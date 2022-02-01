package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessResult;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.b;
import com.tencent.mm.plugin.appbrand.task.g.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIAccountReleaseHandler;", "", "()V", "TAG", "", "processForegroundImportance", "", "", "[Ljava/lang/Integer;", "getSerializedUin", "handleAccountRelease", "", "activity", "Landroid/app/Activity;", "finishHandler", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskUIController$FinishAllHandler;", "plugin-appbrand-integration_release"})
public final class l
{
  private static final Integer[] meL;
  public static final l meM;
  
  static
  {
    AppMethodBeat.i(51149);
    meM = new l();
    meL = new Integer[] { Integer.valueOf(100), Integer.valueOf(200) };
    AppMethodBeat.o(51149);
  }
  
  public static void a(final Activity paramActivity, g.a parama)
  {
    AppMethodBeat.i(51148);
    k.h(paramActivity, "activity");
    k.h(parama, "finishHandler");
    try
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      parama = new a(parama, paramActivity);
      if ((localRunningAppProcessInfo == null) || (!org.apache.commons.b.a.contains(meL, Integer.valueOf(localRunningAppProcessInfo.importance))))
      {
        paramActivity = new StringBuilder("finish directly importance[");
        if (localRunningAppProcessInfo != null)
        {
          i = localRunningAppProcessInfo.importance;
          ac.i("MicroMsg.AppBrandUIAccountReleaseHandler", i + ']');
          parama.invoke();
          AppMethodBeat.o(51148);
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
      parama = (AppBrandProxyUIProcessTask.b)new b(parama);
      com.tencent.mm.plugin.appbrand.ipc.a.a((Context)paramActivity, (AppBrandProxyUIProcessTask.ProcessRequest)new AccountReleaseProxyUILaunchRequest(), parama, new Intent().addFlags(67108864));
      AppMethodBeat.o(51148);
    }
  }
  
  public static final int bvx()
  {
    AppMethodBeat.i(175219);
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("system_config_prefs", 0);
    if (localSharedPreferences != null)
    {
      int i = localSharedPreferences.getInt("default_uin", 0);
      AppMethodBeat.o(175219);
      return i;
    }
    AppMethodBeat.o(175219);
    return 0;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"doFinish", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    a(g.a parama, Activity paramActivity)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(51146);
      this.meN.proceed();
      paramActivity.finish();
      AppMethodBeat.o(51146);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<AccountReleaseProxyUILaunchResult>
  {
    b(l.a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.l
 * JD-Core Version:    0.7.0.1
 */