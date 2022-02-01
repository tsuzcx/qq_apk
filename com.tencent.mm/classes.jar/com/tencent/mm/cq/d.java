package com.tencent.mm.cq;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.e.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ah;
import com.tencent.xweb.ai;
import com.tencent.xweb.p.a;
import com.tencent.xweb.y;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class d
{
  static a LBR = null;
  static boolean LBS = false;
  static boolean LBT = false;
  static String LBU = null;
  static String LBV = null;
  static int LBW = 3600000;
  static long LBX = 3600000L;
  
  private static void a(Context paramContext, WebView.c paramc, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(152951);
    d.1 local1 = new d.1(paramPreInitCallback);
    paramPreInitCallback = paramContext;
    if (paramContext == null) {
      paramPreInitCallback = com.tencent.mm.sdk.platformtools.aj.getContext();
    }
    kQ(paramPreInitCallback);
    if ((i.DEBUG) || (i.IS_FLAVOR_RED) || (i.IS_FLAVOR_PURPLE) || (ad.getLogLevel() <= 1)) {}
    try
    {
      y.gaM().gaP();
      WebView.initWebviewCore(paramPreInitCallback, paramc, b.getModuleName(), local1);
      if (("mm".equals(b.getModuleName())) && (al.isDarkMode())) {
        ah.gbm();
      }
      if (fSx()) {
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
      AppMethodBeat.i(195499);
      LBR = parama;
      fSv();
      ad.i("XWebUtil", "setExpansionImp stack = ");
      AppMethodBeat.o(195499);
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
    AppMethodBeat.i(195501);
    a(MMWebView.KSk, paramPreInitCallback);
    AppMethodBeat.o(195501);
  }
  
  public static void a(WebView.c paramc)
  {
    AppMethodBeat.i(195500);
    a(paramc, null);
    AppMethodBeat.o(195500);
  }
  
  public static void a(WebView.c paramc, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(152950);
    a(com.tencent.mm.sdk.platformtools.aj.getContext(), paramc, paramPreInitCallback);
    AppMethodBeat.o(152950);
  }
  
  public static void aYU(String paramString)
  {
    AppMethodBeat.i(152945);
    aYV(paramString);
    aYW(paramString);
    AppMethodBeat.o(152945);
  }
  
  private static void aYV(String paramString)
  {
    AppMethodBeat.i(152947);
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!com.tencent.mm.sdk.platformtools.aj.aQt(com.tencent.mm.sdk.platformtools.aj.getPackageName() + ":tools")))
    {
      AppMethodBeat.o(152947);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(e.l.IUG, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    com.tencent.mm.sdk.platformtools.aj.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(152947);
  }
  
  public static void aYW(String paramString)
  {
    AppMethodBeat.i(152948);
    if (com.tencent.mm.bs.d.ahO())
    {
      AppMethodBeat.o(152948);
      return;
    }
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!com.tencent.mm.sdk.platformtools.aj.aQt(com.tencent.mm.sdk.platformtools.aj.getPackageName() + ":toolsmp")))
    {
      AppMethodBeat.o(152948);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(e.l.IUG, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    com.tencent.mm.sdk.platformtools.aj.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(152948);
  }
  
  public static void by(Intent paramIntent)
  {
    AppMethodBeat.i(152946);
    paramIntent.setComponent(new ComponentName(e.l.IUG, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    com.tencent.mm.sdk.platformtools.aj.getContext().sendBroadcast(paramIntent);
    if (com.tencent.mm.bs.d.ahO())
    {
      AppMethodBeat.o(152946);
      return;
    }
    paramIntent.setComponent(new ComponentName(e.l.IUG, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    com.tencent.mm.sdk.platformtools.aj.getContext().sendBroadcast(paramIntent);
    AppMethodBeat.o(152946);
  }
  
  public static void fSu()
  {
    AppMethodBeat.i(152944);
    aYV("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    aYW("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
    AppMethodBeat.o(152944);
  }
  
  /* Error */
  private static void fSv()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 256
    //   6: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 25	com/tencent/mm/cq/d:LBR	Lcom/tencent/mm/cq/d$a;
    //   12: ifnonnull +25 -> 37
    //   15: ldc 138
    //   17: ldc_w 258
    //   20: invokestatic 261	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: iconst_0
    //   24: invokestatic 266	com/tencent/xweb/ai:zH	(Z)V
    //   27: ldc_w 256
    //   30: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: ldc 2
    //   35: monitorexit
    //   36: return
    //   37: ldc 138
    //   39: ldc_w 268
    //   42: invokestatic 170	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: getstatic 25	com/tencent/mm/cq/d:LBR	Lcom/tencent/mm/cq/d$a;
    //   48: invokeinterface 271 1 0
    //   53: istore_0
    //   54: iload_0
    //   55: invokestatic 266	com/tencent/xweb/ai:zH	(Z)V
    //   58: iload_0
    //   59: ifeq +14 -> 73
    //   62: getstatic 25	com/tencent/mm/cq/d:LBR	Lcom/tencent/mm/cq/d$a;
    //   65: invokeinterface 274 1 0
    //   70: invokestatic 277	com/tencent/xweb/ai:bbf	(Ljava/lang/String;)V
    //   73: ldc_w 256
    //   76: invokestatic 136	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  private static void fSw()
  {
    AppMethodBeat.i(152953);
    HashMap localHashMap = new HashMap();
    localHashMap.put("isgpversion", Boolean.valueOf(com.tencent.mm.sdk.platformtools.j.fjZ()));
    localHashMap.put("processname", com.tencent.mm.sdk.platformtools.aj.getProcessName());
    localHashMap.put("is64bitabi", Boolean.valueOf(q.is64BitRuntime()));
    XWalkEnvironment.setXWebInitArgs(localHashMap);
    AppMethodBeat.o(152953);
  }
  
  public static boolean fSx()
  {
    AppMethodBeat.i(152954);
    if (WebView.getCurWebType() == WebView.c.Mqu)
    {
      boolean bool = XWalkEnvironment.isCurrentVersionSupportCustomContext();
      AppMethodBeat.o(152954);
      return bool;
    }
    AppMethodBeat.o(152954);
    return false;
  }
  
  public static boolean kP(Context paramContext)
  {
    AppMethodBeat.i(152949);
    if ((WebView.isX5()) && (WebView.getUsingTbsCoreVersion(paramContext) <= 36541))
    {
      ad.i("XWebUtil", "lower version of x5 not support source type ");
      AppMethodBeat.o(152949);
      return false;
    }
    AppMethodBeat.o(152949);
    return true;
  }
  
  public static void kQ(Context paramContext)
  {
    AppMethodBeat.i(152952);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = com.tencent.mm.sdk.platformtools.aj.getContext();
    }
    com.tencent.xweb.p.MpG = new p.a()
    {
      public final void vr(String paramAnonymousString)
      {
        AppMethodBeat.i(195498);
        com.tencent.mm.compatible.util.j.vr(paramAnonymousString);
        AppMethodBeat.o(195498);
      }
    };
    com.tencent.xweb.aj.a(localContext, b.LBM, b.LBP, b.LBN, b.LBO);
    ah.gbl();
    if ((i.IS_FLAVOR_RED) || (i.IS_FLAVOR_PURPLE) || (i.DEBUG))
    {
      XWalkEnvironment.setTempUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      XWalkEnvironment.setTempPluginUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_exp.xml");
    }
    for (;;)
    {
      XWalkEnvironment.setTempPluginUpdatePeriod(LBW);
      XWalkEnvironment.setConfigFetchPeriod(LBX);
      do
      {
        fSv();
        ai.zI(com.tencent.mm.sdk.platformtools.j.fjZ());
        XWalkEnvironment.setAppClientVersion(i.Ics);
        fSw();
        if (com.tencent.mm.sdk.platformtools.j.fjZ())
        {
          com.tencent.xweb.x5.sdk.d.forceSysWebView();
          XWalkEnvironment.appendAppInfo("GP_USER");
        }
        AppMethodBeat.o(152952);
        return;
        if (com.tencent.mm.protocal.d.Fnm) {
          break;
        }
      } while (!com.tencent.mm.protocal.d.Fnl);
      if (LBS) {
        XWalkEnvironment.setTempUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/test_" + i.hgG + "_main.xml");
      }
      for (;;)
      {
        if (!LBT) {
          break label219;
        }
        XWalkEnvironment.setTempPluginUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/test_" + i.hgG + "_plugin.xml");
        break;
        XWalkEnvironment.setTempUpdateConfigUrl(LBU);
      }
      label219:
      XWalkEnvironment.setTempPluginUpdateConfigUrl(LBU);
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean HK();
    
    public abstract String cmQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cq.d
 * JD-Core Version:    0.7.0.1
 */