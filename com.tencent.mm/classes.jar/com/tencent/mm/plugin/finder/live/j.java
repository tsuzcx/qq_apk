package com.tencent.mm.plugin.finder.live;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.live.model.x;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.Serializable;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/MiniProgramReportHelper;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "report21188", "", "liveData", "Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderLiveRoomData;", "bundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "luanchFromApp", "", "report21235", "report21237", "prewarmStartTime", "", "prewarmEndTime", "plugin-finder_release"})
public final class j
{
  private static final String TAG = "MiniProgramReportHelper";
  public static final j ugg;
  
  static
  {
    AppMethodBeat.i(245885);
    ugg = new j();
    TAG = "MiniProgramReportHelper";
    AppMethodBeat.o(245885);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.viewmodel.g paramg, com.tencent.mm.plugin.appbrand.api.g paramg1, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(245884);
    p.h(paramg, "liveData");
    p.h(paramg1, "bundle");
    Object localObject = k.vfA;
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    localObject = h.ufY;
    boolean bool1 = h.deV();
    localObject = h.ufY;
    boolean bool2 = h.deW();
    long l1 = paramg.liveInfo.liveId;
    String str2 = z.aUg();
    p.g(str2, "ConfigStorageLogic.getMyFinderUsername()");
    localObject = paramg.uEl;
    if (localObject != null)
    {
      String str1 = ((awc)localObject).vtD;
      localObject = str1;
      if (str1 != null) {}
    }
    else
    {
      localObject = "";
    }
    long l2 = paramg.sessionId;
    paramg1 = paramg1.appId;
    paramg = paramg1;
    if (paramg1 == null) {
      paramg = "";
    }
    k.a(localContext, bool1, bool2, String.valueOf(l1), str2, (String)localObject, String.valueOf(l2), paramLong1, paramLong2, paramg, "");
    AppMethodBeat.o(245884);
  }
  
  public static void a(com.tencent.mm.plugin.finder.live.viewmodel.g paramg, com.tencent.mm.plugin.appbrand.api.g paramg1, boolean paramBoolean)
  {
    AppMethodBeat.i(245883);
    p.h(paramg, "liveData");
    p.h(paramg1, "bundle");
    if (paramBoolean)
    {
      if ((Util.isNullOrNil(paramg.uEq)) && (!Util.isNullOrNil(paramg1.appId))) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        localObject1 = paramg1.kHx;
        if (localObject1 != null) {
          break;
        }
        paramg = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.WxLiveShoppingExtranData");
        AppMethodBeat.o(245883);
        throw paramg;
      }
      Object localObject3 = (x)localObject1;
      Object localObject1 = h.ufY;
      if (h.deX())
      {
        localObject1 = paramg.uEl;
        if (localObject1 != null)
        {
          localObject2 = ((awc)localObject1).LGH;
          localObject1 = localObject2;
          if (localObject2 != null) {
            break label125;
          }
        }
      }
      localObject1 = "";
      label125:
      p.g(localObject1, "if (MiniProgramPreloadHe…derPagePath ?: \"\" else \"\"");
      Object localObject2 = k.vfA;
      Context localContext = MMApplicationContext.getContext();
      p.g(localContext, "MMApplicationContext.getContext()");
      int i = ((x)localObject3).uks;
      localObject2 = ((x)localObject3).ukt;
      if (localObject2 != null) {}
      for (localObject2 = (Serializable)localObject2;; localObject2 = (Serializable)"")
      {
        String str1 = String.valueOf(localObject2);
        localObject3 = paramg1.appId;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        int j = paramg1.scene;
        paramg1 = h.ufY;
        boolean bool1 = h.deV();
        paramg1 = h.ufY;
        boolean bool2 = h.deW();
        long l = paramg.liveInfo.liveId;
        String str2 = z.aUg();
        p.g(str2, "ConfigStorageLogic.getMyFinderUsername()");
        paramg1 = paramg.uEl;
        if (paramg1 != null)
        {
          localObject3 = paramg1.vtD;
          paramg1 = (com.tencent.mm.plugin.appbrand.api.g)localObject3;
          if (localObject3 != null) {}
        }
        else
        {
          paramg1 = "";
        }
        k.a(localContext, paramBoolean, i, str1, (String)localObject2, j, (String)localObject1, bool1, bool2, String.valueOf(l), str2, paramg1, String.valueOf(paramg.sessionId));
        AppMethodBeat.o(245883);
        return;
      }
    }
    Log.i(TAG, "luanch from mini program!");
    AppMethodBeat.o(245883);
  }
  
  public static void b(com.tencent.mm.plugin.finder.live.viewmodel.g paramg, com.tencent.mm.plugin.appbrand.api.g paramg1)
  {
    AppMethodBeat.i(245882);
    p.h(paramg, "liveData");
    p.h(paramg1, "bundle");
    Object localObject1 = k.vfA;
    Context localContext = MMApplicationContext.getContext();
    p.g(localContext, "MMApplicationContext.getContext()");
    localObject1 = paramg1.appId;
    paramg1 = (com.tencent.mm.plugin.appbrand.api.g)localObject1;
    if (localObject1 == null) {
      paramg1 = "";
    }
    localObject1 = paramg.uEl;
    if (localObject1 != null)
    {
      localObject2 = ((awc)localObject1).LGH;
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    Object localObject2 = h.ufY;
    boolean bool1 = h.deV();
    localObject2 = h.ufY;
    boolean bool2 = h.deW();
    long l = paramg.liveInfo.liveId;
    String str2 = z.aUg();
    p.g(str2, "ConfigStorageLogic.getMyFinderUsername()");
    localObject2 = paramg.uEl;
    if (localObject2 != null)
    {
      String str1 = ((awc)localObject2).vtD;
      localObject2 = str1;
      if (str1 != null) {}
    }
    else
    {
      localObject2 = "";
    }
    k.a(localContext, paramg1, (String)localObject1, bool1, bool2, String.valueOf(l), str2, (String)localObject2, String.valueOf(paramg.sessionId));
    AppMethodBeat.o(245882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.j
 * JD-Core Version:    0.7.0.1
 */