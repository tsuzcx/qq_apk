package com.tencent.mm.br;

import android.content.Context;
import android.content.res.Resources;
import android.os.StatFs;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.io.File;

public final class c
{
  private static String anj(String paramString)
  {
    AppMethodBeat.i(28269);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(28269);
      return "";
    }
    paramString = paramString.replaceAll(" ", "").trim().replaceAll("kB", "").trim().replaceAll("\\t", "").trim();
    AppMethodBeat.o(28269);
    return paramString;
  }
  
  /* Error */
  public static String dpW()
  {
    // Byte code:
    //   0: sipush 28270
    //   3: invokestatic 12	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 45	java/io/BufferedReader
    //   9: dup
    //   10: new 47	java/io/InputStreamReader
    //   13: dup
    //   14: new 49	java/io/FileInputStream
    //   17: dup
    //   18: ldc 51
    //   20: invokespecial 55	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: ldc 57
    //   25: invokespecial 60	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   28: invokespecial 63	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: new 65	java/lang/StringBuilder
    //   37: dup
    //   38: sipush 256
    //   41: invokespecial 67	java/lang/StringBuilder:<init>	(I)V
    //   44: astore_2
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: invokevirtual 70	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +59 -> 112
    //   56: aload_1
    //   57: astore_0
    //   58: aload_3
    //   59: invokestatic 18	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   62: ifne -17 -> 45
    //   65: aload_1
    //   66: astore_0
    //   67: aload_2
    //   68: aload_3
    //   69: invokestatic 72	com/tencent/mm/br/c:anj	(Ljava/lang/String;)Ljava/lang/String;
    //   72: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: bipush 59
    //   77: invokevirtual 79	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: goto -36 -> 45
    //   84: astore_2
    //   85: aload_1
    //   86: astore_0
    //   87: ldc 81
    //   89: aload_2
    //   90: ldc 83
    //   92: iconst_0
    //   93: anewarray 4	java/lang/Object
    //   96: invokestatic 89	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: aload_1
    //   100: invokestatic 93	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   103: sipush 28270
    //   106: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: ldc 23
    //   111: areturn
    //   112: aload_1
    //   113: astore_0
    //   114: aload_2
    //   115: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: bipush 44
    //   120: bipush 95
    //   122: invokevirtual 100	java/lang/String:replace	(CC)Ljava/lang/String;
    //   125: astore_2
    //   126: aload_1
    //   127: invokestatic 93	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   130: sipush 28270
    //   133: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_2
    //   137: areturn
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_0
    //   141: aload_0
    //   142: invokestatic 93	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   145: sipush 28270
    //   148: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_1
    //   152: athrow
    //   153: astore_1
    //   154: goto -13 -> 141
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_1
    //   160: goto -75 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   33	109	0	localBufferedReader1	java.io.BufferedReader
    //   31	96	1	localBufferedReader2	java.io.BufferedReader
    //   138	14	1	localObject1	Object
    //   153	1	1	localObject2	Object
    //   159	1	1	localObject3	Object
    //   44	24	2	localStringBuilder	java.lang.StringBuilder
    //   84	31	2	localThrowable1	java.lang.Throwable
    //   125	12	2	str1	String
    //   157	1	2	localThrowable2	java.lang.Throwable
    //   51	18	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   34	45	84	java/lang/Throwable
    //   47	52	84	java/lang/Throwable
    //   58	65	84	java/lang/Throwable
    //   67	81	84	java/lang/Throwable
    //   114	126	84	java/lang/Throwable
    //   6	32	138	finally
    //   34	45	153	finally
    //   47	52	153	finally
    //   58	65	153	finally
    //   67	81	153	finally
    //   87	99	153	finally
    //   114	126	153	finally
    //   6	32	157	java/lang/Throwable
  }
  
  /* Error */
  public static String dpX()
  {
    // Byte code:
    //   0: sipush 28271
    //   3: invokestatic 12	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 45	java/io/BufferedReader
    //   9: dup
    //   10: new 47	java/io/InputStreamReader
    //   13: dup
    //   14: new 49	java/io/FileInputStream
    //   17: dup
    //   18: ldc 103
    //   20: invokespecial 55	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   23: ldc 57
    //   25: invokespecial 60	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   28: invokespecial 63	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   31: astore_1
    //   32: aload_1
    //   33: astore_0
    //   34: new 65	java/lang/StringBuilder
    //   37: dup
    //   38: sipush 256
    //   41: invokespecial 67	java/lang/StringBuilder:<init>	(I)V
    //   44: astore_2
    //   45: aload_1
    //   46: astore_0
    //   47: aload_1
    //   48: invokevirtual 70	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   51: astore_3
    //   52: aload_3
    //   53: ifnull +59 -> 112
    //   56: aload_1
    //   57: astore_0
    //   58: aload_3
    //   59: invokestatic 18	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   62: ifne -17 -> 45
    //   65: aload_1
    //   66: astore_0
    //   67: aload_2
    //   68: aload_3
    //   69: invokestatic 72	com/tencent/mm/br/c:anj	(Ljava/lang/String;)Ljava/lang/String;
    //   72: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: bipush 59
    //   77: invokevirtual 79	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: goto -36 -> 45
    //   84: astore_2
    //   85: aload_1
    //   86: astore_0
    //   87: ldc 81
    //   89: aload_2
    //   90: ldc 83
    //   92: iconst_0
    //   93: anewarray 4	java/lang/Object
    //   96: invokestatic 89	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: aload_1
    //   100: invokestatic 93	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   103: sipush 28271
    //   106: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: ldc 23
    //   111: areturn
    //   112: aload_1
    //   113: astore_0
    //   114: aload_2
    //   115: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: bipush 44
    //   120: bipush 95
    //   122: invokevirtual 100	java/lang/String:replace	(CC)Ljava/lang/String;
    //   125: astore_2
    //   126: aload_1
    //   127: invokestatic 93	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   130: sipush 28271
    //   133: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   136: aload_2
    //   137: areturn
    //   138: astore_1
    //   139: aconst_null
    //   140: astore_0
    //   141: aload_0
    //   142: invokestatic 93	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   145: sipush 28271
    //   148: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_1
    //   152: athrow
    //   153: astore_1
    //   154: goto -13 -> 141
    //   157: astore_2
    //   158: aconst_null
    //   159: astore_1
    //   160: goto -75 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   33	109	0	localBufferedReader1	java.io.BufferedReader
    //   31	96	1	localBufferedReader2	java.io.BufferedReader
    //   138	14	1	localObject1	Object
    //   153	1	1	localObject2	Object
    //   159	1	1	localObject3	Object
    //   44	24	2	localStringBuilder	java.lang.StringBuilder
    //   84	31	2	localThrowable1	java.lang.Throwable
    //   125	12	2	str1	String
    //   157	1	2	localThrowable2	java.lang.Throwable
    //   51	18	3	str2	String
    // Exception table:
    //   from	to	target	type
    //   34	45	84	java/lang/Throwable
    //   47	52	84	java/lang/Throwable
    //   58	65	84	java/lang/Throwable
    //   67	81	84	java/lang/Throwable
    //   114	126	84	java/lang/Throwable
    //   6	32	138	finally
    //   34	45	153	finally
    //   47	52	153	finally
    //   58	65	153	finally
    //   67	81	153	finally
    //   87	99	153	finally
    //   114	126	153	finally
    //   6	32	157	java/lang/Throwable
  }
  
  public static String dpY()
  {
    AppMethodBeat.i(28272);
    Object localObject1 = "";
    try
    {
      new DisplayMetrics();
      Object localObject2 = ah.getContext().getResources().getDisplayMetrics();
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
        ab.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[] { bo.l(localException) });
      }
    }
    localObject1 = ((String)localObject1).replace(",", "_");
    AppMethodBeat.o(28272);
    return localObject1;
  }
  
  public static String dpZ()
  {
    AppMethodBeat.i(28274);
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
        ab.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[] { bo.l(localException) });
      }
    }
    str1 = str1.replace(",", "_");
    AppMethodBeat.o(28274);
    return str1;
  }
  
  public static String dqa()
  {
    AppMethodBeat.i(28275);
    aw.aaz();
    String str = (String)com.tencent.mm.model.c.Ru().get(71, null);
    AppMethodBeat.o(28275);
    return str;
  }
  
  public static String getRomInfo()
  {
    AppMethodBeat.i(28273);
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
        ab.e("MicroMsg.PostTaskHardwareInfo", "exception:%s", new Object[] { bo.l(localException) });
      }
    }
    str1 = str1.replace(",", "_");
    AppMethodBeat.o(28273);
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.br.c
 * JD-Core Version:    0.7.0.1
 */