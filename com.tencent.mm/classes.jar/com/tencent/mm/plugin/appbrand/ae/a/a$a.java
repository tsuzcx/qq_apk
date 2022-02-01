package com.tencent.mm.plugin.appbrand.ae.a;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.z.a;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/wxa_redirecting_page/export/WxaRedirectingPageExportApi$WXBizEntryActivityPendingMap;", "", "()V", "map", "Landroid/util/SparseArray;", "Landroid/app/Activity;", "finish", "invokeTicket", "", "get", "remove", "set", "", "activity", "api-protocol_release"})
public final class a$a
{
  private static final SparseArray<Activity> lvo;
  public static final a nqe;
  
  static
  {
    AppMethodBeat.i(218891);
    nqe = new a();
    lvo = new SparseArray();
    Object localObject = aj.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getApplicationContext();
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type android.app.Application");
      AppMethodBeat.o(218891);
      throw ((Throwable)localObject);
    }
    ((Application)localObject).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new a()
    {
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(218888);
        super.onActivityDestroyed(paramAnonymousActivity);
        if (paramAnonymousActivity != null)
        {
          locala = a.a.nqe;
          if (a.a.bFN().size() > 0) {}
        }
        else
        {
          AppMethodBeat.o(218888);
          return;
        }
        a.a locala = a.a.nqe;
        int i = a.a.bFN().indexOfValue(paramAnonymousActivity);
        if (i >= 0)
        {
          paramAnonymousActivity = a.a.nqe;
          a.a.bFN().removeAt(i);
        }
        AppMethodBeat.o(218888);
      }
    });
    AppMethodBeat.o(218891);
  }
  
  public static Activity VH(String paramString)
  {
    AppMethodBeat.i(218890);
    p.h(paramString, "invokeTicket");
    p.h(paramString, "invokeTicket");
    int i = lvo.indexOfKey(paramString.hashCode());
    if (i >= 0)
    {
      paramString = lvo.valueAt(i);
      lvo.removeAt(i);
    }
    for (paramString = (Activity)paramString; paramString == null; paramString = null)
    {
      AppMethodBeat.o(218890);
      return null;
    }
    Object localObject = bt.aJ((Context)paramString, paramString.getTaskId());
    if (localObject != null)
    {
      localObject = ((ActivityManager.RunningTaskInfo)localObject).baseActivity;
      if (localObject != null)
      {
        localObject = ((ComponentName)localObject).getClassName();
        if ((localObject != null) && (n.nA((String)localObject, "WXEntryActivity") == true) && (Build.VERSION.SDK_INT >= 21)) {
          paramString.finishAndRemoveTask();
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(218890);
      return paramString;
      paramString.finish();
    }
  }
  
  public static final void b(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(218889);
    p.h(paramString, "invokeTicket");
    p.h(paramActivity, "activity");
    lvo.put(paramString.hashCode(), paramActivity);
    AppMethodBeat.o(218889);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ae.a.a.a
 * JD-Core Version:    0.7.0.1
 */