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
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.jsapi.q.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.q.i.a;
import com.tencent.mm.plugin.appbrand.page.br;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.page.t.e;
import com.tencent.mm.plugin.appbrand.page.t.h;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.sdk.platformtools.ae;
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
  public final String crG;
  public AppBrandPipContainerView jAa;
  public final AppBrandRuntime jDb;
  final t jzE;
  final AudioManager mAudioManager;
  public final Context mContext;
  View mrn;
  boolean msA;
  a.a msB;
  public i.a msC;
  volatile boolean msD;
  boolean msE;
  boolean msF;
  volatile Integer msG;
  boolean msH;
  boolean msI;
  com.tencent.mm.plugin.appbrand.utils.z msJ;
  com.tencent.mm.plugin.appbrand.utils.z msK;
  volatile boolean msL;
  AudioManager.OnAudioFocusChangeListener msM;
  public j msN;
  private i msO;
  public d msP;
  volatile boolean msQ;
  volatile boolean mst;
  public final Map<Integer, a> msu;
  private Map<Integer, Set<String>> msv;
  public b msw;
  com.tencent.mm.plugin.appbrand.jsapi.q.h msx;
  public String msy;
  q msz;
  
  public f(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(207953);
    this.crG = ("MicroMsg.AppBrand.AppBrandPipManager#" + hashCode());
    this.jAa = null;
    this.mst = false;
    this.msu = new ConcurrentHashMap();
    this.msv = new ConcurrentHashMap();
    this.mrn = null;
    this.msw = null;
    this.msx = null;
    this.msy = null;
    this.msz = null;
    this.msA = true;
    this.msB = null;
    this.msC = null;
    this.msD = false;
    this.msE = false;
    this.msF = false;
    this.msG = null;
    this.msH = false;
    this.msI = false;
    this.msJ = null;
    this.msK = null;
    this.msL = false;
    this.msM = null;
    this.msN = null;
    this.msO = null;
    this.msP = null;
    this.mContext = paramContext;
    this.jDb = paramAppBrandRuntime;
    this.mAudioManager = ((AudioManager)paramContext.getApplicationContext().getSystemService("audio"));
    this.jzE = paramAppBrandRuntime.aWm();
    if (!paramAppBrandRuntime.mResumed) {}
    for (boolean bool = true;; bool = false)
    {
      this.msQ = bool;
      AppMethodBeat.o(207953);
      return;
    }
  }
  
  public static String r(q paramq)
  {
    AppMethodBeat.i(207962);
    if (paramq == null)
    {
      AppMethodBeat.o(207962);
      return "null";
    }
    paramq = paramq.getClass().getSimpleName() + "@" + paramq.hashCode() + "(" + paramq.getCurrentUrl() + ")";
    AppMethodBeat.o(207962);
    return paramq;
  }
  
  public final void bxw()
  {
    AppMethodBeat.i(207955);
    if ((this.jAa != null) && (this.msN != null))
    {
      if (this.msO == null) {
        this.msO = this.msN.a(this.jDb.mAppId, this.jAa);
      }
      this.msO.a(new h()
      {
        public final void e(final Point paramAnonymousPoint)
        {
          AppMethodBeat.i(207945);
          if (paramAnonymousPoint == null)
          {
            ae.i(f.this.crG, "onPipStablePosGot, point is null");
            AppMethodBeat.o(207945);
            return;
          }
          com.tencent.e.h.MqF.aM(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(207944);
              if (f.this.jAa != null) {
                f.this.jAa.setStablePos(paramAnonymousPoint);
              }
              AppMethodBeat.o(207944);
            }
          });
          AppMethodBeat.o(207945);
        }
      });
    }
    AppMethodBeat.o(207955);
  }
  
  final boolean hw(boolean paramBoolean)
  {
    AppMethodBeat.i(207958);
    if ((this.jAa == null) || (this.msx == null) || (this.mrn == null))
    {
      AppMethodBeat.o(207958);
      return false;
    }
    Object localObject1;
    if (this.msK != null)
    {
      localObject1 = this.msK;
      ((com.tencent.mm.plugin.appbrand.utils.z)localObject1).mUr.set(0);
      ((com.tencent.mm.plugin.appbrand.utils.z)localObject1).run();
      this.msK = null;
    }
    Object localObject2 = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207946);
        ae.i(f.this.crG, "transferFrom, dismissTask run");
        f.this.msJ = null;
        if ((f.this.jAa == null) || (f.this.mrn == null) || (f.this.msx == null))
        {
          AppMethodBeat.o(207946);
          return;
        }
        AppBrandPipContainerView localAppBrandPipContainerView = f.this.jAa;
        View localView = f.this.mrn;
        localAppBrandPipContainerView.mXH.removeView(localView);
        f.this.msx.cq(f.this.mrn);
        f.this.jAa.setVisibility(4);
        f.this.mrn = null;
        f.this.msw = null;
        AppMethodBeat.o(207946);
      }
    };
    ae.i(this.crG, "transferFrom");
    if (paramBoolean)
    {
      localObject1 = this.msx;
      View localView = this.mrn;
      localObject2 = new com.tencent.mm.plugin.appbrand.utils.z((Runnable)localObject2, (byte)0);
      this.msJ = ((com.tencent.mm.plugin.appbrand.utils.z)localObject2);
      ((com.tencent.mm.plugin.appbrand.jsapi.q.h)localObject1).e(localView, (Runnable)localObject2);
    }
    for (;;)
    {
      AppMethodBeat.o(207958);
      return true;
      this.msx.e(this.mrn, null);
      ((Runnable)localObject2).run();
    }
  }
  
  final void q(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207960);
    Set localSet = (Set)this.msv.get(Integer.valueOf(paramInt));
    if (localSet != null)
    {
      ae.i(this.crG, paramString2 + ", mPageView2VideosMap remove " + paramString1 + " for " + paramInt);
      localSet.remove(paramString1);
    }
    AppMethodBeat.o(207960);
  }
  
  final void r(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(207961);
    Set localSet = (Set)this.msv.get(Integer.valueOf(paramInt));
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.msv.put(Integer.valueOf(paramInt), localObject);
    }
    ae.i(this.crG, paramString2 + ", mPageView2VideosMap add " + paramString1 + " for " + paramInt);
    ((Set)localObject).add(paramString1);
    AppMethodBeat.o(207961);
  }
  
  public final a u(com.tencent.mm.plugin.appbrand.page.z paramz)
  {
    AppMethodBeat.i(207957);
    paramz = ve(paramz.hashCode());
    AppMethodBeat.o(207957);
    return paramz;
  }
  
  public final boolean vd(int paramInt)
  {
    AppMethodBeat.i(207954);
    ae.i(this.crG, "exitPip, viewId: ".concat(String.valueOf(paramInt)));
    if (this.msD)
    {
      ae.w(this.crG, "exitPip when mPipClickProcessing, return");
      AppMethodBeat.o(207954);
      return false;
    }
    if ((this.msy != null) && (this.msy.contains(String.valueOf(paramInt))))
    {
      if ((this.msB != null) && (this.msP != null)) {
        this.msP.a(this.msB.mrm, e.msq);
      }
      if (this.jAa != null) {
        this.jAa.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(207943);
            f.a(f.this);
            AppMethodBeat.o(207943);
          }
        });
      }
      AppMethodBeat.o(207954);
      return true;
    }
    AppMethodBeat.o(207954);
    return false;
  }
  
  final a ve(int paramInt)
  {
    AppMethodBeat.i(207956);
    a locala = (a)this.msu.get(Integer.valueOf(paramInt));
    if (locala == null)
    {
      ae.w(this.crG, "getPageScopedPipInfo, null == pageScopedPipInfo");
      AppMethodBeat.o(207956);
      return null;
    }
    AppMethodBeat.o(207956);
    return locala;
  }
  
  final void y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(207959);
    ae.i(this.crG, "clearPipVideoRelated, mayPause: " + paramBoolean1 + ", mayDestroyPage: " + paramBoolean2);
    if ((this.msy != null) && (this.msB != null) && (this.msz != null) && (this.msB.mrj != null)) {
      this.msB.mrj.gI(this.msB.id).d(this.msz);
    }
    String str = this.msy;
    this.msy = null;
    int i;
    Object localObject;
    if (this.msz != null)
    {
      i = this.msz.getCurrentPageView().hashCode();
      r(i, str, "clearPipVideoRelated");
      if (paramBoolean2)
      {
        localObject = this.jzE.getCurrentPage();
        if (localObject != null) {
          break label312;
        }
        ae.w(this.crG, "clearPipVideoRelated, curPage is null");
      }
    }
    for (;;)
    {
      this.msz.mew = false;
      if ((paramBoolean1) && (this.msB != null) && (this.msB.mrl != null)) {
        this.msB.mrl.pause();
      }
      if ((paramBoolean2) && (!this.msA))
      {
        ae.i(this.crG, "clearPipVideoRelated, performDestroy and performCleanup");
        this.msz.performDestroy();
        this.msz.Es();
        if (this.msB != null)
        {
          localObject = this.msB;
          if (((a.a)localObject).mrl != null) {
            ((a.a)localObject).mrl.a(null);
          }
        }
        q(i, str, "clearPipVideoRelated");
      }
      this.msz = null;
      this.jzE.setPipVideoRelatedPage(null);
      this.msA = true;
      this.msB = null;
      AppMethodBeat.o(207959);
      return;
      label312:
      ((q)localObject).a(br.mko, null);
      ((q)localObject).buP();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.f
 * JD-Core Version:    0.7.0.1
 */