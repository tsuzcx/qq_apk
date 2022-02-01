package com.tencent.mm.plugin.expt.trigger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/trigger/NewMsgRingtoneSingleton;", "Lcom/tencent/mm/plugin/expt/trigger/IExptSdkTrigger;", "()V", "trigger", "", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements b
{
  public static final d.a zNw;
  
  static
  {
    AppMethodBeat.i(299423);
    zNw = new d.a((byte)0);
    AppMethodBeat.o(299423);
  }
  
  public final void aXY()
  {
    AppMethodBeat.i(299429);
    if (((c)h.ax(c.class)).a(c.a.yUJ, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.NewMsgRingtoneSingleton", s.X("trigger ringtoneSw:", Boolean.valueOf(bool)));
      if ((com.tencent.mm.compatible.util.d.rb(26)) && (!bool)) {
        com.tencent.mm.plugin.notification.b.aQu("");
      }
      AppMethodBeat.o(299429);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.trigger.d
 * JD-Core Version:    0.7.0.1
 */