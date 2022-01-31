package com.tencent.mm.plugin.appbrand.game.g;

import com.hilive.mediasdk.LoadDelegate.ILoadLibrary;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;

final class b$3
  implements LoadDelegate.ILoadLibrary
{
  b$3(b paramb) {}
  
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(143216);
    k.a(paramString, b.class.getClassLoader());
    AppMethodBeat.o(143216);
  }
  
  public final void loadLibrary(String paramString, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(143217);
    k.a(paramString, paramClassLoader);
    AppMethodBeat.o(143217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.b.3
 * JD-Core Version:    0.7.0.1
 */