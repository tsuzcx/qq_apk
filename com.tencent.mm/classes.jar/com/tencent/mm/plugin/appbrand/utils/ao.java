package com.tencent.mm.plugin.appbrand.utils;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ao
{
  public static boolean aoz()
  {
    AppMethodBeat.i(185648);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      AppMethodBeat.o(185648);
      return true;
    }
    if (Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId())
    {
      AppMethodBeat.o(185648);
      return true;
    }
    AppMethodBeat.o(185648);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.ao
 * JD-Core Version:    0.7.0.1
 */