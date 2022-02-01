package com.tencent.mm.plugin.appbrand.pip;

import android.content.Context;
import android.graphics.Point;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.w.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.w.i.a;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.cb;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.x;
import com.tencent.mm.plugin.appbrand.page.x.a;
import com.tencent.mm.plugin.appbrand.page.x.b;
import com.tencent.mm.plugin.appbrand.page.x.d;
import com.tencent.mm.plugin.appbrand.page.x.e;
import com.tencent.mm.plugin.appbrand.page.x.h;
import com.tencent.mm.plugin.appbrand.page.x.i;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class g
{
  public final String exO;
  private final AudioManager mAudioManager;
  public final Context mContext;
  public AppBrandPipContainerView qsN;
  final x qsj;
  public final AppBrandRuntime qwG;
  View tIY;
  volatile boolean tKA;
  volatile boolean tKe;
  public final Map<Integer, a> tKf;
  private Map<Integer, Set<String>> tKg;
  public b tKh;
  com.tencent.mm.plugin.appbrand.jsapi.w.h tKi;
  public String tKj;
  u tKk;
  boolean tKl;
  a.a tKm;
  public i.a tKn;
  volatile boolean tKo;
  boolean tKp;
  boolean tKq;
  volatile Integer tKr;
  boolean tKs;
  boolean tKt;
  ag tKu;
  ag tKv;
  private AudioManager.OnAudioFocusChangeListener tKw;
  public k tKx;
  private j tKy;
  public d tKz;
  
  public g(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(319632);
    this.exO = ("MicroMsg.AppBrand.AppBrandPipManager#" + hashCode());
    this.qsN = null;
    this.tKe = false;
    this.tKf = new ConcurrentHashMap();
    this.tKg = new ConcurrentHashMap();
    this.tIY = null;
    this.tKh = null;
    this.tKi = null;
    this.tKj = null;
    this.tKk = null;
    this.tKl = true;
    this.tKm = null;
    this.tKn = null;
    this.tKo = false;
    this.tKp = false;
    this.tKq = false;
    this.tKr = null;
    this.tKs = false;
    this.tKt = false;
    this.tKu = null;
    this.tKv = null;
    this.tKw = null;
    this.tKx = null;
    this.tKy = null;
    this.tKz = null;
    this.mContext = paramContext;
    this.qwG = paramAppBrandRuntime;
    this.mAudioManager = ((AudioManager)paramContext.getApplicationContext().getSystemService("audio"));
    this.qsj = paramAppBrandRuntime.getPageContainer();
    if (!paramAppBrandRuntime.mResumed) {}
    for (boolean bool = true;; bool = false)
    {
      this.tKA = bool;
      AppMethodBeat.o(319632);
      return;
    }
  }
  
  private AudioManager.OnAudioFocusChangeListener cHK()
  {
    AppMethodBeat.i(319642);
    if (this.tKw == null) {
      this.tKw = new AudioManager.OnAudioFocusChangeListener()
      {
        public final void onAudioFocusChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(319571);
          Log.d(g.this.exO, "onAudioFocusChange, focusChange: ".concat(String.valueOf(paramAnonymousInt)));
          if (g.this.tKA)
          {
            Log.i(g.this.exO, "onAudioFocusChange, runtime paused");
            AppMethodBeat.o(319571);
            return;
          }
          if (g.this.tKm == null)
          {
            Log.d(g.this.exO, "onAudioFocusChange, mPipVideoSession is null");
            AppMethodBeat.o(319571);
            return;
          }
          if ((g.this.tKj == null) || ((g.this.tKs) && (g.this.tKt)))
          {
            Log.d(g.this.exO, "onAudioFocusChange, mPipVideoRelatedKey is null or is transfering from");
            AppMethodBeat.o(319571);
            return;
          }
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(319571);
            return;
            g.this.tKm.tIW.start();
            AppMethodBeat.o(319571);
            return;
            g.this.afH("onAudioFocusChange");
            g.this.tKm.tIW.pause();
            g.this.tKq = true;
          }
        }
      };
    }
    AudioManager.OnAudioFocusChangeListener localOnAudioFocusChangeListener = this.tKw;
    AppMethodBeat.o(319642);
    return localOnAudioFocusChangeListener;
  }
  
  public static String u(u paramu)
  {
    AppMethodBeat.i(319647);
    if (paramu == null)
    {
      AppMethodBeat.o(319647);
      return "null";
    }
    paramu = paramu.getClass().getSimpleName() + "@" + paramu.hashCode() + "(" + paramu.getCurrentUrl() + ")";
    AppMethodBeat.o(319647);
    return paramu;
  }
  
  public final a A(ad paramad)
  {
    AppMethodBeat.i(319671);
    paramad = CS(paramad.hashCode());
    AppMethodBeat.o(319671);
    return paramad;
  }
  
  public final boolean CR(int paramInt)
  {
    AppMethodBeat.i(319666);
    Log.i(this.exO, "exitPip, viewId: ".concat(String.valueOf(paramInt)));
    if (this.tKo)
    {
      Log.w(this.exO, "exitPip when mPipClickProcessing, return");
      AppMethodBeat.o(319666);
      return false;
    }
    if ((this.tKj != null) && (this.tKj.contains(String.valueOf(paramInt))))
    {
      if ((this.tKm != null) && (this.tKz != null)) {
        this.tKz.a(this.tKm.tIX, f.tKb);
      }
      if (this.qsN != null) {
        this.qsN.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(319575);
            g.a(g.this);
            AppMethodBeat.o(319575);
          }
        });
      }
      AppMethodBeat.o(319666);
      return true;
    }
    AppMethodBeat.o(319666);
    return false;
  }
  
  final a CS(int paramInt)
  {
    AppMethodBeat.i(319670);
    a locala = (a)this.tKf.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      Log.w(this.exO, "getPageScopedPipInfo, null == pageScopedPipInfo");
      AppMethodBeat.o(319670);
      return null;
    }
    AppMethodBeat.o(319670);
    return locala;
  }
  
  final void F(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(319675);
    Log.i(this.exO, "clearPipVideoRelated, mayPause: " + paramBoolean1 + ", mayDestroyPage: " + paramBoolean2);
    if ((this.tKj != null) && (this.tKm != null) && (this.tKk != null) && (this.tKm.tIU != null)) {
      this.tKm.tIU.mC(this.tKm.id).d(this.tKk);
    }
    String str = this.tKj;
    this.tKj = null;
    int i;
    Object localObject;
    if (this.tKk != null)
    {
      i = this.tKk.getCurrentPageView().hashCode();
      v(i, str, "clearPipVideoRelated");
      if (paramBoolean2)
      {
        localObject = this.qsj.getCurrentPage();
        if (localObject != null) {
          break label312;
        }
        Log.w(this.exO, "clearPipVideoRelated, curPage is null");
      }
    }
    for (;;)
    {
      this.tKk.tvc = false;
      if ((paramBoolean1) && (this.tKm != null) && (this.tKm.tIW != null)) {
        this.tKm.tIW.pause();
      }
      if ((paramBoolean2) && (!this.tKl))
      {
        Log.i(this.exO, "clearPipVideoRelated, performDestroy and performCleanup");
        this.tKk.performDestroy();
        this.tKk.arb();
        if (this.tKm != null)
        {
          localObject = this.tKm;
          if (((a.a)localObject).tIW != null) {
            ((a.a)localObject).tIW.a(null);
          }
        }
        u(i, str, "clearPipVideoRelated");
      }
      this.tKk = null;
      this.qsj.setPipVideoRelatedPage(null);
      this.tKl = true;
      this.tKm = null;
      AppMethodBeat.o(319675);
      return;
      label312:
      ((u)localObject).a(cb.tBu, null);
      ((u)localObject).e(cb.tBu);
    }
  }
  
  final void afH(String paramString)
  {
    AppMethodBeat.i(319680);
    Log.d(this.exO, paramString + ", abandonAudioFocus");
    this.mAudioManager.abandonAudioFocus(cHK());
    AppMethodBeat.o(319680);
  }
  
  public final void cHJ()
  {
    AppMethodBeat.i(319668);
    if ((this.qsN != null) && (this.tKx != null))
    {
      if (this.tKy == null) {
        this.tKy = this.tKx.a(this.qwG.mAppId, this.qsN);
      }
      this.tKy.a(new i()
      {
        public final void g(final Point paramAnonymousPoint)
        {
          AppMethodBeat.i(319576);
          if (paramAnonymousPoint == null)
          {
            Log.i(g.this.exO, "onPipStablePosGot, point is null");
            AppMethodBeat.o(319576);
            return;
          }
          com.tencent.threadpool.h.ahAA.bk(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(319538);
              if (g.this.qsN != null) {
                g.this.qsN.setStablePos(paramAnonymousPoint);
              }
              AppMethodBeat.o(319538);
            }
          });
          AppMethodBeat.o(319576);
        }
      });
    }
    AppMethodBeat.o(319668);
  }
  
  final boolean kI(boolean paramBoolean)
  {
    AppMethodBeat.i(319673);
    if ((this.qsN == null) || (this.tKi == null) || (this.tIY == null))
    {
      AppMethodBeat.o(319673);
      return false;
    }
    Object localObject1;
    if (this.tKv != null)
    {
      localObject1 = this.tKv;
      ((ag)localObject1).urw.set(0);
      ((ag)localObject1).run();
      this.tKv = null;
    }
    Object localObject2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(319587);
        Log.i(g.this.exO, "transferFrom, dismissTask run");
        g.this.tKu = null;
        if ((g.this.qsN == null) || (g.this.tIY == null) || (g.this.tKi == null))
        {
          AppMethodBeat.o(319587);
          return;
        }
        AppBrandPipContainerView localAppBrandPipContainerView = g.this.qsN;
        View localView = g.this.tIY;
        localAppBrandPipContainerView.uwW.removeView(localView);
        g.this.tKi.cR(g.this.tIY);
        g.this.qsN.setVisibility(4);
        g.this.tIY = null;
        g.this.tKh = null;
        AppMethodBeat.o(319587);
      }
    };
    Log.i(this.exO, "transferFrom");
    if (paramBoolean)
    {
      localObject1 = this.tKi;
      View localView = this.tIY;
      localObject2 = new ag((Runnable)localObject2, (byte)0);
      this.tKu = ((ag)localObject2);
      ((com.tencent.mm.plugin.appbrand.jsapi.w.h)localObject1).e(localView, (Runnable)localObject2);
    }
    for (;;)
    {
      AppMethodBeat.o(319673);
      return true;
      this.tKi.e(this.tIY, null);
      ((Runnable)localObject2).run();
    }
  }
  
  final void u(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(319677);
    Set localSet = (Set)this.tKg.get(Integer.valueOf(paramInt));
    if (localSet != null)
    {
      Log.i(this.exO, paramString2 + ", mPageView2VideosMap remove " + paramString1 + " for " + paramInt);
      localSet.remove(paramString1);
    }
    AppMethodBeat.o(319677);
  }
  
  final void v(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(319678);
    Set localSet = (Set)this.tKg.get(Integer.valueOf(paramInt));
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.tKg.put(Integer.valueOf(paramInt), localObject);
    }
    Log.i(this.exO, paramString2 + ", mPageView2VideosMap add " + paramString1 + " for " + paramInt);
    ((Set)localObject).add(paramString1);
    AppMethodBeat.o(319678);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.g
 * JD-Core Version:    0.7.0.1
 */