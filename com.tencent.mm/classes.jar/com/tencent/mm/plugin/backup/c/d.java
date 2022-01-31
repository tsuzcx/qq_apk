package com.tencent.mm.plugin.backup.c;

import android.util.Pair;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.a.bo;
import com.tencent.mm.h.a.pr;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.h.a.2;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.l;
import com.tencent.wcdb.DatabaseUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class d
{
  private static int hGW = 0;
  private static int hGX = 1;
  private static int hGY = 2;
  private static boolean hGZ = false;
  private boolean edT;
  private final int hFq;
  public boolean hGO = false;
  private final HashMap<String, String> hGP = au.Hx().Ge().ctv();
  private HashSet<String> hGQ = new HashSet();
  private final int hGR;
  private final long hGS;
  private long hGT;
  private b.d hGU;
  private int hGV = hGW;
  private final com.tencent.mm.plugin.backup.b.d hGe;
  private HashMap<String, Pair<Long, Long>> hHa;
  private d.a hHb;
  private boolean hHc;
  private int hHd;
  private Object lock = new Object();
  
  public d(com.tencent.mm.plugin.backup.b.d paramd, int paramInt1, b.d paramd1, int paramInt2, boolean paramBoolean, LinkedList<String> paramLinkedList, LinkedList<Long> paramLinkedList1)
  {
    this.hGe = paramd;
    this.hFq = paramInt1;
    this.hGU = paramd1;
    this.hGR = paramInt2;
    hGZ = paramBoolean;
    this.hGS = DatabaseUtils.longForQuery(au.Hx().Ge().dXo.cxg(), "SELECT COUNT(*) FROM BackupRecoverMsgListDataId", null);
    this.hHa = b(paramLinkedList, paramLinkedList1);
    this.hGQ.clear();
    this.hGT = 0L;
    y.i("MicroMsg.BackupRecoverMerger", "BackupRecoverMerger, msgListDataIdHashMap size[%d], backupMode[%d], totalMsgList[%d], totalSession[%d], isQuickBackup[%b]", new Object[] { Integer.valueOf(this.hGP.size()), Integer.valueOf(paramInt1), Long.valueOf(this.hGS), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
  }
  
  /* Error */
  private int a(String arg1, HashMap<String, Integer> paramHashMap, HashMap<String, LinkedList<Long>> paramHashMap1)
  {
    // Byte code:
    //   0: invokestatic 171	com/tencent/mm/sdk/platformtools/bk:UY	()J
    //   3: lstore 8
    //   5: aload_1
    //   6: iconst_0
    //   7: iconst_m1
    //   8: invokestatic 177	com/tencent/mm/vfs/e:c	(Ljava/lang/String;II)[B
    //   11: astore 10
    //   13: new 179	com/tencent/mm/protocal/c/fp
    //   16: dup
    //   17: invokespecial 180	com/tencent/mm/protocal/c/fp:<init>	()V
    //   20: aload 10
    //   22: invokevirtual 184	com/tencent/mm/protocal/c/fp:aH	([B)Lcom/tencent/mm/bv/a;
    //   25: checkcast 179	com/tencent/mm/protocal/c/fp
    //   28: astore 12
    //   30: aload 12
    //   32: getfield 188	com/tencent/mm/protocal/c/fp:hPT	Ljava/util/LinkedList;
    //   35: invokevirtual 194	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   38: astore 13
    //   40: aload 13
    //   42: invokeinterface 200 1 0
    //   47: ifeq +1075 -> 1122
    //   50: aload 13
    //   52: invokeinterface 204 1 0
    //   57: checkcast 206	com/tencent/mm/protocal/c/fo
    //   60: astore 14
    //   62: aload_0
    //   63: getfield 62	com/tencent/mm/plugin/backup/c/d:lock	Ljava/lang/Object;
    //   66: astore_1
    //   67: aload_1
    //   68: monitorenter
    //   69: aload_0
    //   70: getfield 208	com/tencent/mm/plugin/backup/c/d:edT	Z
    //   73: ifeq +176 -> 249
    //   76: ldc 125
    //   78: ldc 210
    //   80: invokestatic 213	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: aload_1
    //   84: monitorexit
    //   85: iconst_m1
    //   86: ireturn
    //   87: astore 11
    //   89: ldc 215
    //   91: astore_3
    //   92: aload_3
    //   93: astore_2
    //   94: new 217	java/io/File
    //   97: dup
    //   98: aload_1
    //   99: invokespecial 220	java/io/File:<init>	(Ljava/lang/String;)V
    //   102: astore 12
    //   104: aload_3
    //   105: astore_2
    //   106: new 222	java/lang/StringBuilder
    //   109: dup
    //   110: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   113: ldc 215
    //   115: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 12
    //   120: invokevirtual 230	java/io/File:exists	()Z
    //   123: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   126: ldc 235
    //   128: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: astore_3
    //   135: aload_3
    //   136: astore_2
    //   137: new 222	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   144: aload_3
    //   145: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 12
    //   150: invokevirtual 242	java/io/File:canRead	()Z
    //   153: invokevirtual 233	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   156: ldc 235
    //   158: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: astore_3
    //   165: aload_3
    //   166: astore_2
    //   167: new 222	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 223	java/lang/StringBuilder:<init>	()V
    //   174: aload_3
    //   175: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 12
    //   180: invokevirtual 245	java/io/File:length	()J
    //   183: invokevirtual 248	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   186: ldc 250
    //   188: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: astore_3
    //   195: aload_3
    //   196: astore_2
    //   197: aload 10
    //   199: ifnonnull +42 -> 241
    //   202: iconst_m1
    //   203: istore 4
    //   205: ldc 125
    //   207: aload 11
    //   209: ldc 252
    //   211: iconst_4
    //   212: anewarray 4	java/lang/Object
    //   215: dup
    //   216: iconst_0
    //   217: aload_1
    //   218: aastore
    //   219: dup
    //   220: iconst_1
    //   221: aload_2
    //   222: aastore
    //   223: dup
    //   224: iconst_2
    //   225: iload 4
    //   227: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   230: aastore
    //   231: dup
    //   232: iconst_3
    //   233: aload 11
    //   235: aastore
    //   236: invokestatic 256	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: iconst_0
    //   240: ireturn
    //   241: aload 10
    //   243: arraylength
    //   244: istore 4
    //   246: goto -41 -> 205
    //   249: aload_1
    //   250: monitorexit
    //   251: getstatic 48	com/tencent/mm/plugin/backup/c/d:hGZ	Z
    //   254: ifeq +12 -> 266
    //   257: aload 14
    //   259: getfield 259	com/tencent/mm/protocal/c/fo:hQR	I
    //   262: iconst_1
    //   263: if_icmpne -223 -> 40
    //   266: aload_0
    //   267: getfield 118	com/tencent/mm/plugin/backup/c/d:hHa	Ljava/util/HashMap;
    //   270: astore 18
    //   272: invokestatic 265	com/tencent/mm/plugin/backup/h/d:avi	()Lcom/tencent/mm/plugin/backup/h/d;
    //   275: invokevirtual 269	com/tencent/mm/plugin/backup/h/d:avj	()Lcom/tencent/mm/plugin/backup/h/b;
    //   278: invokevirtual 275	com/tencent/mm/plugin/backup/h/b:Dz	()Lcom/tencent/mm/storage/z;
    //   281: iconst_2
    //   282: aconst_null
    //   283: invokevirtual 281	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
    //   286: checkcast 283	java/lang/String
    //   289: astore 15
    //   291: invokestatic 265	com/tencent/mm/plugin/backup/h/d:avi	()Lcom/tencent/mm/plugin/backup/h/d;
    //   294: invokevirtual 269	com/tencent/mm/plugin/backup/h/d:avj	()Lcom/tencent/mm/plugin/backup/h/b;
    //   297: invokevirtual 287	com/tencent/mm/plugin/backup/h/b:Fy	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/g;
    //   300: astore 17
    //   302: aload 14
    //   304: getfield 291	com/tencent/mm/protocal/c/fo:svF	Lcom/tencent/mm/protocal/c/bml;
    //   307: getfield 297	com/tencent/mm/protocal/c/bml:tFO	Ljava/lang/String;
    //   310: astore 10
    //   312: aload 14
    //   314: getfield 300	com/tencent/mm/protocal/c/fo:svG	Lcom/tencent/mm/protocal/c/bml;
    //   317: getfield 297	com/tencent/mm/protocal/c/bml:tFO	Ljava/lang/String;
    //   320: astore_1
    //   321: aload 10
    //   323: invokestatic 304	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   326: ifne +10 -> 336
    //   329: aload_1
    //   330: invokestatic 304	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   333: ifeq +66 -> 399
    //   336: aload 10
    //   338: astore 11
    //   340: aload 10
    //   342: ifnonnull +819 -> 1161
    //   345: ldc_w 306
    //   348: astore 11
    //   350: goto +811 -> 1161
    //   353: ldc_w 308
    //   356: ldc_w 310
    //   359: iconst_2
    //   360: anewarray 4	java/lang/Object
    //   363: dup
    //   364: iconst_0
    //   365: aload 11
    //   367: aastore
    //   368: dup
    //   369: iconst_1
    //   370: aload 10
    //   372: aastore
    //   373: invokestatic 313	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   376: aload 14
    //   378: getfield 259	com/tencent/mm/protocal/c/fo:hQR	I
    //   381: invokestatic 319	com/tencent/mm/plugin/backup/c/e:nw	(I)V
    //   384: aload_0
    //   385: invokespecial 323	com/tencent/mm/plugin/backup/c/d:atE	()Lcom/tencent/mm/plugin/backup/c/d$a;
    //   388: invokevirtual 326	com/tencent/mm/plugin/backup/c/d$a:atL	()V
    //   391: goto -351 -> 40
    //   394: astore_2
    //   395: aload_1
    //   396: monitorexit
    //   397: aload_2
    //   398: athrow
    //   399: ldc_w 308
    //   402: ldc_w 328
    //   405: iconst_3
    //   406: anewarray 4	java/lang/Object
    //   409: dup
    //   410: iconst_0
    //   411: aload 14
    //   413: getfield 259	com/tencent/mm/protocal/c/fo:hQR	I
    //   416: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   419: aastore
    //   420: dup
    //   421: iconst_1
    //   422: aload 10
    //   424: aastore
    //   425: dup
    //   426: iconst_2
    //   427: aload_1
    //   428: aastore
    //   429: invokestatic 155	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   432: invokestatic 265	com/tencent/mm/plugin/backup/h/d:avi	()Lcom/tencent/mm/plugin/backup/h/d;
    //   435: invokevirtual 269	com/tencent/mm/plugin/backup/h/d:avj	()Lcom/tencent/mm/plugin/backup/h/b;
    //   438: astore 11
    //   440: aload 11
    //   442: getfield 331	com/tencent/mm/plugin/backup/h/b:uin	I
    //   445: ifne +28 -> 473
    //   448: new 333	com/tencent/mm/model/b
    //   451: dup
    //   452: invokespecial 334	com/tencent/mm/model/b:<init>	()V
    //   455: athrow
    //   456: astore_1
    //   457: ldc 125
    //   459: aload_1
    //   460: ldc_w 336
    //   463: iconst_0
    //   464: anewarray 4	java/lang/Object
    //   467: invokestatic 256	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   470: goto -94 -> 376
    //   473: aload 11
    //   475: getfield 340	com/tencent/mm/plugin/backup/h/b:hMQ	Lcom/tencent/mm/plugin/messenger/foundation/a/a/j;
    //   478: astore 11
    //   480: invokestatic 265	com/tencent/mm/plugin/backup/h/d:avi	()Lcom/tencent/mm/plugin/backup/h/d;
    //   483: invokevirtual 269	com/tencent/mm/plugin/backup/h/d:avj	()Lcom/tencent/mm/plugin/backup/h/b;
    //   486: invokevirtual 344	com/tencent/mm/plugin/backup/h/b:Fw	()Lcom/tencent/mm/storage/bd;
    //   489: astore 16
    //   491: aload 11
    //   493: aload 10
    //   495: invokeinterface 349 2 0
    //   500: ifne +676 -> 1176
    //   503: aload 15
    //   505: aload 10
    //   507: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   510: ifeq +680 -> 1190
    //   513: goto +663 -> 1176
    //   516: aload 14
    //   518: getfield 356	com/tencent/mm/protocal/c/fo:szt	J
    //   521: lconst_0
    //   522: lcmp
    //   523: ifeq +131 -> 654
    //   526: aload 14
    //   528: getfield 356	com/tencent/mm/protocal/c/fo:szt	J
    //   531: lstore 6
    //   533: aload 18
    //   535: ifnull +54 -> 589
    //   538: aload 18
    //   540: aload 11
    //   542: invokevirtual 359	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   545: checkcast 361	android/util/Pair
    //   548: astore 18
    //   550: aload 18
    //   552: ifnull +37 -> 589
    //   555: lload 6
    //   557: aload 18
    //   559: getfield 364	android/util/Pair:first	Ljava/lang/Object;
    //   562: checkcast 141	java/lang/Long
    //   565: invokevirtual 367	java/lang/Long:longValue	()J
    //   568: lcmp
    //   569: iflt -193 -> 376
    //   572: lload 6
    //   574: aload 18
    //   576: getfield 370	android/util/Pair:second	Ljava/lang/Object;
    //   579: checkcast 141	java/lang/Long
    //   582: invokevirtual 367	java/lang/Long:longValue	()J
    //   585: lcmp
    //   586: ifgt -210 -> 376
    //   589: invokestatic 376	com/tencent/mm/plugin/backup/b/g:atA	()Ljava/util/List;
    //   592: astore 18
    //   594: aload 18
    //   596: aload 10
    //   598: invokeinterface 381 2 0
    //   603: ifne +14 -> 617
    //   606: aload 18
    //   608: aload_1
    //   609: invokeinterface 381 2 0
    //   614: ifeq +55 -> 669
    //   617: ldc_w 308
    //   620: new 222	java/lang/StringBuilder
    //   623: dup
    //   624: ldc_w 383
    //   627: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   630: aload 10
    //   632: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: ldc_w 386
    //   638: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload_1
    //   642: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 388	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   651: goto -275 -> 376
    //   654: aload 14
    //   656: getfield 391	com/tencent/mm/protocal/c/fo:szl	I
    //   659: i2l
    //   660: ldc2_w 392
    //   663: lmul
    //   664: lstore 6
    //   666: goto -133 -> 533
    //   669: aload 14
    //   671: getfield 396	com/tencent/mm/protocal/c/fo:ndp	J
    //   674: lconst_0
    //   675: lcmp
    //   676: ifne +22 -> 698
    //   679: aload 14
    //   681: getfield 399	com/tencent/mm/protocal/c/fo:ndm	I
    //   684: ifeq +14 -> 698
    //   687: aload 14
    //   689: aload 14
    //   691: getfield 399	com/tencent/mm/protocal/c/fo:ndm	I
    //   694: i2l
    //   695: putfield 396	com/tencent/mm/protocal/c/fo:ndp	J
    //   698: aload 14
    //   700: getfield 396	com/tencent/mm/protocal/c/fo:ndp	J
    //   703: lconst_0
    //   704: lcmp
    //   705: ifeq +48 -> 753
    //   708: aload 15
    //   710: aload 10
    //   712: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   715: ifeq +488 -> 1203
    //   718: aload 17
    //   720: aload_1
    //   721: aload 14
    //   723: getfield 396	com/tencent/mm/protocal/c/fo:ndp	J
    //   726: invokeinterface 405 4 0
    //   731: astore_1
    //   732: aload_1
    //   733: getfield 410	com/tencent/mm/h/c/cs:field_msgId	J
    //   736: lconst_0
    //   737: lcmp
    //   738: ifeq +27 -> 765
    //   741: ldc_w 308
    //   744: ldc_w 412
    //   747: invokestatic 213	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   750: goto -374 -> 376
    //   753: ldc_w 308
    //   756: ldc_w 414
    //   759: invokestatic 388	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   762: goto -386 -> 376
    //   765: aload 14
    //   767: getfield 396	com/tencent/mm/protocal/c/fo:ndp	J
    //   770: lconst_0
    //   771: lcmp
    //   772: ifeq +12 -> 784
    //   775: aload_1
    //   776: aload 14
    //   778: getfield 396	com/tencent/mm/protocal/c/fo:ndp	J
    //   781: invokevirtual 420	com/tencent/mm/storage/bi:bf	(J)V
    //   784: aload_1
    //   785: aload 14
    //   787: getfield 423	com/tencent/mm/protocal/c/fo:szs	I
    //   790: i2l
    //   791: invokevirtual 426	com/tencent/mm/storage/bi:bi	(J)V
    //   794: aload_3
    //   795: aload 11
    //   797: invokevirtual 359	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   800: checkcast 190	java/util/LinkedList
    //   803: astore 10
    //   805: aload 10
    //   807: ifnull +148 -> 955
    //   810: aload 10
    //   812: invokevirtual 427	java/util/LinkedList:size	()I
    //   815: ifle +140 -> 955
    //   818: lload 6
    //   820: aload 10
    //   822: invokevirtual 430	java/util/LinkedList:getFirst	()Ljava/lang/Object;
    //   825: checkcast 141	java/lang/Long
    //   828: invokevirtual 367	java/lang/Long:longValue	()J
    //   831: lcmp
    //   832: ifeq +105 -> 937
    //   835: aload 10
    //   837: invokevirtual 431	java/util/LinkedList:clear	()V
    //   840: aload 10
    //   842: lload 6
    //   844: invokestatic 144	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   847: invokevirtual 434	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   850: pop
    //   851: aload_1
    //   852: lload 6
    //   854: invokevirtual 437	com/tencent/mm/storage/bi:bg	(J)V
    //   857: aload_1
    //   858: aload 14
    //   860: getfield 440	com/tencent/mm/protocal/c/fo:szu	I
    //   863: invokevirtual 443	com/tencent/mm/storage/bi:fJ	(I)V
    //   866: aload_1
    //   867: aload 14
    //   869: getfield 259	com/tencent/mm/protocal/c/fo:hQR	I
    //   872: invokevirtual 446	com/tencent/mm/storage/bi:setType	(I)V
    //   875: aload 16
    //   877: aload 11
    //   879: invokeinterface 452 2 0
    //   884: astore 10
    //   886: aload 10
    //   888: ifnull +321 -> 1209
    //   891: aload 10
    //   893: getfield 457	com/tencent/mm/h/c/ao:field_username	Ljava/lang/String;
    //   896: invokestatic 304	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   899: ifne +310 -> 1209
    //   902: aload 10
    //   904: invokevirtual 462	com/tencent/mm/storage/ad:cua	()Z
    //   907: ifeq +302 -> 1209
    //   910: ldc_w 308
    //   913: new 222	java/lang/StringBuilder
    //   916: dup
    //   917: ldc_w 383
    //   920: invokespecial 384	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   923: aload 11
    //   925: invokevirtual 227	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   928: invokevirtual 239	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   931: invokestatic 388	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   934: goto -558 -> 376
    //   937: aload 10
    //   939: invokevirtual 465	java/util/LinkedList:getLast	()Ljava/lang/Object;
    //   942: checkcast 141	java/lang/Long
    //   945: invokevirtual 367	java/lang/Long:longValue	()J
    //   948: lconst_1
    //   949: ladd
    //   950: lstore 6
    //   952: goto -112 -> 840
    //   955: new 190	java/util/LinkedList
    //   958: dup
    //   959: invokespecial 466	java/util/LinkedList:<init>	()V
    //   962: astore 10
    //   964: aload 10
    //   966: lload 6
    //   968: invokestatic 144	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   971: invokevirtual 434	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   974: pop
    //   975: aload_3
    //   976: aload 11
    //   978: aload 10
    //   980: invokevirtual 470	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   983: pop
    //   984: goto -133 -> 851
    //   987: aload_1
    //   988: iload 5
    //   990: invokevirtual 473	com/tencent/mm/storage/bi:fA	(I)V
    //   993: aload_1
    //   994: aload 11
    //   996: invokevirtual 476	com/tencent/mm/storage/bi:ec	(Ljava/lang/String;)V
    //   999: iload 4
    //   1001: ifeq +225 -> 1226
    //   1004: aload 14
    //   1006: getfield 479	com/tencent/mm/protocal/c/fo:szk	I
    //   1009: istore 5
    //   1011: aload_1
    //   1012: iload 5
    //   1014: invokevirtual 482	com/tencent/mm/storage/bi:setStatus	(I)V
    //   1017: aload_2
    //   1018: aload 11
    //   1020: invokevirtual 359	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1023: ifnonnull +14 -> 1037
    //   1026: aload_2
    //   1027: aload 11
    //   1029: iconst_0
    //   1030: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1033: invokevirtual 470	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1036: pop
    //   1037: iload 4
    //   1039: ifne +37 -> 1076
    //   1042: aload 14
    //   1044: getfield 479	com/tencent/mm/protocal/c/fo:szk	I
    //   1047: iconst_3
    //   1048: if_icmpne +28 -> 1076
    //   1051: aload_2
    //   1052: aload 11
    //   1054: aload_2
    //   1055: aload 11
    //   1057: invokevirtual 359	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1060: checkcast 135	java/lang/Integer
    //   1063: iconst_0
    //   1064: invokestatic 485	com/tencent/mm/sdk/platformtools/bk:a	(Ljava/lang/Integer;I)I
    //   1067: iconst_1
    //   1068: iadd
    //   1069: invokestatic 139	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1072: invokevirtual 470	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1075: pop
    //   1076: invokestatic 491	com/tencent/mm/plugin/backup/f/c:aut	()Lcom/tencent/mm/plugin/backup/f/c;
    //   1079: aload 14
    //   1081: getfield 259	com/tencent/mm/protocal/c/fo:hQR	I
    //   1084: invokevirtual 495	com/tencent/mm/plugin/backup/f/c:nA	(I)Lcom/tencent/mm/plugin/backup/f/l;
    //   1087: astore 10
    //   1089: aload 10
    //   1091: ifnonnull +15 -> 1106
    //   1094: ldc_w 308
    //   1097: ldc_w 497
    //   1100: invokestatic 213	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1103: goto -727 -> 376
    //   1106: aload 10
    //   1108: aload 15
    //   1110: aload 14
    //   1112: aload_1
    //   1113: invokeinterface 502 4 0
    //   1118: pop
    //   1119: goto -743 -> 376
    //   1122: invokestatic 505	com/tencent/mm/plugin/backup/c/e:atM	()V
    //   1125: ldc 125
    //   1127: ldc_w 507
    //   1130: iconst_1
    //   1131: anewarray 4	java/lang/Object
    //   1134: dup
    //   1135: iconst_0
    //   1136: lload 8
    //   1138: invokestatic 511	com/tencent/mm/sdk/platformtools/bk:co	(J)J
    //   1141: invokestatic 144	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1144: aastore
    //   1145: invokestatic 155	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1148: aload 12
    //   1150: getfield 188	com/tencent/mm/protocal/c/fp:hPT	Ljava/util/LinkedList;
    //   1153: invokevirtual 427	java/util/LinkedList:size	()I
    //   1156: ireturn
    //   1157: astore_3
    //   1158: goto -961 -> 197
    //   1161: aload_1
    //   1162: astore 10
    //   1164: aload_1
    //   1165: ifnonnull -812 -> 353
    //   1168: ldc_w 306
    //   1171: astore 10
    //   1173: goto -820 -> 353
    //   1176: iconst_1
    //   1177: istore 4
    //   1179: iload 4
    //   1181: ifeq +15 -> 1196
    //   1184: aload_1
    //   1185: astore 11
    //   1187: goto -671 -> 516
    //   1190: iconst_0
    //   1191: istore 4
    //   1193: goto -14 -> 1179
    //   1196: aload 10
    //   1198: astore 11
    //   1200: goto -684 -> 516
    //   1203: aload 10
    //   1205: astore_1
    //   1206: goto -488 -> 718
    //   1209: iload 4
    //   1211: ifeq +9 -> 1220
    //   1214: iconst_1
    //   1215: istore 5
    //   1217: goto -230 -> 987
    //   1220: iconst_0
    //   1221: istore 5
    //   1223: goto -236 -> 987
    //   1226: iconst_4
    //   1227: istore 5
    //   1229: goto -218 -> 1011
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1232	0	this	d
    //   0	1232	2	paramHashMap	HashMap<String, Integer>
    //   0	1232	3	paramHashMap1	HashMap<String, LinkedList<Long>>
    //   203	1007	4	i	int
    //   988	240	5	j	int
    //   531	436	6	l1	long
    //   3	1134	8	l2	long
    //   11	1193	10	localObject1	Object
    //   87	147	11	localException	java.lang.Exception
    //   338	861	11	localObject2	Object
    //   28	1121	12	localObject3	Object
    //   38	13	13	localIterator	Iterator
    //   60	1051	14	localfo	com.tencent.mm.protocal.c.fo
    //   289	820	15	str	String
    //   489	387	16	localbd	com.tencent.mm.storage.bd
    //   300	419	17	localg	com.tencent.mm.plugin.messenger.foundation.a.a.g
    //   270	337	18	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   13	30	87	java/lang/Exception
    //   69	85	394	finally
    //   249	251	394	finally
    //   395	397	394	finally
    //   266	336	456	java/lang/Exception
    //   353	376	456	java/lang/Exception
    //   399	456	456	java/lang/Exception
    //   473	513	456	java/lang/Exception
    //   516	533	456	java/lang/Exception
    //   538	550	456	java/lang/Exception
    //   555	589	456	java/lang/Exception
    //   589	617	456	java/lang/Exception
    //   617	651	456	java/lang/Exception
    //   654	666	456	java/lang/Exception
    //   669	698	456	java/lang/Exception
    //   698	718	456	java/lang/Exception
    //   718	750	456	java/lang/Exception
    //   753	762	456	java/lang/Exception
    //   765	784	456	java/lang/Exception
    //   784	805	456	java/lang/Exception
    //   810	840	456	java/lang/Exception
    //   840	851	456	java/lang/Exception
    //   851	886	456	java/lang/Exception
    //   891	934	456	java/lang/Exception
    //   937	952	456	java/lang/Exception
    //   955	984	456	java/lang/Exception
    //   987	999	456	java/lang/Exception
    //   1004	1011	456	java/lang/Exception
    //   1011	1037	456	java/lang/Exception
    //   1042	1076	456	java/lang/Exception
    //   1076	1089	456	java/lang/Exception
    //   1094	1103	456	java/lang/Exception
    //   1106	1119	456	java/lang/Exception
    //   94	104	1157	java/lang/Exception
    //   106	135	1157	java/lang/Exception
    //   137	165	1157	java/lang/Exception
    //   167	195	1157	java/lang/Exception
  }
  
  private d.a atE()
  {
    if (this.hHb == null) {
      this.hHb = new d.a(this, (byte)0);
    }
    return this.hHb;
  }
  
  private void atG()
  {
    this.hGO = false;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      return;
    }
  }
  
  public static void atH()
  {
    y.i("MicroMsg.BackupRecoverMerger", "backupFinishMerge");
    com.tencent.mm.sdk.b.a.udP.m(new bo());
    com.tencent.mm.sdk.b.a.udP.m(new com.tencent.mm.h.a.z());
    com.tencent.mm.vfs.e.K(com.tencent.mm.plugin.backup.b.g.aty(), true);
    com.tencent.mm.plugin.backup.h.a locala = com.tencent.mm.plugin.backup.h.d.avi().avk();
    locala.handler.post(new a.2(locala));
    au.Hx();
    c.Fy().bhX();
    com.tencent.mm.sdk.b.a.udP.m(new pr());
    com.tencent.mm.sdk.a.b.mr(false);
  }
  
  public static void atI()
  {
    com.tencent.mm.plugin.backup.h.d.avi().avj().Fy().Hv("BACKUP_MERGE_LOCK");
  }
  
  public static void atJ()
  {
    com.tencent.mm.plugin.backup.h.d.avi().avj().Fy().Hw("BACKUP_MERGE_LOCK");
  }
  
  private static HashMap<String, Pair<Long, Long>> b(LinkedList<String> paramLinkedList, LinkedList<Long> paramLinkedList1)
  {
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
    return localHashMap;
  }
  
  public final void atF()
  {
    for (;;)
    {
      try
      {
        if (this.hGO)
        {
          y.e("MicroMsg.BackupRecoverMerger", "hasStartMerge , return");
          return;
        }
        this.hGO = true;
        y.i("MicroMsg.BackupRecoverMerger", "startMerge");
        this.hGe.ato();
        com.tencent.mm.plugin.backup.h.d.avi().avl();
        y.i("MicroMsg.BackupRecoverMerger", "backupStartMerge");
        com.tencent.mm.sdk.a.b.mr(true);
        atI();
        this.hGV = hGX;
        if (this.hFq == 1)
        {
          au.Hx();
          c.Dz().c(ac.a.uuo, Boolean.valueOf(true));
          y.i("MicroMsg.BackupRecoverMerger", "recoverFromSdcardImp start, mergeState[%d], totalMsgList size[%d], msgListDataIdHashMap size[%d]", new Object[] { Integer.valueOf(this.hGV), Long.valueOf(this.hGS), Integer.valueOf(this.hGP.size()) });
          com.tencent.mm.sdk.f.e.c(new d.1(this), "BackupRecoverMerger_recoverFromSdcard", 1).start();
          continue;
        }
        if (this.hFq != 2) {
          continue;
        }
      }
      finally {}
      au.Hx();
      c.Dz().c(ac.a.uur, Boolean.valueOf(true));
    }
  }
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    synchronized (this.lock)
    {
      y.i("MicroMsg.BackupRecoverMerger", "cancel, needClearContinueRecoverData[%b], mergeState[%d], updateState[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.hGV), Integer.valueOf(paramInt) });
      this.edT = true;
      this.hHc = paramBoolean;
      this.hHd = paramInt;
      return;
    }
  }
  
  public final void nv(int paramInt)
  {
    if (this.hGU != null) {
      this.hGU.nt(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.d
 * JD-Core Version:    0.7.0.1
 */