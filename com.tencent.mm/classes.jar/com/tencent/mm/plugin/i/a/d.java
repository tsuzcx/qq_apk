package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class d
{
  public static final Pattern jrU;
  public static int tfL;
  
  static
  {
    AppMethodBeat.i(209260);
    jrU = Pattern.compile("<a>(.+?)</a>");
    tfL = 33554432;
    AppMethodBeat.o(209260);
  }
  
  public static abstract interface a
  {
    public static final int tfM = Math.max(4, Runtime.getRuntime().availableProcessors());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.d
 * JD-Core Version:    0.7.0.1
 */