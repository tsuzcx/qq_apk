package com.tencent.f.c;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends a
{
  public static Thread b(String paramString, Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(183244);
    paramString = new a.2(new a.1(paramRunnable), "[GT]".concat(String.valueOf(paramString)));
    paramString.setPriority(android.support.v4.b.a.clamp(paramInt, 1, 10));
    AppMethodBeat.o(183244);
    return paramString;
  }
  
  public static HandlerThread bqq(String paramString)
  {
    AppMethodBeat.i(183241);
    paramString = hy(paramString, 5);
    AppMethodBeat.o(183241);
    return paramString;
  }
  
  public static HandlerThread bqr(String paramString)
  {
    AppMethodBeat.i(183242);
    paramString = hy(paramString, 5);
    AppMethodBeat.o(183242);
    return paramString;
  }
  
  public static HandlerThread hA(String paramString, int paramInt)
  {
    AppMethodBeat.i(183238);
    paramString = hy(paramString, paramInt);
    AppMethodBeat.o(183238);
    return paramString;
  }
  
  public static HandlerThread hB(String paramString, int paramInt)
  {
    AppMethodBeat.i(183239);
    paramString = hy(paramString, paramInt);
    AppMethodBeat.o(183239);
    return paramString;
  }
  
  public static HandlerThread hC(String paramString, int paramInt)
  {
    AppMethodBeat.i(183240);
    paramString = hy(paramString, paramInt);
    AppMethodBeat.o(183240);
    return paramString;
  }
  
  public static HandlerThread hD(String paramString, int paramInt)
  {
    AppMethodBeat.i(256671);
    paramString = hy(paramString, paramInt);
    AppMethodBeat.o(256671);
    return paramString;
  }
  
  public static HandlerThread hz(String paramString, int paramInt)
  {
    AppMethodBeat.i(183237);
    paramString = hy(paramString, paramInt);
    AppMethodBeat.o(183237);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.c.d
 * JD-Core Version:    0.7.0.1
 */