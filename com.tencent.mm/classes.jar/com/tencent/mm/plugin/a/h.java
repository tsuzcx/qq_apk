package com.tencent.mm.plugin.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  private long duration;
  private long fJL;
  private String filePath;
  private long iQF;
  private long[] iQI;
  private int iQJ;
  private List<n> iQK;
  private List<Pair> iQL;
  public m iQM;
  public List<p> iQN;
  
  public h()
  {
    AppMethodBeat.i(133868);
    this.iQN = new ArrayList();
    AppMethodBeat.o(133868);
  }
  
  /* Error */
  public final boolean Jb(String paramString)
  {
    // Byte code:
    //   0: ldc 48
    //   2: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: aconst_null
    //   7: putfield 50	com/tencent/mm/plugin/a/h:filePath	Ljava/lang/String;
    //   10: aload_0
    //   11: aconst_null
    //   12: putfield 52	com/tencent/mm/plugin/a/h:iQI	[J
    //   15: aload_0
    //   16: iconst_0
    //   17: putfield 54	com/tencent/mm/plugin/a/h:iQJ	I
    //   20: aload_0
    //   21: lconst_0
    //   22: putfield 56	com/tencent/mm/plugin/a/h:duration	J
    //   25: aload_0
    //   26: lconst_0
    //   27: putfield 58	com/tencent/mm/plugin/a/h:iQF	J
    //   30: aload_0
    //   31: lconst_0
    //   32: putfield 60	com/tencent/mm/plugin/a/h:fJL	J
    //   35: aload_0
    //   36: getfield 62	com/tencent/mm/plugin/a/h:iQK	Ljava/util/List;
    //   39: ifnull +12 -> 51
    //   42: aload_0
    //   43: getfield 62	com/tencent/mm/plugin/a/h:iQK	Ljava/util/List;
    //   46: invokeinterface 67 1 0
    //   51: aload_0
    //   52: getfield 69	com/tencent/mm/plugin/a/h:iQL	Ljava/util/List;
    //   55: ifnull +12 -> 67
    //   58: aload_0
    //   59: getfield 69	com/tencent/mm/plugin/a/h:iQL	Ljava/util/List;
    //   62: invokeinterface 67 1 0
    //   67: aload_0
    //   68: getfield 39	com/tencent/mm/plugin/a/h:iQN	Ljava/util/List;
    //   71: ifnull +12 -> 83
    //   74: aload_0
    //   75: getfield 39	com/tencent/mm/plugin/a/h:iQN	Ljava/util/List;
    //   78: invokeinterface 67 1 0
    //   83: aload_1
    //   84: invokestatic 74	com/tencent/mm/vfs/i:fv	(Ljava/lang/String;)Z
    //   87: ifne +10 -> 97
    //   90: ldc 48
    //   92: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: iconst_0
    //   96: ireturn
    //   97: aconst_null
    //   98: astore 13
    //   100: aload_1
    //   101: iconst_0
    //   102: invokestatic 78	com/tencent/mm/vfs/i:dd	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   105: astore_1
    //   106: bipush 8
    //   108: newarray byte
    //   110: astore 14
    //   112: aload_1
    //   113: aload 14
    //   115: getstatic 83	com/tencent/mm/plugin/a/a:blp	I
    //   118: invokestatic 89	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;[BI)Lcom/tencent/mm/plugin/a/a;
    //   121: astore 13
    //   123: ldc2_w 90
    //   126: aload 13
    //   128: getfield 94	com/tencent/mm/plugin/a/a:iQi	J
    //   131: ladd
    //   132: lstore 8
    //   134: aload 13
    //   136: invokevirtual 98	com/tencent/mm/plugin/a/a:getSize	()J
    //   139: ldc2_w 90
    //   142: lsub
    //   143: lstore 10
    //   145: lload 10
    //   147: lconst_0
    //   148: lcmp
    //   149: ifle +620 -> 769
    //   152: aload_1
    //   153: lload 8
    //   155: invokevirtual 104	java/io/RandomAccessFile:seek	(J)V
    //   158: aload_1
    //   159: aload 14
    //   161: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   164: pop
    //   165: aload 14
    //   167: iconst_0
    //   168: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   171: istore_3
    //   172: aload 14
    //   174: iconst_4
    //   175: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   178: istore_2
    //   179: iload_2
    //   180: getstatic 115	com/tencent/mm/plugin/a/a:blr	I
    //   183: if_icmpne +427 -> 610
    //   186: new 117	com/tencent/mm/plugin/a/p
    //   189: dup
    //   190: iload_3
    //   191: lload 8
    //   193: iload_2
    //   194: invokespecial 120	com/tencent/mm/plugin/a/p:<init>	(IJI)V
    //   197: astore 15
    //   199: aload 15
    //   201: invokevirtual 121	com/tencent/mm/plugin/a/p:getSize	()J
    //   204: lstore 6
    //   206: lload 6
    //   208: ldc2_w 90
    //   211: lsub
    //   212: lstore 6
    //   214: lload 6
    //   216: lconst_0
    //   217: lcmp
    //   218: ifle +295 -> 513
    //   221: aload_1
    //   222: aload 14
    //   224: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   227: istore_2
    //   228: aload 14
    //   230: iconst_0
    //   231: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   234: istore 4
    //   236: aload 14
    //   238: iconst_4
    //   239: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   242: istore 5
    //   244: lload 6
    //   246: iload 4
    //   248: i2l
    //   249: lsub
    //   250: lstore 6
    //   252: iload 5
    //   254: getstatic 124	com/tencent/mm/plugin/a/a:blD	I
    //   257: if_icmpne +288 -> 545
    //   260: aload 15
    //   262: iload 4
    //   264: iload 5
    //   266: aload_1
    //   267: invokevirtual 127	java/io/RandomAccessFile:getFilePointer	()J
    //   270: iload_2
    //   271: i2l
    //   272: lsub
    //   273: invokestatic 133	com/tencent/mm/plugin/a/i:d	(IIJ)Lcom/tencent/mm/plugin/a/a;
    //   276: checkcast 135	com/tencent/mm/plugin/a/d
    //   279: putfield 139	com/tencent/mm/plugin/a/p:iRE	Lcom/tencent/mm/plugin/a/d;
    //   282: aload 15
    //   284: getfield 139	com/tencent/mm/plugin/a/p:iRE	Lcom/tencent/mm/plugin/a/d;
    //   287: astore 16
    //   289: aload_1
    //   290: ldc 141
    //   292: invokestatic 147	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   295: aload 14
    //   297: ldc 149
    //   299: invokestatic 147	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   302: aload_1
    //   303: aload 14
    //   305: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   308: bipush 8
    //   310: if_icmplt +232 -> 542
    //   313: aload 14
    //   315: iconst_4
    //   316: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   319: getstatic 152	com/tencent/mm/plugin/a/a:blE	I
    //   322: if_icmpne +220 -> 542
    //   325: iconst_4
    //   326: newarray byte
    //   328: astore 13
    //   330: aload_1
    //   331: aload 13
    //   333: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   336: pop
    //   337: aload 13
    //   339: iconst_0
    //   340: baload
    //   341: istore 4
    //   343: aload_1
    //   344: aload 13
    //   346: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   349: pop
    //   350: aload 13
    //   352: iconst_0
    //   353: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   356: istore 5
    //   358: iload 4
    //   360: iconst_1
    //   361: if_icmpne +457 -> 818
    //   364: bipush 8
    //   366: newarray byte
    //   368: astore 13
    //   370: goto +448 -> 818
    //   373: iload_2
    //   374: iload 5
    //   376: if_icmpge +166 -> 542
    //   379: iload 4
    //   381: iconst_1
    //   382: if_icmpne +70 -> 452
    //   385: aload_1
    //   386: aload 13
    //   388: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   391: pop
    //   392: aload 16
    //   394: getfield 155	com/tencent/mm/plugin/a/d:iQn	Ljava/util/List;
    //   397: aload 13
    //   399: invokestatic 159	com/tencent/mm/plugin/a/c:an	([B)J
    //   402: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   405: invokeinterface 169 2 0
    //   410: pop
    //   411: aload_1
    //   412: aload 13
    //   414: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   417: pop
    //   418: aload 16
    //   420: getfield 172	com/tencent/mm/plugin/a/d:iQo	Ljava/util/List;
    //   423: aload 13
    //   425: invokestatic 159	com/tencent/mm/plugin/a/c:an	([B)J
    //   428: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   431: invokeinterface 169 2 0
    //   436: pop
    //   437: aload_1
    //   438: ldc2_w 173
    //   441: invokestatic 177	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;J)Z
    //   444: pop
    //   445: iload_2
    //   446: iconst_1
    //   447: iadd
    //   448: istore_2
    //   449: goto -76 -> 373
    //   452: aload_1
    //   453: aload 13
    //   455: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   458: pop
    //   459: aload 16
    //   461: getfield 155	com/tencent/mm/plugin/a/d:iQn	Ljava/util/List;
    //   464: aload 13
    //   466: iconst_0
    //   467: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   470: i2l
    //   471: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   474: invokeinterface 169 2 0
    //   479: pop
    //   480: aload_1
    //   481: aload 13
    //   483: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   486: pop
    //   487: aload 16
    //   489: getfield 172	com/tencent/mm/plugin/a/d:iQo	Ljava/util/List;
    //   492: aload 13
    //   494: iconst_0
    //   495: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   498: i2l
    //   499: invokestatic 165	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   502: invokeinterface 169 2 0
    //   507: pop
    //   508: goto -71 -> 437
    //   511: astore 13
    //   513: aload_0
    //   514: getfield 39	com/tencent/mm/plugin/a/h:iQN	Ljava/util/List;
    //   517: aload 15
    //   519: invokeinterface 169 2 0
    //   524: pop
    //   525: lload 10
    //   527: iload_3
    //   528: i2l
    //   529: lsub
    //   530: lstore 10
    //   532: lload 8
    //   534: iload_3
    //   535: i2l
    //   536: ladd
    //   537: lstore 8
    //   539: goto -394 -> 145
    //   542: goto -328 -> 214
    //   545: iload 5
    //   547: getstatic 180	com/tencent/mm/plugin/a/a:bls	I
    //   550: if_icmpne +40 -> 590
    //   553: aload 15
    //   555: iload 4
    //   557: iload 5
    //   559: aload_1
    //   560: invokevirtual 127	java/io/RandomAccessFile:getFilePointer	()J
    //   563: iload_2
    //   564: i2l
    //   565: lsub
    //   566: invokestatic 133	com/tencent/mm/plugin/a/i:d	(IIJ)Lcom/tencent/mm/plugin/a/a;
    //   569: checkcast 182	com/tencent/mm/plugin/a/g
    //   572: putfield 186	com/tencent/mm/plugin/a/p:iRD	Lcom/tencent/mm/plugin/a/g;
    //   575: aload 15
    //   577: getfield 186	com/tencent/mm/plugin/a/p:iRD	Lcom/tencent/mm/plugin/a/g;
    //   580: aload_1
    //   581: aload 14
    //   583: invokevirtual 189	com/tencent/mm/plugin/a/g:a	(Ljava/io/RandomAccessFile;[B)Z
    //   586: pop
    //   587: goto -373 -> 214
    //   590: aload_1
    //   591: iload 4
    //   593: bipush 8
    //   595: isub
    //   596: i2l
    //   597: invokestatic 177	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;J)Z
    //   600: istore 12
    //   602: iload 12
    //   604: ifeq -91 -> 513
    //   607: goto -393 -> 214
    //   610: iload_2
    //   611: getstatic 192	com/tencent/mm/plugin/a/a:blq	I
    //   614: if_icmpne -89 -> 525
    //   617: aload_0
    //   618: new 194	com/tencent/mm/plugin/a/m
    //   621: dup
    //   622: iload_3
    //   623: lload 8
    //   625: iload_2
    //   626: invokespecial 195	com/tencent/mm/plugin/a/m:<init>	(IJI)V
    //   629: putfield 197	com/tencent/mm/plugin/a/h:iQM	Lcom/tencent/mm/plugin/a/m;
    //   632: aload_0
    //   633: getfield 197	com/tencent/mm/plugin/a/h:iQM	Lcom/tencent/mm/plugin/a/m;
    //   636: astore 13
    //   638: aload_1
    //   639: ldc 141
    //   641: invokestatic 147	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   644: aload 14
    //   646: ldc 149
    //   648: invokestatic 147	d/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   651: iconst_4
    //   652: newarray byte
    //   654: astore 15
    //   656: aload_1
    //   657: ldc2_w 198
    //   660: invokestatic 177	com/tencent/mm/plugin/a/c:a	(Ljava/io/RandomAccessFile;J)Z
    //   663: pop
    //   664: aload_1
    //   665: aload 15
    //   667: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   670: pop
    //   671: aload 13
    //   673: aload 15
    //   675: iconst_0
    //   676: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   679: i2l
    //   680: putfield 200	com/tencent/mm/plugin/a/m:iQF	J
    //   683: aload_1
    //   684: aload 15
    //   686: invokevirtual 108	java/io/RandomAccessFile:read	([B)I
    //   689: pop
    //   690: aload 13
    //   692: aload 15
    //   694: iconst_0
    //   695: invokestatic 112	com/tencent/mm/plugin/a/c:readInt	([BI)I
    //   698: i2l
    //   699: putfield 201	com/tencent/mm/plugin/a/m:duration	J
    //   702: aload_0
    //   703: aload_0
    //   704: getfield 197	com/tencent/mm/plugin/a/h:iQM	Lcom/tencent/mm/plugin/a/m;
    //   707: getfield 200	com/tencent/mm/plugin/a/m:iQF	J
    //   710: putfield 58	com/tencent/mm/plugin/a/h:iQF	J
    //   713: aload_0
    //   714: aload_0
    //   715: getfield 197	com/tencent/mm/plugin/a/h:iQM	Lcom/tencent/mm/plugin/a/m;
    //   718: getfield 201	com/tencent/mm/plugin/a/m:duration	J
    //   721: putfield 56	com/tencent/mm/plugin/a/h:duration	J
    //   724: new 203	java/lang/StringBuilder
    //   727: dup
    //   728: ldc 205
    //   730: invokespecial 208	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   733: aload_0
    //   734: getfield 58	com/tencent/mm/plugin/a/h:iQF	J
    //   737: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   740: ldc 214
    //   742: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: aload_0
    //   746: getfield 56	com/tencent/mm/plugin/a/h:duration	J
    //   749: invokevirtual 212	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   752: pop
    //   753: goto -228 -> 525
    //   756: astore 13
    //   758: aload_1
    //   759: invokestatic 222	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   762: ldc 48
    //   764: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   767: iconst_0
    //   768: ireturn
    //   769: aload_1
    //   770: invokestatic 222	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   773: ldc 48
    //   775: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   778: iconst_1
    //   779: ireturn
    //   780: astore_1
    //   781: aconst_null
    //   782: astore 13
    //   784: aload 13
    //   786: invokestatic 222	com/tencent/mm/sdk/platformtools/bt:d	(Ljava/io/Closeable;)V
    //   789: ldc 48
    //   791: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   794: aload_1
    //   795: athrow
    //   796: astore 13
    //   798: aload_1
    //   799: astore 14
    //   801: aload 13
    //   803: astore_1
    //   804: aload 14
    //   806: astore 13
    //   808: goto -24 -> 784
    //   811: astore_1
    //   812: aload 13
    //   814: astore_1
    //   815: goto -57 -> 758
    //   818: iconst_0
    //   819: istore_2
    //   820: goto -447 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	823	0	this	h
    //   0	823	1	paramString	String
    //   178	642	2	i	int
    //   171	452	3	j	int
    //   234	362	4	k	int
    //   242	316	5	m	int
    //   204	47	6	l1	long
    //   132	492	8	l2	long
    //   143	388	10	l3	long
    //   600	3	12	bool	boolean
    //   98	395	13	localObject1	Object
    //   511	1	13	localException1	java.lang.Exception
    //   636	55	13	localm	m
    //   756	1	13	localException2	java.lang.Exception
    //   782	3	13	localCloseable	java.io.Closeable
    //   796	6	13	localObject2	Object
    //   806	7	13	localObject3	Object
    //   110	695	14	localObject4	Object
    //   197	496	15	localObject5	Object
    //   287	201	16	locald	d
    // Exception table:
    //   from	to	target	type
    //   221	244	511	java/lang/Exception
    //   252	337	511	java/lang/Exception
    //   343	358	511	java/lang/Exception
    //   364	370	511	java/lang/Exception
    //   385	437	511	java/lang/Exception
    //   437	445	511	java/lang/Exception
    //   452	508	511	java/lang/Exception
    //   545	587	511	java/lang/Exception
    //   590	602	511	java/lang/Exception
    //   106	145	756	java/lang/Exception
    //   152	206	756	java/lang/Exception
    //   513	525	756	java/lang/Exception
    //   610	753	756	java/lang/Exception
    //   100	106	780	finally
    //   106	145	796	finally
    //   152	206	796	finally
    //   221	244	796	finally
    //   252	337	796	finally
    //   343	358	796	finally
    //   364	370	796	finally
    //   385	437	796	finally
    //   437	445	796	finally
    //   452	508	796	finally
    //   513	525	796	finally
    //   545	587	796	finally
    //   590	602	796	finally
    //   610	753	796	finally
    //   100	106	811	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.a.h
 * JD-Core Version:    0.7.0.1
 */