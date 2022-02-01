package com.tencent.mm.cp;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.e.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ah;
import com.tencent.xweb.ai;
import com.tencent.xweb.aj;
import com.tencent.xweb.p.a;
import com.tencent.xweb.y;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class d
{
  static a LYU = null;
  static boolean LYV = false;
  static boolean LYW = false;
  static String LYX = "20201101";
  static String LYY = null;
  static String LYZ = null;
  static int LZa = 3600000;
  static long LZb = 3600000L;
  
  private static void a(Context paramContext, WebView.c paramc, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(152951);
    d.1 local1 = new d.1(paramPreInitCallback);
    paramPreInitCallback = paramContext;
    if (paramContext == null) {
      paramPreInitCallback = ak.getContext();
    }
    kX(paramPreInitCallback);
    if ((com.tencent.mm.sdk.platformtools.j.DEBUG) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) || (ae.getLogLevel() <= 1)) {}
    try
    {
      y.gfo().gfr();
      WebView.initWebviewCore(paramPreInitCallback, paramc, b.getModuleName(), local1);
      if (("mm".equals(b.getModuleName())) && (al.isDarkMode())) {
        ah.gfO();
      }
      if (fWX()) {
        XWalkEnvironment.setUsingCustomContext(true);
      }
      AppMethodBeat.o(152951);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Log.e("XWebUtil", "turn on xweb debug failed , exp = " + paramContext.getMessage());
      }
    }
  }
  
  public static void a(a parama)
  {
    try
    {
      AppMethodBeat.i(218952);
      LYU = parama;
      fWV();
      ae.i("XWebUtil", "setExpansionImp stack = ");
      AppMethodBeat.o(218952);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public static void a(WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(218954);
    a(MMWebView.LoI, paramPreInitCallback);
    AppMethodBeat.o(218954);
  }
  
  public static void a(WebView.c paramc)
  {
    AppMethodBeat.i(218953);
    a(paramc, null);
    AppMethodBeat.o(218953);
  }
  
  public static void a(WebView.c paramc, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(152950);
    a(ak.getContext(), paramc, paramPreInitCallback);
    AppMethodBeat.o(152950);
  }
  
  public static void bax(String paramString)
  {
    AppMethodBeat.i(152945);
    bay(paramString);
    baz(paramString);
    AppMethodBeat.o(152945);
  }
  
  private static void bay(String paramString)
  {
    AppMethodBeat.i(152947);
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!ak.aRQ(ak.getPackageName() + ":tools")))
    {
      AppMethodBeat.o(152947);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(e.l.Jpo, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    ak.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(152947);
  }
  
  public static void baz(String paramString)
  {
    AppMethodBeat.i(152948);
    if (com.tencent.mm.br.d.aid())
    {
      AppMethodBeat.o(152948);
      return;
    }
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!ak.aRQ(ak.getPackageName() + ":toolsmp")))
    {
      AppMethodBeat.o(152948);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(e.l.Jpo, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    ak.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(152948);
  }
  
  public static void bz(Intent paramIntent)
  {
    AppMethodBeat.i(152946);
    paramIntent.setComponent(new ComponentName(e.l.Jpo, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    ak.getContext().sendBroadcast(paramIntent);
    if (com.tencent.mm.br.d.aid())
    {
      AppMethodBeat.o(152946);
      return;
    }
    paramIntent.setComponent(new ComponentName(e.l.Jpo, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    ak.getContext().sendBroadcast(paramIntent);
    AppMethodBeat.o(152946);
  }
  
  public static void fWU()
  {
    AppMethodBeat.i(152944);
    bay("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    baz("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
    AppMethodBeat.o(152944);
  }
  
  /* Error */
  private static void fWV()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 261
    //   6: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 26	com/tencent/mm/cp/d:LYU	Lcom/tencent/mm/cp/d$a;
    //   12: ifnonnull +25 -> 37
    //   15: ldc 143
    //   17: ldc_w 263
    //   20: invokestatic 266	com/tencent/mm/sdk/platformtools/ae:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: iconst_0
    //   24: invokestatic 271	com/tencent/xweb/ai:zU	(Z)V
    //   27: ldc_w 261
    //   30: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: ldc 2
    //   35: monitorexit
    //   36: return
    //   37: ldc 143
    //   39: ldc_w 273
    //   42: invokestatic 175	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: getstatic 26	com/tencent/mm/cp/d:LYU	Lcom/tencent/mm/cp/d$a;
    //   48: invokeinterface 276 1 0
    //   53: istore_0
    //   54: iload_0
    //   55: invokestatic 271	com/tencent/xweb/ai:zU	(Z)V
    //   58: iload_0
    //   59: ifeq +14 -> 73
    //   62: getstatic 26	com/tencent/mm/cp/d:LYU	Lcom/tencent/mm/cp/d$a;
    //   65: invokeinterface 279 1 0
    //   70: invokestatic 282	com/tencent/xweb/ai:bcI	(Ljava/lang/String;)V
    //   73: ldc_w 261
    //   76: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: goto -46 -> 33
    //   82: astore_1
    //   83: ldc 2
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   53	6	0	bool	boolean
    //   82	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	33	82	finally
    //   37	58	82	finally
    //   62	73	82	finally
    //   73	79	82	finally
  }
  
  private static void fWW()
  {
    AppMethodBeat.i(152953);
    HashMap localHashMap = new HashMap();
    localHashMap.put("isgpversion", Boolean.valueOf(k.fnT()));
    localHashMap.put("processname", ak.getProcessName());
    localHashMap.put("is64bitabi", Boolean.valueOf(q.is64BitRuntime()));
    XWalkEnvironment.setXWebInitArgs(localHashMap);
    AppMethodBeat.o(152953);
  }
  
  public static boolean fWX()
  {
    AppMethodBeat.i(152954);
    if (WebView.getCurWebType() == WebView.c.MNy)
    {
      boolean bool = XWalkEnvironment.isCurrentVersionSupportCustomContext();
      AppMethodBeat.o(152954);
      return bool;
    }
    AppMethodBeat.o(152954);
    return false;
  }
  
  public static boolean kW(Context paramContext)
  {
    AppMethodBeat.i(152949);
    if ((WebView.isX5()) && (WebView.getUsingTbsCoreVersion(paramContext) <= 36541))
    {
      ae.i("XWebUtil", "lower version of x5 not support source type ");
      AppMethodBeat.o(152949);
      return false;
    }
    AppMethodBeat.o(152949);
    return true;
  }
  
  public static void kX(Context paramContext)
  {
    AppMethodBeat.i(152952);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ak.getContext();
    }
    com.tencent.xweb.p.MMK = new p.a()
    {
      public final void vN(String paramAnonymousString)
      {
        AppMethodBeat.i(218951);
        com.tencent.mm.compatible.util.j.vN(paramAnonymousString);
        AppMethodBeat.o(218951);
      }
    };
    aj.a(localContext, b.LYP, b.LYS, b.LYQ, b.LYR);
    ah.gfN();
    if ((com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.j.DEBUG))
    {
      XWalkEnvironment.setTempUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      XWalkEnvironment.setTempPluginUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_exp.xml");
    }
    for (;;)
    {
      XWalkEnvironment.setTempPluginUpdatePeriod(LZa);
      XWalkEnvironment.setConfigFetchPeriod(LZb);
      do
      {
        fWV();
        ai.zV(k.fnT());
        XWalkEnvironment.setAppClientVersion(com.tencent.mm.sdk.platformtools.j.IwD);
        fWW();
        if (k.fnT())
        {
          com.tencent.xweb.x5.sdk.d.forceSysWebView();
          XWalkEnvironment.appendAppInfo("GP_USER");
        }
        AppMethodBeat.o(152952);
        return;
        if (com.tencent.mm.protocal.d.FFK) {
          break;
        }
      } while (!com.tencent.mm.protocal.d.FFJ);
      if (LYV) {
        XWalkEnvironment.setTempUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/test_" + com.tencent.mm.sdk.platformtools.j.hju + "_main.xml", LYX);
      }
      for (;;)
      {
        if (!LYW) {
          break label231;
        }
        XWalkEnvironment.setTempPluginUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/test_" + com.tencent.mm.sdk.platformtools.j.hju + "_plugin.xml", LYX);
        break;
        XWalkEnvironment.setTempUpdateConfigUrl(LYY, LYX);
      }
      label231:
      XWalkEnvironment.setTempPluginUpdateConfigUrl(LYY, LYX);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean HS();
    
    public abstract String cog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cp.d
 * JD-Core Version:    0.7.0.1
 */