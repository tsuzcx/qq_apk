package com.tencent.mm.modelstat;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;

public final class d
{
  private static d eCD;
  private d.a eCB = new d.a();
  private HashSet<String> eCC = new HashSet();
  
  private d()
  {
    this.eCC.add("com.tencent.mm.ui.LauncherUI");
    this.eCC.add("com.tencent.mm.plugin.profile.ui.ContactInfoUI");
    this.eCC.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    this.eCC.add("com.tencent.mm.ui.conversation.BizConversationUI");
    this.eCC.add("com.tencent.mm.ui.chatting.ChattingUI");
    this.eCC.add("com.tencent.mm.plugin.label.ui.ContactLabelEditUI");
    this.eCC.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI");
    this.eCC.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI1");
    this.eCC.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI2");
    this.eCC.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI3");
    this.eCC.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI4");
  }
  
  public static boolean Ro()
  {
    d.a locala = Rp().eCB;
    return locala.eCG > locala.eCH;
  }
  
  public static d Rp()
  {
    if (eCD == null) {}
    try
    {
      if (eCD == null) {
        eCD = new d();
      }
      return eCD;
    }
    finally {}
  }
  
  public static void b(int paramInt1, String paramString, int paramInt2)
  {
    Intent localIntent = new Intent("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT");
    localIntent.putExtra("opCode", paramInt1);
    localIntent.putExtra("ui", paramString);
    localIntent.putExtra("uiHashCode", paramInt2);
    localIntent.putExtra("nowMilliSecond", bk.UY());
    localIntent.putExtra("elapsedRealtime", SystemClock.elapsedRealtime());
    paramString = ae.getContext();
    if (paramString != null)
    {
      if (!ae.cqV()) {
        break label88;
      }
      c.Rn().j(localIntent);
    }
    for (;;)
    {
      localIntent.setAction("com.tencent.mm.Intent.ACTION_NET_STATS");
      paramString.sendBroadcast(localIntent);
      return;
      label88:
      y.d("MicroMsg.ClickFlowStatSender", "sendBroadcast, Intent: %s, Extra: %s", new Object[] { localIntent, localIntent.getExtras() });
      paramString.sendBroadcast(localIntent);
    }
  }
  
  public static void c(Application paramApplication)
  {
    paramApplication.registerActivityLifecycleCallbacks(Rp().eCB);
  }
  
  public static void h(String paramString, long paramLong1, long paramLong2)
  {
    if ((com.tencent.mm.protocal.d.spd) || (com.tencent.mm.protocal.d.spc))
    {
      y.i("MicroMsg.ClickFlowStatSender", "kvCheck :%s [%s,%s,%s]", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong2 - paramLong1) });
      f.nEG.aC(13393, "99999,0,0," + paramLong1 + "," + paramLong2 + "," + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.d
 * JD-Core Version:    0.7.0.1
 */