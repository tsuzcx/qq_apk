package com.tencent.tencentmap.mapsdk.a;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.URL;

public class h
{
  private static int a = 0;
  private static boolean b;
  
  /* Error */
  private static e a(HttpURLConnection paramHttpURLConnection, boolean paramBoolean)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload 6
    //   5: astore 5
    //   7: new 18	com/tencent/tencentmap/mapsdk/a/e
    //   10: dup
    //   11: invokespecial 21	com/tencent/tencentmap/mapsdk/a/e:<init>	()V
    //   14: astore 7
    //   16: aload 6
    //   18: astore 5
    //   20: aload_0
    //   21: invokevirtual 27	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   24: astore 8
    //   26: aload 6
    //   28: astore 5
    //   30: aload 7
    //   32: aload 8
    //   34: invokestatic 30	com/tencent/tencentmap/mapsdk/a/h:a	(Ljava/lang/String;)Ljava/lang/String;
    //   37: putfield 33	com/tencent/tencentmap/mapsdk/a/e:b	Ljava/lang/String;
    //   40: iload_1
    //   41: ifeq +31 -> 72
    //   44: aload 6
    //   46: astore 5
    //   48: aload 8
    //   50: invokestatic 38	com/tencent/tencentmap/mapsdk/a/c:a	(Ljava/lang/String;)Z
    //   53: ifeq +19 -> 72
    //   56: aload 6
    //   58: astore 5
    //   60: aload_0
    //   61: invokevirtual 41	java/net/HttpURLConnection:disconnect	()V
    //   64: aload 6
    //   66: astore 5
    //   68: aload_0
    //   69: invokevirtual 44	java/net/HttpURLConnection:connect	()V
    //   72: aload 6
    //   74: astore 5
    //   76: aload_0
    //   77: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   80: astore_0
    //   81: aload_0
    //   82: ifnull +114 -> 196
    //   85: aload_0
    //   86: astore 5
    //   88: aload 7
    //   90: iconst_0
    //   91: newarray byte
    //   93: putfield 51	com/tencent/tencentmap/mapsdk/a/e:a	[B
    //   96: iconst_0
    //   97: istore_2
    //   98: aload_0
    //   99: astore 5
    //   101: sipush 1024
    //   104: newarray byte
    //   106: astore 6
    //   108: aload_0
    //   109: astore 5
    //   111: aload_0
    //   112: aload 6
    //   114: invokevirtual 57	java/io/InputStream:read	([B)I
    //   117: istore 4
    //   119: iload_2
    //   120: istore_3
    //   121: iload 4
    //   123: ifle +66 -> 189
    //   126: iload_2
    //   127: iload 4
    //   129: iadd
    //   130: istore_3
    //   131: aload_0
    //   132: astore 5
    //   134: iload_3
    //   135: newarray byte
    //   137: astore 8
    //   139: aload_0
    //   140: astore 5
    //   142: aload 7
    //   144: getfield 51	com/tencent/tencentmap/mapsdk/a/e:a	[B
    //   147: iconst_0
    //   148: aload 8
    //   150: iconst_0
    //   151: aload 7
    //   153: getfield 51	com/tencent/tencentmap/mapsdk/a/e:a	[B
    //   156: arraylength
    //   157: invokestatic 63	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   160: aload_0
    //   161: astore 5
    //   163: aload 6
    //   165: iconst_0
    //   166: aload 8
    //   168: aload 7
    //   170: getfield 51	com/tencent/tencentmap/mapsdk/a/e:a	[B
    //   173: arraylength
    //   174: iload 4
    //   176: invokestatic 63	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   179: aload_0
    //   180: astore 5
    //   182: aload 7
    //   184: aload 8
    //   186: putfield 51	com/tencent/tencentmap/mapsdk/a/e:a	[B
    //   189: iload_3
    //   190: istore_2
    //   191: iload 4
    //   193: ifgt -85 -> 108
    //   196: aload_0
    //   197: ifnull +7 -> 204
    //   200: aload_0
    //   201: invokevirtual 66	java/io/InputStream:close	()V
    //   204: aload 7
    //   206: areturn
    //   207: astore_0
    //   208: aload 5
    //   210: ifnull +8 -> 218
    //   213: aload 5
    //   215: invokevirtual 66	java/io/InputStream:close	()V
    //   218: aload_0
    //   219: athrow
    //   220: astore_0
    //   221: aload 7
    //   223: areturn
    //   224: astore 5
    //   226: goto -8 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	paramHttpURLConnection	HttpURLConnection
    //   0	229	1	paramBoolean	boolean
    //   97	94	2	i	int
    //   120	70	3	j	int
    //   117	75	4	k	int
    //   5	209	5	localObject1	Object
    //   224	1	5	localIOException	IOException
    //   1	163	6	arrayOfByte	byte[]
    //   14	208	7	locale	e
    //   24	161	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   7	16	207	finally
    //   20	26	207	finally
    //   30	40	207	finally
    //   48	56	207	finally
    //   60	64	207	finally
    //   68	72	207	finally
    //   76	81	207	finally
    //   88	96	207	finally
    //   101	108	207	finally
    //   111	119	207	finally
    //   134	139	207	finally
    //   142	160	207	finally
    //   163	179	207	finally
    //   182	189	207	finally
    //   200	204	220	java/io/IOException
    //   213	218	224	java/io/IOException
  }
  
  /* Error */
  public static e a(boolean paramBoolean1, String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte, boolean paramBoolean2, boolean paramBoolean3)
    throws java.lang.Exception
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 8
    //   6: invokestatic 76	com/tencent/tencentmap/mapsdk/a/c:e	()Z
    //   9: ifne +11 -> 20
    //   12: new 78	com/tencent/tencentmap/mapsdk/a/j
    //   15: dup
    //   16: invokespecial 79	com/tencent/tencentmap/mapsdk/a/j:<init>	()V
    //   19: athrow
    //   20: aconst_null
    //   21: astore 10
    //   23: aconst_null
    //   24: astore 13
    //   26: aconst_null
    //   27: astore 12
    //   29: aconst_null
    //   30: astore 14
    //   32: aload 14
    //   34: astore 11
    //   36: aload_1
    //   37: iload 6
    //   39: invokestatic 82	com/tencent/tencentmap/mapsdk/a/h:a	(Ljava/lang/String;Z)Ljava/net/HttpURLConnection;
    //   42: astore_1
    //   43: aload_1
    //   44: astore 12
    //   46: aload_1
    //   47: astore 10
    //   49: aload 14
    //   51: astore 11
    //   53: aload_1
    //   54: astore 13
    //   56: aload_3
    //   57: invokestatic 85	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/lang/String;)Z
    //   60: ifeq +479 -> 539
    //   63: aload_1
    //   64: astore 12
    //   66: aload_1
    //   67: astore 10
    //   69: aload 14
    //   71: astore 11
    //   73: aload_1
    //   74: astore 13
    //   76: aload_1
    //   77: invokevirtual 89	java/net/HttpURLConnection:getURL	()Ljava/net/URL;
    //   80: invokevirtual 94	java/net/URL:getHost	()Ljava/lang/String;
    //   83: invokestatic 85	com/tencent/tencentmap/mapsdk/a/k:a	(Ljava/lang/String;)Z
    //   86: ifeq +3 -> 89
    //   89: iload_0
    //   90: ifeq +519 -> 609
    //   93: aload_1
    //   94: astore 12
    //   96: aload_1
    //   97: astore 10
    //   99: aload 14
    //   101: astore 11
    //   103: aload_1
    //   104: astore 13
    //   106: aload_1
    //   107: ldc 96
    //   109: invokevirtual 100	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   112: aload_1
    //   113: astore 12
    //   115: aload_1
    //   116: astore 10
    //   118: aload 14
    //   120: astore 11
    //   122: aload_1
    //   123: astore 13
    //   125: aload_1
    //   126: invokestatic 106	com/tencent/tencentmap/mapsdk/a/b:c	()I
    //   129: invokevirtual 110	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   132: aload_1
    //   133: astore 12
    //   135: aload_1
    //   136: astore 10
    //   138: aload 14
    //   140: astore 11
    //   142: aload_1
    //   143: astore 13
    //   145: aload_1
    //   146: invokestatic 113	com/tencent/tencentmap/mapsdk/a/b:d	()I
    //   149: invokevirtual 116	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   152: aload_1
    //   153: astore 12
    //   155: aload_1
    //   156: astore 10
    //   158: aload 14
    //   160: astore 11
    //   162: aload_1
    //   163: astore 13
    //   165: aload_1
    //   166: ldc 118
    //   168: aload_2
    //   169: invokevirtual 122	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: aload_1
    //   173: astore 12
    //   175: aload_1
    //   176: astore 10
    //   178: aload 14
    //   180: astore 11
    //   182: aload_1
    //   183: astore 13
    //   185: aload_1
    //   186: iconst_1
    //   187: invokevirtual 126	java/net/HttpURLConnection:setDoInput	(Z)V
    //   190: iload 9
    //   192: istore 6
    //   194: iload_0
    //   195: ifeq +6 -> 201
    //   198: iconst_0
    //   199: istore 6
    //   201: aload_1
    //   202: astore 12
    //   204: aload_1
    //   205: astore 10
    //   207: aload 14
    //   209: astore 11
    //   211: aload_1
    //   212: astore 13
    //   214: aload_1
    //   215: iload 6
    //   217: invokevirtual 129	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   220: aload_1
    //   221: astore 12
    //   223: aload_1
    //   224: astore 10
    //   226: aload 14
    //   228: astore 11
    //   230: aload_1
    //   231: astore 13
    //   233: aload_1
    //   234: iconst_0
    //   235: invokevirtual 132	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   238: iload 5
    //   240: ifeq +24 -> 264
    //   243: aload_1
    //   244: astore 12
    //   246: aload_1
    //   247: astore 10
    //   249: aload 14
    //   251: astore 11
    //   253: aload_1
    //   254: astore 13
    //   256: aload_1
    //   257: ldc 134
    //   259: ldc 136
    //   261: invokevirtual 122	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: aload_1
    //   265: astore 12
    //   267: aload_1
    //   268: astore 10
    //   270: aload 14
    //   272: astore 11
    //   274: aload_1
    //   275: astore 13
    //   277: aload_1
    //   278: invokestatic 139	com/tencent/tencentmap/mapsdk/a/b:a	(Ljava/net/HttpURLConnection;)V
    //   281: aload_1
    //   282: astore 12
    //   284: aload_1
    //   285: astore 10
    //   287: aload 14
    //   289: astore 11
    //   291: aload_1
    //   292: astore 13
    //   294: aload_1
    //   295: invokevirtual 44	java/net/HttpURLConnection:connect	()V
    //   298: aload_1
    //   299: astore 12
    //   301: aload_1
    //   302: astore 10
    //   304: aload 14
    //   306: astore 11
    //   308: aload_1
    //   309: astore 13
    //   311: invokestatic 141	com/tencent/tencentmap/mapsdk/a/b:e	()V
    //   314: iload_0
    //   315: ifne +66 -> 381
    //   318: aload 4
    //   320: ifnull +61 -> 381
    //   323: aload_1
    //   324: astore 12
    //   326: aload_1
    //   327: astore 10
    //   329: aload 14
    //   331: astore 11
    //   333: aload_1
    //   334: astore 13
    //   336: aload 4
    //   338: arraylength
    //   339: ifeq +42 -> 381
    //   342: aload_1
    //   343: astore 12
    //   345: aload_1
    //   346: astore 10
    //   348: aload 14
    //   350: astore 11
    //   352: aload_1
    //   353: astore 13
    //   355: new 143	java/io/DataOutputStream
    //   358: dup
    //   359: aload_1
    //   360: invokevirtual 147	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   363: invokespecial 150	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   366: astore_2
    //   367: aload_2
    //   368: aload 4
    //   370: invokevirtual 154	java/io/DataOutputStream:write	([B)V
    //   373: aload_2
    //   374: invokevirtual 157	java/io/DataOutputStream:flush	()V
    //   377: aload_2
    //   378: invokevirtual 158	java/io/DataOutputStream:close	()V
    //   381: aconst_null
    //   382: astore_2
    //   383: aload_1
    //   384: astore 12
    //   386: aload_1
    //   387: astore 10
    //   389: aload_2
    //   390: astore 11
    //   392: aload_1
    //   393: astore 13
    //   395: aload_1
    //   396: invokevirtual 161	java/net/HttpURLConnection:getResponseCode	()I
    //   399: istore 7
    //   401: iload 7
    //   403: sipush 200
    //   406: if_icmpeq +11 -> 417
    //   409: iload 7
    //   411: sipush 206
    //   414: if_icmpne +240 -> 654
    //   417: aload_1
    //   418: astore 12
    //   420: aload_1
    //   421: astore 10
    //   423: aload_2
    //   424: astore 11
    //   426: aload_1
    //   427: astore 13
    //   429: invokestatic 164	com/tencent/tencentmap/mapsdk/a/b:f	()V
    //   432: aload_1
    //   433: astore 12
    //   435: aload_1
    //   436: astore 10
    //   438: aload_2
    //   439: astore 11
    //   441: aload_1
    //   442: astore 13
    //   444: aload_1
    //   445: iload_0
    //   446: invokestatic 166	com/tencent/tencentmap/mapsdk/a/h:a	(Ljava/net/HttpURLConnection;Z)Lcom/tencent/tencentmap/mapsdk/a/e;
    //   449: astore_3
    //   450: iload 8
    //   452: istore 7
    //   454: aload_3
    //   455: ifnull +45 -> 500
    //   458: iload 8
    //   460: istore 7
    //   462: aload_1
    //   463: astore 12
    //   465: aload_1
    //   466: astore 10
    //   468: aload_2
    //   469: astore 11
    //   471: aload_1
    //   472: astore 13
    //   474: aload_3
    //   475: getfield 51	com/tencent/tencentmap/mapsdk/a/e:a	[B
    //   478: ifnull +22 -> 500
    //   481: aload_1
    //   482: astore 12
    //   484: aload_1
    //   485: astore 10
    //   487: aload_2
    //   488: astore 11
    //   490: aload_1
    //   491: astore 13
    //   493: aload_3
    //   494: getfield 51	com/tencent/tencentmap/mapsdk/a/e:a	[B
    //   497: arraylength
    //   498: istore 7
    //   500: aload_1
    //   501: astore 12
    //   503: aload_1
    //   504: astore 10
    //   506: aload_2
    //   507: astore 11
    //   509: aload_1
    //   510: astore 13
    //   512: iload 7
    //   514: invokestatic 168	com/tencent/tencentmap/mapsdk/a/b:a	(I)V
    //   517: iconst_0
    //   518: ifeq +11 -> 529
    //   521: new 170	java/lang/NullPointerException
    //   524: dup
    //   525: invokespecial 171	java/lang/NullPointerException:<init>	()V
    //   528: athrow
    //   529: aload_1
    //   530: ifnull +7 -> 537
    //   533: aload_1
    //   534: invokevirtual 41	java/net/HttpURLConnection:disconnect	()V
    //   537: aload_3
    //   538: areturn
    //   539: aload_1
    //   540: astore 12
    //   542: aload_1
    //   543: astore 10
    //   545: aload 14
    //   547: astore 11
    //   549: aload_1
    //   550: astore 13
    //   552: aload_1
    //   553: ldc 173
    //   555: aload_3
    //   556: invokevirtual 122	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   559: goto -470 -> 89
    //   562: aconst_null
    //   563: astore_2
    //   564: astore_3
    //   565: aload 12
    //   567: astore_1
    //   568: aload_1
    //   569: astore 10
    //   571: aload_2
    //   572: astore 11
    //   574: iconst_1
    //   575: invokestatic 175	com/tencent/tencentmap/mapsdk/a/b:a	(Z)V
    //   578: aload_1
    //   579: astore 10
    //   581: aload_2
    //   582: astore 11
    //   584: aload_3
    //   585: athrow
    //   586: astore_1
    //   587: aload 11
    //   589: ifnull +8 -> 597
    //   592: aload 11
    //   594: invokevirtual 158	java/io/DataOutputStream:close	()V
    //   597: aload 10
    //   599: ifnull +8 -> 607
    //   602: aload 10
    //   604: invokevirtual 41	java/net/HttpURLConnection:disconnect	()V
    //   607: aload_1
    //   608: athrow
    //   609: aload_1
    //   610: astore 12
    //   612: aload_1
    //   613: astore 10
    //   615: aload 14
    //   617: astore 11
    //   619: aload_1
    //   620: astore 13
    //   622: aload_1
    //   623: ldc 177
    //   625: invokevirtual 100	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   628: goto -516 -> 112
    //   631: aconst_null
    //   632: astore_1
    //   633: astore_2
    //   634: aload 13
    //   636: astore 10
    //   638: aload_1
    //   639: astore 11
    //   641: iconst_0
    //   642: invokestatic 175	com/tencent/tencentmap/mapsdk/a/b:a	(Z)V
    //   645: aload 13
    //   647: astore 10
    //   649: aload_1
    //   650: astore 11
    //   652: aload_2
    //   653: athrow
    //   654: iload 7
    //   656: sipush 202
    //   659: if_icmpeq +75 -> 734
    //   662: iload 7
    //   664: sipush 201
    //   667: if_icmpeq +67 -> 734
    //   670: iload 7
    //   672: sipush 204
    //   675: if_icmpeq +59 -> 734
    //   678: iload 7
    //   680: sipush 205
    //   683: if_icmpeq +51 -> 734
    //   686: iload 7
    //   688: sipush 304
    //   691: if_icmpeq +43 -> 734
    //   694: iload 7
    //   696: sipush 305
    //   699: if_icmpeq +35 -> 734
    //   702: iload 7
    //   704: sipush 408
    //   707: if_icmpeq +27 -> 734
    //   710: iload 7
    //   712: sipush 502
    //   715: if_icmpeq +19 -> 734
    //   718: iload 7
    //   720: sipush 504
    //   723: if_icmpeq +11 -> 734
    //   726: iload 7
    //   728: sipush 503
    //   731: if_icmpne +40 -> 771
    //   734: aload_1
    //   735: astore 12
    //   737: aload_1
    //   738: astore 10
    //   740: aload_2
    //   741: astore 11
    //   743: aload_1
    //   744: astore 13
    //   746: new 16	java/io/IOException
    //   749: dup
    //   750: new 179	java/lang/StringBuilder
    //   753: dup
    //   754: ldc 181
    //   756: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   759: iload 7
    //   761: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   764: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokespecial 191	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   770: athrow
    //   771: aload_1
    //   772: astore 12
    //   774: aload_1
    //   775: astore 10
    //   777: aload_2
    //   778: astore 11
    //   780: aload_1
    //   781: astore 13
    //   783: new 72	com/tencent/tencentmap/mapsdk/a/g
    //   786: dup
    //   787: new 179	java/lang/StringBuilder
    //   790: dup
    //   791: ldc 193
    //   793: invokespecial 183	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   796: iload 7
    //   798: invokevirtual 187	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   801: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokespecial 194	com/tencent/tencentmap/mapsdk/a/g:<init>	(Ljava/lang/String;)V
    //   807: athrow
    //   808: astore_3
    //   809: aload_1
    //   810: astore 10
    //   812: aload_2
    //   813: astore 11
    //   815: aload_3
    //   816: astore_1
    //   817: goto -230 -> 587
    //   820: astore 4
    //   822: aload_2
    //   823: astore_3
    //   824: aload_1
    //   825: astore 13
    //   827: aload 4
    //   829: astore_2
    //   830: aload_3
    //   831: astore_1
    //   832: goto -198 -> 634
    //   835: astore_3
    //   836: goto -268 -> 568
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	839	0	paramBoolean1	boolean
    //   0	839	1	paramString1	String
    //   0	839	2	paramString2	String
    //   0	839	3	paramString3	String
    //   0	839	4	paramArrayOfByte	byte[]
    //   0	839	5	paramBoolean2	boolean
    //   0	839	6	paramBoolean3	boolean
    //   399	398	7	i	int
    //   4	455	8	j	int
    //   1	190	9	bool	boolean
    //   21	790	10	localObject1	Object
    //   34	780	11	localObject2	Object
    //   27	746	12	str1	String
    //   24	802	13	str2	String
    //   30	586	14	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   36	43	562	com/tencent/tencentmap/mapsdk/a/g
    //   56	63	562	com/tencent/tencentmap/mapsdk/a/g
    //   76	89	562	com/tencent/tencentmap/mapsdk/a/g
    //   106	112	562	com/tencent/tencentmap/mapsdk/a/g
    //   125	132	562	com/tencent/tencentmap/mapsdk/a/g
    //   145	152	562	com/tencent/tencentmap/mapsdk/a/g
    //   165	172	562	com/tencent/tencentmap/mapsdk/a/g
    //   185	190	562	com/tencent/tencentmap/mapsdk/a/g
    //   214	220	562	com/tencent/tencentmap/mapsdk/a/g
    //   233	238	562	com/tencent/tencentmap/mapsdk/a/g
    //   256	264	562	com/tencent/tencentmap/mapsdk/a/g
    //   277	281	562	com/tencent/tencentmap/mapsdk/a/g
    //   294	298	562	com/tencent/tencentmap/mapsdk/a/g
    //   311	314	562	com/tencent/tencentmap/mapsdk/a/g
    //   336	342	562	com/tencent/tencentmap/mapsdk/a/g
    //   355	367	562	com/tencent/tencentmap/mapsdk/a/g
    //   395	401	562	com/tencent/tencentmap/mapsdk/a/g
    //   429	432	562	com/tencent/tencentmap/mapsdk/a/g
    //   444	450	562	com/tencent/tencentmap/mapsdk/a/g
    //   474	481	562	com/tencent/tencentmap/mapsdk/a/g
    //   493	500	562	com/tencent/tencentmap/mapsdk/a/g
    //   512	517	562	com/tencent/tencentmap/mapsdk/a/g
    //   552	559	562	com/tencent/tencentmap/mapsdk/a/g
    //   622	628	562	com/tencent/tencentmap/mapsdk/a/g
    //   746	771	562	com/tencent/tencentmap/mapsdk/a/g
    //   783	808	562	com/tencent/tencentmap/mapsdk/a/g
    //   36	43	586	finally
    //   56	63	586	finally
    //   76	89	586	finally
    //   106	112	586	finally
    //   125	132	586	finally
    //   145	152	586	finally
    //   165	172	586	finally
    //   185	190	586	finally
    //   214	220	586	finally
    //   233	238	586	finally
    //   256	264	586	finally
    //   277	281	586	finally
    //   294	298	586	finally
    //   311	314	586	finally
    //   336	342	586	finally
    //   355	367	586	finally
    //   395	401	586	finally
    //   429	432	586	finally
    //   444	450	586	finally
    //   474	481	586	finally
    //   493	500	586	finally
    //   512	517	586	finally
    //   552	559	586	finally
    //   574	578	586	finally
    //   584	586	586	finally
    //   622	628	586	finally
    //   641	645	586	finally
    //   652	654	586	finally
    //   746	771	586	finally
    //   783	808	586	finally
    //   36	43	631	java/lang/Exception
    //   56	63	631	java/lang/Exception
    //   76	89	631	java/lang/Exception
    //   106	112	631	java/lang/Exception
    //   125	132	631	java/lang/Exception
    //   145	152	631	java/lang/Exception
    //   165	172	631	java/lang/Exception
    //   185	190	631	java/lang/Exception
    //   214	220	631	java/lang/Exception
    //   233	238	631	java/lang/Exception
    //   256	264	631	java/lang/Exception
    //   277	281	631	java/lang/Exception
    //   294	298	631	java/lang/Exception
    //   311	314	631	java/lang/Exception
    //   336	342	631	java/lang/Exception
    //   355	367	631	java/lang/Exception
    //   395	401	631	java/lang/Exception
    //   429	432	631	java/lang/Exception
    //   444	450	631	java/lang/Exception
    //   474	481	631	java/lang/Exception
    //   493	500	631	java/lang/Exception
    //   512	517	631	java/lang/Exception
    //   552	559	631	java/lang/Exception
    //   622	628	631	java/lang/Exception
    //   746	771	631	java/lang/Exception
    //   783	808	631	java/lang/Exception
    //   367	381	808	finally
    //   367	381	820	java/lang/Exception
    //   367	381	835	com/tencent/tencentmap/mapsdk/a/g
  }
  
  private static String a(String paramString)
  {
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split(";");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {}
      do
      {
        return "GBK";
        Object localObject = paramString[i];
        if (!localObject.contains("charset")) {
          break;
        }
        paramString = localObject.split("=");
      } while (paramString.length <= 1);
      return paramString[1].trim();
      i += 1;
    }
  }
  
  public static HttpURLConnection a(String paramString, boolean paramBoolean)
  {
    URL localURL;
    try
    {
      localURL = new URL(paramString);
      if ((c.a(paramBoolean)) || (a == 0)) {
        a();
      }
    }
    catch (MalformedURLException paramString)
    {
      try
      {
        paramString = (HttpURLConnection)localURL.openConnection();
        return paramString;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramString = paramString;
      paramString.printStackTrace();
      return null;
    }
    for (;;)
    {
      try
      {
        switch (a)
        {
        case 2: 
          return a(localURL);
        }
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      paramString = a(localURL, paramString);
      return paramString;
    }
  }
  
  private static HttpURLConnection a(URL paramURL)
    throws IOException
  {
    Object localObject = android.net.Proxy.getDefaultHost();
    int j = android.net.Proxy.getDefaultPort();
    int i = j;
    if (j == -1) {
      i = 80;
    }
    localObject = new InetSocketAddress((String)localObject, i);
    return (HttpURLConnection)paramURL.openConnection(new java.net.Proxy(Proxy.Type.HTTP, (SocketAddress)localObject));
  }
  
  private static HttpURLConnection a(URL paramURL, String paramString)
    throws IOException
  {
    String str2 = android.net.Proxy.getDefaultHost();
    int j = android.net.Proxy.getDefaultPort();
    int i = j;
    if (j == -1) {
      i = 80;
    }
    String str1 = paramURL.getHost();
    int k = paramURL.getPort();
    j = k;
    if (k == -1) {
      j = 80;
    }
    if (paramString.indexOf(str1 + ":" + j) != -1) {}
    for (paramURL = paramString.replaceFirst(str1 + ":" + j, str2 + ":" + i);; paramURL = paramString.replaceFirst(str1, str2 + ":" + i)) {
      try
      {
        paramURL = new URL(paramURL);
        paramURL = (HttpURLConnection)paramURL.openConnection();
        paramURL.setRequestProperty("X-Online-Host", str1 + ":" + j);
        return paramURL;
      }
      catch (MalformedURLException paramURL) {}
    }
    return null;
  }
  
  /* Error */
  private static void a()
  {
    // Byte code:
    //   0: getstatic 288	com/tencent/tencentmap/mapsdk/a/h:b	Z
    //   3: ifeq +4 -> 7
    //   6: return
    //   7: iconst_1
    //   8: putstatic 288	com/tencent/tencentmap/mapsdk/a/h:b	Z
    //   11: new 91	java/net/URL
    //   14: dup
    //   15: ldc_w 290
    //   18: invokespecial 218	java/net/URL:<init>	(Ljava/lang/String;)V
    //   21: astore 5
    //   23: invokestatic 242	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   26: astore_3
    //   27: invokestatic 245	android/net/Proxy:getDefaultPort	()I
    //   30: istore_1
    //   31: iload_1
    //   32: istore_0
    //   33: iload_1
    //   34: iconst_m1
    //   35: if_icmpne +6 -> 41
    //   38: bipush 80
    //   40: istore_0
    //   41: new 247	java/net/InetSocketAddress
    //   44: dup
    //   45: aload_3
    //   46: iload_0
    //   47: invokespecial 250	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   50: astore_3
    //   51: new 252	java/net/Proxy
    //   54: dup
    //   55: getstatic 258	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   58: aload_3
    //   59: invokespecial 261	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   62: astore 6
    //   64: aconst_null
    //   65: astore 4
    //   67: aconst_null
    //   68: astore_3
    //   69: aload 5
    //   71: aload 6
    //   73: invokevirtual 264	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   76: checkcast 23	java/net/HttpURLConnection
    //   79: astore 5
    //   81: aload 5
    //   83: astore_3
    //   84: aload 5
    //   86: astore 4
    //   88: aload 5
    //   90: ldc 96
    //   92: invokevirtual 100	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   95: aload 5
    //   97: astore_3
    //   98: aload 5
    //   100: astore 4
    //   102: aload 5
    //   104: sipush 15000
    //   107: invokevirtual 110	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   110: aload 5
    //   112: astore_3
    //   113: aload 5
    //   115: astore 4
    //   117: aload 5
    //   119: ldc_w 291
    //   122: invokevirtual 116	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   125: aload 5
    //   127: astore_3
    //   128: aload 5
    //   130: astore 4
    //   132: aload 5
    //   134: ldc 118
    //   136: ldc_w 293
    //   139: invokevirtual 122	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload 5
    //   144: astore_3
    //   145: aload 5
    //   147: astore 4
    //   149: aload 5
    //   151: iconst_1
    //   152: invokevirtual 126	java/net/HttpURLConnection:setDoInput	(Z)V
    //   155: aload 5
    //   157: astore_3
    //   158: aload 5
    //   160: astore 4
    //   162: aload 5
    //   164: iconst_0
    //   165: invokevirtual 129	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   168: aload 5
    //   170: astore_3
    //   171: aload 5
    //   173: astore 4
    //   175: aload 5
    //   177: iconst_0
    //   178: invokevirtual 132	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   181: aload 5
    //   183: astore_3
    //   184: aload 5
    //   186: astore 4
    //   188: aload 5
    //   190: invokestatic 296	com/tencent/tencentmap/mapsdk/a/h:a	(Ljava/net/HttpURLConnection;)Z
    //   193: istore_2
    //   194: aload 5
    //   196: astore_3
    //   197: aload 5
    //   199: astore 4
    //   201: aload 5
    //   203: invokevirtual 44	java/net/HttpURLConnection:connect	()V
    //   206: iload_2
    //   207: ifeq +31 -> 238
    //   210: aload 5
    //   212: astore_3
    //   213: aload 5
    //   215: astore 4
    //   217: iconst_1
    //   218: invokestatic 297	com/tencent/tencentmap/mapsdk/a/h:a	(I)V
    //   221: aload 5
    //   223: ifnull -217 -> 6
    //   226: aload 5
    //   228: invokevirtual 41	java/net/HttpURLConnection:disconnect	()V
    //   231: return
    //   232: astore_3
    //   233: iconst_0
    //   234: putstatic 288	com/tencent/tencentmap/mapsdk/a/h:b	Z
    //   237: return
    //   238: aload 5
    //   240: astore_3
    //   241: aload 5
    //   243: astore 4
    //   245: iconst_2
    //   246: invokestatic 297	com/tencent/tencentmap/mapsdk/a/h:a	(I)V
    //   249: goto -28 -> 221
    //   252: astore 5
    //   254: aload_3
    //   255: astore 4
    //   257: aload 5
    //   259: invokevirtual 298	java/lang/Exception:printStackTrace	()V
    //   262: aload_3
    //   263: astore 4
    //   265: iconst_2
    //   266: invokestatic 297	com/tencent/tencentmap/mapsdk/a/h:a	(I)V
    //   269: aload_3
    //   270: ifnull -264 -> 6
    //   273: aload_3
    //   274: invokevirtual 41	java/net/HttpURLConnection:disconnect	()V
    //   277: return
    //   278: astore_3
    //   279: aload 4
    //   281: ifnull +8 -> 289
    //   284: aload 4
    //   286: invokevirtual 41	java/net/HttpURLConnection:disconnect	()V
    //   289: aload_3
    //   290: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   32	15	0	i	int
    //   30	6	1	j	int
    //   193	14	2	bool	boolean
    //   26	187	3	localObject1	Object
    //   232	1	3	localMalformedURLException	MalformedURLException
    //   240	34	3	localObject2	Object
    //   278	12	3	localObject3	Object
    //   65	220	4	localObject4	Object
    //   21	221	5	localObject5	Object
    //   252	6	5	localException	java.lang.Exception
    //   62	10	6	localProxy	java.net.Proxy
    // Exception table:
    //   from	to	target	type
    //   11	23	232	java/net/MalformedURLException
    //   69	81	252	java/lang/Exception
    //   88	95	252	java/lang/Exception
    //   102	110	252	java/lang/Exception
    //   117	125	252	java/lang/Exception
    //   132	142	252	java/lang/Exception
    //   149	155	252	java/lang/Exception
    //   162	168	252	java/lang/Exception
    //   175	181	252	java/lang/Exception
    //   188	194	252	java/lang/Exception
    //   201	206	252	java/lang/Exception
    //   217	221	252	java/lang/Exception
    //   245	249	252	java/lang/Exception
    //   69	81	278	finally
    //   88	95	278	finally
    //   102	110	278	finally
    //   117	125	278	finally
    //   132	142	278	finally
    //   149	155	278	finally
    //   162	168	278	finally
    //   175	181	278	finally
    //   188	194	278	finally
    //   201	206	278	finally
    //   217	221	278	finally
    //   245	249	278	finally
    //   257	262	278	finally
    //   265	269	278	finally
  }
  
  private static void a(int paramInt)
  {
    if (a == paramInt) {
      return;
    }
    a = paramInt;
  }
  
  /* Error */
  private static boolean a(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 48	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   6: astore 4
    //   8: aload 4
    //   10: astore_3
    //   11: aload_0
    //   12: invokevirtual 27	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
    //   15: ldc_w 300
    //   18: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   21: istore_1
    //   22: iload_1
    //   23: ifne +17 -> 40
    //   26: aload 4
    //   28: ifnull +8 -> 36
    //   31: aload 4
    //   33: invokevirtual 66	java/io/InputStream:close	()V
    //   36: iconst_0
    //   37: istore_1
    //   38: iload_1
    //   39: ireturn
    //   40: aload 4
    //   42: astore_3
    //   43: new 306	java/io/ByteArrayOutputStream
    //   46: dup
    //   47: invokespecial 307	java/io/ByteArrayOutputStream:<init>	()V
    //   50: astore_0
    //   51: aload 4
    //   53: astore_3
    //   54: aload 4
    //   56: invokevirtual 310	java/io/InputStream:available	()I
    //   59: ifgt +41 -> 100
    //   62: aload 4
    //   64: astore_3
    //   65: new 198	java/lang/String
    //   68: dup
    //   69: aload_0
    //   70: invokevirtual 314	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   73: invokespecial 316	java/lang/String:<init>	([B)V
    //   76: invokevirtual 215	java/lang/String:trim	()Ljava/lang/String;
    //   79: ldc_w 318
    //   82: invokevirtual 304	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   85: istore_2
    //   86: iload_2
    //   87: istore_1
    //   88: aload 4
    //   90: ifnull -52 -> 38
    //   93: aload 4
    //   95: invokevirtual 66	java/io/InputStream:close	()V
    //   98: iload_2
    //   99: ireturn
    //   100: aload 4
    //   102: astore_3
    //   103: aload_0
    //   104: aload 4
    //   106: invokevirtual 320	java/io/InputStream:read	()I
    //   109: invokevirtual 322	java/io/ByteArrayOutputStream:write	(I)V
    //   112: goto -61 -> 51
    //   115: astore_0
    //   116: aload_3
    //   117: ifnull +7 -> 124
    //   120: aload_3
    //   121: invokevirtual 66	java/io/InputStream:close	()V
    //   124: aload_0
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	paramHttpURLConnection	HttpURLConnection
    //   21	67	1	bool1	boolean
    //   85	14	2	bool2	boolean
    //   1	120	3	localObject	Object
    //   6	99	4	localInputStream	java.io.InputStream
    // Exception table:
    //   from	to	target	type
    //   2	8	115	finally
    //   11	22	115	finally
    //   43	51	115	finally
    //   54	62	115	finally
    //   65	86	115	finally
    //   103	112	115	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.h
 * JD-Core Version:    0.7.0.1
 */