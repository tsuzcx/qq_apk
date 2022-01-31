package com.tencent.luggage.g;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  public static JSONArray B(List<? extends Object> paramList)
  {
    AppMethodBeat.i(90917);
    JSONArray localJSONArray = new JSONArray();
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(90917);
      return localJSONArray;
    }
    int i = 0;
    while (i < paramList.size())
    {
      localJSONArray.put(paramList.get(i));
      i += 1;
    }
    AppMethodBeat.o(90917);
    return localJSONArray;
  }
  
  public static void b(Closeable paramCloseable)
  {
    AppMethodBeat.i(90915);
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      AppMethodBeat.o(90915);
      return;
    }
    catch (IOException paramCloseable)
    {
      d.printErrStackTrace("Util", paramCloseable, "qualityClose", new Object[0]);
      AppMethodBeat.o(90915);
    }
  }
  
  public static JSONObject ci(String paramString)
  {
    AppMethodBeat.i(90918);
    if ((paramString == null) || (paramString.length() == 0))
    {
      AppMethodBeat.o(90918);
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      AppMethodBeat.o(90918);
      return paramString;
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(90918);
    }
    return null;
  }
  
  /* Error */
  public static String convertStreamToString(InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 83
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 85	java/io/InputStreamReader
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 88	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   13: astore_2
    //   14: sipush 4096
    //   17: newarray char
    //   19: astore_3
    //   20: new 90	java/io/StringWriter
    //   23: dup
    //   24: invokespecial 91	java/io/StringWriter:<init>	()V
    //   27: astore 4
    //   29: aload_2
    //   30: aload_3
    //   31: invokevirtual 95	java/io/InputStreamReader:read	([C)I
    //   34: istore_1
    //   35: iconst_m1
    //   36: iload_1
    //   37: if_icmpeq +49 -> 86
    //   40: aload 4
    //   42: aload_3
    //   43: iconst_0
    //   44: iload_1
    //   45: invokevirtual 99	java/io/StringWriter:write	([CII)V
    //   48: goto -19 -> 29
    //   51: astore_3
    //   52: ldc 55
    //   54: ldc 101
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_3
    //   63: invokevirtual 105	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   66: aastore
    //   67: invokestatic 109	com/tencent/luggage/g/d:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: aload_2
    //   71: invokestatic 111	com/tencent/luggage/g/i:b	(Ljava/io/Closeable;)V
    //   74: aload_0
    //   75: invokestatic 111	com/tencent/luggage/g/i:b	(Ljava/io/Closeable;)V
    //   78: ldc 83
    //   80: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: ldc 113
    //   85: areturn
    //   86: aload_2
    //   87: invokestatic 111	com/tencent/luggage/g/i:b	(Ljava/io/Closeable;)V
    //   90: aload_0
    //   91: invokestatic 111	com/tencent/luggage/g/i:b	(Ljava/io/Closeable;)V
    //   94: aload 4
    //   96: invokevirtual 116	java/io/StringWriter:toString	()Ljava/lang/String;
    //   99: astore_0
    //   100: ldc 83
    //   102: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_0
    //   106: areturn
    //   107: astore_3
    //   108: aload_2
    //   109: invokestatic 111	com/tencent/luggage/g/i:b	(Ljava/io/Closeable;)V
    //   112: aload_0
    //   113: invokestatic 111	com/tencent/luggage/g/i:b	(Ljava/io/Closeable;)V
    //   116: ldc 83
    //   118: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static void d(Map paramMap)
  {
    AppMethodBeat.i(90916);
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        d((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
    AppMethodBeat.o(90916);
  }
  
  public static byte[] g(InputStream paramInputStream)
  {
    AppMethodBeat.i(90914);
    if (paramInputStream == null)
    {
      AppMethodBeat.o(90914);
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[4096];
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, 4096);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      try
      {
        paramInputStream.close();
        AppMethodBeat.o(90914);
        throw localObject;
      }
      catch (Exception paramInputStream)
      {
        for (;;)
        {
          d.e("Util", "close: ".concat(String.valueOf(paramInputStream)));
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      d.e("Util", "readPkgCertificate: ".concat(String.valueOf(localException)));
      try
      {
        paramInputStream.close();
        AppMethodBeat.o(90914);
        return null;
        localException.flush();
        try
        {
          paramInputStream.close();
          paramInputStream = localException.toByteArray();
          AppMethodBeat.o(90914);
          return paramInputStream;
        }
        catch (Exception paramInputStream)
        {
          for (;;)
          {
            d.e("Util", "close: ".concat(String.valueOf(paramInputStream)));
          }
        }
      }
      catch (Exception paramInputStream)
      {
        for (;;)
        {
          d.e("Util", "close: ".concat(String.valueOf(paramInputStream)));
        }
      }
    }
    finally {}
  }
  
  public static String p(Context paramContext, String paramString)
  {
    AppMethodBeat.i(90912);
    Object localObject = paramContext.getAssets();
    paramContext = null;
    try
    {
      localObject = ((AssetManager)localObject).open(paramString);
      paramContext = (Context)localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        d.e("Util", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, localException });
      }
      paramContext = convertStreamToString(paramContext);
      AppMethodBeat.o(90912);
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(90912);
      return "";
    }
    return paramContext;
  }
  
  public static String y(String paramString1, String paramString2)
  {
    AppMethodBeat.i(141788);
    try
    {
      paramString1 = ah.getContext().getPackageManager().getApplicationInfo(ah.getContext().getPackageName(), 128).metaData.getString(paramString1, paramString2);
      AppMethodBeat.o(141788);
      return paramString1;
    }
    catch (PackageManager.NameNotFoundException paramString1)
    {
      d.a("Util", "", new Object[] { paramString1 });
      AppMethodBeat.o(141788);
    }
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.g.i
 * JD-Core Version:    0.7.0.1
 */