package com.tencent.mm.plugin.appbrand.game.g;

import com.hilive.mediasdk.LoadDelegate.ILoadLibrary;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;

final class b$12
  implements LoadDelegate.ILoadLibrary
{
  b$12(b paramb) {}
  
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(45341);
    b.class.getClassLoader();
    j.KW(paramString);
    AppMethodBeat.o(45341);
  }
  
  public final void loadLibrary(String paramString, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(45342);
    j.KW(paramString);
    AppMethodBeat.o(45342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.12
 * JD-Core Version:    0.7.0.1
 */