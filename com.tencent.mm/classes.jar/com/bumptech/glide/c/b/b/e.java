package com.bumptech.glide.c.b.b;

import android.util.Log;
import com.bumptech.glide.c.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public final class e
  implements a
{
  private final j aJd;
  private final c aJe;
  private com.bumptech.glide.a.a aJf;
  private final File directory;
  private final long maxSize;
  
  @Deprecated
  e(File paramFile, long paramLong)
  {
    AppMethodBeat.i(77150);
    this.aJe = new c();
    this.directory = paramFile;
    this.maxSize = paramLong;
    this.aJd = new j();
    AppMethodBeat.o(77150);
  }
  
  private com.bumptech.glide.a.a pd()
  {
    try
    {
      AppMethodBeat.i(77151);
      if (this.aJf == null) {
        this.aJf = com.bumptech.glide.a.a.b(this.directory, this.maxSize);
      }
      com.bumptech.glide.a.a locala = this.aJf;
      AppMethodBeat.o(77151);
      return locala;
    }
    finally {}
  }
  
  public final File a(h paramh)
  {
    AppMethodBeat.i(77152);
    Object localObject2 = this.aJd.c(paramh);
    if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
      new StringBuilder("Get: Obtained: ").append((String)localObject2).append(" for for Key: ").append(paramh);
    }
    localObject1 = null;
    try
    {
      localObject2 = pd().N((String)localObject2);
      paramh = localObject1;
      if (localObject2 != null) {
        paramh = localObject2.aDU[0];
      }
    }
    catch (IOException paramh)
    {
      for (;;)
      {
        Log.isLoggable("DiskLruCacheWrapper", 5);
        paramh = localObject1;
      }
    }
    AppMethodBeat.o(77152);
    return paramh;
  }
  
  public final void a(h paramh, a.b paramb)
  {
    AppMethodBeat.i(77153);
    str = this.aJd.c(paramh);
    Object localObject;
    synchronized (this.aJe)
    {
      c.a locala = (c.a)???.aIW.get(str);
      localObject = locala;
      if (locala == null)
      {
        localObject = ???.aIX.pb();
        ???.aIW.put(str, localObject);
      }
      ((c.a)localObject).aIZ += 1;
      ((c.a)localObject).aIY.lock();
    }
    for (;;)
    {
      try
      {
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
          new StringBuilder("Put: Obtained: ").append(str).append(" for for Key: ").append(paramh);
        }
      }
      finally
      {
        try
        {
          if (paramb.s(paramh.nV()))
          {
            com.bumptech.glide.a.a.a(paramh.aDL, paramh, true);
            paramh.aDO = true;
          }
          paramh.nW();
          continue;
        }
        finally
        {
          paramh.nW();
          AppMethodBeat.o(77153);
        }
        paramh = finally;
        this.aJe.release(str);
        AppMethodBeat.o(77153);
      }
      try
      {
        paramh = pd();
        localObject = paramh.N(str);
        if (localObject != null)
        {
          this.aJe.release(str);
          AppMethodBeat.o(77153);
          return;
          paramh = finally;
          AppMethodBeat.o(77153);
          throw paramh;
        }
        paramh = paramh.O(str);
        if (paramh == null)
        {
          paramh = new IllegalStateException("Had two simultaneous puts for: ".concat(String.valueOf(str)));
          AppMethodBeat.o(77153);
          throw paramh;
        }
      }
      catch (IOException paramh)
      {
        Log.isLoggable("DiskLruCacheWrapper", 5);
        this.aJe.release(str);
        AppMethodBeat.o(77153);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.b.e
 * JD-Core Version:    0.7.0.1
 */