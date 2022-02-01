package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public final class f
{
  public static ByteBuffer I(k paramk)
  {
    AppMethodBeat.i(177463);
    if ((paramk == null) || (!paramk.exists()) || (!paramk.isFile()))
    {
      AppMethodBeat.o(177463);
      return null;
    }
    try
    {
      paramk = o.dg(w.B(paramk.mUri), false);
      try
      {
        Object localObject1 = a.g(paramk);
        localByteBuffer2 = (ByteBuffer)((Pair)localObject1).first;
        l = ((Long)((Pair)localObject1).second).longValue();
        if (!h.c(paramk, l)) {
          break label108;
        }
        localObject1 = new a.b("ZIP64 APK not supported");
        AppMethodBeat.o(177463);
        throw ((Throwable)localObject1);
      }
      finally {}
    }
    finally
    {
      for (;;)
      {
        ByteBuffer localByteBuffer2;
        long l;
        ByteBuffer localByteBuffer1;
        paramk = null;
      }
    }
    if (paramk != null) {
      paramk.close();
    }
    AppMethodBeat.o(177463);
    throw localObject2;
    label108:
    localByteBuffer1 = (ByteBuffer)a.b(paramk, a.b(localByteBuffer2, l)).first;
    if (paramk != null) {
      paramk.close();
    }
    AppMethodBeat.o(177463);
    return localByteBuffer1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.f
 * JD-Core Version:    0.7.0.1
 */