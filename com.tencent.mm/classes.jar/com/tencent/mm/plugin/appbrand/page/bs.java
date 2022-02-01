package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.loader.a;

final class bs
{
  static boolean b(br parambr)
  {
    return (parambr != br.mkg) && (parambr != br.mkn) && (parambr != br.mkj) && (parambr != br.mkk) && (parambr != br.mkl) && (parambr != br.mkm);
  }
  
  static boolean c(br parambr)
  {
    return (parambr == br.mkj) || (parambr == br.mkk) || (parambr == br.mkn) || (parambr == br.mkl) || (parambr == br.mkm);
  }
  
  static boolean d(br parambr)
  {
    AppMethodBeat.i(207860);
    boolean bool = a.contains(new br[] { br.mkn, br.mkl, br.mkm }, parambr);
    AppMethodBeat.o(207860);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bs
 * JD-Core Version:    0.7.0.1
 */