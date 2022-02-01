package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;

final class by
{
  static boolean c(bx parambx)
  {
    return (parambx != bx.nuD) && (parambx != bx.nuK) && (parambx != bx.nuG) && (parambx != bx.nuH) && (parambx != bx.nuI) && (parambx != bx.nuJ);
  }
  
  static boolean d(bx parambx)
  {
    return (parambx == bx.nuG) || (parambx == bx.nuH) || (parambx == bx.nuK) || (parambx == bx.nuI) || (parambx == bx.nuJ);
  }
  
  static boolean e(bx parambx)
  {
    AppMethodBeat.i(219459);
    boolean bool = a.contains(new bx[] { bx.nuK, bx.nuI, bx.nuJ }, parambx);
    AppMethodBeat.o(219459);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.by
 * JD-Core Version:    0.7.0.1
 */