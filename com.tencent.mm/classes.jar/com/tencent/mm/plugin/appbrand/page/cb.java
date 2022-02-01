package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;

final class cb
{
  static boolean d(ca paramca)
  {
    return (paramca != ca.qwx) && (paramca != ca.qwE) && (paramca != ca.qwA) && (paramca != ca.qwB) && (paramca != ca.qwC) && (paramca != ca.qwD);
  }
  
  static boolean e(ca paramca)
  {
    return (paramca == ca.qwA) || (paramca == ca.qwB) || (paramca == ca.qwE) || (paramca == ca.qwC) || (paramca == ca.qwD);
  }
  
  static boolean f(ca paramca)
  {
    AppMethodBeat.i(246533);
    boolean bool = a.contains(new ca[] { ca.qwE, ca.qwC, ca.qwD }, paramca);
    AppMethodBeat.o(246533);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.cb
 * JD-Core Version:    0.7.0.1
 */