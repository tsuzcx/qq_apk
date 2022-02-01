package com.tencent.mm.cq;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.ui.e.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.PreInitCallback;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.ah;
import com.tencent.xweb.p.a;
import com.tencent.xweb.y;
import java.util.HashMap;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public final class d
{
  static a JIo = null;
  
  private static void a(Context paramContext, WebView.c paramc, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(152951);
    d.1 local1 = new d.1(paramPreInitCallback);
    paramPreInitCallback = paramContext;
    if (paramContext == null) {
      paramPreInitCallback = com.tencent.mm.sdk.platformtools.ai.getContext();
    }
    kE(paramPreInitCallback);
    if ((h.DEBUG) || (h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE) || (ac.getLogLevel() <= 1)) {}
    try
    {
      y.fJs().fJv();
      WebView.initWebviewCore(paramPreInitCallback, paramc, b.getModuleName(), local1);
      if (("mm".equals(b.getModuleName())) && (com.tencent.mm.ui.aj.DT())) {
        ah.fJS();
      }
      if (fBi()) {
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
      AppMethodBeat.i(192733);
      JIo = parama;
      fBg();
      ac.i("XWebUtil", "setExpansionImp stack = ");
      AppMethodBeat.o(192733);
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
    AppMethodBeat.i(192735);
    a(MMWebView.JaZ, paramPreInitCallback);
    AppMethodBeat.o(192735);
  }
  
  public static void a(WebView.c paramc)
  {
    AppMethodBeat.i(192734);
    a(paramc, null);
    AppMethodBeat.o(192734);
  }
  
  public static void a(WebView.c paramc, WebView.PreInitCallback paramPreInitCallback)
  {
    AppMethodBeat.i(152950);
    a(com.tencent.mm.sdk.platformtools.ai.getContext(), paramc, paramPreInitCallback);
    AppMethodBeat.o(152950);
  }
  
  public static void aSU(String paramString)
  {
    AppMethodBeat.i(152945);
    aSV(paramString);
    aSW(paramString);
    AppMethodBeat.o(152945);
  }
  
  private static void aSV(String paramString)
  {
    AppMethodBeat.i(152947);
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!com.tencent.mm.sdk.platformtools.ai.aKN(com.tencent.mm.sdk.platformtools.ai.getPackageName() + ":tools")))
    {
      AppMethodBeat.o(152947);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(e.l.Hhq, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    com.tencent.mm.sdk.platformtools.ai.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(152947);
  }
  
  public static void aSW(String paramString)
  {
    AppMethodBeat.i(152948);
    if (com.tencent.mm.br.d.afc())
    {
      AppMethodBeat.o(152948);
      return;
    }
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!com.tencent.mm.sdk.platformtools.ai.aKN(com.tencent.mm.sdk.platformtools.ai.getPackageName() + ":toolsmp")))
    {
      AppMethodBeat.o(152948);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(e.l.Hhq, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    com.tencent.mm.sdk.platformtools.ai.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(152948);
  }
  
  public static void bt(Intent paramIntent)
  {
    AppMethodBeat.i(152946);
    paramIntent.setComponent(new ComponentName(e.l.Hhq, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    com.tencent.mm.sdk.platformtools.ai.getContext().sendBroadcast(paramIntent);
    if (com.tencent.mm.br.d.afc())
    {
      AppMethodBeat.o(152946);
      return;
    }
    paramIntent.setComponent(new ComponentName(e.l.Hhq, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    com.tencent.mm.sdk.platformtools.ai.getContext().sendBroadcast(paramIntent);
    AppMethodBeat.o(152946);
  }
  
  public static void fBf()
  {
    AppMethodBeat.i(152944);
    aSV("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    aSW("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
    AppMethodBeat.o(152944);
  }
  
  /* Error */
  private static void fBg()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 233
    //   5: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 15	com/tencent/mm/cq/d:JIo	Lcom/tencent/mm/cq/d$a;
    //   11: ifnonnull +23 -> 34
    //   14: ldc 114
    //   16: ldc 235
    //   18: invokestatic 238	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: iconst_0
    //   22: invokestatic 243	com/tencent/xweb/ai:yU	(Z)V
    //   25: ldc 233
    //   27: invokestatic 112	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: ldc 2
    //   32: monitorexit
    //   33: return
    //   34: ldc 114
    //   36: ldc 245
    //   38: invokestatic 146	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: getstatic 15	com/tencent/mm/cq/d:JIo	Lcom/tencent/mm/cq/d$a;
    //   44: invokeinterface 248 1 0
    //   49: istore_0
    //   50: iload_0
    //   51: invokestatic 243	com/tencent/xweb/ai:yU	(Z)V
    //   54: iload_0
    //   55: ifeq +14 -> 69
    //   58: getstatic 15	com/tencent/mm/cq/d:JIo	Lcom/tencent/mm/cq/d$a;
    //   61: invokeinterface 251 1 0
    //   66: invokestatic 254	com/tencent/xweb/ai:aVc	(Ljava/lang/String;)V
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
  
  private static void fBh()
  {
    AppMethodBeat.i(152953);
    HashMap localHashMap = new HashMap();
    localHashMap.put("isgpversion", Boolean.valueOf(i.eUv()));
    localHashMap.put("processname", com.tencent.mm.sdk.platformtools.ai.getProcessName());
    localHashMap.put("is64bitabi", Boolean.valueOf(q.is64BitRuntime()));
    XWalkEnvironment.setXWebInitArgs(localHashMap);
    AppMethodBeat.o(152953);
  }
  
  public static boolean fBi()
  {
    AppMethodBeat.i(152954);
    if (WebView.getCurWebType() == WebView.c.KzZ)
    {
      boolean bool = XWalkEnvironment.isCurrentVersionSupportCustomContext();
      AppMethodBeat.o(152954);
      return bool;
    }
    AppMethodBeat.o(152954);
    return false;
  }
  
  public static boolean kD(Context paramContext)
  {
    AppMethodBeat.i(152949);
    if ((WebView.isX5()) && (WebView.getUsingTbsCoreVersion(paramContext) <= 36541))
    {
      ac.i("XWebUtil", "lower version of x5 not support source type ");
      AppMethodBeat.o(152949);
      return false;
    }
    AppMethodBeat.o(152949);
    return true;
  }
  
  public static void kE(Context paramContext)
  {
    AppMethodBeat.i(152952);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = com.tencent.mm.sdk.platformtools.ai.getContext();
    }
    com.tencent.xweb.p.Kzl = new p.a()
    {
      public final void sC(String paramAnonymousString)
      {
        AppMethodBeat.i(192732);
        j.sC(paramAnonymousString);
        AppMethodBeat.o(192732);
      }
    };
    com.tencent.xweb.aj.a(localContext, b.JIj, b.JIm, b.JIk, b.JIl);
    ah.fJR();
    if ((h.IS_FLAVOR_RED) || (h.IS_FLAVOR_PURPLE) || (h.DEBUG))
    {
      XWalkEnvironment.setTempUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      XWalkEnvironment.setTempPluginUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_exp.xml");
      XWalkEnvironment.setTempPluginUpdatePeriod(MMWebView.Jbc);
      XWalkEnvironment.setConfigFetchPeriod(MMWebView.Jbd);
    }
    for (;;)
    {
      fBg();
      com.tencent.xweb.ai.yV(i.eUv());
      XWalkEnvironment.setAppClientVersion(h.GqE);
      fBh();
      if (i.eUv())
      {
        com.tencent.xweb.x5.sdk.d.forceSysWebView();
        XWalkEnvironment.appendAppInfo("GP_USER");
      }
      AppMethodBeat.o(152952);
      return;
      if (com.tencent.mm.protocal.d.DIf)
      {
        XWalkEnvironment.setTempUpdateConfigUrl("https://dldir1.qq.com/weixin/android/wxweb/uitrhead_block.xml");
        XWalkEnvironment.setTempPluginUpdatePeriod(MMWebView.Jbc);
        XWalkEnvironment.setConfigFetchPeriod(MMWebView.Jbd);
      }
      else if (com.tencent.mm.protocal.d.DIe)
      {
        XWalkEnvironment.setTempUpdateConfigUrl(MMWebView.Jba);
        XWalkEnvironment.setTempPluginUpdateConfigUrl(MMWebView.Jbb);
        XWalkEnvironment.setTempPluginUpdatePeriod(MMWebView.Jbc);
        XWalkEnvironment.setConfigFetchPeriod(MMWebView.Jbd);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean Gp();
    
    public abstract String cim();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.cq.d
 * JD-Core Version:    0.7.0.1
 */