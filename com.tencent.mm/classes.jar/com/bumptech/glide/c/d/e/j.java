package com.bumptech.glide.c.d.e;

import android.util.Log;
import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.c.f;
import com.bumptech.glide.c.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class j
  implements k<InputStream, c>
{
  private final b aDH;
  private final List<f> aDQ;
  private final k<ByteBuffer, c> aKv;
  
  public j(List<f> paramList, k<ByteBuffer, c> paramk, b paramb)
  {
    this.aDQ = paramList;
    this.aKv = paramk;
    this.aDH = paramb;
  }
  
  private static byte[] d(InputStream paramInputStream)
  {
    AppMethodBeat.i(77526);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(16384);
    try
    {
      byte[] arrayOfByte = new byte[16384];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      localByteArrayOutputStream.flush();
    }
    catch (IOException paramInputStream)
    {
      Log.isLoggable("StreamGifDecoder", 5);
      AppMethodBeat.o(77526);
      return null;
    }
    paramInputStream = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(77526);
    return paramInputStream;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.e.j
 * JD-Core Version:    0.7.0.1
 */