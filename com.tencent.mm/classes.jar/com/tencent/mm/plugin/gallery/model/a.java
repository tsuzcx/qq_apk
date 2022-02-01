package com.tencent.mm.plugin.gallery.model;

import android.content.ContentResolver;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.Comparator;

public final class a
  extends b
  implements Comparator<GalleryItem.MediaItem>
{
  protected ContentResolver bwu;
  private u rAa;
  private k rzZ;
  
  public a()
  {
    AppMethodBeat.i(111230);
    this.bwu = aj.getContext().getContentResolver();
    this.rzZ = new k();
    this.rAa = new u();
    AppMethodBeat.o(111230);
  }
  
  /* Error */
  public final java.util.LinkedList<GalleryItem.MediaItem> a(String paramString, int paramInt, i.c paramc, long paramLong)
  {
    // Byte code:
    //   0: ldc 59
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: invokestatic 65	java/lang/System:currentTimeMillis	()J
    //   8: lstore 6
    //   10: aconst_null
    //   11: astore 10
    //   13: aconst_null
    //   14: astore 14
    //   16: aconst_null
    //   17: astore 22
    //   19: aconst_null
    //   20: astore 11
    //   22: aconst_null
    //   23: astore 19
    //   25: aconst_null
    //   26: astore 20
    //   28: aconst_null
    //   29: astore 18
    //   31: aconst_null
    //   32: astore 16
    //   34: aconst_null
    //   35: astore 15
    //   37: aconst_null
    //   38: astore 17
    //   40: aconst_null
    //   41: astore 21
    //   43: aconst_null
    //   44: astore 23
    //   46: aload 14
    //   48: astore 12
    //   50: aload 22
    //   52: astore 13
    //   54: aload_0
    //   55: iconst_0
    //   56: putfield 69	com/tencent/mm/plugin/gallery/model/a:gqP	Z
    //   59: aload 14
    //   61: astore 12
    //   63: aload 22
    //   65: astore 13
    //   67: new 71	java/util/LinkedList
    //   70: dup
    //   71: invokespecial 72	java/util/LinkedList:<init>	()V
    //   74: astore 25
    //   76: aload 14
    //   78: astore 12
    //   80: aload 22
    //   82: astore 13
    //   84: aload_1
    //   85: invokestatic 78	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   88: ifeq +653 -> 741
    //   91: iload_2
    //   92: iconst_1
    //   93: if_icmpeq +8 -> 101
    //   96: iload_2
    //   97: iconst_3
    //   98: if_icmpne +1598 -> 1696
    //   101: aload 14
    //   103: astore 12
    //   105: aload 22
    //   107: astore 13
    //   109: aload_0
    //   110: getfield 38	com/tencent/mm/plugin/gallery/model/a:bwu	Landroid/content/ContentResolver;
    //   113: getstatic 84	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   116: aload_0
    //   117: getfield 43	com/tencent/mm/plugin/gallery/model/a:rzZ	Lcom/tencent/mm/plugin/gallery/model/k;
    //   120: invokevirtual 88	com/tencent/mm/plugin/gallery/model/k:getProjection	()[Ljava/lang/String;
    //   123: aload_0
    //   124: getfield 43	com/tencent/mm/plugin/gallery/model/a:rzZ	Lcom/tencent/mm/plugin/gallery/model/k;
    //   127: aload_0
    //   128: getfield 92	com/tencent/mm/plugin/gallery/model/a:rAc	[Ljava/lang/String;
    //   131: iconst_0
    //   132: invokevirtual 96	com/tencent/mm/plugin/gallery/model/k:b	([Ljava/lang/String;Z)Ljava/lang/String;
    //   135: aconst_null
    //   136: aload_0
    //   137: getfield 43	com/tencent/mm/plugin/gallery/model/a:rzZ	Lcom/tencent/mm/plugin/gallery/model/k;
    //   140: iconst_0
    //   141: invokevirtual 100	com/tencent/mm/plugin/gallery/model/k:lC	(Z)Ljava/lang/String;
    //   144: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   147: astore 11
    //   149: aload 11
    //   151: astore 12
    //   153: aload 11
    //   155: astore 13
    //   157: aload 11
    //   159: astore 14
    //   161: aload_0
    //   162: getfield 38	com/tencent/mm/plugin/gallery/model/a:bwu	Landroid/content/ContentResolver;
    //   165: getstatic 84	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   168: aload_0
    //   169: getfield 43	com/tencent/mm/plugin/gallery/model/a:rzZ	Lcom/tencent/mm/plugin/gallery/model/k;
    //   172: invokevirtual 88	com/tencent/mm/plugin/gallery/model/k:getProjection	()[Ljava/lang/String;
    //   175: aload_0
    //   176: getfield 43	com/tencent/mm/plugin/gallery/model/a:rzZ	Lcom/tencent/mm/plugin/gallery/model/k;
    //   179: aload_0
    //   180: getfield 92	com/tencent/mm/plugin/gallery/model/a:rAc	[Ljava/lang/String;
    //   183: iconst_1
    //   184: invokevirtual 96	com/tencent/mm/plugin/gallery/model/k:b	([Ljava/lang/String;Z)Ljava/lang/String;
    //   187: aconst_null
    //   188: aload_0
    //   189: getfield 43	com/tencent/mm/plugin/gallery/model/a:rzZ	Lcom/tencent/mm/plugin/gallery/model/k;
    //   192: iconst_1
    //   193: invokevirtual 100	com/tencent/mm/plugin/gallery/model/k:lC	(Z)Ljava/lang/String;
    //   196: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   199: astore 10
    //   201: iload_2
    //   202: iconst_2
    //   203: if_icmpeq +16 -> 219
    //   206: aload 10
    //   208: astore 14
    //   210: aload 11
    //   212: astore 13
    //   214: iload_2
    //   215: iconst_3
    //   216: if_icmpne +1468 -> 1684
    //   219: aload 21
    //   221: astore 17
    //   223: aload 18
    //   225: astore 12
    //   227: aload 10
    //   229: astore 14
    //   231: aload 11
    //   233: astore 13
    //   235: aload 10
    //   237: astore 19
    //   239: aload 11
    //   241: astore 18
    //   243: aload 10
    //   245: astore 20
    //   247: aload 11
    //   249: astore 15
    //   251: aload_0
    //   252: getfield 38	com/tencent/mm/plugin/gallery/model/a:bwu	Landroid/content/ContentResolver;
    //   255: getstatic 109	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   258: aload_0
    //   259: getfield 48	com/tencent/mm/plugin/gallery/model/a:rAa	Lcom/tencent/mm/plugin/gallery/model/u;
    //   262: invokevirtual 110	com/tencent/mm/plugin/gallery/model/u:getProjection	()[Ljava/lang/String;
    //   265: aload_0
    //   266: getfield 48	com/tencent/mm/plugin/gallery/model/a:rAa	Lcom/tencent/mm/plugin/gallery/model/u;
    //   269: iconst_1
    //   270: anewarray 112	java/lang/String
    //   273: dup
    //   274: iconst_0
    //   275: aload_0
    //   276: getfield 92	com/tencent/mm/plugin/gallery/model/a:rAc	[Ljava/lang/String;
    //   279: iconst_0
    //   280: aaload
    //   281: aastore
    //   282: iconst_0
    //   283: invokevirtual 113	com/tencent/mm/plugin/gallery/model/u:b	([Ljava/lang/String;Z)Ljava/lang/String;
    //   286: aconst_null
    //   287: aload_0
    //   288: getfield 48	com/tencent/mm/plugin/gallery/model/a:rAa	Lcom/tencent/mm/plugin/gallery/model/u;
    //   291: iconst_0
    //   292: invokevirtual 114	com/tencent/mm/plugin/gallery/model/u:lC	(Z)Ljava/lang/String;
    //   295: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   298: astore 22
    //   300: aload 22
    //   302: astore 15
    //   304: aload 21
    //   306: astore 17
    //   308: aload 15
    //   310: astore 12
    //   312: aload 10
    //   314: astore 14
    //   316: aload 11
    //   318: astore 13
    //   320: aload 15
    //   322: astore 16
    //   324: aload 10
    //   326: astore 19
    //   328: aload 11
    //   330: astore 18
    //   332: aload 15
    //   334: astore 22
    //   336: aload 10
    //   338: astore 21
    //   340: aload 11
    //   342: astore 20
    //   344: aload_0
    //   345: getfield 38	com/tencent/mm/plugin/gallery/model/a:bwu	Landroid/content/ContentResolver;
    //   348: getstatic 109	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   351: aload_0
    //   352: getfield 48	com/tencent/mm/plugin/gallery/model/a:rAa	Lcom/tencent/mm/plugin/gallery/model/u;
    //   355: invokevirtual 110	com/tencent/mm/plugin/gallery/model/u:getProjection	()[Ljava/lang/String;
    //   358: aload_0
    //   359: getfield 48	com/tencent/mm/plugin/gallery/model/a:rAa	Lcom/tencent/mm/plugin/gallery/model/u;
    //   362: iconst_1
    //   363: anewarray 112	java/lang/String
    //   366: dup
    //   367: iconst_0
    //   368: aload_0
    //   369: getfield 92	com/tencent/mm/plugin/gallery/model/a:rAc	[Ljava/lang/String;
    //   372: iconst_0
    //   373: aaload
    //   374: aastore
    //   375: iconst_1
    //   376: invokevirtual 113	com/tencent/mm/plugin/gallery/model/u:b	([Ljava/lang/String;Z)Ljava/lang/String;
    //   379: aconst_null
    //   380: aload_0
    //   381: getfield 48	com/tencent/mm/plugin/gallery/model/a:rAa	Lcom/tencent/mm/plugin/gallery/model/u;
    //   384: iconst_1
    //   385: invokevirtual 114	com/tencent/mm/plugin/gallery/model/u:lC	(Z)Ljava/lang/String;
    //   388: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   391: astore 24
    //   393: aload 24
    //   395: astore 16
    //   397: aload 11
    //   399: astore 13
    //   401: aload 10
    //   403: astore 14
    //   405: aload 13
    //   407: ifnull +11 -> 418
    //   410: aload 13
    //   412: invokeinterface 120 1 0
    //   417: pop
    //   418: aload 14
    //   420: ifnull +11 -> 431
    //   423: aload 14
    //   425: invokeinterface 120 1 0
    //   430: pop
    //   431: aload 15
    //   433: ifnull +11 -> 444
    //   436: aload 15
    //   438: invokeinterface 120 1 0
    //   443: pop
    //   444: aload 16
    //   446: ifnull +11 -> 457
    //   449: aload 16
    //   451: invokeinterface 120 1 0
    //   456: pop
    //   457: aload 13
    //   459: iconst_1
    //   460: invokestatic 124	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   463: astore 10
    //   465: aload 14
    //   467: iconst_1
    //   468: invokestatic 124	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   471: astore 11
    //   473: aload 15
    //   475: iconst_2
    //   476: invokestatic 124	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   479: astore 12
    //   481: aload 16
    //   483: iconst_2
    //   484: invokestatic 124	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   487: astore 17
    //   489: iconst_1
    //   490: istore 9
    //   492: goto +1210 -> 1702
    //   495: aload 19
    //   497: astore 18
    //   499: aload 11
    //   501: ifnull +29 -> 530
    //   504: aload 19
    //   506: ifnull +1211 -> 1717
    //   509: aload 19
    //   511: astore 18
    //   513: aload 19
    //   515: getfield 130	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:rBt	J
    //   518: aload 11
    //   520: getfield 130	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:rBt	J
    //   523: lcmp
    //   524: ifge +6 -> 530
    //   527: goto +1190 -> 1717
    //   530: aload 18
    //   532: astore 19
    //   534: aload 12
    //   536: ifnull +29 -> 565
    //   539: aload 18
    //   541: ifnull +1183 -> 1724
    //   544: aload 18
    //   546: astore 19
    //   548: aload 18
    //   550: getfield 130	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:rBt	J
    //   553: aload 12
    //   555: getfield 130	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:rBt	J
    //   558: lcmp
    //   559: ifge +6 -> 565
    //   562: goto +1162 -> 1724
    //   565: aload 19
    //   567: astore 18
    //   569: aload 17
    //   571: ifnull +29 -> 600
    //   574: aload 19
    //   576: ifnull +1155 -> 1731
    //   579: aload 19
    //   581: astore 18
    //   583: aload 19
    //   585: getfield 130	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:rBt	J
    //   588: aload 17
    //   590: getfield 130	com/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem:rBt	J
    //   593: lcmp
    //   594: ifge +6 -> 600
    //   597: goto +1134 -> 1731
    //   600: aload 18
    //   602: ifnull +536 -> 1138
    //   605: aload 25
    //   607: aload 18
    //   609: invokevirtual 134	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   612: pop
    //   613: aload 18
    //   615: aload 10
    //   617: if_acmpne +411 -> 1028
    //   620: aload 13
    //   622: invokeinterface 137 1 0
    //   627: pop
    //   628: aload 13
    //   630: iconst_1
    //   631: invokestatic 124	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   634: astore 18
    //   636: aload 12
    //   638: astore 10
    //   640: aload 18
    //   642: astore 12
    //   644: iload 9
    //   646: istore 8
    //   648: aload_0
    //   649: aload_3
    //   650: aload 25
    //   652: lload 4
    //   654: iload 9
    //   656: invokevirtual 140	com/tencent/mm/plugin/gallery/model/a:a	(Lcom/tencent/mm/plugin/gallery/model/i$c;Ljava/util/LinkedList;JZ)Z
    //   659: ifeq +15 -> 674
    //   662: iload 9
    //   664: istore 8
    //   666: iload 9
    //   668: ifeq +6 -> 674
    //   671: iconst_0
    //   672: istore 8
    //   674: aload_0
    //   675: getfield 69	com/tencent/mm/plugin/gallery/model/a:gqP	Z
    //   678: istore 9
    //   680: iload 9
    //   682: ifeq +1056 -> 1738
    //   685: aload 13
    //   687: ifnull +10 -> 697
    //   690: aload 13
    //   692: invokeinterface 143 1 0
    //   697: aload 14
    //   699: ifnull +10 -> 709
    //   702: aload 14
    //   704: invokeinterface 143 1 0
    //   709: aload 15
    //   711: ifnull +10 -> 721
    //   714: aload 15
    //   716: invokeinterface 143 1 0
    //   721: aload 16
    //   723: ifnull +10 -> 733
    //   726: aload 16
    //   728: invokeinterface 143 1 0
    //   733: ldc 59
    //   735: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   738: aload 25
    //   740: areturn
    //   741: iload_2
    //   742: iconst_1
    //   743: if_icmpeq +8 -> 751
    //   746: iload_2
    //   747: iconst_3
    //   748: if_icmpne +942 -> 1690
    //   751: aload 14
    //   753: astore 12
    //   755: aload 22
    //   757: astore 13
    //   759: aload_0
    //   760: getfield 38	com/tencent/mm/plugin/gallery/model/a:bwu	Landroid/content/ContentResolver;
    //   763: getstatic 84	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   766: aload_0
    //   767: getfield 43	com/tencent/mm/plugin/gallery/model/a:rzZ	Lcom/tencent/mm/plugin/gallery/model/k;
    //   770: invokevirtual 88	com/tencent/mm/plugin/gallery/model/k:getProjection	()[Ljava/lang/String;
    //   773: aload_0
    //   774: getfield 43	com/tencent/mm/plugin/gallery/model/a:rzZ	Lcom/tencent/mm/plugin/gallery/model/k;
    //   777: aload_1
    //   778: iconst_0
    //   779: invokevirtual 147	com/tencent/mm/plugin/gallery/model/k:bd	(Ljava/lang/String;Z)Ljava/lang/String;
    //   782: aconst_null
    //   783: aload_0
    //   784: getfield 43	com/tencent/mm/plugin/gallery/model/a:rzZ	Lcom/tencent/mm/plugin/gallery/model/k;
    //   787: iconst_0
    //   788: invokevirtual 100	com/tencent/mm/plugin/gallery/model/k:lC	(Z)Ljava/lang/String;
    //   791: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   794: astore 10
    //   796: aload 10
    //   798: astore 12
    //   800: aload 10
    //   802: astore 13
    //   804: aload 10
    //   806: astore 14
    //   808: aload_0
    //   809: getfield 38	com/tencent/mm/plugin/gallery/model/a:bwu	Landroid/content/ContentResolver;
    //   812: getstatic 84	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   815: aload_0
    //   816: getfield 43	com/tencent/mm/plugin/gallery/model/a:rzZ	Lcom/tencent/mm/plugin/gallery/model/k;
    //   819: invokevirtual 88	com/tencent/mm/plugin/gallery/model/k:getProjection	()[Ljava/lang/String;
    //   822: aload_0
    //   823: getfield 43	com/tencent/mm/plugin/gallery/model/a:rzZ	Lcom/tencent/mm/plugin/gallery/model/k;
    //   826: aload_1
    //   827: iconst_1
    //   828: invokevirtual 147	com/tencent/mm/plugin/gallery/model/k:bd	(Ljava/lang/String;Z)Ljava/lang/String;
    //   831: aconst_null
    //   832: aload_0
    //   833: getfield 43	com/tencent/mm/plugin/gallery/model/a:rzZ	Lcom/tencent/mm/plugin/gallery/model/k;
    //   836: iconst_1
    //   837: invokevirtual 100	com/tencent/mm/plugin/gallery/model/k:lC	(Z)Ljava/lang/String;
    //   840: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   843: astore 11
    //   845: iload_2
    //   846: iconst_2
    //   847: if_icmpeq +16 -> 863
    //   850: aload 11
    //   852: astore 14
    //   854: aload 10
    //   856: astore 13
    //   858: iload_2
    //   859: iconst_3
    //   860: if_icmpne +824 -> 1684
    //   863: aload 21
    //   865: astore 17
    //   867: aload 18
    //   869: astore 12
    //   871: aload 11
    //   873: astore 14
    //   875: aload 10
    //   877: astore 13
    //   879: aload 11
    //   881: astore 19
    //   883: aload 10
    //   885: astore 18
    //   887: aload 11
    //   889: astore 20
    //   891: aload 10
    //   893: astore 15
    //   895: aload_0
    //   896: getfield 38	com/tencent/mm/plugin/gallery/model/a:bwu	Landroid/content/ContentResolver;
    //   899: getstatic 109	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   902: aload_0
    //   903: getfield 48	com/tencent/mm/plugin/gallery/model/a:rAa	Lcom/tencent/mm/plugin/gallery/model/u;
    //   906: invokevirtual 110	com/tencent/mm/plugin/gallery/model/u:getProjection	()[Ljava/lang/String;
    //   909: aload_0
    //   910: getfield 48	com/tencent/mm/plugin/gallery/model/a:rAa	Lcom/tencent/mm/plugin/gallery/model/u;
    //   913: aload_1
    //   914: iconst_0
    //   915: invokevirtual 148	com/tencent/mm/plugin/gallery/model/u:bd	(Ljava/lang/String;Z)Ljava/lang/String;
    //   918: aconst_null
    //   919: aload_0
    //   920: getfield 48	com/tencent/mm/plugin/gallery/model/a:rAa	Lcom/tencent/mm/plugin/gallery/model/u;
    //   923: iconst_0
    //   924: invokevirtual 114	com/tencent/mm/plugin/gallery/model/u:lC	(Z)Ljava/lang/String;
    //   927: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   930: astore 22
    //   932: aload 22
    //   934: astore 15
    //   936: aload 21
    //   938: astore 17
    //   940: aload 15
    //   942: astore 12
    //   944: aload 11
    //   946: astore 14
    //   948: aload 10
    //   950: astore 13
    //   952: aload 15
    //   954: astore 16
    //   956: aload 11
    //   958: astore 19
    //   960: aload 10
    //   962: astore 18
    //   964: aload 15
    //   966: astore 22
    //   968: aload 11
    //   970: astore 21
    //   972: aload 10
    //   974: astore 20
    //   976: aload_0
    //   977: getfield 38	com/tencent/mm/plugin/gallery/model/a:bwu	Landroid/content/ContentResolver;
    //   980: getstatic 109	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   983: aload_0
    //   984: getfield 48	com/tencent/mm/plugin/gallery/model/a:rAa	Lcom/tencent/mm/plugin/gallery/model/u;
    //   987: invokevirtual 110	com/tencent/mm/plugin/gallery/model/u:getProjection	()[Ljava/lang/String;
    //   990: aload_0
    //   991: getfield 48	com/tencent/mm/plugin/gallery/model/a:rAa	Lcom/tencent/mm/plugin/gallery/model/u;
    //   994: aload_1
    //   995: iconst_1
    //   996: invokevirtual 148	com/tencent/mm/plugin/gallery/model/u:bd	(Ljava/lang/String;Z)Ljava/lang/String;
    //   999: aconst_null
    //   1000: aload_0
    //   1001: getfield 48	com/tencent/mm/plugin/gallery/model/a:rAa	Lcom/tencent/mm/plugin/gallery/model/u;
    //   1004: iconst_1
    //   1005: invokevirtual 114	com/tencent/mm/plugin/gallery/model/u:lC	(Z)Ljava/lang/String;
    //   1008: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   1011: astore 24
    //   1013: aload 24
    //   1015: astore 16
    //   1017: aload 11
    //   1019: astore 14
    //   1021: aload 10
    //   1023: astore 13
    //   1025: goto -620 -> 405
    //   1028: aload 18
    //   1030: aload 11
    //   1032: if_acmpne +34 -> 1066
    //   1035: aload 14
    //   1037: invokeinterface 137 1 0
    //   1042: pop
    //   1043: aload 14
    //   1045: iconst_1
    //   1046: invokestatic 124	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   1049: astore 11
    //   1051: aload 10
    //   1053: astore 18
    //   1055: aload 12
    //   1057: astore 10
    //   1059: aload 18
    //   1061: astore 12
    //   1063: goto -419 -> 644
    //   1066: aload 18
    //   1068: aload 12
    //   1070: if_acmpne +30 -> 1100
    //   1073: aload 15
    //   1075: invokeinterface 137 1 0
    //   1080: pop
    //   1081: aload 15
    //   1083: iconst_2
    //   1084: invokestatic 124	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   1087: astore 18
    //   1089: aload 10
    //   1091: astore 12
    //   1093: aload 18
    //   1095: astore 10
    //   1097: goto -453 -> 644
    //   1100: aload 18
    //   1102: aload 17
    //   1104: if_acmpne +565 -> 1669
    //   1107: aload 16
    //   1109: invokeinterface 137 1 0
    //   1114: pop
    //   1115: aload 16
    //   1117: iconst_2
    //   1118: invokestatic 124	com/tencent/mm/plugin/gallery/model/a:c	(Landroid/database/Cursor;I)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   1121: astore 17
    //   1123: aload 10
    //   1125: astore 18
    //   1127: aload 12
    //   1129: astore 10
    //   1131: aload 18
    //   1133: astore 12
    //   1135: goto -491 -> 644
    //   1138: ldc 150
    //   1140: ldc 152
    //   1142: iconst_1
    //   1143: anewarray 154	java/lang/Object
    //   1146: dup
    //   1147: iconst_0
    //   1148: aload 25
    //   1150: invokevirtual 158	java/util/LinkedList:size	()I
    //   1153: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1156: aastore
    //   1157: invokestatic 170	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1160: aload_3
    //   1161: aload 25
    //   1163: lload 4
    //   1165: iload 9
    //   1167: invokeinterface 175 5 0
    //   1172: ldc 150
    //   1174: ldc 177
    //   1176: iconst_5
    //   1177: anewarray 154	java/lang/Object
    //   1180: dup
    //   1181: iconst_0
    //   1182: aload_1
    //   1183: aastore
    //   1184: dup
    //   1185: iconst_1
    //   1186: iload_2
    //   1187: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1190: aastore
    //   1191: dup
    //   1192: iconst_2
    //   1193: aload 25
    //   1195: invokevirtual 158	java/util/LinkedList:size	()I
    //   1198: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1201: aastore
    //   1202: dup
    //   1203: iconst_3
    //   1204: lload 4
    //   1206: invokestatic 182	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1209: aastore
    //   1210: dup
    //   1211: iconst_4
    //   1212: invokestatic 65	java/lang/System:currentTimeMillis	()J
    //   1215: lload 6
    //   1217: lsub
    //   1218: invokestatic 182	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1221: aastore
    //   1222: invokestatic 184	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1225: aload 13
    //   1227: ifnull +10 -> 1237
    //   1230: aload 13
    //   1232: invokeinterface 143 1 0
    //   1237: aload 14
    //   1239: ifnull +10 -> 1249
    //   1242: aload 14
    //   1244: invokeinterface 143 1 0
    //   1249: aload 15
    //   1251: ifnull +10 -> 1261
    //   1254: aload 15
    //   1256: invokeinterface 143 1 0
    //   1261: aload 16
    //   1263: ifnull +10 -> 1273
    //   1266: aload 16
    //   1268: invokeinterface 143 1 0
    //   1273: ldc 59
    //   1275: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1278: aload 25
    //   1280: areturn
    //   1281: astore 12
    //   1283: aconst_null
    //   1284: astore_1
    //   1285: aconst_null
    //   1286: astore_3
    //   1287: aconst_null
    //   1288: astore 10
    //   1290: aconst_null
    //   1291: astore 11
    //   1293: ldc 150
    //   1295: aload 12
    //   1297: ldc 186
    //   1299: iconst_0
    //   1300: anewarray 154	java/lang/Object
    //   1303: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1306: aload 11
    //   1308: ifnull +10 -> 1318
    //   1311: aload 11
    //   1313: invokeinterface 143 1 0
    //   1318: aload 10
    //   1320: ifnull +10 -> 1330
    //   1323: aload 10
    //   1325: invokeinterface 143 1 0
    //   1330: aload_3
    //   1331: ifnull +9 -> 1340
    //   1334: aload_3
    //   1335: invokeinterface 143 1 0
    //   1340: aload_1
    //   1341: ifnull +9 -> 1350
    //   1344: aload_1
    //   1345: invokeinterface 143 1 0
    //   1350: new 71	java/util/LinkedList
    //   1353: dup
    //   1354: invokespecial 72	java/util/LinkedList:<init>	()V
    //   1357: astore_1
    //   1358: ldc 59
    //   1360: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1363: aload_1
    //   1364: areturn
    //   1365: astore 10
    //   1367: aconst_null
    //   1368: astore_1
    //   1369: aload 12
    //   1371: astore_3
    //   1372: aload 19
    //   1374: astore 15
    //   1376: aload 23
    //   1378: astore 11
    //   1380: aload 11
    //   1382: astore 17
    //   1384: aload 15
    //   1386: astore 12
    //   1388: aload_1
    //   1389: astore 14
    //   1391: aload_3
    //   1392: astore 13
    //   1394: ldc 150
    //   1396: aload 10
    //   1398: ldc 186
    //   1400: iconst_0
    //   1401: anewarray 154	java/lang/Object
    //   1404: invokestatic 190	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1407: aload_3
    //   1408: ifnull +9 -> 1417
    //   1411: aload_3
    //   1412: invokeinterface 143 1 0
    //   1417: aload_1
    //   1418: ifnull +9 -> 1427
    //   1421: aload_1
    //   1422: invokeinterface 143 1 0
    //   1427: aload 15
    //   1429: ifnull +10 -> 1439
    //   1432: aload 15
    //   1434: invokeinterface 143 1 0
    //   1439: aload 11
    //   1441: ifnull -91 -> 1350
    //   1444: aload 11
    //   1446: invokeinterface 143 1 0
    //   1451: goto -101 -> 1350
    //   1454: astore_1
    //   1455: aconst_null
    //   1456: astore 14
    //   1458: aload 20
    //   1460: astore 12
    //   1462: aload 17
    //   1464: astore_3
    //   1465: aload 13
    //   1467: ifnull +10 -> 1477
    //   1470: aload 13
    //   1472: invokeinterface 143 1 0
    //   1477: aload 14
    //   1479: ifnull +10 -> 1489
    //   1482: aload 14
    //   1484: invokeinterface 143 1 0
    //   1489: aload 12
    //   1491: ifnull +10 -> 1501
    //   1494: aload 12
    //   1496: invokeinterface 143 1 0
    //   1501: aload_3
    //   1502: ifnull +9 -> 1511
    //   1505: aload_3
    //   1506: invokeinterface 143 1 0
    //   1511: ldc 59
    //   1513: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1516: aload_1
    //   1517: athrow
    //   1518: astore_1
    //   1519: aload 17
    //   1521: astore_3
    //   1522: goto -57 -> 1465
    //   1525: astore_1
    //   1526: aload 16
    //   1528: astore_3
    //   1529: aload 15
    //   1531: astore 12
    //   1533: goto -68 -> 1465
    //   1536: astore 14
    //   1538: aload_1
    //   1539: astore 12
    //   1541: aload_3
    //   1542: astore 13
    //   1544: aload 14
    //   1546: astore_1
    //   1547: aload 12
    //   1549: astore_3
    //   1550: aload 13
    //   1552: astore 12
    //   1554: aload 10
    //   1556: astore 14
    //   1558: aload 11
    //   1560: astore 13
    //   1562: goto -97 -> 1465
    //   1565: astore 10
    //   1567: aload 23
    //   1569: astore 11
    //   1571: aload 16
    //   1573: astore 15
    //   1575: aload 19
    //   1577: astore_1
    //   1578: aload 18
    //   1580: astore_3
    //   1581: goto -201 -> 1380
    //   1584: astore 10
    //   1586: aload 16
    //   1588: astore 11
    //   1590: aload 14
    //   1592: astore_1
    //   1593: aload 13
    //   1595: astore_3
    //   1596: goto -216 -> 1380
    //   1599: astore 12
    //   1601: aconst_null
    //   1602: astore_1
    //   1603: aconst_null
    //   1604: astore_3
    //   1605: aconst_null
    //   1606: astore 10
    //   1608: aload 14
    //   1610: astore 11
    //   1612: goto -319 -> 1293
    //   1615: astore 12
    //   1617: aconst_null
    //   1618: astore_1
    //   1619: aconst_null
    //   1620: astore_3
    //   1621: aload 20
    //   1623: astore 10
    //   1625: aload 15
    //   1627: astore 11
    //   1629: goto -336 -> 1293
    //   1632: astore 12
    //   1634: aconst_null
    //   1635: astore_1
    //   1636: aload 22
    //   1638: astore_3
    //   1639: aload 21
    //   1641: astore 10
    //   1643: aload 20
    //   1645: astore 11
    //   1647: goto -354 -> 1293
    //   1650: astore 12
    //   1652: aload 16
    //   1654: astore_1
    //   1655: aload 15
    //   1657: astore_3
    //   1658: aload 14
    //   1660: astore 10
    //   1662: aload 13
    //   1664: astore 11
    //   1666: goto -373 -> 1293
    //   1669: aload 10
    //   1671: astore 18
    //   1673: aload 12
    //   1675: astore 10
    //   1677: aload 18
    //   1679: astore 12
    //   1681: goto -1037 -> 644
    //   1684: aconst_null
    //   1685: astore 16
    //   1687: goto -1282 -> 405
    //   1690: aconst_null
    //   1691: astore 11
    //   1693: goto -848 -> 845
    //   1696: aconst_null
    //   1697: astore 10
    //   1699: goto -1498 -> 201
    //   1702: aconst_null
    //   1703: astore 19
    //   1705: aload 10
    //   1707: ifnull -1212 -> 495
    //   1710: aload 10
    //   1712: astore 19
    //   1714: goto -1219 -> 495
    //   1717: aload 11
    //   1719: astore 18
    //   1721: goto -1191 -> 530
    //   1724: aload 12
    //   1726: astore 19
    //   1728: goto -1163 -> 565
    //   1731: aload 17
    //   1733: astore 18
    //   1735: goto -1135 -> 600
    //   1738: aload 12
    //   1740: astore 18
    //   1742: aload 10
    //   1744: astore 12
    //   1746: aload 18
    //   1748: astore 10
    //   1750: iload 8
    //   1752: istore 9
    //   1754: goto -52 -> 1702
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1757	0	this	a
    //   0	1757	1	paramString	String
    //   0	1757	2	paramInt	int
    //   0	1757	3	paramc	i.c
    //   0	1757	4	paramLong	long
    //   8	1208	6	l	long
    //   646	1105	8	bool1	boolean
    //   490	1263	9	bool2	boolean
    //   11	1313	10	localObject1	java.lang.Object
    //   1365	190	10	localNullPointerException1	java.lang.NullPointerException
    //   1565	1	10	localNullPointerException2	java.lang.NullPointerException
    //   1584	1	10	localNullPointerException3	java.lang.NullPointerException
    //   1606	143	10	localObject2	java.lang.Object
    //   20	1698	11	localObject3	java.lang.Object
    //   48	1086	12	localObject4	java.lang.Object
    //   1281	89	12	localSQLiteDiskIOException1	android.database.sqlite.SQLiteDiskIOException
    //   1386	167	12	localObject5	java.lang.Object
    //   1599	1	12	localSQLiteDiskIOException2	android.database.sqlite.SQLiteDiskIOException
    //   1615	1	12	localSQLiteDiskIOException3	android.database.sqlite.SQLiteDiskIOException
    //   1632	1	12	localSQLiteDiskIOException4	android.database.sqlite.SQLiteDiskIOException
    //   1650	24	12	localSQLiteDiskIOException5	android.database.sqlite.SQLiteDiskIOException
    //   1679	66	12	localObject6	java.lang.Object
    //   52	1611	13	localObject7	java.lang.Object
    //   14	1469	14	localObject8	java.lang.Object
    //   1536	9	14	localObject9	java.lang.Object
    //   1556	103	14	localNullPointerException4	java.lang.NullPointerException
    //   35	1621	15	localObject10	java.lang.Object
    //   32	1654	16	localObject11	java.lang.Object
    //   38	1694	17	localObject12	java.lang.Object
    //   29	1718	18	localObject13	java.lang.Object
    //   23	1704	19	localObject14	java.lang.Object
    //   26	1618	20	localObject15	java.lang.Object
    //   41	1599	21	localObject16	java.lang.Object
    //   17	1620	22	localObject17	java.lang.Object
    //   44	1524	23	localObject18	java.lang.Object
    //   391	623	24	localCursor	android.database.Cursor
    //   74	1205	25	localLinkedList	java.util.LinkedList
    // Exception table:
    //   from	to	target	type
    //   54	59	1281	android/database/sqlite/SQLiteDiskIOException
    //   67	76	1281	android/database/sqlite/SQLiteDiskIOException
    //   84	91	1281	android/database/sqlite/SQLiteDiskIOException
    //   109	149	1281	android/database/sqlite/SQLiteDiskIOException
    //   759	796	1281	android/database/sqlite/SQLiteDiskIOException
    //   54	59	1365	java/lang/NullPointerException
    //   67	76	1365	java/lang/NullPointerException
    //   84	91	1365	java/lang/NullPointerException
    //   109	149	1365	java/lang/NullPointerException
    //   161	201	1365	java/lang/NullPointerException
    //   759	796	1365	java/lang/NullPointerException
    //   808	845	1365	java/lang/NullPointerException
    //   54	59	1454	finally
    //   67	76	1454	finally
    //   84	91	1454	finally
    //   109	149	1454	finally
    //   161	201	1454	finally
    //   759	796	1454	finally
    //   808	845	1454	finally
    //   251	300	1518	finally
    //   344	393	1518	finally
    //   895	932	1518	finally
    //   976	1013	1518	finally
    //   1394	1407	1518	finally
    //   410	418	1525	finally
    //   423	431	1525	finally
    //   436	444	1525	finally
    //   449	457	1525	finally
    //   457	489	1525	finally
    //   513	527	1525	finally
    //   548	562	1525	finally
    //   583	597	1525	finally
    //   605	613	1525	finally
    //   620	636	1525	finally
    //   648	662	1525	finally
    //   674	680	1525	finally
    //   1035	1051	1525	finally
    //   1073	1089	1525	finally
    //   1107	1123	1525	finally
    //   1138	1225	1525	finally
    //   1293	1306	1536	finally
    //   251	300	1565	java/lang/NullPointerException
    //   344	393	1565	java/lang/NullPointerException
    //   895	932	1565	java/lang/NullPointerException
    //   976	1013	1565	java/lang/NullPointerException
    //   410	418	1584	java/lang/NullPointerException
    //   423	431	1584	java/lang/NullPointerException
    //   436	444	1584	java/lang/NullPointerException
    //   449	457	1584	java/lang/NullPointerException
    //   457	489	1584	java/lang/NullPointerException
    //   513	527	1584	java/lang/NullPointerException
    //   548	562	1584	java/lang/NullPointerException
    //   583	597	1584	java/lang/NullPointerException
    //   605	613	1584	java/lang/NullPointerException
    //   620	636	1584	java/lang/NullPointerException
    //   648	662	1584	java/lang/NullPointerException
    //   674	680	1584	java/lang/NullPointerException
    //   1035	1051	1584	java/lang/NullPointerException
    //   1073	1089	1584	java/lang/NullPointerException
    //   1107	1123	1584	java/lang/NullPointerException
    //   1138	1225	1584	java/lang/NullPointerException
    //   161	201	1599	android/database/sqlite/SQLiteDiskIOException
    //   808	845	1599	android/database/sqlite/SQLiteDiskIOException
    //   251	300	1615	android/database/sqlite/SQLiteDiskIOException
    //   895	932	1615	android/database/sqlite/SQLiteDiskIOException
    //   344	393	1632	android/database/sqlite/SQLiteDiskIOException
    //   976	1013	1632	android/database/sqlite/SQLiteDiskIOException
    //   410	418	1650	android/database/sqlite/SQLiteDiskIOException
    //   423	431	1650	android/database/sqlite/SQLiteDiskIOException
    //   436	444	1650	android/database/sqlite/SQLiteDiskIOException
    //   449	457	1650	android/database/sqlite/SQLiteDiskIOException
    //   457	489	1650	android/database/sqlite/SQLiteDiskIOException
    //   513	527	1650	android/database/sqlite/SQLiteDiskIOException
    //   548	562	1650	android/database/sqlite/SQLiteDiskIOException
    //   583	597	1650	android/database/sqlite/SQLiteDiskIOException
    //   605	613	1650	android/database/sqlite/SQLiteDiskIOException
    //   620	636	1650	android/database/sqlite/SQLiteDiskIOException
    //   648	662	1650	android/database/sqlite/SQLiteDiskIOException
    //   674	680	1650	android/database/sqlite/SQLiteDiskIOException
    //   1035	1051	1650	android/database/sqlite/SQLiteDiskIOException
    //   1073	1089	1650	android/database/sqlite/SQLiteDiskIOException
    //   1107	1123	1650	android/database/sqlite/SQLiteDiskIOException
    //   1138	1225	1650	android/database/sqlite/SQLiteDiskIOException
  }
  
  /* Error */
  public final java.util.LinkedList<GalleryItem.AlbumItem> cyR()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: ldc 203
    //   5: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 205	java/util/HashMap
    //   11: dup
    //   12: invokespecial 206	java/util/HashMap:<init>	()V
    //   15: astore 7
    //   17: new 71	java/util/LinkedList
    //   20: dup
    //   21: invokespecial 72	java/util/LinkedList:<init>	()V
    //   24: astore 8
    //   26: aload_0
    //   27: getfield 38	com/tencent/mm/plugin/gallery/model/a:bwu	Landroid/content/ContentResolver;
    //   30: getstatic 109	android/provider/MediaStore$Video$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   33: aload_0
    //   34: getfield 48	com/tencent/mm/plugin/gallery/model/a:rAa	Lcom/tencent/mm/plugin/gallery/model/u;
    //   37: invokevirtual 209	com/tencent/mm/plugin/gallery/model/u:cyS	()[Ljava/lang/String;
    //   40: ldc 211
    //   42: aconst_null
    //   43: ldc 213
    //   45: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   48: astore 4
    //   50: aload 4
    //   52: ifnonnull +121 -> 173
    //   55: ldc 150
    //   57: ldc 215
    //   59: invokestatic 218	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   62: aconst_null
    //   63: astore_3
    //   64: aload_0
    //   65: getfield 38	com/tencent/mm/plugin/gallery/model/a:bwu	Landroid/content/ContentResolver;
    //   68: getstatic 84	android/provider/MediaStore$Images$Media:EXTERNAL_CONTENT_URI	Landroid/net/Uri;
    //   71: aload_0
    //   72: getfield 43	com/tencent/mm/plugin/gallery/model/a:rzZ	Lcom/tencent/mm/plugin/gallery/model/k;
    //   75: invokevirtual 219	com/tencent/mm/plugin/gallery/model/k:cyS	()[Ljava/lang/String;
    //   78: ldc 211
    //   80: aconst_null
    //   81: ldc 213
    //   83: invokevirtual 106	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   86: astore 4
    //   88: aload 4
    //   90: ifnonnull +246 -> 336
    //   93: ldc 150
    //   95: ldc 221
    //   97: invokestatic 218	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload 7
    //   102: invokevirtual 224	java/util/HashMap:isEmpty	()Z
    //   105: ifne +19 -> 124
    //   108: aload 8
    //   110: aload 7
    //   112: invokevirtual 228	java/util/HashMap:values	()Ljava/util/Collection;
    //   115: invokevirtual 232	java/util/LinkedList:addAll	(Ljava/util/Collection;)Z
    //   118: pop
    //   119: aload 8
    //   121: invokestatic 238	java/util/Collections:sort	(Ljava/util/List;)V
    //   124: aload 8
    //   126: invokestatic 242	com/tencent/mm/plugin/gallery/model/a:ag	(Ljava/util/LinkedList;)V
    //   129: aload_3
    //   130: ifnull +10 -> 140
    //   133: aload 8
    //   135: iconst_1
    //   136: aload_3
    //   137: invokevirtual 245	java/util/LinkedList:add	(ILjava/lang/Object;)V
    //   140: ldc 203
    //   142: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   145: aload 8
    //   147: areturn
    //   148: astore_3
    //   149: ldc 150
    //   151: ldc 247
    //   153: iconst_1
    //   154: anewarray 154	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_3
    //   160: invokevirtual 251	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   163: aastore
    //   164: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   167: aconst_null
    //   168: astore 4
    //   170: goto -120 -> 50
    //   173: aload 4
    //   175: invokeinterface 120 1 0
    //   180: ifeq +259 -> 439
    //   183: aconst_null
    //   184: astore 5
    //   186: iconst_0
    //   187: istore_2
    //   188: aload 4
    //   190: iconst_2
    //   191: ldc_w 256
    //   194: invokestatic 259	com/tencent/mm/plugin/gallery/model/a:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
    //   197: astore 9
    //   199: aload 5
    //   201: astore_3
    //   202: iload_2
    //   203: istore_1
    //   204: aload 9
    //   206: ifnull +42 -> 248
    //   209: iload_2
    //   210: aload 9
    //   212: getfield 265	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:did	I
    //   215: iadd
    //   216: istore_2
    //   217: aload 7
    //   219: aload 9
    //   221: getfield 269	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:Lmi	Ljava/lang/String;
    //   224: aload 9
    //   226: invokevirtual 273	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   229: pop
    //   230: aload 5
    //   232: astore_3
    //   233: iload_2
    //   234: istore_1
    //   235: aload 5
    //   237: ifnonnull +11 -> 248
    //   240: aload 9
    //   242: getfield 277	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:Lmj	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   245: astore_3
    //   246: iload_2
    //   247: istore_1
    //   248: aload_3
    //   249: astore 5
    //   251: iload_1
    //   252: istore_2
    //   253: aload 4
    //   255: invokeinterface 137 1 0
    //   260: ifne -72 -> 188
    //   263: new 261	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   266: dup
    //   267: invokestatic 30	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   270: ldc_w 278
    //   273: invokevirtual 282	android/content/Context:getString	(I)Ljava/lang/String;
    //   276: iload_1
    //   277: invokespecial 285	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:<init>	(Ljava/lang/String;I)V
    //   280: astore 5
    //   282: aload 5
    //   284: iconst_1
    //   285: putfield 288	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:Lml	Z
    //   288: aload 5
    //   290: aload_3
    //   291: putfield 277	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:Lmj	Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;
    //   294: aload 5
    //   296: astore_3
    //   297: aload 4
    //   299: invokeinterface 143 1 0
    //   304: goto -240 -> 64
    //   307: astore 4
    //   309: ldc 150
    //   311: ldc_w 290
    //   314: iconst_1
    //   315: anewarray 154	java/lang/Object
    //   318: dup
    //   319: iconst_0
    //   320: aload 4
    //   322: invokevirtual 251	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   325: aastore
    //   326: invokestatic 254	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   329: aload 6
    //   331: astore 4
    //   333: goto -245 -> 88
    //   336: aload 4
    //   338: invokeinterface 120 1 0
    //   343: ifeq +86 -> 429
    //   346: aload 4
    //   348: iconst_1
    //   349: ldc_w 256
    //   352: invokestatic 259	com/tencent/mm/plugin/gallery/model/a:a	(Landroid/database/Cursor;ILjava/lang/String;)Lcom/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem;
    //   355: astore 5
    //   357: aload 5
    //   359: ifnull +60 -> 419
    //   362: aload 7
    //   364: aload 5
    //   366: getfield 269	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:Lmi	Ljava/lang/String;
    //   369: invokevirtual 294	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   372: checkcast 261	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem
    //   375: astore 6
    //   377: aload 6
    //   379: ifnull +32 -> 411
    //   382: aload 5
    //   384: getfield 265	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:did	I
    //   387: istore_1
    //   388: aload 5
    //   390: aload 6
    //   392: getfield 265	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:did	I
    //   395: iload_1
    //   396: iadd
    //   397: putfield 265	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:did	I
    //   400: aload 7
    //   402: aload 5
    //   404: getfield 269	com/tencent/mm/plugin/gallery/model/GalleryItem$AlbumItem:Lmi	Ljava/lang/String;
    //   407: invokevirtual 297	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   410: pop
    //   411: aload 8
    //   413: aload 5
    //   415: invokevirtual 134	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   418: pop
    //   419: aload 4
    //   421: invokeinterface 137 1 0
    //   426: ifne -80 -> 346
    //   429: aload 4
    //   431: invokeinterface 143 1 0
    //   436: goto -336 -> 100
    //   439: aconst_null
    //   440: astore_3
    //   441: goto -144 -> 297
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	444	0	this	a
    //   203	194	1	i	int
    //   187	66	2	j	int
    //   63	74	3	localObject1	java.lang.Object
    //   148	12	3	localException1	java.lang.Exception
    //   201	240	3	localObject2	java.lang.Object
    //   48	250	4	localCursor	android.database.Cursor
    //   307	14	4	localException2	java.lang.Exception
    //   331	99	4	localAlbumItem1	GalleryItem.AlbumItem
    //   184	230	5	localObject3	java.lang.Object
    //   1	390	6	localAlbumItem2	GalleryItem.AlbumItem
    //   15	386	7	localHashMap	java.util.HashMap
    //   24	388	8	localLinkedList	java.util.LinkedList
    //   197	44	9	localAlbumItem3	GalleryItem.AlbumItem
    // Exception table:
    //   from	to	target	type
    //   26	50	148	java/lang/Exception
    //   64	88	307	java/lang/Exception
  }
  
  public final String lC(boolean paramBoolean)
  {
    AppMethodBeat.i(111231);
    if (paramBoolean)
    {
      str = b.rAe + " desc, bucket_display_name desc, _id desc";
      AppMethodBeat.o(111231);
      return str;
    }
    String str = b.rAd + " desc, bucket_display_name desc, _id desc";
    AppMethodBeat.o(111231);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.model.a
 * JD-Core Version:    0.7.0.1
 */