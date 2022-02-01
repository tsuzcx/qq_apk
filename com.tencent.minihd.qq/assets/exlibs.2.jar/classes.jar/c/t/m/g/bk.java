package c.t.m.g;

import android.content.Context;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class bk
  extends be
{
  private final Context a;
  
  public bk(Context paramContext, String paramString)
  {
    super(paramString, "load libtencentloc.so myself");
    this.a = paramContext;
  }
  
  private static void a(InputStream paramInputStream, BufferedOutputStream paramBufferedOutputStream)
    throws IOException
  {
    if ((paramInputStream == null) || (paramBufferedOutputStream == null)) {
      return;
    }
    byte[] arrayOfByte = new byte[4096];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramBufferedOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  /* Error */
  protected final java.lang.Object b(android.os.Bundle paramBundle)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: new 38	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: getfield 15	c/t/m/g/bk:a	Landroid/content/Context;
    //   10: invokevirtual 44	android/content/Context:getFilesDir	()Ljava/io/File;
    //   13: ldc 46
    //   15: invokespecial 49	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   18: astore 9
    //   20: aload 9
    //   22: invokevirtual 53	java/io/File:exists	()Z
    //   25: ifeq +139 -> 164
    //   28: aload 9
    //   30: invokevirtual 57	java/io/File:length	()J
    //   33: lconst_0
    //   34: lcmp
    //   35: ifle +129 -> 164
    //   38: iload_2
    //   39: ifne +74 -> 113
    //   42: aload 9
    //   44: invokevirtual 60	java/io/File:delete	()Z
    //   47: pop
    //   48: new 38	java/io/File
    //   51: dup
    //   52: aload_0
    //   53: getfield 15	c/t/m/g/bk:a	Landroid/content/Context;
    //   56: invokevirtual 44	android/content/Context:getFilesDir	()Ljava/io/File;
    //   59: ldc 46
    //   61: invokespecial 49	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 15	c/t/m/g/bk:a	Landroid/content/Context;
    //   69: invokevirtual 64	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   72: ldc 66
    //   74: invokevirtual 72	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   77: astore_3
    //   78: new 27	java/io/BufferedOutputStream
    //   81: dup
    //   82: new 74	java/io/FileOutputStream
    //   85: dup
    //   86: aload_1
    //   87: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   90: invokespecial 80	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   93: astore_1
    //   94: aload_1
    //   95: astore 6
    //   97: aload_3
    //   98: astore 7
    //   100: aload_3
    //   101: aload_1
    //   102: invokestatic 82	c/t/m/g/bk:a	(Ljava/io/InputStream;Ljava/io/BufferedOutputStream;)V
    //   105: aload_1
    //   106: invokestatic 87	c/t/m/g/b$a:a	(Ljava/io/Closeable;)V
    //   109: aload_3
    //   110: invokestatic 87	c/t/m/g/b$a:a	(Ljava/io/Closeable;)V
    //   113: ldc 89
    //   115: new 91	java/lang/StringBuilder
    //   118: dup
    //   119: ldc 93
    //   121: invokespecial 96	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   124: aload 9
    //   126: invokevirtual 100	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   129: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: ldc 106
    //   134: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: aload 9
    //   139: invokevirtual 57	java/io/File:length	()J
    //   142: invokevirtual 109	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   145: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 116	c/t/m/g/cj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload 9
    //   153: invokevirtual 100	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   156: invokestatic 121	java/lang/System:load	(Ljava/lang/String;)V
    //   159: iconst_1
    //   160: invokestatic 127	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   163: areturn
    //   164: iconst_0
    //   165: istore_2
    //   166: goto -128 -> 38
    //   169: astore 4
    //   171: aconst_null
    //   172: astore_1
    //   173: aconst_null
    //   174: astore 5
    //   176: aload_1
    //   177: astore 6
    //   179: aload 5
    //   181: astore 7
    //   183: ldc 89
    //   185: ldc 129
    //   187: aload 4
    //   189: invokestatic 132	c/t/m/g/cj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   192: aload_1
    //   193: astore 6
    //   195: aload 5
    //   197: astore 7
    //   199: new 38	java/io/File
    //   202: dup
    //   203: aload_0
    //   204: getfield 15	c/t/m/g/bk:a	Landroid/content/Context;
    //   207: invokevirtual 44	android/content/Context:getFilesDir	()Ljava/io/File;
    //   210: ldc 46
    //   212: invokespecial 49	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   215: astore 4
    //   217: aload_0
    //   218: invokevirtual 138	java/lang/Object:getClass	()Ljava/lang/Class;
    //   221: ldc 140
    //   223: invokevirtual 145	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   226: astore_3
    //   227: new 27	java/io/BufferedOutputStream
    //   230: dup
    //   231: new 74	java/io/FileOutputStream
    //   234: dup
    //   235: aload 4
    //   237: invokespecial 77	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   240: invokespecial 80	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   243: astore 4
    //   245: aload 4
    //   247: astore 7
    //   249: aload_3
    //   250: astore 6
    //   252: aload_3
    //   253: aload 4
    //   255: invokestatic 82	c/t/m/g/bk:a	(Ljava/io/InputStream;Ljava/io/BufferedOutputStream;)V
    //   258: aload_1
    //   259: astore 6
    //   261: aload 5
    //   263: astore 7
    //   265: aload 4
    //   267: invokestatic 87	c/t/m/g/b$a:a	(Ljava/io/Closeable;)V
    //   270: aload_1
    //   271: astore 6
    //   273: aload 5
    //   275: astore 7
    //   277: aload_3
    //   278: invokestatic 87	c/t/m/g/b$a:a	(Ljava/io/Closeable;)V
    //   281: aload_1
    //   282: invokestatic 87	c/t/m/g/b$a:a	(Ljava/io/Closeable;)V
    //   285: aload 5
    //   287: invokestatic 87	c/t/m/g/b$a:a	(Ljava/io/Closeable;)V
    //   290: goto -177 -> 113
    //   293: astore 8
    //   295: aconst_null
    //   296: astore 4
    //   298: aconst_null
    //   299: astore_3
    //   300: aload 4
    //   302: astore 7
    //   304: aload_3
    //   305: astore 6
    //   307: ldc 89
    //   309: ldc 147
    //   311: aload 8
    //   313: invokestatic 132	c/t/m/g/cj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   316: aload_1
    //   317: astore 6
    //   319: aload 5
    //   321: astore 7
    //   323: aload 4
    //   325: invokestatic 87	c/t/m/g/b$a:a	(Ljava/io/Closeable;)V
    //   328: aload_1
    //   329: astore 6
    //   331: aload 5
    //   333: astore 7
    //   335: aload_3
    //   336: invokestatic 87	c/t/m/g/b$a:a	(Ljava/io/Closeable;)V
    //   339: goto -58 -> 281
    //   342: astore_1
    //   343: aload 7
    //   345: astore_3
    //   346: aload 6
    //   348: invokestatic 87	c/t/m/g/b$a:a	(Ljava/io/Closeable;)V
    //   351: aload_3
    //   352: invokestatic 87	c/t/m/g/b$a:a	(Ljava/io/Closeable;)V
    //   355: aload_1
    //   356: athrow
    //   357: astore 4
    //   359: aconst_null
    //   360: astore 8
    //   362: aconst_null
    //   363: astore_3
    //   364: aload_1
    //   365: astore 6
    //   367: aload 5
    //   369: astore 7
    //   371: aload 8
    //   373: invokestatic 87	c/t/m/g/b$a:a	(Ljava/io/Closeable;)V
    //   376: aload_1
    //   377: astore 6
    //   379: aload 5
    //   381: astore 7
    //   383: aload_3
    //   384: invokestatic 87	c/t/m/g/b$a:a	(Ljava/io/Closeable;)V
    //   387: aload_1
    //   388: astore 6
    //   390: aload 5
    //   392: astore 7
    //   394: aload 4
    //   396: athrow
    //   397: astore_1
    //   398: ldc 89
    //   400: ldc 149
    //   402: aload_1
    //   403: invokestatic 132	c/t/m/g/cj:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   406: aconst_null
    //   407: areturn
    //   408: astore_1
    //   409: aconst_null
    //   410: astore 6
    //   412: aconst_null
    //   413: astore_3
    //   414: goto -68 -> 346
    //   417: astore_1
    //   418: aconst_null
    //   419: astore 6
    //   421: goto -75 -> 346
    //   424: astore 4
    //   426: aconst_null
    //   427: astore 8
    //   429: goto -65 -> 364
    //   432: astore 4
    //   434: aload 7
    //   436: astore 8
    //   438: aload 6
    //   440: astore_3
    //   441: goto -77 -> 364
    //   444: astore 8
    //   446: aconst_null
    //   447: astore 4
    //   449: goto -149 -> 300
    //   452: astore 8
    //   454: goto -154 -> 300
    //   457: astore 4
    //   459: aconst_null
    //   460: astore_1
    //   461: aload_3
    //   462: astore 5
    //   464: goto -288 -> 176
    //   467: astore 4
    //   469: aload_3
    //   470: astore 5
    //   472: goto -296 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	this	bk
    //   0	475	1	paramBundle	android.os.Bundle
    //   1	165	2	i	int
    //   77	393	3	localObject1	java.lang.Object
    //   169	19	4	localIOException1	IOException
    //   215	109	4	localObject2	java.lang.Object
    //   357	38	4	localObject3	java.lang.Object
    //   424	1	4	localObject4	java.lang.Object
    //   432	1	4	localObject5	java.lang.Object
    //   447	1	4	localObject6	java.lang.Object
    //   457	1	4	localIOException2	IOException
    //   467	1	4	localIOException3	IOException
    //   174	297	5	localObject7	java.lang.Object
    //   95	344	6	localObject8	java.lang.Object
    //   98	337	7	localObject9	java.lang.Object
    //   293	19	8	localIOException4	IOException
    //   360	77	8	localObject10	java.lang.Object
    //   444	1	8	localIOException5	IOException
    //   452	1	8	localIOException6	IOException
    //   18	134	9	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   65	78	169	java/io/IOException
    //   217	227	293	java/io/IOException
    //   100	105	342	finally
    //   183	192	342	finally
    //   199	217	342	finally
    //   265	270	342	finally
    //   277	281	342	finally
    //   323	328	342	finally
    //   335	339	342	finally
    //   371	376	342	finally
    //   383	387	342	finally
    //   394	397	342	finally
    //   217	227	357	finally
    //   151	159	397	java/lang/Error
    //   65	78	408	finally
    //   78	94	417	finally
    //   227	245	424	finally
    //   252	258	432	finally
    //   307	316	432	finally
    //   227	245	444	java/io/IOException
    //   252	258	452	java/io/IOException
    //   78	94	457	java/io/IOException
    //   100	105	467	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     c.t.m.g.bk
 * JD-Core Version:    0.7.0.1
 */