package com.tencent.mm.d.a;

import com.eclipsesource.v8.V8;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  static
  {
    AppMethodBeat.i(113803);
    V8.setLoadLibraryDelegate(new g.1());
    AppMethodBeat.o(113803);
  }
  
  public static i g(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(113800);
    paramString = i.j(paramString, paramArrayOfByte);
    AppMethodBeat.o(113800);
    return paramString;
  }
  
  public static v h(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(113801);
    paramString = v.k(paramString, paramArrayOfByte);
    AppMethodBeat.o(113801);
    return paramString;
  }
  
  public static v i(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(113802);
    paramString = b.f(paramString, paramArrayOfByte);
    AppMethodBeat.o(113802);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.d.a.g
 * JD-Core Version:    0.7.0.1
 */