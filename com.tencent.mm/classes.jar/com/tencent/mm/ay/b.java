package com.tencent.mm.ay;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static boolean GC(String paramString)
  {
    AppMethodBeat.i(137007);
    f localf = a.aKc();
    if ((localf != null) && (localf.ikf.equals(paramString)))
    {
      AppMethodBeat.o(137007);
      return true;
    }
    AppMethodBeat.o(137007);
    return false;
  }
  
  public static boolean aKe()
  {
    AppMethodBeat.i(137004);
    if ((a.aKb()) && (!a.aJZ()))
    {
      a.aJW();
      AppMethodBeat.o(137004);
      return true;
    }
    AppMethodBeat.o(137004);
    return false;
  }
  
  public static boolean aKf()
  {
    AppMethodBeat.i(137005);
    if (a.aJZ())
    {
      a.aJV();
      AppMethodBeat.o(137005);
      return true;
    }
    AppMethodBeat.o(137005);
    return false;
  }
  
  public static boolean aKg()
  {
    AppMethodBeat.i(137006);
    if (a.aKb())
    {
      a.aJX();
      AppMethodBeat.o(137006);
      return true;
    }
    AppMethodBeat.o(137006);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ay.b
 * JD-Core Version:    0.7.0.1
 */