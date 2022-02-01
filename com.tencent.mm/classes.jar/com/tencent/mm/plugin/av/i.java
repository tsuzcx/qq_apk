package com.tencent.mm.plugin.av;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.aa;
import com.tencent.mm.an.aa.a;
import com.tencent.mm.an.d.a;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.webview.k.h.a;
import com.tencent.mm.protocal.protobuf.ns;
import com.tencent.mm.protocal.protobuf.nt;
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
import kotlin.g;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/WxJsEngineAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;)V", "dump", "", "tag", "", "data", "dumpToFile", "", "dumpFileName", "content", "getLogLevel", "", "getNetWorkType", "getPlatform", "idkey", "id", "", "key", "value", "idkeyList", "kv", "reportCgi", "businessId", "", "reqJson", "callback", "userAgent", "Companion", "webview-sdk_release"})
public final class i
  extends a<c>
{
  private static final String Pvo;
  public static final a Pvp;
  private static final kotlin.f sNT;
  
  static
  {
    AppMethodBeat.i(206368);
    Pvp = new a((byte)0);
    sNT = g.ar((kotlin.g.a.a)b.Pvq);
    Pvo = com.tencent.mm.loader.j.b.aSL() + "jsengine/trace/";
    AppMethodBeat.o(206368);
  }
  
  public i(c paramc)
  {
    super("wxJsEngine", (b)paramc);
    AppMethodBeat.i(206366);
    AppMethodBeat.o(206366);
  }
  
  /* Error */
  private final boolean eI(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 130
    //   5: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 136	com/tencent/mm/compatible/util/e:avA	()Z
    //   11: ifne +19 -> 30
    //   14: aload_0
    //   15: getfield 139	com/tencent/mm/plugin/av/a:TAG	Ljava/lang/String;
    //   18: ldc 141
    //   20: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc 130
    //   25: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: iconst_0
    //   29: ireturn
    //   30: aconst_null
    //   31: astore 7
    //   33: aconst_null
    //   34: astore 6
    //   36: aload 7
    //   38: astore 5
    //   40: new 149	com/tencent/mm/vfs/q
    //   43: dup
    //   44: getstatic 105	com/tencent/mm/plugin/av/i:Pvo	Ljava/lang/String;
    //   47: invokespecial 152	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   50: astore 8
    //   52: aload 7
    //   54: astore 5
    //   56: aload 8
    //   58: invokevirtual 155	com/tencent/mm/vfs/q:ifE	()Z
    //   61: ifne +13 -> 74
    //   64: aload 7
    //   66: astore 5
    //   68: aload 8
    //   70: invokevirtual 158	com/tencent/mm/vfs/q:ifL	()Z
    //   73: pop
    //   74: aload 7
    //   76: astore 5
    //   78: new 160	com/tencent/mm/vfs/y
    //   81: dup
    //   82: new 149	com/tencent/mm/vfs/q
    //   85: dup
    //   86: aload 8
    //   88: aload_1
    //   89: invokespecial 163	com/tencent/mm/vfs/q:<init>	(Lcom/tencent/mm/vfs/q;Ljava/lang/String;)V
    //   92: iconst_0
    //   93: invokespecial 166	com/tencent/mm/vfs/y:<init>	(Lcom/tencent/mm/vfs/q;Z)V
    //   96: astore_1
    //   97: aload_1
    //   98: aload_2
    //   99: invokevirtual 169	com/tencent/mm/vfs/y:write	(Ljava/lang/String;)V
    //   102: iconst_1
    //   103: istore_3
    //   104: aload_1
    //   105: invokevirtual 172	com/tencent/mm/vfs/y:close	()V
    //   108: ldc 130
    //   110: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iload_3
    //   114: ireturn
    //   115: astore_1
    //   116: aload_0
    //   117: getfield 139	com/tencent/mm/plugin/av/a:TAG	Ljava/lang/String;
    //   120: ldc 174
    //   122: aload_1
    //   123: invokestatic 180	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   126: invokevirtual 184	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   129: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -24 -> 108
    //   135: astore_2
    //   136: aload 6
    //   138: astore_1
    //   139: aload_1
    //   140: astore 5
    //   142: aload_0
    //   143: getfield 139	com/tencent/mm/plugin/av/a:TAG	Ljava/lang/String;
    //   146: ldc 186
    //   148: aload_2
    //   149: invokestatic 180	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   152: invokevirtual 184	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   155: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: iload 4
    //   160: istore_3
    //   161: aload_1
    //   162: ifnull -54 -> 108
    //   165: aload_1
    //   166: invokevirtual 172	com/tencent/mm/vfs/y:close	()V
    //   169: iload 4
    //   171: istore_3
    //   172: goto -64 -> 108
    //   175: astore_1
    //   176: aload_0
    //   177: getfield 139	com/tencent/mm/plugin/av/a:TAG	Ljava/lang/String;
    //   180: ldc 174
    //   182: aload_1
    //   183: invokestatic 180	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokevirtual 184	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: iload 4
    //   194: istore_3
    //   195: goto -87 -> 108
    //   198: astore_1
    //   199: aload 5
    //   201: ifnull +8 -> 209
    //   204: aload 5
    //   206: invokevirtual 172	com/tencent/mm/vfs/y:close	()V
    //   209: ldc 130
    //   211: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_1
    //   215: athrow
    //   216: astore_2
    //   217: aload_0
    //   218: getfield 139	com/tencent/mm/plugin/av/a:TAG	Ljava/lang/String;
    //   221: ldc 174
    //   223: aload_2
    //   224: invokestatic 180	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   227: invokevirtual 184	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   230: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: goto -24 -> 209
    //   236: astore_2
    //   237: aload_1
    //   238: astore 5
    //   240: aload_2
    //   241: astore_1
    //   242: goto -43 -> 199
    //   245: astore_2
    //   246: goto -107 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	249	0	this	i
    //   0	249	1	paramString1	String
    //   0	249	2	paramString2	String
    //   103	92	3	bool1	boolean
    //   1	192	4	bool2	boolean
    //   38	201	5	localObject1	Object
    //   34	103	6	localObject2	Object
    //   31	44	7	localObject3	Object
    //   50	37	8	localq	com.tencent.mm.vfs.q
    // Exception table:
    //   from	to	target	type
    //   104	108	115	java/lang/Exception
    //   40	52	135	java/lang/Exception
    //   56	64	135	java/lang/Exception
    //   68	74	135	java/lang/Exception
    //   78	97	135	java/lang/Exception
    //   165	169	175	java/lang/Exception
    //   40	52	198	finally
    //   56	64	198	finally
    //   68	74	198	finally
    //   78	97	198	finally
    //   142	158	198	finally
    //   204	209	216	java/lang/Exception
    //   97	102	236	finally
    //   97	102	245	java/lang/Exception
  }
  
  @JavascriptInterface
  public final void dump(String paramString1, String paramString2)
  {
    AppMethodBeat.i(206361);
    kotlin.g.b.p.k(paramString1, "tag");
    kotlin.g.b.p.k(paramString2, "data");
    if (!WeChatEnvironment.hasDebugger())
    {
      Log.w(this.TAG, "try to dump data without debugger");
      AppMethodBeat.o(206361);
      return;
    }
    paramString1 = "CPU_" + paramString1 + '_' + MMSlotKt.now() + ".cpuprofile";
    if (eI(paramString1, paramString2))
    {
      paramString1 = Pvo + paramString1;
      a.ajY(paramString1 + " exported.");
      Log.i(this.TAG, paramString1 + " exported.");
      AppMethodBeat.o(206361);
      return;
    }
    a.ajY(paramString1 + " export failed!");
    Log.e(this.TAG, paramString1 + " export failed!");
    AppMethodBeat.o(206361);
  }
  
  @JavascriptInterface
  public final int getLogLevel()
  {
    AppMethodBeat.i(206359);
    int i = Log.getLogLevel();
    AppMethodBeat.o(206359);
    return i;
  }
  
  @JavascriptInterface
  public final String getNetWorkType()
  {
    AppMethodBeat.i(206364);
    Object localObject2 = MMApplicationContext.getContext();
    if (!NetStatusUtil.isConnected((Context)localObject2))
    {
      Log.i(this.TAG, "getNetworkType, not connected");
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("networkType", "none");
      localObject1 = ((JSONObject)localObject1).toString();
      kotlin.g.b.p.j(localObject1, "org.json.JSONObject().ap…pe\", \"none\") }.toString()");
      AppMethodBeat.o(206364);
      return localObject1;
    }
    Object localObject1 = (com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.misc.a.a.class);
    label92:
    label96:
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.misc.a.a)localObject1).WE(16));
      if (localObject1 != null) {
        break label213;
      }
      if (localObject1 != null) {
        break label225;
      }
      i = 2;
    }
    for (;;)
    {
      localObject1 = Integer.valueOf(i);
      i = NetStatusUtil.getNetType((Context)localObject2);
      Log.i(this.TAG, "getNetworkType, type = " + i + ", simType = " + localObject1);
      if (!NetStatusUtil.is2G((Context)localObject2)) {
        break label238;
      }
      Log.i(this.TAG, "getNetworkType, 2g");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "2g");
      ((JSONObject)localObject2).put("simtype", ((Integer)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      kotlin.g.b.p.j(localObject1, "org.json.JSONObject().ap…\n            }.toString()");
      AppMethodBeat.o(206364);
      return localObject1;
      localObject1 = null;
      break;
      label213:
      if (((Integer)localObject1).intValue() != 0) {
        break label92;
      }
      i = 0;
      continue;
      label225:
      if (((Integer)localObject1).intValue() != 1) {
        break label96;
      }
      i = 1;
    }
    label238:
    if (NetStatusUtil.is3G((Context)localObject2))
    {
      Log.i(this.TAG, "getNetworkType, 3g");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "3g");
      ((JSONObject)localObject2).put("simtype", ((Integer)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      kotlin.g.b.p.j(localObject1, "org.json.JSONObject().ap…\n            }.toString()");
      AppMethodBeat.o(206364);
      return localObject1;
    }
    if (NetStatusUtil.is4G((Context)localObject2))
    {
      Log.i(this.TAG, "getNetworkType, 4g");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "4g");
      ((JSONObject)localObject2).put("simtype", ((Integer)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      kotlin.g.b.p.j(localObject1, "org.json.JSONObject().ap…\n            }.toString()");
      AppMethodBeat.o(206364);
      return localObject1;
    }
    if (NetStatusUtil.is5G((Context)localObject2))
    {
      Log.i(this.TAG, "getNetworkType, 5g");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "5g");
      ((JSONObject)localObject2).put("simtype", ((Integer)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      kotlin.g.b.p.j(localObject1, "org.json.JSONObject().ap…\n            }.toString()");
      AppMethodBeat.o(206364);
      return localObject1;
    }
    if (NetStatusUtil.isWifi((Context)localObject2))
    {
      Log.i(this.TAG, "getNetworkType, wifi");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "wifi");
      ((JSONObject)localObject2).put("simtype", ((Integer)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      kotlin.g.b.p.j(localObject1, "org.json.JSONObject().ap…\n            }.toString()");
      AppMethodBeat.o(206364);
      return localObject1;
    }
    Log.w(this.TAG, "getNetworkType, unknown");
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("networkType", "none");
    localObject1 = ((JSONObject)localObject1).toString();
    kotlin.g.b.p.j(localObject1, "org.json.JSONObject().ap…pe\", \"none\") }.toString()");
    AppMethodBeat.o(206364);
    return localObject1;
  }
  
  @JavascriptInterface
  public final String getPlatform()
  {
    return "android";
  }
  
  @JavascriptInterface
  public final void idkey(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(206354);
    if (paramLong1 <= 0L)
    {
      Log.e(this.TAG, "idkey id can't be 0");
      AppMethodBeat.o(206354);
      return;
    }
    com.tencent.mm.plugin.report.service.h.IzE.p(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(206354);
  }
  
  @JavascriptInterface
  public final void idkeyList(String paramString)
  {
    AppMethodBeat.i(206357);
    kotlin.g.b.p.k(paramString, "idkeyList");
    paramString = new com.tencent.mm.ad.f(paramString);
    Object localObject1 = new LinkedList();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      localObject2 = paramString.sv(i);
      ((LinkedList)localObject1).add(new IDKey(((com.tencent.mm.ad.f)localObject2).getLong(0), ((com.tencent.mm.ad.f)localObject2).getLong(1), ((com.tencent.mm.ad.f)localObject2).getLong(2)));
      i += 1;
    }
    localObject1 = (List)localObject1;
    paramString = com.tencent.mm.plugin.report.service.h.IzE;
    Object localObject2 = (Iterable)localObject1;
    localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label181:
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      if (((IDKey)localObject3).GetID() > 0L) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label181;
        }
        ((Collection)localObject1).add(localObject3);
        break;
      }
    }
    paramString.b(new ArrayList((Collection)localObject1), false);
    AppMethodBeat.o(206357);
  }
  
  @JavascriptInterface
  public final void kv(int paramInt, String paramString)
  {
    AppMethodBeat.i(206352);
    kotlin.g.b.p.k(paramString, "data");
    Log.i(this.TAG, "kvStat id=" + paramInt + ", data=" + paramString);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(paramInt, paramString);
    AppMethodBeat.o(206352);
  }
  
  @JavascriptInterface
  public final void reportCgi(Number paramNumber, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(206360);
    kotlin.g.b.p.k(paramNumber, "businessId");
    kotlin.g.b.p.k(paramString1, "reqJson");
    kotlin.g.b.p.k(paramString2, "callback");
    Object localObject1 = new d.a();
    ((d.a)localObject1).c((com.tencent.mm.cd.a)new ns());
    ((d.a)localObject1).d((com.tencent.mm.cd.a)new nt());
    ((d.a)localObject1).TW("/cgi-bin/mmbiz-bin/report/bizcommreport");
    ((d.a)localObject1).vD(4779);
    localObject1 = ((d.a)localObject1).bgN();
    Object localObject2 = ((com.tencent.mm.an.d)localObject1).bhX();
    if (localObject2 == null)
    {
      paramNumber = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizCommReportReq");
      AppMethodBeat.o(206360);
      throw paramNumber;
    }
    localObject2 = (ns)localObject2;
    ((ns)localObject2).RUA = paramNumber.intValue();
    ((ns)localObject2).RUB = paramString1;
    Log.d(this.TAG, "reportCgi %s", new Object[] { paramString1 });
    Log.i(this.TAG, "reportCgi businessId=".concat(String.valueOf(paramNumber)));
    aa.a((com.tencent.mm.an.d)localObject1, (aa.a)new c(this, paramString2));
    AppMethodBeat.o(206360);
  }
  
  @JavascriptInterface
  public final String userAgent()
  {
    AppMethodBeat.i(206358);
    Object localObject = MMApplicationContext.getContext();
    h.a locala = com.tencent.mm.plugin.webview.k.h.QAa;
    localObject = com.tencent.mm.plugin.appbrand.ac.p.a((Context)localObject, h.a.hcr(), (p.a)a.gPE());
    Log.d(this.TAG, "userAgent=".concat(String.valueOf(localObject)));
    kotlin.g.b.p.j(localObject, "userAgent");
    AppMethodBeat.o(206358);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webjsapi/WxJsEngineAPI$Companion;", "", "()V", "profilerPath", "", "userAgentInfo", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "getUserAgentInfo", "()Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "userAgentInfo$delegate", "Lkotlin/Lazy;", "toast", "", "text", "webview-sdk_release"})
  public static final class a
  {
    static void ajY(String paramString)
    {
      AppMethodBeat.i(208773);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramString));
      AppMethodBeat.o(208773);
    }
    
    public static com.tencent.mm.plugin.webview.k.h gPE()
    {
      AppMethodBeat.i(208772);
      Object localObject = i.gPD();
      a locala = i.Pvp;
      localObject = (com.tencent.mm.plugin.webview.k.h)((kotlin.f)localObject).getValue();
      AppMethodBeat.o(208772);
      return localObject;
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(String paramString)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/webview/util/WebPrefetchUserAgentInfo;", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<com.tencent.mm.plugin.webview.k.h>
  {
    public static final b Pvq;
    
    static
    {
      AppMethodBeat.i(207090);
      Pvq = new b();
      AppMethodBeat.o(207090);
    }
    
    b()
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class c
    implements aa.a
  {
    c(i parami, String paramString) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.d paramd, com.tencent.mm.an.q paramq)
    {
      AppMethodBeat.i(209867);
      kotlin.g.b.p.k(paramd, "rr");
      kotlin.g.b.p.k(paramq, "<anonymous parameter 4>");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = (c)this.Pvr.Pvj;
        paramd = paramString2;
        paramq = new com.tencent.mm.ad.i();
        paramq.al("err_code", paramInt2);
        paramq.g("err_msg", "fail");
        paramq = paramq.toString();
        kotlin.g.b.p.j(paramq, "JSONObject().apply {\n   …             }.toString()");
        c.a.a(paramString, paramd, paramq, null, 4);
        AppMethodBeat.o(209867);
        return 0;
      }
      paramd = paramd.bhY();
      paramString = paramd;
      if (!(paramd instanceof nt)) {
        paramString = null;
      }
      paramString = (nt)paramString;
      if (paramString == null)
      {
        AppMethodBeat.o(209867);
        return 0;
      }
      Log.i(this.Pvr.TAG, "reportCgi resp_json=" + paramString.RUC);
      paramq = (c)this.Pvr.Pvj;
      String str = paramString2;
      paramd = paramString.RUC;
      paramString = paramd;
      if (paramd == null) {
        paramString = "null";
      }
      c.a.a(paramq, str, paramString, null, 4);
      AppMethodBeat.o(209867);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.av.i
 * JD-Core Version:    0.7.0.1
 */