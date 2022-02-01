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
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.n.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.n.i.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.bt;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.u.a;
import com.tencent.mm.plugin.appbrand.page.u.b;
import com.tencent.mm.plugin.appbrand.page.u.d;
import com.tencent.mm.plugin.appbrand.page.u.e;
import com.tencent.mm.plugin.appbrand.page.u.h;
import com.tencent.mm.plugin.appbrand.page.u.i;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public final class f
{
  public final String cgL;
  public AppBrandPipContainerView jdU;
  final u jdz;
  public final AppBrandRuntime jgY;
  View lMC;
  volatile boolean lNI;
  public final Map<Integer, a> lNJ;
  private Map<Integer, Set<String>> lNK;
  public b lNL;
  com.tencent.mm.plugin.appbrand.jsapi.n.h lNM;
  public String lNN;
  r lNO;
  boolean lNP;
  a.a lNQ;
  public i.a lNR;
  volatile boolean lNS;
  boolean lNT;
  volatile Integer lNU;
  boolean lNV;
  boolean lNW;
  x lNX;
  x lNY;
  public j lNZ;
  private i lOa;
  public d lOb;
  volatile boolean lOc;
  boolean lVR;
  final AudioManager mAudioManager;
  public final Context mContext;
  volatile boolean msl;
  AudioManager.OnAudioFocusChangeListener msm;
  
  public f(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(193492);
    this.cgL = ("MicroMsg.AppBrand.AppBrandPipManager#" + hashCode());
    this.jdU = null;
    this.lNI = false;
    this.lNJ = new ConcurrentHashMap();
    this.lNK = new ConcurrentHashMap();
    this.lMC = null;
    this.lNL = null;
    this.lNM = null;
    this.lNN = null;
    this.lNO = null;
    this.lNP = true;
    this.lNQ = null;
    this.lNR = null;
    this.lNS = false;
    this.lNT = false;
    this.lVR = false;
    this.lNU = null;
    this.lNV = false;
    this.lNW = false;
    this.lNX = null;
    this.lNY = null;
    this.msl = false;
    this.msm = null;
    this.lNZ = null;
    this.lOa = null;
    this.lOb = null;
    this.mContext = paramContext;
    this.jgY = paramAppBrandRuntime;
    this.mAudioManager = ((AudioManager)paramContext.getApplicationContext().getSystemService("audio"));
    this.jdz = paramAppBrandRuntime.aSA();
    if (!paramAppBrandRuntime.mResumed) {}
    for (boolean bool = true;; bool = false)
    {
      this.lOc = bool;
      AppMethodBeat.o(193492);
      return;
    }
  }
  
  public static String r(r paramr)
  {
    AppMethodBeat.i(193501);
    if (paramr == null)
    {
      AppMethodBeat.o(193501);
      return "null";
    }
    paramr = paramr.getClass().getSimpleName() + "@" + paramr.hashCode() + "(" + paramr.getCurrentUrl() + ")";
    AppMethodBeat.o(193501);
    return paramr;
  }
  
  public final void bsA()
  {
    AppMethodBeat.i(193494);
    if ((this.jdU != null) && (this.lNZ != null))
    {
      if (this.lOa == null) {
        this.lOa = this.lNZ.a(this.jgY.mAppId, this.jdU);
      }
      this.lOa.a(new h()
      {
        public final void d(final Point paramAnonymousPoint)
        {
          AppMethodBeat.i(193484);
          if (paramAnonymousPoint == null)
          {
            ac.i(f.this.cgL, "onPipStablePosGot, point is null");
            AppMethodBeat.o(193484);
            return;
          }
          com.tencent.e.h.JZN.aQ(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193483);
              if (f.this.jdU != null) {
                f.this.jdU.setStablePos(paramAnonymousPoint);
              }
              AppMethodBeat.o(193483);
            }
          });
          AppMethodBeat.o(193484);
        }
      });
    }
    AppMethodBeat.o(193494);
  }
  
  final boolean ho(boolean paramBoolean)
  {
    AppMethodBeat.i(193497);
    if ((this.jdU == null) || (this.lNM == null) || (this.lMC == null))
    {
      AppMethodBeat.o(193497);
      return false;
    }
    Object localObject1;
    if (this.lNY != null)
    {
      localObject1 = this.lNY;
      ((x)localObject1).moK.set(0);
      ((x)localObject1).run();
      this.lNY = null;
    }
    Object localObject2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193485);
        ac.i(f.this.cgL, "transferFrom, dismissTask run");
        f.this.lNX = null;
        if ((f.this.jdU == null) || (f.this.lMC == null) || (f.this.lNM == null))
        {
          AppMethodBeat.o(193485);
          return;
        }
        AppBrandPipContainerView localAppBrandPipContainerView = f.this.jdU;
        View localView = f.this.lMC;
        localAppBrandPipContainerView.mrS.removeView(localView);
        f.this.lNM.cr(f.this.lMC);
        f.this.jdU.setVisibility(4);
        f.this.lMC = null;
        f.this.lNL = null;
        AppMethodBeat.o(193485);
      }
    };
    ac.i(this.cgL, "transferFrom");
    if (paramBoolean)
    {
      localObject1 = this.lNM;
      View localView = this.lMC;
      localObject2 = new x((Runnable)localObject2, (byte)0);
      this.lNX = ((x)localObject2);
      ((com.tencent.mm.plugin.appbrand.jsapi.n.h)localObject1).c(localView, (Runnable)localObject2);
    }
    for (;;)
    {
      AppMethodBeat.o(193497);
      return true;
      this.lNM.c(this.lMC, null);
      ((Runnable)localObject2).run();
    }
  }
  
  final void q(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(193499);
    Set localSet = (Set)this.lNK.get(Integer.valueOf(paramInt));
    if (localSet != null)
    {
      ac.i(this.cgL, paramString2 + ", mPageView2VideosMap remove " + paramString1 + " for " + paramInt);
      localSet.remove(paramString1);
    }
    AppMethodBeat.o(193499);
  }
  
  final void r(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(193500);
    Set localSet = (Set)this.lNK.get(Integer.valueOf(paramInt));
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.lNK.put(Integer.valueOf(paramInt), localObject);
    }
    ac.i(this.cgL, paramString2 + ", mPageView2VideosMap add " + paramString1 + " for " + paramInt);
    ((Set)localObject).add(paramString1);
    AppMethodBeat.o(193500);
  }
  
  public final a t(aa paramaa)
  {
    AppMethodBeat.i(193496);
    paramaa = uv(paramaa.hashCode());
    AppMethodBeat.o(193496);
    return paramaa;
  }
  
  public final boolean uu(int paramInt)
  {
    AppMethodBeat.i(193493);
    ac.i(this.cgL, "exitPip, viewId: ".concat(String.valueOf(paramInt)));
    if (this.lNS)
    {
      ac.w(this.cgL, "exitPip when mPipClickProcessing, return");
      AppMethodBeat.o(193493);
      return false;
    }
    if ((this.lNN != null) && (this.lNN.contains(String.valueOf(paramInt))))
    {
      if ((this.lNQ != null) && (this.lOb != null)) {
        this.lOb.a(this.lNQ.lMB, e.lNF);
      }
      if (this.jdU != null) {
        this.jdU.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193482);
            f.a(f.this);
            AppMethodBeat.o(193482);
          }
        });
      }
      AppMethodBeat.o(193493);
      return true;
    }
    AppMethodBeat.o(193493);
    return false;
  }
  
  final a uv(int paramInt)
  {
    AppMethodBeat.i(193495);
    a locala = (a)this.lNJ.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      ac.w(this.cgL, "getPageScopedPipInfo, null == pageScopedPipInfo");
      AppMethodBeat.o(193495);
      return null;
    }
    AppMethodBeat.o(193495);
    return locala;
  }
  
  final void y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(193498);
    ac.i(this.cgL, "clearPipVideoRelated, mayPause: " + paramBoolean1 + ", mayDestroyPage: " + paramBoolean2);
    if ((this.lNN != null) && (this.lNQ != null) && (this.lNO != null) && (this.lNQ.lMy != null)) {
      this.lNQ.lMy.gC(this.lNQ.id).d(this.lNO);
    }
    String str = this.lNN;
    this.lNN = null;
    int i;
    Object localObject;
    if (this.lNO != null)
    {
      i = this.lNO.getCurrentPageView().hashCode();
      r(i, str, "clearPipVideoRelated");
      if (paramBoolean2)
      {
        localObject = this.jdz.getCurrentPage();
        if (localObject != null) {
          break label304;
        }
        ac.w(this.cgL, "clearPipVideoRelated, curPage is null");
      }
    }
    for (;;)
    {
      this.lNO.lAE = false;
      if ((paramBoolean1) && (this.lNQ != null) && (this.lNQ.lMA != null)) {
        this.lNQ.lMA.pause();
      }
      if ((paramBoolean2) && (!this.lNP))
      {
        ac.i(this.cgL, "clearPipVideoRelated, performDestroy and performCleanup");
        this.lNO.performDestroy();
        this.lNO.CR();
        if (this.lNQ != null)
        {
          localObject = this.lNQ;
          if (((a.a)localObject).lMA != null) {
            ((a.a)localObject).lMA.a(null);
          }
        }
        q(i, str, "clearPipVideoRelated");
      }
      this.lNO = null;
      this.lNP = true;
      this.lNQ = null;
      AppMethodBeat.o(193498);
      return;
      label304:
      ((r)localObject).a(bt.lGq, null);
      ((r)localObject).bqe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f
 * JD-Core Version:    0.7.0.1
 */