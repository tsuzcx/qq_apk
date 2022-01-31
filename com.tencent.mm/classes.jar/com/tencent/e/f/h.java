package com.tencent.e.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  private static boolean BlH;
  private static g BlI;
  
  static
  {
    AppMethodBeat.i(114620);
    BlH = false;
    BlI = new k();
    BlH = false;
    BlI = new k();
    AppMethodBeat.o(114620);
  }
  
  public static void cU(Object paramObject)
  {
    AppMethodBeat.i(114618);
    if ((paramObject != null) && ((paramObject instanceof Exception)))
    {
      new StringBuilder().append(paramObject);
      AppMethodBeat.o(114618);
      return;
    }
    AppMethodBeat.o(114618);
  }
  
  public static void cV(Object paramObject)
  {
    AppMethodBeat.i(114619);
    if ((paramObject != null) && ((paramObject instanceof Exception)))
    {
      new StringBuilder().append(paramObject);
      AppMethodBeat.o(114619);
      return;
    }
    AppMethodBeat.o(114619);
  }
  
  public static void dUT() {}
  
  public static void dUU() {}
  
  public static void dUV() {}
  
  public static void w(Throwable paramThrowable)
  {
    AppMethodBeat.i(114617);
    cU(paramThrowable);
    AppMethodBeat.o(114617);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.f.h
 * JD-Core Version:    0.7.0.1
 */