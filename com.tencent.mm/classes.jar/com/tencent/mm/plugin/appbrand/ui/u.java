package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIMoveTaskToBackGuardLogic;", "", "()V", "TAG", "", "onMMTaskToFrontListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Function0;", "", "install", "application", "Landroid/app/Application;", "registerOnMMTaskToFrontListener", "key", "block", "unregisterOnMMTaskToFrontListener", "plugin-appbrand-integration_release"})
public final class u
{
  private static final ConcurrentHashMap<String, kotlin.g.a.a<x>> nXL;
  public static final u nXM;
  
  static
  {
    AppMethodBeat.i(229528);
    nXM = new u();
    nXL = new ConcurrentHashMap();
    AppMethodBeat.o(229528);
  }
  
  public static void afs(String paramString)
  {
    AppMethodBeat.i(229527);
    p.h(paramString, "key");
    nXL.remove(paramString);
    AppMethodBeat.o(229527);
  }
  
  public static void i(String paramString, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(229526);
    p.h(paramString, "key");
    p.h(parama, "block");
    ((Map)nXL).put(paramString, parama);
    AppMethodBeat.o(229526);
  }
  
  public static final void install(Application paramApplication)
  {
    AppMethodBeat.i(229525);
    p.h(paramApplication, "application");
    paramApplication.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new a());
    AppMethodBeat.o(229525);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/ui/AppBrandUIMoveTaskToBackGuardLogic$install$1", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "onActivityPostStarted", "", "activity", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
  public static final class a
    extends com.tencent.mm.plugin.appbrand.ac.a
  {
    public final void onActivityPostStarted(Activity paramActivity)
    {
      AppMethodBeat.i(229524);
      p.h(paramActivity, "activity");
      Object localObject = u.nXM;
      if (u.bXD().size() > 0)
      {
        int i = paramActivity.getTaskId();
        localObject = (com.tencent.mm.ui.j.a)g.af(com.tencent.mm.ui.j.a.class);
        if (localObject == null) {
          break label108;
        }
        localObject = ((com.tencent.mm.ui.j.a)localObject).gIw();
        if (localObject == null) {
          break label108;
        }
        if (i == ((Activity)localObject).getTaskId())
        {
          Log.i("MicroMsg.AppBrandUIMoveTaskToBackGuardLogic", "onActivityPostStarted " + paramActivity + ", invoke onMMTaskToFront");
          h.RTc.aZ((Runnable)a.nXN);
        }
      }
      AppMethodBeat.o(229524);
      return;
      label108:
      AppMethodBeat.o(229524);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a nXN;
      
      static
      {
        AppMethodBeat.i(229523);
        nXN = new a();
        AppMethodBeat.o(229523);
      }
      
      public final void run()
      {
        AppMethodBeat.i(229522);
        Object localObject = u.nXM;
        localObject = ((Map)u.bXD()).entrySet().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((kotlin.g.a.a)((Map.Entry)((Iterator)localObject).next()).getValue()).invoke();
        }
        AppMethodBeat.o(229522);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.u
 * JD-Core Version:    0.7.0.1
 */