package com.tencent.mm.plugin.hp.d;

import android.util.Base64;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  public static boolean Ft(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bk.bl(paramString))
    {
      bool1 = bool2;
      if (paramString.length() != 10) {}
    }
    try
    {
      int i = Integer.decode(paramString).intValue();
      bool1 = bool2;
      if ((i & 0xFF) >= 0)
      {
        bool1 = bool2;
        if ((i & 0xFF) <= 31) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("Tinker.TinkerUtils", paramString, "checkAplhVersion failed.", new Object[0]);
    }
    return false;
  }
  
  public static String Fu(String paramString)
  {
    if (!bk.bl(paramString)) {
      return new String(Base64.decode(paramString, 0));
    }
    return "";
  }
  
  /* Error */
  public static java.util.Properties K(java.io.File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 64	java/io/File:isFile	()Z
    //   4: ifeq +12 -> 16
    //   7: aload_0
    //   8: invokevirtual 67	java/io/File:length	()J
    //   11: lconst_0
    //   12: lcmp
    //   13: ifne +5 -> 18
    //   16: aconst_null
    //   17: areturn
    //   18: new 69	java/util/zip/ZipFile
    //   21: dup
    //   22: aload_0
    //   23: invokespecial 72	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   26: astore_1
    //   27: aload_1
    //   28: ldc 74
    //   30: invokevirtual 78	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   33: astore_0
    //   34: aload_0
    //   35: ifnonnull +9 -> 44
    //   38: aload_1
    //   39: invokestatic 84	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   42: aconst_null
    //   43: areturn
    //   44: aload_1
    //   45: aload_0
    //   46: invokevirtual 88	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   49: astore_0
    //   50: new 90	java/util/Properties
    //   53: dup
    //   54: invokespecial 93	java/util/Properties:<init>	()V
    //   57: astore_2
    //   58: aload_2
    //   59: aload_0
    //   60: invokevirtual 97	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   63: aload_0
    //   64: invokestatic 101	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:S	(Ljava/lang/Object;)V
    //   67: aload_1
    //   68: invokestatic 84	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   71: aload_2
    //   72: areturn
    //   73: astore_2
    //   74: aconst_null
    //   75: astore_0
    //   76: aload_0
    //   77: invokestatic 101	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:S	(Ljava/lang/Object;)V
    //   80: aload_2
    //   81: athrow
    //   82: astore_2
    //   83: aload_1
    //   84: astore_0
    //   85: aload_2
    //   86: astore_1
    //   87: new 103	java/lang/StringBuilder
    //   90: dup
    //   91: ldc 105
    //   93: invokespecial 108	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: aload_1
    //   97: invokevirtual 112	java/io/IOException:getMessage	()Ljava/lang/String;
    //   100: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: pop
    //   104: aload_0
    //   105: invokestatic 84	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   108: aconst_null
    //   109: areturn
    //   110: astore_0
    //   111: aconst_null
    //   112: astore_1
    //   113: aload_1
    //   114: invokestatic 84	com/tencent/tinker/loader/shareutil/SharePatchFileUtil:a	(Ljava/util/zip/ZipFile;)V
    //   117: aload_0
    //   118: athrow
    //   119: astore_0
    //   120: goto -7 -> 113
    //   123: astore_1
    //   124: aload_0
    //   125: astore_2
    //   126: aload_1
    //   127: astore_0
    //   128: aload_2
    //   129: astore_1
    //   130: goto -17 -> 113
    //   133: astore_1
    //   134: aconst_null
    //   135: astore_0
    //   136: goto -49 -> 87
    //   139: astore_2
    //   140: goto -64 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramFile	java.io.File
    //   26	88	1	localObject1	Object
    //   123	4	1	localObject2	Object
    //   129	1	1	localObject3	Object
    //   133	1	1	localIOException1	java.io.IOException
    //   57	15	2	localProperties	java.util.Properties
    //   73	8	2	localObject4	Object
    //   82	4	2	localIOException2	java.io.IOException
    //   125	4	2	localFile	java.io.File
    //   139	1	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   44	50	73	finally
    //   27	34	82	java/io/IOException
    //   63	67	82	java/io/IOException
    //   76	82	82	java/io/IOException
    //   18	27	110	finally
    //   27	34	119	finally
    //   63	67	119	finally
    //   76	82	119	finally
    //   87	104	123	finally
    //   18	27	133	java/io/IOException
    //   50	63	139	finally
  }
  
  /* Error */
  @java.lang.Deprecated
  public static boolean bbr()
  {
    // Byte code:
    //   0: new 120	android/os/StatFs
    //   3: dup
    //   4: invokestatic 126	android/os/Environment:getDataDirectory	()Ljava/io/File;
    //   7: invokevirtual 129	java/io/File:getPath	()Ljava/lang/String;
    //   10: invokespecial 130	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   13: astore 5
    //   15: aload 5
    //   17: invokevirtual 133	android/os/StatFs:getAvailableBlocks	()I
    //   20: i2l
    //   21: lstore_1
    //   22: aload 5
    //   24: invokevirtual 136	android/os/StatFs:getBlockSize	()I
    //   27: istore_0
    //   28: lload_1
    //   29: iload_0
    //   30: i2l
    //   31: lmul
    //   32: lstore_1
    //   33: aload 5
    //   35: invokevirtual 139	android/os/StatFs:getBlockCount	()I
    //   38: i2l
    //   39: lstore_3
    //   40: aload 5
    //   42: invokevirtual 136	android/os/StatFs:getBlockSize	()I
    //   45: istore_0
    //   46: iload_0
    //   47: i2l
    //   48: lload_3
    //   49: lmul
    //   50: lstore_3
    //   51: lload_3
    //   52: lconst_0
    //   53: lcmp
    //   54: ifeq +22 -> 76
    //   57: lload_1
    //   58: ldc2_w 140
    //   61: lcmp
    //   62: ifle +14 -> 76
    //   65: iconst_1
    //   66: ireturn
    //   67: astore 5
    //   69: lconst_0
    //   70: lstore_1
    //   71: lconst_0
    //   72: lstore_3
    //   73: goto -22 -> 51
    //   76: iconst_0
    //   77: ireturn
    //   78: astore 5
    //   80: goto -9 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   27	20	0	i	int
    //   21	50	1	l1	long
    //   39	34	3	l2	long
    //   13	28	5	localStatFs	android.os.StatFs
    //   67	1	5	localException1	Exception
    //   78	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	28	67	java/lang/Exception
    //   33	46	78	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.d.c
 * JD-Core Version:    0.7.0.1
 */