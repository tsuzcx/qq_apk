package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.appbrand.service.z;
import com.tencent.mm.plugin.finder.live.model.at;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/MiniProgramPreloadHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isPreEnv", "", "()Z", "setPreEnv", "(Z)V", "isPreHot", "setPreHot", "isPreload", "setPreload", "performanceLevel", "", "getPerformanceLevel", "()I", "performanceLevel$delegate", "Lkotlin/Lazy;", "checkPreRender", "", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "preRender", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "preloadIfFail", "preRenderImpl", "preloadPkg", "prepareEnv", "reset", "tryToPreRender", "plugin-finder_release"})
public final class s
{
  private static final String TAG = "MiniProgramPreloadHelper";
  private static boolean ooW;
  private static boolean xWD;
  private static boolean xWE;
  private static final kotlin.f xWF;
  public static final s xWG;
  
  static
  {
    AppMethodBeat.i(275436);
    xWG = new s();
    TAG = "MiniProgramPreloadHelper";
    xWF = kotlin.g.ar((kotlin.g.a.a)s.a.xWH);
    AppMethodBeat.o(275436);
  }
  
  private static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    StringBuilder localStringBuilder = null;
    AppMethodBeat.i(275429);
    Object localObject2 = paramg.nBr;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof at)) {
      localObject1 = null;
    }
    localObject2 = (at)localObject1;
    localObject1 = localStringBuilder;
    if (localObject2 != null) {
      localObject1 = Integer.valueOf(((at)localObject2).yiF);
    }
    if (localObject1 == null) {
      if (localObject1 != null) {
        break label298;
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(275429);
        return;
        if (((Integer)localObject1).intValue() != 1) {
          break;
        }
        int i = ((Number)xWF.getValue()).intValue();
        localObject1 = com.tencent.c.a.a.a.a.a.Zlt;
        int j = com.tencent.c.a.a.a.a.a.imP();
        localObject1 = TAG;
        localStringBuilder = new StringBuilder("[preRender] performanceLevel:").append(i).append(",threshold:").append(j).append(",appId:").append(paramg.appId).append(",patch:").append(paramg.nBq).append(",type:");
        localObject2 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        Log.i((String)localObject1, com.tencent.mm.plugin.finder.live.utils.a.dEO() + ",preloadIfFail:false");
        if ((Util.isNullOrNil(paramg.appId)) || (Util.isNullOrNil(paramg.nBq)))
        {
          Log.i(TAG, "[preRender] fail, stack:" + Util.getStack());
          AppMethodBeat.o(275429);
          return;
        }
        localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
        paramg.cBU = com.tencent.mm.plugin.finder.live.utils.a.dEO();
        long l = System.currentTimeMillis();
        xWE = true;
        ((r)h.ae(r.class)).b(paramg, (com.tencent.mm.plugin.appbrand.api.f)new s.b(parama, paramg, l));
        AppMethodBeat.o(275429);
        return;
        label298:
        if (((Integer)localObject1).intValue() == 2)
        {
          d(paramg);
          AppMethodBeat.o(275429);
          return;
        }
      }
    }
    if (((Integer)localObject1).intValue() == 3)
    {
      d(paramg);
      dwS();
    }
    AppMethodBeat.o(275429);
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    AppMethodBeat.i(275430);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.yRm;
    int i;
    if (parama != null)
    {
      localObject1 = (com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)parama.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.j.class);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.finder.live.viewmodel.data.business.j)localObject1).ziI;
        localObject1 = ((Iterable)com.tencent.mm.plugin.finder.live.utils.a.a((azy)localObject1)).iterator();
        i = 0;
      }
    }
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label249;
      }
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      localObject2 = (com.tencent.mm.plugin.appbrand.api.g)localObject2;
      if (Util.isNullOrNil(((com.tencent.mm.plugin.appbrand.api.g)localObject2).appId))
      {
        Log.i(TAG, "[checkPreRender] index:" + i + " fail, appId:" + ((com.tencent.mm.plugin.appbrand.api.g)localObject2).appId);
        AppMethodBeat.o(275430);
        return;
        localObject1 = null;
        break;
      }
      r localr = (r)h.ae(r.class);
      String str = ((com.tencent.mm.plugin.appbrand.api.g)localObject2).appId;
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      boolean bool = localr.cu(str, com.tencent.mm.plugin.finder.live.utils.a.dEO());
      Log.i(TAG, "[checkPreRender] index:" + i + " hasInstance:" + bool + ",appId:" + ((com.tencent.mm.plugin.appbrand.api.g)localObject2).appId + ",patch:" + ((com.tencent.mm.plugin.appbrand.api.g)localObject2).nBq);
      if (!bool) {
        a(parama, (com.tencent.mm.plugin.appbrand.api.g)localObject2);
      }
      i += 1;
    }
    label249:
    AppMethodBeat.o(275430);
  }
  
  private static void d(com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(275433);
    Log.i(TAG, "[preloadPkg],username:" + paramg.username + ",appId:" + paramg.appId + ",path:" + paramg.nBq);
    if ((Util.isNullOrNil(paramg.username)) && (Util.isNullOrNil(paramg.appId)))
    {
      Log.i(TAG, "[preloadPkg] fail, stack:" + Util.getStack());
      AppMethodBeat.o(275433);
      return;
    }
    ((w)h.ae(w.class)).t(paramg.username, paramg.appId, 4);
    ooW = true;
    AppMethodBeat.o(275433);
  }
  
  public static boolean dwP()
  {
    return xWD;
  }
  
  public static boolean dwQ()
  {
    return ooW;
  }
  
  public static boolean dwR()
  {
    return xWE;
  }
  
  private static void dwS()
  {
    AppMethodBeat.i(275431);
    Log.i(TAG, "[prepareEnv]");
    ((com.tencent.mm.plugin.appbrand.service.f)h.ae(com.tencent.mm.plugin.appbrand.service.f.class)).a(z.qPc);
    xWD = true;
    AppMethodBeat.o(275431);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.s
 * JD-Core Version:    0.7.0.1
 */