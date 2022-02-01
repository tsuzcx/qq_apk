package midas.x;

import android.text.TextUtils;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

public class mc
  implements kv
{
  private final ArrayList<kq> a = new ArrayList();
  private final md b;
  
  mc(md parammd)
  {
    this.b = parammd;
  }
  
  /* Error */
  private kz a(ky paramky)
  {
    // Byte code:
    //   0: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: new 41	midas/x/kz
    //   8: dup
    //   9: invokespecial 42	midas/x/kz:<init>	()V
    //   12: astore 18
    //   14: aload_1
    //   15: ifnonnull +6 -> 21
    //   18: aload 18
    //   20: areturn
    //   21: aload 18
    //   23: aload_1
    //   24: invokevirtual 45	midas/x/kz:a	(Lmidas/x/ky;)V
    //   27: aload_1
    //   28: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   31: putfield 51	midas/x/ky:d	J
    //   34: aload_0
    //   35: aload_1
    //   36: invokespecial 53	midas/x/mc:b	(Lmidas/x/ky;)V
    //   39: aconst_null
    //   40: astore 13
    //   42: aconst_null
    //   43: astore 10
    //   45: aconst_null
    //   46: astore 16
    //   48: aconst_null
    //   49: astore 17
    //   51: aconst_null
    //   52: astore 14
    //   54: aconst_null
    //   55: astore 9
    //   57: aload_1
    //   58: invokevirtual 56	midas/x/ky:f	()V
    //   61: aload_1
    //   62: invokevirtual 60	midas/x/ky:s	()Ljava/lang/String;
    //   65: astore 11
    //   67: new 62	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   74: astore 12
    //   76: aload 12
    //   78: ldc 65
    //   80: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 12
    //   86: aload 11
    //   88: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: ldc 71
    //   94: aload 12
    //   96: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 79	midas/x/ks:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload 11
    //   104: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: istore 8
    //   109: iload 8
    //   111: ifeq +82 -> 193
    //   114: aload_0
    //   115: aconst_null
    //   116: aconst_null
    //   117: invokespecial 88	midas/x/mc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   120: aload_1
    //   121: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   124: aload_1
    //   125: getfield 91	midas/x/ky:e	J
    //   128: lsub
    //   129: putfield 93	midas/x/ky:f	J
    //   132: aload 18
    //   134: getfield 96	midas/x/kz:a	I
    //   137: sipush 200
    //   140: if_icmpeq +8 -> 148
    //   143: aload_1
    //   144: iconst_1
    //   145: putfield 100	midas/x/ky:j	Z
    //   148: aload_0
    //   149: aload_1
    //   150: aload 18
    //   152: invokespecial 103	midas/x/mc:b	(Lmidas/x/ky;Lmidas/x/kz;)V
    //   155: new 62	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   162: astore_1
    //   163: aload_1
    //   164: ldc 105
    //   166: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_1
    //   171: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   174: lload 4
    //   176: lsub
    //   177: invokevirtual 108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: ldc 110
    //   183: aload_1
    //   184: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 79	midas/x/ks:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   190: aload 18
    //   192: areturn
    //   193: new 112	java/net/URL
    //   196: dup
    //   197: aload 11
    //   199: invokespecial 115	java/net/URL:<init>	(Ljava/lang/String;)V
    //   202: invokevirtual 119	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   205: astore 11
    //   207: aload 11
    //   209: ifnonnull +82 -> 291
    //   212: aload_0
    //   213: aconst_null
    //   214: aconst_null
    //   215: invokespecial 88	midas/x/mc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   218: aload_1
    //   219: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   222: aload_1
    //   223: getfield 91	midas/x/ky:e	J
    //   226: lsub
    //   227: putfield 93	midas/x/ky:f	J
    //   230: aload 18
    //   232: getfield 96	midas/x/kz:a	I
    //   235: sipush 200
    //   238: if_icmpeq +8 -> 246
    //   241: aload_1
    //   242: iconst_1
    //   243: putfield 100	midas/x/ky:j	Z
    //   246: aload_0
    //   247: aload_1
    //   248: aload 18
    //   250: invokespecial 103	midas/x/mc:b	(Lmidas/x/ky;Lmidas/x/kz;)V
    //   253: new 62	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   260: astore_1
    //   261: aload_1
    //   262: ldc 105
    //   264: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload_1
    //   269: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   272: lload 4
    //   274: lsub
    //   275: invokevirtual 108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: ldc 110
    //   281: aload_1
    //   282: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 79	midas/x/ks:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload 18
    //   290: areturn
    //   291: aload 11
    //   293: instanceof 121
    //   296: istore 8
    //   298: iload 8
    //   300: ifne +82 -> 382
    //   303: aload_0
    //   304: aconst_null
    //   305: aconst_null
    //   306: invokespecial 88	midas/x/mc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   309: aload_1
    //   310: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   313: aload_1
    //   314: getfield 91	midas/x/ky:e	J
    //   317: lsub
    //   318: putfield 93	midas/x/ky:f	J
    //   321: aload 18
    //   323: getfield 96	midas/x/kz:a	I
    //   326: sipush 200
    //   329: if_icmpeq +8 -> 337
    //   332: aload_1
    //   333: iconst_1
    //   334: putfield 100	midas/x/ky:j	Z
    //   337: aload_0
    //   338: aload_1
    //   339: aload 18
    //   341: invokespecial 103	midas/x/mc:b	(Lmidas/x/ky;Lmidas/x/kz;)V
    //   344: new 62	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   351: astore_1
    //   352: aload_1
    //   353: ldc 105
    //   355: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload_1
    //   360: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   363: lload 4
    //   365: lsub
    //   366: invokevirtual 108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   369: pop
    //   370: ldc 110
    //   372: aload_1
    //   373: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 79	midas/x/ks:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload 18
    //   381: areturn
    //   382: aload 11
    //   384: checkcast 121	java/net/HttpURLConnection
    //   387: astore 11
    //   389: new 62	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   396: astore 12
    //   398: aload 12
    //   400: ldc 123
    //   402: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: aload 12
    //   408: aload 11
    //   410: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   413: pop
    //   414: ldc 71
    //   416: aload 12
    //   418: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 79	midas/x/ks:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: aload 11
    //   426: iconst_0
    //   427: invokevirtual 130	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   430: aload 11
    //   432: iconst_0
    //   433: invokevirtual 133	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   436: aload_0
    //   437: aload 11
    //   439: aload_1
    //   440: invokespecial 136	midas/x/mc:a	(Ljava/net/HttpURLConnection;Lmidas/x/ky;)V
    //   443: aload 11
    //   445: aload_1
    //   446: invokestatic 138	midas/x/mc:b	(Ljava/net/HttpURLConnection;Lmidas/x/ky;)V
    //   449: aload_0
    //   450: aload 11
    //   452: aload_1
    //   453: invokespecial 141	midas/x/mc:c	(Ljava/net/HttpURLConnection;Lmidas/x/ky;)V
    //   456: aload 11
    //   458: iconst_1
    //   459: invokevirtual 144	java/net/HttpURLConnection:setDoInput	(Z)V
    //   462: aload 11
    //   464: ldc 146
    //   466: invokevirtual 149	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   469: aload 11
    //   471: iconst_1
    //   472: invokevirtual 152	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   475: aload_1
    //   476: invokevirtual 156	midas/x/ky:r	()Z
    //   479: ifeq +218 -> 697
    //   482: aload_1
    //   483: invokevirtual 159	midas/x/ky:k	()Ljava/lang/String;
    //   486: astore 12
    //   488: new 62	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   495: astore 15
    //   497: aload 15
    //   499: ldc 161
    //   501: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: pop
    //   505: aload 15
    //   507: aload 12
    //   509: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: ldc 71
    //   515: aload 15
    //   517: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 79	midas/x/ks:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: aload 12
    //   525: ldc 163
    //   527: invokevirtual 169	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   530: astore 12
    //   532: aload 12
    //   534: arraylength
    //   535: istore_3
    //   536: iload_3
    //   537: istore_2
    //   538: aload_1
    //   539: instanceof 171
    //   542: ifeq +18 -> 560
    //   545: iload_3
    //   546: i2l
    //   547: aload_1
    //   548: checkcast 171	midas/x/me
    //   551: invokevirtual 174	midas/x/me:a	()Ljava/io/File;
    //   554: invokevirtual 179	java/io/File:length	()J
    //   557: ladd
    //   558: l2i
    //   559: istore_2
    //   560: aload 11
    //   562: ldc 181
    //   564: iload_2
    //   565: invokestatic 185	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   568: invokevirtual 188	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: aload 11
    //   573: iload_2
    //   574: invokevirtual 192	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   577: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   580: lstore 6
    //   582: new 194	java/io/DataOutputStream
    //   585: dup
    //   586: aload 11
    //   588: invokevirtual 198	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   591: invokespecial 201	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   594: astore 15
    //   596: aload 15
    //   598: aload 12
    //   600: invokevirtual 205	java/io/DataOutputStream:write	([B)V
    //   603: aload 15
    //   605: invokevirtual 208	java/io/DataOutputStream:flush	()V
    //   608: ldc 71
    //   610: ldc 210
    //   612: invokestatic 79	midas/x/ks:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   615: aload_1
    //   616: instanceof 171
    //   619: ifeq +20 -> 639
    //   622: ldc 71
    //   624: ldc 212
    //   626: invokestatic 79	midas/x/ks:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: aload_0
    //   630: aload 15
    //   632: aload_1
    //   633: checkcast 171	midas/x/me
    //   636: invokespecial 215	midas/x/mc:a	(Ljava/io/DataOutputStream;Lmidas/x/me;)V
    //   639: aload_1
    //   640: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   643: lload 6
    //   645: lsub
    //   646: putfield 218	midas/x/ky:g	J
    //   649: aload 15
    //   651: invokevirtual 221	java/io/DataOutputStream:close	()V
    //   654: goto +43 -> 697
    //   657: astore 12
    //   659: new 62	java/lang/StringBuilder
    //   662: dup
    //   663: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   666: astore 15
    //   668: aload 15
    //   670: ldc 223
    //   672: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload 15
    //   678: aload 12
    //   680: invokevirtual 226	java/io/IOException:getMessage	()Ljava/lang/String;
    //   683: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: pop
    //   687: ldc 71
    //   689: aload 15
    //   691: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   694: invokestatic 228	midas/x/ks:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   697: aload 11
    //   699: invokevirtual 232	java/net/HttpURLConnection:getResponseCode	()I
    //   702: istore_2
    //   703: new 62	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   710: astore 12
    //   712: aload 12
    //   714: ldc 234
    //   716: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   719: pop
    //   720: aload 12
    //   722: iload_2
    //   723: invokevirtual 237	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   726: pop
    //   727: ldc 71
    //   729: aload 12
    //   731: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: invokestatic 79	midas/x/ks:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   737: aload 18
    //   739: iload_2
    //   740: putfield 96	midas/x/kz:a	I
    //   743: iload_2
    //   744: sipush 200
    //   747: if_icmpne +251 -> 998
    //   750: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   753: lstore 6
    //   755: aload 11
    //   757: invokevirtual 241	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   760: astore 9
    //   762: aload_1
    //   763: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   766: lload 6
    //   768: lsub
    //   769: putfield 244	midas/x/ky:h	J
    //   772: new 246	java/io/ByteArrayOutputStream
    //   775: dup
    //   776: invokespecial 247	java/io/ByteArrayOutputStream:<init>	()V
    //   779: astore 10
    //   781: sipush 1024
    //   784: newarray byte
    //   786: astore 12
    //   788: aload 9
    //   790: aload 12
    //   792: invokevirtual 253	java/io/InputStream:read	([B)I
    //   795: istore_2
    //   796: iload_2
    //   797: ifle +15 -> 812
    //   800: aload 10
    //   802: aload 12
    //   804: iconst_0
    //   805: iload_2
    //   806: invokevirtual 256	java/io/ByteArrayOutputStream:write	([BII)V
    //   809: goto -21 -> 788
    //   812: aload 18
    //   814: new 165	java/lang/String
    //   817: dup
    //   818: aload 10
    //   820: invokevirtual 260	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   823: ldc 163
    //   825: invokespecial 263	java/lang/String:<init>	([BLjava/lang/String;)V
    //   828: putfield 266	midas/x/kz:b	Ljava/lang/String;
    //   831: new 62	java/lang/StringBuilder
    //   834: dup
    //   835: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   838: astore 12
    //   840: aload 12
    //   842: ldc_w 268
    //   845: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   848: pop
    //   849: aload 12
    //   851: aload 18
    //   853: getfield 266	midas/x/kz:b	Ljava/lang/String;
    //   856: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: pop
    //   860: ldc 71
    //   862: aload 12
    //   864: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   867: invokestatic 79	midas/x/ks:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   870: goto +131 -> 1001
    //   873: astore 13
    //   875: aload 10
    //   877: astore 12
    //   879: goto +28 -> 907
    //   882: astore 15
    //   884: goto +39 -> 923
    //   887: astore 15
    //   889: goto +54 -> 943
    //   892: astore 15
    //   894: goto +69 -> 963
    //   897: astore 15
    //   899: goto +84 -> 983
    //   902: astore 13
    //   904: aconst_null
    //   905: astore 12
    //   907: aload 11
    //   909: astore 10
    //   911: aload 13
    //   913: astore 11
    //   915: goto +731 -> 1646
    //   918: astore 15
    //   920: aconst_null
    //   921: astore 10
    //   923: aload 9
    //   925: astore 13
    //   927: aload 11
    //   929: astore 14
    //   931: aload 10
    //   933: astore 12
    //   935: goto +235 -> 1170
    //   938: astore 15
    //   940: aconst_null
    //   941: astore 10
    //   943: aload 9
    //   945: astore 13
    //   947: aload 11
    //   949: astore 14
    //   951: aload 10
    //   953: astore 12
    //   955: goto +328 -> 1283
    //   958: astore 15
    //   960: aconst_null
    //   961: astore 10
    //   963: aload 9
    //   965: astore 13
    //   967: aload 11
    //   969: astore 14
    //   971: aload 10
    //   973: astore 12
    //   975: goto +421 -> 1396
    //   978: astore 15
    //   980: aconst_null
    //   981: astore 10
    //   983: aload 9
    //   985: astore 13
    //   987: aload 11
    //   989: astore 14
    //   991: aload 10
    //   993: astore 12
    //   995: goto +514 -> 1509
    //   998: aconst_null
    //   999: astore 10
    //   1001: aload_0
    //   1002: aload 9
    //   1004: aload 10
    //   1006: invokespecial 88	midas/x/mc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   1009: aload 11
    //   1011: ifnull +8 -> 1019
    //   1014: aload 11
    //   1016: invokevirtual 271	java/net/HttpURLConnection:disconnect	()V
    //   1019: aload_1
    //   1020: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   1023: aload_1
    //   1024: getfield 91	midas/x/ky:e	J
    //   1027: lsub
    //   1028: putfield 93	midas/x/ky:f	J
    //   1031: aload 18
    //   1033: getfield 96	midas/x/kz:a	I
    //   1036: sipush 200
    //   1039: if_icmpeq +8 -> 1047
    //   1042: aload_1
    //   1043: iconst_1
    //   1044: putfield 100	midas/x/ky:j	Z
    //   1047: aload_0
    //   1048: aload_1
    //   1049: aload 18
    //   1051: invokespecial 103	midas/x/mc:b	(Lmidas/x/ky;Lmidas/x/kz;)V
    //   1054: new 62	java/lang/StringBuilder
    //   1057: dup
    //   1058: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1061: astore_1
    //   1062: goto +544 -> 1606
    //   1065: astore 13
    //   1067: aconst_null
    //   1068: astore 12
    //   1070: aload 14
    //   1072: astore 9
    //   1074: aload 11
    //   1076: astore 10
    //   1078: aload 13
    //   1080: astore 11
    //   1082: goto +564 -> 1646
    //   1085: astore 15
    //   1087: aconst_null
    //   1088: astore 12
    //   1090: aload 11
    //   1092: astore 14
    //   1094: goto +76 -> 1170
    //   1097: astore 15
    //   1099: aconst_null
    //   1100: astore 12
    //   1102: aload 10
    //   1104: astore 13
    //   1106: aload 11
    //   1108: astore 14
    //   1110: goto +173 -> 1283
    //   1113: astore 15
    //   1115: aconst_null
    //   1116: astore 12
    //   1118: aload 16
    //   1120: astore 13
    //   1122: aload 11
    //   1124: astore 14
    //   1126: goto +270 -> 1396
    //   1129: astore 15
    //   1131: aconst_null
    //   1132: astore 12
    //   1134: aload 17
    //   1136: astore 13
    //   1138: aload 11
    //   1140: astore 14
    //   1142: goto +367 -> 1509
    //   1145: astore 11
    //   1147: aconst_null
    //   1148: astore 10
    //   1150: aload 10
    //   1152: astore 12
    //   1154: aload 14
    //   1156: astore 9
    //   1158: goto +488 -> 1646
    //   1161: astore 15
    //   1163: aconst_null
    //   1164: astore 14
    //   1166: aload 14
    //   1168: astore 12
    //   1170: aload 13
    //   1172: astore 9
    //   1174: aload 14
    //   1176: astore 10
    //   1178: aload 12
    //   1180: astore 11
    //   1182: aload 15
    //   1184: invokevirtual 274	java/lang/Exception:printStackTrace	()V
    //   1187: aload 13
    //   1189: astore 9
    //   1191: aload 14
    //   1193: astore 10
    //   1195: aload 12
    //   1197: astore 11
    //   1199: aload 18
    //   1201: aload 15
    //   1203: putfield 277	midas/x/kz:c	Ljava/lang/Exception;
    //   1206: aload_0
    //   1207: aload 13
    //   1209: aload 12
    //   1211: invokespecial 88	midas/x/mc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   1214: aload 14
    //   1216: ifnull +8 -> 1224
    //   1219: aload 14
    //   1221: invokevirtual 271	java/net/HttpURLConnection:disconnect	()V
    //   1224: aload_1
    //   1225: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   1228: aload_1
    //   1229: getfield 91	midas/x/ky:e	J
    //   1232: lsub
    //   1233: putfield 93	midas/x/ky:f	J
    //   1236: aload 18
    //   1238: getfield 96	midas/x/kz:a	I
    //   1241: sipush 200
    //   1244: if_icmpeq +8 -> 1252
    //   1247: aload_1
    //   1248: iconst_1
    //   1249: putfield 100	midas/x/ky:j	Z
    //   1252: aload_0
    //   1253: aload_1
    //   1254: aload 18
    //   1256: invokespecial 103	midas/x/mc:b	(Lmidas/x/ky;Lmidas/x/kz;)V
    //   1259: new 62	java/lang/StringBuilder
    //   1262: dup
    //   1263: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1266: astore_1
    //   1267: goto +339 -> 1606
    //   1270: astore 15
    //   1272: aconst_null
    //   1273: astore 14
    //   1275: aload 14
    //   1277: astore 12
    //   1279: aload 10
    //   1281: astore 13
    //   1283: aload 13
    //   1285: astore 9
    //   1287: aload 14
    //   1289: astore 10
    //   1291: aload 12
    //   1293: astore 11
    //   1295: aload 15
    //   1297: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   1300: aload 13
    //   1302: astore 9
    //   1304: aload 14
    //   1306: astore 10
    //   1308: aload 12
    //   1310: astore 11
    //   1312: aload 18
    //   1314: aload 15
    //   1316: putfield 277	midas/x/kz:c	Ljava/lang/Exception;
    //   1319: aload_0
    //   1320: aload 13
    //   1322: aload 12
    //   1324: invokespecial 88	midas/x/mc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   1327: aload 14
    //   1329: ifnull +8 -> 1337
    //   1332: aload 14
    //   1334: invokevirtual 271	java/net/HttpURLConnection:disconnect	()V
    //   1337: aload_1
    //   1338: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   1341: aload_1
    //   1342: getfield 91	midas/x/ky:e	J
    //   1345: lsub
    //   1346: putfield 93	midas/x/ky:f	J
    //   1349: aload 18
    //   1351: getfield 96	midas/x/kz:a	I
    //   1354: sipush 200
    //   1357: if_icmpeq +8 -> 1365
    //   1360: aload_1
    //   1361: iconst_1
    //   1362: putfield 100	midas/x/ky:j	Z
    //   1365: aload_0
    //   1366: aload_1
    //   1367: aload 18
    //   1369: invokespecial 103	midas/x/mc:b	(Lmidas/x/ky;Lmidas/x/kz;)V
    //   1372: new 62	java/lang/StringBuilder
    //   1375: dup
    //   1376: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1379: astore_1
    //   1380: goto +226 -> 1606
    //   1383: astore 15
    //   1385: aconst_null
    //   1386: astore 14
    //   1388: aload 14
    //   1390: astore 12
    //   1392: aload 16
    //   1394: astore 13
    //   1396: aload 13
    //   1398: astore 9
    //   1400: aload 14
    //   1402: astore 10
    //   1404: aload 12
    //   1406: astore 11
    //   1408: aload 15
    //   1410: invokevirtual 279	java/net/SocketTimeoutException:printStackTrace	()V
    //   1413: aload 13
    //   1415: astore 9
    //   1417: aload 14
    //   1419: astore 10
    //   1421: aload 12
    //   1423: astore 11
    //   1425: aload 18
    //   1427: aload 15
    //   1429: putfield 277	midas/x/kz:c	Ljava/lang/Exception;
    //   1432: aload_0
    //   1433: aload 13
    //   1435: aload 12
    //   1437: invokespecial 88	midas/x/mc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   1440: aload 14
    //   1442: ifnull +8 -> 1450
    //   1445: aload 14
    //   1447: invokevirtual 271	java/net/HttpURLConnection:disconnect	()V
    //   1450: aload_1
    //   1451: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   1454: aload_1
    //   1455: getfield 91	midas/x/ky:e	J
    //   1458: lsub
    //   1459: putfield 93	midas/x/ky:f	J
    //   1462: aload 18
    //   1464: getfield 96	midas/x/kz:a	I
    //   1467: sipush 200
    //   1470: if_icmpeq +8 -> 1478
    //   1473: aload_1
    //   1474: iconst_1
    //   1475: putfield 100	midas/x/ky:j	Z
    //   1478: aload_0
    //   1479: aload_1
    //   1480: aload 18
    //   1482: invokespecial 103	midas/x/mc:b	(Lmidas/x/ky;Lmidas/x/kz;)V
    //   1485: new 62	java/lang/StringBuilder
    //   1488: dup
    //   1489: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1492: astore_1
    //   1493: goto +113 -> 1606
    //   1496: astore 15
    //   1498: aconst_null
    //   1499: astore 14
    //   1501: aload 14
    //   1503: astore 12
    //   1505: aload 17
    //   1507: astore 13
    //   1509: aload 13
    //   1511: astore 9
    //   1513: aload 14
    //   1515: astore 10
    //   1517: aload 12
    //   1519: astore 11
    //   1521: aload 15
    //   1523: invokevirtual 280	org/apache/http/conn/ConnectTimeoutException:printStackTrace	()V
    //   1526: aload 13
    //   1528: astore 9
    //   1530: aload 14
    //   1532: astore 10
    //   1534: aload 12
    //   1536: astore 11
    //   1538: aload 18
    //   1540: aload 15
    //   1542: putfield 277	midas/x/kz:c	Ljava/lang/Exception;
    //   1545: aload_0
    //   1546: aload 13
    //   1548: aload 12
    //   1550: invokespecial 88	midas/x/mc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   1553: aload 14
    //   1555: ifnull +8 -> 1563
    //   1558: aload 14
    //   1560: invokevirtual 271	java/net/HttpURLConnection:disconnect	()V
    //   1563: aload_1
    //   1564: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   1567: aload_1
    //   1568: getfield 91	midas/x/ky:e	J
    //   1571: lsub
    //   1572: putfield 93	midas/x/ky:f	J
    //   1575: aload 18
    //   1577: getfield 96	midas/x/kz:a	I
    //   1580: sipush 200
    //   1583: if_icmpeq +8 -> 1591
    //   1586: aload_1
    //   1587: iconst_1
    //   1588: putfield 100	midas/x/ky:j	Z
    //   1591: aload_0
    //   1592: aload_1
    //   1593: aload 18
    //   1595: invokespecial 103	midas/x/mc:b	(Lmidas/x/ky;Lmidas/x/kz;)V
    //   1598: new 62	java/lang/StringBuilder
    //   1601: dup
    //   1602: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1605: astore_1
    //   1606: aload_1
    //   1607: ldc 105
    //   1609: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1612: pop
    //   1613: aload_1
    //   1614: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   1617: lload 4
    //   1619: lsub
    //   1620: invokevirtual 108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1623: pop
    //   1624: ldc 110
    //   1626: aload_1
    //   1627: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1630: invokestatic 79	midas/x/ks:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1633: aload 18
    //   1635: areturn
    //   1636: astore 13
    //   1638: aload 11
    //   1640: astore 12
    //   1642: aload 13
    //   1644: astore 11
    //   1646: aload_0
    //   1647: aload 9
    //   1649: aload 12
    //   1651: invokespecial 88	midas/x/mc:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   1654: aload 10
    //   1656: ifnull +8 -> 1664
    //   1659: aload 10
    //   1661: invokevirtual 271	java/net/HttpURLConnection:disconnect	()V
    //   1664: aload_1
    //   1665: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   1668: aload_1
    //   1669: getfield 91	midas/x/ky:e	J
    //   1672: lsub
    //   1673: putfield 93	midas/x/ky:f	J
    //   1676: aload 18
    //   1678: getfield 96	midas/x/kz:a	I
    //   1681: sipush 200
    //   1684: if_icmpeq +8 -> 1692
    //   1687: aload_1
    //   1688: iconst_1
    //   1689: putfield 100	midas/x/ky:j	Z
    //   1692: aload_0
    //   1693: aload_1
    //   1694: aload 18
    //   1696: invokespecial 103	midas/x/mc:b	(Lmidas/x/ky;Lmidas/x/kz;)V
    //   1699: new 62	java/lang/StringBuilder
    //   1702: dup
    //   1703: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   1706: astore_1
    //   1707: aload_1
    //   1708: ldc 105
    //   1710: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1713: pop
    //   1714: aload_1
    //   1715: invokestatic 39	java/lang/System:currentTimeMillis	()J
    //   1718: lload 4
    //   1720: lsub
    //   1721: invokevirtual 108	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1724: pop
    //   1725: ldc 110
    //   1727: aload_1
    //   1728: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1731: invokestatic 79	midas/x/ks:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1734: aload 11
    //   1736: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1737	0	this	mc
    //   0	1737	1	paramky	ky
    //   537	269	2	i	int
    //   535	11	3	j	int
    //   3	1716	4	l1	long
    //   580	187	6	l2	long
    //   107	192	8	bool	boolean
    //   55	1593	9	localObject1	Object
    //   43	1617	10	localObject2	Object
    //   65	1074	11	localObject3	Object
    //   1145	1	11	localObject4	Object
    //   1180	555	11	localObject5	Object
    //   74	525	12	localObject6	Object
    //   657	22	12	localIOException1	java.io.IOException
    //   710	940	12	localObject7	Object
    //   40	1	13	localObject8	Object
    //   873	1	13	localObject9	Object
    //   902	10	13	localObject10	Object
    //   925	61	13	localObject11	Object
    //   1065	14	13	localObject12	Object
    //   1104	443	13	localObject13	Object
    //   1636	7	13	localObject14	Object
    //   52	1507	14	localObject15	Object
    //   495	195	15	localObject16	Object
    //   882	1	15	localException1	Exception
    //   887	1	15	localIOException2	java.io.IOException
    //   892	1	15	localSocketTimeoutException1	java.net.SocketTimeoutException
    //   897	1	15	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   918	1	15	localException2	Exception
    //   938	1	15	localIOException3	java.io.IOException
    //   958	1	15	localSocketTimeoutException2	java.net.SocketTimeoutException
    //   978	1	15	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   1085	1	15	localException3	Exception
    //   1097	1	15	localIOException4	java.io.IOException
    //   1113	1	15	localSocketTimeoutException3	java.net.SocketTimeoutException
    //   1129	1	15	localConnectTimeoutException3	org.apache.http.conn.ConnectTimeoutException
    //   1161	41	15	localException4	Exception
    //   1270	45	15	localIOException5	java.io.IOException
    //   1383	45	15	localSocketTimeoutException4	java.net.SocketTimeoutException
    //   1496	45	15	localConnectTimeoutException4	org.apache.http.conn.ConnectTimeoutException
    //   46	1347	16	localObject17	Object
    //   49	1457	17	localObject18	Object
    //   12	1683	18	localkz	kz
    // Exception table:
    //   from	to	target	type
    //   649	654	657	java/io/IOException
    //   781	788	873	finally
    //   788	796	873	finally
    //   800	809	873	finally
    //   812	870	873	finally
    //   781	788	882	java/lang/Exception
    //   788	796	882	java/lang/Exception
    //   800	809	882	java/lang/Exception
    //   812	870	882	java/lang/Exception
    //   781	788	887	java/io/IOException
    //   788	796	887	java/io/IOException
    //   800	809	887	java/io/IOException
    //   812	870	887	java/io/IOException
    //   781	788	892	java/net/SocketTimeoutException
    //   788	796	892	java/net/SocketTimeoutException
    //   800	809	892	java/net/SocketTimeoutException
    //   812	870	892	java/net/SocketTimeoutException
    //   781	788	897	org/apache/http/conn/ConnectTimeoutException
    //   788	796	897	org/apache/http/conn/ConnectTimeoutException
    //   800	809	897	org/apache/http/conn/ConnectTimeoutException
    //   812	870	897	org/apache/http/conn/ConnectTimeoutException
    //   762	781	902	finally
    //   762	781	918	java/lang/Exception
    //   762	781	938	java/io/IOException
    //   762	781	958	java/net/SocketTimeoutException
    //   762	781	978	org/apache/http/conn/ConnectTimeoutException
    //   389	536	1065	finally
    //   538	560	1065	finally
    //   560	639	1065	finally
    //   639	649	1065	finally
    //   649	654	1065	finally
    //   659	697	1065	finally
    //   697	743	1065	finally
    //   750	762	1065	finally
    //   389	536	1085	java/lang/Exception
    //   538	560	1085	java/lang/Exception
    //   560	639	1085	java/lang/Exception
    //   639	649	1085	java/lang/Exception
    //   649	654	1085	java/lang/Exception
    //   659	697	1085	java/lang/Exception
    //   697	743	1085	java/lang/Exception
    //   750	762	1085	java/lang/Exception
    //   389	536	1097	java/io/IOException
    //   538	560	1097	java/io/IOException
    //   560	639	1097	java/io/IOException
    //   639	649	1097	java/io/IOException
    //   659	697	1097	java/io/IOException
    //   697	743	1097	java/io/IOException
    //   750	762	1097	java/io/IOException
    //   389	536	1113	java/net/SocketTimeoutException
    //   538	560	1113	java/net/SocketTimeoutException
    //   560	639	1113	java/net/SocketTimeoutException
    //   639	649	1113	java/net/SocketTimeoutException
    //   649	654	1113	java/net/SocketTimeoutException
    //   659	697	1113	java/net/SocketTimeoutException
    //   697	743	1113	java/net/SocketTimeoutException
    //   750	762	1113	java/net/SocketTimeoutException
    //   389	536	1129	org/apache/http/conn/ConnectTimeoutException
    //   538	560	1129	org/apache/http/conn/ConnectTimeoutException
    //   560	639	1129	org/apache/http/conn/ConnectTimeoutException
    //   639	649	1129	org/apache/http/conn/ConnectTimeoutException
    //   649	654	1129	org/apache/http/conn/ConnectTimeoutException
    //   659	697	1129	org/apache/http/conn/ConnectTimeoutException
    //   697	743	1129	org/apache/http/conn/ConnectTimeoutException
    //   750	762	1129	org/apache/http/conn/ConnectTimeoutException
    //   57	109	1145	finally
    //   193	207	1145	finally
    //   291	298	1145	finally
    //   382	389	1145	finally
    //   57	109	1161	java/lang/Exception
    //   193	207	1161	java/lang/Exception
    //   291	298	1161	java/lang/Exception
    //   382	389	1161	java/lang/Exception
    //   57	109	1270	java/io/IOException
    //   193	207	1270	java/io/IOException
    //   291	298	1270	java/io/IOException
    //   382	389	1270	java/io/IOException
    //   57	109	1383	java/net/SocketTimeoutException
    //   193	207	1383	java/net/SocketTimeoutException
    //   291	298	1383	java/net/SocketTimeoutException
    //   382	389	1383	java/net/SocketTimeoutException
    //   57	109	1496	org/apache/http/conn/ConnectTimeoutException
    //   193	207	1496	org/apache/http/conn/ConnectTimeoutException
    //   291	298	1496	org/apache/http/conn/ConnectTimeoutException
    //   382	389	1496	org/apache/http/conn/ConnectTimeoutException
    //   1182	1187	1636	finally
    //   1199	1206	1636	finally
    //   1295	1300	1636	finally
    //   1312	1319	1636	finally
    //   1408	1413	1636	finally
    //   1425	1432	1636	finally
    //   1521	1526	1636	finally
    //   1538	1545	1636	finally
  }
  
  private void a(DataOutputStream paramDataOutputStream, me paramme)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("encode file length: ");
      ((StringBuilder)localObject).append(paramme.a().length());
      ks.b("HTTP-UPLOAD", ((StringBuilder)localObject).toString());
      paramme = new FileInputStream(paramme.a());
      localObject = new byte[4096];
      for (;;)
      {
        int i = paramme.read((byte[])localObject);
        if (i == -1) {
          break;
        }
        paramDataOutputStream.write((byte[])localObject, 0, i);
      }
      paramDataOutputStream.flush();
      return;
    }
    catch (Exception paramDataOutputStream)
    {
      paramDataOutputStream.printStackTrace();
      paramme = new StringBuilder();
      paramme.append("write http out failed: ");
      paramme.append(Arrays.toString(paramDataOutputStream.getStackTrace()));
      ks.a("HTTP-UPLOAD", paramme.toString());
    }
  }
  
  private void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    if (paramInputStream != null) {
      try
      {
        paramInputStream.close();
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
    if (paramOutputStream != null) {
      try
      {
        paramOutputStream.flush();
        paramOutputStream.close();
        return;
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
    }
  }
  
  private void a(HttpURLConnection paramHttpURLConnection, ky paramky)
  {
    if (paramHttpURLConnection == null) {
      return;
    }
    if (this.b != null)
    {
      k = this.b.a;
      j = this.b.b;
    }
    else
    {
      k = 15000;
      j = 15000;
    }
    int i = k;
    if (paramky != null)
    {
      i = k;
      if (paramky.n > 0) {
        i = paramky.n;
      }
    }
    if ((paramky != null) && (paramky.o > 0)) {
      j = paramky.o;
    }
    int k = i;
    if (i > 20000) {
      k = 20000;
    }
    int m = k;
    if (k <= 0) {
      m = 15000;
    }
    i = j;
    if (j > 20000) {
      i = 15000;
    }
    int j = i;
    if (i <= 0) {
      j = 15000;
    }
    paramHttpURLConnection.setConnectTimeout(m);
    paramHttpURLConnection.setReadTimeout(j);
  }
  
  private static void b(HttpURLConnection paramHttpURLConnection, ky paramky)
  {
    if (paramHttpURLConnection == null) {
      return;
    }
    if (paramky == null) {
      return;
    }
    if (!paramky.n()) {
      return;
    }
    if (!(paramHttpURLConnection instanceof HttpsURLConnection)) {
      return;
    }
    paramHttpURLConnection = (HttpsURLConnection)paramHttpURLConnection;
    HostnameVerifier localHostnameVerifier = paramky.i();
    if (localHostnameVerifier != null) {
      paramHttpURLConnection.setHostnameVerifier(localHostnameVerifier);
    }
    paramky = paramky.j();
    if (paramky != null) {
      paramHttpURLConnection.setSSLSocketFactory(paramky);
    }
  }
  
  private void b(ky paramky)
  {
    if (this.a.size() == 0) {
      return;
    }
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((kq)localIterator.next()).a(paramky);
    }
  }
  
  private void b(ky paramky, kz paramkz)
  {
    if (this.a.size() == 0) {
      return;
    }
    int i = this.a.size();
    ListIterator localListIterator = this.a.listIterator(i);
    while (localListIterator.hasPrevious()) {
      ((kq)localListIterator.previous()).a(paramky, paramkz);
    }
  }
  
  private void c(HttpURLConnection paramHttpURLConnection, ky paramky)
  {
    if (paramky == null) {
      return;
    }
    paramky = paramky.l();
    if (paramky == null) {
      return;
    }
    if (paramky.size() <= 0) {
      return;
    }
    paramky = paramky.entrySet().iterator();
    while (paramky.hasNext())
    {
      Object localObject = (Map.Entry)paramky.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (String)((Map.Entry)localObject).getValue();
      if (!TextUtils.isEmpty(str)) {
        paramHttpURLConnection.setRequestProperty(str, (String)localObject);
      }
    }
  }
  
  public kz a(ky paramky, kz paramkz)
  {
    if (paramky == null) {
      return paramkz;
    }
    return a(paramky);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.mc
 * JD-Core Version:    0.7.0.1
 */