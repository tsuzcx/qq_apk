import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.widgets.ScannerView;

public class cqx
  extends Handler
{
  public cqx(ScannerView paramScannerView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 30	android/os/Message:what	I
    //   4: tableswitch	default:+24 -> 28, 5:+25->29, 6:+1113->1117
    //   29: aload_0
    //   30: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   33: astore 16
    //   35: aload 16
    //   37: aload 16
    //   39: getfield 36	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Long	J
    //   42: lconst_1
    //   43: ladd
    //   44: putfield 36	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Long	J
    //   47: aload_1
    //   48: getfield 40	android/os/Message:obj	Ljava/lang/Object;
    //   51: ifnull +13 -> 64
    //   54: aload_1
    //   55: getfield 40	android/os/Message:obj	Ljava/lang/Object;
    //   58: instanceof 42
    //   61: ifne +16 -> 77
    //   64: aload_0
    //   65: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   68: getfield 45	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   71: iconst_2
    //   72: invokevirtual 49	android/os/Handler:sendEmptyMessage	(I)Z
    //   75: pop
    //   76: return
    //   77: aload_1
    //   78: getfield 40	android/os/Message:obj	Ljava/lang/Object;
    //   81: checkcast 42	[B
    //   84: checkcast 42	[B
    //   87: astore 17
    //   89: aload_0
    //   90: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   93: getfield 52	com/tencent/biz/widgets/ScannerView:u	I
    //   96: iconst_3
    //   97: if_icmpge +49 -> 146
    //   100: iconst_0
    //   101: istore 8
    //   103: aload 17
    //   105: arraylength
    //   106: istore 9
    //   108: iconst_0
    //   109: istore 6
    //   111: iload 8
    //   113: istore 7
    //   115: iload 6
    //   117: iload 9
    //   119: if_icmpge +14 -> 133
    //   122: aload 17
    //   124: iload 6
    //   126: baload
    //   127: ifeq +566 -> 693
    //   130: iconst_1
    //   131: istore 7
    //   133: iload 7
    //   135: ifeq +567 -> 702
    //   138: aload_0
    //   139: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   142: iconst_3
    //   143: putfield 52	com/tencent/biz/widgets/ScannerView:u	I
    //   146: aload_0
    //   147: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   150: getfield 55	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   153: astore_1
    //   154: aload_0
    //   155: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   158: getfield 57	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   161: astore 16
    //   163: aload_1
    //   164: ifnonnull +2634 -> 2798
    //   167: aload 16
    //   169: astore_1
    //   170: aload 16
    //   172: ifnonnull +39 -> 211
    //   175: aload_0
    //   176: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   179: astore 16
    //   181: new 59	android/graphics/Rect
    //   184: dup
    //   185: iconst_0
    //   186: iconst_0
    //   187: aload_0
    //   188: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   191: getfield 62	com/tencent/biz/widgets/ScannerView:r	I
    //   194: aload_0
    //   195: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   198: getfield 65	com/tencent/biz/widgets/ScannerView:s	I
    //   201: invokespecial 68	android/graphics/Rect:<init>	(IIII)V
    //   204: astore_1
    //   205: aload 16
    //   207: aload_1
    //   208: putfield 57	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   211: aload_0
    //   212: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   215: getfield 71	com/tencent/biz/widgets/ScannerView:t	I
    //   218: bipush 90
    //   220: if_icmpne +523 -> 743
    //   223: aload_0
    //   224: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   227: getfield 74	com/tencent/biz/widgets/ScannerView:n	I
    //   230: i2f
    //   231: aload_0
    //   232: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   235: getfield 65	com/tencent/biz/widgets/ScannerView:s	I
    //   238: i2f
    //   239: fdiv
    //   240: fstore 4
    //   242: aload_0
    //   243: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   246: getfield 77	com/tencent/biz/widgets/ScannerView:o	I
    //   249: i2f
    //   250: aload_0
    //   251: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   254: getfield 62	com/tencent/biz/widgets/ScannerView:r	I
    //   257: i2f
    //   258: fdiv
    //   259: fstore 5
    //   261: new 59	android/graphics/Rect
    //   264: dup
    //   265: aload_1
    //   266: getfield 80	android/graphics/Rect:top	I
    //   269: i2f
    //   270: fload 4
    //   272: fmul
    //   273: f2i
    //   274: aload_0
    //   275: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   278: getfield 62	com/tencent/biz/widgets/ScannerView:r	I
    //   281: aload_1
    //   282: getfield 83	android/graphics/Rect:right	I
    //   285: isub
    //   286: i2f
    //   287: fload 5
    //   289: fmul
    //   290: f2i
    //   291: fload 4
    //   293: aload_1
    //   294: getfield 86	android/graphics/Rect:bottom	I
    //   297: i2f
    //   298: fmul
    //   299: f2i
    //   300: aload_0
    //   301: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   304: getfield 62	com/tencent/biz/widgets/ScannerView:r	I
    //   307: aload_1
    //   308: getfield 89	android/graphics/Rect:left	I
    //   311: isub
    //   312: i2f
    //   313: fload 5
    //   315: fmul
    //   316: f2i
    //   317: invokespecial 68	android/graphics/Rect:<init>	(IIII)V
    //   320: astore_1
    //   321: aload_0
    //   322: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   325: aload_1
    //   326: putfield 55	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   329: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   332: lstore 14
    //   334: iconst_2
    //   335: newarray int
    //   337: astore 16
    //   339: aload_1
    //   340: invokevirtual 99	android/graphics/Rect:width	()I
    //   343: aload_1
    //   344: invokevirtual 102	android/graphics/Rect:height	()I
    //   347: imul
    //   348: iconst_3
    //   349: imul
    //   350: iconst_1
    //   351: ishr
    //   352: newarray byte
    //   354: astore 18
    //   356: aload_0
    //   357: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   360: getfield 74	com/tencent/biz/widgets/ScannerView:n	I
    //   363: ifle +2429 -> 2792
    //   366: aload_0
    //   367: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   370: getfield 77	com/tencent/biz/widgets/ScannerView:o	I
    //   373: ifle +2419 -> 2792
    //   376: aload_1
    //   377: getfield 89	android/graphics/Rect:left	I
    //   380: iflt +2412 -> 2792
    //   383: aload_1
    //   384: getfield 80	android/graphics/Rect:top	I
    //   387: iflt +2405 -> 2792
    //   390: aload_1
    //   391: invokevirtual 99	android/graphics/Rect:width	()I
    //   394: ifle +2398 -> 2792
    //   397: aload_1
    //   398: invokevirtual 102	android/graphics/Rect:height	()I
    //   401: ifle +2391 -> 2792
    //   404: aload_1
    //   405: getfield 83	android/graphics/Rect:right	I
    //   408: aload_0
    //   409: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   412: getfield 74	com/tencent/biz/widgets/ScannerView:n	I
    //   415: if_icmpgt +2377 -> 2792
    //   418: aload_1
    //   419: getfield 86	android/graphics/Rect:bottom	I
    //   422: aload_0
    //   423: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   426: getfield 77	com/tencent/biz/widgets/ScannerView:o	I
    //   429: if_icmpgt +2363 -> 2792
    //   432: aload 17
    //   434: arraylength
    //   435: aload_0
    //   436: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   439: getfield 74	com/tencent/biz/widgets/ScannerView:n	I
    //   442: aload_0
    //   443: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   446: getfield 77	com/tencent/biz/widgets/ScannerView:o	I
    //   449: imul
    //   450: iconst_3
    //   451: imul
    //   452: iconst_1
    //   453: ishr
    //   454: if_icmpne +2338 -> 2792
    //   457: aload 18
    //   459: aload 16
    //   461: aload 17
    //   463: aload_0
    //   464: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   467: getfield 74	com/tencent/biz/widgets/ScannerView:n	I
    //   470: aload_0
    //   471: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   474: getfield 77	com/tencent/biz/widgets/ScannerView:o	I
    //   477: aload_1
    //   478: getfield 89	android/graphics/Rect:left	I
    //   481: aload_1
    //   482: getfield 80	android/graphics/Rect:top	I
    //   485: aload_1
    //   486: invokevirtual 99	android/graphics/Rect:width	()I
    //   489: aload_1
    //   490: invokevirtual 102	android/graphics/Rect:height	()I
    //   493: aload_0
    //   494: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   497: getfield 71	com/tencent/biz/widgets/ScannerView:t	I
    //   500: iconst_0
    //   501: invokestatic 107	com/tencent/imageboost/ImgProcessScan:a	([B[I[BIIIIIIII)I
    //   504: iconst_1
    //   505: if_icmpne +2287 -> 2792
    //   508: aload 18
    //   510: aload 16
    //   512: iconst_0
    //   513: iaload
    //   514: aload 16
    //   516: iconst_1
    //   517: iaload
    //   518: iconst_0
    //   519: invokestatic 113	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   522: istore 6
    //   524: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   527: lload 14
    //   529: lsub
    //   530: l2d
    //   531: dstore_2
    //   532: iload 6
    //   534: istore 7
    //   536: invokestatic 119	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   539: ifeq +33 -> 572
    //   542: getstatic 122	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   545: iconst_4
    //   546: new 124	java/lang/StringBuilder
    //   549: dup
    //   550: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   553: ldc 129
    //   555: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: dload_2
    //   559: invokevirtual 136	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   562: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   565: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   568: iload 6
    //   570: istore 7
    //   572: iload 7
    //   574: iconst_1
    //   575: if_icmpne +529 -> 1104
    //   578: new 124	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   585: astore_1
    //   586: new 124	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   593: astore 16
    //   595: aload_1
    //   596: aload 16
    //   598: invokestatic 147	com/tencent/qbar/QbarNative:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   601: pop
    //   602: aconst_null
    //   603: ldc 149
    //   605: ldc 151
    //   607: ldc 153
    //   609: ldc 155
    //   611: ldc 157
    //   613: iconst_0
    //   614: iconst_0
    //   615: new 124	java/lang/StringBuilder
    //   618: dup
    //   619: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   622: ldc 153
    //   624: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: invokestatic 95	java/lang/System:currentTimeMillis	()J
    //   630: aload_0
    //   631: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   634: getfield 159	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Long	J
    //   637: lsub
    //   638: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   641: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: new 124	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   651: ldc 153
    //   653: invokevirtual 133	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: aload_0
    //   657: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   660: getfield 36	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Long	J
    //   663: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   666: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: ldc 153
    //   671: ldc 153
    //   673: invokestatic 167	com/tencent/mobileqq/statistics/ReportController:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   676: aload_0
    //   677: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   680: getfield 45	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   683: iconst_1
    //   684: aload 16
    //   686: invokevirtual 171	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   689: invokevirtual 174	android/os/Message:sendToTarget	()V
    //   692: return
    //   693: iload 6
    //   695: iconst_1
    //   696: iadd
    //   697: istore 6
    //   699: goto -588 -> 111
    //   702: aload_0
    //   703: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   706: astore_1
    //   707: aload_1
    //   708: getfield 52	com/tencent/biz/widgets/ScannerView:u	I
    //   711: iconst_1
    //   712: iadd
    //   713: istore 6
    //   715: aload_1
    //   716: iload 6
    //   718: putfield 52	com/tencent/biz/widgets/ScannerView:u	I
    //   721: iload 6
    //   723: iconst_3
    //   724: if_icmpne -578 -> 146
    //   727: aload_0
    //   728: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   731: getfield 45	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   734: bipush 9
    //   736: invokevirtual 49	android/os/Handler:sendEmptyMessage	(I)Z
    //   739: pop
    //   740: goto -594 -> 146
    //   743: aload_0
    //   744: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   747: getfield 71	com/tencent/biz/widgets/ScannerView:t	I
    //   750: sipush 180
    //   753: if_icmpne +120 -> 873
    //   756: aload_0
    //   757: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   760: getfield 74	com/tencent/biz/widgets/ScannerView:n	I
    //   763: i2f
    //   764: aload_0
    //   765: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   768: getfield 62	com/tencent/biz/widgets/ScannerView:r	I
    //   771: i2f
    //   772: fdiv
    //   773: fstore 4
    //   775: aload_0
    //   776: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   779: getfield 77	com/tencent/biz/widgets/ScannerView:o	I
    //   782: i2f
    //   783: aload_0
    //   784: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   787: getfield 65	com/tencent/biz/widgets/ScannerView:s	I
    //   790: i2f
    //   791: fdiv
    //   792: fstore 5
    //   794: new 59	android/graphics/Rect
    //   797: dup
    //   798: aload_0
    //   799: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   802: getfield 62	com/tencent/biz/widgets/ScannerView:r	I
    //   805: aload_1
    //   806: getfield 83	android/graphics/Rect:right	I
    //   809: isub
    //   810: i2f
    //   811: fload 4
    //   813: fmul
    //   814: f2i
    //   815: aload_0
    //   816: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   819: getfield 65	com/tencent/biz/widgets/ScannerView:s	I
    //   822: aload_1
    //   823: getfield 86	android/graphics/Rect:bottom	I
    //   826: isub
    //   827: i2f
    //   828: fload 5
    //   830: fmul
    //   831: f2i
    //   832: fload 4
    //   834: aload_0
    //   835: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   838: getfield 62	com/tencent/biz/widgets/ScannerView:r	I
    //   841: aload_1
    //   842: getfield 89	android/graphics/Rect:left	I
    //   845: isub
    //   846: i2f
    //   847: fmul
    //   848: f2i
    //   849: aload_0
    //   850: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   853: getfield 65	com/tencent/biz/widgets/ScannerView:s	I
    //   856: aload_1
    //   857: getfield 80	android/graphics/Rect:top	I
    //   860: isub
    //   861: i2f
    //   862: fload 5
    //   864: fmul
    //   865: f2i
    //   866: invokespecial 68	android/graphics/Rect:<init>	(IIII)V
    //   869: astore_1
    //   870: goto -549 -> 321
    //   873: aload_0
    //   874: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   877: getfield 71	com/tencent/biz/widgets/ScannerView:t	I
    //   880: sipush 270
    //   883: if_icmpne +104 -> 987
    //   886: aload_0
    //   887: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   890: getfield 74	com/tencent/biz/widgets/ScannerView:n	I
    //   893: i2f
    //   894: aload_0
    //   895: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   898: getfield 65	com/tencent/biz/widgets/ScannerView:s	I
    //   901: i2f
    //   902: fdiv
    //   903: fstore 4
    //   905: aload_0
    //   906: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   909: getfield 77	com/tencent/biz/widgets/ScannerView:o	I
    //   912: i2f
    //   913: aload_0
    //   914: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   917: getfield 62	com/tencent/biz/widgets/ScannerView:r	I
    //   920: i2f
    //   921: fdiv
    //   922: fstore 5
    //   924: new 59	android/graphics/Rect
    //   927: dup
    //   928: aload_0
    //   929: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   932: getfield 65	com/tencent/biz/widgets/ScannerView:s	I
    //   935: aload_1
    //   936: getfield 86	android/graphics/Rect:bottom	I
    //   939: isub
    //   940: i2f
    //   941: fload 4
    //   943: fmul
    //   944: f2i
    //   945: aload_1
    //   946: getfield 89	android/graphics/Rect:left	I
    //   949: i2f
    //   950: fload 5
    //   952: fmul
    //   953: f2i
    //   954: fload 4
    //   956: aload_0
    //   957: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   960: getfield 65	com/tencent/biz/widgets/ScannerView:s	I
    //   963: aload_1
    //   964: getfield 80	android/graphics/Rect:top	I
    //   967: isub
    //   968: i2f
    //   969: fmul
    //   970: f2i
    //   971: aload_1
    //   972: getfield 83	android/graphics/Rect:right	I
    //   975: i2f
    //   976: fload 5
    //   978: fmul
    //   979: f2i
    //   980: invokespecial 68	android/graphics/Rect:<init>	(IIII)V
    //   983: astore_1
    //   984: goto -663 -> 321
    //   987: aload_0
    //   988: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   991: getfield 74	com/tencent/biz/widgets/ScannerView:n	I
    //   994: i2f
    //   995: aload_0
    //   996: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   999: getfield 62	com/tencent/biz/widgets/ScannerView:r	I
    //   1002: i2f
    //   1003: fdiv
    //   1004: fstore 4
    //   1006: aload_0
    //   1007: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1010: getfield 77	com/tencent/biz/widgets/ScannerView:o	I
    //   1013: i2f
    //   1014: aload_0
    //   1015: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1018: getfield 65	com/tencent/biz/widgets/ScannerView:s	I
    //   1021: i2f
    //   1022: fdiv
    //   1023: fstore 5
    //   1025: new 59	android/graphics/Rect
    //   1028: dup
    //   1029: aload_1
    //   1030: getfield 89	android/graphics/Rect:left	I
    //   1033: i2f
    //   1034: fload 4
    //   1036: fmul
    //   1037: f2i
    //   1038: aload_1
    //   1039: getfield 80	android/graphics/Rect:top	I
    //   1042: i2f
    //   1043: fload 5
    //   1045: fmul
    //   1046: f2i
    //   1047: fload 4
    //   1049: aload_1
    //   1050: getfield 83	android/graphics/Rect:right	I
    //   1053: i2f
    //   1054: fmul
    //   1055: f2i
    //   1056: aload_1
    //   1057: getfield 86	android/graphics/Rect:bottom	I
    //   1060: i2f
    //   1061: fload 5
    //   1063: fmul
    //   1064: f2i
    //   1065: invokespecial 68	android/graphics/Rect:<init>	(IIII)V
    //   1068: astore_1
    //   1069: goto -748 -> 321
    //   1072: astore_1
    //   1073: iconst_0
    //   1074: istore 6
    //   1076: iload 6
    //   1078: istore 7
    //   1080: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1083: ifeq -511 -> 572
    //   1086: getstatic 122	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1089: iconst_2
    //   1090: aload_1
    //   1091: invokevirtual 178	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   1094: invokestatic 181	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1097: iload 6
    //   1099: istore 7
    //   1101: goto -529 -> 572
    //   1104: aload_0
    //   1105: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1108: getfield 45	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1111: iconst_2
    //   1112: invokevirtual 49	android/os/Handler:sendEmptyMessage	(I)Z
    //   1115: pop
    //   1116: return
    //   1117: iconst_m1
    //   1118: istore 6
    //   1120: iload 6
    //   1122: istore 7
    //   1124: iload 6
    //   1126: istore 8
    //   1128: iload 6
    //   1130: istore 9
    //   1132: aload_1
    //   1133: getfield 40	android/os/Message:obj	Ljava/lang/Object;
    //   1136: checkcast 183	android/net/Uri
    //   1139: astore 18
    //   1141: iload 6
    //   1143: istore 7
    //   1145: iload 6
    //   1147: istore 8
    //   1149: iload 6
    //   1151: istore 9
    //   1153: aload_0
    //   1154: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1157: invokevirtual 187	com/tencent/biz/widgets/ScannerView:getContext	()Landroid/content/Context;
    //   1160: invokevirtual 193	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1163: astore 19
    //   1165: iload 6
    //   1167: istore 7
    //   1169: iload 6
    //   1171: istore 8
    //   1173: iload 6
    //   1175: istore 9
    //   1177: new 195	android/graphics/BitmapFactory$Options
    //   1180: dup
    //   1181: invokespecial 196	android/graphics/BitmapFactory$Options:<init>	()V
    //   1184: astore 17
    //   1186: iload 6
    //   1188: istore 7
    //   1190: iload 6
    //   1192: istore 8
    //   1194: iload 6
    //   1196: istore 9
    //   1198: aload 17
    //   1200: iconst_1
    //   1201: putfield 200	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1204: iload 6
    //   1206: istore 7
    //   1208: iload 6
    //   1210: istore 8
    //   1212: iload 6
    //   1214: istore 9
    //   1216: aload 19
    //   1218: aload 18
    //   1220: invokevirtual 206	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1223: astore 16
    //   1225: iload 6
    //   1227: istore 7
    //   1229: iload 6
    //   1231: istore 8
    //   1233: iload 6
    //   1235: istore 9
    //   1237: aload 16
    //   1239: aconst_null
    //   1240: aload 17
    //   1242: invokestatic 212	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1245: pop
    //   1246: iload 6
    //   1248: istore 7
    //   1250: iload 6
    //   1252: istore 8
    //   1254: iload 6
    //   1256: istore 9
    //   1258: aload 16
    //   1260: invokevirtual 217	java/io/InputStream:close	()V
    //   1263: iload 6
    //   1265: istore 7
    //   1267: iload 6
    //   1269: istore 8
    //   1271: iload 6
    //   1273: istore 9
    //   1275: aload 17
    //   1277: getfield 220	android/graphics/BitmapFactory$Options:outWidth	I
    //   1280: istore 12
    //   1282: iload 6
    //   1284: istore 7
    //   1286: iload 6
    //   1288: istore 8
    //   1290: iload 6
    //   1292: istore 9
    //   1294: aload 17
    //   1296: getfield 223	android/graphics/BitmapFactory$Options:outHeight	I
    //   1299: istore 13
    //   1301: iload 6
    //   1303: istore 7
    //   1305: iload 6
    //   1307: istore 8
    //   1309: iload 6
    //   1311: istore 9
    //   1313: aload 17
    //   1315: iconst_0
    //   1316: putfield 200	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   1319: iload 12
    //   1321: iload 13
    //   1323: imul
    //   1324: ldc 224
    //   1326: if_icmple +806 -> 2132
    //   1329: iload 6
    //   1331: istore 7
    //   1333: iload 6
    //   1335: istore 8
    //   1337: iload 6
    //   1339: istore 9
    //   1341: aload 17
    //   1343: iload 12
    //   1345: iload 13
    //   1347: imul
    //   1348: i2d
    //   1349: invokestatic 230	java/lang/Math:sqrt	(D)D
    //   1352: ldc2_w 231
    //   1355: ddiv
    //   1356: invokestatic 235	java/lang/Math:ceil	(D)D
    //   1359: d2i
    //   1360: putfield 238	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1363: iload 6
    //   1365: istore 7
    //   1367: iload 6
    //   1369: istore 8
    //   1371: iload 6
    //   1373: istore 9
    //   1375: aload 19
    //   1377: aload 18
    //   1379: invokevirtual 206	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1382: astore_1
    //   1383: iload 6
    //   1385: istore 7
    //   1387: iload 6
    //   1389: istore 8
    //   1391: iload 6
    //   1393: istore 9
    //   1395: aload_1
    //   1396: aconst_null
    //   1397: aload 17
    //   1399: invokestatic 212	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1402: astore 20
    //   1404: iload 6
    //   1406: istore 7
    //   1408: iload 6
    //   1410: istore 8
    //   1412: iload 6
    //   1414: istore 9
    //   1416: aload_1
    //   1417: invokevirtual 217	java/io/InputStream:close	()V
    //   1420: iload 6
    //   1422: istore 7
    //   1424: iload 6
    //   1426: istore 8
    //   1428: iload 6
    //   1430: istore 9
    //   1432: aload 20
    //   1434: invokevirtual 243	android/graphics/Bitmap:getWidth	()I
    //   1437: istore 10
    //   1439: iload 6
    //   1441: istore 7
    //   1443: iload 6
    //   1445: istore 8
    //   1447: iload 6
    //   1449: istore 9
    //   1451: aload 20
    //   1453: invokevirtual 246	android/graphics/Bitmap:getHeight	()I
    //   1456: istore 11
    //   1458: iload 6
    //   1460: istore 7
    //   1462: iload 6
    //   1464: istore 8
    //   1466: iload 6
    //   1468: istore 9
    //   1470: iload 10
    //   1472: iload 11
    //   1474: imul
    //   1475: newarray int
    //   1477: astore 16
    //   1479: iload 6
    //   1481: istore 7
    //   1483: iload 6
    //   1485: istore 8
    //   1487: iload 6
    //   1489: istore 9
    //   1491: aload 20
    //   1493: aload 16
    //   1495: iconst_0
    //   1496: iload 10
    //   1498: iconst_0
    //   1499: iconst_0
    //   1500: iload 10
    //   1502: iload 11
    //   1504: invokevirtual 250	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1507: iload 6
    //   1509: istore 7
    //   1511: iload 6
    //   1513: istore 8
    //   1515: iload 6
    //   1517: istore 9
    //   1519: aload 20
    //   1521: invokevirtual 253	android/graphics/Bitmap:recycle	()V
    //   1524: iload 6
    //   1526: istore 7
    //   1528: iload 6
    //   1530: istore 8
    //   1532: iload 6
    //   1534: istore 9
    //   1536: iload 10
    //   1538: iload 11
    //   1540: imul
    //   1541: newarray byte
    //   1543: astore 20
    //   1545: iload 6
    //   1547: istore 7
    //   1549: iload 6
    //   1551: istore 8
    //   1553: iload 6
    //   1555: istore 9
    //   1557: aload 16
    //   1559: aload 20
    //   1561: iload 10
    //   1563: iload 11
    //   1565: invokestatic 256	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   1568: pop
    //   1569: iload 6
    //   1571: istore 7
    //   1573: iload 6
    //   1575: istore 8
    //   1577: iload 6
    //   1579: istore 9
    //   1581: aload 20
    //   1583: iload 10
    //   1585: iload 11
    //   1587: iconst_0
    //   1588: invokestatic 113	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   1591: istore 10
    //   1593: iload 10
    //   1595: istore 6
    //   1597: aload_1
    //   1598: astore 16
    //   1600: iload 6
    //   1602: istore 7
    //   1604: iload 6
    //   1606: iconst_1
    //   1607: if_icmpeq +1032 -> 2639
    //   1610: iload 12
    //   1612: iconst_2
    //   1613: imul
    //   1614: iload 13
    //   1616: if_icmpgt +639 -> 2255
    //   1619: iload 12
    //   1621: sipush 1024
    //   1624: if_icmpge +631 -> 2255
    //   1627: iload 6
    //   1629: istore 7
    //   1631: iload 6
    //   1633: istore 8
    //   1635: iload 6
    //   1637: istore 9
    //   1639: aload 19
    //   1641: aload 18
    //   1643: invokevirtual 206	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1646: astore 16
    //   1648: iload 6
    //   1650: istore 7
    //   1652: iload 6
    //   1654: istore 8
    //   1656: iload 6
    //   1658: istore 9
    //   1660: iload 6
    //   1662: istore 10
    //   1664: aload 16
    //   1666: invokestatic 259	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   1669: astore_1
    //   1670: iload 6
    //   1672: istore 7
    //   1674: iload 6
    //   1676: istore 8
    //   1678: iload 6
    //   1680: istore 9
    //   1682: iload 6
    //   1684: istore 10
    //   1686: aload 16
    //   1688: invokevirtual 217	java/io/InputStream:close	()V
    //   1691: iload 6
    //   1693: istore 7
    //   1695: iload 6
    //   1697: istore 8
    //   1699: iload 6
    //   1701: istore 9
    //   1703: iload 6
    //   1705: istore 10
    //   1707: iload 12
    //   1709: iload 12
    //   1711: imul
    //   1712: newarray int
    //   1714: astore 20
    //   1716: iload 6
    //   1718: istore 7
    //   1720: iload 6
    //   1722: istore 8
    //   1724: iload 6
    //   1726: istore 9
    //   1728: iload 6
    //   1730: istore 10
    //   1732: aload_1
    //   1733: aload 20
    //   1735: iconst_0
    //   1736: iload 12
    //   1738: iconst_0
    //   1739: iconst_0
    //   1740: iload 12
    //   1742: iload 12
    //   1744: invokevirtual 250	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1747: iload 6
    //   1749: istore 7
    //   1751: iload 6
    //   1753: istore 8
    //   1755: iload 6
    //   1757: istore 9
    //   1759: iload 6
    //   1761: istore 10
    //   1763: iload 12
    //   1765: iload 12
    //   1767: imul
    //   1768: newarray byte
    //   1770: astore 21
    //   1772: iload 6
    //   1774: istore 7
    //   1776: iload 6
    //   1778: istore 8
    //   1780: iload 6
    //   1782: istore 9
    //   1784: iload 6
    //   1786: istore 10
    //   1788: aload 20
    //   1790: aload 21
    //   1792: iload 12
    //   1794: iload 12
    //   1796: invokestatic 256	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   1799: pop
    //   1800: iload 6
    //   1802: istore 7
    //   1804: iload 6
    //   1806: istore 8
    //   1808: iload 6
    //   1810: istore 9
    //   1812: iload 6
    //   1814: istore 10
    //   1816: aload 21
    //   1818: iload 12
    //   1820: iload 12
    //   1822: iconst_0
    //   1823: invokestatic 113	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   1826: istore 6
    //   1828: iload 6
    //   1830: iconst_1
    //   1831: if_icmpeq +958 -> 2789
    //   1834: iload 6
    //   1836: istore 7
    //   1838: iload 6
    //   1840: istore 8
    //   1842: iload 6
    //   1844: istore 9
    //   1846: iload 6
    //   1848: istore 10
    //   1850: aload_1
    //   1851: aload 20
    //   1853: iconst_0
    //   1854: iload 12
    //   1856: iconst_0
    //   1857: iload 13
    //   1859: iload 12
    //   1861: isub
    //   1862: iload 12
    //   1864: iload 12
    //   1866: invokevirtual 250	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   1869: iload 6
    //   1871: istore 7
    //   1873: iload 6
    //   1875: istore 8
    //   1877: iload 6
    //   1879: istore 9
    //   1881: iload 6
    //   1883: istore 10
    //   1885: aload 20
    //   1887: aload 21
    //   1889: iload 12
    //   1891: iload 12
    //   1893: invokestatic 256	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   1896: pop
    //   1897: iload 6
    //   1899: istore 7
    //   1901: iload 6
    //   1903: istore 8
    //   1905: iload 6
    //   1907: istore 9
    //   1909: iload 6
    //   1911: istore 10
    //   1913: aload 21
    //   1915: iload 12
    //   1917: iload 12
    //   1919: iconst_0
    //   1920: invokestatic 113	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   1923: istore 6
    //   1925: iload 6
    //   1927: istore 7
    //   1929: iload 6
    //   1931: istore 8
    //   1933: iload 6
    //   1935: istore 9
    //   1937: aload_1
    //   1938: invokevirtual 253	android/graphics/Bitmap:recycle	()V
    //   1941: aload 16
    //   1943: astore_1
    //   1944: iload 6
    //   1946: iconst_1
    //   1947: if_icmpeq +708 -> 2655
    //   1950: iload 12
    //   1952: iload 13
    //   1954: invokestatic 263	java/lang/Math:min	(II)I
    //   1957: istore 7
    //   1959: iload 7
    //   1961: sipush 250
    //   1964: if_icmple +691 -> 2655
    //   1967: aload 17
    //   1969: iload 7
    //   1971: i2d
    //   1972: ldc2_w 264
    //   1975: ddiv
    //   1976: invokestatic 235	java/lang/Math:ceil	(D)D
    //   1979: d2i
    //   1980: putfield 238	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   1983: aload 19
    //   1985: aload 18
    //   1987: invokevirtual 206	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   1990: astore 16
    //   1992: aload 16
    //   1994: aconst_null
    //   1995: aload 17
    //   1997: invokestatic 212	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   2000: astore 17
    //   2002: aload 16
    //   2004: invokevirtual 217	java/io/InputStream:close	()V
    //   2007: aload 17
    //   2009: invokevirtual 243	android/graphics/Bitmap:getWidth	()I
    //   2012: istore 7
    //   2014: aload 17
    //   2016: invokevirtual 246	android/graphics/Bitmap:getHeight	()I
    //   2019: istore 8
    //   2021: iload 7
    //   2023: iload 8
    //   2025: imul
    //   2026: newarray int
    //   2028: astore_1
    //   2029: aload 17
    //   2031: aload_1
    //   2032: iconst_0
    //   2033: iload 7
    //   2035: iconst_0
    //   2036: iconst_0
    //   2037: iload 7
    //   2039: iload 8
    //   2041: invokevirtual 250	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2044: aload 17
    //   2046: invokevirtual 253	android/graphics/Bitmap:recycle	()V
    //   2049: iload 7
    //   2051: iload 8
    //   2053: imul
    //   2054: newarray byte
    //   2056: astore 17
    //   2058: aload_1
    //   2059: aload 17
    //   2061: iload 7
    //   2063: iload 8
    //   2065: invokestatic 256	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   2068: pop
    //   2069: aload 17
    //   2071: iload 7
    //   2073: iload 8
    //   2075: iconst_0
    //   2076: invokestatic 113	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   2079: istore 7
    //   2081: iload 7
    //   2083: istore 6
    //   2085: iload 6
    //   2087: iconst_1
    //   2088: if_icmpne +599 -> 2687
    //   2091: new 124	java/lang/StringBuilder
    //   2094: dup
    //   2095: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2098: astore_1
    //   2099: new 124	java/lang/StringBuilder
    //   2102: dup
    //   2103: invokespecial 127	java/lang/StringBuilder:<init>	()V
    //   2106: astore 16
    //   2108: aload_1
    //   2109: aload 16
    //   2111: invokestatic 147	com/tencent/qbar/QbarNative:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   2114: pop
    //   2115: aload_0
    //   2116: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   2119: getfield 45	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   2122: iconst_3
    //   2123: aload 16
    //   2125: invokevirtual 171	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   2128: invokevirtual 174	android/os/Message:sendToTarget	()V
    //   2131: return
    //   2132: iload 6
    //   2134: istore 7
    //   2136: iload 6
    //   2138: istore 8
    //   2140: iload 6
    //   2142: istore 9
    //   2144: aload 17
    //   2146: iconst_1
    //   2147: putfield 238	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   2150: goto -787 -> 1363
    //   2153: astore_1
    //   2154: iload 7
    //   2156: istore 6
    //   2158: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2161: ifeq -76 -> 2085
    //   2164: getstatic 122	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2167: iconst_2
    //   2168: aload_1
    //   2169: invokevirtual 266	java/io/IOException:toString	()Ljava/lang/String;
    //   2172: invokestatic 181	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2175: iload 7
    //   2177: istore 6
    //   2179: goto -94 -> 2085
    //   2182: astore_1
    //   2183: aload 16
    //   2185: astore_1
    //   2186: iload 6
    //   2188: istore 7
    //   2190: iload 6
    //   2192: istore 8
    //   2194: iload 6
    //   2196: istore 9
    //   2198: aload_1
    //   2199: invokevirtual 217	java/io/InputStream:close	()V
    //   2202: goto -605 -> 1597
    //   2205: astore_1
    //   2206: iload 8
    //   2208: istore 6
    //   2210: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2213: ifeq -128 -> 2085
    //   2216: getstatic 122	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2219: iconst_2
    //   2220: aload_1
    //   2221: invokevirtual 267	java/lang/RuntimeException:toString	()Ljava/lang/String;
    //   2224: invokestatic 181	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2227: iload 8
    //   2229: istore 6
    //   2231: goto -146 -> 2085
    //   2234: astore 16
    //   2236: iload 6
    //   2238: istore 7
    //   2240: iload 6
    //   2242: istore 8
    //   2244: iload 6
    //   2246: istore 9
    //   2248: aload_1
    //   2249: invokevirtual 217	java/io/InputStream:close	()V
    //   2252: goto -308 -> 1944
    //   2255: aload_1
    //   2256: astore 16
    //   2258: iload 6
    //   2260: istore 7
    //   2262: iload 12
    //   2264: iload 13
    //   2266: iconst_2
    //   2267: imul
    //   2268: if_icmplt +371 -> 2639
    //   2271: aload_1
    //   2272: astore 16
    //   2274: iload 6
    //   2276: istore 7
    //   2278: iload 13
    //   2280: sipush 1024
    //   2283: if_icmpge +356 -> 2639
    //   2286: iload 6
    //   2288: istore 7
    //   2290: iload 6
    //   2292: istore 8
    //   2294: iload 6
    //   2296: istore 9
    //   2298: aload 19
    //   2300: aload 18
    //   2302: invokevirtual 206	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   2305: astore 16
    //   2307: iload 6
    //   2309: istore 7
    //   2311: iload 6
    //   2313: istore 8
    //   2315: iload 6
    //   2317: istore 9
    //   2319: iload 6
    //   2321: istore 11
    //   2323: aload 16
    //   2325: invokestatic 259	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    //   2328: astore_1
    //   2329: iload 6
    //   2331: istore 7
    //   2333: iload 6
    //   2335: istore 8
    //   2337: iload 6
    //   2339: istore 9
    //   2341: iload 6
    //   2343: istore 11
    //   2345: aload 16
    //   2347: invokevirtual 217	java/io/InputStream:close	()V
    //   2350: iload 6
    //   2352: istore 7
    //   2354: iload 6
    //   2356: istore 8
    //   2358: iload 6
    //   2360: istore 9
    //   2362: iload 6
    //   2364: istore 11
    //   2366: iload 13
    //   2368: iload 13
    //   2370: imul
    //   2371: newarray int
    //   2373: astore 20
    //   2375: iload 6
    //   2377: istore 7
    //   2379: iload 6
    //   2381: istore 8
    //   2383: iload 6
    //   2385: istore 9
    //   2387: iload 6
    //   2389: istore 11
    //   2391: aload_1
    //   2392: aload 20
    //   2394: iconst_0
    //   2395: iload 13
    //   2397: iconst_0
    //   2398: iconst_0
    //   2399: iload 13
    //   2401: iload 13
    //   2403: invokevirtual 250	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2406: iload 6
    //   2408: istore 7
    //   2410: iload 6
    //   2412: istore 8
    //   2414: iload 6
    //   2416: istore 9
    //   2418: iload 6
    //   2420: istore 11
    //   2422: iload 13
    //   2424: iload 13
    //   2426: imul
    //   2427: newarray byte
    //   2429: astore 21
    //   2431: iload 6
    //   2433: istore 7
    //   2435: iload 6
    //   2437: istore 8
    //   2439: iload 6
    //   2441: istore 9
    //   2443: iload 6
    //   2445: istore 11
    //   2447: aload 20
    //   2449: aload 21
    //   2451: iload 13
    //   2453: iload 13
    //   2455: invokestatic 256	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   2458: pop
    //   2459: iload 6
    //   2461: istore 7
    //   2463: iload 6
    //   2465: istore 8
    //   2467: iload 6
    //   2469: istore 9
    //   2471: iload 6
    //   2473: istore 11
    //   2475: aload 21
    //   2477: iload 13
    //   2479: iload 13
    //   2481: iconst_0
    //   2482: invokestatic 113	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   2485: istore 10
    //   2487: iload 10
    //   2489: istore 6
    //   2491: iload 10
    //   2493: iconst_1
    //   2494: if_icmpeq +94 -> 2588
    //   2497: iload 10
    //   2499: istore 7
    //   2501: iload 10
    //   2503: istore 8
    //   2505: iload 10
    //   2507: istore 9
    //   2509: iload 10
    //   2511: istore 11
    //   2513: aload_1
    //   2514: aload 20
    //   2516: iconst_0
    //   2517: iload 13
    //   2519: iload 12
    //   2521: iload 13
    //   2523: isub
    //   2524: iconst_0
    //   2525: iload 13
    //   2527: iload 13
    //   2529: invokevirtual 250	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   2532: iload 10
    //   2534: istore 7
    //   2536: iload 10
    //   2538: istore 8
    //   2540: iload 10
    //   2542: istore 9
    //   2544: iload 10
    //   2546: istore 11
    //   2548: aload 20
    //   2550: aload 21
    //   2552: iload 13
    //   2554: iload 13
    //   2556: invokestatic 256	com/tencent/imageboost/ImgProcessScan:b	([I[BII)I
    //   2559: pop
    //   2560: iload 10
    //   2562: istore 7
    //   2564: iload 10
    //   2566: istore 8
    //   2568: iload 10
    //   2570: istore 9
    //   2572: iload 10
    //   2574: istore 11
    //   2576: aload 21
    //   2578: iload 13
    //   2580: iload 13
    //   2582: iconst_0
    //   2583: invokestatic 113	com/tencent/qbar/QbarNative:ScanImage	([BIII)I
    //   2586: istore 6
    //   2588: iload 6
    //   2590: istore 7
    //   2592: iload 6
    //   2594: istore 8
    //   2596: iload 6
    //   2598: istore 9
    //   2600: iload 6
    //   2602: istore 11
    //   2604: aload_1
    //   2605: invokevirtual 253	android/graphics/Bitmap:recycle	()V
    //   2608: aload 16
    //   2610: astore_1
    //   2611: goto -667 -> 1944
    //   2614: astore 16
    //   2616: iload 6
    //   2618: istore 7
    //   2620: iload 6
    //   2622: istore 8
    //   2624: iload 6
    //   2626: istore 9
    //   2628: aload_1
    //   2629: invokevirtual 217	java/io/InputStream:close	()V
    //   2632: iload 6
    //   2634: istore 7
    //   2636: aload_1
    //   2637: astore 16
    //   2639: iload 7
    //   2641: istore 6
    //   2643: aload 16
    //   2645: astore_1
    //   2646: goto -702 -> 1944
    //   2649: astore 16
    //   2651: aload_1
    //   2652: invokevirtual 217	java/io/InputStream:close	()V
    //   2655: goto -570 -> 2085
    //   2658: astore_1
    //   2659: iload 9
    //   2661: istore 6
    //   2663: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2666: ifeq -581 -> 2085
    //   2669: getstatic 122	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2672: iconst_2
    //   2673: aload_1
    //   2674: invokevirtual 178	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   2677: invokestatic 181	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2680: iload 9
    //   2682: istore 6
    //   2684: goto -599 -> 2085
    //   2687: aload_0
    //   2688: getfield 10	cqx:a	Lcom/tencent/biz/widgets/ScannerView;
    //   2691: getfield 45	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   2694: iconst_4
    //   2695: invokevirtual 49	android/os/Handler:sendEmptyMessage	(I)Z
    //   2698: pop
    //   2699: return
    //   2700: astore_1
    //   2701: iload 7
    //   2703: istore 9
    //   2705: goto -46 -> 2659
    //   2708: astore_1
    //   2709: iload 6
    //   2711: istore 9
    //   2713: goto -54 -> 2659
    //   2716: astore_1
    //   2717: goto -511 -> 2206
    //   2720: astore_1
    //   2721: iload 6
    //   2723: istore 8
    //   2725: goto -519 -> 2206
    //   2728: astore_1
    //   2729: iload 9
    //   2731: istore 7
    //   2733: goto -579 -> 2154
    //   2736: astore_1
    //   2737: iload 6
    //   2739: istore 7
    //   2741: goto -587 -> 2154
    //   2744: astore_1
    //   2745: aload 16
    //   2747: astore_1
    //   2748: goto -97 -> 2651
    //   2751: astore_1
    //   2752: aload 16
    //   2754: astore_1
    //   2755: iload 11
    //   2757: istore 6
    //   2759: goto -143 -> 2616
    //   2762: astore_1
    //   2763: aload 16
    //   2765: astore_1
    //   2766: iload 10
    //   2768: istore 6
    //   2770: goto -534 -> 2236
    //   2773: astore_1
    //   2774: aload 16
    //   2776: astore_1
    //   2777: goto -541 -> 2236
    //   2780: astore 16
    //   2782: goto -596 -> 2186
    //   2785: astore_1
    //   2786: goto -1710 -> 1076
    //   2789: goto -864 -> 1925
    //   2792: iconst_0
    //   2793: istore 6
    //   2795: goto -2271 -> 524
    //   2798: goto -2469 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2801	0	this	cqx
    //   0	2801	1	paramMessage	android.os.Message
    //   531	28	2	d	double
    //   240	808	4	f1	float
    //   259	803	5	f2	float
    //   109	2685	6	i	int
    //   113	2627	7	j	int
    //   101	2623	8	k	int
    //   106	2624	9	m	int
    //   1437	1330	10	n	int
    //   1456	1300	11	i1	int
    //   1280	1244	12	i2	int
    //   1299	1282	13	i3	int
    //   332	196	14	l	long
    //   33	2151	16	localObject1	java.lang.Object
    //   2234	1	16	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   2256	353	16	localObject2	java.lang.Object
    //   2614	1	16	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   2637	7	16	localMessage	android.os.Message
    //   2649	126	16	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   2780	1	16	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   87	2058	17	localObject3	java.lang.Object
    //   354	1947	18	localObject4	java.lang.Object
    //   1163	1136	19	localContentResolver	android.content.ContentResolver
    //   1402	1147	20	localObject5	java.lang.Object
    //   1770	807	21	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   329	524	1072	java/lang/UnsatisfiedLinkError
    //   1132	1141	2153	java/io/IOException
    //   1153	1165	2153	java/io/IOException
    //   1177	1186	2153	java/io/IOException
    //   1198	1204	2153	java/io/IOException
    //   1216	1225	2153	java/io/IOException
    //   1237	1246	2153	java/io/IOException
    //   1258	1263	2153	java/io/IOException
    //   1275	1282	2153	java/io/IOException
    //   1294	1301	2153	java/io/IOException
    //   1313	1319	2153	java/io/IOException
    //   1341	1363	2153	java/io/IOException
    //   1375	1383	2153	java/io/IOException
    //   1395	1404	2153	java/io/IOException
    //   1416	1420	2153	java/io/IOException
    //   1432	1439	2153	java/io/IOException
    //   1451	1458	2153	java/io/IOException
    //   1470	1479	2153	java/io/IOException
    //   1491	1507	2153	java/io/IOException
    //   1519	1524	2153	java/io/IOException
    //   1536	1545	2153	java/io/IOException
    //   1557	1569	2153	java/io/IOException
    //   1581	1593	2153	java/io/IOException
    //   1639	1648	2153	java/io/IOException
    //   1664	1670	2153	java/io/IOException
    //   1686	1691	2153	java/io/IOException
    //   1707	1716	2153	java/io/IOException
    //   1732	1747	2153	java/io/IOException
    //   1763	1772	2153	java/io/IOException
    //   1788	1800	2153	java/io/IOException
    //   1816	1828	2153	java/io/IOException
    //   1850	1869	2153	java/io/IOException
    //   1885	1897	2153	java/io/IOException
    //   1913	1925	2153	java/io/IOException
    //   2144	2150	2153	java/io/IOException
    //   2198	2202	2153	java/io/IOException
    //   2298	2307	2153	java/io/IOException
    //   2323	2329	2153	java/io/IOException
    //   2345	2350	2153	java/io/IOException
    //   2366	2375	2153	java/io/IOException
    //   2391	2406	2153	java/io/IOException
    //   2422	2431	2153	java/io/IOException
    //   2447	2459	2153	java/io/IOException
    //   2475	2487	2153	java/io/IOException
    //   2513	2532	2153	java/io/IOException
    //   2548	2560	2153	java/io/IOException
    //   2576	2588	2153	java/io/IOException
    //   2604	2608	2153	java/io/IOException
    //   2628	2632	2153	java/io/IOException
    //   1375	1383	2182	java/lang/OutOfMemoryError
    //   1132	1141	2205	java/lang/RuntimeException
    //   1153	1165	2205	java/lang/RuntimeException
    //   1177	1186	2205	java/lang/RuntimeException
    //   1198	1204	2205	java/lang/RuntimeException
    //   1216	1225	2205	java/lang/RuntimeException
    //   1237	1246	2205	java/lang/RuntimeException
    //   1258	1263	2205	java/lang/RuntimeException
    //   1275	1282	2205	java/lang/RuntimeException
    //   1294	1301	2205	java/lang/RuntimeException
    //   1313	1319	2205	java/lang/RuntimeException
    //   1341	1363	2205	java/lang/RuntimeException
    //   1375	1383	2205	java/lang/RuntimeException
    //   1395	1404	2205	java/lang/RuntimeException
    //   1416	1420	2205	java/lang/RuntimeException
    //   1432	1439	2205	java/lang/RuntimeException
    //   1451	1458	2205	java/lang/RuntimeException
    //   1470	1479	2205	java/lang/RuntimeException
    //   1491	1507	2205	java/lang/RuntimeException
    //   1519	1524	2205	java/lang/RuntimeException
    //   1536	1545	2205	java/lang/RuntimeException
    //   1557	1569	2205	java/lang/RuntimeException
    //   1581	1593	2205	java/lang/RuntimeException
    //   1639	1648	2205	java/lang/RuntimeException
    //   1664	1670	2205	java/lang/RuntimeException
    //   1686	1691	2205	java/lang/RuntimeException
    //   1707	1716	2205	java/lang/RuntimeException
    //   1732	1747	2205	java/lang/RuntimeException
    //   1763	1772	2205	java/lang/RuntimeException
    //   1788	1800	2205	java/lang/RuntimeException
    //   1816	1828	2205	java/lang/RuntimeException
    //   1850	1869	2205	java/lang/RuntimeException
    //   1885	1897	2205	java/lang/RuntimeException
    //   1913	1925	2205	java/lang/RuntimeException
    //   2144	2150	2205	java/lang/RuntimeException
    //   2198	2202	2205	java/lang/RuntimeException
    //   2298	2307	2205	java/lang/RuntimeException
    //   2323	2329	2205	java/lang/RuntimeException
    //   2345	2350	2205	java/lang/RuntimeException
    //   2366	2375	2205	java/lang/RuntimeException
    //   2391	2406	2205	java/lang/RuntimeException
    //   2422	2431	2205	java/lang/RuntimeException
    //   2447	2459	2205	java/lang/RuntimeException
    //   2475	2487	2205	java/lang/RuntimeException
    //   2513	2532	2205	java/lang/RuntimeException
    //   2548	2560	2205	java/lang/RuntimeException
    //   2576	2588	2205	java/lang/RuntimeException
    //   2604	2608	2205	java/lang/RuntimeException
    //   2628	2632	2205	java/lang/RuntimeException
    //   1639	1648	2234	java/lang/OutOfMemoryError
    //   2298	2307	2614	java/lang/OutOfMemoryError
    //   1983	1992	2649	java/lang/OutOfMemoryError
    //   1132	1141	2658	java/lang/UnsatisfiedLinkError
    //   1153	1165	2658	java/lang/UnsatisfiedLinkError
    //   1177	1186	2658	java/lang/UnsatisfiedLinkError
    //   1198	1204	2658	java/lang/UnsatisfiedLinkError
    //   1216	1225	2658	java/lang/UnsatisfiedLinkError
    //   1237	1246	2658	java/lang/UnsatisfiedLinkError
    //   1258	1263	2658	java/lang/UnsatisfiedLinkError
    //   1275	1282	2658	java/lang/UnsatisfiedLinkError
    //   1294	1301	2658	java/lang/UnsatisfiedLinkError
    //   1313	1319	2658	java/lang/UnsatisfiedLinkError
    //   1341	1363	2658	java/lang/UnsatisfiedLinkError
    //   1375	1383	2658	java/lang/UnsatisfiedLinkError
    //   1395	1404	2658	java/lang/UnsatisfiedLinkError
    //   1416	1420	2658	java/lang/UnsatisfiedLinkError
    //   1432	1439	2658	java/lang/UnsatisfiedLinkError
    //   1451	1458	2658	java/lang/UnsatisfiedLinkError
    //   1470	1479	2658	java/lang/UnsatisfiedLinkError
    //   1491	1507	2658	java/lang/UnsatisfiedLinkError
    //   1519	1524	2658	java/lang/UnsatisfiedLinkError
    //   1536	1545	2658	java/lang/UnsatisfiedLinkError
    //   1557	1569	2658	java/lang/UnsatisfiedLinkError
    //   1581	1593	2658	java/lang/UnsatisfiedLinkError
    //   1639	1648	2658	java/lang/UnsatisfiedLinkError
    //   1664	1670	2658	java/lang/UnsatisfiedLinkError
    //   1686	1691	2658	java/lang/UnsatisfiedLinkError
    //   1707	1716	2658	java/lang/UnsatisfiedLinkError
    //   1732	1747	2658	java/lang/UnsatisfiedLinkError
    //   1763	1772	2658	java/lang/UnsatisfiedLinkError
    //   1788	1800	2658	java/lang/UnsatisfiedLinkError
    //   1816	1828	2658	java/lang/UnsatisfiedLinkError
    //   1850	1869	2658	java/lang/UnsatisfiedLinkError
    //   1885	1897	2658	java/lang/UnsatisfiedLinkError
    //   1913	1925	2658	java/lang/UnsatisfiedLinkError
    //   2144	2150	2658	java/lang/UnsatisfiedLinkError
    //   2198	2202	2658	java/lang/UnsatisfiedLinkError
    //   2298	2307	2658	java/lang/UnsatisfiedLinkError
    //   2323	2329	2658	java/lang/UnsatisfiedLinkError
    //   2345	2350	2658	java/lang/UnsatisfiedLinkError
    //   2366	2375	2658	java/lang/UnsatisfiedLinkError
    //   2391	2406	2658	java/lang/UnsatisfiedLinkError
    //   2422	2431	2658	java/lang/UnsatisfiedLinkError
    //   2447	2459	2658	java/lang/UnsatisfiedLinkError
    //   2475	2487	2658	java/lang/UnsatisfiedLinkError
    //   2513	2532	2658	java/lang/UnsatisfiedLinkError
    //   2548	2560	2658	java/lang/UnsatisfiedLinkError
    //   2576	2588	2658	java/lang/UnsatisfiedLinkError
    //   2604	2608	2658	java/lang/UnsatisfiedLinkError
    //   2628	2632	2658	java/lang/UnsatisfiedLinkError
    //   1937	1941	2700	java/lang/UnsatisfiedLinkError
    //   2248	2252	2700	java/lang/UnsatisfiedLinkError
    //   1950	1959	2708	java/lang/UnsatisfiedLinkError
    //   1967	1983	2708	java/lang/UnsatisfiedLinkError
    //   1983	1992	2708	java/lang/UnsatisfiedLinkError
    //   1992	2081	2708	java/lang/UnsatisfiedLinkError
    //   2651	2655	2708	java/lang/UnsatisfiedLinkError
    //   1937	1941	2716	java/lang/RuntimeException
    //   2248	2252	2716	java/lang/RuntimeException
    //   1950	1959	2720	java/lang/RuntimeException
    //   1967	1983	2720	java/lang/RuntimeException
    //   1983	1992	2720	java/lang/RuntimeException
    //   1992	2081	2720	java/lang/RuntimeException
    //   2651	2655	2720	java/lang/RuntimeException
    //   1937	1941	2728	java/io/IOException
    //   2248	2252	2728	java/io/IOException
    //   1950	1959	2736	java/io/IOException
    //   1967	1983	2736	java/io/IOException
    //   1983	1992	2736	java/io/IOException
    //   1992	2081	2736	java/io/IOException
    //   2651	2655	2736	java/io/IOException
    //   1992	2081	2744	java/lang/OutOfMemoryError
    //   2323	2329	2751	java/lang/OutOfMemoryError
    //   2345	2350	2751	java/lang/OutOfMemoryError
    //   2366	2375	2751	java/lang/OutOfMemoryError
    //   2391	2406	2751	java/lang/OutOfMemoryError
    //   2422	2431	2751	java/lang/OutOfMemoryError
    //   2447	2459	2751	java/lang/OutOfMemoryError
    //   2475	2487	2751	java/lang/OutOfMemoryError
    //   2513	2532	2751	java/lang/OutOfMemoryError
    //   2548	2560	2751	java/lang/OutOfMemoryError
    //   2576	2588	2751	java/lang/OutOfMemoryError
    //   2604	2608	2751	java/lang/OutOfMemoryError
    //   1664	1670	2762	java/lang/OutOfMemoryError
    //   1686	1691	2762	java/lang/OutOfMemoryError
    //   1707	1716	2762	java/lang/OutOfMemoryError
    //   1732	1747	2762	java/lang/OutOfMemoryError
    //   1763	1772	2762	java/lang/OutOfMemoryError
    //   1788	1800	2762	java/lang/OutOfMemoryError
    //   1816	1828	2762	java/lang/OutOfMemoryError
    //   1850	1869	2762	java/lang/OutOfMemoryError
    //   1885	1897	2762	java/lang/OutOfMemoryError
    //   1913	1925	2762	java/lang/OutOfMemoryError
    //   1937	1941	2773	java/lang/OutOfMemoryError
    //   1395	1404	2780	java/lang/OutOfMemoryError
    //   1416	1420	2780	java/lang/OutOfMemoryError
    //   1432	1439	2780	java/lang/OutOfMemoryError
    //   1451	1458	2780	java/lang/OutOfMemoryError
    //   1470	1479	2780	java/lang/OutOfMemoryError
    //   1491	1507	2780	java/lang/OutOfMemoryError
    //   1519	1524	2780	java/lang/OutOfMemoryError
    //   1536	1545	2780	java/lang/OutOfMemoryError
    //   1557	1569	2780	java/lang/OutOfMemoryError
    //   1581	1593	2780	java/lang/OutOfMemoryError
    //   524	532	2785	java/lang/UnsatisfiedLinkError
    //   536	568	2785	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cqx
 * JD-Core Version:    0.7.0.1
 */