package com.tencent.mm.as.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.as.a.c.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class e
  implements k
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
  
  public static byte[] r(InputStream paramInputStream)
  {
    return a(paramInputStream, false);
  }
  
  public final boolean aw(String paramString1, String paramString2)
  {
    if (bk.bl(paramString2))
    {
      y.w("MicroMsg.DefaultImageMD5CheckListener", "hy: filePath is null. check failed");
      return false;
    }
    if (bk.bl(paramString1))
    {
      y.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
      return false;
    }
    paramString2 = g.bQ(paramString2);
    if ((!bk.bl(paramString2)) && (paramString2.equals(paramString1)))
    {
      y.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
      return true;
    }
    y.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[] { paramString2, paramString1 });
    return false;
  }
  
  public final boolean b(String paramString, InputStream paramInputStream)
  {
    if (paramInputStream == null)
    {
      y.w("MicroMsg.DefaultImageMD5CheckListener", "hy: inputStream is null. check failed");
      return false;
    }
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
      return false;
    }
    try
    {
      paramInputStream = ad.n(a(paramInputStream, true));
      if ((!bk.bl(paramInputStream)) && (paramInputStream.equals(paramString)))
      {
        y.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
        return true;
      }
      y.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[] { paramInputStream, paramString });
      return false;
    }
    catch (Exception paramString)
    {
      y.w("MicroMsg.DefaultImageMD5CheckListener", "hy: exception: " + paramString.toString());
    }
    return false;
  }
  
  public final boolean j(String paramString, byte[] paramArrayOfByte)
  {
    if (bk.bl(paramString))
    {
      y.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
      return false;
    }
    paramArrayOfByte = ad.n(paramArrayOfByte);
    if ((!bk.bl(paramArrayOfByte)) && (paramArrayOfByte.equals(paramString)))
    {
      y.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
      return true;
    }
    y.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[] { paramArrayOfByte, paramString });
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.as.a.b.e
 * JD-Core Version:    0.7.0.1
 */