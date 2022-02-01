package com.tencent.e.c;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
  extends a
{
  public static Thread b(String paramString, Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(183244);
    paramString = new a.2(new a.1(paramRunnable), "[GT]".concat(String.valueOf(paramString)));
    paramString.setPriority(a.Xb(paramInt));
    AppMethodBeat.o(183244);
    return paramString;
  }
  
  public static HandlerThread bDj(String paramString)
  {
    AppMethodBeat.i(183241);
    paramString = ii(paramString, 5);
    AppMethodBeat.o(183241);
    return paramString;
  }
  
  public static HandlerThread bDk(String paramString)
  {
    AppMethodBeat.i(183242);
    paramString = ii(paramString, 5);
    AppMethodBeat.o(183242);
    return paramString;
  }
  
  public static HandlerThread bDl(String paramString)
  {
    AppMethodBeat.i(183243);
    paramString = ii(paramString, 5);
    AppMethodBeat.o(183243);
    return paramString;
  }
  
  public static HandlerThread ij(String paramString, int paramInt)
  {
    AppMethodBeat.i(183237);
    paramString = ii(paramString, paramInt);
    AppMethodBeat.o(183237);
    return paramString;
  }
  
  public static HandlerThread ik(String paramString, int paramInt)
  {
    AppMethodBeat.i(183238);
    paramString = ii(paramString, paramInt);
    AppMethodBeat.o(183238);
    return paramString;
  }
  
  public static HandlerThread il(String paramString, int paramInt)
  {
    AppMethodBeat.i(183239);
    paramString = ii(paramString, paramInt);
    AppMethodBeat.o(183239);
    return paramString;
  }
  
  public static HandlerThread im(String paramString, int paramInt)
  {
    AppMethodBeat.i(183240);
    paramString = ii(paramString, paramInt);
    AppMethodBeat.o(183240);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.c.d
 * JD-Core Version:    0.7.0.1
 */