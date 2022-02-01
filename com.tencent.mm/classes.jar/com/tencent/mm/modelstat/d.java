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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;

public final class d
{
  private static d hVE;
  private a hVC;
  private HashSet<String> hVD;
  
  private d()
  {
    AppMethodBeat.i(151055);
    this.hVC = new a();
    this.hVD = new HashSet();
    this.hVD.add("com.tencent.mm.ui.LauncherUI");
    this.hVD.add("com.tencent.mm.plugin.profile.ui.ContactInfoUI");
    this.hVD.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    this.hVD.add("com.tencent.mm.ui.conversation.BizConversationUI");
    this.hVD.add("com.tencent.mm.ui.chatting.ChattingUI");
    this.hVD.add("com.tencent.mm.plugin.label.ui.ContactLabelEditUI");
    this.hVD.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI");
    this.hVD.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI1");
    this.hVD.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI2");
    this.hVD.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI3");
    this.hVD.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI4");
    AppMethodBeat.o(151055);
  }
  
  public static boolean aIs()
  {
    AppMethodBeat.i(151053);
    a locala = aIt().hVC;
    if (locala.hVH > locala.hVI)
    {
      AppMethodBeat.o(151053);
      return true;
    }
    AppMethodBeat.o(151053);
    return false;
  }
  
  public static d aIt()
  {
    AppMethodBeat.i(151056);
    if (hVE == null) {}
    try
    {
      if (hVE == null) {
        hVE = new d();
      }
      d locald = hVE;
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
    localIntent.putExtra("nowMilliSecond", bs.eWj());
    localIntent.putExtra("elapsedRealtime", SystemClock.elapsedRealtime());
    g.be(localIntent);
    paramString = ai.getContext();
    if (paramString != null)
    {
      if (!ai.ciE()) {
        break label102;
      }
      c.aIr().j(localIntent);
    }
    for (;;)
    {
      localIntent.setAction("com.tencent.mm.Intent.ACTION_NET_STATS");
      paramString.sendBroadcast(localIntent);
      AppMethodBeat.o(151054);
      return;
      label102:
      ac.d("MicroMsg.ClickFlowStatSender", "sendBroadcast, Intent: %s, Extra: %s", new Object[] { localIntent, localIntent.getExtras() });
      paramString.sendBroadcast(localIntent);
    }
  }
  
  public static void f(Application paramApplication)
  {
    AppMethodBeat.i(151052);
    paramApplication.registerActivityLifecycleCallbacks(aIt().hVC);
    AppMethodBeat.o(151052);
  }
  
  public static void m(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151057);
    if ((com.tencent.mm.protocal.d.DIf) || (com.tencent.mm.protocal.d.DIe))
    {
      ac.i("MicroMsg.ClickFlowStatSender", "kvCheck :%s [%s,%s,%s]", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong2 - paramLong1) });
      e.wTc.kvStat(13393, "99999,0,0," + paramLong1 + "," + paramLong2 + "," + paramString);
    }
    AppMethodBeat.o(151057);
  }
  
  static final class a
    implements Application.ActivityLifecycleCallbacks
  {
    private int hVF;
    private int hVG;
    int hVH;
    int hVI;
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(151046);
      d.a(d.aIt(), 1, paramActivity);
      AppMethodBeat.o(151046);
    }
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(151051);
      d.a(d.aIt(), 6, paramActivity);
      AppMethodBeat.o(151051);
    }
    
    public final void onActivityPaused(Activity paramActivity)
    {
      AppMethodBeat.i(151049);
      this.hVG += 1;
      ac.i("MicroMsg.ClickFlowStatSender", "paused[%d]", new Object[] { Integer.valueOf(this.hVG) });
      d.a(d.aIt(), 4, paramActivity);
      f localf = f.aIw();
      if ((paramActivity != null) && ((paramActivity instanceof MMActivity)))
      {
        String str = paramActivity.getClass().getName();
        long l = ((MMActivity)paramActivity).getActivityBrowseTimeMs();
        localf.D(str, l);
        ac.v("MicroMsg.MMActivityBrowseMgr", "onPause activity[%s] time[%d] map[%d]", new Object[] { str, Long.valueOf(l), Integer.valueOf(localf.hWv.size()) });
      }
      AppMethodBeat.o(151049);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(151048);
      this.hVF += 1;
      ac.i("MicroMsg.ClickFlowStatSender", "resumed[%d]", new Object[] { Integer.valueOf(this.hVF) });
      d.a(d.aIt(), 3, paramActivity);
      AppMethodBeat.o(151048);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity)
    {
      AppMethodBeat.i(151047);
      this.hVH += 1;
      ac.i("MicroMsg.ClickFlowStatSender", "started[%d]", new Object[] { Integer.valueOf(this.hVH) });
      d.a(d.aIt(), 2, paramActivity);
      AppMethodBeat.o(151047);
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      AppMethodBeat.i(151050);
      this.hVI += 1;
      ac.i("MicroMsg.ClickFlowStatSender", "stopped[%d]", new Object[] { Integer.valueOf(this.hVI) });
      d.a(d.aIt(), 5, paramActivity);
      AppMethodBeat.o(151050);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.d
 * JD-Core Version:    0.7.0.1
 */