package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.a.a;
import com.tencent.mm.plugin.fav.ui.widget.c;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMActivity;

public abstract class FavBaseUI
  extends MMActivity
  implements AdapterView.OnItemClickListener
{
  protected ap gIf = new ap(Looper.getMainLooper());
  protected TextView gWP;
  private final Object lockObj = new Object();
  protected ap rpF;
  private boolean rvg = false;
  protected boolean rvh = false;
  private boolean rvi = false;
  private long rvj = 0L;
  protected ListView rvk;
  protected View rvl;
  private View rvm;
  protected c rvn;
  protected View rvo;
  protected o rvp;
  protected c.a rvq = null;
  private f rvr = new f()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
    {
      AppMethodBeat.i(106618);
      ad.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
      if (((ak)paramAnonymousn).rtG)
      {
        ad.i("MicroMsg.FavoriteBaseUI", "need batch get return");
        AppMethodBeat.o(106618);
        return;
      }
      ad.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
      if (FavBaseUI.c(FavBaseUI.this)) {
        FavBaseUI.d(FavBaseUI.this);
      }
      FavBaseUI.this.lx(false);
      FavBaseUI.this.cvZ();
      AppMethodBeat.o(106618);
    }
  };
  private f rvs = new f()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
    {
      AppMethodBeat.i(106619);
      ad.i("MicroMsg.FavoriteBaseUI", "on batch get end");
      if (FavBaseUI.c(FavBaseUI.this))
      {
        ad.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
        FavBaseUI.d(FavBaseUI.this);
        FavBaseUI.this.lx(false);
      }
      AppMethodBeat.o(106619);
    }
  };
  private Runnable rvt = new com.tencent.e.i.h()
  {
    public final String getKey()
    {
      return "MicroMsg.FavoriteBaseUI#notifyAdapterJob";
    }
    
    public final void run()
    {
      AppMethodBeat.i(106620);
      a locala = FavBaseUI.this.cvU();
      locala.aTt();
      locala.cwH();
      FavBaseUI.this.cvZ();
      AppMethodBeat.o(106620);
    }
  };
  protected Runnable rvu = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(106621);
      a locala = FavBaseUI.this.cvU();
      if ((!locala.isEmpty()) && (SystemClock.elapsedRealtime() - FavBaseUI.e(FavBaseUI.this) < 400L))
      {
        ad.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.e(FavBaseUI.this)), Integer.valueOf(400) });
        FavBaseUI.this.gIf.postDelayed(this, 200L);
        AppMethodBeat.o(106621);
        return;
      }
      FavBaseUI.f(FavBaseUI.this);
      FavBaseUI.a(FavBaseUI.this, SystemClock.elapsedRealtime());
      ad.v("MicroMsg.FavoriteBaseUI", "do refresh job");
      locala.notifyDataSetChanged();
      FavBaseUI.this.a(locala);
      if (FavBaseUI.this.rvh)
      {
        ad.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
        FavBaseUI.this.rvk.setSelection(0);
        FavBaseUI.this.rvh = false;
      }
      AppMethodBeat.o(106621);
    }
  };
  private Runnable rvv = new com.tencent.e.i.h()
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
        FavBaseUI.this.cvV();
        FavBaseUI.this.cvU().cwH();
        FavBaseUI.this.cvZ();
        AppMethodBeat.o(106612);
        return;
      }
    }
  };
  private k.a rvw = new FavBaseUI.3(this);
  
  private void ly(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.gWP == null) {
        this.gWP = ((TextView)((ViewStub)findViewById(2131299479)).inflate().findViewById(2131299464));
      }
      this.gWP.setVisibility(0);
    }
    while (this.gWP == null) {
      return;
    }
    this.gWP.setVisibility(8);
  }
  
  protected final void a(a parama)
  {
    if (parama == null) {
      ad.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
    }
    do
    {
      return;
      if (parama.isEmpty()) {
        if (cvW())
        {
          lx(true);
          ly(false);
        }
      }
      while ((parama.isEmpty()) || (((af)g.ad(af.class)).getFavItemInfoStorage().B(parama.cwF(), parama.getType())))
      {
        this.rvk.removeFooterView(this.rvl);
        return;
        lx(false);
        ly(true);
        cvX();
        continue;
        lx(false);
        ly(false);
      }
    } while (this.rvk.getFooterViewsCount() != 0);
    this.rvk.addFooterView(this.rvl);
  }
  
  public abstract a cvU();
  
  protected abstract void cvV();
  
  protected abstract boolean cvW();
  
  protected abstract void cvX();
  
  protected abstract View.OnClickListener cvY();
  
  protected void cvZ()
  {
    ad.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
    this.gIf.removeCallbacks(this.rvu);
    this.gIf.post(this.rvu);
  }
  
  public int getLayoutId()
  {
    return 2131493986;
  }
  
  protected void initHeaderView()
  {
    this.rvn = new c(getContext());
    this.rvn.setCleanFavSpace(this.rvq);
    this.rvn.lH(false);
    this.rvn.rEE.setVisibility(8);
    this.rvn.rEF.setVisibility(8);
    ad.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", new Object[] { Integer.valueOf(this.rvn.getPaddingTop()), Integer.valueOf(this.rvn.getPaddingBottom()) });
    this.rvk.addHeaderView(this.rvn);
    this.rvo = View.inflate(getContext(), 2131493983, null);
    TextView localTextView1 = (TextView)this.rvo.findViewById(2131299838);
    final TextView localTextView2 = (TextView)this.rvo.findViewById(2131299833);
    TextView localTextView3 = (TextView)this.rvo.findViewById(2131299839);
    TextView localTextView4 = (TextView)this.rvo.findViewById(2131299835);
    TextView localTextView5 = (TextView)this.rvo.findViewById(2131299834);
    TextView localTextView6 = (TextView)this.rvo.findViewById(2131299832);
    final TextView localTextView7 = (TextView)this.rvo.findViewById(2131299837);
    TextView localTextView8 = (TextView)this.rvo.findViewById(2131299836);
    View.OnClickListener localOnClickListener = cvY();
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
    this.rvo.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(106617);
        FavBaseUI.this.rvo.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = FavBaseUI.this.rvo.findViewById(2131299854).getWidth() / 4;
        if ((i > 0) && (localTextView2.getWidth() < i))
        {
          localTextView2.setWidth(i);
          localTextView7.setWidth(i);
        }
        AppMethodBeat.o(106617);
      }
    });
    this.rvk.addHeaderView(this.rvo);
  }
  
  public void initView()
  {
    long l = System.currentTimeMillis();
    this.rvk = ((ListView)findViewById(2131299867));
    this.rvk.setDrawingCacheEnabled(false);
    setToTop(new FavBaseUI.4(this));
    initHeaderView();
    this.rvl = com.tencent.mm.ui.z.jO(this).inflate(2131493968, null);
    this.rvk.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(106615);
        if (paramAnonymousInt == 0)
        {
          if (((af)g.ad(af.class)).getFavItemInfoStorage().B(FavBaseUI.this.cvU().cwF(), FavBaseUI.this.cvU().getType()))
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
    this.rvk.setOnItemClickListener(this);
    this.rvk.setOnTouchListener(new FavBaseUI.6(this));
    this.rvk.setAdapter(cvU());
    a(cvU());
    ad.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  protected final void lx(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.rvm == null)
      {
        localViewStub = (ViewStub)findViewById(2131299466);
        if (localViewStub != null) {
          this.rvm = localViewStub.inflate();
        }
      }
      this.rvm.setVisibility(0);
    }
    while (this.rvm == null)
    {
      ViewStub localViewStub;
      return;
    }
    this.rvm.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    ad.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(g.ajx()) });
    paramBundle = new al();
    g.aiU().a(paramBundle, 0);
    ((af)g.ad(af.class)).getFavItemInfoStorage().add(this.rvw);
    g.aiU().a(400, this.rvr);
    g.aiU().a(402, this.rvs);
    this.rpF = new ap(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.rvp = new o(getContext(), 64);
    initView();
    setActionbarColor(getContext().getResources().getColor(2131100705));
    if (bt.n((Integer)g.ajC().ajl().get(8217, null)) == 0)
    {
      ad.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
      this.rvi = true;
      paramBundle = new ak();
      g.aiU().a(paramBundle, 0);
      if (this.rvi)
      {
        ad.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
        if ((cvU() == null) || (cvU().isEmpty())) {
          lx(true);
        }
        ly(false);
      }
    }
    for (;;)
    {
      ((af)g.ad(af.class)).getFavCdnService().run();
      ((af)g.ad(af.class)).getCheckCdnService().run();
      ((af)g.ad(af.class)).getSendService().run();
      ((af)g.ad(af.class)).getModService().run();
      g.ajF().ay(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106611);
          b.cuC();
          AppMethodBeat.o(106611);
        }
      });
      ad.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      b.startSync();
      if (cvU().isEmpty())
      {
        lx(true);
        ly(false);
        this.rvl.setVisibility(8);
      }
      else
      {
        lx(false);
        ly(false);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ad.i("MicroMsg.FavoriteBaseUI", "[onDestroy]");
    if (((af)g.ad(af.class)).getFavItemInfoStorage().cvk() == null)
    {
      ad.e("MicroMsg.FavoriteBaseUI", "[onDestroy] return getBaseDB is null");
      return;
    }
    this.rvp.destory();
    this.rvp = null;
    ((af)g.ad(af.class)).getFavItemInfoStorage().remove(this.rvw);
    g.aiU().b(400, this.rvr);
    g.aiU().b(402, this.rvs);
    this.rpF.quit();
  }
  
  public void onPause()
  {
    super.onPause();
    cvU();
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.pluginsdk.wallet.h.Zx(5);
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