package com.tencent.mm.plugin.finder.cgi;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.report.bd;
import com.tencent.mm.plugin.finder.storage.k;
import com.tencent.mm.protocal.protobuf.acx;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.aur;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lkotlin.r<Ljava.lang.Integer;Ljava.lang.Long;>;>;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/FinderBaseRequestFactory;", "", "()V", "TAG", "", "create", "Lcom/tencent/mm/protocal/protobuf/FinderBaseRequest;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "fillClientReportInfo", "udfKv", "commonReportInfo", "isEncode", "", "fillClientReportJson", "kvJson", "Lorg/json/JSONObject;", "fillFinderObjectBaseInfo", "", "finderBaseRequest", "list", "", "Lkotlin/Pair;", "", "", "generateClientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderClientStatus;", "getLiveIdentity", "optReportJson", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bi
{
  public static final bi ABn;
  
  static
  {
    AppMethodBeat.i(336511);
    ABn = new bi();
    AppMethodBeat.o(336511);
  }
  
  public static atz a(bui parambui)
  {
    AppMethodBeat.i(336471);
    atz localatz = new atz();
    Object localObject = k.FKi;
    k.a(localatz);
    localatz.ZEp = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcY, 0);
    localatz.ZEt = dVv();
    localatz.ZEs = new acx();
    if (parambui != null)
    {
      localatz.scene = parambui.AJo;
      localObject = localatz.ZEs;
      if (localObject != null) {
        ((acx)localObject).zIO = parambui.zIO;
      }
      localObject = localatz.ZEs;
      if (localObject != null) {
        ((acx)localObject).zIB = parambui.zIB;
      }
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("sessionId", parambui.sessionId);
      if (!Util.isNullOrNil(parambui.extraInfo)) {
        ((JSONObject)localObject).put("extraInfo", parambui.extraInfo);
      }
      if (!Util.isNullOrNil(parambui.zIE)) {
        ((JSONObject)localObject).put("enterSourceInfo", parambui.zIE);
      }
      if (!Util.isNullOrNil(parambui.DUN)) {
        ((JSONObject)localObject).put("jumpId", parambui.DUN);
      }
    }
    catch (Exception parambui)
    {
      label184:
      break label184;
    }
    parambui = localatz.ZEs;
    if (parambui != null) {
      parambui.Zlw = ((JSONObject)localObject).toString();
    }
    localatz.Bjl = cn.bDv();
    AppMethodBeat.o(336471);
    return localatz;
  }
  
  public static void a(atz paramatz, List<r<Integer, Long>> paramList, bui parambui)
  {
    AppMethodBeat.i(336487);
    s.u(paramList, "list");
    Iterator localIterator = ((Iterable)paramList).iterator();
    while (localIterator.hasNext())
    {
      r localr = (r)localIterator.next();
      bd localbd = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).q(((Number)localr.bsD).longValue(), ((Number)localr.bsC).intValue());
      label88:
      Object localObject;
      if (localbd == null)
      {
        paramList = null;
        if (paramList == null) {
          Log.e("Finder.BaseRequestFactory", "[fillFinderObjectBaseInfo] feed=" + com.tencent.mm.ae.d.hF(((Number)localr.bsD).longValue()) + " commentScene=" + ((Number)localr.bsC).intValue() + ' ' + Util.getStack());
        }
      }
      else
      {
        if (parambui != null)
        {
          String str = parambui.GSW;
          if (str != null)
          {
            bra localbra = localbd.FuM;
            localObject = localbd.FuM.ZZe;
            paramList = (List<r<Integer, Long>>)localObject;
            if (localObject == null) {
              paramList = "";
            }
            localbra.ZZe = hG(paramList, str);
          }
        }
        if (paramatz != null)
        {
          paramList = paramatz.ZEu;
          if (paramList != null) {
            paramList.add(localbd.FuM);
          }
        }
        localObject = new StringBuilder("fillFinderObjectBaseInfo: feedId = ").append(com.tencent.mm.ae.d.hF(localbd.FuM.id)).append(", exposeCnt = ").append(localbd.FuM.ZZd).append(", exposeTime = ").append(localbd.FuM.ZZc).append(", receiveTime = ").append(localbd.FuM.ZZb).append(", client_udf_kv = ").append(localbd.FuM.ZZe).append("commonExtraInfo = ");
        if (parambui != null) {
          break label360;
        }
      }
      label360:
      for (paramList = null;; paramList = parambui.GSW)
      {
        Log.i("Finder.BaseRequestFactory", paramList);
        paramList = ah.aiuX;
        break label88;
        break;
      }
    }
    AppMethodBeat.o(336487);
  }
  
  public static aur bTZ()
  {
    AppMethodBeat.i(336509);
    aur localaur = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).bTZ();
    AppMethodBeat.o(336509);
    return localaur;
  }
  
  public static atz dVu()
  {
    AppMethodBeat.i(336459);
    atz localatz = new atz();
    k localk = k.FKi;
    k.a(localatz);
    localatz.ZEp = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adcY, 0);
    localatz.ZEt = dVv();
    localatz.Bjl = cn.bDv();
    AppMethodBeat.o(336459);
    return localatz;
  }
  
  private static int dVv()
  {
    AppMethodBeat.i(336477);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbf, 0);
    if (i != 1)
    {
      Log.i("Finder.BaseRequestFactory", s.X("cgi, get isAssistant, ", Integer.valueOf(i)));
      i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adaO, 4);
      AppMethodBeat.o(336477);
      return i;
    }
    Log.i("Finder.BaseRequestFactory", "cgi, get isAssistant, 1");
    AppMethodBeat.o(336477);
    return i;
  }
  
  public static String hG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(336499);
    s.u(paramString1, "udfKv");
    s.u(paramString2, "commonReportInfo");
    if (Util.isNullOrNil(paramString2))
    {
      if (n.U(paramString1, "{", false))
      {
        paramString1 = paramString1.getBytes(kotlin.n.d.UTF_8);
        s.s(paramString1, "(this as java.lang.String).getBytes(charset)");
        paramString1 = Base64.encodeToString(paramString1, 2);
        s.s(paramString1, "{\n                Base64…64.NO_WRAP)\n            }");
        AppMethodBeat.o(336499);
        return paramString1;
      }
      AppMethodBeat.o(336499);
      return paramString1;
    }
    if (n.U(paramString1, "{", false))
    {
      paramString1 = k(new JSONObject(paramString1), paramString2);
      AppMethodBeat.o(336499);
      return paramString1;
    }
    try
    {
      if (!Util.isNullOrNil(paramString1))
      {
        paramString1 = Base64.decode(paramString1, 2);
        s.s(paramString1, "decode(udfKv, Base64.NO_WRAP)");
        paramString1 = k(new JSONObject(new String(paramString1, kotlin.n.d.UTF_8)), paramString2);
      }
      for (;;)
      {
        AppMethodBeat.o(336499);
        return paramString1;
        paramString1 = new JSONObject(paramString2).optJSONObject("clientReportInfo");
        if (paramString1 == null)
        {
          paramString1 = "";
        }
        else
        {
          paramString2 = paramString1.toString();
          paramString1 = paramString2;
          if (paramString2 == null) {
            paramString1 = "";
          }
        }
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        Log.printErrStackTrace("Finder.BaseRequestFactory", (Throwable)paramString1, "fillClientReportInfo", new Object[0]);
        paramString1 = "";
      }
    }
  }
  
  private static String k(JSONObject paramJSONObject, String paramString)
  {
    AppMethodBeat.i(336505);
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("clientReportInfo");
      if (paramString != null)
      {
        Iterator localIterator = paramString.keys();
        if (localIterator != null) {
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            paramJSONObject.put(str, paramString.get(str));
            continue;
            AppMethodBeat.o(336505);
          }
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      Log.printErrStackTrace("Finder.BaseRequestFactory", (Throwable)paramJSONObject, "fillClientReportJson", new Object[0]);
      paramJSONObject = "";
    }
    for (;;)
    {
      return paramJSONObject;
      paramJSONObject = paramJSONObject.toString();
      s.s(paramJSONObject, "{\n            val report…)\n            }\n        }");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bi
 * JD-Core Version:    0.7.0.1
 */