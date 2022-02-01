package com.tencent.mm.plugin.appbrand.y;

import android.content.Context;
import android.content.res.AssetManager;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class d
{
  public static byte[] I(InputStream paramInputStream)
  {
    AppMethodBeat.i(140805);
    paramInputStream = a(paramInputStream, 0L, -1L);
    AppMethodBeat.o(140805);
    return paramInputStream;
  }
  
  public static String VE(String paramString)
  {
    AppMethodBeat.i(140802);
    Object localObject2 = ak.getContext().getAssets();
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
        ae.e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, bu.o(localException) });
        paramString = localObject1;
      }
      paramString = convertStreamToString(paramString);
      AppMethodBeat.o(140802);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(140802);
      return "";
    }
    return paramString;
  }
  
  public static byte[] VF(String paramString)
  {
    AppMethodBeat.i(140803);
    Object localObject2 = ak.getContext().getAssets();
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
        ae.e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, bu.o(localException) });
        paramString = localObject1;
      }
      paramString = I(paramString);
      AppMethodBeat.o(140803);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(140803);
      return new byte[0];
    }
    return paramString;
  }
  
  public static boolean VG(String paramString)
  {
    AppMethodBeat.i(140806);
    if ((!bu.isNullOrNil(paramString)) && ((URLUtil.isHttpsUrl(paramString)) || (URLUtil.isHttpUrl(paramString))))
    {
      AppMethodBeat.o(140806);
      return true;
    }
    AppMethodBeat.o(140806);
    return false;
  }
  
  public static byte[] a(InputStream paramInputStream, long paramLong1, long paramLong2)
  {
    int i = 0;
    AppMethodBeat.i(140804);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[16384];
    try
    {
      j = paramInputStream.available();
      if (j < 0) {
        try
        {
          paramInputStream.close();
          AppMethodBeat.o(140804);
          return new byte[0];
        }
        catch (Exception paramInputStream)
        {
          for (;;)
          {
            ae.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: ".concat(String.valueOf(paramInputStream)));
          }
        }
      }
      if (paramLong1 + paramLong2 - 1L > j - 1) {
        try
        {
          paramInputStream.close();
          AppMethodBeat.o(140804);
          return new byte[0];
        }
        catch (Exception paramInputStream)
        {
          for (;;)
          {
            ae.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: ".concat(String.valueOf(paramInputStream)));
          }
        }
      }
      l = j;
      if (paramLong2 < 0L) {
        break label308;
      }
    }
    catch (Exception localException)
    {
      int j;
      ae.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray: ".concat(String.valueOf(localException)));
      try
      {
        paramInputStream.close();
        AppMethodBeat.o(140804);
        return new byte[0];
      }
      catch (Exception paramInputStream)
      {
        for (;;)
        {
          ae.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: ".concat(String.valueOf(paramInputStream)));
        }
      }
    }
    finally
    {
      for (;;)
      {
        long l;
        try
        {
          paramInputStream.close();
          AppMethodBeat.o(140804);
          throw localObject;
        }
        catch (Exception paramInputStream)
        {
          ae.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: ".concat(String.valueOf(paramInputStream)));
          continue;
        }
        paramLong2 = l;
      }
    }
    paramInputStream.skip(paramLong1);
    while (i < paramLong2)
    {
      j = paramInputStream.read(arrayOfByte, 0, 16384);
      if (j == -1) {
        break;
      }
      j = (int)Math.min(j, paramLong2 - i);
      localByteArrayOutputStream.write(arrayOfByte, 0, j);
      i += j;
    }
    localByteArrayOutputStream.flush();
    try
    {
      paramInputStream.close();
      paramInputStream = localByteArrayOutputStream.toByteArray();
      AppMethodBeat.o(140804);
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      for (;;)
      {
        ae.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: ".concat(String.valueOf(paramInputStream)));
      }
    }
  }
  
  /* Error */
  public static String convertStreamToString(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 144
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 146	java/io/InputStreamReader
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 149	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   13: astore_2
    //   14: sipush 16384
    //   17: newarray char
    //   19: astore_3
    //   20: new 151	java/io/StringWriter
    //   23: dup
    //   24: invokespecial 152	java/io/StringWriter:<init>	()V
    //   27: astore 4
    //   29: aload_2
    //   30: aload_3
    //   31: invokevirtual 155	java/io/InputStreamReader:read	([C)I
    //   34: istore_1
    //   35: iconst_m1
    //   36: iload_1
    //   37: if_icmpeq +49 -> 86
    //   40: aload 4
    //   42: aload_3
    //   43: iconst_0
    //   44: iload_1
    //   45: invokevirtual 158	java/io/StringWriter:write	([CII)V
    //   48: goto -19 -> 29
    //   51: astore_3
    //   52: ldc 50
    //   54: ldc 160
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_3
    //   63: invokevirtual 164	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   66: aastore
    //   67: invokestatic 63	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_2
    //   71: invokestatic 168	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   74: aload_0
    //   75: invokestatic 168	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   78: ldc 144
    //   80: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: ldc 48
    //   85: areturn
    //   86: aload_2
    //   87: invokestatic 168	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   90: aload_0
    //   91: invokestatic 168	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   94: aload 4
    //   96: invokevirtual 171	java/io/StringWriter:toString	()Ljava/lang/String;
    //   99: astore_0
    //   100: ldc 144
    //   102: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: areturn
    //   107: astore_3
    //   108: aload_2
    //   109: invokestatic 168	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   112: aload_0
    //   113: invokestatic 168	com/tencent/mm/sdk/platformtools/bu:d	(Ljava/io/Closeable;)V
    //   116: ldc 144
    //   118: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: aload_3
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramInputStream	InputStream
    //   34	11	1	i	int
    //   13	96	2	localInputStreamReader	java.io.InputStreamReader
    //   19	24	3	arrayOfChar	char[]
    //   51	12	3	localException	Exception
    //   107	15	3	localObject	Object
    //   27	68	4	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   29	35	51	java/lang/Exception
    //   40	48	51	java/lang/Exception
    //   29	35	107	finally
    //   40	48	107	finally
    //   52	70	107	finally
  }
  
  public static byte[] p(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(140807);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(140807);
      return new byte[0];
    }
    if (!paramByteBuffer.isDirect())
    {
      paramByteBuffer = paramByteBuffer.array();
      AppMethodBeat.o(140807);
      return paramByteBuffer;
    }
    int i = paramByteBuffer.position();
    paramByteBuffer.position(0);
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    paramByteBuffer.position(i);
    AppMethodBeat.o(140807);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.y.d
 * JD-Core Version:    0.7.0.1
 */