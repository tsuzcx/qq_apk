package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.o.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.d;
import com.tencent.mm.plugin.appbrand.jsapi.o.e;
import com.tencent.mm.plugin.appbrand.jsapi.o.h;
import com.tencent.mm.plugin.appbrand.jsapi.o.i.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.j;
import com.tencent.mm.plugin.appbrand.jsapi.o.j.a;
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
import java.util.concurrent.atomic.AtomicBoolean;

public final class aj
{
  public final String cjP;
  public AppBrandPipContainerView iDU;
  public final t iDz;
  public final AppBrandRuntime iGV;
  View lbN;
  public volatile boolean lcR;
  public final Map<Integer, x> lcS;
  private Map<Integer, Set<String>> lcT;
  public af lcU;
  com.tencent.mm.plugin.appbrand.jsapi.o.i lcV;
  public String lcW;
  q lcX;
  boolean lcY;
  x.a lcZ;
  public j.a lda;
  volatile boolean ldb;
  boolean ldc;
  boolean ldd;
  volatile Integer lde;
  boolean ldf;
  boolean ldg;
  com.tencent.mm.plugin.appbrand.utils.i ldh;
  volatile boolean ldi;
  AudioManager.OnAudioFocusChangeListener ldj;
  public ah ldk;
  AtomicBoolean ldl;
  final AudioManager mAudioManager;
  public final Context mContext;
  
  public aj(Context paramContext, AppBrandRuntime paramAppBrandRuntime)
  {
    AppMethodBeat.i(176683);
    this.cjP = ("MicroMsg.AppBrand.AppBrandPipManager#" + hashCode());
    this.iDU = null;
    this.lcR = false;
    this.lcS = new ConcurrentHashMap();
    this.lcT = new ConcurrentHashMap();
    this.lbN = null;
    this.lcU = null;
    this.lcV = null;
    this.lcW = null;
    this.lcX = null;
    this.lcY = true;
    this.lcZ = null;
    this.lda = null;
    this.ldb = false;
    this.ldc = false;
    this.ldd = false;
    this.lde = null;
    this.ldf = false;
    this.ldg = false;
    this.ldh = null;
    this.ldi = false;
    this.ldj = null;
    this.ldk = null;
    this.mContext = paramContext;
    this.iGV = paramAppBrandRuntime;
    this.mAudioManager = ((AudioManager)paramContext.getApplicationContext().getSystemService("audio"));
    this.iDz = paramAppBrandRuntime.aLK();
    if (!paramAppBrandRuntime.mResumed) {}
    for (boolean bool = true;; bool = false)
    {
      this.ldl = new AtomicBoolean(bool);
      AppMethodBeat.o(176683);
      return;
    }
  }
  
  public static String r(q paramq)
  {
    AppMethodBeat.i(176689);
    if (paramq == null)
    {
      AppMethodBeat.o(176689);
      return "null";
    }
    paramq = paramq.getClass().getSimpleName() + "@" + paramq.hashCode() + "(" + paramq.getCurrentUrl() + ")";
    AppMethodBeat.o(176689);
    return paramq;
  }
  
  public final void a(aa paramaa, String paramString)
  {
    AppMethodBeat.i(176684);
    if (paramaa == null)
    {
      paramaa = this.lcS.values().iterator();
      while (paramaa.hasNext())
      {
        x localx = (x)paramaa.next();
        if (localx.containsKey(paramString))
        {
          localx.LC(paramString);
          AppMethodBeat.o(176684);
          return;
        }
      }
      AppMethodBeat.o(176684);
      return;
    }
    paramaa = s(paramaa);
    if (paramaa == null)
    {
      AppMethodBeat.o(176684);
      return;
    }
    paramaa.LC(paramString);
    AppMethodBeat.o(176684);
  }
  
  final boolean gD(boolean paramBoolean)
  {
    AppMethodBeat.i(176687);
    if ((this.iDU == null) || (this.lcV == null) || (this.lbN == null))
    {
      AppMethodBeat.o(176687);
      return false;
    }
    Object localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(176657);
        ad.i(aj.this.cjP, "transferFrom, dismissTask run");
        if ((aj.this.iDU == null) || (aj.this.lbN == null) || (aj.this.lcV == null))
        {
          AppMethodBeat.o(176657);
          return;
        }
        AppBrandPipContainerView localAppBrandPipContainerView = aj.this.iDU;
        View localView = aj.this.lbN;
        localAppBrandPipContainerView.lPR.removeView(localView);
        aj.this.lcV.cr(aj.this.lbN);
        aj.this.iDU.setVisibility(4);
        aj.this.lbN = null;
        aj.this.lcU = null;
        aj.this.ldh = null;
        AppMethodBeat.o(176657);
      }
    };
    ad.i(this.cjP, "transferFrom");
    if (paramBoolean)
    {
      com.tencent.mm.plugin.appbrand.jsapi.o.i locali = this.lcV;
      View localView = this.lbN;
      localObject = new com.tencent.mm.plugin.appbrand.utils.i((Runnable)localObject);
      this.ldh = ((com.tencent.mm.plugin.appbrand.utils.i)localObject);
      locali.a(localView, (com.tencent.mm.plugin.appbrand.utils.i)localObject);
    }
    for (;;)
    {
      AppMethodBeat.o(176687);
      return true;
      this.lcV.a(this.lbN, null);
      ((Runnable)localObject).run();
    }
  }
  
  final void r(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(178613);
    Set localSet = (Set)this.lcT.get(Integer.valueOf(paramInt));
    if (localSet != null)
    {
      ad.i(this.cjP, paramString2 + ", mPageView2VideosMap remove " + paramString1 + " for " + paramInt);
      localSet.remove(paramString1);
    }
    AppMethodBeat.o(178613);
  }
  
  public final x s(aa paramaa)
  {
    AppMethodBeat.i(176686);
    paramaa = (x)this.lcS.get(Integer.valueOf(paramaa.hashCode()));
    if (paramaa == null)
    {
      ad.w(this.cjP, "getPageScopedPipInfo, null == pageScopedPipInfo");
      AppMethodBeat.o(176686);
      return null;
    }
    AppMethodBeat.o(176686);
    return paramaa;
  }
  
  final void s(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(178614);
    Set localSet = (Set)this.lcT.get(Integer.valueOf(paramInt));
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.lcT.put(Integer.valueOf(paramInt), localObject);
    }
    ad.i(this.cjP, paramString2 + ", mPageView2VideosMap add " + paramString1 + " for " + paramInt);
    ((Set)localObject).add(paramString1);
    AppMethodBeat.o(178614);
  }
  
  public final boolean tv(int paramInt)
  {
    AppMethodBeat.i(176685);
    ad.i(this.cjP, "exitPip, viewId: ".concat(String.valueOf(paramInt)));
    if (this.ldb)
    {
      ad.w(this.cjP, "exitPip when mPipClickProcessing, return");
      AppMethodBeat.o(176685);
      return false;
    }
    if ((this.lcW != null) && (this.lcW.contains(String.valueOf(paramInt))))
    {
      if ((this.lcZ != null) && (this.ldk != null)) {
        this.ldk.a(this.lcZ.laH, ai.lcO);
      }
      if (this.iDU != null) {
        this.iDU.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(178581);
            aj.a(aj.this);
            AppMethodBeat.o(178581);
          }
        });
      }
      AppMethodBeat.o(176685);
      return true;
    }
    AppMethodBeat.o(176685);
    return false;
  }
  
  final void x(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(176688);
    ad.i(this.cjP, "clearPipVideoRelated, mayPause: " + paramBoolean1 + ", mayDestroyPage: " + paramBoolean2);
    if ((this.lcW != null) && (this.lcZ != null) && (this.lcX != null) && (this.lcZ.laE != null)) {
      this.lcZ.laE.gS(this.lcZ.id).d(this.lcX);
    }
    String str = this.lcW;
    this.lcW = null;
    int i;
    Object localObject;
    if (this.lcX != null)
    {
      i = this.lcX.getCurrentPageView().hashCode();
      s(i, str, "clearPipVideoRelated");
      if (paramBoolean2)
      {
        localObject = this.iDz.getCurrentPage();
        if (localObject != null) {
          break label304;
        }
        ad.w(this.cjP, "clearPipVideoRelated, curPage is null");
      }
    }
    for (;;)
    {
      this.lcX.kYU = false;
      if ((paramBoolean1) && (this.lcZ != null) && (this.lcZ.laG != null)) {
        this.lcZ.laG.pause();
      }
      if ((paramBoolean2) && (!this.lcY))
      {
        ad.i(this.cjP, "clearPipVideoRelated, performDestroy and performCleanup");
        this.lcX.performDestroy();
        this.lcX.Do();
        if (this.lcZ != null)
        {
          localObject = this.lcZ;
          if (((x.a)localObject).laG != null) {
            ((x.a)localObject).laG.a(null);
          }
        }
        r(i, str, "clearPipVideoRelated");
      }
      this.lcX = null;
      this.lcY = true;
      this.lcZ = null;
      AppMethodBeat.o(176688);
      return;
      label304:
      ((q)localObject).a(by.lgw, null);
      ((q)localObject).bjm();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aj
 * JD-Core Version:    0.7.0.1
 */