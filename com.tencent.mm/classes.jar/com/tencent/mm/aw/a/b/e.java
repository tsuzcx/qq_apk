package com.tencent.mm.aw.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
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
  
  public static byte[] s(InputStream paramInputStream)
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
      ad.w("MicroMsg.DefaultImageMD5CheckListener", "hy: inputStream is null. check failed");
      AppMethodBeat.o(130416);
      return false;
    }
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
      AppMethodBeat.o(130416);
      return false;
    }
    try
    {
      paramInputStream.mark(paramInputStream.available());
      String str = ai.B(b(paramInputStream, true));
      paramInputStream.reset();
      if ((!bt.isNullOrNil(str)) && (str.equals(paramString)))
      {
        ad.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
        AppMethodBeat.o(130416);
        return true;
      }
      ad.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[] { str, paramString });
      AppMethodBeat.o(130416);
      return false;
    }
    catch (Exception paramString)
    {
      ad.w("MicroMsg.DefaultImageMD5CheckListener", "hy: exception: " + paramString.toString());
      AppMethodBeat.o(130416);
    }
    return false;
  }
  
  public final boolean bp(String paramString1, String paramString2)
  {
    AppMethodBeat.i(130414);
    if (bt.isNullOrNil(paramString2))
    {
      ad.w("MicroMsg.DefaultImageMD5CheckListener", "hy: filePath is null. check failed");
      AppMethodBeat.o(130414);
      return false;
    }
    if (bt.isNullOrNil(paramString1))
    {
      ad.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
      AppMethodBeat.o(130414);
      return false;
    }
    paramString2 = i.aPK(paramString2);
    if ((!bt.isNullOrNil(paramString2)) && (paramString2.equals(paramString1)))
    {
      ad.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
      AppMethodBeat.o(130414);
      return true;
    }
    ad.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[] { paramString2, paramString1 });
    AppMethodBeat.o(130414);
    return false;
  }
  
  public final boolean j(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130415);
    if (bt.isNullOrNil(paramString))
    {
      ad.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
      AppMethodBeat.o(130415);
      return false;
    }
    paramArrayOfByte = ai.B(paramArrayOfByte);
    if ((!bt.isNullOrNil(paramArrayOfByte)) && (paramArrayOfByte.equals(paramString)))
    {
      ad.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
      AppMethodBeat.o(130415);
      return true;
    }
    ad.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[] { paramArrayOfByte, paramString });
    AppMethodBeat.o(130415);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aw.a.b.e
 * JD-Core Version:    0.7.0.1
 */