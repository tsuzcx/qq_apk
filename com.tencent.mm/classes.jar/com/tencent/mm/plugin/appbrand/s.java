package com.tencent.mm.plugin.appbrand;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingMainProcessTriggerCheckEvent;", "Lcom/tencent/mm/sdk/event/IEvent;", "()V", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
  extends IEvent
{
  private static long mgb;
  public static final a quK;
  private static final long quL;
  
  static
  {
    AppMethodBeat.i(316639);
    quK = new a((byte)0);
    quL = TimeUnit.MINUTES.toMillis(1L);
    AppMethodBeat.o(316639);
  }
  
  public static final void publish()
  {
    AppMethodBeat.i(316618);
    a.publish();
    AppMethodBeat.o(316618);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/AppBrandRuntimeSuspendingMainProcessTriggerCheckEvent$Companion;", "", "()V", "CHECK_INTERVAL_MILLIS", "", "lastCheckTick", "publish", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final void ah(a parama)
    {
      AppMethodBeat.i(316925);
      kotlin.g.b.s.u(parama, "$tmp0");
      parama.invoke();
      AppMethodBeat.o(316925);
    }
    
    public static void publish()
    {
      AppMethodBeat.i(316916);
      if (MMApplicationContext.isMainProcess())
      {
        if (Util.ticksToNow(s.aUq()) < s.cct())
        {
          AppMethodBeat.o(316916);
          return;
        }
        s.hu(Util.currentTicks());
        a locala = (a)a.quM;
        if (kotlin.g.b.s.p(Looper.getMainLooper(), Looper.myLooper()))
        {
          h.ahAA.j(new s.a..ExternalSyntheticLambda0(locala), "AppBrandRuntimeSuspendingMMGuardCheckSuspendedEvent");
          AppMethodBeat.o(316916);
          return;
        }
        locala.invoke();
        AppMethodBeat.o(316916);
        return;
      }
      new s().asyncPublish(Looper.getMainLooper());
      AppMethodBeat.o(316916);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      public static final a quM;
      
      static
      {
        AppMethodBeat.i(317252);
        quM = new a();
        AppMethodBeat.o(317252);
      }
      
      a()
      {
        super();
      }
      
      private static final void a(IPCVoid paramIPCVoid, f paramf)
      {
        AppMethodBeat.i(317249);
        new s().asyncPublish(Looper.getMainLooper());
        if (paramf != null) {
          paramf.onCallback(IPCVoid.mzv);
        }
        AppMethodBeat.o(317249);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s
 * JD-Core Version:    0.7.0.1
 */