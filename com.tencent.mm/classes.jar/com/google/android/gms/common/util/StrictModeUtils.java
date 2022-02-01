package com.google.android.gms.common.util;

import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StrictModeUtils
{
  public static StrictMode.ThreadPolicy setDynamiteThreadPolicy()
  {
    AppMethodBeat.i(5289);
    StrictMode.noteSlowCall("gcore.dynamite");
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.getThreadPolicy();
    StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
    AppMethodBeat.o(5289);
    return localThreadPolicy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.util.StrictModeUtils
 * JD-Core Version:    0.7.0.1
 */