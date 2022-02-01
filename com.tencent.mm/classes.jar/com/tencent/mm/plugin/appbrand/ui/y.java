package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIMoveTaskToBackGuardLogic;", "", "()V", "TAG", "", "onMMTaskToFrontListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Function0;", "", "install", "application", "Landroid/app/Application;", "registerOnMMTaskToFrontListener", "key", "block", "unregisterOnMMTaskToFrontListener", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class y
{
  public static final y ufu;
  private static final ConcurrentHashMap<String, kotlin.g.a.a<ah>> ufv;
  
  static
  {
    AppMethodBeat.i(322182);
    ufu = new y();
    ufv = new ConcurrentHashMap();
    AppMethodBeat.o(322182);
  }
  
  public static void agh(String paramString)
  {
    AppMethodBeat.i(322175);
    s.u(paramString, "key");
    ufv.remove(paramString);
    AppMethodBeat.o(322175);
  }
  
  public static final void m(Application paramApplication)
  {
    AppMethodBeat.i(322163);
    s.u(paramApplication, "application");
    paramApplication.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new a());
    AppMethodBeat.o(322163);
  }
  
  public static void o(String paramString, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(322169);
    s.u(paramString, "key");
    s.u(parama, "block");
    ((Map)ufv).put(paramString, parama);
    AppMethodBeat.o(322169);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/ui/AppBrandUIMoveTaskToBackGuardLogic$install$1", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "onActivityPostStarted", "", "activity", "Landroid/app/Activity;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends com.tencent.mm.plugin.appbrand.af.a
  {
    private static final void cLC()
    {
      AppMethodBeat.i(321903);
      Iterator localIterator = ((Map)y.cLB()).entrySet().iterator();
      while (localIterator.hasNext()) {
        ((kotlin.g.a.a)((Map.Entry)localIterator.next()).getValue()).invoke();
      }
      AppMethodBeat.o(321903);
    }
    
    public final void onActivityPostStarted(Activity paramActivity)
    {
      AppMethodBeat.i(321908);
      s.u(paramActivity, "activity");
      if (y.cLB().size() > 0)
      {
        i = paramActivity.getTaskId();
        Object localObject = (com.tencent.mm.ui.l.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.ui.l.a.class);
        if (localObject == null) {
          break label107;
        }
        localObject = ((com.tencent.mm.ui.l.a)localObject).jjs();
        if ((localObject == null) || (i != ((Activity)localObject).getTaskId())) {
          break label107;
        }
      }
      label107:
      for (int i = 1;; i = 0)
      {
        if (i != 0)
        {
          Log.i("MicroMsg.AppBrandUIMoveTaskToBackGuardLogic", "onActivityPostStarted " + paramActivity + ", invoke onMMTaskToFront");
          com.tencent.threadpool.h.ahAA.bo(y.a..ExternalSyntheticLambda0.INSTANCE);
        }
        AppMethodBeat.o(321908);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.y
 * JD-Core Version:    0.7.0.1
 */