package com.tencent.mm.d.a;

import com.eclipsesource.v8.ILoadLibraryDelegate;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.ab;

final class g$1
  implements ILoadLibraryDelegate
{
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(113799);
    k.a("mmv8", i.class.getClassLoader());
    k.a("node", i.class.getClassLoader());
    k.a("j2v8", i.class.getClassLoader());
    k.a("c++_shared", i.class.getClassLoader());
    k.a("mmskia", i.class.getClassLoader());
    k.a("skia-canvas", i.class.getClassLoader());
    k.a("skia-canvas-log-bridge", i.class.getClassLoader());
    ab.i("MicroMsg.JSRuntimeCreator", "load so done");
    AppMethodBeat.o(113799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.d.a.g.1
 * JD-Core Version:    0.7.0.1
 */