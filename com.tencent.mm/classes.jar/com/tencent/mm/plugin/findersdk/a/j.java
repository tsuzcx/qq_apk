package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class j
{
  public static int Bvf;
  public static int Bvg;
  public static final Pattern PATTERN;
  
  static
  {
    AppMethodBeat.i(208811);
    PATTERN = Pattern.compile("<a>(.+?)</a>");
    Bvf = 0;
    Bvg = 33554432;
    AppMethodBeat.o(208811);
  }
  
  public static boolean Sg(int paramInt)
  {
    return (paramInt == 76) || (paramInt == 77) || (paramInt == 80);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.j
 * JD-Core Version:    0.7.0.1
 */