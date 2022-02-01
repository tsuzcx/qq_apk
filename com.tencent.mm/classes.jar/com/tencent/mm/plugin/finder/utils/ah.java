package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.mmdata.rpt.iu;
import com.tencent.mm.cp.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.finder.cgi.x;
import com.tencent.mm.plugin.findersdk.b.c;
import com.tencent.mm.protocal.protobuf.aka;
import com.tencent.mm.protocal.protobuf.bay;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.protocal.protobuf.bzc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.w.a.a.a.i;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.ah.f;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/utils/FinderProductShareUtil;", "", "()V", "TAG", "", "lastShareObject", "Lcom/tencent/mm/protocal/protobuf/FinderProductShareObject;", "getLastShareObject", "()Lcom/tencent/mm/protocal/protobuf/FinderProductShareObject;", "setLastShareObject", "(Lcom/tencent/mm/protocal/protobuf/FinderProductShareObject;)V", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "gen23782Params", "live_id", "live_status", "", "commodity_id", "to_username", "share_way", "commodity_status", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/String;", "generateFinderProductShareObject", "finderUsername", "objectId", "", "nonceId", "productInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWindowProductInfo;", "liveId", "getProduct", "key", "putProduct", "value", "report23782", "", "eventName", "params", "requestProductInfo", "context", "Landroid/content/Context;", "shareObject", "callback", "Lkotlin/Function5;", "structLog", "struct", "Lcom/tencent/mm/plugin/report/AbsReportStruct;", "fromLive", "", "logInfo", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
{
  public static final ah Ghp;
  private static bth Ghq;
  private static final String TAG;
  private static final ConcurrentHashMap<String, bth> evG;
  
  static
  {
    AppMethodBeat.i(333643);
    Ghp = new ah();
    TAG = "Finder.FinderProductShareUtil";
    evG = new ConcurrentHashMap();
    AppMethodBeat.o(333643);
  }
  
  public static bth a(String paramString1, long paramLong, String paramString2, bzc parambzc, String paramString3)
  {
    AppMethodBeat.i(333569);
    kotlin.g.b.s.u(paramString1, "finderUsername");
    kotlin.g.b.s.u(paramString2, "nonceId");
    kotlin.g.b.s.u(parambzc, "productInfo");
    kotlin.g.b.s.u(paramString3, "liveId");
    bth localbth = new bth();
    localbth.aabe = paramString3;
    localbth.finderUsername = paramString1;
    localbth.aabf = d.hF(paramLong);
    localbth.aabg = paramString2;
    localbth.aabh = "";
    paramString1 = parambzc.DVq;
    if (paramString1 == null)
    {
      paramString1 = "";
      localbth.appId = paramString1;
      paramString1 = parambzc.DVq;
      if (paramString1 != null) {
        break label286;
      }
      paramString1 = "";
      label107:
      localbth.hzy = paramString1;
      localbth.productId = d.hF(parambzc.DVk);
      paramString1 = parambzc.DVl;
      kotlin.g.b.s.s(paramString1, "productInfo.img_urls");
      paramString2 = (String)p.ae((List)paramString1, 0);
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localbth.coverUrl = paramString1;
      paramString2 = parambzc.title;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
      localbth.aabi = paramString1;
      localbth.aabj = parambzc.DVn;
      localbth.aabk = parambzc.DVo;
      parambzc = ((com.tencent.mm.plugin.appbrand.service.s)h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).Xz(localbth.appId);
      if (parambzc != null) {
        break label303;
      }
      paramString1 = "";
      label234:
      localbth.aabl = paramString1;
      if (parambzc != null) {
        break label321;
      }
      paramString1 = "";
    }
    for (;;)
    {
      localbth.ESn = paramString1;
      localbth.DGl = "";
      AppMethodBeat.o(333569);
      return localbth;
      paramString2 = paramString1.appid;
      paramString1 = paramString2;
      if (paramString2 != null) {
        break;
      }
      paramString1 = "";
      break;
      label286:
      paramString2 = paramString1.path;
      paramString1 = paramString2;
      if (paramString2 != null) {
        break label107;
      }
      paramString1 = "";
      break label107;
      label303:
      paramString2 = parambzc.field_bigHeadURL;
      paramString1 = paramString2;
      if (paramString2 != null) {
        break label234;
      }
      paramString1 = "";
      break label234;
      label321:
      paramString2 = parambzc.field_nickname;
      paramString1 = paramString2;
      if (paramString2 == null) {
        paramString1 = "";
      }
    }
  }
  
  public static String a(bth parambth)
  {
    AppMethodBeat.i(333546);
    kotlin.g.b.s.u(parambth, "value");
    Ghq = parambth;
    String str = d.hF(cn.bDu());
    evG.put(str, parambth);
    a(parambth, kotlin.g.b.s.X(TAG, "put"));
    AppMethodBeat.o(333546);
    return str;
  }
  
  private static final kotlin.ah a(bth parambth, kotlin.g.a.s params, b.a parama)
  {
    AppMethodBeat.i(333640);
    kotlin.g.b.s.u(parambth, "$shareObject");
    kotlin.g.b.s.u(params, "$callback");
    ah.f localf = new ah.f();
    localf.aqH = "";
    bzc localbzc;
    Object localObject;
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      localbzc = ((bay)parama.ott).ZLN;
      if (localbzc != null)
      {
        localObject = localbzc.DVq;
        if (localObject != null) {
          break label280;
        }
        localObject = "";
        parambth.appId = ((String)localObject);
        localObject = localbzc.DVq;
        if (localObject != null) {
          break label300;
        }
        localObject = "";
      }
    }
    for (;;)
    {
      parambth.hzy = ((String)localObject);
      parambth.productId = d.hF(localbzc.DVk);
      localObject = localbzc.DVl;
      kotlin.g.b.s.s(localObject, "productInfo.img_urls");
      String str = (String)p.ae((List)localObject, 0);
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      parambth.coverUrl = ((String)localObject);
      str = localbzc.title;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      parambth.aabi = ((String)localObject);
      parambth.aabj = localbzc.DVn;
      parambth.aabk = localbzc.DVo;
      str = localbzc.request_id;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localf.aqH = localObject;
      a(parambth, kotlin.g.b.s.X(TAG, "_requestProductInfoOk"));
      Log.i(TAG, kotlin.g.b.s.X("requestId:", localf.aqH));
      d.uiThread((kotlin.g.a.a)new ah.a(params, parama, localf));
      parambth = kotlin.ah.aiuX;
      AppMethodBeat.o(333640);
      return parambth;
      label280:
      str = ((aka)localObject).appid;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label300:
      str = ((aka)localObject).path;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  public static void a(Context paramContext, bth parambth, kotlin.g.a.s<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super String, kotlin.ah> params)
  {
    AppMethodBeat.i(333584);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parambth, "shareObject");
    kotlin.g.b.s.u(params, "callback");
    a(parambth, kotlin.g.b.s.X(TAG, "_requestProductInfo"));
    Object localObject2 = parambth.finderUsername;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    String str = parambth.aabf;
    localObject2 = str;
    if (str == null) {
      localObject2 = "0";
    }
    long l1 = d.FK((String)localObject2);
    str = parambth.productId;
    localObject2 = str;
    if (str == null) {
      localObject2 = "0";
    }
    long l2 = d.FK((String)localObject2);
    kotlin.g.b.s.u(parambth, "<this>");
    localObject2 = (CharSequence)parambth.aabe;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label217;
      }
      i = 1;
      label152:
      if (i == 0) {
        break label222;
      }
    }
    label217:
    label222:
    for (int i = 1;; i = 2)
    {
      new x((String)localObject1, l1, l2, i).e(paramContext, paramContext.getResources().getString(a.i.finder_waiting), 500L).bFJ().g(new ah..ExternalSyntheticLambda0(parambth, params));
      AppMethodBeat.o(333584);
      return;
      i = 0;
      break;
      i = 0;
      break label152;
    }
  }
  
  private static void a(bth parambth, String paramString)
  {
    AppMethodBeat.i(333596);
    kotlin.g.b.s.u(parambth, "<this>");
    kotlin.g.b.s.u(paramString, "TAG");
    Log.i(paramString, "FinderProductShareObject LogInfo, " + ", liveId:" + parambth.aabe + ", finderUsername:" + parambth.finderUsername + ", finderObjectID:" + parambth.aabf + ", finderNonceID: " + parambth.aabg);
    Log.i(paramString, "FinderProductShareObject LogInfo, " + ", appId:" + parambth.appId + ", pagePath:" + parambth.hzy + ", productId:" + parambth.productId);
    Log.i(paramString, "FinderProductShareObject LogInfo, " + ", productTitle:" + parambth.aabi + ", marketPrice:" + parambth.aabj + ", sellingPrice:" + parambth.aabk + ", coverUrl:" + parambth.coverUrl);
    Log.i(paramString, "FinderProductShareObject LogInfo, " + ", platformName:" + parambth.ESn + ", shopWindowId:" + parambth.DGl + ", platformHeadImg:" + parambth.aabl);
    AppMethodBeat.o(333596);
  }
  
  public static void a(bth parambth, String paramString1, String paramString2)
  {
    AppMethodBeat.i(333611);
    kotlin.g.b.s.u(parambth, "value");
    kotlin.g.b.s.u(paramString1, "eventName");
    kotlin.g.b.s.u(paramString2, "params");
    iu localiu = new iu();
    String str2 = parambth.aabe;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localiu.rU(str1);
    str2 = parambth.aabf;
    str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localiu.rV(str1);
    str1 = parambth.finderUsername;
    parambth = str1;
    if (str1 == null) {
      parambth = "";
    }
    localiu.rW(parambth);
    localiu.rX(paramString1);
    localiu.rY(n.m(paramString2, ",", ";", false));
    localiu.bMH();
    paramString2 = (com.tencent.mm.plugin.report.a)localiu;
    kotlin.g.b.s.u(paramString2, "struct");
    parambth = TAG;
    paramString1 = new StringBuilder("report").append(paramString2.getId()).append(' ');
    paramString2 = paramString2.aIF();
    kotlin.g.b.s.s(paramString2, "struct.toShowString()");
    Log.i(parambth, n.bV(paramString2, "\r\n", " "));
    AppMethodBeat.o(333611);
  }
  
  public static bth aBB(String paramString)
  {
    AppMethodBeat.i(333555);
    kotlin.g.b.s.u(paramString, "key");
    if ((bth)evG.get(paramString) == null) {
      Log.i(TAG, "getProduct key:" + paramString + ", result is null");
    }
    paramString = (bth)evG.get(paramString);
    AppMethodBeat.o(333555);
    return paramString;
  }
  
  public static String aBD(String paramString)
  {
    AppMethodBeat.i(333628);
    kotlin.g.b.s.u(paramString, "live_id");
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("live_id", paramString);
    localJSONObject.put("live_status", 1);
    paramString = localJSONObject.toString();
    kotlin.g.b.s.s(paramString, "json.toString()");
    AppMethodBeat.o(333628);
    return paramString;
  }
  
  public static String b(String paramString1, String paramString2, String paramString3, Integer paramInteger)
  {
    AppMethodBeat.i(333619);
    JSONObject localJSONObject = new JSONObject();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localJSONObject.put("commodity_id", str);
    if (paramString2 != null) {
      localJSONObject.put("to_username", paramString2);
    }
    if (paramString3 != null) {
      localJSONObject.put("share_way", paramString3);
    }
    if (paramInteger != null)
    {
      ((Number)paramInteger).intValue();
      localJSONObject.put("commodity_status", paramInteger.intValue());
    }
    paramString1 = localJSONObject.toString();
    kotlin.g.b.s.s(paramString1, "json.toString()");
    AppMethodBeat.o(333619);
    return paramString1;
  }
  
  public static bth ffh()
  {
    return Ghq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ah
 * JD-Core Version:    0.7.0.1
 */