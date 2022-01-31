package com.tencent.mm.plugin.appbrand.ui;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIAccountReleaseHandler;", "", "()V", "TAG", "", "processForegroundImportance", "", "", "[Ljava/lang/Integer;", "handleAccountRelease", "", "activity", "Landroid/app/Activity;", "finishHandler", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskUIController$FinishAllHandler;", "plugin-appbrand-integration_release"})
public final class i
{
  private static final Integer[] iPj;
  public static final i iPk;
  
  static
  {
    AppMethodBeat.i(135001);
    iPk = new i();
    iPj = new Integer[] { Integer.valueOf(100), Integer.valueOf(200) };
    AppMethodBeat.o(135001);
  }
  
  public static void a(Activity paramActivity, com.tencent.mm.plugin.appbrand.task.i.a parama)
  {
    AppMethodBeat.i(135000);
    j.q(paramActivity, "activity");
    j.q(parama, "finishHandler");
    try
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      parama = new i.a(parama, paramActivity);
      if ((localRunningAppProcessInfo == null) || (!org.apache.commons.b.a.contains(iPj, Integer.valueOf(localRunningAppProcessInfo.importance))))
      {
        paramActivity = new StringBuilder("finish directly importance[");
        if (localRunningAppProcessInfo != null)
        {
          i = localRunningAppProcessInfo.importance;
          ab.i("MicroMsg.AppBrandUIAccountReleaseHandler", i + ']');
          parama.ate();
          AppMethodBeat.o(135000);
          return;
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Object localObject = null;
        continue;
        int i = -1;
      }
      parama = (AppBrandProxyUIProcessTask.b)new i.b(parama);
      com.tencent.mm.plugin.appbrand.ipc.a.a((Context)paramActivity, (AppBrandProxyUIProcessTask.ProcessRequest)new AccountReleaseProxyUILaunchRequest(), parama, new Intent().addFlags(67108864));
      AppMethodBeat.o(135000);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.i
 * JD-Core Version:    0.7.0.1
 */