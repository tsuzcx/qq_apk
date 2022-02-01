package com.tencent.mm.audio.mix.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c
{
  protected static ThreadLocal<MessageDigest> TLS_digest;
  protected static char[] hexDigits;
  
  static
  {
    AppMethodBeat.i(136971);
    hexDigits = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
    TLS_digest = new ThreadLocal()
    {
      private static MessageDigest initialValue()
      {
        AppMethodBeat.i(136968);
        try
        {
          MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
          AppMethodBeat.o(136968);
          return localMessageDigest;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          RuntimeException localRuntimeException = new RuntimeException("Initialize MD5 failed.", localNoSuchAlgorithmException);
          AppMethodBeat.o(136968);
          throw localRuntimeException;
        }
      }
    };
    AppMethodBeat.o(136971);
  }
  
  @Deprecated
  public static String getMD5String(String paramString)
  {
    AppMethodBeat.i(136970);
    paramString = paramString.getBytes();
    paramString = ((MessageDigest)TLS_digest.get()).digest(paramString);
    int j = paramString.length;
    StringBuffer localStringBuffer = new StringBuffer(j * 2);
    int i = 0;
    while (i < j + 0)
    {
      int k = paramString[i];
      char c1 = hexDigits[((k & 0xF0) >> 4)];
      char c2 = hexDigits[(k & 0xF)];
      localStringBuffer.append(c1);
      localStringBuffer.append(c2);
      i += 1;
    }
    paramString = localStringBuffer.toString();
    AppMethodBeat.o(136970);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.i.c
 * JD-Core Version:    0.7.0.1
 */