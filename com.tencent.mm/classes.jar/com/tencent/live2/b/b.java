package com.tencent.live2.b;

import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.live2.impl.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.trtc.TRTCCloudDef.TRTCParams;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  private int a;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private boolean k;
  private boolean l;
  private boolean m = true;
  private boolean n = true;
  private boolean o;
  private a.d p = a.d.a;
  
  /* Error */
  public static b a(String paramString)
  {
    // Byte code:
    //   0: ldc 49
    //   2: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 49
    //   14: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: ldc 64
    //   22: invokevirtual 70	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   25: ifne +19 -> 44
    //   28: aload_0
    //   29: ldc 72
    //   31: invokevirtual 70	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   34: ifne +10 -> 44
    //   37: ldc 49
    //   39: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aconst_null
    //   43: areturn
    //   44: new 2	com/tencent/live2/b/b
    //   47: dup
    //   48: invokespecial 73	com/tencent/live2/b/b:<init>	()V
    //   51: astore 5
    //   53: aload_0
    //   54: ldc 75
    //   56: invokevirtual 79	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   59: astore 6
    //   61: aload_0
    //   62: ldc 64
    //   64: invokevirtual 70	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   67: ifeq +169 -> 236
    //   70: aload 5
    //   72: getstatic 81	com/tencent/live2/impl/a$d:b	Lcom/tencent/live2/impl/a$d;
    //   75: putfield 34	com/tencent/live2/b/b:p	Lcom/tencent/live2/impl/a$d;
    //   78: aload_0
    //   79: ldc 83
    //   81: invokevirtual 87	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   84: istore_1
    //   85: aload_0
    //   86: ldc 89
    //   88: invokevirtual 92	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   91: istore_2
    //   92: iload_1
    //   93: iconst_m1
    //   94: if_icmpeq +50 -> 144
    //   97: iload_2
    //   98: iconst_m1
    //   99: if_icmpeq +45 -> 144
    //   102: iload_2
    //   103: iload_1
    //   104: iconst_1
    //   105: iadd
    //   106: if_icmple +38 -> 144
    //   109: aload 5
    //   111: aload_0
    //   112: iload_1
    //   113: iconst_1
    //   114: iadd
    //   115: iload_2
    //   116: invokevirtual 96	java/lang/String:substring	(II)Ljava/lang/String;
    //   119: putfield 98	com/tencent/live2/b/b:e	Ljava/lang/String;
    //   122: aload 5
    //   124: aload 5
    //   126: getfield 98	com/tencent/live2/b/b:e	Ljava/lang/String;
    //   129: putfield 100	com/tencent/live2/b/b:i	Ljava/lang/String;
    //   132: aload 5
    //   134: iconst_0
    //   135: putfield 102	com/tencent/live2/b/b:o	Z
    //   138: aload 5
    //   140: iconst_1
    //   141: putfield 36	com/tencent/live2/b/b:b	I
    //   144: aload 6
    //   146: arraylength
    //   147: istore_2
    //   148: iconst_0
    //   149: istore_1
    //   150: iload_1
    //   151: iload_2
    //   152: if_icmpge +825 -> 977
    //   155: aload 6
    //   157: iload_1
    //   158: aaload
    //   159: astore_0
    //   160: aload_0
    //   161: ldc 104
    //   163: invokevirtual 107	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   166: ifeq +63 -> 229
    //   169: aload_0
    //   170: ldc 109
    //   172: invokevirtual 79	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   175: astore_0
    //   176: aload_0
    //   177: arraylength
    //   178: iconst_2
    //   179: if_icmpne +50 -> 229
    //   182: aload_0
    //   183: iconst_0
    //   184: aaload
    //   185: astore 7
    //   187: aload_0
    //   188: iconst_1
    //   189: aaload
    //   190: astore_0
    //   191: aload 7
    //   193: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifne +33 -> 229
    //   199: aload_0
    //   200: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   203: ifne +26 -> 229
    //   206: aload 7
    //   208: ldc 111
    //   210: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   213: istore 4
    //   215: iload 4
    //   217: ifeq +84 -> 301
    //   220: aload 5
    //   222: aload_0
    //   223: invokestatic 119	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   226: putfield 121	com/tencent/live2/b/b:a	I
    //   229: iload_1
    //   230: iconst_1
    //   231: iadd
    //   232: istore_1
    //   233: goto -83 -> 150
    //   236: aload 5
    //   238: getstatic 32	com/tencent/live2/impl/a$d:a	Lcom/tencent/live2/impl/a$d;
    //   241: putfield 34	com/tencent/live2/b/b:p	Lcom/tencent/live2/impl/a$d;
    //   244: goto -100 -> 144
    //   247: astore_0
    //   248: ldc 123
    //   250: ldc 125
    //   252: iconst_1
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload_0
    //   259: aastore
    //   260: invokestatic 130	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: ldc 49
    //   265: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aconst_null
    //   269: areturn
    //   270: astore 7
    //   272: ldc 123
    //   274: new 132	java/lang/StringBuilder
    //   277: dup
    //   278: ldc 134
    //   280: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload_0
    //   284: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc 143
    //   289: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 150	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: goto -69 -> 229
    //   301: aload 7
    //   303: ldc 152
    //   305: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   308: ifeq +18 -> 326
    //   311: aload 5
    //   313: aload_0
    //   314: putfield 98	com/tencent/live2/b/b:e	Ljava/lang/String;
    //   317: aload 5
    //   319: iconst_1
    //   320: putfield 102	com/tencent/live2/b/b:o	Z
    //   323: goto -94 -> 229
    //   326: aload 7
    //   328: ldc 154
    //   330: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   333: ifeq +18 -> 351
    //   336: aload 5
    //   338: aload_0
    //   339: putfield 98	com/tencent/live2/b/b:e	Ljava/lang/String;
    //   342: aload 5
    //   344: iconst_0
    //   345: putfield 102	com/tencent/live2/b/b:o	Z
    //   348: goto -119 -> 229
    //   351: aload 7
    //   353: ldc 156
    //   355: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   358: ifeq +12 -> 370
    //   361: aload 5
    //   363: aload_0
    //   364: putfield 158	com/tencent/live2/b/b:f	Ljava/lang/String;
    //   367: goto -138 -> 229
    //   370: aload 7
    //   372: ldc 160
    //   374: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   377: ifeq +12 -> 389
    //   380: aload 5
    //   382: aload_0
    //   383: putfield 162	com/tencent/live2/b/b:g	Ljava/lang/String;
    //   386: goto -157 -> 229
    //   389: aload 7
    //   391: ldc 164
    //   393: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   396: ifeq +75 -> 471
    //   399: aload_0
    //   400: ldc 166
    //   402: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   405: ifeq +12 -> 417
    //   408: aload 5
    //   410: iconst_0
    //   411: putfield 42	com/tencent/live2/b/b:c	I
    //   414: goto -185 -> 229
    //   417: aload_0
    //   418: ldc 168
    //   420: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   423: ifeq +12 -> 435
    //   426: aload 5
    //   428: iconst_1
    //   429: putfield 42	com/tencent/live2/b/b:c	I
    //   432: goto -203 -> 229
    //   435: aload_0
    //   436: ldc 170
    //   438: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   441: ifeq +12 -> 453
    //   444: aload 5
    //   446: iconst_2
    //   447: putfield 42	com/tencent/live2/b/b:c	I
    //   450: goto -221 -> 229
    //   453: aload_0
    //   454: ldc 172
    //   456: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   459: ifeq -230 -> 229
    //   462: aload 5
    //   464: iconst_3
    //   465: putfield 42	com/tencent/live2/b/b:c	I
    //   468: goto -239 -> 229
    //   471: aload 7
    //   473: ldc 174
    //   475: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   478: istore 4
    //   480: iload 4
    //   482: ifeq +55 -> 537
    //   485: aload_0
    //   486: invokestatic 119	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   489: iconst_1
    //   490: if_icmpne +495 -> 985
    //   493: iconst_1
    //   494: istore 4
    //   496: aload 5
    //   498: iload 4
    //   500: putfield 176	com/tencent/live2/b/b:k	Z
    //   503: goto -274 -> 229
    //   506: astore 7
    //   508: ldc 123
    //   510: new 132	java/lang/StringBuilder
    //   513: dup
    //   514: ldc 178
    //   516: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   519: aload_0
    //   520: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: ldc 143
    //   525: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 150	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: goto -305 -> 229
    //   537: aload 7
    //   539: ldc 180
    //   541: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   544: istore 4
    //   546: iload 4
    //   548: ifeq +55 -> 603
    //   551: aload_0
    //   552: invokestatic 119	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   555: iconst_1
    //   556: if_icmpne +435 -> 991
    //   559: iconst_1
    //   560: istore 4
    //   562: aload 5
    //   564: iload 4
    //   566: putfield 182	com/tencent/live2/b/b:l	Z
    //   569: goto -340 -> 229
    //   572: astore 7
    //   574: ldc 123
    //   576: new 132	java/lang/StringBuilder
    //   579: dup
    //   580: ldc 184
    //   582: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   585: aload_0
    //   586: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: ldc 143
    //   591: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   597: invokestatic 150	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   600: goto -371 -> 229
    //   603: aload 7
    //   605: ldc 186
    //   607: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   610: ifeq +84 -> 694
    //   613: aload_0
    //   614: ldc 188
    //   616: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   619: ifeq +12 -> 631
    //   622: aload 5
    //   624: iconst_1
    //   625: putfield 36	com/tencent/live2/b/b:b	I
    //   628: goto -399 -> 229
    //   631: aload_0
    //   632: ldc 190
    //   634: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   637: ifeq +12 -> 649
    //   640: aload 5
    //   642: iconst_0
    //   643: putfield 36	com/tencent/live2/b/b:b	I
    //   646: goto -417 -> 229
    //   649: aload_0
    //   650: ldc 192
    //   652: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   655: ifeq +12 -> 667
    //   658: aload 5
    //   660: iconst_2
    //   661: putfield 36	com/tencent/live2/b/b:b	I
    //   664: goto -435 -> 229
    //   667: aload_0
    //   668: ldc 194
    //   670: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   673: ifeq +12 -> 685
    //   676: aload 5
    //   678: iconst_3
    //   679: putfield 36	com/tencent/live2/b/b:b	I
    //   682: goto -453 -> 229
    //   685: aload 5
    //   687: iconst_0
    //   688: putfield 36	com/tencent/live2/b/b:b	I
    //   691: goto -462 -> 229
    //   694: aload 7
    //   696: ldc 196
    //   698: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   701: istore 4
    //   703: iload 4
    //   705: ifeq +134 -> 839
    //   708: aload_0
    //   709: invokestatic 119	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   712: istore_3
    //   713: iload_3
    //   714: iconst_1
    //   715: if_icmpne +49 -> 764
    //   718: aload 5
    //   720: iconst_1
    //   721: putfield 40	com/tencent/live2/b/b:n	Z
    //   724: aload 5
    //   726: iconst_1
    //   727: putfield 38	com/tencent/live2/b/b:m	Z
    //   730: goto -501 -> 229
    //   733: astore 7
    //   735: ldc 123
    //   737: new 132	java/lang/StringBuilder
    //   740: dup
    //   741: ldc 198
    //   743: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   746: aload_0
    //   747: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: ldc 143
    //   752: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokestatic 150	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   761: goto -532 -> 229
    //   764: iload_3
    //   765: iconst_2
    //   766: if_icmpne +18 -> 784
    //   769: aload 5
    //   771: iconst_1
    //   772: putfield 40	com/tencent/live2/b/b:n	Z
    //   775: aload 5
    //   777: iconst_0
    //   778: putfield 38	com/tencent/live2/b/b:m	Z
    //   781: goto -552 -> 229
    //   784: iload_3
    //   785: iconst_3
    //   786: if_icmpne +18 -> 804
    //   789: aload 5
    //   791: iconst_0
    //   792: putfield 40	com/tencent/live2/b/b:n	Z
    //   795: aload 5
    //   797: iconst_1
    //   798: putfield 38	com/tencent/live2/b/b:m	Z
    //   801: goto -572 -> 229
    //   804: iload_3
    //   805: iconst_4
    //   806: if_icmpne +18 -> 824
    //   809: aload 5
    //   811: iconst_0
    //   812: putfield 40	com/tencent/live2/b/b:n	Z
    //   815: aload 5
    //   817: iconst_0
    //   818: putfield 38	com/tencent/live2/b/b:m	Z
    //   821: goto -592 -> 229
    //   824: aload 5
    //   826: iconst_1
    //   827: putfield 40	com/tencent/live2/b/b:n	Z
    //   830: aload 5
    //   832: iconst_1
    //   833: putfield 38	com/tencent/live2/b/b:m	Z
    //   836: goto -607 -> 229
    //   839: aload 7
    //   841: ldc 200
    //   843: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   846: ifeq +12 -> 858
    //   849: aload 5
    //   851: aload_0
    //   852: putfield 100	com/tencent/live2/b/b:i	Ljava/lang/String;
    //   855: goto -626 -> 229
    //   858: aload 7
    //   860: ldc 202
    //   862: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   865: ifeq +12 -> 877
    //   868: aload 5
    //   870: aload_0
    //   871: putfield 204	com/tencent/live2/b/b:j	Ljava/lang/String;
    //   874: goto -645 -> 229
    //   877: aload 7
    //   879: ldc 206
    //   881: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   884: ifeq +12 -> 896
    //   887: aload 5
    //   889: aload_0
    //   890: putfield 208	com/tencent/live2/b/b:h	Ljava/lang/String;
    //   893: goto -664 -> 229
    //   896: aload 7
    //   898: ldc 210
    //   900: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   903: istore 4
    //   905: iload 4
    //   907: ifeq +46 -> 953
    //   910: aload 5
    //   912: aload_0
    //   913: invokestatic 119	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   916: putfield 44	com/tencent/live2/b/b:d	I
    //   919: goto -690 -> 229
    //   922: astore 7
    //   924: ldc 123
    //   926: new 132	java/lang/StringBuilder
    //   929: dup
    //   930: ldc 212
    //   932: invokespecial 137	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   935: aload_0
    //   936: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: ldc 143
    //   941: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   947: invokestatic 150	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   950: goto -721 -> 229
    //   953: aload 7
    //   955: ldc 214
    //   957: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   960: ifeq -731 -> 229
    //   963: aload 5
    //   965: ldc 216
    //   967: aload_0
    //   968: invokevirtual 114	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   971: putfield 102	com/tencent/live2/b/b:o	Z
    //   974: goto -745 -> 229
    //   977: ldc 49
    //   979: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   982: aload 5
    //   984: areturn
    //   985: iconst_0
    //   986: istore 4
    //   988: goto -492 -> 496
    //   991: iconst_0
    //   992: istore 4
    //   994: goto -432 -> 562
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	997	0	paramString	String
    //   84	149	1	i1	int
    //   91	62	2	i2	int
    //   712	95	3	i3	int
    //   213	780	4	bool	boolean
    //   51	932	5	localb	b
    //   59	97	6	arrayOfString	String[]
    //   185	22	7	localCharSequence	java.lang.CharSequence
    //   270	202	7	localException1	Exception
    //   506	32	7	localException2	Exception
    //   572	123	7	localException3	Exception
    //   733	164	7	localException4	Exception
    //   922	32	7	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   44	92	247	java/lang/Exception
    //   109	144	247	java/lang/Exception
    //   144	148	247	java/lang/Exception
    //   160	182	247	java/lang/Exception
    //   191	215	247	java/lang/Exception
    //   236	244	247	java/lang/Exception
    //   272	298	247	java/lang/Exception
    //   301	323	247	java/lang/Exception
    //   326	348	247	java/lang/Exception
    //   351	367	247	java/lang/Exception
    //   370	386	247	java/lang/Exception
    //   389	414	247	java/lang/Exception
    //   417	432	247	java/lang/Exception
    //   435	450	247	java/lang/Exception
    //   453	468	247	java/lang/Exception
    //   471	480	247	java/lang/Exception
    //   508	534	247	java/lang/Exception
    //   537	546	247	java/lang/Exception
    //   574	600	247	java/lang/Exception
    //   603	628	247	java/lang/Exception
    //   631	646	247	java/lang/Exception
    //   649	664	247	java/lang/Exception
    //   667	682	247	java/lang/Exception
    //   685	691	247	java/lang/Exception
    //   694	703	247	java/lang/Exception
    //   735	761	247	java/lang/Exception
    //   839	855	247	java/lang/Exception
    //   858	874	247	java/lang/Exception
    //   877	893	247	java/lang/Exception
    //   896	905	247	java/lang/Exception
    //   924	950	247	java/lang/Exception
    //   953	974	247	java/lang/Exception
    //   220	229	270	java/lang/Exception
    //   485	493	506	java/lang/Exception
    //   496	503	506	java/lang/Exception
    //   551	559	572	java/lang/Exception
    //   562	569	572	java/lang/Exception
    //   708	713	733	java/lang/Exception
    //   718	730	733	java/lang/Exception
    //   769	781	733	java/lang/Exception
    //   789	801	733	java/lang/Exception
    //   809	821	733	java/lang/Exception
    //   824	836	733	java/lang/Exception
    //   910	919	922	java/lang/Exception
  }
  
  public boolean a()
  {
    AppMethodBeat.i(213998);
    if ((this.a > 0) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.g)))
    {
      AppMethodBeat.o(213998);
      return true;
    }
    AppMethodBeat.o(213998);
    return false;
  }
  
  public boolean b()
  {
    return this.k;
  }
  
  public boolean c()
  {
    return this.l;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public int e()
  {
    return this.b;
  }
  
  public String f()
  {
    return this.e;
  }
  
  public String g()
  {
    return this.f;
  }
  
  public boolean h()
  {
    return this.p == a.d.b;
  }
  
  public boolean i()
  {
    return this.p == a.d.a;
  }
  
  public a.d j()
  {
    return this.p;
  }
  
  public boolean k()
  {
    return this.n;
  }
  
  public boolean l()
  {
    return this.m;
  }
  
  public TRTCCloudDef.TRTCParams m()
  {
    AppMethodBeat.i(214004);
    TRTCCloudDef.TRTCParams localTRTCParams = new TRTCCloudDef.TRTCParams();
    localTRTCParams.sdkAppId = this.a;
    localTRTCParams.userId = this.f;
    localTRTCParams.userSig = this.g;
    localTRTCParams.role = 20;
    if (this.o) {}
    for (;;)
    {
      try
      {
        localTRTCParams.roomId = Long.valueOf(this.e).intValue();
        if (!TextUtils.isEmpty(this.h)) {
          localTRTCParams.privateMapKey = this.h;
        }
        if (!TextUtils.isEmpty(this.j)) {
          localTRTCParams.userDefineRecordId = this.j;
        }
        if (!TextUtils.isEmpty(this.i)) {
          localTRTCParams.streamId = this.i;
        }
        JSONObject localJSONObject1 = new JSONObject();
        JSONObject localJSONObject2 = new JSONObject();
        try
        {
          if ((this.d == 1) || (this.d == 2))
          {
            localJSONObject2.put("pure_audio_push_mod", this.d);
            localJSONObject1.put("Str_uc_params", localJSONObject2);
            localTRTCParams.businessInfo = localJSONObject1.toString();
          }
        }
        catch (JSONException localJSONException)
        {
          continue;
        }
        AppMethodBeat.o(214004);
        return localTRTCParams;
      }
      catch (Exception localException)
      {
        TXCLog.e("V2-TRTCPushURLParam", "get enter room fail. can't parse num room id.");
        localTRTCParams.roomId = 0;
        continue;
      }
      localTRTCParams.roomId = 0;
      localTRTCParams.strRoomId = this.e;
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(214007);
    String str = "[env:" + this.c + "][sdkAppId:" + this.a + "][roomId:" + this.e + "][isNumRoomId:" + this.o + "][scene:" + this.b + "][userId:" + this.f + "][streamId:" + this.i + "][recordId:" + this.j + "][pureAudioMode:" + this.d + "][autoRecvAudio:" + this.n + "][autoRecvViedo:" + this.m + "][protocolType:" + this.p + "]";
    AppMethodBeat.o(214007);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.live2.b.b
 * JD-Core Version:    0.7.0.1
 */