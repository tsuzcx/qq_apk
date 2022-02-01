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
  private final j aGw;
  private final c aGx;
  private com.bumptech.glide.a.a aGy;
  private final File directory;
  private final long maxSize;
  
  @Deprecated
  e(File paramFile, long paramLong)
  {
    AppMethodBeat.i(77150);
    this.aGx = new c();
    this.directory = paramFile;
    this.maxSize = paramLong;
    this.aGw = new j();
    AppMethodBeat.o(77150);
  }
  
  private com.bumptech.glide.a.a oB()
  {
    try
    {
      AppMethodBeat.i(77151);
      if (this.aGy == null) {
        this.aGy = com.bumptech.glide.a.a.b(this.directory, this.maxSize);
      }
      com.bumptech.glide.a.a locala = this.aGy;
      AppMethodBeat.o(77151);
      return locala;
    }
    finally {}
  }
  
  public final File a(h paramh)
  {
    AppMethodBeat.i(77152);
    Object localObject2 = this.aGw.c(paramh);
    if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
      new StringBuilder("Get: Obtained: ").append((String)localObject2).append(" for for Key: ").append(paramh);
    }
    localObject1 = null;
    try
    {
      localObject2 = oB().M((String)localObject2);
      paramh = localObject1;
      if (localObject2 != null) {
        paramh = localObject2.aBk[0];
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
    str = this.aGw.c(paramh);
    Object localObject;
    synchronized (this.aGx)
    {
      c.a locala = (c.a)???.aGp.get(str);
      localObject = locala;
      if (locala == null)
      {
        localObject = ???.aGq.oz();
        ???.aGp.put(str, localObject);
      }
      ((c.a)localObject).aGs += 1;
      ((c.a)localObject).aGr.lock();
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
          if (paramb.s(paramh.nt()))
          {
            com.bumptech.glide.a.a.a(paramh.aBa, paramh, true);
            paramh.aBd = true;
          }
          paramh.nu();
          continue;
        }
        finally
        {
          paramh.nu();
          AppMethodBeat.o(77153);
        }
        paramh = finally;
        this.aGx.release(str);
        AppMethodBeat.o(77153);
      }
      try
      {
        paramh = oB();
        localObject = paramh.M(str);
        if (localObject != null)
        {
          this.aGx.release(str);
          AppMethodBeat.o(77153);
          return;
          paramh = finally;
          AppMethodBeat.o(77153);
          throw paramh;
        }
        paramh = paramh.N(str);
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
        this.aGx.release(str);
        AppMethodBeat.o(77153);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.bumptech.glide.c.b.b.e
 * JD-Core Version:    0.7.0.1
 */