package com.tencent.mm.plugin.findersdk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.regex.Pattern;

public final class k
{
  public static int Hca;
  public static int Hcb;
  public static final Pattern PATTERN;
  
  static
  {
    AppMethodBeat.i(273974);
    PATTERN = Pattern.compile("<a>(.+?)</a>");
    Hca = 0;
    Hcb = 33554432;
    AppMethodBeat.o(273974);
  }
  
  public static boolean Vz(int paramInt)
  {
    return (paramInt == 76) || (paramInt == 77) || (paramInt == 80);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.a.k
 * JD-Core Version:    0.7.0.1
 */