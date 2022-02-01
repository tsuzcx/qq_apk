package com.bumptech.glide.load.b.b;

import android.util.Log;
import com.bumptech.glide.load.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public final class e
  implements a
{
  private final j aIW;
  private final c aIX;
  private com.bumptech.glide.a.a aIY;
  private final File directory;
  private final long maxSize;
  
  @Deprecated
  e(File paramFile, long paramLong)
  {
    AppMethodBeat.i(77150);
    this.aIX = new c();
    this.directory = paramFile;
    this.maxSize = paramLong;
    this.aIW = new j();
    AppMethodBeat.o(77150);
  }
  
  private com.bumptech.glide.a.a pi()
  {
    try
    {
      AppMethodBeat.i(77151);
      if (this.aIY == null) {
        this.aIY = com.bumptech.glide.a.a.b(this.directory, this.maxSize);
      }
      com.bumptech.glide.a.a locala = this.aIY;
      AppMethodBeat.o(77151);
      return locala;
    }
    finally {}
  }
  
  public final void a(g paramg, a.b paramb)
  {
    AppMethodBeat.i(77153);
    str = this.aIW.e(paramg);
    Object localObject;
    synchronized (this.aIX)
    {
      c.a locala = (c.a)???.aIP.get(str);
      localObject = locala;
      if (locala == null)
      {
        localObject = ???.aIQ.pg();
        ???.aIP.put(str, localObject);
      }
      ((c.a)localObject).aIS += 1;
      ((c.a)localObject).aIR.lock();
    }
    for (;;)
    {
      try
      {
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
          new StringBuilder("Put: Obtained: ").append(str).append(" for for Key: ").append(paramg);
        }
      }
      finally
      {
        try
        {
          if (paramb.s(paramg.ob()))
          {
            com.bumptech.glide.a.a.a(paramg.aDL, paramg, true);
            paramg.aDO = true;
          }
          paramg.oc();
          continue;
        }
        finally
        {
          paramg.oc();
          AppMethodBeat.o(77153);
        }
        paramg = finally;
        this.aIX.release(str);
        AppMethodBeat.o(77153);
      }
      try
      {
        paramg = pi();
        localObject = paramg.O(str);
        if (localObject != null)
        {
          this.aIX.release(str);
          AppMethodBeat.o(77153);
          return;
          paramg = finally;
          AppMethodBeat.o(77153);
          throw paramg;
        }
        paramg = paramg.P(str);
        if (paramg == null)
        {
          paramg = new IllegalStateException("Had two simultaneous puts for: ".concat(String.valueOf(str)));
          AppMethodBeat.o(77153);
          throw paramg;
        }
      }
      catch (IOException paramg)
      {
        Log.isLoggable("DiskLruCacheWrapper", 5);
        this.aIX.release(str);
        AppMethodBeat.o(77153);
        return;
      }
    }
  }
  
  public final File c(g paramg)
  {
    AppMethodBeat.i(77152);
    Object localObject2 = this.aIW.e(paramg);
    if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
      new StringBuilder("Get: Obtained: ").append((String)localObject2).append(" for for Key: ").append(paramg);
    }
    localObject1 = null;
    try
    {
      localObject2 = pi().O((String)localObject2);
      paramg = localObject1;
      if (localObject2 != null) {
        paramg = localObject2.aDU[0];
      }
    }
    catch (IOException paramg)
    {
      for (;;)
      {
        Log.isLoggable("DiskLruCacheWrapper", 5);
        paramg = localObject1;
      }
    }
    AppMethodBeat.o(77152);
    return paramg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.b.e
 * JD-Core Version:    0.7.0.1
 */