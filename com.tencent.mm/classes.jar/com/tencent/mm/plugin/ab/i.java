package com.tencent.mm.plugin.ab;

import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.aa.a;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.k.e;
import com.tencent.mm.plugin.webview.k.e.a;
import com.tencent.mm.protocal.protobuf.oc;
import com.tencent.mm.protocal.protobuf.od;
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
import kotlin.l;
import kotlin.t;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webjsapi/WxJsEngineAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSAPI;", "Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;", "context", "(Lcom/tencent/mm/plugin/webjsapi/JSEngineAPIContext;)V", "dump", "", "tag", "", "data", "dumpToFile", "", "dumpFileName", "content", "getLogLevel", "", "getNetWorkType", "getPlatform", "idkey", "id", "", "key", "value", "idkeyList", "kv", "reportCgi", "businessId", "", "reqJson", "callback", "userAgent", "Companion", "webview-sdk_release"})
public final class i
  extends a<c>
{
  private static final String IBf;
  public static final i.a IBg;
  private static final kotlin.f pDC;
  
  static
  {
    AppMethodBeat.i(224823);
    IBg = new i.a((byte)0);
    pDC = kotlin.g.ah((kotlin.g.a.a)i.b.IBh);
    IBf = com.tencent.mm.loader.j.b.aKJ() + "jsengine/trace/";
    AppMethodBeat.o(224823);
  }
  
  public i(c paramc)
  {
    super("wxJsEngine", (b)paramc);
    AppMethodBeat.i(224822);
    AppMethodBeat.o(224822);
  }
  
  /* Error */
  private final boolean eu(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 127
    //   5: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: invokestatic 133	com/tencent/mm/compatible/util/e:apn	()Z
    //   11: ifne +19 -> 30
    //   14: aload_0
    //   15: getfield 136	com/tencent/mm/plugin/ab/a:TAG	Ljava/lang/String;
    //   18: ldc 138
    //   20: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc 127
    //   25: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: iconst_0
    //   29: ireturn
    //   30: aconst_null
    //   31: astore 7
    //   33: aconst_null
    //   34: astore 6
    //   36: aload 7
    //   38: astore 5
    //   40: new 146	com/tencent/mm/vfs/o
    //   43: dup
    //   44: getstatic 102	com/tencent/mm/plugin/ab/i:IBf	Ljava/lang/String;
    //   47: invokespecial 149	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   50: astore 8
    //   52: aload 7
    //   54: astore 5
    //   56: aload 8
    //   58: invokevirtual 152	com/tencent/mm/vfs/o:exists	()Z
    //   61: ifne +13 -> 74
    //   64: aload 7
    //   66: astore 5
    //   68: aload 8
    //   70: invokevirtual 155	com/tencent/mm/vfs/o:mkdirs	()Z
    //   73: pop
    //   74: aload 7
    //   76: astore 5
    //   78: new 157	com/tencent/mm/vfs/v
    //   81: dup
    //   82: new 146	com/tencent/mm/vfs/o
    //   85: dup
    //   86: aload 8
    //   88: aload_1
    //   89: invokespecial 160	com/tencent/mm/vfs/o:<init>	(Lcom/tencent/mm/vfs/o;Ljava/lang/String;)V
    //   92: iconst_0
    //   93: invokespecial 163	com/tencent/mm/vfs/v:<init>	(Lcom/tencent/mm/vfs/o;Z)V
    //   96: astore_1
    //   97: aload_1
    //   98: aload_2
    //   99: invokevirtual 166	com/tencent/mm/vfs/v:write	(Ljava/lang/String;)V
    //   102: iconst_1
    //   103: istore_3
    //   104: aload_1
    //   105: invokevirtual 169	com/tencent/mm/vfs/v:close	()V
    //   108: ldc 127
    //   110: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iload_3
    //   114: ireturn
    //   115: astore_1
    //   116: aload_0
    //   117: getfield 136	com/tencent/mm/plugin/ab/a:TAG	Ljava/lang/String;
    //   120: ldc 171
    //   122: aload_1
    //   123: invokestatic 177	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   126: invokevirtual 181	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   129: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   132: goto -24 -> 108
    //   135: astore_2
    //   136: aload 6
    //   138: astore_1
    //   139: aload_1
    //   140: astore 5
    //   142: aload_0
    //   143: getfield 136	com/tencent/mm/plugin/ab/a:TAG	Ljava/lang/String;
    //   146: ldc 183
    //   148: aload_2
    //   149: invokestatic 177	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   152: invokevirtual 181	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   155: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: iload 4
    //   160: istore_3
    //   161: aload_1
    //   162: ifnull -54 -> 108
    //   165: aload_1
    //   166: invokevirtual 169	com/tencent/mm/vfs/v:close	()V
    //   169: iload 4
    //   171: istore_3
    //   172: goto -64 -> 108
    //   175: astore_1
    //   176: aload_0
    //   177: getfield 136	com/tencent/mm/plugin/ab/a:TAG	Ljava/lang/String;
    //   180: ldc 171
    //   182: aload_1
    //   183: invokestatic 177	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   186: invokevirtual 181	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   189: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   192: iload 4
    //   194: istore_3
    //   195: goto -87 -> 108
    //   198: astore_1
    //   199: aload 5
    //   201: ifnull +8 -> 209
    //   204: aload 5
    //   206: invokevirtual 169	com/tencent/mm/vfs/v:close	()V
    //   209: ldc 127
    //   211: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: aload_1
    //   215: athrow
    //   216: astore_2
    //   217: aload_0
    //   218: getfield 136	com/tencent/mm/plugin/ab/a:TAG	Ljava/lang/String;
    //   221: ldc 171
    //   223: aload_2
    //   224: invokestatic 177	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   227: invokevirtual 181	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   230: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   50	37	8	localo	com.tencent.mm.vfs.o
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
    AppMethodBeat.i(224819);
    kotlin.g.b.p.h(paramString1, "tag");
    kotlin.g.b.p.h(paramString2, "data");
    if (!WeChatEnvironment.hasDebugger())
    {
      Log.w(this.TAG, "try to dump data without debugger");
      AppMethodBeat.o(224819);
      return;
    }
    paramString1 = "CPU_" + paramString1 + '_' + MMSlotKt.now() + ".cpuprofile";
    if (eu(paramString1, paramString2))
    {
      paramString1 = IBf + paramString1;
      i.a.acb(paramString1 + " exported.");
      Log.i(this.TAG, paramString1 + " exported.");
      AppMethodBeat.o(224819);
      return;
    }
    i.a.acb(paramString1 + " export failed!");
    Log.e(this.TAG, paramString1 + " export failed!");
    AppMethodBeat.o(224819);
  }
  
  @JavascriptInterface
  public final int getLogLevel()
  {
    AppMethodBeat.i(224817);
    int i = Log.getLogLevel();
    AppMethodBeat.o(224817);
    return i;
  }
  
  @JavascriptInterface
  public final String getNetWorkType()
  {
    AppMethodBeat.i(224821);
    Object localObject2 = MMApplicationContext.getContext();
    if (!NetStatusUtil.isConnected((Context)localObject2))
    {
      Log.i(this.TAG, "getNetworkType, not connected");
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("networkType", "none");
      localObject1 = ((JSONObject)localObject1).toString();
      kotlin.g.b.p.g(localObject1, "org.json.JSONObject().ap…pe\", \"none\") }.toString()");
      AppMethodBeat.o(224821);
      return localObject1;
    }
    Object localObject1 = (com.tencent.mm.plugin.misc.a.a)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.misc.a.a.class);
    label91:
    label95:
    int i;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(((com.tencent.mm.plugin.misc.a.a)localObject1).Qr(16));
      if (localObject1 != null) {
        break label212;
      }
      if (localObject1 != null) {
        break label224;
      }
      i = 2;
    }
    for (;;)
    {
      localObject1 = Integer.valueOf(i);
      i = NetStatusUtil.getNetType((Context)localObject2);
      Log.i(this.TAG, "getNetworkType, type = " + i + ", simType = " + localObject1);
      if (!NetStatusUtil.is2G((Context)localObject2)) {
        break label237;
      }
      Log.i(this.TAG, "getNetworkType, 2g");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "2g");
      ((JSONObject)localObject2).put("simtype", ((Integer)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      kotlin.g.b.p.g(localObject1, "org.json.JSONObject().ap…\n            }.toString()");
      AppMethodBeat.o(224821);
      return localObject1;
      localObject1 = null;
      break;
      label212:
      if (((Integer)localObject1).intValue() != 0) {
        break label91;
      }
      i = 0;
      continue;
      label224:
      if (((Integer)localObject1).intValue() != 1) {
        break label95;
      }
      i = 1;
    }
    label237:
    if (NetStatusUtil.is3G((Context)localObject2))
    {
      Log.i(this.TAG, "getNetworkType, 3g");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "3g");
      ((JSONObject)localObject2).put("simtype", ((Integer)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      kotlin.g.b.p.g(localObject1, "org.json.JSONObject().ap…\n            }.toString()");
      AppMethodBeat.o(224821);
      return localObject1;
    }
    if (NetStatusUtil.is4G((Context)localObject2))
    {
      Log.i(this.TAG, "getNetworkType, 4g");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "4g");
      ((JSONObject)localObject2).put("simtype", ((Integer)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      kotlin.g.b.p.g(localObject1, "org.json.JSONObject().ap…\n            }.toString()");
      AppMethodBeat.o(224821);
      return localObject1;
    }
    if (NetStatusUtil.is5G((Context)localObject2))
    {
      Log.i(this.TAG, "getNetworkType, 5g");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "5g");
      ((JSONObject)localObject2).put("simtype", ((Integer)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      kotlin.g.b.p.g(localObject1, "org.json.JSONObject().ap…\n            }.toString()");
      AppMethodBeat.o(224821);
      return localObject1;
    }
    if (NetStatusUtil.isWifi((Context)localObject2))
    {
      Log.i(this.TAG, "getNetworkType, wifi");
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("networkType", "wifi");
      ((JSONObject)localObject2).put("simtype", ((Integer)localObject1).intValue());
      localObject1 = ((JSONObject)localObject2).toString();
      kotlin.g.b.p.g(localObject1, "org.json.JSONObject().ap…\n            }.toString()");
      AppMethodBeat.o(224821);
      return localObject1;
    }
    Log.w(this.TAG, "getNetworkType, unknown");
    localObject1 = new JSONObject();
    ((JSONObject)localObject1).put("networkType", "none");
    localObject1 = ((JSONObject)localObject1).toString();
    kotlin.g.b.p.g(localObject1, "org.json.JSONObject().ap…pe\", \"none\") }.toString()");
    AppMethodBeat.o(224821);
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
    AppMethodBeat.i(224814);
    if (paramLong1 <= 0L)
    {
      Log.e(this.TAG, "idkey id can't be 0");
      AppMethodBeat.o(224814);
      return;
    }
    h.CyF.n(paramLong1, paramLong2, paramLong3);
    AppMethodBeat.o(224814);
  }
  
  @JavascriptInterface
  public final void idkeyList(String paramString)
  {
    AppMethodBeat.i(224815);
    kotlin.g.b.p.h(paramString, "idkeyList");
    paramString = new com.tencent.mm.ab.f(paramString);
    Object localObject1 = new LinkedList();
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      localObject2 = paramString.pW(i);
      ((LinkedList)localObject1).add(new IDKey(((com.tencent.mm.ab.f)localObject2).getLong(0), ((com.tencent.mm.ab.f)localObject2).getLong(1), ((com.tencent.mm.ab.f)localObject2).getLong(2)));
      i += 1;
    }
    localObject1 = (List)localObject1;
    paramString = h.CyF;
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
    AppMethodBeat.o(224815);
  }
  
  @JavascriptInterface
  public final void kv(int paramInt, String paramString)
  {
    AppMethodBeat.i(224813);
    kotlin.g.b.p.h(paramString, "data");
    Log.i(this.TAG, "kvStat id=" + paramInt + ", data=" + paramString);
    h.CyF.kvStat(paramInt, paramString);
    AppMethodBeat.o(224813);
  }
  
  @JavascriptInterface
  public final void reportCgi(Number paramNumber, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(224818);
    kotlin.g.b.p.h(paramNumber, "businessId");
    kotlin.g.b.p.h(paramString1, "reqJson");
    kotlin.g.b.p.h(paramString2, "callback");
    Object localObject1 = new d.a();
    ((d.a)localObject1).c((com.tencent.mm.bw.a)new oc());
    ((d.a)localObject1).d((com.tencent.mm.bw.a)new od());
    ((d.a)localObject1).MB("/cgi-bin/mmbiz-bin/report/bizcommreport");
    ((d.a)localObject1).sG(4779);
    localObject1 = ((d.a)localObject1).aXF();
    Object localObject2 = ((d)localObject1).aYJ();
    if (localObject2 == null)
    {
      paramNumber = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.BizCommReportReq");
      AppMethodBeat.o(224818);
      throw paramNumber;
    }
    localObject2 = (oc)localObject2;
    ((oc)localObject2).KTE = paramNumber.intValue();
    ((oc)localObject2).KTF = paramString1;
    Log.d(this.TAG, "reportCgi %s", new Object[] { paramString1 });
    Log.i(this.TAG, "reportCgi businessId=".concat(String.valueOf(paramNumber)));
    aa.a((d)localObject1, (aa.a)new c(this, paramString2));
    AppMethodBeat.o(224818);
  }
  
  @JavascriptInterface
  public final String userAgent()
  {
    AppMethodBeat.i(224816);
    Object localObject = MMApplicationContext.getContext();
    e.a locala = e.JBw;
    localObject = com.tencent.mm.plugin.appbrand.ac.p.a((Context)localObject, e.a.giH(), (p.a)pDC.getValue());
    Log.d(this.TAG, "userAgent=".concat(String.valueOf(localObject)));
    kotlin.g.b.p.g(localObject, "userAgent");
    AppMethodBeat.o(224816);
    return localObject;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "errCode", "<anonymous parameter 2>", "", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "<anonymous parameter 4>", "Lcom/tencent/mm/modelbase/NetSceneBase;", "callback"})
  static final class c
    implements aa.a
  {
    c(i parami, String paramString) {}
    
    public final int a(int paramInt1, int paramInt2, String paramString, d paramd, q paramq)
    {
      AppMethodBeat.i(224812);
      kotlin.g.b.p.h(paramd, "rr");
      kotlin.g.b.p.h(paramq, "<anonymous parameter 4>");
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        paramString = (c)this.IBi.IBa;
        paramd = paramString2;
        paramq = new com.tencent.mm.ab.i();
        paramq.U("err_code", paramInt2);
        paramq.h("err_msg", "fail");
        paramq = paramq.toString();
        kotlin.g.b.p.g(paramq, "JSONObject().apply {\n   …             }.toString()");
        c.a.a(paramString, paramd, paramq, null, 4);
        AppMethodBeat.o(224812);
        return 0;
      }
      paramd = paramd.aYK();
      paramString = paramd;
      if (!(paramd instanceof od)) {
        paramString = null;
      }
      paramString = (od)paramString;
      if (paramString == null)
      {
        AppMethodBeat.o(224812);
        return 0;
      }
      Log.i(this.IBi.TAG, "reportCgi resp_json=" + paramString.KTG);
      paramq = (c)this.IBi.IBa;
      String str = paramString2;
      paramd = paramString.KTG;
      paramString = paramd;
      if (paramd == null) {
        paramString = "null";
      }
      c.a.a(paramq, str, paramString, null, 4);
      AppMethodBeat.o(224812);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ab.i
 * JD-Core Version:    0.7.0.1
 */