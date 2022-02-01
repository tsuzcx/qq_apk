package com.tencent.mm.plugin.appbrand.game.h;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.k;
import d.l;
import d.n.n;
import d.v;
import java.util.Iterator;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/game/util/WAGameSelfRestart;", "", "()V", "prepare_restart", "", "selfRestart", "suicide", "plugin-appbrand-integration_release"})
public final class a
{
  public static final a jtS;
  
  static
  {
    AppMethodBeat.i(50397);
    jtS = new a();
    AppMethodBeat.o(50397);
  }
  
  public static void aXd()
  {
    AppMethodBeat.i(50396);
    Object localObject = aj.getContext();
    k.g(localObject, "context");
    PendingIntent localPendingIntent = PendingIntent.getActivity((Context)localObject, -1, ((Context)localObject).getPackageManager().getLaunchIntentForPackage(((Context)localObject).getPackageName()), 268435456);
    localObject = (AlarmManager)((Context)localObject).getSystemService("alarm");
    if (localObject == null) {
      k.fvU();
    }
    ((AlarmManager)localObject).set(1, System.currentTimeMillis() + 100L, localPendingIntent);
    AppMethodBeat.o(50396);
  }
  
  public static void suicide()
  {
    AppMethodBeat.i(50395);
    Object localObject = aj.getContext().getSystemService("activity");
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.ActivityManager");
      AppMethodBeat.o(50395);
      throw ((Throwable)localObject);
    }
    localObject = ((ActivityManager)localObject).getRunningAppProcesses();
    k.g(localObject, "am.runningAppProcesses");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      String str = localRunningAppProcessInfo.processName;
      k.g(str, "it.processName");
      if (n.a((CharSequence)str, (CharSequence)"com.tencent.mm:", false)) {
        Process.killProcess(localRunningAppProcessInfo.pid);
      }
    }
    Process.killProcess(Process.myPid());
    AppMethodBeat.o(50395);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.h.a
 * JD-Core Version:    0.7.0.1
 */