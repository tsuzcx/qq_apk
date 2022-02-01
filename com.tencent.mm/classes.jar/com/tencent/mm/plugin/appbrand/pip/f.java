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
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.s.i.a;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bx;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.page.w.e;
import com.tencent.mm.plugin.appbrand.page.w.h;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  public final String cDW;
  public AppBrandPipContainerView kAR;
  final w kAs;
  public final AppBrandRuntime kEc;
  private final AudioManager mAudioManager;
  public final Context mContext;
  View nBY;
  volatile boolean nDd;
  public final Map<Integer, a> nDe;
  private Map<Integer, Set<String>> nDf;
  public b nDg;
  com.tencent.mm.plugin.appbrand.jsapi.s.h nDh;
  public String nDi;
  t nDj;
  boolean nDk;
  a.a nDl;
  public i.a nDm;
  volatile boolean nDn;
  boolean nDo;
  boolean nDp;
  volatile Integer nDq;
  boolean nDr;
  boolean nDs;
  z nDt;
  z nDu;
  private AudioManager.OnAudioFocusChangeListener nDv;
  public j nDw;
  private i nDx;
  public d nDy;
  volatile boolean nDz;
  
  public f(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(219555);
    this.cDW = ("MicroMsg.AppBrand.AppBrandPipManager#" + hashCode());
    this.kAR = null;
    this.nDd = false;
    this.nDe = new ConcurrentHashMap();
    this.nDf = new ConcurrentHashMap();
    this.nBY = null;
    this.nDg = null;
    this.nDh = null;
    this.nDi = null;
    this.nDj = null;
    this.nDk = true;
    this.nDl = null;
    this.nDm = null;
    this.nDn = false;
    this.nDo = false;
    this.nDp = false;
    this.nDq = null;
    this.nDr = false;
    this.nDs = false;
    this.nDt = null;
    this.nDu = null;
    this.nDv = null;
    this.nDw = null;
    this.nDx = null;
    this.nDy = null;
    this.mContext = paramContext;
    this.kEc = paramAppBrandRuntime;
    this.mAudioManager = ((AudioManager)paramContext.getApplicationContext().getSystemService("audio"));
    this.kAs = paramAppBrandRuntime.brh();
    if (!paramAppBrandRuntime.mResumed) {}
    for (boolean bool = true;; bool = false)
    {
      this.nDz = bool;
      AppMethodBeat.o(219555);
      return;
    }
  }
  
  private AudioManager.OnAudioFocusChangeListener bTH()
  {
    AppMethodBeat.i(219565);
    if (this.nDv == null) {
      this.nDv = new AudioManager.OnAudioFocusChangeListener()
      {
        public final void onAudioFocusChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(219543);
          Log.d(f.this.cDW, "onAudioFocusChange, focusChange: ".concat(String.valueOf(paramAnonymousInt)));
          if (f.this.nDz)
          {
            Log.i(f.this.cDW, "onAudioFocusChange, runtime paused");
            AppMethodBeat.o(219543);
            return;
          }
          if (f.this.nDl == null)
          {
            Log.d(f.this.cDW, "onAudioFocusChange, mPipVideoSession is null");
            AppMethodBeat.o(219543);
            return;
          }
          if ((f.this.nDi == null) || ((f.this.nDr) && (f.this.nDs)))
          {
            Log.d(f.this.cDW, "onAudioFocusChange, mPipVideoRelatedKey is null or is transfering from");
            AppMethodBeat.o(219543);
            return;
          }
          switch (paramAnonymousInt)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(219543);
            return;
            f.this.nDl.nBW.start();
            AppMethodBeat.o(219543);
            return;
            f.this.aeA("onAudioFocusChange");
            f.this.nDl.nBW.pause();
            f.this.nDp = true;
          }
        }
      };
    }
    AudioManager.OnAudioFocusChangeListener localOnAudioFocusChangeListener = this.nDv;
    AppMethodBeat.o(219565);
    return localOnAudioFocusChangeListener;
  }
  
  public static String s(t paramt)
  {
    AppMethodBeat.i(219566);
    if (paramt == null)
    {
      AppMethodBeat.o(219566);
      return "null";
    }
    paramt = paramt.getClass().getSimpleName() + "@" + paramt.hashCode() + "(" + paramt.getCurrentUrl() + ")";
    AppMethodBeat.o(219566);
    return paramt;
  }
  
  final void aeA(String paramString)
  {
    AppMethodBeat.i(219564);
    Log.d(this.cDW, paramString + ", abandonAudioFocus");
    this.mAudioManager.abandonAudioFocus(bTH());
    AppMethodBeat.o(219564);
  }
  
  public final void bTG()
  {
    AppMethodBeat.i(219557);
    if ((this.kAR != null) && (this.nDw != null))
    {
      if (this.nDx == null) {
        this.nDx = this.nDw.a(this.kEc.mAppId, this.kAR);
      }
      this.nDx.a(new h()
      {
        public final void f(final Point paramAnonymousPoint)
        {
          AppMethodBeat.i(219547);
          if (paramAnonymousPoint == null)
          {
            Log.i(f.this.cDW, "onPipStablePosGot, point is null");
            AppMethodBeat.o(219547);
            return;
          }
          com.tencent.f.h.RTc.aV(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(219546);
              if (f.this.kAR != null) {
                f.this.kAR.setStablePos(paramAnonymousPoint);
              }
              AppMethodBeat.o(219546);
            }
          });
          AppMethodBeat.o(219547);
        }
      });
    }
    AppMethodBeat.o(219557);
  }
  
  final boolean ix(boolean paramBoolean)
  {
    AppMethodBeat.i(219560);
    if ((this.kAR == null) || (this.nDh == null) || (this.nBY == null))
    {
      AppMethodBeat.o(219560);
      return false;
    }
    Object localObject1;
    if (this.nDu != null)
    {
      localObject1 = this.nDu;
      ((z)localObject1).ohs.set(0);
      ((z)localObject1).run();
      this.nDu = null;
    }
    Object localObject2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219548);
        Log.i(f.this.cDW, "transferFrom, dismissTask run");
        f.this.nDt = null;
        if ((f.this.kAR == null) || (f.this.nBY == null) || (f.this.nDh == null))
        {
          AppMethodBeat.o(219548);
          return;
        }
        AppBrandPipContainerView localAppBrandPipContainerView = f.this.kAR;
        View localView = f.this.nBY;
        localAppBrandPipContainerView.okL.removeView(localView);
        f.this.nDh.cf(f.this.nBY);
        f.this.kAR.setVisibility(4);
        f.this.nBY = null;
        f.this.nDg = null;
        AppMethodBeat.o(219548);
      }
    };
    Log.i(this.cDW, "transferFrom");
    if (paramBoolean)
    {
      localObject1 = this.nDh;
      View localView = this.nBY;
      localObject2 = new z((Runnable)localObject2, (byte)0);
      this.nDt = ((z)localObject2);
      ((com.tencent.mm.plugin.appbrand.jsapi.s.h)localObject1).e(localView, (Runnable)localObject2);
    }
    for (;;)
    {
      AppMethodBeat.o(219560);
      return true;
      this.nDh.e(this.nBY, null);
      ((Runnable)localObject2).run();
    }
  }
  
  final void r(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219562);
    Set localSet = (Set)this.nDf.get(Integer.valueOf(paramInt));
    if (localSet != null)
    {
      Log.i(this.cDW, paramString2 + ", mPageView2VideosMap remove " + paramString1 + " for " + paramInt);
      localSet.remove(paramString1);
    }
    AppMethodBeat.o(219562);
  }
  
  final void s(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219563);
    Set localSet = (Set)this.nDf.get(Integer.valueOf(paramInt));
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.nDf.put(Integer.valueOf(paramInt), localObject);
    }
    Log.i(this.cDW, paramString2 + ", mPageView2VideosMap add " + paramString1 + " for " + paramInt);
    ((Set)localObject).add(paramString1);
    AppMethodBeat.o(219563);
  }
  
  final void y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(219561);
    Log.i(this.cDW, "clearPipVideoRelated, mayPause: " + paramBoolean1 + ", mayDestroyPage: " + paramBoolean2);
    if ((this.nDi != null) && (this.nDl != null) && (this.nDj != null) && (this.nDl.nBU != null)) {
      this.nDl.nBU.hX(this.nDl.id).d(this.nDj);
    }
    String str = this.nDi;
    this.nDi = null;
    int i;
    Object localObject;
    if (this.nDj != null)
    {
      i = this.nDj.getCurrentPageView().hashCode();
      s(i, str, "clearPipVideoRelated");
      if (paramBoolean2)
      {
        localObject = this.kAs.getCurrentPage();
        if (localObject != null) {
          break label312;
        }
        Log.w(this.cDW, "clearPipVideoRelated, curPage is null");
      }
    }
    for (;;)
    {
      this.nDj.noQ = false;
      if ((paramBoolean1) && (this.nDl != null) && (this.nDl.nBW != null)) {
        this.nDl.nBW.pause();
      }
      if ((paramBoolean2) && (!this.nDk))
      {
        Log.i(this.cDW, "clearPipVideoRelated, performDestroy and performCleanup");
        this.nDj.performDestroy();
        this.nDj.NR();
        if (this.nDl != null)
        {
          localObject = this.nDl;
          if (((a.a)localObject).nBW != null) {
            ((a.a)localObject).nBW.a(null);
          }
        }
        r(i, str, "clearPipVideoRelated");
      }
      this.nDj = null;
      this.kAs.setPipVideoRelatedPage(null);
      this.nDk = true;
      this.nDl = null;
      AppMethodBeat.o(219561);
      return;
      label312:
      ((t)localObject).a(bx.nuL, null);
      ((t)localObject).b(bx.nuL);
    }
  }
  
  public final boolean yV(int paramInt)
  {
    AppMethodBeat.i(219556);
    Log.i(this.cDW, "exitPip, viewId: ".concat(String.valueOf(paramInt)));
    if (this.nDn)
    {
      Log.w(this.cDW, "exitPip when mPipClickProcessing, return");
      AppMethodBeat.o(219556);
      return false;
    }
    if ((this.nDi != null) && (this.nDi.contains(String.valueOf(paramInt))))
    {
      if ((this.nDl != null) && (this.nDy != null)) {
        this.nDy.a(this.nDl.nBX, e.nDa);
      }
      if (this.kAR != null) {
        this.kAR.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(219545);
            f.a(f.this);
            AppMethodBeat.o(219545);
          }
        });
      }
      AppMethodBeat.o(219556);
      return true;
    }
    AppMethodBeat.o(219556);
    return false;
  }
  
  final a yW(int paramInt)
  {
    AppMethodBeat.i(219558);
    a locala = (a)this.nDe.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      Log.w(this.cDW, "getPageScopedPipInfo, null == pageScopedPipInfo");
      AppMethodBeat.o(219558);
      return null;
    }
    AppMethodBeat.o(219558);
    return locala;
  }
  
  public final a z(ac paramac)
  {
    AppMethodBeat.i(219559);
    paramac = yW(paramac.hashCode());
    AppMethodBeat.o(219559);
    return paramac;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f
 * JD-Core Version:    0.7.0.1
 */