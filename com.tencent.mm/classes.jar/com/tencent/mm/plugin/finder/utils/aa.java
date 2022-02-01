package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.co.f;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ac;
import com.tencent.mm.plugin.i.a.af.a;
import com.tencent.mm.protocal.protobuf.eoy;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/FinderWxProfileManager;", "", "()V", "requestInterval", "", "getRequestInterval", "()I", "setRequestInterval", "(I)V", "requestTimeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "userPreviewInfoCache", "Lcom/tencent/mm/protocal/protobuf/UserPreviewInfo;", "getWxProfileInfo", "wxUsername", "lifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failedCallback", "resetRequestTime", "", "updateCacheLikeEntrance", "enable", "", "plugin-finder_release"})
public final class aa
{
  private static int ufh;
  private static final HashMap<String, Integer> vXj;
  private static final HashMap<String, eoy> vYh;
  public static final aa vYi;
  
  static
  {
    AppMethodBeat.i(253733);
    vYi = new aa();
    vYh = new HashMap();
    vXj = new HashMap();
    AppMethodBeat.o(253733);
  }
  
  public static void IV(int paramInt)
  {
    ufh = paramInt;
  }
  
  public static void awv(String paramString)
  {
    AppMethodBeat.i(253731);
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(253731);
      return;
    }
    ((Map)vXj).put(paramString, Integer.valueOf(0));
    AppMethodBeat.o(253731);
  }
  
  public static void aww(String paramString)
  {
    AppMethodBeat.i(253732);
    p.h(paramString, "wxUsername");
    paramString = (eoy)vYh.get(paramString);
    if (paramString != null)
    {
      paramString.LNI = 0;
      AppMethodBeat.o(253732);
      return;
    }
    AppMethodBeat.o(253732);
  }
  
  public static eoy b(String paramString, b<com.tencent.mm.vending.e.a> paramb, final af.a<Object> parama, final af.a<Integer> parama1)
  {
    AppMethodBeat.i(253730);
    p.h(paramb, "lifeCycle");
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      if (parama1 != null) {
        parama1.bn(Integer.valueOf(-1000));
      }
      AppMethodBeat.o(253730);
      return null;
    }
    Object localObject;
    if (p.j(paramString, z.aTY())) {
      localObject = Integer.valueOf(0);
    }
    for (;;)
    {
      p.g(localObject, "if (wxUsername == Config…tTimeMap[wxUsername] ?: 0");
      int i = ((Integer)localObject).intValue();
      if (cl.aWB() - i > ufh) {
        new ac(paramString).aYI().a(paramb).g((com.tencent.mm.vending.c.a)new a(paramString, parama, parama1));
      }
      paramString = (eoy)vYh.get(paramString);
      AppMethodBeat.o(253730);
      return paramString;
      Integer localInteger = (Integer)vXj.get(paramString);
      localObject = localInteger;
      if (localInteger == null) {
        localObject = Integer.valueOf(0);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderUserPagePreviewResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(String paramString, af.a parama1, af.a parama2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.aa
 * JD-Core Version:    0.7.0.1
 */