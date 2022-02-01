package com.tencent.mm.plugin.appbrand.ah.a;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/wxa_redirecting_page/export/WxaRedirectingPageExportApi$WXBizEntryActivityPendingMap;", "", "()V", "TAG", "", "map", "Landroid/util/SparseArray;", "Landroid/app/Activity;", "finish", "invokeTicket", "get", "remove", "set", "", "activity", "api-protocol_release"})
public final class a$a
{
  private static final SparseArray<Activity> mHa;
  public static final a oFy;
  
  static
  {
    AppMethodBeat.i(194332);
    oFy = new a();
    mHa = new SparseArray();
    Object localObject = MMApplicationContext.getContext();
    p.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getApplicationContext();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.app.Application");
      AppMethodBeat.o(194332);
      throw ((Throwable)localObject);
    }
    ((Application)localObject).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new com.tencent.mm.plugin.appbrand.ac.a()
    {
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(194328);
        super.onActivityDestroyed(paramAnonymousActivity);
        if (paramAnonymousActivity != null)
        {
          locala = a.a.oFy;
          if (a.a.cdh().size() > 0) {}
        }
        else
        {
          AppMethodBeat.o(194328);
          return;
        }
        a.a locala = a.a.oFy;
        int i = a.a.cdh().indexOfValue(paramAnonymousActivity);
        if (i >= 0)
        {
          paramAnonymousActivity = a.a.oFy;
          a.a.cdh().removeAt(i);
        }
        AppMethodBeat.o(194328);
      }
    });
    AppMethodBeat.o(194332);
  }
  
  public static Activity agm(String paramString)
  {
    AppMethodBeat.i(194331);
    p.h(paramString, "invokeTicket");
    p.h(paramString, "invokeTicket");
    int i = mHa.indexOfKey(paramString.hashCode());
    if (i >= 0)
    {
      localObject1 = mHa.valueAt(i);
      mHa.removeAt(i);
    }
    for (Object localObject1 = (Activity)localObject1; localObject1 == null; localObject1 = null)
    {
      paramString = (Activity)((kotlin.g.a.a)new a.a.a(paramString)).invoke();
      AppMethodBeat.o(194331);
      return paramString;
    }
    Object localObject2 = Util.getCurrentTaskInfo((Context)localObject1, ((Activity)localObject1).getTaskId());
    if (localObject2 != null)
    {
      localObject2 = ((ActivityManager.RunningTaskInfo)localObject2).baseActivity;
      if (localObject2 != null)
      {
        localObject2 = ((ComponentName)localObject2).getClassName();
        if ((localObject2 != null) && (n.K((String)localObject2, "WXEntryActivity", false) == true) && (Build.VERSION.SDK_INT >= 21))
        {
          ((Activity)localObject1).finishAndRemoveTask();
          Log.i("MicroMsg.WxaRedirectingPageExportApi.WXBizEntryActivityPendingMap", "finish with ticket:" + paramString + ", invoke finishAndRemoveTask(), wxBizEntryActivity:" + ((Activity)localObject1).hashCode());
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(194331);
      return localObject1;
      ((Activity)localObject1).finish();
      Log.i("MicroMsg.WxaRedirectingPageExportApi.WXBizEntryActivityPendingMap", "finish with ticket:" + paramString + ", invoke finish(), wxBizEntryActivity:" + ((Activity)localObject1).hashCode());
    }
  }
  
  public static final void b(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(194330);
    p.h(paramString, "invokeTicket");
    p.h(paramActivity, "activity");
    mHa.put(paramString.hashCode(), paramActivity);
    AppMethodBeat.o(194330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ah.a.a.a
 * JD-Core Version:    0.7.0.1
 */