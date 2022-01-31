package com.google.android.gms.common.util;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StrictModeUtils
{
  public static StrictMode.ThreadPolicy setDynamiteThreadPolicy()
  {
    AppMethodBeat.i(90268);
    StrictMode.noteSlowCall("gcore.dynamite");
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
    AppMethodBeat.o(90268);
    return localThreadPolicy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.util.StrictModeUtils
 * JD-Core Version:    0.7.0.1
 */