package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.a.a;
import com.tencent.mm.plugin.fav.ui.widget.c;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.w;

public abstract class FavBaseUI
  extends MMActivity
  implements AdapterView.OnItemClickListener
{
  protected com.tencent.mm.sdk.platformtools.ak faV = new com.tencent.mm.sdk.platformtools.ak(Looper.getMainLooper());
  private final Object lockObj = new Object();
  private HandlerThread mqE;
  protected com.tencent.mm.sdk.platformtools.ak mqF;
  protected c mvA;
  protected View mvB;
  protected l mvC;
  protected c.a mvD = null;
  private f mvE = new FavBaseUI.8(this);
  private f mvF = new FavBaseUI.9(this);
  private Runnable mvG = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(73935);
      a locala = FavBaseUI.this.bxl();
      locala.bxO();
      locala.bxP();
      FavBaseUI.this.bxq();
      AppMethodBeat.o(73935);
    }
  };
  protected Runnable mvH = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(73936);
      a locala = FavBaseUI.this.bxl();
      if ((!locala.isEmpty()) && (SystemClock.elapsedRealtime() - FavBaseUI.e(FavBaseUI.this) < 400L))
      {
        ab.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.e(FavBaseUI.this)), Integer.valueOf(400) });
        FavBaseUI.this.faV.postDelayed(this, 200L);
        AppMethodBeat.o(73936);
        return;
      }
      FavBaseUI.f(FavBaseUI.this);
      FavBaseUI.a(FavBaseUI.this, SystemClock.elapsedRealtime());
      ab.v("MicroMsg.FavoriteBaseUI", "do refresh job");
      locala.notifyDataSetChanged();
      FavBaseUI.this.a(locala);
      if (FavBaseUI.this.mvt)
      {
        ab.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
        FavBaseUI.this.mvw.setSelection(0);
        FavBaseUI.this.mvt = false;
      }
      AppMethodBeat.o(73936);
    }
  };
  private Runnable mvI = new FavBaseUI.2(this);
  private k.a mvJ = new FavBaseUI.3(this);
  private boolean mvs = false;
  protected boolean mvt = false;
  private boolean mvu = false;
  private long mvv = 0L;
  protected ListView mvw;
  protected TextView mvx;
  protected View mvy;
  private View mvz;
  
  private void hz(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mvx == null) {
        this.mvx = ((TextView)((ViewStub)findViewById(2131824107)).inflate().findViewById(2131823725));
      }
      this.mvx.setVisibility(0);
    }
    while (this.mvx == null) {
      return;
    }
    this.mvx.setVisibility(8);
  }
  
  protected final void a(a parama)
  {
    if (parama == null) {
      ab.w("MicroMsg.FavoriteBaseUI", "handle empty view fail, adapter is null");
    }
    do
    {
      return;
      if (parama.isEmpty()) {
        if (bxn())
        {
          hy(true);
          hz(false);
        }
      }
      while ((parama.isEmpty()) || (((ae)g.G(ae.class)).getFavItemInfoStorage().v(parama.bxM(), parama.getType())))
      {
        this.mvw.removeFooterView(this.mvy);
        return;
        hy(false);
        hz(true);
        bxo();
        continue;
        hy(false);
        hz(false);
      }
    } while (this.mvw.getFooterViewsCount() != 0);
    this.mvw.addFooterView(this.mvy);
  }
  
  public abstract a bxl();
  
  protected abstract void bxm();
  
  protected abstract boolean bxn();
  
  protected abstract void bxo();
  
  protected abstract View.OnClickListener bxp();
  
  protected void bxq()
  {
    ab.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
    this.faV.removeCallbacks(this.mvH);
    this.faV.post(this.mvH);
  }
  
  public int getLayoutId()
  {
    return 2130969568;
  }
  
  protected final void hy(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.mvz == null) {
        this.mvz = ((ViewStub)findViewById(2131823999)).inflate();
      }
      this.mvz.setVisibility(0);
    }
    while (this.mvz == null) {
      return;
    }
    this.mvz.setVisibility(8);
  }
  
  protected void initHeaderView()
  {
    this.mvA = new c(getContext());
    this.mvA.setCleanFavSpace(this.mvD);
    this.mvA.hE(false);
    this.mvA.mEa.setVisibility(8);
    this.mvA.mEb.setVisibility(8);
    ab.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", new Object[] { Integer.valueOf(this.mvA.getPaddingTop()), Integer.valueOf(this.mvA.getPaddingBottom()) });
    this.mvw.addHeaderView(this.mvA);
    this.mvB = View.inflate(getContext(), 2130969565, null);
    TextView localTextView1 = (TextView)this.mvB.findViewById(2131824099);
    final TextView localTextView2 = (TextView)this.mvB.findViewById(2131824098);
    TextView localTextView3 = (TextView)this.mvB.findViewById(2131824103);
    TextView localTextView4 = (TextView)this.mvB.findViewById(2131824101);
    TextView localTextView5 = (TextView)this.mvB.findViewById(2131824105);
    TextView localTextView6 = (TextView)this.mvB.findViewById(2131824100);
    final TextView localTextView7 = (TextView)this.mvB.findViewById(2131824102);
    TextView localTextView8 = (TextView)this.mvB.findViewById(2131824104);
    View.OnClickListener localOnClickListener = bxp();
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
    this.mvB.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(73932);
        FavBaseUI.this.mvB.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        int i = FavBaseUI.this.mvB.findViewById(2131824097).getWidth() / 4;
        if ((i > 0) && (localTextView2.getWidth() < i))
        {
          localTextView2.setWidth(i);
          localTextView7.setWidth(i);
        }
        AppMethodBeat.o(73932);
      }
    });
    this.mvw.addHeaderView(this.mvB);
  }
  
  public void initView()
  {
    long l = System.currentTimeMillis();
    this.mvw = ((ListView)findViewById(2131824106));
    this.mvw.setDrawingCacheEnabled(false);
    setToTop(new FavBaseUI.4(this));
    initHeaderView();
    this.mvy = w.hM(this).inflate(2130969551, null);
    this.mvw.setOnScrollListener(new FavBaseUI.5(this));
    this.mvw.setOnItemClickListener(this);
    this.mvw.setOnTouchListener(new FavBaseUI.6(this));
    this.mvw.setAdapter(bxl());
    a(bxl());
    ab.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    ab.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(g.RG()) });
    paramBundle = new com.tencent.mm.plugin.fav.a.ak();
    g.Rc().a(paramBundle, 0);
    ((ae)g.G(ae.class)).getFavItemInfoStorage().add(this.mvJ);
    g.Rc().a(400, this.mvE);
    g.Rc().a(402, this.mvF);
    this.mqE = d.aqu(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.mqE.start();
    this.mqF = new com.tencent.mm.sdk.platformtools.ak(this.mqE.getLooper());
    this.mvC = new l(getContext(), 64);
    initView();
    setActionbarColor(getContext().getResources().getColor(2131690316));
    if (bo.g((Integer)g.RL().Ru().get(8217, null)) == 0)
    {
      ab.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
      this.mvu = true;
      paramBundle = new aj();
      g.Rc().a(paramBundle, 0);
      if (this.mvu)
      {
        ab.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
        if ((bxl() == null) || (bxl().isEmpty())) {
          hy(true);
        }
        hz(false);
      }
    }
    for (;;)
    {
      ((ae)g.G(ae.class)).getFavCdnService().run();
      ((ae)g.G(ae.class)).getCheckCdnService().run();
      ((ae)g.G(ae.class)).getSendService().run();
      ((ae)g.G(ae.class)).getModService().run();
      g.RO().ac(new FavBaseUI.1(this));
      ab.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      b.startSync();
      if (bxl().isEmpty())
      {
        hy(true);
        hz(false);
        this.mvy.setVisibility(8);
      }
      else
      {
        hy(false);
        hz(false);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (((ae)g.G(ae.class)).getFavItemInfoStorage().bwI() == null) {
      return;
    }
    this.mvC.destory();
    this.mvC = null;
    this.mqE.quit();
    ((ae)g.G(ae.class)).getFavItemInfoStorage().remove(this.mvJ);
    g.Rc().b(400, this.mvE);
    g.Rc().b(402, this.mvF);
  }
  
  public void onPause()
  {
    super.onPause();
    bxl();
  }
  
  public void onResume()
  {
    super.onResume();
    j.Mx(5);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavBaseUI
 * JD-Core Version:    0.7.0.1
 */