package com.tencent.mm.plugin.appbrand.ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class c
{
  public static boolean aNA()
  {
    AppMethodBeat.i(133562);
    if (((a)g.E(a.class)).a(a.a.lRI, 0) > 0)
    {
      AppMethodBeat.o(133562);
      return true;
    }
    AppMethodBeat.o(133562);
    return false;
  }
  
  public static boolean aNB()
  {
    AppMethodBeat.i(133563);
    if (((Integer)g.RL().Ru().get(ac.a.yDk, Integer.valueOf(0))).intValue() == 1)
    {
      AppMethodBeat.o(133563);
      return true;
    }
    AppMethodBeat.o(133563);
    return false;
  }
  
  public static boolean aNC()
  {
    AppMethodBeat.i(154351);
    if (((a)g.E(a.class)).a(a.a.lVw, -1) == 1)
    {
      AppMethodBeat.o(154351);
      return true;
    }
    AppMethodBeat.o(154351);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.c
 * JD-Core Version:    0.7.0.1
 */