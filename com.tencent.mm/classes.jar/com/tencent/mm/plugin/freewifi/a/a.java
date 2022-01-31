package com.tencent.mm.plugin.freewifi.a;

import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.h.b;

public final class a
{
  private static final int knM = h.b.aTv().aTq();
  private static final int knN = h.b.aTv().aTr();
  
  /* Error */
  public static void a(java.lang.String paramString, a.a parama)
  {
    // Byte code:
    //   0: ldc 47
    //   2: ldc 49
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_0
    //   11: aastore
    //   12: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   15: aload_0
    //   16: invokestatic 61	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   19: ifeq +4 -> 23
    //   22: return
    //   23: aconst_null
    //   24: astore_2
    //   25: aconst_null
    //   26: astore 4
    //   28: new 63	java/net/URL
    //   31: dup
    //   32: aload_0
    //   33: invokespecial 66	java/net/URL:<init>	(Ljava/lang/String;)V
    //   36: invokevirtual 70	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   39: checkcast 72	java/net/HttpURLConnection
    //   42: astore_0
    //   43: aload_0
    //   44: ifnull +46 -> 90
    //   47: aload_0
    //   48: getstatic 28	com/tencent/mm/plugin/freewifi/a/a:knM	I
    //   51: invokevirtual 76	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   54: aload_0
    //   55: getstatic 33	com/tencent/mm/plugin/freewifi/a/a:knN	I
    //   58: invokevirtual 79	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   61: aload_0
    //   62: ldc 81
    //   64: invokestatic 20	com/tencent/mm/plugin/freewifi/h$b:aTv	()Lcom/tencent/mm/plugin/freewifi/h;
    //   67: invokevirtual 85	com/tencent/mm/plugin/freewifi/h:getUserAgent	()Ljava/lang/String;
    //   70: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   73: aload_0
    //   74: iconst_0
    //   75: invokevirtual 93	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   78: aload_0
    //   79: iconst_0
    //   80: invokevirtual 96	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   83: aload_1
    //   84: aload_0
    //   85: invokeinterface 100 2 0
    //   90: aload_0
    //   91: ifnull -69 -> 22
    //   94: aload_0
    //   95: invokevirtual 103	java/net/HttpURLConnection:disconnect	()V
    //   98: return
    //   99: astore_2
    //   100: aload_1
    //   101: aload_2
    //   102: invokeinterface 106 2 0
    //   107: goto -17 -> 90
    //   110: astore_3
    //   111: aload_0
    //   112: astore_2
    //   113: aload_1
    //   114: aload_3
    //   115: invokeinterface 106 2 0
    //   120: aload_0
    //   121: ifnull -99 -> 22
    //   124: aload_0
    //   125: invokevirtual 103	java/net/HttpURLConnection:disconnect	()V
    //   128: return
    //   129: astore_2
    //   130: aload_1
    //   131: aload_2
    //   132: invokeinterface 106 2 0
    //   137: goto -47 -> 90
    //   140: astore_1
    //   141: aload_0
    //   142: astore_2
    //   143: aload_1
    //   144: astore_0
    //   145: aload_2
    //   146: ifnull +7 -> 153
    //   149: aload_2
    //   150: invokevirtual 103	java/net/HttpURLConnection:disconnect	()V
    //   153: aload_0
    //   154: athrow
    //   155: astore_0
    //   156: goto -11 -> 145
    //   159: astore_3
    //   160: aload 4
    //   162: astore_0
    //   163: goto -52 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramString	java.lang.String
    //   0	166	1	parama	a.a
    //   24	1	2	localObject1	Object
    //   99	3	2	localIOException	java.io.IOException
    //   112	1	2	str1	java.lang.String
    //   129	3	2	localException1	java.lang.Exception
    //   142	8	2	str2	java.lang.String
    //   110	5	3	localException2	java.lang.Exception
    //   159	1	3	localException3	java.lang.Exception
    //   26	135	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   83	90	99	java/io/IOException
    //   47	83	110	java/lang/Exception
    //   100	107	110	java/lang/Exception
    //   130	137	110	java/lang/Exception
    //   83	90	129	java/lang/Exception
    //   47	83	140	finally
    //   83	90	140	finally
    //   100	107	140	finally
    //   130	137	140	finally
    //   28	43	155	finally
    //   113	120	155	finally
    //   28	43	159	java/lang/Exception
  }
  
  /* Error */
  public static void a(java.lang.String paramString1, java.lang.String paramString2, a.a parama)
  {
    // Byte code:
    //   0: ldc 47
    //   2: ldc 109
    //   4: iconst_2
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_0
    //   11: aastore
    //   12: dup
    //   13: iconst_1
    //   14: aload_1
    //   15: aastore
    //   16: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   19: aload_0
    //   20: invokestatic 61	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   23: ifne +10 -> 33
    //   26: aload_1
    //   27: invokestatic 61	com/tencent/mm/plugin/freewifi/m:isEmpty	(Ljava/lang/String;)Z
    //   30: ifeq +4 -> 34
    //   33: return
    //   34: aload_1
    //   35: ifnull +12 -> 47
    //   38: ldc 111
    //   40: aload_1
    //   41: invokevirtual 116	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   44: ifeq +181 -> 225
    //   47: ldc 111
    //   49: astore 6
    //   51: ldc 47
    //   53: ldc 118
    //   55: iconst_2
    //   56: anewarray 4	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload_0
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: aload 6
    //   67: aastore
    //   68: invokestatic 55	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: aconst_null
    //   72: astore_1
    //   73: aconst_null
    //   74: astore 7
    //   76: new 63	java/net/URL
    //   79: dup
    //   80: aload_0
    //   81: invokespecial 66	java/net/URL:<init>	(Ljava/lang/String;)V
    //   84: invokevirtual 70	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   87: checkcast 72	java/net/HttpURLConnection
    //   90: astore_0
    //   91: aload_0
    //   92: ifnull +124 -> 216
    //   95: aload_0
    //   96: getstatic 28	com/tencent/mm/plugin/freewifi/a/a:knM	I
    //   99: invokevirtual 76	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   102: aload_0
    //   103: getstatic 33	com/tencent/mm/plugin/freewifi/a/a:knN	I
    //   106: invokevirtual 79	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   109: aload_0
    //   110: ldc 81
    //   112: invokestatic 20	com/tencent/mm/plugin/freewifi/h$b:aTv	()Lcom/tencent/mm/plugin/freewifi/h;
    //   115: invokevirtual 85	com/tencent/mm/plugin/freewifi/h:getUserAgent	()Ljava/lang/String;
    //   118: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   121: aload_0
    //   122: iconst_0
    //   123: invokevirtual 96	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   126: aload_0
    //   127: iconst_1
    //   128: invokevirtual 121	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   131: aload_0
    //   132: ldc 123
    //   134: invokevirtual 126	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: ldc 128
    //   140: ldc 130
    //   142: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: ldc 132
    //   148: ldc 134
    //   150: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   153: aload_0
    //   154: iconst_0
    //   155: invokevirtual 93	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   158: aload 6
    //   160: ldc 136
    //   162: invokestatic 142	java/nio/charset/Charset:forName	(Ljava/lang/String;)Ljava/nio/charset/Charset;
    //   165: invokevirtual 146	java/lang/String:getBytes	(Ljava/nio/charset/Charset;)[B
    //   168: astore_1
    //   169: aload_0
    //   170: ldc 148
    //   172: aload_1
    //   173: arraylength
    //   174: invokestatic 154	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   177: invokevirtual 89	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   180: new 156	java/io/DataOutputStream
    //   183: dup
    //   184: aload_0
    //   185: invokevirtual 160	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   188: invokespecial 163	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   191: astore 6
    //   193: aload 6
    //   195: aload_1
    //   196: invokevirtual 167	java/io/DataOutputStream:write	([B)V
    //   199: aload 6
    //   201: invokevirtual 170	java/io/DataOutputStream:flush	()V
    //   204: aload 6
    //   206: invokevirtual 173	java/io/DataOutputStream:close	()V
    //   209: aload_2
    //   210: aload_0
    //   211: invokeinterface 100 2 0
    //   216: aload_0
    //   217: ifnull -184 -> 33
    //   220: aload_0
    //   221: invokevirtual 103	java/net/HttpURLConnection:disconnect	()V
    //   224: return
    //   225: ldc 111
    //   227: astore 6
    //   229: aload_1
    //   230: ldc 175
    //   232: invokevirtual 179	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   235: astore 10
    //   237: iconst_1
    //   238: istore_3
    //   239: aload 6
    //   241: astore_1
    //   242: iload_3
    //   243: bipush 10
    //   245: if_icmpgt +267 -> 512
    //   248: new 181	java/lang/StringBuilder
    //   251: dup
    //   252: ldc 183
    //   254: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   257: iload_3
    //   258: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   261: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   264: astore 11
    //   266: new 181	java/lang/StringBuilder
    //   269: dup
    //   270: ldc 192
    //   272: invokespecial 184	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: iload_3
    //   276: invokevirtual 188	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: astore 12
    //   284: aconst_null
    //   285: astore 6
    //   287: aconst_null
    //   288: astore 7
    //   290: aload 10
    //   292: arraylength
    //   293: istore 5
    //   295: iconst_0
    //   296: istore 4
    //   298: iload 4
    //   300: iload 5
    //   302: if_icmpge +120 -> 422
    //   305: aload 10
    //   307: iload 4
    //   309: aaload
    //   310: astore 13
    //   312: aload 13
    //   314: aload 11
    //   316: invokevirtual 196	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   319: iflt +47 -> 366
    //   322: aload 13
    //   324: ldc 198
    //   326: invokevirtual 179	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   329: arraylength
    //   330: iconst_2
    //   331: if_icmpne +35 -> 366
    //   334: aload 13
    //   336: ldc 198
    //   338: invokevirtual 179	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   341: iconst_1
    //   342: aaload
    //   343: astore 9
    //   345: aload 7
    //   347: astore 8
    //   349: iload 4
    //   351: iconst_1
    //   352: iadd
    //   353: istore 4
    //   355: aload 8
    //   357: astore 7
    //   359: aload 9
    //   361: astore 6
    //   363: goto -65 -> 298
    //   366: aload 7
    //   368: astore 8
    //   370: aload 6
    //   372: astore 9
    //   374: aload 13
    //   376: aload 12
    //   378: invokevirtual 196	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   381: iflt -32 -> 349
    //   384: aload 7
    //   386: astore 8
    //   388: aload 6
    //   390: astore 9
    //   392: aload 13
    //   394: ldc 198
    //   396: invokevirtual 179	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   399: arraylength
    //   400: iconst_2
    //   401: if_icmpne -52 -> 349
    //   404: aload 13
    //   406: ldc 198
    //   408: invokevirtual 179	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   411: iconst_1
    //   412: aaload
    //   413: astore 8
    //   415: aload 6
    //   417: astore 9
    //   419: goto -70 -> 349
    //   422: aload 6
    //   424: ifnull +88 -> 512
    //   427: aload 7
    //   429: ifnull +83 -> 512
    //   432: iload_3
    //   433: iconst_1
    //   434: if_icmpne +40 -> 474
    //   437: new 181	java/lang/StringBuilder
    //   440: dup
    //   441: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   444: aload_1
    //   445: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 6
    //   450: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: ldc 198
    //   455: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: aload 7
    //   460: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: astore_1
    //   467: iload_3
    //   468: iconst_1
    //   469: iadd
    //   470: istore_3
    //   471: goto -229 -> 242
    //   474: new 181	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   481: aload_1
    //   482: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: ldc 175
    //   487: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload 6
    //   492: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: ldc 198
    //   497: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload 7
    //   502: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   508: astore_1
    //   509: goto -42 -> 467
    //   512: aload_1
    //   513: astore 6
    //   515: goto -464 -> 51
    //   518: astore_1
    //   519: aload_2
    //   520: aload_1
    //   521: invokeinterface 106 2 0
    //   526: goto -310 -> 216
    //   529: astore 6
    //   531: aload_0
    //   532: astore_1
    //   533: aload_2
    //   534: aload 6
    //   536: invokeinterface 106 2 0
    //   541: aload_0
    //   542: ifnull -509 -> 33
    //   545: aload_0
    //   546: invokevirtual 103	java/net/HttpURLConnection:disconnect	()V
    //   549: return
    //   550: astore_1
    //   551: aload_2
    //   552: aload_1
    //   553: invokeinterface 106 2 0
    //   558: goto -342 -> 216
    //   561: astore_2
    //   562: aload_0
    //   563: astore_1
    //   564: aload_2
    //   565: astore_0
    //   566: aload_1
    //   567: ifnull +7 -> 574
    //   570: aload_1
    //   571: invokevirtual 103	java/net/HttpURLConnection:disconnect	()V
    //   574: aload_0
    //   575: athrow
    //   576: astore_0
    //   577: goto -11 -> 566
    //   580: astore 6
    //   582: aload 7
    //   584: astore_0
    //   585: goto -54 -> 531
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	588	0	paramString1	java.lang.String
    //   0	588	1	paramString2	java.lang.String
    //   0	588	2	parama	a.a
    //   238	233	3	i	int
    //   296	58	4	j	int
    //   293	10	5	k	int
    //   49	465	6	localObject1	Object
    //   529	6	6	localException1	java.lang.Exception
    //   580	1	6	localException2	java.lang.Exception
    //   74	509	7	localObject2	Object
    //   347	67	8	localObject3	Object
    //   343	75	9	localObject4	Object
    //   235	71	10	arrayOfString	java.lang.String[]
    //   264	51	11	str1	java.lang.String
    //   282	95	12	str2	java.lang.String
    //   310	95	13	str3	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   209	216	518	java/io/IOException
    //   95	209	529	java/lang/Exception
    //   519	526	529	java/lang/Exception
    //   551	558	529	java/lang/Exception
    //   209	216	550	java/lang/Exception
    //   95	209	561	finally
    //   209	216	561	finally
    //   519	526	561	finally
    //   551	558	561	finally
    //   76	91	576	finally
    //   533	541	576	finally
    //   76	91	580	java/lang/Exception
  }
  
  public static a aTG()
  {
    return b.aTH();
  }
  
  private static final class b
  {
    private static a knO = new a((byte)0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.freewifi.a.a
 * JD-Core Version:    0.7.0.1
 */