package com.tencent.mm.plugin.downloader.c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public final class f
{
  public static ByteBuffer N(u paramu)
  {
    AppMethodBeat.i(177463);
    if ((paramu == null) || (!paramu.jKS()) || (!paramu.jKV()))
    {
      AppMethodBeat.o(177463);
      return null;
    }
    try
    {
      paramu = y.eA(ah.v(paramu.mUri), false);
      try
      {
        Object localObject1 = a.g(paramu);
        localByteBuffer2 = (ByteBuffer)((Pair)localObject1).first;
        l = ((Long)((Pair)localObject1).second).longValue();
        if (!h.c(paramu, l)) {
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
        paramu = null;
      }
    }
    if (paramu != null) {
      paramu.close();
    }
    AppMethodBeat.o(177463);
    throw localObject2;
    label108:
    localByteBuffer1 = (ByteBuffer)a.b(paramu, a.c(localByteBuffer2, l)).first;
    if (paramu != null) {
      paramu.close();
    }
    AppMethodBeat.o(177463);
    return localByteBuffer1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.c.f
 * JD-Core Version:    0.7.0.1
 */