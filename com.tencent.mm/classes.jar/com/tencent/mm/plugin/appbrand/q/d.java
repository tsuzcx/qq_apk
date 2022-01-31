package com.tencent.mm.plugin.appbrand.q;

import com.tencent.mm.plugin.appbrand.u.r;
import java.io.File;
import java.util.Properties;

public final class d
{
  public static final d haJ = new d();
  
  public static Properties A(File paramFile)
  {
    return r.A(paramFile);
  }
  
  public static String aoA()
  {
    return r.aoA();
  }
  
  public static int aoB()
  {
    return r.aoB();
  }
  
  /* Error */
  public static boolean cb(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 41	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   5: invokevirtual 47	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   8: astore 4
    //   10: aload 4
    //   12: aload_1
    //   13: invokevirtual 53	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   16: astore_1
    //   17: aload_1
    //   18: ifnonnull +30 -> 48
    //   21: ldc 55
    //   23: ldc 57
    //   25: invokestatic 63	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: iconst_0
    //   29: ireturn
    //   30: astore_1
    //   31: ldc 55
    //   33: aload_1
    //   34: ldc 65
    //   36: iconst_0
    //   37: anewarray 4	java/lang/Object
    //   40: invokestatic 69	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   43: aconst_null
    //   44: astore_1
    //   45: goto -28 -> 17
    //   48: new 71	java/io/File
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 74	java/io/File:<init>	(Ljava/lang/String;)V
    //   56: astore_0
    //   57: aload_0
    //   58: invokevirtual 78	java/io/File:exists	()Z
    //   61: ifeq +8 -> 69
    //   64: aload_0
    //   65: invokevirtual 81	java/io/File:delete	()Z
    //   68: pop
    //   69: aload_0
    //   70: invokevirtual 85	java/io/File:getParentFile	()Ljava/io/File;
    //   73: invokevirtual 88	java/io/File:mkdirs	()Z
    //   76: pop
    //   77: new 90	java/io/FileOutputStream
    //   80: dup
    //   81: aload_0
    //   82: invokespecial 93	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   85: astore_0
    //   86: aload_0
    //   87: ifnull +92 -> 179
    //   90: sipush 1024
    //   93: newarray byte
    //   95: astore_3
    //   96: aload_1
    //   97: aload_3
    //   98: invokevirtual 99	java/io/InputStream:read	([B)I
    //   101: istore_2
    //   102: iload_2
    //   103: iconst_m1
    //   104: if_icmpeq +54 -> 158
    //   107: aload_0
    //   108: aload_3
    //   109: iconst_0
    //   110: iload_2
    //   111: invokevirtual 105	java/io/OutputStream:write	([BII)V
    //   114: goto -18 -> 96
    //   117: astore_3
    //   118: ldc 55
    //   120: aload_3
    //   121: ldc 65
    //   123: iconst_0
    //   124: anewarray 4	java/lang/Object
    //   127: invokestatic 69	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: aload_1
    //   131: invokestatic 111	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   134: aload_0
    //   135: invokestatic 115	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   138: iconst_0
    //   139: ireturn
    //   140: astore_0
    //   141: ldc 55
    //   143: aload_0
    //   144: ldc 65
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 69	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_3
    //   154: astore_0
    //   155: goto -69 -> 86
    //   158: aload_1
    //   159: invokestatic 111	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   162: aload_0
    //   163: invokestatic 115	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   166: iconst_1
    //   167: ireturn
    //   168: astore_3
    //   169: aload_1
    //   170: invokestatic 111	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   173: aload_0
    //   174: invokestatic 115	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   177: aload_3
    //   178: athrow
    //   179: aload_1
    //   180: invokestatic 111	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   183: iconst_0
    //   184: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramString1	String
    //   0	185	1	paramString2	String
    //   101	10	2	i	int
    //   1	108	3	arrayOfByte	byte[]
    //   117	37	3	localIOException	java.io.IOException
    //   168	10	3	localObject	Object
    //   8	3	4	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   10	17	30	java/io/IOException
    //   90	96	117	java/io/IOException
    //   96	102	117	java/io/IOException
    //   107	114	117	java/io/IOException
    //   77	86	140	java/io/FileNotFoundException
    //   90	96	168	finally
    //   96	102	168	finally
    //   107	114	168	finally
    //   118	130	168	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.q.d
 * JD-Core Version:    0.7.0.1
 */