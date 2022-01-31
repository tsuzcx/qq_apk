package com.tencent.mm.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class e
{
  /* Error */
  public static int a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +16 -> 17
    //   4: aload_1
    //   5: arraylength
    //   6: ifeq +11 -> 17
    //   9: aload_1
    //   10: arraylength
    //   11: iload_2
    //   12: iconst_0
    //   13: iadd
    //   14: if_icmpge +6 -> 20
    //   17: bipush 254
    //   19: ireturn
    //   20: new 12	java/io/FileOutputStream
    //   23: dup
    //   24: aload_0
    //   25: iconst_1
    //   26: invokespecial 16	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   29: astore 4
    //   31: aload 4
    //   33: astore_3
    //   34: aload 4
    //   36: aload_1
    //   37: iconst_0
    //   38: iload_2
    //   39: invokevirtual 20	java/io/FileOutputStream:write	([BII)V
    //   42: aload 4
    //   44: invokevirtual 24	java/io/FileOutputStream:close	()V
    //   47: iconst_0
    //   48: ireturn
    //   49: astore_3
    //   50: ldc 26
    //   52: aload_3
    //   53: ldc 28
    //   55: iconst_0
    //   56: anewarray 4	java/lang/Object
    //   59: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: ldc 26
    //   64: ldc 36
    //   66: bipush 6
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_3
    //   74: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   77: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   80: aastore
    //   81: dup
    //   82: iconst_1
    //   83: aload_3
    //   84: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   87: aastore
    //   88: dup
    //   89: iconst_2
    //   90: aload_0
    //   91: aastore
    //   92: dup
    //   93: iconst_3
    //   94: aload_1
    //   95: arraylength
    //   96: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   99: aastore
    //   100: dup
    //   101: iconst_4
    //   102: iconst_0
    //   103: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   106: aastore
    //   107: dup
    //   108: iconst_5
    //   109: iload_2
    //   110: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   113: aastore
    //   114: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: iconst_0
    //   118: ireturn
    //   119: astore 5
    //   121: aconst_null
    //   122: astore 4
    //   124: aload 4
    //   126: astore_3
    //   127: ldc 26
    //   129: aload 5
    //   131: ldc 28
    //   133: iconst_0
    //   134: anewarray 4	java/lang/Object
    //   137: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: aload 4
    //   142: astore_3
    //   143: ldc 26
    //   145: ldc 61
    //   147: bipush 6
    //   149: anewarray 4	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload 5
    //   156: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   159: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload 5
    //   167: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   170: aastore
    //   171: dup
    //   172: iconst_2
    //   173: aload_0
    //   174: aastore
    //   175: dup
    //   176: iconst_3
    //   177: aload_1
    //   178: arraylength
    //   179: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   182: aastore
    //   183: dup
    //   184: iconst_4
    //   185: iconst_0
    //   186: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: aastore
    //   190: dup
    //   191: iconst_5
    //   192: iload_2
    //   193: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: aastore
    //   197: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   200: aload 4
    //   202: ifnull +8 -> 210
    //   205: aload 4
    //   207: invokevirtual 24	java/io/FileOutputStream:close	()V
    //   210: iconst_m1
    //   211: ireturn
    //   212: astore_3
    //   213: ldc 26
    //   215: aload_3
    //   216: ldc 28
    //   218: iconst_0
    //   219: anewarray 4	java/lang/Object
    //   222: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   225: ldc 26
    //   227: ldc 36
    //   229: bipush 6
    //   231: anewarray 4	java/lang/Object
    //   234: dup
    //   235: iconst_0
    //   236: aload_3
    //   237: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   240: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   243: aastore
    //   244: dup
    //   245: iconst_1
    //   246: aload_3
    //   247: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   250: aastore
    //   251: dup
    //   252: iconst_2
    //   253: aload_0
    //   254: aastore
    //   255: dup
    //   256: iconst_3
    //   257: aload_1
    //   258: arraylength
    //   259: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   262: aastore
    //   263: dup
    //   264: iconst_4
    //   265: iconst_0
    //   266: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: aastore
    //   270: dup
    //   271: iconst_5
    //   272: iload_2
    //   273: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   276: aastore
    //   277: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   280: goto -70 -> 210
    //   283: astore 4
    //   285: aconst_null
    //   286: astore_3
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 24	java/io/FileOutputStream:close	()V
    //   295: aload 4
    //   297: athrow
    //   298: astore_3
    //   299: ldc 26
    //   301: aload_3
    //   302: ldc 28
    //   304: iconst_0
    //   305: anewarray 4	java/lang/Object
    //   308: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   311: ldc 26
    //   313: ldc 36
    //   315: bipush 6
    //   317: anewarray 4	java/lang/Object
    //   320: dup
    //   321: iconst_0
    //   322: aload_3
    //   323: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   326: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: aload_3
    //   333: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   336: aastore
    //   337: dup
    //   338: iconst_2
    //   339: aload_0
    //   340: aastore
    //   341: dup
    //   342: iconst_3
    //   343: aload_1
    //   344: arraylength
    //   345: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   348: aastore
    //   349: dup
    //   350: iconst_4
    //   351: iconst_0
    //   352: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   355: aastore
    //   356: dup
    //   357: iconst_5
    //   358: iload_2
    //   359: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   362: aastore
    //   363: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   366: goto -71 -> 295
    //   369: astore 4
    //   371: goto -84 -> 287
    //   374: astore 5
    //   376: goto -252 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	paramString	String
    //   0	379	1	paramArrayOfByte	byte[]
    //   0	379	2	paramInt	int
    //   33	1	3	localFileOutputStream1	java.io.FileOutputStream
    //   49	35	3	localIOException1	IOException
    //   126	17	3	localFileOutputStream2	java.io.FileOutputStream
    //   212	35	3	localIOException2	IOException
    //   286	6	3	localObject1	Object
    //   298	35	3	localIOException3	IOException
    //   29	177	4	localFileOutputStream3	java.io.FileOutputStream
    //   283	13	4	localObject2	Object
    //   369	1	4	localObject3	Object
    //   119	47	5	localException1	Exception
    //   374	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   42	47	49	java/io/IOException
    //   20	31	119	java/lang/Exception
    //   205	210	212	java/io/IOException
    //   20	31	283	finally
    //   291	295	298	java/io/IOException
    //   34	42	369	finally
    //   127	140	369	finally
    //   143	200	369	finally
    //   34	42	374	java/lang/Exception
  }
  
  /* Error */
  public static int b(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +6 -> 7
    //   4: bipush 254
    //   6: ireturn
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore 5
    //   13: aload 4
    //   15: astore_3
    //   16: new 67	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 6
    //   26: aload 4
    //   28: astore_3
    //   29: aload 6
    //   31: invokevirtual 74	java/io/File:exists	()Z
    //   34: ifne +12 -> 46
    //   37: aload 4
    //   39: astore_3
    //   40: aload 6
    //   42: invokevirtual 77	java/io/File:mkdirs	()Z
    //   45: pop
    //   46: aload 4
    //   48: astore_3
    //   49: new 67	java/io/File
    //   52: dup
    //   53: new 79	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   74: astore 6
    //   76: aload 4
    //   78: astore_3
    //   79: aload 6
    //   81: invokevirtual 74	java/io/File:exists	()Z
    //   84: ifne +12 -> 96
    //   87: aload 4
    //   89: astore_3
    //   90: aload 6
    //   92: invokevirtual 91	java/io/File:createNewFile	()Z
    //   95: pop
    //   96: aload 4
    //   98: astore_3
    //   99: new 93	java/io/BufferedOutputStream
    //   102: dup
    //   103: new 12	java/io/FileOutputStream
    //   106: dup
    //   107: aload 6
    //   109: iconst_1
    //   110: invokespecial 96	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   113: invokespecial 99	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   116: astore 4
    //   118: aload 4
    //   120: aload_2
    //   121: invokevirtual 102	java/io/BufferedOutputStream:write	([B)V
    //   124: aload 4
    //   126: invokevirtual 105	java/io/BufferedOutputStream:flush	()V
    //   129: aload 4
    //   131: invokevirtual 106	java/io/BufferedOutputStream:close	()V
    //   134: iconst_0
    //   135: ireturn
    //   136: astore_3
    //   137: ldc 26
    //   139: aload_3
    //   140: ldc 28
    //   142: iconst_0
    //   143: anewarray 4	java/lang/Object
    //   146: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   149: ldc 26
    //   151: ldc 108
    //   153: iconst_5
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_3
    //   160: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   163: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: aload_3
    //   170: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   173: aastore
    //   174: dup
    //   175: iconst_2
    //   176: aload_0
    //   177: aastore
    //   178: dup
    //   179: iconst_3
    //   180: aload_1
    //   181: aastore
    //   182: dup
    //   183: iconst_4
    //   184: aload_2
    //   185: arraylength
    //   186: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   189: aastore
    //   190: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   193: iconst_0
    //   194: ireturn
    //   195: astore_3
    //   196: aload 5
    //   198: astore 4
    //   200: aload_3
    //   201: astore 5
    //   203: aload 4
    //   205: astore_3
    //   206: ldc 26
    //   208: aload 5
    //   210: ldc 28
    //   212: iconst_0
    //   213: anewarray 4	java/lang/Object
    //   216: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   219: aload 4
    //   221: astore_3
    //   222: ldc 26
    //   224: ldc 110
    //   226: iconst_5
    //   227: anewarray 4	java/lang/Object
    //   230: dup
    //   231: iconst_0
    //   232: aload 5
    //   234: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   237: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   240: aastore
    //   241: dup
    //   242: iconst_1
    //   243: aload 5
    //   245: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   248: aastore
    //   249: dup
    //   250: iconst_2
    //   251: aload_0
    //   252: aastore
    //   253: dup
    //   254: iconst_3
    //   255: aload_1
    //   256: aastore
    //   257: dup
    //   258: iconst_4
    //   259: aload_2
    //   260: arraylength
    //   261: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: aload 4
    //   270: ifnull +8 -> 278
    //   273: aload 4
    //   275: invokevirtual 106	java/io/BufferedOutputStream:close	()V
    //   278: iconst_m1
    //   279: ireturn
    //   280: astore_3
    //   281: ldc 26
    //   283: aload_3
    //   284: ldc 28
    //   286: iconst_0
    //   287: anewarray 4	java/lang/Object
    //   290: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: ldc 26
    //   295: ldc 108
    //   297: iconst_5
    //   298: anewarray 4	java/lang/Object
    //   301: dup
    //   302: iconst_0
    //   303: aload_3
    //   304: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   307: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   310: aastore
    //   311: dup
    //   312: iconst_1
    //   313: aload_3
    //   314: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   317: aastore
    //   318: dup
    //   319: iconst_2
    //   320: aload_0
    //   321: aastore
    //   322: dup
    //   323: iconst_3
    //   324: aload_1
    //   325: aastore
    //   326: dup
    //   327: iconst_4
    //   328: aload_2
    //   329: arraylength
    //   330: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   333: aastore
    //   334: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: goto -59 -> 278
    //   340: astore 5
    //   342: aload_3
    //   343: astore 4
    //   345: aload 5
    //   347: astore_3
    //   348: aload 4
    //   350: ifnull +8 -> 358
    //   353: aload 4
    //   355: invokevirtual 106	java/io/BufferedOutputStream:close	()V
    //   358: aload_3
    //   359: athrow
    //   360: astore 4
    //   362: ldc 26
    //   364: aload 4
    //   366: ldc 28
    //   368: iconst_0
    //   369: anewarray 4	java/lang/Object
    //   372: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   375: ldc 26
    //   377: ldc 108
    //   379: iconst_5
    //   380: anewarray 4	java/lang/Object
    //   383: dup
    //   384: iconst_0
    //   385: aload 4
    //   387: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   390: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   393: aastore
    //   394: dup
    //   395: iconst_1
    //   396: aload 4
    //   398: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   401: aastore
    //   402: dup
    //   403: iconst_2
    //   404: aload_0
    //   405: aastore
    //   406: dup
    //   407: iconst_3
    //   408: aload_1
    //   409: aastore
    //   410: dup
    //   411: iconst_4
    //   412: aload_2
    //   413: arraylength
    //   414: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   417: aastore
    //   418: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   421: goto -63 -> 358
    //   424: astore_3
    //   425: goto -77 -> 348
    //   428: astore 5
    //   430: goto -227 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	433	0	paramString1	String
    //   0	433	1	paramString2	String
    //   0	433	2	paramArrayOfByte	byte[]
    //   15	84	3	localObject1	Object
    //   136	34	3	localIOException1	IOException
    //   195	6	3	localException1	Exception
    //   205	17	3	localObject2	Object
    //   280	63	3	localIOException2	IOException
    //   347	12	3	localObject3	Object
    //   424	1	3	localObject4	Object
    //   8	346	4	localObject5	Object
    //   360	37	4	localIOException3	IOException
    //   11	233	5	localObject6	Object
    //   340	6	5	localObject7	Object
    //   428	1	5	localException2	Exception
    //   24	84	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   129	134	136	java/io/IOException
    //   16	26	195	java/lang/Exception
    //   29	37	195	java/lang/Exception
    //   40	46	195	java/lang/Exception
    //   49	76	195	java/lang/Exception
    //   79	87	195	java/lang/Exception
    //   90	96	195	java/lang/Exception
    //   99	118	195	java/lang/Exception
    //   273	278	280	java/io/IOException
    //   16	26	340	finally
    //   29	37	340	finally
    //   40	46	340	finally
    //   49	76	340	finally
    //   79	87	340	finally
    //   90	96	340	finally
    //   99	118	340	finally
    //   206	219	340	finally
    //   222	268	340	finally
    //   353	358	360	java/io/IOException
    //   118	129	424	finally
    //   118	129	428	java/lang/Exception
  }
  
  /* Error */
  public static int b(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +6 -> 7
    //   4: bipush 254
    //   6: ireturn
    //   7: aload_1
    //   8: arraylength
    //   9: iload_2
    //   10: iconst_0
    //   11: iadd
    //   12: if_icmpge +6 -> 18
    //   15: bipush 253
    //   17: ireturn
    //   18: new 12	java/io/FileOutputStream
    //   21: dup
    //   22: aload_0
    //   23: iconst_0
    //   24: invokespecial 16	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   27: astore 4
    //   29: aload 4
    //   31: astore_3
    //   32: aload 4
    //   34: aload_1
    //   35: iconst_0
    //   36: iload_2
    //   37: invokevirtual 20	java/io/FileOutputStream:write	([BII)V
    //   40: aload 4
    //   42: invokevirtual 24	java/io/FileOutputStream:close	()V
    //   45: iconst_0
    //   46: ireturn
    //   47: astore_3
    //   48: ldc 26
    //   50: aload_3
    //   51: ldc 28
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   60: ldc 26
    //   62: ldc 112
    //   64: bipush 6
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_3
    //   72: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   75: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload_3
    //   82: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   85: aastore
    //   86: dup
    //   87: iconst_2
    //   88: aload_0
    //   89: aastore
    //   90: dup
    //   91: iconst_3
    //   92: aload_1
    //   93: arraylength
    //   94: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: dup
    //   99: iconst_4
    //   100: iconst_0
    //   101: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   104: aastore
    //   105: dup
    //   106: iconst_5
    //   107: iload_2
    //   108: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   111: aastore
    //   112: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   115: iconst_0
    //   116: ireturn
    //   117: astore 5
    //   119: aconst_null
    //   120: astore 4
    //   122: aload 4
    //   124: astore_3
    //   125: ldc 26
    //   127: aload 5
    //   129: ldc 28
    //   131: iconst_0
    //   132: anewarray 4	java/lang/Object
    //   135: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   138: aload 4
    //   140: astore_3
    //   141: ldc 26
    //   143: ldc 114
    //   145: bipush 6
    //   147: anewarray 4	java/lang/Object
    //   150: dup
    //   151: iconst_0
    //   152: aload 5
    //   154: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   157: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   160: aastore
    //   161: dup
    //   162: iconst_1
    //   163: aload 5
    //   165: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   168: aastore
    //   169: dup
    //   170: iconst_2
    //   171: aload_0
    //   172: aastore
    //   173: dup
    //   174: iconst_3
    //   175: aload_1
    //   176: arraylength
    //   177: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: aastore
    //   181: dup
    //   182: iconst_4
    //   183: iconst_0
    //   184: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   187: aastore
    //   188: dup
    //   189: iconst_5
    //   190: iload_2
    //   191: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   194: aastore
    //   195: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: aload 4
    //   200: ifnull +8 -> 208
    //   203: aload 4
    //   205: invokevirtual 24	java/io/FileOutputStream:close	()V
    //   208: iconst_m1
    //   209: ireturn
    //   210: astore_3
    //   211: ldc 26
    //   213: aload_3
    //   214: ldc 28
    //   216: iconst_0
    //   217: anewarray 4	java/lang/Object
    //   220: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   223: ldc 26
    //   225: ldc 112
    //   227: bipush 6
    //   229: anewarray 4	java/lang/Object
    //   232: dup
    //   233: iconst_0
    //   234: aload_3
    //   235: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   238: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   241: aastore
    //   242: dup
    //   243: iconst_1
    //   244: aload_3
    //   245: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   248: aastore
    //   249: dup
    //   250: iconst_2
    //   251: aload_0
    //   252: aastore
    //   253: dup
    //   254: iconst_3
    //   255: aload_1
    //   256: arraylength
    //   257: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   260: aastore
    //   261: dup
    //   262: iconst_4
    //   263: iconst_0
    //   264: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: aastore
    //   268: dup
    //   269: iconst_5
    //   270: iload_2
    //   271: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   274: aastore
    //   275: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: goto -70 -> 208
    //   281: astore 4
    //   283: aconst_null
    //   284: astore_3
    //   285: aload_3
    //   286: ifnull +7 -> 293
    //   289: aload_3
    //   290: invokevirtual 24	java/io/FileOutputStream:close	()V
    //   293: aload 4
    //   295: athrow
    //   296: astore_3
    //   297: ldc 26
    //   299: aload_3
    //   300: ldc 28
    //   302: iconst_0
    //   303: anewarray 4	java/lang/Object
    //   306: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   309: ldc 26
    //   311: ldc 112
    //   313: bipush 6
    //   315: anewarray 4	java/lang/Object
    //   318: dup
    //   319: iconst_0
    //   320: aload_3
    //   321: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   324: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   327: aastore
    //   328: dup
    //   329: iconst_1
    //   330: aload_3
    //   331: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   334: aastore
    //   335: dup
    //   336: iconst_2
    //   337: aload_0
    //   338: aastore
    //   339: dup
    //   340: iconst_3
    //   341: aload_1
    //   342: arraylength
    //   343: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: aastore
    //   347: dup
    //   348: iconst_4
    //   349: iconst_0
    //   350: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   353: aastore
    //   354: dup
    //   355: iconst_5
    //   356: iload_2
    //   357: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   360: aastore
    //   361: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   364: goto -71 -> 293
    //   367: astore 4
    //   369: goto -84 -> 285
    //   372: astore 5
    //   374: goto -252 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	paramString	String
    //   0	377	1	paramArrayOfByte	byte[]
    //   0	377	2	paramInt	int
    //   31	1	3	localFileOutputStream1	java.io.FileOutputStream
    //   47	35	3	localIOException1	IOException
    //   124	17	3	localFileOutputStream2	java.io.FileOutputStream
    //   210	35	3	localIOException2	IOException
    //   284	6	3	localObject1	Object
    //   296	35	3	localIOException3	IOException
    //   27	177	4	localFileOutputStream3	java.io.FileOutputStream
    //   281	13	4	localObject2	Object
    //   367	1	4	localObject3	Object
    //   117	47	5	localException1	Exception
    //   372	1	5	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   40	45	47	java/io/IOException
    //   18	29	117	java/lang/Exception
    //   203	208	210	java/io/IOException
    //   18	29	281	finally
    //   289	293	296	java/io/IOException
    //   32	40	367	finally
    //   125	138	367	finally
    //   141	198	367	finally
    //   32	40	372	java/lang/Exception
  }
  
  public static int bJ(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return 0;
      paramString = new File(paramString);
    } while (!paramString.exists());
    return (int)paramString.length();
  }
  
  public static final boolean bK(String paramString)
  {
    if (paramString == null) {}
    while (!new File(paramString).exists()) {
      return false;
    }
    return true;
  }
  
  public static boolean bL(String paramString)
  {
    return k(new File(paramString));
  }
  
  public static final String bM(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    paramString = new File(paramString).getName();
    int i = paramString.lastIndexOf('.');
    if ((i <= 0) || (i == paramString.length() - 1)) {
      return "";
    }
    return paramString.substring(i + 1);
  }
  
  public static final boolean bN(String paramString)
  {
    if (bk.bl(paramString)) {}
    String[] arrayOfString;
    do
    {
      return false;
      localObject = new File(paramString);
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory())) {
        return true;
      }
      arrayOfString = paramString.split("/");
    } while ((arrayOfString == null) || (arrayOfString.length < 2));
    Object localObject = "/";
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfString.length) {
        break label180;
      }
      paramString = (String)localObject;
      if (!bk.bl(arrayOfString[i]))
      {
        localObject = (String)localObject + "/" + arrayOfString[i];
        File localFile = new File((String)localObject);
        if ((localFile.isFile()) && (!localFile.renameTo(new File((String)localObject + "_mmbak")))) {
          break;
        }
        paramString = (String)localObject;
        if (!localFile.exists())
        {
          if (!localFile.mkdir()) {
            break;
          }
          paramString = (String)localObject;
        }
      }
      i += 1;
      localObject = paramString;
    }
    label180:
    return true;
  }
  
  public static void bO(String paramString)
  {
    File localFile = new File(paramString).getParentFile();
    if ((!localFile.exists()) && ((!localFile.mkdirs()) || (!localFile.isDirectory()))) {
      y.e("MicroMsg.FileOperation", "mkParentDir mkdir error. %s", new Object[] { paramString });
    }
  }
  
  /* Error */
  public static String bP(String paramString)
  {
    // Byte code:
    //   0: new 67	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 74	java/io/File:exists	()Z
    //   11: ifne +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 184	java/lang/StringBuffer
    //   19: dup
    //   20: invokespecial 185	java/lang/StringBuffer:<init>	()V
    //   23: astore_3
    //   24: new 187	java/io/BufferedReader
    //   27: dup
    //   28: new 189	java/io/FileReader
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 190	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   36: invokespecial 193	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   39: astore_2
    //   40: aload_2
    //   41: astore_0
    //   42: sipush 1024
    //   45: newarray char
    //   47: astore 4
    //   49: aload_2
    //   50: astore_0
    //   51: aload_2
    //   52: aload 4
    //   54: invokevirtual 197	java/io/BufferedReader:read	([C)I
    //   57: istore_1
    //   58: iload_1
    //   59: iconst_m1
    //   60: if_icmpeq +38 -> 98
    //   63: aload_2
    //   64: astore_0
    //   65: aload_3
    //   66: aload 4
    //   68: iconst_0
    //   69: iload_1
    //   70: invokestatic 200	java/lang/String:valueOf	([CII)Ljava/lang/String;
    //   73: invokevirtual 203	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   76: pop
    //   77: goto -28 -> 49
    //   80: astore_3
    //   81: aload_2
    //   82: astore_0
    //   83: aload_3
    //   84: astore_2
    //   85: aload_2
    //   86: athrow
    //   87: astore_2
    //   88: aload_0
    //   89: ifnull +7 -> 96
    //   92: aload_0
    //   93: invokevirtual 204	java/io/BufferedReader:close	()V
    //   96: aload_2
    //   97: athrow
    //   98: aload_2
    //   99: invokevirtual 204	java/io/BufferedReader:close	()V
    //   102: aload_3
    //   103: invokevirtual 205	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   106: areturn
    //   107: astore_0
    //   108: aload_0
    //   109: athrow
    //   110: astore_0
    //   111: aload_0
    //   112: athrow
    //   113: astore_2
    //   114: aconst_null
    //   115: astore_0
    //   116: goto -28 -> 88
    //   119: astore_2
    //   120: aconst_null
    //   121: astore_0
    //   122: goto -37 -> 85
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	125	0	paramString	String
    //   57	13	1	i	int
    //   39	47	2	localObject1	Object
    //   87	12	2	localObject2	Object
    //   113	1	2	localObject3	Object
    //   119	1	2	localIOException1	IOException
    //   23	43	3	localStringBuffer	java.lang.StringBuffer
    //   80	23	3	localIOException2	IOException
    //   47	20	4	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   42	49	80	java/io/IOException
    //   51	58	80	java/io/IOException
    //   65	77	80	java/io/IOException
    //   42	49	87	finally
    //   51	58	87	finally
    //   65	77	87	finally
    //   85	87	87	finally
    //   98	102	107	java/lang/Exception
    //   92	96	110	java/lang/Exception
    //   24	40	113	finally
    //   24	40	119	java/io/IOException
  }
  
  public static long c(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (paramInputStream == null) {
      return 0L;
    }
    try
    {
      byte[] arrayOfByte = new byte[4096];
      int i;
      for (long l = 0L;; l += i)
      {
        i = paramInputStream.read(arrayOfByte);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      return l;
    }
    catch (Exception paramInputStream)
    {
      y.w("MicroMsg.FileOperation", "copyStream error: %s", new Object[] { paramInputStream.getMessage() });
    }
    return 0L;
  }
  
  /* Error */
  public static byte[] c(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +9 -> 10
    //   4: aconst_null
    //   5: astore 7
    //   7: aload 7
    //   9: areturn
    //   10: new 67	java/io/File
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 6
    //   20: aload 6
    //   22: invokevirtual 74	java/io/File:exists	()Z
    //   25: ifne +5 -> 30
    //   28: aconst_null
    //   29: areturn
    //   30: iload_2
    //   31: istore_3
    //   32: iload_2
    //   33: iconst_m1
    //   34: if_icmpne +10 -> 44
    //   37: aload 6
    //   39: invokevirtual 120	java/io/File:length	()J
    //   42: l2i
    //   43: istore_3
    //   44: iload_1
    //   45: ifge +5 -> 50
    //   48: aconst_null
    //   49: areturn
    //   50: iload_3
    //   51: ifgt +5 -> 56
    //   54: aconst_null
    //   55: areturn
    //   56: iload_1
    //   57: iload_3
    //   58: iadd
    //   59: aload 6
    //   61: invokevirtual 120	java/io/File:length	()J
    //   64: l2i
    //   65: if_icmple +5 -> 70
    //   68: aconst_null
    //   69: areturn
    //   70: new 220	java/io/RandomAccessFile
    //   73: dup
    //   74: aload_0
    //   75: ldc 222
    //   77: invokespecial 225	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: astore 8
    //   82: aload 8
    //   84: astore 7
    //   86: iload_3
    //   87: newarray byte
    //   89: astore 6
    //   91: iload_1
    //   92: i2l
    //   93: lstore 4
    //   95: aload 8
    //   97: astore 7
    //   99: aload 8
    //   101: lload 4
    //   103: invokevirtual 229	java/io/RandomAccessFile:seek	(J)V
    //   106: aload 8
    //   108: astore 7
    //   110: aload 8
    //   112: aload 6
    //   114: invokevirtual 232	java/io/RandomAccessFile:readFully	([B)V
    //   117: aload 8
    //   119: invokevirtual 233	java/io/RandomAccessFile:close	()V
    //   122: aload 6
    //   124: areturn
    //   125: astore 7
    //   127: ldc 26
    //   129: aload 7
    //   131: ldc 28
    //   133: iconst_0
    //   134: anewarray 4	java/lang/Object
    //   137: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: ldc 26
    //   142: ldc 235
    //   144: iconst_5
    //   145: anewarray 4	java/lang/Object
    //   148: dup
    //   149: iconst_0
    //   150: aload 7
    //   152: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   155: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   158: aastore
    //   159: dup
    //   160: iconst_1
    //   161: aload 7
    //   163: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   166: aastore
    //   167: dup
    //   168: iconst_2
    //   169: aload_0
    //   170: aastore
    //   171: dup
    //   172: iconst_3
    //   173: iload_1
    //   174: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   177: aastore
    //   178: dup
    //   179: iconst_4
    //   180: iload_3
    //   181: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   184: aastore
    //   185: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   188: aload 6
    //   190: areturn
    //   191: astore 9
    //   193: aconst_null
    //   194: astore 8
    //   196: aconst_null
    //   197: astore 6
    //   199: aload 8
    //   201: astore 7
    //   203: ldc 26
    //   205: aload 9
    //   207: ldc 28
    //   209: iconst_0
    //   210: anewarray 4	java/lang/Object
    //   213: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   216: aload 8
    //   218: astore 7
    //   220: ldc 26
    //   222: ldc 237
    //   224: iconst_5
    //   225: anewarray 4	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: aload 9
    //   232: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   235: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   238: aastore
    //   239: dup
    //   240: iconst_1
    //   241: aload 9
    //   243: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   246: aastore
    //   247: dup
    //   248: iconst_2
    //   249: aload_0
    //   250: aastore
    //   251: dup
    //   252: iconst_3
    //   253: iload_1
    //   254: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: dup
    //   259: iconst_4
    //   260: iload_3
    //   261: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   264: aastore
    //   265: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   268: aload 6
    //   270: astore 7
    //   272: aload 8
    //   274: ifnull -267 -> 7
    //   277: aload 8
    //   279: invokevirtual 233	java/io/RandomAccessFile:close	()V
    //   282: aload 6
    //   284: areturn
    //   285: astore 7
    //   287: ldc 26
    //   289: aload 7
    //   291: ldc 28
    //   293: iconst_0
    //   294: anewarray 4	java/lang/Object
    //   297: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: ldc 26
    //   302: ldc 235
    //   304: iconst_5
    //   305: anewarray 4	java/lang/Object
    //   308: dup
    //   309: iconst_0
    //   310: aload 7
    //   312: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   315: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   318: aastore
    //   319: dup
    //   320: iconst_1
    //   321: aload 7
    //   323: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   326: aastore
    //   327: dup
    //   328: iconst_2
    //   329: aload_0
    //   330: aastore
    //   331: dup
    //   332: iconst_3
    //   333: iload_1
    //   334: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   337: aastore
    //   338: dup
    //   339: iconst_4
    //   340: iload_3
    //   341: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   344: aastore
    //   345: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   348: aload 6
    //   350: areturn
    //   351: astore 6
    //   353: aconst_null
    //   354: astore 7
    //   356: aload 7
    //   358: ifnull +8 -> 366
    //   361: aload 7
    //   363: invokevirtual 233	java/io/RandomAccessFile:close	()V
    //   366: aload 6
    //   368: athrow
    //   369: astore 7
    //   371: ldc 26
    //   373: aload 7
    //   375: ldc 28
    //   377: iconst_0
    //   378: anewarray 4	java/lang/Object
    //   381: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: ldc 26
    //   386: ldc 235
    //   388: iconst_5
    //   389: anewarray 4	java/lang/Object
    //   392: dup
    //   393: iconst_0
    //   394: aload 7
    //   396: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   399: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   402: aastore
    //   403: dup
    //   404: iconst_1
    //   405: aload 7
    //   407: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   410: aastore
    //   411: dup
    //   412: iconst_2
    //   413: aload_0
    //   414: aastore
    //   415: dup
    //   416: iconst_3
    //   417: iload_1
    //   418: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: aastore
    //   422: dup
    //   423: iconst_4
    //   424: iload_3
    //   425: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   428: aastore
    //   429: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   432: goto -66 -> 366
    //   435: astore 6
    //   437: goto -81 -> 356
    //   440: astore 9
    //   442: aconst_null
    //   443: astore 6
    //   445: goto -246 -> 199
    //   448: astore 9
    //   450: goto -251 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	453	0	paramString	String
    //   0	453	1	paramInt1	int
    //   0	453	2	paramInt2	int
    //   31	394	3	i	int
    //   93	9	4	l	long
    //   18	331	6	localObject1	Object
    //   351	16	6	localObject2	Object
    //   435	1	6	localObject3	Object
    //   443	1	6	localObject4	Object
    //   5	104	7	localObject5	Object
    //   125	37	7	localIOException1	IOException
    //   201	70	7	localObject6	Object
    //   285	37	7	localIOException2	IOException
    //   354	8	7	localObject7	Object
    //   369	37	7	localIOException3	IOException
    //   80	198	8	localRandomAccessFile	java.io.RandomAccessFile
    //   191	51	9	localException1	Exception
    //   440	1	9	localException2	Exception
    //   448	1	9	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   117	122	125	java/io/IOException
    //   70	82	191	java/lang/Exception
    //   277	282	285	java/io/IOException
    //   70	82	351	finally
    //   361	366	369	java/io/IOException
    //   86	91	435	finally
    //   99	106	435	finally
    //   110	117	435	finally
    //   203	216	435	finally
    //   220	268	435	finally
    //   86	91	440	java/lang/Exception
    //   99	106	448	java/lang/Exception
    //   110	117	448	java/lang/Exception
  }
  
  public static void closeOutputStream(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.close();
      return;
    }
    catch (IOException localIOException)
    {
      y.printErrStackTrace("MicroMsg.FileOperation", localIOException, "", new Object[0]);
      y.w("MicroMsg.FileOperation", "file op closeOutputStream e type:%s, e msg:%s, stream:%s", new Object[] { localIOException.getClass().getSimpleName(), localIOException.getMessage(), paramOutputStream });
    }
  }
  
  public static void d(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      File localFile = new File(str);
      if ((!localFile.exists()) && ((!localFile.mkdirs()) || (!localFile.isDirectory()))) {
        y.e("MicroMsg.FileOperation", "batchMkDirs mkdir error. %s", new Object[] { str });
      }
      i += 1;
    }
  }
  
  /* Error */
  public static final boolean d(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iload 4
    //   5: istore_3
    //   6: aload_0
    //   7: invokevirtual 74	java/io/File:exists	()Z
    //   10: ifeq +83 -> 93
    //   13: aload_0
    //   14: invokevirtual 154	java/io/File:isDirectory	()Z
    //   17: ifeq +78 -> 95
    //   20: aload_1
    //   21: invokevirtual 74	java/io/File:exists	()Z
    //   24: ifne +8 -> 32
    //   27: aload_1
    //   28: invokevirtual 171	java/io/File:mkdir	()Z
    //   31: pop
    //   32: aload_0
    //   33: invokevirtual 250	java/io/File:listFiles	()[Ljava/io/File;
    //   36: astore 5
    //   38: iconst_0
    //   39: istore_2
    //   40: iconst_0
    //   41: istore_3
    //   42: iload_2
    //   43: aload 5
    //   45: arraylength
    //   46: if_icmpge +47 -> 93
    //   49: aload 5
    //   51: iload_2
    //   52: aaload
    //   53: astore 6
    //   55: aload 6
    //   57: new 67	java/io/File
    //   60: dup
    //   61: aload_1
    //   62: invokevirtual 253	java/io/File:getPath	()Ljava/lang/String;
    //   65: aload 6
    //   67: invokevirtual 137	java/io/File:getName	()Ljava/lang/String;
    //   70: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: invokestatic 256	com/tencent/mm/a/e:d	(Ljava/io/File;Ljava/io/File;)Z
    //   76: istore_3
    //   77: iload_3
    //   78: ifeq +8 -> 86
    //   81: aload_0
    //   82: invokevirtual 259	java/io/File:delete	()Z
    //   85: pop
    //   86: iload_2
    //   87: iconst_1
    //   88: iadd
    //   89: istore_2
    //   90: goto -48 -> 42
    //   93: iload_3
    //   94: ireturn
    //   95: new 261	java/io/FileInputStream
    //   98: dup
    //   99: aload_0
    //   100: invokespecial 264	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   103: astore 6
    //   105: new 12	java/io/FileOutputStream
    //   108: dup
    //   109: aload_1
    //   110: invokespecial 265	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   113: astore 5
    //   115: aload 5
    //   117: astore 8
    //   119: aload 6
    //   121: astore 7
    //   123: ldc_w 266
    //   126: newarray byte
    //   128: astore 9
    //   130: aload 5
    //   132: astore 8
    //   134: aload 6
    //   136: astore 7
    //   138: aload 6
    //   140: aload 9
    //   142: invokevirtual 212	java/io/InputStream:read	([B)I
    //   145: istore_2
    //   146: iload_2
    //   147: iconst_m1
    //   148: if_icmpeq +174 -> 322
    //   151: aload 5
    //   153: astore 8
    //   155: aload 6
    //   157: astore 7
    //   159: aload 5
    //   161: aload 9
    //   163: iconst_0
    //   164: iload_2
    //   165: invokevirtual 215	java/io/OutputStream:write	([BII)V
    //   168: goto -38 -> 130
    //   171: astore 9
    //   173: aload 5
    //   175: astore 8
    //   177: aload 6
    //   179: astore 7
    //   181: ldc 26
    //   183: aload 9
    //   185: ldc 28
    //   187: iconst_0
    //   188: anewarray 4	java/lang/Object
    //   191: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: aload 5
    //   196: astore 8
    //   198: aload 6
    //   200: astore 7
    //   202: ldc 26
    //   204: ldc_w 268
    //   207: iconst_4
    //   208: anewarray 4	java/lang/Object
    //   211: dup
    //   212: iconst_0
    //   213: aload 9
    //   215: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   218: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   221: aastore
    //   222: dup
    //   223: iconst_1
    //   224: aload 9
    //   226: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   229: aastore
    //   230: dup
    //   231: iconst_2
    //   232: aload_0
    //   233: aastore
    //   234: dup
    //   235: iconst_3
    //   236: aload_1
    //   237: aastore
    //   238: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   241: aload 6
    //   243: ifnull +8 -> 251
    //   246: aload 6
    //   248: invokevirtual 269	java/io/InputStream:close	()V
    //   251: iload 4
    //   253: istore_3
    //   254: aload 5
    //   256: ifnull -163 -> 93
    //   259: aload 5
    //   261: invokevirtual 239	java/io/OutputStream:close	()V
    //   264: iconst_0
    //   265: ireturn
    //   266: astore 5
    //   268: ldc 26
    //   270: aload 5
    //   272: ldc 28
    //   274: iconst_0
    //   275: anewarray 4	java/lang/Object
    //   278: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   281: ldc 26
    //   283: ldc_w 271
    //   286: iconst_4
    //   287: anewarray 4	java/lang/Object
    //   290: dup
    //   291: iconst_0
    //   292: aload 5
    //   294: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   297: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   300: aastore
    //   301: dup
    //   302: iconst_1
    //   303: aload 5
    //   305: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   308: aastore
    //   309: dup
    //   310: iconst_2
    //   311: aload_0
    //   312: aastore
    //   313: dup
    //   314: iconst_3
    //   315: aload_1
    //   316: aastore
    //   317: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   320: iconst_0
    //   321: ireturn
    //   322: aload 5
    //   324: astore 8
    //   326: aload 6
    //   328: astore 7
    //   330: aload 5
    //   332: invokevirtual 272	java/io/OutputStream:flush	()V
    //   335: aload 5
    //   337: astore 8
    //   339: aload 6
    //   341: astore 7
    //   343: aload_0
    //   344: invokevirtual 259	java/io/File:delete	()Z
    //   347: pop
    //   348: aload 6
    //   350: invokevirtual 269	java/io/InputStream:close	()V
    //   353: aload 5
    //   355: invokevirtual 239	java/io/OutputStream:close	()V
    //   358: iconst_1
    //   359: ireturn
    //   360: astore 6
    //   362: ldc 26
    //   364: aload 6
    //   366: ldc 28
    //   368: iconst_0
    //   369: anewarray 4	java/lang/Object
    //   372: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   375: ldc 26
    //   377: ldc_w 274
    //   380: iconst_4
    //   381: anewarray 4	java/lang/Object
    //   384: dup
    //   385: iconst_0
    //   386: aload 6
    //   388: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   391: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   394: aastore
    //   395: dup
    //   396: iconst_1
    //   397: aload 6
    //   399: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   402: aastore
    //   403: dup
    //   404: iconst_2
    //   405: aload_0
    //   406: aastore
    //   407: dup
    //   408: iconst_3
    //   409: aload_1
    //   410: aastore
    //   411: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   414: goto -61 -> 353
    //   417: astore 5
    //   419: ldc 26
    //   421: aload 5
    //   423: ldc 28
    //   425: iconst_0
    //   426: anewarray 4	java/lang/Object
    //   429: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   432: ldc 26
    //   434: ldc_w 271
    //   437: iconst_4
    //   438: anewarray 4	java/lang/Object
    //   441: dup
    //   442: iconst_0
    //   443: aload 5
    //   445: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   448: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   451: aastore
    //   452: dup
    //   453: iconst_1
    //   454: aload 5
    //   456: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   459: aastore
    //   460: dup
    //   461: iconst_2
    //   462: aload_0
    //   463: aastore
    //   464: dup
    //   465: iconst_3
    //   466: aload_1
    //   467: aastore
    //   468: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   471: goto -113 -> 358
    //   474: astore 6
    //   476: ldc 26
    //   478: aload 6
    //   480: ldc 28
    //   482: iconst_0
    //   483: anewarray 4	java/lang/Object
    //   486: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   489: ldc 26
    //   491: ldc_w 274
    //   494: iconst_4
    //   495: anewarray 4	java/lang/Object
    //   498: dup
    //   499: iconst_0
    //   500: aload 6
    //   502: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   505: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   508: aastore
    //   509: dup
    //   510: iconst_1
    //   511: aload 6
    //   513: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   516: aastore
    //   517: dup
    //   518: iconst_2
    //   519: aload_0
    //   520: aastore
    //   521: dup
    //   522: iconst_3
    //   523: aload_1
    //   524: aastore
    //   525: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   528: goto -277 -> 251
    //   531: astore 5
    //   533: aconst_null
    //   534: astore 8
    //   536: aconst_null
    //   537: astore 6
    //   539: aload 6
    //   541: ifnull +8 -> 549
    //   544: aload 6
    //   546: invokevirtual 269	java/io/InputStream:close	()V
    //   549: aload 8
    //   551: ifnull +8 -> 559
    //   554: aload 8
    //   556: invokevirtual 239	java/io/OutputStream:close	()V
    //   559: aload 5
    //   561: athrow
    //   562: astore 6
    //   564: ldc 26
    //   566: aload 6
    //   568: ldc 28
    //   570: iconst_0
    //   571: anewarray 4	java/lang/Object
    //   574: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   577: ldc 26
    //   579: ldc_w 274
    //   582: iconst_4
    //   583: anewarray 4	java/lang/Object
    //   586: dup
    //   587: iconst_0
    //   588: aload 6
    //   590: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   593: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   596: aastore
    //   597: dup
    //   598: iconst_1
    //   599: aload 6
    //   601: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   604: aastore
    //   605: dup
    //   606: iconst_2
    //   607: aload_0
    //   608: aastore
    //   609: dup
    //   610: iconst_3
    //   611: aload_1
    //   612: aastore
    //   613: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   616: goto -67 -> 549
    //   619: astore 6
    //   621: ldc 26
    //   623: aload 6
    //   625: ldc 28
    //   627: iconst_0
    //   628: anewarray 4	java/lang/Object
    //   631: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   634: ldc 26
    //   636: ldc_w 271
    //   639: iconst_4
    //   640: anewarray 4	java/lang/Object
    //   643: dup
    //   644: iconst_0
    //   645: aload 6
    //   647: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   650: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   653: aastore
    //   654: dup
    //   655: iconst_1
    //   656: aload 6
    //   658: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   661: aastore
    //   662: dup
    //   663: iconst_2
    //   664: aload_0
    //   665: aastore
    //   666: dup
    //   667: iconst_3
    //   668: aload_1
    //   669: aastore
    //   670: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   673: goto -114 -> 559
    //   676: astore 5
    //   678: aconst_null
    //   679: astore 8
    //   681: goto -142 -> 539
    //   684: astore 5
    //   686: aload 7
    //   688: astore 6
    //   690: goto -151 -> 539
    //   693: astore 9
    //   695: aconst_null
    //   696: astore 5
    //   698: aconst_null
    //   699: astore 6
    //   701: goto -528 -> 173
    //   704: astore 9
    //   706: aconst_null
    //   707: astore 5
    //   709: goto -536 -> 173
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	712	0	paramFile1	File
    //   0	712	1	paramFile2	File
    //   39	126	2	i	int
    //   5	249	3	bool1	boolean
    //   1	251	4	bool2	boolean
    //   36	224	5	localObject1	Object
    //   266	88	5	localIOException1	IOException
    //   417	38	5	localIOException2	IOException
    //   531	29	5	localObject2	Object
    //   676	1	5	localObject3	Object
    //   684	1	5	localObject4	Object
    //   696	12	5	localObject5	Object
    //   53	296	6	localObject6	Object
    //   360	38	6	localIOException3	IOException
    //   474	38	6	localIOException4	IOException
    //   537	8	6	localObject7	Object
    //   562	38	6	localIOException5	IOException
    //   619	38	6	localIOException6	IOException
    //   688	12	6	localObject8	Object
    //   121	566	7	localObject9	Object
    //   117	563	8	localObject10	Object
    //   128	34	9	arrayOfByte	byte[]
    //   171	54	9	localException1	Exception
    //   693	1	9	localException2	Exception
    //   704	1	9	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   123	130	171	java/lang/Exception
    //   138	146	171	java/lang/Exception
    //   159	168	171	java/lang/Exception
    //   330	335	171	java/lang/Exception
    //   343	348	171	java/lang/Exception
    //   259	264	266	java/io/IOException
    //   348	353	360	java/io/IOException
    //   353	358	417	java/io/IOException
    //   246	251	474	java/io/IOException
    //   95	105	531	finally
    //   544	549	562	java/io/IOException
    //   554	559	619	java/io/IOException
    //   105	115	676	finally
    //   123	130	684	finally
    //   138	146	684	finally
    //   159	168	684	finally
    //   181	194	684	finally
    //   202	241	684	finally
    //   330	335	684	finally
    //   343	348	684	finally
    //   95	105	693	java/lang/Exception
    //   105	115	704	java/lang/Exception
  }
  
  /* Error */
  public static byte[] d(String paramString, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 67	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 70	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 6
    //   16: aload 6
    //   18: invokevirtual 74	java/io/File:exists	()Z
    //   21: ifne +5 -> 26
    //   24: aconst_null
    //   25: areturn
    //   26: iload_2
    //   27: iconst_m1
    //   28: if_icmpne +431 -> 459
    //   31: aload 6
    //   33: invokevirtual 120	java/io/File:length	()J
    //   36: l2i
    //   37: istore_2
    //   38: iload_1
    //   39: ifge +5 -> 44
    //   42: aconst_null
    //   43: areturn
    //   44: iload_2
    //   45: ifgt +5 -> 50
    //   48: aconst_null
    //   49: areturn
    //   50: iload_2
    //   51: istore_3
    //   52: iload_1
    //   53: iload_2
    //   54: iadd
    //   55: aload 6
    //   57: invokevirtual 120	java/io/File:length	()J
    //   60: l2i
    //   61: if_icmple +12 -> 73
    //   64: aload 6
    //   66: invokevirtual 120	java/io/File:length	()J
    //   69: l2i
    //   70: iload_1
    //   71: isub
    //   72: istore_3
    //   73: new 220	java/io/RandomAccessFile
    //   76: dup
    //   77: aload_0
    //   78: ldc 222
    //   80: invokespecial 225	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: astore 9
    //   85: aload 9
    //   87: astore 7
    //   89: iload_3
    //   90: newarray byte
    //   92: astore 6
    //   94: iload_1
    //   95: i2l
    //   96: lstore 4
    //   98: aload 9
    //   100: astore 7
    //   102: aload 9
    //   104: lload 4
    //   106: invokevirtual 229	java/io/RandomAccessFile:seek	(J)V
    //   109: aload 9
    //   111: astore 7
    //   113: aload 9
    //   115: aload 6
    //   117: invokevirtual 232	java/io/RandomAccessFile:readFully	([B)V
    //   120: aload 9
    //   122: invokevirtual 233	java/io/RandomAccessFile:close	()V
    //   125: aload 6
    //   127: areturn
    //   128: astore 7
    //   130: ldc 26
    //   132: aload 7
    //   134: ldc 28
    //   136: iconst_0
    //   137: anewarray 4	java/lang/Object
    //   140: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: ldc 26
    //   145: ldc_w 276
    //   148: iconst_5
    //   149: anewarray 4	java/lang/Object
    //   152: dup
    //   153: iconst_0
    //   154: aload 7
    //   156: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   159: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   162: aastore
    //   163: dup
    //   164: iconst_1
    //   165: aload 7
    //   167: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   170: aastore
    //   171: dup
    //   172: iconst_2
    //   173: aload_0
    //   174: aastore
    //   175: dup
    //   176: iconst_3
    //   177: iload_1
    //   178: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: aastore
    //   182: dup
    //   183: iconst_4
    //   184: iload_3
    //   185: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: aastore
    //   189: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   192: aload 6
    //   194: areturn
    //   195: astore 8
    //   197: aconst_null
    //   198: astore 9
    //   200: aconst_null
    //   201: astore 6
    //   203: aload 9
    //   205: astore 7
    //   207: ldc 26
    //   209: aload 8
    //   211: ldc 28
    //   213: iconst_0
    //   214: anewarray 4	java/lang/Object
    //   217: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   220: aload 9
    //   222: astore 7
    //   224: ldc 26
    //   226: ldc_w 278
    //   229: iconst_5
    //   230: anewarray 4	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: aload 8
    //   237: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   240: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   243: aastore
    //   244: dup
    //   245: iconst_1
    //   246: aload 8
    //   248: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   251: aastore
    //   252: dup
    //   253: iconst_2
    //   254: aload_0
    //   255: aastore
    //   256: dup
    //   257: iconst_3
    //   258: iload_1
    //   259: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   262: aastore
    //   263: dup
    //   264: iconst_4
    //   265: iload_3
    //   266: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   269: aastore
    //   270: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   273: aload 9
    //   275: ifnull +181 -> 456
    //   278: aload 9
    //   280: invokevirtual 233	java/io/RandomAccessFile:close	()V
    //   283: aload 6
    //   285: areturn
    //   286: astore 7
    //   288: ldc 26
    //   290: aload 7
    //   292: ldc 28
    //   294: iconst_0
    //   295: anewarray 4	java/lang/Object
    //   298: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   301: ldc 26
    //   303: ldc_w 276
    //   306: iconst_5
    //   307: anewarray 4	java/lang/Object
    //   310: dup
    //   311: iconst_0
    //   312: aload 7
    //   314: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   317: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   320: aastore
    //   321: dup
    //   322: iconst_1
    //   323: aload 7
    //   325: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   328: aastore
    //   329: dup
    //   330: iconst_2
    //   331: aload_0
    //   332: aastore
    //   333: dup
    //   334: iconst_3
    //   335: iload_1
    //   336: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   339: aastore
    //   340: dup
    //   341: iconst_4
    //   342: iload_3
    //   343: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   346: aastore
    //   347: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   350: aload 6
    //   352: areturn
    //   353: astore 6
    //   355: aconst_null
    //   356: astore 7
    //   358: aload 7
    //   360: ifnull +8 -> 368
    //   363: aload 7
    //   365: invokevirtual 233	java/io/RandomAccessFile:close	()V
    //   368: aload 6
    //   370: athrow
    //   371: astore 7
    //   373: ldc 26
    //   375: aload 7
    //   377: ldc 28
    //   379: iconst_0
    //   380: anewarray 4	java/lang/Object
    //   383: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   386: ldc 26
    //   388: ldc_w 276
    //   391: iconst_5
    //   392: anewarray 4	java/lang/Object
    //   395: dup
    //   396: iconst_0
    //   397: aload 7
    //   399: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   402: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   405: aastore
    //   406: dup
    //   407: iconst_1
    //   408: aload 7
    //   410: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   413: aastore
    //   414: dup
    //   415: iconst_2
    //   416: aload_0
    //   417: aastore
    //   418: dup
    //   419: iconst_3
    //   420: iload_1
    //   421: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   424: aastore
    //   425: dup
    //   426: iconst_4
    //   427: iload_3
    //   428: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   431: aastore
    //   432: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   435: goto -67 -> 368
    //   438: astore 6
    //   440: goto -82 -> 358
    //   443: astore 8
    //   445: aconst_null
    //   446: astore 6
    //   448: goto -245 -> 203
    //   451: astore 8
    //   453: goto -250 -> 203
    //   456: aload 6
    //   458: areturn
    //   459: goto -421 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	462	0	paramString	String
    //   0	462	1	paramInt1	int
    //   0	462	2	paramInt2	int
    //   51	377	3	i	int
    //   96	9	4	l	long
    //   14	337	6	localObject1	Object
    //   353	16	6	localObject2	Object
    //   438	1	6	localObject3	Object
    //   446	11	6	arrayOfByte	byte[]
    //   87	25	7	localRandomAccessFile1	java.io.RandomAccessFile
    //   128	38	7	localIOException1	IOException
    //   205	18	7	localRandomAccessFile2	java.io.RandomAccessFile
    //   286	38	7	localIOException2	IOException
    //   356	8	7	localObject4	Object
    //   371	38	7	localIOException3	IOException
    //   195	52	8	localException1	Exception
    //   443	1	8	localException2	Exception
    //   451	1	8	localException3	Exception
    //   83	196	9	localRandomAccessFile3	java.io.RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   120	125	128	java/io/IOException
    //   73	85	195	java/lang/Exception
    //   278	283	286	java/io/IOException
    //   73	85	353	finally
    //   363	368	371	java/io/IOException
    //   89	94	438	finally
    //   102	109	438	finally
    //   113	120	438	finally
    //   207	220	438	finally
    //   224	273	438	finally
    //   89	94	443	java/lang/Exception
    //   102	109	451	java/lang/Exception
    //   113	120	451	java/lang/Exception
  }
  
  public static boolean deleteFile(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return true;
      paramString = new File(paramString);
    } while (!paramString.exists());
    return paramString.delete();
  }
  
  /* Error */
  public static int e(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +8 -> 9
    //   4: aload_1
    //   5: arraylength
    //   6: ifne +6 -> 12
    //   9: bipush 254
    //   11: ireturn
    //   12: new 12	java/io/FileOutputStream
    //   15: dup
    //   16: aload_0
    //   17: iconst_1
    //   18: invokespecial 16	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   21: astore_3
    //   22: aload_3
    //   23: astore_2
    //   24: aload_3
    //   25: aload_1
    //   26: iconst_0
    //   27: aload_1
    //   28: arraylength
    //   29: invokevirtual 20	java/io/FileOutputStream:write	([BII)V
    //   32: aload_3
    //   33: invokevirtual 24	java/io/FileOutputStream:close	()V
    //   36: iconst_0
    //   37: ireturn
    //   38: astore_2
    //   39: ldc 26
    //   41: aload_2
    //   42: ldc 28
    //   44: iconst_0
    //   45: anewarray 4	java/lang/Object
    //   48: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: ldc 26
    //   53: ldc_w 282
    //   56: iconst_4
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload_2
    //   63: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   66: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   69: aastore
    //   70: dup
    //   71: iconst_1
    //   72: aload_2
    //   73: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   76: aastore
    //   77: dup
    //   78: iconst_2
    //   79: aload_0
    //   80: aastore
    //   81: dup
    //   82: iconst_3
    //   83: aload_1
    //   84: arraylength
    //   85: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore 4
    //   96: aconst_null
    //   97: astore_3
    //   98: aload_3
    //   99: astore_2
    //   100: ldc 26
    //   102: aload 4
    //   104: ldc 28
    //   106: iconst_0
    //   107: anewarray 4	java/lang/Object
    //   110: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   113: aload_3
    //   114: astore_2
    //   115: ldc 26
    //   117: ldc_w 284
    //   120: iconst_4
    //   121: anewarray 4	java/lang/Object
    //   124: dup
    //   125: iconst_0
    //   126: aload 4
    //   128: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   131: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   134: aastore
    //   135: dup
    //   136: iconst_1
    //   137: aload 4
    //   139: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   142: aastore
    //   143: dup
    //   144: iconst_2
    //   145: aload_0
    //   146: aastore
    //   147: dup
    //   148: iconst_3
    //   149: aload_1
    //   150: arraylength
    //   151: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   154: aastore
    //   155: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   158: aload_3
    //   159: ifnull +7 -> 166
    //   162: aload_3
    //   163: invokevirtual 24	java/io/FileOutputStream:close	()V
    //   166: iconst_m1
    //   167: ireturn
    //   168: astore_2
    //   169: ldc 26
    //   171: aload_2
    //   172: ldc 28
    //   174: iconst_0
    //   175: anewarray 4	java/lang/Object
    //   178: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   181: ldc 26
    //   183: ldc_w 282
    //   186: iconst_4
    //   187: anewarray 4	java/lang/Object
    //   190: dup
    //   191: iconst_0
    //   192: aload_2
    //   193: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   196: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   199: aastore
    //   200: dup
    //   201: iconst_1
    //   202: aload_2
    //   203: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   206: aastore
    //   207: dup
    //   208: iconst_2
    //   209: aload_0
    //   210: aastore
    //   211: dup
    //   212: iconst_3
    //   213: aload_1
    //   214: arraylength
    //   215: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   218: aastore
    //   219: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   222: goto -56 -> 166
    //   225: astore_3
    //   226: aconst_null
    //   227: astore_2
    //   228: aload_2
    //   229: ifnull +7 -> 236
    //   232: aload_2
    //   233: invokevirtual 24	java/io/FileOutputStream:close	()V
    //   236: aload_3
    //   237: athrow
    //   238: astore_2
    //   239: ldc 26
    //   241: aload_2
    //   242: ldc 28
    //   244: iconst_0
    //   245: anewarray 4	java/lang/Object
    //   248: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   251: ldc 26
    //   253: ldc_w 282
    //   256: iconst_4
    //   257: anewarray 4	java/lang/Object
    //   260: dup
    //   261: iconst_0
    //   262: aload_2
    //   263: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   266: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   269: aastore
    //   270: dup
    //   271: iconst_1
    //   272: aload_2
    //   273: invokevirtual 49	java/io/IOException:getMessage	()Ljava/lang/String;
    //   276: aastore
    //   277: dup
    //   278: iconst_2
    //   279: aload_0
    //   280: aastore
    //   281: dup
    //   282: iconst_3
    //   283: aload_1
    //   284: arraylength
    //   285: invokestatic 55	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   288: aastore
    //   289: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   292: goto -56 -> 236
    //   295: astore_3
    //   296: goto -68 -> 228
    //   299: astore 4
    //   301: goto -203 -> 98
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramString	String
    //   0	304	1	paramArrayOfByte	byte[]
    //   23	1	2	localFileOutputStream1	java.io.FileOutputStream
    //   38	35	2	localIOException1	IOException
    //   99	16	2	localFileOutputStream2	java.io.FileOutputStream
    //   168	35	2	localIOException2	IOException
    //   227	6	2	localObject1	Object
    //   238	35	2	localIOException3	IOException
    //   21	142	3	localFileOutputStream3	java.io.FileOutputStream
    //   225	12	3	localObject2	Object
    //   295	1	3	localObject3	Object
    //   94	44	4	localException1	Exception
    //   299	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   32	36	38	java/io/IOException
    //   12	22	94	java/lang/Exception
    //   162	166	168	java/io/IOException
    //   12	22	225	finally
    //   232	236	238	java/io/IOException
    //   24	32	295	finally
    //   100	113	295	finally
    //   115	158	295	finally
    //   24	32	299	java/lang/Exception
  }
  
  public static final boolean f(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {}
    do
    {
      return false;
      paramString2 = new File(paramString1 + paramString2);
      paramString1 = new File(paramString1 + paramString3);
    } while (!paramString2.exists());
    return paramString2.renameTo(paramString1);
  }
  
  public static void j(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.FileOperation", localException, "", new Object[0]);
      y.w("MicroMsg.FileOperation", "file op closeInputStream e type:%s, e msg:%s, stream:%s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage(), paramInputStream });
    }
  }
  
  public static final boolean k(File paramFile)
  {
    int i = 0;
    if ((paramFile == null) || (!paramFile.exists())) {
      return false;
    }
    if (paramFile.isFile()) {
      paramFile.delete();
    }
    for (;;)
    {
      paramFile.delete();
      return true;
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null) {
          while (i < arrayOfFile.length)
          {
            k(arrayOfFile[i]);
            i += 1;
          }
        }
      }
    }
  }
  
  public static byte[] k(InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return null;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte[1024];
    int i = 0;
    for (;;)
    {
      try
      {
        int j = paramInputStream.read(arrayOfByte, 0, 1024);
        i = j;
      }
      catch (IOException localIOException)
      {
        continue;
      }
      if (i <= 0) {
        continue;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static final boolean l(File paramFile)
  {
    int i = 0;
    if ((paramFile == null) || (!paramFile.exists())) {}
    do
    {
      do
      {
        return false;
      } while (!paramFile.isDirectory());
      paramFile = paramFile.listFiles();
    } while (paramFile == null);
    while (i < paramFile.length)
    {
      paramFile[i].delete();
      i += 1;
    }
    return true;
  }
  
  /* Error */
  public static long r(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 261	java/io/FileInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 305	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 309	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   11: astore 4
    //   13: new 12	java/io/FileOutputStream
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 310	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   21: invokevirtual 311	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   24: astore 5
    //   26: aload 5
    //   28: aload 4
    //   30: lconst_0
    //   31: aload 4
    //   33: invokevirtual 316	java/nio/channels/FileChannel:size	()J
    //   36: invokevirtual 320	java/nio/channels/FileChannel:transferFrom	(Ljava/nio/channels/ReadableByteChannel;JJ)J
    //   39: pop2
    //   40: aload 4
    //   42: invokevirtual 316	java/nio/channels/FileChannel:size	()J
    //   45: lstore_2
    //   46: aload 4
    //   48: ifnull +8 -> 56
    //   51: aload 4
    //   53: invokevirtual 321	java/nio/channels/FileChannel:close	()V
    //   56: aload 5
    //   58: ifnull +8 -> 66
    //   61: aload 5
    //   63: invokevirtual 321	java/nio/channels/FileChannel:close	()V
    //   66: lload_2
    //   67: lreturn
    //   68: astore 6
    //   70: aconst_null
    //   71: astore 4
    //   73: aconst_null
    //   74: astore 5
    //   76: ldc 26
    //   78: aload 6
    //   80: ldc 28
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokestatic 34	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   89: ldc 26
    //   91: ldc_w 323
    //   94: iconst_4
    //   95: anewarray 4	java/lang/Object
    //   98: dup
    //   99: iconst_0
    //   100: aload 6
    //   102: invokevirtual 40	java/lang/Object:getClass	()Ljava/lang/Class;
    //   105: invokevirtual 46	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: aload 6
    //   113: invokevirtual 62	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   116: aastore
    //   117: dup
    //   118: iconst_2
    //   119: aload_0
    //   120: aastore
    //   121: dup
    //   122: iconst_3
    //   123: aload_1
    //   124: aastore
    //   125: invokestatic 59	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload 5
    //   130: ifnull +8 -> 138
    //   133: aload 5
    //   135: invokevirtual 321	java/nio/channels/FileChannel:close	()V
    //   138: aload 4
    //   140: ifnull +8 -> 148
    //   143: aload 4
    //   145: invokevirtual 321	java/nio/channels/FileChannel:close	()V
    //   148: ldc2_w 324
    //   151: lreturn
    //   152: astore_0
    //   153: aconst_null
    //   154: astore 4
    //   156: aconst_null
    //   157: astore 5
    //   159: aload 5
    //   161: ifnull +8 -> 169
    //   164: aload 5
    //   166: invokevirtual 321	java/nio/channels/FileChannel:close	()V
    //   169: aload 4
    //   171: ifnull +8 -> 179
    //   174: aload 4
    //   176: invokevirtual 321	java/nio/channels/FileChannel:close	()V
    //   179: aload_0
    //   180: athrow
    //   181: astore_0
    //   182: goto -126 -> 56
    //   185: astore_0
    //   186: goto -120 -> 66
    //   189: astore_0
    //   190: goto -52 -> 138
    //   193: astore_0
    //   194: goto -46 -> 148
    //   197: astore_1
    //   198: goto -29 -> 169
    //   201: astore_1
    //   202: goto -23 -> 179
    //   205: astore_0
    //   206: aconst_null
    //   207: astore_1
    //   208: aload 4
    //   210: astore 5
    //   212: aload_1
    //   213: astore 4
    //   215: goto -56 -> 159
    //   218: astore_0
    //   219: aload 5
    //   221: astore_1
    //   222: aload 4
    //   224: astore 5
    //   226: aload_1
    //   227: astore 4
    //   229: goto -70 -> 159
    //   232: astore_0
    //   233: goto -74 -> 159
    //   236: astore 6
    //   238: aconst_null
    //   239: astore 7
    //   241: aload 4
    //   243: astore 5
    //   245: aload 7
    //   247: astore 4
    //   249: goto -173 -> 76
    //   252: astore 6
    //   254: aload 5
    //   256: astore 7
    //   258: aload 4
    //   260: astore 5
    //   262: aload 7
    //   264: astore 4
    //   266: goto -190 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	269	0	paramString1	String
    //   0	269	1	paramString2	String
    //   45	22	2	l	long
    //   11	254	4	localObject1	Object
    //   24	237	5	localObject2	Object
    //   68	44	6	localException1	Exception
    //   236	1	6	localException2	Exception
    //   252	1	6	localException3	Exception
    //   239	24	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	13	68	java/lang/Exception
    //   0	13	152	finally
    //   51	56	181	java/io/IOException
    //   61	66	185	java/io/IOException
    //   133	138	189	java/io/IOException
    //   143	148	193	java/io/IOException
    //   164	169	197	java/io/IOException
    //   174	179	201	java/io/IOException
    //   13	26	205	finally
    //   26	46	218	finally
    //   76	128	232	finally
    //   13	26	236	java/lang/Exception
    //   26	46	252	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.a.e
 * JD-Core Version:    0.7.0.1
 */