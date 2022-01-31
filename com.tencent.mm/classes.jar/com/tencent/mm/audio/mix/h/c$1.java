package com.tencent.mm.audio.mix.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class c$1
  extends ThreadLocal<MessageDigest>
{
  private static MessageDigest zK()
  {
    AppMethodBeat.i(137219);
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      AppMethodBeat.o(137219);
      return localMessageDigest;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      RuntimeException localRuntimeException = new RuntimeException("Initialize MD5 failed.", localNoSuchAlgorithmException);
      AppMethodBeat.o(137219);
      throw localRuntimeException;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.audio.mix.h.c.1
 * JD-Core Version:    0.7.0.1
 */