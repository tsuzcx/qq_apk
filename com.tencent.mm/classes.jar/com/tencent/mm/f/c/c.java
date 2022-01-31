package com.tencent.mm.f.c;

import com.tencent.mm.compatible.e.m;
import com.tencent.mm.f.b.g.a;
import com.tencent.mm.modelvoice.MediaRecorder;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public final class c
  implements a
{
  private static a.a bEB = new a.a();
  private boolean bEA = false;
  public BlockingQueue<g.a> bEq = new ArrayBlockingQueue(1024);
  public boolean bEr = false;
  private String bEs;
  private int bEt = 0;
  private byte[] bEu = null;
  private int bEv = 16000;
  private Object bEw = new Object();
  public a bEx = null;
  private OutputStream bEy;
  private int bEz;
  private int mSampleRate = 16000;
  private boolean pHT = false;
  
  public c(int paramInt1, int paramInt2)
  {
    this.mSampleRate = paramInt1;
    this.bEv = paramInt2;
  }
  
  public final int a(g.a parama)
  {
    return a(parama, 0, false);
  }
  
  /* Error */
  public final int a(g.a parama, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 89	com/tencent/mm/compatible/util/g$a
    //   3: dup
    //   4: invokespecial 90	com/tencent/mm/compatible/util/g$a:<init>	()V
    //   7: astore 14
    //   9: aload_0
    //   10: getfield 60	com/tencent/mm/f/c/c:mSampleRate	I
    //   13: bipush 20
    //   15: imul
    //   16: iconst_2
    //   17: imul
    //   18: sipush 1000
    //   21: idiv
    //   22: i2s
    //   23: istore 4
    //   25: aload_0
    //   26: getfield 56	com/tencent/mm/f/c/c:bEt	I
    //   29: aload_1
    //   30: getfield 95	com/tencent/mm/f/b/g$a:bDu	I
    //   33: iadd
    //   34: istore 7
    //   36: iconst_0
    //   37: istore 6
    //   39: iload 4
    //   41: newarray byte
    //   43: astore 15
    //   45: aload_0
    //   46: getfield 70	com/tencent/mm/f/c/c:bEA	Z
    //   49: ifeq +468 -> 517
    //   52: bipush 6
    //   54: istore 5
    //   56: iload 5
    //   58: iload 4
    //   60: imul
    //   61: newarray byte
    //   63: astore 16
    //   65: ldc 97
    //   67: invokestatic 103	com/tencent/mm/kernel/g:r	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   70: checkcast 97	com/tencent/mm/plugin/zero/b/a
    //   73: invokeinterface 107 1 0
    //   78: ldc 109
    //   80: invokevirtual 115	com/tencent/mm/m/e:getValue	(Ljava/lang/String;)Ljava/lang/String;
    //   83: astore 17
    //   85: aload 17
    //   87: invokestatic 121	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   90: ifne +971 -> 1061
    //   93: aload 17
    //   95: iconst_1
    //   96: invokestatic 125	com/tencent/mm/sdk/platformtools/bk:getInt	(Ljava/lang/String;I)I
    //   99: iconst_1
    //   100: if_icmpne +423 -> 523
    //   103: iconst_1
    //   104: istore 11
    //   106: iload_3
    //   107: ifeq +6 -> 113
    //   110: iconst_0
    //   111: istore 11
    //   113: ldc 127
    //   115: ldc 129
    //   117: iconst_1
    //   118: anewarray 4	java/lang/Object
    //   121: dup
    //   122: iconst_0
    //   123: iload 11
    //   125: invokestatic 135	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   128: aastore
    //   129: invokestatic 141	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   132: iconst_0
    //   133: istore 5
    //   135: iload 7
    //   137: iload 4
    //   139: if_icmplt +698 -> 837
    //   142: aload_0
    //   143: getfield 56	com/tencent/mm/f/c/c:bEt	I
    //   146: ifle +427 -> 573
    //   149: aload_0
    //   150: getfield 58	com/tencent/mm/f/c/c:bEu	[B
    //   153: iconst_0
    //   154: aload 15
    //   156: iconst_0
    //   157: aload_0
    //   158: getfield 56	com/tencent/mm/f/c/c:bEt	I
    //   161: invokestatic 147	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   164: aload_1
    //   165: getfield 150	com/tencent/mm/f/b/g$a:buf	[B
    //   168: iconst_0
    //   169: aload 15
    //   171: aload_0
    //   172: getfield 56	com/tencent/mm/f/c/c:bEt	I
    //   175: iload 4
    //   177: aload_0
    //   178: getfield 56	com/tencent/mm/f/c/c:bEt	I
    //   181: isub
    //   182: invokestatic 147	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   185: iload 6
    //   187: iload 4
    //   189: aload_0
    //   190: getfield 56	com/tencent/mm/f/c/c:bEt	I
    //   193: isub
    //   194: iadd
    //   195: istore 6
    //   197: aload_0
    //   198: iconst_0
    //   199: putfield 56	com/tencent/mm/f/c/c:bEt	I
    //   202: iload 7
    //   204: iload 4
    //   206: isub
    //   207: istore 7
    //   209: iconst_1
    //   210: newarray short
    //   212: astore 17
    //   214: aload_0
    //   215: getfield 64	com/tencent/mm/f/c/c:bEw	Ljava/lang/Object;
    //   218: astore 18
    //   220: aload 18
    //   222: monitorenter
    //   223: aload_0
    //   224: getfield 70	com/tencent/mm/f/c/c:bEA	Z
    //   227: ifeq +32 -> 259
    //   230: iload 7
    //   232: iload 4
    //   234: if_icmpge +400 -> 634
    //   237: aload_1
    //   238: getfield 153	com/tencent/mm/f/b/g$a:bDv	Z
    //   241: ifeq +393 -> 634
    //   244: sipush 201
    //   247: iconst_1
    //   248: invokestatic 159	com/tencent/mm/modelvoice/MediaRecorder:SetVoiceSilkControl	(II)I
    //   251: pop
    //   252: ldc 127
    //   254: ldc 161
    //   256: invokestatic 165	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload 15
    //   261: iload 4
    //   263: aload 16
    //   265: aload 17
    //   267: iload 11
    //   269: invokestatic 169	com/tencent/mm/modelvoice/MediaRecorder:SilkDoEnc	([BS[B[SZ)I
    //   272: istore 10
    //   274: aload 18
    //   276: monitorexit
    //   277: iconst_0
    //   278: istore 9
    //   280: iload 9
    //   282: istore 8
    //   284: iload_3
    //   285: ifeq +159 -> 444
    //   288: iload 9
    //   290: istore 8
    //   292: aload 17
    //   294: iconst_0
    //   295: saload
    //   296: bipush 10
    //   298: if_icmplt +146 -> 444
    //   301: iload 9
    //   303: istore 8
    //   305: aload 16
    //   307: iconst_0
    //   308: baload
    //   309: iconst_2
    //   310: if_icmpne +134 -> 444
    //   313: iload 9
    //   315: istore 8
    //   317: aload 16
    //   319: iconst_1
    //   320: baload
    //   321: bipush 35
    //   323: if_icmpne +121 -> 444
    //   326: iload 9
    //   328: istore 8
    //   330: aload 16
    //   332: iconst_2
    //   333: baload
    //   334: bipush 33
    //   336: if_icmpne +108 -> 444
    //   339: iload 9
    //   341: istore 8
    //   343: aload 16
    //   345: iconst_3
    //   346: baload
    //   347: bipush 83
    //   349: if_icmpne +95 -> 444
    //   352: iload 9
    //   354: istore 8
    //   356: aload 16
    //   358: iconst_4
    //   359: baload
    //   360: bipush 73
    //   362: if_icmpne +82 -> 444
    //   365: iload 9
    //   367: istore 8
    //   369: aload 16
    //   371: iconst_5
    //   372: baload
    //   373: bipush 76
    //   375: if_icmpne +69 -> 444
    //   378: iload 9
    //   380: istore 8
    //   382: aload 16
    //   384: bipush 6
    //   386: baload
    //   387: bipush 75
    //   389: if_icmpne +55 -> 444
    //   392: iload 9
    //   394: istore 8
    //   396: aload 16
    //   398: bipush 7
    //   400: baload
    //   401: bipush 95
    //   403: if_icmpne +41 -> 444
    //   406: iload 9
    //   408: istore 8
    //   410: aload 16
    //   412: bipush 8
    //   414: baload
    //   415: bipush 86
    //   417: if_icmpne +27 -> 444
    //   420: iload 9
    //   422: istore 8
    //   424: aload 16
    //   426: bipush 9
    //   428: baload
    //   429: bipush 51
    //   431: if_icmpne +13 -> 444
    //   434: ldc 127
    //   436: ldc 171
    //   438: invokestatic 165	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   441: iconst_1
    //   442: istore 8
    //   444: iload 10
    //   446: ifeq +205 -> 651
    //   449: aload_0
    //   450: iconst_0
    //   451: putfield 56	com/tencent/mm/f/c/c:bEt	I
    //   454: ldc 127
    //   456: ldc 173
    //   458: iconst_1
    //   459: anewarray 4	java/lang/Object
    //   462: dup
    //   463: iconst_0
    //   464: iload 10
    //   466: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   469: aastore
    //   470: invokestatic 181	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   473: aload_0
    //   474: getfield 68	com/tencent/mm/f/c/c:pHT	Z
    //   477: ifne +38 -> 515
    //   480: getstatic 187	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   483: ldc2_w 188
    //   486: ldc2_w 190
    //   489: lconst_1
    //   490: invokevirtual 195	com/tencent/mm/plugin/report/service/h:h	(JJJ)V
    //   493: aload_0
    //   494: iconst_1
    //   495: putfield 68	com/tencent/mm/f/c/c:pHT	Z
    //   498: getstatic 200	com/tencent/mm/protocal/d:spd	Z
    //   501: ifeq +14 -> 515
    //   504: getstatic 187	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   507: ldc 202
    //   509: ldc 204
    //   511: aconst_null
    //   512: invokevirtual 207	com/tencent/mm/plugin/report/service/h:d	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   515: iconst_m1
    //   516: ireturn
    //   517: iconst_1
    //   518: istore 5
    //   520: goto -464 -> 56
    //   523: iconst_0
    //   524: istore 11
    //   526: goto -420 -> 106
    //   529: astore_1
    //   530: ldc 127
    //   532: ldc 209
    //   534: iconst_3
    //   535: anewarray 4	java/lang/Object
    //   538: dup
    //   539: iconst_0
    //   540: aload_0
    //   541: getfield 56	com/tencent/mm/f/c/c:bEt	I
    //   544: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   547: aastore
    //   548: dup
    //   549: iconst_1
    //   550: iload 4
    //   552: aload_0
    //   553: getfield 56	com/tencent/mm/f/c/c:bEt	I
    //   556: isub
    //   557: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   560: aastore
    //   561: dup
    //   562: iconst_2
    //   563: aload_1
    //   564: invokevirtual 213	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   567: aastore
    //   568: invokestatic 181	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   571: iconst_m1
    //   572: ireturn
    //   573: aload_1
    //   574: getfield 150	com/tencent/mm/f/b/g$a:buf	[B
    //   577: iload 6
    //   579: aload 15
    //   581: iconst_0
    //   582: iload 4
    //   584: invokestatic 147	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   587: iload 6
    //   589: iload 4
    //   591: iadd
    //   592: istore 6
    //   594: goto -392 -> 202
    //   597: astore_1
    //   598: ldc 127
    //   600: ldc 215
    //   602: iconst_3
    //   603: anewarray 4	java/lang/Object
    //   606: dup
    //   607: iconst_0
    //   608: iload 6
    //   610: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   613: aastore
    //   614: dup
    //   615: iconst_1
    //   616: iload 4
    //   618: invokestatic 220	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   621: aastore
    //   622: dup
    //   623: iconst_2
    //   624: aload_1
    //   625: invokevirtual 213	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   628: aastore
    //   629: invokestatic 181	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   632: iconst_m1
    //   633: ireturn
    //   634: sipush 201
    //   637: iconst_0
    //   638: invokestatic 159	com/tencent/mm/modelvoice/MediaRecorder:SetVoiceSilkControl	(II)I
    //   641: pop
    //   642: goto -383 -> 259
    //   645: astore_1
    //   646: aload 18
    //   648: monitorexit
    //   649: aload_1
    //   650: athrow
    //   651: ldc 127
    //   653: ldc 222
    //   655: iconst_4
    //   656: anewarray 4	java/lang/Object
    //   659: dup
    //   660: iconst_0
    //   661: aload 17
    //   663: iconst_0
    //   664: saload
    //   665: invokestatic 220	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   668: aastore
    //   669: dup
    //   670: iconst_1
    //   671: iload 4
    //   673: invokestatic 220	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   676: aastore
    //   677: dup
    //   678: iconst_2
    //   679: aload_1
    //   680: getfield 153	com/tencent/mm/f/b/g$a:bDv	Z
    //   683: invokestatic 135	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   686: aastore
    //   687: dup
    //   688: iconst_3
    //   689: aload_1
    //   690: getfield 95	com/tencent/mm/f/b/g$a:bDu	I
    //   693: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   696: aastore
    //   697: invokestatic 225	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   700: iload 5
    //   702: istore 9
    //   704: aload 17
    //   706: iconst_0
    //   707: saload
    //   708: aload 16
    //   710: arraylength
    //   711: if_icmpge +98 -> 809
    //   714: iload 5
    //   716: istore 9
    //   718: aload 17
    //   720: iconst_0
    //   721: saload
    //   722: ifle +87 -> 809
    //   725: iload_3
    //   726: ifeq +56 -> 782
    //   729: iload 8
    //   731: ifeq +51 -> 782
    //   734: ldc 127
    //   736: ldc 227
    //   738: invokestatic 165	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   741: aload 16
    //   743: iconst_1
    //   744: aload 16
    //   746: arraylength
    //   747: invokestatic 233	java/util/Arrays:copyOfRange	([BII)[B
    //   750: astore 18
    //   752: aload_0
    //   753: getfield 235	com/tencent/mm/f/c/c:bEy	Ljava/io/OutputStream;
    //   756: aload 18
    //   758: iconst_0
    //   759: aload 17
    //   761: iconst_0
    //   762: saload
    //   763: iconst_1
    //   764: isub
    //   765: invokevirtual 241	java/io/OutputStream:write	([BII)V
    //   768: iload 5
    //   770: aload 17
    //   772: iconst_0
    //   773: saload
    //   774: iconst_1
    //   775: isub
    //   776: iadd
    //   777: istore 5
    //   779: goto -644 -> 135
    //   782: aload_0
    //   783: getfield 235	com/tencent/mm/f/c/c:bEy	Ljava/io/OutputStream;
    //   786: aload 16
    //   788: iconst_0
    //   789: aload 17
    //   791: iconst_0
    //   792: saload
    //   793: invokevirtual 241	java/io/OutputStream:write	([BII)V
    //   796: aload 17
    //   798: iconst_0
    //   799: saload
    //   800: istore 8
    //   802: iload 5
    //   804: iload 8
    //   806: iadd
    //   807: istore 9
    //   809: iload 9
    //   811: istore 5
    //   813: goto -678 -> 135
    //   816: astore_1
    //   817: ldc 127
    //   819: ldc 243
    //   821: iconst_1
    //   822: anewarray 4	java/lang/Object
    //   825: dup
    //   826: iconst_0
    //   827: aload_0
    //   828: getfield 77	com/tencent/mm/f/c/c:bEs	Ljava/lang/String;
    //   831: aastore
    //   832: invokestatic 181	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   835: iconst_m1
    //   836: ireturn
    //   837: aload_0
    //   838: getfield 235	com/tencent/mm/f/c/c:bEy	Ljava/io/OutputStream;
    //   841: invokevirtual 246	java/io/OutputStream:flush	()V
    //   844: aload_1
    //   845: getfield 150	com/tencent/mm/f/b/g$a:buf	[B
    //   848: iload 6
    //   850: aload_0
    //   851: getfield 58	com/tencent/mm/f/c/c:bEu	[B
    //   854: aload_0
    //   855: getfield 56	com/tencent/mm/f/c/c:bEt	I
    //   858: iload 7
    //   860: invokestatic 147	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   863: aload_0
    //   864: aload_0
    //   865: getfield 56	com/tencent/mm/f/c/c:bEt	I
    //   868: iload 7
    //   870: iadd
    //   871: putfield 56	com/tencent/mm/f/c/c:bEt	I
    //   874: aload 14
    //   876: invokevirtual 250	com/tencent/mm/compatible/util/g$a:zJ	()J
    //   879: lstore 12
    //   881: iload_2
    //   882: iconst_1
    //   883: if_icmpne +42 -> 925
    //   886: getstatic 42	com/tencent/mm/f/c/c:bEB	Lcom/tencent/mm/f/c/a$a;
    //   889: astore_1
    //   890: aload_1
    //   891: aload_1
    //   892: getfield 254	com/tencent/mm/f/c/a$a:bEn	J
    //   895: aload_1
    //   896: getfield 257	com/tencent/mm/f/c/a$a:count	I
    //   899: i2l
    //   900: lmul
    //   901: lload 12
    //   903: ladd
    //   904: aload_1
    //   905: getfield 257	com/tencent/mm/f/c/a$a:count	I
    //   908: iconst_1
    //   909: iadd
    //   910: i2l
    //   911: ldiv
    //   912: putfield 254	com/tencent/mm/f/c/a$a:bEn	J
    //   915: aload_1
    //   916: aload_1
    //   917: getfield 257	com/tencent/mm/f/c/a$a:count	I
    //   920: iconst_1
    //   921: iadd
    //   922: putfield 257	com/tencent/mm/f/c/a$a:count	I
    //   925: ldc 127
    //   927: new 259	java/lang/StringBuilder
    //   930: dup
    //   931: ldc_w 261
    //   934: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   937: lload 12
    //   939: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   942: ldc_w 270
    //   945: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: iload_2
    //   949: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   952: ldc_w 278
    //   955: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: getstatic 42	com/tencent/mm/f/c/c:bEB	Lcom/tencent/mm/f/c/a$a;
    //   961: getfield 254	com/tencent/mm/f/c/a$a:bEn	J
    //   964: invokevirtual 268	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   967: ldc_w 280
    //   970: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: getstatic 42	com/tencent/mm/f/c/c:bEB	Lcom/tencent/mm/f/c/a$a;
    //   976: getfield 257	com/tencent/mm/f/c/a$a:count	I
    //   979: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   982: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   985: invokestatic 285	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   988: iload 5
    //   990: ireturn
    //   991: astore_1
    //   992: ldc 127
    //   994: ldc_w 287
    //   997: iconst_1
    //   998: anewarray 4	java/lang/Object
    //   1001: dup
    //   1002: iconst_0
    //   1003: aload_0
    //   1004: getfield 77	com/tencent/mm/f/c/c:bEs	Ljava/lang/String;
    //   1007: aastore
    //   1008: invokestatic 181	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1011: iconst_m1
    //   1012: ireturn
    //   1013: astore_1
    //   1014: ldc 127
    //   1016: ldc_w 289
    //   1019: iconst_4
    //   1020: anewarray 4	java/lang/Object
    //   1023: dup
    //   1024: iconst_0
    //   1025: iload 6
    //   1027: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1030: aastore
    //   1031: dup
    //   1032: iconst_1
    //   1033: aload_0
    //   1034: getfield 56	com/tencent/mm/f/c/c:bEt	I
    //   1037: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1040: aastore
    //   1041: dup
    //   1042: iconst_2
    //   1043: iload 7
    //   1045: invokestatic 178	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1048: aastore
    //   1049: dup
    //   1050: iconst_3
    //   1051: aload_1
    //   1052: invokevirtual 213	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1055: aastore
    //   1056: invokestatic 181	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1059: iconst_m1
    //   1060: ireturn
    //   1061: iconst_1
    //   1062: istore 11
    //   1064: goto -958 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1067	0	this	c
    //   0	1067	1	parama	g.a
    //   0	1067	2	paramInt	int
    //   0	1067	3	paramBoolean	boolean
    //   23	649	4	i	int
    //   54	7	5	j	int
    //   133	856	5	k	int
    //   37	555	6	m	int
    //   592	434	6	n	int
    //   34	173	7	i1	int
    //   207	837	7	i2	int
    //   282	525	8	i3	int
    //   278	532	9	i4	int
    //   272	193	10	i5	int
    //   104	959	11	bool	boolean
    //   879	59	12	l	long
    //   7	868	14	locala	com.tencent.mm.compatible.util.g.a
    //   43	537	15	arrayOfByte1	byte[]
    //   63	724	16	arrayOfByte2	byte[]
    //   83	714	17	localObject1	Object
    // Exception table:
    //   from	to	target	type
    //   149	185	529	java/lang/Exception
    //   573	587	597	java/lang/Exception
    //   223	230	645	finally
    //   237	259	645	finally
    //   259	277	645	finally
    //   634	642	645	finally
    //   646	649	645	finally
    //   704	714	816	java/io/IOException
    //   734	768	816	java/io/IOException
    //   782	796	816	java/io/IOException
    //   837	844	991	java/io/IOException
    //   844	874	1013	java/lang/Exception
  }
  
  public final boolean cG(String paramString)
  {
    y.i("MicroMsg.SilkWriter", "initWriter path: " + paramString);
    if (paramString == null)
    {
      y.e("MicroMsg.SilkWriter", "path is null");
      return false;
    }
    Object localObject2 = null;
    try
    {
      localObject1 = e.I(paramString, false);
      if (localObject1 == null) {
        break label378;
      }
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject1;
        this.bEs = paramString;
        this.bEy = ((OutputStream)localObject1);
        this.pHT = false;
        i = m.yR();
        if ((i & 0x400) != 0) {}
        for (this.bEz = 4;; this.bEz = 2)
        {
          i = MediaRecorder.SilkEncInit(this.mSampleRate, this.bEv, this.bEz);
          if (i == 0) {
            break label256;
          }
          y.e("MicroMsg.SilkWriter", "initWriter SilkEncoderInit Error:%d", new Object[] { Integer.valueOf(i) });
          return false;
          localException = localException;
          y.printErrStackTrace("MicroMsg.SilkWriter", localException, "initWriter openWrite failed: %s", new Object[] { localException.getMessage() });
          h.nFQ.h(357L, 55L, 1L);
          localObject1 = localObject2;
          if (!com.tencent.mm.protocal.d.spd) {
            break;
          }
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("stack", localException.getMessage());
          h.nFQ.d("Record", "Write failed", (Map)localObject1);
          localObject1 = localObject2;
          break;
          if ((i & 0x200) == 0) {
            break label245;
          }
        }
        y.e("TAG", "initWriter cpuType error! silk don't support arm_v5!!!!");
      }
      catch (Exception paramString)
      {
        y.e("MicroMsg.SilkWriter", "initWriter FileOutputStream error:%s", new Object[] { paramString.getMessage() });
        return false;
      }
      label245:
      return false;
    }
    label256:
    this.bEu = new byte[this.mSampleRate * 20 * 2 / 1000];
    int i = -1;
    paramString = com.tencent.mm.model.c.c.IX().fJ("100279");
    if (paramString.isValid()) {
      i = bk.getInt((String)paramString.ctr().get("isVoiceMsgOptOpen"), 0);
    }
    if (1 == i) {
      this.bEA = true;
    }
    if (i == 0) {
      this.bEA = false;
    }
    if (this.bEA)
    {
      MediaRecorder.SetVoiceSilkControl(200, 1);
      y.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Open !");
    }
    else
    {
      MediaRecorder.SetVoiceSilkControl(200, 0);
      y.i("MicroMsg.SilkWriter", "Voice Message Compression Optimization is Close !");
      break label380;
      label378:
      return false;
    }
    label380:
    return true;
  }
  
  /* Error */
  public final void uE()
  {
    // Byte code:
    //   0: ldc 127
    //   2: ldc_w 383
    //   5: invokestatic 165	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: iconst_1
    //   12: putfield 54	com/tencent/mm/f/c/c:bEr	Z
    //   15: aload_0
    //   16: monitorexit
    //   17: aload_0
    //   18: getfield 66	com/tencent/mm/f/c/c:bEx	Lcom/tencent/mm/f/c/c$a;
    //   21: ifnull +10 -> 31
    //   24: aload_0
    //   25: getfield 66	com/tencent/mm/f/c/c:bEx	Lcom/tencent/mm/f/c/c$a;
    //   28: invokestatic 389	com/tencent/mm/sdk/f/e:aa	(Ljava/lang/Runnable;)V
    //   31: aload_0
    //   32: getfield 64	com/tencent/mm/f/c/c:bEw	Ljava/lang/Object;
    //   35: astore_1
    //   36: aload_1
    //   37: monitorenter
    //   38: invokestatic 392	com/tencent/mm/modelvoice/MediaRecorder:SilkEncUnInit	()I
    //   41: pop
    //   42: aload_1
    //   43: monitorexit
    //   44: ldc 127
    //   46: new 259	java/lang/StringBuilder
    //   49: dup
    //   50: ldc_w 394
    //   53: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: aload_0
    //   57: getfield 77	com/tencent/mm/f/c/c:bEs	Ljava/lang/String;
    //   60: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 165	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   69: aload_0
    //   70: getfield 235	com/tencent/mm/f/c/c:bEy	Ljava/io/OutputStream;
    //   73: ifnull +15 -> 88
    //   76: aload_0
    //   77: getfield 235	com/tencent/mm/f/c/c:bEy	Ljava/io/OutputStream;
    //   80: invokevirtual 397	java/io/OutputStream:close	()V
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield 235	com/tencent/mm/f/c/c:bEy	Ljava/io/OutputStream;
    //   88: return
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    //   94: astore_1
    //   95: ldc 127
    //   97: ldc_w 399
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: aload_1
    //   107: invokestatic 403	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   110: aastore
    //   111: invokestatic 181	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: goto -83 -> 31
    //   117: astore_2
    //   118: aload_1
    //   119: monitorexit
    //   120: aload_2
    //   121: athrow
    //   122: astore_1
    //   123: ldc 127
    //   125: new 259	java/lang/StringBuilder
    //   128: dup
    //   129: ldc_w 405
    //   132: invokespecial 264	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload_0
    //   136: getfield 77	com/tencent/mm/f/c/c:bEs	Ljava/lang/String;
    //   139: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 407
    //   145: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload_1
    //   149: invokevirtual 213	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   152: invokevirtual 273	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 296	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: goto -78 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	c
    //   89	4	1	localObject2	Object
    //   94	25	1	localInterruptedException	InterruptedException
    //   122	27	1	localException	Exception
    //   117	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   10	17	89	finally
    //   90	92	89	finally
    //   24	31	94	java/lang/InterruptedException
    //   38	44	117	finally
    //   118	120	117	finally
    //   76	83	122	java/lang/Exception
  }
  
  public final boolean uF()
  {
    y.i("MicroMsg.SilkWriter", "resetWriter");
    synchronized (this.bEw)
    {
      MediaRecorder.SilkEncUnInit();
      int i = MediaRecorder.SilkEncInit(this.mSampleRate, this.bEv, this.bEz);
      if (i != 0)
      {
        y.e("MicroMsg.SilkWriter", "resetWriter SilkEncoderInit Error:%d", new Object[] { Integer.valueOf(i) });
        return false;
      }
    }
    return true;
  }
  
  private final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      y.i("MicroMsg.SilkWriter", "Silk Thread start run");
      int i;
      for (;;)
      {
        boolean bool;
        synchronized (c.this)
        {
          bool = c.a(c.this);
          y.d("MicroMsg.SilkWriter", "ThreadSilk in :" + bool + " cnt :" + c.b(c.this).size());
          if (bool) {
            if (c.b(c.this).isEmpty()) {
              break label276;
            }
          }
        }
        continue;
        i = c.b(c.this).size();
        if ((i > 10) || (bool))
        {
          y.w("MicroMsg.SilkWriter", "speed up silkcodec queue:" + i + " stop:" + bool);
          i = 0;
        }
      }
      for (;;)
      {
        int j = i;
        if (c.uH().count >= 10)
        {
          j = i;
          if (c.uH().bEn > 240L) {
            j = 0;
          }
        }
        c.this.a(localInterruptedException, j, false);
        break;
        if (i < 9) {
          i = 1;
        } else {
          label276:
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.c.c
 * JD-Core Version:    0.7.0.1
 */