package com.tencent.mm.plugin.finder.utils;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.jc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/utils/FinderLbsLogic$syncWaitLbs$1$listener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderLocationRefreshEvent;", "callback", "", "event", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLbsLogic$syncWaitLbs$1$listener$1
  extends IListener<jc>
{
  FinderLbsLogic$syncWaitLbs$1$listener$1(Object paramObject, f paramf)
  {
    super((q)paramf);
    AppMethodBeat.i(333897);
    AppMethodBeat.o(333897);
  }
  
  private boolean a(jc paramjc)
  {
    AppMethodBeat.i(333904);
    s.u(paramjc, "event");
    dead();
    paramjc = this.Geq;
    Object localObject1 = this.Geq;
    try
    {
      Log.i(v.aUw(), "notify syncWaitLbs");
      localObject1.notifyAll();
      localObject1 = ah.aiuX;
      return true;
    }
    finally
    {
      AppMethodBeat.o(333904);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.FinderLbsLogic.syncWaitLbs.1.listener.1
 * JD-Core Version:    0.7.0.1
 */