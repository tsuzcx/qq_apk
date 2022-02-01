package com.tencent.mm.plugin.finder.live;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.service.y;
import com.tencent.mm.plugin.finder.live.model.ay;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.q;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.boh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/MiniProgramPreloadHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "isPreEnv", "", "()Z", "setPreEnv", "(Z)V", "isPreHot", "setPreHot", "isPreload", "setPreload", "performanceLevel", "", "getPerformanceLevel", "()I", "performanceLevel$delegate", "Lkotlin/Lazy;", "checkPreRender", "", "liveData", "Lcom/tencent/mm/plugin/finder/live/model/context/LiveBuContext;", "preRender", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "preloadIfFail", "preRenderImpl", "preloadPkg", "prepareEnv", "reset", "tryToPreRender", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l Bxv;
  private static boolean Bxw;
  private static boolean Bxx;
  private static final j Bxy;
  private static final String TAG;
  private static boolean rsE;
  
  static
  {
    AppMethodBeat.i(350673);
    Bxv = new l();
    TAG = "MiniProgramPreloadHelper";
    Bxy = k.cm((kotlin.g.a.a)l.a.Bxz);
    AppMethodBeat.o(350673);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.model.context.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(350640);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (parama == null)
    {
      localObject1 = null;
      localObject1 = com.tencent.mm.plugin.finder.live.utils.a.a((boh)localObject1);
      if (localObject1 != null) {
        break label89;
      }
    }
    for (parama = (com.tencent.mm.plugin.finder.live.model.context.a)localObject2;; parama = ah.aiuX)
    {
      if (parama == null) {
        Log.i(TAG, "[checkPreRender] preRenderList is empty!");
      }
      AppMethodBeat.o(350640);
      return;
      localObject1 = (q)parama.business(q.class);
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((q)localObject1).Eia;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((bih)localObject1).ZRr;
      break;
      label89:
      localObject1 = ((Iterable)localObject1).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        localObject2 = (com.tencent.mm.plugin.appbrand.api.g)localObject2;
        if (Util.isNullOrNil(((com.tencent.mm.plugin.appbrand.api.g)localObject2).appId))
        {
          Log.i(TAG, "[checkPreRender] index:" + i + " fail, appId:" + ((com.tencent.mm.plugin.appbrand.api.g)localObject2).appId);
          AppMethodBeat.o(350640);
          return;
        }
        t localt = (t)h.ax(t.class);
        String str = ((com.tencent.mm.plugin.appbrand.api.g)localObject2).appId;
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        boolean bool = localt.cT(str, com.tencent.mm.plugin.finder.live.utils.a.bUq());
        Log.i(TAG, "[checkPreRender] index:" + i + " hasInstance:" + bool + ",appId:" + ((com.tencent.mm.plugin.appbrand.api.g)localObject2).appId + ",patch:" + ((com.tencent.mm.plugin.appbrand.api.g)localObject2).qAF);
        if (!bool) {
          a(parama, (com.tencent.mm.plugin.appbrand.api.g)localObject2);
        }
        i += 1;
      }
    }
  }
  
  private static void a(com.tencent.mm.plugin.finder.live.model.context.a parama, final com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(350631);
    Object localObject = paramg.qAG;
    if ((localObject instanceof ay))
    {
      localObject = (ay)localObject;
      if (localObject != null) {
        break label61;
      }
      localObject = null;
      label34:
      if (localObject != null) {
        break label74;
      }
      label39:
      if (localObject != null) {
        break label267;
      }
    }
    for (;;)
    {
      if (localObject == null)
      {
        AppMethodBeat.o(350631);
        return;
        localObject = null;
        break;
        label61:
        localObject = Integer.valueOf(((ay)localObject).CIJ);
        break label34;
        label74:
        if (((Integer)localObject).intValue() != 1) {
          break label39;
        }
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder("[preRender] performanceLevel:").append(((Number)Bxy.getValue()).intValue()).append(",appId:").append(paramg.appId).append(",patch:").append(paramg.qAF).append(",type:");
        com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        Log.i((String)localObject, com.tencent.mm.plugin.finder.live.utils.a.bUq() + ",preloadIfFail:false");
        if ((Util.isNullOrNil(paramg.appId)) || (Util.isNullOrNil(paramg.qAF)))
        {
          Log.i(TAG, s.X("[preRender] fail, stack:", Util.getStack()));
          AppMethodBeat.o(350631);
          return;
        }
        localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
        paramg.euz = com.tencent.mm.plugin.finder.live.utils.a.bUq();
        final long l = System.currentTimeMillis();
        Bxx = true;
        ((t)h.ax(t.class)).b(paramg, (f)new b(parama, paramg, l));
        AppMethodBeat.o(350631);
        return;
        label267:
        if (((Integer)localObject).intValue() == 2)
        {
          e(paramg);
          AppMethodBeat.o(350631);
          return;
        }
      }
    }
    if (((Integer)localObject).intValue() == 3)
    {
      e(paramg);
      ehk();
    }
    AppMethodBeat.o(350631);
  }
  
  private static void e(com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(350650);
    Log.i(TAG, "[preloadPkg],username:" + paramg.username + ",appId:" + paramg.appId + ",path:" + paramg.qAF);
    if ((Util.isNullOrNil(paramg.username)) && (Util.isNullOrNil(paramg.appId)))
    {
      Log.i(TAG, s.X("[preloadPkg] fail, stack:", Util.getStack()));
      AppMethodBeat.o(350650);
      return;
    }
    ((y)h.ax(y.class)).z(paramg.username, paramg.appId, 4);
    rsE = true;
    AppMethodBeat.o(350650);
  }
  
  public static boolean ehh()
  {
    return Bxw;
  }
  
  public static boolean ehi()
  {
    return rsE;
  }
  
  public static boolean ehj()
  {
    return Bxx;
  }
  
  private static void ehk()
  {
    AppMethodBeat.i(350645);
    Log.i(TAG, "[prepareEnv]");
    ((com.tencent.mm.plugin.appbrand.service.g)h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).a(ab.tTT);
    Bxw = true;
    AppMethodBeat.o(350645);
  }
  
  public static String getTAG()
  {
    return TAG;
  }
  
  public final void b(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.plugin.appbrand.api.g paramg)
  {
    AppMethodBeat.i(350678);
    s.u(paramg, "bundle");
    if (Util.isNullOrNil(paramg.appId))
    {
      Log.i(TAG, "[tryToPreRender] fail, appId is empty!");
      AppMethodBeat.o(350678);
      return;
    }
    t localt = (t)h.ax(t.class);
    String str = paramg.appId;
    com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    boolean bool = localt.cT(str, com.tencent.mm.plugin.finder.live.utils.a.bUq());
    Log.i(TAG, "[tryToPreRender] hasInstance:" + bool + ",appId:" + paramg.appId + ",patch:" + paramg.qAF);
    if (!bool) {
      a(parama, paramg);
    }
    AppMethodBeat.o(350678);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/MiniProgramPreloadHelper$preRender$1", "Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements f
  {
    b(com.tencent.mm.plugin.finder.live.model.context.a parama, com.tencent.mm.plugin.appbrand.api.g paramg, long paramLong) {}
    
    public final void onError(int paramInt, String paramString)
    {
      AppMethodBeat.i(350701);
      Object localObject = l.Bxv;
      Log.i(l.getTAG(), "prerender mini pro fail,errCode:" + paramInt + ",errMsg:" + paramString);
      if (this.BxD)
      {
        paramString = l.Bxv;
        l.f(paramg);
        paramString = l.Bxv;
        l.ehl();
      }
      if (this.BxA != null)
      {
        paramString = this.BxA;
        localObject = paramg;
        long l = l;
        n localn = n.BxF;
        n.a(paramString, (com.tencent.mm.plugin.appbrand.api.g)localObject, l, System.currentTimeMillis());
      }
      AppMethodBeat.o(350701);
    }
    
    public final void onSuccess()
    {
      AppMethodBeat.i(350690);
      Object localObject = l.Bxv;
      Log.i(l.getTAG(), "prerender mini pro success!");
      if (this.BxA != null)
      {
        localObject = this.BxA;
        com.tencent.mm.plugin.appbrand.api.g localg = paramg;
        long l = l;
        n localn = n.BxF;
        n.a((com.tencent.mm.plugin.finder.live.model.context.a)localObject, localg, l, System.currentTimeMillis());
      }
      AppMethodBeat.o(350690);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.l
 * JD-Core Version:    0.7.0.1
 */