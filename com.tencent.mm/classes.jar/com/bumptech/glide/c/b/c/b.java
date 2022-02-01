package com.bumptech.glide.c.b.c;

import android.os.Build.VERSION;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class b
{
  static int availableProcessors()
  {
    AppMethodBeat.i(77196);
    int j = Runtime.getRuntime().availableProcessors();
    int i = j;
    if (Build.VERSION.SDK_INT < 17) {
      i = Math.max(pm(), j);
    }
    AppMethodBeat.o(77196);
    return i;
  }
  
  private static int pm()
  {
    AppMethodBeat.i(77197);
    Object localObject1 = null;
    StrictMode.ThreadPolicy localThreadPolicy = StrictMode.allowThreadDiskReads();
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new FilenameFilter()
      {
        public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          AppMethodBeat.i(77195);
          boolean bool = b.this.matcher(paramAnonymousString).matches();
          AppMethodBeat.o(77195);
          return bool;
        }
      });
      localObject1 = arrayOfFile;
      StrictMode.setThreadPolicy(localThreadPolicy);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Log.isLoggable("GlideRuntimeCompat", 6);
        StrictMode.setThreadPolicy(localThreadPolicy);
      }
    }
    finally
    {
      StrictMode.setThreadPolicy(localThreadPolicy);
      AppMethodBeat.o(77197);
    }
    if (localObject1 != null) {}
    for (int i = localObject1.length;; i = 0)
    {
      i = Math.max(1, i);
      AppMethodBeat.o(77197);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.c.b
 * JD-Core Version:    0.7.0.1
 */