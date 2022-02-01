package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.akh;

public final class e
{
  public static boolean JB(int paramInt)
  {
    AppMethodBeat.i(108375);
    if ((fX(paramInt, 4)) || (fX(paramInt, 8)))
    {
      AppMethodBeat.o(108375);
      return true;
    }
    AppMethodBeat.o(108375);
    return false;
  }
  
  public static boolean a(akh paramakh)
  {
    AppMethodBeat.i(108373);
    if (paramakh == null)
    {
      AppMethodBeat.o(108373);
      return false;
    }
    boolean bool = fX(paramakh.TOG, 1);
    AppMethodBeat.o(108373);
    return bool;
  }
  
  public static boolean b(akh paramakh)
  {
    AppMethodBeat.i(108374);
    if ((c(paramakh)) || (d(paramakh)))
    {
      AppMethodBeat.o(108374);
      return true;
    }
    AppMethodBeat.o(108374);
    return false;
  }
  
  private static boolean c(akh paramakh)
  {
    AppMethodBeat.i(108376);
    if (paramakh == null)
    {
      AppMethodBeat.o(108376);
      return false;
    }
    boolean bool = fX(paramakh.Tey, 4);
    AppMethodBeat.o(108376);
    return bool;
  }
  
  private static boolean d(akh paramakh)
  {
    AppMethodBeat.i(108377);
    if (paramakh == null)
    {
      AppMethodBeat.o(108377);
      return false;
    }
    boolean bool = fX(paramakh.Tey, 8);
    AppMethodBeat.o(108377);
    return bool;
  }
  
  public static boolean e(akh paramakh)
  {
    AppMethodBeat.i(108378);
    if (paramakh == null)
    {
      AppMethodBeat.o(108378);
      return false;
    }
    boolean bool = fX(paramakh.TOG, 8);
    AppMethodBeat.o(108378);
    return bool;
  }
  
  public static boolean fX(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.e
 * JD-Core Version:    0.7.0.1
 */