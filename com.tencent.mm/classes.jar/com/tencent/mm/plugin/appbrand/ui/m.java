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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIAccountReleaseHandler;", "", "()V", "TAG", "", "processForegroundImportance", "", "", "[Ljava/lang/Integer;", "getSerializedUin", "handleAccountRelease", "", "activity", "Landroid/app/Activity;", "finishHandler", "Lcom/tencent/mm/plugin/appbrand/task/AppBrandTaskUIController$FinishAllHandler;", "plugin-appbrand-integration_release"})
public final class m
{
  private static final Integer[] mFj;
  public static final m mFk;
  
  static
  {
    AppMethodBeat.i(51149);
    mFk = new m();
    mFj = new Integer[] { Integer.valueOf(100), Integer.valueOf(200) };
    AppMethodBeat.o(51149);
  }
  
  public static void a(final Activity paramActivity, g.a parama)
  {
    AppMethodBeat.i(51148);
    p.h(paramActivity, "activity");
    p.h(parama, "finishHandler");
    try
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      parama = new a(parama, paramActivity);
      if ((localRunningAppProcessInfo == null) || (!org.apache.commons.b.a.contains(mFj, Integer.valueOf(localRunningAppProcessInfo.importance))))
      {
        paramActivity = new StringBuilder("finish directly importance[");
        if (localRunningAppProcessInfo != null)
        {
          i = localRunningAppProcessInfo.importance;
          ad.i("MicroMsg.AppBrandUIAccountReleaseHandler", i + ']');
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
  
  public static final int bzD()
  {
    AppMethodBeat.i(175219);
    SharedPreferences localSharedPreferences = aj.getContext().getSharedPreferences("system_config_prefs", 0);
    if (localSharedPreferences != null)
    {
      int i = localSharedPreferences.getInt("default_uin", 0);
      AppMethodBeat.o(175219);
      return i;
    }
    AppMethodBeat.o(175219);
    return 0;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"doFinish", "", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<z>
  {
    a(g.a parama, Activity paramActivity)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(51146);
      this.mFl.proceed();
      paramActivity.finish();
      AppMethodBeat.o(51146);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/ui/AccountReleaseProxyUILaunchResult;", "kotlin.jvm.PlatformType", "onReceiveResult"})
  static final class b<R extends AppBrandProxyUIProcessTask.ProcessResult>
    implements AppBrandProxyUIProcessTask.b<AccountReleaseProxyUILaunchResult>
  {
    b(m.a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.m
 * JD-Core Version:    0.7.0.1
 */