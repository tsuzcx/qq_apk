package com.tencent.mm.plugin.downloader.d;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public final class f
{
  public static ByteBuffer L(q paramq)
  {
    AppMethodBeat.i(177463);
    if ((paramq == null) || (!paramq.ifE()) || (!paramq.ifH()))
    {
      AppMethodBeat.o(177463);
      return null;
    }
    try
    {
      paramq = u.dO(paramq.getPath(), false);
      try
      {
        Object localObject1 = a.g(paramq);
        localByteBuffer2 = (ByteBuffer)((Pair)localObject1).first;
        l = ((Long)((Pair)localObject1).second).longValue();
        if (!h.c(paramq, l)) {
          break label105;
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
        paramq = null;
      }
    }
    if (paramq != null) {
      paramq.close();
    }
    AppMethodBeat.o(177463);
    throw localObject2;
    label105:
    localByteBuffer1 = (ByteBuffer)a.b(paramq, a.b(localByteBuffer2, l)).first;
    if (paramq != null) {
      paramq.close();
    }
    AppMethodBeat.o(177463);
    return localByteBuffer1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.f
 * JD-Core Version:    0.7.0.1
 */