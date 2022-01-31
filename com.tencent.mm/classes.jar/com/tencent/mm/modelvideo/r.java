package com.tencent.mm.modelvideo;

public final class r
{
  private static String bytesToHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramArrayOfByte.length <= 0) {
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
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static boolean nL(String paramString)
  {
    // Byte code:
    //   0: ldc 44
    //   2: new 8	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 46
    //   8: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18: invokestatic 55	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: invokestatic 60	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   25: ifeq +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: aconst_null
    //   31: astore_2
    //   32: aconst_null
    //   33: astore_1
    //   34: aload_0
    //   35: invokestatic 66	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   38: astore_0
    //   39: aload_0
    //   40: astore_1
    //   41: aload_0
    //   42: astore_2
    //   43: bipush 10
    //   45: newarray byte
    //   47: astore_3
    //   48: aload_0
    //   49: astore_1
    //   50: aload_0
    //   51: astore_2
    //   52: aload_0
    //   53: aload_3
    //   54: iconst_0
    //   55: bipush 10
    //   57: invokevirtual 72	java/io/InputStream:read	([BII)I
    //   60: pop
    //   61: aload_0
    //   62: astore_1
    //   63: aload_0
    //   64: astore_2
    //   65: aload_3
    //   66: invokestatic 74	com/tencent/mm/modelvideo/r:bytesToHexString	([B)Ljava/lang/String;
    //   69: astore_3
    //   70: aload_0
    //   71: astore_1
    //   72: aload_0
    //   73: astore_2
    //   74: aload_3
    //   75: invokestatic 60	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   78: ifne +71 -> 149
    //   81: aload_0
    //   82: astore_1
    //   83: aload_0
    //   84: astore_2
    //   85: aload_3
    //   86: invokevirtual 77	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   89: astore_3
    //   90: aload_0
    //   91: astore_1
    //   92: aload_0
    //   93: astore_2
    //   94: ldc 44
    //   96: new 8	java/lang/StringBuilder
    //   99: dup
    //   100: ldc 79
    //   102: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_3
    //   106: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 55	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_0
    //   116: astore_1
    //   117: aload_0
    //   118: astore_2
    //   119: aload_3
    //   120: ldc 81
    //   122: invokevirtual 85	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   125: ifeq +24 -> 149
    //   128: aload_0
    //   129: astore_1
    //   130: aload_0
    //   131: astore_2
    //   132: ldc 44
    //   134: ldc 87
    //   136: invokestatic 55	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: ifnull +7 -> 147
    //   143: aload_0
    //   144: invokevirtual 90	java/io/InputStream:close	()V
    //   147: iconst_1
    //   148: ireturn
    //   149: aload_0
    //   150: ifnull -122 -> 28
    //   153: aload_0
    //   154: invokevirtual 90	java/io/InputStream:close	()V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore_0
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_0
    //   163: aload_1
    //   164: astore_2
    //   165: ldc 44
    //   167: ldc 92
    //   169: iconst_1
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_0
    //   176: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   179: aastore
    //   180: invokestatic 100	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_1
    //   184: ifnull -156 -> 28
    //   187: aload_1
    //   188: invokevirtual 90	java/io/InputStream:close	()V
    //   191: iconst_0
    //   192: ireturn
    //   193: astore_0
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_0
    //   197: aload_2
    //   198: ifnull +7 -> 205
    //   201: aload_2
    //   202: invokevirtual 90	java/io/InputStream:close	()V
    //   205: aload_0
    //   206: athrow
    //   207: astore_0
    //   208: goto -61 -> 147
    //   211: astore_1
    //   212: goto -7 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramString	String
    //   33	155	1	str	String
    //   211	1	1	localIOException	java.io.IOException
    //   31	171	2	localObject1	Object
    //   47	73	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   153	157	159	java/io/IOException
    //   34	39	162	java/lang/Exception
    //   43	48	162	java/lang/Exception
    //   52	61	162	java/lang/Exception
    //   65	70	162	java/lang/Exception
    //   74	81	162	java/lang/Exception
    //   85	90	162	java/lang/Exception
    //   94	115	162	java/lang/Exception
    //   119	128	162	java/lang/Exception
    //   132	139	162	java/lang/Exception
    //   187	191	193	java/io/IOException
    //   34	39	196	finally
    //   43	48	196	finally
    //   52	61	196	finally
    //   65	70	196	finally
    //   74	81	196	finally
    //   85	90	196	finally
    //   94	115	196	finally
    //   119	128	196	finally
    //   132	139	196	finally
    //   165	183	196	finally
    //   143	147	207	java/io/IOException
    //   201	205	211	java/io/IOException
  }
  
  /* Error */
  public static boolean nM(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 104	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   4: ifne +5 -> 9
    //   7: iconst_0
    //   8: ireturn
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: invokestatic 66	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_0
    //   18: aload_0
    //   19: astore_2
    //   20: aload_0
    //   21: astore_3
    //   22: bipush 32
    //   24: newarray byte
    //   26: astore 4
    //   28: aload_0
    //   29: astore_2
    //   30: aload_0
    //   31: astore_3
    //   32: aload_0
    //   33: aload 4
    //   35: iconst_0
    //   36: bipush 32
    //   38: invokevirtual 72	java/io/InputStream:read	([BII)I
    //   41: pop
    //   42: aload_0
    //   43: astore_2
    //   44: aload_0
    //   45: astore_3
    //   46: aload 4
    //   48: invokestatic 74	com/tencent/mm/modelvideo/r:bytesToHexString	([B)Ljava/lang/String;
    //   51: astore 4
    //   53: aload_0
    //   54: astore_2
    //   55: aload_0
    //   56: astore_3
    //   57: aload 4
    //   59: invokestatic 60	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   62: ifne +32 -> 94
    //   65: aload_0
    //   66: astore_2
    //   67: aload_0
    //   68: astore_3
    //   69: aload 4
    //   71: invokevirtual 77	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   74: ldc 106
    //   76: invokevirtual 85	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   79: istore_1
    //   80: iload_1
    //   81: ifeq +13 -> 94
    //   84: aload_0
    //   85: ifnull +7 -> 92
    //   88: aload_0
    //   89: invokevirtual 90	java/io/InputStream:close	()V
    //   92: iconst_1
    //   93: ireturn
    //   94: aload_0
    //   95: ifnull -88 -> 7
    //   98: aload_0
    //   99: invokevirtual 90	java/io/InputStream:close	()V
    //   102: iconst_0
    //   103: ireturn
    //   104: astore_0
    //   105: iconst_0
    //   106: ireturn
    //   107: astore_0
    //   108: aload_2
    //   109: astore_3
    //   110: ldc 44
    //   112: ldc 92
    //   114: iconst_1
    //   115: anewarray 4	java/lang/Object
    //   118: dup
    //   119: iconst_0
    //   120: aload_0
    //   121: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   124: aastore
    //   125: invokestatic 100	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_2
    //   129: ifnull -122 -> 7
    //   132: aload_2
    //   133: invokevirtual 90	java/io/InputStream:close	()V
    //   136: iconst_0
    //   137: ireturn
    //   138: astore_0
    //   139: iconst_0
    //   140: ireturn
    //   141: astore_0
    //   142: aload_3
    //   143: ifnull +7 -> 150
    //   146: aload_3
    //   147: invokevirtual 90	java/io/InputStream:close	()V
    //   150: aload_0
    //   151: athrow
    //   152: astore_0
    //   153: goto -61 -> 92
    //   156: astore_2
    //   157: goto -7 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	160	0	paramString	String
    //   79	2	1	bool	boolean
    //   12	121	2	str	String
    //   156	1	2	localIOException	java.io.IOException
    //   10	137	3	localObject1	Object
    //   26	44	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   98	102	104	java/io/IOException
    //   13	18	107	java/lang/Exception
    //   22	28	107	java/lang/Exception
    //   32	42	107	java/lang/Exception
    //   46	53	107	java/lang/Exception
    //   57	65	107	java/lang/Exception
    //   69	80	107	java/lang/Exception
    //   132	136	138	java/io/IOException
    //   13	18	141	finally
    //   22	28	141	finally
    //   32	42	141	finally
    //   46	53	141	finally
    //   57	65	141	finally
    //   69	80	141	finally
    //   110	128	141	finally
    //   88	92	152	java/io/IOException
    //   146	150	156	java/io/IOException
  }
  
  /* Error */
  public static boolean nN(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: invokestatic 104	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
    //   7: ifne +5 -> 12
    //   10: iconst_0
    //   11: ireturn
    //   12: ldc 44
    //   14: ldc 111
    //   16: iconst_1
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_0
    //   23: aastore
    //   24: invokestatic 113	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   27: new 115	android/media/MediaExtractor
    //   30: dup
    //   31: invokespecial 116	android/media/MediaExtractor:<init>	()V
    //   34: astore 5
    //   36: aload 5
    //   38: aload_0
    //   39: invokevirtual 119	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   42: aload 5
    //   44: invokevirtual 122	android/media/MediaExtractor:getTrackCount	()I
    //   47: istore_2
    //   48: iconst_0
    //   49: istore_1
    //   50: iload_1
    //   51: iload_2
    //   52: if_icmpge +83 -> 135
    //   55: aload 5
    //   57: iload_1
    //   58: invokevirtual 126	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   61: ldc 128
    //   63: invokevirtual 134	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 4
    //   68: ldc 136
    //   70: aload 4
    //   72: invokevirtual 139	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   75: istore_3
    //   76: iload_3
    //   77: ifeq +32 -> 109
    //   80: aload 5
    //   82: invokevirtual 142	android/media/MediaExtractor:release	()V
    //   85: iconst_1
    //   86: ireturn
    //   87: astore 6
    //   89: aconst_null
    //   90: astore 4
    //   92: ldc 44
    //   94: aload 6
    //   96: ldc 111
    //   98: iconst_1
    //   99: anewarray 4	java/lang/Object
    //   102: dup
    //   103: iconst_0
    //   104: aload_0
    //   105: aastore
    //   106: invokestatic 146	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   109: ldc 136
    //   111: aload 4
    //   113: invokevirtual 139	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   116: istore_3
    //   117: iload_3
    //   118: ifeq +10 -> 128
    //   121: aload 5
    //   123: invokevirtual 142	android/media/MediaExtractor:release	()V
    //   126: iconst_1
    //   127: ireturn
    //   128: iload_1
    //   129: iconst_1
    //   130: iadd
    //   131: istore_1
    //   132: goto -82 -> 50
    //   135: aload 5
    //   137: invokevirtual 142	android/media/MediaExtractor:release	()V
    //   140: iconst_0
    //   141: ireturn
    //   142: astore 5
    //   144: ldc 44
    //   146: aload 5
    //   148: ldc 111
    //   150: iconst_1
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_0
    //   157: aastore
    //   158: invokestatic 146	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload 4
    //   163: ifnull -153 -> 10
    //   166: aload 4
    //   168: invokevirtual 142	android/media/MediaExtractor:release	()V
    //   171: iconst_0
    //   172: ireturn
    //   173: astore_0
    //   174: aconst_null
    //   175: astore 4
    //   177: aload 4
    //   179: ifnull +8 -> 187
    //   182: aload 4
    //   184: invokevirtual 142	android/media/MediaExtractor:release	()V
    //   187: aload_0
    //   188: athrow
    //   189: astore_0
    //   190: aload 5
    //   192: astore 4
    //   194: goto -17 -> 177
    //   197: astore_0
    //   198: goto -21 -> 177
    //   201: astore 6
    //   203: aload 5
    //   205: astore 4
    //   207: aload 6
    //   209: astore 5
    //   211: goto -67 -> 144
    //   214: astore 6
    //   216: goto -124 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	paramString	String
    //   49	83	1	i	int
    //   47	6	2	j	int
    //   75	43	3	bool	boolean
    //   1	205	4	localObject1	Object
    //   34	102	5	localMediaExtractor	android.media.MediaExtractor
    //   142	62	5	localThrowable1	java.lang.Throwable
    //   209	1	5	localObject2	Object
    //   87	8	6	localThrowable2	java.lang.Throwable
    //   201	7	6	localThrowable3	java.lang.Throwable
    //   214	1	6	localThrowable4	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   55	68	87	java/lang/Throwable
    //   27	36	142	java/lang/Throwable
    //   27	36	173	finally
    //   36	48	189	finally
    //   55	68	189	finally
    //   68	76	189	finally
    //   92	109	189	finally
    //   109	117	189	finally
    //   144	161	197	finally
    //   36	48	201	java/lang/Throwable
    //   92	109	201	java/lang/Throwable
    //   109	117	201	java/lang/Throwable
    //   68	76	214	java/lang/Throwable
  }
  
  /* Error */
  public static boolean nO(String paramString)
  {
    // Byte code:
    //   0: ldc 44
    //   2: new 8	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 46
    //   8: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_0
    //   12: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18: invokestatic 55	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: invokestatic 60	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   25: ifeq +5 -> 30
    //   28: iconst_0
    //   29: ireturn
    //   30: aconst_null
    //   31: astore_2
    //   32: aconst_null
    //   33: astore_1
    //   34: aload_0
    //   35: invokestatic 66	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   38: astore_0
    //   39: aload_0
    //   40: astore_1
    //   41: aload_0
    //   42: astore_2
    //   43: bipush 7
    //   45: newarray byte
    //   47: astore_3
    //   48: aload_0
    //   49: astore_1
    //   50: aload_0
    //   51: astore_2
    //   52: aload_0
    //   53: aload_3
    //   54: iconst_0
    //   55: bipush 7
    //   57: invokevirtual 72	java/io/InputStream:read	([BII)I
    //   60: pop
    //   61: aload_0
    //   62: astore_1
    //   63: aload_0
    //   64: astore_2
    //   65: aload_3
    //   66: invokestatic 74	com/tencent/mm/modelvideo/r:bytesToHexString	([B)Ljava/lang/String;
    //   69: astore_3
    //   70: aload_0
    //   71: astore_1
    //   72: aload_0
    //   73: astore_2
    //   74: aload_3
    //   75: invokestatic 60	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   78: ifne +71 -> 149
    //   81: aload_0
    //   82: astore_1
    //   83: aload_0
    //   84: astore_2
    //   85: aload_3
    //   86: invokevirtual 77	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   89: astore_3
    //   90: aload_0
    //   91: astore_1
    //   92: aload_0
    //   93: astore_2
    //   94: ldc 44
    //   96: new 8	java/lang/StringBuilder
    //   99: dup
    //   100: ldc 79
    //   102: invokespecial 49	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_3
    //   106: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 55	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aload_0
    //   116: astore_1
    //   117: aload_0
    //   118: astore_2
    //   119: aload_3
    //   120: ldc 149
    //   122: invokevirtual 85	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   125: ifeq +24 -> 149
    //   128: aload_0
    //   129: astore_1
    //   130: aload_0
    //   131: astore_2
    //   132: ldc 44
    //   134: ldc 151
    //   136: invokestatic 55	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: ifnull +7 -> 147
    //   143: aload_0
    //   144: invokevirtual 90	java/io/InputStream:close	()V
    //   147: iconst_1
    //   148: ireturn
    //   149: aload_0
    //   150: ifnull -122 -> 28
    //   153: aload_0
    //   154: invokevirtual 90	java/io/InputStream:close	()V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore_0
    //   160: iconst_0
    //   161: ireturn
    //   162: astore_0
    //   163: aload_1
    //   164: astore_2
    //   165: ldc 44
    //   167: ldc 92
    //   169: iconst_1
    //   170: anewarray 4	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_0
    //   176: invokestatic 96	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   179: aastore
    //   180: invokestatic 100	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: aload_1
    //   184: ifnull -156 -> 28
    //   187: aload_1
    //   188: invokevirtual 90	java/io/InputStream:close	()V
    //   191: iconst_0
    //   192: ireturn
    //   193: astore_0
    //   194: iconst_0
    //   195: ireturn
    //   196: astore_0
    //   197: aload_2
    //   198: ifnull +7 -> 205
    //   201: aload_2
    //   202: invokevirtual 90	java/io/InputStream:close	()V
    //   205: aload_0
    //   206: athrow
    //   207: astore_0
    //   208: goto -61 -> 147
    //   211: astore_1
    //   212: goto -7 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	paramString	String
    //   33	155	1	str	String
    //   211	1	1	localIOException	java.io.IOException
    //   31	171	2	localObject1	Object
    //   47	73	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   153	157	159	java/io/IOException
    //   34	39	162	java/lang/Exception
    //   43	48	162	java/lang/Exception
    //   52	61	162	java/lang/Exception
    //   65	70	162	java/lang/Exception
    //   74	81	162	java/lang/Exception
    //   85	90	162	java/lang/Exception
    //   94	115	162	java/lang/Exception
    //   119	128	162	java/lang/Exception
    //   132	139	162	java/lang/Exception
    //   187	191	193	java/io/IOException
    //   34	39	196	finally
    //   43	48	196	finally
    //   52	61	196	finally
    //   65	70	196	finally
    //   74	81	196	finally
    //   85	90	196	finally
    //   94	115	196	finally
    //   119	128	196	finally
    //   132	139	196	finally
    //   165	183	196	finally
    //   143	147	207	java/io/IOException
    //   201	205	211	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.r
 * JD-Core Version:    0.7.0.1
 */