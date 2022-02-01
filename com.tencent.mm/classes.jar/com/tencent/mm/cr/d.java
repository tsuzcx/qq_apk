package com.tencent.mm.cr;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.g.a.abg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.e.n;
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
import org.xwalk.core.XWalkEnvironment;

public final class d
{
  static a Rzm = null;
  static boolean Rzn = true;
  static boolean Rzo = true;
  static String Rzp = "20201215";
  static String Rzq = null;
  static String Rzr = null;
  static int Rzs = 3600000;
  static long Rzt = 3600000L;
  
  private static void a(Context paramContext, WebView.c paramc, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(152951);
    WebView.PreInitCallback local1 = new WebView.PreInitCallback()
    {
      public final void btl()
      {
        AppMethodBeat.i(152943);
        com.tencent.mm.sdk.platformtools.Log.i("XWebUtil", "onCoreInitFailed");
        abg localabg = new abg();
        localabg.eiA.success = false;
        EventCenter.instance.publish(localabg);
        if (this.Rzu != null) {
          this.Rzu.btl();
        }
        AppMethodBeat.o(152943);
      }
      
      public final void onCoreInitFinished()
      {
        AppMethodBeat.i(152942);
        com.tencent.mm.sdk.platformtools.Log.i("XWebUtil", "onCoreInitFinished");
        abg localabg = new abg();
        localabg.eiA.success = true;
        EventCenter.instance.publish(localabg);
        if (this.Rzu != null) {
          this.Rzu.onCoreInitFinished();
        }
        AppMethodBeat.o(152942);
      }
    };
    paramPreInitCallback = paramContext;
    if (paramContext == null) {
      paramPreInitCallback = MMApplicationContext.getContext();
    }
    kT(paramPreInitCallback);
    if ((BuildInfo.DEBUG) || (BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.Log.getLogLevel() <= 1)) {}
    try
    {
      y.hsF().hsI();
      WebView.initWebviewCore(paramPreInitCallback, paramc, b.getModuleName(), local1);
      if (("mm".equals(b.getModuleName())) && (ao.isDarkMode())) {
        ah.htg();
      }
      if (hiB()) {
        XWalkEnvironment.setUsingCustomContext(true);
      }
      AppMethodBeat.o(152951);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        org.xwalk.core.Log.e("XWebUtil", "turn on xweb debug failed , exp = " + paramContext.getMessage());
      }
    }
  }
  
  public static void a(a parama)
  {
    try
    {
      AppMethodBeat.i(223920);
      Rzm = parama;
      hiz();
      com.tencent.mm.sdk.platformtools.Log.i("XWebUtil", "setExpansionImp stack = ");
      AppMethodBeat.o(223920);
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
    AppMethodBeat.i(223922);
    a(MMWebView.QDR, paramPreInitCallback);
    AppMethodBeat.o(223922);
  }
  
  public static void a(WebView.c paramc)
  {
    AppMethodBeat.i(223921);
    a(paramc, null);
    AppMethodBeat.o(223921);
  }
  
  public static void a(WebView.c paramc, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(152950);
    a(MMApplicationContext.getContext(), paramc, paramPreInitCallback);
    AppMethodBeat.o(152950);
  }
  
  public static void bJ(Intent paramIntent)
  {
    AppMethodBeat.i(152946);
    paramIntent.setComponent(new ComponentName(e.n.Ozn, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    MMApplicationContext.getContext().sendBroadcast(paramIntent);
    if (c.ayt())
    {
      AppMethodBeat.o(152946);
      return;
    }
    paramIntent.setComponent(new ComponentName(e.n.Ozn, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    MMApplicationContext.getContext().sendBroadcast(paramIntent);
    AppMethodBeat.o(152946);
  }
  
  public static void bpG(String paramString)
  {
    AppMethodBeat.i(152945);
    bpH(paramString);
    bpI(paramString);
    AppMethodBeat.o(152945);
  }
  
  private static void bpH(String paramString)
  {
    AppMethodBeat.i(152947);
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":tools")))
    {
      AppMethodBeat.o(152947);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(e.n.Ozn, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(152947);
  }
  
  public static void bpI(String paramString)
  {
    AppMethodBeat.i(152948);
    if (c.ayt())
    {
      AppMethodBeat.o(152948);
      return;
    }
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!MMApplicationContext.isProcessExist(MMApplicationContext.getPackageName() + ":toolsmp")))
    {
      AppMethodBeat.o(152948);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(e.n.Ozn, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    MMApplicationContext.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(152948);
  }
  
  private static void hiA()
  {
    AppMethodBeat.i(152953);
    HashMap localHashMap = new HashMap();
    localHashMap.put("isgpversion", Boolean.valueOf(ChannelUtil.isGPVersion()));
    localHashMap.put("processname", MMApplicationContext.getProcessName());
    localHashMap.put("is64bitabi", Boolean.valueOf(q.is64BitRuntime()));
    XWalkEnvironment.setXWebInitArgs(localHashMap);
    AppMethodBeat.o(152953);
  }
  
  public static boolean hiB()
  {
    AppMethodBeat.i(152954);
    if (WebView.getCurWebType() == WebView.c.SAt)
    {
      boolean bool = XWalkEnvironment.isCurrentVersionSupportCustomContext();
      AppMethodBeat.o(152954);
      return bool;
    }
    AppMethodBeat.o(152954);
    return false;
  }
  
  public static void hiy()
  {
    AppMethodBeat.i(152944);
    bpH("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    bpI("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
    AppMethodBeat.o(152944);
  }
  
  /* Error */
  private static void hiz()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 312
    //   6: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: getstatic 28	com/tencent/mm/cr/d:Rzm	Lcom/tencent/mm/cr/d$a;
    //   12: ifnonnull +25 -> 37
    //   15: ldc 143
    //   17: ldc_w 314
    //   20: invokestatic 317	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: iconst_0
    //   24: invokestatic 322	com/tencent/xweb/ai:Ek	(Z)V
    //   27: ldc_w 312
    //   30: invokestatic 141	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: ldc 2
    //   35: monitorexit
    //   36: return
    //   37: ldc 143
    //   39: ldc_w 324
    //   42: invokestatic 175	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   45: getstatic 28	com/tencent/mm/cr/d:Rzm	Lcom/tencent/mm/cr/d$a;
    //   48: invokeinterface 327 1 0
    //   53: istore_0
    //   54: iload_0
    //   55: invokestatic 322	com/tencent/xweb/ai:Ek	(Z)V
    //   58: iload_0
    //   59: ifeq +14 -> 73
    //   62: getstatic 28	com/tencent/mm/cr/d:Rzm	Lcom/tencent/mm/cr/d$a;
    //   65: invokeinterface 330 1 0
    //   70: invokestatic 333	com/tencent/xweb/ai:bss	(Ljava/lang/String;)V
    //   73: ldc_w 312
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
  
  public static boolean kS(Context paramContext)
  {
    AppMethodBeat.i(152949);
    if ((WebView.isX5()) && (WebView.getUsingTbsCoreVersion(paramContext) <= 36541))
    {
      com.tencent.mm.sdk.platformtools.Log.i("XWebUtil", "lower version of x5 not support source type ");
      AppMethodBeat.o(152949);
      return false;
    }
    AppMethodBeat.o(152949);
    return true;
  }
  
  public static void kT(Context paramContext)
  {
    AppMethodBeat.i(152952);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = MMApplicationContext.getContext();
    }
    com.tencent.xweb.p.SzF = new p.a()
    {
      public final void Ed(String paramAnonymousString)
      {
        AppMethodBeat.i(223919);
        j.Ed(paramAnonymousString);
        AppMethodBeat.o(223919);
      }
    };
    aj.a(localContext, b.Rzh, b.Rzk, b.Rzi, b.Rzj);
    ah.htf();
    if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.IS_FLAVOR_PURPLE) || (BuildInfo.DEBUG))
    {
      XWalkEnvironment.setTempUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      XWalkEnvironment.setTempPluginUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_exp.xml");
    }
    for (;;)
    {
      XWalkEnvironment.setTempPluginUpdatePeriod(Rzs);
      XWalkEnvironment.setConfigFetchPeriod(Rzt);
      do
      {
        hiz();
        ai.El(ChannelUtil.isGPVersion());
        XWalkEnvironment.setAppClientVersion(BuildInfo.CLIENT_VERSION_INT);
        hiA();
        if (ChannelUtil.isGPVersion())
        {
          com.tencent.xweb.x5.sdk.d.forceSysWebView();
          XWalkEnvironment.appendAppInfo("GP_USER");
        }
        AppMethodBeat.o(152952);
        return;
        if (com.tencent.mm.protocal.d.KyR) {
          break;
        }
      } while (!com.tencent.mm.protocal.d.KyQ);
      if (Rzn) {
        XWalkEnvironment.setTempUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/test_" + BuildInfo.CLIENT_VERSION + "_main.xml", Rzp);
      }
      for (;;)
      {
        if (!Rzo) {
          break label231;
        }
        XWalkEnvironment.setTempPluginUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/test_" + BuildInfo.CLIENT_VERSION + "_plugin.xml", Rzp);
        break;
        XWalkEnvironment.setTempUpdateConfigUrl(Rzq, Rzp);
      }
      label231:
      XWalkEnvironment.setTempPluginUpdateConfigUrl(Rzq, Rzp);
    }
  }
  
  public static abstract interface a
  {
    public abstract String cMs();
    
    public abstract boolean isInstalled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cr.d
 * JD-Core Version:    0.7.0.1
 */