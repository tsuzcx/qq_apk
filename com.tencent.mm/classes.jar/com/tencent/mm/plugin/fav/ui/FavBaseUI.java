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
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.ui.MMActivity;

public abstract class FavBaseUI
  extends MMActivity
  implements AdapterView.OnItemClickListener
{
  protected aq gKO = new aq(Looper.getMainLooper());
  protected TextView gZC;
  private final Object lockObj = new Object();
  protected View rDA;
  protected o rDB;
  protected c.a rDC = null;
  private f rDD = new f()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
    {
      AppMethodBeat.i(106618);
      ae.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
      if (((ak)paramAnonymousn).rBS)
      {
        ae.i("MicroMsg.FavoriteBaseUI", "need batch get return");
        AppMethodBeat.o(106618);
        return;
      }
      ae.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
      if (FavBaseUI.c(FavBaseUI.this)) {
        FavBaseUI.d(FavBaseUI.this);
      }
      FavBaseUI.this.lx(false);
      FavBaseUI.this.cxA();
      AppMethodBeat.o(106618);
    }
  };
  private f rDE = new f()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
    {
      AppMethodBeat.i(106619);
      ae.i("MicroMsg.FavoriteBaseUI", "on batch get end");
      if (FavBaseUI.c(FavBaseUI.this))
      {
        ae.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
        FavBaseUI.d(FavBaseUI.this);
        FavBaseUI.this.lx(false);
      }
      AppMethodBeat.o(106619);
    }
  };
  private Runnable rDF = new com.tencent.e.i.h()
  {
    public final String getKey()
    {
      return "MicroMsg.FavoriteBaseUI#notifyAdapterJob";
    }
    
    public final void run()
    {
      AppMethodBeat.i(106620);
      a locala = FavBaseUI.this.cxv();
      locala.aTS();
      locala.cyi();
      FavBaseUI.this.cxA();
      AppMethodBeat.o(106620);
    }
  };
  protected Runnable rDG = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(106621);
      a locala = FavBaseUI.this.cxv();
      if ((!locala.isEmpty()) && (SystemClock.elapsedRealtime() - FavBaseUI.e(FavBaseUI.this) < 400L))
      {
        ae.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.e(FavBaseUI.this)), Integer.valueOf(400) });
        FavBaseUI.this.gKO.postDelayed(this, 200L);
        AppMethodBeat.o(106621);
        return;
      }
      FavBaseUI.f(FavBaseUI.this);
      FavBaseUI.a(FavBaseUI.this, SystemClock.elapsedRealtime());
      ae.v("MicroMsg.FavoriteBaseUI", "do refresh job");
      locala.notifyDataSetChanged();
      FavBaseUI.this.a(locala);
      if (FavBaseUI.this.rDt)
      {
        ae.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
        FavBaseUI.this.rDw.setSelection(0);
        FavBaseUI.this.rDt = false;
      }
      AppMethodBeat.o(106621);
    }
  };
  private Runnable rDH = new com.tencent.e.i.h()
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
        FavBaseUI.this.cxw();
        FavBaseUI.this.cxv().cyi();
        FavBaseUI.this.cxA();
        AppMethodBeat.o(106612);
        return;
      }
    }
  };
  private k.a rDI = new FavBaseUI.3(this);
  private boolean rDs = false;
  protected boolean rDt = false;
  private boolean rDu = false;
  private long rDv = 0L;
  protected ListView rDw;
  protected View rDx;
  private View rDy;
  protected c rDz;
  protected aq rxJ;
  
  private void ly(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.gZC == null) {
        this.gZC = ((TextView)((ViewStub)findViewById(2131299479)).inflate().findViewById(2131299464));
      }
      this.gZC.setVisibility(0);
    }
    while (this.gZC == null) {
      return;
    }
    this.gZC.setVisibility(8);
  }
  
  protected final void a(a parama)
  {
    if (parama == null) {
      ae.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
    }
    do
    {
      return;
      if (parama.isEmpty()) {
        if (cxx())
        {
          lx(true);
          ly(false);
        }
      }
      while ((parama.isEmpty()) || (((af)g.ad(af.class)).getFavItemInfoStorage().B(parama.cyg(), parama.getType())))
      {
        this.rDw.removeFooterView(this.rDx);
        return;
        lx(false);
        ly(true);
        cxy();
        continue;
        lx(false);
        ly(false);
      }
    } while (this.rDw.getFooterViewsCount() != 0);
    this.rDw.addFooterView(this.rDx);
  }
  
  protected void cxA()
  {
    ae.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
    this.gKO.removeCallbacks(this.rDG);
    this.gKO.post(this.rDG);
  }
  
  public abstract a cxv();
  
  protected abstract void cxw();
  
  protected abstract boolean cxx();
  
  protected abstract void cxy();
  
  protected abstract View.OnClickListener cxz();
  
  public int getLayoutId()
  {
    return 2131493986;
  }
  
  protected void initHeaderView()
  {
    this.rDz = new c(getContext());
    this.rDz.setCleanFavSpace(this.rDC);
    this.rDz.lH(false);
    this.rDz.rMP.setVisibility(8);
    this.rDz.rMQ.setVisibility(8);
    ae.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", new Object[] { Integer.valueOf(this.rDz.getPaddingTop()), Integer.valueOf(this.rDz.getPaddingBottom()) });
    this.rDw.addHeaderView(this.rDz);
    this.rDA = View.inflate(getContext(), 2131493983, null);
    TextView localTextView1 = (TextView)this.rDA.findViewById(2131299838);
    TextView localTextView2 = (TextView)this.rDA.findViewById(2131299833);
    TextView localTextView3 = (TextView)this.rDA.findViewById(2131299839);
    TextView localTextView4 = (TextView)this.rDA.findViewById(2131299835);
    TextView localTextView5 = (TextView)this.rDA.findViewById(2131299834);
    TextView localTextView6 = (TextView)this.rDA.findViewById(2131299832);
    TextView localTextView7 = (TextView)this.rDA.findViewById(2131299837);
    TextView localTextView8 = (TextView)this.rDA.findViewById(2131299836);
    View.OnClickListener localOnClickListener = cxz();
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
    this.rDA.getViewTreeObserver().addOnGlobalLayoutListener(new FavBaseUI.7(this, localTextView2, localTextView7));
    this.rDw.addHeaderView(this.rDA);
  }
  
  public void initView()
  {
    long l = System.currentTimeMillis();
    this.rDw = ((ListView)findViewById(2131299867));
    this.rDw.setDrawingCacheEnabled(false);
    setToTop(new FavBaseUI.4(this));
    initHeaderView();
    this.rDx = com.tencent.mm.ui.z.jV(this).inflate(2131493968, null);
    this.rDw.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(106615);
        if (paramAnonymousInt == 0)
        {
          if (((af)g.ad(af.class)).getFavItemInfoStorage().B(FavBaseUI.this.cxv().cyg(), FavBaseUI.this.cxv().getType()))
          {
            ae.v("MicroMsg.FavoriteBaseUI", "has shown all, do not load data");
            AppMethodBeat.o(106615);
            return;
          }
          if (FavBaseUI.a(FavBaseUI.this))
          {
            ae.i("MicroMsg.FavoriteBaseUI", "force bottom load data");
            FavBaseUI.b(FavBaseUI.this);
          }
        }
        AppMethodBeat.o(106615);
      }
    });
    this.rDw.setOnItemClickListener(this);
    this.rDw.setOnTouchListener(new FavBaseUI.6(this));
    this.rDw.setAdapter(cxv());
    a(cxv());
    ae.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  protected final void lx(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.rDy == null)
      {
        localViewStub = (ViewStub)findViewById(2131299466);
        if (localViewStub != null) {
          this.rDy = localViewStub.inflate();
        }
      }
      this.rDy.setVisibility(0);
    }
    while (this.rDy == null)
    {
      ViewStub localViewStub;
      return;
    }
    this.rDy.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    ae.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(g.ajM()) });
    paramBundle = new al();
    g.ajj().a(paramBundle, 0);
    ((af)g.ad(af.class)).getFavItemInfoStorage().add(this.rDI);
    g.ajj().a(400, this.rDD);
    g.ajj().a(402, this.rDE);
    this.rxJ = new aq(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.rDB = new o(getContext(), 64);
    initView();
    setActionbarColor(getContext().getResources().getColor(2131100705));
    if (bu.o((Integer)g.ajR().ajA().get(8217, null)) == 0)
    {
      ae.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
      this.rDu = true;
      paramBundle = new ak();
      g.ajj().a(paramBundle, 0);
      if (this.rDu)
      {
        ae.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
        if ((cxv() == null) || (cxv().isEmpty())) {
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
      g.ajU().aw(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106611);
          b.cwd();
          AppMethodBeat.o(106611);
        }
      });
      ae.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      b.startSync();
      if (cxv().isEmpty())
      {
        lx(true);
        ly(false);
        this.rDx.setVisibility(8);
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
    ae.i("MicroMsg.FavoriteBaseUI", "[onDestroy]");
    if (((af)g.ad(af.class)).getFavItemInfoStorage().cwL() == null)
    {
      ae.e("MicroMsg.FavoriteBaseUI", "[onDestroy] return getBaseDB is null");
      return;
    }
    this.rDB.destory();
    this.rDB = null;
    ((af)g.ad(af.class)).getFavItemInfoStorage().remove(this.rDI);
    g.ajj().b(400, this.rDD);
    g.ajj().b(402, this.rDE);
    this.rxJ.quit();
  }
  
  public void onPause()
  {
    super.onPause();
    cxv();
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.pluginsdk.wallet.h.aad(5);
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