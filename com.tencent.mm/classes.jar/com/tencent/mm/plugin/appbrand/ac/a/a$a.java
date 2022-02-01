package com.tencent.mm.plugin.appbrand.ac.a;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.y.a;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/wxa_redirecting_page/export/WxaRedirectingPageExportApi$WXBizEntryActivityPendingMap;", "", "()V", "map", "Landroid/util/SparseArray;", "Landroid/app/Activity;", "finish", "invokeTicket", "", "get", "remove", "set", "", "activity", "api-protocol_release"})
public final class a$a
{
  private static final SparseArray<Activity> lzM;
  public static final a nvx;
  
  static
  {
    AppMethodBeat.i(200283);
    nvx = new a();
    lzM = new SparseArray();
    Object localObject = ak.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getApplicationContext();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.Application");
      AppMethodBeat.o(200283);
      throw ((Throwable)localObject);
    }
    ((Application)localObject).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new a()
    {
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(200280);
        super.onActivityDestroyed(paramAnonymousActivity);
        if (paramAnonymousActivity != null)
        {
          locala = a.a.nvx;
          if (a.a.bGJ().size() > 0) {}
        }
        else
        {
          AppMethodBeat.o(200280);
          return;
        }
        a.a locala = a.a.nvx;
        int i = a.a.bGJ().indexOfValue(paramAnonymousActivity);
        if (i >= 0)
        {
          paramAnonymousActivity = a.a.nvx;
          a.a.bGJ().removeAt(i);
        }
        AppMethodBeat.o(200280);
      }
    });
    AppMethodBeat.o(200283);
  }
  
  public static Activity Wt(String paramString)
  {
    AppMethodBeat.i(200282);
    p.h(paramString, "invokeTicket");
    p.h(paramString, "invokeTicket");
    int i = lzM.indexOfKey(paramString.hashCode());
    if (i >= 0)
    {
      paramString = lzM.valueAt(i);
      lzM.removeAt(i);
    }
    for (paramString = (Activity)paramString; paramString == null; paramString = null)
    {
      AppMethodBeat.o(200282);
      return null;
    }
    Object localObject = bu.aJ((Context)paramString, paramString.getTaskId());
    if (localObject != null)
    {
      localObject = ((ActivityManager.RunningTaskInfo)localObject).baseActivity;
      if (localObject != null)
      {
        localObject = ((ComponentName)localObject).getClassName();
        if ((localObject != null) && (n.nG((String)localObject, "WXEntryActivity") == true) && (Build.VERSION.SDK_INT >= 21)) {
          paramString.finishAndRemoveTask();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(200282);
      return paramString;
      paramString.finish();
    }
  }
  
  public static final void b(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(200281);
    p.h(paramString, "invokeTicket");
    p.h(paramActivity, "activity");
    lzM.put(paramString.hashCode(), paramActivity);
    AppMethodBeat.o(200281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ac.a.a.a
 * JD-Core Version:    0.7.0.1
 */