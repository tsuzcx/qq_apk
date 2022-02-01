package com.tencent.mm.plugin.appbrand.ui;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandUIMoveTaskToBackGuardLogic;", "", "()V", "TAG", "", "onMMTaskToFrontListeners", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlin/Function0;", "", "install", "application", "Landroid/app/Application;", "registerOnMMTaskToFrontListener", "key", "block", "unregisterOnMMTaskToFrontListener", "plugin-appbrand-integration_release"})
public final class t
{
  private static final ConcurrentHashMap<String, kotlin.g.a.a<x>> qZt;
  public static final t qZu;
  
  static
  {
    AppMethodBeat.i(270424);
    qZu = new t();
    qZt = new ConcurrentHashMap();
    AppMethodBeat.o(270424);
  }
  
  public static void amU(String paramString)
  {
    AppMethodBeat.i(270423);
    p.k(paramString, "key");
    qZt.remove(paramString);
    AppMethodBeat.o(270423);
  }
  
  public static void i(String paramString, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(270421);
    p.k(paramString, "key");
    p.k(parama, "block");
    ((Map)qZt).put(paramString, parama);
    AppMethodBeat.o(270421);
  }
  
  public static final void install(Application paramApplication)
  {
    AppMethodBeat.i(270419);
    p.k(paramApplication, "application");
    paramApplication.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new a());
    AppMethodBeat.o(270419);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/ui/AppBrandUIMoveTaskToBackGuardLogic$install$1", "Lcom/tencent/mm/plugin/appbrand/util/ActivityLifecycleCallbacksAdapter;", "onActivityPostStarted", "", "activity", "Landroid/app/Activity;", "plugin-appbrand-integration_release"})
  public static final class a
    extends com.tencent.mm.plugin.appbrand.ac.a
  {
    public final void onActivityPostStarted(Activity paramActivity)
    {
      AppMethodBeat.i(274713);
      p.k(paramActivity, "activity");
      Object localObject = t.qZu;
      if (t.ckn().size() > 0)
      {
        int i = paramActivity.getTaskId();
        localObject = (com.tencent.mm.ui.l.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.ui.l.a.class);
        if (localObject == null) {
          break label108;
        }
        localObject = ((com.tencent.mm.ui.l.a)localObject).hHi();
        if (localObject == null) {
          break label108;
        }
        if (i == ((Activity)localObject).getTaskId())
        {
          Log.i("MicroMsg.AppBrandUIMoveTaskToBackGuardLogic", "onActivityPostStarted " + paramActivity + ", invoke onMMTaskToFront");
          com.tencent.e.h.ZvG.bg((Runnable)a.qZv);
        }
      }
      AppMethodBeat.o(274713);
      return;
      label108:
      AppMethodBeat.o(274713);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      public static final a qZv;
      
      static
      {
        AppMethodBeat.i(271998);
        qZv = new a();
        AppMethodBeat.o(271998);
      }
      
      public final void run()
      {
        AppMethodBeat.i(271996);
        Object localObject = t.qZu;
        localObject = ((Map)t.ckn()).entrySet().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((kotlin.g.a.a)((Map.Entry)((Iterator)localObject).next()).getValue()).invoke();
        }
        AppMethodBeat.o(271996);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.t
 * JD-Core Version:    0.7.0.1
 */