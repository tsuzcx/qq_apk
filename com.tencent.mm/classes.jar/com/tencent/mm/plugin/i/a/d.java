package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class d
{
  public static final Pattern juN;
  public static int tqE;
  
  static
  {
    AppMethodBeat.i(189297);
    juN = Pattern.compile("<a>(.+?)</a>");
    tqE = 33554432;
    AppMethodBeat.o(189297);
  }
  
  public static abstract interface a
  {
    public static final int tqF = Math.max(4, Runtime.getRuntime().availableProcessors());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.d
 * JD-Core Version:    0.7.0.1
 */