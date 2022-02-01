package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.os.RemoteException;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import org.apache.commons.c.a;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIAccountReleaseHandler;", "", "()V", "TAG", "", "processForegroundImportance", "", "", "[Ljava/lang/Integer;", "getSerializedUin", "handleAccountRelease", "", "activity", "Landroid/app/Activity;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  public static final s ueP;
  private static final Integer[] ueQ;
  
  static
  {
    AppMethodBeat.i(51149);
    ueP = new s();
    ueQ = new Integer[] { Integer.valueOf(100), Integer.valueOf(200) };
    AppMethodBeat.o(51149);
  }
  
  public static void N(Activity paramActivity)
  {
    AppMethodBeat.i(322181);
    kotlin.g.b.s.u(paramActivity, "activity");
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUIAccountReleaseHandler", "handleAccountRelease activity:" + paramActivity.getComponentName() + ", stack:" + android.util.Log.getStackTraceString(new Throwable()));
    try
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      if ((localRunningAppProcessInfo == null) || (!a.contains(ueQ, Integer.valueOf(localRunningAppProcessInfo.importance))) || (paramActivity.isFinishing()) || (paramActivity.isDestroyed()))
      {
        StringBuilder localStringBuilder = new StringBuilder("finish directly importance[");
        if (localRunningAppProcessInfo == null)
        {
          i = -1;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUIAccountReleaseHandler", i + ']');
          O(paramActivity);
          AppMethodBeat.o(322181);
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
        int i = localObject.importance;
      }
      j.a(MMApplicationContext.getMainProcessName(), (Parcelable)IPCVoid.mzv, ao.class, new s..ExternalSyntheticLambda0(paramActivity));
      AppMethodBeat.o(322181);
    }
  }
  
  private static final void O(Activity paramActivity)
  {
    AppMethodBeat.i(322185);
    if ((!paramActivity.isFinishing()) && (!paramActivity.isDestroyed())) {
      paramActivity.finish();
    }
    AppMethodBeat.o(322185);
  }
  
  private static final void P(Activity paramActivity)
  {
    AppMethodBeat.i(322191);
    kotlin.g.b.s.u(paramActivity, "$activity");
    Toast.makeText(MMApplicationContext.getContext(), ba.i.app_brand_account_release_error, 1).show();
    Context localContext = (Context)paramActivity;
    Intent localIntent = new Intent();
    localIntent.addFlags(268435456);
    localIntent.addFlags(67108864);
    localIntent.putExtra("animation_pop_in", true);
    localIntent.putExtra("Intro_Switch", true);
    ah localah = ah.aiuX;
    c.g(localContext, ".ui.LauncherUI", localIntent);
    O(paramActivity);
    AppMethodBeat.o(322191);
  }
  
  private static final void a(Activity paramActivity, IPCBoolean paramIPCBoolean)
  {
    int i = 1;
    AppMethodBeat.i(322196);
    kotlin.g.b.s.u(paramActivity, "$activity");
    if ((paramIPCBoolean != null) && (paramIPCBoolean.value == true)) {}
    while (i != 0)
    {
      h.ahAA.bk(new s..ExternalSyntheticLambda1(paramActivity));
      AppMethodBeat.o(322196);
      return;
      i = 0;
    }
    O(paramActivity);
    AppMethodBeat.o(322196);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.s
 * JD-Core Version:    0.7.0.1
 */