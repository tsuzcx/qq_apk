package com.tencent.mm.plugin.brandservice.ui.timeline;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class c
{
  public static boolean aWM()
  {
    AppMethodBeat.i(14143);
    if ((((Integer)g.RL().Ru().get(ac.a.yKe, Integer.valueOf(0))).intValue() & 0x2) > 0)
    {
      AppMethodBeat.o(14143);
      return true;
    }
    AppMethodBeat.o(14143);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c
 * JD-Core Version:    0.7.0.1
 */