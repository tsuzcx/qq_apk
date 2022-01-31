package com.tencent.mm.at.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.at.a.c.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public final class e
  implements k
{
  public static byte[] a(InputStream paramInputStream, boolean paramBoolean)
  {
    AppMethodBeat.i(116088);
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
    AppMethodBeat.o(116088);
    return arrayOfByte;
  }
  
  public static byte[] u(InputStream paramInputStream)
  {
    AppMethodBeat.i(116087);
    paramInputStream = a(paramInputStream, false);
    AppMethodBeat.o(116087);
    return paramInputStream;
  }
  
  public final boolean aP(String paramString1, String paramString2)
  {
    AppMethodBeat.i(116084);
    if (bo.isNullOrNil(paramString2))
    {
      ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: filePath is null. check failed");
      AppMethodBeat.o(116084);
      return false;
    }
    if (bo.isNullOrNil(paramString1))
    {
      ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
      AppMethodBeat.o(116084);
      return false;
    }
    paramString2 = g.getMD5(paramString2);
    if ((!bo.isNullOrNil(paramString2)) && (paramString2.equals(paramString1)))
    {
      ab.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
      AppMethodBeat.o(116084);
      return true;
    }
    ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[] { paramString2, paramString1 });
    AppMethodBeat.o(116084);
    return false;
  }
  
  public final boolean b(String paramString, InputStream paramInputStream)
  {
    AppMethodBeat.i(116086);
    if (paramInputStream == null)
    {
      ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: inputStream is null. check failed");
      AppMethodBeat.o(116086);
      return false;
    }
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
      AppMethodBeat.o(116086);
      return false;
    }
    try
    {
      paramInputStream.mark(paramInputStream.available());
      String str = ag.v(a(paramInputStream, true));
      paramInputStream.reset();
      if ((!bo.isNullOrNil(str)) && (str.equals(paramString)))
      {
        ab.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
        AppMethodBeat.o(116086);
        return true;
      }
      ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[] { str, paramString });
      AppMethodBeat.o(116086);
      return false;
    }
    catch (Exception paramString)
    {
      ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: exception: " + paramString.toString());
      AppMethodBeat.o(116086);
    }
    return false;
  }
  
  public final boolean p(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(116085);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: target md5 is null or nill. check failed");
      AppMethodBeat.o(116085);
      return false;
    }
    paramArrayOfByte = ag.v(paramArrayOfByte);
    if ((!bo.isNullOrNil(paramArrayOfByte)) && (paramArrayOfByte.equals(paramString)))
    {
      ab.i("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check success");
      AppMethodBeat.o(116085);
      return true;
    }
    ab.w("MicroMsg.DefaultImageMD5CheckListener", "hy: md5 check failed. original is %s, target is %s", new Object[] { paramArrayOfByte, paramString });
    AppMethodBeat.o(116085);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.at.a.b.e
 * JD-Core Version:    0.7.0.1
 */