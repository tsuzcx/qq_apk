package midas.x;

import java.io.File;
import java.net.URL;

public class at
  extends Thread
{
  private File a = null;
  private URL b = null;
  private int c = 0;
  private int d = -1;
  private int e = 0;
  private boolean f = false;
  private ar g = null;
  private String h = "";
  
  public at(ar paramar, String paramString, URL paramURL, File paramFile, int paramInt1, int paramInt2, int paramInt3)
  {
    this.g = paramar;
    this.h = paramString;
    this.b = paramURL;
    this.a = paramFile;
    this.c = paramInt1;
    this.e = paramInt2;
    this.d = paramInt3;
  }
  
  public boolean a()
  {
    return this.f;
  }
  
  public void destroy()
  {
    super.destroy();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 53	java/lang/Thread:run	()V
    //   4: aload_0
    //   5: getfield 33	midas/x/at:e	I
    //   8: aload_0
    //   9: getfield 29	midas/x/at:c	I
    //   12: if_icmpge +672 -> 684
    //   15: aconst_null
    //   16: astore 8
    //   18: aconst_null
    //   19: astore 9
    //   21: new 55	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   28: astore 6
    //   30: aload 6
    //   32: ldc 58
    //   34: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 6
    //   40: aload_0
    //   41: getfield 41	midas/x/at:h	Ljava/lang/String;
    //   44: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: ldc 64
    //   50: aload 6
    //   52: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 73	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_0
    //   59: getfield 27	midas/x/at:b	Ljava/net/URL;
    //   62: invokevirtual 79	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   65: checkcast 81	java/net/HttpURLConnection
    //   68: astore 6
    //   70: aload 6
    //   72: ldc 82
    //   74: invokevirtual 86	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   77: aload 6
    //   79: ldc 82
    //   81: invokevirtual 89	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   84: aload 6
    //   86: ldc 91
    //   88: invokevirtual 95	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   91: aload 6
    //   93: iconst_1
    //   94: invokevirtual 99	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   97: aload 6
    //   99: iconst_0
    //   100: invokevirtual 102	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   103: aload_0
    //   104: getfield 29	midas/x/at:c	I
    //   107: aload_0
    //   108: getfield 31	midas/x/at:d	I
    //   111: iconst_1
    //   112: isub
    //   113: imul
    //   114: aload_0
    //   115: getfield 33	midas/x/at:e	I
    //   118: iadd
    //   119: istore_1
    //   120: aload_0
    //   121: getfield 29	midas/x/at:c	I
    //   124: istore_2
    //   125: aload_0
    //   126: getfield 31	midas/x/at:d	I
    //   129: istore_3
    //   130: new 55	java/lang/StringBuilder
    //   133: dup
    //   134: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   137: astore 7
    //   139: aload 7
    //   141: ldc 104
    //   143: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 7
    //   149: iload_1
    //   150: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload 7
    //   156: ldc 109
    //   158: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 7
    //   164: iload_2
    //   165: iload_3
    //   166: imul
    //   167: iconst_1
    //   168: isub
    //   169: invokevirtual 107	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 6
    //   175: ldc 111
    //   177: aload 7
    //   179: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokevirtual 114	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   185: aload 6
    //   187: ldc 116
    //   189: ldc 118
    //   191: invokevirtual 114	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   194: aload 6
    //   196: ldc 120
    //   198: ldc 122
    //   200: invokevirtual 114	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   203: aload 6
    //   205: instanceof 124
    //   208: ifeq +18 -> 226
    //   211: aload 6
    //   213: checkcast 124	javax/net/ssl/HttpsURLConnection
    //   216: aload_0
    //   217: getfield 27	midas/x/at:b	Ljava/net/URL;
    //   220: invokevirtual 127	java/net/URL:getHost	()Ljava/lang/String;
    //   223: invokestatic 132	midas/x/al:a	(Ljavax/net/ssl/HttpsURLConnection;Ljava/lang/String;)V
    //   226: aload 6
    //   228: invokevirtual 135	java/net/HttpURLConnection:connect	()V
    //   231: aload 6
    //   233: invokevirtual 139	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   236: astore 6
    //   238: sipush 2048
    //   241: newarray byte
    //   243: astore 8
    //   245: new 141	java/io/RandomAccessFile
    //   248: dup
    //   249: aload_0
    //   250: getfield 25	midas/x/at:a	Ljava/io/File;
    //   253: ldc 143
    //   255: invokespecial 146	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   258: astore 7
    //   260: iload_1
    //   261: i2l
    //   262: lstore 4
    //   264: aload 7
    //   266: lload 4
    //   268: invokevirtual 150	java/io/RandomAccessFile:seek	(J)V
    //   271: iconst_0
    //   272: istore_1
    //   273: aload 6
    //   275: aload 8
    //   277: iconst_0
    //   278: sipush 2048
    //   281: invokevirtual 156	java/io/InputStream:read	([BII)I
    //   284: istore_3
    //   285: iload_3
    //   286: iconst_m1
    //   287: if_icmpeq +69 -> 356
    //   290: aload 7
    //   292: aload 8
    //   294: iconst_0
    //   295: iload_3
    //   296: invokevirtual 160	java/io/RandomAccessFile:write	([BII)V
    //   299: aload_0
    //   300: aload_0
    //   301: getfield 33	midas/x/at:e	I
    //   304: iload_3
    //   305: iadd
    //   306: putfield 33	midas/x/at:e	I
    //   309: iload_1
    //   310: iload_3
    //   311: iadd
    //   312: istore_2
    //   313: aload_0
    //   314: getfield 37	midas/x/at:g	Lmidas/x/ar;
    //   317: aload_0
    //   318: getfield 41	midas/x/at:h	Ljava/lang/String;
    //   321: iload_3
    //   322: invokevirtual 165	midas/x/ar:a	(Ljava/lang/String;I)V
    //   325: iload_2
    //   326: istore_1
    //   327: iload_2
    //   328: sipush 10240
    //   331: if_icmplt -58 -> 273
    //   334: aload_0
    //   335: getfield 37	midas/x/at:g	Lmidas/x/ar;
    //   338: aload_0
    //   339: getfield 41	midas/x/at:h	Ljava/lang/String;
    //   342: aload_0
    //   343: getfield 31	midas/x/at:d	I
    //   346: aload_0
    //   347: getfield 33	midas/x/at:e	I
    //   350: invokevirtual 168	midas/x/ar:a	(Ljava/lang/String;II)V
    //   353: goto -82 -> 271
    //   356: aload_0
    //   357: getfield 37	midas/x/at:g	Lmidas/x/ar;
    //   360: astore 8
    //   362: aload_0
    //   363: getfield 41	midas/x/at:h	Ljava/lang/String;
    //   366: astore 9
    //   368: aload_0
    //   369: getfield 31	midas/x/at:d	I
    //   372: istore_1
    //   373: aload_0
    //   374: getfield 33	midas/x/at:e	I
    //   377: istore_2
    //   378: aload 8
    //   380: aload 9
    //   382: iload_1
    //   383: iload_2
    //   384: invokevirtual 168	midas/x/ar:a	(Ljava/lang/String;II)V
    //   387: goto +51 -> 438
    //   390: astore 8
    //   392: goto +67 -> 459
    //   395: astore 8
    //   397: aload 8
    //   399: invokevirtual 171	java/lang/Exception:printStackTrace	()V
    //   402: invokestatic 176	midas/x/aq:a	()Lmidas/x/aq;
    //   405: aload 8
    //   407: invokevirtual 177	java/lang/Exception:toString	()Ljava/lang/String;
    //   410: invokevirtual 179	midas/x/aq:b	(Ljava/lang/String;)V
    //   413: aload_0
    //   414: getfield 37	midas/x/at:g	Lmidas/x/ar;
    //   417: astore 8
    //   419: aload_0
    //   420: getfield 41	midas/x/at:h	Ljava/lang/String;
    //   423: astore 9
    //   425: aload_0
    //   426: getfield 31	midas/x/at:d	I
    //   429: istore_1
    //   430: aload_0
    //   431: getfield 33	midas/x/at:e	I
    //   434: istore_2
    //   435: goto -57 -> 378
    //   438: aload_0
    //   439: iconst_1
    //   440: putfield 35	midas/x/at:f	Z
    //   443: aload 6
    //   445: ifnull +8 -> 453
    //   448: aload 6
    //   450: invokevirtual 182	java/io/InputStream:close	()V
    //   453: aload 7
    //   455: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   458: return
    //   459: aload_0
    //   460: getfield 37	midas/x/at:g	Lmidas/x/ar;
    //   463: aload_0
    //   464: getfield 41	midas/x/at:h	Ljava/lang/String;
    //   467: aload_0
    //   468: getfield 31	midas/x/at:d	I
    //   471: aload_0
    //   472: getfield 33	midas/x/at:e	I
    //   475: invokevirtual 168	midas/x/ar:a	(Ljava/lang/String;II)V
    //   478: aload 8
    //   480: athrow
    //   481: astore 8
    //   483: goto +13 -> 496
    //   486: astore 8
    //   488: goto +48 -> 536
    //   491: astore 8
    //   493: aconst_null
    //   494: astore 7
    //   496: aload 6
    //   498: astore 9
    //   500: aload 8
    //   502: astore 6
    //   504: aload 9
    //   506: astore 8
    //   508: goto +142 -> 650
    //   511: astore 8
    //   513: aconst_null
    //   514: astore 7
    //   516: goto +20 -> 536
    //   519: astore 6
    //   521: aconst_null
    //   522: astore 7
    //   524: goto +126 -> 650
    //   527: astore 8
    //   529: aconst_null
    //   530: astore 7
    //   532: aload 9
    //   534: astore 6
    //   536: aload_0
    //   537: iconst_m1
    //   538: putfield 33	midas/x/at:e	I
    //   541: aload 8
    //   543: invokevirtual 171	java/lang/Exception:printStackTrace	()V
    //   546: invokestatic 176	midas/x/aq:a	()Lmidas/x/aq;
    //   549: aload 8
    //   551: invokevirtual 177	java/lang/Exception:toString	()Ljava/lang/String;
    //   554: invokevirtual 185	midas/x/aq:a	(Ljava/lang/String;)V
    //   557: new 55	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 56	java/lang/StringBuilder:<init>	()V
    //   564: astore 9
    //   566: aload 9
    //   568: ldc 58
    //   570: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 9
    //   576: aload_0
    //   577: getfield 41	midas/x/at:h	Ljava/lang/String;
    //   580: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: pop
    //   584: aload 9
    //   586: ldc 187
    //   588: invokevirtual 62	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload 9
    //   594: aload 8
    //   596: invokevirtual 190	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   599: pop
    //   600: ldc 64
    //   602: aload 9
    //   604: invokevirtual 68	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokestatic 73	com/tencent/midas/comm/APLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   610: aload 6
    //   612: ifnull +11 -> 623
    //   615: aload 6
    //   617: invokevirtual 182	java/io/InputStream:close	()V
    //   620: goto +3 -> 623
    //   623: aload 7
    //   625: ifnull +59 -> 684
    //   628: aload 7
    //   630: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   633: return
    //   634: aload 6
    //   636: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   639: return
    //   640: astore 9
    //   642: aload 6
    //   644: astore 8
    //   646: aload 9
    //   648: astore 6
    //   650: aload 8
    //   652: ifnull +11 -> 663
    //   655: aload 8
    //   657: invokevirtual 182	java/io/InputStream:close	()V
    //   660: goto +3 -> 663
    //   663: aload 7
    //   665: ifnull +16 -> 681
    //   668: aload 7
    //   670: invokevirtual 183	java/io/RandomAccessFile:close	()V
    //   673: goto +8 -> 681
    //   676: aload 7
    //   678: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   681: aload 6
    //   683: athrow
    //   684: return
    //   685: astore 6
    //   687: goto -53 -> 634
    //   690: astore 7
    //   692: goto -16 -> 676
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	695	0	this	at
    //   119	311	1	i	int
    //   124	311	2	j	int
    //   129	193	3	k	int
    //   262	5	4	l	long
    //   28	475	6	localObject1	Object
    //   519	1	6	localObject2	Object
    //   534	148	6	localObject3	Object
    //   685	1	6	localIOException1	java.io.IOException
    //   137	540	7	localObject4	Object
    //   690	1	7	localIOException2	java.io.IOException
    //   16	363	8	localObject5	Object
    //   390	1	8	localObject6	Object
    //   395	11	8	localException1	java.lang.Exception
    //   417	62	8	localar	ar
    //   481	1	8	localObject7	Object
    //   486	1	8	localException2	java.lang.Exception
    //   491	10	8	localObject8	Object
    //   506	1	8	localObject9	Object
    //   511	1	8	localException3	java.lang.Exception
    //   527	68	8	localException4	java.lang.Exception
    //   644	12	8	localObject10	Object
    //   19	584	9	localObject11	Object
    //   640	7	9	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   273	285	390	finally
    //   290	309	390	finally
    //   313	325	390	finally
    //   334	353	390	finally
    //   397	413	390	finally
    //   273	285	395	java/lang/Exception
    //   290	309	395	java/lang/Exception
    //   313	325	395	java/lang/Exception
    //   334	353	395	java/lang/Exception
    //   264	271	481	finally
    //   356	378	481	finally
    //   378	387	481	finally
    //   413	435	481	finally
    //   438	443	481	finally
    //   459	481	481	finally
    //   264	271	486	java/lang/Exception
    //   356	378	486	java/lang/Exception
    //   378	387	486	java/lang/Exception
    //   413	435	486	java/lang/Exception
    //   438	443	486	java/lang/Exception
    //   459	481	486	java/lang/Exception
    //   238	260	491	finally
    //   238	260	511	java/lang/Exception
    //   21	226	519	finally
    //   226	238	519	finally
    //   21	226	527	java/lang/Exception
    //   226	238	527	java/lang/Exception
    //   536	610	640	finally
    //   448	453	685	java/io/IOException
    //   453	458	685	java/io/IOException
    //   615	620	685	java/io/IOException
    //   628	633	685	java/io/IOException
    //   655	660	690	java/io/IOException
    //   668	673	690	java/io/IOException
  }
  
  public void start()
  {
    try
    {
      super.start();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.at
 * JD-Core Version:    0.7.0.1
 */