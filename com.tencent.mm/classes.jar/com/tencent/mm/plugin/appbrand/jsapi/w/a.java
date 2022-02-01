package com.tencent.mm.plugin.appbrand.jsapi.w;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.i;
import java.util.ArrayList;

public final class a
{
  public static String NI(String paramString)
  {
    AppMethodBeat.i(206832);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(206832);
      return "";
    }
    paramString = NK(NJ(paramString));
    AppMethodBeat.o(206832);
    return paramString;
  }
  
  private static String NJ(String paramString)
  {
    AppMethodBeat.i(206833);
    paramString = paramString.substring(paramString.indexOf("base64,") + 7).trim();
    AppMethodBeat.o(206833);
    return paramString;
  }
  
  /* Error */
  private static String NK(String paramString)
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: iconst_0
    //   7: invokestatic 59	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   10: astore_2
    //   11: aload_2
    //   12: ifnull +8 -> 20
    //   15: aload_2
    //   16: arraylength
    //   17: ifne +11 -> 28
    //   20: ldc 53
    //   22: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   25: ldc 24
    //   27: areturn
    //   28: new 61	java/lang/StringBuilder
    //   31: dup
    //   32: ldc 63
    //   34: invokespecial 67	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   37: invokestatic 73	java/lang/System:currentTimeMillis	()J
    //   40: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   43: ldc 79
    //   45: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: invokevirtual 86	java/lang/String:hashCode	()I
    //   52: invokevirtual 89	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   55: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore_0
    //   59: new 94	com/tencent/mm/vfs/e
    //   62: dup
    //   63: invokestatic 100	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   66: invokevirtual 106	android/content/Context:getCacheDir	()Ljava/io/File;
    //   69: aload_0
    //   70: invokespecial 109	com/tencent/mm/vfs/e:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   73: astore_3
    //   74: aconst_null
    //   75: astore_1
    //   76: aload_3
    //   77: invokestatic 115	com/tencent/mm/vfs/i:ah	(Lcom/tencent/mm/vfs/e;)Ljava/io/OutputStream;
    //   80: astore_0
    //   81: aload_0
    //   82: astore_1
    //   83: aload_0
    //   84: aload_2
    //   85: invokevirtual 121	java/io/OutputStream:write	([B)V
    //   88: aload_0
    //   89: ifnull +7 -> 96
    //   92: aload_0
    //   93: invokevirtual 125	java/io/OutputStream:close	()V
    //   96: aload_3
    //   97: invokevirtual 129	com/tencent/mm/vfs/e:fxV	()Landroid/net/Uri;
    //   100: invokestatic 135	com/tencent/mm/vfs/q:B	(Landroid/net/Uri;)Ljava/lang/String;
    //   103: astore_0
    //   104: ldc 53
    //   106: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_0
    //   110: areturn
    //   111: astore_0
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_0
    //   115: ifnull +7 -> 122
    //   118: aload_0
    //   119: invokevirtual 125	java/io/OutputStream:close	()V
    //   122: ldc 53
    //   124: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: ldc 24
    //   129: areturn
    //   130: astore_0
    //   131: aload_1
    //   132: ifnull +7 -> 139
    //   135: aload_1
    //   136: invokevirtual 125	java/io/OutputStream:close	()V
    //   139: ldc 53
    //   141: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_0
    //   145: athrow
    //   146: astore_0
    //   147: goto -51 -> 96
    //   150: astore_0
    //   151: goto -29 -> 122
    //   154: astore_1
    //   155: goto -16 -> 139
    //   158: astore_1
    //   159: goto -45 -> 114
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	162	0	paramString	String
    //   75	61	1	str	String
    //   154	1	1	localIOException	java.io.IOException
    //   158	1	1	localException	Exception
    //   10	75	2	arrayOfByte	byte[]
    //   73	24	3	locale	com.tencent.mm.vfs.e
    // Exception table:
    //   from	to	target	type
    //   76	81	111	java/lang/Exception
    //   76	81	130	finally
    //   83	88	130	finally
    //   92	96	146	java/io/IOException
    //   118	122	150	java/io/IOException
    //   135	139	154	java/io/IOException
    //   83	88	158	java/lang/Exception
  }
  
  public static String[] a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(206830);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString1.length)
    {
      if ((paramArrayOfString1[i] != null) && (paramArrayOfString2[i] != null) && (!paramArrayOfString1[i].equals(paramArrayOfString2[i]))) {
        localArrayList.add(paramArrayOfString1[i]);
      }
      i += 1;
    }
    paramArrayOfString1 = (String[])localArrayList.toArray(new String[localArrayList.size()]);
    AppMethodBeat.o(206830);
    return paramArrayOfString1;
  }
  
  public static String[] o(String[] paramArrayOfString)
  {
    AppMethodBeat.i(206829);
    String[] arrayOfString = new String[paramArrayOfString.length];
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      if ((paramArrayOfString[i] != null) && (paramArrayOfString[i].startsWith("data:image/"))) {
        arrayOfString[i] = NI(paramArrayOfString[i]);
      }
      for (;;)
      {
        i += 1;
        break;
        arrayOfString[i] = paramArrayOfString[i];
      }
    }
    AppMethodBeat.o(206829);
    return arrayOfString;
  }
  
  public static void p(String[] paramArrayOfString)
  {
    AppMethodBeat.i(206831);
    int i = 0;
    for (;;)
    {
      if (i < paramArrayOfString.length) {}
      try
      {
        i.deleteFile(paramArrayOfString[i]);
        label20:
        i += 1;
        continue;
        AppMethodBeat.o(206831);
        return;
      }
      catch (Exception localException)
      {
        break label20;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.w.a
 * JD-Core Version:    0.7.0.1
 */