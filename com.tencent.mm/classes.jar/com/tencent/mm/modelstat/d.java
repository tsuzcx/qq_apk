package com.tencent.mm.modelstat;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;

public final class d
{
  private static d irU;
  private a irS;
  private HashSet<String> irT;
  
  private d()
  {
    AppMethodBeat.i(151055);
    this.irS = new a();
    this.irT = new HashSet();
    this.irT.add("com.tencent.mm.ui.LauncherUI");
    this.irT.add("com.tencent.mm.plugin.profile.ui.ContactInfoUI");
    this.irT.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
    this.irT.add("com.tencent.mm.ui.conversation.BizConversationUI");
    this.irT.add("com.tencent.mm.ui.chatting.ChattingUI");
    this.irT.add("com.tencent.mm.plugin.label.ui.ContactLabelEditUI");
    this.irT.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI");
    this.irT.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI1");
    this.irT.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI2");
    this.irT.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI3");
    this.irT.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI4");
    AppMethodBeat.o(151055);
  }
  
  public static boolean aLZ()
  {
    AppMethodBeat.i(151053);
    a locala = aMa().irS;
    if (locala.irX > locala.irY)
    {
      AppMethodBeat.o(151053);
      return true;
    }
    AppMethodBeat.o(151053);
    return false;
  }
  
  public static d aMa()
  {
    AppMethodBeat.i(151056);
    if (irU == null) {}
    try
    {
      if (irU == null) {
        irU = new d();
      }
      d locald = irU;
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
    h.MqF.aO(new d.1(paramInt1, paramString, paramInt2));
    AppMethodBeat.o(151054);
  }
  
  public static void i(Application paramApplication)
  {
    AppMethodBeat.i(151052);
    paramApplication.registerActivityLifecycleCallbacks(aMa().irS);
    AppMethodBeat.o(151052);
  }
  
  public static void m(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(151057);
    if ((com.tencent.mm.protocal.d.FFK) || (com.tencent.mm.protocal.d.FFJ))
    {
      ae.i("MicroMsg.ClickFlowStatSender", "kvCheck :%s [%s,%s,%s]", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong2 - paramLong1) });
      e.ywz.kvStat(13393, "99999,0,0," + paramLong1 + "," + paramLong2 + "," + paramString);
    }
    AppMethodBeat.o(151057);
  }
  
  static final class a
    implements Application.ActivityLifecycleCallbacks
  {
    private int irV;
    private int irW;
    int irX;
    int irY;
    
    public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
    {
      AppMethodBeat.i(151046);
      d.a(d.aMa(), 1, paramActivity);
      AppMethodBeat.o(151046);
    }
    
    public final void onActivityDestroyed(Activity paramActivity)
    {
      AppMethodBeat.i(151051);
      d.a(d.aMa(), 6, paramActivity);
      AppMethodBeat.o(151051);
    }
    
    public final void onActivityPaused(Activity paramActivity)
    {
      AppMethodBeat.i(151049);
      this.irW += 1;
      ae.i("MicroMsg.ClickFlowStatSender", "paused[%d]", new Object[] { Integer.valueOf(this.irW) });
      d.a(d.aMa(), 4, paramActivity);
      f localf = f.aMd();
      if ((paramActivity != null) && ((paramActivity instanceof MMActivity)))
      {
        String str = paramActivity.getClass().getName();
        long l = ((MMActivity)paramActivity).getActivityBrowseTimeMs();
        localf.I(str, l);
        ae.v("MicroMsg.MMActivityBrowseMgr", "onPause activity[%s] time[%d] map[%d]", new Object[] { str, Long.valueOf(l), Integer.valueOf(localf.isL.size()) });
      }
      AppMethodBeat.o(151049);
    }
    
    public final void onActivityResumed(Activity paramActivity)
    {
      AppMethodBeat.i(151048);
      this.irV += 1;
      ae.i("MicroMsg.ClickFlowStatSender", "resumed[%d]", new Object[] { Integer.valueOf(this.irV) });
      d.a(d.aMa(), 3, paramActivity);
      AppMethodBeat.o(151048);
    }
    
    public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
    
    public final void onActivityStarted(Activity paramActivity)
    {
      AppMethodBeat.i(151047);
      this.irX += 1;
      ae.i("MicroMsg.ClickFlowStatSender", "started[%d]", new Object[] { Integer.valueOf(this.irX) });
      d.a(d.aMa(), 2, paramActivity);
      AppMethodBeat.o(151047);
    }
    
    public final void onActivityStopped(Activity paramActivity)
    {
      AppMethodBeat.i(151050);
      this.irY += 1;
      ae.i("MicroMsg.ClickFlowStatSender", "stopped[%d]", new Object[] { Integer.valueOf(this.irY) });
      d.a(d.aMa(), 5, paramActivity);
      AppMethodBeat.o(151050);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelstat.d
 * JD-Core Version:    0.7.0.1
 */