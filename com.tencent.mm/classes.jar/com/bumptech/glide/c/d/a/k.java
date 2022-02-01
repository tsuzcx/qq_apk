package com.bumptech.glide.c.d.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class k
{
  private static final File aJF;
  private static volatile k aJI;
  private volatile int aJG;
  private volatile boolean aJH = true;
  
  static
  {
    AppMethodBeat.i(77410);
    aJF = new File("/proc/self/fd");
    AppMethodBeat.o(77410);
  }
  
  static k ph()
  {
    AppMethodBeat.i(77408);
    if (aJI == null) {}
    try
    {
      if (aJI == null) {
        aJI = new k();
      }
      k localk = aJI;
      AppMethodBeat.o(77408);
      return localk;
    }
    finally
    {
      AppMethodBeat.o(77408);
    }
  }
  
  final boolean pi()
  {
    boolean bool = false;
    try
    {
      AppMethodBeat.i(77409);
      int i = this.aJG + 1;
      this.aJG = i;
      if (i >= 50)
      {
        this.aJG = 0;
        i = aJF.list().length;
        if (i < 700) {
          bool = true;
        }
        this.aJH = bool;
        if ((!this.aJH) && (Log.isLoggable("Downsampler", 5))) {
          new StringBuilder("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ").append(i).append(", limit 700");
        }
      }
      bool = this.aJH;
      AppMethodBeat.o(77409);
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.k
 * JD-Core Version:    0.7.0.1
 */