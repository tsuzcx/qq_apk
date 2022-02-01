package com.tencent.mm.modelstat;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BroadcastHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;

public final class d
{
  private static d mde;
  private a mdc;
  private HashSet<String> mdd;
  
  private d()
  {
    AppMethodBeat.i(151055);
    this.mdc = new a();
    this.mdd = new HashSet();
    this.mdd.add("com.tencent.mm.ui.LauncherUI");
    this.mdd.add("com.tencent.mm.plugin.profile.ui.ContactInfoUI");
    this.mdd.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    this.mdd.add("com.tencent.mm.ui.conversation.BizConversationUI");
    this.mdd.add("com.tencent.mm.ui.chatting.ChattingUI");
    this.mdd.add("com.tencent.mm.plugin.label.ui.ContactLabelEditUI");
    this.mdd.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI");
    this.mdd.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI1");
    this.mdd.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI2");
    this.mdd.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI3");
    this.mdd.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI4");
    AppMethodBeat.o(151055);
  }
  
  public static boolean bps()
  {
    AppMethodBeat.i(151053);
    a locala = bpt().mdc;
    if (locala.mdk > locala.mdl)
    {
      AppMethodBeat.o(151053);
      return true;
    }
    AppMethodBeat.o(151053);
    return false;
  }
  
  public static d bpt()
  {
    AppMethodBeat.i(151056);
    if (mde == null) {}
    try
    {
      if (mde == null) {
        mde = new d();
      }
      d locald = mde;
      AppMethodBeat.o(151056);
      return locald;
    }
    finally
    {
      AppMethodBeat.o(151056);
    }
  }
  
  public static void d(int paramInt1, final String paramString, final int paramInt2)
  {
    AppMethodBeat.i(151054);
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197981);
        Intent localIntent = new Intent("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT");
        localIntent.putExtra("opCode", this.mdf);
        localIntent.putExtra("ui", paramString);
        localIntent.putExtra("uiHashCode", paramInt2);
        localIntent.putExtra("nowMilliSecond", Util.nowMilliSecond());
        localIntent.putExtra("elapsedRealtime", SystemClock.elapsedRealtime());
        BroadcastHelper.setIntentPackageName(localIntent);
        Context localContext = MMApplicationContext.getContext();
        if (localContext != null)
        {
          if (!MMApplicationContext.isMMProcess()) {
            break label111;
          }
          c.bpr().k(localIntent);
        }
        for (;;)
        {
          localIntent.setAction("com.tencent.mm.Intent.ACTION_NET_STATS");
          localContext.sendBroadcast(localIntent);
          AppMethodBeat.o(197981);
          return;
          label111:
          Log.d("MicroMsg.ClickFlowStatSender", "sendBroadcast, Intent: %s, Extra: %s", new Object[] { localIntent, localIntent.getExtras() });
          localContext.sendBroadcast(localIntent);
        }
      }
    });
    AppMethodBeat.o(151054);
  }
  
  public static void j(Application paramApplication)
  {
    AppMethodBeat.i(151052);
    paramApplication.registerActivityLifecycleCallbacks(bpt().mdc);
    AppMethodBeat.o(151052);
  }
  
  public static void l(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151057);
    if ((com.tencent.mm.protocal.d.RAG) || (com.tencent.mm.protocal.d.RAF))
    {
      Log.i("MicroMsg.ClickFlowStatSender", "kvCheck :%s [%s,%s,%s]", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong2 - paramLong1) });
      com.tencent.mm.plugin.report.f.Iyx.kvStat(13393, "99999,0,0," + paramLong1 + "," + paramLong2 + "," + paramString);
    }
    AppMethodBeat.o(151057);
  }
  
  static final class a
    implements Application.ActivityLifecycleCallbacks
  {
    private int mdi;
    private int mdj;
    int mdk;
    int mdl;
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(151046);
      d.a(d.bpt(), 1, paramActivity);
      AppMethodBeat.o(151046);
    }
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(151051);
      d.a(d.bpt(), 6, paramActivity);
      AppMethodBeat.o(151051);
    }
    
    public final void onActivityPaused(Activity paramActivity)
    {
      AppMethodBeat.i(151049);
      this.mdj += 1;
      Log.i("MicroMsg.ClickFlowStatSender", "paused[%d]", new Object[] { Integer.valueOf(this.mdj) });
      d.a(d.bpt(), 4, paramActivity);
      e locale = e.bpu();
      if ((paramActivity != null) && ((paramActivity instanceof MMActivity)))
      {
        String str = paramActivity.getClass().getName();
        long l = ((MMActivity)paramActivity).getActivityBrowseTimeMs();
        locale.F(str, l);
        Log.v("MicroMsg.MMActivityBrowseMgr", "onPause activity[%s] time[%d] map[%d]", new Object[] { str, Long.valueOf(l), Integer.valueOf(locale.mdn.size()) });
      }
      AppMethodBeat.o(151049);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(151048);
      this.mdi += 1;
      Log.i("MicroMsg.ClickFlowStatSender", "resumed[%d]", new Object[] { Integer.valueOf(this.mdi) });
      d.a(d.bpt(), 3, paramActivity);
      AppMethodBeat.o(151048);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity)
    {
      AppMethodBeat.i(151047);
      this.mdk += 1;
      Log.i("MicroMsg.ClickFlowStatSender", "started[%d]", new Object[] { Integer.valueOf(this.mdk) });
      d.a(d.bpt(), 2, paramActivity);
      AppMethodBeat.o(151047);
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      AppMethodBeat.i(151050);
      this.mdl += 1;
      Log.i("MicroMsg.ClickFlowStatSender", "stopped[%d]", new Object[] { Integer.valueOf(this.mdl) });
      d.a(d.bpt(), 5, paramActivity);
      AppMethodBeat.o(151050);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelstat.d
 * JD-Core Version:    0.7.0.1
 */