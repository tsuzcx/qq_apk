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
import com.tencent.mm.plugin.appbrand.jsapi.q.c;
import com.tencent.mm.plugin.appbrand.jsapi.q.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.q.i.a;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.bs;
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
import com.tencent.mm.sdk.platformtools.ad;
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
  public final String crd;
  final u jwI;
  public AppBrandPipContainerView jxc;
  public final AppBrandRuntime jzY;
  final AudioManager mAudioManager;
  public final Context mContext;
  View mmq;
  public String mnA;
  r mnB;
  boolean mnC;
  a.a mnD;
  public i.a mnE;
  volatile boolean mnF;
  boolean mnG;
  boolean mnH;
  volatile Integer mnI;
  boolean mnJ;
  boolean mnK;
  x mnL;
  x mnM;
  volatile boolean mnN;
  AudioManager.OnAudioFocusChangeListener mnO;
  public j mnP;
  private i mnQ;
  public d mnR;
  volatile boolean mnS;
  volatile boolean mnv;
  public final Map<Integer, a> mnw;
  private Map<Integer, Set<String>> mnx;
  public b mny;
  com.tencent.mm.plugin.appbrand.jsapi.q.h mnz;
  
  public f(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(197411);
    this.crd = ("MicroMsg.AppBrand.AppBrandPipManager#" + hashCode());
    this.jxc = null;
    this.mnv = false;
    this.mnw = new ConcurrentHashMap();
    this.mnx = new ConcurrentHashMap();
    this.mmq = null;
    this.mny = null;
    this.mnz = null;
    this.mnA = null;
    this.mnB = null;
    this.mnC = true;
    this.mnD = null;
    this.mnE = null;
    this.mnF = false;
    this.mnG = false;
    this.mnH = false;
    this.mnI = null;
    this.mnJ = false;
    this.mnK = false;
    this.mnL = null;
    this.mnM = null;
    this.mnN = false;
    this.mnO = null;
    this.mnP = null;
    this.mnQ = null;
    this.mnR = null;
    this.mContext = paramContext;
    this.jzY = paramAppBrandRuntime;
    this.mAudioManager = ((AudioManager)paramContext.getApplicationContext().getSystemService("audio"));
    this.jwI = paramAppBrandRuntime.aVN();
    if (!paramAppBrandRuntime.mResumed) {}
    for (boolean bool = true;; bool = false)
    {
      this.mnS = bool;
      AppMethodBeat.o(197411);
      return;
    }
  }
  
  public static String r(r paramr)
  {
    AppMethodBeat.i(197420);
    if (paramr == null)
    {
      AppMethodBeat.o(197420);
      return "null";
    }
    paramr = paramr.getClass().getSimpleName() + "@" + paramr.hashCode() + "(" + paramr.getCurrentUrl() + ")";
    AppMethodBeat.o(197420);
    return paramr;
  }
  
  public final void bwF()
  {
    AppMethodBeat.i(197413);
    if ((this.jxc != null) && (this.mnP != null))
    {
      if (this.mnQ == null) {
        this.mnQ = this.mnP.a(this.jzY.mAppId, this.jxc);
      }
      this.mnQ.a(new h()
      {
        public final void e(final Point paramAnonymousPoint)
        {
          AppMethodBeat.i(197403);
          if (paramAnonymousPoint == null)
          {
            ad.i(f.this.crd, "onPipStablePosGot, point is null");
            AppMethodBeat.o(197403);
            return;
          }
          com.tencent.e.h.LTJ.aP(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(197402);
              if (f.this.jxc != null) {
                f.this.jxc.setStablePos(paramAnonymousPoint);
              }
              AppMethodBeat.o(197402);
            }
          });
          AppMethodBeat.o(197403);
        }
      });
    }
    AppMethodBeat.o(197413);
  }
  
  final boolean hv(boolean paramBoolean)
  {
    AppMethodBeat.i(197416);
    if ((this.jxc == null) || (this.mnz == null) || (this.mmq == null))
    {
      AppMethodBeat.o(197416);
      return false;
    }
    Object localObject1;
    if (this.mnM != null)
    {
      localObject1 = this.mnM;
      ((x)localObject1).mPm.set(0);
      ((x)localObject1).run();
      this.mnM = null;
    }
    Object localObject2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197404);
        ad.i(f.this.crd, "transferFrom, dismissTask run");
        f.this.mnL = null;
        if ((f.this.jxc == null) || (f.this.mmq == null) || (f.this.mnz == null))
        {
          AppMethodBeat.o(197404);
          return;
        }
        AppBrandPipContainerView localAppBrandPipContainerView = f.this.jxc;
        View localView = f.this.mmq;
        localAppBrandPipContainerView.mSy.removeView(localView);
        f.this.mnz.cq(f.this.mmq);
        f.this.jxc.setVisibility(4);
        f.this.mmq = null;
        f.this.mny = null;
        AppMethodBeat.o(197404);
      }
    };
    ad.i(this.crd, "transferFrom");
    if (paramBoolean)
    {
      localObject1 = this.mnz;
      View localView = this.mmq;
      localObject2 = new x((Runnable)localObject2, (byte)0);
      this.mnL = ((x)localObject2);
      ((com.tencent.mm.plugin.appbrand.jsapi.q.h)localObject1).e(localView, (Runnable)localObject2);
    }
    for (;;)
    {
      AppMethodBeat.o(197416);
      return true;
      this.mnz.e(this.mmq, null);
      ((Runnable)localObject2).run();
    }
  }
  
  final void q(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(197418);
    Set localSet = (Set)this.mnx.get(Integer.valueOf(paramInt));
    if (localSet != null)
    {
      ad.i(this.crd, paramString2 + ", mPageView2VideosMap remove " + paramString1 + " for " + paramInt);
      localSet.remove(paramString1);
    }
    AppMethodBeat.o(197418);
  }
  
  final void r(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(197419);
    Set localSet = (Set)this.mnx.get(Integer.valueOf(paramInt));
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.mnx.put(Integer.valueOf(paramInt), localObject);
    }
    ad.i(this.crd, paramString2 + ", mPageView2VideosMap add " + paramString1 + " for " + paramInt);
    ((Set)localObject).add(paramString1);
    AppMethodBeat.o(197419);
  }
  
  public final a t(aa paramaa)
  {
    AppMethodBeat.i(197415);
    paramaa = uZ(paramaa.hashCode());
    AppMethodBeat.o(197415);
    return paramaa;
  }
  
  public final boolean uY(int paramInt)
  {
    AppMethodBeat.i(197412);
    ad.i(this.crd, "exitPip, viewId: ".concat(String.valueOf(paramInt)));
    if (this.mnF)
    {
      ad.w(this.crd, "exitPip when mPipClickProcessing, return");
      AppMethodBeat.o(197412);
      return false;
    }
    if ((this.mnA != null) && (this.mnA.contains(String.valueOf(paramInt))))
    {
      if ((this.mnD != null) && (this.mnR != null)) {
        this.mnR.a(this.mnD.mmp, e.mns);
      }
      if (this.jxc != null) {
        this.jxc.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(197401);
            f.a(f.this);
            AppMethodBeat.o(197401);
          }
        });
      }
      AppMethodBeat.o(197412);
      return true;
    }
    AppMethodBeat.o(197412);
    return false;
  }
  
  final a uZ(int paramInt)
  {
    AppMethodBeat.i(197414);
    a locala = (a)this.mnw.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      ad.w(this.crd, "getPageScopedPipInfo, null == pageScopedPipInfo");
      AppMethodBeat.o(197414);
      return null;
    }
    AppMethodBeat.o(197414);
    return locala;
  }
  
  final void y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(197417);
    ad.i(this.crd, "clearPipVideoRelated, mayPause: " + paramBoolean1 + ", mayDestroyPage: " + paramBoolean2);
    if ((this.mnA != null) && (this.mnD != null) && (this.mnB != null) && (this.mnD.mmm != null)) {
      this.mnD.mmm.gH(this.mnD.id).d(this.mnB);
    }
    String str = this.mnA;
    this.mnA = null;
    int i;
    Object localObject;
    if (this.mnB != null)
    {
      i = this.mnB.getCurrentPageView().hashCode();
      r(i, str, "clearPipVideoRelated");
      if (paramBoolean2)
      {
        localObject = this.jwI.getCurrentPage();
        if (localObject != null) {
          break label312;
        }
        ad.w(this.crd, "clearPipVideoRelated, curPage is null");
      }
    }
    for (;;)
    {
      this.mnB.mad = false;
      if ((paramBoolean1) && (this.mnD != null) && (this.mnD.mmo != null)) {
        this.mnD.mmo.pause();
      }
      if ((paramBoolean2) && (!this.mnC))
      {
        ad.i(this.crd, "clearPipVideoRelated, performDestroy and performCleanup");
        this.mnB.performDestroy();
        this.mnB.Eq();
        if (this.mnD != null)
        {
          localObject = this.mnD;
          if (((a.a)localObject).mmo != null) {
            ((a.a)localObject).mmo.a(null);
          }
        }
        q(i, str, "clearPipVideoRelated");
      }
      this.mnB = null;
      this.jwI.setPipVideoRelatedPage(null);
      this.mnC = true;
      this.mnD = null;
      AppMethodBeat.o(197417);
      return;
      label312:
      ((r)localObject).a(bs.mfT, null);
      ((r)localObject).bue();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f
 * JD-Core Version:    0.7.0.1
 */