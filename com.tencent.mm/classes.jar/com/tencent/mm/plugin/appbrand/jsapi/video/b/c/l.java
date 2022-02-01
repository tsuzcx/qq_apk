package com.tencent.mm.plugin.appbrand.jsapi.video.b.c;

import android.text.TextUtils;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class l
{
  private static volatile l kQZ;
  public m kRa;
  private Set<String> kRb;
  
  private l()
  {
    AppMethodBeat.i(194283);
    this.kRb = Collections.synchronizedSet(new HashSet());
    this.kRa = new m();
    AppMethodBeat.o(194283);
  }
  
  /* Error */
  private boolean a(String paramString, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: ldc 147
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 37	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/l:kRb	Ljava/util/Set;
    //   9: aload_1
    //   10: invokeinterface 153 2 0
    //   15: ifeq +25 -> 40
    //   18: iconst_4
    //   19: ldc 155
    //   21: ldc 157
    //   23: aload_1
    //   24: invokestatic 66	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   27: invokevirtual 70	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   30: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   33: ldc 147
    //   35: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   38: iconst_0
    //   39: ireturn
    //   40: aload_0
    //   41: getfield 42	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/l:kRa	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/c/m;
    //   44: aload_1
    //   45: iconst_1
    //   46: iconst_1
    //   47: ldc 159
    //   49: bipush 10
    //   51: invokevirtual 162	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/m:a	(Ljava/lang/String;ZZLjava/lang/String;I)Ljava/lang/String;
    //   54: astore 29
    //   56: aload 29
    //   58: invokestatic 165	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:NA	(Ljava/lang/String;)Ljava/lang/String;
    //   61: astore 27
    //   63: ldc 167
    //   65: aload 27
    //   67: invokestatic 66	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   70: invokevirtual 70	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   73: astore 28
    //   75: iconst_4
    //   76: aload 28
    //   78: new 114	java/lang/StringBuilder
    //   81: dup
    //   82: ldc 169
    //   84: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: lload_2
    //   88: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   91: ldc 171
    //   93: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: aload_1
    //   97: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   106: aload_0
    //   107: getfield 37	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/l:kRb	Ljava/util/Set;
    //   110: aload_1
    //   111: invokeinterface 174 2 0
    //   116: pop
    //   117: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   120: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   123: aload 27
    //   125: aload_1
    //   126: invokeinterface 190 3 0
    //   131: iload 7
    //   133: ifeq +2072 -> 2205
    //   136: lconst_0
    //   137: lstore 10
    //   139: aload 29
    //   141: ifnull +2064 -> 2205
    //   144: new 53	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j
    //   147: dup
    //   148: ldc 55
    //   150: invokespecial 58	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:<init>	(Ljava/lang/String;)V
    //   153: astore 30
    //   155: sipush 512
    //   158: newarray byte
    //   160: astore 26
    //   162: lload 10
    //   164: lstore 16
    //   166: aload 30
    //   168: new 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g
    //   171: dup
    //   172: aload 29
    //   174: invokestatic 88	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   177: lconst_0
    //   178: invokespecial 91	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g:<init>	(Landroid/net/Uri;J)V
    //   181: invokeinterface 96 2 0
    //   186: pop2
    //   187: lload 10
    //   189: lstore 16
    //   191: aload 30
    //   193: invokeinterface 100 1 0
    //   198: lstore 12
    //   200: lload_2
    //   201: lstore 14
    //   203: lload_2
    //   204: ldc2_w 71
    //   207: lcmp
    //   208: ifne +7 -> 215
    //   211: lload 12
    //   213: lstore 14
    //   215: lload 4
    //   217: ldc2_w 191
    //   220: lcmp
    //   221: ifle +276 -> 497
    //   224: lload 10
    //   226: lstore 22
    //   228: lload 14
    //   230: lstore 20
    //   232: lload 10
    //   234: lstore 16
    //   236: lload 10
    //   238: lstore 24
    //   240: lload 14
    //   242: lstore 18
    //   244: ldc2_w 193
    //   247: lload 12
    //   249: lmul
    //   250: lload 4
    //   252: ldiv
    //   253: l2i
    //   254: sipush 1000
    //   257: imul
    //   258: istore 9
    //   260: lload 10
    //   262: lstore 22
    //   264: lload 14
    //   266: lstore 20
    //   268: lload 10
    //   270: lstore 16
    //   272: lload 10
    //   274: lstore 24
    //   276: lload 14
    //   278: lstore 18
    //   280: iload 6
    //   282: sipush 1000
    //   285: idiv
    //   286: iload 9
    //   288: imul
    //   289: bipush 8
    //   291: idiv
    //   292: istore 6
    //   294: lload 10
    //   296: lstore 22
    //   298: lload 14
    //   300: lstore 20
    //   302: lload 10
    //   304: lstore 16
    //   306: lload 10
    //   308: lstore 24
    //   310: lload 14
    //   312: lstore 18
    //   314: ldc2_w 195
    //   317: lload 4
    //   319: ldc2_w 197
    //   322: ldiv
    //   323: lmul
    //   324: lstore 4
    //   326: lload 10
    //   328: lstore 22
    //   330: lload 14
    //   332: lstore 20
    //   334: lload 10
    //   336: lstore 16
    //   338: lload 10
    //   340: lstore 24
    //   342: lload 14
    //   344: lstore 18
    //   346: lload 14
    //   348: iload 6
    //   350: i2l
    //   351: lload 4
    //   353: ladd
    //   354: invokestatic 204	java/lang/Math:min	(JJ)J
    //   357: lstore_2
    //   358: lload 10
    //   360: lstore 22
    //   362: lload_2
    //   363: lstore 20
    //   365: lload 10
    //   367: lstore 16
    //   369: lload 10
    //   371: lstore 24
    //   373: lload_2
    //   374: lstore 18
    //   376: iconst_4
    //   377: aload 28
    //   379: new 114	java/lang/StringBuilder
    //   382: dup
    //   383: ldc 206
    //   385: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   388: iload 9
    //   390: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   393: ldc 211
    //   395: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: lload 4
    //   400: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   403: ldc 213
    //   405: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: iload 6
    //   410: invokevirtual 209	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   413: ldc 215
    //   415: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: lload_2
    //   419: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   422: ldc 171
    //   424: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_1
    //   428: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   434: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   437: lload 10
    //   439: lload_2
    //   440: lcmp
    //   441: ifge +559 -> 1000
    //   444: lload 10
    //   446: lstore 22
    //   448: lload_2
    //   449: lstore 20
    //   451: lload 10
    //   453: lstore 16
    //   455: lload 10
    //   457: lstore 24
    //   459: lload_2
    //   460: lstore 18
    //   462: aload 30
    //   464: aload 26
    //   466: iconst_0
    //   467: sipush 512
    //   470: invokeinterface 104 4 0
    //   475: i2l
    //   476: lstore 4
    //   478: lload 4
    //   480: ldc2_w 71
    //   483: lcmp
    //   484: ifeq +516 -> 1000
    //   487: lload 10
    //   489: lload 4
    //   491: ladd
    //   492: lstore 10
    //   494: goto -57 -> 437
    //   497: lload 10
    //   499: lstore 22
    //   501: lload 14
    //   503: lstore 20
    //   505: lload 10
    //   507: lstore 16
    //   509: lload 10
    //   511: lstore 24
    //   513: lload 14
    //   515: lstore 18
    //   517: iconst_4
    //   518: aload 28
    //   520: new 114	java/lang/StringBuilder
    //   523: dup
    //   524: ldc 217
    //   526: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   529: aload_1
    //   530: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: ldc 219
    //   535: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: lload 14
    //   540: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   543: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   549: lload 14
    //   551: lstore_2
    //   552: goto -115 -> 437
    //   555: astore 26
    //   557: lload 20
    //   559: lstore_2
    //   560: lload 22
    //   562: lstore 10
    //   564: lload 10
    //   566: lstore 16
    //   568: aload 26
    //   570: invokevirtual 223	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a:getCause	()Ljava/lang/Throwable;
    //   573: instanceof 225
    //   576: ifeq +635 -> 1211
    //   579: lload 10
    //   581: lstore 16
    //   583: aload 26
    //   585: invokevirtual 226	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a:getMessage	()Ljava/lang/String;
    //   588: ifnull +496 -> 1084
    //   591: lload 10
    //   593: lstore 16
    //   595: aload 26
    //   597: invokevirtual 226	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a:getMessage	()Ljava/lang/String;
    //   600: invokevirtual 229	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   603: ldc 231
    //   605: invokevirtual 234	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   608: ifeq +476 -> 1084
    //   611: lload 10
    //   613: lstore 16
    //   615: iconst_4
    //   616: aload 28
    //   618: ldc 236
    //   620: lload 10
    //   622: invokestatic 109	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   625: invokevirtual 70	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   628: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   631: lload 10
    //   633: lstore 16
    //   635: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   638: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   641: aload 27
    //   643: aload_1
    //   644: bipush 155
    //   646: invokeinterface 240 4 0
    //   651: iconst_3
    //   652: aload 28
    //   654: new 114	java/lang/StringBuilder
    //   657: dup
    //   658: ldc 242
    //   660: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   663: lload 10
    //   665: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   668: ldc 244
    //   670: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   679: aload 30
    //   681: invokeinterface 112 1 0
    //   686: iconst_4
    //   687: aload 28
    //   689: ldc 246
    //   691: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   694: iload 8
    //   696: ifeq +871 -> 1567
    //   699: lconst_0
    //   700: lstore 4
    //   702: aload 29
    //   704: ifnull +863 -> 1567
    //   707: new 53	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j
    //   710: dup
    //   711: ldc 55
    //   713: invokespecial 58	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/j:<init>	(Ljava/lang/String;)V
    //   716: astore 26
    //   718: sipush 512
    //   721: newarray byte
    //   723: astore 30
    //   725: lload 12
    //   727: lstore 10
    //   729: lload 12
    //   731: ldc2_w 71
    //   734: lcmp
    //   735: ifne +1478 -> 2213
    //   738: lload 4
    //   740: lstore 12
    //   742: lload 4
    //   744: lstore 10
    //   746: lload 4
    //   748: lstore 14
    //   750: aload 26
    //   752: new 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g
    //   755: dup
    //   756: aload 29
    //   758: invokestatic 88	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   761: lconst_0
    //   762: invokespecial 91	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g:<init>	(Landroid/net/Uri;J)V
    //   765: invokeinterface 96 2 0
    //   770: pop2
    //   771: lload 4
    //   773: lstore 12
    //   775: lload 4
    //   777: lstore 10
    //   779: lload 4
    //   781: lstore 14
    //   783: aload 26
    //   785: invokeinterface 100 1 0
    //   790: lstore 16
    //   792: lload 4
    //   794: lstore 12
    //   796: lload 4
    //   798: lstore 10
    //   800: lload 4
    //   802: lstore 14
    //   804: aload 26
    //   806: invokeinterface 112 1 0
    //   811: lload 16
    //   813: lstore 10
    //   815: goto +1398 -> 2213
    //   818: ldc 247
    //   820: lload 10
    //   822: l2f
    //   823: fmul
    //   824: f2l
    //   825: lstore_2
    //   826: lload 10
    //   828: lload 12
    //   830: lsub
    //   831: lstore 16
    //   833: lload 4
    //   835: lstore 12
    //   837: lload 4
    //   839: lstore 10
    //   841: lload 4
    //   843: lstore 14
    //   845: lload 16
    //   847: lload_2
    //   848: invokestatic 250	java/lang/Math:max	(JJ)J
    //   851: lstore 18
    //   853: lload 4
    //   855: lstore 12
    //   857: lload 4
    //   859: lstore 10
    //   861: lload 4
    //   863: lstore 14
    //   865: iconst_4
    //   866: aload 28
    //   868: new 114	java/lang/StringBuilder
    //   871: dup
    //   872: ldc 252
    //   874: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   877: lload_2
    //   878: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   881: ldc 254
    //   883: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: lload 16
    //   888: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   891: ldc_w 256
    //   894: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   897: lload 18
    //   899: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   902: ldc 171
    //   904: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   907: aload_1
    //   908: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   917: lload 4
    //   919: lstore 12
    //   921: lload 4
    //   923: lstore 10
    //   925: lload 4
    //   927: lstore 14
    //   929: aload 26
    //   931: new 82	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g
    //   934: dup
    //   935: aload 29
    //   937: invokestatic 88	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   940: lload 18
    //   942: invokespecial 91	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/g:<init>	(Landroid/net/Uri;J)V
    //   945: invokeinterface 96 2 0
    //   950: pop2
    //   951: lload 4
    //   953: lstore_2
    //   954: lload_2
    //   955: lstore 12
    //   957: lload_2
    //   958: lstore 10
    //   960: lload_2
    //   961: lstore 14
    //   963: aload 26
    //   965: aload 30
    //   967: iconst_0
    //   968: sipush 512
    //   971: invokeinterface 104 4 0
    //   976: istore 6
    //   978: iload 6
    //   980: i2l
    //   981: lstore 4
    //   983: lload 4
    //   985: ldc2_w 71
    //   988: lcmp
    //   989: ifeq +534 -> 1523
    //   992: lload_2
    //   993: lload 4
    //   995: ladd
    //   996: lstore_2
    //   997: goto -43 -> 954
    //   1000: iconst_3
    //   1001: aload 28
    //   1003: new 114	java/lang/StringBuilder
    //   1006: dup
    //   1007: ldc 242
    //   1009: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1012: lload 10
    //   1014: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1017: ldc 244
    //   1019: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1022: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1025: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1028: aload 30
    //   1030: invokeinterface 112 1 0
    //   1035: iconst_4
    //   1036: aload 28
    //   1038: ldc 246
    //   1040: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1043: goto -349 -> 694
    //   1046: astore 26
    //   1048: iconst_4
    //   1049: aload 28
    //   1051: ldc_w 258
    //   1054: aload 26
    //   1056: invokestatic 66	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1059: invokevirtual 70	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1062: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1065: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1068: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1071: aload 27
    //   1073: aload_1
    //   1074: bipush 151
    //   1076: invokeinterface 240 4 0
    //   1081: goto -387 -> 694
    //   1084: lload 10
    //   1086: lstore 16
    //   1088: iconst_5
    //   1089: aload 28
    //   1091: new 114	java/lang/StringBuilder
    //   1094: dup
    //   1095: ldc_w 260
    //   1098: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1101: lload_2
    //   1102: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1105: ldc_w 262
    //   1108: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1111: aload_1
    //   1112: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1115: ldc_w 264
    //   1118: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: aload 26
    //   1123: invokestatic 268	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1126: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1129: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1132: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1135: lload 10
    //   1137: lstore 16
    //   1139: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1142: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1145: aload 27
    //   1147: aload_1
    //   1148: bipush 154
    //   1150: invokeinterface 240 4 0
    //   1155: goto -504 -> 651
    //   1158: astore 26
    //   1160: iconst_3
    //   1161: aload 28
    //   1163: new 114	java/lang/StringBuilder
    //   1166: dup
    //   1167: ldc 242
    //   1169: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1172: lload 16
    //   1174: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1177: ldc 244
    //   1179: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1182: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1185: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1188: aload 30
    //   1190: invokeinterface 112 1 0
    //   1195: iconst_4
    //   1196: aload 28
    //   1198: ldc 246
    //   1200: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1203: ldc 147
    //   1205: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1208: aload 26
    //   1210: athrow
    //   1211: lload 10
    //   1213: lstore 16
    //   1215: iconst_5
    //   1216: aload 28
    //   1218: new 114	java/lang/StringBuilder
    //   1221: dup
    //   1222: ldc_w 260
    //   1225: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1228: lload_2
    //   1229: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1232: ldc_w 262
    //   1235: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1238: aload_1
    //   1239: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: ldc_w 270
    //   1245: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1248: aload 26
    //   1250: invokestatic 268	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1253: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1256: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1259: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1262: lload 10
    //   1264: lstore 16
    //   1266: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1269: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1272: aload 27
    //   1274: aload_1
    //   1275: bipush 153
    //   1277: invokeinterface 240 4 0
    //   1282: goto -631 -> 651
    //   1285: astore 26
    //   1287: iconst_4
    //   1288: aload 28
    //   1290: ldc_w 258
    //   1293: aload 26
    //   1295: invokestatic 66	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1298: invokevirtual 70	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1301: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1304: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1307: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1310: aload 27
    //   1312: aload_1
    //   1313: bipush 151
    //   1315: invokeinterface 240 4 0
    //   1320: goto -626 -> 694
    //   1323: astore 26
    //   1325: ldc2_w 71
    //   1328: lstore 12
    //   1330: lload 10
    //   1332: lstore 16
    //   1334: iconst_5
    //   1335: aload 28
    //   1337: new 114	java/lang/StringBuilder
    //   1340: dup
    //   1341: ldc_w 260
    //   1344: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1347: lload_2
    //   1348: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1351: ldc_w 262
    //   1354: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: aload_1
    //   1358: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1361: ldc_w 272
    //   1364: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: aload 26
    //   1369: invokestatic 268	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1372: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1375: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1378: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1381: lload 10
    //   1383: lstore 16
    //   1385: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1388: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1391: aload 27
    //   1393: aload_1
    //   1394: bipush 152
    //   1396: invokeinterface 240 4 0
    //   1401: iconst_3
    //   1402: aload 28
    //   1404: new 114	java/lang/StringBuilder
    //   1407: dup
    //   1408: ldc 242
    //   1410: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1413: lload 10
    //   1415: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1418: ldc 244
    //   1420: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1423: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1426: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1429: aload 30
    //   1431: invokeinterface 112 1 0
    //   1436: iconst_4
    //   1437: aload 28
    //   1439: ldc 246
    //   1441: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1444: goto -750 -> 694
    //   1447: astore 26
    //   1449: iconst_4
    //   1450: aload 28
    //   1452: ldc_w 258
    //   1455: aload 26
    //   1457: invokestatic 66	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1460: invokevirtual 70	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1463: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1466: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1469: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1472: aload 27
    //   1474: aload_1
    //   1475: bipush 151
    //   1477: invokeinterface 240 4 0
    //   1482: goto -788 -> 694
    //   1485: astore 29
    //   1487: iconst_4
    //   1488: aload 28
    //   1490: ldc_w 258
    //   1493: aload 29
    //   1495: invokestatic 66	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1498: invokevirtual 70	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1501: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1504: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1507: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1510: aload 27
    //   1512: aload_1
    //   1513: bipush 151
    //   1515: invokeinterface 240 4 0
    //   1520: goto -317 -> 1203
    //   1523: iconst_3
    //   1524: aload 28
    //   1526: new 114	java/lang/StringBuilder
    //   1529: dup
    //   1530: ldc_w 274
    //   1533: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1536: lload_2
    //   1537: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1540: ldc 244
    //   1542: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1545: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1548: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1551: aload 26
    //   1553: invokeinterface 112 1 0
    //   1558: iconst_4
    //   1559: aload 28
    //   1561: ldc_w 276
    //   1564: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1567: aload_0
    //   1568: getfield 37	com/tencent/mm/plugin/appbrand/jsapi/video/b/c/l:kRb	Ljava/util/Set;
    //   1571: aload_1
    //   1572: invokeinterface 279 2 0
    //   1577: pop
    //   1578: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1581: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1584: aload 27
    //   1586: aload_1
    //   1587: invokeinterface 282 3 0
    //   1592: ldc 147
    //   1594: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1597: iconst_1
    //   1598: ireturn
    //   1599: astore 26
    //   1601: iconst_4
    //   1602: aload 28
    //   1604: ldc_w 284
    //   1607: aload 26
    //   1609: invokestatic 66	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1612: invokevirtual 70	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1615: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1618: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1621: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1624: aload 27
    //   1626: aload_1
    //   1627: bipush 151
    //   1629: invokeinterface 240 4 0
    //   1634: goto -67 -> 1567
    //   1637: astore 29
    //   1639: lload 12
    //   1641: lstore 10
    //   1643: aload 29
    //   1645: invokevirtual 223	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a:getCause	()Ljava/lang/Throwable;
    //   1648: instanceof 225
    //   1651: ifeq +281 -> 1932
    //   1654: lload 12
    //   1656: lstore 10
    //   1658: aload 29
    //   1660: invokevirtual 226	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a:getMessage	()Ljava/lang/String;
    //   1663: ifnull +150 -> 1813
    //   1666: lload 12
    //   1668: lstore 10
    //   1670: aload 29
    //   1672: invokevirtual 226	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a:getMessage	()Ljava/lang/String;
    //   1675: invokevirtual 229	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1678: ldc 231
    //   1680: invokevirtual 234	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1683: ifeq +130 -> 1813
    //   1686: lload 12
    //   1688: lstore 10
    //   1690: iconst_4
    //   1691: aload 28
    //   1693: ldc_w 286
    //   1696: lload 12
    //   1698: invokestatic 109	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1701: invokevirtual 70	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1704: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1707: lload 12
    //   1709: lstore 10
    //   1711: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1714: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1717: aload 27
    //   1719: aload_1
    //   1720: bipush 155
    //   1722: invokeinterface 240 4 0
    //   1727: iconst_3
    //   1728: aload 28
    //   1730: new 114	java/lang/StringBuilder
    //   1733: dup
    //   1734: ldc_w 274
    //   1737: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1740: lload 12
    //   1742: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1745: ldc 244
    //   1747: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1750: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1753: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1756: aload 26
    //   1758: invokeinterface 112 1 0
    //   1763: iconst_4
    //   1764: aload 28
    //   1766: ldc_w 276
    //   1769: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1772: goto -205 -> 1567
    //   1775: astore 26
    //   1777: iconst_4
    //   1778: aload 28
    //   1780: ldc_w 284
    //   1783: aload 26
    //   1785: invokestatic 66	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1788: invokevirtual 70	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1791: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1794: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1797: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1800: aload 27
    //   1802: aload_1
    //   1803: bipush 151
    //   1805: invokeinterface 240 4 0
    //   1810: goto -243 -> 1567
    //   1813: lload 12
    //   1815: lstore 10
    //   1817: iconst_5
    //   1818: aload 28
    //   1820: new 114	java/lang/StringBuilder
    //   1823: dup
    //   1824: ldc_w 288
    //   1827: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1830: aload_1
    //   1831: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1834: ldc_w 264
    //   1837: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1840: aload 29
    //   1842: invokestatic 268	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1845: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1848: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1851: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1854: lload 12
    //   1856: lstore 10
    //   1858: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1861: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1864: aload 27
    //   1866: aload_1
    //   1867: bipush 154
    //   1869: invokeinterface 240 4 0
    //   1874: goto -147 -> 1727
    //   1877: astore 29
    //   1879: iconst_3
    //   1880: aload 28
    //   1882: new 114	java/lang/StringBuilder
    //   1885: dup
    //   1886: ldc_w 274
    //   1889: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1892: lload 10
    //   1894: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1897: ldc 244
    //   1899: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1902: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1905: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1908: aload 26
    //   1910: invokeinterface 112 1 0
    //   1915: iconst_4
    //   1916: aload 28
    //   1918: ldc_w 276
    //   1921: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1924: ldc 147
    //   1926: invokestatic 45	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1929: aload 29
    //   1931: athrow
    //   1932: lload 12
    //   1934: lstore 10
    //   1936: iconst_5
    //   1937: aload 28
    //   1939: new 114	java/lang/StringBuilder
    //   1942: dup
    //   1943: ldc_w 288
    //   1946: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1949: aload_1
    //   1950: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1953: ldc_w 270
    //   1956: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1959: aload 29
    //   1961: invokestatic 268	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   1964: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1967: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1970: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1973: lload 12
    //   1975: lstore 10
    //   1977: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   1980: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   1983: aload 27
    //   1985: aload_1
    //   1986: bipush 153
    //   1988: invokeinterface 240 4 0
    //   1993: goto -266 -> 1727
    //   1996: astore 29
    //   1998: lload 14
    //   2000: lstore 10
    //   2002: iconst_5
    //   2003: aload 28
    //   2005: new 114	java/lang/StringBuilder
    //   2008: dup
    //   2009: ldc_w 288
    //   2012: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2015: aload_1
    //   2016: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2019: ldc_w 272
    //   2022: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2025: aload 29
    //   2027: invokestatic 268	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:h	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   2030: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2033: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2036: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2039: lload 14
    //   2041: lstore 10
    //   2043: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   2046: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   2049: aload 27
    //   2051: aload_1
    //   2052: bipush 152
    //   2054: invokeinterface 240 4 0
    //   2059: iconst_3
    //   2060: aload 28
    //   2062: new 114	java/lang/StringBuilder
    //   2065: dup
    //   2066: ldc_w 274
    //   2069: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2072: lload 14
    //   2074: invokevirtual 121	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2077: ldc 244
    //   2079: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2085: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2088: aload 26
    //   2090: invokeinterface 112 1 0
    //   2095: iconst_4
    //   2096: aload 28
    //   2098: ldc_w 276
    //   2101: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2104: goto -537 -> 1567
    //   2107: astore 26
    //   2109: iconst_4
    //   2110: aload 28
    //   2112: ldc_w 284
    //   2115: aload 26
    //   2117: invokestatic 66	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2120: invokevirtual 70	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2123: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2126: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   2129: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   2132: aload 27
    //   2134: aload_1
    //   2135: bipush 151
    //   2137: invokeinterface 240 4 0
    //   2142: goto -575 -> 1567
    //   2145: astore 26
    //   2147: iconst_4
    //   2148: aload 28
    //   2150: ldc_w 284
    //   2153: aload 26
    //   2155: invokestatic 66	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   2158: invokevirtual 70	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   2161: invokestatic 80	com/tencent/mm/plugin/appbrand/jsapi/video/b/e/h:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   2164: invokestatic 180	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:bjM	()Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/a;
    //   2167: getfield 184	com/tencent/mm/plugin/appbrand/jsapi/video/b/a:kPI	Lcom/tencent/mm/plugin/appbrand/jsapi/video/b/d/a;
    //   2170: aload 27
    //   2172: aload_1
    //   2173: bipush 151
    //   2175: invokeinterface 240 4 0
    //   2180: goto -256 -> 1924
    //   2183: astore 26
    //   2185: lload 24
    //   2187: lstore 10
    //   2189: lload 18
    //   2191: lstore_2
    //   2192: goto -862 -> 1330
    //   2195: astore 26
    //   2197: ldc2_w 71
    //   2200: lstore 12
    //   2202: goto -1638 -> 564
    //   2205: ldc2_w 71
    //   2208: lstore 12
    //   2210: goto -1516 -> 694
    //   2213: lload_2
    //   2214: lstore 12
    //   2216: lload_2
    //   2217: ldc2_w 71
    //   2220: lcmp
    //   2221: ifne -1403 -> 818
    //   2224: lload 10
    //   2226: lstore 12
    //   2228: goto -1410 -> 818
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2231	0	this	l
    //   0	2231	1	paramString	String
    //   0	2231	2	paramLong1	long
    //   0	2231	4	paramLong2	long
    //   0	2231	6	paramInt	int
    //   0	2231	7	paramBoolean1	boolean
    //   0	2231	8	paramBoolean2	boolean
    //   258	131	9	i	int
    //   137	2088	10	l1	long
    //   198	2029	12	l2	long
    //   201	1872	14	l3	long
    //   164	1220	16	l4	long
    //   242	1948	18	l5	long
    //   230	328	20	l6	long
    //   226	335	22	l7	long
    //   238	1948	24	l8	long
    //   160	305	26	arrayOfByte	byte[]
    //   555	41	26	locala1	com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.a
    //   716	248	26	localj	com.tencent.mm.plugin.appbrand.jsapi.video.b.b.j
    //   1046	76	26	localException1	Exception
    //   1158	91	26	localThrowable1	Throwable
    //   1285	9	26	localException2	Exception
    //   1323	45	26	localIOException1	java.io.IOException
    //   1447	105	26	localException3	Exception
    //   1599	158	26	localException4	Exception
    //   1775	314	26	localException5	Exception
    //   2107	9	26	localException6	Exception
    //   2145	9	26	localException7	Exception
    //   2183	1	26	localIOException2	java.io.IOException
    //   2195	1	26	locala2	com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.a
    //   61	2110	27	str1	String
    //   73	2076	28	str2	String
    //   54	882	29	str3	String
    //   1485	9	29	localException8	Exception
    //   1637	204	29	locala3	com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l.a
    //   1877	83	29	localThrowable2	Throwable
    //   1996	30	29	localIOException3	java.io.IOException
    //   153	1277	30	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   244	260	555	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   280	294	555	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   314	326	555	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   346	358	555	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   376	437	555	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   462	478	555	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   517	549	555	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   1000	1043	1046	java/lang/Exception
    //   166	187	1158	finally
    //   191	200	1158	finally
    //   244	260	1158	finally
    //   280	294	1158	finally
    //   314	326	1158	finally
    //   346	358	1158	finally
    //   376	437	1158	finally
    //   462	478	1158	finally
    //   517	549	1158	finally
    //   568	579	1158	finally
    //   583	591	1158	finally
    //   595	611	1158	finally
    //   615	631	1158	finally
    //   635	651	1158	finally
    //   1088	1135	1158	finally
    //   1139	1155	1158	finally
    //   1215	1262	1158	finally
    //   1266	1282	1158	finally
    //   1334	1381	1158	finally
    //   1385	1401	1158	finally
    //   651	694	1285	java/lang/Exception
    //   166	187	1323	java/io/IOException
    //   191	200	1323	java/io/IOException
    //   1401	1444	1447	java/lang/Exception
    //   1160	1203	1485	java/lang/Exception
    //   1523	1567	1599	java/lang/Exception
    //   750	771	1637	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   783	792	1637	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   804	811	1637	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   845	853	1637	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   865	917	1637	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   929	951	1637	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   963	978	1637	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   1727	1772	1775	java/lang/Exception
    //   750	771	1877	finally
    //   783	792	1877	finally
    //   804	811	1877	finally
    //   845	853	1877	finally
    //   865	917	1877	finally
    //   929	951	1877	finally
    //   963	978	1877	finally
    //   1643	1654	1877	finally
    //   1658	1666	1877	finally
    //   1670	1686	1877	finally
    //   1690	1707	1877	finally
    //   1711	1727	1877	finally
    //   1817	1854	1877	finally
    //   1858	1874	1877	finally
    //   1936	1973	1877	finally
    //   1977	1993	1877	finally
    //   2002	2039	1877	finally
    //   2043	2059	1877	finally
    //   750	771	1996	java/io/IOException
    //   783	792	1996	java/io/IOException
    //   804	811	1996	java/io/IOException
    //   845	853	1996	java/io/IOException
    //   865	917	1996	java/io/IOException
    //   929	951	1996	java/io/IOException
    //   963	978	1996	java/io/IOException
    //   2059	2104	2107	java/lang/Exception
    //   1879	1924	2145	java/lang/Exception
    //   244	260	2183	java/io/IOException
    //   280	294	2183	java/io/IOException
    //   314	326	2183	java/io/IOException
    //   346	358	2183	java/io/IOException
    //   376	437	2183	java/io/IOException
    //   462	478	2183	java/io/IOException
    //   517	549	2183	java/io/IOException
    //   166	187	2195	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
    //   191	200	2195	com/tencent/mm/plugin/appbrand/jsapi/video/b/b/l$a
  }
  
  public static l bjV()
  {
    AppMethodBeat.i(194284);
    if (kQZ == null)
    {
      localObject = new IllegalStateException("Video SDK has not been initialized! Call init() first!");
      AppMethodBeat.o(194284);
      throw ((Throwable)localObject);
    }
    Object localObject = kQZ;
    AppMethodBeat.o(194284);
    return localObject;
  }
  
  public static void init()
  {
    AppMethodBeat.i(194285);
    if (kQZ == null) {
      try
      {
        if (kQZ == null) {
          kQZ = new l();
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(194285);
      }
    }
    AppMethodBeat.o(194285);
  }
  
  private boolean isCached(String paramString)
  {
    AppMethodBeat.i(194286);
    m localm = this.kRa;
    if ((!TextUtils.isEmpty(paramString)) && (localm.kPL != null))
    {
      paramString = h.Nz(paramString);
      boolean bool = localm.kPL.isCached(paramString);
      AppMethodBeat.o(194286);
      return bool;
    }
    AppMethodBeat.o(194286);
    return false;
  }
  
  public final boolean N(final String paramString, final long paramLong)
  {
    AppMethodBeat.i(194288);
    if ((TextUtils.isEmpty(paramString)) || (!URLUtil.isNetworkUrl(paramString)))
    {
      h.log(4, "VideoManager", "preload, not valid url, url=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(194288);
      return false;
    }
    if (!com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPx)
    {
      h.log(4, "VideoManager", "preload, video proxy & cache disabled");
      AppMethodBeat.o(194288);
      return false;
    }
    if (this.kRb.contains(paramString))
    {
      h.log(4, "VideoManager", "preload, same url in preloading, url=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(194288);
      return false;
    }
    if (h.NB(paramString))
    {
      h.log(4, "VideoManager", "preload, m3u8 is not supported, url=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(194288);
      return false;
    }
    if (isCached(paramString))
    {
      h.log(4, "VideoManager", "preload, video already cached, url=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(194288);
      return true;
    }
    if ((paramLong == -1L) || (Nn(paramString) < paramLong)) {}
    for (int i = 1; i == 0; i = 0)
    {
      h.log(4, "VideoManager", "preload, no need to preload, preloadSync skipped, url=".concat(String.valueOf(paramString)));
      AppMethodBeat.o(194288);
      return false;
    }
    try
    {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.m.a(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(194281);
          l.a(l.this, paramString, paramLong, this.kRe, this.kRf, this.kRg, this.kRh);
          AppMethodBeat.o(194281);
        }
      }, "preloadAsync");
      AppMethodBeat.o(194288);
      return true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.log(6, "VideoManager", "preload, preloadSync error, url=" + paramString + " msg=" + localException.getMessage());
      }
    }
  }
  
  public final long Nn(String paramString)
  {
    AppMethodBeat.i(194287);
    long l = this.kRa.Nn(paramString);
    AppMethodBeat.o(194287);
    return l;
  }
  
  public final void b(ArrayList<i> paramArrayList, String paramString)
  {
    AppMethodBeat.i(194290);
    final String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "preloadMediasAsync";
    }
    paramString = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      final i locali = (i)paramArrayList.next();
      int i = 1;
      if (-1L == -1L) {
        if (!isCached(locali.kQX)) {
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label197;
        }
        paramString.add(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194282);
            l.a(locali.kQY, this.kRl, this.kRm, str);
            AppMethodBeat.o(194282);
          }
        });
        break;
        i = 0;
        continue;
        if (-1L > 0L)
        {
          long l = -1L - this.kRa.kPL.Nn(h.Nz(locali.kQX));
          h.log(3, str, "preloadMediasAsync, remainingBytes2Cache " + l + ", url=" + locali.kQX);
          if (l > 0L) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
      label197:
      h.log(4, str, "preloadMediasAsync, url " + locali.kQX + " already cached, cacheMaxBytes=-1");
    }
    if (paramString.size() > 0) {
      com.tencent.mm.plugin.appbrand.jsapi.video.b.e.m.C(paramString);
    }
    AppMethodBeat.o(194290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.c.l
 * JD-Core Version:    0.7.0.1
 */