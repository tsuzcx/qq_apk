package com.bumptech.glide.c.d.a;

import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

final class k
{
  private static final File aIP;
  private static volatile k aIS;
  private volatile int aIQ;
  private volatile boolean aIR = true;
  
  static
  {
    AppMethodBeat.i(77410);
    aIP = new File("/proc/self/fd");
    AppMethodBeat.o(77410);
  }
  
  static k oX()
  {
    AppMethodBeat.i(77408);
    if (aIS == null) {}
    try
    {
      if (aIS == null) {
        aIS = new k();
      }
      k localk = aIS;
      AppMethodBeat.o(77408);
      return localk;
    }
    finally
    {
      AppMethodBeat.o(77408);
    }
  }
  
  final boolean oY()
  {
    boolean bool = false;
    try
    {
      AppMethodBeat.i(77409);
      int i = this.aIQ + 1;
      this.aIQ = i;
      if (i >= 50)
      {
        this.aIQ = 0;
        i = aIP.list().length;
        if (i < 700) {
          bool = true;
        }
        this.aIR = bool;
        if ((!this.aIR) && (Log.isLoggable("Downsampler", 5))) {
          new StringBuilder("Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors ").append(i).append(", limit 700");
        }
      }
      bool = this.aIR;
      AppMethodBeat.o(77409);
      return bool;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.k
 * JD-Core Version:    0.7.0.1
 */