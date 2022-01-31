package com.tencent.mm.modelvoice;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import junit.framework.Assert;

public final class o
{
  public static int g(String paramString, int paramInt, boolean paramBoolean)
  {
    if (bk.bl(paramString)) {
      return -1;
    }
    y.d("MicroMsg.VoiceFile", "fileName " + paramString);
    if (h(paramString, paramInt, paramBoolean)) {
      return 0;
    }
    if (i(paramString, paramInt, paramBoolean)) {
      return 2;
    }
    return 1;
  }
  
  /* Error */
  private static boolean h(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_2
    //   1: ifeq +73 -> 74
    //   4: ldc 14
    //   6: new 16	java/lang/StringBuilder
    //   9: dup
    //   10: ldc 50
    //   12: invokespecial 22	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 36	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: new 52	java/io/RandomAccessFile
    //   28: dup
    //   29: aload_0
    //   30: ldc 54
    //   32: invokespecial 56	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: astore_3
    //   36: aload_3
    //   37: astore_0
    //   38: bipush 6
    //   40: newarray byte
    //   42: astore 4
    //   44: aload_3
    //   45: astore_0
    //   46: aload_3
    //   47: aload 4
    //   49: iconst_0
    //   50: bipush 6
    //   52: invokevirtual 60	java/io/RandomAccessFile:read	([BII)I
    //   55: iconst_m1
    //   56: if_icmpne +52 -> 108
    //   59: aload_3
    //   60: astore_0
    //   61: ldc 14
    //   63: ldc 62
    //   65: invokestatic 65	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload_3
    //   69: invokevirtual 69	java/io/RandomAccessFile:close	()V
    //   72: iconst_0
    //   73: ireturn
    //   74: iload_1
    //   75: ifne +243 -> 318
    //   78: aload_0
    //   79: invokestatic 75	com/tencent/mm/modelvoice/q:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   82: astore_0
    //   83: goto -79 -> 4
    //   86: astore_0
    //   87: ldc 14
    //   89: ldc 77
    //   91: iconst_1
    //   92: anewarray 4	java/lang/Object
    //   95: dup
    //   96: iconst_0
    //   97: aload_0
    //   98: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   101: aastore
    //   102: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   105: goto -33 -> 72
    //   108: aload_3
    //   109: astore_0
    //   110: new 86	java/lang/String
    //   113: dup
    //   114: aload 4
    //   116: invokespecial 89	java/lang/String:<init>	([B)V
    //   119: astore 5
    //   121: aload_3
    //   122: astore_0
    //   123: ldc 14
    //   125: ldc 91
    //   127: iconst_3
    //   128: anewarray 4	java/lang/Object
    //   131: dup
    //   132: iconst_0
    //   133: aload 4
    //   135: invokestatic 95	com/tencent/mm/sdk/platformtools/bk:bD	([B)Ljava/lang/String;
    //   138: aastore
    //   139: dup
    //   140: iconst_1
    //   141: aload 5
    //   143: aastore
    //   144: dup
    //   145: iconst_2
    //   146: ldc 97
    //   148: aastore
    //   149: invokestatic 99	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   152: aload_3
    //   153: astore_0
    //   154: aload 5
    //   156: ldc 97
    //   158: invokevirtual 102	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   161: istore_2
    //   162: iload_2
    //   163: ifeq +31 -> 194
    //   166: aload_3
    //   167: invokevirtual 69	java/io/RandomAccessFile:close	()V
    //   170: iconst_1
    //   171: ireturn
    //   172: astore_0
    //   173: ldc 14
    //   175: ldc 77
    //   177: iconst_1
    //   178: anewarray 4	java/lang/Object
    //   181: dup
    //   182: iconst_0
    //   183: aload_0
    //   184: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   187: aastore
    //   188: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   191: goto -21 -> 170
    //   194: aload_3
    //   195: invokevirtual 69	java/io/RandomAccessFile:close	()V
    //   198: iconst_0
    //   199: ireturn
    //   200: astore_0
    //   201: ldc 14
    //   203: ldc 77
    //   205: iconst_1
    //   206: anewarray 4	java/lang/Object
    //   209: dup
    //   210: iconst_0
    //   211: aload_0
    //   212: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   215: aastore
    //   216: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: goto -21 -> 198
    //   222: astore 4
    //   224: aconst_null
    //   225: astore_3
    //   226: aload_3
    //   227: astore_0
    //   228: ldc 14
    //   230: aload 4
    //   232: ldc 104
    //   234: iconst_0
    //   235: anewarray 4	java/lang/Object
    //   238: invokestatic 108	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: aload_3
    //   242: ifnull -44 -> 198
    //   245: aload_3
    //   246: invokevirtual 69	java/io/RandomAccessFile:close	()V
    //   249: goto -51 -> 198
    //   252: astore_0
    //   253: ldc 14
    //   255: ldc 77
    //   257: iconst_1
    //   258: anewarray 4	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: aload_0
    //   264: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   267: aastore
    //   268: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: goto -73 -> 198
    //   274: astore_3
    //   275: aconst_null
    //   276: astore_0
    //   277: aload_0
    //   278: ifnull +7 -> 285
    //   281: aload_0
    //   282: invokevirtual 69	java/io/RandomAccessFile:close	()V
    //   285: aload_3
    //   286: athrow
    //   287: astore_0
    //   288: ldc 14
    //   290: ldc 77
    //   292: iconst_1
    //   293: anewarray 4	java/lang/Object
    //   296: dup
    //   297: iconst_0
    //   298: aload_0
    //   299: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   302: aastore
    //   303: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   306: goto -21 -> 285
    //   309: astore_3
    //   310: goto -33 -> 277
    //   313: astore 4
    //   315: goto -89 -> 226
    //   318: aconst_null
    //   319: astore_0
    //   320: goto -316 -> 4
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	paramString	String
    //   0	323	1	paramInt	int
    //   0	323	2	paramBoolean	boolean
    //   35	211	3	localRandomAccessFile	java.io.RandomAccessFile
    //   274	12	3	localObject1	Object
    //   309	1	3	localObject2	Object
    //   42	92	4	arrayOfByte	byte[]
    //   222	9	4	localException1	java.lang.Exception
    //   313	1	4	localException2	java.lang.Exception
    //   119	36	5	str	String
    // Exception table:
    //   from	to	target	type
    //   68	72	86	java/io/IOException
    //   166	170	172	java/io/IOException
    //   194	198	200	java/io/IOException
    //   25	36	222	java/lang/Exception
    //   245	249	252	java/io/IOException
    //   25	36	274	finally
    //   281	285	287	java/io/IOException
    //   38	44	309	finally
    //   46	59	309	finally
    //   61	68	309	finally
    //   110	121	309	finally
    //   123	152	309	finally
    //   154	162	309	finally
    //   228	241	309	finally
    //   38	44	313	java/lang/Exception
    //   46	59	313	java/lang/Exception
    //   61	68	313	java/lang/Exception
    //   110	121	313	java/lang/Exception
    //   123	152	313	java/lang/Exception
    //   154	162	313	java/lang/Exception
  }
  
  /* Error */
  public static boolean i(String paramString, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iload_2
    //   3: ifeq +65 -> 68
    //   6: ldc 14
    //   8: new 16	java/lang/StringBuilder
    //   11: dup
    //   12: ldc 110
    //   14: invokespecial 22	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: invokevirtual 26	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokestatic 36	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: new 52	java/io/RandomAccessFile
    //   30: dup
    //   31: aload_0
    //   32: ldc 54
    //   34: invokespecial 56	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   37: astore_0
    //   38: bipush 9
    //   40: newarray byte
    //   42: astore_3
    //   43: aload_0
    //   44: lconst_1
    //   45: invokevirtual 114	java/io/RandomAccessFile:seek	(J)V
    //   48: aload_0
    //   49: aload_3
    //   50: iconst_0
    //   51: bipush 9
    //   53: invokevirtual 60	java/io/RandomAccessFile:read	([BII)I
    //   56: istore_1
    //   57: iload_1
    //   58: iconst_m1
    //   59: if_icmpne +65 -> 124
    //   62: aload_0
    //   63: invokevirtual 69	java/io/RandomAccessFile:close	()V
    //   66: iconst_0
    //   67: ireturn
    //   68: iload_1
    //   69: ifne +11 -> 80
    //   72: aload_0
    //   73: invokestatic 75	com/tencent/mm/modelvoice/q:getFullPath	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_0
    //   77: goto -71 -> 6
    //   80: iload_1
    //   81: iconst_1
    //   82: if_icmpne +254 -> 336
    //   85: ldc 14
    //   87: ldc 116
    //   89: iconst_1
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_0
    //   96: aastore
    //   97: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: iconst_0
    //   101: ireturn
    //   102: astore_0
    //   103: ldc 14
    //   105: ldc 77
    //   107: iconst_1
    //   108: anewarray 4	java/lang/Object
    //   111: dup
    //   112: iconst_0
    //   113: aload_0
    //   114: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   117: aastore
    //   118: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   121: goto -55 -> 66
    //   124: new 86	java/lang/String
    //   127: dup
    //   128: aload_3
    //   129: invokespecial 89	java/lang/String:<init>	([B)V
    //   132: astore 4
    //   134: ldc 14
    //   136: ldc 118
    //   138: iconst_3
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_3
    //   145: invokestatic 95	com/tencent/mm/sdk/platformtools/bk:bD	([B)Ljava/lang/String;
    //   148: aastore
    //   149: dup
    //   150: iconst_1
    //   151: aload 4
    //   153: aastore
    //   154: dup
    //   155: iconst_2
    //   156: ldc 120
    //   158: aastore
    //   159: invokestatic 99	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: aload 4
    //   164: ldc 120
    //   166: invokevirtual 102	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   169: istore_2
    //   170: iload_2
    //   171: ifeq +31 -> 202
    //   174: aload_0
    //   175: invokevirtual 69	java/io/RandomAccessFile:close	()V
    //   178: iconst_1
    //   179: ireturn
    //   180: astore_0
    //   181: ldc 14
    //   183: ldc 77
    //   185: iconst_1
    //   186: anewarray 4	java/lang/Object
    //   189: dup
    //   190: iconst_0
    //   191: aload_0
    //   192: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   195: aastore
    //   196: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: goto -21 -> 178
    //   202: aload_0
    //   203: invokevirtual 69	java/io/RandomAccessFile:close	()V
    //   206: iconst_0
    //   207: ireturn
    //   208: astore_0
    //   209: ldc 14
    //   211: ldc 77
    //   213: iconst_1
    //   214: anewarray 4	java/lang/Object
    //   217: dup
    //   218: iconst_0
    //   219: aload_0
    //   220: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   223: aastore
    //   224: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: goto -21 -> 206
    //   230: astore_0
    //   231: aload_3
    //   232: astore_0
    //   233: ldc 14
    //   235: ldc 122
    //   237: invokestatic 36	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload_0
    //   241: ifnull -35 -> 206
    //   244: aload_0
    //   245: invokevirtual 69	java/io/RandomAccessFile:close	()V
    //   248: goto -42 -> 206
    //   251: astore_0
    //   252: ldc 14
    //   254: ldc 77
    //   256: iconst_1
    //   257: anewarray 4	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: aload_0
    //   263: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   266: aastore
    //   267: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: goto -64 -> 206
    //   273: astore_0
    //   274: aconst_null
    //   275: astore_3
    //   276: aload_3
    //   277: ifnull +7 -> 284
    //   280: aload_3
    //   281: invokevirtual 69	java/io/RandomAccessFile:close	()V
    //   284: aload_0
    //   285: athrow
    //   286: astore_3
    //   287: ldc 14
    //   289: ldc 77
    //   291: iconst_1
    //   292: anewarray 4	java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: aload_3
    //   298: invokestatic 81	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   301: aastore
    //   302: invokestatic 84	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   305: goto -21 -> 284
    //   308: astore_3
    //   309: aload_0
    //   310: astore 4
    //   312: aload_3
    //   313: astore_0
    //   314: aload 4
    //   316: astore_3
    //   317: goto -41 -> 276
    //   320: astore_3
    //   321: aload_0
    //   322: astore 4
    //   324: aload_3
    //   325: astore_0
    //   326: aload 4
    //   328: astore_3
    //   329: goto -53 -> 276
    //   332: astore_3
    //   333: goto -100 -> 233
    //   336: aconst_null
    //   337: astore_0
    //   338: goto -332 -> 6
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramString	String
    //   0	341	1	paramInt	int
    //   0	341	2	paramBoolean	boolean
    //   1	280	3	arrayOfByte	byte[]
    //   286	12	3	localIOException	java.io.IOException
    //   308	5	3	localObject1	Object
    //   316	1	3	localObject2	Object
    //   320	5	3	localObject3	Object
    //   328	1	3	localObject4	Object
    //   332	1	3	localException	java.lang.Exception
    //   132	195	4	str	String
    // Exception table:
    //   from	to	target	type
    //   62	66	102	java/io/IOException
    //   174	178	180	java/io/IOException
    //   202	206	208	java/io/IOException
    //   27	38	230	java/lang/Exception
    //   244	248	251	java/io/IOException
    //   27	38	273	finally
    //   280	284	286	java/io/IOException
    //   38	57	308	finally
    //   124	170	308	finally
    //   233	240	320	finally
    //   38	57	332	java/lang/Exception
    //   124	170	332	java/lang/Exception
  }
  
  public static int nU(String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int j = 0;
    int i;
    int k;
    switch (ou(paramString))
    {
    default: 
      i = ov(q.getFullPath(paramString));
      return i;
    case 0: 
      return ov(q.getFullPath(paramString));
    case 1: 
      paramString = q.getFullPath(paramString);
      if (paramString.length() >= 0) {}
      for (;;)
      {
        Assert.assertTrue(bool1);
        paramString = new File(paramString);
        i = j;
        if (!paramString.exists()) {
          break;
        }
        k = (int)paramString.length();
        i = j;
        if (k <= 0) {
          break;
        }
        return k;
        bool1 = false;
      }
    }
    paramString = q.getFullPath(paramString);
    if (paramString.length() >= 0) {}
    for (bool1 = bool2;; bool1 = false)
    {
      Assert.assertTrue(bool1);
      paramString = new File(paramString);
      i = j;
      if (!paramString.exists()) {
        break;
      }
      k = (int)paramString.length();
      i = j;
      if (k <= 0) {
        break;
      }
      return k;
    }
  }
  
  public static int ou(String paramString)
  {
    int i = 0;
    if (bk.bl(paramString)) {
      i = -1;
    }
    do
    {
      return i;
      y.d("MicroMsg.VoiceFile", "fileName " + paramString);
    } while (h(paramString, 0, false));
    if (i(paramString, 0, false)) {
      return 2;
    }
    return 1;
  }
  
  private static int ov(String paramString)
  {
    boolean bool;
    if (paramString.length() >= 0)
    {
      bool = true;
      Assert.assertTrue(bool);
      paramString = new File(paramString);
      if (paramString.exists()) {
        break label36;
      }
    }
    label36:
    int i;
    do
    {
      return 0;
      bool = false;
      break;
      i = (int)paramString.length() - 6;
    } while (i <= 0);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvoice.o
 * JD-Core Version:    0.7.0.1
 */