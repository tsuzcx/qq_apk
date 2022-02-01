package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.widget.c;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;

public abstract class FavBaseUI
  extends MMActivity
  implements AdapterView.OnItemClickListener
{
  protected ap gAC = new ap(Looper.getMainLooper());
  private final Object lockObj = new Object();
  protected ap pXi;
  private boolean qcA = false;
  private long qcB = 0L;
  protected ListView qcC;
  protected TextView qcD;
  protected View qcE;
  private View qcF;
  protected c qcG;
  protected View qcH;
  protected o qcI;
  protected c.a qcJ = null;
  private com.tencent.mm.al.g qcK = new com.tencent.mm.al.g()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
    {
      AppMethodBeat.i(106618);
      ad.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
      if (((ak)paramAnonymousn).qaY)
      {
        ad.i("MicroMsg.FavoriteBaseUI", "need batch get return");
        AppMethodBeat.o(106618);
        return;
      }
      ad.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
      if (FavBaseUI.c(FavBaseUI.this)) {
        FavBaseUI.d(FavBaseUI.this);
      }
      FavBaseUI.this.kA(false);
      FavBaseUI.this.ciN();
      AppMethodBeat.o(106618);
    }
  };
  private com.tencent.mm.al.g qcL = new com.tencent.mm.al.g()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
    {
      AppMethodBeat.i(106619);
      ad.i("MicroMsg.FavoriteBaseUI", "on batch get end");
      if (FavBaseUI.c(FavBaseUI.this))
      {
        ad.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
        FavBaseUI.d(FavBaseUI.this);
        FavBaseUI.this.kA(false);
      }
      AppMethodBeat.o(106619);
    }
  };
  private Runnable qcM = new com.tencent.e.i.h()
  {
    public final String getKey()
    {
      return "MicroMsg.FavoriteBaseUI#notifyAdapterJob";
    }
    
    public final void run()
    {
      AppMethodBeat.i(106620);
      com.tencent.mm.plugin.fav.ui.a.a locala = FavBaseUI.this.ciI();
      locala.aJq();
      locala.cjq();
      FavBaseUI.this.ciN();
      AppMethodBeat.o(106620);
    }
  };
  protected Runnable qcN = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(106621);
      com.tencent.mm.plugin.fav.ui.a.a locala = FavBaseUI.this.ciI();
      if ((!locala.isEmpty()) && (SystemClock.elapsedRealtime() - FavBaseUI.e(FavBaseUI.this) < 400L))
      {
        ad.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.e(FavBaseUI.this)), Integer.valueOf(400) });
        FavBaseUI.this.gAC.postDelayed(this, 200L);
        AppMethodBeat.o(106621);
        return;
      }
      FavBaseUI.f(FavBaseUI.this);
      FavBaseUI.a(FavBaseUI.this, SystemClock.elapsedRealtime());
      ad.v("MicroMsg.FavoriteBaseUI", "do refresh job");
      locala.notifyDataSetChanged();
      FavBaseUI.this.a(locala);
      if (FavBaseUI.this.qcz)
      {
        ad.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
        FavBaseUI.this.qcC.setSelection(0);
        FavBaseUI.this.qcz = false;
      }
      AppMethodBeat.o(106621);
    }
  };
  private Runnable qcO = new com.tencent.e.i.h()
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
        FavBaseUI.this.ciJ();
        FavBaseUI.this.ciI().cjq();
        FavBaseUI.this.ciN();
        AppMethodBeat.o(106612);
        return;
      }
    }
  };
  private k.a qcP = new k.a()
  {
    long qcR = 0L;
    
    public final void a(String paramAnonymousString, m paramAnonymousm)
    {
      AppMethodBeat.i(106613);
      ad.i("MicroMsg.FavoriteBaseUI", "[onNotifyChange] event=%s", new Object[] { paramAnonymousString });
      FavBaseUI.this.pXi.removeCallbacks(FavBaseUI.h(FavBaseUI.this));
      if (bt.aS(this.qcR) > 200L)
      {
        this.qcR = bt.GC();
        FavBaseUI.this.pXi.post(FavBaseUI.h(FavBaseUI.this));
        AppMethodBeat.o(106613);
        return;
      }
      FavBaseUI.this.pXi.postDelayed(FavBaseUI.h(FavBaseUI.this), 200L);
      AppMethodBeat.o(106613);
    }
  };
  private boolean qcy = false;
  protected boolean qcz = false;
  
  private void kB(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.qcD == null) {
        this.qcD = ((TextView)((ViewStub)findViewById(2131299479)).inflate().findViewById(2131299464));
      }
      this.qcD.setVisibility(0);
    }
    while (this.qcD == null) {
      return;
    }
    this.qcD.setVisibility(8);
  }
  
  protected final void a(com.tencent.mm.plugin.fav.ui.a.a parama)
  {
    if (parama == null) {
      ad.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
    }
    do
    {
      return;
      if (parama.isEmpty()) {
        if (ciK())
        {
          kA(true);
          kB(false);
        }
      }
      while ((parama.isEmpty()) || (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().z(parama.cjo(), parama.getType())))
      {
        this.qcC.removeFooterView(this.qcE);
        return;
        kA(false);
        kB(true);
        ciL();
        continue;
        kA(false);
        kB(false);
      }
    } while (this.qcC.getFooterViewsCount() != 0);
    this.qcC.addFooterView(this.qcE);
  }
  
  public abstract com.tencent.mm.plugin.fav.ui.a.a ciI();
  
  protected abstract void ciJ();
  
  protected abstract boolean ciK();
  
  protected abstract void ciL();
  
  protected abstract View.OnClickListener ciM();
  
  protected void ciN()
  {
    ad.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
    this.gAC.removeCallbacks(this.qcN);
    this.gAC.post(this.qcN);
  }
  
  public int getLayoutId()
  {
    return 2131493986;
  }
  
  protected void initHeaderView()
  {
    this.qcG = new c(getContext());
    this.qcG.setCleanFavSpace(this.qcJ);
    this.qcG.kK(false);
    this.qcG.qlO.setVisibility(8);
    this.qcG.qlP.setVisibility(8);
    ad.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", new Object[] { Integer.valueOf(this.qcG.getPaddingTop()), Integer.valueOf(this.qcG.getPaddingBottom()) });
    this.qcC.addHeaderView(this.qcG);
    this.qcH = View.inflate(getContext(), 2131493983, null);
    TextView localTextView1 = (TextView)this.qcH.findViewById(2131299838);
    final TextView localTextView2 = (TextView)this.qcH.findViewById(2131299833);
    TextView localTextView3 = (TextView)this.qcH.findViewById(2131299839);
    TextView localTextView4 = (TextView)this.qcH.findViewById(2131299835);
    TextView localTextView5 = (TextView)this.qcH.findViewById(2131299834);
    TextView localTextView6 = (TextView)this.qcH.findViewById(2131299832);
    final TextView localTextView7 = (TextView)this.qcH.findViewById(2131299837);
    TextView localTextView8 = (TextView)this.qcH.findViewById(2131299836);
    View.OnClickListener localOnClickListener = ciM();
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
    this.qcH.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(106617);
        FavBaseUI.this.qcH.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = FavBaseUI.this.qcH.findViewById(2131299854).getWidth() / 4;
        if ((i > 0) && (localTextView2.getWidth() < i))
        {
          localTextView2.setWidth(i);
          localTextView7.setWidth(i);
        }
        AppMethodBeat.o(106617);
      }
    });
    this.qcC.addHeaderView(this.qcH);
  }
  
  public void initView()
  {
    long l = System.currentTimeMillis();
    this.qcC = ((ListView)findViewById(2131299867));
    this.qcC.setDrawingCacheEnabled(false);
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(106614);
        paramAnonymousView = FavBaseUI.this.qcC;
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/fav/ui/FavBaseUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/fav/ui/FavBaseUI$2", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        AppMethodBeat.o(106614);
      }
    });
    initHeaderView();
    this.qcE = y.js(this).inflate(2131493968, null);
    this.qcC.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(106615);
        if (paramAnonymousInt == 0)
        {
          if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().z(FavBaseUI.this.ciI().cjo(), FavBaseUI.this.ciI().getType()))
          {
            ad.v("MicroMsg.FavoriteBaseUI", "has shown all, do not load data");
            AppMethodBeat.o(106615);
            return;
          }
          if (FavBaseUI.a(FavBaseUI.this))
          {
            ad.i("MicroMsg.FavoriteBaseUI", "force bottom load data");
            FavBaseUI.b(FavBaseUI.this);
          }
        }
        AppMethodBeat.o(106615);
      }
    });
    this.qcC.setOnItemClickListener(this);
    this.qcC.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(106616);
        FavBaseUI.this.hideVKB();
        AppMethodBeat.o(106616);
        return false;
      }
    });
    this.qcC.setAdapter(ciI());
    a(ciI());
    ad.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  protected final void kA(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.qcF == null)
      {
        localViewStub = (ViewStub)findViewById(2131299466);
        if (localViewStub != null) {
          this.qcF = localViewStub.inflate();
        }
      }
      this.qcF.setVisibility(0);
    }
    while (this.qcF == null)
    {
      ViewStub localViewStub;
      return;
    }
    this.qcF.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    ad.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.afw()) });
    paramBundle = new al();
    com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().add(this.qcP);
    com.tencent.mm.kernel.g.aeS().a(400, this.qcK);
    com.tencent.mm.kernel.g.aeS().a(402, this.qcL);
    this.pXi = new ap(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.qcI = new o(getContext(), 64);
    initView();
    setActionbarColor(getContext().getResources().getColor(2131100705));
    if (bt.l((Integer)com.tencent.mm.kernel.g.afB().afk().get(8217, null)) == 0)
    {
      ad.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
      this.qcA = true;
      paramBundle = new ak();
      com.tencent.mm.kernel.g.aeS().a(paramBundle, 0);
      if (this.qcA)
      {
        ad.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
        if ((ciI() == null) || (ciI().isEmpty())) {
          kA(true);
        }
        kB(false);
      }
    }
    for (;;)
    {
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getCheckCdnService().run();
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
      com.tencent.mm.kernel.g.afE().ax(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106611);
          b.chq();
          AppMethodBeat.o(106611);
        }
      });
      ad.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      b.startSync();
      if (ciI().isEmpty())
      {
        kA(true);
        kB(false);
        this.qcE.setVisibility(8);
      }
      else
      {
        kA(false);
        kB(false);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ad.i("MicroMsg.FavoriteBaseUI", "[onDestroy]");
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().chY() == null)
    {
      ad.e("MicroMsg.FavoriteBaseUI", "[onDestroy] return getBaseDB is null");
      return;
    }
    this.qcI.destory();
    this.qcI = null;
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().remove(this.qcP);
    com.tencent.mm.kernel.g.aeS().b(400, this.qcK);
    com.tencent.mm.kernel.g.aeS().b(402, this.qcL);
    this.pXi.quit();
  }
  
  public void onPause()
  {
    super.onPause();
    ciI();
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.pluginsdk.wallet.h.Vs(5);
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