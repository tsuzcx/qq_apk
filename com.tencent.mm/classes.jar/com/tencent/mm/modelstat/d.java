package com.tencent.mm.modelstat;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;

public final class d
{
  private static d fSu;
  private d.a fSs;
  private HashSet<String> fSt;
  
  private d()
  {
    AppMethodBeat.i(78711);
    this.fSs = new d.a();
    this.fSt = new HashSet();
    this.fSt.add("com.tencent.mm.ui.LauncherUI");
    this.fSt.add("com.tencent.mm.plugin.profile.ui.ContactInfoUI");
    this.fSt.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    this.fSt.add("com.tencent.mm.ui.conversation.BizConversationUI");
    this.fSt.add("com.tencent.mm.ui.chatting.ChattingUI");
    this.fSt.add("com.tencent.mm.plugin.label.ui.ContactLabelEditUI");
    this.fSt.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI");
    this.fSt.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI1");
    this.fSt.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI2");
    this.fSt.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI3");
    this.fSt.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI4");
    AppMethodBeat.o(78711);
  }
  
  public static boolean akx()
  {
    AppMethodBeat.i(78709);
    d.a locala = aky().fSs;
    if (locala.fSx > locala.fSy)
    {
      AppMethodBeat.o(78709);
      return true;
    }
    AppMethodBeat.o(78709);
    return false;
  }
  
  public static d aky()
  {
    AppMethodBeat.i(78712);
    if (fSu == null) {}
    try
    {
      if (fSu == null) {
        fSu = new d();
      }
      d locald = fSu;
      AppMethodBeat.o(78712);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(78712);
    }
  }
  
  public static void b(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(78710);
    Intent localIntent = new Intent("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT");
    localIntent.putExtra("opCode", paramInt1);
    localIntent.putExtra("ui", paramString);
    localIntent.putExtra("uiHashCode", paramInt2);
    localIntent.putExtra("nowMilliSecond", bo.aoy());
    localIntent.putExtra("elapsedRealtime", SystemClock.elapsedRealtime());
    com.tencent.mm.sdk.platformtools.e.aK(localIntent);
    paramString = ah.getContext();
    if (paramString != null)
    {
      if (!ah.brt()) {
        break label102;
      }
      c.akw().x(localIntent);
    }
    for (;;)
    {
      localIntent.setAction("com.tencent.mm.Intent.ACTION_NET_STATS");
      paramString.sendBroadcast(localIntent);
      AppMethodBeat.o(78710);
      return;
      label102:
      ab.d("MicroMsg.ClickFlowStatSender", "sendBroadcast, Intent: %s, Extra: %s", new Object[] { localIntent, localIntent.getExtras() });
      paramString.sendBroadcast(localIntent);
    }
  }
  
  public static void d(Application paramApplication)
  {
    AppMethodBeat.i(78708);
    paramApplication.registerActivityLifecycleCallbacks(aky().fSs);
    AppMethodBeat.o(78708);
  }
  
  public static void o(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(78713);
    if ((com.tencent.mm.protocal.d.whK) || (com.tencent.mm.protocal.d.whJ))
    {
      ab.i("MicroMsg.ClickFlowStatSender", "kvCheck :%s [%s,%s,%s]", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong2 - paramLong1) });
      com.tencent.mm.plugin.report.e.qrI.kvStat(13393, "99999,0,0," + paramLong1 + "," + paramLong2 + "," + paramString);
    }
    AppMethodBeat.o(78713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.d
 * JD-Core Version:    0.7.0.1
 */