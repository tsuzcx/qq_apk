package com.tencent.mm.plugin.appbrand.s;

import android.content.Context;
import android.content.res.AssetManager;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class d
{
  public static String Fj(String paramString)
  {
    AppMethodBeat.i(91138);
    Object localObject2 = ah.getContext().getAssets();
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
        ab.e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, bo.l(localException) });
        paramString = localObject1;
      }
      paramString = convertStreamToString(paramString);
      AppMethodBeat.o(91138);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(91138);
      return "";
    }
    return paramString;
  }
  
  public static byte[] Fk(String paramString)
  {
    AppMethodBeat.i(91139);
    Object localObject2 = ah.getContext().getAssets();
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
        ab.e("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, bo.l(localException) });
        paramString = localObject1;
      }
      paramString = g(paramString);
      AppMethodBeat.o(91139);
    }
    if (paramString == null)
    {
      AppMethodBeat.o(91139);
      return new byte[0];
    }
    return paramString;
  }
  
  public static boolean Fl(String paramString)
  {
    AppMethodBeat.i(91141);
    if ((!bo.isNullOrNil(paramString)) && ((URLUtil.isHttpsUrl(paramString)) || (URLUtil.isHttpUrl(paramString))))
    {
      AppMethodBeat.o(91141);
      return true;
    }
    AppMethodBeat.o(91141);
    return false;
  }
  
  /* Error */
  public static String convertStreamToString(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 81
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 83	java/io/InputStreamReader
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 87	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   13: astore_2
    //   14: sipush 16384
    //   17: newarray char
    //   19: astore_3
    //   20: new 89	java/io/StringWriter
    //   23: dup
    //   24: invokespecial 92	java/io/StringWriter:<init>	()V
    //   27: astore 4
    //   29: aload_2
    //   30: aload_3
    //   31: invokevirtual 96	java/io/InputStreamReader:read	([C)I
    //   34: istore_1
    //   35: iconst_m1
    //   36: iload_1
    //   37: if_icmpeq +49 -> 86
    //   40: aload 4
    //   42: aload_3
    //   43: iconst_0
    //   44: iload_1
    //   45: invokevirtual 100	java/io/StringWriter:write	([CII)V
    //   48: goto -19 -> 29
    //   51: astore_3
    //   52: ldc 40
    //   54: ldc 102
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_3
    //   63: invokevirtual 106	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   66: aastore
    //   67: invokestatic 54	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_2
    //   71: invokestatic 110	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   74: aload_0
    //   75: invokestatic 110	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   78: ldc 81
    //   80: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: ldc 38
    //   85: areturn
    //   86: aload_2
    //   87: invokestatic 110	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   90: aload_0
    //   91: invokestatic 110	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   94: aload 4
    //   96: invokevirtual 113	java/io/StringWriter:toString	()Ljava/lang/String;
    //   99: astore_0
    //   100: ldc 81
    //   102: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: areturn
    //   107: astore_3
    //   108: aload_2
    //   109: invokestatic 110	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   112: aload_0
    //   113: invokestatic 110	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   116: ldc 81
    //   118: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static byte[] g(InputStream paramInputStream)
  {
    AppMethodBeat.i(91140);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[16384];
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, 16384);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      try
      {
        paramInputStream.close();
        AppMethodBeat.o(91140);
        throw localObject;
      }
      catch (Exception paramInputStream)
      {
        for (;;)
        {
          ab.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: ".concat(String.valueOf(paramInputStream)));
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      ab.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray: ".concat(String.valueOf(localException)));
      try
      {
        paramInputStream.close();
        AppMethodBeat.o(91140);
        return new byte[0];
        localException.flush();
        try
        {
          paramInputStream.close();
          paramInputStream = localException.toByteArray();
          AppMethodBeat.o(91140);
          return paramInputStream;
        }
        catch (Exception paramInputStream)
        {
          for (;;)
          {
            ab.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: ".concat(String.valueOf(paramInputStream)));
          }
        }
      }
      catch (Exception paramInputStream)
      {
        for (;;)
        {
          ab.e("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: ".concat(String.valueOf(paramInputStream)));
        }
      }
    }
    finally {}
  }
  
  public static byte[] m(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(91142);
    if (paramByteBuffer == null)
    {
      AppMethodBeat.o(91142);
      return new byte[0];
    }
    if (!paramByteBuffer.isDirect())
    {
      paramByteBuffer = paramByteBuffer.array();
      AppMethodBeat.o(91142);
      return paramByteBuffer;
    }
    int i = paramByteBuffer.position();
    paramByteBuffer.position(0);
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    paramByteBuffer.position(i);
    AppMethodBeat.o(91142);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.s.d
 * JD-Core Version:    0.7.0.1
 */