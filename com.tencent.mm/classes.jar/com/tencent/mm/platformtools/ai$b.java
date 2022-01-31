package com.tencent.mm.platformtools;

public final class ai$b
{
  private static char[] ad(byte[] paramArrayOfByte)
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
  public static java.lang.String x(java.io.File paramFile)
  {
    // Byte code:
    //   0: sipush 16710
    //   3: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 24	java/util/jar/JarFile
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 28	java/util/jar/JarFile:<init>	(Ljava/io/File;)V
    //   14: astore 6
    //   16: sipush 8192
    //   19: newarray byte
    //   21: astore 9
    //   23: aload 6
    //   25: invokevirtual 32	java/util/jar/JarFile:entries	()Ljava/util/Enumeration;
    //   28: astore 10
    //   30: aconst_null
    //   31: astore 5
    //   33: aconst_null
    //   34: astore_0
    //   35: aload_0
    //   36: astore 4
    //   38: aload_0
    //   39: astore_3
    //   40: aload 10
    //   42: invokeinterface 38 1 0
    //   47: ifeq +625 -> 672
    //   50: aload_0
    //   51: astore 4
    //   53: aload_0
    //   54: astore_3
    //   55: aload 10
    //   57: invokeinterface 42 1 0
    //   62: checkcast 44	java/util/jar/JarEntry
    //   65: astore 7
    //   67: aload_0
    //   68: astore 4
    //   70: aload_0
    //   71: astore_3
    //   72: aload 7
    //   74: invokevirtual 47	java/util/jar/JarEntry:isDirectory	()Z
    //   77: ifne -42 -> 35
    //   80: aload_0
    //   81: astore 4
    //   83: aload_0
    //   84: astore_3
    //   85: aload 7
    //   87: invokevirtual 51	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   90: ldc 53
    //   92: invokevirtual 59	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   95: ifne -60 -> 35
    //   98: aload_0
    //   99: astore 4
    //   101: aload_0
    //   102: astore_3
    //   103: aload 7
    //   105: invokevirtual 51	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   108: astore 8
    //   110: aload_0
    //   111: astore 4
    //   113: aload_0
    //   114: astore_3
    //   115: ldc 61
    //   117: aload 8
    //   119: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifne -87 -> 35
    //   125: aload_0
    //   126: astore 4
    //   128: aload_0
    //   129: astore_3
    //   130: ldc 67
    //   132: aload 8
    //   134: invokevirtual 65	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   137: ifne -102 -> 35
    //   140: aload_0
    //   141: astore 4
    //   143: aload_0
    //   144: astore_3
    //   145: aload 7
    //   147: invokevirtual 71	java/util/jar/JarEntry:getSize	()J
    //   150: ldc2_w 72
    //   153: lcmp
    //   154: ifgt -119 -> 35
    //   157: aload_0
    //   158: astore 4
    //   160: aload_0
    //   161: astore_3
    //   162: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   165: lstore_1
    //   166: aload_0
    //   167: astore 4
    //   169: aload_0
    //   170: astore_3
    //   171: ldc 80
    //   173: ldc 82
    //   175: aload 8
    //   177: invokestatic 86	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   180: invokevirtual 90	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   183: invokestatic 96	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_0
    //   187: astore 4
    //   189: aload_0
    //   190: astore_3
    //   191: aload 6
    //   193: aload 7
    //   195: invokevirtual 100	java/util/jar/JarFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   198: astore_0
    //   199: aload_0
    //   200: astore 4
    //   202: aload_0
    //   203: astore_3
    //   204: ldc 80
    //   206: new 102	java/lang/StringBuilder
    //   209: dup
    //   210: ldc 104
    //   212: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   215: invokestatic 78	java/lang/System:currentTimeMillis	()J
    //   218: lload_1
    //   219: lsub
    //   220: invokevirtual 111	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   223: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 96	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   229: aload_0
    //   230: ifnull +31 -> 261
    //   233: aload_0
    //   234: astore 4
    //   236: aload_0
    //   237: astore_3
    //   238: aload_0
    //   239: aload 9
    //   241: iconst_0
    //   242: sipush 8192
    //   245: invokevirtual 120	java/io/InputStream:read	([BII)I
    //   248: iconst_m1
    //   249: if_icmpne -16 -> 233
    //   252: aload_0
    //   253: astore 4
    //   255: aload_0
    //   256: astore_3
    //   257: aload_0
    //   258: invokevirtual 124	java/io/InputStream:close	()V
    //   261: aload_0
    //   262: astore 4
    //   264: aload_0
    //   265: astore_3
    //   266: aload 7
    //   268: invokevirtual 128	java/util/jar/JarEntry:getCertificates	()[Ljava/security/cert/Certificate;
    //   271: astore 8
    //   273: aload 8
    //   275: ifnull +14 -> 289
    //   278: aload_0
    //   279: astore 4
    //   281: aload_0
    //   282: astore_3
    //   283: aload 8
    //   285: arraylength
    //   286: ifne +117 -> 403
    //   289: aload_0
    //   290: astore 4
    //   292: aload_0
    //   293: astore_3
    //   294: new 130	java/lang/SecurityException
    //   297: dup
    //   298: new 102	java/lang/StringBuilder
    //   301: dup
    //   302: ldc 132
    //   304: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   307: aload 7
    //   309: invokevirtual 51	java/util/jar/JarEntry:getName	()Ljava/lang/String;
    //   312: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: invokevirtual 114	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokespecial 136	java/lang/SecurityException:<init>	(Ljava/lang/String;)V
    //   321: astore 5
    //   323: aload_0
    //   324: astore 4
    //   326: aload_0
    //   327: astore_3
    //   328: sipush 16710
    //   331: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   334: aload_0
    //   335: astore 4
    //   337: aload_0
    //   338: astore_3
    //   339: aload 5
    //   341: athrow
    //   342: astore_3
    //   343: aload 4
    //   345: astore_0
    //   346: aload 6
    //   348: astore 4
    //   350: ldc 141
    //   352: aload_3
    //   353: ldc 143
    //   355: iconst_0
    //   356: anewarray 4	java/lang/Object
    //   359: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   362: sipush 16710
    //   365: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   368: aload_3
    //   369: athrow
    //   370: astore 5
    //   372: aload_0
    //   373: astore_3
    //   374: aload 5
    //   376: astore_0
    //   377: aload_3
    //   378: ifnull +7 -> 385
    //   381: aload_3
    //   382: invokevirtual 124	java/io/InputStream:close	()V
    //   385: aload 4
    //   387: ifnull +8 -> 395
    //   390: aload 4
    //   392: invokevirtual 148	java/util/jar/JarFile:close	()V
    //   395: sipush 16710
    //   398: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   401: aload_0
    //   402: athrow
    //   403: aload 5
    //   405: ifnonnull +258 -> 663
    //   408: aload_0
    //   409: astore 4
    //   411: aload_0
    //   412: astore_3
    //   413: aload 8
    //   415: iconst_0
    //   416: aaload
    //   417: checkcast 150	java/security/cert/X509Certificate
    //   420: astore 8
    //   422: aload 8
    //   424: astore 7
    //   426: aload_0
    //   427: astore 5
    //   429: aload 8
    //   431: ifnonnull +9 -> 440
    //   434: aload 8
    //   436: astore_3
    //   437: goto +229 -> 666
    //   440: aload 7
    //   442: ifnull +87 -> 529
    //   445: aload 5
    //   447: astore 4
    //   449: aload 5
    //   451: astore_3
    //   452: new 55	java/lang/String
    //   455: dup
    //   456: aload 7
    //   458: invokevirtual 154	java/security/cert/X509Certificate:getEncoded	()[B
    //   461: invokestatic 156	com/tencent/mm/platformtools/ai$b:ad	([B)[C
    //   464: invokespecial 159	java/lang/String:<init>	([C)V
    //   467: invokevirtual 162	java/lang/String:getBytes	()[B
    //   470: invokestatic 168	com/tencent/mm/sdk/platformtools/ag:v	([B)Ljava/lang/String;
    //   473: astore_0
    //   474: aload 5
    //   476: ifnull +8 -> 484
    //   479: aload 5
    //   481: invokevirtual 124	java/io/InputStream:close	()V
    //   484: aload 6
    //   486: invokevirtual 148	java/util/jar/JarFile:close	()V
    //   489: sipush 16710
    //   492: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   495: aload_0
    //   496: areturn
    //   497: astore_3
    //   498: ldc 141
    //   500: aload_3
    //   501: ldc 143
    //   503: iconst_0
    //   504: anewarray 4	java/lang/Object
    //   507: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   510: goto -26 -> 484
    //   513: astore_3
    //   514: ldc 141
    //   516: aload_3
    //   517: ldc 143
    //   519: iconst_0
    //   520: anewarray 4	java/lang/Object
    //   523: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   526: goto -37 -> 489
    //   529: aload 5
    //   531: ifnull +8 -> 539
    //   534: aload 5
    //   536: invokevirtual 124	java/io/InputStream:close	()V
    //   539: aload 6
    //   541: invokevirtual 148	java/util/jar/JarFile:close	()V
    //   544: sipush 16710
    //   547: invokestatic 139	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   550: ldc 143
    //   552: areturn
    //   553: astore_0
    //   554: ldc 141
    //   556: aload_0
    //   557: ldc 143
    //   559: iconst_0
    //   560: anewarray 4	java/lang/Object
    //   563: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   566: goto -27 -> 539
    //   569: astore_0
    //   570: ldc 141
    //   572: aload_0
    //   573: ldc 143
    //   575: iconst_0
    //   576: anewarray 4	java/lang/Object
    //   579: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   582: goto -38 -> 544
    //   585: astore_3
    //   586: ldc 141
    //   588: aload_3
    //   589: ldc 143
    //   591: iconst_0
    //   592: anewarray 4	java/lang/Object
    //   595: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   598: goto -213 -> 385
    //   601: astore_3
    //   602: ldc 141
    //   604: aload_3
    //   605: ldc 143
    //   607: iconst_0
    //   608: anewarray 4	java/lang/Object
    //   611: invokestatic 147	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   614: goto -219 -> 395
    //   617: astore_0
    //   618: aconst_null
    //   619: astore_3
    //   620: aconst_null
    //   621: astore 4
    //   623: goto -246 -> 377
    //   626: astore_0
    //   627: aconst_null
    //   628: astore_3
    //   629: aload 6
    //   631: astore 4
    //   633: goto -256 -> 377
    //   636: astore_0
    //   637: aload 6
    //   639: astore 4
    //   641: goto -264 -> 377
    //   644: astore_3
    //   645: aconst_null
    //   646: astore_0
    //   647: aconst_null
    //   648: astore 4
    //   650: goto -300 -> 350
    //   653: astore_3
    //   654: aconst_null
    //   655: astore_0
    //   656: aload 6
    //   658: astore 4
    //   660: goto -310 -> 350
    //   663: aload 5
    //   665: astore_3
    //   666: aload_3
    //   667: astore 5
    //   669: goto -634 -> 35
    //   672: aload 5
    //   674: astore 7
    //   676: aload_0
    //   677: astore 5
    //   679: goto -239 -> 440
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	682	0	paramFile	java.io.File
    //   165	54	1	l	long
    //   39	300	3	localFile	java.io.File
    //   342	27	3	localException1	java.lang.Exception
    //   373	79	3	localObject1	Object
    //   497	4	3	localIOException1	java.io.IOException
    //   513	4	3	localIOException2	java.io.IOException
    //   585	4	3	localIOException3	java.io.IOException
    //   601	4	3	localIOException4	java.io.IOException
    //   619	10	3	localObject2	Object
    //   644	1	3	localException2	java.lang.Exception
    //   653	1	3	localException3	java.lang.Exception
    //   665	2	3	localObject3	Object
    //   36	623	4	localObject4	Object
    //   31	309	5	localSecurityException	java.lang.SecurityException
    //   370	34	5	localObject5	Object
    //   427	251	5	localObject6	Object
    //   14	643	6	localJarFile	java.util.jar.JarFile
    //   65	610	7	localObject7	Object
    //   108	327	8	localObject8	Object
    //   21	219	9	arrayOfByte	byte[]
    //   28	28	10	localEnumeration	java.util.Enumeration
    // Exception table:
    //   from	to	target	type
    //   40	50	342	java/lang/Exception
    //   55	67	342	java/lang/Exception
    //   72	80	342	java/lang/Exception
    //   85	98	342	java/lang/Exception
    //   103	110	342	java/lang/Exception
    //   115	125	342	java/lang/Exception
    //   130	140	342	java/lang/Exception
    //   145	157	342	java/lang/Exception
    //   162	166	342	java/lang/Exception
    //   171	186	342	java/lang/Exception
    //   191	199	342	java/lang/Exception
    //   204	229	342	java/lang/Exception
    //   238	252	342	java/lang/Exception
    //   257	261	342	java/lang/Exception
    //   266	273	342	java/lang/Exception
    //   283	289	342	java/lang/Exception
    //   294	323	342	java/lang/Exception
    //   328	334	342	java/lang/Exception
    //   339	342	342	java/lang/Exception
    //   413	422	342	java/lang/Exception
    //   452	474	342	java/lang/Exception
    //   350	370	370	finally
    //   479	484	497	java/io/IOException
    //   484	489	513	java/io/IOException
    //   534	539	553	java/io/IOException
    //   539	544	569	java/io/IOException
    //   381	385	585	java/io/IOException
    //   390	395	601	java/io/IOException
    //   6	16	617	finally
    //   16	30	626	finally
    //   40	50	636	finally
    //   55	67	636	finally
    //   72	80	636	finally
    //   85	98	636	finally
    //   103	110	636	finally
    //   115	125	636	finally
    //   130	140	636	finally
    //   145	157	636	finally
    //   162	166	636	finally
    //   171	186	636	finally
    //   191	199	636	finally
    //   204	229	636	finally
    //   238	252	636	finally
    //   257	261	636	finally
    //   266	273	636	finally
    //   283	289	636	finally
    //   294	323	636	finally
    //   328	334	636	finally
    //   339	342	636	finally
    //   413	422	636	finally
    //   452	474	636	finally
    //   6	16	644	java/lang/Exception
    //   16	30	653	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.platformtools.ai.b
 * JD-Core Version:    0.7.0.1
 */