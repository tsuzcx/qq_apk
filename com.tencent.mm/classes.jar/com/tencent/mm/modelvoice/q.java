package com.tencent.mm.modelvoice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import junit.framework.Assert;

public final class q
{
  public static int g(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(116606);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116606);
      return -1;
    }
    ab.d("MicroMsg.VoiceFile", "fileName ".concat(String.valueOf(paramString)));
    if (h(paramString, paramInt, paramBoolean))
    {
      AppMethodBeat.o(116606);
      return 0;
    }
    if (i(paramString, paramInt, paramBoolean))
    {
      AppMethodBeat.o(116606);
      return 2;
    }
    AppMethodBeat.o(116606);
    return 1;
  }
  
  /* Error */
  private static boolean h(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 54
    //   2: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iload_2
    //   6: ifeq +71 -> 77
    //   9: ldc 24
    //   11: ldc 56
    //   13: aload_0
    //   14: invokestatic 32	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   17: invokevirtual 36	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   20: invokestatic 42	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: new 58	java/io/RandomAccessFile
    //   26: dup
    //   27: aload_0
    //   28: ldc 60
    //   30: invokespecial 63	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   33: astore_3
    //   34: aload_3
    //   35: astore_0
    //   36: bipush 6
    //   38: newarray byte
    //   40: astore 4
    //   42: aload_3
    //   43: astore_0
    //   44: aload_3
    //   45: aload 4
    //   47: iconst_0
    //   48: bipush 6
    //   50: invokevirtual 67	java/io/RandomAccessFile:read	([BII)I
    //   53: iconst_m1
    //   54: if_icmpne +57 -> 111
    //   57: aload_3
    //   58: astore_0
    //   59: ldc 24
    //   61: ldc 69
    //   63: invokestatic 72	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_3
    //   67: invokevirtual 76	java/io/RandomAccessFile:close	()V
    //   70: ldc 54
    //   72: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: iconst_0
    //   76: ireturn
    //   77: iload_1
    //   78: ifne +258 -> 336
    //   81: aload_0
    //   82: invokestatic 81	com/tencent/mm/modelvoice/s:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   85: astore_0
    //   86: goto -77 -> 9
    //   89: astore_0
    //   90: ldc 24
    //   92: ldc 83
    //   94: iconst_1
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload_0
    //   101: invokestatic 87	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   104: aastore
    //   105: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: goto -38 -> 70
    //   111: aload_3
    //   112: astore_0
    //   113: new 28	java/lang/String
    //   116: dup
    //   117: aload 4
    //   119: invokespecial 93	java/lang/String:<init>	([B)V
    //   122: astore 5
    //   124: aload_3
    //   125: astore_0
    //   126: ldc 24
    //   128: ldc 95
    //   130: iconst_3
    //   131: anewarray 4	java/lang/Object
    //   134: dup
    //   135: iconst_0
    //   136: aload 4
    //   138: invokestatic 99	com/tencent/mm/sdk/platformtools/bo:cd	([B)Ljava/lang/String;
    //   141: aastore
    //   142: dup
    //   143: iconst_1
    //   144: aload 5
    //   146: aastore
    //   147: dup
    //   148: iconst_2
    //   149: ldc 101
    //   151: aastore
    //   152: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: aload_3
    //   156: astore_0
    //   157: aload 5
    //   159: ldc 101
    //   161: invokevirtual 106	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   164: istore_2
    //   165: iload_2
    //   166: ifeq +36 -> 202
    //   169: aload_3
    //   170: invokevirtual 76	java/io/RandomAccessFile:close	()V
    //   173: ldc 54
    //   175: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   178: iconst_1
    //   179: ireturn
    //   180: astore_0
    //   181: ldc 24
    //   183: ldc 83
    //   185: iconst_1
    //   186: anewarray 4	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: aload_0
    //   192: invokestatic 87	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   195: aastore
    //   196: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: goto -26 -> 173
    //   202: aload_3
    //   203: invokevirtual 76	java/io/RandomAccessFile:close	()V
    //   206: ldc 54
    //   208: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   211: iconst_0
    //   212: ireturn
    //   213: astore_0
    //   214: ldc 24
    //   216: ldc 83
    //   218: iconst_1
    //   219: anewarray 4	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_0
    //   225: invokestatic 87	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   228: aastore
    //   229: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   232: goto -26 -> 206
    //   235: astore 4
    //   237: aconst_null
    //   238: astore_3
    //   239: aload_3
    //   240: astore_0
    //   241: ldc 24
    //   243: aload 4
    //   245: ldc 108
    //   247: iconst_0
    //   248: anewarray 4	java/lang/Object
    //   251: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   254: aload_3
    //   255: ifnull -49 -> 206
    //   258: aload_3
    //   259: invokevirtual 76	java/io/RandomAccessFile:close	()V
    //   262: goto -56 -> 206
    //   265: astore_0
    //   266: ldc 24
    //   268: ldc 83
    //   270: iconst_1
    //   271: anewarray 4	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: aload_0
    //   277: invokestatic 87	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   280: aastore
    //   281: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   284: goto -78 -> 206
    //   287: astore_3
    //   288: aconst_null
    //   289: astore_0
    //   290: aload_0
    //   291: ifnull +7 -> 298
    //   294: aload_0
    //   295: invokevirtual 76	java/io/RandomAccessFile:close	()V
    //   298: ldc 54
    //   300: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   303: aload_3
    //   304: athrow
    //   305: astore_0
    //   306: ldc 24
    //   308: ldc 83
    //   310: iconst_1
    //   311: anewarray 4	java/lang/Object
    //   314: dup
    //   315: iconst_0
    //   316: aload_0
    //   317: invokestatic 87	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   320: aastore
    //   321: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   324: goto -26 -> 298
    //   327: astore_3
    //   328: goto -38 -> 290
    //   331: astore 4
    //   333: goto -94 -> 239
    //   336: aconst_null
    //   337: astore_0
    //   338: goto -329 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramString	String
    //   0	341	1	paramInt	int
    //   0	341	2	paramBoolean	boolean
    //   33	226	3	localRandomAccessFile	java.io.RandomAccessFile
    //   287	17	3	localObject1	Object
    //   327	1	3	localObject2	Object
    //   40	97	4	arrayOfByte	byte[]
    //   235	9	4	localException1	java.lang.Exception
    //   331	1	4	localException2	java.lang.Exception
    //   122	36	5	str	String
    // Exception table:
    //   from	to	target	type
    //   66	70	89	java/io/IOException
    //   169	173	180	java/io/IOException
    //   202	206	213	java/io/IOException
    //   23	34	235	java/lang/Exception
    //   258	262	265	java/io/IOException
    //   23	34	287	finally
    //   294	298	305	java/io/IOException
    //   36	42	327	finally
    //   44	57	327	finally
    //   59	66	327	finally
    //   113	124	327	finally
    //   126	155	327	finally
    //   157	165	327	finally
    //   241	254	327	finally
    //   36	42	331	java/lang/Exception
    //   44	57	331	java/lang/Exception
    //   59	66	331	java/lang/Exception
    //   113	124	331	java/lang/Exception
    //   126	155	331	java/lang/Exception
    //   157	165	331	java/lang/Exception
  }
  
  /* Error */
  public static boolean i(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 113
    //   4: invokestatic 13	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: iload_2
    //   8: ifeq +63 -> 71
    //   11: ldc 24
    //   13: ldc 115
    //   15: aload_0
    //   16: invokestatic 32	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   19: invokevirtual 36	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   22: invokestatic 42	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: new 58	java/io/RandomAccessFile
    //   28: dup
    //   29: aload_0
    //   30: ldc 60
    //   32: invokespecial 63	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: astore_0
    //   36: bipush 9
    //   38: newarray byte
    //   40: astore_3
    //   41: aload_0
    //   42: lconst_1
    //   43: invokevirtual 119	java/io/RandomAccessFile:seek	(J)V
    //   46: aload_0
    //   47: aload_3
    //   48: iconst_0
    //   49: bipush 9
    //   51: invokevirtual 67	java/io/RandomAccessFile:read	([BII)I
    //   54: istore_1
    //   55: iload_1
    //   56: iconst_m1
    //   57: if_icmpne +75 -> 132
    //   60: aload_0
    //   61: invokevirtual 76	java/io/RandomAccessFile:close	()V
    //   64: ldc 113
    //   66: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iconst_0
    //   70: ireturn
    //   71: iload_1
    //   72: ifne +11 -> 83
    //   75: aload_0
    //   76: invokestatic 81	com/tencent/mm/modelvoice/s:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   79: astore_0
    //   80: goto -69 -> 11
    //   83: iload_1
    //   84: iconst_1
    //   85: if_icmpne +274 -> 359
    //   88: ldc 24
    //   90: ldc 121
    //   92: iconst_1
    //   93: anewarray 4	java/lang/Object
    //   96: dup
    //   97: iconst_0
    //   98: aload_0
    //   99: aastore
    //   100: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: ldc 113
    //   105: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: iconst_0
    //   109: ireturn
    //   110: astore_0
    //   111: ldc 24
    //   113: ldc 83
    //   115: iconst_1
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload_0
    //   122: invokestatic 87	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   125: aastore
    //   126: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   129: goto -65 -> 64
    //   132: new 28	java/lang/String
    //   135: dup
    //   136: aload_3
    //   137: invokespecial 93	java/lang/String:<init>	([B)V
    //   140: astore 4
    //   142: ldc 24
    //   144: ldc 123
    //   146: iconst_3
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload_3
    //   153: invokestatic 99	com/tencent/mm/sdk/platformtools/bo:cd	([B)Ljava/lang/String;
    //   156: aastore
    //   157: dup
    //   158: iconst_1
    //   159: aload 4
    //   161: aastore
    //   162: dup
    //   163: iconst_2
    //   164: ldc 125
    //   166: aastore
    //   167: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   170: aload 4
    //   172: ldc 125
    //   174: invokevirtual 106	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   177: istore_2
    //   178: iload_2
    //   179: ifeq +36 -> 215
    //   182: aload_0
    //   183: invokevirtual 76	java/io/RandomAccessFile:close	()V
    //   186: ldc 113
    //   188: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   191: iconst_1
    //   192: ireturn
    //   193: astore_0
    //   194: ldc 24
    //   196: ldc 83
    //   198: iconst_1
    //   199: anewarray 4	java/lang/Object
    //   202: dup
    //   203: iconst_0
    //   204: aload_0
    //   205: invokestatic 87	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   208: aastore
    //   209: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: goto -26 -> 186
    //   215: aload_0
    //   216: invokevirtual 76	java/io/RandomAccessFile:close	()V
    //   219: ldc 113
    //   221: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   224: iconst_0
    //   225: ireturn
    //   226: astore_0
    //   227: ldc 24
    //   229: ldc 83
    //   231: iconst_1
    //   232: anewarray 4	java/lang/Object
    //   235: dup
    //   236: iconst_0
    //   237: aload_0
    //   238: invokestatic 87	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   241: aastore
    //   242: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   245: goto -26 -> 219
    //   248: astore_0
    //   249: aload_3
    //   250: astore_0
    //   251: ldc 24
    //   253: ldc 127
    //   255: invokestatic 42	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: aload_0
    //   259: ifnull -40 -> 219
    //   262: aload_0
    //   263: invokevirtual 76	java/io/RandomAccessFile:close	()V
    //   266: goto -47 -> 219
    //   269: astore_0
    //   270: ldc 24
    //   272: ldc 83
    //   274: iconst_1
    //   275: anewarray 4	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: aload_0
    //   281: invokestatic 87	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   284: aastore
    //   285: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   288: goto -69 -> 219
    //   291: astore_0
    //   292: aconst_null
    //   293: astore_3
    //   294: aload_3
    //   295: ifnull +7 -> 302
    //   298: aload_3
    //   299: invokevirtual 76	java/io/RandomAccessFile:close	()V
    //   302: ldc 113
    //   304: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: aload_0
    //   308: athrow
    //   309: astore_3
    //   310: ldc 24
    //   312: ldc 83
    //   314: iconst_1
    //   315: anewarray 4	java/lang/Object
    //   318: dup
    //   319: iconst_0
    //   320: aload_3
    //   321: invokestatic 87	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   324: aastore
    //   325: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   328: goto -26 -> 302
    //   331: astore_3
    //   332: aload_0
    //   333: astore 4
    //   335: aload_3
    //   336: astore_0
    //   337: aload 4
    //   339: astore_3
    //   340: goto -46 -> 294
    //   343: astore_3
    //   344: aload_0
    //   345: astore 4
    //   347: aload_3
    //   348: astore_0
    //   349: aload 4
    //   351: astore_3
    //   352: goto -58 -> 294
    //   355: astore_3
    //   356: goto -105 -> 251
    //   359: aconst_null
    //   360: astore_0
    //   361: goto -350 -> 11
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	paramString	String
    //   0	364	1	paramInt	int
    //   0	364	2	paramBoolean	boolean
    //   1	298	3	arrayOfByte	byte[]
    //   309	12	3	localIOException	java.io.IOException
    //   331	5	3	localObject1	Object
    //   339	1	3	localObject2	Object
    //   343	5	3	localObject3	Object
    //   351	1	3	localObject4	Object
    //   355	1	3	localException	java.lang.Exception
    //   140	210	4	str	String
    // Exception table:
    //   from	to	target	type
    //   60	64	110	java/io/IOException
    //   182	186	193	java/io/IOException
    //   215	219	226	java/io/IOException
    //   25	36	248	java/lang/Exception
    //   262	266	269	java/io/IOException
    //   25	36	291	finally
    //   298	302	309	java/io/IOException
    //   36	55	331	finally
    //   132	178	331	finally
    //   251	258	343	finally
    //   36	55	355	java/lang/Exception
    //   132	178	355	java/lang/Exception
  }
  
  public static int vH(String paramString)
  {
    AppMethodBeat.i(116605);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(116605);
      return -1;
    }
    ab.d("MicroMsg.VoiceFile", "fileName ".concat(String.valueOf(paramString)));
    if (h(paramString, 0, false))
    {
      AppMethodBeat.o(116605);
      return 0;
    }
    if (i(paramString, 0, false))
    {
      AppMethodBeat.o(116605);
      return 2;
    }
    AppMethodBeat.o(116605);
    return 1;
  }
  
  private static int vI(String paramString)
  {
    AppMethodBeat.i(116610);
    if (paramString.length() >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      paramString = new File(paramString);
      if (paramString.exists()) {
        break;
      }
      AppMethodBeat.o(116610);
      return 0;
    }
    int i = (int)paramString.length() - 6;
    if (i <= 0)
    {
      AppMethodBeat.o(116610);
      return 0;
    }
    AppMethodBeat.o(116610);
    return i;
  }
  
  public static int vh(String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(116609);
    switch (vH(paramString))
    {
    default: 
      i = vI(s.getFullPath(paramString));
      AppMethodBeat.o(116609);
      return i;
    case 0: 
      i = vI(s.getFullPath(paramString));
      AppMethodBeat.o(116609);
      return i;
    case 1: 
      paramString = s.getFullPath(paramString);
      if (paramString.length() >= 0) {}
      for (;;)
      {
        Assert.assertTrue(bool1);
        paramString = new File(paramString);
        if (paramString.exists()) {
          break;
        }
        AppMethodBeat.o(116609);
        return 0;
        bool1 = false;
      }
      i = (int)paramString.length();
      if (i <= 0)
      {
        AppMethodBeat.o(116609);
        return 0;
      }
      AppMethodBeat.o(116609);
      return i;
    }
    paramString = s.getFullPath(paramString);
    if (paramString.length() >= 0) {}
    for (bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramString = new File(paramString);
      if (paramString.exists()) {
        break;
      }
      AppMethodBeat.o(116609);
      return 0;
    }
    int i = (int)paramString.length();
    if (i <= 0)
    {
      AppMethodBeat.o(116609);
      return 0;
    }
    AppMethodBeat.o(116609);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.q
 * JD-Core Version:    0.7.0.1
 */