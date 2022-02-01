package com.bumptech.glide.c.c;

import android.util.Log;
import com.bumptech.glide.c.d;
import com.bumptech.glide.h.a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.c.c
 * JD-Core Version:    0.7.0.1
 */