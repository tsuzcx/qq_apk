package com.tencent.mm.plugin.appbrand.u;

import android.content.Context;
import android.content.res.AssetManager;
import android.webkit.URLUtil;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class d
{
  /* Error */
  public static String convertStreamToString(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 10	java/io/InputStreamReader
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 14	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   8: astore_2
    //   9: sipush 4096
    //   12: newarray char
    //   14: astore_3
    //   15: new 16	java/io/StringWriter
    //   18: dup
    //   19: invokespecial 19	java/io/StringWriter:<init>	()V
    //   22: astore 4
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual 23	java/io/InputStreamReader:read	([C)I
    //   29: istore_1
    //   30: iconst_m1
    //   31: iload_1
    //   32: if_icmpeq +44 -> 76
    //   35: aload 4
    //   37: aload_3
    //   38: iconst_0
    //   39: iload_1
    //   40: invokevirtual 27	java/io/StringWriter:write	([CII)V
    //   43: goto -19 -> 24
    //   46: astore_3
    //   47: ldc 29
    //   49: ldc 31
    //   51: iconst_1
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_3
    //   58: invokevirtual 35	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   61: aastore
    //   62: invokestatic 41	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload_2
    //   66: invokestatic 47	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   69: aload_0
    //   70: invokestatic 47	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   73: ldc 49
    //   75: areturn
    //   76: aload_2
    //   77: invokestatic 47	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   80: aload_0
    //   81: invokestatic 47	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   84: aload 4
    //   86: invokevirtual 52	java/io/StringWriter:toString	()Ljava/lang/String;
    //   89: areturn
    //   90: astore_3
    //   91: aload_2
    //   92: invokestatic 47	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   95: aload_0
    //   96: invokestatic 47	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   99: aload_3
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramInputStream	InputStream
    //   29	11	1	i	int
    //   8	84	2	localInputStreamReader	java.io.InputStreamReader
    //   14	24	3	arrayOfChar	char[]
    //   46	12	3	localException	Exception
    //   90	10	3	localObject	Object
    //   22	63	4	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   24	30	46	java/lang/Exception
    //   35	43	46	java/lang/Exception
    //   24	30	90	finally
    //   35	43	90	finally
    //   47	65	90	finally
  }
  
  public static byte[] k(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer == null) {
      return new byte[0];
    }
    if (!paramByteBuffer.isDirect()) {
      return paramByteBuffer.array();
    }
    int i = paramByteBuffer.position();
    paramByteBuffer.position(0);
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    paramByteBuffer.position(i);
    return arrayOfByte;
  }
  
  public static byte[] w(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte2 = new byte[4096];
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte2, 0, 4096);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte2, 0, i);
      }
      try
      {
        byte[] arrayOfByte1;
        paramInputStream.close();
        throw localObject;
      }
      catch (Exception paramInputStream)
      {
        for (;;)
        {
          y.e("MicroMsg.AppBrandIOUtil", "close: " + paramInputStream);
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      y.e("MicroMsg.AppBrandIOUtil", "readPkgCertificate: " + localException);
      arrayOfByte1 = new byte[0];
      try
      {
        paramInputStream.close();
        return arrayOfByte1;
      }
      catch (Exception paramInputStream)
      {
        y.e("MicroMsg.AppBrandIOUtil", "close: " + paramInputStream);
        return arrayOfByte1;
      }
      arrayOfByte1.flush();
      try
      {
        paramInputStream.close();
        return arrayOfByte1.toByteArray();
      }
      catch (Exception paramInputStream)
      {
        for (;;)
        {
          y.e("MicroMsg.AppBrandIOUtil", "close: " + paramInputStream);
        }
      }
    }
    finally {}
  }
  
  public static String wB(String paramString)
  {
    Object localObject2 = ae.getContext().getAssets();
    Object localObject1 = null;
    try
    {
      localObject2 = ((AssetManager)localObject2).open(paramString);
      paramString = (String)localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, bk.j(localException) });
        paramString = localObject1;
      }
    }
    if (paramString == null) {
      return "";
    }
    return convertStreamToString(paramString);
  }
  
  public static byte[] wC(String paramString)
  {
    Object localObject2 = ae.getContext().getAssets();
    Object localObject1 = null;
    try
    {
      localObject2 = ((AssetManager)localObject2).open(paramString);
      paramString = (String)localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, bk.j(localException) });
        paramString = localObject1;
      }
    }
    if (paramString == null) {
      return new byte[0];
    }
    return w(paramString);
  }
  
  public static boolean wD(String paramString)
  {
    return (!bk.bl(paramString)) && ((URLUtil.isHttpsUrl(paramString)) || (URLUtil.isHttpUrl(paramString)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.u.d
 * JD-Core Version:    0.7.0.1
 */