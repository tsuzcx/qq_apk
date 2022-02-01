package com.tencent.e.c;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  extends a
{
  public static Thread a(String paramString, Runnable paramRunnable, int paramInt)
  {
    AppMethodBeat.i(183235);
    paramString = new a.4(new a.3(paramRunnable), "[GT]".concat(String.valueOf(paramString)));
    paramString.setPriority(paramInt);
    AppMethodBeat.o(183235);
    return paramString;
  }
  
  public static HandlerThread createHandlerThread(String paramString)
  {
    AppMethodBeat.i(183236);
    paramString = a.ii(paramString, 5);
    AppMethodBeat.o(183236);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.e.c.c
 * JD-Core Version:    0.7.0.1
 */