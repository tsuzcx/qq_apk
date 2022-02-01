package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.s;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.widget.c;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.report.MMSecDataActivity;

public abstract class FavBaseUI
  extends MMSecDataActivity
  implements AdapterView.OnItemClickListener
{
  protected TextView kGU;
  protected MMHandler knk = new MMHandler(Looper.getMainLooper());
  private final Object lockObj = new Object();
  private boolean wJi = false;
  protected boolean wJj = false;
  private boolean wJk = false;
  private long wJl = 0L;
  protected ListView wJm;
  protected View wJn;
  private View wJo;
  protected c wJp;
  protected View wJq;
  protected o wJr;
  protected c.a wJs = null;
  private i wJt = new i()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
    {
      AppMethodBeat.i(106618);
      Log.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
      if (((al)paramAnonymousq).wHC)
      {
        Log.i("MicroMsg.FavoriteBaseUI", "need batch get return");
        AppMethodBeat.o(106618);
        return;
      }
      Log.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
      if (FavBaseUI.c(FavBaseUI.this)) {
        FavBaseUI.d(FavBaseUI.this);
      }
      FavBaseUI.this.nM(false);
      FavBaseUI.this.dkK();
      AppMethodBeat.o(106618);
    }
  };
  private i wJu = new i()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
    {
      AppMethodBeat.i(106619);
      Log.i("MicroMsg.FavoriteBaseUI", "on batch get end");
      if (FavBaseUI.c(FavBaseUI.this))
      {
        Log.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
        FavBaseUI.d(FavBaseUI.this);
        FavBaseUI.this.nM(false);
      }
      AppMethodBeat.o(106619);
    }
  };
  private Runnable wJv = new com.tencent.e.i.h()
  {
    public final String getKey()
    {
      return "MicroMsg.FavoriteBaseUI#notifyAdapterJob";
    }
    
    public final void run()
    {
      AppMethodBeat.i(106620);
      com.tencent.mm.plugin.fav.ui.a.a locala = FavBaseUI.this.dkF();
      locala.byN();
      locala.dlt();
      FavBaseUI.this.dkK();
      AppMethodBeat.o(106620);
    }
  };
  protected Runnable wJw = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(106621);
      com.tencent.mm.plugin.fav.ui.a.a locala = FavBaseUI.this.dkF();
      if ((!locala.isEmpty()) && (SystemClock.elapsedRealtime() - FavBaseUI.e(FavBaseUI.this) < 400L))
      {
        Log.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.e(FavBaseUI.this)), Integer.valueOf(400) });
        FavBaseUI.this.knk.postDelayed(this, 200L);
        AppMethodBeat.o(106621);
        return;
      }
      FavBaseUI.f(FavBaseUI.this);
      FavBaseUI.a(FavBaseUI.this, SystemClock.elapsedRealtime());
      Log.v("MicroMsg.FavoriteBaseUI", "do refresh job");
      locala.notifyDataSetChanged();
      FavBaseUI.this.a(locala);
      if (FavBaseUI.this.wJj)
      {
        Log.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
        FavBaseUI.this.wJm.setSelection(0);
        FavBaseUI.this.wJj = false;
      }
      AppMethodBeat.o(106621);
    }
  };
  private Runnable wJx = new com.tencent.e.i.h()
  {
    public final String getKey()
    {
      return "MicroMsg.FavoriteBaseUI#dataSetChangedJob";
    }
    
    public final void run()
    {
      AppMethodBeat.i(106612);
      synchronized (FavBaseUI.g(FavBaseUI.this))
      {
        FavBaseUI.this.dkG();
        FavBaseUI.this.dkF().dlt();
        FavBaseUI.this.dkK();
        AppMethodBeat.o(106612);
        return;
      }
    }
  };
  private MStorage.IOnStorageChange wJy = new MStorage.IOnStorageChange()
  {
    long wJA = 0L;
    
    public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
    {
      AppMethodBeat.i(106613);
      Log.i("MicroMsg.FavoriteBaseUI", "[onNotifyChange] event=%s", new Object[] { paramAnonymousString });
      FavBaseUI.this.workerHandler.removeCallbacks(FavBaseUI.h(FavBaseUI.this));
      if (Util.ticksToNow(this.wJA) > 200L)
      {
        this.wJA = Util.currentTicks();
        FavBaseUI.this.workerHandler.post(FavBaseUI.h(FavBaseUI.this));
        AppMethodBeat.o(106613);
        return;
      }
      FavBaseUI.this.workerHandler.postDelayed(FavBaseUI.h(FavBaseUI.this), 200L);
      AppMethodBeat.o(106613);
    }
  };
  protected MMHandler workerHandler;
  
  private void nN(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.kGU == null) {
        this.kGU = ((TextView)((ViewStub)findViewById(s.e.empty_view_stub)).inflate().findViewById(s.e.empty_fav_view));
      }
      this.kGU.setVisibility(0);
    }
    while (this.kGU == null) {
      return;
    }
    this.kGU.setVisibility(8);
  }
  
  protected final void a(com.tencent.mm.plugin.fav.ui.a.a parama)
  {
    if (parama == null) {
      Log.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
    }
    do
    {
      return;
      if (parama.isEmpty()) {
        if (dkH())
        {
          nM(true);
          nN(false);
        }
      }
      while ((parama.isEmpty()) || (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().B(parama.dlr(), parama.getType())))
      {
        this.wJm.removeFooterView(this.wJn);
        return;
        nM(false);
        nN(true);
        dkI();
        continue;
        nM(false);
        nN(false);
      }
    } while (this.wJm.getFooterViewsCount() != 0);
    this.wJm.addFooterView(this.wJn);
  }
  
  public abstract com.tencent.mm.plugin.fav.ui.a.a dkF();
  
  protected abstract void dkG();
  
  protected abstract boolean dkH();
  
  protected abstract void dkI();
  
  protected abstract View.OnClickListener dkJ();
  
  protected void dkK()
  {
    Log.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
    this.knk.removeCallbacks(this.wJw);
    this.knk.post(this.wJw);
  }
  
  public int getLayoutId()
  {
    return s.f.favorite_base_ui;
  }
  
  protected void initHeaderView()
  {
    this.wJp = new c(getContext());
    this.wJp.setCleanFavSpace(this.wJs);
    this.wJp.nX(false);
    this.wJp.wSZ.setVisibility(8);
    this.wJp.wTa.setVisibility(8);
    Log.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", new Object[] { Integer.valueOf(this.wJp.getPaddingTop()), Integer.valueOf(this.wJp.getPaddingBottom()) });
    this.wJm.addHeaderView(this.wJp);
    this.wJq = View.inflate(getContext(), s.f.fav_type_header, null);
    TextView localTextView1 = (TextView)this.wJq.findViewById(s.e.fav_sub_url_tv);
    final TextView localTextView2 = (TextView)this.wJq.findViewById(s.e.fav_sub_image_tv);
    TextView localTextView3 = (TextView)this.wJq.findViewById(s.e.fav_sub_voice_tv);
    TextView localTextView4 = (TextView)this.wJq.findViewById(s.e.fav_sub_music_tv);
    TextView localTextView5 = (TextView)this.wJq.findViewById(s.e.fav_sub_location_tv);
    TextView localTextView6 = (TextView)this.wJq.findViewById(s.e.fav_sub_file_tv);
    final TextView localTextView7 = (TextView)this.wJq.findViewById(s.e.fav_sub_record_tv);
    TextView localTextView8 = (TextView)this.wJq.findViewById(s.e.fav_sub_note_tv);
    View.OnClickListener localOnClickListener = dkJ();
    localTextView1.setOnClickListener(localOnClickListener);
    localTextView1.setTag(Integer.valueOf(5));
    localTextView2.setOnClickListener(localOnClickListener);
    localTextView2.setTag(Integer.valueOf(21));
    localTextView3.setOnClickListener(localOnClickListener);
    localTextView3.setTag(Integer.valueOf(3));
    localTextView4.setOnClickListener(localOnClickListener);
    localTextView4.setTag(Integer.valueOf(7));
    localTextView5.setOnClickListener(localOnClickListener);
    localTextView5.setTag(Integer.valueOf(6));
    localTextView6.setOnClickListener(localOnClickListener);
    localTextView6.setTag(Integer.valueOf(8));
    localTextView7.setOnClickListener(localOnClickListener);
    localTextView7.setTag(Integer.valueOf(17));
    localTextView8.setOnClickListener(localOnClickListener);
    localTextView8.setTag(Integer.valueOf(18));
    this.wJq.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(106617);
        FavBaseUI.this.wJq.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = FavBaseUI.this.wJq.findViewById(s.e.fav_type_wrapper_layout1).getWidth() / 4;
        if ((i > 0) && (localTextView2.getWidth() < i))
        {
          localTextView2.setWidth(i);
          localTextView7.setWidth(i);
        }
        AppMethodBeat.o(106617);
      }
    });
    this.wJm.addHeaderView(this.wJq);
  }
  
  public void initView()
  {
    long l = System.currentTimeMillis();
    this.wJm = ((ListView)findViewById(s.e.favorite_lv));
    this.wJm.setDrawingCacheEnabled(false);
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106614);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/FavBaseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        paramAnonymousView = FavBaseUI.this.wJm;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/fav/ui/FavBaseUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/fav/ui/FavBaseUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/FavBaseUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(106614);
      }
    });
    initHeaderView();
    this.wJn = com.tencent.mm.ui.ad.kS(this).inflate(s.f.fav_loading_footer, null);
    this.wJm.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(106615);
        if (paramAnonymousInt == 0)
        {
          if (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().B(FavBaseUI.this.dkF().dlr(), FavBaseUI.this.dkF().getType()))
          {
            Log.v("MicroMsg.FavoriteBaseUI", "has shown all, do not load data");
            AppMethodBeat.o(106615);
            return;
          }
          if (FavBaseUI.a(FavBaseUI.this))
          {
            Log.i("MicroMsg.FavoriteBaseUI", "force bottom load data");
            FavBaseUI.b(FavBaseUI.this);
          }
        }
        AppMethodBeat.o(106615);
      }
    });
    this.wJm.setOnItemClickListener(this);
    this.wJm.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106616);
        FavBaseUI.this.hideVKB();
        AppMethodBeat.o(106616);
        return false;
      }
    });
    this.wJm.setAdapter(dkF());
    a(dkF());
    Log.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  protected final void nM(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.wJo == null)
      {
        localViewStub = (ViewStub)findViewById(s.e.empty_load_view_stub);
        if (localViewStub != null) {
          this.wJo = localViewStub.inflate();
        }
      }
      this.wJo.setVisibility(0);
    }
    while (this.wJo == null)
    {
      ViewStub localViewStub;
      return;
    }
    this.wJo.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    Log.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.h.aHB()) });
    paramBundle = new am();
    com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().add(this.wJy);
    com.tencent.mm.kernel.h.aGY().a(400, this.wJt);
    com.tencent.mm.kernel.h.aGY().a(402, this.wJu);
    this.workerHandler = new MMHandler(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.wJr = new o(getContext(), 64);
    initView();
    setActionbarColor(getContext().getResources().getColor(s.b.normal_actionbar_color));
    if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(8217, null)) == 0)
    {
      Log.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
      this.wJk = true;
      paramBundle = new al();
      com.tencent.mm.kernel.h.aGY().a(paramBundle, 0);
      if (this.wJk)
      {
        Log.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
        if ((dkF() == null) || (dkF().isEmpty())) {
          nM(true);
        }
        nN(false);
      }
    }
    for (;;)
    {
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnService().run();
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getCheckCdnService().run();
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getSendService().run();
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getModService().run();
      com.tencent.mm.kernel.h.aHJ().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106611);
          com.tencent.mm.plugin.fav.a.b.djm();
          AppMethodBeat.o(106611);
        }
      });
      Log.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      com.tencent.mm.plugin.fav.a.b.startSync();
      if (dkF().isEmpty())
      {
        nM(true);
        nN(false);
        this.wJn.setVisibility(8);
      }
      else
      {
        nM(false);
        nN(false);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("MicroMsg.FavoriteBaseUI", "[onDestroy]");
    if (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().djV() == null)
    {
      Log.e("MicroMsg.FavoriteBaseUI", "[onDestroy] return getBaseDB is null");
      return;
    }
    this.wJr.destory();
    this.wJr = null;
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().remove(this.wJy);
    com.tencent.mm.kernel.h.aGY().b(400, this.wJt);
    com.tencent.mm.kernel.h.aGY().b(402, this.wJu);
    this.workerHandler.quit();
  }
  
  public void onPause()
  {
    super.onPause();
    dkF().onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    dkF().onResume();
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(5);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI
 * JD-Core Version:    0.7.0.1
 */