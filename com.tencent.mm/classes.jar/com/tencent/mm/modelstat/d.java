package com.tencent.mm.modelstat;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;

public final class d
{
  private static d ioZ;
  private a ioX;
  private HashSet<String> ioY;
  
  private d()
  {
    AppMethodBeat.i(151055);
    this.ioX = new a();
    this.ioY = new HashSet();
    this.ioY.add("com.tencent.mm.ui.LauncherUI");
    this.ioY.add("com.tencent.mm.plugin.profile.ui.ContactInfoUI");
    this.ioY.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    this.ioY.add("com.tencent.mm.ui.conversation.BizConversationUI");
    this.ioY.add("com.tencent.mm.ui.chatting.ChattingUI");
    this.ioY.add("com.tencent.mm.plugin.label.ui.ContactLabelEditUI");
    this.ioY.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI");
    this.ioY.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI1");
    this.ioY.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI2");
    this.ioY.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI3");
    this.ioY.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI4");
    AppMethodBeat.o(151055);
  }
  
  public static boolean aLC()
  {
    AppMethodBeat.i(151053);
    a locala = aLD().ioX;
    if (locala.ipc > locala.ipd)
    {
      AppMethodBeat.o(151053);
      return true;
    }
    AppMethodBeat.o(151053);
    return false;
  }
  
  public static d aLD()
  {
    AppMethodBeat.i(151056);
    if (ioZ == null) {}
    try
    {
      if (ioZ == null) {
        ioZ = new d();
      }
      d locald = ioZ;
      AppMethodBeat.o(151056);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(151056);
    }
  }
  
  public static void d(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(151054);
    Intent localIntent = new Intent("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT");
    localIntent.putExtra("opCode", paramInt1);
    localIntent.putExtra("ui", paramString);
    localIntent.putExtra("uiHashCode", paramInt2);
    localIntent.putExtra("nowMilliSecond", bt.flT());
    localIntent.putExtra("elapsedRealtime", SystemClock.elapsedRealtime());
    h.bj(localIntent);
    paramString = aj.getContext();
    if (paramString != null)
    {
      if (!aj.cnC()) {
        break label102;
      }
      c.aLB().j(localIntent);
    }
    for (;;)
    {
      localIntent.setAction("com.tencent.mm.Intent.ACTION_NET_STATS");
      paramString.sendBroadcast(localIntent);
      AppMethodBeat.o(151054);
      return;
      label102:
      ad.d("MicroMsg.ClickFlowStatSender", "sendBroadcast, Intent: %s, Extra: %s", new Object[] { localIntent, localIntent.getExtras() });
      paramString.sendBroadcast(localIntent);
    }
  }
  
  public static void h(Application paramApplication)
  {
    AppMethodBeat.i(151052);
    paramApplication.registerActivityLifecycleCallbacks(aLD().ioX);
    AppMethodBeat.o(151052);
  }
  
  public static void m(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151057);
    if ((com.tencent.mm.protocal.d.Fnm) || (com.tencent.mm.protocal.d.Fnl))
    {
      ad.i("MicroMsg.ClickFlowStatSender", "kvCheck :%s [%s,%s,%s]", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong2 - paramLong1) });
      e.ygI.kvStat(13393, "99999,0,0," + paramLong1 + "," + paramLong2 + "," + paramString);
    }
    AppMethodBeat.o(151057);
  }
  
  static final class a
    implements Application.ActivityLifecycleCallbacks
  {
    private int ipa;
    private int ipb;
    int ipc;
    int ipd;
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(151046);
      d.a(d.aLD(), 1, paramActivity);
      AppMethodBeat.o(151046);
    }
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(151051);
      d.a(d.aLD(), 6, paramActivity);
      AppMethodBeat.o(151051);
    }
    
    public final void onActivityPaused(Activity paramActivity)
    {
      AppMethodBeat.i(151049);
      this.ipb += 1;
      ad.i("MicroMsg.ClickFlowStatSender", "paused[%d]", new Object[] { Integer.valueOf(this.ipb) });
      d.a(d.aLD(), 4, paramActivity);
      f localf = f.aLG();
      if ((paramActivity != null) && ((paramActivity instanceof MMActivity)))
      {
        String str = paramActivity.getClass().getName();
        long l = ((MMActivity)paramActivity).getActivityBrowseTimeMs();
        localf.I(str, l);
        ad.v("MicroMsg.MMActivityBrowseMgr", "onPause activity[%s] time[%d] map[%d]", new Object[] { str, Long.valueOf(l), Integer.valueOf(localf.ipQ.size()) });
      }
      AppMethodBeat.o(151049);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(151048);
      this.ipa += 1;
      ad.i("MicroMsg.ClickFlowStatSender", "resumed[%d]", new Object[] { Integer.valueOf(this.ipa) });
      d.a(d.aLD(), 3, paramActivity);
      AppMethodBeat.o(151048);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity)
    {
      AppMethodBeat.i(151047);
      this.ipc += 1;
      ad.i("MicroMsg.ClickFlowStatSender", "started[%d]", new Object[] { Integer.valueOf(this.ipc) });
      d.a(d.aLD(), 2, paramActivity);
      AppMethodBeat.o(151047);
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      AppMethodBeat.i(151050);
      this.ipd += 1;
      ad.i("MicroMsg.ClickFlowStatSender", "stopped[%d]", new Object[] { Integer.valueOf(this.ipd) });
      d.a(d.aLD(), 5, paramActivity);
      AppMethodBeat.o(151050);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.d
 * JD-Core Version:    0.7.0.1
 */