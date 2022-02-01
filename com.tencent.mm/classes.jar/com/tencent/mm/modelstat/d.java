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
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;

public final class d
{
  private static d hvd;
  private a hvb;
  private HashSet<String> hvc;
  
  private d()
  {
    AppMethodBeat.i(151055);
    this.hvb = new a();
    this.hvc = new HashSet();
    this.hvc.add("com.tencent.mm.ui.LauncherUI");
    this.hvc.add("com.tencent.mm.plugin.profile.ui.ContactInfoUI");
    this.hvc.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    this.hvc.add("com.tencent.mm.ui.conversation.BizConversationUI");
    this.hvc.add("com.tencent.mm.ui.chatting.ChattingUI");
    this.hvc.add("com.tencent.mm.plugin.label.ui.ContactLabelEditUI");
    this.hvc.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI");
    this.hvc.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI1");
    this.hvc.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI2");
    this.hvc.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI3");
    this.hvc.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI4");
    AppMethodBeat.o(151055);
  }
  
  public static boolean aBC()
  {
    AppMethodBeat.i(151053);
    a locala = aBD().hvb;
    if (locala.hvg > locala.hvh)
    {
      AppMethodBeat.o(151053);
      return true;
    }
    AppMethodBeat.o(151053);
    return false;
  }
  
  public static d aBD()
  {
    AppMethodBeat.i(151056);
    if (hvd == null) {}
    try
    {
      if (hvd == null) {
        hvd = new d();
      }
      d locald = hvd;
      AppMethodBeat.o(151056);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(151056);
    }
  }
  
  public static void c(int paramInt1, String paramString, int paramInt2)
  {
    AppMethodBeat.i(151054);
    Intent localIntent = new Intent("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT");
    localIntent.putExtra("opCode", paramInt1);
    localIntent.putExtra("ui", paramString);
    localIntent.putExtra("uiHashCode", paramInt2);
    localIntent.putExtra("nowMilliSecond", bt.eGO());
    localIntent.putExtra("elapsedRealtime", SystemClock.elapsedRealtime());
    g.bd(localIntent);
    paramString = aj.getContext();
    if (paramString != null)
    {
      if (!aj.cbv()) {
        break label102;
      }
      c.aBB().j(localIntent);
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
  
  public static void f(Application paramApplication)
  {
    AppMethodBeat.i(151052);
    paramApplication.registerActivityLifecycleCallbacks(aBD().hvb);
    AppMethodBeat.o(151052);
  }
  
  public static void p(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151057);
    if ((com.tencent.mm.protocal.d.CpN) || (com.tencent.mm.protocal.d.CpM))
    {
      ad.i("MicroMsg.ClickFlowStatSender", "kvCheck :%s [%s,%s,%s]", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong2 - paramLong1) });
      e.vIY.kvStat(13393, "99999,0,0," + paramLong1 + "," + paramLong2 + "," + paramString);
    }
    AppMethodBeat.o(151057);
  }
  
  static final class a
    implements Application.ActivityLifecycleCallbacks
  {
    private int hve;
    private int hvf;
    int hvg;
    int hvh;
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(151046);
      d.a(d.aBD(), 1, paramActivity);
      AppMethodBeat.o(151046);
    }
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(151051);
      d.a(d.aBD(), 6, paramActivity);
      AppMethodBeat.o(151051);
    }
    
    public final void onActivityPaused(Activity paramActivity)
    {
      AppMethodBeat.i(151049);
      this.hvf += 1;
      ad.i("MicroMsg.ClickFlowStatSender", "paused[%d]", new Object[] { Integer.valueOf(this.hvf) });
      d.a(d.aBD(), 4, paramActivity);
      f localf = f.aBG();
      if ((paramActivity != null) && ((paramActivity instanceof MMActivity)))
      {
        String str = paramActivity.getClass().getName();
        long l = ((MMActivity)paramActivity).getActivityBrowseTimeMs();
        localf.C(str, l);
        ad.v("MicroMsg.MMActivityBrowseMgr", "onPause activity[%s] time[%d] map[%d]", new Object[] { str, Long.valueOf(l), Integer.valueOf(localf.hvU.size()) });
      }
      AppMethodBeat.o(151049);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(151048);
      this.hve += 1;
      ad.i("MicroMsg.ClickFlowStatSender", "resumed[%d]", new Object[] { Integer.valueOf(this.hve) });
      d.a(d.aBD(), 3, paramActivity);
      AppMethodBeat.o(151048);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity)
    {
      AppMethodBeat.i(151047);
      this.hvg += 1;
      ad.i("MicroMsg.ClickFlowStatSender", "started[%d]", new Object[] { Integer.valueOf(this.hvg) });
      d.a(d.aBD(), 2, paramActivity);
      AppMethodBeat.o(151047);
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      AppMethodBeat.i(151050);
      this.hvh += 1;
      ad.i("MicroMsg.ClickFlowStatSender", "stopped[%d]", new Object[] { Integer.valueOf(this.hvh) });
      d.a(d.aBD(), 5, paramActivity);
      AppMethodBeat.o(151050);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.d
 * JD-Core Version:    0.7.0.1
 */