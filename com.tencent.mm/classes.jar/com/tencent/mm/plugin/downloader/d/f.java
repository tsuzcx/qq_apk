package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public final class f
{
  public static ByteBuffer J(e parame)
  {
    AppMethodBeat.i(177463);
    if ((parame == null) || (!parame.exists()) || (!parame.isFile()))
    {
      AppMethodBeat.o(177463);
      return null;
    }
    try
    {
      parame = i.cS(q.B(parame.mUri), false);
      try
      {
        Object localObject1 = a.g(parame);
        localByteBuffer2 = (ByteBuffer)((Pair)localObject1).first;
        l = ((Long)((Pair)localObject1).second).longValue();
        if (!h.c(parame, l)) {
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
        parame = null;
      }
    }
    if (parame != null) {
      parame.close();
    }
    AppMethodBeat.o(177463);
    throw localObject2;
    label108:
    localByteBuffer1 = (ByteBuffer)a.b(parame, a.b(localByteBuffer2, l)).first;
    if (parame != null) {
      parame.close();
    }
    AppMethodBeat.o(177463);
    return localByteBuffer1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.f
 * JD-Core Version:    0.7.0.1
 */