package com.tencent.mm.app;

import java.util.Properties;

final class q
{
  Properties cLB;
  private String filePath;
  
  /* Error */
  public q(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 17	java/lang/Object:<init>	()V
    //   4: ldc 18
    //   6: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 26	com/tencent/mm/app/q:cLB	Ljava/util/Properties;
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 28	com/tencent/mm/app/q:filePath	Ljava/lang/String;
    //   19: aload_0
    //   20: new 30	java/util/Properties
    //   23: dup
    //   24: invokespecial 31	java/util/Properties:<init>	()V
    //   27: putfield 26	com/tencent/mm/app/q:cLB	Ljava/util/Properties;
    //   30: aload_0
    //   31: aload_1
    //   32: putfield 28	com/tencent/mm/app/q:filePath	Ljava/lang/String;
    //   35: new 33	java/io/FileInputStream
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 35	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   43: astore_3
    //   44: aload_3
    //   45: astore_2
    //   46: aload_0
    //   47: getfield 26	com/tencent/mm/app/q:cLB	Ljava/util/Properties;
    //   50: aload_3
    //   51: invokevirtual 39	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   54: aload_3
    //   55: invokevirtual 42	java/io/FileInputStream:close	()V
    //   58: ldc 18
    //   60: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: return
    //   64: astore_2
    //   65: ldc 47
    //   67: ldc 49
    //   69: iconst_2
    //   70: anewarray 4	java/lang/Object
    //   73: dup
    //   74: iconst_0
    //   75: aload_1
    //   76: aastore
    //   77: dup
    //   78: iconst_1
    //   79: aload_2
    //   80: invokevirtual 53	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   83: aastore
    //   84: invokestatic 59	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: ldc 18
    //   89: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: return
    //   93: astore 4
    //   95: aconst_null
    //   96: astore_3
    //   97: aload_3
    //   98: astore_2
    //   99: ldc 47
    //   101: ldc 61
    //   103: iconst_2
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload_1
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: aload 4
    //   115: invokevirtual 62	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   118: aastore
    //   119: invokestatic 59	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload_3
    //   123: ifnull +86 -> 209
    //   126: aload_3
    //   127: invokevirtual 42	java/io/FileInputStream:close	()V
    //   130: ldc 18
    //   132: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: return
    //   136: astore_2
    //   137: ldc 47
    //   139: ldc 49
    //   141: iconst_2
    //   142: anewarray 4	java/lang/Object
    //   145: dup
    //   146: iconst_0
    //   147: aload_1
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: aload_2
    //   152: invokevirtual 53	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   155: aastore
    //   156: invokestatic 59	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: ldc 18
    //   161: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   164: return
    //   165: astore_3
    //   166: aconst_null
    //   167: astore_2
    //   168: aload_2
    //   169: ifnull +7 -> 176
    //   172: aload_2
    //   173: invokevirtual 42	java/io/FileInputStream:close	()V
    //   176: ldc 18
    //   178: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   181: aload_3
    //   182: athrow
    //   183: astore_2
    //   184: ldc 47
    //   186: ldc 49
    //   188: iconst_2
    //   189: anewarray 4	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: aload_1
    //   195: aastore
    //   196: dup
    //   197: iconst_1
    //   198: aload_2
    //   199: invokevirtual 53	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   202: aastore
    //   203: invokestatic 59	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   206: goto -30 -> 176
    //   209: ldc 18
    //   211: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: return
    //   215: astore_3
    //   216: goto -48 -> 168
    //   219: astore 4
    //   221: goto -124 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	q
    //   0	224	1	paramString	String
    //   45	1	2	localFileInputStream1	java.io.FileInputStream
    //   64	16	2	localIOException1	java.io.IOException
    //   98	1	2	localFileInputStream2	java.io.FileInputStream
    //   136	16	2	localIOException2	java.io.IOException
    //   167	6	2	localObject1	Object
    //   183	16	2	localIOException3	java.io.IOException
    //   43	84	3	localFileInputStream3	java.io.FileInputStream
    //   165	17	3	localObject2	Object
    //   215	1	3	localObject3	Object
    //   93	21	4	localException1	java.lang.Exception
    //   219	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   54	58	64	java/io/IOException
    //   35	44	93	java/lang/Exception
    //   126	130	136	java/io/IOException
    //   35	44	165	finally
    //   172	176	183	java/io/IOException
    //   46	54	215	finally
    //   99	122	215	finally
    //   46	54	219	java/lang/Exception
  }
  
  /* Error */
  public final boolean L(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 66
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 68	java/io/FileOutputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 28	com/tencent/mm/app/q:filePath	Ljava/lang/String;
    //   15: invokespecial 69	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   18: astore 5
    //   20: aload 5
    //   22: astore 4
    //   24: aload_0
    //   25: getfield 26	com/tencent/mm/app/q:cLB	Ljava/util/Properties;
    //   28: aload_1
    //   29: aload_2
    //   30: invokevirtual 73	java/util/Properties:setProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   33: pop
    //   34: aload 5
    //   36: astore 4
    //   38: aload_0
    //   39: getfield 26	com/tencent/mm/app/q:cLB	Ljava/util/Properties;
    //   42: aload 5
    //   44: ldc 75
    //   46: invokevirtual 79	java/util/Properties:store	(Ljava/io/OutputStream;Ljava/lang/String;)V
    //   49: aload 5
    //   51: invokevirtual 80	java/io/FileOutputStream:close	()V
    //   54: ldc 66
    //   56: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: iload_3
    //   60: ireturn
    //   61: astore_1
    //   62: ldc 47
    //   64: ldc 49
    //   66: iconst_2
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload_0
    //   73: getfield 28	com/tencent/mm/app/q:filePath	Ljava/lang/String;
    //   76: aastore
    //   77: dup
    //   78: iconst_1
    //   79: aload_1
    //   80: invokevirtual 53	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   83: aastore
    //   84: invokestatic 59	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   87: goto -33 -> 54
    //   90: astore_2
    //   91: aconst_null
    //   92: astore_1
    //   93: aload_1
    //   94: astore 4
    //   96: ldc 47
    //   98: ldc 82
    //   100: iconst_2
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_0
    //   107: getfield 28	com/tencent/mm/app/q:filePath	Ljava/lang/String;
    //   110: aastore
    //   111: dup
    //   112: iconst_1
    //   113: aload_2
    //   114: invokevirtual 62	java/lang/Exception:getLocalizedMessage	()Ljava/lang/String;
    //   117: aastore
    //   118: invokestatic 59	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: aload_1
    //   122: ifnull +104 -> 226
    //   125: aload_1
    //   126: invokevirtual 80	java/io/FileOutputStream:close	()V
    //   129: iconst_0
    //   130: istore_3
    //   131: goto -77 -> 54
    //   134: astore_1
    //   135: ldc 47
    //   137: ldc 49
    //   139: iconst_2
    //   140: anewarray 4	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: aload_0
    //   146: getfield 28	com/tencent/mm/app/q:filePath	Ljava/lang/String;
    //   149: aastore
    //   150: dup
    //   151: iconst_1
    //   152: aload_1
    //   153: invokevirtual 53	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   156: aastore
    //   157: invokestatic 59	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   160: iconst_0
    //   161: istore_3
    //   162: goto -108 -> 54
    //   165: astore_1
    //   166: aconst_null
    //   167: astore 4
    //   169: aload 4
    //   171: ifnull +8 -> 179
    //   174: aload 4
    //   176: invokevirtual 80	java/io/FileOutputStream:close	()V
    //   179: ldc 66
    //   181: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_1
    //   185: athrow
    //   186: astore_2
    //   187: ldc 47
    //   189: ldc 49
    //   191: iconst_2
    //   192: anewarray 4	java/lang/Object
    //   195: dup
    //   196: iconst_0
    //   197: aload_0
    //   198: getfield 28	com/tencent/mm/app/q:filePath	Ljava/lang/String;
    //   201: aastore
    //   202: dup
    //   203: iconst_1
    //   204: aload_2
    //   205: invokevirtual 53	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   208: aastore
    //   209: invokestatic 59	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: goto -33 -> 179
    //   215: astore_1
    //   216: goto -47 -> 169
    //   219: astore_2
    //   220: aload 5
    //   222: astore_1
    //   223: goto -130 -> 93
    //   226: iconst_0
    //   227: istore_3
    //   228: goto -174 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	231	0	this	q
    //   0	231	1	paramString1	String
    //   0	231	2	paramString2	String
    //   1	227	3	bool	boolean
    //   22	153	4	localObject	Object
    //   18	203	5	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   49	54	61	java/io/IOException
    //   7	20	90	java/lang/Exception
    //   125	129	134	java/io/IOException
    //   7	20	165	finally
    //   174	179	186	java/io/IOException
    //   24	34	215	finally
    //   38	49	215	finally
    //   96	121	215	finally
    //   24	34	219	java/lang/Exception
    //   38	49	219	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.q
 * JD-Core Version:    0.7.0.1
 */