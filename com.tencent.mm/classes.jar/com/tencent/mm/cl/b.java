package com.tencent.mm.cl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.e.i;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;
import com.tencent.xweb.WebView.d;
import com.tencent.xweb.r;
import com.tencent.xweb.t;
import com.tencent.xweb.x5.sdk.d;
import java.util.HashMap;
import org.xwalk.core.WebViewExtensionListener;
import org.xwalk.core.XWalkEnvironment;

public final class b
{
  public static void a(WebView.d paramd, WebView.c paramc)
  {
    Context localContext2 = ae.getContext();
    com.tencent.xweb.util.b localb = a.wDk;
    r localr = a.wDl;
    WebViewExtensionListener localWebViewExtensionListener = a.wDm;
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = ae.getContext();
    }
    XWalkEnvironment.setTempUpdateConfigUrl(MMWebView.wkq);
    t.a(localContext1, localb, localr, localWebViewExtensionListener);
    cND();
    if (e.cqq()) {
      d.forceSysWebView();
    }
    WebView.initWebviewCore(localContext1, paramd, a.cNC(), paramc);
  }
  
  public static void afs(String paramString)
  {
    if ((!"com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) || (ae.Zl(ae.getPackageName() + ":tools")))
    {
      Intent localIntent = new Intent();
      localIntent.setComponent(new ComponentName(e.i.hle, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
      localIntent.putExtra("tools_process_action_code_key", paramString);
      ae.getContext().sendBroadcast(localIntent);
    }
    aft(paramString);
  }
  
  public static void aft(String paramString)
  {
    if (("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS".equals(paramString)) && (!ae.Zl(ae.getPackageName() + ":toolsmp"))) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setComponent(new ComponentName(e.i.hle, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    localIntent.putExtra("tools_process_action_code_key", paramString);
    ae.getContext().sendBroadcast(localIntent);
  }
  
  public static void av(Intent paramIntent)
  {
    paramIntent.setComponent(new ComponentName(e.i.hle, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
    ae.getContext().sendBroadcast(paramIntent);
    paramIntent.setComponent(new ComponentName(e.i.hle, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
    ae.getContext().sendBroadcast(paramIntent);
  }
  
  public static void cND()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("isgpversion", Boolean.valueOf(e.cqq()));
    localHashMap.put("processname", ae.getProcessName());
    XWalkEnvironment.setXWebInitArgs(localHashMap);
  }
  
  public static boolean ho(Context paramContext)
  {
    if ((WebView.isX5()) && (WebView.getUsingTbsCoreVersion(paramContext) <= 36541))
    {
      y.i("XWebUtil", "lower version of x5 not support source type ");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.cl.b
 * JD-Core Version:    0.7.0.1
 */