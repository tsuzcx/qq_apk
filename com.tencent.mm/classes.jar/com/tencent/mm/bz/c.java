package com.tencent.mm.bz;

import android.content.Context;
import android.content.res.Resources;
import android.os.StatFs;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import java.io.File;

public final class c
{
  private static String bsr(String paramString)
  {
    AppMethodBeat.i(32073);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(32073);
      return "";
    }
    paramString = paramString.replaceAll(" ", "").trim().replaceAll("kB", "").trim().replaceAll("\\t", "").trim();
    AppMethodBeat.o(32073);
    return paramString;
  }
  
  public static String getRomInfo()
  {
    AppMethodBeat.i(32077);
    String str2 = "";
    String str1 = str2;
    try
    {
      StatFs localStatFs = new StatFs(g.avG().getPath());
      str1 = str2;
      long l = localStatFs.getBlockSize();
      str1 = str2;
      str2 = "" + "AvailableSizes:" + localStatFs.getAvailableBlocks() * l + ";";
      str1 = str2;
      str2 = str2 + "FreeSizes:" + localStatFs.getFreeBlocks() * l + ";";
      str1 = str2;
      str2 = str2 + "AllSize:" + l * localStatFs.getBlockCount() + ";";
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
    str1 = str1.replace(",", "_");
    AppMethodBeat.o(32077);
    return str1;
  }
  
  /* Error */
  public static String hom()
  {
    // Byte code:
    //   0: sipush 32074
    //   3: invokestatic 12	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 123	java/io/BufferedReader
    //   9: dup
    //   10: new 125	java/io/InputStreamReader
    //   13: dup
    //   14: ldc 127
    //   16: invokestatic 133	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: ldc 135
    //   21: invokespecial 138	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   24: invokespecial 141	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_1
    //   28: aload_1
    //   29: astore_0
    //   30: new 66	java/lang/StringBuilder
    //   33: dup
    //   34: sipush 256
    //   37: invokespecial 143	java/lang/StringBuilder:<init>	(I)V
    //   40: astore_2
    //   41: aload_1
    //   42: astore_0
    //   43: aload_1
    //   44: invokevirtual 146	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull +59 -> 108
    //   52: aload_1
    //   53: astore_0
    //   54: aload_3
    //   55: invokestatic 18	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   58: ifne -17 -> 41
    //   61: aload_1
    //   62: astore_0
    //   63: aload_2
    //   64: aload_3
    //   65: invokestatic 148	com/tencent/mm/bz/c:bsr	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: bipush 59
    //   73: invokevirtual 151	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: goto -36 -> 41
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: ldc 106
    //   85: aload_2
    //   86: ldc 153
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_1
    //   96: invokestatic 161	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   99: sipush 32074
    //   102: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: ldc 23
    //   107: areturn
    //   108: aload_1
    //   109: astore_0
    //   110: aload_2
    //   111: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: bipush 44
    //   116: bipush 95
    //   118: invokevirtual 164	java/lang/String:replace	(CC)Ljava/lang/String;
    //   121: astore_2
    //   122: aload_1
    //   123: invokestatic 161	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   126: sipush 32074
    //   129: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload_2
    //   133: areturn
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_0
    //   137: aload_0
    //   138: invokestatic 161	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   141: sipush 32074
    //   144: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_1
    //   148: athrow
    //   149: astore_1
    //   150: goto -13 -> 137
    //   153: astore_2
    //   154: aconst_null
    //   155: astore_1
    //   156: goto -75 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	109	0	localBufferedReader1	java.io.BufferedReader
    //   27	96	1	localBufferedReader2	java.io.BufferedReader
    //   134	14	1	localObject1	Object
    //   149	1	1	localObject2	Object
    //   155	1	1	localObject3	Object
    //   40	24	2	localStringBuilder	java.lang.StringBuilder
    //   80	31	2	localThrowable1	java.lang.Throwable
    //   121	12	2	str1	String
    //   153	1	2	localThrowable2	java.lang.Throwable
    //   47	18	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   30	41	80	java/lang/Throwable
    //   43	48	80	java/lang/Throwable
    //   54	61	80	java/lang/Throwable
    //   63	77	80	java/lang/Throwable
    //   110	122	80	java/lang/Throwable
    //   6	28	134	finally
    //   30	41	149	finally
    //   43	48	149	finally
    //   54	61	149	finally
    //   63	77	149	finally
    //   83	95	149	finally
    //   110	122	149	finally
    //   6	28	153	java/lang/Throwable
  }
  
  /* Error */
  public static String hon()
  {
    // Byte code:
    //   0: sipush 32075
    //   3: invokestatic 12	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 123	java/io/BufferedReader
    //   9: dup
    //   10: new 125	java/io/InputStreamReader
    //   13: dup
    //   14: ldc 167
    //   16: invokestatic 133	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: ldc 135
    //   21: invokespecial 138	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   24: invokespecial 141	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   27: astore_1
    //   28: aload_1
    //   29: astore_0
    //   30: new 66	java/lang/StringBuilder
    //   33: dup
    //   34: sipush 256
    //   37: invokespecial 143	java/lang/StringBuilder:<init>	(I)V
    //   40: astore_2
    //   41: aload_1
    //   42: astore_0
    //   43: aload_1
    //   44: invokevirtual 146	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore_3
    //   48: aload_3
    //   49: ifnull +59 -> 108
    //   52: aload_1
    //   53: astore_0
    //   54: aload_3
    //   55: invokestatic 18	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   58: ifne -17 -> 41
    //   61: aload_1
    //   62: astore_0
    //   63: aload_2
    //   64: aload_3
    //   65: invokestatic 148	com/tencent/mm/bz/c:bsr	(Ljava/lang/String;)Ljava/lang/String;
    //   68: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: bipush 59
    //   73: invokevirtual 151	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: goto -36 -> 41
    //   80: astore_2
    //   81: aload_1
    //   82: astore_0
    //   83: ldc 106
    //   85: aload_2
    //   86: ldc 153
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_1
    //   96: invokestatic 161	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   99: sipush 32075
    //   102: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: ldc 23
    //   107: areturn
    //   108: aload_1
    //   109: astore_0
    //   110: aload_2
    //   111: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: bipush 44
    //   116: bipush 95
    //   118: invokevirtual 164	java/lang/String:replace	(CC)Ljava/lang/String;
    //   121: astore_2
    //   122: aload_1
    //   123: invokestatic 161	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   126: sipush 32075
    //   129: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload_2
    //   133: areturn
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_0
    //   137: aload_0
    //   138: invokestatic 161	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   141: sipush 32075
    //   144: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   147: aload_1
    //   148: athrow
    //   149: astore_1
    //   150: goto -13 -> 137
    //   153: astore_2
    //   154: aconst_null
    //   155: astore_1
    //   156: goto -75 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   29	109	0	localBufferedReader1	java.io.BufferedReader
    //   27	96	1	localBufferedReader2	java.io.BufferedReader
    //   134	14	1	localObject1	Object
    //   149	1	1	localObject2	Object
    //   155	1	1	localObject3	Object
    //   40	24	2	localStringBuilder	java.lang.StringBuilder
    //   80	31	2	localThrowable1	java.lang.Throwable
    //   121	12	2	str1	String
    //   153	1	2	localThrowable2	java.lang.Throwable
    //   47	18	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   30	41	80	java/lang/Throwable
    //   43	48	80	java/lang/Throwable
    //   54	61	80	java/lang/Throwable
    //   63	77	80	java/lang/Throwable
    //   110	122	80	java/lang/Throwable
    //   6	28	134	finally
    //   30	41	149	finally
    //   43	48	149	finally
    //   54	61	149	finally
    //   63	77	149	finally
    //   83	95	149	finally
    //   110	122	149	finally
    //   6	28	153	java/lang/Throwable
  }
  
  public static String hoo()
  {
    AppMethodBeat.i(32076);
    Object localObject1 = "";
    try
    {
      new DisplayMetrics();
      Object localObject2 = MMApplicationContext.getContext().getResources().getDisplayMetrics();
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
        Log.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
    localObject1 = ((String)localObject1).replace(",", "_");
    AppMethodBeat.o(32076);
    return localObject1;
  }
  
  public static String hop()
  {
    AppMethodBeat.i(32078);
    String str2 = "";
    String str1 = str2;
    try
    {
      StatFs localStatFs = new StatFs(b.aSL());
      str1 = str2;
      long l = localStatFs.getBlockSize();
      str1 = str2;
      str2 = "" + "AvailableSizes:" + localStatFs.getAvailableBlocks() * l + ";";
      str1 = str2;
      str2 = str2 + "FreeSizes:" + localStatFs.getFreeBlocks() * l + ";";
      str1 = str2;
      str2 = str2 + "AllSize:" + l * localStatFs.getBlockCount() + ";";
      str1 = str2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
      }
    }
    str1 = str1.replace(",", "_");
    AppMethodBeat.o(32078);
    return str1;
  }
  
  public static String hoq()
  {
    AppMethodBeat.i(32079);
    bh.beI();
    String str = (String)com.tencent.mm.model.c.aHp().b(71, null);
    AppMethodBeat.o(32079);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bz.c
 * JD-Core Version:    0.7.0.1
 */