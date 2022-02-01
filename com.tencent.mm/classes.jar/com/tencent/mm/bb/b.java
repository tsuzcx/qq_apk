package com.tencent.mm.bb;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static boolean WL(String paramString)
  {
    AppMethodBeat.i(137007);
    f localf = a.bnA();
    if ((localf != null) && (localf.lVz.equals(paramString)))
    {
      AppMethodBeat.o(137007);
      return true;
    }
    AppMethodBeat.o(137007);
    return false;
  }
  
  public static boolean bnC()
  {
    AppMethodBeat.i(137004);
    if ((a.bnz()) && (!a.bnx()))
    {
      a.bnu();
      AppMethodBeat.o(137004);
      return true;
    }
    AppMethodBeat.o(137004);
    return false;
  }
  
  public static boolean bnD()
  {
    AppMethodBeat.i(137005);
    if (a.bnx())
    {
      a.bnt();
      AppMethodBeat.o(137005);
      return true;
    }
    AppMethodBeat.o(137005);
    return false;
  }
  
  public static boolean bnE()
  {
    AppMethodBeat.i(137006);
    if (a.bnz())
    {
      a.bnv();
      AppMethodBeat.o(137006);
      return true;
    }
    AppMethodBeat.o(137006);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.bb.b
 * JD-Core Version:    0.7.0.1
 */