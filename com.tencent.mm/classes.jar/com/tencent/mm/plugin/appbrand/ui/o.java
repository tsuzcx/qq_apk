package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.os.RemoteException;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIAccountReleaseHandler;", "", "()V", "TAG", "", "processForegroundImportance", "", "", "[Ljava/lang/Integer;", "getSerializedUin", "handleAccountRelease", "", "activity", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
public final class o
{
  private static final Integer[] qYR;
  public static final o qYS;
  
  static
  {
    AppMethodBeat.i(51149);
    qYS = new o();
    qYR = new Integer[] { Integer.valueOf(100), Integer.valueOf(200) };
    AppMethodBeat.o(51149);
  }
  
  public static void H(Activity paramActivity)
  {
    AppMethodBeat.i(282874);
    p.k(paramActivity, "activity");
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUIAccountReleaseHandler", "handleAccountRelease activity:" + paramActivity.getComponentName() + ", stack:" + android.util.Log.getStackTraceString(new Throwable()));
    try
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      locala = new a(paramActivity);
      if ((localRunningAppProcessInfo == null) || (!org.apache.commons.b.a.contains(qYR, Integer.valueOf(localRunningAppProcessInfo.importance))) || (paramActivity.isFinishing()) || (paramActivity.isDestroyed()))
      {
        paramActivity = new StringBuilder("finish directly importance[");
        if (localRunningAppProcessInfo != null)
        {
          i = localRunningAppProcessInfo.importance;
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandUIAccountReleaseHandler", i + ']');
          locala.invoke();
          AppMethodBeat.o(282874);
          return;
        }
      }
    }
    catch (RemoteException localRemoteException)
    {
      final a locala;
      for (;;)
      {
        Object localObject = null;
        continue;
        int i = -1;
      }
      j.a(MMApplicationContext.getMainProcessName(), (Parcelable)IPCVoid.jZu, ag.class, (f)new b(paramActivity, locala));
      AppMethodBeat.o(282874);
    }
  }
  
  public static final int ckj()
  {
    AppMethodBeat.i(175219);
    SharedPreferences localSharedPreferences = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
    if (localSharedPreferences != null)
    {
      int i = localSharedPreferences.getInt("default_uin", 0);
      AppMethodBeat.o(175219);
      return i;
    }
    AppMethodBeat.o(175219);
    return 0;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"doFinish", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(Activity paramActivity)
    {
      super();
    }
    
    public final void invoke()
    {
      AppMethodBeat.i(51146);
      if ((!this.otc.isFinishing()) && (!this.otc.isDestroyed())) {
        this.otc.finish();
      }
      AppMethodBeat.o(51146);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "data", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "kotlin.jvm.PlatformType", "onCallback"})
  static final class b<T>
    implements f<IPCBoolean>
  {
    b(Activity paramActivity, o.a parama) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.o
 * JD-Core Version:    0.7.0.1
 */