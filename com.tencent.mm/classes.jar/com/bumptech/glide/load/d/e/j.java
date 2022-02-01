package com.bumptech.glide.load.d.e;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.b.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public final class j
  implements com.bumptech.glide.load.j<InputStream, c>
{
  private final b aFo;
  private final List<ImageHeaderParser> aFx;
  private final com.bumptech.glide.load.j<ByteBuffer, c> aMe;
  
  public j(List<ImageHeaderParser> paramList, com.bumptech.glide.load.j<ByteBuffer, c> paramj, b paramb)
  {
    this.aFx = paramList;
    this.aMe = paramj;
    this.aFo = paramb;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.d.e.j
 * JD-Core Version:    0.7.0.1
 */