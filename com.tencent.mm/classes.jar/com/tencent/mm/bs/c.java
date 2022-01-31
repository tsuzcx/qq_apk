package com.tencent.mm.bs;

import android.content.Context;
import android.content.res.Resources;
import android.os.StatFs;
import android.util.DisplayMetrics;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.io.File;

public final class c
{
  private static String Xo(String paramString)
  {
    if (bk.bl(paramString)) {
      return "";
    }
    return paramString.replaceAll(" ", "").trim().replaceAll("kB", "").trim().replaceAll("\\t", "").trim();
  }
  
  /* Error */
  public static String coB()
  {
    // Byte code:
    //   0: new 36	java/io/BufferedReader
    //   3: dup
    //   4: new 38	java/io/InputStreamReader
    //   7: dup
    //   8: new 40	java/io/FileInputStream
    //   11: dup
    //   12: ldc 42
    //   14: invokespecial 46	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   17: ldc 48
    //   19: invokespecial 51	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   22: invokespecial 54	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: new 56	java/lang/StringBuilder
    //   31: dup
    //   32: sipush 256
    //   35: invokespecial 59	java/lang/StringBuilder:<init>	(I)V
    //   38: astore_2
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: invokevirtual 62	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +53 -> 100
    //   50: aload_1
    //   51: astore_0
    //   52: aload_3
    //   53: invokestatic 12	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   56: ifne -17 -> 39
    //   59: aload_1
    //   60: astore_0
    //   61: aload_2
    //   62: aload_3
    //   63: invokestatic 64	com/tencent/mm/bs/c:Xo	(Ljava/lang/String;)Ljava/lang/String;
    //   66: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: bipush 59
    //   71: invokevirtual 71	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: goto -36 -> 39
    //   78: astore_2
    //   79: aload_1
    //   80: astore_0
    //   81: ldc 73
    //   83: aload_2
    //   84: ldc 75
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 81	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_1
    //   94: invokestatic 85	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   97: ldc 14
    //   99: areturn
    //   100: aload_1
    //   101: astore_0
    //   102: aload_2
    //   103: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: bipush 44
    //   108: bipush 95
    //   110: invokevirtual 92	java/lang/String:replace	(CC)Ljava/lang/String;
    //   113: astore_2
    //   114: aload_1
    //   115: invokestatic 85	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   118: aload_2
    //   119: areturn
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_0
    //   124: invokestatic 85	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: goto -7 -> 123
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_1
    //   136: goto -57 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	97	0	localBufferedReader1	java.io.BufferedReader
    //   25	90	1	localBufferedReader2	java.io.BufferedReader
    //   120	8	1	localObject1	Object
    //   129	1	1	localObject2	Object
    //   135	1	1	localObject3	Object
    //   38	24	2	localStringBuilder	java.lang.StringBuilder
    //   78	25	2	localThrowable1	java.lang.Throwable
    //   113	6	2	str1	String
    //   133	1	2	localThrowable2	java.lang.Throwable
    //   45	18	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   28	39	78	java/lang/Throwable
    //   41	46	78	java/lang/Throwable
    //   52	59	78	java/lang/Throwable
    //   61	75	78	java/lang/Throwable
    //   102	114	78	java/lang/Throwable
    //   0	26	120	finally
    //   28	39	129	finally
    //   41	46	129	finally
    //   52	59	129	finally
    //   61	75	129	finally
    //   81	93	129	finally
    //   102	114	129	finally
    //   0	26	133	java/lang/Throwable
  }
  
  /* Error */
  public static String coC()
  {
    // Byte code:
    //   0: new 36	java/io/BufferedReader
    //   3: dup
    //   4: new 38	java/io/InputStreamReader
    //   7: dup
    //   8: new 40	java/io/FileInputStream
    //   11: dup
    //   12: ldc 95
    //   14: invokespecial 46	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   17: ldc 48
    //   19: invokespecial 51	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   22: invokespecial 54	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   25: astore_1
    //   26: aload_1
    //   27: astore_0
    //   28: new 56	java/lang/StringBuilder
    //   31: dup
    //   32: sipush 256
    //   35: invokespecial 59	java/lang/StringBuilder:<init>	(I)V
    //   38: astore_2
    //   39: aload_1
    //   40: astore_0
    //   41: aload_1
    //   42: invokevirtual 62	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   45: astore_3
    //   46: aload_3
    //   47: ifnull +53 -> 100
    //   50: aload_1
    //   51: astore_0
    //   52: aload_3
    //   53: invokestatic 12	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   56: ifne -17 -> 39
    //   59: aload_1
    //   60: astore_0
    //   61: aload_2
    //   62: aload_3
    //   63: invokestatic 64	com/tencent/mm/bs/c:Xo	(Ljava/lang/String;)Ljava/lang/String;
    //   66: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: bipush 59
    //   71: invokevirtual 71	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: goto -36 -> 39
    //   78: astore_2
    //   79: aload_1
    //   80: astore_0
    //   81: ldc 73
    //   83: aload_2
    //   84: ldc 75
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 81	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: aload_1
    //   94: invokestatic 85	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   97: ldc 14
    //   99: areturn
    //   100: aload_1
    //   101: astore_0
    //   102: aload_2
    //   103: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: bipush 44
    //   108: bipush 95
    //   110: invokevirtual 92	java/lang/String:replace	(CC)Ljava/lang/String;
    //   113: astore_2
    //   114: aload_1
    //   115: invokestatic 85	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   118: aload_2
    //   119: areturn
    //   120: astore_1
    //   121: aconst_null
    //   122: astore_0
    //   123: aload_0
    //   124: invokestatic 85	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   127: aload_1
    //   128: athrow
    //   129: astore_1
    //   130: goto -7 -> 123
    //   133: astore_2
    //   134: aconst_null
    //   135: astore_1
    //   136: goto -57 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	97	0	localBufferedReader1	java.io.BufferedReader
    //   25	90	1	localBufferedReader2	java.io.BufferedReader
    //   120	8	1	localObject1	Object
    //   129	1	1	localObject2	Object
    //   135	1	1	localObject3	Object
    //   38	24	2	localStringBuilder	java.lang.StringBuilder
    //   78	25	2	localThrowable1	java.lang.Throwable
    //   113	6	2	str1	String
    //   133	1	2	localThrowable2	java.lang.Throwable
    //   45	18	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   28	39	78	java/lang/Throwable
    //   41	46	78	java/lang/Throwable
    //   52	59	78	java/lang/Throwable
    //   61	75	78	java/lang/Throwable
    //   102	114	78	java/lang/Throwable
    //   0	26	120	finally
    //   28	39	129	finally
    //   41	46	129	finally
    //   52	59	129	finally
    //   61	75	129	finally
    //   81	93	129	finally
    //   102	114	129	finally
    //   0	26	133	java/lang/Throwable
  }
  
  public static String coD()
  {
    Object localObject1 = "";
    try
    {
      new DisplayMetrics();
      Object localObject2 = ae.getContext().getResources().getDisplayMetrics();
      int i = ((DisplayMetrics)localObject2).widthPixels;
      int j = ((DisplayMetrics)localObject2).heightPixels;
      float f1 = ((DisplayMetrics)localObject2).density;
      float f2 = ((DisplayMetrics)localObject2).xdpi;
      float f3 = ((DisplayMetrics)localObject2).ydpi;
      localObject2 = "" + "width:" + String.valueOf(i) + ";";
      localObject2 = (String)localObject2 + "height:" + String.valueOf(j) + ";";
      localObject2 = (String)localObject2 + "density:" + String.valueOf(f1) + ";";
      localObject2 = (String)localObject2 + "xd:" + String.valueOf(f2) + ";";
      localObject2 = (String)localObject2 + "yd:" + String.valueOf(f3) + ";";
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[] { bk.j(localException) });
      }
    }
    return ((String)localObject1).replace(",", "_");
  }
  
  public static String coE()
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      StatFs localStatFs = new StatFs(h.getExternalStorageDirectory().getPath());
      str1 = str2;
      long l = localStatFs.getBlockSize();
      str1 = str2;
      str2 = "" + "AvailableSizes:" + localStatFs.getAvailableBlocks() * l + ";";
      str1 = str2;
      str2 = str2 + "FreeSizes:" + localStatFs.getFreeBlocks() * l + ";";
      str1 = str2;
      str2 = str2 + "AllSize:" + localStatFs.getBlockCount() * l + ";";
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[] { bk.j(localException) });
      }
    }
    return str1.replace(",", "_");
  }
  
  public static String coF()
  {
    au.Hx();
    return (String)com.tencent.mm.model.c.Dz().get(71, null);
  }
  
  public static String getRomInfo()
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      StatFs localStatFs = new StatFs(h.getDataDirectory().getPath());
      str1 = str2;
      long l = localStatFs.getBlockSize();
      str1 = str2;
      str2 = "" + "AvailableSizes:" + localStatFs.getAvailableBlocks() * l + ";";
      str1 = str2;
      str2 = str2 + "FreeSizes:" + localStatFs.getFreeBlocks() * l + ";";
      str1 = str2;
      str2 = str2 + "AllSize:" + localStatFs.getBlockCount() * l + ";";
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[] { bk.j(localException) });
      }
    }
    return str1.replace(",", "_");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bs.c
 * JD-Core Version:    0.7.0.1
 */