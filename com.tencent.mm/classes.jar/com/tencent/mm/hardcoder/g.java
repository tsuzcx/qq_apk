package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
{
  /* Error */
  public static long[] PE()
  {
    // Byte code:
    //   0: ldc 12
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 20	java/io/FileReader
    //   8: dup
    //   9: new 22	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 24
    //   15: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: invokestatic 34	android/os/Process:myPid	()I
    //   21: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: ldc 40
    //   26: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 48	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: new 50	java/io/BufferedReader
    //   40: dup
    //   41: aload 5
    //   43: invokespecial 53	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore 4
    //   48: aload 4
    //   50: astore 7
    //   52: aload 5
    //   54: astore 6
    //   56: aload 4
    //   58: invokevirtual 56	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: ldc 58
    //   63: invokevirtual 64	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   66: astore 8
    //   68: aload 4
    //   70: astore 7
    //   72: aload 5
    //   74: astore 6
    //   76: aload 8
    //   78: bipush 13
    //   80: aaload
    //   81: invokestatic 70	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   84: lstore_0
    //   85: aload 4
    //   87: astore 7
    //   89: aload 5
    //   91: astore 6
    //   93: aload 8
    //   95: bipush 14
    //   97: aaload
    //   98: invokestatic 70	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   101: lstore_2
    //   102: aload 5
    //   104: invokevirtual 74	java/io/FileReader:close	()V
    //   107: aload 4
    //   109: invokevirtual 75	java/io/BufferedReader:close	()V
    //   112: ldc 12
    //   114: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: iconst_2
    //   118: newarray long
    //   120: dup
    //   121: iconst_0
    //   122: lload_0
    //   123: lastore
    //   124: dup
    //   125: iconst_1
    //   126: lload_2
    //   127: lastore
    //   128: areturn
    //   129: astore 5
    //   131: ldc 80
    //   133: new 22	java/lang/StringBuilder
    //   136: dup
    //   137: ldc 82
    //   139: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   142: aload 5
    //   144: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto -49 -> 107
    //   159: astore 4
    //   161: ldc 80
    //   163: new 22	java/lang/StringBuilder
    //   166: dup
    //   167: ldc 93
    //   169: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: aload 4
    //   174: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   177: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: goto -74 -> 112
    //   189: astore 8
    //   191: aconst_null
    //   192: astore 4
    //   194: aconst_null
    //   195: astore 5
    //   197: aload 4
    //   199: astore 7
    //   201: aload 5
    //   203: astore 6
    //   205: ldc 80
    //   207: new 22	java/lang/StringBuilder
    //   210: dup
    //   211: ldc 95
    //   213: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   216: aload 8
    //   218: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload 5
    //   232: ifnull +8 -> 240
    //   235: aload 5
    //   237: invokevirtual 74	java/io/FileReader:close	()V
    //   240: aload 4
    //   242: ifnull +8 -> 250
    //   245: aload 4
    //   247: invokevirtual 75	java/io/BufferedReader:close	()V
    //   250: ldc 12
    //   252: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: aconst_null
    //   256: areturn
    //   257: astore 5
    //   259: ldc 80
    //   261: new 22	java/lang/StringBuilder
    //   264: dup
    //   265: ldc 82
    //   267: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   270: aload 5
    //   272: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   275: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: goto -44 -> 240
    //   287: astore 4
    //   289: ldc 80
    //   291: new 22	java/lang/StringBuilder
    //   294: dup
    //   295: ldc 93
    //   297: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   300: aload 4
    //   302: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   305: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: goto -64 -> 250
    //   317: astore 4
    //   319: aconst_null
    //   320: astore 7
    //   322: aconst_null
    //   323: astore 5
    //   325: aload 5
    //   327: ifnull +8 -> 335
    //   330: aload 5
    //   332: invokevirtual 74	java/io/FileReader:close	()V
    //   335: aload 7
    //   337: ifnull +8 -> 345
    //   340: aload 7
    //   342: invokevirtual 75	java/io/BufferedReader:close	()V
    //   345: ldc 12
    //   347: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   350: aload 4
    //   352: athrow
    //   353: astore 5
    //   355: ldc 80
    //   357: new 22	java/lang/StringBuilder
    //   360: dup
    //   361: ldc 82
    //   363: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   366: aload 5
    //   368: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   371: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: goto -45 -> 335
    //   383: astore 5
    //   385: ldc 80
    //   387: new 22	java/lang/StringBuilder
    //   390: dup
    //   391: ldc 93
    //   393: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   396: aload 5
    //   398: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   401: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: goto -65 -> 345
    //   413: astore 4
    //   415: aconst_null
    //   416: astore 7
    //   418: goto -93 -> 325
    //   421: astore 4
    //   423: aload 6
    //   425: astore 5
    //   427: goto -102 -> 325
    //   430: astore 8
    //   432: aconst_null
    //   433: astore 4
    //   435: goto -238 -> 197
    //   438: astore 8
    //   440: goto -243 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   84	39	0	l1	long
    //   101	26	2	l2	long
    //   46	62	4	localBufferedReader	java.io.BufferedReader
    //   159	14	4	localException1	java.lang.Exception
    //   192	54	4	localObject1	Object
    //   287	14	4	localException2	java.lang.Exception
    //   317	34	4	localObject2	Object
    //   413	1	4	localObject3	Object
    //   421	1	4	localObject4	Object
    //   433	1	4	localObject5	Object
    //   35	68	5	localFileReader	java.io.FileReader
    //   129	14	5	localException3	java.lang.Exception
    //   195	41	5	localObject6	Object
    //   257	14	5	localException4	java.lang.Exception
    //   323	8	5	localObject7	Object
    //   353	14	5	localException5	java.lang.Exception
    //   383	14	5	localException6	java.lang.Exception
    //   425	1	5	localObject8	Object
    //   54	370	6	localObject9	Object
    //   50	367	7	localObject10	Object
    //   66	28	8	arrayOfString	String[]
    //   189	28	8	localException7	java.lang.Exception
    //   430	1	8	localException8	java.lang.Exception
    //   438	1	8	localException9	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   102	107	129	java/lang/Exception
    //   107	112	159	java/lang/Exception
    //   5	37	189	java/lang/Exception
    //   235	240	257	java/lang/Exception
    //   245	250	287	java/lang/Exception
    //   5	37	317	finally
    //   330	335	353	java/lang/Exception
    //   340	345	383	java/lang/Exception
    //   37	48	413	finally
    //   56	68	421	finally
    //   76	85	421	finally
    //   93	102	421	finally
    //   205	230	421	finally
    //   37	48	430	java/lang/Exception
    //   56	68	438	java/lang/Exception
    //   76	85	438	java/lang/Exception
    //   93	102	438	java/lang/Exception
  }
  
  /* Error */
  public static void a(java.io.InputStream paramInputStream, a parama)
  {
    // Byte code:
    //   0: ldc 98
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 50	java/io/BufferedReader
    //   8: dup
    //   9: new 100	java/io/InputStreamReader
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 103	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   17: invokespecial 53	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   20: astore_3
    //   21: aload_3
    //   22: astore_0
    //   23: aload_3
    //   24: invokevirtual 56	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull +22 -> 53
    //   34: aload_1
    //   35: ifnull -14 -> 21
    //   38: aload_3
    //   39: astore_0
    //   40: aload_1
    //   41: aload 4
    //   43: invokeinterface 107 2 0
    //   48: istore_2
    //   49: iload_2
    //   50: ifne -29 -> 21
    //   53: aload_3
    //   54: invokevirtual 75	java/io/BufferedReader:close	()V
    //   57: ldc 98
    //   59: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: return
    //   63: astore_0
    //   64: ldc 80
    //   66: aload_0
    //   67: ldc 109
    //   69: iconst_0
    //   70: anewarray 4	java/lang/Object
    //   73: invokestatic 113	com/tencent/mm/hardcoder/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   76: ldc 98
    //   78: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: return
    //   82: astore 4
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_1
    //   87: astore_0
    //   88: ldc 80
    //   90: aload 4
    //   92: ldc 109
    //   94: iconst_0
    //   95: anewarray 4	java/lang/Object
    //   98: invokestatic 113	com/tencent/mm/hardcoder/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload_1
    //   102: ifnull +66 -> 168
    //   105: aload_1
    //   106: invokevirtual 75	java/io/BufferedReader:close	()V
    //   109: ldc 98
    //   111: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: astore_0
    //   116: ldc 80
    //   118: aload_0
    //   119: ldc 109
    //   121: iconst_0
    //   122: anewarray 4	java/lang/Object
    //   125: invokestatic 113	com/tencent/mm/hardcoder/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: ldc 98
    //   130: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: return
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_0
    //   137: aload_0
    //   138: ifnull +7 -> 145
    //   141: aload_0
    //   142: invokevirtual 75	java/io/BufferedReader:close	()V
    //   145: ldc 98
    //   147: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_1
    //   151: athrow
    //   152: astore_0
    //   153: ldc 80
    //   155: aload_0
    //   156: ldc 109
    //   158: iconst_0
    //   159: anewarray 4	java/lang/Object
    //   162: invokestatic 113	com/tencent/mm/hardcoder/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: goto -20 -> 145
    //   168: ldc 98
    //   170: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: return
    //   174: astore_1
    //   175: goto -38 -> 137
    //   178: astore 4
    //   180: aload_3
    //   181: astore_1
    //   182: goto -96 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	paramInputStream	java.io.InputStream
    //   0	185	1	parama	a
    //   48	2	2	bool	boolean
    //   20	161	3	localBufferedReader	java.io.BufferedReader
    //   27	15	4	str	String
    //   82	9	4	localException1	java.lang.Exception
    //   178	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   53	57	63	java/lang/Exception
    //   5	21	82	java/lang/Exception
    //   105	109	115	java/lang/Exception
    //   5	21	134	finally
    //   141	145	152	java/lang/Exception
    //   23	29	174	finally
    //   40	49	174	finally
    //   88	101	174	finally
    //   23	29	178	java/lang/Exception
    //   40	49	178	java/lang/Exception
  }
  
  /* Error */
  public static void a(String paramString, a parama)
  {
    // Byte code:
    //   0: ldc 115
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 117	java/io/FileInputStream
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 118	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: astore_0
    //   16: aload_2
    //   17: aload_1
    //   18: invokestatic 120	com/tencent/mm/hardcoder/g:a	(Ljava/io/InputStream;Lcom/tencent/mm/hardcoder/g$a;)V
    //   21: aload_2
    //   22: invokevirtual 123	java/io/InputStream:close	()V
    //   25: ldc 115
    //   27: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   30: return
    //   31: astore_0
    //   32: ldc 80
    //   34: aload_0
    //   35: ldc 109
    //   37: iconst_0
    //   38: anewarray 4	java/lang/Object
    //   41: invokestatic 113	com/tencent/mm/hardcoder/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: ldc 115
    //   46: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: return
    //   50: astore_3
    //   51: aconst_null
    //   52: astore_1
    //   53: aload_1
    //   54: astore_0
    //   55: ldc 80
    //   57: aload_3
    //   58: ldc 109
    //   60: iconst_0
    //   61: anewarray 4	java/lang/Object
    //   64: invokestatic 113	com/tencent/mm/hardcoder/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   67: aload_1
    //   68: ifnull +66 -> 134
    //   71: aload_1
    //   72: invokevirtual 123	java/io/InputStream:close	()V
    //   75: ldc 115
    //   77: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: return
    //   81: astore_0
    //   82: ldc 80
    //   84: aload_0
    //   85: ldc 109
    //   87: iconst_0
    //   88: anewarray 4	java/lang/Object
    //   91: invokestatic 113	com/tencent/mm/hardcoder/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: ldc 115
    //   96: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: astore_1
    //   101: aconst_null
    //   102: astore_0
    //   103: aload_0
    //   104: ifnull +7 -> 111
    //   107: aload_0
    //   108: invokevirtual 123	java/io/InputStream:close	()V
    //   111: ldc 115
    //   113: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: aload_1
    //   117: athrow
    //   118: astore_0
    //   119: ldc 80
    //   121: aload_0
    //   122: ldc 109
    //   124: iconst_0
    //   125: anewarray 4	java/lang/Object
    //   128: invokestatic 113	com/tencent/mm/hardcoder/c:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   131: goto -20 -> 111
    //   134: ldc 115
    //   136: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: return
    //   140: astore_1
    //   141: goto -38 -> 103
    //   144: astore_3
    //   145: aload_2
    //   146: astore_1
    //   147: goto -94 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	paramString	String
    //   0	150	1	parama	a
    //   13	133	2	localFileInputStream	java.io.FileInputStream
    //   50	8	3	localException1	java.lang.Exception
    //   144	1	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   21	25	31	java/lang/Exception
    //   5	14	50	java/lang/Exception
    //   71	75	81	java/lang/Exception
    //   5	14	100	finally
    //   107	111	118	java/lang/Exception
    //   16	21	140	finally
    //   55	67	140	finally
    //   16	21	144	java/lang/Exception
  }
  
  /* Error */
  public static long[] jo(int paramInt)
  {
    // Byte code:
    //   0: ldc 126
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 20	java/io/FileReader
    //   8: dup
    //   9: new 22	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 24
    //   15: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: invokestatic 34	android/os/Process:myPid	()I
    //   21: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: ldc 128
    //   26: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload_0
    //   30: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc 40
    //   35: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 48	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   44: astore 6
    //   46: new 50	java/io/BufferedReader
    //   49: dup
    //   50: aload 6
    //   52: invokespecial 53	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   55: astore 5
    //   57: aload 5
    //   59: astore 8
    //   61: aload 6
    //   63: astore 7
    //   65: aload 5
    //   67: invokevirtual 56	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   70: astore 9
    //   72: aload 9
    //   74: ifnonnull +80 -> 154
    //   77: aload 6
    //   79: invokevirtual 74	java/io/FileReader:close	()V
    //   82: aload 5
    //   84: invokevirtual 75	java/io/BufferedReader:close	()V
    //   87: ldc 126
    //   89: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: aconst_null
    //   93: areturn
    //   94: astore 6
    //   96: ldc 80
    //   98: new 22	java/lang/StringBuilder
    //   101: dup
    //   102: ldc 130
    //   104: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: aload 6
    //   109: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   112: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: goto -39 -> 82
    //   124: astore 5
    //   126: ldc 80
    //   128: new 22	java/lang/StringBuilder
    //   131: dup
    //   132: ldc 132
    //   134: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   137: aload 5
    //   139: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   142: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   148: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: goto -64 -> 87
    //   154: aload 5
    //   156: astore 8
    //   158: aload 6
    //   160: astore 7
    //   162: aload 9
    //   164: ldc 58
    //   166: invokevirtual 64	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   169: astore 9
    //   171: aload 5
    //   173: astore 8
    //   175: aload 6
    //   177: astore 7
    //   179: aload 9
    //   181: bipush 13
    //   183: aaload
    //   184: invokestatic 135	com/tencent/mm/hardcoder/g:lU	(Ljava/lang/String;)J
    //   187: lstore_1
    //   188: aload 5
    //   190: astore 8
    //   192: aload 6
    //   194: astore 7
    //   196: aload 9
    //   198: bipush 14
    //   200: aaload
    //   201: invokestatic 135	com/tencent/mm/hardcoder/g:lU	(Ljava/lang/String;)J
    //   204: lstore_3
    //   205: aload 6
    //   207: invokevirtual 74	java/io/FileReader:close	()V
    //   210: aload 5
    //   212: invokevirtual 75	java/io/BufferedReader:close	()V
    //   215: ldc 126
    //   217: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: iconst_2
    //   221: newarray long
    //   223: dup
    //   224: iconst_0
    //   225: lload_1
    //   226: lastore
    //   227: dup
    //   228: iconst_1
    //   229: lload_3
    //   230: lastore
    //   231: areturn
    //   232: astore 6
    //   234: ldc 80
    //   236: new 22	java/lang/StringBuilder
    //   239: dup
    //   240: ldc 130
    //   242: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   245: aload 6
    //   247: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   250: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: goto -49 -> 210
    //   262: astore 5
    //   264: ldc 80
    //   266: new 22	java/lang/StringBuilder
    //   269: dup
    //   270: ldc 132
    //   272: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: aload 5
    //   277: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   280: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   289: goto -74 -> 215
    //   292: astore 9
    //   294: aconst_null
    //   295: astore 5
    //   297: aconst_null
    //   298: astore 6
    //   300: aload 5
    //   302: astore 8
    //   304: aload 6
    //   306: astore 7
    //   308: ldc 80
    //   310: new 22	java/lang/StringBuilder
    //   313: dup
    //   314: ldc 137
    //   316: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   319: aload 9
    //   321: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   324: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   333: aload 6
    //   335: ifnull +8 -> 343
    //   338: aload 6
    //   340: invokevirtual 74	java/io/FileReader:close	()V
    //   343: aload 5
    //   345: ifnull +8 -> 353
    //   348: aload 5
    //   350: invokevirtual 75	java/io/BufferedReader:close	()V
    //   353: ldc 126
    //   355: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   358: aconst_null
    //   359: areturn
    //   360: astore 6
    //   362: ldc 80
    //   364: new 22	java/lang/StringBuilder
    //   367: dup
    //   368: ldc 130
    //   370: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   373: aload 6
    //   375: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   378: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   387: goto -44 -> 343
    //   390: astore 5
    //   392: ldc 80
    //   394: new 22	java/lang/StringBuilder
    //   397: dup
    //   398: ldc 132
    //   400: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   403: aload 5
    //   405: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   408: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   417: goto -64 -> 353
    //   420: astore 5
    //   422: aconst_null
    //   423: astore 8
    //   425: aconst_null
    //   426: astore 6
    //   428: aload 6
    //   430: ifnull +8 -> 438
    //   433: aload 6
    //   435: invokevirtual 74	java/io/FileReader:close	()V
    //   438: aload 8
    //   440: ifnull +8 -> 448
    //   443: aload 8
    //   445: invokevirtual 75	java/io/BufferedReader:close	()V
    //   448: ldc 126
    //   450: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   453: aload 5
    //   455: athrow
    //   456: astore 6
    //   458: ldc 80
    //   460: new 22	java/lang/StringBuilder
    //   463: dup
    //   464: ldc 130
    //   466: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   469: aload 6
    //   471: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   474: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   483: goto -45 -> 438
    //   486: astore 6
    //   488: ldc 80
    //   490: new 22	java/lang/StringBuilder
    //   493: dup
    //   494: ldc 132
    //   496: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   499: aload 6
    //   501: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   504: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   513: goto -65 -> 448
    //   516: astore 5
    //   518: aconst_null
    //   519: astore 8
    //   521: goto -93 -> 428
    //   524: astore 5
    //   526: aload 7
    //   528: astore 6
    //   530: goto -102 -> 428
    //   533: astore 9
    //   535: aconst_null
    //   536: astore 5
    //   538: goto -238 -> 300
    //   541: astore 9
    //   543: goto -243 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	546	0	paramInt	int
    //   187	39	1	l1	long
    //   204	26	3	l2	long
    //   55	28	5	localBufferedReader	java.io.BufferedReader
    //   124	87	5	localException1	java.lang.Exception
    //   262	14	5	localException2	java.lang.Exception
    //   295	54	5	localObject1	Object
    //   390	14	5	localException3	java.lang.Exception
    //   420	34	5	localObject2	Object
    //   516	1	5	localObject3	Object
    //   524	1	5	localObject4	Object
    //   536	1	5	localObject5	Object
    //   44	34	6	localFileReader	java.io.FileReader
    //   94	112	6	localException4	java.lang.Exception
    //   232	14	6	localException5	java.lang.Exception
    //   298	41	6	localObject6	Object
    //   360	14	6	localException6	java.lang.Exception
    //   426	8	6	localObject7	Object
    //   456	14	6	localException7	java.lang.Exception
    //   486	14	6	localException8	java.lang.Exception
    //   528	1	6	localObject8	Object
    //   63	464	7	localObject9	Object
    //   59	461	8	localObject10	Object
    //   70	127	9	localObject11	Object
    //   292	28	9	localException9	java.lang.Exception
    //   533	1	9	localException10	java.lang.Exception
    //   541	1	9	localException11	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   77	82	94	java/lang/Exception
    //   82	87	124	java/lang/Exception
    //   205	210	232	java/lang/Exception
    //   210	215	262	java/lang/Exception
    //   5	46	292	java/lang/Exception
    //   338	343	360	java/lang/Exception
    //   348	353	390	java/lang/Exception
    //   5	46	420	finally
    //   433	438	456	java/lang/Exception
    //   443	448	486	java/lang/Exception
    //   46	57	516	finally
    //   65	72	524	finally
    //   162	171	524	finally
    //   179	188	524	finally
    //   196	205	524	finally
    //   308	333	524	finally
    //   46	57	533	java/lang/Exception
    //   65	72	541	java/lang/Exception
    //   162	171	541	java/lang/Exception
    //   179	188	541	java/lang/Exception
    //   196	205	541	java/lang/Exception
  }
  
  /* Error */
  public static int jp(int paramInt)
  {
    // Byte code:
    //   0: ldc 140
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 20	java/io/FileReader
    //   8: dup
    //   9: new 22	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 24
    //   15: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: invokestatic 34	android/os/Process:myPid	()I
    //   21: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: ldc 128
    //   26: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload_0
    //   30: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc 40
    //   35: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 48	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   44: astore_2
    //   45: new 50	java/io/BufferedReader
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 53	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   53: astore_1
    //   54: aload_1
    //   55: astore 4
    //   57: aload_2
    //   58: astore_3
    //   59: aload_1
    //   60: invokevirtual 56	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnonnull +74 -> 141
    //   70: aload_2
    //   71: invokevirtual 74	java/io/FileReader:close	()V
    //   74: aload_1
    //   75: invokevirtual 75	java/io/BufferedReader:close	()V
    //   78: ldc 140
    //   80: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: iconst_m1
    //   84: ireturn
    //   85: astore_2
    //   86: ldc 80
    //   88: new 22	java/lang/StringBuilder
    //   91: dup
    //   92: ldc 142
    //   94: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: aload_2
    //   98: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   101: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: goto -36 -> 74
    //   113: astore_1
    //   114: ldc 80
    //   116: new 22	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 144
    //   122: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload_1
    //   126: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: goto -60 -> 78
    //   141: aload_1
    //   142: astore 4
    //   144: aload_2
    //   145: astore_3
    //   146: aload 5
    //   148: ldc 58
    //   150: invokevirtual 64	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   153: bipush 38
    //   155: aaload
    //   156: invokestatic 148	com/tencent/mm/hardcoder/g:lT	(Ljava/lang/String;)I
    //   159: istore_0
    //   160: aload_2
    //   161: invokevirtual 74	java/io/FileReader:close	()V
    //   164: aload_1
    //   165: invokevirtual 75	java/io/BufferedReader:close	()V
    //   168: ldc 140
    //   170: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: iload_0
    //   174: ireturn
    //   175: astore_2
    //   176: ldc 80
    //   178: new 22	java/lang/StringBuilder
    //   181: dup
    //   182: ldc 142
    //   184: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   187: aload_2
    //   188: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   191: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: goto -36 -> 164
    //   203: astore_1
    //   204: ldc 80
    //   206: new 22	java/lang/StringBuilder
    //   209: dup
    //   210: ldc 144
    //   212: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: aload_1
    //   216: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   219: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: goto -60 -> 168
    //   231: astore 5
    //   233: aconst_null
    //   234: astore_1
    //   235: aconst_null
    //   236: astore_2
    //   237: aload_1
    //   238: astore 4
    //   240: aload_2
    //   241: astore_3
    //   242: ldc 80
    //   244: new 22	java/lang/StringBuilder
    //   247: dup
    //   248: ldc 150
    //   250: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload 5
    //   255: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   258: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_2
    //   268: ifnull +7 -> 275
    //   271: aload_2
    //   272: invokevirtual 74	java/io/FileReader:close	()V
    //   275: aload_1
    //   276: ifnull +7 -> 283
    //   279: aload_1
    //   280: invokevirtual 75	java/io/BufferedReader:close	()V
    //   283: ldc 140
    //   285: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: iconst_m1
    //   289: ireturn
    //   290: astore_2
    //   291: ldc 80
    //   293: new 22	java/lang/StringBuilder
    //   296: dup
    //   297: ldc 142
    //   299: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   302: aload_2
    //   303: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   306: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: goto -40 -> 275
    //   318: astore_1
    //   319: ldc 80
    //   321: new 22	java/lang/StringBuilder
    //   324: dup
    //   325: ldc 144
    //   327: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   330: aload_1
    //   331: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   334: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: goto -60 -> 283
    //   346: astore_1
    //   347: aconst_null
    //   348: astore 4
    //   350: aconst_null
    //   351: astore_2
    //   352: aload_2
    //   353: ifnull +7 -> 360
    //   356: aload_2
    //   357: invokevirtual 74	java/io/FileReader:close	()V
    //   360: aload 4
    //   362: ifnull +8 -> 370
    //   365: aload 4
    //   367: invokevirtual 75	java/io/BufferedReader:close	()V
    //   370: ldc 140
    //   372: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   375: aload_1
    //   376: athrow
    //   377: astore_2
    //   378: ldc 80
    //   380: new 22	java/lang/StringBuilder
    //   383: dup
    //   384: ldc 142
    //   386: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   389: aload_2
    //   390: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   393: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: goto -42 -> 360
    //   405: astore_2
    //   406: ldc 80
    //   408: new 22	java/lang/StringBuilder
    //   411: dup
    //   412: ldc 144
    //   414: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   417: aload_2
    //   418: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   421: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   430: goto -60 -> 370
    //   433: astore_1
    //   434: aconst_null
    //   435: astore 4
    //   437: goto -85 -> 352
    //   440: astore_1
    //   441: aload_3
    //   442: astore_2
    //   443: goto -91 -> 352
    //   446: astore 5
    //   448: aconst_null
    //   449: astore_1
    //   450: goto -213 -> 237
    //   453: astore 5
    //   455: goto -218 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	458	0	paramInt	int
    //   53	22	1	localBufferedReader	java.io.BufferedReader
    //   113	52	1	localException1	java.lang.Exception
    //   203	13	1	localException2	java.lang.Exception
    //   234	46	1	localObject1	Object
    //   318	13	1	localException3	java.lang.Exception
    //   346	30	1	localObject2	Object
    //   433	1	1	localObject3	Object
    //   440	1	1	localObject4	Object
    //   449	1	1	localObject5	Object
    //   44	27	2	localFileReader	java.io.FileReader
    //   85	76	2	localException4	java.lang.Exception
    //   175	13	2	localException5	java.lang.Exception
    //   236	36	2	localObject6	Object
    //   290	13	2	localException6	java.lang.Exception
    //   351	6	2	localObject7	Object
    //   377	13	2	localException7	java.lang.Exception
    //   405	13	2	localException8	java.lang.Exception
    //   442	1	2	localObject8	Object
    //   58	384	3	localObject9	Object
    //   55	381	4	localObject10	Object
    //   63	84	5	str	String
    //   231	23	5	localException9	java.lang.Exception
    //   446	1	5	localException10	java.lang.Exception
    //   453	1	5	localException11	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   70	74	85	java/lang/Exception
    //   74	78	113	java/lang/Exception
    //   160	164	175	java/lang/Exception
    //   164	168	203	java/lang/Exception
    //   5	45	231	java/lang/Exception
    //   271	275	290	java/lang/Exception
    //   279	283	318	java/lang/Exception
    //   5	45	346	finally
    //   356	360	377	java/lang/Exception
    //   365	370	405	java/lang/Exception
    //   45	54	433	finally
    //   59	65	440	finally
    //   146	160	440	finally
    //   242	267	440	finally
    //   45	54	446	java/lang/Exception
    //   59	65	453	java/lang/Exception
    //   146	160	453	java/lang/Exception
  }
  
  /* Error */
  public static long jq(int paramInt)
  {
    // Byte code:
    //   0: ldc 153
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 155	java/io/File
    //   8: dup
    //   9: new 22	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 157
    //   15: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: iload_0
    //   19: invokevirtual 38	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc 159
    //   24: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 160	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 4
    //   35: aload 4
    //   37: invokevirtual 164	java/io/File:exists	()Z
    //   40: istore_1
    //   41: iload_1
    //   42: ifne +12 -> 54
    //   45: ldc 153
    //   47: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: ldc2_w 165
    //   53: lreturn
    //   54: new 20	java/io/FileReader
    //   57: dup
    //   58: aload 4
    //   60: invokespecial 169	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   63: astore 5
    //   65: new 50	java/io/BufferedReader
    //   68: dup
    //   69: aload 5
    //   71: invokespecial 53	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   74: astore 4
    //   76: aload 4
    //   78: astore 7
    //   80: aload 5
    //   82: astore 6
    //   84: aload 4
    //   86: invokevirtual 56	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: invokestatic 135	com/tencent/mm/hardcoder/g:lU	(Ljava/lang/String;)J
    //   92: lstore_2
    //   93: aload 4
    //   95: invokevirtual 75	java/io/BufferedReader:close	()V
    //   98: aload 5
    //   100: invokevirtual 74	java/io/FileReader:close	()V
    //   103: ldc 153
    //   105: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: lload_2
    //   109: lreturn
    //   110: astore 4
    //   112: ldc 80
    //   114: new 22	java/lang/StringBuilder
    //   117: dup
    //   118: ldc 171
    //   120: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload 4
    //   125: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   128: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: goto -39 -> 98
    //   140: astore 4
    //   142: ldc 80
    //   144: new 22	java/lang/StringBuilder
    //   147: dup
    //   148: ldc 173
    //   150: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   153: aload 4
    //   155: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   167: goto -64 -> 103
    //   170: astore 8
    //   172: aconst_null
    //   173: astore 4
    //   175: aconst_null
    //   176: astore 5
    //   178: aload 4
    //   180: astore 7
    //   182: aload 5
    //   184: astore 6
    //   186: ldc 80
    //   188: new 22	java/lang/StringBuilder
    //   191: dup
    //   192: ldc 175
    //   194: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   197: aload 8
    //   199: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   202: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 4
    //   213: ifnull +8 -> 221
    //   216: aload 4
    //   218: invokevirtual 75	java/io/BufferedReader:close	()V
    //   221: aload 5
    //   223: ifnull +8 -> 231
    //   226: aload 5
    //   228: invokevirtual 74	java/io/FileReader:close	()V
    //   231: ldc 153
    //   233: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: ldc2_w 165
    //   239: lreturn
    //   240: astore 4
    //   242: ldc 80
    //   244: new 22	java/lang/StringBuilder
    //   247: dup
    //   248: ldc 171
    //   250: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload 4
    //   255: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   258: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: goto -46 -> 221
    //   270: astore 4
    //   272: ldc 80
    //   274: new 22	java/lang/StringBuilder
    //   277: dup
    //   278: ldc 173
    //   280: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload 4
    //   285: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   288: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: goto -66 -> 231
    //   300: astore 4
    //   302: aconst_null
    //   303: astore 7
    //   305: aconst_null
    //   306: astore 5
    //   308: aload 7
    //   310: ifnull +8 -> 318
    //   313: aload 7
    //   315: invokevirtual 75	java/io/BufferedReader:close	()V
    //   318: aload 5
    //   320: ifnull +8 -> 328
    //   323: aload 5
    //   325: invokevirtual 74	java/io/FileReader:close	()V
    //   328: ldc 153
    //   330: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   333: aload 4
    //   335: athrow
    //   336: astore 6
    //   338: ldc 80
    //   340: new 22	java/lang/StringBuilder
    //   343: dup
    //   344: ldc 171
    //   346: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   349: aload 6
    //   351: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   354: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: goto -45 -> 318
    //   366: astore 5
    //   368: ldc 80
    //   370: new 22	java/lang/StringBuilder
    //   373: dup
    //   374: ldc 173
    //   376: invokespecial 28	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   379: aload 5
    //   381: invokevirtual 85	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   384: invokevirtual 43	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 91	com/tencent/mm/hardcoder/c:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   393: goto -65 -> 328
    //   396: astore 4
    //   398: aconst_null
    //   399: astore 7
    //   401: goto -93 -> 308
    //   404: astore 4
    //   406: aload 6
    //   408: astore 5
    //   410: goto -102 -> 308
    //   413: astore 8
    //   415: aconst_null
    //   416: astore 4
    //   418: goto -240 -> 178
    //   421: astore 8
    //   423: goto -245 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	paramInt	int
    //   40	2	1	bool	boolean
    //   92	17	2	l	long
    //   33	61	4	localObject1	Object
    //   110	14	4	localException1	java.lang.Exception
    //   140	14	4	localException2	java.lang.Exception
    //   173	44	4	localObject2	Object
    //   240	14	4	localException3	java.lang.Exception
    //   270	14	4	localException4	java.lang.Exception
    //   300	34	4	localObject3	Object
    //   396	1	4	localObject4	Object
    //   404	1	4	localObject5	Object
    //   416	1	4	localObject6	Object
    //   63	261	5	localFileReader1	java.io.FileReader
    //   366	14	5	localException5	java.lang.Exception
    //   408	1	5	localObject7	Object
    //   82	103	6	localFileReader2	java.io.FileReader
    //   336	71	6	localException6	java.lang.Exception
    //   78	322	7	localObject8	Object
    //   170	28	8	localException7	java.lang.Exception
    //   413	1	8	localException8	java.lang.Exception
    //   421	1	8	localException9	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   93	98	110	java/lang/Exception
    //   98	103	140	java/lang/Exception
    //   5	41	170	java/lang/Exception
    //   54	65	170	java/lang/Exception
    //   216	221	240	java/lang/Exception
    //   226	231	270	java/lang/Exception
    //   5	41	300	finally
    //   54	65	300	finally
    //   313	318	336	java/lang/Exception
    //   323	328	366	java/lang/Exception
    //   65	76	396	finally
    //   84	93	404	finally
    //   186	211	404	finally
    //   65	76	413	java/lang/Exception
    //   84	93	421	java/lang/Exception
  }
  
  private static int lT(String paramString)
  {
    AppMethodBeat.i(93946);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(93946);
        return 0;
      }
      int i = Integer.decode(paramString).intValue();
      AppMethodBeat.o(93946);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      c.printErrStackTrace("HardCoder.HardCoderUtil", paramString, "getInt", new Object[0]);
      AppMethodBeat.o(93946);
    }
    return 0;
  }
  
  private static long lU(String paramString)
  {
    AppMethodBeat.i(93947);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(93947);
        return 0L;
      }
      long l = Long.decode(paramString).longValue();
      AppMethodBeat.o(93947);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      c.printErrStackTrace("HardCoder.HardCoderUtil", paramString, "getLong", new Object[0]);
      AppMethodBeat.o(93947);
    }
    return 0L;
  }
  
  public static abstract interface a
  {
    public abstract boolean lS(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.g
 * JD-Core Version:    0.7.0.1
 */