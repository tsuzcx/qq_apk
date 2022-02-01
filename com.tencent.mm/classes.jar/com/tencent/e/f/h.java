package com.tencent.e.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  private static boolean ahvq;
  private static g ahvr;
  
  static
  {
    AppMethodBeat.i(138483);
    ahvq = false;
    ahvr = new k();
    ahvq = false;
    ahvr = new k();
    AppMethodBeat.o(138483);
  }
  
  public static void hd(Object paramObject)
  {
    AppMethodBeat.i(138481);
    if ((paramObject != null) && ((paramObject instanceof Exception)))
    {
      new StringBuilder().append(paramObject);
      AppMethodBeat.o(138481);
      return;
    }
    AppMethodBeat.o(138481);
  }
  
  public static void he(Object paramObject)
  {
    AppMethodBeat.i(138482);
    if ((paramObject != null) && ((paramObject instanceof Exception)))
    {
      new StringBuilder().append(paramObject);
      AppMethodBeat.o(138482);
      return;
    }
    AppMethodBeat.o(138482);
  }
  
  public static void jXC() {}
  
  public static void jXD() {}
  
  public static void jhd() {}
  
  public static void w(Throwable paramThrowable)
  {
    AppMethodBeat.i(138480);
    hd(paramThrowable);
    AppMethodBeat.o(138480);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.e.f.h
 * JD-Core Version:    0.7.0.1
 */