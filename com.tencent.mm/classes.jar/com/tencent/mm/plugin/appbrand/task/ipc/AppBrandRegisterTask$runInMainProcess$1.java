package com.tencent.mm.plugin.appbrand.task.ipc;

import androidx.lifecycle.q;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.dc;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/task/ipc/AppBrandRegisterTask$runInMainProcess$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/CoreAccountInitializationNotifiedEvent;", "callback", "", "event", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandRegisterTask$runInMainProcess$1
  extends IListener<dc>
{
  AppBrandRegisterTask$runInMainProcess$1(AppBrandInitConfigWC paramAppBrandInitConfigWC, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(318629);
    AppMethodBeat.o(318629);
  }
  
  private boolean a(dc paramdc)
  {
    AppMethodBeat.i(318635);
    s.u(paramdc, "event");
    h.ckG().a(this.tWO.username, (AppBrandInitConfigLU)this.tWO);
    dead();
    AppMethodBeat.o(318635);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.ipc.AppBrandRegisterTask.runInMainProcess.1
 * JD-Core Version:    0.7.0.1
 */