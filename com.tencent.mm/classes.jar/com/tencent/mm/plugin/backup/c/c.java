package com.tencent.mm.plugin.backup.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.b.b;
import com.tencent.mm.plugin.backup.b.e;
import com.tencent.mm.plugin.backup.b.f.a;
import com.tencent.mm.plugin.backup.g.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.LinkedList;
import java.util.Vector;
import junit.framework.Assert;

public final class c
{
  private int jyJ;
  com.tencent.mm.plugin.backup.b.d jzA;
  long jzB = 0L;
  public long jzC = 0L;
  boolean jzy = false;
  b.b jzz;
  
  public c(com.tencent.mm.plugin.backup.b.d paramd, int paramInt, b.b paramb)
  {
    this.jzA = paramd;
    this.jyJ = paramInt;
    this.jzz = paramb;
    this.jzy = false;
  }
  
  public final void a(LinkedList<f.a> paramLinkedList, long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(17196);
    if (paramLinkedList == null) {}
    for (int i = -1;; i = paramLinkedList.size())
    {
      ab.i("MicroMsg.BackupPackAndSend", "startBackup, backupSessionList size[%d], bigFileSize[%d], isOnlyText[%b]", new Object[] { Integer.valueOf(i), Long.valueOf(paramLong), Boolean.valueOf(paramBoolean) });
      com.tencent.mm.sdk.g.d.a(new c.1(this, paramLinkedList, paramLong, paramBoolean), "backupPackThread", 10).start();
      AppMethodBeat.o(17196);
      return;
    }
  }
  
  /* Error */
  final boolean a(f.a parama, c.c paramc, String paramString, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 17197
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 111	com/tencent/mm/plugin/backup/h/d:aUK	()Lcom/tencent/mm/plugin/backup/h/d;
    //   9: invokevirtual 115	com/tencent/mm/plugin/backup/h/d:aUL	()Lcom/tencent/mm/plugin/backup/h/b;
    //   12: invokevirtual 121	com/tencent/mm/plugin/backup/h/b:YF	()Lcom/tencent/mm/storage/be;
    //   15: aload_1
    //   16: getfield 127	com/tencent/mm/plugin/backup/b/f$a:jyY	Ljava/lang/String;
    //   19: invokeinterface 133 2 0
    //   24: astore 26
    //   26: aload 26
    //   28: ifnull +180 -> 208
    //   31: aload 26
    //   33: getfield 138	com/tencent/mm/g/c/au:field_unReadCount	I
    //   36: istore 7
    //   38: ldc 51
    //   40: ldc 140
    //   42: iconst_5
    //   43: anewarray 4	java/lang/Object
    //   46: dup
    //   47: iconst_0
    //   48: aload_1
    //   49: getfield 143	com/tencent/mm/plugin/backup/b/f$a:jyZ	I
    //   52: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: aload_1
    //   59: getfield 127	com/tencent/mm/plugin/backup/b/f$a:jyY	Ljava/lang/String;
    //   62: aastore
    //   63: dup
    //   64: iconst_2
    //   65: aload_1
    //   66: getfield 146	com/tencent/mm/plugin/backup/b/f$a:startTime	J
    //   69: invokestatic 64	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   72: aastore
    //   73: dup
    //   74: iconst_3
    //   75: aload_1
    //   76: getfield 149	com/tencent/mm/plugin/backup/b/f$a:endTime	J
    //   79: invokestatic 64	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   82: aastore
    //   83: dup
    //   84: iconst_4
    //   85: iload 7
    //   87: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   90: aastore
    //   91: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   94: invokestatic 155	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   97: lstore 19
    //   99: iconst_0
    //   100: istore 9
    //   102: lconst_0
    //   103: lstore 11
    //   105: lconst_0
    //   106: lstore 13
    //   108: lconst_0
    //   109: lstore 15
    //   111: iload 7
    //   113: istore 8
    //   115: iload 9
    //   117: istore 7
    //   119: new 96	java/util/LinkedList
    //   122: dup
    //   123: invokespecial 156	java/util/LinkedList:<init>	()V
    //   126: astore 28
    //   128: invokestatic 155	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   131: lstore 17
    //   133: invokestatic 111	com/tencent/mm/plugin/backup/h/d:aUK	()Lcom/tencent/mm/plugin/backup/h/d;
    //   136: invokevirtual 115	com/tencent/mm/plugin/backup/h/d:aUL	()Lcom/tencent/mm/plugin/backup/h/b;
    //   139: invokevirtual 160	com/tencent/mm/plugin/backup/h/b:YC	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/h;
    //   142: aload_1
    //   143: getfield 127	com/tencent/mm/plugin/backup/b/f$a:jyY	Ljava/lang/String;
    //   146: aload_1
    //   147: getfield 146	com/tencent/mm/plugin/backup/b/f$a:startTime	J
    //   150: aload_1
    //   151: getfield 149	com/tencent/mm/plugin/backup/b/f$a:endTime	J
    //   154: iload 7
    //   156: invokeinterface 166 7 0
    //   161: astore 26
    //   163: aload 26
    //   165: invokeinterface 172 1 0
    //   170: ifeq +93 -> 263
    //   173: iload 7
    //   175: iconst_1
    //   176: iadd
    //   177: istore 9
    //   179: aload_0
    //   180: getfield 30	com/tencent/mm/plugin/backup/c/c:jzy	Z
    //   183: ifeq +31 -> 214
    //   186: ldc 51
    //   188: ldc 174
    //   190: invokestatic 178	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload 26
    //   195: invokeinterface 181 1 0
    //   200: sipush 17197
    //   203: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: iconst_0
    //   207: ireturn
    //   208: iconst_0
    //   209: istore 7
    //   211: goto -173 -> 38
    //   214: new 183	com/tencent/mm/storage/bi
    //   217: dup
    //   218: invokespecial 184	com/tencent/mm/storage/bi:<init>	()V
    //   221: astore 27
    //   223: aload 27
    //   225: aload 26
    //   227: invokevirtual 188	com/tencent/mm/storage/bi:convertFrom	(Landroid/database/Cursor;)V
    //   230: iload 6
    //   232: ifeq +16 -> 248
    //   235: iload 9
    //   237: istore 7
    //   239: aload 27
    //   241: invokevirtual 191	com/tencent/mm/storage/bi:getType	()I
    //   244: iconst_1
    //   245: if_icmpne -82 -> 163
    //   248: aload 28
    //   250: aload 27
    //   252: invokevirtual 195	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   255: pop
    //   256: iload 9
    //   258: istore 7
    //   260: goto -97 -> 163
    //   263: aload 26
    //   265: invokeinterface 181 1 0
    //   270: lload 15
    //   272: lload 17
    //   274: lsub
    //   275: invokestatic 155	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   278: ladd
    //   279: lstore 17
    //   281: aload 28
    //   283: invokevirtual 100	java/util/LinkedList:size	()I
    //   286: ifeq +418 -> 704
    //   289: iconst_0
    //   290: istore 9
    //   292: iload 9
    //   294: aload 28
    //   296: invokevirtual 100	java/util/LinkedList:size	()I
    //   299: if_icmpge +398 -> 697
    //   302: aload_0
    //   303: getfield 30	com/tencent/mm/plugin/backup/c/c:jzy	Z
    //   306: ifeq +18 -> 324
    //   309: ldc 51
    //   311: ldc 197
    //   313: invokestatic 178	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: sipush 17197
    //   319: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: iconst_0
    //   323: ireturn
    //   324: aload 28
    //   326: iload 9
    //   328: invokevirtual 201	java/util/LinkedList:get	(I)Ljava/lang/Object;
    //   331: checkcast 183	com/tencent/mm/storage/bi
    //   334: astore 31
    //   336: new 203	com/tencent/mm/pointers/PLong
    //   339: dup
    //   340: invokespecial 204	com/tencent/mm/pointers/PLong:<init>	()V
    //   343: astore 32
    //   345: new 96	java/util/LinkedList
    //   348: dup
    //   349: invokespecial 156	java/util/LinkedList:<init>	()V
    //   352: astore 29
    //   354: new 206	java/util/HashMap
    //   357: dup
    //   358: invokespecial 207	java/util/HashMap:<init>	()V
    //   361: astore 30
    //   363: lload 13
    //   365: lstore 15
    //   367: lload 13
    //   369: invokestatic 155	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   372: lsub
    //   373: lstore 13
    //   375: iload 8
    //   377: ifle +282 -> 659
    //   380: iconst_1
    //   381: istore 25
    //   383: lload 13
    //   385: lstore 15
    //   387: aload 31
    //   389: iconst_0
    //   390: aload_3
    //   391: aload 32
    //   393: aload 29
    //   395: aload 30
    //   397: iload 25
    //   399: iconst_0
    //   400: lload 4
    //   402: invokestatic 212	com/tencent/mm/plugin/backup/f/h:a	(Lcom/tencent/mm/storage/bi;ZLjava/lang/String;Lcom/tencent/mm/pointers/PLong;Ljava/util/LinkedList;Ljava/util/HashMap;ZZJ)Lcom/tencent/mm/protocal/protobuf/gx;
    //   405: astore 26
    //   407: invokestatic 155	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   410: lstore 15
    //   412: lload 15
    //   414: lload 13
    //   416: ladd
    //   417: lstore 13
    //   419: aload 26
    //   421: ifnonnull +270 -> 691
    //   424: iconst_1
    //   425: istore 25
    //   427: ldc 51
    //   429: ldc 214
    //   431: bipush 8
    //   433: anewarray 4	java/lang/Object
    //   436: dup
    //   437: iconst_0
    //   438: iload 25
    //   440: invokestatic 69	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   443: aastore
    //   444: dup
    //   445: iconst_1
    //   446: aload 29
    //   448: invokevirtual 100	java/util/LinkedList:size	()I
    //   451: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: aastore
    //   455: dup
    //   456: iconst_2
    //   457: aload 32
    //   459: getfield 217	com/tencent/mm/pointers/PLong:value	J
    //   462: invokestatic 64	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   465: aastore
    //   466: dup
    //   467: iconst_3
    //   468: aload 30
    //   470: invokevirtual 218	java/util/HashMap:size	()I
    //   473: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   476: aastore
    //   477: dup
    //   478: iconst_4
    //   479: aload 31
    //   481: getfield 223	com/tencent/mm/g/c/dd:field_msgSvrId	J
    //   484: invokestatic 64	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   487: aastore
    //   488: dup
    //   489: iconst_5
    //   490: aload 31
    //   492: invokevirtual 191	com/tencent/mm/storage/bi:getType	()I
    //   495: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   498: aastore
    //   499: dup
    //   500: bipush 6
    //   502: aload 31
    //   504: getfield 226	com/tencent/mm/g/c/dd:field_createTime	J
    //   507: invokestatic 64	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   510: aastore
    //   511: dup
    //   512: bipush 7
    //   514: aload 31
    //   516: getfield 229	com/tencent/mm/g/c/dd:field_talker	Ljava/lang/String;
    //   519: aastore
    //   520: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   523: lload 11
    //   525: lstore 15
    //   527: iload 8
    //   529: istore 10
    //   531: aload 26
    //   533: ifnull +109 -> 642
    //   536: iload 8
    //   538: iconst_1
    //   539: isub
    //   540: istore 10
    //   542: invokestatic 155	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   545: lstore 15
    //   547: aload 32
    //   549: getfield 217	com/tencent/mm/pointers/PLong:value	J
    //   552: lstore 21
    //   554: aload 31
    //   556: getfield 226	com/tencent/mm/g/c/dd:field_createTime	J
    //   559: lstore 23
    //   561: aload_2
    //   562: getfield 233	com/tencent/mm/plugin/backup/c/c$c:jAh	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   565: ifnonnull +41 -> 606
    //   568: aload_2
    //   569: getfield 237	com/tencent/mm/plugin/backup/c/c$c:jAf	Ljava/util/concurrent/LinkedBlockingQueue;
    //   572: astore 27
    //   574: new 8	com/tencent/mm/plugin/backup/c/c$b
    //   577: dup
    //   578: aload_2
    //   579: getfield 241	com/tencent/mm/plugin/backup/c/c$c:jzG	Lcom/tencent/mm/plugin/backup/c/c;
    //   582: aload_2
    //   583: getfield 245	com/tencent/mm/plugin/backup/c/c$c:jzL	Lcom/tencent/mm/plugin/backup/c/c$a;
    //   586: aload_1
    //   587: invokespecial 248	com/tencent/mm/plugin/backup/c/c$b:<init>	(Lcom/tencent/mm/plugin/backup/c/c;Lcom/tencent/mm/plugin/backup/c/c$a;Lcom/tencent/mm/plugin/backup/b/f$a;)V
    //   590: astore 31
    //   592: aload_2
    //   593: aload 31
    //   595: putfield 233	com/tencent/mm/plugin/backup/c/c$c:jAh	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   598: aload 27
    //   600: aload 31
    //   602: invokevirtual 253	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
    //   605: pop
    //   606: aload_2
    //   607: getfield 233	com/tencent/mm/plugin/backup/c/c$c:jAh	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   610: aload 26
    //   612: lload 21
    //   614: lload 23
    //   616: aload 29
    //   618: aload 30
    //   620: invokevirtual 256	com/tencent/mm/plugin/backup/c/c$b:a	(Lcom/tencent/mm/protocal/protobuf/gx;JJLjava/util/LinkedList;Ljava/util/HashMap;)Z
    //   623: ifeq +8 -> 631
    //   626: aload_2
    //   627: aconst_null
    //   628: putfield 233	com/tencent/mm/plugin/backup/c/c$c:jAh	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   631: lload 11
    //   633: lload 15
    //   635: lsub
    //   636: invokestatic 155	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   639: ladd
    //   640: lstore 15
    //   642: iload 9
    //   644: iconst_1
    //   645: iadd
    //   646: istore 9
    //   648: lload 15
    //   650: lstore 11
    //   652: iload 10
    //   654: istore 8
    //   656: goto -364 -> 292
    //   659: iconst_0
    //   660: istore 25
    //   662: goto -279 -> 383
    //   665: astore 27
    //   667: aconst_null
    //   668: astore 26
    //   670: lload 15
    //   672: lstore 13
    //   674: ldc 51
    //   676: aload 27
    //   678: ldc_w 258
    //   681: iconst_0
    //   682: anewarray 4	java/lang/Object
    //   685: invokestatic 262	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   688: goto -269 -> 419
    //   691: iconst_0
    //   692: istore 25
    //   694: goto -267 -> 427
    //   697: lload 17
    //   699: lstore 15
    //   701: goto -582 -> 119
    //   704: invokestatic 155	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   707: lstore 4
    //   709: aload_2
    //   710: getfield 233	com/tencent/mm/plugin/backup/c/c$c:jAh	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   713: ifnonnull +39 -> 752
    //   716: aload_2
    //   717: getfield 237	com/tencent/mm/plugin/backup/c/c$c:jAf	Ljava/util/concurrent/LinkedBlockingQueue;
    //   720: astore_3
    //   721: new 8	com/tencent/mm/plugin/backup/c/c$b
    //   724: dup
    //   725: aload_2
    //   726: getfield 241	com/tencent/mm/plugin/backup/c/c$c:jzG	Lcom/tencent/mm/plugin/backup/c/c;
    //   729: aload_2
    //   730: getfield 245	com/tencent/mm/plugin/backup/c/c$c:jzL	Lcom/tencent/mm/plugin/backup/c/c$a;
    //   733: aload_1
    //   734: invokespecial 248	com/tencent/mm/plugin/backup/c/c$b:<init>	(Lcom/tencent/mm/plugin/backup/c/c;Lcom/tencent/mm/plugin/backup/c/c$a;Lcom/tencent/mm/plugin/backup/b/f$a;)V
    //   737: astore 26
    //   739: aload_2
    //   740: aload 26
    //   742: putfield 233	com/tencent/mm/plugin/backup/c/c$c:jAh	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   745: aload_3
    //   746: aload 26
    //   748: invokevirtual 253	java/util/concurrent/LinkedBlockingQueue:offer	(Ljava/lang/Object;)Z
    //   751: pop
    //   752: aload_2
    //   753: getfield 233	com/tencent/mm/plugin/backup/c/c$c:jAh	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   756: invokevirtual 265	com/tencent/mm/plugin/backup/c/c$b:aTb	()V
    //   759: aload_2
    //   760: aconst_null
    //   761: putfield 233	com/tencent/mm/plugin/backup/c/c$c:jAh	Lcom/tencent/mm/plugin/backup/c/c$b;
    //   764: invokestatic 155	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   767: lstore 15
    //   769: ldc 51
    //   771: ldc_w 267
    //   774: bipush 7
    //   776: anewarray 4	java/lang/Object
    //   779: dup
    //   780: iconst_0
    //   781: aload_1
    //   782: getfield 143	com/tencent/mm/plugin/backup/b/f$a:jyZ	I
    //   785: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   788: aastore
    //   789: dup
    //   790: iconst_1
    //   791: aload_1
    //   792: getfield 127	com/tencent/mm/plugin/backup/b/f$a:jyY	Ljava/lang/String;
    //   795: aastore
    //   796: dup
    //   797: iconst_2
    //   798: iload 7
    //   800: invokestatic 59	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   803: aastore
    //   804: dup
    //   805: iconst_3
    //   806: lload 19
    //   808: invokestatic 271	com/tencent/mm/sdk/platformtools/bo:hl	(J)J
    //   811: invokestatic 64	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   814: aastore
    //   815: dup
    //   816: iconst_4
    //   817: lload 17
    //   819: invokestatic 64	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   822: aastore
    //   823: dup
    //   824: iconst_5
    //   825: lload 13
    //   827: invokestatic 64	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   830: aastore
    //   831: dup
    //   832: bipush 6
    //   834: lload 11
    //   836: lload 4
    //   838: lsub
    //   839: lload 15
    //   841: ladd
    //   842: invokestatic 64	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   845: aastore
    //   846: invokestatic 74	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   849: sipush 17197
    //   852: invokestatic 94	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   855: iconst_1
    //   856: ireturn
    //   857: astore 27
    //   859: goto -185 -> 674
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	862	0	this	c
    //   0	862	1	parama	f.a
    //   0	862	2	paramc	c.c
    //   0	862	3	paramString	String
    //   0	862	4	paramLong	long
    //   0	862	6	paramBoolean	boolean
    //   36	763	7	i	int
    //   113	542	8	j	int
    //   100	547	9	k	int
    //   529	124	10	m	int
    //   103	732	11	l1	long
    //   106	720	13	l2	long
    //   109	731	15	l3	long
    //   131	687	17	l4	long
    //   97	710	19	l5	long
    //   552	61	21	l6	long
    //   559	56	23	l7	long
    //   381	312	25	bool	boolean
    //   24	723	26	localObject1	Object
    //   221	378	27	localObject2	Object
    //   665	12	27	localException1	Exception
    //   857	1	27	localException2	Exception
    //   126	199	28	localLinkedList1	LinkedList
    //   352	265	29	localLinkedList2	LinkedList
    //   361	258	30	localHashMap	java.util.HashMap
    //   334	267	31	localObject3	Object
    //   343	205	32	localPLong	com.tencent.mm.pointers.PLong
    // Exception table:
    //   from	to	target	type
    //   367	375	665	java/lang/Exception
    //   387	407	665	java/lang/Exception
    //   407	412	857	java/lang/Exception
  }
  
  public final long aSZ()
  {
    return this.jzB / 1024L;
  }
  
  public final void aTa()
  {
    AppMethodBeat.i(17195);
    ab.i("MicroMsg.BackupPackAndSend", "backupSendFinishRequest.");
    com.tencent.mm.plugin.backup.i.d locald = new com.tencent.mm.plugin.backup.i.d();
    locald.ID = this.jzA.jyF;
    try
    {
      b.J(locald.toByteArray(), 8);
      AppMethodBeat.o(17195);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.BackupPackAndSend", localException, "BackupFinishRequest to buf err.", new Object[0]);
      AppMethodBeat.o(17195);
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(17193);
    ab.e("MicroMsg.BackupPackAndSend", "cancel, caller:%s", new Object[] { an.dtg() });
    this.jzy = true;
    AppMethodBeat.o(17193);
  }
  
  public final void fx(boolean paramBoolean)
  {
    AppMethodBeat.i(17194);
    ab.i("MicroMsg.BackupPackAndSend", "clearContinueBackupData.");
    SharedPreferences.Editor localEditor;
    if (this.jyJ == 1)
    {
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yEp, Boolean.FALSE);
      localEditor = com.tencent.mm.plugin.backup.b.d.aSQ().edit();
      localEditor.putString("BACKUP_PC_CHOOSE_SESSION", null);
      if (paramBoolean)
      {
        if (this.jyJ != 1) {
          break label155;
        }
        localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_TIME_MODE", 0);
        localEditor.putInt("BACKUP_PC_CHOOSE_SELECT_CONTENT_TYPE", 0);
        localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_START_TIME", 0L);
        localEditor.putLong("BACKUP_PC_CHOOSE_SELECT_END_TIME", 0L);
      }
    }
    for (;;)
    {
      localEditor.commit();
      AppMethodBeat.o(17194);
      return;
      if (this.jyJ != 2) {
        break;
      }
      aw.aaz();
      com.tencent.mm.model.c.Ru().set(ac.a.yEs, Boolean.FALSE);
      break;
      label155:
      if (this.jyJ == 2)
      {
        localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_TIME_MODE", 0);
        localEditor.putInt("BACKUP_MOVE_CHOOSE_SELECT_CONTENT_TYPE", 0);
        localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_START_TIME", 0L);
        localEditor.putLong("BACKUP_MOVE_CHOOSE_SELECT_END_TIME", 0L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.c
 * JD-Core Version:    0.7.0.1
 */