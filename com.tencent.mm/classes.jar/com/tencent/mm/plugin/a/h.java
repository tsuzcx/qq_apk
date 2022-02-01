package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  private long duration;
  private String filePath;
  private long lxo;
  private long pEc;
  private long[] pEf;
  private int pEg;
  private List<n> pEh;
  private List<Pair> pEi;
  public m pEj;
  public List<p> pEk;
  
  public h()
  {
    AppMethodBeat.i(133868);
    this.pEk = new ArrayList();
    AppMethodBeat.o(133868);
  }
  
  /* Error */
  public final boolean Sn(String paramString)
  {
    // Byte code:
    //   0: ldc 48
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aconst_null
    //   7: putfield 50	com/tencent/mm/plugin/a/h:filePath	Ljava/lang/String;
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield 52	com/tencent/mm/plugin/a/h:pEf	[J
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 54	com/tencent/mm/plugin/a/h:pEg	I
    //   20: aload_0
    //   21: lconst_0
    //   22: putfield 56	com/tencent/mm/plugin/a/h:duration	J
    //   25: aload_0
    //   26: lconst_0
    //   27: putfield 58	com/tencent/mm/plugin/a/h:pEc	J
    //   30: aload_0
    //   31: lconst_0
    //   32: putfield 60	com/tencent/mm/plugin/a/h:lxo	J
    //   35: aload_0
    //   36: getfield 62	com/tencent/mm/plugin/a/h:pEh	Ljava/util/List;
    //   39: ifnull +12 -> 51
    //   42: aload_0
    //   43: getfield 62	com/tencent/mm/plugin/a/h:pEh	Ljava/util/List;
    //   46: invokeinterface 67 1 0
    //   51: aload_0
    //   52: getfield 69	com/tencent/mm/plugin/a/h:pEi	Ljava/util/List;
    //   55: ifnull +12 -> 67
    //   58: aload_0
    //   59: getfield 69	com/tencent/mm/plugin/a/h:pEi	Ljava/util/List;
    //   62: invokeinterface 67 1 0
    //   67: aload_0
    //   68: getfield 39	com/tencent/mm/plugin/a/h:pEk	Ljava/util/List;
    //   71: ifnull +12 -> 83
    //   74: aload_0
    //   75: getfield 39	com/tencent/mm/plugin/a/h:pEk	Ljava/util/List;
    //   78: invokeinterface 67 1 0
    //   83: aload_1
    //   84: invokestatic 74	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   87: ifne +10 -> 97
    //   90: ldc 48
    //   92: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: iconst_0
    //   96: ireturn
    //   97: aconst_null
    //   98: astore 14
    //   100: aload_1
    //   101: iconst_0
    //   102: invokestatic 78	com/tencent/mm/vfs/y:eA	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   105: astore_1
    //   106: bipush 8
    //   108: newarray byte
    //   110: astore 15
    //   112: aload_1
    //   113: aload 15
    //   115: getstatic 83	com/tencent/mm/plugin/a/a:cOI	I
    //   118: invokestatic 89	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;[BI)Lcom/tencent/mm/plugin/a/a;
    //   121: astore 14
    //   123: ldc2_w 90
    //   126: aload 14
    //   128: getfield 94	com/tencent/mm/plugin/a/a:pDG	J
    //   131: ladd
    //   132: lstore 9
    //   134: aload 14
    //   136: invokevirtual 98	com/tencent/mm/plugin/a/a:getSize	()J
    //   139: ldc2_w 90
    //   142: lsub
    //   143: lstore 11
    //   145: lload 11
    //   147: lconst_0
    //   148: lcmp
    //   149: ifle +619 -> 768
    //   152: aload_1
    //   153: lload 9
    //   155: invokevirtual 104	java/io/RandomAccessFile:seek	(J)V
    //   158: aload_1
    //   159: aload 15
    //   161: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   164: pop
    //   165: aload 15
    //   167: iconst_0
    //   168: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   171: istore 4
    //   173: aload 15
    //   175: iconst_4
    //   176: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   179: istore_2
    //   180: iload_2
    //   181: getstatic 115	com/tencent/mm/plugin/a/a:cOK	I
    //   184: if_icmpne +424 -> 608
    //   187: new 117	com/tencent/mm/plugin/a/p
    //   190: dup
    //   191: iload 4
    //   193: lload 9
    //   195: iload_2
    //   196: invokespecial 120	com/tencent/mm/plugin/a/p:<init>	(IJI)V
    //   199: astore 16
    //   201: aload 16
    //   203: invokevirtual 121	com/tencent/mm/plugin/a/p:getSize	()J
    //   206: lstore 7
    //   208: lload 7
    //   210: ldc2_w 90
    //   213: lsub
    //   214: lstore 7
    //   216: lload 7
    //   218: lconst_0
    //   219: lcmp
    //   220: ifle +294 -> 514
    //   223: aload_1
    //   224: aload 15
    //   226: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   229: istore_2
    //   230: aload 15
    //   232: iconst_0
    //   233: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   236: istore_3
    //   237: aload 15
    //   239: iconst_4
    //   240: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   243: istore 5
    //   245: lload 7
    //   247: iload_3
    //   248: i2l
    //   249: lsub
    //   250: lstore 7
    //   252: iload 5
    //   254: getstatic 124	com/tencent/mm/plugin/a/a:cOW	I
    //   257: if_icmpne +288 -> 545
    //   260: aload 16
    //   262: iload_3
    //   263: iload 5
    //   265: aload_1
    //   266: invokevirtual 127	java/io/RandomAccessFile:getFilePointer	()J
    //   269: iload_2
    //   270: i2l
    //   271: lsub
    //   272: invokestatic 133	com/tencent/mm/plugin/a/i:f	(IIJ)Lcom/tencent/mm/plugin/a/a;
    //   275: checkcast 135	com/tencent/mm/plugin/a/d
    //   278: putfield 139	com/tencent/mm/plugin/a/p:pFb	Lcom/tencent/mm/plugin/a/d;
    //   281: aload 16
    //   283: getfield 139	com/tencent/mm/plugin/a/p:pFb	Lcom/tencent/mm/plugin/a/d;
    //   286: astore 17
    //   288: aload_1
    //   289: ldc 141
    //   291: invokestatic 147	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   294: aload 15
    //   296: ldc 149
    //   298: invokestatic 147	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   301: aload_1
    //   302: aload 15
    //   304: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   307: bipush 8
    //   309: if_icmplt +518 -> 827
    //   312: aload 15
    //   314: iconst_4
    //   315: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   318: getstatic 152	com/tencent/mm/plugin/a/a:cOX	I
    //   321: if_icmpne +506 -> 827
    //   324: iconst_4
    //   325: newarray byte
    //   327: astore 14
    //   329: aload_1
    //   330: aload 14
    //   332: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   335: pop
    //   336: aload 14
    //   338: iconst_0
    //   339: baload
    //   340: istore 5
    //   342: aload_1
    //   343: aload 14
    //   345: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   348: pop
    //   349: aload 14
    //   351: iconst_0
    //   352: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   355: istore 6
    //   357: iload 5
    //   359: iconst_1
    //   360: if_icmpne +457 -> 817
    //   363: bipush 8
    //   365: newarray byte
    //   367: astore 14
    //   369: goto +448 -> 817
    //   372: iload_2
    //   373: iconst_1
    //   374: iadd
    //   375: istore_3
    //   376: iload 5
    //   378: iconst_1
    //   379: if_icmpne +74 -> 453
    //   382: aload_1
    //   383: aload 14
    //   385: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   388: pop
    //   389: aload 17
    //   391: getfield 155	com/tencent/mm/plugin/a/d:pDK	Ljava/util/List;
    //   394: aload 14
    //   396: invokestatic 159	com/tencent/mm/plugin/a/c:aP	([B)J
    //   399: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   402: invokeinterface 169 2 0
    //   407: pop
    //   408: aload_1
    //   409: aload 14
    //   411: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   414: pop
    //   415: aload 17
    //   417: getfield 172	com/tencent/mm/plugin/a/d:pDL	Ljava/util/List;
    //   420: aload 14
    //   422: invokestatic 159	com/tencent/mm/plugin/a/c:aP	([B)J
    //   425: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   428: invokeinterface 169 2 0
    //   433: pop
    //   434: aload_1
    //   435: ldc2_w 173
    //   438: invokestatic 177	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;J)Z
    //   441: pop
    //   442: iload_3
    //   443: istore_2
    //   444: iload_3
    //   445: iload 6
    //   447: if_icmplt -75 -> 372
    //   450: goto +377 -> 827
    //   453: aload_1
    //   454: aload 14
    //   456: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   459: pop
    //   460: aload 17
    //   462: getfield 155	com/tencent/mm/plugin/a/d:pDK	Ljava/util/List;
    //   465: aload 14
    //   467: iconst_0
    //   468: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   471: i2l
    //   472: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   475: invokeinterface 169 2 0
    //   480: pop
    //   481: aload_1
    //   482: aload 14
    //   484: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   487: pop
    //   488: aload 17
    //   490: getfield 172	com/tencent/mm/plugin/a/d:pDL	Ljava/util/List;
    //   493: aload 14
    //   495: iconst_0
    //   496: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   499: i2l
    //   500: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   503: invokeinterface 169 2 0
    //   508: pop
    //   509: goto -75 -> 434
    //   512: astore 14
    //   514: aload_0
    //   515: getfield 39	com/tencent/mm/plugin/a/h:pEk	Ljava/util/List;
    //   518: aload 16
    //   520: invokeinterface 169 2 0
    //   525: pop
    //   526: lload 11
    //   528: iload 4
    //   530: i2l
    //   531: lsub
    //   532: lstore 11
    //   534: lload 9
    //   536: iload 4
    //   538: i2l
    //   539: ladd
    //   540: lstore 9
    //   542: goto -397 -> 145
    //   545: iload 5
    //   547: getstatic 180	com/tencent/mm/plugin/a/a:cOL	I
    //   550: if_icmpne +39 -> 589
    //   553: aload 16
    //   555: iload_3
    //   556: iload 5
    //   558: aload_1
    //   559: invokevirtual 127	java/io/RandomAccessFile:getFilePointer	()J
    //   562: iload_2
    //   563: i2l
    //   564: lsub
    //   565: invokestatic 133	com/tencent/mm/plugin/a/i:f	(IIJ)Lcom/tencent/mm/plugin/a/a;
    //   568: checkcast 182	com/tencent/mm/plugin/a/g
    //   571: putfield 186	com/tencent/mm/plugin/a/p:pFa	Lcom/tencent/mm/plugin/a/g;
    //   574: aload 16
    //   576: getfield 186	com/tencent/mm/plugin/a/p:pFa	Lcom/tencent/mm/plugin/a/g;
    //   579: aload_1
    //   580: aload 15
    //   582: invokevirtual 189	com/tencent/mm/plugin/a/g:a	(Ljava/io/RandomAccessFile;[B)Z
    //   585: pop
    //   586: goto -370 -> 216
    //   589: aload_1
    //   590: iload_3
    //   591: bipush 8
    //   593: isub
    //   594: i2l
    //   595: invokestatic 177	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;J)Z
    //   598: istore 13
    //   600: iload 13
    //   602: ifeq -88 -> 514
    //   605: goto -389 -> 216
    //   608: iload_2
    //   609: getstatic 192	com/tencent/mm/plugin/a/a:cOJ	I
    //   612: if_icmpne -86 -> 526
    //   615: aload_0
    //   616: new 194	com/tencent/mm/plugin/a/m
    //   619: dup
    //   620: iload 4
    //   622: lload 9
    //   624: iload_2
    //   625: invokespecial 195	com/tencent/mm/plugin/a/m:<init>	(IJI)V
    //   628: putfield 197	com/tencent/mm/plugin/a/h:pEj	Lcom/tencent/mm/plugin/a/m;
    //   631: aload_0
    //   632: getfield 197	com/tencent/mm/plugin/a/h:pEj	Lcom/tencent/mm/plugin/a/m;
    //   635: astore 14
    //   637: aload_1
    //   638: ldc 141
    //   640: invokestatic 147	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   643: aload 15
    //   645: ldc 149
    //   647: invokestatic 147	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   650: iconst_4
    //   651: newarray byte
    //   653: astore 16
    //   655: aload_1
    //   656: ldc2_w 198
    //   659: invokestatic 177	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;J)Z
    //   662: pop
    //   663: aload_1
    //   664: aload 16
    //   666: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   669: pop
    //   670: aload 14
    //   672: aload 16
    //   674: iconst_0
    //   675: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   678: i2l
    //   679: putfield 200	com/tencent/mm/plugin/a/m:pEc	J
    //   682: aload_1
    //   683: aload 16
    //   685: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   688: pop
    //   689: aload 14
    //   691: aload 16
    //   693: iconst_0
    //   694: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   697: i2l
    //   698: putfield 201	com/tencent/mm/plugin/a/m:duration	J
    //   701: aload_0
    //   702: aload_0
    //   703: getfield 197	com/tencent/mm/plugin/a/h:pEj	Lcom/tencent/mm/plugin/a/m;
    //   706: getfield 200	com/tencent/mm/plugin/a/m:pEc	J
    //   709: putfield 58	com/tencent/mm/plugin/a/h:pEc	J
    //   712: aload_0
    //   713: aload_0
    //   714: getfield 197	com/tencent/mm/plugin/a/h:pEj	Lcom/tencent/mm/plugin/a/m;
    //   717: getfield 201	com/tencent/mm/plugin/a/m:duration	J
    //   720: putfield 56	com/tencent/mm/plugin/a/h:duration	J
    //   723: new 203	java/lang/StringBuilder
    //   726: dup
    //   727: ldc 205
    //   729: invokespecial 208	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   732: aload_0
    //   733: getfield 58	com/tencent/mm/plugin/a/h:pEc	J
    //   736: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   739: ldc 214
    //   741: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: aload_0
    //   745: getfield 56	com/tencent/mm/plugin/a/h:duration	J
    //   748: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: goto -226 -> 526
    //   755: astore 14
    //   757: aload_1
    //   758: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   761: ldc 48
    //   763: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   766: iconst_0
    //   767: ireturn
    //   768: aload_1
    //   769: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   772: ldc 48
    //   774: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   777: iconst_1
    //   778: ireturn
    //   779: astore_1
    //   780: aconst_null
    //   781: astore 14
    //   783: aload 14
    //   785: invokestatic 223	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   788: ldc 48
    //   790: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   793: aload_1
    //   794: athrow
    //   795: astore 14
    //   797: aload_1
    //   798: astore 15
    //   800: aload 14
    //   802: astore_1
    //   803: aload 15
    //   805: astore 14
    //   807: goto -24 -> 783
    //   810: astore_1
    //   811: aload 14
    //   813: astore_1
    //   814: goto -57 -> 757
    //   817: iconst_0
    //   818: istore_2
    //   819: iload 6
    //   821: ifle +6 -> 827
    //   824: goto -452 -> 372
    //   827: goto -611 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	830	0	this	h
    //   0	830	1	paramString	String
    //   179	640	2	i	int
    //   236	358	3	j	int
    //   171	450	4	k	int
    //   243	314	5	m	int
    //   355	465	6	n	int
    //   206	45	7	l1	long
    //   132	491	9	l2	long
    //   143	390	11	l3	long
    //   598	3	13	bool	boolean
    //   98	396	14	localObject1	Object
    //   512	1	14	localException1	java.lang.Exception
    //   635	55	14	localm	m
    //   755	1	14	localException2	java.lang.Exception
    //   781	3	14	localCloseable	java.io.Closeable
    //   795	6	14	localObject2	Object
    //   805	7	14	localObject3	Object
    //   110	694	15	localObject4	Object
    //   199	493	16	localObject5	Object
    //   286	203	17	locald	d
    // Exception table:
    //   from	to	target	type
    //   223	245	512	java/lang/Exception
    //   252	336	512	java/lang/Exception
    //   342	357	512	java/lang/Exception
    //   363	369	512	java/lang/Exception
    //   382	434	512	java/lang/Exception
    //   434	442	512	java/lang/Exception
    //   453	509	512	java/lang/Exception
    //   545	586	512	java/lang/Exception
    //   589	600	512	java/lang/Exception
    //   106	145	755	java/lang/Exception
    //   152	208	755	java/lang/Exception
    //   514	526	755	java/lang/Exception
    //   608	752	755	java/lang/Exception
    //   100	106	779	finally
    //   106	145	795	finally
    //   152	208	795	finally
    //   223	245	795	finally
    //   252	336	795	finally
    //   342	357	795	finally
    //   363	369	795	finally
    //   382	434	795	finally
    //   434	442	795	finally
    //   453	509	795	finally
    //   514	526	795	finally
    //   545	586	795	finally
    //   589	600	795	finally
    //   608	752	795	finally
    //   100	106	810	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.a.h
 * JD-Core Version:    0.7.0.1
 */