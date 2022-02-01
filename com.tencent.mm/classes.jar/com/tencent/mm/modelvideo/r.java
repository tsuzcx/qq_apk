package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class r
{
  /* Error */
  public static boolean Ql(String paramString)
  {
    // Byte code:
    //   0: ldc 11
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 19
    //   7: ldc 21
    //   9: aload_0
    //   10: invokestatic 27	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   13: invokevirtual 31	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: aload_0
    //   20: invokestatic 42	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   23: ifeq +10 -> 33
    //   26: ldc 11
    //   28: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: iconst_0
    //   32: ireturn
    //   33: aconst_null
    //   34: astore_2
    //   35: aconst_null
    //   36: astore_1
    //   37: aload_0
    //   38: invokestatic 51	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   41: astore_0
    //   42: aload_0
    //   43: astore_1
    //   44: aload_0
    //   45: astore_2
    //   46: bipush 10
    //   48: newarray byte
    //   50: astore_3
    //   51: aload_0
    //   52: astore_1
    //   53: aload_0
    //   54: astore_2
    //   55: aload_0
    //   56: aload_3
    //   57: iconst_0
    //   58: bipush 10
    //   60: invokevirtual 57	java/io/InputStream:read	([BII)I
    //   63: pop
    //   64: aload_0
    //   65: astore_1
    //   66: aload_0
    //   67: astore_2
    //   68: aload_3
    //   69: invokestatic 61	com/tencent/mm/modelvideo/r:bytesToHexString	([B)Ljava/lang/String;
    //   72: astore_3
    //   73: aload_0
    //   74: astore_1
    //   75: aload_0
    //   76: astore_2
    //   77: aload_3
    //   78: invokestatic 42	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   81: ifne +69 -> 150
    //   84: aload_0
    //   85: astore_1
    //   86: aload_0
    //   87: astore_2
    //   88: aload_3
    //   89: invokevirtual 65	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   92: astore_3
    //   93: aload_0
    //   94: astore_1
    //   95: aload_0
    //   96: astore_2
    //   97: ldc 19
    //   99: ldc 67
    //   101: aload_3
    //   102: invokestatic 27	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   105: invokevirtual 31	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   108: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_0
    //   112: astore_1
    //   113: aload_0
    //   114: astore_2
    //   115: aload_3
    //   116: ldc 69
    //   118: invokevirtual 73	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   121: ifeq +29 -> 150
    //   124: aload_0
    //   125: astore_1
    //   126: aload_0
    //   127: astore_2
    //   128: ldc 19
    //   130: ldc 75
    //   132: invokestatic 37	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload_0
    //   136: ifnull +7 -> 143
    //   139: aload_0
    //   140: invokevirtual 79	java/io/InputStream:close	()V
    //   143: ldc 11
    //   145: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   148: iconst_1
    //   149: ireturn
    //   150: aload_0
    //   151: ifnull +7 -> 158
    //   154: aload_0
    //   155: invokevirtual 79	java/io/InputStream:close	()V
    //   158: ldc 11
    //   160: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: iconst_0
    //   164: ireturn
    //   165: astore_0
    //   166: aload_1
    //   167: astore_2
    //   168: ldc 19
    //   170: ldc 81
    //   172: iconst_1
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_0
    //   179: invokestatic 85	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   182: aastore
    //   183: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   186: aload_1
    //   187: ifnull -29 -> 158
    //   190: aload_1
    //   191: invokevirtual 79	java/io/InputStream:close	()V
    //   194: goto -36 -> 158
    //   197: astore_0
    //   198: goto -40 -> 158
    //   201: astore_0
    //   202: aload_2
    //   203: ifnull +7 -> 210
    //   206: aload_2
    //   207: invokevirtual 79	java/io/InputStream:close	()V
    //   210: ldc 11
    //   212: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   215: aload_0
    //   216: athrow
    //   217: astore_0
    //   218: goto -75 -> 143
    //   221: astore_0
    //   222: goto -64 -> 158
    //   225: astore_1
    //   226: goto -16 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramString	String
    //   36	155	1	str	String
    //   225	1	1	localIOException	java.io.IOException
    //   34	173	2	localObject1	Object
    //   50	66	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   37	42	165	java/lang/Exception
    //   46	51	165	java/lang/Exception
    //   55	64	165	java/lang/Exception
    //   68	73	165	java/lang/Exception
    //   77	84	165	java/lang/Exception
    //   88	93	165	java/lang/Exception
    //   97	111	165	java/lang/Exception
    //   115	124	165	java/lang/Exception
    //   128	135	165	java/lang/Exception
    //   190	194	197	java/io/IOException
    //   37	42	201	finally
    //   46	51	201	finally
    //   55	64	201	finally
    //   68	73	201	finally
    //   77	84	201	finally
    //   88	93	201	finally
    //   97	111	201	finally
    //   115	124	201	finally
    //   128	135	201	finally
    //   168	186	201	finally
    //   139	143	217	java/io/IOException
    //   154	158	221	java/io/IOException
    //   206	210	225	java/io/IOException
  }
  
  /* Error */
  public static boolean Qm(String paramString)
  {
    // Byte code:
    //   0: ldc 92
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 95	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   9: ifne +10 -> 19
    //   12: ldc 92
    //   14: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: iconst_0
    //   18: ireturn
    //   19: aconst_null
    //   20: astore_3
    //   21: aconst_null
    //   22: astore_2
    //   23: aload_0
    //   24: invokestatic 51	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   27: astore_0
    //   28: aload_0
    //   29: astore_2
    //   30: aload_0
    //   31: astore_3
    //   32: bipush 32
    //   34: newarray byte
    //   36: astore 4
    //   38: aload_0
    //   39: astore_2
    //   40: aload_0
    //   41: astore_3
    //   42: aload_0
    //   43: aload 4
    //   45: iconst_0
    //   46: bipush 32
    //   48: invokevirtual 57	java/io/InputStream:read	([BII)I
    //   51: pop
    //   52: aload_0
    //   53: astore_2
    //   54: aload_0
    //   55: astore_3
    //   56: aload 4
    //   58: invokestatic 61	com/tencent/mm/modelvideo/r:bytesToHexString	([B)Ljava/lang/String;
    //   61: astore 4
    //   63: aload_0
    //   64: astore_2
    //   65: aload_0
    //   66: astore_3
    //   67: aload 4
    //   69: invokestatic 42	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   72: ifne +37 -> 109
    //   75: aload_0
    //   76: astore_2
    //   77: aload_0
    //   78: astore_3
    //   79: aload 4
    //   81: invokevirtual 65	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   84: ldc 97
    //   86: invokevirtual 73	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   89: istore_1
    //   90: iload_1
    //   91: ifeq +18 -> 109
    //   94: aload_0
    //   95: ifnull +7 -> 102
    //   98: aload_0
    //   99: invokevirtual 79	java/io/InputStream:close	()V
    //   102: ldc 92
    //   104: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: iconst_1
    //   108: ireturn
    //   109: aload_0
    //   110: ifnull +7 -> 117
    //   113: aload_0
    //   114: invokevirtual 79	java/io/InputStream:close	()V
    //   117: ldc 92
    //   119: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: iconst_0
    //   123: ireturn
    //   124: astore_0
    //   125: aload_2
    //   126: astore_3
    //   127: ldc 19
    //   129: ldc 81
    //   131: iconst_1
    //   132: anewarray 4	java/lang/Object
    //   135: dup
    //   136: iconst_0
    //   137: aload_0
    //   138: invokestatic 85	com/tencent/mm/sdk/platformtools/Util:stackTraceToString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   141: aastore
    //   142: invokestatic 89	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_2
    //   146: ifnull -29 -> 117
    //   149: aload_2
    //   150: invokevirtual 79	java/io/InputStream:close	()V
    //   153: goto -36 -> 117
    //   156: astore_0
    //   157: goto -40 -> 117
    //   160: astore_0
    //   161: aload_3
    //   162: ifnull +7 -> 169
    //   165: aload_3
    //   166: invokevirtual 79	java/io/InputStream:close	()V
    //   169: ldc 92
    //   171: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_0
    //   175: athrow
    //   176: astore_0
    //   177: goto -75 -> 102
    //   180: astore_0
    //   181: goto -64 -> 117
    //   184: astore_2
    //   185: goto -16 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramString	String
    //   89	2	1	bool	boolean
    //   22	128	2	str	String
    //   184	1	2	localIOException	java.io.IOException
    //   20	146	3	localObject1	Object
    //   36	44	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   23	28	124	java/lang/Exception
    //   32	38	124	java/lang/Exception
    //   42	52	124	java/lang/Exception
    //   56	63	124	java/lang/Exception
    //   67	75	124	java/lang/Exception
    //   79	90	124	java/lang/Exception
    //   149	153	156	java/io/IOException
    //   23	28	160	finally
    //   32	38	160	finally
    //   42	52	160	finally
    //   56	63	160	finally
    //   67	75	160	finally
    //   79	90	160	finally
    //   127	145	160	finally
    //   98	102	176	java/io/IOException
    //   113	117	180	java/io/IOException
    //   165	169	184	java/io/IOException
  }
  
  private static String bytesToHexString(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133566);
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayOfByte.length <= 0)
    {
      AppMethodBeat.o(133566);
      return null;
    }
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str.length() < 2) {
        localStringBuilder.append(0);
      }
      localStringBuilder.append(str);
      i += 1;
    }
    paramArrayOfByte = localStringBuilder.toString();
    AppMethodBeat.o(133566);
    return paramArrayOfByte;
  }
  
  /* Error */
  public static boolean isH265Video(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 127
    //   5: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokestatic 95	com/tencent/mm/vfs/s:YS	(Ljava/lang/String;)Z
    //   12: ifne +10 -> 22
    //   15: ldc 127
    //   17: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_0
    //   21: ireturn
    //   22: ldc 19
    //   24: ldc 129
    //   26: iconst_1
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload_0
    //   33: aastore
    //   34: invokestatic 131	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: ldc 133
    //   39: invokestatic 139	com/tencent/mm/kernel/g:af	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   42: checkcast 133	com/tencent/mm/plugin/expt/b/b
    //   45: getstatic 145	com/tencent/mm/plugin/expt/b/b$a:sjw	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   48: iconst_1
    //   49: invokeinterface 149 3 0
    //   54: ifne +204 -> 258
    //   57: new 151	com/tencent/mm/compatible/i/c
    //   60: dup
    //   61: invokespecial 152	com/tencent/mm/compatible/i/c:<init>	()V
    //   64: astore 5
    //   66: aload 5
    //   68: aload_0
    //   69: invokevirtual 156	com/tencent/mm/compatible/i/c:setDataSource	(Ljava/lang/String;)V
    //   72: aload 5
    //   74: getfield 160	com/tencent/mm/compatible/i/c:gLF	Landroid/media/MediaExtractor;
    //   77: invokevirtual 165	android/media/MediaExtractor:getTrackCount	()I
    //   80: istore_2
    //   81: iconst_0
    //   82: istore_1
    //   83: iload_1
    //   84: iload_2
    //   85: if_icmpge +99 -> 184
    //   88: aload 5
    //   90: iload_1
    //   91: invokevirtual 169	com/tencent/mm/compatible/i/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   94: ldc 171
    //   96: invokevirtual 176	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: astore 4
    //   101: ldc 178
    //   103: aload 4
    //   105: invokevirtual 181	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   108: istore_3
    //   109: iload_3
    //   110: ifeq +40 -> 150
    //   113: aload 5
    //   115: getfield 160	com/tencent/mm/compatible/i/c:gLF	Landroid/media/MediaExtractor;
    //   118: invokevirtual 184	android/media/MediaExtractor:release	()V
    //   121: ldc 127
    //   123: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: iconst_1
    //   127: ireturn
    //   128: astore 6
    //   130: aconst_null
    //   131: astore 4
    //   133: ldc 19
    //   135: aload 6
    //   137: ldc 129
    //   139: iconst_1
    //   140: anewarray 4	java/lang/Object
    //   143: dup
    //   144: iconst_0
    //   145: aload_0
    //   146: aastore
    //   147: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   150: ldc 178
    //   152: aload 4
    //   154: invokevirtual 181	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   157: istore_3
    //   158: iload_3
    //   159: ifeq +18 -> 177
    //   162: aload 5
    //   164: getfield 160	com/tencent/mm/compatible/i/c:gLF	Landroid/media/MediaExtractor;
    //   167: invokevirtual 184	android/media/MediaExtractor:release	()V
    //   170: ldc 127
    //   172: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: iconst_1
    //   176: ireturn
    //   177: iload_1
    //   178: iconst_1
    //   179: iadd
    //   180: istore_1
    //   181: goto -98 -> 83
    //   184: aload 5
    //   186: getfield 160	com/tencent/mm/compatible/i/c:gLF	Landroid/media/MediaExtractor;
    //   189: invokevirtual 184	android/media/MediaExtractor:release	()V
    //   192: ldc 127
    //   194: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: iconst_0
    //   198: ireturn
    //   199: astore 5
    //   201: ldc 19
    //   203: aload 5
    //   205: ldc 129
    //   207: iconst_1
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload_0
    //   214: aastore
    //   215: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   218: aload 4
    //   220: ifnull -28 -> 192
    //   223: aload 4
    //   225: getfield 160	com/tencent/mm/compatible/i/c:gLF	Landroid/media/MediaExtractor;
    //   228: invokevirtual 184	android/media/MediaExtractor:release	()V
    //   231: goto -39 -> 192
    //   234: astore_0
    //   235: aconst_null
    //   236: astore 4
    //   238: aload 4
    //   240: ifnull +11 -> 251
    //   243: aload 4
    //   245: getfield 160	com/tencent/mm/compatible/i/c:gLF	Landroid/media/MediaExtractor;
    //   248: invokevirtual 184	android/media/MediaExtractor:release	()V
    //   251: ldc 127
    //   253: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   256: aload_0
    //   257: athrow
    //   258: aload_0
    //   259: invokestatic 193	com/tencent/mm/plugin/sight/base/SightVideoJNI:isH265VideoVFS	(Ljava/lang/String;)Z
    //   262: istore_3
    //   263: ldc 127
    //   265: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: iload_3
    //   269: ireturn
    //   270: astore_0
    //   271: aload 5
    //   273: astore 4
    //   275: goto -37 -> 238
    //   278: astore_0
    //   279: goto -41 -> 238
    //   282: astore 6
    //   284: aload 5
    //   286: astore 4
    //   288: aload 6
    //   290: astore 5
    //   292: goto -91 -> 201
    //   295: astore 6
    //   297: goto -164 -> 133
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	300	0	paramString	String
    //   82	99	1	i	int
    //   80	6	2	j	int
    //   108	161	3	bool	boolean
    //   1	286	4	localObject1	Object
    //   64	121	5	localc	com.tencent.mm.compatible.i.c
    //   199	86	5	localThrowable1	java.lang.Throwable
    //   290	1	5	localObject2	Object
    //   128	8	6	localThrowable2	java.lang.Throwable
    //   282	7	6	localThrowable3	java.lang.Throwable
    //   295	1	6	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   88	101	128	java/lang/Throwable
    //   57	66	199	java/lang/Throwable
    //   57	66	234	finally
    //   66	81	270	finally
    //   88	101	270	finally
    //   101	109	270	finally
    //   133	150	270	finally
    //   150	158	270	finally
    //   201	218	278	finally
    //   66	81	282	java/lang/Throwable
    //   133	150	282	java/lang/Throwable
    //   150	158	282	java/lang/Throwable
    //   101	109	295	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.r
 * JD-Core Version:    0.7.0.1
 */