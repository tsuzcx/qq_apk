package com.tencent.mm.plugin.hp.tinker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.loader.j.b;
import java.io.File;

public final class i
{
  private static final File DNs;
  private static int DNt;
  private static int DNu;
  private static boolean sInitialized;
  
  static
  {
    AppMethodBeat.i(117512);
    DNs = new File(b.aSD(), "patch_ver_history.bin");
    sInitialized = false;
    DNt = 0;
    DNu = 0;
    AppMethodBeat.o(117512);
  }
  
  private static int eIn()
  {
    AppMethodBeat.i(117509);
    int i = Integer.decode(a.CLIENT_VERSION).intValue();
    AppMethodBeat.o(117509);
    return i;
  }
  
  /* Error */
  public static void eIo()
  {
    // Byte code:
    //   0: ldc 70
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 76	com/tencent/mm/kernel/h:aHD	()Lcom/tencent/mm/kernel/e;
    //   8: invokevirtual 82	com/tencent/mm/kernel/e:aHf	()Lcom/tencent/mm/kernel/b/g;
    //   11: checkcast 84	com/tencent/mm/kernel/b/h
    //   14: invokevirtual 88	com/tencent/mm/kernel/b/h:aIE	()Z
    //   17: ifne +20 -> 37
    //   20: new 90	java/lang/IllegalStateException
    //   23: dup
    //   24: ldc 92
    //   26: invokespecial 95	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: ldc 70
    //   32: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: aload_3
    //   36: athrow
    //   37: getstatic 38	com/tencent/mm/plugin/hp/tinker/i:sInitialized	Z
    //   40: istore_2
    //   41: iload_2
    //   42: ifne +56 -> 98
    //   45: new 97	java/io/DataInputStream
    //   48: dup
    //   49: new 99	java/io/BufferedInputStream
    //   52: dup
    //   53: new 101	java/io/FileInputStream
    //   56: dup
    //   57: getstatic 36	com/tencent/mm/plugin/hp/tinker/i:DNs	Ljava/io/File;
    //   60: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   63: invokespecial 107	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   66: invokespecial 108	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   69: astore_3
    //   70: aload_3
    //   71: astore 4
    //   73: aload_3
    //   74: invokevirtual 111	java/io/DataInputStream:readInt	()I
    //   77: putstatic 40	com/tencent/mm/plugin/hp/tinker/i:DNt	I
    //   80: aload_3
    //   81: astore 4
    //   83: aload_3
    //   84: invokevirtual 111	java/io/DataInputStream:readInt	()I
    //   87: putstatic 42	com/tencent/mm/plugin/hp/tinker/i:DNu	I
    //   90: aload_3
    //   91: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   94: iconst_1
    //   95: putstatic 38	com/tencent/mm/plugin/hp/tinker/i:sInitialized	Z
    //   98: invokestatic 119	com/tencent/mm/plugin/hp/tinker/i:eIn	()I
    //   101: istore_0
    //   102: getstatic 124	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION_INT	I
    //   105: istore_1
    //   106: iload_0
    //   107: getstatic 40	com/tencent/mm/plugin/hp/tinker/i:DNt	I
    //   110: if_icmpeq +168 -> 278
    //   113: ldc 126
    //   115: ldc 128
    //   117: iconst_2
    //   118: anewarray 4	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: getstatic 40	com/tencent/mm/plugin/hp/tinker/i:DNt	I
    //   126: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: aastore
    //   130: dup
    //   131: iconst_1
    //   132: iload_0
    //   133: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   136: aastore
    //   137: invokestatic 138	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: iload_0
    //   141: iload_1
    //   142: invokestatic 142	com/tencent/mm/plugin/hp/tinker/i:hS	(II)V
    //   145: ldc 70
    //   147: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: astore_3
    //   152: aconst_null
    //   153: astore_3
    //   154: aload_3
    //   155: astore 4
    //   157: invokestatic 119	com/tencent/mm/plugin/hp/tinker/i:eIn	()I
    //   160: putstatic 40	com/tencent/mm/plugin/hp/tinker/i:DNt	I
    //   163: aload_3
    //   164: astore 4
    //   166: getstatic 124	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION_INT	I
    //   169: putstatic 42	com/tencent/mm/plugin/hp/tinker/i:DNu	I
    //   172: aload_3
    //   173: astore 4
    //   175: getstatic 40	com/tencent/mm/plugin/hp/tinker/i:DNt	I
    //   178: getstatic 42	com/tencent/mm/plugin/hp/tinker/i:DNu	I
    //   181: invokestatic 142	com/tencent/mm/plugin/hp/tinker/i:hS	(II)V
    //   184: aload_3
    //   185: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   188: goto -94 -> 94
    //   191: astore_3
    //   192: ldc 126
    //   194: aload_3
    //   195: ldc 144
    //   197: iconst_0
    //   198: anewarray 4	java/lang/Object
    //   201: invokestatic 147	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   204: iconst_0
    //   205: putstatic 38	com/tencent/mm/plugin/hp/tinker/i:sInitialized	Z
    //   208: goto -110 -> 98
    //   211: astore_3
    //   212: ldc 126
    //   214: aload_3
    //   215: ldc 149
    //   217: iconst_0
    //   218: anewarray 4	java/lang/Object
    //   221: invokestatic 147	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   224: ldc 70
    //   226: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   229: return
    //   230: astore 4
    //   232: aconst_null
    //   233: astore_3
    //   234: ldc 126
    //   236: aload 4
    //   238: ldc 151
    //   240: iconst_0
    //   241: anewarray 4	java/lang/Object
    //   244: invokestatic 147	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: invokestatic 119	com/tencent/mm/plugin/hp/tinker/i:eIn	()I
    //   250: putstatic 40	com/tencent/mm/plugin/hp/tinker/i:DNt	I
    //   253: getstatic 124	com/tencent/mm/sdk/platformtools/BuildInfo:CLIENT_VERSION_INT	I
    //   256: putstatic 42	com/tencent/mm/plugin/hp/tinker/i:DNu	I
    //   259: aload_3
    //   260: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   263: goto -169 -> 94
    //   266: aload_3
    //   267: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   270: ldc 70
    //   272: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload 4
    //   277: athrow
    //   278: iload_1
    //   279: iload_0
    //   280: if_icmpeq +39 -> 319
    //   283: ldc 126
    //   285: ldc 153
    //   287: iconst_2
    //   288: anewarray 4	java/lang/Object
    //   291: dup
    //   292: iconst_0
    //   293: iload_0
    //   294: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   297: aastore
    //   298: dup
    //   299: iconst_1
    //   300: iload_1
    //   301: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   304: aastore
    //   305: invokestatic 138	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   308: iload_0
    //   309: iload_1
    //   310: invokestatic 142	com/tencent/mm/plugin/hp/tinker/i:hS	(II)V
    //   313: ldc 70
    //   315: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   318: return
    //   319: iload_1
    //   320: getstatic 42	com/tencent/mm/plugin/hp/tinker/i:DNu	I
    //   323: if_icmpeq +42 -> 365
    //   326: ldc 126
    //   328: ldc 155
    //   330: iconst_2
    //   331: anewarray 4	java/lang/Object
    //   334: dup
    //   335: iconst_0
    //   336: getstatic 42	com/tencent/mm/plugin/hp/tinker/i:DNu	I
    //   339: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: dup
    //   344: iconst_1
    //   345: iload_1
    //   346: invokestatic 132	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: aastore
    //   350: invokestatic 158	com/tencent/mm/app/x:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   353: sipush 1141
    //   356: iconst_0
    //   357: invokestatic 161	com/tencent/mm/app/x:ff	(II)V
    //   360: iload_0
    //   361: iload_1
    //   362: invokestatic 142	com/tencent/mm/plugin/hp/tinker/i:hS	(II)V
    //   365: ldc 70
    //   367: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   370: return
    //   371: astore_3
    //   372: aload 4
    //   374: astore 5
    //   376: aload_3
    //   377: astore 4
    //   379: aload 5
    //   381: astore_3
    //   382: goto -116 -> 266
    //   385: astore 4
    //   387: goto -121 -> 266
    //   390: astore 4
    //   392: goto -158 -> 234
    //   395: astore 4
    //   397: goto -243 -> 154
    //   400: astore 4
    //   402: aconst_null
    //   403: astore_3
    //   404: goto -138 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   101	260	0	i	int
    //   105	257	1	j	int
    //   40	2	2	bool	boolean
    //   29	62	3	localObject1	Object
    //   151	1	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   153	32	3	localCloseable1	java.io.Closeable
    //   191	4	3	localThrowable1	java.lang.Throwable
    //   211	4	3	localThrowable2	java.lang.Throwable
    //   233	34	3	localCloseable2	java.io.Closeable
    //   371	6	3	localObject2	Object
    //   381	23	3	localObject3	Object
    //   71	103	4	localObject4	Object
    //   230	143	4	localThrowable3	java.lang.Throwable
    //   377	1	4	localObject5	Object
    //   385	1	4	localObject6	Object
    //   390	1	4	localThrowable4	java.lang.Throwable
    //   395	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   400	1	4	localObject7	Object
    //   374	6	5	localThrowable5	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   45	70	151	java/io/FileNotFoundException
    //   90	94	191	java/lang/Throwable
    //   94	98	191	java/lang/Throwable
    //   184	188	191	java/lang/Throwable
    //   259	263	191	java/lang/Throwable
    //   266	278	191	java/lang/Throwable
    //   37	41	211	java/lang/Throwable
    //   98	150	211	java/lang/Throwable
    //   192	208	211	java/lang/Throwable
    //   283	318	211	java/lang/Throwable
    //   319	365	211	java/lang/Throwable
    //   45	70	230	java/lang/Throwable
    //   73	80	371	finally
    //   83	90	371	finally
    //   157	163	371	finally
    //   166	172	371	finally
    //   175	184	371	finally
    //   234	259	385	finally
    //   73	80	390	java/lang/Throwable
    //   83	90	390	java/lang/Throwable
    //   73	80	395	java/io/FileNotFoundException
    //   83	90	395	java/io/FileNotFoundException
    //   45	70	400	finally
  }
  
  /* Error */
  private static void hS(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 162
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: getstatic 36	com/tencent/mm/plugin/hp/tinker/i:DNs	Ljava/io/File;
    //   8: invokevirtual 165	java/io/File:exists	()Z
    //   11: ifne +13 -> 24
    //   14: getstatic 36	com/tencent/mm/plugin/hp/tinker/i:DNs	Ljava/io/File;
    //   17: invokevirtual 169	java/io/File:getParentFile	()Ljava/io/File;
    //   20: invokevirtual 172	java/io/File:mkdirs	()Z
    //   23: pop
    //   24: new 174	java/io/DataOutputStream
    //   27: dup
    //   28: new 176	java/io/BufferedOutputStream
    //   31: dup
    //   32: new 178	java/io/FileOutputStream
    //   35: dup
    //   36: getstatic 36	com/tencent/mm/plugin/hp/tinker/i:DNs	Ljava/io/File;
    //   39: invokespecial 179	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   42: invokespecial 182	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   45: invokespecial 183	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   48: astore_3
    //   49: aload_3
    //   50: astore_2
    //   51: aload_3
    //   52: iload_0
    //   53: invokevirtual 186	java/io/DataOutputStream:writeInt	(I)V
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: iload_1
    //   60: invokevirtual 186	java/io/DataOutputStream:writeInt	(I)V
    //   63: aload_3
    //   64: astore_2
    //   65: aload_3
    //   66: invokevirtual 189	java/io/DataOutputStream:flush	()V
    //   69: aload_3
    //   70: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   73: ldc 162
    //   75: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: astore 4
    //   81: aconst_null
    //   82: astore_3
    //   83: aload_3
    //   84: astore_2
    //   85: ldc 126
    //   87: aload 4
    //   89: ldc 191
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
    //   109: invokestatic 147	com/tencent/mm/app/x:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   112: aload_3
    //   113: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   116: ldc 162
    //   118: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   121: return
    //   122: astore_3
    //   123: aconst_null
    //   124: astore_2
    //   125: aload_2
    //   126: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   129: ldc 162
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hp.tinker.i
 * JD-Core Version:    0.7.0.1
 */