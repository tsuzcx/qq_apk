package com.tencent.mm.plugin.appbrand.aj.a;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/wxa_redirecting_page/export/WxaRedirectingPageExportApi$WXBizEntryActivityPendingMap;", "", "()V", "TAG", "", "map", "Landroid/util/SparseArray;", "Landroid/app/Activity;", "finish", "invokeTicket", "get", "remove", "set", "", "activity", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  private static final SparseArray<Activity> sLp;
  public static final a uSD;
  
  static
  {
    AppMethodBeat.i(316978);
    uSD = new a();
    sLp = new SparseArray();
    Object localObject = MMApplicationContext.getContext().getApplicationContext();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.app.Application");
      AppMethodBeat.o(316978);
      throw ((Throwable)localObject);
    }
    ((Application)localObject).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new a()
    {
      public final void onActivityDestroyed(Activity paramAnonymousActivity)
      {
        AppMethodBeat.i(316965);
        s.u(paramAnonymousActivity, "activity");
        super.onActivityDestroyed(paramAnonymousActivity);
        if (a.a.cTa().size() <= 0)
        {
          AppMethodBeat.o(316965);
          return;
        }
        int i = a.a.cTa().indexOfValue(paramAnonymousActivity);
        if (i >= 0) {
          a.a.cTa().removeAt(i);
        }
        AppMethodBeat.o(316965);
      }
    });
    AppMethodBeat.o(316978);
  }
  
  public static Activity ahm(String paramString)
  {
    AppMethodBeat.i(316970);
    s.u(paramString, "invokeTicket");
    s.u(paramString, "invokeTicket");
    int i = sLp.indexOfKey(paramString.hashCode());
    if (i >= 0)
    {
      localObject1 = sLp.valueAt(i);
      sLp.removeAt(i);
    }
    for (Object localObject1 = (Activity)localObject1; localObject1 == null; localObject1 = null)
    {
      s.u(paramString, "$invokeTicket");
      Log.e("MicroMsg.WxaRedirectingPageExportApi.WXBizEntryActivityPendingMap", "finish with ticket:" + paramString + ", get null wxBizEntryActivity");
      AppMethodBeat.o(316970);
      return null;
    }
    Object localObject2 = Util.getCurrentTaskInfo((Context)localObject1, ((Activity)localObject1).getTaskId());
    if (localObject2 != null)
    {
      localObject2 = ((ActivityManager.RunningTaskInfo)localObject2).baseActivity;
      if (localObject2 != null)
      {
        localObject2 = ((ComponentName)localObject2).getClassName();
        if ((localObject2 != null) && (n.rs((String)localObject2, "WXEntryActivity") == true))
        {
          i = 1;
          if ((i == 0) || (Build.VERSION.SDK_INT < 21)) {
            break label207;
          }
          ((Activity)localObject1).finishAndRemoveTask();
          Log.i("MicroMsg.WxaRedirectingPageExportApi.WXBizEntryActivityPendingMap", "finish with ticket:" + paramString + ", invoke finishAndRemoveTask(), wxBizEntryActivity:" + ((Activity)localObject1).hashCode());
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(316970);
      return localObject1;
      i = 0;
      break;
      label207:
      ((Activity)localObject1).finish();
      Log.i("MicroMsg.WxaRedirectingPageExportApi.WXBizEntryActivityPendingMap", "finish with ticket:" + paramString + ", invoke finish(), wxBizEntryActivity:" + ((Activity)localObject1).hashCode());
    }
  }
  
  public static final void b(String paramString, Activity paramActivity)
  {
    AppMethodBeat.i(316964);
    s.u(paramString, "invokeTicket");
    s.u(paramActivity, "activity");
    sLp.put(paramString.hashCode(), paramActivity);
    AppMethodBeat.o(316964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.aj.a.a.a
 * JD-Core Version:    0.7.0.1
 */