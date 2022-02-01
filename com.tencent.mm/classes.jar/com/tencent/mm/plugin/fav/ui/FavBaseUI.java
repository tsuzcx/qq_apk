package com.tencent.mm.plugin.fav.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.fav.a.aa;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.adapter.a;
import com.tencent.mm.plugin.fav.ui.widget.c;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.af;

public abstract class FavBaseUI
  extends MMSecDataActivity
  implements AdapterView.OnItemClickListener
{
  private boolean AfD = false;
  protected boolean AfE = false;
  private boolean AfF = false;
  private long AfG = 0L;
  protected ListView AfH;
  protected View AfI;
  private View AfJ;
  protected c AfK;
  protected View AfL;
  protected FavoriteImageServer AfM;
  protected c.a AfN = null;
  private com.tencent.mm.am.h AfO = new com.tencent.mm.am.h()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
    {
      AppMethodBeat.i(106618);
      Log.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
      if (((am)paramAnonymousp).AdQ)
      {
        Log.i("MicroMsg.FavoriteBaseUI", "need batch get return");
        AppMethodBeat.o(106618);
        return;
      }
      Log.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
      if (FavBaseUI.c(FavBaseUI.this)) {
        FavBaseUI.d(FavBaseUI.this);
      }
      FavBaseUI.this.pm(false);
      FavBaseUI.this.dRA();
      AppMethodBeat.o(106618);
    }
  };
  private com.tencent.mm.am.h AfP = new com.tencent.mm.am.h()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.p paramAnonymousp)
    {
      AppMethodBeat.i(106619);
      Log.i("MicroMsg.FavoriteBaseUI", "on batch get end");
      if (FavBaseUI.c(FavBaseUI.this))
      {
        Log.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
        FavBaseUI.d(FavBaseUI.this);
        FavBaseUI.this.pm(false);
      }
      AppMethodBeat.o(106619);
    }
  };
  private Runnable AfQ = new com.tencent.threadpool.i.h()
  {
    public final String getKey()
    {
      return "MicroMsg.FavoriteBaseUI#notifyAdapterJob";
    }
    
    public final void run()
    {
      AppMethodBeat.i(106620);
      a locala = FavBaseUI.this.dRv();
      locala.bXB();
      locala.dSj();
      FavBaseUI.this.dRA();
      AppMethodBeat.o(106620);
    }
  };
  protected Runnable AfR = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(106621);
      a locala = FavBaseUI.this.dRv();
      if ((!locala.isEmpty()) && (SystemClock.elapsedRealtime() - FavBaseUI.e(FavBaseUI.this) < 400L))
      {
        Log.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.e(FavBaseUI.this)), Integer.valueOf(400) });
        FavBaseUI.this.mRi.postDelayed(this, 200L);
        AppMethodBeat.o(106621);
        return;
      }
      FavBaseUI.f(FavBaseUI.this);
      FavBaseUI.a(FavBaseUI.this, SystemClock.elapsedRealtime());
      Log.v("MicroMsg.FavoriteBaseUI", "do refresh job");
      locala.notifyDataSetChanged();
      FavBaseUI.this.a(locala);
      if (FavBaseUI.this.AfE)
      {
        Log.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
        FavBaseUI.this.AfH.setSelection(0);
        FavBaseUI.this.AfE = false;
      }
      AppMethodBeat.o(106621);
    }
  };
  private Runnable AfS = new com.tencent.threadpool.i.h()
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
        FavBaseUI.this.dRw();
        FavBaseUI.this.dRv().dSj();
        FavBaseUI.this.dRA();
        AppMethodBeat.o(106612);
        return;
      }
    }
  };
  private MStorage.IOnStorageChange AfT = new FavBaseUI.3(this);
  private final Object lockObj = new Object();
  protected MMHandler mRi = new MMHandler(Looper.getMainLooper());
  protected TextView njO;
  protected MMHandler workerHandler;
  
  private void pn(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.njO == null) {
        this.njO = ((TextView)((ViewStub)findViewById(q.e.empty_view_stub)).inflate().findViewById(q.e.empty_fav_view));
      }
      this.njO.setVisibility(0);
    }
    while (this.njO == null) {
      return;
    }
    this.njO.setVisibility(8);
  }
  
  protected final void a(a parama)
  {
    if (parama == null) {
      Log.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
    }
    do
    {
      return;
      if (parama.isEmpty()) {
        if (dRx())
        {
          pm(true);
          pn(false);
        }
      }
      while ((parama.isEmpty()) || (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().L(parama.dSh(), parama.getType())))
      {
        this.AfH.removeFooterView(this.AfI);
        return;
        pm(false);
        pn(true);
        dRy();
        continue;
        pm(false);
        pn(false);
      }
    } while (this.AfH.getFooterViewsCount() != 0);
    this.AfH.addFooterView(this.AfI);
  }
  
  protected void dRA()
  {
    Log.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
    this.mRi.removeCallbacks(this.AfR);
    this.mRi.post(this.AfR);
  }
  
  public abstract a dRv();
  
  protected abstract void dRw();
  
  protected abstract boolean dRx();
  
  protected abstract void dRy();
  
  protected abstract View.OnClickListener dRz();
  
  public int getLayoutId()
  {
    return q.f.favorite_base_ui;
  }
  
  protected void initHeaderView()
  {
    this.AfK = new c(getContext());
    this.AfK.setCleanFavSpace(this.AfN);
    this.AfK.px(false);
    this.AfK.ApC.setVisibility(8);
    this.AfK.ApD.setVisibility(8);
    Log.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", new Object[] { Integer.valueOf(this.AfK.getPaddingTop()), Integer.valueOf(this.AfK.getPaddingBottom()) });
    this.AfH.addHeaderView(this.AfK);
    this.AfL = View.inflate(getContext(), q.f.fav_type_header, null);
    TextView localTextView1 = (TextView)this.AfL.findViewById(q.e.fav_sub_url_tv);
    final TextView localTextView2 = (TextView)this.AfL.findViewById(q.e.fav_sub_recently_used_tv);
    final TextView localTextView3 = (TextView)this.AfL.findViewById(q.e.fav_sub_image_tv);
    TextView localTextView4 = (TextView)this.AfL.findViewById(q.e.fav_sub_voice_tv);
    TextView localTextView5 = (TextView)this.AfL.findViewById(q.e.fav_sub_music_tv);
    TextView localTextView6 = (TextView)this.AfL.findViewById(q.e.fav_sub_location_tv);
    TextView localTextView7 = (TextView)this.AfL.findViewById(q.e.fav_sub_file_tv);
    final TextView localTextView8 = (TextView)this.AfL.findViewById(q.e.fav_sub_record_tv);
    TextView localTextView9 = (TextView)this.AfL.findViewById(q.e.fav_sub_note_tv);
    View.OnClickListener localOnClickListener = dRz();
    localTextView1.setOnClickListener(localOnClickListener);
    localTextView1.setTag(Integer.valueOf(5));
    localTextView3.setOnClickListener(localOnClickListener);
    localTextView3.setTag(Integer.valueOf(21));
    localTextView4.setOnClickListener(localOnClickListener);
    localTextView4.setTag(Integer.valueOf(3));
    localTextView5.setOnClickListener(localOnClickListener);
    localTextView5.setTag(Integer.valueOf(7));
    localTextView6.setOnClickListener(localOnClickListener);
    localTextView6.setTag(Integer.valueOf(6));
    localTextView7.setOnClickListener(localOnClickListener);
    localTextView7.setTag(Integer.valueOf(8));
    localTextView8.setOnClickListener(localOnClickListener);
    localTextView8.setTag(Integer.valueOf(17));
    localTextView9.setOnClickListener(localOnClickListener);
    localTextView9.setTag(Integer.valueOf(18));
    localTextView2.setOnClickListener(localOnClickListener);
    localTextView2.setTag(Integer.valueOf(22));
    this.AfL.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(106617);
        FavBaseUI.this.AfL.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = FavBaseUI.this.AfL.findViewById(q.e.fav_type_wrapper_layout1).getWidth() / 3;
        if ((i > 0) && (localTextView3.getWidth() < i))
        {
          localTextView2.setWidth(i);
          localTextView3.setWidth(i);
          localTextView8.setWidth(i);
        }
        AppMethodBeat.o(106617);
      }
    });
    this.AfH.addHeaderView(this.AfL);
  }
  
  public void initView()
  {
    long l = System.currentTimeMillis();
    this.AfH = ((ListView)findViewById(q.e.favorite_lv));
    this.AfH.setDrawingCacheEnabled(false);
    setToTop(new FavBaseUI.4(this));
    initHeaderView();
    this.AfI = af.mU(this).inflate(q.f.fav_loading_footer, null);
    this.AfH.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(106615);
        if (paramAnonymousInt == 0)
        {
          if (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().L(FavBaseUI.this.dRv().dSh(), FavBaseUI.this.dRv().getType()))
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
    this.AfH.setOnItemClickListener(this);
    this.AfH.setOnTouchListener(new FavBaseUI.6(this));
    this.AfH.setAdapter(dRv());
    a(dRv());
    Log.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    Log.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.h.baz()) });
    paramBundle = new an();
    com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().add(this.AfT);
    com.tencent.mm.kernel.h.aZW().a(400, this.AfO);
    com.tencent.mm.kernel.h.aZW().a(402, this.AfP);
    this.workerHandler = new MMHandler(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.AfM = new FavoriteImageServer(getContext(), 64);
    initView();
    setActionbarColor(getContext().getResources().getColor(q.b.normal_actionbar_color));
    if (Util.nullAsNil((Integer)com.tencent.mm.kernel.h.baE().ban().d(8217, null)) == 0)
    {
      Log.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
      this.AfF = true;
      paramBundle = new am();
      com.tencent.mm.kernel.h.aZW().a(paramBundle, 0);
      if (this.AfF)
      {
        Log.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
        if ((dRv() == null) || (dRv().isEmpty())) {
          pm(true);
        }
        pn(false);
      }
    }
    for (;;)
    {
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnService().run();
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getCheckCdnService().run();
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getSendService().run();
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getModService().run();
      com.tencent.mm.kernel.h.baH().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106611);
          b.dPX();
          AppMethodBeat.o(106611);
        }
      });
      Log.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      b.startSync();
      if (dRv().isEmpty())
      {
        pm(true);
        pn(false);
        this.AfI.setVisibility(8);
      }
      else
      {
        pm(false);
        pn(false);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("MicroMsg.FavoriteBaseUI", "[onDestroy]");
    if (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().dQF() == null)
    {
      Log.e("MicroMsg.FavoriteBaseUI", "[onDestroy] return getBaseDB is null");
      return;
    }
    this.AfM.destory();
    this.AfM = null;
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().remove(this.AfT);
    com.tencent.mm.kernel.h.aZW().b(400, this.AfO);
    com.tencent.mm.kernel.h.aZW().b(402, this.AfP);
    this.workerHandler.quit();
  }
  
  public void onPause()
  {
    super.onPause();
    dRv().onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    dRv().onResume();
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(5);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void pm(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.AfJ == null)
      {
        localViewStub = (ViewStub)findViewById(q.e.empty_load_view_stub);
        if (localViewStub != null) {
          this.AfJ = localViewStub.inflate();
        }
      }
      this.AfJ.setVisibility(0);
    }
    while (this.AfJ == null)
    {
      ViewStub localViewStub;
      return;
    }
    this.AfJ.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI
 * JD-Core Version:    0.7.0.1
 */