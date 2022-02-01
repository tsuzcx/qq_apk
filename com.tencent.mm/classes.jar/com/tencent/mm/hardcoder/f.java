package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  /* Error */
  public static long[] ahn()
  {
    // Byte code:
    //   0: ldc 9
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 17	java/io/FileReader
    //   8: dup
    //   9: new 19	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 21
    //   15: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: invokestatic 31	android/os/Process:myPid	()I
    //   21: invokevirtual 35	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: ldc 37
    //   26: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 45	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   35: astore 5
    //   37: new 47	java/io/BufferedReader
    //   40: dup
    //   41: aload 5
    //   43: invokespecial 50	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   46: astore 4
    //   48: aload 4
    //   50: astore 7
    //   52: aload 5
    //   54: astore 6
    //   56: aload 4
    //   58: invokevirtual 53	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   61: ldc 55
    //   63: invokevirtual 61	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   66: astore 8
    //   68: aload 4
    //   70: astore 7
    //   72: aload 5
    //   74: astore 6
    //   76: aload 8
    //   78: bipush 13
    //   80: aaload
    //   81: invokestatic 67	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   84: lstore_0
    //   85: aload 4
    //   87: astore 7
    //   89: aload 5
    //   91: astore 6
    //   93: aload 8
    //   95: bipush 14
    //   97: aaload
    //   98: invokestatic 67	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   101: lstore_2
    //   102: aload 5
    //   104: invokevirtual 71	java/io/FileReader:close	()V
    //   107: aload 4
    //   109: invokevirtual 72	java/io/BufferedReader:close	()V
    //   112: ldc 9
    //   114: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   131: ldc 77
    //   133: new 19	java/lang/StringBuilder
    //   136: dup
    //   137: ldc 79
    //   139: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   142: aload 5
    //   144: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto -49 -> 107
    //   159: astore 4
    //   161: ldc 77
    //   163: new 19	java/lang/StringBuilder
    //   166: dup
    //   167: ldc 90
    //   169: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   172: aload 4
    //   174: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   177: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   205: ldc 77
    //   207: new 19	java/lang/StringBuilder
    //   210: dup
    //   211: ldc 92
    //   213: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   216: aload 8
    //   218: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   221: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload 5
    //   232: ifnull +8 -> 240
    //   235: aload 5
    //   237: invokevirtual 71	java/io/FileReader:close	()V
    //   240: aload 4
    //   242: ifnull +8 -> 250
    //   245: aload 4
    //   247: invokevirtual 72	java/io/BufferedReader:close	()V
    //   250: ldc 9
    //   252: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   255: aconst_null
    //   256: areturn
    //   257: astore 5
    //   259: ldc 77
    //   261: new 19	java/lang/StringBuilder
    //   264: dup
    //   265: ldc 79
    //   267: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   270: aload 5
    //   272: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   275: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   284: goto -44 -> 240
    //   287: astore 4
    //   289: ldc 77
    //   291: new 19	java/lang/StringBuilder
    //   294: dup
    //   295: ldc 90
    //   297: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   300: aload 4
    //   302: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   305: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: goto -64 -> 250
    //   317: astore 4
    //   319: aconst_null
    //   320: astore 7
    //   322: aconst_null
    //   323: astore 5
    //   325: aload 5
    //   327: ifnull +8 -> 335
    //   330: aload 5
    //   332: invokevirtual 71	java/io/FileReader:close	()V
    //   335: aload 7
    //   337: ifnull +8 -> 345
    //   340: aload 7
    //   342: invokevirtual 72	java/io/BufferedReader:close	()V
    //   345: ldc 9
    //   347: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   350: aload 4
    //   352: athrow
    //   353: astore 5
    //   355: ldc 77
    //   357: new 19	java/lang/StringBuilder
    //   360: dup
    //   361: ldc 79
    //   363: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   366: aload 5
    //   368: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   371: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: goto -45 -> 335
    //   383: astore 5
    //   385: ldc 77
    //   387: new 19	java/lang/StringBuilder
    //   390: dup
    //   391: ldc 90
    //   393: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   396: aload 5
    //   398: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   401: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  private static int eZ(String paramString)
  {
    AppMethodBeat.i(62483);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(62483);
        return 0;
      }
      int i = Integer.decode(paramString).intValue();
      AppMethodBeat.o(62483);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      d.printErrStackTrace("Hardcoder.HardCoderUtil", paramString, "getInt", new Object[0]);
      AppMethodBeat.o(62483);
    }
    return 0;
  }
  
  /* Error */
  public static int mo(int paramInt)
  {
    // Byte code:
    //   0: ldc 119
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 17	java/io/FileReader
    //   8: dup
    //   9: new 19	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 21
    //   15: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: invokestatic 31	android/os/Process:myPid	()I
    //   21: invokevirtual 35	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   24: ldc 121
    //   26: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload_0
    //   30: invokevirtual 35	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc 37
    //   35: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   41: invokespecial 45	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   44: astore_2
    //   45: new 47	java/io/BufferedReader
    //   48: dup
    //   49: aload_2
    //   50: invokespecial 50	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   53: astore_1
    //   54: aload_1
    //   55: astore 4
    //   57: aload_2
    //   58: astore_3
    //   59: aload_1
    //   60: invokevirtual 53	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   63: astore 5
    //   65: aload 5
    //   67: ifnonnull +74 -> 141
    //   70: aload_2
    //   71: invokevirtual 71	java/io/FileReader:close	()V
    //   74: aload_1
    //   75: invokevirtual 72	java/io/BufferedReader:close	()V
    //   78: ldc 119
    //   80: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: iconst_m1
    //   84: ireturn
    //   85: astore_2
    //   86: ldc 77
    //   88: new 19	java/lang/StringBuilder
    //   91: dup
    //   92: ldc 123
    //   94: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: aload_2
    //   98: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   101: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: goto -36 -> 74
    //   113: astore_1
    //   114: ldc 77
    //   116: new 19	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 125
    //   122: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload_1
    //   126: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   129: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: goto -60 -> 78
    //   141: aload_1
    //   142: astore 4
    //   144: aload_2
    //   145: astore_3
    //   146: aload 5
    //   148: ldc 55
    //   150: invokevirtual 61	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   153: bipush 38
    //   155: aaload
    //   156: invokestatic 127	com/tencent/mm/hardcoder/f:eZ	(Ljava/lang/String;)I
    //   159: istore_0
    //   160: aload_2
    //   161: invokevirtual 71	java/io/FileReader:close	()V
    //   164: aload_1
    //   165: invokevirtual 72	java/io/BufferedReader:close	()V
    //   168: ldc 119
    //   170: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: iload_0
    //   174: ireturn
    //   175: astore_2
    //   176: ldc 77
    //   178: new 19	java/lang/StringBuilder
    //   181: dup
    //   182: ldc 123
    //   184: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   187: aload_2
    //   188: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   191: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   197: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: goto -36 -> 164
    //   203: astore_1
    //   204: ldc 77
    //   206: new 19	java/lang/StringBuilder
    //   209: dup
    //   210: ldc 125
    //   212: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: aload_1
    //   216: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   219: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   242: ldc 77
    //   244: new 19	java/lang/StringBuilder
    //   247: dup
    //   248: ldc 129
    //   250: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload 5
    //   255: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   258: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: aload_2
    //   268: ifnull +7 -> 275
    //   271: aload_2
    //   272: invokevirtual 71	java/io/FileReader:close	()V
    //   275: aload_1
    //   276: ifnull +7 -> 283
    //   279: aload_1
    //   280: invokevirtual 72	java/io/BufferedReader:close	()V
    //   283: ldc 119
    //   285: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: iconst_m1
    //   289: ireturn
    //   290: astore_2
    //   291: ldc 77
    //   293: new 19	java/lang/StringBuilder
    //   296: dup
    //   297: ldc 123
    //   299: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   302: aload_2
    //   303: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   306: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   315: goto -40 -> 275
    //   318: astore_1
    //   319: ldc 77
    //   321: new 19	java/lang/StringBuilder
    //   324: dup
    //   325: ldc 125
    //   327: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   330: aload_1
    //   331: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   334: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: goto -60 -> 283
    //   346: astore_1
    //   347: aconst_null
    //   348: astore 4
    //   350: aconst_null
    //   351: astore_2
    //   352: aload_2
    //   353: ifnull +7 -> 360
    //   356: aload_2
    //   357: invokevirtual 71	java/io/FileReader:close	()V
    //   360: aload 4
    //   362: ifnull +8 -> 370
    //   365: aload 4
    //   367: invokevirtual 72	java/io/BufferedReader:close	()V
    //   370: ldc 119
    //   372: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   375: aload_1
    //   376: athrow
    //   377: astore_2
    //   378: ldc 77
    //   380: new 19	java/lang/StringBuilder
    //   383: dup
    //   384: ldc 123
    //   386: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   389: aload_2
    //   390: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   393: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   402: goto -42 -> 360
    //   405: astore_2
    //   406: ldc 77
    //   408: new 19	java/lang/StringBuilder
    //   411: dup
    //   412: ldc 125
    //   414: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   417: aload_2
    //   418: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   421: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  public static long mp(int paramInt)
  {
    // Byte code:
    //   0: ldc 132
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 134	java/io/File
    //   8: dup
    //   9: new 19	java/lang/StringBuilder
    //   12: dup
    //   13: ldc 136
    //   15: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   18: iload_0
    //   19: invokevirtual 35	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   22: ldc 138
    //   24: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokespecial 139	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 4
    //   35: aload 4
    //   37: invokevirtual 143	java/io/File:exists	()Z
    //   40: istore_1
    //   41: iload_1
    //   42: ifne +12 -> 54
    //   45: ldc 132
    //   47: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   50: ldc2_w 144
    //   53: lreturn
    //   54: new 17	java/io/FileReader
    //   57: dup
    //   58: aload 4
    //   60: invokespecial 148	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   63: astore 5
    //   65: new 47	java/io/BufferedReader
    //   68: dup
    //   69: aload 5
    //   71: invokespecial 50	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   74: astore 4
    //   76: aload 4
    //   78: astore 7
    //   80: aload 5
    //   82: astore 6
    //   84: aload 4
    //   86: invokevirtual 53	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   89: invokestatic 151	com/tencent/mm/hardcoder/f:wn	(Ljava/lang/String;)J
    //   92: lstore_2
    //   93: aload 4
    //   95: invokevirtual 72	java/io/BufferedReader:close	()V
    //   98: aload 5
    //   100: invokevirtual 71	java/io/FileReader:close	()V
    //   103: ldc 132
    //   105: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: lload_2
    //   109: lreturn
    //   110: astore 4
    //   112: ldc 77
    //   114: new 19	java/lang/StringBuilder
    //   117: dup
    //   118: ldc 153
    //   120: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload 4
    //   125: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   128: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: goto -39 -> 98
    //   140: astore 4
    //   142: ldc 77
    //   144: new 19	java/lang/StringBuilder
    //   147: dup
    //   148: ldc 155
    //   150: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   153: aload 4
    //   155: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   158: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   186: ldc 77
    //   188: new 19	java/lang/StringBuilder
    //   191: dup
    //   192: ldc 157
    //   194: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   197: aload 8
    //   199: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   202: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 4
    //   213: ifnull +8 -> 221
    //   216: aload 4
    //   218: invokevirtual 72	java/io/BufferedReader:close	()V
    //   221: aload 5
    //   223: ifnull +8 -> 231
    //   226: aload 5
    //   228: invokevirtual 71	java/io/FileReader:close	()V
    //   231: ldc 132
    //   233: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   236: ldc2_w 144
    //   239: lreturn
    //   240: astore 4
    //   242: ldc 77
    //   244: new 19	java/lang/StringBuilder
    //   247: dup
    //   248: ldc 153
    //   250: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   253: aload 4
    //   255: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   258: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   267: goto -46 -> 221
    //   270: astore 4
    //   272: ldc 77
    //   274: new 19	java/lang/StringBuilder
    //   277: dup
    //   278: ldc 155
    //   280: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload 4
    //   285: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   288: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: goto -66 -> 231
    //   300: astore 4
    //   302: aconst_null
    //   303: astore 7
    //   305: aconst_null
    //   306: astore 5
    //   308: aload 7
    //   310: ifnull +8 -> 318
    //   313: aload 7
    //   315: invokevirtual 72	java/io/BufferedReader:close	()V
    //   318: aload 5
    //   320: ifnull +8 -> 328
    //   323: aload 5
    //   325: invokevirtual 71	java/io/FileReader:close	()V
    //   328: ldc 132
    //   330: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   333: aload 4
    //   335: athrow
    //   336: astore 6
    //   338: ldc 77
    //   340: new 19	java/lang/StringBuilder
    //   343: dup
    //   344: ldc 153
    //   346: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   349: aload 6
    //   351: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   354: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   363: goto -45 -> 318
    //   366: astore 5
    //   368: ldc 77
    //   370: new 19	java/lang/StringBuilder
    //   373: dup
    //   374: ldc 155
    //   376: invokespecial 25	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   379: aload 5
    //   381: invokevirtual 82	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   384: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 88	com/tencent/mm/hardcoder/d:e	(Ljava/lang/String;Ljava/lang/String;)V
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
  
  private static long wn(String paramString)
  {
    AppMethodBeat.i(62484);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(62484);
        return 0L;
      }
      long l = Long.decode(paramString).longValue();
      AppMethodBeat.o(62484);
      return l;
    }
    catch (NumberFormatException paramString)
    {
      d.printErrStackTrace("Hardcoder.HardCoderUtil", paramString, "getLong", new Object[0]);
      AppMethodBeat.o(62484);
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.hardcoder.f
 * JD-Core Version:    0.7.0.1
 */