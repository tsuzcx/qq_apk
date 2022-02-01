package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI01;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI02;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI03;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI04;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI1;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI2;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI3;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI4;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ipc/AppBrandLaunchMMSingleTaskUIHelper;", "", "()V", "TAG", "", "allAppBrandProcessUiClass", "", "Ljava/lang/Class;", "Landroid/app/Activity;", "provideExtrasForSmoothBack", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b ruw;
  private static final List<Class<? extends Activity>> rux;
  
  static
  {
    AppMethodBeat.i(319395);
    ruw = new b();
    rux = p.listOf(new Class[] { AppBrandUI.class, AppBrandUI1.class, AppBrandUI2.class, AppBrandUI3.class, AppBrandUI4.class, AppBrandUI.class, AppBrandUI01.class, AppBrandUI02.class, AppBrandUI03.class, AppBrandUI04.class });
    AppMethodBeat.o(319395);
  }
  
  public static final Intent eD(Context paramContext)
  {
    AppMethodBeat.i(319390);
    s.u(paramContext, "context");
    try
    {
      paramContext = (ActivityManager)a.a(paramContext, ActivityManager.class);
      if (paramContext == null) {
        paramContext = null;
      }
      while (paramContext == null)
      {
        AppMethodBeat.o(319390);
        return null;
        paramContext = paramContext.getRunningTasks(1);
        if (paramContext == null)
        {
          paramContext = null;
        }
        else
        {
          paramContext = (ActivityManager.RunningTaskInfo)paramContext.get(0);
          if (paramContext == null) {
            paramContext = null;
          } else {
            paramContext = paramContext.baseActivity;
          }
        }
      }
      Iterator localIterator = ((Iterable)rux).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
      } while (!s.p(((Class)localObject).getName(), paramContext.getClassName()));
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        Object localObject;
        boolean bool;
        Log.w("MicroMsg.AppBrand.AppBrandLaunchMMSingleTaskUIHelper", s.X("provideExtrasForSmoothBack fail since ", paramContext));
        paramContext = null;
        continue;
        if (localObject != null) {
          bool = true;
        }
      }
    }
    Log.i("MicroMsg.AppBrand.AppBrandLaunchMMSingleTaskUIHelper", "provideExtrasForSmoothBack, curStackBaseUI: " + paramContext + ", curInAppBrandStack: " + bool);
    if (bool)
    {
      Log.i("MicroMsg.AppBrand.AppBrandLaunchMMSingleTaskUIHelper", "provideExtrasForSmoothBack, provide");
      paramContext = new Intent();
      paramContext.addFlags(268468224);
    }
    for (;;)
    {
      AppMethodBeat.o(319390);
      return paramContext;
      localObject = null;
      break label231;
      bool = false;
      break;
      Log.i("MicroMsg.AppBrand.AppBrandLaunchMMSingleTaskUIHelper", "provideExtrasForSmoothBack, not need");
      paramContext = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.b
 * JD-Core Version:    0.7.0.1
 */