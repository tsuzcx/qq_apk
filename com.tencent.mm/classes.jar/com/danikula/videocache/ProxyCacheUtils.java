package com.danikula.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class ProxyCacheUtils
{
  static final int DEFAULT_BUFFER_SIZE = 8192;
  static final int MAX_ARRAY_PREVIEW = 16;
  
  static void assertBuffer(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    boolean bool2 = true;
    AppMethodBeat.i(223196);
    Preconditions.checkNotNull(paramArrayOfByte, "Buffer must be not null!");
    if (paramLong >= 0L)
    {
      bool1 = true;
      Preconditions.checkArgument(bool1, "Data offset must be positive!");
      if ((paramInt < 0) || (paramInt > paramArrayOfByte.length)) {
        break label64;
      }
    }
    label64:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Preconditions.checkArgument(bool1, "Length must be in range [0..buffer.length]");
      AppMethodBeat.o(223196);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static String bytesToHexString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(223198);
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append(String.format("%02x", new Object[] { Byte.valueOf(paramArrayOfByte[i]) }));
      i += 1;
    }
    paramArrayOfByte = localStringBuffer.toString();
    AppMethodBeat.o(223198);
    return paramArrayOfByte;
  }
  
  static void close(Closeable paramCloseable)
  {
    AppMethodBeat.i(183615);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(183615);
        return;
      }
      catch (IOException paramCloseable)
      {
        Logger.error("Error closing resource");
      }
    }
    AppMethodBeat.o(183615);
  }
  
  public static String computeMD5(String paramString)
  {
    AppMethodBeat.i(183616);
    try
    {
      paramString = bytesToHexString(MessageDigest.getInstance("MD5").digest(paramString.getBytes()));
      AppMethodBeat.o(183616);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString = new IllegalStateException(paramString);
      AppMethodBeat.o(183616);
      throw paramString;
    }
  }
  
  static String decode(String paramString)
  {
    AppMethodBeat.i(183614);
    try
    {
      paramString = URLDecoder.decode(paramString, "utf-8");
      AppMethodBeat.o(183614);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new RuntimeException("Error decoding url", paramString);
      AppMethodBeat.o(183614);
      throw paramString;
    }
  }
  
  static String encode(String paramString)
  {
    AppMethodBeat.i(183613);
    try
    {
      paramString = URLEncoder.encode(paramString, "utf-8");
      AppMethodBeat.o(183613);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString = new RuntimeException("Error encoding url", paramString);
      AppMethodBeat.o(183613);
      throw paramString;
    }
  }
  
  static String getSupposablyMime(String paramString)
  {
    AppMethodBeat.i(223195);
    MimeTypeMap localMimeTypeMap = MimeTypeMap.getSingleton();
    paramString = MimeTypeMap.getFileExtensionFromUrl(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(223195);
      return null;
    }
    paramString = localMimeTypeMap.getMimeTypeFromExtension(paramString);
    AppMethodBeat.o(223195);
    return paramString;
  }
  
  static String preview(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(223197);
    int i = Math.min(16, Math.max(paramInt, 0));
    String str = Arrays.toString(Arrays.copyOfRange(paramArrayOfByte, 0, i));
    paramArrayOfByte = str;
    if (i < paramInt) {
      paramArrayOfByte = str.substring(0, str.length() - 1) + ", ...]";
    }
    AppMethodBeat.o(223197);
    return paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.danikula.videocache.ProxyCacheUtils
 * JD-Core Version:    0.7.0.1
 */