package com.tencent.d.e.b.a.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class a
{
  public static byte[] cF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(138448);
    Object localObject = null;
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance(new String(b.Vp("4D4435")));
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      AppMethodBeat.o(138448);
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.d.e.b.a.a.b.a
 * JD-Core Version:    0.7.0.1
 */