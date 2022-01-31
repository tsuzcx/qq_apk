package com.tencent.mm.plugin.ad.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import com.tencent.mm.plugin.scanner.a.m;
import com.tencent.mm.plugin.scanner.util.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.qbar.QbarNative;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public final class a
{
  Set<Integer> bWG;
  private Object bjn = new Object();
  private boolean gpg = false;
  boolean mCancelled = false;
  private QbarNative njV = new QbarNative();
  a.a njW = null;
  long njX = 0L;
  
  /* Error */
  private d a(e.a parama, Set<Integer> paramSet)
  {
    // Byte code:
    //   0: new 48	com/tencent/mm/plugin/ad/a/d
    //   3: dup
    //   4: invokespecial 49	com/tencent/mm/plugin/ad/a/d:<init>	()V
    //   7: astore 11
    //   9: aload_0
    //   10: getfield 33	com/tencent/mm/plugin/ad/a/a:bjn	Ljava/lang/Object;
    //   13: astore 10
    //   15: aload 10
    //   17: monitorenter
    //   18: aload_2
    //   19: ifnull +29 -> 48
    //   22: aload_2
    //   23: invokeinterface 55 1 0
    //   28: ifne +20 -> 48
    //   31: aload_0
    //   32: aload_2
    //   33: invokespecial 59	com/tencent/mm/plugin/ad/a/a:h	(Ljava/util/Set;)Z
    //   36: ifne +12 -> 48
    //   39: aload_0
    //   40: invokespecial 62	com/tencent/mm/plugin/ad/a/a:nm	()V
    //   43: aload 10
    //   45: monitorexit
    //   46: aconst_null
    //   47: areturn
    //   48: aload_0
    //   49: getfield 35	com/tencent/mm/plugin/ad/a/a:gpg	Z
    //   52: ifne +82 -> 134
    //   55: new 64	java/util/HashSet
    //   58: dup
    //   59: invokespecial 65	java/util/HashSet:<init>	()V
    //   62: astore_2
    //   63: aload_2
    //   64: iconst_2
    //   65: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   68: invokeinterface 75 2 0
    //   73: pop
    //   74: aload_2
    //   75: iconst_1
    //   76: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: invokeinterface 75 2 0
    //   84: pop
    //   85: aload_2
    //   86: iconst_4
    //   87: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: invokeinterface 75 2 0
    //   95: pop
    //   96: aload_2
    //   97: iconst_3
    //   98: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   101: invokeinterface 75 2 0
    //   106: pop
    //   107: aload_0
    //   108: aload_2
    //   109: invokespecial 59	com/tencent/mm/plugin/ad/a/a:h	(Ljava/util/Set;)Z
    //   112: istore 5
    //   114: iload 5
    //   116: ifne +27 -> 143
    //   119: aload_0
    //   120: invokespecial 62	com/tencent/mm/plugin/ad/a/a:nm	()V
    //   123: aload 10
    //   125: monitorexit
    //   126: aconst_null
    //   127: areturn
    //   128: astore_1
    //   129: aload 10
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    //   134: aload_0
    //   135: getfield 35	com/tencent/mm/plugin/ad/a/a:gpg	Z
    //   138: istore 5
    //   140: goto -26 -> 114
    //   143: ldc 77
    //   145: ldc 79
    //   147: iconst_1
    //   148: anewarray 4	java/lang/Object
    //   151: dup
    //   152: iconst_0
    //   153: iconst_0
    //   154: invokestatic 84	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   157: aastore
    //   158: invokestatic 90	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   161: aload_1
    //   162: invokevirtual 96	e/a:byj	()[B
    //   165: ifnull +45 -> 210
    //   168: ldc 77
    //   170: ldc 98
    //   172: iconst_3
    //   173: anewarray 4	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_1
    //   179: invokevirtual 96	e/a:byj	()[B
    //   182: arraylength
    //   183: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: aload_1
    //   190: getfield 102	e/a:width	I
    //   193: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   196: aastore
    //   197: dup
    //   198: iconst_2
    //   199: aload_1
    //   200: getfield 105	e/a:height	I
    //   203: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   206: aastore
    //   207: invokestatic 108	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   210: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   213: lstore 6
    //   215: aload_1
    //   216: invokevirtual 96	e/a:byj	()[B
    //   219: ifnull +147 -> 366
    //   222: aload_1
    //   223: getfield 102	e/a:width	I
    //   226: aload_1
    //   227: getfield 105	e/a:height	I
    //   230: imul
    //   231: aload_1
    //   232: invokevirtual 96	e/a:byj	()[B
    //   235: arraylength
    //   236: if_icmpne +130 -> 366
    //   239: getstatic 120	com/tencent/mm/plugin/scanner/a/m:nHb	Lcom/tencent/mm/plugin/scanner/a/m;
    //   242: aload_1
    //   243: getfield 102	e/a:width	I
    //   246: aload_1
    //   247: getfield 105	e/a:height	I
    //   250: invokevirtual 124	com/tencent/mm/plugin/scanner/a/m:dF	(II)V
    //   253: aload_0
    //   254: getfield 31	com/tencent/mm/plugin/ad/a/a:njV	Lcom/tencent/qbar/QbarNative;
    //   257: aload_1
    //   258: invokevirtual 96	e/a:byj	()[B
    //   261: aload_1
    //   262: getfield 102	e/a:width	I
    //   265: aload_1
    //   266: getfield 105	e/a:height	I
    //   269: invokevirtual 128	com/tencent/qbar/QbarNative:w	([BII)I
    //   272: istore_3
    //   273: invokestatic 114	java/lang/System:currentTimeMillis	()J
    //   276: lstore 8
    //   278: ldc 77
    //   280: ldc 130
    //   282: iconst_2
    //   283: anewarray 4	java/lang/Object
    //   286: dup
    //   287: iconst_0
    //   288: iload_3
    //   289: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   292: aastore
    //   293: dup
    //   294: iconst_1
    //   295: lload 8
    //   297: lload 6
    //   299: lsub
    //   300: invokestatic 135	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   303: aastore
    //   304: invokestatic 90	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   307: getstatic 120	com/tencent/mm/plugin/scanner/a/m:nHb	Lcom/tencent/mm/plugin/scanner/a/m;
    //   310: lload 8
    //   312: lload 6
    //   314: lsub
    //   315: invokevirtual 139	com/tencent/mm/plugin/scanner/a/m:fz	(J)V
    //   318: getstatic 120	com/tencent/mm/plugin/scanner/a/m:nHb	Lcom/tencent/mm/plugin/scanner/a/m;
    //   321: invokevirtual 142	com/tencent/mm/plugin/scanner/a/m:bxj	()V
    //   324: iload_3
    //   325: ifeq +46 -> 371
    //   328: new 144	java/util/ArrayList
    //   331: dup
    //   332: invokespecial 145	java/util/ArrayList:<init>	()V
    //   335: astore_1
    //   336: new 144	java/util/ArrayList
    //   339: dup
    //   340: invokespecial 145	java/util/ArrayList:<init>	()V
    //   343: astore_2
    //   344: aload_0
    //   345: getfield 31	com/tencent/mm/plugin/ad/a/a:njV	Lcom/tencent/qbar/QbarNative;
    //   348: aload_1
    //   349: aload_2
    //   350: invokevirtual 149	com/tencent/qbar/QbarNative:n	(Ljava/util/List;Ljava/util/List;)I
    //   353: pop
    //   354: getstatic 120	com/tencent/mm/plugin/scanner/a/m:nHb	Lcom/tencent/mm/plugin/scanner/a/m;
    //   357: aload_1
    //   358: putfield 153	com/tencent/mm/plugin/scanner/a/m:nHs	Ljava/util/List;
    //   361: aload 10
    //   363: monitorexit
    //   364: aconst_null
    //   365: areturn
    //   366: iconst_m1
    //   367: istore_3
    //   368: goto -95 -> 273
    //   371: invokestatic 159	com/tencent/mm/model/u:Hc	()Lcom/tencent/mm/model/u;
    //   374: ldc 161
    //   376: invokevirtual 165	com/tencent/mm/model/u:ii	(Ljava/lang/String;)Lcom/tencent/mm/model/u$b;
    //   379: astore_1
    //   380: aload_1
    //   381: ifnull +75 -> 456
    //   384: aload_1
    //   385: ldc 167
    //   387: iconst_0
    //   388: invokevirtual 173	com/tencent/mm/model/u$b:getInt	(Ljava/lang/String;I)I
    //   391: istore_3
    //   392: aload_1
    //   393: ldc 175
    //   395: iconst_0
    //   396: invokevirtual 173	com/tencent/mm/model/u$b:getInt	(Ljava/lang/String;I)I
    //   399: istore 4
    //   401: aload_0
    //   402: getfield 31	com/tencent/mm/plugin/ad/a/a:njV	Lcom/tencent/qbar/QbarNative;
    //   405: astore_1
    //   406: aload_1
    //   407: iload_3
    //   408: iload 4
    //   410: invokestatic 181	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   413: invokestatic 187	com/tencent/mm/cb/a:fj	(Landroid/content/Context;)I
    //   416: invokestatic 181	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   419: invokestatic 190	com/tencent/mm/cb/a:fk	(Landroid/content/Context;)I
    //   422: aload_1
    //   423: getfield 193	com/tencent/qbar/QbarNative:wKg	I
    //   426: invokevirtual 197	com/tencent/qbar/QbarNative:SetCenterCoordinate	(IIIII)I
    //   429: pop
    //   430: ldc 77
    //   432: ldc 199
    //   434: iconst_2
    //   435: anewarray 4	java/lang/Object
    //   438: dup
    //   439: iconst_0
    //   440: iload_3
    //   441: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   444: aastore
    //   445: dup
    //   446: iconst_1
    //   447: iload 4
    //   449: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   452: aastore
    //   453: invokestatic 108	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   456: getstatic 120	com/tencent/mm/plugin/scanner/a/m:nHb	Lcom/tencent/mm/plugin/scanner/a/m;
    //   459: invokevirtual 202	com/tencent/mm/plugin/scanner/a/m:bxi	()V
    //   462: getstatic 120	com/tencent/mm/plugin/scanner/a/m:nHb	Lcom/tencent/mm/plugin/scanner/a/m;
    //   465: lload 8
    //   467: lload 6
    //   469: lsub
    //   470: invokevirtual 205	com/tencent/mm/plugin/scanner/a/m:fA	(J)V
    //   473: new 207	java/util/LinkedList
    //   476: dup
    //   477: invokespecial 208	java/util/LinkedList:<init>	()V
    //   480: astore 12
    //   482: new 207	java/util/LinkedList
    //   485: dup
    //   486: invokespecial 208	java/util/LinkedList:<init>	()V
    //   489: astore_1
    //   490: aload_0
    //   491: getfield 31	com/tencent/mm/plugin/ad/a/a:njV	Lcom/tencent/qbar/QbarNative;
    //   494: aload 12
    //   496: aload_1
    //   497: invokevirtual 211	com/tencent/qbar/QbarNative:m	(Ljava/util/List;Ljava/util/List;)I
    //   500: pop
    //   501: aload 12
    //   503: invokeinterface 217 1 0
    //   508: istore_3
    //   509: iload_3
    //   510: ifne +8 -> 518
    //   513: aload 10
    //   515: monitorexit
    //   516: aconst_null
    //   517: areturn
    //   518: ldc 77
    //   520: ldc 219
    //   522: iconst_1
    //   523: anewarray 4	java/lang/Object
    //   526: dup
    //   527: iconst_0
    //   528: aload 12
    //   530: invokeinterface 217 1 0
    //   535: invokestatic 71	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   538: aastore
    //   539: invokestatic 108	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   542: aload 12
    //   544: iconst_0
    //   545: invokeinterface 223 2 0
    //   550: checkcast 225	com/tencent/qbar/QbarNative$QBarResult
    //   553: astore 13
    //   555: aconst_null
    //   556: astore_2
    //   557: aload_1
    //   558: invokestatic 231	com/tencent/mm/sdk/platformtools/bk:dk	(Ljava/util/List;)Z
    //   561: ifne +14 -> 575
    //   564: aload_1
    //   565: iconst_0
    //   566: invokeinterface 223 2 0
    //   571: checkcast 233	com/tencent/qbar/QbarNative$QBarReportMsg
    //   574: astore_2
    //   575: ldc 235
    //   577: astore_1
    //   578: aload 13
    //   580: ifnull +114 -> 694
    //   583: aload 13
    //   585: getfield 239	com/tencent/qbar/QbarNative$QBarResult:data	Ljava/lang/String;
    //   588: invokestatic 243	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   591: ifne +33 -> 624
    //   594: aload 13
    //   596: getfield 246	com/tencent/qbar/QbarNative$QBarResult:typeName	Ljava/lang/String;
    //   599: astore_1
    //   600: aload_1
    //   601: ldc 248
    //   603: invokevirtual 253	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   606: ifne +12 -> 618
    //   609: aload_1
    //   610: ldc 255
    //   612: invokevirtual 253	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   615: ifeq +85 -> 700
    //   618: aload 13
    //   620: getfield 239	com/tencent/qbar/QbarNative$QBarResult:data	Ljava/lang/String;
    //   623: astore_1
    //   624: aload 11
    //   626: aload_1
    //   627: putfield 258	com/tencent/mm/plugin/ad/a/d:result	Ljava/lang/String;
    //   630: aload 11
    //   632: aload 13
    //   634: getfield 262	com/tencent/qbar/QbarNative$QBarResult:rawData	[B
    //   637: putfield 263	com/tencent/mm/plugin/ad/a/d:rawData	[B
    //   640: aload 11
    //   642: aload 13
    //   644: getfield 246	com/tencent/qbar/QbarNative$QBarResult:typeName	Ljava/lang/String;
    //   647: invokestatic 269	com/tencent/mm/plugin/scanner/util/r:Mi	(Ljava/lang/String;)I
    //   650: putfield 272	com/tencent/mm/plugin/ad/a/d:bIj	I
    //   653: aload_2
    //   654: ifnull +78 -> 732
    //   657: aload_2
    //   658: getfield 275	com/tencent/qbar/QbarNative$QBarReportMsg:qrcodeVersion	I
    //   661: istore_3
    //   662: aload 11
    //   664: iload_3
    //   665: putfield 278	com/tencent/mm/plugin/ad/a/d:bIk	I
    //   668: getstatic 120	com/tencent/mm/plugin/scanner/a/m:nHb	Lcom/tencent/mm/plugin/scanner/a/m;
    //   671: aload 13
    //   673: getfield 246	com/tencent/qbar/QbarNative$QBarResult:typeName	Ljava/lang/String;
    //   676: aload_1
    //   677: aload 13
    //   679: getfield 281	com/tencent/qbar/QbarNative$QBarResult:charset	Ljava/lang/String;
    //   682: aload_2
    //   683: aload 12
    //   685: invokeinterface 217 1 0
    //   690: iconst_0
    //   691: invokevirtual 284	com/tencent/mm/plugin/scanner/a/m:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/qbar/QbarNative$QBarReportMsg;II)V
    //   694: aload 10
    //   696: monitorexit
    //   697: aload 11
    //   699: areturn
    //   700: new 286	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 287	java/lang/StringBuilder:<init>	()V
    //   707: aload_1
    //   708: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: ldc_w 293
    //   714: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   717: aload 13
    //   719: getfield 239	com/tencent/qbar/QbarNative$QBarResult:data	Ljava/lang/String;
    //   722: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   725: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   728: astore_1
    //   729: goto -105 -> 624
    //   732: iconst_0
    //   733: istore_3
    //   734: goto -72 -> 662
    //   737: astore_1
    //   738: ldc 77
    //   740: new 286	java/lang/StringBuilder
    //   743: dup
    //   744: ldc_w 299
    //   747: invokespecial 302	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   750: aload_1
    //   751: invokevirtual 305	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   754: invokevirtual 291	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokevirtual 297	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokestatic 309	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   763: ldc 77
    //   765: aload_1
    //   766: ldc 235
    //   768: iconst_0
    //   769: anewarray 4	java/lang/Object
    //   772: invokestatic 313	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   775: aload 10
    //   777: monitorexit
    //   778: aload 11
    //   780: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	781	0	this	a
    //   0	781	1	parama	e.a
    //   0	781	2	paramSet	Set<Integer>
    //   272	462	3	i	int
    //   399	49	4	j	int
    //   112	27	5	bool	boolean
    //   213	255	6	l1	long
    //   276	190	8	l2	long
    //   13	763	10	localObject	Object
    //   7	772	11	locald	d
    //   480	204	12	localLinkedList	java.util.LinkedList
    //   553	165	13	localQBarResult	com.tencent.qbar.QbarNative.QBarResult
    // Exception table:
    //   from	to	target	type
    //   22	43	128	finally
    //   43	46	128	finally
    //   48	114	128	finally
    //   119	123	128	finally
    //   123	126	128	finally
    //   129	132	128	finally
    //   134	140	128	finally
    //   143	210	128	finally
    //   210	273	128	finally
    //   273	324	128	finally
    //   328	361	128	finally
    //   361	364	128	finally
    //   371	380	128	finally
    //   384	456	128	finally
    //   456	509	128	finally
    //   513	516	128	finally
    //   518	555	128	finally
    //   557	575	128	finally
    //   583	618	128	finally
    //   618	624	128	finally
    //   624	653	128	finally
    //   657	662	128	finally
    //   662	694	128	finally
    //   694	697	128	finally
    //   700	729	128	finally
    //   738	778	128	finally
    //   22	43	737	java/lang/Exception
    //   48	114	737	java/lang/Exception
    //   119	123	737	java/lang/Exception
    //   134	140	737	java/lang/Exception
    //   143	210	737	java/lang/Exception
    //   210	273	737	java/lang/Exception
    //   273	324	737	java/lang/Exception
    //   328	361	737	java/lang/Exception
    //   371	380	737	java/lang/Exception
    //   384	456	737	java/lang/Exception
    //   456	509	737	java/lang/Exception
    //   518	555	737	java/lang/Exception
    //   557	575	737	java/lang/Exception
    //   583	618	737	java/lang/Exception
    //   618	624	737	java/lang/Exception
    //   624	653	737	java/lang/Exception
    //   657	662	737	java/lang/Exception
    //   662	694	737	java/lang/Exception
    //   700	729	737	java/lang/Exception
  }
  
  private d c(Bitmap paramBitmap, int paramInt)
  {
    paramBitmap = new f(paramBitmap, paramInt, paramInt);
    if ((paramBitmap.byj() == null) || (paramBitmap.width <= 0) || (paramBitmap.height <= 0)) {
      return null;
    }
    return a(paramBitmap, this.bWG);
  }
  
  private int g(Set<Integer> arg1)
  {
    if ((??? != null) && (!???.isEmpty()))
    {
      int[] arrayOfInt = new int[???.size()];
      ??? = ???.iterator();
      int i = 0;
      while (???.hasNext())
      {
        Integer localInteger = (Integer)???.next();
        if (localInteger != null)
        {
          arrayOfInt[i] = localInteger.intValue();
          i += 1;
        }
      }
      y.i("MicroMsg.scanner.DecodeFile", "QBarNative.SetReaders, readers:%s", new Object[] { Arrays.toString(arrayOfInt) });
      synchronized (this.bjn)
      {
        i = this.njV.h(arrayOfInt, arrayOfInt.length);
        return i;
      }
    }
    return 0;
  }
  
  private boolean h(Set<Integer> paramSet)
  {
    if ((!this.gpg) && (paramSet != null) && (!paramSet.isEmpty()))
    {
      int i = this.njV.a(1, "ANY", "UTF-8", com.tencent.qbar.a.hp(ae.getContext()));
      m.nHb.nHr = paramSet.contains(Integer.valueOf(3));
      int j = g(paramSet);
      y.i("MicroMsg.scanner.DecodeFile", "QbarNative.Init = [%s], SetReaders = [%s], version = [%s]", new Object[] { Integer.valueOf(i), Integer.valueOf(j), QbarNative.getVersion() });
      if ((i == 0) && (j == 0)) {
        this.gpg = true;
      }
    }
    else
    {
      return this.gpg;
    }
    y.e("MicroMsg.scanner.DecodeFile", "QbarNative failed, releaseDecoder 1");
    return false;
  }
  
  private void nm()
  {
    y.d("MicroMsg.scanner.DecodeFile", "releaseDecoder() start, hasInitQBar = %s", new Object[] { Boolean.valueOf(this.gpg) });
    synchronized (this.bjn)
    {
      if (this.gpg)
      {
        int i = this.njV.release();
        this.njV = null;
        this.gpg = false;
        y.d("MicroMsg.scanner.DecodeFile", "QbarNative.Release() = [%s]", new Object[] { Integer.valueOf(i) });
      }
      com.tencent.mm.plugin.scanner.util.c.byh();
      return;
    }
  }
  
  public final d Lu(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if ((paramString == null) || (paramString.length() <= 0)) {
      y.e("MicroMsg.scanner.DecodeFile", "in decodeFile, file == null");
    }
    BitmapFactory.Options localOptions;
    do
    {
      return localObject1;
      localOptions = com.tencent.mm.sdk.platformtools.c.YU(paramString);
      if (localOptions != null)
      {
        localOptions.inJustDecodeBounds = false;
        localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
        if (localOptions.outWidth * localOptions.outHeight * 8 * 4L > 268435456L)
        {
          y.i("MicroMsg.scanner.DecodeFile", "initial width %d, initial height %d", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight) });
          localOptions.inSampleSize = 4;
        }
      }
    } while (this.mCancelled);
    localObject1 = localObject2;
    try
    {
      paramString = com.tencent.mm.sdk.platformtools.c.decodeFile(paramString, localOptions);
      if (paramString == null)
      {
        localObject1 = localObject2;
        y.e("MicroMsg.scanner.DecodeFile", "decode bitmap is null!");
        return null;
      }
    }
    catch (OutOfMemoryError paramString)
    {
      y.e("MicroMsg.scanner.DecodeFile", "OutOfMemoryError, e: %s", new Object[] { paramString.getMessage() });
      return localObject1;
    }
    localObject1 = localObject2;
    paramString = b(paramString, 8);
    if (paramString == null) {}
    for (boolean bool = true;; bool = false)
    {
      localObject1 = paramString;
      y.d("MicroMsg.scanner.DecodeFile", "decode result==null:%b", new Object[] { Boolean.valueOf(bool) });
      localObject1 = paramString;
      if (paramString == null) {
        break;
      }
      localObject1 = paramString;
      bool = bk.bl(paramString.result);
      localObject1 = paramString;
      if (bool) {
        break;
      }
      return paramString;
    }
  }
  
  public final d b(Bitmap paramBitmap, int paramInt)
  {
    long l1 = SystemClock.elapsedRealtime();
    d locald1 = c(paramBitmap, 3);
    m.nHb.bxk();
    long l2 = SystemClock.elapsedRealtime() - l1;
    y.d("MicroMsg.scanner.DecodeFile", "decode once time(ms):" + l2);
    if ((locald1 != null) && (!bk.bl(locald1.result)))
    {
      nm();
      return locald1;
    }
    l1 = l2;
    if (l2 == 0L) {
      l1 = 1L;
    }
    int j = (int)(2000L / l1) + 1;
    y.i("MicroMsg.scanner.DecodeFile", "max retry time: %s", new Object[] { Integer.valueOf(j) });
    int i = 1;
    for (;;)
    {
      d locald2 = locald1;
      if (i < j)
      {
        locald2 = locald1;
        if (!this.mCancelled)
        {
          int k = paramInt * i + 3;
          locald2 = locald1;
          if (k < paramBitmap.getWidth())
          {
            locald2 = locald1;
            if (k < paramBitmap.getHeight())
            {
              locald2 = locald1;
              if (System.currentTimeMillis() - this.njX <= 2000L)
              {
                locald1 = c(paramBitmap, k);
                m.nHb.bxk();
                if ((locald1 == null) || (bk.bl(locald1.result))) {
                  break label282;
                }
                y.d("MicroMsg.scanner.DecodeFile", "Decode file done, i = %d, max times = %d, width = %d, height = %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
                locald2 = locald1;
              }
            }
          }
        }
      }
      nm();
      return locald2;
      label282:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ad.a.a
 * JD-Core Version:    0.7.0.1
 */