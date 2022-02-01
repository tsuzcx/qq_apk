package com.tencent.mm.plugin.finder.extension.reddot;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.su;
import com.tencent.mm.autogen.a.su.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.sdk.event.IListener;

class FinderDynamicTimeHelper$2
  extends IListener<su>
{
  FinderDynamicTimeHelper$2(a parama, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(366666);
    this.__eventId = su.class.getName().hashCode();
    AppMethodBeat.o(366666);
  }
  
  private boolean a(su paramsu)
  {
    AppMethodBeat.i(366675);
    try
    {
      if ("143".equals(paramsu.hWe.hWf)) {
        this.APM.APB = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().Su("FinderEntrance");
      }
      label43:
      AppMethodBeat.o(366675);
      return false;
    }
    catch (Exception paramsu)
    {
      break label43;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.reddot.FinderDynamicTimeHelper.2
 * JD-Core Version:    0.7.0.1
 */