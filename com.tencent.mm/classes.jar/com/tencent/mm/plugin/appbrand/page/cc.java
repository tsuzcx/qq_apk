package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;

final class cc
{
  static boolean g(cb paramcb)
  {
    return (paramcb != cb.tBm) && (paramcb != cb.tBt) && (paramcb != cb.tBp) && (paramcb != cb.tBq) && (paramcb != cb.tBr) && (paramcb != cb.tBs);
  }
  
  static boolean h(cb paramcb)
  {
    return (paramcb == cb.tBp) || (paramcb == cb.tBq) || (paramcb == cb.tBt) || (paramcb == cb.tBr) || (paramcb == cb.tBs);
  }
  
  static boolean i(cb paramcb)
  {
    AppMethodBeat.i(324960);
    boolean bool = a.contains(new cb[] { cb.tBt, cb.tBr, cb.tBs }, paramcb);
    AppMethodBeat.o(324960);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.cc
 * JD-Core Version:    0.7.0.1
 */