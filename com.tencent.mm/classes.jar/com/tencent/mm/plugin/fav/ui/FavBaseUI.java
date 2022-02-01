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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
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
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.MMActivity;

public abstract class FavBaseUI
  extends MMActivity
  implements AdapterView.OnItemClickListener
{
  protected TextView gDf;
  protected ao gox = new ao(Looper.getMainLooper());
  private final Object lockObj = new Object();
  protected ao qFN;
  private boolean qLe = false;
  protected boolean qLf = false;
  private boolean qLg = false;
  private long qLh = 0L;
  protected ListView qLi;
  protected View qLj;
  private View qLk;
  protected c qLl;
  protected View qLm;
  protected o qLn;
  protected c.a qLo = null;
  private com.tencent.mm.ak.g qLp = new com.tencent.mm.ak.g()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
    {
      AppMethodBeat.i(106618);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
      if (((ak)paramAnonymousn).qJE)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FavoriteBaseUI", "need batch get return");
        AppMethodBeat.o(106618);
        return;
      }
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
      if (FavBaseUI.c(FavBaseUI.this)) {
        FavBaseUI.d(FavBaseUI.this);
      }
      FavBaseUI.this.le(false);
      FavBaseUI.this.cqu();
      AppMethodBeat.o(106618);
    }
  };
  private com.tencent.mm.ak.g qLq = new com.tencent.mm.ak.g()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
    {
      AppMethodBeat.i(106619);
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FavoriteBaseUI", "on batch get end");
      if (FavBaseUI.c(FavBaseUI.this))
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
        FavBaseUI.d(FavBaseUI.this);
        FavBaseUI.this.le(false);
      }
      AppMethodBeat.o(106619);
    }
  };
  private Runnable qLr = new com.tencent.e.i.h()
  {
    public final String getKey()
    {
      return "MicroMsg.FavoriteBaseUI#notifyAdapterJob";
    }
    
    public final void run()
    {
      AppMethodBeat.i(106620);
      a locala = FavBaseUI.this.cqp();
      locala.aQh();
      locala.cqX();
      FavBaseUI.this.cqu();
      AppMethodBeat.o(106620);
    }
  };
  protected Runnable qLs = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(106621);
      a locala = FavBaseUI.this.cqp();
      if ((!locala.isEmpty()) && (SystemClock.elapsedRealtime() - FavBaseUI.e(FavBaseUI.this) < 400L))
      {
        com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.e(FavBaseUI.this)), Integer.valueOf(400) });
        FavBaseUI.this.gox.postDelayed(this, 200L);
        AppMethodBeat.o(106621);
        return;
      }
      FavBaseUI.f(FavBaseUI.this);
      FavBaseUI.a(FavBaseUI.this, SystemClock.elapsedRealtime());
      com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.FavoriteBaseUI", "do refresh job");
      locala.notifyDataSetChanged();
      FavBaseUI.this.a(locala);
      if (FavBaseUI.this.qLf)
      {
        com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
        FavBaseUI.this.qLi.setSelection(0);
        FavBaseUI.this.qLf = false;
      }
      AppMethodBeat.o(106621);
    }
  };
  private Runnable qLt = new com.tencent.e.i.h()
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
        FavBaseUI.this.cqq();
        FavBaseUI.this.cqp().cqX();
        FavBaseUI.this.cqu();
        AppMethodBeat.o(106612);
        return;
      }
    }
  };
  private k.a qLu = new FavBaseUI.3(this);
  
  private void lf(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.gDf == null) {
        this.gDf = ((TextView)((ViewStub)findViewById(2131299479)).inflate().findViewById(2131299464));
      }
      this.gDf.setVisibility(0);
    }
    while (this.gDf == null) {
      return;
    }
    this.gDf.setVisibility(8);
  }
  
  protected final void a(a parama)
  {
    if (parama == null) {
      com.tencent.mm.sdk.platformtools.ac.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
    }
    do
    {
      return;
      if (parama.isEmpty()) {
        if (cqr())
        {
          le(true);
          lf(false);
        }
      }
      while ((parama.isEmpty()) || (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(parama.cqV(), parama.getType())))
      {
        this.qLi.removeFooterView(this.qLj);
        return;
        le(false);
        lf(true);
        cqs();
        continue;
        le(false);
        lf(false);
      }
    } while (this.qLi.getFooterViewsCount() != 0);
    this.qLi.addFooterView(this.qLj);
  }
  
  public abstract a cqp();
  
  protected abstract void cqq();
  
  protected abstract boolean cqr();
  
  protected abstract void cqs();
  
  protected abstract View.OnClickListener cqt();
  
  protected void cqu()
  {
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
    this.gox.removeCallbacks(this.qLs);
    this.gox.post(this.qLs);
  }
  
  public int getLayoutId()
  {
    return 2131493986;
  }
  
  protected void initHeaderView()
  {
    this.qLl = new c(getContext());
    this.qLl.setCleanFavSpace(this.qLo);
    this.qLl.lo(false);
    this.qLl.qUq.setVisibility(8);
    this.qLl.qUr.setVisibility(8);
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", new Object[] { Integer.valueOf(this.qLl.getPaddingTop()), Integer.valueOf(this.qLl.getPaddingBottom()) });
    this.qLi.addHeaderView(this.qLl);
    this.qLm = View.inflate(getContext(), 2131493983, null);
    TextView localTextView1 = (TextView)this.qLm.findViewById(2131299838);
    final TextView localTextView2 = (TextView)this.qLm.findViewById(2131299833);
    TextView localTextView3 = (TextView)this.qLm.findViewById(2131299839);
    TextView localTextView4 = (TextView)this.qLm.findViewById(2131299835);
    TextView localTextView5 = (TextView)this.qLm.findViewById(2131299834);
    TextView localTextView6 = (TextView)this.qLm.findViewById(2131299832);
    final TextView localTextView7 = (TextView)this.qLm.findViewById(2131299837);
    TextView localTextView8 = (TextView)this.qLm.findViewById(2131299836);
    View.OnClickListener localOnClickListener = cqt();
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
    this.qLm.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(106617);
        FavBaseUI.this.qLm.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = FavBaseUI.this.qLm.findViewById(2131299854).getWidth() / 4;
        if ((i > 0) && (localTextView2.getWidth() < i))
        {
          localTextView2.setWidth(i);
          localTextView7.setWidth(i);
        }
        AppMethodBeat.o(106617);
      }
    });
    this.qLi.addHeaderView(this.qLm);
  }
  
  public void initView()
  {
    long l = System.currentTimeMillis();
    this.qLi = ((ListView)findViewById(2131299867));
    this.qLi.setDrawingCacheEnabled(false);
    setToTop(new FavBaseUI.4(this));
    initHeaderView();
    this.qLj = com.tencent.mm.ui.z.jD(this).inflate(2131493968, null);
    this.qLi.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(106615);
        if (paramAnonymousInt == 0)
        {
          if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().A(FavBaseUI.this.cqp().cqV(), FavBaseUI.this.cqp().getType()))
          {
            com.tencent.mm.sdk.platformtools.ac.v("MicroMsg.FavoriteBaseUI", "has shown all, do not load data");
            AppMethodBeat.o(106615);
            return;
          }
          if (FavBaseUI.a(FavBaseUI.this))
          {
            com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FavoriteBaseUI", "force bottom load data");
            FavBaseUI.b(FavBaseUI.this);
          }
        }
        AppMethodBeat.o(106615);
      }
    });
    this.qLi.setOnItemClickListener(this);
    this.qLi.setOnTouchListener(new FavBaseUI.6(this));
    this.qLi.setAdapter(cqp());
    a(cqp());
    com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  protected final void le(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.qLk == null)
      {
        localViewStub = (ViewStub)findViewById(2131299466);
        if (localViewStub != null) {
          this.qLk = localViewStub.inflate();
        }
      }
      this.qLk.setVisibility(0);
    }
    while (this.qLk == null)
    {
      ViewStub localViewStub;
      return;
    }
    this.qLk.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(com.tencent.mm.kernel.g.agM()) });
    paramBundle = new al();
    com.tencent.mm.kernel.g.agi().a(paramBundle, 0);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().add(this.qLu);
    com.tencent.mm.kernel.g.agi().a(400, this.qLp);
    com.tencent.mm.kernel.g.agi().a(402, this.qLq);
    this.qFN = new ao(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.qLn = new o(getContext(), 64);
    initView();
    setActionbarColor(getContext().getResources().getColor(2131100705));
    if (bs.m((Integer)com.tencent.mm.kernel.g.agR().agA().get(8217, null)) == 0)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
      this.qLg = true;
      paramBundle = new ak();
      com.tencent.mm.kernel.g.agi().a(paramBundle, 0);
      if (this.qLg)
      {
        com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
        if ((cqp() == null) || (cqp().isEmpty())) {
          le(true);
        }
        lf(false);
      }
    }
    for (;;)
    {
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnService().run();
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getCheckCdnService().run();
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getSendService().run();
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getModService().run();
      com.tencent.mm.kernel.g.agU().az(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106611);
          b.coX();
          AppMethodBeat.o(106611);
        }
      });
      com.tencent.mm.sdk.platformtools.ac.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      b.startSync();
      if (cqp().isEmpty())
      {
        le(true);
        lf(false);
        this.qLj.setVisibility(8);
      }
      else
      {
        le(false);
        lf(false);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.FavoriteBaseUI", "[onDestroy]");
    if (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().cpF() == null)
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.FavoriteBaseUI", "[onDestroy] return getBaseDB is null");
      return;
    }
    this.qLn.destory();
    this.qLn = null;
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().remove(this.qLu);
    com.tencent.mm.kernel.g.agi().b(400, this.qLp);
    com.tencent.mm.kernel.g.agi().b(402, this.qLq);
    this.qFN.quit();
  }
  
  public void onPause()
  {
    super.onPause();
    cqp();
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.pluginsdk.wallet.h.XB(5);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI
 * JD-Core Version:    0.7.0.1
 */