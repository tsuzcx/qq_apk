package com.bumptech.glide.load.c;

import android.util.Log;
import com.bumptech.glide.g.a;
import com.bumptech.glide.load.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class c
  implements d<ByteBuffer>
{
  private static boolean a(ByteBuffer paramByteBuffer, File paramFile)
  {
    AppMethodBeat.i(77212);
    boolean bool = false;
    try
    {
      a.b(paramByteBuffer, paramFile);
      bool = true;
    }
    catch (IOException paramByteBuffer)
    {
      for (;;)
      {
        Log.isLoggable("ByteBufferEncoder", 3);
      }
    }
    AppMethodBeat.o(77212);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.c
 * JD-Core Version:    0.7.0.1
 */