package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.aa;
import com.tencent.mm.loader.i.a;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public final class i
{
  private static final File JEG;
  private static int JEH;
  private static int JEI;
  private static boolean sInitialized;
  
  static
  {
    AppMethodBeat.i(117512);
    JEG = new File(b.bmr(), "patch_ver_history.bin");
    sInitialized = false;
    JEH = 0;
    JEI = 0;
    AppMethodBeat.o(117512);
  }
  
  private static int fQg()
  {
    AppMethodBeat.i(117509);
    int i = Integer.decode(a.CLIENT_VERSION).intValue();
    AppMethodBeat.o(117509);
    return i;
  }
  
  /* Error */
  public static void fQh()
  {
    // Byte code:
    //   0: ldc 68
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 74	com/tencent/mm/kernel/h:baB	()Lcom/tencent/mm/kernel/e;
    //   8: invokevirtual 80	com/tencent/mm/kernel/e:bad	()Lcom/tencent/mm/kernel/b/g;
    //   11: checkcast 82	com/tencent/mm/kernel/b/h
    //   14: invokevirtual 86	com/tencent/mm/kernel/b/h:bbA	()Z
    //   17: ifne +20 -> 37
    //   20: new 88	java/lang/IllegalStateException
    //   23: dup
    //   24: ldc 90
    //   26: invokespecial 93	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: ldc 68
    //   32: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_3
    //   36: athrow
    //   37: getstatic 38	com/tencent/mm/plugin/hp/tinker/i:sInitialized	Z
    //   40: istore_2
    //   41: iload_2
    //   42: ifne +50 -> 92
    //   45: new 95	java/io/DataInputStream
    //   48: dup
    //   49: new 97	java/io/BufferedInputStream
    //   52: dup
    //   53: new 99	java/io/FileInputStream
    //   56: dup
    //   57: getstatic 36	com/tencent/mm/plugin/hp/tinker/i:JEG	Ljava/io/File;
    //   60: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 105	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: invokespecial 106	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: astore_3
    //   70: aload_3
    //   71: invokevirtual 109	java/io/DataInputStream:readInt	()I
    //   74: putstatic 40	com/tencent/mm/plugin/hp/tinker/i:JEH	I
    //   77: aload_3
    //   78: invokevirtual 109	java/io/DataInputStream:readInt	()I
    //   81: putstatic 42	com/tencent/mm/plugin/hp/tinker/i:JEI	I
    //   84: aload_3
    //   85: invokestatic 115	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   88: iconst_1
    //   89: putstatic 38	com/tencent/mm/plugin/hp/tinker/i:sInitialized	Z
    //   92: invokestatic 117	com/tencent/mm/plugin/hp/tinker/i:fQg	()I
    //   95: istore_0
    //   96: getstatic 122	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION_INT	I
    //   99: istore_1
    //   100: iload_0
    //   101: getstatic 40	com/tencent/mm/plugin/hp/tinker/i:JEH	I
    //   104: if_icmpeq +159 -> 263
    //   107: ldc 124
    //   109: ldc 126
    //   111: iconst_2
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: getstatic 40	com/tencent/mm/plugin/hp/tinker/i:JEH	I
    //   120: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: aastore
    //   124: dup
    //   125: iconst_1
    //   126: iload_0
    //   127: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   130: aastore
    //   131: invokestatic 136	com/tencent/mm/app/aa:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   134: iload_0
    //   135: iload_1
    //   136: invokestatic 140	com/tencent/mm/plugin/hp/tinker/i:jw	(II)V
    //   139: ldc 68
    //   141: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: return
    //   145: astore_3
    //   146: aconst_null
    //   147: astore_3
    //   148: invokestatic 117	com/tencent/mm/plugin/hp/tinker/i:fQg	()I
    //   151: putstatic 40	com/tencent/mm/plugin/hp/tinker/i:JEH	I
    //   154: getstatic 122	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION_INT	I
    //   157: putstatic 42	com/tencent/mm/plugin/hp/tinker/i:JEI	I
    //   160: getstatic 40	com/tencent/mm/plugin/hp/tinker/i:JEH	I
    //   163: getstatic 42	com/tencent/mm/plugin/hp/tinker/i:JEI	I
    //   166: invokestatic 140	com/tencent/mm/plugin/hp/tinker/i:jw	(II)V
    //   169: aload_3
    //   170: invokestatic 115	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   173: goto -85 -> 88
    //   176: astore_3
    //   177: ldc 124
    //   179: aload_3
    //   180: ldc 142
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 145	com/tencent/mm/app/aa:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: iconst_0
    //   190: putstatic 38	com/tencent/mm/plugin/hp/tinker/i:sInitialized	Z
    //   193: goto -101 -> 92
    //   196: astore_3
    //   197: ldc 124
    //   199: aload_3
    //   200: ldc 147
    //   202: iconst_0
    //   203: anewarray 4	java/lang/Object
    //   206: invokestatic 145	com/tencent/mm/app/aa:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   209: ldc 68
    //   211: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: return
    //   215: astore 4
    //   217: aconst_null
    //   218: astore_3
    //   219: ldc 124
    //   221: aload 4
    //   223: ldc 149
    //   225: iconst_0
    //   226: anewarray 4	java/lang/Object
    //   229: invokestatic 145	com/tencent/mm/app/aa:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: invokestatic 117	com/tencent/mm/plugin/hp/tinker/i:fQg	()I
    //   235: putstatic 40	com/tencent/mm/plugin/hp/tinker/i:JEH	I
    //   238: getstatic 122	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION_INT	I
    //   241: putstatic 42	com/tencent/mm/plugin/hp/tinker/i:JEI	I
    //   244: aload_3
    //   245: invokestatic 115	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   248: goto -160 -> 88
    //   251: aload_3
    //   252: invokestatic 115	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   255: ldc 68
    //   257: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: aload 4
    //   262: athrow
    //   263: iload_1
    //   264: iload_0
    //   265: if_icmpeq +39 -> 304
    //   268: ldc 124
    //   270: ldc 151
    //   272: iconst_2
    //   273: anewarray 4	java/lang/Object
    //   276: dup
    //   277: iconst_0
    //   278: iload_0
    //   279: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   282: aastore
    //   283: dup
    //   284: iconst_1
    //   285: iload_1
    //   286: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   289: aastore
    //   290: invokestatic 136	com/tencent/mm/app/aa:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: iload_0
    //   294: iload_1
    //   295: invokestatic 140	com/tencent/mm/plugin/hp/tinker/i:jw	(II)V
    //   298: ldc 68
    //   300: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: return
    //   304: iload_1
    //   305: getstatic 42	com/tencent/mm/plugin/hp/tinker/i:JEI	I
    //   308: if_icmpeq +38 -> 346
    //   311: ldc 124
    //   313: ldc 153
    //   315: iconst_2
    //   316: anewarray 4	java/lang/Object
    //   319: dup
    //   320: iconst_0
    //   321: getstatic 42	com/tencent/mm/plugin/hp/tinker/i:JEI	I
    //   324: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   327: aastore
    //   328: dup
    //   329: iconst_1
    //   330: iload_1
    //   331: invokestatic 130	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   334: aastore
    //   335: invokestatic 156	com/tencent/mm/app/aa:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   338: invokestatic 159	com/tencent/mm/app/aa:aCL	()V
    //   341: iload_0
    //   342: iload_1
    //   343: invokestatic 140	com/tencent/mm/plugin/hp/tinker/i:jw	(II)V
    //   346: ldc 68
    //   348: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   351: return
    //   352: astore 4
    //   354: goto -103 -> 251
    //   357: astore 4
    //   359: goto -140 -> 219
    //   362: astore 4
    //   364: goto -216 -> 148
    //   367: astore 4
    //   369: goto -118 -> 251
    // Local variable table:
    //   start	length	slot	name	signature
    //   95	247	0	i	int
    //   99	244	1	j	int
    //   40	2	2	bool	boolean
    //   29	56	3	localObject1	Object
    //   145	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   147	23	3	localCloseable1	java.io.Closeable
    //   176	4	3	localThrowable1	Throwable
    //   196	4	3	localThrowable2	Throwable
    //   218	34	3	localCloseable2	java.io.Closeable
    //   215	46	4	localThrowable3	Throwable
    //   352	1	4	localObject2	Object
    //   357	1	4	localObject3	Object
    //   362	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   367	1	4	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   45	70	145	java/io/FileNotFoundException
    //   84	88	176	finally
    //   88	92	176	finally
    //   169	173	176	finally
    //   244	248	176	finally
    //   251	263	176	finally
    //   37	41	196	finally
    //   92	144	196	finally
    //   177	193	196	finally
    //   268	303	196	finally
    //   304	346	196	finally
    //   45	70	215	finally
    //   219	244	352	finally
    //   70	84	357	finally
    //   70	84	362	java/io/FileNotFoundException
    //   148	169	367	finally
  }
  
  private static void jw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117510);
    if (!JEG.exists()) {
      JEG.getParentFile().mkdirs();
    }
    try
    {
      DataOutputStream localDataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(JEG)));
      try
      {
        aa.a("MicroMsg.TinkerRollbackStatistic", localThrowable, "[-] Fail to store base clientversion[%s] and patch clientversion[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        return;
      }
      finally
      {
        Util.qualityClose(localDataOutputStream);
        AppMethodBeat.o(117510);
      }
    }
    finally
    {
      try
      {
        localDataOutputStream.writeInt(paramInt1);
        localDataOutputStream.writeInt(paramInt2);
        localDataOutputStream.flush();
        Util.qualityClose(localDataOutputStream);
        AppMethodBeat.o(117510);
        return;
      }
      finally {}
      localThrowable = finally;
      localDataOutputStream = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.i
 * JD-Core Version:    0.7.0.1
 */