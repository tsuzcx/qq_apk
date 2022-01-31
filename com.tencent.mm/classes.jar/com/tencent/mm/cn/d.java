package com.tencent.mm.cn;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.e.k;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.ac;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;

public final class d
{
  private static void a(Context paramContext, WebView.d paramd, WebView.c paramc)
  {
    AppMethodBeat.i(80417);
    d.1 local1 = new d.1(paramc);
    paramc = paramContext;
    if (paramContext == null) {
      paramc = ah.getContext();
    }
    iO(paramc);
    WebView.initWebviewCore(paramc, paramd, b.dTi(), local1);
    if (dTk()) {
      XWalkEnvironment.setUsingCustomContext(true);
    }
    AppMethodBeat.o(80417);
  }
  
  public static void a(WebView.d paramd, WebView.c paramc)
  {
    AppMethodBeat.i(80416);
    a(ah.getContext(), paramd, paramc);
    AppMethodBeat.o(80416);
  }
  
  public static void aNX()
  {
    AppMethodBeat.i(80409);
    awn("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
    awo("com.tencent.mm.intent.ACTION_START_MPTOOLS_PROCESS");
    AppMethodBeat.o(80409);
  }
  
  public static void aX(Intent paramIntent)
  {
    AppMethodBeat.i(80411);
    paramIntent.setComponent(new ComponentName(e.k.iXz, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    ah.getContext().sendBroadcast(paramIntent);
    if (com.tencent.mm.bq.d.Qa())
    {
      AppMethodBeat.o(80411);
      return;
    }
    paramIntent.setComponent(new ComponentName(e.k.iXz, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    ah.getContext().sendBroadcast(paramIntent);
    AppMethodBeat.o(80411);
  }
  
  public static void awm(String paramString)
  {
    AppMethodBeat.i(80410);
    awn(paramString);
    awo(paramString);
    AppMethodBeat.o(80410);
  }
  
  private static void awn(String paramString)
  {
    AppMethodBeat.i(80412);
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!ah.apj(ah.getPackageName() + ":tools")))
    {
      AppMethodBeat.o(80412);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(e.k.iXz, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    ah.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(80412);
  }
  
  public static void awo(String paramString)
  {
    AppMethodBeat.i(80413);
    if (com.tencent.mm.bq.d.Qa())
    {
      AppMethodBeat.o(80413);
      return;
    }
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!ah.apj(ah.getPackageName() + ":toolsmp")))
    {
      AppMethodBeat.o(80413);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(e.k.iXz, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    ah.getContext().sendBroadcast(localIntent);
    AppMethodBeat.o(80413);
  }
  
  private static void dTj()
  {
    AppMethodBeat.i(80419);
    HashMap localHashMap = new HashMap();
    localHashMap.put("isgpversion", Boolean.valueOf(g.dsn()));
    localHashMap.put("processname", ah.getProcessName());
    XWalkEnvironment.setXWebInitArgs(localHashMap);
    AppMethodBeat.o(80419);
  }
  
  public static boolean dTk()
  {
    AppMethodBeat.i(80420);
    if (WebView.getCurWebType() == WebView.d.BEq)
    {
      boolean bool = XWalkEnvironment.isCurrentVersionSupportCustomContext();
      AppMethodBeat.o(80420);
      return bool;
    }
    AppMethodBeat.o(80420);
    return false;
  }
  
  public static boolean iN(Context paramContext)
  {
    AppMethodBeat.i(80414);
    if ((WebView.isX5()) && (WebView.getUsingTbsCoreVersion(paramContext) <= 36541))
    {
      ab.i("XWebUtil", "lower version of x5 not support source type ");
      AppMethodBeat.o(80414);
      return false;
    }
    AppMethodBeat.o(80414);
    return true;
  }
  
  public static void iO(Context paramContext)
  {
    AppMethodBeat.i(80418);
    Context localContext = paramContext;
    if (paramContext == null) {
      localContext = ah.getContext();
    }
    ac.a(localContext, b.AZH, b.AZK, b.AZI, b.AZJ);
    if ((com.tencent.mm.protocal.d.whH <= 654312495) && (com.tencent.mm.protocal.d.whH >= 654312448)) {
      MMWebView.ADY = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_mar_test.xml";
    }
    if ((com.tencent.mm.protocal.d.whH >= 654312704) && (com.tencent.mm.protocal.d.whH <= 654312751))
    {
      MMWebView.ADY = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_xfiles_test.xml";
      MMWebView.ADZ = "https://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_xfiles_test.xml";
      MMWebView.AEa = 10800000;
    }
    XWalkEnvironment.setTempUpdateConfigUrl(MMWebView.ADY);
    XWalkEnvironment.setTempPluginUpdateConfigUrl(MMWebView.ADZ);
    XWalkEnvironment.setTempPluginUpdatePeriod(MMWebView.AEa);
    XWalkEnvironment.setIsForbidDownloadCode(g.dsn());
    dTj();
    if (g.dsn()) {
      com.tencent.xweb.x5.sdk.d.forceSysWebView();
    }
    AppMethodBeat.o(80418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cn.d
 * JD-Core Version:    0.7.0.1
 */