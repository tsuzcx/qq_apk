package com.bumptech.glide.load.d.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class l
{
  private static final File aLo;
  private static volatile l aLr;
  private volatile int aLp;
  private volatile boolean aLq = true;
  
  static
  {
    AppMethodBeat.i(77410);
    aLo = new File("/proc/self/fd");
    AppMethodBeat.o(77410);
  }
  
  static l pE()
  {
    AppMethodBeat.i(77408);
    if (aLr == null) {}
    try
    {
      if (aLr == null) {
        aLr = new l();
      }
      l locall = aLr;
      AppMethodBeat.o(77408);
      return locall;
    }
    finally
    {
      AppMethodBeat.o(77408);
    }
  }
  
  final boolean pF()
  {
    boolean bool = false;
    try
    {
      AppMethodBeat.i(77409);
      int i = this.aLp + 1;
      this.aLp = i;
      if (i >= 50)
      {
        this.aLp = 0;
        i = aLo.list().length;
        if (i < 700) {
          bool = true;
        }
        this.aLq = bool;
        if ((!this.aLq) && (Log.isLoggable("Downsampler", 5))) {
          new StringBuilder("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ").append(i).append(", limit 700");
        }
      }
      bool = this.aLq;
      AppMethodBeat.o(77409);
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.a.l
 * JD-Core Version:    0.7.0.1
 */