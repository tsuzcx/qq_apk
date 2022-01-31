package com.tencent.mm.plugin.backup.c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bq;
import com.tencent.mm.g.a.qy;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.a.2;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.l;
import com.tencent.mm.vfs.e;
import com.tencent.wcdb.DatabaseUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static int jAs = 0;
  private static int jAt = 1;
  private static int jAu = 2;
  private static boolean jAv = false;
  private boolean eUJ;
  public boolean jAk;
  private final HashMap<String, String> jAl;
  private HashSet<String> jAm;
  private final int jAn;
  private final long jAo;
  private long jAp;
  private b.d jAq;
  private int jAr;
  private HashMap<String, Pair<Long, Long>> jAw;
  private d.a jAx;
  private boolean jAy;
  private int jAz;
  private final int jyJ;
  private long jyX;
  private final com.tencent.mm.plugin.backup.b.d jzA;
  private Object lock;
  
  public d(com.tencent.mm.plugin.backup.b.d paramd, int paramInt1, b.d paramd1, int paramInt2, boolean paramBoolean, LinkedList<String> paramLinkedList, LinkedList<Long> paramLinkedList1)
  {
    AppMethodBeat.i(17203);
    this.jAk = false;
    this.jAm = new HashSet();
    this.lock = new Object();
    this.jyX = 0L;
    this.jAr = jAs;
    this.jAl = aw.aaz().Zf().dvR();
    this.jzA = paramd;
    this.jyJ = paramInt1;
    this.jAq = paramd1;
    this.jAn = paramInt2;
    jAv = paramBoolean;
    this.jAo = DatabaseUtils.longForQuery(aw.aaz().Zf().fnw.dzV(), "SELECT COUNT(*) FROM BackupRecoverMsgListDataId", null);
    this.jAw = c(paramLinkedList, paramLinkedList1);
    this.jAm.clear();
    this.jAp = 0L;
    ab.i("MicroMsg.BackupRecoverMerger", "BackupRecoverMerger, msgListDataIdHashMap size[%d], backupMode[%d], totalMsgList[%d], totalSession[%d], isQuickBackup[%b]", new Object[] { Integer.valueOf(this.jAl.size()), Integer.valueOf(paramInt1), Long.valueOf(this.jAo), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(17203);
  }
  
  /* Error */
  private int a(String arg1, HashMap<String, Integer> paramHashMap, HashMap<String, LinkedList<Long>> paramHashMap1)
  {
    // Byte code:
    //   0: sipush 17206
    //   3: invokestatic 60	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 182	com/tencent/mm/sdk/platformtools/bo:aoy	()J
    //   9: lstore 8
    //   11: aload_1
    //   12: iconst_0
    //   13: iconst_m1
    //   14: invokestatic 187	com/tencent/mm/vfs/e:i	(Ljava/lang/String;II)[B
    //   17: astore 10
    //   19: new 189	com/tencent/mm/protocal/protobuf/gy
    //   22: dup
    //   23: invokespecial 190	com/tencent/mm/protocal/protobuf/gy:<init>	()V
    //   26: aload 10
    //   28: invokevirtual 194	com/tencent/mm/protocal/protobuf/gy:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   31: checkcast 189	com/tencent/mm/protocal/protobuf/gy
    //   34: astore 12
    //   36: aload 12
    //   38: getfield 198	com/tencent/mm/protocal/protobuf/gy:jJv	Ljava/util/LinkedList;
    //   41: invokevirtual 204	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   44: astore 13
    //   46: aload 13
    //   48: invokeinterface 210 1 0
    //   53: ifeq +1096 -> 1149
    //   56: aload 13
    //   58: invokeinterface 214 1 0
    //   63: checkcast 216	com/tencent/mm/protocal/protobuf/gx
    //   66: astore 14
    //   68: aload_0
    //   69: getfield 69	com/tencent/mm/plugin/backup/c/d:lock	Ljava/lang/Object;
    //   72: astore_1
    //   73: aload_1
    //   74: monitorenter
    //   75: aload_0
    //   76: getfield 218	com/tencent/mm/plugin/backup/c/d:eUJ	Z
    //   79: ifeq +190 -> 269
    //   82: ldc 134
    //   84: ldc 220
    //   86: invokestatic 223	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_1
    //   90: monitorexit
    //   91: sipush 17206
    //   94: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   97: iconst_m1
    //   98: ireturn
    //   99: astore 11
    //   101: ldc 225
    //   103: astore_3
    //   104: aload_3
    //   105: astore_2
    //   106: new 227	com/tencent/mm/vfs/b
    //   109: dup
    //   110: aload_1
    //   111: invokespecial 230	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   114: astore 12
    //   116: aload_3
    //   117: astore_2
    //   118: new 232	java/lang/StringBuilder
    //   121: dup
    //   122: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   125: ldc 225
    //   127: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 12
    //   132: invokevirtual 240	com/tencent/mm/vfs/b:exists	()Z
    //   135: invokevirtual 243	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   138: ldc 245
    //   140: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: astore_3
    //   147: aload_3
    //   148: astore_2
    //   149: new 232	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   156: aload_3
    //   157: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 12
    //   162: invokevirtual 252	com/tencent/mm/vfs/b:canRead	()Z
    //   165: invokevirtual 243	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   168: ldc 245
    //   170: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: astore_3
    //   177: aload_3
    //   178: astore_2
    //   179: new 232	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 233	java/lang/StringBuilder:<init>	()V
    //   186: aload_3
    //   187: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: aload 12
    //   192: invokevirtual 255	com/tencent/mm/vfs/b:length	()J
    //   195: invokevirtual 258	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   198: ldc_w 260
    //   201: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: astore_3
    //   208: aload_3
    //   209: astore_2
    //   210: aload 10
    //   212: ifnonnull +49 -> 261
    //   215: iconst_m1
    //   216: istore 4
    //   218: ldc 134
    //   220: aload 11
    //   222: ldc_w 262
    //   225: iconst_4
    //   226: anewarray 4	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload_1
    //   232: aastore
    //   233: dup
    //   234: iconst_1
    //   235: aload_2
    //   236: aastore
    //   237: dup
    //   238: iconst_2
    //   239: iload 4
    //   241: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   244: aastore
    //   245: dup
    //   246: iconst_3
    //   247: aload 11
    //   249: aastore
    //   250: invokestatic 266	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: sipush 17206
    //   256: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: iconst_0
    //   260: ireturn
    //   261: aload 10
    //   263: arraylength
    //   264: istore 4
    //   266: goto -48 -> 218
    //   269: aload_1
    //   270: monitorexit
    //   271: getstatic 49	com/tencent/mm/plugin/backup/c/d:jAv	Z
    //   274: ifeq +12 -> 286
    //   277: aload 14
    //   279: getfield 269	com/tencent/mm/protocal/protobuf/gx:jKs	I
    //   282: iconst_1
    //   283: if_icmpne -237 -> 46
    //   286: aload_0
    //   287: getfield 127	com/tencent/mm/plugin/backup/c/d:jAw	Ljava/util/HashMap;
    //   290: astore 18
    //   292: invokestatic 275	com/tencent/mm/plugin/backup/h/d:aUK	()Lcom/tencent/mm/plugin/backup/h/d;
    //   295: invokevirtual 279	com/tencent/mm/plugin/backup/h/d:aUL	()Lcom/tencent/mm/plugin/backup/h/b;
    //   298: invokevirtual 285	com/tencent/mm/plugin/backup/h/b:Ru	()Lcom/tencent/mm/storage/z;
    //   301: iconst_2
    //   302: aconst_null
    //   303: invokevirtual 291	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   306: checkcast 293	java/lang/String
    //   309: astore 15
    //   311: invokestatic 275	com/tencent/mm/plugin/backup/h/d:aUK	()Lcom/tencent/mm/plugin/backup/h/d;
    //   314: invokevirtual 279	com/tencent/mm/plugin/backup/h/d:aUL	()Lcom/tencent/mm/plugin/backup/h/b;
    //   317: invokevirtual 297	com/tencent/mm/plugin/backup/h/b:YC	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/h;
    //   320: astore 17
    //   322: aload 14
    //   324: getfield 301	com/tencent/mm/protocal/protobuf/gx:woP	Lcom/tencent/mm/protocal/protobuf/bwc;
    //   327: getfield 307	com/tencent/mm/protocal/protobuf/bwc:xJE	Ljava/lang/String;
    //   330: astore 10
    //   332: aload 14
    //   334: getfield 310	com/tencent/mm/protocal/protobuf/gx:woQ	Lcom/tencent/mm/protocal/protobuf/bwc;
    //   337: getfield 307	com/tencent/mm/protocal/protobuf/bwc:xJE	Ljava/lang/String;
    //   340: astore_1
    //   341: aload 10
    //   343: invokestatic 314	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   346: ifne +10 -> 356
    //   349: aload_1
    //   350: invokestatic 314	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   353: ifeq +72 -> 425
    //   356: aload 10
    //   358: astore 11
    //   360: aload 10
    //   362: ifnonnull +836 -> 1198
    //   365: ldc_w 316
    //   368: astore 11
    //   370: goto +828 -> 1198
    //   373: ldc_w 318
    //   376: ldc_w 320
    //   379: iconst_2
    //   380: anewarray 4	java/lang/Object
    //   383: dup
    //   384: iconst_0
    //   385: aload 11
    //   387: aastore
    //   388: dup
    //   389: iconst_1
    //   390: aload 10
    //   392: aastore
    //   393: invokestatic 323	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   396: aload 14
    //   398: getfield 269	com/tencent/mm/protocal/protobuf/gx:jKs	I
    //   401: invokestatic 328	com/tencent/mm/plugin/backup/c/e:ri	(I)V
    //   404: aload_0
    //   405: invokespecial 332	com/tencent/mm/plugin/backup/c/d:aTc	()Lcom/tencent/mm/plugin/backup/c/d$a;
    //   408: invokevirtual 335	com/tencent/mm/plugin/backup/c/d$a:aTj	()V
    //   411: goto -365 -> 46
    //   414: astore_2
    //   415: aload_1
    //   416: monitorexit
    //   417: sipush 17206
    //   420: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: aload_2
    //   424: athrow
    //   425: ldc_w 318
    //   428: ldc_w 337
    //   431: iconst_3
    //   432: anewarray 4	java/lang/Object
    //   435: dup
    //   436: iconst_0
    //   437: aload 14
    //   439: getfield 269	com/tencent/mm/protocal/protobuf/gx:jKs	I
    //   442: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   445: aastore
    //   446: dup
    //   447: iconst_1
    //   448: aload 10
    //   450: aastore
    //   451: dup
    //   452: iconst_2
    //   453: aload_1
    //   454: aastore
    //   455: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   458: invokestatic 275	com/tencent/mm/plugin/backup/h/d:aUK	()Lcom/tencent/mm/plugin/backup/h/d;
    //   461: invokevirtual 279	com/tencent/mm/plugin/backup/h/d:aUL	()Lcom/tencent/mm/plugin/backup/h/b;
    //   464: astore 11
    //   466: aload 11
    //   468: getfield 340	com/tencent/mm/plugin/backup/h/b:uin	I
    //   471: ifne +36 -> 507
    //   474: new 342	com/tencent/mm/model/b
    //   477: dup
    //   478: invokespecial 343	com/tencent/mm/model/b:<init>	()V
    //   481: astore_1
    //   482: sipush 17206
    //   485: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   488: aload_1
    //   489: athrow
    //   490: astore_1
    //   491: ldc 134
    //   493: aload_1
    //   494: ldc_w 345
    //   497: iconst_0
    //   498: anewarray 4	java/lang/Object
    //   501: invokestatic 266	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   504: goto -108 -> 396
    //   507: aload 11
    //   509: getfield 349	com/tencent/mm/plugin/backup/h/b:jGs	Lcom/tencent/mm/plugin/messenger/foundation/a/a/k;
    //   512: astore 11
    //   514: invokestatic 275	com/tencent/mm/plugin/backup/h/d:aUK	()Lcom/tencent/mm/plugin/backup/h/d;
    //   517: invokevirtual 279	com/tencent/mm/plugin/backup/h/d:aUL	()Lcom/tencent/mm/plugin/backup/h/b;
    //   520: invokevirtual 353	com/tencent/mm/plugin/backup/h/b:YA	()Lcom/tencent/mm/storage/bd;
    //   523: astore 16
    //   525: aload 11
    //   527: aload 10
    //   529: invokeinterface 358 2 0
    //   534: ifne +679 -> 1213
    //   537: aload 15
    //   539: aload 10
    //   541: invokevirtual 362	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   544: ifeq +683 -> 1227
    //   547: goto +666 -> 1213
    //   550: aload 14
    //   552: getfield 365	com/tencent/mm/protocal/protobuf/gx:wtu	J
    //   555: lconst_0
    //   556: lcmp
    //   557: ifeq +131 -> 688
    //   560: aload 14
    //   562: getfield 365	com/tencent/mm/protocal/protobuf/gx:wtu	J
    //   565: lstore 6
    //   567: aload 18
    //   569: ifnull +54 -> 623
    //   572: aload 18
    //   574: aload 11
    //   576: invokevirtual 368	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   579: checkcast 370	android/util/Pair
    //   582: astore 18
    //   584: aload 18
    //   586: ifnull +37 -> 623
    //   589: lload 6
    //   591: aload 18
    //   593: getfield 373	android/util/Pair:first	Ljava/lang/Object;
    //   596: checkcast 150	java/lang/Long
    //   599: invokevirtual 376	java/lang/Long:longValue	()J
    //   602: lcmp
    //   603: iflt -207 -> 396
    //   606: lload 6
    //   608: aload 18
    //   610: getfield 379	android/util/Pair:second	Ljava/lang/Object;
    //   613: checkcast 150	java/lang/Long
    //   616: invokevirtual 376	java/lang/Long:longValue	()J
    //   619: lcmp
    //   620: ifgt -224 -> 396
    //   623: invokestatic 385	com/tencent/mm/plugin/backup/b/g:aSY	()Ljava/util/List;
    //   626: astore 18
    //   628: aload 18
    //   630: aload 10
    //   632: invokeinterface 390 2 0
    //   637: ifne +14 -> 651
    //   640: aload 18
    //   642: aload_1
    //   643: invokeinterface 390 2 0
    //   648: ifeq +55 -> 703
    //   651: ldc_w 318
    //   654: new 232	java/lang/StringBuilder
    //   657: dup
    //   658: ldc_w 392
    //   661: invokespecial 393	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   664: aload 10
    //   666: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   669: ldc_w 395
    //   672: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: aload_1
    //   676: invokevirtual 237	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: invokevirtual 249	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   682: invokestatic 397	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   685: goto -289 -> 396
    //   688: aload 14
    //   690: getfield 400	com/tencent/mm/protocal/protobuf/gx:wtm	I
    //   693: i2l
    //   694: ldc2_w 401
    //   697: lmul
    //   698: lstore 6
    //   700: goto -133 -> 567
    //   703: aload 14
    //   705: getfield 405	com/tencent/mm/protocal/protobuf/gx:pIG	J
    //   708: lconst_0
    //   709: lcmp
    //   710: ifne +22 -> 732
    //   713: aload 14
    //   715: getfield 408	com/tencent/mm/protocal/protobuf/gx:pIE	I
    //   718: ifeq +14 -> 732
    //   721: aload 14
    //   723: aload 14
    //   725: getfield 408	com/tencent/mm/protocal/protobuf/gx:pIE	I
    //   728: i2l
    //   729: putfield 405	com/tencent/mm/protocal/protobuf/gx:pIG	J
    //   732: aload 14
    //   734: getfield 405	com/tencent/mm/protocal/protobuf/gx:pIG	J
    //   737: lconst_0
    //   738: lcmp
    //   739: ifeq +48 -> 787
    //   742: aload 15
    //   744: aload 10
    //   746: invokevirtual 362	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   749: ifeq +491 -> 1240
    //   752: aload 17
    //   754: aload_1
    //   755: aload 14
    //   757: getfield 405	com/tencent/mm/protocal/protobuf/gx:pIG	J
    //   760: invokeinterface 414 4 0
    //   765: astore_1
    //   766: aload_1
    //   767: getfield 419	com/tencent/mm/g/c/dd:field_msgId	J
    //   770: lconst_0
    //   771: lcmp
    //   772: ifeq +27 -> 799
    //   775: ldc_w 318
    //   778: ldc_w 421
    //   781: invokestatic 223	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   784: goto -388 -> 396
    //   787: ldc_w 318
    //   790: ldc_w 423
    //   793: invokestatic 397	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   796: goto -400 -> 396
    //   799: aload 14
    //   801: getfield 405	com/tencent/mm/protocal/protobuf/gx:pIG	J
    //   804: lconst_0
    //   805: lcmp
    //   806: ifeq +12 -> 818
    //   809: aload_1
    //   810: aload 14
    //   812: getfield 405	com/tencent/mm/protocal/protobuf/gx:pIG	J
    //   815: invokevirtual 429	com/tencent/mm/storage/bi:fP	(J)V
    //   818: aload_1
    //   819: aload 14
    //   821: getfield 432	com/tencent/mm/protocal/protobuf/gx:wtt	I
    //   824: i2l
    //   825: invokevirtual 435	com/tencent/mm/storage/bi:fS	(J)V
    //   828: aload_3
    //   829: aload 11
    //   831: invokevirtual 368	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   834: checkcast 200	java/util/LinkedList
    //   837: astore 10
    //   839: aload 10
    //   841: ifnull +141 -> 982
    //   844: aload 10
    //   846: invokevirtual 436	java/util/LinkedList:size	()I
    //   849: ifle +133 -> 982
    //   852: lload 6
    //   854: aload 10
    //   856: invokevirtual 439	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   859: checkcast 150	java/lang/Long
    //   862: invokevirtual 376	java/lang/Long:longValue	()J
    //   865: lcmp
    //   866: ifeq +98 -> 964
    //   869: aload 10
    //   871: invokevirtual 440	java/util/LinkedList:clear	()V
    //   874: aload 10
    //   876: lload 6
    //   878: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   881: invokevirtual 443	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   884: pop
    //   885: aload_1
    //   886: lload 6
    //   888: invokevirtual 446	com/tencent/mm/storage/bi:fQ	(J)V
    //   891: aload_1
    //   892: aload 14
    //   894: getfield 449	com/tencent/mm/protocal/protobuf/gx:wtv	I
    //   897: invokevirtual 452	com/tencent/mm/storage/bi:hV	(I)V
    //   900: aload_1
    //   901: aload 14
    //   903: getfield 269	com/tencent/mm/protocal/protobuf/gx:jKs	I
    //   906: invokevirtual 455	com/tencent/mm/storage/bi:setType	(I)V
    //   909: aload 16
    //   911: aload 11
    //   913: invokeinterface 461 2 0
    //   918: astore 10
    //   920: aload 10
    //   922: ifnull +324 -> 1246
    //   925: aload 10
    //   927: getfield 466	com/tencent/mm/g/c/aq:field_username	Ljava/lang/String;
    //   930: invokestatic 314	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   933: ifne +313 -> 1246
    //   936: aload 10
    //   938: invokevirtual 471	com/tencent/mm/storage/ad:dwz	()Z
    //   941: ifeq +305 -> 1246
    //   944: ldc_w 318
    //   947: ldc_w 392
    //   950: aload 11
    //   952: invokestatic 474	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   955: invokevirtual 478	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   958: invokestatic 397	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   961: goto -565 -> 396
    //   964: aload 10
    //   966: invokevirtual 481	java/util/LinkedList:getLast	()Ljava/lang/Object;
    //   969: checkcast 150	java/lang/Long
    //   972: invokevirtual 376	java/lang/Long:longValue	()J
    //   975: lconst_1
    //   976: ladd
    //   977: lstore 6
    //   979: goto -105 -> 874
    //   982: new 200	java/util/LinkedList
    //   985: dup
    //   986: invokespecial 482	java/util/LinkedList:<init>	()V
    //   989: astore 10
    //   991: aload 10
    //   993: lload 6
    //   995: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   998: invokevirtual 443	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   1001: pop
    //   1002: aload_3
    //   1003: aload 11
    //   1005: aload 10
    //   1007: invokevirtual 486	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1010: pop
    //   1011: goto -126 -> 885
    //   1014: aload_1
    //   1015: iload 5
    //   1017: invokevirtual 489	com/tencent/mm/storage/bi:hL	(I)V
    //   1020: aload_1
    //   1021: aload 11
    //   1023: invokevirtual 492	com/tencent/mm/storage/bi:kj	(Ljava/lang/String;)V
    //   1026: iload 4
    //   1028: ifeq +235 -> 1263
    //   1031: aload 14
    //   1033: getfield 495	com/tencent/mm/protocal/protobuf/gx:wtl	I
    //   1036: istore 5
    //   1038: aload_1
    //   1039: iload 5
    //   1041: invokevirtual 498	com/tencent/mm/storage/bi:setStatus	(I)V
    //   1044: aload_2
    //   1045: aload 11
    //   1047: invokevirtual 368	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1050: ifnonnull +14 -> 1064
    //   1053: aload_2
    //   1054: aload 11
    //   1056: iconst_0
    //   1057: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1060: invokevirtual 486	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1063: pop
    //   1064: iload 4
    //   1066: ifne +37 -> 1103
    //   1069: aload 14
    //   1071: getfield 495	com/tencent/mm/protocal/protobuf/gx:wtl	I
    //   1074: iconst_3
    //   1075: if_icmpne +28 -> 1103
    //   1078: aload_2
    //   1079: aload 11
    //   1081: aload_2
    //   1082: aload 11
    //   1084: invokevirtual 368	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1087: checkcast 144	java/lang/Integer
    //   1090: iconst_0
    //   1091: invokestatic 501	com/tencent/mm/sdk/platformtools/bo:a	(Ljava/lang/Integer;I)I
    //   1094: iconst_1
    //   1095: iadd
    //   1096: invokestatic 148	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1099: invokevirtual 486	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1102: pop
    //   1103: invokestatic 507	com/tencent/mm/plugin/backup/f/c:aTT	()Lcom/tencent/mm/plugin/backup/f/c;
    //   1106: aload 14
    //   1108: getfield 269	com/tencent/mm/protocal/protobuf/gx:jKs	I
    //   1111: invokevirtual 511	com/tencent/mm/plugin/backup/f/c:ro	(I)Lcom/tencent/mm/plugin/backup/f/l;
    //   1114: astore 10
    //   1116: aload 10
    //   1118: ifnonnull +15 -> 1133
    //   1121: ldc_w 318
    //   1124: ldc_w 513
    //   1127: invokestatic 223	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1130: goto -734 -> 396
    //   1133: aload 10
    //   1135: aload 15
    //   1137: aload 14
    //   1139: aload_1
    //   1140: invokeinterface 518 4 0
    //   1145: pop
    //   1146: goto -750 -> 396
    //   1149: invokestatic 521	com/tencent/mm/plugin/backup/c/e:aTk	()V
    //   1152: ldc 134
    //   1154: ldc_w 523
    //   1157: iconst_1
    //   1158: anewarray 4	java/lang/Object
    //   1161: dup
    //   1162: iconst_0
    //   1163: lload 8
    //   1165: invokestatic 527	com/tencent/mm/sdk/platformtools/bo:hl	(J)J
    //   1168: invokestatic 153	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1171: aastore
    //   1172: invokestatic 163	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1175: aload 12
    //   1177: getfield 198	com/tencent/mm/protocal/protobuf/gy:jJv	Ljava/util/LinkedList;
    //   1180: invokevirtual 436	java/util/LinkedList:size	()I
    //   1183: istore 4
    //   1185: sipush 17206
    //   1188: invokestatic 166	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1191: iload 4
    //   1193: ireturn
    //   1194: astore_3
    //   1195: goto -985 -> 210
    //   1198: aload_1
    //   1199: astore 10
    //   1201: aload_1
    //   1202: ifnonnull -829 -> 373
    //   1205: ldc_w 316
    //   1208: astore 10
    //   1210: goto -837 -> 373
    //   1213: iconst_1
    //   1214: istore 4
    //   1216: iload 4
    //   1218: ifeq +15 -> 1233
    //   1221: aload_1
    //   1222: astore 11
    //   1224: goto -674 -> 550
    //   1227: iconst_0
    //   1228: istore 4
    //   1230: goto -14 -> 1216
    //   1233: aload 10
    //   1235: astore 11
    //   1237: goto -687 -> 550
    //   1240: aload 10
    //   1242: astore_1
    //   1243: goto -491 -> 752
    //   1246: iload 4
    //   1248: ifeq +9 -> 1257
    //   1251: iconst_1
    //   1252: istore 5
    //   1254: goto -240 -> 1014
    //   1257: iconst_0
    //   1258: istore 5
    //   1260: goto -246 -> 1014
    //   1263: iconst_4
    //   1264: istore 5
    //   1266: goto -228 -> 1038
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1269	0	this	d
    //   0	1269	2	paramHashMap	HashMap<String, Integer>
    //   0	1269	3	paramHashMap1	HashMap<String, LinkedList<Long>>
    //   216	1031	4	i	int
    //   1015	250	5	j	int
    //   565	429	6	l1	long
    //   9	1155	8	l2	long
    //   17	1224	10	localObject1	Object
    //   99	149	11	localException	java.lang.Exception
    //   358	878	11	localObject2	Object
    //   34	1142	12	localObject3	Object
    //   44	13	13	localIterator	Iterator
    //   66	1072	14	localgx	com.tencent.mm.protocal.protobuf.gx
    //   309	827	15	str	String
    //   523	387	16	localbd	com.tencent.mm.storage.bd
    //   320	433	17	localh	com.tencent.mm.plugin.messenger.foundation.a.a.h
    //   290	351	18	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   19	36	99	java/lang/Exception
    //   75	91	414	finally
    //   269	271	414	finally
    //   415	417	414	finally
    //   286	356	490	java/lang/Exception
    //   373	396	490	java/lang/Exception
    //   425	490	490	java/lang/Exception
    //   507	547	490	java/lang/Exception
    //   550	567	490	java/lang/Exception
    //   572	584	490	java/lang/Exception
    //   589	623	490	java/lang/Exception
    //   623	651	490	java/lang/Exception
    //   651	685	490	java/lang/Exception
    //   688	700	490	java/lang/Exception
    //   703	732	490	java/lang/Exception
    //   732	752	490	java/lang/Exception
    //   752	784	490	java/lang/Exception
    //   787	796	490	java/lang/Exception
    //   799	818	490	java/lang/Exception
    //   818	839	490	java/lang/Exception
    //   844	874	490	java/lang/Exception
    //   874	885	490	java/lang/Exception
    //   885	920	490	java/lang/Exception
    //   925	961	490	java/lang/Exception
    //   964	979	490	java/lang/Exception
    //   982	1011	490	java/lang/Exception
    //   1014	1026	490	java/lang/Exception
    //   1031	1038	490	java/lang/Exception
    //   1038	1064	490	java/lang/Exception
    //   1069	1103	490	java/lang/Exception
    //   1103	1116	490	java/lang/Exception
    //   1121	1130	490	java/lang/Exception
    //   1133	1146	490	java/lang/Exception
    //   106	116	1194	java/lang/Exception
    //   118	147	1194	java/lang/Exception
    //   149	177	1194	java/lang/Exception
    //   179	208	1194	java/lang/Exception
  }
  
  private d.a aTc()
  {
    AppMethodBeat.i(17202);
    if (this.jAx == null) {
      this.jAx = new d.a(this, (byte)0);
    }
    d.a locala = this.jAx;
    AppMethodBeat.o(17202);
    return locala;
  }
  
  private void aTe()
  {
    AppMethodBeat.i(17208);
    this.jAk = false;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      AppMethodBeat.o(17208);
      return;
    }
  }
  
  public static void aTf()
  {
    AppMethodBeat.i(17210);
    ab.i("MicroMsg.BackupRecoverMerger", "backupFinishMerge");
    com.tencent.mm.sdk.b.a.ymk.l(new bq());
    com.tencent.mm.sdk.b.a.ymk.l(new com.tencent.mm.g.a.z());
    e.O(g.aSW(), true);
    com.tencent.mm.plugin.backup.h.a locala = com.tencent.mm.plugin.backup.h.d.aUK().aUM();
    locala.handler.post(new a.2(locala));
    aw.aaz();
    c.YC().bPZ();
    com.tencent.mm.sdk.b.a.ymk.l(new qy());
    com.tencent.mm.sdk.a.b.pG(false);
    AppMethodBeat.o(17210);
  }
  
  public static void aTg()
  {
    AppMethodBeat.i(17211);
    com.tencent.mm.plugin.backup.h.d.aUK().aUL().YC().Th("BACKUP_MERGE_LOCK");
    AppMethodBeat.o(17211);
  }
  
  public static void aTh()
  {
    AppMethodBeat.i(17212);
    com.tencent.mm.plugin.backup.h.d.aUK().aUL().YC().Ti("BACKUP_MERGE_LOCK");
    AppMethodBeat.o(17212);
  }
  
  private static HashMap<String, Pair<Long, Long>> c(LinkedList<String> paramLinkedList, LinkedList<Long> paramLinkedList1)
  {
    AppMethodBeat.i(17204);
    HashMap localHashMap = new HashMap();
    paramLinkedList1 = paramLinkedList1.iterator();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      String str = (String)paramLinkedList.next();
      if (paramLinkedList1.hasNext())
      {
        long l2 = ((Long)paramLinkedList1.next()).longValue();
        long l1 = l2;
        if (l2 == 0L) {
          l1 = -9223372036854775808L;
        }
        if (!paramLinkedList1.hasNext()) {
          break;
        }
        long l3 = ((Long)paramLinkedList1.next()).longValue();
        l2 = l3;
        if (l3 == 0L) {
          l2 = 9223372036854775807L;
        }
        localHashMap.put(str, new Pair(Long.valueOf(l1), Long.valueOf(l2)));
      }
    }
    AppMethodBeat.o(17204);
    return localHashMap;
  }
  
  public final void aTd()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(17205);
        if (this.jAk)
        {
          ab.e("MicroMsg.BackupRecoverMerger", "hasStartMerge , return");
          AppMethodBeat.o(17205);
          return;
        }
        this.jAk = true;
        this.jyX = 0L;
        ab.i("MicroMsg.BackupRecoverMerger", "startMerge");
        this.jzA.aSM();
        com.tencent.mm.plugin.backup.h.d.aUK().aUN();
        ab.i("MicroMsg.BackupRecoverMerger", "backupStartMerge");
        com.tencent.mm.sdk.a.b.pG(true);
        aTg();
        this.jAr = jAt;
        if (this.jyJ == 1)
        {
          aw.aaz();
          c.Ru().set(ac.a.yEr, Boolean.TRUE);
          ab.i("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp start, mergeState[%d], totalMsgList size[%d], msgListDataIdHashMap size[%d]", new Object[] { Integer.valueOf(this.jAr), Long.valueOf(this.jAo), Integer.valueOf(this.jAl.size()) });
          com.tencent.mm.sdk.g.d.a(new d.1(this), "BackupRecoverMerger_recoverFromSdcard", 1).start();
          AppMethodBeat.o(17205);
          continue;
        }
        if (this.jyJ != 2) {
          continue;
        }
      }
      finally {}
      aw.aaz();
      c.Ru().set(ac.a.yEu, Boolean.TRUE);
    }
  }
  
  public final void n(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(17207);
    synchronized (this.lock)
    {
      ab.i("MicroMsg.BackupRecoverMerger", "cancel, needClearContinueRecoverData[%b], mergeState[%d], updateState[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.jAr), Integer.valueOf(paramInt) });
      this.eUJ = true;
      this.jAy = paramBoolean;
      this.jAz = paramInt;
      this.jzA.aSN();
      AppMethodBeat.o(17207);
      return;
    }
  }
  
  public final void rh(int paramInt)
  {
    AppMethodBeat.i(17209);
    if (this.jAq != null) {
      this.jAq.rf(paramInt);
    }
    AppMethodBeat.o(17209);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.d
 * JD-Core Version:    0.7.0.1
 */