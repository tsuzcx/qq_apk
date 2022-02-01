package com.tencent.mm.plugin.i.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class k
{
  public static final Pattern PATTERN;
  public static int wEa;
  public static int wEb;
  
  static
  {
    AppMethodBeat.i(209314);
    PATTERN = Pattern.compile("<a>(.+?)</a>");
    wEa = 0;
    wEb = 33554432;
    AppMethodBeat.o(209314);
  }
  
  public static boolean MM(int paramInt)
  {
    return (paramInt == 76) || (paramInt == 77) || (paramInt == 80);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.i.a.k
 * JD-Core Version:    0.7.0.1
 */