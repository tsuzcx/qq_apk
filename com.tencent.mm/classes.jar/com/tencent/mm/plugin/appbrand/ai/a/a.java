package com.tencent.mm.plugin.appbrand.ai.a;

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
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/wxa_redirecting_page/export/WxaRedirectingPageExportApi;", "", "()V", "WXBizEntryActivityPendingMap", "api-protocol_release"})
public final class a
{
  public static final a rHm;
  
  static
  {
    AppMethodBeat.i(192339);
    rHm = new a();
    AppMethodBeat.o(192339);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/wxa_redirecting_page/export/WxaRedirectingPageExportApi$WXBizEntryActivityPendingMap;", "", "()V", "TAG", "", "map", "Landroid/util/SparseArray;", "Landroid/app/Activity;", "finish", "invokeTicket", "get", "remove", "set", "", "activity", "api-protocol_release"})
  public static final class a
  {
    private static final SparseArray<Activity> pGf;
    public static final a rHn;
    
    static
    {
      AppMethodBeat.i(192438);
      rHn = new a();
      pGf = new SparseArray();
      Object localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getApplicationContext();
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type android.app.Application");
        AppMethodBeat.o(192438);
        throw ((Throwable)localObject);
      }
      ((Application)localObject).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new com.tencent.mm.plugin.appbrand.ac.a()
      {
        public final void onActivityDestroyed(Activity paramAnonymousActivity)
        {
          AppMethodBeat.i(192028);
          super.onActivityDestroyed(paramAnonymousActivity);
          if (paramAnonymousActivity != null)
          {
            locala = a.a.rHn;
            if (a.a.cqt().size() > 0) {}
          }
          else
          {
            AppMethodBeat.o(192028);
            return;
          }
          a.a locala = a.a.rHn;
          int i = a.a.cqt().indexOfValue(paramAnonymousActivity);
          if (i >= 0)
          {
            paramAnonymousActivity = a.a.rHn;
            a.a.cqt().removeAt(i);
          }
          AppMethodBeat.o(192028);
        }
      });
      AppMethodBeat.o(192438);
    }
    
    public static Activity anP(String paramString)
    {
      AppMethodBeat.i(192436);
      p.k(paramString, "invokeTicket");
      p.k(paramString, "invokeTicket");
      int i = pGf.indexOfKey(paramString.hashCode());
      if (i >= 0)
      {
        localObject1 = pGf.valueAt(i);
        pGf.removeAt(i);
      }
      for (Object localObject1 = (Activity)localObject1; localObject1 == null; localObject1 = null)
      {
        paramString = (Activity)((kotlin.g.a.a)new a(paramString)).invoke();
        AppMethodBeat.o(192436);
        return paramString;
      }
      Object localObject2 = Util.getCurrentTaskInfo((Context)localObject1, ((Activity)localObject1).getTaskId());
      if (localObject2 != null)
      {
        localObject2 = ((ActivityManager.RunningTaskInfo)localObject2).baseActivity;
        if (localObject2 != null)
        {
          localObject2 = ((ComponentName)localObject2).getClassName();
          if ((localObject2 != null) && (n.pu((String)localObject2, "WXEntryActivity") == true) && (Build.VERSION.SDK_INT >= 21))
          {
            ((Activity)localObject1).finishAndRemoveTask();
            Log.i("MicroMsg.WxaRedirectingPageExportApi.WXBizEntryActivityPendingMap", "finish with ticket:" + paramString + ", invoke finishAndRemoveTask(), wxBizEntryActivity:" + ((Activity)localObject1).hashCode());
          }
        }
      }
      for (;;)
      {
        AppMethodBeat.o(192436);
        return localObject1;
        ((Activity)localObject1).finish();
        Log.i("MicroMsg.WxaRedirectingPageExportApi.WXBizEntryActivityPendingMap", "finish with ticket:" + paramString + ", invoke finish(), wxBizEntryActivity:" + ((Activity)localObject1).hashCode());
      }
    }
    
    public static final void b(String paramString, Activity paramActivity)
    {
      AppMethodBeat.i(192425);
      p.k(paramString, "invokeTicket");
      p.k(paramActivity, "activity");
      pGf.put(paramString.hashCode(), paramActivity);
      AppMethodBeat.o(192425);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a
    {
      a(String paramString)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ai.a.a
 * JD-Core Version:    0.7.0.1
 */