package com.tencent.mm.loader.e;

import com.tencent.mm.loader.d.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class d
  implements c
{
  public static byte[] a(InputStream paramInputStream, boolean paramBoolean)
  {
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
    return arrayOfByte;
  }
  
  public final boolean b(String paramString, InputStream paramInputStream)
  {
    if (paramInputStream == null)
    {
      ab.w("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: inputStream is null. check failed");
      return false;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
      return false;
    }
    try
    {
      paramInputStream = ag.v(a(paramInputStream, true));
      if ((!bo.isNullOrNil(paramInputStream)) && (paramInputStream.equals(paramString)))
      {
        ab.i("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: md5 check success");
        return true;
      }
      ab.w("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[] { paramInputStream, paramString });
      return false;
    }
    catch (Exception paramString)
    {
      ab.w("MicroMsg.Loader.DefaultImageMD5CheckListener", "hy: exception: " + paramString.toString());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.loader.e.d
 * JD-Core Version:    0.7.0.1
 */