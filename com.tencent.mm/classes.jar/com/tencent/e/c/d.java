package com.tencent.e.c;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends a
{
  public static HandlerThread aNZ(String paramString)
  {
    AppMethodBeat.i(183241);
    paramString = gt(paramString, 5);
    AppMethodBeat.o(183241);
    return paramString;
  }
  
  public static HandlerThread aOa(String paramString)
  {
    AppMethodBeat.i(183242);
    paramString = gt(paramString, 5);
    AppMethodBeat.o(183242);
    return paramString;
  }
  
  public static Thread b(String paramString, Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(183244);
    paramString = new a.2(new a.1(paramRunnable), "[GT]".concat(String.valueOf(paramString)));
    paramString.setPriority(android.support.v4.b.a.clamp(paramInt, 1, 10));
    AppMethodBeat.o(183244);
    return paramString;
  }
  
  public static HandlerThread gu(String paramString, int paramInt)
  {
    AppMethodBeat.i(183237);
    paramString = gt(paramString, paramInt);
    AppMethodBeat.o(183237);
    return paramString;
  }
  
  public static HandlerThread gv(String paramString, int paramInt)
  {
    AppMethodBeat.i(183238);
    paramString = gt(paramString, paramInt);
    AppMethodBeat.o(183238);
    return paramString;
  }
  
  public static HandlerThread gw(String paramString, int paramInt)
  {
    AppMethodBeat.i(183239);
    paramString = gt(paramString, paramInt);
    AppMethodBeat.o(183239);
    return paramString;
  }
  
  public static HandlerThread gx(String paramString, int paramInt)
  {
    AppMethodBeat.i(183240);
    paramString = gt(paramString, paramInt);
    AppMethodBeat.o(183240);
    return paramString;
  }
  
  public static HandlerThread gy(String paramString, int paramInt)
  {
    AppMethodBeat.i(186955);
    paramString = gt(paramString, paramInt);
    AppMethodBeat.o(186955);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.c.d
 * JD-Core Version:    0.7.0.1
 */