package com.tencent.mm.plugin.downloader.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.q;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Map;
import org.xwalk.core.Log;

public final class d
{
  public static Map<Integer, ByteBuffer> G(e parame)
  {
    AppMethodBeat.i(177460);
    if ((parame == null) || (!parame.exists()) || (!parame.isFile()))
    {
      AppMethodBeat.o(177460);
      return null;
    }
    LinkedHashMap localLinkedHashMap;
    try
    {
      localObject = f.I(parame);
      a.C((ByteBuffer)localObject);
      localObject = a.c((ByteBuffer)localObject, ((ByteBuffer)localObject).capacity() - 24);
      localLinkedHashMap = new LinkedHashMap();
      i = 0;
    }
    catch (IOException parame)
    {
      AppMethodBeat.o(177460);
      return null;
      l = ((ByteBuffer)localObject).getLong();
      if ((l >= 4L) && (l <= 2147483647L)) {
        break label228;
      }
      Object localObject = new a.b("APK Signing Block entry #" + i + " size out of range: " + l);
      AppMethodBeat.o(177460);
      throw ((Throwable)localObject);
    }
    catch (a.b localb1)
    {
      int i;
      for (;;)
      {
        long l;
        Log.e("MicroMsg.Channel.IdValueReader", "APK : " + q.B(parame.fxV()) + " not have apk signature block");
        continue;
        int j = (int)l;
        int k = localb1.position();
        if (j > localb1.remaining())
        {
          localb2 = new a.b("APK Signing Block entry #" + i + " size out of range: " + j + ", available: " + localb1.remaining());
          AppMethodBeat.o(177460);
          throw localb2;
        }
        int m = localb2.getInt();
        localLinkedHashMap.put(Integer.valueOf(m), a.d(localb2, j - 4));
        if (m == 1896449818) {
          ac.i("MicroMsg.Channel.V2SchemeUtil", "find V2 signature block Id : 1896449818");
        }
        localb2.position(k + j);
      }
      if (!localLinkedHashMap.isEmpty()) {
        break label392;
      }
      a.b localb2 = new a.b("not have Id-Value Pair in APK Signing Block entry #".concat(String.valueOf(i)));
      AppMethodBeat.o(177460);
      throw localb2;
      AppMethodBeat.o(177460);
    }
    if (((ByteBuffer)localObject).hasRemaining())
    {
      i += 1;
      if (((ByteBuffer)localObject).remaining() < 8)
      {
        localObject = new a.b("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i)));
        AppMethodBeat.o(177460);
        throw ((Throwable)localObject);
      }
    }
    label228:
    return localLinkedHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.d.d
 * JD-Core Version:    0.7.0.1
 */