package com.tencent.mm.plugin.hp.d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static boolean aBK(String paramString)
  {
    AppMethodBeat.i(117523);
    if ((!Util.isNullOrNil(paramString)) && (paramString.length() == 10)) {
      try
      {
        int i = Integer.decode(paramString).intValue();
        if (((i & 0xFF) >= 0) && ((i & 0xFF) <= 31))
        {
          AppMethodBeat.o(117523);
          return true;
        }
        AppMethodBeat.o(117523);
        return false;
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("Tinker.TinkerUtils", paramString, "checkAplhVersion failed.", new Object[0]);
      }
    }
    AppMethodBeat.o(117523);
    return false;
  }
  
  public static String aBL(String paramString)
  {
    AppMethodBeat.i(117524);
    if (!Util.isNullOrNil(paramString))
    {
      paramString = new String(Base64.decode(paramString, 0));
      AppMethodBeat.o(117524);
      return paramString;
    }
    AppMethodBeat.o(117524);
    return "";
  }
  
  /* Error */
  @java.lang.Deprecated
  public static boolean dZz()
  {
    // Byte code:
    //   0: ldc 69
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 71	android/os/StatFs
    //   8: dup
    //   9: invokestatic 77	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   12: invokevirtual 83	java/io/File:getPath	()Ljava/lang/String;
    //   15: invokespecial 86	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   18: astore 5
    //   20: aload 5
    //   22: invokevirtual 89	android/os/StatFs:getAvailableBlocks	()I
    //   25: i2l
    //   26: lstore_1
    //   27: aload 5
    //   29: invokevirtual 92	android/os/StatFs:getBlockSize	()I
    //   32: istore_0
    //   33: lload_1
    //   34: iload_0
    //   35: i2l
    //   36: lmul
    //   37: lstore_1
    //   38: aload 5
    //   40: invokevirtual 95	android/os/StatFs:getBlockCount	()I
    //   43: i2l
    //   44: lstore_3
    //   45: aload 5
    //   47: invokevirtual 92	android/os/StatFs:getBlockSize	()I
    //   50: istore_0
    //   51: iload_0
    //   52: i2l
    //   53: lload_3
    //   54: lmul
    //   55: lstore_3
    //   56: lload_3
    //   57: lconst_0
    //   58: lcmp
    //   59: ifeq +27 -> 86
    //   62: lload_1
    //   63: ldc2_w 96
    //   66: lcmp
    //   67: ifle +19 -> 86
    //   70: ldc 69
    //   72: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: iconst_1
    //   76: ireturn
    //   77: astore 5
    //   79: lconst_0
    //   80: lstore_1
    //   81: lconst_0
    //   82: lstore_3
    //   83: goto -27 -> 56
    //   86: ldc 69
    //   88: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: iconst_0
    //   92: ireturn
    //   93: astore 5
    //   95: goto -14 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	20	0	i	int
    //   26	55	1	l1	long
    //   44	39	3	l2	long
    //   18	28	5	localStatFs	android.os.StatFs
    //   77	1	5	localException1	Exception
    //   93	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   5	33	77	java/lang/Exception
    //   38	51	93	java/lang/Exception
  }
  
  /* Error */
  public static java.util.Properties fastGetPatchPackageMeta(java.io.File paramFile)
  {
    // Byte code:
    //   0: ldc 103
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 106	java/io/File:isFile	()Z
    //   9: ifeq +12 -> 21
    //   12: aload_0
    //   13: invokevirtual 109	java/io/File:length	()J
    //   16: lconst_0
    //   17: lcmp
    //   18: ifne +10 -> 28
    //   21: ldc 103
    //   23: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   26: aconst_null
    //   27: areturn
    //   28: new 111	java/util/zip/ZipFile
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 114	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   36: astore_1
    //   37: aload_1
    //   38: ldc 116
    //   40: invokevirtual 120	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   43: astore_0
    //   44: aload_0
    //   45: ifnonnull +14 -> 59
    //   48: aload_1
    //   49: invokestatic 126	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   52: ldc 103
    //   54: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: aconst_null
    //   58: areturn
    //   59: aload_1
    //   60: aload_0
    //   61: invokevirtual 130	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   64: astore_0
    //   65: new 132	java/util/Properties
    //   68: dup
    //   69: invokespecial 135	java/util/Properties:<init>	()V
    //   72: astore_2
    //   73: aload_2
    //   74: aload_0
    //   75: invokevirtual 139	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   78: aload_0
    //   79: invokestatic 143	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   82: aload_1
    //   83: invokestatic 126	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   86: ldc 103
    //   88: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_2
    //   92: areturn
    //   93: astore_2
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: invokestatic 143	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeQuietly	(Ljava/lang/Object;)V
    //   100: ldc 103
    //   102: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_2
    //   106: athrow
    //   107: astore_2
    //   108: aload_1
    //   109: astore_0
    //   110: aload_2
    //   111: astore_1
    //   112: new 145	java/lang/StringBuilder
    //   115: dup
    //   116: ldc 147
    //   118: invokespecial 148	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   121: aload_1
    //   122: invokevirtual 151	java/io/IOException:getMessage	()Ljava/lang/String;
    //   125: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload_0
    //   130: invokestatic 126	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   133: ldc 103
    //   135: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aconst_null
    //   139: areturn
    //   140: astore_0
    //   141: aconst_null
    //   142: astore_1
    //   143: aload_1
    //   144: invokestatic 126	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:closeZip	(Ljava/util/zip/ZipFile;)V
    //   147: ldc 103
    //   149: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   152: aload_0
    //   153: athrow
    //   154: astore_0
    //   155: goto -12 -> 143
    //   158: astore_1
    //   159: aload_0
    //   160: astore_2
    //   161: aload_1
    //   162: astore_0
    //   163: aload_2
    //   164: astore_1
    //   165: goto -22 -> 143
    //   168: astore_1
    //   169: aconst_null
    //   170: astore_0
    //   171: goto -59 -> 112
    //   174: astore_2
    //   175: goto -79 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	paramFile	java.io.File
    //   36	108	1	localObject1	Object
    //   158	4	1	localObject2	Object
    //   164	1	1	localObject3	Object
    //   168	1	1	localIOException1	java.io.IOException
    //   72	20	2	localProperties	java.util.Properties
    //   93	13	2	localObject4	Object
    //   107	4	2	localIOException2	java.io.IOException
    //   160	4	2	localFile	java.io.File
    //   174	1	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   59	65	93	finally
    //   37	44	107	java/io/IOException
    //   78	82	107	java/io/IOException
    //   96	107	107	java/io/IOException
    //   28	37	140	finally
    //   37	44	154	finally
    //   78	82	154	finally
    //   96	107	154	finally
    //   112	129	158	finally
    //   28	37	168	java/io/IOException
    //   65	78	174	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.d.c
 * JD-Core Version:    0.7.0.1
 */