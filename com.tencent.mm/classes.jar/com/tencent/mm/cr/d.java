package com.tencent.mm.cr;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.e.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.af;
import com.tencent.xweb.ag;
import com.tencent.xweb.ah;
import com.tencent.xweb.o.a;
import com.tencent.xweb.x;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class d
{
  static a IgG = null;
  
  private static void a(Context paramContext, WebView.c paramc, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(152951);
    d.1 local1 = new d.1(paramPreInitCallback);
    paramPreInitCallback = paramContext;
    if (paramContext == null) {
      paramPreInitCallback = aj.getContext();
    }
    ks(paramPreInitCallback);
    if ((h.DEBUG) || (h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE) || (ad.getLogLevel() <= 1)) {}
    try
    {
      x.fqR().fqU();
      WebView.initWebviewCore(paramPreInitCallback, paramc, b.getModuleName(), local1);
      if (("mm".equals(b.getModuleName())) && (ai.Eq())) {
        af.frq();
      }
      if (fkS()) {
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
      AppMethodBeat.i(190807);
      IgG = parama;
      fkQ();
      ad.i("XWebUtil", "setExpansionImp stack = ");
      AppMethodBeat.o(190807);
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
    AppMethodBeat.i(190809);
    a(MMWebView.HAC, paramPreInitCallback);
    AppMethodBeat.o(190809);
  }
  
  public static void a(WebView.c paramc)
  {
    AppMethodBeat.i(190808);
    a(paramc, null);
    AppMethodBeat.o(190808);
  }
  
  public static void a(WebView.c paramc, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(152950);
    a(aj.getContext(), paramc, paramPreInitCallback);
    AppMethodBeat.o(152950);
  }
  
  public static void aNr(String paramString)
  {
    AppMethodBeat.i(152945);
    aNs(paramString);
    aNt(paramString);
    AppMethodBeat.o(152945);
  }
  
  private static void aNs(String paramString)
  {
    AppMethodBeat.i(152947);
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!aj.aFw(aj.getPackageName() + ":tools")))
    {
      AppMethodBeat.o(152947);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(e.l.FIi, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    aj.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(152947);
  }
  
  public static void aNt(String paramString)
  {
    AppMethodBeat.i(152948);
    if (com.tencent.mm.bs.d.adM())
    {
      AppMethodBeat.o(152948);
      return;
    }
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!aj.aFw(aj.getPackageName() + ":toolsmp")))
    {
      AppMethodBeat.o(152948);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(e.l.FIi, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    aj.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(152948);
  }
  
  public static void bs(Intent paramIntent)
  {
    AppMethodBeat.i(152946);
    paramIntent.setComponent(new ComponentName(e.l.FIi, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    aj.getContext().sendBroadcast(paramIntent);
    if (com.tencent.mm.bs.d.adM())
    {
      AppMethodBeat.o(152946);
      return;
    }
    paramIntent.setComponent(new ComponentName(e.l.FIi, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    aj.getContext().sendBroadcast(paramIntent);
    AppMethodBeat.o(152946);
  }
  
  public static void fkP()
  {
    AppMethodBeat.i(152944);
    aNs("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    aNt("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
    AppMethodBeat.o(152944);
  }
  
  /* Error */
  private static void fkQ()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 233
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 15	com/tencent/mm/cr/d:IgG	Lcom/tencent/mm/cr/d$a;
    //   11: ifnonnull +23 -> 34
    //   14: ldc 114
    //   16: ldc 235
    //   18: invokestatic 238	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: iconst_0
    //   22: invokestatic 243	com/tencent/xweb/ag:xD	(Z)V
    //   25: ldc 233
    //   27: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: return
    //   34: ldc 114
    //   36: ldc 245
    //   38: invokestatic 146	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: getstatic 15	com/tencent/mm/cr/d:IgG	Lcom/tencent/mm/cr/d$a;
    //   44: invokeinterface 248 1 0
    //   49: istore_0
    //   50: iload_0
    //   51: invokestatic 243	com/tencent/xweb/ag:xD	(Z)V
    //   54: iload_0
    //   55: ifeq +14 -> 69
    //   58: getstatic 15	com/tencent/mm/cr/d:IgG	Lcom/tencent/mm/cr/d$a;
    //   61: invokeinterface 251 1 0
    //   66: invokestatic 254	com/tencent/xweb/ag:aPj	(Ljava/lang/String;)V
    //   69: ldc 233
    //   71: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: goto -44 -> 30
    //   77: astore_1
    //   78: ldc 2
    //   80: monitorexit
    //   81: aload_1
    //   82: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   49	6	0	bool	boolean
    //   77	5	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	30	77	finally
    //   34	54	77	finally
    //   58	69	77	finally
    //   69	74	77	finally
  }
  
  private static void fkR()
  {
    AppMethodBeat.i(152953);
    HashMap localHashMap = new HashMap();
    localHashMap.put("isgpversion", Boolean.valueOf(i.eFb()));
    localHashMap.put("processname", aj.getProcessName());
    localHashMap.put("is64bitabi", Boolean.valueOf(q.is64BitRuntime()));
    XWalkEnvironment.setXWebInitArgs(localHashMap);
    AppMethodBeat.o(152953);
  }
  
  public static boolean fkS()
  {
    AppMethodBeat.i(152954);
    if (WebView.getCurWebType() == WebView.c.INC)
    {
      boolean bool = XWalkEnvironment.isCurrentVersionSupportCustomContext();
      AppMethodBeat.o(152954);
      return bool;
    }
    AppMethodBeat.o(152954);
    return false;
  }
  
  public static boolean kr(Context paramContext)
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
  
  public static void ks(Context paramContext)
  {
    AppMethodBeat.i(152952);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = aj.getContext();
    }
    com.tencent.xweb.o.IMN = new o.a()
    {
      public final void pq(String paramAnonymousString)
      {
        AppMethodBeat.i(190806);
        j.pq(paramAnonymousString);
        AppMethodBeat.o(190806);
      }
    };
    ah.a(localContext, b.IgB, b.IgE, b.IgC, b.IgD);
    af.frp();
    if ((h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE) || (h.DEBUG))
    {
      XWalkEnvironment.setTempUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      XWalkEnvironment.setTempPluginUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_exp.xml");
      XWalkEnvironment.setTempPluginUpdatePeriod(MMWebView.HAF);
      XWalkEnvironment.setConfigFetchPeriod(MMWebView.HAG);
    }
    for (;;)
    {
      fkQ();
      ag.xE(i.eFb());
      XWalkEnvironment.setAppClientVersion(h.ETr);
      fkR();
      if (i.eFb())
      {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
        XWalkEnvironment.appendAppInfo("GP_USER");
      }
      AppMethodBeat.o(152952);
      return;
      if (com.tencent.mm.protocal.d.CpN)
      {
        XWalkEnvironment.setTempUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/uitrhead_block.xml");
        XWalkEnvironment.setTempPluginUpdatePeriod(MMWebView.HAF);
        XWalkEnvironment.setConfigFetchPeriod(MMWebView.HAG);
      }
      else if (com.tencent.mm.protocal.d.CpM)
      {
        XWalkEnvironment.setTempUpdateConfigUrl(MMWebView.HAD);
        XWalkEnvironment.setTempPluginUpdateConfigUrl(MMWebView.HAE);
        XWalkEnvironment.setTempPluginUpdatePeriod(MMWebView.HAF);
        XWalkEnvironment.setConfigFetchPeriod(MMWebView.HAG);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean GE();
    
    public abstract String cbd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.cr.d
 * JD-Core Version:    0.7.0.1
 */