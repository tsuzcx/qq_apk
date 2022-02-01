package com.tencent.map.tools.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class w
{
  private String a;
  private File b;
  
  public w(String paramString)
  {
    AppMethodBeat.i(209811);
    this.a = w.class.getSimpleName();
    this.b = null;
    this.b = new File(paramString);
    AppMethodBeat.o(209811);
  }
  
  /* Error */
  public final String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 42
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 44	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: invokespecial 45	java/io/ByteArrayOutputStream:<init>	()V
    //   15: astore 6
    //   17: aload_0
    //   18: getfield 30	com/tencent/map/tools/internal/w:b	Ljava/io/File;
    //   21: invokevirtual 49	java/io/File:exists	()Z
    //   24: istore_3
    //   25: iload_3
    //   26: ifne +23 -> 49
    //   29: new 51	java/lang/NullPointerException
    //   32: dup
    //   33: invokespecial 52	java/lang/NullPointerException:<init>	()V
    //   36: athrow
    //   37: aload 6
    //   39: invokevirtual 55	java/io/ByteArrayOutputStream:close	()V
    //   42: ldc 42
    //   44: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload_1
    //   48: areturn
    //   49: new 57	java/io/FileInputStream
    //   52: dup
    //   53: aload_0
    //   54: getfield 30	com/tencent/map/tools/internal/w:b	Ljava/io/File;
    //   57: invokevirtual 60	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   63: astore 4
    //   65: sipush 10240
    //   68: newarray byte
    //   70: astore 5
    //   72: aload 4
    //   74: aload 5
    //   76: invokevirtual 65	java/io/FileInputStream:read	([B)I
    //   79: istore_2
    //   80: iload_2
    //   81: iconst_m1
    //   82: if_icmpeq +44 -> 126
    //   85: aload 6
    //   87: aload 5
    //   89: iconst_0
    //   90: iload_2
    //   91: invokevirtual 69	java/io/ByteArrayOutputStream:write	([BII)V
    //   94: goto -22 -> 72
    //   97: astore 5
    //   99: aload 4
    //   101: invokevirtual 70	java/io/FileInputStream:close	()V
    //   104: aload 6
    //   106: invokevirtual 55	java/io/ByteArrayOutputStream:close	()V
    //   109: aload 4
    //   111: invokevirtual 70	java/io/FileInputStream:close	()V
    //   114: aload 6
    //   116: invokevirtual 55	java/io/ByteArrayOutputStream:close	()V
    //   119: ldc 42
    //   121: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: aload_1
    //   125: areturn
    //   126: aload 6
    //   128: invokevirtual 55	java/io/ByteArrayOutputStream:close	()V
    //   131: new 72	java/lang/String
    //   134: dup
    //   135: aload 6
    //   137: invokevirtual 76	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   140: invokespecial 79	java/lang/String:<init>	([B)V
    //   143: astore 5
    //   145: aload 4
    //   147: invokevirtual 70	java/io/FileInputStream:close	()V
    //   150: aload 4
    //   152: invokevirtual 70	java/io/FileInputStream:close	()V
    //   155: aload 6
    //   157: invokevirtual 55	java/io/ByteArrayOutputStream:close	()V
    //   160: ldc 42
    //   162: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aload 5
    //   167: areturn
    //   168: astore_1
    //   169: aconst_null
    //   170: astore 4
    //   172: aload 4
    //   174: invokevirtual 70	java/io/FileInputStream:close	()V
    //   177: aload 6
    //   179: invokevirtual 55	java/io/ByteArrayOutputStream:close	()V
    //   182: ldc 42
    //   184: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   187: aload_1
    //   188: athrow
    //   189: astore 4
    //   191: goto -154 -> 37
    //   194: astore 4
    //   196: goto -154 -> 42
    //   199: astore_1
    //   200: goto -45 -> 155
    //   203: astore_1
    //   204: goto -44 -> 160
    //   207: astore 5
    //   209: goto -105 -> 104
    //   212: astore 5
    //   214: goto -105 -> 109
    //   217: astore 4
    //   219: goto -105 -> 114
    //   222: astore 4
    //   224: goto -105 -> 119
    //   227: astore 4
    //   229: goto -52 -> 177
    //   232: astore 4
    //   234: goto -52 -> 182
    //   237: astore_1
    //   238: goto -66 -> 172
    //   241: astore_1
    //   242: goto -70 -> 172
    //   245: astore 4
    //   247: aload 5
    //   249: astore 4
    //   251: goto -152 -> 99
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	this	w
    //   0	254	1	paramString	String
    //   79	12	2	i	int
    //   24	2	3	bool	boolean
    //   63	110	4	localFileInputStream	java.io.FileInputStream
    //   189	1	4	localException1	java.lang.Exception
    //   194	1	4	localException2	java.lang.Exception
    //   217	1	4	localException3	java.lang.Exception
    //   222	1	4	localException4	java.lang.Exception
    //   227	1	4	localException5	java.lang.Exception
    //   232	1	4	localException6	java.lang.Exception
    //   245	1	4	localException7	java.lang.Exception
    //   249	1	4	localException8	java.lang.Exception
    //   1	87	5	arrayOfByte	byte[]
    //   97	1	5	localException9	java.lang.Exception
    //   143	23	5	str	String
    //   207	1	5	localException10	java.lang.Exception
    //   212	36	5	localException11	java.lang.Exception
    //   15	163	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   65	72	97	java/lang/Exception
    //   72	80	97	java/lang/Exception
    //   85	94	97	java/lang/Exception
    //   126	150	97	java/lang/Exception
    //   17	25	168	finally
    //   49	65	168	finally
    //   29	37	189	java/lang/Exception
    //   37	42	194	java/lang/Exception
    //   150	155	199	java/lang/Exception
    //   155	160	203	java/lang/Exception
    //   99	104	207	java/lang/Exception
    //   104	109	212	java/lang/Exception
    //   109	114	217	java/lang/Exception
    //   114	119	222	java/lang/Exception
    //   172	177	227	java/lang/Exception
    //   177	182	232	java/lang/Exception
    //   65	72	237	finally
    //   72	80	237	finally
    //   85	94	237	finally
    //   126	150	237	finally
    //   99	104	241	finally
    //   104	109	241	finally
    //   17	25	245	java/lang/Exception
    //   49	65	245	java/lang/Exception
  }
  
  /* Error */
  public final boolean a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 81
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore 4
    //   8: aconst_null
    //   9: astore_3
    //   10: aload_0
    //   11: getfield 30	com/tencent/map/tools/internal/w:b	Ljava/io/File;
    //   14: invokevirtual 49	java/io/File:exists	()Z
    //   17: ifne +38 -> 55
    //   20: new 32	java/io/File
    //   23: dup
    //   24: aload_0
    //   25: getfield 30	com/tencent/map/tools/internal/w:b	Ljava/io/File;
    //   28: invokevirtual 84	java/io/File:getParent	()Ljava/lang/String;
    //   31: invokespecial 34	java/io/File:<init>	(Ljava/lang/String;)V
    //   34: astore_2
    //   35: aload_2
    //   36: invokevirtual 49	java/io/File:exists	()Z
    //   39: ifne +16 -> 55
    //   42: aload_2
    //   43: invokevirtual 87	java/io/File:mkdirs	()Z
    //   46: pop
    //   47: aload_0
    //   48: getfield 30	com/tencent/map/tools/internal/w:b	Ljava/io/File;
    //   51: invokevirtual 90	java/io/File:createNewFile	()Z
    //   54: pop
    //   55: new 92	java/io/FileOutputStream
    //   58: dup
    //   59: aload_0
    //   60: getfield 30	com/tencent/map/tools/internal/w:b	Ljava/io/File;
    //   63: iconst_0
    //   64: invokespecial 95	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   67: astore_2
    //   68: aload_2
    //   69: aload_1
    //   70: invokevirtual 97	java/io/FileOutputStream:write	([B)V
    //   73: aload_2
    //   74: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   77: aload_2
    //   78: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   81: ldc 81
    //   83: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   86: iconst_1
    //   87: ireturn
    //   88: astore_1
    //   89: aload_3
    //   90: astore_1
    //   91: aload_1
    //   92: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   95: ldc 81
    //   97: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_1
    //   103: aload 4
    //   105: astore_2
    //   106: aload_2
    //   107: invokevirtual 98	java/io/FileOutputStream:close	()V
    //   110: ldc 81
    //   112: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   115: aload_1
    //   116: athrow
    //   117: astore_1
    //   118: goto -37 -> 81
    //   121: astore_1
    //   122: goto -27 -> 95
    //   125: astore_2
    //   126: goto -16 -> 110
    //   129: astore_1
    //   130: goto -24 -> 106
    //   133: astore_1
    //   134: aload_2
    //   135: astore_1
    //   136: goto -45 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	w
    //   0	139	1	paramArrayOfByte	byte[]
    //   34	73	2	localObject1	Object
    //   125	10	2	localException	java.lang.Exception
    //   9	81	3	localObject2	Object
    //   6	98	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   10	55	88	java/lang/Exception
    //   55	68	88	java/lang/Exception
    //   10	55	102	finally
    //   55	68	102	finally
    //   77	81	117	java/lang/Exception
    //   91	95	121	java/lang/Exception
    //   106	110	125	java/lang/Exception
    //   68	77	129	finally
    //   68	77	133	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.w
 * JD-Core Version:    0.7.0.1
 */