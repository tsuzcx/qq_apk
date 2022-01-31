package com.tencent.mm.plugin.appbrand.p;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.r;
import java.io.File;
import java.util.Properties;

public final class d
{
  public static final d iJl;
  
  static
  {
    AppMethodBeat.i(132728);
    iJl = new d();
    AppMethodBeat.o(132728);
  }
  
  public static Properties J(File paramFile)
  {
    AppMethodBeat.i(132727);
    paramFile = r.J(paramFile);
    AppMethodBeat.o(132727);
    return paramFile;
  }
  
  public static String aLw()
  {
    AppMethodBeat.i(132725);
    String str = r.aLw();
    AppMethodBeat.o(132725);
    return str;
  }
  
  public static int aLx()
  {
    AppMethodBeat.i(132726);
    int i = r.aLx();
    AppMethodBeat.o(132726);
    return i;
  }
  
  /* Error */
  public static boolean cR(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 49
    //   4: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 55	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   10: invokevirtual 61	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: astore 4
    //   15: aload 4
    //   17: aload_1
    //   18: invokevirtual 67	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   21: astore_1
    //   22: aload_1
    //   23: ifnonnull +35 -> 58
    //   26: ldc 69
    //   28: ldc 71
    //   30: invokestatic 77	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: ldc 49
    //   35: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: iconst_0
    //   39: ireturn
    //   40: astore_1
    //   41: ldc 69
    //   43: aload_1
    //   44: ldc 79
    //   46: iconst_0
    //   47: anewarray 4	java/lang/Object
    //   50: invokestatic 83	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   53: aconst_null
    //   54: astore_1
    //   55: goto -33 -> 22
    //   58: new 85	java/io/File
    //   61: dup
    //   62: aload_0
    //   63: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore_0
    //   67: aload_0
    //   68: invokevirtual 92	java/io/File:exists	()Z
    //   71: ifeq +8 -> 79
    //   74: aload_0
    //   75: invokevirtual 95	java/io/File:delete	()Z
    //   78: pop
    //   79: aload_0
    //   80: invokevirtual 99	java/io/File:getParentFile	()Ljava/io/File;
    //   83: invokevirtual 102	java/io/File:mkdirs	()Z
    //   86: pop
    //   87: new 104	java/io/FileOutputStream
    //   90: dup
    //   91: aload_0
    //   92: invokespecial 107	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   95: astore_0
    //   96: aload_0
    //   97: ifnull +107 -> 204
    //   100: sipush 1024
    //   103: newarray byte
    //   105: astore_3
    //   106: aload_1
    //   107: aload_3
    //   108: invokevirtual 113	java/io/InputStream:read	([B)I
    //   111: istore_2
    //   112: iload_2
    //   113: iconst_m1
    //   114: if_icmpeq +59 -> 173
    //   117: aload_0
    //   118: aload_3
    //   119: iconst_0
    //   120: iload_2
    //   121: invokevirtual 119	java/io/OutputStream:write	([BII)V
    //   124: goto -18 -> 106
    //   127: astore_3
    //   128: ldc 69
    //   130: aload_3
    //   131: ldc 79
    //   133: iconst_0
    //   134: anewarray 4	java/lang/Object
    //   137: invokestatic 83	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload_1
    //   141: invokestatic 125	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   144: aload_0
    //   145: invokestatic 129	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   148: ldc 49
    //   150: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   153: iconst_0
    //   154: ireturn
    //   155: astore_0
    //   156: ldc 69
    //   158: aload_0
    //   159: ldc 79
    //   161: iconst_0
    //   162: anewarray 4	java/lang/Object
    //   165: invokestatic 83	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   168: aload_3
    //   169: astore_0
    //   170: goto -74 -> 96
    //   173: aload_1
    //   174: invokestatic 125	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   177: aload_0
    //   178: invokestatic 129	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   181: ldc 49
    //   183: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: iconst_1
    //   187: ireturn
    //   188: astore_3
    //   189: aload_1
    //   190: invokestatic 125	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   193: aload_0
    //   194: invokestatic 129	com/tencent/mm/a/e:closeOutputStream	(Ljava/io/OutputStream;)V
    //   197: ldc 49
    //   199: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_3
    //   203: athrow
    //   204: aload_1
    //   205: invokestatic 125	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   208: ldc 49
    //   210: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   213: iconst_0
    //   214: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramString1	String
    //   0	215	1	paramString2	String
    //   111	10	2	i	int
    //   1	118	3	arrayOfByte	byte[]
    //   127	42	3	localIOException	java.io.IOException
    //   188	15	3	localObject	Object
    //   13	3	4	localAssetManager	android.content.res.AssetManager
    // Exception table:
    //   from	to	target	type
    //   15	22	40	java/io/IOException
    //   100	106	127	java/io/IOException
    //   106	112	127	java/io/IOException
    //   117	124	127	java/io/IOException
    //   87	96	155	java/io/FileNotFoundException
    //   100	106	188	finally
    //   106	112	188	finally
    //   117	124	188	finally
    //   128	140	188	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.p.d
 * JD-Core Version:    0.7.0.1
 */