package com.tencent.mm.plugin.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cjb;

public final class e
{
  public static boolean Kj(int paramInt)
  {
    AppMethodBeat.i(108375);
    if ((gO(paramInt, 4)) || (gO(paramInt, 8)))
    {
      AppMethodBeat.o(108375);
      return true;
    }
    AppMethodBeat.o(108375);
    return false;
  }
  
  public static boolean a(cjb paramcjb)
  {
    AppMethodBeat.i(108373);
    if (paramcjb == null)
    {
      AppMethodBeat.o(108373);
      return false;
    }
    boolean bool = gO(paramcjb.akke, 1);
    AppMethodBeat.o(108373);
    return bool;
  }
  
  public static boolean b(cjb paramcjb)
  {
    AppMethodBeat.i(108374);
    if ((c(paramcjb)) || (d(paramcjb)))
    {
      AppMethodBeat.o(108374);
      return true;
    }
    AppMethodBeat.o(108374);
    return false;
  }
  
  private static boolean c(cjb paramcjb)
  {
    AppMethodBeat.i(108376);
    if (paramcjb == null)
    {
      AppMethodBeat.o(108376);
      return false;
    }
    boolean bool = gO(paramcjb.akkd, 4);
    AppMethodBeat.o(108376);
    return bool;
  }
  
  private static boolean d(cjb paramcjb)
  {
    AppMethodBeat.i(108377);
    if (paramcjb == null)
    {
      AppMethodBeat.o(108377);
      return false;
    }
    boolean bool = gO(paramcjb.akkd, 8);
    AppMethodBeat.o(108377);
    return bool;
  }
  
  public static boolean e(cjb paramcjb)
  {
    AppMethodBeat.i(108378);
    if (paramcjb == null)
    {
      AppMethodBeat.o(108378);
      return false;
    }
    boolean bool = gO(paramcjb.akke, 8);
    AppMethodBeat.o(108378);
    return bool;
  }
  
  public static boolean f(cjb paramcjb)
  {
    AppMethodBeat.i(269940);
    boolean bool = gO(paramcjb.akkd, 2);
    AppMethodBeat.o(269940);
    return bool;
  }
  
  public static boolean g(cjb paramcjb)
  {
    AppMethodBeat.i(269946);
    if ((paramcjb.akkh > 0) && (paramcjb.akkh < System.currentTimeMillis()))
    {
      AppMethodBeat.o(269946);
      return true;
    }
    AppMethodBeat.o(269946);
    return false;
  }
  
  public static boolean gO(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.a.e
 * JD-Core Version:    0.7.0.1
 */