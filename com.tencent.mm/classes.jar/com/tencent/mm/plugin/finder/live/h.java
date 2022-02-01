package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/MiniProgramPreloadHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "ispreload", "", "getIspreload", "()Z", "setIspreload", "(Z)V", "ispresend", "getIspresend", "setIspresend", "isprewarm", "getIsprewarm", "setIsprewarm", "performanceLevel", "", "getPerformanceLevel", "()I", "performanceLevel$delegate", "Lkotlin/Lazy;", "checkPreRender", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "preLoadPkgAndEnv", "", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "preRender", "reset", "plugin-finder_release"})
public final class h
{
  private static final String TAG = "MiniProgramPreloadHelper";
  private static boolean ufU;
  private static boolean ufV;
  private static boolean ufW;
  private static final kotlin.f ufX;
  public static final h ufY;
  
  static
  {
    AppMethodBeat.i(245878);
    ufY = new h();
    TAG = "MiniProgramPreloadHelper";
    ufX = kotlin.g.ah((a)h.a.ufZ);
    AppMethodBeat.o(245878);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.viewmodel.g paramg, final com.tencent.mm.plugin.appbrand.api.g paramg1)
  {
    AppMethodBeat.i(245877);
    p.h(paramg1, "bundle");
    Object localObject = m.vVH;
    if (m.dBP())
    {
      AppMethodBeat.o(245877);
      return;
    }
    int i = deY();
    localObject = c.vCb;
    int j = c.dva();
    localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder("[preRender] performanceLevel:").append(i).append(",threshold:").append(j).append(",appId:").append(paramg1.appId).append(",patch:").append(paramg1.kHw).append(",is test:");
    c localc = c.vCb;
    Log.i((String)localObject, c.dvc());
    if ((Util.isNullOrNil(paramg1.appId)) || (Util.isNullOrNil(paramg1.kHw)))
    {
      Log.i(TAG, "[preRender] fail, stack:" + Util.getStack());
      AppMethodBeat.o(245877);
      return;
    }
    localObject = c.vCb;
    if (c.dvc()) {}
    for (paramg1.iOo = 1; i >= j; paramg1.iOo = 0)
    {
      final long l = System.currentTimeMillis();
      ufW = true;
      ((r)com.tencent.mm.kernel.g.af(r.class)).b(paramg1, (com.tencent.mm.plugin.appbrand.api.f)new b(paramg, paramg1, l));
      AppMethodBeat.o(245877);
      return;
    }
    if (1 > j)
    {
      AppMethodBeat.o(245877);
      return;
    }
    AppMethodBeat.o(245877);
  }
  
  public static void d(com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(245876);
    p.h(paramg, "bundle");
    Log.i(TAG, "[preLoadPkgAndEnv],username:" + paramg.username);
    if (Util.isNullOrNil(paramg.username))
    {
      Log.i(TAG, "[preLoadPkgAndEnv] fail, stack:" + Util.getStack());
      AppMethodBeat.o(245876);
      return;
    }
    ((w)com.tencent.mm.kernel.g.af(w.class)).bb(paramg.username, 4);
    ((com.tencent.mm.plugin.appbrand.service.f)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.appbrand.service.f.class)).a(z.nMK);
    ufU = true;
    ufV = true;
    AppMethodBeat.o(245876);
  }
  
  public static boolean deV()
  {
    return ufU;
  }
  
  public static boolean deW()
  {
    return ufV;
  }
  
  public static boolean deX()
  {
    return ufW;
  }
  
  public static int deY()
  {
    AppMethodBeat.i(245874);
    int i = ((Number)ufX.getValue()).intValue();
    AppMethodBeat.o(245874);
    return i;
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public final boolean a(com.tencent.mm.plugin.finder.live.viewmodel.g paramg)
  {
    int i = 1;
    AppMethodBeat.i(245875);
    Object localObject = m.vVH;
    if ((m.dBP()) || ((paramg != null) && (paramg.uEp == true)))
    {
      AppMethodBeat.o(245875);
      return true;
    }
    localObject = y.vXH;
    if (paramg != null) {}
    for (localObject = paramg.uEl;; localObject = null)
    {
      localObject = y.c((awc)localObject);
      if (!Util.isNullOrNil(((com.tencent.mm.plugin.appbrand.api.g)localObject).appId)) {
        break;
      }
      Log.i(TAG, "[checkPreRender] fail, appId:" + ((com.tencent.mm.plugin.appbrand.api.g)localObject).appId);
      AppMethodBeat.o(245875);
      return false;
    }
    r localr = (r)com.tencent.mm.kernel.g.af(r.class);
    String str = ((com.tencent.mm.plugin.appbrand.api.g)localObject).appId;
    c localc = c.vCb;
    if (c.dvc()) {}
    for (;;)
    {
      boolean bool = localr.bW(str, i);
      Log.i(TAG, "[checkPreRender] hasInstance:" + bool + ",appId:" + ((com.tencent.mm.plugin.appbrand.api.g)localObject).appId + ",patch:" + ((com.tencent.mm.plugin.appbrand.api.g)localObject).kHw);
      if (!bool) {
        a(paramg, (com.tencent.mm.plugin.appbrand.api.g)localObject);
      }
      if (paramg != null) {
        paramg.uEp = bool;
      }
      AppMethodBeat.o(245875);
      return bool;
      i = 0;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/live/MiniProgramPreloadHelper$preRender$1", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-finder_release"})
  public static final class b
    implements com.tencent.mm.plugin.appbrand.api.f
  {
    b(com.tencent.mm.plugin.finder.live.viewmodel.g paramg, com.tencent.mm.plugin.appbrand.api.g paramg1, long paramLong) {}
    
    public final void onError(int paramInt, String paramString)
    {
      AppMethodBeat.i(245873);
      h localh = h.ufY;
      Log.i(h.getTAG(), "prerender mini pro fail,errCode:" + paramInt + ",errMsg:" + paramString);
      if (this.uga != null)
      {
        paramString = j.ugg;
        j.a(this.uga, paramg1, l, System.currentTimeMillis());
      }
      AppMethodBeat.o(245873);
    }
    
    public final void onSuccess()
    {
      AppMethodBeat.i(245872);
      Object localObject = h.ufY;
      Log.i(h.getTAG(), "prerender mini pro success!");
      if (this.uga != null)
      {
        localObject = j.ugg;
        j.a(this.uga, paramg1, l, System.currentTimeMillis());
      }
      AppMethodBeat.o(245872);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.h
 * JD-Core Version:    0.7.0.1
 */