package com.tencent.mm.plugin.finder.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.plugin.findersdk.a.ca.a;
import com.tencent.mm.protocal.protobuf.azh;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fvk;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.e.a;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderWxProfileManager;", "", "()V", "requestInterval", "", "getRequestInterval", "()I", "setRequestInterval", "(I)V", "requestTimeMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "userPreviewInfoCache", "Lcom/tencent/mm/protocal/protobuf/UserPreviewInfo;", "doRequest", "", "userpreview", "Lcom/tencent/mm/wx/WxPipeline;", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/FinderUserPagePreviewResponse;", "username", "succCallback", "Lcom/tencent/mm/plugin/findersdk/api/IFinderUtilApi$Callback;", "failedCallback", "getOpenIMProfileInfo", "openimUsername", "lifeCycle", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "forceRequest", "", "getWxProfileInfo", "wxUsername", "contactType", "getWxProfileInfo2", "onSuccess", "Lkotlin/Function1;", "onError", "resetRequestTime", "updateCacheLikeEntrance", "enable", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ay
{
  private static int BvC;
  private static final HashMap<String, Integer> Giu;
  public static final ay Gjp;
  private static final HashMap<String, fvk> Gjq;
  
  static
  {
    AppMethodBeat.i(333081);
    Gjp = new ay();
    Gjq = new HashMap();
    Giu = new HashMap();
    AppMethodBeat.o(333081);
  }
  
  public static fvk a(String paramString, com.tencent.mm.vending.e.b<a> paramb, ca.a<Object> parama, ca.a<Integer> parama1, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(333018);
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      if (parama1 != null) {
        parama1.onCallback(Integer.valueOf(-1000));
      }
      AppMethodBeat.o(333018);
      return null;
    }
    Object localObject;
    if (s.p(paramString, z.bAM()))
    {
      localObject = Integer.valueOf(0);
      int i = ((Number)localObject).intValue();
      if (paramBoolean) {
        i = 0;
      }
      if (cn.getSyncServerTimeSecond() - i > BvC) {
        if (paramb == null) {
          break label170;
        }
      }
    }
    label170:
    for (paramb = new at(paramString, paramInt, "").bFJ().a(paramb);; paramb = new at(paramString, paramInt, "").bFJ())
    {
      s.s(paramb, "userpreview");
      a(paramb, paramString, parama, parama1);
      paramString = (fvk)Gjq.get(paramString);
      AppMethodBeat.o(333018);
      return paramString;
      Integer localInteger = (Integer)Giu.get(paramString);
      localObject = localInteger;
      if (localInteger != null) {
        break;
      }
      localObject = Integer.valueOf(0);
      break;
    }
  }
  
  private static final ah a(String paramString, ca.a parama1, ca.a parama2, b.a parama)
  {
    AppMethodBeat.i(333075);
    s.u(paramString, "$username");
    if (((parama.errType == 0) && (parama.errCode == 0)) || (parama.errCode == -5700) || (parama.errCode == -5701))
    {
      fvk localfvk = new fvk();
      localfvk.contact = ((bym)parama.ott).contact;
      localfvk.aahh = ((bym)parama.ott).aahh;
      localfvk.ZIQ = ((bym)parama.ott).ZIQ;
      localfvk.aahj = ((bym)parama.ott).aahj;
      localfvk.aahk = ((bym)parama.ott).aahk;
      parama2 = localfvk.aahk;
      if (parama2 == null)
      {
        parama2 = null;
        if (parama2 == null)
        {
          parama2 = localfvk.aahk;
          if (parama2 != null) {
            break label315;
          }
          parama2 = null;
          label157:
          if (parama2 != null)
          {
            etl localetl = new etl();
            localetl.btH("");
            ah localah = ah.aiuX;
            parama2.akjO = localetl;
          }
        }
        ((Map)Gjq).put(paramString, localfvk);
        BvC = ((bym)parama.ott).aahi;
        if (parama1 != null) {
          parama1.onCallback(localfvk);
        }
      }
    }
    for (;;)
    {
      if (((parama.errType == 0) && (parama.errCode == 0)) || (parama.errCode == -5700) || (parama.errCode == -5701)) {
        ((Map)Giu).put(paramString, Integer.valueOf(cn.getSyncServerTimeSecond()));
      }
      paramString = ah.aiuX;
      AppMethodBeat.o(333075);
      return paramString;
      parama2 = parama2.BaseResponse;
      if (parama2 == null)
      {
        parama2 = null;
        break;
      }
      parama2 = parama2.akjO;
      break;
      label315:
      parama2 = parama2.BaseResponse;
      break label157;
      if (parama2 != null) {
        parama2.onCallback(Integer.valueOf(parama.errCode));
      }
    }
  }
  
  private static void a(f<b.a<bym>> paramf, String paramString, ca.a<Object> parama, ca.a<Integer> parama1)
  {
    AppMethodBeat.i(333044);
    paramf.g(new ay..ExternalSyntheticLambda2(paramString, parama, parama1));
    AppMethodBeat.o(333044);
  }
  
  public static void a(String paramString, com.tencent.mm.vending.e.b<a> paramb, kotlin.g.a.b<? super fvk, ah> paramb1, kotlin.g.a.b<? super Integer, ah> paramb2, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(333031);
    s.u(paramb, "lifeCycle");
    s.u(paramb1, "onSuccess");
    s.u(paramb2, "onError");
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      paramb2.invoke(Integer.valueOf(-1000));
      AppMethodBeat.o(333031);
      return;
    }
    Object localObject;
    if (s.p(paramString, z.bAM())) {
      localObject = Integer.valueOf(0);
    }
    for (;;)
    {
      paramInt = ((Number)localObject).intValue();
      if (cn.getSyncServerTimeSecond() - paramInt <= BvC) {
        break;
      }
      paramb = new at(paramString, 0, "").bFJ().a(paramb);
      s.s(paramb, "request");
      a(paramb, paramString, new ay..ExternalSyntheticLambda1(paramb1, paramb2), new ay..ExternalSyntheticLambda0(paramb2));
      AppMethodBeat.o(333031);
      return;
      Integer localInteger = (Integer)Giu.get(paramString);
      localObject = localInteger;
      if (localInteger == null) {
        localObject = Integer.valueOf(0);
      }
    }
    paramString = (fvk)Gjq.get(paramString);
    if (paramString != null)
    {
      paramb1.invoke(paramString);
      AppMethodBeat.o(333031);
      return;
    }
    paramb2.invoke(Integer.valueOf(-100));
    AppMethodBeat.o(333031);
  }
  
  private static final void a(kotlin.g.a.b paramb1, kotlin.g.a.b paramb2, Object paramObject)
  {
    AppMethodBeat.i(333058);
    s.u(paramb1, "$onSuccess");
    s.u(paramb2, "$onError");
    if ((paramObject instanceof fvk))
    {
      paramb1.invoke(paramObject);
      AppMethodBeat.o(333058);
      return;
    }
    paramb2.invoke(Integer.valueOf(-1001));
    AppMethodBeat.o(333058);
  }
  
  public static void aBY(String paramString)
  {
    AppMethodBeat.i(333048);
    if ((paramString == null) || (Util.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(333048);
      return;
    }
    ((Map)Giu).put(paramString, Integer.valueOf(0));
    AppMethodBeat.o(333048);
  }
  
  public static void aBZ(String paramString)
  {
    AppMethodBeat.i(333052);
    s.u(paramString, "wxUsername");
    paramString = (fvk)Gjq.get(paramString);
    if (paramString != null) {
      paramString.aahj = 0;
    }
    AppMethodBeat.o(333052);
  }
  
  private static final void b(kotlin.g.a.b paramb, Integer paramInteger)
  {
    AppMethodBeat.i(333064);
    s.u(paramb, "$onError");
    s.s(paramInteger, "it");
    paramb.invoke(paramInteger);
    AppMethodBeat.o(333064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ay
 * JD-Core Version:    0.7.0.1
 */