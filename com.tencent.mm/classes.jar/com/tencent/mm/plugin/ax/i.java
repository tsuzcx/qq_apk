package com.tencent.mm.plugin.ax;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.webkit.JavascriptInterface;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.z;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.af.r;
import com.tencent.mm.plugin.appbrand.af.r.a;
import com.tencent.mm.plugin.webview.k.j.a;
import com.tencent.mm.protocal.protobuf.oy;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMSlotKt;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.k;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/WxJsEngineAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;)V", "dump", "", "tag", "", "data", "dumpToFile", "", "dumpFileName", "content", "getLogLevel", "", "getNetWorkType", "getPlatform", "getSystemInfo", "idkey", "id", "", "key", "value", "idkeyList", "kv", "reportCgi", "businessId", "", "reqJson", "callback", "userAgent", "Companion", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends a<c>
{
  public static final a WlJ;
  private static final String WlK;
  private static final kotlin.j<com.tencent.mm.plugin.webview.k.j> vTp;
  
  static
  {
    AppMethodBeat.i(260828);
    WlJ = new a((byte)0);
    vTp = k.cm((kotlin.g.a.a)b.WlL);
    WlK = s.X(com.tencent.mm.loader.i.b.bmz(), "jsengine/trace/");
    AppMethodBeat.o(260828);
  }
  
  public i(c paramc)
  {
    super("wxJsEngine", (b)paramc);
    AppMethodBeat.i(260795);
    AppMethodBeat.o(260795);
  }
  
  private static final int a(i parami, String paramString1, int paramInt1, int paramInt2, String paramString2, com.tencent.mm.am.c paramc, p paramp)
  {
    AppMethodBeat.i(260813);
    s.u(parami, "this$0");
    s.u(paramString1, "$callback");
    s.u(paramc, "rr");
    s.u(paramp, "$noName_4");
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      parami = (c)parami.WlE;
      paramString2 = new com.tencent.mm.ad.i();
      paramString2.au("err_code", paramInt2);
      paramString2.m("err_msg", "fail");
      paramc = ah.aiuX;
      paramString2 = paramString2.toString();
      s.s(paramString2, "JSONObject().apply {\n   …             }.toString()");
      c.a.a(parami, paramString1, paramString2, null, 4);
      AppMethodBeat.o(260813);
      return 0;
    }
    paramString2 = c.c.b(paramc.otC);
    if ((paramString2 instanceof oz)) {}
    for (paramString2 = (oz)paramString2; paramString2 == null; paramString2 = null)
    {
      AppMethodBeat.o(260813);
      return 0;
    }
    Log.i(parami.getTAG(), s.X("reportCgi resp_json=", paramString2.Kuf));
    paramc = (c)parami.WlE;
    paramString2 = paramString2.Kuf;
    parami = paramString2;
    if (paramString2 == null) {
      parami = "null";
    }
    c.a.a(paramc, paramString1, parami, null, 4);
    AppMethodBeat.o(260813);
    return 0;
  }
  
  /* Error */
  private final boolean eZ(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 212
    //   5: invokestatic 67	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 218	com/tencent/mm/compatible/util/e:aPU	()Z
    //   11: ifne +19 -> 30
    //   14: aload_0
    //   15: invokevirtual 195	com/tencent/mm/plugin/ax/i:getTAG	()Ljava/lang/String;
    //   18: ldc 220
    //   20: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc 212
    //   25: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: iconst_0
    //   29: ireturn
    //   30: aconst_null
    //   31: astore 7
    //   33: aconst_null
    //   34: astore 6
    //   36: aload 7
    //   38: astore 5
    //   40: new 225	com/tencent/mm/vfs/u
    //   43: dup
    //   44: getstatic 112	com/tencent/mm/plugin/ax/i:WlK	Ljava/lang/String;
    //   47: invokespecial 228	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   50: astore 8
    //   52: aload 7
    //   54: astore 5
    //   56: aload 8
    //   58: invokevirtual 231	com/tencent/mm/vfs/u:jKS	()Z
    //   61: ifne +13 -> 74
    //   64: aload 7
    //   66: astore 5
    //   68: aload 8
    //   70: invokevirtual 234	com/tencent/mm/vfs/u:jKY	()Z
    //   73: pop
    //   74: aload 7
    //   76: astore 5
    //   78: new 236	com/tencent/mm/vfs/ac
    //   81: dup
    //   82: new 225	com/tencent/mm/vfs/u
    //   85: dup
    //   86: aload 8
    //   88: aload_1
    //   89: invokespecial 239	com/tencent/mm/vfs/u:<init>	(Lcom/tencent/mm/vfs/u;Ljava/lang/String;)V
    //   92: iconst_0
    //   93: invokespecial 242	com/tencent/mm/vfs/ac:<init>	(Lcom/tencent/mm/vfs/u;Z)V
    //   96: astore_1
    //   97: aload_1
    //   98: aload_2
    //   99: invokevirtual 245	com/tencent/mm/vfs/ac:write	(Ljava/lang/String;)V
    //   102: iconst_1
    //   103: istore_3
    //   104: aload_1
    //   105: invokevirtual 248	com/tencent/mm/vfs/ac:close	()V
    //   108: ldc 212
    //   110: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iload_3
    //   114: ireturn
    //   115: astore_1
    //   116: aload_0
    //   117: invokevirtual 195	com/tencent/mm/plugin/ax/i:getTAG	()Ljava/lang/String;
    //   120: ldc 250
    //   122: aload_1
    //   123: invokestatic 110	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   126: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: goto -21 -> 108
    //   132: astore_2
    //   133: aload 6
    //   135: astore_1
    //   136: aload_1
    //   137: astore 5
    //   139: aload_0
    //   140: invokevirtual 195	com/tencent/mm/plugin/ax/i:getTAG	()Ljava/lang/String;
    //   143: ldc 252
    //   145: aload_2
    //   146: invokestatic 110	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   149: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: iload 4
    //   154: istore_3
    //   155: aload_1
    //   156: ifnull -48 -> 108
    //   159: aload_1
    //   160: invokevirtual 248	com/tencent/mm/vfs/ac:close	()V
    //   163: iload 4
    //   165: istore_3
    //   166: goto -58 -> 108
    //   169: astore_1
    //   170: aload_0
    //   171: invokevirtual 195	com/tencent/mm/plugin/ax/i:getTAG	()Ljava/lang/String;
    //   174: ldc 250
    //   176: aload_1
    //   177: invokestatic 110	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   180: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: iload 4
    //   185: istore_3
    //   186: goto -78 -> 108
    //   189: astore_1
    //   190: aload 5
    //   192: ifnull +8 -> 200
    //   195: aload 5
    //   197: invokevirtual 248	com/tencent/mm/vfs/ac:close	()V
    //   200: ldc 212
    //   202: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   205: aload_1
    //   206: athrow
    //   207: astore_2
    //   208: aload_0
    //   209: invokevirtual 195	com/tencent/mm/plugin/ax/i:getTAG	()Ljava/lang/String;
    //   212: ldc 250
    //   214: aload_2
    //   215: invokestatic 110	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   218: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: goto -21 -> 200
    //   224: astore_2
    //   225: aload_1
    //   226: astore 5
    //   228: aload_2
    //   229: astore_1
    //   230: goto -40 -> 190
    //   233: astore_2
    //   234: goto -98 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	i
    //   0	237	1	paramString1	String
    //   0	237	2	paramString2	String
    //   103	83	3	bool1	boolean
    //   1	183	4	bool2	boolean
    //   38	189	5	localObject1	Object
    //   34	100	6	localObject2	Object
    //   31	44	7	localObject3	Object
    //   50	37	8	localu	com.tencent.mm.vfs.u
    // Exception table:
    //   from	to	target	type
    //   104	108	115	java/lang/Exception
    //   40	52	132	java/lang/Exception
    //   56	64	132	java/lang/Exception
    //   68	74	132	java/lang/Exception
    //   78	97	132	java/lang/Exception
    //   159	163	169	java/lang/Exception
    //   40	52	189	finally
    //   56	64	189	finally
    //   68	74	189	finally
    //   78	97	189	finally
    //   139	152	189	finally
    //   195	200	207	java/lang/Exception
    //   97	102	224	finally
    //   97	102	233	java/lang/Exception
  }
  
  @JavascriptInterface
  public final void dump(String paramString1, String paramString2)
  {
    AppMethodBeat.i(260889);
    s.u(paramString1, "tag");
    s.u(paramString2, "data");
    if (!WeChatEnvironment.hasDebugger())
    {
      Log.w(getTAG(), "try to dump data without debugger");
      AppMethodBeat.o(260889);
      return;
    }
    paramString1 = "CPU_" + paramString1 + '_' + MMSlotKt.now() + ".cpuprofile";
    if (eZ(paramString1, paramString2))
    {
      paramString1 = s.X(WlK, paramString1);
      a.adc(s.X(paramString1, " exported."));
      Log.i(getTAG(), s.X(paramString1, " exported."));
      AppMethodBeat.o(260889);
      return;
    }
    a.adc(s.X(paramString1, " export failed!"));
    Log.e(getTAG(), s.X(paramString1, " export failed!"));
    AppMethodBeat.o(260889);
  }
  
  @JavascriptInterface
  public final int getLogLevel()
  {
    AppMethodBeat.i(260873);
    int i = Log.getLogLevel();
    AppMethodBeat.o(260873);
    return i;
  }
  
  @JavascriptInterface
  public final String getNetWorkType()
  {
    AppMethodBeat.i(260901);
    Object localObject2 = MMApplicationContext.getContext();
    if (!NetStatusUtil.isConnected((Context)localObject2))
    {
      Log.i(getTAG(), "getNetworkType, not connected");
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("networkType", "none");
      localObject1 = ((JSONObject)localObject1).toString();
      s.s(localObject1, "JSONObject().apply { put…pe\", \"none\") }.toString()");
      AppMethodBeat.o(260901);
      return localObject1;
    }
    Object localObject1 = (com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.misc.a.a.class);
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label220;
      }
      label86:
      if (localObject1 != null) {
        break label235;
      }
      label90:
      localObject1 = Integer.valueOf(2);
    }
    for (;;)
    {
      int i = NetStatusUtil.getNetType((Context)localObject2);
      Log.i(getTAG(), "getNetworkType, type = " + i + ", simType = " + localObject1);
      if (!NetStatusUtil.is2G((Context)localObject2)) {
        break label251;
      }
      Log.i(getTAG(), "getNetworkType, 2g");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "2g");
      ((JSONObject)localObject2).put("simtype", ((Number)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      s.s(localObject1, "JSONObject().apply {\n   …\n            }.toString()");
      AppMethodBeat.o(260901);
      return localObject1;
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.misc.a.a)localObject1).aaG(16));
      break;
      label220:
      if (((Integer)localObject1).intValue() != 0) {
        break label86;
      }
      localObject1 = Integer.valueOf(0);
      continue;
      label235:
      if (((Integer)localObject1).intValue() != 1) {
        break label90;
      }
      localObject1 = Integer.valueOf(1);
    }
    label251:
    if (NetStatusUtil.is3G((Context)localObject2))
    {
      Log.i(getTAG(), "getNetworkType, 3g");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "3g");
      ((JSONObject)localObject2).put("simtype", ((Number)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      s.s(localObject1, "JSONObject().apply {\n   …\n            }.toString()");
      AppMethodBeat.o(260901);
      return localObject1;
    }
    if (NetStatusUtil.is4G((Context)localObject2))
    {
      Log.i(getTAG(), "getNetworkType, 4g");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "4g");
      ((JSONObject)localObject2).put("simtype", ((Number)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      s.s(localObject1, "JSONObject().apply {\n   …\n            }.toString()");
      AppMethodBeat.o(260901);
      return localObject1;
    }
    if (NetStatusUtil.is5G((Context)localObject2))
    {
      Log.i(getTAG(), "getNetworkType, 5g");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "5g");
      ((JSONObject)localObject2).put("simtype", ((Number)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      s.s(localObject1, "JSONObject().apply {\n   …\n            }.toString()");
      AppMethodBeat.o(260901);
      return localObject1;
    }
    if (NetStatusUtil.isWifi((Context)localObject2))
    {
      Log.i(getTAG(), "getNetworkType, wifi");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "wifi");
      ((JSONObject)localObject2).put("simtype", ((Number)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      s.s(localObject1, "JSONObject().apply {\n   …\n            }.toString()");
      AppMethodBeat.o(260901);
      return localObject1;
    }
    Log.w(getTAG(), "getNetworkType, unknown");
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("networkType", "none");
    localObject1 = ((JSONObject)localObject1).toString();
    s.s(localObject1, "JSONObject().apply { put…pe\", \"none\") }.toString()");
    AppMethodBeat.o(260901);
    return localObject1;
  }
  
  @JavascriptInterface
  public final String getPlatform()
  {
    return "android";
  }
  
  @JavascriptInterface
  public final String getSystemInfo()
  {
    AppMethodBeat.i(260869);
    Object localObject = new JSONObject();
    ((JSONObject)localObject).put("devicesType", 2);
    ((JSONObject)localObject).put("osVersion", Build.VERSION.SDK_INT);
    ((JSONObject)localObject).put("brand", Build.BRAND);
    ((JSONObject)localObject).put("model", q.aPo());
    f.a locala = f.WlF;
    ((JSONObject)localObject).put("pixelRatio", Float.valueOf(f.a.getDevicePixelRatio()));
    localObject = ((JSONObject)localObject).toString();
    s.s(localObject, "JSONObject().apply {\n   …tio)\n        }.toString()");
    AppMethodBeat.o(260869);
    return localObject;
  }
  
  @JavascriptInterface
  public final void idkey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(260840);
    if (paramLong1 <= 0L)
    {
      Log.e(getTAG(), "idkey id can't be 0");
      AppMethodBeat.o(260840);
      return;
    }
    com.tencent.mm.plugin.report.service.h.OAn.p(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(260840);
  }
  
  @JavascriptInterface
  public final void idkeyList(String paramString)
  {
    AppMethodBeat.i(260843);
    s.u(paramString, "idkeyList");
    paramString = new com.tencent.mm.ad.f(paramString);
    Object localObject1 = new LinkedList();
    int i = 0;
    int k = paramString.length();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      Object localObject2 = paramString.sr(i);
      ((LinkedList)localObject1).add(new IDKey(((com.tencent.mm.ad.f)localObject2).getLong(0), ((com.tencent.mm.ad.f)localObject2).getLong(1), ((com.tencent.mm.ad.f)localObject2).getLong(2)));
      if (j >= k)
      {
        localObject1 = (List)localObject1;
        paramString = com.tencent.mm.plugin.report.service.h.OAn;
        localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
        label185:
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = ((Iterator)localObject2).next();
          if (((IDKey)localObject3).GetID() > 0L) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label185;
            }
            ((Collection)localObject1).add(localObject3);
            break;
          }
        }
        paramString.b(new ArrayList((Collection)localObject1), false);
        AppMethodBeat.o(260843);
        return;
      }
      i = j;
    }
  }
  
  @JavascriptInterface
  public final void kv(int paramInt, String paramString)
  {
    AppMethodBeat.i(260836);
    s.u(paramString, "data");
    Log.i(getTAG(), "kvStat id=" + paramInt + ", data=" + paramString);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(paramInt, paramString);
    AppMethodBeat.o(260836);
  }
  
  @JavascriptInterface
  public final void reportCgi(Number paramNumber, String paramString1, String paramString2)
  {
    AppMethodBeat.i(260881);
    s.u(paramNumber, "businessId");
    s.u(paramString1, "reqJson");
    s.u(paramString2, "callback");
    Object localObject1 = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject1).otE = ((com.tencent.mm.bx.a)new oy());
    ((com.tencent.mm.am.c.a)localObject1).otF = ((com.tencent.mm.bx.a)new oz());
    ((com.tencent.mm.am.c.a)localObject1).uri = "/cgi-bin/mmbiz-bin/report/bizcommreport";
    ((com.tencent.mm.am.c.a)localObject1).funcId = 4779;
    localObject1 = ((com.tencent.mm.am.c.a)localObject1).bEF();
    Object localObject2 = c.b.b(((com.tencent.mm.am.c)localObject1).otB);
    if (localObject2 == null)
    {
      paramNumber = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizCommReportReq");
      AppMethodBeat.o(260881);
      throw paramNumber;
    }
    localObject2 = (oy)localObject2;
    ((oy)localObject2).business_type = paramNumber.intValue();
    ((oy)localObject2).YSb = paramString1;
    Log.d(getTAG(), "reportCgi %s", new Object[] { paramString1 });
    Log.i(getTAG(), s.X("reportCgi businessId=", paramNumber));
    z.a((com.tencent.mm.am.c)localObject1, new i..ExternalSyntheticLambda0(this, paramString2));
    AppMethodBeat.o(260881);
  }
  
  @JavascriptInterface
  public final String userAgent()
  {
    AppMethodBeat.i(260848);
    Object localObject = MMApplicationContext.getContext();
    j.a locala = com.tencent.mm.plugin.webview.k.j.Xta;
    localObject = r.a((Context)localObject, j.a.iCS(), (r.a)a.ioY());
    Log.d(getTAG(), s.X("userAgent=", localObject));
    s.s(localObject, "userAgent");
    AppMethodBeat.o(260848);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webjsapi/WxJsEngineAPI$Companion;", "", "()V", "profilerPath", "", "userAgentInfo", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "getUserAgentInfo", "()Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "userAgentInfo$delegate", "Lkotlin/Lazy;", "toast", "", "text", "webview-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static void adc(String paramString)
    {
      AppMethodBeat.i(260792);
      d.uiThread((kotlin.g.a.a)new a(paramString));
      AppMethodBeat.o(260792);
    }
    
    public static com.tencent.mm.plugin.webview.k.j ioY()
    {
      AppMethodBeat.i(260784);
      com.tencent.mm.plugin.webview.k.j localj = (com.tencent.mm.plugin.webview.k.j)i.ioX().getValue();
      AppMethodBeat.o(260784);
      return localj;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(String paramString)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.k.j>
  {
    public static final b WlL;
    
    static
    {
      AppMethodBeat.i(260781);
      WlL = new b();
      AppMethodBeat.o(260781);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ax.i
 * JD-Core Version:    0.7.0.1
 */