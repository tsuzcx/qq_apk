package com.tencent.luggage.j;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.Closeable;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

public final class h
{
  private static void b(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      c.printErrStackTrace("Util", paramCloseable, "qualityClose", new Object[0]);
    }
  }
  
  public static void c(Map paramMap)
  {
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      Object localObject1 = ((Map.Entry)localObject2).getKey();
      localObject2 = ((Map.Entry)localObject2).getValue();
      if (((localObject1 instanceof String)) && ((localObject2 instanceof Map)))
      {
        c((Map)localObject2);
        paramMap.put(localObject1, new JSONObject((Map)localObject2));
      }
    }
  }
  
  /* Error */
  private static String convertStreamToString(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 76	java/io/InputStreamReader
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 79	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   8: astore_2
    //   9: sipush 4096
    //   12: newarray char
    //   14: astore_3
    //   15: new 81	java/io/StringWriter
    //   18: dup
    //   19: invokespecial 83	java/io/StringWriter:<init>	()V
    //   22: astore 4
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual 87	java/io/InputStreamReader:read	([C)I
    //   29: istore_1
    //   30: iconst_m1
    //   31: iload_1
    //   32: if_icmpeq +44 -> 76
    //   35: aload 4
    //   37: aload_3
    //   38: iconst_0
    //   39: iload_1
    //   40: invokevirtual 91	java/io/StringWriter:write	([CII)V
    //   43: goto -19 -> 24
    //   46: astore_3
    //   47: ldc 16
    //   49: ldc 93
    //   51: iconst_1
    //   52: anewarray 4	java/lang/Object
    //   55: dup
    //   56: iconst_0
    //   57: aload_3
    //   58: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   61: aastore
    //   62: invokestatic 101	com/tencent/luggage/j/c:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   65: aload_2
    //   66: invokestatic 103	com/tencent/luggage/j/h:b	(Ljava/io/Closeable;)V
    //   69: aload_0
    //   70: invokestatic 103	com/tencent/luggage/j/h:b	(Ljava/io/Closeable;)V
    //   73: ldc 105
    //   75: areturn
    //   76: aload_2
    //   77: invokestatic 103	com/tencent/luggage/j/h:b	(Ljava/io/Closeable;)V
    //   80: aload_0
    //   81: invokestatic 103	com/tencent/luggage/j/h:b	(Ljava/io/Closeable;)V
    //   84: aload 4
    //   86: invokevirtual 108	java/io/StringWriter:toString	()Ljava/lang/String;
    //   89: areturn
    //   90: astore_3
    //   91: aload_2
    //   92: invokestatic 103	com/tencent/luggage/j/h:b	(Ljava/io/Closeable;)V
    //   95: aload_0
    //   96: invokestatic 103	com/tencent/luggage/j/h:b	(Ljava/io/Closeable;)V
    //   99: aload_3
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	paramInputStream	java.io.InputStream
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
  
  public static String k(Context paramContext, String paramString)
  {
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
        c.e("Util", "openRead file( %s ) failed, exp = %s", new Object[] { paramString, localException });
      }
    }
    if (paramContext == null) {
      return "";
    }
    return convertStreamToString(paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.luggage.j.h
 * JD-Core Version:    0.7.0.1
 */