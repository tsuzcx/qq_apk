package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.loader.j.b;
import java.io.File;

public final class i
{
  private static boolean sInitialized;
  private static int syA;
  private static int syB;
  private static final File syz;
  
  static
  {
    AppMethodBeat.i(117512);
    syz = new File(b.ahZ(), "patch_ver_history.bin");
    sInitialized = false;
    syA = 0;
    syB = 0;
    AppMethodBeat.o(117512);
  }
  
  private static int cGk()
  {
    AppMethodBeat.i(117509);
    int i = Integer.decode(a.glW).intValue();
    AppMethodBeat.o(117509);
    return i;
  }
  
  /* Error */
  public static void cGl()
  {
    // Byte code:
    //   0: ldc 70
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 76	com/tencent/mm/kernel/g:afy	()Lcom/tencent/mm/kernel/d;
    //   8: invokevirtual 82	com/tencent/mm/kernel/d:aeZ	()Lcom/tencent/mm/kernel/b/g;
    //   11: checkcast 84	com/tencent/mm/kernel/b/h
    //   14: invokevirtual 88	com/tencent/mm/kernel/b/h:agu	()Z
    //   17: ifne +20 -> 37
    //   20: new 90	java/lang/IllegalStateException
    //   23: dup
    //   24: ldc 92
    //   26: invokespecial 95	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   29: astore_2
    //   30: ldc 70
    //   32: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_2
    //   36: athrow
    //   37: getstatic 38	com/tencent/mm/plugin/hp/tinker/i:sInitialized	Z
    //   40: ifne +54 -> 94
    //   43: new 97	java/io/DataInputStream
    //   46: dup
    //   47: new 99	java/io/BufferedInputStream
    //   50: dup
    //   51: new 101	java/io/FileInputStream
    //   54: dup
    //   55: getstatic 36	com/tencent/mm/plugin/hp/tinker/i:syz	Ljava/io/File;
    //   58: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: invokespecial 107	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   64: invokespecial 108	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   67: astore_2
    //   68: aload_2
    //   69: astore_3
    //   70: aload_2
    //   71: invokevirtual 111	java/io/DataInputStream:readInt	()I
    //   74: putstatic 40	com/tencent/mm/plugin/hp/tinker/i:syA	I
    //   77: aload_2
    //   78: astore_3
    //   79: aload_2
    //   80: invokevirtual 111	java/io/DataInputStream:readInt	()I
    //   83: putstatic 42	com/tencent/mm/plugin/hp/tinker/i:syB	I
    //   86: aload_2
    //   87: invokestatic 117	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   90: iconst_1
    //   91: putstatic 38	com/tencent/mm/plugin/hp/tinker/i:sInitialized	Z
    //   94: invokestatic 119	com/tencent/mm/plugin/hp/tinker/i:cGk	()I
    //   97: istore_0
    //   98: getstatic 124	com/tencent/mm/sdk/platformtools/h:ETr	I
    //   101: istore_1
    //   102: iload_0
    //   103: getstatic 40	com/tencent/mm/plugin/hp/tinker/i:syA	I
    //   106: if_icmpeq +126 -> 232
    //   109: ldc 126
    //   111: ldc 128
    //   113: iconst_2
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: getstatic 40	com/tencent/mm/plugin/hp/tinker/i:syA	I
    //   122: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   125: aastore
    //   126: dup
    //   127: iconst_1
    //   128: iload_0
    //   129: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: aastore
    //   133: invokestatic 137	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: iload_0
    //   137: iload_1
    //   138: invokestatic 141	com/tencent/mm/plugin/hp/tinker/i:fS	(II)V
    //   141: ldc 70
    //   143: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   146: return
    //   147: astore_2
    //   148: aconst_null
    //   149: astore_2
    //   150: aload_2
    //   151: astore_3
    //   152: invokestatic 119	com/tencent/mm/plugin/hp/tinker/i:cGk	()I
    //   155: putstatic 40	com/tencent/mm/plugin/hp/tinker/i:syA	I
    //   158: aload_2
    //   159: astore_3
    //   160: getstatic 124	com/tencent/mm/sdk/platformtools/h:ETr	I
    //   163: putstatic 42	com/tencent/mm/plugin/hp/tinker/i:syB	I
    //   166: aload_2
    //   167: astore_3
    //   168: getstatic 40	com/tencent/mm/plugin/hp/tinker/i:syA	I
    //   171: getstatic 42	com/tencent/mm/plugin/hp/tinker/i:syB	I
    //   174: invokestatic 141	com/tencent/mm/plugin/hp/tinker/i:fS	(II)V
    //   177: aload_2
    //   178: invokestatic 117	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   181: goto -91 -> 90
    //   184: astore_3
    //   185: aconst_null
    //   186: astore_2
    //   187: ldc 126
    //   189: aload_3
    //   190: ldc 143
    //   192: iconst_0
    //   193: anewarray 4	java/lang/Object
    //   196: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: invokestatic 119	com/tencent/mm/plugin/hp/tinker/i:cGk	()I
    //   202: putstatic 40	com/tencent/mm/plugin/hp/tinker/i:syA	I
    //   205: getstatic 124	com/tencent/mm/sdk/platformtools/h:ETr	I
    //   208: putstatic 42	com/tencent/mm/plugin/hp/tinker/i:syB	I
    //   211: aload_2
    //   212: invokestatic 117	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   215: goto -125 -> 90
    //   218: astore_3
    //   219: aconst_null
    //   220: astore_2
    //   221: aload_2
    //   222: invokestatic 117	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   225: ldc 70
    //   227: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   230: aload_3
    //   231: athrow
    //   232: iload_1
    //   233: iload_0
    //   234: if_icmpeq +39 -> 273
    //   237: ldc 126
    //   239: ldc 149
    //   241: iconst_2
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: iload_0
    //   248: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   251: aastore
    //   252: dup
    //   253: iconst_1
    //   254: iload_1
    //   255: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   258: aastore
    //   259: invokestatic 137	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   262: iload_0
    //   263: iload_1
    //   264: invokestatic 141	com/tencent/mm/plugin/hp/tinker/i:fS	(II)V
    //   267: ldc 70
    //   269: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: return
    //   273: iload_1
    //   274: getstatic 42	com/tencent/mm/plugin/hp/tinker/i:syB	I
    //   277: if_icmpeq +46 -> 323
    //   280: ldc 126
    //   282: ldc 151
    //   284: iconst_2
    //   285: anewarray 4	java/lang/Object
    //   288: dup
    //   289: iconst_0
    //   290: getstatic 42	com/tencent/mm/plugin/hp/tinker/i:syB	I
    //   293: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   296: aastore
    //   297: dup
    //   298: iconst_1
    //   299: iload_1
    //   300: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   303: aastore
    //   304: invokestatic 154	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: getstatic 160	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   310: ldc2_w 161
    //   313: lconst_0
    //   314: lconst_1
    //   315: invokevirtual 166	com/tencent/mm/plugin/report/service/h:m	(JJJ)V
    //   318: iload_0
    //   319: iload_1
    //   320: invokestatic 141	com/tencent/mm/plugin/hp/tinker/i:fS	(II)V
    //   323: ldc 70
    //   325: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   328: return
    //   329: astore_2
    //   330: aload_3
    //   331: astore 4
    //   333: aload_2
    //   334: astore_3
    //   335: aload 4
    //   337: astore_2
    //   338: goto -117 -> 221
    //   341: astore_3
    //   342: goto -121 -> 221
    //   345: astore_3
    //   346: goto -159 -> 187
    //   349: astore_3
    //   350: goto -200 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   97	222	0	i	int
    //   101	219	1	j	int
    //   29	58	2	localObject1	Object
    //   147	1	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   149	73	2	localCloseable	java.io.Closeable
    //   329	5	2	localObject2	Object
    //   337	1	2	localObject3	Object
    //   69	99	3	localObject4	Object
    //   184	6	3	localThrowable1	java.lang.Throwable
    //   218	113	3	localObject5	Object
    //   334	1	3	localObject6	Object
    //   341	1	3	localObject7	Object
    //   345	1	3	localThrowable2	java.lang.Throwable
    //   349	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   331	5	4	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   43	68	147	java/io/FileNotFoundException
    //   43	68	184	java/lang/Throwable
    //   43	68	218	finally
    //   70	77	329	finally
    //   79	86	329	finally
    //   152	158	329	finally
    //   160	166	329	finally
    //   168	177	329	finally
    //   187	211	341	finally
    //   70	77	345	java/lang/Throwable
    //   79	86	345	java/lang/Throwable
    //   70	77	349	java/io/FileNotFoundException
    //   79	86	349	java/io/FileNotFoundException
  }
  
  /* Error */
  private static void fS(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 167
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 36	com/tencent/mm/plugin/hp/tinker/i:syz	Ljava/io/File;
    //   8: invokevirtual 170	java/io/File:exists	()Z
    //   11: ifne +13 -> 24
    //   14: getstatic 36	com/tencent/mm/plugin/hp/tinker/i:syz	Ljava/io/File;
    //   17: invokevirtual 174	java/io/File:getParentFile	()Ljava/io/File;
    //   20: invokevirtual 177	java/io/File:mkdirs	()Z
    //   23: pop
    //   24: new 179	java/io/DataOutputStream
    //   27: dup
    //   28: new 181	java/io/BufferedOutputStream
    //   31: dup
    //   32: new 183	java/io/FileOutputStream
    //   35: dup
    //   36: getstatic 36	com/tencent/mm/plugin/hp/tinker/i:syz	Ljava/io/File;
    //   39: invokespecial 184	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 187	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   45: invokespecial 188	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   48: astore_3
    //   49: aload_3
    //   50: astore_2
    //   51: aload_3
    //   52: iload_0
    //   53: invokevirtual 191	java/io/DataOutputStream:writeInt	(I)V
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: iload_1
    //   60: invokevirtual 191	java/io/DataOutputStream:writeInt	(I)V
    //   63: aload_3
    //   64: astore_2
    //   65: aload_3
    //   66: invokevirtual 194	java/io/DataOutputStream:flush	()V
    //   69: aload_3
    //   70: invokestatic 117	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   73: ldc 167
    //   75: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: astore 4
    //   81: aconst_null
    //   82: astore_3
    //   83: aload_3
    //   84: astore_2
    //   85: ldc 126
    //   87: aload 4
    //   89: ldc 196
    //   91: iconst_2
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: iload_0
    //   98: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: aastore
    //   102: dup
    //   103: iconst_1
    //   104: iload_1
    //   105: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: aastore
    //   109: invokestatic 147	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_3
    //   113: invokestatic 117	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   116: ldc 167
    //   118: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: return
    //   122: astore_3
    //   123: aconst_null
    //   124: astore_2
    //   125: aload_2
    //   126: invokestatic 117	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   129: ldc 167
    //   131: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload_3
    //   135: athrow
    //   136: astore_3
    //   137: goto -12 -> 125
    //   140: astore 4
    //   142: goto -59 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	paramInt1	int
    //   0	145	1	paramInt2	int
    //   50	76	2	localDataOutputStream1	java.io.DataOutputStream
    //   48	65	3	localDataOutputStream2	java.io.DataOutputStream
    //   122	13	3	localObject1	Object
    //   136	1	3	localObject2	Object
    //   79	9	4	localThrowable1	java.lang.Throwable
    //   140	1	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   24	49	79	java/lang/Throwable
    //   24	49	122	finally
    //   51	56	136	finally
    //   58	63	136	finally
    //   65	69	136	finally
    //   85	112	136	finally
    //   51	56	140	java/lang/Throwable
    //   58	63	140	java/lang/Throwable
    //   65	69	140	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.i
 * JD-Core Version:    0.7.0.1
 */