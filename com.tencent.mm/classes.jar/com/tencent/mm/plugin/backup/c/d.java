package com.tencent.mm.plugin.backup.c;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bv;
import com.tencent.mm.g.a.ta;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.a.1;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.m;
import com.tencent.wcdb.DatabaseUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class d
{
  private static int mTQ = 0;
  private static int mTR = 1;
  private static int mTS = 2;
  private static boolean mTT = false;
  private boolean gRx;
  private Object lock;
  private final com.tencent.mm.plugin.backup.b.d mSY;
  private final int mSg;
  private long mSw;
  public boolean mTI;
  private final HashMap<String, String> mTJ;
  private HashSet<String> mTK;
  private final int mTL;
  private final long mTM;
  private long mTN;
  private b.d mTO;
  private int mTP;
  private HashMap<String, Pair<Long, Long>> mTU;
  private a mTV;
  private boolean mTW;
  private int mTX;
  
  public d(com.tencent.mm.plugin.backup.b.d paramd, int paramInt1, b.d paramd1, int paramInt2, boolean paramBoolean, LinkedList<String> paramLinkedList, LinkedList<Long> paramLinkedList1)
  {
    AppMethodBeat.i(21258);
    this.mTI = false;
    this.mTK = new HashSet();
    this.lock = new Object();
    this.mSw = 0L;
    this.mTP = mTQ;
    this.mTJ = az.ayM().axg().eYY();
    this.mSY = paramd;
    this.mSg = paramInt1;
    this.mTO = paramd1;
    this.mTL = paramInt2;
    mTT = paramBoolean;
    this.mTM = DatabaseUtils.longForQuery(az.ayM().axg().hpA.fdL(), "SELECT COUNT(*) FROM BackupRecoverMsgListDataId", null);
    this.mTU = c(paramLinkedList, paramLinkedList1);
    this.mTK.clear();
    this.mTN = 0L;
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BackupRecoverMerger", "BackupRecoverMerger, msgListDataIdHashMap[%d], backupMode[%d], totalMsgList[%d], totalSession[%d], isQuickBackup[%b]", new Object[] { Integer.valueOf(this.mTJ.size()), Integer.valueOf(paramInt1), Long.valueOf(this.mTM), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(21258);
  }
  
  /* Error */
  private int a(String arg1, HashMap<String, Integer> paramHashMap, Pair<PLong, PLong> paramPair, String paramString2, PString paramPString, PBool paramPBool)
  {
    // Byte code:
    //   0: sipush 21261
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: iconst_0
    //   8: iconst_m1
    //   9: invokestatic 184	com/tencent/mm/vfs/i:aU	(Ljava/lang/String;II)[B
    //   12: astore 12
    //   14: new 186	com/tencent/mm/protocal/protobuf/hz
    //   17: dup
    //   18: invokespecial 187	com/tencent/mm/protocal/protobuf/hz:<init>	()V
    //   21: aload 12
    //   23: invokevirtual 191	com/tencent/mm/protocal/protobuf/hz:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   26: checkcast 186	com/tencent/mm/protocal/protobuf/hz
    //   29: astore 16
    //   31: iconst_1
    //   32: istore 7
    //   34: ldc 193
    //   36: astore 12
    //   38: aload 16
    //   40: getfield 197	com/tencent/mm/protocal/protobuf/hz:ncM	Ljava/util/LinkedList;
    //   43: invokevirtual 203	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   46: astore 17
    //   48: aload 17
    //   50: invokeinterface 209 1 0
    //   55: ifeq +1035 -> 1090
    //   58: aload 17
    //   60: invokeinterface 213 1 0
    //   65: checkcast 215	com/tencent/mm/protocal/protobuf/hy
    //   68: astore 18
    //   70: aload_0
    //   71: getfield 72	com/tencent/mm/plugin/backup/c/d:lock	Ljava/lang/Object;
    //   74: astore_1
    //   75: aload_1
    //   76: monitorenter
    //   77: aload_0
    //   78: getfield 217	com/tencent/mm/plugin/backup/c/d:gRx	Z
    //   81: ifeq +182 -> 263
    //   84: aload_1
    //   85: monitorexit
    //   86: sipush 21261
    //   89: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: iconst_m1
    //   93: ireturn
    //   94: astore 4
    //   96: ldc 193
    //   98: astore_3
    //   99: aload_3
    //   100: astore_2
    //   101: new 219	com/tencent/mm/vfs/e
    //   104: dup
    //   105: aload_1
    //   106: invokespecial 222	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   109: astore 5
    //   111: aload_3
    //   112: astore_2
    //   113: new 224	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   120: ldc 193
    //   122: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 5
    //   127: invokevirtual 232	com/tencent/mm/vfs/e:exists	()Z
    //   130: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   133: ldc 237
    //   135: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: astore_3
    //   142: aload_3
    //   143: astore_2
    //   144: new 224	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   151: aload_3
    //   152: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 5
    //   157: invokevirtual 244	com/tencent/mm/vfs/e:canRead	()Z
    //   160: invokevirtual 235	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   163: ldc 237
    //   165: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: astore_3
    //   172: aload_3
    //   173: astore_2
    //   174: new 224	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 225	java/lang/StringBuilder:<init>	()V
    //   181: aload_3
    //   182: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: aload 5
    //   187: invokevirtual 248	com/tencent/mm/vfs/e:length	()J
    //   190: invokevirtual 251	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   193: ldc 253
    //   195: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: astore_3
    //   202: aload_3
    //   203: astore_2
    //   204: aload 12
    //   206: ifnonnull +49 -> 255
    //   209: iconst_m1
    //   210: istore 7
    //   212: ldc 137
    //   214: aload 4
    //   216: ldc 255
    //   218: iconst_4
    //   219: anewarray 4	java/lang/Object
    //   222: dup
    //   223: iconst_0
    //   224: aload_1
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: aload_2
    //   229: aastore
    //   230: dup
    //   231: iconst_2
    //   232: iload 7
    //   234: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: aastore
    //   238: dup
    //   239: iconst_3
    //   240: aload 4
    //   242: aastore
    //   243: invokestatic 259	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   246: sipush 21261
    //   249: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: bipush 254
    //   254: ireturn
    //   255: aload 12
    //   257: arraylength
    //   258: istore 7
    //   260: goto -48 -> 212
    //   263: aload_1
    //   264: monitorexit
    //   265: getstatic 52	com/tencent/mm/plugin/backup/c/d:mTT	Z
    //   268: ifeq +12 -> 280
    //   271: aload 18
    //   273: getfield 262	com/tencent/mm/protocal/protobuf/hy:ndI	I
    //   276: iconst_1
    //   277: if_icmpne -229 -> 48
    //   280: aload 6
    //   282: getfield 267	com/tencent/mm/pointers/PBool:value	Z
    //   285: ifeq +47 -> 332
    //   288: aconst_null
    //   289: astore_1
    //   290: iload 7
    //   292: ifeq +172 -> 464
    //   295: aload_1
    //   296: ifnull +168 -> 464
    //   299: aload_1
    //   300: getfield 273	com/tencent/mm/g/c/dy:field_talker	Ljava/lang/String;
    //   303: astore_1
    //   304: iconst_0
    //   305: istore 7
    //   307: aload 18
    //   309: getfield 262	com/tencent/mm/protocal/protobuf/hy:ndI	I
    //   312: invokestatic 278	com/tencent/mm/plugin/backup/c/e:wM	(I)V
    //   315: aload_1
    //   316: astore 12
    //   318: goto -270 -> 48
    //   321: astore_2
    //   322: aload_1
    //   323: monitorexit
    //   324: sipush 21261
    //   327: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: aload_2
    //   331: athrow
    //   332: aload 18
    //   334: getfield 282	com/tencent/mm/protocal/protobuf/hy:DPT	Lcom/tencent/mm/protocal/protobuf/crm;
    //   337: getfield 287	com/tencent/mm/protocal/protobuf/crm:FEm	Ljava/lang/String;
    //   340: astore 14
    //   342: aload 18
    //   344: getfield 290	com/tencent/mm/protocal/protobuf/hy:DPU	Lcom/tencent/mm/protocal/protobuf/crm;
    //   347: getfield 287	com/tencent/mm/protocal/protobuf/crm:FEm	Ljava/lang/String;
    //   350: astore 13
    //   352: aload 14
    //   354: invokestatic 296	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   357: ifne +11 -> 368
    //   360: aload 13
    //   362: invokestatic 296	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   365: ifeq +45 -> 410
    //   368: aload 14
    //   370: astore_1
    //   371: aload 14
    //   373: ifnonnull +769 -> 1142
    //   376: ldc_w 298
    //   379: astore_1
    //   380: goto +762 -> 1142
    //   383: ldc_w 300
    //   386: ldc_w 302
    //   389: iconst_2
    //   390: anewarray 4	java/lang/Object
    //   393: dup
    //   394: iconst_0
    //   395: aload_1
    //   396: aastore
    //   397: dup
    //   398: iconst_1
    //   399: aload 14
    //   401: aastore
    //   402: invokestatic 305	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   405: aconst_null
    //   406: astore_1
    //   407: goto -117 -> 290
    //   410: aload 4
    //   412: aload 14
    //   414: invokevirtual 311	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   417: ifne +742 -> 1159
    //   420: invokestatic 317	com/tencent/mm/plugin/backup/h/d:bEP	()Lcom/tencent/mm/plugin/backup/h/d;
    //   423: invokevirtual 321	com/tencent/mm/plugin/backup/h/d:bEQ	()Lcom/tencent/mm/plugin/backup/h/b;
    //   426: astore_1
    //   427: aload_1
    //   428: getfield 326	com/tencent/mm/plugin/backup/h/b:uin	I
    //   431: ifne +39 -> 470
    //   434: new 328	com/tencent/mm/model/b
    //   437: dup
    //   438: invokespecial 329	com/tencent/mm/model/b:<init>	()V
    //   441: astore_1
    //   442: sipush 21261
    //   445: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   448: aload_1
    //   449: athrow
    //   450: astore_1
    //   451: ldc 137
    //   453: aload_1
    //   454: ldc_w 331
    //   457: iconst_0
    //   458: anewarray 4	java/lang/Object
    //   461: invokestatic 259	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   464: aload 12
    //   466: astore_1
    //   467: goto -160 -> 307
    //   470: aload_1
    //   471: getfield 335	com/tencent/mm/plugin/backup/h/b:mZM	Lcom/tencent/mm/plugin/messenger/foundation/a/a/k;
    //   474: aload 14
    //   476: invokeinterface 340 2 0
    //   481: ifeq +696 -> 1177
    //   484: goto +675 -> 1159
    //   487: aload 5
    //   489: ifnull +14 -> 503
    //   492: aload 5
    //   494: getfield 344	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   497: invokestatic 296	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   500: ifeq +636 -> 1136
    //   503: aload 5
    //   505: ifnonnull +625 -> 1130
    //   508: new 342	com/tencent/mm/pointers/PString
    //   511: dup
    //   512: invokespecial 345	com/tencent/mm/pointers/PString:<init>	()V
    //   515: astore_1
    //   516: goto +649 -> 1165
    //   519: aload_1
    //   520: aload 15
    //   522: putfield 344	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   525: invokestatic 317	com/tencent/mm/plugin/backup/h/d:bEP	()Lcom/tencent/mm/plugin/backup/h/d;
    //   528: invokevirtual 321	com/tencent/mm/plugin/backup/h/d:bEQ	()Lcom/tencent/mm/plugin/backup/h/b;
    //   531: invokevirtual 349	com/tencent/mm/plugin/backup/h/b:awB	()Lcom/tencent/mm/storage/bj;
    //   534: aload_1
    //   535: getfield 344	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   538: invokeinterface 355 2 0
    //   543: astore 15
    //   545: invokestatic 361	com/tencent/mm/plugin/backup/b/g:bDg	()Ljava/util/List;
    //   548: aload_1
    //   549: getfield 344	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   552: invokeinterface 366 2 0
    //   557: ifne +27 -> 584
    //   560: aload 15
    //   562: ifnull +628 -> 1190
    //   565: aload 15
    //   567: getfield 371	com/tencent/mm/g/c/av:field_username	Ljava/lang/String;
    //   570: invokestatic 296	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   573: ifne +617 -> 1190
    //   576: aload 15
    //   578: invokevirtual 376	com/tencent/mm/storage/ai:fad	()Z
    //   581: ifeq +609 -> 1190
    //   584: ldc_w 300
    //   587: new 224	java/lang/StringBuilder
    //   590: dup
    //   591: ldc_w 378
    //   594: invokespecial 379	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   597: aload_1
    //   598: getfield 344	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   601: invokevirtual 229	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: invokevirtual 241	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokestatic 382	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   610: aload 6
    //   612: iconst_1
    //   613: putfield 267	com/tencent/mm/pointers/PBool:value	Z
    //   616: aconst_null
    //   617: astore_1
    //   618: goto -328 -> 290
    //   621: aload 18
    //   623: getfield 385	com/tencent/mm/protocal/protobuf/hy:vTQ	J
    //   626: lconst_0
    //   627: lcmp
    //   628: ifne +22 -> 650
    //   631: aload 18
    //   633: getfield 388	com/tencent/mm/protocal/protobuf/hy:vTO	I
    //   636: ifeq +14 -> 650
    //   639: aload 18
    //   641: aload 18
    //   643: getfield 388	com/tencent/mm/protocal/protobuf/hy:vTO	I
    //   646: i2l
    //   647: putfield 385	com/tencent/mm/protocal/protobuf/hy:vTQ	J
    //   650: aload 18
    //   652: getfield 385	com/tencent/mm/protocal/protobuf/hy:vTQ	J
    //   655: lconst_0
    //   656: lcmp
    //   657: ifeq +77 -> 734
    //   660: invokestatic 317	com/tencent/mm/plugin/backup/h/d:bEP	()Lcom/tencent/mm/plugin/backup/h/d;
    //   663: invokevirtual 321	com/tencent/mm/plugin/backup/h/d:bEQ	()Lcom/tencent/mm/plugin/backup/h/b;
    //   666: invokevirtual 392	com/tencent/mm/plugin/backup/h/b:awD	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/h;
    //   669: aload_1
    //   670: getfield 344	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   673: aload 18
    //   675: getfield 385	com/tencent/mm/protocal/protobuf/hy:vTQ	J
    //   678: invokeinterface 398 4 0
    //   683: astore 15
    //   685: aload 15
    //   687: getfield 401	com/tencent/mm/g/c/dy:field_msgId	J
    //   690: lconst_0
    //   691: lcmp
    //   692: ifeq +56 -> 748
    //   695: ldc_w 300
    //   698: ldc_w 403
    //   701: iconst_3
    //   702: anewarray 4	java/lang/Object
    //   705: dup
    //   706: iconst_0
    //   707: aload 18
    //   709: getfield 262	com/tencent/mm/protocal/protobuf/hy:ndI	I
    //   712: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   715: aastore
    //   716: dup
    //   717: iconst_1
    //   718: aload 14
    //   720: aastore
    //   721: dup
    //   722: iconst_2
    //   723: aload 13
    //   725: aastore
    //   726: invokestatic 166	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   729: aconst_null
    //   730: astore_1
    //   731: goto -441 -> 290
    //   734: ldc_w 300
    //   737: ldc_w 405
    //   740: invokestatic 382	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   743: aconst_null
    //   744: astore_1
    //   745: goto -455 -> 290
    //   748: ldc_w 300
    //   751: ldc_w 407
    //   754: iconst_3
    //   755: anewarray 4	java/lang/Object
    //   758: dup
    //   759: iconst_0
    //   760: aload 18
    //   762: getfield 262	com/tencent/mm/protocal/protobuf/hy:ndI	I
    //   765: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   768: aastore
    //   769: dup
    //   770: iconst_1
    //   771: aload 14
    //   773: aastore
    //   774: dup
    //   775: iconst_2
    //   776: aload 13
    //   778: aastore
    //   779: invokestatic 166	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   782: aload 15
    //   784: aload 18
    //   786: getfield 385	com/tencent/mm/protocal/protobuf/hy:vTQ	J
    //   789: invokevirtual 413	com/tencent/mm/storage/bo:oz	(J)V
    //   792: aload 15
    //   794: aload 18
    //   796: getfield 416	com/tencent/mm/protocal/protobuf/hy:DVv	I
    //   799: i2l
    //   800: invokevirtual 419	com/tencent/mm/storage/bo:oC	(J)V
    //   803: aload 18
    //   805: getfield 422	com/tencent/mm/protocal/protobuf/hy:DVw	J
    //   808: lconst_0
    //   809: lcmp
    //   810: ifeq +217 -> 1027
    //   813: aload 18
    //   815: getfield 422	com/tencent/mm/protocal/protobuf/hy:DVw	J
    //   818: lstore 10
    //   820: lload 10
    //   822: aload_3
    //   823: getfield 427	android/util/Pair:first	Ljava/lang/Object;
    //   826: checkcast 429	com/tencent/mm/pointers/PLong
    //   829: getfield 431	com/tencent/mm/pointers/PLong:value	J
    //   832: lcmp
    //   833: ifeq +209 -> 1042
    //   836: aload_3
    //   837: getfield 427	android/util/Pair:first	Ljava/lang/Object;
    //   840: checkcast 429	com/tencent/mm/pointers/PLong
    //   843: lload 10
    //   845: putfield 431	com/tencent/mm/pointers/PLong:value	J
    //   848: aload_3
    //   849: getfield 434	android/util/Pair:second	Ljava/lang/Object;
    //   852: checkcast 429	com/tencent/mm/pointers/PLong
    //   855: lload 10
    //   857: putfield 431	com/tencent/mm/pointers/PLong:value	J
    //   860: aload 15
    //   862: lload 10
    //   864: invokevirtual 437	com/tencent/mm/storage/bo:oA	(J)V
    //   867: aload 15
    //   869: aload 18
    //   871: getfield 440	com/tencent/mm/protocal/protobuf/hy:DVx	I
    //   874: invokevirtual 443	com/tencent/mm/storage/bo:setFlag	(I)V
    //   877: aload 15
    //   879: aload 18
    //   881: getfield 262	com/tencent/mm/protocal/protobuf/hy:ndI	I
    //   884: invokevirtual 446	com/tencent/mm/storage/bo:setType	(I)V
    //   887: iload 8
    //   889: ifeq +304 -> 1193
    //   892: iconst_1
    //   893: istore 9
    //   895: aload 15
    //   897: iload 9
    //   899: invokevirtual 449	com/tencent/mm/storage/bo:jT	(I)V
    //   902: aload 15
    //   904: aload_1
    //   905: getfield 344	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   908: invokevirtual 452	com/tencent/mm/storage/bo:re	(Ljava/lang/String;)V
    //   911: iload 8
    //   913: ifeq +286 -> 1199
    //   916: aload 18
    //   918: getfield 455	com/tencent/mm/protocal/protobuf/hy:DVn	I
    //   921: istore 9
    //   923: aload 15
    //   925: iload 9
    //   927: invokevirtual 458	com/tencent/mm/storage/bo:setStatus	(I)V
    //   930: aload_2
    //   931: aload_1
    //   932: getfield 344	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   935: invokevirtual 462	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   938: ifnonnull +16 -> 954
    //   941: aload_2
    //   942: aload_1
    //   943: getfield 344	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   946: iconst_0
    //   947: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   950: invokevirtual 466	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   953: pop
    //   954: iload 8
    //   956: ifne +41 -> 997
    //   959: aload 18
    //   961: getfield 455	com/tencent/mm/protocal/protobuf/hy:DVn	I
    //   964: iconst_3
    //   965: if_icmpne +32 -> 997
    //   968: aload_2
    //   969: aload_1
    //   970: getfield 344	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   973: aload_2
    //   974: aload_1
    //   975: getfield 344	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   978: invokevirtual 462	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   981: checkcast 147	java/lang/Integer
    //   984: iconst_0
    //   985: invokestatic 469	com/tencent/mm/sdk/platformtools/bs:a	(Ljava/lang/Integer;I)I
    //   988: iconst_1
    //   989: iadd
    //   990: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   993: invokevirtual 466	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   996: pop
    //   997: invokestatic 475	com/tencent/mm/plugin/backup/f/c:bDW	()Lcom/tencent/mm/plugin/backup/f/c;
    //   1000: aload 18
    //   1002: getfield 262	com/tencent/mm/protocal/protobuf/hy:ndI	I
    //   1005: invokevirtual 479	com/tencent/mm/plugin/backup/f/c:wR	(I)Lcom/tencent/mm/plugin/backup/f/l;
    //   1008: astore_1
    //   1009: aload_1
    //   1010: ifnonnull +61 -> 1071
    //   1013: ldc_w 300
    //   1016: ldc_w 481
    //   1019: invokestatic 483	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1022: aconst_null
    //   1023: astore_1
    //   1024: goto -734 -> 290
    //   1027: aload 18
    //   1029: getfield 486	com/tencent/mm/protocal/protobuf/hy:DVo	I
    //   1032: i2l
    //   1033: ldc2_w 487
    //   1036: lmul
    //   1037: lstore 10
    //   1039: goto -219 -> 820
    //   1042: aload_3
    //   1043: getfield 434	android/util/Pair:second	Ljava/lang/Object;
    //   1046: checkcast 429	com/tencent/mm/pointers/PLong
    //   1049: getfield 431	com/tencent/mm/pointers/PLong:value	J
    //   1052: lconst_1
    //   1053: ladd
    //   1054: lstore 10
    //   1056: aload_3
    //   1057: getfield 434	android/util/Pair:second	Ljava/lang/Object;
    //   1060: checkcast 429	com/tencent/mm/pointers/PLong
    //   1063: lload 10
    //   1065: putfield 431	com/tencent/mm/pointers/PLong:value	J
    //   1068: goto -208 -> 860
    //   1071: aload_1
    //   1072: aload 4
    //   1074: aload 18
    //   1076: aload 15
    //   1078: invokeinterface 493 4 0
    //   1083: pop
    //   1084: aload 15
    //   1086: astore_1
    //   1087: goto -797 -> 290
    //   1090: invokestatic 496	com/tencent/mm/plugin/backup/c/e:bDr	()V
    //   1093: ldc_w 498
    //   1096: invokestatic 504	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   1099: checkcast 498	com/tencent/mm/chatroom/plugin/PluginChatroomUI
    //   1102: aload 12
    //   1104: invokevirtual 507	com/tencent/mm/chatroom/plugin/PluginChatroomUI:handleChatroomBackup	(Ljava/lang/String;)V
    //   1107: aload 16
    //   1109: getfield 197	com/tencent/mm/protocal/protobuf/hz:ncM	Ljava/util/LinkedList;
    //   1112: invokevirtual 508	java/util/LinkedList:size	()I
    //   1115: istore 7
    //   1117: sipush 21261
    //   1120: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1123: iload 7
    //   1125: ireturn
    //   1126: astore_3
    //   1127: goto -923 -> 204
    //   1130: aload 5
    //   1132: astore_1
    //   1133: goto +32 -> 1165
    //   1136: aload 5
    //   1138: astore_1
    //   1139: goto -518 -> 621
    //   1142: aload 13
    //   1144: astore 14
    //   1146: aload 13
    //   1148: ifnonnull -765 -> 383
    //   1151: ldc_w 298
    //   1154: astore 14
    //   1156: goto -773 -> 383
    //   1159: iconst_1
    //   1160: istore 8
    //   1162: goto -675 -> 487
    //   1165: iload 8
    //   1167: ifeq +16 -> 1183
    //   1170: aload 13
    //   1172: astore 15
    //   1174: goto -655 -> 519
    //   1177: iconst_0
    //   1178: istore 8
    //   1180: goto -693 -> 487
    //   1183: aload 14
    //   1185: astore 15
    //   1187: goto -668 -> 519
    //   1190: goto -569 -> 621
    //   1193: iconst_0
    //   1194: istore 9
    //   1196: goto -301 -> 895
    //   1199: iconst_4
    //   1200: istore 9
    //   1202: goto -279 -> 923
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1205	0	this	d
    //   0	1205	2	paramHashMap	HashMap<String, Integer>
    //   0	1205	3	paramPair	Pair<PLong, PLong>
    //   0	1205	4	paramString2	String
    //   0	1205	5	paramPString	PString
    //   0	1205	6	paramPBool	PBool
    //   32	1092	7	i	int
    //   887	292	8	j	int
    //   893	308	9	k	int
    //   818	246	10	l	long
    //   12	1091	12	localObject1	Object
    //   350	821	13	str	String
    //   340	844	14	localObject2	Object
    //   520	666	15	localObject3	Object
    //   29	1079	16	localhz	com.tencent.mm.protocal.protobuf.hz
    //   46	13	17	localIterator	Iterator
    //   68	1007	18	localhy	com.tencent.mm.protocal.protobuf.hy
    // Exception table:
    //   from	to	target	type
    //   14	31	94	java/lang/Exception
    //   77	86	321	finally
    //   263	265	321	finally
    //   322	324	321	finally
    //   280	288	450	java/lang/Exception
    //   299	304	450	java/lang/Exception
    //   332	368	450	java/lang/Exception
    //   383	405	450	java/lang/Exception
    //   410	450	450	java/lang/Exception
    //   470	484	450	java/lang/Exception
    //   492	503	450	java/lang/Exception
    //   508	516	450	java/lang/Exception
    //   519	560	450	java/lang/Exception
    //   565	584	450	java/lang/Exception
    //   584	616	450	java/lang/Exception
    //   621	650	450	java/lang/Exception
    //   650	729	450	java/lang/Exception
    //   734	743	450	java/lang/Exception
    //   748	820	450	java/lang/Exception
    //   820	860	450	java/lang/Exception
    //   860	887	450	java/lang/Exception
    //   895	911	450	java/lang/Exception
    //   916	923	450	java/lang/Exception
    //   923	954	450	java/lang/Exception
    //   959	997	450	java/lang/Exception
    //   997	1009	450	java/lang/Exception
    //   1013	1022	450	java/lang/Exception
    //   1027	1039	450	java/lang/Exception
    //   1042	1068	450	java/lang/Exception
    //   1071	1084	450	java/lang/Exception
    //   101	111	1126	java/lang/Exception
    //   113	142	1126	java/lang/Exception
    //   144	172	1126	java/lang/Exception
    //   174	202	1126	java/lang/Exception
  }
  
  /* Error */
  private boolean bDk()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 65	com/tencent/mm/plugin/backup/c/d:mTI	Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 65	com/tencent/mm/plugin/backup/c/d:mTI	Z
    //   22: iconst_0
    //   23: istore_1
    //   24: goto -11 -> 13
    //   27: astore_3
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_3
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	d
    //   1	23	1	bool1	boolean
    //   8	2	2	bool2	boolean
    //   27	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	27	finally
    //   17	22	27	finally
  }
  
  private void bDl()
  {
    try
    {
      this.mTI = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void bDm()
  {
    AppMethodBeat.i(21264);
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BackupRecoverMerger", "backupFinishMerge");
    com.tencent.mm.sdk.b.a.GpY.l(new bv());
    com.tencent.mm.sdk.b.a.GpY.l(new com.tencent.mm.g.a.ac());
    com.tencent.mm.plugin.backup.h.a locala = com.tencent.mm.plugin.backup.h.d.bEP().bER();
    locala.handler.post(new a.1(locala));
    az.ayM();
    com.tencent.mm.model.c.awD().dcA();
    com.tencent.mm.sdk.b.a.GpY.l(new ta());
    com.tencent.mm.sdk.a.b.vO(false);
    AppMethodBeat.o(21264);
  }
  
  public static void bDn()
  {
    AppMethodBeat.i(21265);
    com.tencent.mm.plugin.backup.h.d.bEP().bEQ().awD().alf("BACKUP_MERGE_LOCK");
    AppMethodBeat.o(21265);
  }
  
  public static void bDo()
  {
    AppMethodBeat.i(21266);
    com.tencent.mm.plugin.backup.h.d.bEP().bEQ().awD().alg("BACKUP_MERGE_LOCK");
    AppMethodBeat.o(21266);
  }
  
  private static HashMap<String, Pair<Long, Long>> c(LinkedList<String> paramLinkedList, LinkedList<Long> paramLinkedList1)
  {
    AppMethodBeat.i(21259);
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
    AppMethodBeat.o(21259);
    return localHashMap;
  }
  
  public final void ir(final boolean paramBoolean)
  {
    AppMethodBeat.i(21260);
    if (bDk())
    {
      com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BackupRecoverMerger", "Already start merge, return.");
      AppMethodBeat.o(21260);
      return;
    }
    com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BackupRecoverMerger", "startMerge");
    this.mSw = 0L;
    com.tencent.mm.sdk.a.b.vO(true);
    this.mSY.bCQ();
    az.getNotification().cx(true);
    this.mTP = mTR;
    if (this.mSg == 1)
    {
      az.ayM();
      com.tencent.mm.model.c.agA().set(ah.a.GKM, Boolean.TRUE);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BackupRecoverMerger", "startMergeImpl start, mergeState[%d], totalMsgList[%d], msgListDataIdHashMap[%d]", new Object[] { Integer.valueOf(this.mTP), Long.valueOf(this.mTM), Integer.valueOf(this.mTJ.size()) });
      com.tencent.e.h.JZN.aV(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "BackupRecoverMerger";
        }
        
        public final void run()
        {
          AppMethodBeat.i(21256);
          e.reset();
          e.bDs();
          if ((g.mSE) && (paramBoolean) && (com.tencent.mm.vfs.i.eA(g.bDd())) && (com.tencent.mm.vfs.i.cZ(g.bDd(), false) != null))
          {
            g.Sq(g.bDc());
            com.tencent.mm.vfs.i.mb(g.bDd(), g.bDc());
          }
          Object localObject1 = new HashMap();
          Object localObject2 = (String)com.tencent.mm.plugin.backup.h.d.bEP().bEQ().agA().get(2, null);
          Iterator localIterator = d.a(d.this).keySet().iterator();
          for (;;)
          {
            long l2;
            long l3;
            label468:
            long l1;
            if (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              l2 = bs.eWj();
              d.bDn();
              Object localObject3 = d.b(d.this);
              if (com.tencent.mm.plugin.backup.h.d.bEP().bEQ().ghG != null)
              {
                ((d.a)localObject3).mUa = com.tencent.mm.plugin.backup.h.d.bEP().bEQ().ghG.vE(Thread.currentThread().getId());
                ((d.a)localObject3).gas = true;
              }
              localObject3 = g.Sr(str) + str;
              PString localPString = new PString();
              PBool localPBool = new PBool();
              Pair localPair = new Pair(new PLong(-1L), new PLong(-1L));
              try
              {
                l3 = d.a(d.this, (String)localObject3, (HashMap)localObject1, localPair, (String)localObject2, localPString, localPBool);
                if (l3 < 0L) {
                  com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BackupRecoverMerger", "msgListMsgCount error, msgListMsgCount:%d, itemPath:%s", new Object[] { Long.valueOf(l3), localObject3 });
                }
                if (!d.c(d.this)) {
                  break label468;
                }
                com.tencent.mm.sdk.platformtools.ac.e("MicroMsg.BackupRecoverMerger", "startMergeImpl cancel, msgDataId[%s], transferMsgList[%d], totalMsgList[%d], transferSessions[%d], totalSession[%d]", new Object[] { str, Long.valueOf(d.d(d.this)), Long.valueOf(d.e(d.this)), Integer.valueOf(d.f(d.this).size()), Integer.valueOf(d.g(d.this)) });
                d.b(d.this).end();
                d.bDo();
                com.tencent.mm.plugin.backup.h.c.g((HashMap)localObject1);
                d.a(d.this, d.h(d.this), d.i(d.this));
                AppMethodBeat.o(21256);
                return;
              }
              catch (Exception localException)
              {
                com.tencent.mm.sdk.platformtools.ac.printErrStackTrace("MicroMsg.BackupRecoverMerger", localException, "startMergeImpl MMThread.run():", new Object[0]);
              }
              if (!com.tencent.mm.sdk.a.b.eUk()) {
                continue;
              }
              AppMethodBeat.o(21256);
              throw localException;
              d.a(d.this, d.j(d.this) + l3);
              d.f(d.this).add(d.a(d.this).get(localException));
              d.k(d.this);
              d.l(d.this).bCP().mSk = 26;
              localObject3 = d.l(d.this).bCP();
              if (d.d(d.this) > d.e(d.this))
              {
                l1 = 100L;
                label566:
                ((com.tencent.mm.plugin.backup.b.e)localObject3).mSn = ((int)l1);
                d.this.wL(26);
                d.b(d.this).end();
                d.bDo();
              }
            }
            try
            {
              Thread.sleep(10L);
              label601:
              com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BackupRecoverMerger", "startMergeImpl msgDataId[%s] merge finish, transferMsgList[%d], transferSessions[%d], msgListMsgCount:%d, receiveMsgCount:%d, costTime:%d", new Object[] { localException, Long.valueOf(d.d(d.this)), Integer.valueOf(d.f(d.this).size()), Long.valueOf(l3), Long.valueOf(d.j(d.this)), Long.valueOf(bs.Ap(l2)) });
              continue;
              l1 = d.d(d.this) * 100L / d.e(d.this);
              break label566;
              d.l(d.this).bCP().mSw = d.j(d.this);
              localObject2 = d.l(d.this).bCP();
              if (d.f(d.this).size() > d.g(d.this))
              {
                i = d.g(d.this);
                ((com.tencent.mm.plugin.backup.b.e)localObject2).mSl = i;
                d.l(d.this).bCP().mSm = d.g(d.this);
                localObject2 = d.l(d.this).bCP();
                if (d.d(d.this) <= d.e(d.this)) {
                  break label1143;
                }
                l1 = 100L;
                label826:
                ((com.tencent.mm.plugin.backup.b.e)localObject2).mSn = ((int)l1);
                d.this.wL(30);
                com.tencent.mm.plugin.backup.h.c.g((HashMap)localObject1);
                com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BackupRecoverMerger", "startMergeImpl buildConversation finish! transferMsgList[%d], totalMsgList[%d], transferSession[%d], totalSession[%d]", new Object[] { Long.valueOf(d.d(d.this)), Long.valueOf(d.e(d.this)), Integer.valueOf(d.f(d.this).size()), Integer.valueOf(d.g(d.this)) });
                d.b(d.this).end();
                if (d.m(d.this) != d.bDp())
                {
                  d.a(d.this, d.bDp());
                  d.bDm();
                  if (d.n(d.this) != 1) {
                    break label1166;
                  }
                  az.ayM();
                  com.tencent.mm.model.c.agA().set(ah.a.GKM, Boolean.FALSE);
                  label978:
                  if (d.o(d.this) != null) {
                    d.o(d.this).bCO();
                  }
                  localObject1 = d.l(d.this).bCP();
                  if (d.f(d.this).size() <= d.g(d.this)) {
                    break label1196;
                  }
                }
              }
              label1166:
              label1196:
              for (int i = d.g(d.this);; i = d.f(d.this).size())
              {
                ((com.tencent.mm.plugin.backup.b.e)localObject1).P(27, i, d.g(d.this));
                d.this.wL(27);
                g.bDb();
                if (!g.mSE)
                {
                  g.Sq(g.bDc());
                  g.bDa();
                }
                d.a(d.this, d.bDq());
                d.p(d.this);
                az.getNotification().cx(false);
                d.l(d.this).bCR();
                com.tencent.mm.sdk.platformtools.ac.eUQ();
                AppMethodBeat.o(21256);
                return;
                i = d.f(d.this).size();
                break;
                label1143:
                l1 = d.d(d.this) * 100L / d.e(d.this);
                break label826;
                if (d.n(d.this) != 2) {
                  break label978;
                }
                az.ayM();
                com.tencent.mm.model.c.agA().set(ah.a.GKP, Boolean.FALSE);
                break label978;
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              break label601;
            }
          }
        }
      });
      AppMethodBeat.o(21260);
      return;
      if (this.mSg == 2)
      {
        az.ayM();
        com.tencent.mm.model.c.agA().set(ah.a.GKP, Boolean.TRUE);
      }
    }
  }
  
  public final void wL(int paramInt)
  {
    AppMethodBeat.i(21263);
    if (this.mTO != null) {
      this.mTO.wJ(paramInt);
    }
    AppMethodBeat.o(21263);
  }
  
  public final void x(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(21262);
    synchronized (this.lock)
    {
      com.tencent.mm.sdk.platformtools.ac.i("MicroMsg.BackupRecoverMerger", "cancel, needClearContinueRecoverData[%b], mergeState[%d], updateState[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.mTP), Integer.valueOf(paramInt) });
      this.gRx = true;
      this.mTW = paramBoolean;
      this.mTX = paramInt;
      az.getNotification().cx(false);
      this.mSY.bCR();
      AppMethodBeat.o(21262);
      return;
    }
  }
  
  final class a
  {
    boolean gas = false;
    long mUa = -1L;
    
    private a() {}
    
    public final void end()
    {
      AppMethodBeat.i(21257);
      if ((this.gas) && (com.tencent.mm.plugin.backup.h.d.bEP().bEQ().ghG != null))
      {
        com.tencent.mm.plugin.backup.h.d.bEP().bEQ().ghG.qL(this.mUa);
        this.gas = false;
      }
      AppMethodBeat.o(21257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.d
 * JD-Core Version:    0.7.0.1
 */