package com.tencent.mm.platformtools;

public final class ai$b
{
  private static char[] J(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k * 2];
    int i = 0;
    if (i < k)
    {
      int m = paramArrayOfByte[i];
      int j = m >> 4 & 0xF;
      if (j >= 10)
      {
        j = j + 97 - 10;
        label44:
        arrayOfChar[(i * 2)] = ((char)j);
        j = m & 0xF;
        if (j < 10) {
          break label97;
        }
        j = j + 97 - 10;
      }
      for (;;)
      {
        arrayOfChar[(i * 2 + 1)] = ((char)j);
        i += 1;
        break;
        j += 48;
        break label44;
        label97:
        j += 48;
      }
    }
    return arrayOfChar;
  }
  
  /* Error */
  public static java.lang.String r(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 18	java/util/jar/JarFile
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 22	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   8: astore 6
    //   10: sipush 8192
    //   13: newarray byte
    //   15: astore 9
    //   17: aload 6
    //   19: invokevirtual 26	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   22: astore 10
    //   24: aconst_null
    //   25: astore 5
    //   27: aconst_null
    //   28: astore_0
    //   29: aload_0
    //   30: astore 4
    //   32: aload_0
    //   33: astore_3
    //   34: aload 10
    //   36: invokeinterface 32 1 0
    //   41: ifeq +587 -> 628
    //   44: aload_0
    //   45: astore 4
    //   47: aload_0
    //   48: astore_3
    //   49: aload 10
    //   51: invokeinterface 36 1 0
    //   56: checkcast 38	java/util/jar/JarEntry
    //   59: astore 7
    //   61: aload_0
    //   62: astore 4
    //   64: aload_0
    //   65: astore_3
    //   66: aload 7
    //   68: invokevirtual 41	java/util/jar/JarEntry:isDirectory	()Z
    //   71: ifne -42 -> 29
    //   74: aload_0
    //   75: astore 4
    //   77: aload_0
    //   78: astore_3
    //   79: aload 7
    //   81: invokevirtual 45	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   84: ldc 47
    //   86: invokevirtual 53	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   89: ifne -60 -> 29
    //   92: aload_0
    //   93: astore 4
    //   95: aload_0
    //   96: astore_3
    //   97: aload 7
    //   99: invokevirtual 45	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   102: astore 8
    //   104: aload_0
    //   105: astore 4
    //   107: aload_0
    //   108: astore_3
    //   109: ldc 55
    //   111: aload 8
    //   113: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   116: ifne -87 -> 29
    //   119: aload_0
    //   120: astore 4
    //   122: aload_0
    //   123: astore_3
    //   124: ldc 61
    //   126: aload 8
    //   128: invokevirtual 59	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   131: ifne -102 -> 29
    //   134: aload_0
    //   135: astore 4
    //   137: aload_0
    //   138: astore_3
    //   139: aload 7
    //   141: invokevirtual 65	java/util/jar/JarEntry:getSize	()J
    //   144: ldc2_w 66
    //   147: lcmp
    //   148: ifgt -119 -> 29
    //   151: aload_0
    //   152: astore 4
    //   154: aload_0
    //   155: astore_3
    //   156: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   159: lstore_1
    //   160: aload_0
    //   161: astore 4
    //   163: aload_0
    //   164: astore_3
    //   165: ldc 74
    //   167: new 76	java/lang/StringBuilder
    //   170: dup
    //   171: ldc 78
    //   173: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   176: aload 8
    //   178: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 94	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   187: aload_0
    //   188: astore 4
    //   190: aload_0
    //   191: astore_3
    //   192: aload 6
    //   194: aload 7
    //   196: invokevirtual 98	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   199: astore_0
    //   200: aload_0
    //   201: astore 4
    //   203: aload_0
    //   204: astore_3
    //   205: ldc 74
    //   207: new 76	java/lang/StringBuilder
    //   210: dup
    //   211: ldc 100
    //   213: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   216: invokestatic 72	java/lang/System:currentTimeMillis	()J
    //   219: lload_1
    //   220: lsub
    //   221: invokevirtual 103	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   224: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 94	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   230: aload_0
    //   231: ifnull +31 -> 262
    //   234: aload_0
    //   235: astore 4
    //   237: aload_0
    //   238: astore_3
    //   239: aload_0
    //   240: aload 9
    //   242: iconst_0
    //   243: sipush 8192
    //   246: invokevirtual 109	java/io/InputStream:read	([BII)I
    //   249: iconst_m1
    //   250: if_icmpne -16 -> 234
    //   253: aload_0
    //   254: astore 4
    //   256: aload_0
    //   257: astore_3
    //   258: aload_0
    //   259: invokevirtual 113	java/io/InputStream:close	()V
    //   262: aload_0
    //   263: astore 4
    //   265: aload_0
    //   266: astore_3
    //   267: aload 7
    //   269: invokevirtual 117	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   272: astore 8
    //   274: aload 8
    //   276: ifnull +14 -> 290
    //   279: aload_0
    //   280: astore 4
    //   282: aload_0
    //   283: astore_3
    //   284: aload 8
    //   286: arraylength
    //   287: ifne +85 -> 372
    //   290: aload_0
    //   291: astore 4
    //   293: aload_0
    //   294: astore_3
    //   295: new 119	java/lang/SecurityException
    //   298: dup
    //   299: new 76	java/lang/StringBuilder
    //   302: dup
    //   303: ldc 121
    //   305: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   308: aload 7
    //   310: invokevirtual 45	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   313: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokespecial 122	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
    //   322: athrow
    //   323: astore_3
    //   324: aload 4
    //   326: astore_0
    //   327: aload 6
    //   329: astore 4
    //   331: ldc 124
    //   333: aload_3
    //   334: ldc 126
    //   336: iconst_0
    //   337: anewarray 4	java/lang/Object
    //   340: invokestatic 130	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   343: aload_3
    //   344: athrow
    //   345: astore 5
    //   347: aload_0
    //   348: astore_3
    //   349: aload 5
    //   351: astore_0
    //   352: aload_3
    //   353: ifnull +7 -> 360
    //   356: aload_3
    //   357: invokevirtual 113	java/io/InputStream:close	()V
    //   360: aload 4
    //   362: ifnull +8 -> 370
    //   365: aload 4
    //   367: invokevirtual 131	java/util/jar/JarFile:close	()V
    //   370: aload_0
    //   371: athrow
    //   372: aload 5
    //   374: ifnonnull +245 -> 619
    //   377: aload_0
    //   378: astore 4
    //   380: aload_0
    //   381: astore_3
    //   382: aload 8
    //   384: iconst_0
    //   385: aaload
    //   386: checkcast 133	java/security/cert/X509Certificate
    //   389: astore 8
    //   391: aload 8
    //   393: astore 7
    //   395: aload_0
    //   396: astore 5
    //   398: aload 8
    //   400: ifnonnull +9 -> 409
    //   403: aload 8
    //   405: astore_3
    //   406: goto +216 -> 622
    //   409: aload 7
    //   411: ifnull +80 -> 491
    //   414: aload 5
    //   416: astore 4
    //   418: aload 5
    //   420: astore_3
    //   421: new 49	java/lang/String
    //   424: dup
    //   425: aload 7
    //   427: invokevirtual 137	java/security/cert/X509Certificate:getEncoded	()[B
    //   430: invokestatic 139	com/tencent/mm/platformtools/ai$b:J	([B)[C
    //   433: invokespecial 142	java/lang/String:<init>	([C)V
    //   436: invokevirtual 145	java/lang/String:getBytes	()[B
    //   439: invokestatic 151	com/tencent/mm/sdk/platformtools/ad:n	([B)Ljava/lang/String;
    //   442: astore_0
    //   443: aload 5
    //   445: ifnull +8 -> 453
    //   448: aload 5
    //   450: invokevirtual 113	java/io/InputStream:close	()V
    //   453: aload 6
    //   455: invokevirtual 131	java/util/jar/JarFile:close	()V
    //   458: aload_0
    //   459: areturn
    //   460: astore_3
    //   461: ldc 124
    //   463: aload_3
    //   464: ldc 126
    //   466: iconst_0
    //   467: anewarray 4	java/lang/Object
    //   470: invokestatic 130	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   473: goto -20 -> 453
    //   476: astore_3
    //   477: ldc 124
    //   479: aload_3
    //   480: ldc 126
    //   482: iconst_0
    //   483: anewarray 4	java/lang/Object
    //   486: invokestatic 130	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   489: aload_0
    //   490: areturn
    //   491: aload 5
    //   493: ifnull +8 -> 501
    //   496: aload 5
    //   498: invokevirtual 113	java/io/InputStream:close	()V
    //   501: aload 6
    //   503: invokevirtual 131	java/util/jar/JarFile:close	()V
    //   506: ldc 126
    //   508: areturn
    //   509: astore_0
    //   510: ldc 124
    //   512: aload_0
    //   513: ldc 126
    //   515: iconst_0
    //   516: anewarray 4	java/lang/Object
    //   519: invokestatic 130	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   522: ldc 126
    //   524: areturn
    //   525: astore_0
    //   526: ldc 124
    //   528: aload_0
    //   529: ldc 126
    //   531: iconst_0
    //   532: anewarray 4	java/lang/Object
    //   535: invokestatic 130	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   538: goto -37 -> 501
    //   541: astore_3
    //   542: ldc 124
    //   544: aload_3
    //   545: ldc 126
    //   547: iconst_0
    //   548: anewarray 4	java/lang/Object
    //   551: invokestatic 130	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   554: goto -194 -> 360
    //   557: astore_3
    //   558: ldc 124
    //   560: aload_3
    //   561: ldc 126
    //   563: iconst_0
    //   564: anewarray 4	java/lang/Object
    //   567: invokestatic 130	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   570: goto -200 -> 370
    //   573: astore_0
    //   574: aconst_null
    //   575: astore_3
    //   576: aconst_null
    //   577: astore 4
    //   579: goto -227 -> 352
    //   582: astore_0
    //   583: aconst_null
    //   584: astore_3
    //   585: aload 6
    //   587: astore 4
    //   589: goto -237 -> 352
    //   592: astore_0
    //   593: aload 6
    //   595: astore 4
    //   597: goto -245 -> 352
    //   600: astore_3
    //   601: aconst_null
    //   602: astore_0
    //   603: aconst_null
    //   604: astore 4
    //   606: goto -275 -> 331
    //   609: astore_3
    //   610: aconst_null
    //   611: astore_0
    //   612: aload 6
    //   614: astore 4
    //   616: goto -285 -> 331
    //   619: aload 5
    //   621: astore_3
    //   622: aload_3
    //   623: astore 5
    //   625: goto -596 -> 29
    //   628: aload 5
    //   630: astore 7
    //   632: aload_0
    //   633: astore 5
    //   635: goto -226 -> 409
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	paramFile	java.io.File
    //   159	61	1	l	long
    //   33	262	3	localFile	java.io.File
    //   323	21	3	localException1	java.lang.Exception
    //   348	73	3	localObject1	Object
    //   460	4	3	localIOException1	java.io.IOException
    //   476	4	3	localIOException2	java.io.IOException
    //   541	4	3	localIOException3	java.io.IOException
    //   557	4	3	localIOException4	java.io.IOException
    //   575	10	3	localObject2	Object
    //   600	1	3	localException2	java.lang.Exception
    //   609	1	3	localException3	java.lang.Exception
    //   621	2	3	localObject3	Object
    //   30	585	4	localObject4	Object
    //   25	1	5	localObject5	Object
    //   345	28	5	localObject6	Object
    //   396	238	5	localObject7	Object
    //   8	605	6	localJarFile	java.util.jar.JarFile
    //   59	572	7	localObject8	Object
    //   102	302	8	localObject9	Object
    //   15	226	9	arrayOfByte	byte[]
    //   22	28	10	localEnumeration	java.util.Enumeration
    // Exception table:
    //   from	to	target	type
    //   34	44	323	java/lang/Exception
    //   49	61	323	java/lang/Exception
    //   66	74	323	java/lang/Exception
    //   79	92	323	java/lang/Exception
    //   97	104	323	java/lang/Exception
    //   109	119	323	java/lang/Exception
    //   124	134	323	java/lang/Exception
    //   139	151	323	java/lang/Exception
    //   156	160	323	java/lang/Exception
    //   165	187	323	java/lang/Exception
    //   192	200	323	java/lang/Exception
    //   205	230	323	java/lang/Exception
    //   239	253	323	java/lang/Exception
    //   258	262	323	java/lang/Exception
    //   267	274	323	java/lang/Exception
    //   284	290	323	java/lang/Exception
    //   295	323	323	java/lang/Exception
    //   382	391	323	java/lang/Exception
    //   421	443	323	java/lang/Exception
    //   331	345	345	finally
    //   448	453	460	java/io/IOException
    //   453	458	476	java/io/IOException
    //   501	506	509	java/io/IOException
    //   496	501	525	java/io/IOException
    //   356	360	541	java/io/IOException
    //   365	370	557	java/io/IOException
    //   0	10	573	finally
    //   10	24	582	finally
    //   34	44	592	finally
    //   49	61	592	finally
    //   66	74	592	finally
    //   79	92	592	finally
    //   97	104	592	finally
    //   109	119	592	finally
    //   124	134	592	finally
    //   139	151	592	finally
    //   156	160	592	finally
    //   165	187	592	finally
    //   192	200	592	finally
    //   205	230	592	finally
    //   239	253	592	finally
    //   258	262	592	finally
    //   267	274	592	finally
    //   284	290	592	finally
    //   295	323	592	finally
    //   382	391	592	finally
    //   421	443	592	finally
    //   0	10	600	java/lang/Exception
    //   10	24	609	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.platformtools.ai.b
 * JD-Core Version:    0.7.0.1
 */