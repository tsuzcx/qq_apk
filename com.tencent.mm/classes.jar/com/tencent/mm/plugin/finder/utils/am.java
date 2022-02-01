package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.model.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ad;
import com.tencent.mm.plugin.findersdk.a.ag.a;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.ezi;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.b;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/utils/FinderWxProfileManager;", "", "()V", "requestInterval", "", "getRequestInterval", "()I", "setRequestInterval", "(I)V", "requestTimeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "userPreviewInfoCache", "Lcom/tencent/mm/protocal/protobuf/UserPreviewInfo;", "doRequest", "", "userpreview", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderUserPagePreviewResponse;", "username", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failedCallback", "getOpenIMProfileInfo", "openimUsername", "lifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "forceRequest", "", "getWxProfileInfo", "wxUsername", "contactType", "resetRequestTime", "updateCacheLikeEntrance", "enable", "plugin-finder_release"})
public final class am
{
  private static final HashMap<String, Integer> AFB;
  private static final HashMap<String, ezi> AGQ;
  public static final am AGR;
  private static int xUB;
  
  static
  {
    AppMethodBeat.i(269788);
    AGR = new am();
    AGQ = new HashMap();
    AFB = new HashMap();
    AppMethodBeat.o(269788);
  }
  
  public static void MT(int paramInt)
  {
    xUB = paramInt;
  }
  
  public static ezi a(String paramString, b<com.tencent.mm.vending.e.a> paramb, ag.a<Object> parama, ag.a<Integer> parama1, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(269782);
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      if (parama1 != null) {
        parama1.aH(Integer.valueOf(-1000));
      }
      AppMethodBeat.o(269782);
      return null;
    }
    Object localObject;
    if (p.h(paramString, z.bcZ()))
    {
      localObject = Integer.valueOf(0);
      p.j(localObject, "if (wxUsername == Config…tTimeMap[wxUsername] ?: 0");
      int i = ((Integer)localObject).intValue();
      if (paramBoolean) {
        i = 0;
      }
      if (cm.bfF() - i > xUB) {
        if (paramb == null) {
          break label174;
        }
      }
    }
    label174:
    for (paramb = new ad(paramString, paramInt, "").bhW().a(paramb);; paramb = new ad(paramString, paramInt, "").bhW())
    {
      p.j(paramb, "userpreview");
      a(paramb, paramString, parama, parama1);
      paramString = (ezi)AGQ.get(paramString);
      AppMethodBeat.o(269782);
      return paramString;
      Integer localInteger = (Integer)AFB.get(paramString);
      localObject = localInteger;
      if (localInteger != null) {
        break;
      }
      localObject = Integer.valueOf(0);
      break;
    }
  }
  
  private static void a(f<c.a<bla>> paramf, String paramString, final ag.a<Object> parama, final ag.a<Integer> parama1)
  {
    AppMethodBeat.i(269785);
    paramf.g((com.tencent.mm.vending.c.a)new a(paramString, parama, parama1));
    AppMethodBeat.o(269785);
  }
  
  public static void aFX(String paramString)
  {
    AppMethodBeat.i(269786);
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(269786);
      return;
    }
    ((Map)AFB).put(paramString, Integer.valueOf(0));
    AppMethodBeat.o(269786);
  }
  
  public static void aFY(String paramString)
  {
    AppMethodBeat.i(269787);
    p.k(paramString, "wxUsername");
    paramString = (ezi)AGQ.get(paramString);
    if (paramString != null)
    {
      paramString.SVT = 0;
      AppMethodBeat.o(269787);
      return;
    }
    AppMethodBeat.o(269787);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderUserPagePreviewResponse;", "kotlin.jvm.PlatformType", "call"})
  static final class a<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    a(String paramString, ag.a parama1, ag.a parama2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.am
 * JD-Core Version:    0.7.0.1
 */