package com.bumptech.glide.c.d.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class k
{
  private static final File aLw;
  private static volatile k aLz;
  private volatile int aLx;
  private volatile boolean aLy = true;
  
  static
  {
    AppMethodBeat.i(77410);
    aLw = new File("/proc/self/fd");
    AppMethodBeat.o(77410);
  }
  
  static k pz()
  {
    AppMethodBeat.i(77408);
    if (aLz == null) {}
    try
    {
      if (aLz == null) {
        aLz = new k();
      }
      k localk = aLz;
      AppMethodBeat.o(77408);
      return localk;
    }
    finally
    {
      AppMethodBeat.o(77408);
    }
  }
  
  final boolean pA()
  {
    boolean bool = false;
    try
    {
      AppMethodBeat.i(77409);
      int i = this.aLx + 1;
      this.aLx = i;
      if (i >= 50)
      {
        this.aLx = 0;
        i = aLw.list().length;
        if (i < 700) {
          bool = true;
        }
        this.aLy = bool;
        if ((!this.aLy) && (Log.isLoggable("Downsampler", 5))) {
          new StringBuilder("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ").append(i).append(", limit 700");
        }
      }
      bool = this.aLy;
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