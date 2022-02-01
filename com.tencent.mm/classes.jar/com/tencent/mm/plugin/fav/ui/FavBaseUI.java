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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.a.a;
import com.tencent.mm.plugin.fav.ui.widget.c;
import com.tencent.mm.plugin.fav.ui.widget.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;

public abstract class FavBaseUI
  extends MMActivity
  implements AdapterView.OnItemClickListener
{
  protected MMHandler hAk = new MMHandler(Looper.getMainLooper());
  protected TextView hSx;
  private final Object lockObj = new Object();
  private boolean tcX = false;
  protected boolean tcY = false;
  private boolean tcZ = false;
  private long tda = 0L;
  protected ListView tdb;
  protected View tdc;
  private View tdd;
  protected c tde;
  protected View tdf;
  protected o tdg;
  protected c.a tdh = null;
  private i tdi = new i()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
    {
      AppMethodBeat.i(106618);
      Log.i("MicroMsg.FavoriteBaseUI", "on fav sync end");
      if (((ak)paramAnonymousq).tbx)
      {
        Log.i("MicroMsg.FavoriteBaseUI", "need batch get return");
        AppMethodBeat.o(106618);
        return;
      }
      Log.i("MicroMsg.FavoriteBaseUI", "dismiss loading dialog");
      if (FavBaseUI.c(FavBaseUI.this)) {
        FavBaseUI.d(FavBaseUI.this);
      }
      FavBaseUI.this.mz(false);
      FavBaseUI.this.cVE();
      AppMethodBeat.o(106618);
    }
  };
  private i tdj = new i()
  {
    public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
    {
      AppMethodBeat.i(106619);
      Log.i("MicroMsg.FavoriteBaseUI", "on batch get end");
      if (FavBaseUI.c(FavBaseUI.this))
      {
        Log.i("MicroMsg.FavoriteBaseUI", "init currently, dismiss dialog");
        FavBaseUI.d(FavBaseUI.this);
        FavBaseUI.this.mz(false);
      }
      AppMethodBeat.o(106619);
    }
  };
  private Runnable tdk = new com.tencent.f.i.h()
  {
    public final String getKey()
    {
      return "MicroMsg.FavoriteBaseUI#notifyAdapterJob";
    }
    
    public final void run()
    {
      AppMethodBeat.i(106620);
      a locala = FavBaseUI.this.cVz();
      locala.boE();
      locala.cWm();
      FavBaseUI.this.cVE();
      AppMethodBeat.o(106620);
    }
  };
  protected Runnable tdl = new Runnable()
  {
    public final void run()
    {
      AppMethodBeat.i(106621);
      a locala = FavBaseUI.this.cVz();
      if ((!locala.isEmpty()) && (SystemClock.elapsedRealtime() - FavBaseUI.e(FavBaseUI.this) < 400L))
      {
        Log.d("MicroMsg.FavoriteBaseUI", "try refresh, time limit, now %d last %d delay %d", new Object[] { Long.valueOf(SystemClock.elapsedRealtime()), Long.valueOf(FavBaseUI.e(FavBaseUI.this)), Integer.valueOf(400) });
        FavBaseUI.this.hAk.postDelayed(this, 200L);
        AppMethodBeat.o(106621);
        return;
      }
      FavBaseUI.f(FavBaseUI.this);
      FavBaseUI.a(FavBaseUI.this, SystemClock.elapsedRealtime());
      Log.v("MicroMsg.FavoriteBaseUI", "do refresh job");
      locala.notifyDataSetChanged();
      FavBaseUI.this.a(locala);
      if (FavBaseUI.this.tcY)
      {
        Log.v("MicroMsg.FavoriteBaseUI", "do scroll to first");
        FavBaseUI.this.tdb.setSelection(0);
        FavBaseUI.this.tcY = false;
      }
      AppMethodBeat.o(106621);
    }
  };
  private Runnable tdm = new com.tencent.f.i.h()
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
        FavBaseUI.this.cVA();
        FavBaseUI.this.cVz().cWm();
        FavBaseUI.this.cVE();
        AppMethodBeat.o(106612);
        return;
      }
    }
  };
  private MStorage.IOnStorageChange tdn = new MStorage.IOnStorageChange()
  {
    long tdp = 0L;
    
    public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
    {
      AppMethodBeat.i(106613);
      Log.i("MicroMsg.FavoriteBaseUI", "[onNotifyChange] event=%s", new Object[] { paramAnonymousString });
      FavBaseUI.this.workerHandler.removeCallbacks(FavBaseUI.h(FavBaseUI.this));
      if (Util.ticksToNow(this.tdp) > 200L)
      {
        this.tdp = Util.currentTicks();
        FavBaseUI.this.workerHandler.post(FavBaseUI.h(FavBaseUI.this));
        AppMethodBeat.o(106613);
        return;
      }
      FavBaseUI.this.workerHandler.postDelayed(FavBaseUI.h(FavBaseUI.this), 200L);
      AppMethodBeat.o(106613);
    }
  };
  protected MMHandler workerHandler;
  
  private void mA(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.hSx == null) {
        this.hSx = ((TextView)((ViewStub)findViewById(2131300112)).inflate().findViewById(2131300088));
      }
      this.hSx.setVisibility(0);
    }
    while (this.hSx == null) {
      return;
    }
    this.hSx.setVisibility(8);
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
        if (cVB())
        {
          mz(true);
          mA(false);
        }
      }
      while ((parama.isEmpty()) || (((af)g.ah(af.class)).getFavItemInfoStorage().z(parama.cWk(), parama.getType())))
      {
        this.tdb.removeFooterView(this.tdc);
        return;
        mz(false);
        mA(true);
        cVC();
        continue;
        mz(false);
        mA(false);
      }
    } while (this.tdb.getFooterViewsCount() != 0);
    this.tdb.addFooterView(this.tdc);
  }
  
  protected abstract void cVA();
  
  protected abstract boolean cVB();
  
  protected abstract void cVC();
  
  protected abstract View.OnClickListener cVD();
  
  protected void cVE()
  {
    Log.i("MicroMsg.FavoriteBaseUI", "on storage change, try refresh job");
    this.hAk.removeCallbacks(this.tdl);
    this.hAk.post(this.tdl);
  }
  
  public abstract a cVz();
  
  public int getLayoutId()
  {
    return 2131494156;
  }
  
  protected void initHeaderView()
  {
    this.tde = new c(getContext());
    this.tde.setCleanFavSpace(this.tdh);
    this.tde.mJ(false);
    this.tde.tmB.setVisibility(8);
    this.tde.tmC.setVisibility(8);
    Log.d("MicroMsg.FavoriteBaseUI", "padding %s, %s", new Object[] { Integer.valueOf(this.tde.getPaddingTop()), Integer.valueOf(this.tde.getPaddingBottom()) });
    this.tdb.addHeaderView(this.tde);
    this.tdf = View.inflate(getContext(), 2131494153, null);
    TextView localTextView1 = (TextView)this.tdf.findViewById(2131300516);
    TextView localTextView2 = (TextView)this.tdf.findViewById(2131300511);
    TextView localTextView3 = (TextView)this.tdf.findViewById(2131300517);
    TextView localTextView4 = (TextView)this.tdf.findViewById(2131300513);
    TextView localTextView5 = (TextView)this.tdf.findViewById(2131300512);
    TextView localTextView6 = (TextView)this.tdf.findViewById(2131300510);
    TextView localTextView7 = (TextView)this.tdf.findViewById(2131300515);
    TextView localTextView8 = (TextView)this.tdf.findViewById(2131300514);
    View.OnClickListener localOnClickListener = cVD();
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
    this.tdf.getViewTreeObserver().addOnGlobalLayoutListener(new FavBaseUI.7(this, localTextView2, localTextView7));
    this.tdb.addHeaderView(this.tdf);
  }
  
  public void initView()
  {
    long l = System.currentTimeMillis();
    this.tdb = ((ListView)findViewById(2131300547));
    this.tdb.setDrawingCacheEnabled(false);
    setToTop(new FavBaseUI.4(this));
    initHeaderView();
    this.tdc = aa.jQ(this).inflate(2131494138, null);
    this.tdb.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(106615);
        if (paramAnonymousInt == 0)
        {
          if (((af)g.ah(af.class)).getFavItemInfoStorage().z(FavBaseUI.this.cVz().cWk(), FavBaseUI.this.cVz().getType()))
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
    this.tdb.setOnItemClickListener(this);
    this.tdb.setOnTouchListener(new FavBaseUI.6(this));
    this.tdb.setAdapter(cVz());
    a(cVz());
    Log.d("MicroMsg.FavoriteBaseUI", "init view use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  protected final void mz(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.tdd == null)
      {
        localViewStub = (ViewStub)findViewById(2131300094);
        if (localViewStub != null) {
          this.tdd = localViewStub.inflate();
        }
      }
      this.tdd.setVisibility(0);
    }
    while (this.tdd == null)
    {
      ViewStub localViewStub;
      return;
    }
    this.tdd.setVisibility(8);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    Log.i("MicroMsg.FavoriteBaseUI", "onCreate MMCore.accHasReady[%b]", new Object[] { Boolean.valueOf(g.aAc()) });
    paramBundle = new al();
    g.azz().a(paramBundle, 0);
    ((af)g.ah(af.class)).getFavItemInfoStorage().add(this.tdn);
    g.azz().a(400, this.tdi);
    g.azz().a(402, this.tdj);
    this.workerHandler = new MMHandler(getClass().getName() + "_handlerThread_" + System.currentTimeMillis());
    this.tdg = new o(getContext(), 64);
    initView();
    setActionbarColor(getContext().getResources().getColor(2131100898));
    if (Util.nullAsNil((Integer)g.aAh().azQ().get(8217, null)) == 0)
    {
      Log.i("MicroMsg.FavoriteBaseUI", "do init data for first time");
      this.tcZ = true;
      paramBundle = new ak();
      g.azz().a(paramBundle, 0);
      if (this.tcZ)
      {
        Log.i("MicroMsg.FavoriteBaseUI", "show loading dialog");
        if ((cVz() == null) || (cVz().isEmpty())) {
          mz(true);
        }
        mA(false);
      }
    }
    for (;;)
    {
      ((af)g.ah(af.class)).getFavCdnService().run();
      ((af)g.ah(af.class)).getCheckCdnService().run();
      ((af)g.ah(af.class)).getSendService().run();
      ((af)g.ah(af.class)).getModService().run();
      g.aAk().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(106611);
          b.cUg();
          AppMethodBeat.o(106611);
        }
      });
      Log.d("MicroMsg.FavoriteBaseUI", "on create use %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      return;
      b.startSync();
      if (cVz().isEmpty())
      {
        mz(true);
        mA(false);
        this.tdc.setVisibility(8);
      }
      else
      {
        mz(false);
        mA(false);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Log.i("MicroMsg.FavoriteBaseUI", "[onDestroy]");
    if (((af)g.ah(af.class)).getFavItemInfoStorage().cUP() == null)
    {
      Log.e("MicroMsg.FavoriteBaseUI", "[onDestroy] return getBaseDB is null");
      return;
    }
    this.tdg.destory();
    this.tdg = null;
    ((af)g.ah(af.class)).getFavItemInfoStorage().remove(this.tdn);
    g.azz().b(400, this.tdi);
    g.azz().b(402, this.tdj);
    this.workerHandler.quit();
  }
  
  public void onPause()
  {
    super.onPause();
    cVz();
  }
  
  public void onResume()
  {
    super.onResume();
    com.tencent.mm.pluginsdk.wallet.h.setPayChannel(5);
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