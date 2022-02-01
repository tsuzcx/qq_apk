package com.tencent.mm.av.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class e
  implements m
{
  public static byte[] b(InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(130418);
    byte[] arrayOfByte = new byte[1024];
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    arrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.close();
    if (!paramBoolean) {
      paramInputStream.close();
    }
    AppMethodBeat.o(130418);
    return arrayOfByte;
  }
  
  public static byte[] r(InputStream paramInputStream)
  {
    AppMethodBeat.i(130417);
    paramInputStream = b(paramInputStream, false);
    AppMethodBeat.o(130417);
    return paramInputStream;
  }
  
  public final boolean a(String paramString, InputStream paramInputStream)
  {
    AppMethodBeat.i(130416);
    if (paramInputStream == null)
    {
      Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: inputStream is null. check failed");
      AppMethodBeat.o(130416);
      return false;
    }
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
      AppMethodBeat.o(130416);
      return false;
    }
    try
    {
      paramInputStream.mark(paramInputStream.available());
      String str = MD5Util.getMD5String(b(paramInputStream, true));
      paramInputStream.reset();
      if ((!Util.isNullOrNil(str)) && (str.equals(paramString)))
      {
        Log.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
        AppMethodBeat.o(130416);
        return true;
      }
      Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[] { str, paramString });
      AppMethodBeat.o(130416);
      return false;
    }
    catch (Exception paramString)
    {
      Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: exception: " + paramString.toString());
      AppMethodBeat.o(130416);
    }
    return false;
  }
  
  public final boolean br(String paramString1, String paramString2)
  {
    AppMethodBeat.i(130414);
    if (Util.isNullOrNil(paramString2))
    {
      Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: filePath is null. check failed");
      AppMethodBeat.o(130414);
      return false;
    }
    if (Util.isNullOrNil(paramString1))
    {
      Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
      AppMethodBeat.o(130414);
      return false;
    }
    paramString2 = s.bhK(paramString2);
    if ((!Util.isNullOrNil(paramString2)) && (paramString2.equals(paramString1)))
    {
      Log.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
      AppMethodBeat.o(130414);
      return true;
    }
    Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[] { paramString2, paramString1 });
    AppMethodBeat.o(130414);
    return false;
  }
  
  public final boolean j(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130415);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
      AppMethodBeat.o(130415);
      return false;
    }
    paramArrayOfByte = MD5Util.getMD5String(paramArrayOfByte);
    if ((!Util.isNullOrNil(paramArrayOfByte)) && (paramArrayOfByte.equals(paramString)))
    {
      Log.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
      AppMethodBeat.o(130415);
      return true;
    }
    Log.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[] { paramArrayOfByte, paramString });
    AppMethodBeat.o(130415);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.av.a.b.e
 * JD-Core Version:    0.7.0.1
 */