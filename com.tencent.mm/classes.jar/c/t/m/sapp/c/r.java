package c.t.m.sapp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class r
{
  public String a;
  public File b;
  
  public r(String paramString)
  {
    AppMethodBeat.i(190549);
    this.a = "WriterAndReader";
    this.b = null;
    this.b = new File(paramString);
    AppMethodBeat.o(190549);
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: ldc 38
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 40	java/io/ByteArrayOutputStream
    //   8: dup
    //   9: invokespecial 41	java/io/ByteArrayOutputStream:<init>	()V
    //   12: astore 6
    //   14: aload_0
    //   15: getfield 26	c/t/m/sapp/c/r:b	Ljava/io/File;
    //   18: invokevirtual 45	java/io/File:exists	()Z
    //   21: istore_3
    //   22: iload_3
    //   23: ifne +23 -> 46
    //   26: new 47	java/lang/NullPointerException
    //   29: dup
    //   30: invokespecial 48	java/lang/NullPointerException:<init>	()V
    //   33: athrow
    //   34: aload 6
    //   36: invokevirtual 51	java/io/ByteArrayOutputStream:close	()V
    //   39: ldc 38
    //   41: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   44: aload_1
    //   45: areturn
    //   46: new 53	java/io/FileInputStream
    //   49: dup
    //   50: aload_0
    //   51: getfield 26	c/t/m/sapp/c/r:b	Ljava/io/File;
    //   54: invokevirtual 57	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   57: invokespecial 58	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   60: astore 5
    //   62: aload 5
    //   64: astore 4
    //   66: sipush 10240
    //   69: newarray byte
    //   71: astore 7
    //   73: aload 5
    //   75: astore 4
    //   77: aload 5
    //   79: aload 7
    //   81: invokevirtual 62	java/io/FileInputStream:read	([B)I
    //   84: istore_2
    //   85: iload_2
    //   86: iconst_m1
    //   87: if_icmpeq +56 -> 143
    //   90: aload 5
    //   92: astore 4
    //   94: aload 6
    //   96: aload 7
    //   98: iconst_0
    //   99: iload_2
    //   100: invokevirtual 66	java/io/ByteArrayOutputStream:write	([BII)V
    //   103: goto -30 -> 73
    //   106: astore 4
    //   108: aload 5
    //   110: astore 4
    //   112: aload 5
    //   114: invokevirtual 67	java/io/FileInputStream:close	()V
    //   117: aload 5
    //   119: astore 4
    //   121: aload 6
    //   123: invokevirtual 51	java/io/ByteArrayOutputStream:close	()V
    //   126: aload 5
    //   128: invokevirtual 67	java/io/FileInputStream:close	()V
    //   131: aload 6
    //   133: invokevirtual 51	java/io/ByteArrayOutputStream:close	()V
    //   136: ldc 38
    //   138: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_1
    //   142: areturn
    //   143: aload 5
    //   145: astore 4
    //   147: aload 6
    //   149: invokevirtual 51	java/io/ByteArrayOutputStream:close	()V
    //   152: aload 5
    //   154: astore 4
    //   156: new 69	java/lang/String
    //   159: dup
    //   160: aload 6
    //   162: invokevirtual 73	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   165: invokespecial 76	java/lang/String:<init>	([B)V
    //   168: astore 7
    //   170: aload 5
    //   172: astore 4
    //   174: aload 5
    //   176: invokevirtual 67	java/io/FileInputStream:close	()V
    //   179: aload 5
    //   181: invokevirtual 67	java/io/FileInputStream:close	()V
    //   184: aload 6
    //   186: invokevirtual 51	java/io/ByteArrayOutputStream:close	()V
    //   189: ldc 38
    //   191: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload 7
    //   196: areturn
    //   197: astore_1
    //   198: aconst_null
    //   199: astore 4
    //   201: aload 4
    //   203: invokevirtual 67	java/io/FileInputStream:close	()V
    //   206: aload 6
    //   208: invokevirtual 51	java/io/ByteArrayOutputStream:close	()V
    //   211: ldc 38
    //   213: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   216: aload_1
    //   217: athrow
    //   218: astore 4
    //   220: aconst_null
    //   221: astore 5
    //   223: goto -115 -> 108
    //   226: astore 4
    //   228: goto -194 -> 34
    //   231: astore 4
    //   233: goto -194 -> 39
    //   236: astore_1
    //   237: goto -53 -> 184
    //   240: astore_1
    //   241: goto -52 -> 189
    //   244: astore 4
    //   246: goto -129 -> 117
    //   249: astore 4
    //   251: goto -125 -> 126
    //   254: astore 4
    //   256: goto -50 -> 206
    //   259: astore 4
    //   261: goto -50 -> 211
    //   264: astore 4
    //   266: goto -135 -> 131
    //   269: astore 4
    //   271: goto -135 -> 136
    //   274: astore_1
    //   275: goto -74 -> 201
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	278	0	this	r
    //   0	278	1	paramString	String
    //   84	16	2	i	int
    //   21	2	3	bool	boolean
    //   64	29	4	localFileInputStream1	java.io.FileInputStream
    //   106	1	4	localException1	java.lang.Exception
    //   110	92	4	localFileInputStream2	java.io.FileInputStream
    //   218	1	4	localException2	java.lang.Exception
    //   226	1	4	localException3	java.lang.Exception
    //   231	1	4	localException4	java.lang.Exception
    //   244	1	4	localException5	java.lang.Exception
    //   249	1	4	localException6	java.lang.Exception
    //   254	1	4	localException7	java.lang.Exception
    //   259	1	4	localException8	java.lang.Exception
    //   264	1	4	localException9	java.lang.Exception
    //   269	1	4	localException10	java.lang.Exception
    //   60	162	5	localFileInputStream3	java.io.FileInputStream
    //   12	195	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   71	124	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   66	73	106	java/lang/Exception
    //   77	85	106	java/lang/Exception
    //   94	103	106	java/lang/Exception
    //   147	152	106	java/lang/Exception
    //   156	170	106	java/lang/Exception
    //   174	179	106	java/lang/Exception
    //   14	22	197	finally
    //   46	62	197	finally
    //   14	22	218	java/lang/Exception
    //   46	62	218	java/lang/Exception
    //   26	34	226	java/lang/Exception
    //   34	39	231	java/lang/Exception
    //   179	184	236	java/lang/Exception
    //   184	189	240	java/lang/Exception
    //   112	117	244	java/lang/Exception
    //   121	126	249	java/lang/Exception
    //   201	206	254	java/lang/Exception
    //   206	211	259	java/lang/Exception
    //   126	131	264	java/lang/Exception
    //   131	136	269	java/lang/Exception
    //   66	73	274	finally
    //   77	85	274	finally
    //   94	103	274	finally
    //   112	117	274	finally
    //   121	126	274	finally
    //   147	152	274	finally
    //   156	170	274	finally
    //   174	179	274	finally
  }
  
  /* Error */
  public boolean a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 78
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 26	c/t/m/sapp/c/r:b	Ljava/io/File;
    //   9: invokevirtual 45	java/io/File:exists	()Z
    //   12: ifne +38 -> 50
    //   15: new 28	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: getfield 26	c/t/m/sapp/c/r:b	Ljava/io/File;
    //   23: invokevirtual 81	java/io/File:getParent	()Ljava/lang/String;
    //   26: invokespecial 30	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: aload_3
    //   31: invokevirtual 45	java/io/File:exists	()Z
    //   34: ifne +16 -> 50
    //   37: aload_3
    //   38: invokevirtual 84	java/io/File:mkdirs	()Z
    //   41: pop
    //   42: aload_0
    //   43: getfield 26	c/t/m/sapp/c/r:b	Ljava/io/File;
    //   46: invokevirtual 87	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: new 89	java/io/FileOutputStream
    //   53: dup
    //   54: aload_0
    //   55: getfield 26	c/t/m/sapp/c/r:b	Ljava/io/File;
    //   58: iload_2
    //   59: invokespecial 92	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   62: astore_3
    //   63: aload_3
    //   64: aload_1
    //   65: invokevirtual 94	java/io/FileOutputStream:write	([B)V
    //   68: aload_3
    //   69: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   72: aload_3
    //   73: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   76: ldc 78
    //   78: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: iconst_1
    //   82: ireturn
    //   83: astore_1
    //   84: aload_3
    //   85: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   88: ldc 78
    //   90: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_1
    //   94: athrow
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_3
    //   98: goto -14 -> 84
    //   101: astore_1
    //   102: aconst_null
    //   103: astore_3
    //   104: aload_3
    //   105: invokevirtual 95	java/io/FileOutputStream:close	()V
    //   108: ldc 78
    //   110: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: iconst_0
    //   114: ireturn
    //   115: astore_1
    //   116: goto -40 -> 76
    //   119: astore_3
    //   120: goto -32 -> 88
    //   123: astore_1
    //   124: goto -16 -> 108
    //   127: astore_1
    //   128: goto -24 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	this	r
    //   0	131	1	paramArrayOfByte	byte[]
    //   0	131	2	paramBoolean	boolean
    //   29	76	3	localObject	Object
    //   119	1	3	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   63	72	83	finally
    //   5	50	95	finally
    //   50	63	95	finally
    //   5	50	101	java/lang/Exception
    //   50	63	101	java/lang/Exception
    //   72	76	115	java/lang/Exception
    //   84	88	119	java/lang/Exception
    //   104	108	123	java/lang/Exception
    //   63	72	127	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.sapp.c.r
 * JD-Core Version:    0.7.0.1
 */