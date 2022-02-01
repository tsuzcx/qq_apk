package com.tencent.mm.plugin.appbrand.app;

import android.app.ActivityManager.AppTask;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicate;", "", "isZombieTask", "", "appTask", "Landroid/app/ActivityManager$AppTask;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
abstract interface h$c
{
  public static final a qCg = a.qCh;
  
  public abstract boolean b(ActivityManager.AppTask paramAppTask);
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicate$Companion;", "", "()V", "impl", "Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicate;", "getImpl", "()Lcom/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicate;", "impl$delegate", "Lkotlin/Lazy;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final j<h.c.a.a.1> qCi;
    
    static
    {
      AppMethodBeat.i(317729);
      qCh = new a();
      qCi = k.cm((a)a.qCj);
      AppMethodBeat.o(317729);
    }
    
    public static h.c ceO()
    {
      AppMethodBeat.i(317728);
      h.c localc = (h.c)qCi.getValue();
      AppMethodBeat.o(317728);
      return localc;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "com/tencent/mm/plugin/appbrand/app/AppBrandZombieTaskKiller$ZombieTaskPredicate$Companion$impl$2$1"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<1>
    {
      public static final a qCj;
      
      static
      {
        AppMethodBeat.i(317683);
        qCj = new a();
        AppMethodBeat.o(317683);
      }
      
      a()
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.app.h.c
 * JD-Core Version:    0.7.0.1
 */