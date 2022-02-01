package com.tencent.maas;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
  implements com.facebook.soloader.a.b
{
  final b eEL;
  
  public a$a(b paramb)
  {
    this.eEL = paramb;
  }
  
  public final boolean cz(String paramString)
  {
    AppMethodBeat.i(216763);
    this.eEL.loadLibrary(paramString);
    AppMethodBeat.o(216763);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.a.a
 * JD-Core Version:    0.7.0.1
 */