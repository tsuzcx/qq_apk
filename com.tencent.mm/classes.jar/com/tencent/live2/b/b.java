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
  private int p;
  private a.d q = a.d.a;
  
  /* Error */
  public static b a(String paramString)
  {
    // Byte code:
    //   0: ldc 50
    //   2: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifeq +10 -> 19
    //   12: ldc 50
    //   14: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   17: aconst_null
    //   18: areturn
    //   19: aload_0
    //   20: ldc 65
    //   22: invokevirtual 71	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   25: ifne +19 -> 44
    //   28: aload_0
    //   29: ldc 73
    //   31: invokevirtual 71	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   34: ifne +10 -> 44
    //   37: ldc 50
    //   39: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: aconst_null
    //   43: areturn
    //   44: new 2	com/tencent/live2/b/b
    //   47: dup
    //   48: invokespecial 74	com/tencent/live2/b/b:<init>	()V
    //   51: astore 5
    //   53: aload_0
    //   54: ldc 76
    //   56: invokevirtual 80	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   59: astore 6
    //   61: aload_0
    //   62: ldc 65
    //   64: invokevirtual 71	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   67: ifeq +169 -> 236
    //   70: aload 5
    //   72: getstatic 82	com/tencent/live2/impl/a$d:b	Lcom/tencent/live2/impl/a$d;
    //   75: putfield 35	com/tencent/live2/b/b:q	Lcom/tencent/live2/impl/a$d;
    //   78: aload_0
    //   79: ldc 84
    //   81: invokevirtual 88	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   84: istore_1
    //   85: aload_0
    //   86: ldc 90
    //   88: invokevirtual 93	java/lang/String:indexOf	(Ljava/lang/String;)I
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
    //   116: invokevirtual 97	java/lang/String:substring	(II)Ljava/lang/String;
    //   119: putfield 99	com/tencent/live2/b/b:e	Ljava/lang/String;
    //   122: aload 5
    //   124: aload 5
    //   126: getfield 99	com/tencent/live2/b/b:e	Ljava/lang/String;
    //   129: putfield 101	com/tencent/live2/b/b:i	Ljava/lang/String;
    //   132: aload 5
    //   134: iconst_0
    //   135: putfield 103	com/tencent/live2/b/b:o	Z
    //   138: aload 5
    //   140: iconst_1
    //   141: putfield 37	com/tencent/live2/b/b:b	I
    //   144: aload 6
    //   146: arraylength
    //   147: istore_2
    //   148: iconst_0
    //   149: istore_1
    //   150: iload_1
    //   151: iload_2
    //   152: if_icmpge +882 -> 1034
    //   155: aload 6
    //   157: iload_1
    //   158: aaload
    //   159: astore_0
    //   160: aload_0
    //   161: ldc 105
    //   163: invokevirtual 108	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   166: ifeq +63 -> 229
    //   169: aload_0
    //   170: ldc 110
    //   172: invokevirtual 80	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
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
    //   193: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifne +33 -> 229
    //   199: aload_0
    //   200: invokestatic 61	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   203: ifne +26 -> 229
    //   206: aload 7
    //   208: ldc 112
    //   210: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   213: istore 4
    //   215: iload 4
    //   217: ifeq +84 -> 301
    //   220: aload 5
    //   222: aload_0
    //   223: invokestatic 120	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   226: putfield 122	com/tencent/live2/b/b:a	I
    //   229: iload_1
    //   230: iconst_1
    //   231: iadd
    //   232: istore_1
    //   233: goto -83 -> 150
    //   236: aload 5
    //   238: getstatic 33	com/tencent/live2/impl/a$d:a	Lcom/tencent/live2/impl/a$d;
    //   241: putfield 35	com/tencent/live2/b/b:q	Lcom/tencent/live2/impl/a$d;
    //   244: goto -100 -> 144
    //   247: astore_0
    //   248: ldc 124
    //   250: ldc 126
    //   252: iconst_1
    //   253: anewarray 4	java/lang/Object
    //   256: dup
    //   257: iconst_0
    //   258: aload_0
    //   259: aastore
    //   260: invokestatic 131	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: ldc 50
    //   265: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   268: aconst_null
    //   269: areturn
    //   270: astore 7
    //   272: ldc 124
    //   274: new 133	java/lang/StringBuilder
    //   277: dup
    //   278: ldc 135
    //   280: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload_0
    //   284: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: ldc 144
    //   289: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   295: invokestatic 151	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   298: goto -69 -> 229
    //   301: aload 7
    //   303: ldc 153
    //   305: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   308: ifeq +18 -> 326
    //   311: aload 5
    //   313: aload_0
    //   314: putfield 99	com/tencent/live2/b/b:e	Ljava/lang/String;
    //   317: aload 5
    //   319: iconst_1
    //   320: putfield 103	com/tencent/live2/b/b:o	Z
    //   323: goto -94 -> 229
    //   326: aload 7
    //   328: ldc 155
    //   330: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   333: ifeq +18 -> 351
    //   336: aload 5
    //   338: aload_0
    //   339: putfield 99	com/tencent/live2/b/b:e	Ljava/lang/String;
    //   342: aload 5
    //   344: iconst_0
    //   345: putfield 103	com/tencent/live2/b/b:o	Z
    //   348: goto -119 -> 229
    //   351: aload 7
    //   353: ldc 157
    //   355: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   358: ifeq +12 -> 370
    //   361: aload 5
    //   363: aload_0
    //   364: putfield 159	com/tencent/live2/b/b:f	Ljava/lang/String;
    //   367: goto -138 -> 229
    //   370: aload 7
    //   372: ldc 161
    //   374: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   377: ifeq +12 -> 389
    //   380: aload 5
    //   382: aload_0
    //   383: putfield 163	com/tencent/live2/b/b:g	Ljava/lang/String;
    //   386: goto -157 -> 229
    //   389: aload 7
    //   391: ldc 165
    //   393: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   396: ifeq +75 -> 471
    //   399: aload_0
    //   400: ldc 167
    //   402: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   405: ifeq +12 -> 417
    //   408: aload 5
    //   410: iconst_0
    //   411: putfield 43	com/tencent/live2/b/b:c	I
    //   414: goto -185 -> 229
    //   417: aload_0
    //   418: ldc 169
    //   420: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   423: ifeq +12 -> 435
    //   426: aload 5
    //   428: iconst_1
    //   429: putfield 43	com/tencent/live2/b/b:c	I
    //   432: goto -203 -> 229
    //   435: aload_0
    //   436: ldc 171
    //   438: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   441: ifeq +12 -> 453
    //   444: aload 5
    //   446: iconst_2
    //   447: putfield 43	com/tencent/live2/b/b:c	I
    //   450: goto -221 -> 229
    //   453: aload_0
    //   454: ldc 173
    //   456: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   459: ifeq -230 -> 229
    //   462: aload 5
    //   464: iconst_3
    //   465: putfield 43	com/tencent/live2/b/b:c	I
    //   468: goto -239 -> 229
    //   471: aload 7
    //   473: ldc 175
    //   475: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   478: istore 4
    //   480: iload 4
    //   482: ifeq +55 -> 537
    //   485: aload_0
    //   486: invokestatic 120	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   489: iconst_1
    //   490: if_icmpne +552 -> 1042
    //   493: iconst_1
    //   494: istore 4
    //   496: aload 5
    //   498: iload 4
    //   500: putfield 177	com/tencent/live2/b/b:k	Z
    //   503: goto -274 -> 229
    //   506: astore 7
    //   508: ldc 124
    //   510: new 133	java/lang/StringBuilder
    //   513: dup
    //   514: ldc 179
    //   516: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   519: aload_0
    //   520: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   523: ldc 144
    //   525: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   531: invokestatic 151	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   534: goto -305 -> 229
    //   537: aload 7
    //   539: ldc 181
    //   541: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   544: istore 4
    //   546: iload 4
    //   548: ifeq +46 -> 594
    //   551: aload 5
    //   553: aload_0
    //   554: invokestatic 120	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   557: putfield 183	com/tencent/live2/b/b:p	I
    //   560: goto -331 -> 229
    //   563: astore 7
    //   565: ldc 124
    //   567: new 133	java/lang/StringBuilder
    //   570: dup
    //   571: ldc 185
    //   573: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   576: aload_0
    //   577: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: ldc 144
    //   582: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 151	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   591: goto -362 -> 229
    //   594: aload 7
    //   596: ldc 187
    //   598: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   601: istore 4
    //   603: iload 4
    //   605: ifeq +55 -> 660
    //   608: aload_0
    //   609: invokestatic 120	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   612: iconst_1
    //   613: if_icmpne +435 -> 1048
    //   616: iconst_1
    //   617: istore 4
    //   619: aload 5
    //   621: iload 4
    //   623: putfield 189	com/tencent/live2/b/b:l	Z
    //   626: goto -397 -> 229
    //   629: astore 7
    //   631: ldc 124
    //   633: new 133	java/lang/StringBuilder
    //   636: dup
    //   637: ldc 191
    //   639: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   642: aload_0
    //   643: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: ldc 144
    //   648: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   654: invokestatic 151	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   657: goto -428 -> 229
    //   660: aload 7
    //   662: ldc 193
    //   664: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   667: ifeq +84 -> 751
    //   670: aload_0
    //   671: ldc 195
    //   673: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   676: ifeq +12 -> 688
    //   679: aload 5
    //   681: iconst_1
    //   682: putfield 37	com/tencent/live2/b/b:b	I
    //   685: goto -456 -> 229
    //   688: aload_0
    //   689: ldc 197
    //   691: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   694: ifeq +12 -> 706
    //   697: aload 5
    //   699: iconst_0
    //   700: putfield 37	com/tencent/live2/b/b:b	I
    //   703: goto -474 -> 229
    //   706: aload_0
    //   707: ldc 199
    //   709: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   712: ifeq +12 -> 724
    //   715: aload 5
    //   717: iconst_2
    //   718: putfield 37	com/tencent/live2/b/b:b	I
    //   721: goto -492 -> 229
    //   724: aload_0
    //   725: ldc 201
    //   727: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   730: ifeq +12 -> 742
    //   733: aload 5
    //   735: iconst_3
    //   736: putfield 37	com/tencent/live2/b/b:b	I
    //   739: goto -510 -> 229
    //   742: aload 5
    //   744: iconst_0
    //   745: putfield 37	com/tencent/live2/b/b:b	I
    //   748: goto -519 -> 229
    //   751: aload 7
    //   753: ldc 203
    //   755: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   758: istore 4
    //   760: iload 4
    //   762: ifeq +134 -> 896
    //   765: aload_0
    //   766: invokestatic 120	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   769: istore_3
    //   770: iload_3
    //   771: iconst_1
    //   772: if_icmpne +49 -> 821
    //   775: aload 5
    //   777: iconst_1
    //   778: putfield 41	com/tencent/live2/b/b:n	Z
    //   781: aload 5
    //   783: iconst_1
    //   784: putfield 39	com/tencent/live2/b/b:m	Z
    //   787: goto -558 -> 229
    //   790: astore 7
    //   792: ldc 124
    //   794: new 133	java/lang/StringBuilder
    //   797: dup
    //   798: ldc 205
    //   800: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   803: aload_0
    //   804: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: ldc 144
    //   809: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   815: invokestatic 151	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   818: goto -589 -> 229
    //   821: iload_3
    //   822: iconst_2
    //   823: if_icmpne +18 -> 841
    //   826: aload 5
    //   828: iconst_1
    //   829: putfield 41	com/tencent/live2/b/b:n	Z
    //   832: aload 5
    //   834: iconst_0
    //   835: putfield 39	com/tencent/live2/b/b:m	Z
    //   838: goto -609 -> 229
    //   841: iload_3
    //   842: iconst_3
    //   843: if_icmpne +18 -> 861
    //   846: aload 5
    //   848: iconst_0
    //   849: putfield 41	com/tencent/live2/b/b:n	Z
    //   852: aload 5
    //   854: iconst_1
    //   855: putfield 39	com/tencent/live2/b/b:m	Z
    //   858: goto -629 -> 229
    //   861: iload_3
    //   862: iconst_4
    //   863: if_icmpne +18 -> 881
    //   866: aload 5
    //   868: iconst_0
    //   869: putfield 41	com/tencent/live2/b/b:n	Z
    //   872: aload 5
    //   874: iconst_0
    //   875: putfield 39	com/tencent/live2/b/b:m	Z
    //   878: goto -649 -> 229
    //   881: aload 5
    //   883: iconst_1
    //   884: putfield 41	com/tencent/live2/b/b:n	Z
    //   887: aload 5
    //   889: iconst_1
    //   890: putfield 39	com/tencent/live2/b/b:m	Z
    //   893: goto -664 -> 229
    //   896: aload 7
    //   898: ldc 207
    //   900: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   903: ifeq +12 -> 915
    //   906: aload 5
    //   908: aload_0
    //   909: putfield 101	com/tencent/live2/b/b:i	Ljava/lang/String;
    //   912: goto -683 -> 229
    //   915: aload 7
    //   917: ldc 209
    //   919: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   922: ifeq +12 -> 934
    //   925: aload 5
    //   927: aload_0
    //   928: putfield 211	com/tencent/live2/b/b:j	Ljava/lang/String;
    //   931: goto -702 -> 229
    //   934: aload 7
    //   936: ldc 213
    //   938: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   941: ifeq +12 -> 953
    //   944: aload 5
    //   946: aload_0
    //   947: putfield 215	com/tencent/live2/b/b:h	Ljava/lang/String;
    //   950: goto -721 -> 229
    //   953: aload 7
    //   955: ldc 217
    //   957: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   960: istore 4
    //   962: iload 4
    //   964: ifeq +46 -> 1010
    //   967: aload 5
    //   969: aload_0
    //   970: invokestatic 120	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   973: putfield 45	com/tencent/live2/b/b:d	I
    //   976: goto -747 -> 229
    //   979: astore 7
    //   981: ldc 124
    //   983: new 133	java/lang/StringBuilder
    //   986: dup
    //   987: ldc 219
    //   989: invokespecial 138	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   992: aload_0
    //   993: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   996: ldc 144
    //   998: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokestatic 151	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1007: goto -778 -> 229
    //   1010: aload 7
    //   1012: ldc 221
    //   1014: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1017: ifeq -788 -> 229
    //   1020: aload 5
    //   1022: ldc 223
    //   1024: aload_0
    //   1025: invokevirtual 115	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   1028: putfield 103	com/tencent/live2/b/b:o	Z
    //   1031: goto -802 -> 229
    //   1034: ldc 50
    //   1036: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1039: aload 5
    //   1041: areturn
    //   1042: iconst_0
    //   1043: istore 4
    //   1045: goto -549 -> 496
    //   1048: iconst_0
    //   1049: istore 4
    //   1051: goto -432 -> 619
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1054	0	paramString	String
    //   84	149	1	i1	int
    //   91	62	2	i2	int
    //   769	95	3	i3	int
    //   213	837	4	bool	boolean
    //   51	989	5	localb	b
    //   59	97	6	arrayOfString	String[]
    //   185	22	7	localCharSequence	java.lang.CharSequence
    //   270	202	7	localException1	Exception
    //   506	32	7	localException2	Exception
    //   563	32	7	localException3	Exception
    //   629	123	7	localException4	Exception
    //   790	164	7	localException5	Exception
    //   979	32	7	localException6	Exception
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
    //   565	591	247	java/lang/Exception
    //   594	603	247	java/lang/Exception
    //   631	657	247	java/lang/Exception
    //   660	685	247	java/lang/Exception
    //   688	703	247	java/lang/Exception
    //   706	721	247	java/lang/Exception
    //   724	739	247	java/lang/Exception
    //   742	748	247	java/lang/Exception
    //   751	760	247	java/lang/Exception
    //   792	818	247	java/lang/Exception
    //   896	912	247	java/lang/Exception
    //   915	931	247	java/lang/Exception
    //   934	950	247	java/lang/Exception
    //   953	962	247	java/lang/Exception
    //   981	1007	247	java/lang/Exception
    //   1010	1031	247	java/lang/Exception
    //   220	229	270	java/lang/Exception
    //   485	493	506	java/lang/Exception
    //   496	503	506	java/lang/Exception
    //   551	560	563	java/lang/Exception
    //   608	616	629	java/lang/Exception
    //   619	626	629	java/lang/Exception
    //   765	770	790	java/lang/Exception
    //   775	787	790	java/lang/Exception
    //   826	838	790	java/lang/Exception
    //   846	858	790	java/lang/Exception
    //   866	878	790	java/lang/Exception
    //   881	893	790	java/lang/Exception
    //   967	976	979	java/lang/Exception
  }
  
  public boolean a()
  {
    AppMethodBeat.i(211375);
    if ((this.a > 0) && (!TextUtils.isEmpty(this.e)) && (!TextUtils.isEmpty(this.f)) && (!TextUtils.isEmpty(this.g)))
    {
      AppMethodBeat.o(211375);
      return true;
    }
    AppMethodBeat.o(211375);
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
    return this.q == a.d.b;
  }
  
  public boolean i()
  {
    return this.q == a.d.a;
  }
  
  public a.d j()
  {
    return this.q;
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
    int i1 = 0;
    AppMethodBeat.i(211433);
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
          if (this.p != 0)
          {
            localJSONObject2.put("uc_biz_type", this.p);
            i1 = 1;
          }
          if ((this.d == 1) || (this.d == 2))
          {
            localJSONObject2.put("pure_audio_push_mod", this.d);
            i1 = 1;
          }
          if (i1 != 0)
          {
            localJSONObject1.put("Str_uc_params", localJSONObject2);
            localTRTCParams.businessInfo = localJSONObject1.toString();
          }
        }
        catch (JSONException localJSONException)
        {
          continue;
        }
        AppMethodBeat.o(211433);
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
    AppMethodBeat.i(211440);
    String str = "[env:" + this.c + "][sdkAppId:" + this.a + "][roomId:" + this.e + "][isNumRoomId:" + this.o + "][scene:" + this.b + "][userId:" + this.f + "][streamId:" + this.i + "][recordId:" + this.j + "][pureAudioMode:" + this.d + "][autoRecvAudio:" + this.n + "][autoRecvViedo:" + this.m + "][protocolType:" + this.q + "]";
    AppMethodBeat.o(211440);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.live2.b.b
 * JD-Core Version:    0.7.0.1
 */