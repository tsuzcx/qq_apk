package com.google.android.gms.common.util;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ThreadUtils
{
  public static boolean isMainThread()
  {
    AppMethodBeat.i(5296);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      AppMethodBeat.o(5296);
      return true;
    }
    AppMethodBeat.o(5296);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.util.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */