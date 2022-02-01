package com.tencent.mm.plugin.backup.c;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.a.af;
import com.tencent.mm.f.a.ce;
import com.tencent.mm.f.a.vu;
import com.tencent.mm.f.b.a.z;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.h.a.1;
import com.tencent.mm.plugin.backup.h.b;
import com.tencent.mm.plugin.patmsg.d.f;
import com.tencent.mm.plugin.wear.model.e;
import com.tencent.mm.protocal.protobuf.dit;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.ih;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.m;
import com.tencent.wcdb.DatabaseUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.protobuf.ih;>;

public final class d
{
  private static boolean rMB = false;
  private static int rMx = 0;
  private static int rMy = 1;
  private static int rMz = 2;
  private final MultiProcessMMKV cQO;
  private boolean kUn;
  private Object lock;
  private final int rKO;
  private final com.tencent.mm.plugin.backup.b.d rLF;
  private long rLd;
  private z rMA;
  private HashMap<String, Pair<Long, Long>> rMC;
  private a rMD;
  private boolean rME;
  private int rMF;
  public boolean rMp;
  private final HashMap<String, String> rMq;
  private HashSet<String> rMr;
  private final int rMs;
  private final long rMt;
  private long rMu;
  private b.d rMv;
  private int rMw;
  
  public d(com.tencent.mm.plugin.backup.b.d paramd, int paramInt1, b.d paramd1, int paramInt2, boolean paramBoolean, LinkedList<String> paramLinkedList, LinkedList<Long> paramLinkedList1)
  {
    AppMethodBeat.i(21258);
    this.rMp = false;
    this.rMr = new HashSet();
    this.lock = new Object();
    this.rLd = 0L;
    this.rMw = rMx;
    this.rMA = new z();
    this.rMq = bh.beI().bcr().hvC();
    this.rLF = paramd;
    this.rKO = paramInt1;
    this.rMv = paramd1;
    this.rMs = paramInt2;
    rMB = paramBoolean;
    this.rMt = DatabaseUtils.longForQuery(bh.beI().bcr().lvy.hBZ(), "SELECT COUNT(*) FROM BackupRecoverMsgListDataId", null);
    this.rMC = c(paramLinkedList, paramLinkedList1);
    this.rMr.clear();
    this.rMu = 0L;
    this.cQO = MultiProcessMMKV.getMMKV("MMKV_BACKUP");
    Log.i("MicroMsg.BackupRecoverMerger", "BackupRecoverMerger, msgListDataIdHashMap[%d], backupMode[%d], totalMsgList[%d], totalSession[%d], isQuickBackup[%b]", new Object[] { Integer.valueOf(this.rMq.size()), Integer.valueOf(paramInt1), Long.valueOf(this.rMt), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(21258);
  }
  
  /* Error */
  private int a(String arg1, HashMap<String, Integer> paramHashMap, Pair<com.tencent.mm.pointers.PLong, com.tencent.mm.pointers.PLong> paramPair, String paramString2, com.tencent.mm.pointers.PString paramPString, com.tencent.mm.pointers.PBool paramPBool)
  {
    // Byte code:
    //   0: sipush 21261
    //   3: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: iconst_0
    //   8: iconst_m1
    //   9: invokestatic 207	com/tencent/mm/vfs/u:aY	(Ljava/lang/String;II)[B
    //   12: astore 12
    //   14: new 209	com/tencent/mm/protocal/protobuf/ii
    //   17: dup
    //   18: invokespecial 210	com/tencent/mm/protocal/protobuf/ii:<init>	()V
    //   21: aload 12
    //   23: invokevirtual 214	com/tencent/mm/protocal/protobuf/ii:parseFrom	([B)Lcom/tencent/mm/cd/a;
    //   26: checkcast 209	com/tencent/mm/protocal/protobuf/ii
    //   29: astore 16
    //   31: aload 4
    //   33: aload 16
    //   35: getfield 218	com/tencent/mm/protocal/protobuf/ii:rVy	Ljava/util/LinkedList;
    //   38: invokestatic 222	com/tencent/mm/plugin/backup/c/d:k	(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;
    //   41: astore_1
    //   42: iconst_1
    //   43: istore 7
    //   45: ldc 224
    //   47: astore 12
    //   49: aload_1
    //   50: invokeinterface 230 1 0
    //   55: astore 17
    //   57: aload 17
    //   59: invokeinterface 236 1 0
    //   64: ifeq +1049 -> 1113
    //   67: aload 17
    //   69: invokeinterface 240 1 0
    //   74: checkcast 242	com/tencent/mm/protocal/protobuf/ih
    //   77: astore 18
    //   79: aload_0
    //   80: getfield 78	com/tencent/mm/plugin/backup/c/d:lock	Ljava/lang/Object;
    //   83: astore_1
    //   84: aload_1
    //   85: monitorenter
    //   86: aload_0
    //   87: getfield 244	com/tencent/mm/plugin/backup/c/d:kUn	Z
    //   90: ifeq +193 -> 283
    //   93: ldc 158
    //   95: ldc 246
    //   97: invokestatic 250	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_1
    //   101: monitorexit
    //   102: sipush 21261
    //   105: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: iconst_m1
    //   109: ireturn
    //   110: astore 4
    //   112: ldc 224
    //   114: astore_3
    //   115: aload_3
    //   116: astore_2
    //   117: new 252	com/tencent/mm/vfs/q
    //   120: dup
    //   121: aload_1
    //   122: invokespecial 255	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;)V
    //   125: astore 5
    //   127: aload_3
    //   128: astore_2
    //   129: new 257	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   136: ldc 224
    //   138: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload 5
    //   143: invokevirtual 265	com/tencent/mm/vfs/q:ifE	()Z
    //   146: invokevirtual 268	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   149: ldc_w 270
    //   152: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: astore_3
    //   159: aload_3
    //   160: astore_2
    //   161: new 257	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   168: aload_3
    //   169: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload 5
    //   174: invokevirtual 277	com/tencent/mm/vfs/q:ifC	()Z
    //   177: invokevirtual 268	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   180: ldc_w 270
    //   183: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   189: astore_3
    //   190: aload_3
    //   191: astore_2
    //   192: new 257	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 258	java/lang/StringBuilder:<init>	()V
    //   199: aload_3
    //   200: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload 5
    //   205: invokevirtual 281	com/tencent/mm/vfs/q:length	()J
    //   208: invokevirtual 284	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   211: ldc_w 286
    //   214: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: astore_3
    //   221: aload_3
    //   222: astore_2
    //   223: aload 12
    //   225: ifnonnull +50 -> 275
    //   228: iconst_m1
    //   229: istore 7
    //   231: ldc 158
    //   233: aload 4
    //   235: ldc_w 288
    //   238: iconst_4
    //   239: anewarray 4	java/lang/Object
    //   242: dup
    //   243: iconst_0
    //   244: aload_1
    //   245: aastore
    //   246: dup
    //   247: iconst_1
    //   248: aload_2
    //   249: aastore
    //   250: dup
    //   251: iconst_2
    //   252: iload 7
    //   254: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: dup
    //   259: iconst_3
    //   260: aload 4
    //   262: aastore
    //   263: invokestatic 292	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   266: sipush 21261
    //   269: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: bipush 254
    //   274: ireturn
    //   275: aload 12
    //   277: arraylength
    //   278: istore 7
    //   280: goto -49 -> 231
    //   283: aload_1
    //   284: monitorexit
    //   285: getstatic 58	com/tencent/mm/plugin/backup/c/d:rMB	Z
    //   288: ifeq +12 -> 300
    //   291: aload 18
    //   293: getfield 295	com/tencent/mm/protocal/protobuf/ih:rWu	I
    //   296: iconst_1
    //   297: if_icmpne -240 -> 57
    //   300: aload 6
    //   302: getfield 300	com/tencent/mm/pointers/PBool:value	Z
    //   305: ifeq +47 -> 352
    //   308: aconst_null
    //   309: astore_1
    //   310: iload 7
    //   312: ifeq +175 -> 487
    //   315: aload_1
    //   316: ifnull +171 -> 487
    //   319: aload_1
    //   320: getfield 306	com/tencent/mm/f/c/et:field_talker	Ljava/lang/String;
    //   323: astore_1
    //   324: iconst_0
    //   325: istore 7
    //   327: aload 18
    //   329: getfield 295	com/tencent/mm/protocal/protobuf/ih:rWu	I
    //   332: invokestatic 311	com/tencent/mm/plugin/backup/c/e:EE	(I)V
    //   335: aload_1
    //   336: astore 12
    //   338: goto -281 -> 57
    //   341: astore_2
    //   342: aload_1
    //   343: monitorexit
    //   344: sipush 21261
    //   347: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   350: aload_2
    //   351: athrow
    //   352: aload 18
    //   354: getfield 315	com/tencent/mm/protocal/protobuf/ih:RID	Lcom/tencent/mm/protocal/protobuf/eaf;
    //   357: getfield 320	com/tencent/mm/protocal/protobuf/eaf:Ufy	Ljava/lang/String;
    //   360: astore 14
    //   362: aload 18
    //   364: getfield 323	com/tencent/mm/protocal/protobuf/ih:RIE	Lcom/tencent/mm/protocal/protobuf/eaf;
    //   367: getfield 320	com/tencent/mm/protocal/protobuf/eaf:Ufy	Ljava/lang/String;
    //   370: astore 13
    //   372: aload 14
    //   374: invokestatic 329	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   377: ifne +11 -> 388
    //   380: aload 13
    //   382: invokestatic 329	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   385: ifeq +45 -> 430
    //   388: aload 14
    //   390: astore_1
    //   391: aload 14
    //   393: ifnonnull +772 -> 1165
    //   396: ldc_w 331
    //   399: astore_1
    //   400: goto +765 -> 1165
    //   403: ldc_w 333
    //   406: ldc_w 335
    //   409: iconst_2
    //   410: anewarray 4	java/lang/Object
    //   413: dup
    //   414: iconst_0
    //   415: aload_1
    //   416: aastore
    //   417: dup
    //   418: iconst_1
    //   419: aload 14
    //   421: aastore
    //   422: invokestatic 338	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   425: aconst_null
    //   426: astore_1
    //   427: goto -117 -> 310
    //   430: aload 4
    //   432: aload 14
    //   434: invokevirtual 344	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   437: ifne +745 -> 1182
    //   440: invokestatic 350	com/tencent/mm/plugin/backup/h/d:cua	()Lcom/tencent/mm/plugin/backup/h/d;
    //   443: invokevirtual 354	com/tencent/mm/plugin/backup/h/d:cub	()Lcom/tencent/mm/plugin/backup/h/b;
    //   446: astore_1
    //   447: aload_1
    //   448: getfield 359	com/tencent/mm/plugin/backup/h/b:uin	I
    //   451: ifne +42 -> 493
    //   454: new 361	com/tencent/mm/model/b
    //   457: dup
    //   458: invokespecial 362	com/tencent/mm/model/b:<init>	()V
    //   461: astore_1
    //   462: sipush 21261
    //   465: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   468: aload_1
    //   469: athrow
    //   470: astore_1
    //   471: ldc 158
    //   473: ldc_w 364
    //   476: iconst_1
    //   477: anewarray 4	java/lang/Object
    //   480: dup
    //   481: iconst_0
    //   482: aload_1
    //   483: aastore
    //   484: invokestatic 366	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   487: aload 12
    //   489: astore_1
    //   490: goto -163 -> 327
    //   493: aload_1
    //   494: getfield 370	com/tencent/mm/plugin/backup/h/b:rSy	Lcom/tencent/mm/plugin/messenger/foundation/a/a/l;
    //   497: aload 14
    //   499: invokeinterface 375 2 0
    //   504: ifeq +696 -> 1200
    //   507: goto +675 -> 1182
    //   510: aload 5
    //   512: ifnull +14 -> 526
    //   515: aload 5
    //   517: getfield 379	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   520: invokestatic 329	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   523: ifeq +636 -> 1159
    //   526: aload 5
    //   528: ifnonnull +625 -> 1153
    //   531: new 377	com/tencent/mm/pointers/PString
    //   534: dup
    //   535: invokespecial 380	com/tencent/mm/pointers/PString:<init>	()V
    //   538: astore_1
    //   539: goto +649 -> 1188
    //   542: aload_1
    //   543: aload 15
    //   545: putfield 379	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   548: invokestatic 350	com/tencent/mm/plugin/backup/h/d:cua	()Lcom/tencent/mm/plugin/backup/h/d;
    //   551: invokevirtual 354	com/tencent/mm/plugin/backup/h/d:cub	()Lcom/tencent/mm/plugin/backup/h/b;
    //   554: invokevirtual 384	com/tencent/mm/plugin/backup/h/b:bbL	()Lcom/tencent/mm/storage/bv;
    //   557: aload_1
    //   558: getfield 379	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   561: invokeinterface 390 2 0
    //   566: astore 15
    //   568: invokestatic 396	com/tencent/mm/plugin/backup/b/g:csq	()Ljava/util/List;
    //   571: aload_1
    //   572: getfield 379	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   575: invokeinterface 399 2 0
    //   580: ifne +27 -> 607
    //   583: aload 15
    //   585: ifnull +628 -> 1213
    //   588: aload 15
    //   590: getfield 404	com/tencent/mm/f/c/ax:field_username	Ljava/lang/String;
    //   593: invokestatic 329	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   596: ifne +617 -> 1213
    //   599: aload 15
    //   601: invokevirtual 409	com/tencent/mm/storage/as:hxX	()Z
    //   604: ifeq +609 -> 1213
    //   607: ldc_w 333
    //   610: new 257	java/lang/StringBuilder
    //   613: dup
    //   614: ldc_w 411
    //   617: invokespecial 412	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   620: aload_1
    //   621: getfield 379	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   624: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   627: invokevirtual 274	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 414	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   633: aload 6
    //   635: iconst_1
    //   636: putfield 300	com/tencent/mm/pointers/PBool:value	Z
    //   639: aconst_null
    //   640: astore_1
    //   641: goto -331 -> 310
    //   644: aload 18
    //   646: getfield 417	com/tencent/mm/protocal/protobuf/ih:HlH	J
    //   649: lconst_0
    //   650: lcmp
    //   651: ifne +22 -> 673
    //   654: aload 18
    //   656: getfield 420	com/tencent/mm/protocal/protobuf/ih:HlE	I
    //   659: ifeq +14 -> 673
    //   662: aload 18
    //   664: aload 18
    //   666: getfield 420	com/tencent/mm/protocal/protobuf/ih:HlE	I
    //   669: i2l
    //   670: putfield 417	com/tencent/mm/protocal/protobuf/ih:HlH	J
    //   673: aload 18
    //   675: getfield 417	com/tencent/mm/protocal/protobuf/ih:HlH	J
    //   678: lconst_0
    //   679: lcmp
    //   680: ifeq +77 -> 757
    //   683: invokestatic 350	com/tencent/mm/plugin/backup/h/d:cua	()Lcom/tencent/mm/plugin/backup/h/d;
    //   686: invokevirtual 354	com/tencent/mm/plugin/backup/h/d:cub	()Lcom/tencent/mm/plugin/backup/h/b;
    //   689: invokevirtual 424	com/tencent/mm/plugin/backup/h/b:bbO	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
    //   692: aload_1
    //   693: getfield 379	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   696: aload 18
    //   698: getfield 417	com/tencent/mm/protocal/protobuf/ih:HlH	J
    //   701: invokeinterface 430 4 0
    //   706: astore 15
    //   708: aload 15
    //   710: getfield 433	com/tencent/mm/f/c/et:field_msgId	J
    //   713: lconst_0
    //   714: lcmp
    //   715: ifeq +56 -> 771
    //   718: ldc_w 333
    //   721: ldc_w 435
    //   724: iconst_3
    //   725: anewarray 4	java/lang/Object
    //   728: dup
    //   729: iconst_0
    //   730: aload 18
    //   732: getfield 295	com/tencent/mm/protocal/protobuf/ih:rWu	I
    //   735: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   738: aastore
    //   739: dup
    //   740: iconst_1
    //   741: aload 14
    //   743: aastore
    //   744: dup
    //   745: iconst_2
    //   746: aload 13
    //   748: aastore
    //   749: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   752: aconst_null
    //   753: astore_1
    //   754: goto -444 -> 310
    //   757: ldc_w 333
    //   760: ldc_w 437
    //   763: invokestatic 414	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   766: aconst_null
    //   767: astore_1
    //   768: goto -458 -> 310
    //   771: ldc_w 333
    //   774: ldc_w 439
    //   777: iconst_3
    //   778: anewarray 4	java/lang/Object
    //   781: dup
    //   782: iconst_0
    //   783: aload 18
    //   785: getfield 295	com/tencent/mm/protocal/protobuf/ih:rWu	I
    //   788: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   791: aastore
    //   792: dup
    //   793: iconst_1
    //   794: aload 14
    //   796: aastore
    //   797: dup
    //   798: iconst_2
    //   799: aload 13
    //   801: aastore
    //   802: invokestatic 187	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   805: aload 15
    //   807: aload 18
    //   809: getfield 417	com/tencent/mm/protocal/protobuf/ih:HlH	J
    //   812: invokevirtual 445	com/tencent/mm/storage/ca:EG	(J)V
    //   815: aload 15
    //   817: aload 18
    //   819: getfield 448	com/tencent/mm/protocal/protobuf/ih:RNP	I
    //   822: i2l
    //   823: invokevirtual 451	com/tencent/mm/storage/ca:EI	(J)V
    //   826: aload 18
    //   828: getfield 454	com/tencent/mm/protocal/protobuf/ih:RNQ	J
    //   831: lconst_0
    //   832: lcmp
    //   833: ifeq +217 -> 1050
    //   836: aload 18
    //   838: getfield 454	com/tencent/mm/protocal/protobuf/ih:RNQ	J
    //   841: lstore 10
    //   843: lload 10
    //   845: aload_3
    //   846: getfield 459	android/util/Pair:first	Ljava/lang/Object;
    //   849: checkcast 461	com/tencent/mm/pointers/PLong
    //   852: getfield 463	com/tencent/mm/pointers/PLong:value	J
    //   855: lcmp
    //   856: ifeq +209 -> 1065
    //   859: aload_3
    //   860: getfield 459	android/util/Pair:first	Ljava/lang/Object;
    //   863: checkcast 461	com/tencent/mm/pointers/PLong
    //   866: lload 10
    //   868: putfield 463	com/tencent/mm/pointers/PLong:value	J
    //   871: aload_3
    //   872: getfield 466	android/util/Pair:second	Ljava/lang/Object;
    //   875: checkcast 461	com/tencent/mm/pointers/PLong
    //   878: lload 10
    //   880: putfield 463	com/tencent/mm/pointers/PLong:value	J
    //   883: aload 15
    //   885: lload 10
    //   887: invokevirtual 469	com/tencent/mm/storage/ca:setCreateTime	(J)V
    //   890: aload 15
    //   892: aload 18
    //   894: getfield 472	com/tencent/mm/protocal/protobuf/ih:RNR	I
    //   897: invokevirtual 475	com/tencent/mm/storage/ca:setFlag	(I)V
    //   900: aload 15
    //   902: aload 18
    //   904: getfield 295	com/tencent/mm/protocal/protobuf/ih:rWu	I
    //   907: invokevirtual 478	com/tencent/mm/storage/ca:setType	(I)V
    //   910: iload 8
    //   912: ifeq +304 -> 1216
    //   915: iconst_1
    //   916: istore 9
    //   918: aload 15
    //   920: iload 9
    //   922: invokevirtual 481	com/tencent/mm/storage/ca:pJ	(I)V
    //   925: aload 15
    //   927: aload_1
    //   928: getfield 379	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   931: invokevirtual 484	com/tencent/mm/storage/ca:Jm	(Ljava/lang/String;)V
    //   934: iload 8
    //   936: ifeq +286 -> 1222
    //   939: aload 18
    //   941: getfield 487	com/tencent/mm/protocal/protobuf/ih:RNH	I
    //   944: istore 9
    //   946: aload 15
    //   948: iload 9
    //   950: invokevirtual 490	com/tencent/mm/storage/ca:setStatus	(I)V
    //   953: aload_2
    //   954: aload_1
    //   955: getfield 379	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   958: invokevirtual 494	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   961: ifnonnull +16 -> 977
    //   964: aload_2
    //   965: aload_1
    //   966: getfield 379	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   969: iconst_0
    //   970: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   973: invokevirtual 498	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   976: pop
    //   977: iload 8
    //   979: ifne +41 -> 1020
    //   982: aload 18
    //   984: getfield 487	com/tencent/mm/protocal/protobuf/ih:RNH	I
    //   987: iconst_3
    //   988: if_icmpne +32 -> 1020
    //   991: aload_2
    //   992: aload_1
    //   993: getfield 379	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   996: aload_2
    //   997: aload_1
    //   998: getfield 379	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   1001: invokevirtual 494	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1004: checkcast 168	java/lang/Integer
    //   1007: iconst_0
    //   1008: invokestatic 502	com/tencent/mm/sdk/platformtools/Util:nullAs	(Ljava/lang/Integer;I)I
    //   1011: iconst_1
    //   1012: iadd
    //   1013: invokestatic 172	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1016: invokevirtual 498	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1019: pop
    //   1020: invokestatic 508	com/tencent/mm/plugin/backup/f/c:cti	()Lcom/tencent/mm/plugin/backup/f/c;
    //   1023: aload 18
    //   1025: getfield 295	com/tencent/mm/protocal/protobuf/ih:rWu	I
    //   1028: invokevirtual 511	com/tencent/mm/plugin/backup/f/c:EI	(I)Lcom/tencent/mm/plugin/backup/f/l;
    //   1031: astore_1
    //   1032: aload_1
    //   1033: ifnonnull +61 -> 1094
    //   1036: ldc_w 333
    //   1039: ldc_w 513
    //   1042: invokestatic 515	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1045: aconst_null
    //   1046: astore_1
    //   1047: goto -737 -> 310
    //   1050: aload 18
    //   1052: getfield 518	com/tencent/mm/protocal/protobuf/ih:RNI	I
    //   1055: i2l
    //   1056: ldc2_w 519
    //   1059: lmul
    //   1060: lstore 10
    //   1062: goto -219 -> 843
    //   1065: aload_3
    //   1066: getfield 466	android/util/Pair:second	Ljava/lang/Object;
    //   1069: checkcast 461	com/tencent/mm/pointers/PLong
    //   1072: getfield 463	com/tencent/mm/pointers/PLong:value	J
    //   1075: lconst_1
    //   1076: ladd
    //   1077: lstore 10
    //   1079: aload_3
    //   1080: getfield 466	android/util/Pair:second	Ljava/lang/Object;
    //   1083: checkcast 461	com/tencent/mm/pointers/PLong
    //   1086: lload 10
    //   1088: putfield 463	com/tencent/mm/pointers/PLong:value	J
    //   1091: goto -208 -> 883
    //   1094: aload_1
    //   1095: aload 4
    //   1097: aload 18
    //   1099: aload 15
    //   1101: invokeinterface 525 4 0
    //   1106: pop
    //   1107: aload 15
    //   1109: astore_1
    //   1110: goto -800 -> 310
    //   1113: invokestatic 528	com/tencent/mm/plugin/backup/c/e:csB	()V
    //   1116: ldc_w 530
    //   1119: invokestatic 536	com/tencent/mm/kernel/h:ag	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   1122: checkcast 530	com/tencent/mm/chatroom/plugin/PluginChatroomUI
    //   1125: aload 12
    //   1127: invokevirtual 539	com/tencent/mm/chatroom/plugin/PluginChatroomUI:handleChatroomBackup	(Ljava/lang/String;)V
    //   1130: aload 16
    //   1132: getfield 218	com/tencent/mm/protocal/protobuf/ii:rVy	Ljava/util/LinkedList;
    //   1135: invokevirtual 542	java/util/LinkedList:size	()I
    //   1138: istore 7
    //   1140: sipush 21261
    //   1143: invokestatic 190	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1146: iload 7
    //   1148: ireturn
    //   1149: astore_3
    //   1150: goto -927 -> 223
    //   1153: aload 5
    //   1155: astore_1
    //   1156: goto +32 -> 1188
    //   1159: aload 5
    //   1161: astore_1
    //   1162: goto -518 -> 644
    //   1165: aload 13
    //   1167: astore 14
    //   1169: aload 13
    //   1171: ifnonnull -768 -> 403
    //   1174: ldc_w 331
    //   1177: astore 14
    //   1179: goto -776 -> 403
    //   1182: iconst_1
    //   1183: istore 8
    //   1185: goto -675 -> 510
    //   1188: iload 8
    //   1190: ifeq +16 -> 1206
    //   1193: aload 13
    //   1195: astore 15
    //   1197: goto -655 -> 542
    //   1200: iconst_0
    //   1201: istore 8
    //   1203: goto -693 -> 510
    //   1206: aload 14
    //   1208: astore 15
    //   1210: goto -668 -> 542
    //   1213: goto -569 -> 644
    //   1216: iconst_0
    //   1217: istore 9
    //   1219: goto -301 -> 918
    //   1222: iconst_4
    //   1223: istore 9
    //   1225: goto -279 -> 946
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1228	0	this	d
    //   0	1228	2	paramHashMap	HashMap<String, Integer>
    //   0	1228	3	paramPair	Pair<com.tencent.mm.pointers.PLong, com.tencent.mm.pointers.PLong>
    //   0	1228	4	paramString2	String
    //   0	1228	5	paramPString	com.tencent.mm.pointers.PString
    //   0	1228	6	paramPBool	com.tencent.mm.pointers.PBool
    //   43	1104	7	i	int
    //   910	292	8	j	int
    //   916	308	9	k	int
    //   841	246	10	l	long
    //   12	1114	12	localObject1	Object
    //   370	824	13	str	String
    //   360	847	14	localObject2	Object
    //   543	666	15	localObject3	Object
    //   29	1102	16	localii	com.tencent.mm.protocal.protobuf.ii
    //   55	13	17	localIterator	Iterator
    //   77	1021	18	localih	ih
    // Exception table:
    //   from	to	target	type
    //   14	31	110	java/lang/Exception
    //   86	102	341	finally
    //   300	308	470	java/lang/Exception
    //   319	324	470	java/lang/Exception
    //   352	388	470	java/lang/Exception
    //   403	425	470	java/lang/Exception
    //   430	470	470	java/lang/Exception
    //   493	507	470	java/lang/Exception
    //   515	526	470	java/lang/Exception
    //   531	539	470	java/lang/Exception
    //   542	583	470	java/lang/Exception
    //   588	607	470	java/lang/Exception
    //   607	639	470	java/lang/Exception
    //   644	673	470	java/lang/Exception
    //   673	752	470	java/lang/Exception
    //   757	766	470	java/lang/Exception
    //   771	843	470	java/lang/Exception
    //   843	883	470	java/lang/Exception
    //   883	910	470	java/lang/Exception
    //   918	934	470	java/lang/Exception
    //   939	946	470	java/lang/Exception
    //   946	977	470	java/lang/Exception
    //   982	1020	470	java/lang/Exception
    //   1020	1032	470	java/lang/Exception
    //   1036	1045	470	java/lang/Exception
    //   1050	1062	470	java/lang/Exception
    //   1065	1091	470	java/lang/Exception
    //   1094	1107	470	java/lang/Exception
    //   117	127	1149	java/lang/Exception
    //   129	159	1149	java/lang/Exception
    //   161	190	1149	java/lang/Exception
    //   192	221	1149	java/lang/Exception
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
  
  /* Error */
  private boolean csu()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 71	com/tencent/mm/plugin/backup/c/d:rMp	Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 71	com/tencent/mm/plugin/backup/c/d:rMp	Z
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
  
  private void csv()
  {
    try
    {
      this.rMp = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void csw()
  {
    AppMethodBeat.i(21264);
    Log.i("MicroMsg.BackupRecoverMerger", "backupFinishMerge");
    EventCenter.instance.publish(new ce());
    EventCenter.instance.publish(new af());
    Object localObject = com.tencent.mm.plugin.backup.h.d.cua().cuc();
    ((com.tencent.mm.plugin.backup.h.a)localObject).handler.post(new a.1((com.tencent.mm.plugin.backup.h.a)localObject));
    bh.beI();
    c.bbO().eSo();
    EventCenter.instance.publish(new vu());
    CrashReportFactory.setBackupMerge(false);
    ((com.tencent.mm.plugin.priority.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.priority.a.a.class)).registerMsgInfoStgNotify();
    localObject = com.tencent.mm.plugin.wear.model.a.gOq();
    bh.beI();
    c.bbO().a(((e)localObject).wse, null);
    AppMethodBeat.o(21264);
  }
  
  public static void csx()
  {
    AppMethodBeat.i(21265);
    com.tencent.mm.plugin.backup.h.d.cua().cub().bbO().aOC("BACKUP_MERGE_LOCK");
    AppMethodBeat.o(21265);
  }
  
  public static void csy()
  {
    AppMethodBeat.i(21266);
    com.tencent.mm.plugin.backup.h.d.cua().cub().bbO().aOD("BACKUP_MERGE_LOCK");
    AppMethodBeat.o(21266);
  }
  
  private static List<ih> k(String paramString, List<ih> paramList)
  {
    AppMethodBeat.i(281048);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      ih localih = (ih)localIterator.next();
      if (localih.rWu == 49)
      {
        if (k.b.OQ(localih.RIF.Ufy) != null) {
          break label187;
        }
        l = localih.HlH;
        if (localih.RIF.Ufy != null) {
          break label174;
        }
        localObject = "null";
        Log.e("MicroMsg.BackupRecoverMerger", "checkPatMsg error content null. msgid:%d, content:%s", new Object[] { Long.valueOf(l), localObject });
      }
      label174:
      label187:
      while (k.b.OQ(localih.RIF.Ufy).type != 62) {
        for (;;)
        {
          long l;
          localObject = paramList;
          if (paramList != null)
          {
            localObject = paramList;
            if (!paramList.isEmpty())
            {
              paramList = l(paramString, paramList);
              if (paramList != null) {
                localLinkedList.add(paramList);
              }
              localObject = null;
            }
          }
          localLinkedList.add(localih);
          paramList = (List<ih>)localObject;
          break;
          localObject = localih.RIF.Ufy;
        }
      }
      Object localObject = paramList;
      if (paramList == null) {
        localObject = new LinkedList();
      }
      ((List)localObject).add(localih);
      paramList = (List<ih>)localObject;
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramString = l(paramString, paramList);
      if (paramString != null) {
        localLinkedList.add(paramString);
      }
    }
    AppMethodBeat.o(281048);
    return localLinkedList;
  }
  
  private static ih l(String paramString, List<ih> paramList)
  {
    AppMethodBeat.i(281049);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ih localih = (ih)paramList.get(0);
      dit localdit1 = new dit();
      localdit1.iRq = paramString;
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (ih)paramString.next();
        dit localdit2 = com.tencent.mm.util.g.bBr(paramList.RIF.Ufy);
        Log.d("MicroMsg.BackupRecoverMerger", "find %s pat record in msg", new Object[] { paramList.RJQ });
        localdit1.Ezu.addAll(localdit2.Ezu);
      }
      paramString = new k.b();
      paramList = new com.tencent.mm.plugin.patmsg.a.a();
      paramList.GKw = localdit1;
      paramString.a(paramList);
      paramString.type = 62;
      paramString.title = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_tip);
      paramString.url = MMApplicationContext.getContext().getString(d.f.low_version_upgrade_url);
      paramList = new eaf();
      paramList.btQ(Util.nullAs(k.b.a(paramString, "", null), ""));
      localih.RIF = paramList;
      AppMethodBeat.o(281049);
      return localih;
    }
    AppMethodBeat.o(281049);
    return null;
  }
  
  public final void C(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(21262);
    synchronized (this.lock)
    {
      Log.i("MicroMsg.BackupRecoverMerger", "cancel, needClearContinueRecoverData[%b], mergeState[%d], updateState[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.rMw), Integer.valueOf(paramInt) });
      this.kUn = true;
      this.rME = paramBoolean;
      this.rMF = paramInt;
      bh.getNotification().dH(false);
      this.rLF.csb();
      this.rMv = null;
      AppMethodBeat.o(21262);
      return;
    }
  }
  
  public final void ED(int paramInt)
  {
    AppMethodBeat.i(21263);
    if (this.rMv != null) {
      this.rMv.EB(paramInt);
    }
    AppMethodBeat.o(21263);
  }
  
  public final void kK(final boolean paramBoolean)
  {
    AppMethodBeat.i(21260);
    if (csu())
    {
      Log.e("MicroMsg.BackupRecoverMerger", "Already start merge, return.");
      AppMethodBeat.o(21260);
      return;
    }
    Log.i("MicroMsg.BackupRecoverMerger", "startMerge");
    this.rLd = 0L;
    CrashReportFactory.setBackupMerge(true);
    this.rLF.csa();
    bh.getNotification().dH(true);
    ((com.tencent.mm.plugin.priority.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.priority.a.a.class)).unregisterMsgInfoStgNotify();
    e locale = com.tencent.mm.plugin.wear.model.a.gOq();
    bh.beI();
    c.bbO().a(locale.wse);
    this.rMw = rMy;
    if (this.rKO == 1)
    {
      bh.beI();
      c.aHp().set(ar.a.VnE, Boolean.TRUE);
    }
    for (;;)
    {
      this.cQO.encode("MMKV_BACKUP_TRY_TIME", this.cQO.getInt("MMKV_BACKUP_TRY_TIME", 0) + 1);
      this.cQO.encode("MMKV_BACKUP_NEED_REPORT", true);
      Log.i("MicroMsg.BackupRecoverMerger", "startMergeImpl start, mergeState[%d], totalMsgList[%d], msgListDataIdHashMap[%d]", new Object[] { Integer.valueOf(this.rMw), Long.valueOf(this.rMt), Integer.valueOf(this.rMq.size()) });
      com.tencent.e.h.ZvG.bh(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "BackupRecoverMerger";
        }
        
        /* Error */
        public final void run()
        {
          // Byte code:
          //   0: sipush 21256
          //   3: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
          //   6: invokestatic 42	com/tencent/mm/plugin/backup/c/e:reset	()V
          //   9: invokestatic 45	com/tencent/mm/plugin/backup/c/e:csC	()V
          //   12: getstatic 50	com/tencent/mm/plugin/backup/b/g:rLl	Z
          //   15: ifeq +45 -> 60
          //   18: aload_0
          //   19: getfield 18	com/tencent/mm/plugin/backup/c/d$1:rMG	Z
          //   22: ifeq +38 -> 60
          //   25: invokestatic 53	com/tencent/mm/plugin/backup/b/g:csn	()Ljava/lang/String;
          //   28: invokestatic 59	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
          //   31: ifeq +29 -> 60
          //   34: invokestatic 53	com/tencent/mm/plugin/backup/b/g:csn	()Ljava/lang/String;
          //   37: iconst_0
          //   38: invokestatic 63	com/tencent/mm/vfs/u:dP	(Ljava/lang/String;Z)Ljava/lang/Iterable;
          //   41: ifnull +19 -> 60
          //   44: invokestatic 66	com/tencent/mm/plugin/backup/b/g:csm	()Ljava/lang/String;
          //   47: invokestatic 70	com/tencent/mm/plugin/backup/b/g:aoa	(Ljava/lang/String;)V
          //   50: invokestatic 53	com/tencent/mm/plugin/backup/b/g:csn	()Ljava/lang/String;
          //   53: invokestatic 66	com/tencent/mm/plugin/backup/b/g:csm	()Ljava/lang/String;
          //   56: invokestatic 74	com/tencent/mm/vfs/u:oq	(Ljava/lang/String;Ljava/lang/String;)Z
          //   59: pop
          //   60: new 76	java/util/HashMap
          //   63: dup
          //   64: invokespecial 77	java/util/HashMap:<init>	()V
          //   67: astore 12
          //   69: invokestatic 83	com/tencent/mm/plugin/backup/h/d:cua	()Lcom/tencent/mm/plugin/backup/h/d;
          //   72: invokevirtual 87	com/tencent/mm/plugin/backup/h/d:cub	()Lcom/tencent/mm/plugin/backup/h/b;
          //   75: invokevirtual 93	com/tencent/mm/plugin/backup/h/b:aHp	()Lcom/tencent/mm/storage/ao;
          //   78: iconst_2
          //   79: aconst_null
          //   80: invokevirtual 99	com/tencent/mm/storage/ao:b	(ILjava/lang/Object;)Ljava/lang/Object;
          //   83: checkcast 101	java/lang/String
          //   86: astore 13
          //   88: aload_0
          //   89: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   92: invokestatic 104	com/tencent/mm/plugin/backup/c/d:b	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/f/b/a/z;
          //   95: aload_0
          //   96: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   99: invokestatic 108	com/tencent/mm/plugin/backup/c/d:a	(Lcom/tencent/mm/plugin/backup/c/d;)I
          //   102: putfield 114	com/tencent/mm/f/b/a/z:ggl	I
          //   105: aload_0
          //   106: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   109: invokestatic 104	com/tencent/mm/plugin/backup/c/d:b	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/f/b/a/z;
          //   112: iconst_1
          //   113: putfield 117	com/tencent/mm/f/b/a/z:ggm	I
          //   116: aload_0
          //   117: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   120: invokestatic 104	com/tencent/mm/plugin/backup/c/d:b	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/f/b/a/z;
          //   123: aload_0
          //   124: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   127: invokestatic 121	com/tencent/mm/plugin/backup/c/d:c	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
          //   130: ldc 123
          //   132: iconst_0
          //   133: invokevirtual 129	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getInt	(Ljava/lang/String;I)I
          //   136: putfield 132	com/tencent/mm/f/b/a/z:ggn	I
          //   139: aload_0
          //   140: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   143: invokestatic 104	com/tencent/mm/plugin/backup/c/d:b	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/f/b/a/z;
          //   146: aload_0
          //   147: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   150: invokestatic 135	com/tencent/mm/plugin/backup/c/d:d	(Lcom/tencent/mm/plugin/backup/c/d;)I
          //   153: putfield 138	com/tencent/mm/f/b/a/z:ggp	I
          //   156: aload_0
          //   157: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   160: invokestatic 142	com/tencent/mm/plugin/backup/c/d:e	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashMap;
          //   163: invokevirtual 146	java/util/HashMap:keySet	()Ljava/util/Set;
          //   166: invokeinterface 152 1 0
          //   171: astore 14
          //   173: lconst_0
          //   174: lstore_2
          //   175: aload 14
          //   177: invokeinterface 158 1 0
          //   182: ifeq +1695 -> 1877
          //   185: aload 14
          //   187: invokeinterface 162 1 0
          //   192: checkcast 101	java/lang/String
          //   195: astore 11
          //   197: invokestatic 168	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
          //   200: lstore 6
          //   202: invokestatic 171	com/tencent/mm/plugin/backup/c/d:csx	()V
          //   205: aload_0
          //   206: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   209: invokestatic 175	com/tencent/mm/plugin/backup/c/d:f	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/c/d$a;
          //   212: astore 10
          //   214: invokestatic 83	com/tencent/mm/plugin/backup/h/d:cua	()Lcom/tencent/mm/plugin/backup/h/d;
          //   217: invokevirtual 87	com/tencent/mm/plugin/backup/h/d:cub	()Lcom/tencent/mm/plugin/backup/h/b;
          //   220: getfield 179	com/tencent/mm/plugin/backup/h/b:kcF	Lcom/tencent/mm/storagebase/h;
          //   223: ifnull +32 -> 255
          //   226: aload 10
          //   228: invokestatic 83	com/tencent/mm/plugin/backup/h/d:cua	()Lcom/tencent/mm/plugin/backup/h/d;
          //   231: invokevirtual 87	com/tencent/mm/plugin/backup/h/d:cub	()Lcom/tencent/mm/plugin/backup/h/b;
          //   234: getfield 179	com/tencent/mm/plugin/backup/h/b:kcF	Lcom/tencent/mm/storagebase/h;
          //   237: invokestatic 185	java/lang/Thread:currentThread	()Ljava/lang/Thread;
          //   240: invokevirtual 188	java/lang/Thread:getId	()J
          //   243: invokevirtual 194	com/tencent/mm/storagebase/h:beginTransaction	(J)J
          //   246: putfield 200	com/tencent/mm/plugin/backup/c/d$a:rMI	J
          //   249: aload 10
          //   251: iconst_1
          //   252: putfield 203	com/tencent/mm/plugin/backup/c/d$a:jVu	Z
          //   255: new 205	java/lang/StringBuilder
          //   258: dup
          //   259: invokespecial 206	java/lang/StringBuilder:<init>	()V
          //   262: aload 11
          //   264: invokestatic 210	com/tencent/mm/plugin/backup/b/g:aob	(Ljava/lang/String;)Ljava/lang/String;
          //   267: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   270: aload 11
          //   272: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   275: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   278: astore 10
          //   280: new 219	com/tencent/mm/pointers/PString
          //   283: dup
          //   284: invokespecial 220	com/tencent/mm/pointers/PString:<init>	()V
          //   287: astore 15
          //   289: new 222	com/tencent/mm/pointers/PBool
          //   292: dup
          //   293: invokespecial 223	com/tencent/mm/pointers/PBool:<init>	()V
          //   296: astore 16
          //   298: new 225	android/util/Pair
          //   301: dup
          //   302: new 227	com/tencent/mm/pointers/PLong
          //   305: dup
          //   306: ldc2_w 228
          //   309: invokespecial 232	com/tencent/mm/pointers/PLong:<init>	(J)V
          //   312: new 227	com/tencent/mm/pointers/PLong
          //   315: dup
          //   316: ldc2_w 228
          //   319: invokespecial 232	com/tencent/mm/pointers/PLong:<init>	(J)V
          //   322: invokespecial 235	android/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
          //   325: astore 17
          //   327: aload_0
          //   328: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   331: aload 10
          //   333: aload 12
          //   335: aload 17
          //   337: aload 13
          //   339: aload 15
          //   341: aload 16
          //   343: invokestatic 238	com/tencent/mm/plugin/backup/c/d:a	(Lcom/tencent/mm/plugin/backup/c/d;Ljava/lang/String;Ljava/util/HashMap;Landroid/util/Pair;Ljava/lang/String;Lcom/tencent/mm/pointers/PString;Lcom/tencent/mm/pointers/PBool;)I
          //   346: istore_1
          //   347: iload_1
          //   348: i2l
          //   349: lstore_2
          //   350: lload_2
          //   351: lstore 4
          //   353: aload_0
          //   354: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   357: invokestatic 242	com/tencent/mm/plugin/backup/c/d:g	(Lcom/tencent/mm/plugin/backup/c/d;)Z
          //   360: ifeq +464 -> 824
          //   363: lload_2
          //   364: lstore 4
          //   366: ldc 244
          //   368: ldc 246
          //   370: iconst_5
          //   371: anewarray 4	java/lang/Object
          //   374: dup
          //   375: iconst_0
          //   376: aload 11
          //   378: aastore
          //   379: dup
          //   380: iconst_1
          //   381: aload_0
          //   382: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   385: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   388: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   391: aastore
          //   392: dup
          //   393: iconst_2
          //   394: aload_0
          //   395: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   398: invokestatic 258	com/tencent/mm/plugin/backup/c/d:i	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   401: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   404: aastore
          //   405: dup
          //   406: iconst_3
          //   407: aload_0
          //   408: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   411: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   414: invokevirtual 268	java/util/HashSet:size	()I
          //   417: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   420: aastore
          //   421: dup
          //   422: iconst_4
          //   423: aload_0
          //   424: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   427: invokestatic 135	com/tencent/mm/plugin/backup/c/d:d	(Lcom/tencent/mm/plugin/backup/c/d;)I
          //   430: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   433: aastore
          //   434: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   437: lload_2
          //   438: lstore 4
          //   440: aload_0
          //   441: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   444: invokestatic 175	com/tencent/mm/plugin/backup/c/d:f	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/c/d$a;
          //   447: invokevirtual 281	com/tencent/mm/plugin/backup/c/d$a:end	()V
          //   450: lload_2
          //   451: lstore 4
          //   453: invokestatic 284	com/tencent/mm/plugin/backup/c/d:csy	()V
          //   456: lload_2
          //   457: lstore 4
          //   459: aload 12
          //   461: invokestatic 289	com/tencent/mm/plugin/backup/h/c:i	(Ljava/util/HashMap;)V
          //   464: lload_2
          //   465: lstore 4
          //   467: aload_0
          //   468: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   471: aload_0
          //   472: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   475: invokestatic 292	com/tencent/mm/plugin/backup/c/d:k	(Lcom/tencent/mm/plugin/backup/c/d;)Z
          //   478: aload_0
          //   479: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   482: invokestatic 295	com/tencent/mm/plugin/backup/c/d:l	(Lcom/tencent/mm/plugin/backup/c/d;)I
          //   485: invokestatic 298	com/tencent/mm/plugin/backup/c/d:a	(Lcom/tencent/mm/plugin/backup/c/d;ZI)V
          //   488: aload_0
          //   489: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   492: astore 10
          //   494: aload_0
          //   495: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   498: invokestatic 301	com/tencent/mm/plugin/backup/c/d:m	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   501: lstore 8
          //   503: lload_2
          //   504: lconst_0
          //   505: lcmp
          //   506: ifle +288 -> 794
          //   509: lload_2
          //   510: lstore 4
          //   512: aload 10
          //   514: lload 4
          //   516: lload 8
          //   518: ladd
          //   519: invokestatic 304	com/tencent/mm/plugin/backup/c/d:a	(Lcom/tencent/mm/plugin/backup/c/d;J)J
          //   522: pop2
          //   523: aload_0
          //   524: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   527: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   530: invokevirtual 268	java/util/HashSet:size	()I
          //   533: istore_1
          //   534: aload_0
          //   535: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   538: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   541: aload_0
          //   542: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   545: invokestatic 142	com/tencent/mm/plugin/backup/c/d:e	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashMap;
          //   548: aload 11
          //   550: invokevirtual 308	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   553: invokevirtual 312	java/util/HashSet:add	(Ljava/lang/Object;)Z
          //   556: pop
          //   557: aload_0
          //   558: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   561: invokestatic 315	com/tencent/mm/plugin/backup/c/d:n	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   564: pop2
          //   565: aload_0
          //   566: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   569: invokestatic 319	com/tencent/mm/plugin/backup/c/d:o	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/d;
          //   572: invokevirtual 325	com/tencent/mm/plugin/backup/b/d:crZ	()Lcom/tencent/mm/plugin/backup/b/e;
          //   575: bipush 26
          //   577: putfield 330	com/tencent/mm/plugin/backup/b/e:rKS	I
          //   580: aload_0
          //   581: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   584: invokestatic 319	com/tencent/mm/plugin/backup/c/d:o	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/d;
          //   587: invokevirtual 325	com/tencent/mm/plugin/backup/b/d:crZ	()Lcom/tencent/mm/plugin/backup/b/e;
          //   590: astore 10
          //   592: aload_0
          //   593: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   596: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   599: aload_0
          //   600: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   603: invokestatic 258	com/tencent/mm/plugin/backup/c/d:i	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   606: lcmp
          //   607: ifle +193 -> 800
          //   610: ldc2_w 331
          //   613: lstore 4
          //   615: aload 10
          //   617: lload 4
          //   619: l2i
          //   620: putfield 335	com/tencent/mm/plugin/backup/b/e:rKV	I
          //   623: aload_0
          //   624: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   627: bipush 26
          //   629: invokevirtual 338	com/tencent/mm/plugin/backup/c/d:ED	(I)V
          //   632: aload_0
          //   633: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   636: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   639: invokevirtual 268	java/util/HashSet:size	()I
          //   642: iload_1
          //   643: if_icmple +47 -> 690
          //   646: aload_0
          //   647: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   650: invokestatic 104	com/tencent/mm/plugin/backup/c/d:b	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/f/b/a/z;
          //   653: aload_0
          //   654: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   657: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   660: invokevirtual 268	java/util/HashSet:size	()I
          //   663: putfield 341	com/tencent/mm/f/b/a/z:ggo	I
          //   666: aload_0
          //   667: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   670: invokestatic 121	com/tencent/mm/plugin/backup/c/d:c	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
          //   673: ldc_w 343
          //   676: aload_0
          //   677: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   680: invokestatic 104	com/tencent/mm/plugin/backup/c/d:b	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/f/b/a/z;
          //   683: invokevirtual 346	com/tencent/mm/f/b/a/z:agH	()Ljava/lang/String;
          //   686: invokevirtual 349	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Ljava/lang/String;)Z
          //   689: pop
          //   690: aload_0
          //   691: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   694: invokestatic 175	com/tencent/mm/plugin/backup/c/d:f	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/c/d$a;
          //   697: invokevirtual 281	com/tencent/mm/plugin/backup/c/d$a:end	()V
          //   700: invokestatic 284	com/tencent/mm/plugin/backup/c/d:csy	()V
          //   703: ldc2_w 350
          //   706: invokestatic 354	java/lang/Thread:sleep	(J)V
          //   709: ldc 244
          //   711: ldc_w 356
          //   714: bipush 6
          //   716: anewarray 4	java/lang/Object
          //   719: dup
          //   720: iconst_0
          //   721: aload 11
          //   723: aastore
          //   724: dup
          //   725: iconst_1
          //   726: aload_0
          //   727: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   730: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   733: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   736: aastore
          //   737: dup
          //   738: iconst_2
          //   739: aload_0
          //   740: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   743: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   746: invokevirtual 268	java/util/HashSet:size	()I
          //   749: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   752: aastore
          //   753: dup
          //   754: iconst_3
          //   755: lload_2
          //   756: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   759: aastore
          //   760: dup
          //   761: iconst_4
          //   762: aload_0
          //   763: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   766: invokestatic 301	com/tencent/mm/plugin/backup/c/d:m	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   769: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   772: aastore
          //   773: dup
          //   774: iconst_5
          //   775: lload 6
          //   777: invokestatic 359	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
          //   780: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   783: aastore
          //   784: invokestatic 361	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   787: sipush 21256
          //   790: invokestatic 363	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   793: return
          //   794: lconst_0
          //   795: lstore 4
          //   797: goto -285 -> 512
          //   800: aload_0
          //   801: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   804: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   807: ldc2_w 331
          //   810: lmul
          //   811: aload_0
          //   812: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   815: invokestatic 258	com/tencent/mm/plugin/backup/c/d:i	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   818: ldiv
          //   819: lstore 4
          //   821: goto -206 -> 615
          //   824: aload_0
          //   825: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   828: astore 10
          //   830: aload_0
          //   831: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   834: invokestatic 301	com/tencent/mm/plugin/backup/c/d:m	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   837: lstore 8
          //   839: lload_2
          //   840: lconst_0
          //   841: lcmp
          //   842: ifle +284 -> 1126
          //   845: lload_2
          //   846: lstore 4
          //   848: aload 10
          //   850: lload 4
          //   852: lload 8
          //   854: ladd
          //   855: invokestatic 304	com/tencent/mm/plugin/backup/c/d:a	(Lcom/tencent/mm/plugin/backup/c/d;J)J
          //   858: pop2
          //   859: aload_0
          //   860: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   863: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   866: invokevirtual 268	java/util/HashSet:size	()I
          //   869: istore_1
          //   870: aload_0
          //   871: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   874: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   877: aload_0
          //   878: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   881: invokestatic 142	com/tencent/mm/plugin/backup/c/d:e	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashMap;
          //   884: aload 11
          //   886: invokevirtual 308	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   889: invokevirtual 312	java/util/HashSet:add	(Ljava/lang/Object;)Z
          //   892: pop
          //   893: aload_0
          //   894: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   897: invokestatic 315	com/tencent/mm/plugin/backup/c/d:n	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   900: pop2
          //   901: aload_0
          //   902: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   905: invokestatic 319	com/tencent/mm/plugin/backup/c/d:o	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/d;
          //   908: invokevirtual 325	com/tencent/mm/plugin/backup/b/d:crZ	()Lcom/tencent/mm/plugin/backup/b/e;
          //   911: bipush 26
          //   913: putfield 330	com/tencent/mm/plugin/backup/b/e:rKS	I
          //   916: aload_0
          //   917: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   920: invokestatic 319	com/tencent/mm/plugin/backup/c/d:o	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/d;
          //   923: invokevirtual 325	com/tencent/mm/plugin/backup/b/d:crZ	()Lcom/tencent/mm/plugin/backup/b/e;
          //   926: astore 10
          //   928: aload_0
          //   929: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   932: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   935: aload_0
          //   936: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   939: invokestatic 258	com/tencent/mm/plugin/backup/c/d:i	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   942: lcmp
          //   943: ifle +189 -> 1132
          //   946: ldc2_w 331
          //   949: lstore 4
          //   951: aload 10
          //   953: lload 4
          //   955: l2i
          //   956: putfield 335	com/tencent/mm/plugin/backup/b/e:rKV	I
          //   959: aload_0
          //   960: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   963: bipush 26
          //   965: invokevirtual 338	com/tencent/mm/plugin/backup/c/d:ED	(I)V
          //   968: aload_0
          //   969: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   972: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   975: invokevirtual 268	java/util/HashSet:size	()I
          //   978: iload_1
          //   979: if_icmple +47 -> 1026
          //   982: aload_0
          //   983: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   986: invokestatic 104	com/tencent/mm/plugin/backup/c/d:b	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/f/b/a/z;
          //   989: aload_0
          //   990: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   993: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   996: invokevirtual 268	java/util/HashSet:size	()I
          //   999: putfield 341	com/tencent/mm/f/b/a/z:ggo	I
          //   1002: aload_0
          //   1003: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1006: invokestatic 121	com/tencent/mm/plugin/backup/c/d:c	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
          //   1009: ldc_w 343
          //   1012: aload_0
          //   1013: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1016: invokestatic 104	com/tencent/mm/plugin/backup/c/d:b	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/f/b/a/z;
          //   1019: invokevirtual 346	com/tencent/mm/f/b/a/z:agH	()Ljava/lang/String;
          //   1022: invokevirtual 349	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Ljava/lang/String;)Z
          //   1025: pop
          //   1026: aload_0
          //   1027: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1030: invokestatic 175	com/tencent/mm/plugin/backup/c/d:f	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/c/d$a;
          //   1033: invokevirtual 281	com/tencent/mm/plugin/backup/c/d$a:end	()V
          //   1036: invokestatic 284	com/tencent/mm/plugin/backup/c/d:csy	()V
          //   1039: ldc2_w 350
          //   1042: invokestatic 354	java/lang/Thread:sleep	(J)V
          //   1045: ldc 244
          //   1047: ldc_w 356
          //   1050: bipush 6
          //   1052: anewarray 4	java/lang/Object
          //   1055: dup
          //   1056: iconst_0
          //   1057: aload 11
          //   1059: aastore
          //   1060: dup
          //   1061: iconst_1
          //   1062: aload_0
          //   1063: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1066: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1069: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1072: aastore
          //   1073: dup
          //   1074: iconst_2
          //   1075: aload_0
          //   1076: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1079: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   1082: invokevirtual 268	java/util/HashSet:size	()I
          //   1085: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1088: aastore
          //   1089: dup
          //   1090: iconst_3
          //   1091: lload_2
          //   1092: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1095: aastore
          //   1096: dup
          //   1097: iconst_4
          //   1098: aload_0
          //   1099: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1102: invokestatic 301	com/tencent/mm/plugin/backup/c/d:m	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1105: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1108: aastore
          //   1109: dup
          //   1110: iconst_5
          //   1111: lload 6
          //   1113: invokestatic 359	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
          //   1116: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1119: aastore
          //   1120: invokestatic 361	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1123: goto -948 -> 175
          //   1126: lconst_0
          //   1127: lstore 4
          //   1129: goto -281 -> 848
          //   1132: aload_0
          //   1133: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1136: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1139: ldc2_w 331
          //   1142: lmul
          //   1143: aload_0
          //   1144: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1147: invokestatic 258	com/tencent/mm/plugin/backup/c/d:i	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1150: ldiv
          //   1151: lstore 4
          //   1153: goto -202 -> 951
          //   1156: astore 10
          //   1158: lload_2
          //   1159: lstore 4
          //   1161: ldc 244
          //   1163: ldc_w 365
          //   1166: iconst_1
          //   1167: anewarray 4	java/lang/Object
          //   1170: dup
          //   1171: iconst_0
          //   1172: aload 10
          //   1174: aastore
          //   1175: invokestatic 278	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1178: lload_2
          //   1179: lstore 4
          //   1181: invokestatic 370	com/tencent/mm/sdk/crash/CrashReportFactory:hasDebuger	()Z
          //   1184: ifeq +331 -> 1515
          //   1187: lload_2
          //   1188: lstore 4
          //   1190: sipush 21256
          //   1193: invokestatic 363	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1196: lload_2
          //   1197: lstore 4
          //   1199: aload 10
          //   1201: athrow
          //   1202: astore 10
          //   1204: lload 4
          //   1206: lstore_2
          //   1207: aload_0
          //   1208: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1211: astore 12
          //   1213: aload_0
          //   1214: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1217: invokestatic 301	com/tencent/mm/plugin/backup/c/d:m	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1220: lstore 8
          //   1222: lload_2
          //   1223: lconst_0
          //   1224: lcmp
          //   1225: ifle +622 -> 1847
          //   1228: lload_2
          //   1229: lstore 4
          //   1231: aload 12
          //   1233: lload 4
          //   1235: lload 8
          //   1237: ladd
          //   1238: invokestatic 304	com/tencent/mm/plugin/backup/c/d:a	(Lcom/tencent/mm/plugin/backup/c/d;J)J
          //   1241: pop2
          //   1242: aload_0
          //   1243: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1246: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   1249: invokevirtual 268	java/util/HashSet:size	()I
          //   1252: istore_1
          //   1253: aload_0
          //   1254: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1257: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   1260: aload_0
          //   1261: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1264: invokestatic 142	com/tencent/mm/plugin/backup/c/d:e	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashMap;
          //   1267: aload 11
          //   1269: invokevirtual 308	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   1272: invokevirtual 312	java/util/HashSet:add	(Ljava/lang/Object;)Z
          //   1275: pop
          //   1276: aload_0
          //   1277: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1280: invokestatic 315	com/tencent/mm/plugin/backup/c/d:n	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1283: pop2
          //   1284: aload_0
          //   1285: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1288: invokestatic 319	com/tencent/mm/plugin/backup/c/d:o	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/d;
          //   1291: invokevirtual 325	com/tencent/mm/plugin/backup/b/d:crZ	()Lcom/tencent/mm/plugin/backup/b/e;
          //   1294: bipush 26
          //   1296: putfield 330	com/tencent/mm/plugin/backup/b/e:rKS	I
          //   1299: aload_0
          //   1300: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1303: invokestatic 319	com/tencent/mm/plugin/backup/c/d:o	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/d;
          //   1306: invokevirtual 325	com/tencent/mm/plugin/backup/b/d:crZ	()Lcom/tencent/mm/plugin/backup/b/e;
          //   1309: astore 12
          //   1311: aload_0
          //   1312: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1315: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1318: aload_0
          //   1319: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1322: invokestatic 258	com/tencent/mm/plugin/backup/c/d:i	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1325: lcmp
          //   1326: ifle +527 -> 1853
          //   1329: ldc2_w 331
          //   1332: lstore 4
          //   1334: aload 12
          //   1336: lload 4
          //   1338: l2i
          //   1339: putfield 335	com/tencent/mm/plugin/backup/b/e:rKV	I
          //   1342: aload_0
          //   1343: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1346: bipush 26
          //   1348: invokevirtual 338	com/tencent/mm/plugin/backup/c/d:ED	(I)V
          //   1351: aload_0
          //   1352: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1355: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   1358: invokevirtual 268	java/util/HashSet:size	()I
          //   1361: iload_1
          //   1362: if_icmple +47 -> 1409
          //   1365: aload_0
          //   1366: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1369: invokestatic 104	com/tencent/mm/plugin/backup/c/d:b	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/f/b/a/z;
          //   1372: aload_0
          //   1373: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1376: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   1379: invokevirtual 268	java/util/HashSet:size	()I
          //   1382: putfield 341	com/tencent/mm/f/b/a/z:ggo	I
          //   1385: aload_0
          //   1386: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1389: invokestatic 121	com/tencent/mm/plugin/backup/c/d:c	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
          //   1392: ldc_w 343
          //   1395: aload_0
          //   1396: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1399: invokestatic 104	com/tencent/mm/plugin/backup/c/d:b	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/f/b/a/z;
          //   1402: invokevirtual 346	com/tencent/mm/f/b/a/z:agH	()Ljava/lang/String;
          //   1405: invokevirtual 349	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Ljava/lang/String;)Z
          //   1408: pop
          //   1409: aload_0
          //   1410: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1413: invokestatic 175	com/tencent/mm/plugin/backup/c/d:f	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/c/d$a;
          //   1416: invokevirtual 281	com/tencent/mm/plugin/backup/c/d$a:end	()V
          //   1419: invokestatic 284	com/tencent/mm/plugin/backup/c/d:csy	()V
          //   1422: ldc2_w 350
          //   1425: invokestatic 354	java/lang/Thread:sleep	(J)V
          //   1428: ldc 244
          //   1430: ldc_w 356
          //   1433: bipush 6
          //   1435: anewarray 4	java/lang/Object
          //   1438: dup
          //   1439: iconst_0
          //   1440: aload 11
          //   1442: aastore
          //   1443: dup
          //   1444: iconst_1
          //   1445: aload_0
          //   1446: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1449: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1452: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1455: aastore
          //   1456: dup
          //   1457: iconst_2
          //   1458: aload_0
          //   1459: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1462: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   1465: invokevirtual 268	java/util/HashSet:size	()I
          //   1468: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1471: aastore
          //   1472: dup
          //   1473: iconst_3
          //   1474: lload_2
          //   1475: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1478: aastore
          //   1479: dup
          //   1480: iconst_4
          //   1481: aload_0
          //   1482: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1485: invokestatic 301	com/tencent/mm/plugin/backup/c/d:m	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1488: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1491: aastore
          //   1492: dup
          //   1493: iconst_5
          //   1494: lload 6
          //   1496: invokestatic 359	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
          //   1499: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1502: aastore
          //   1503: invokestatic 361	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1506: sipush 21256
          //   1509: invokestatic 363	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   1512: aload 10
          //   1514: athrow
          //   1515: aload_0
          //   1516: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1519: astore 10
          //   1521: aload_0
          //   1522: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1525: invokestatic 301	com/tencent/mm/plugin/backup/c/d:m	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1528: lstore 8
          //   1530: lload_2
          //   1531: lconst_0
          //   1532: lcmp
          //   1533: ifle +284 -> 1817
          //   1536: lload_2
          //   1537: lstore 4
          //   1539: aload 10
          //   1541: lload 4
          //   1543: lload 8
          //   1545: ladd
          //   1546: invokestatic 304	com/tencent/mm/plugin/backup/c/d:a	(Lcom/tencent/mm/plugin/backup/c/d;J)J
          //   1549: pop2
          //   1550: aload_0
          //   1551: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1554: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   1557: invokevirtual 268	java/util/HashSet:size	()I
          //   1560: istore_1
          //   1561: aload_0
          //   1562: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1565: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   1568: aload_0
          //   1569: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1572: invokestatic 142	com/tencent/mm/plugin/backup/c/d:e	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashMap;
          //   1575: aload 11
          //   1577: invokevirtual 308	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
          //   1580: invokevirtual 312	java/util/HashSet:add	(Ljava/lang/Object;)Z
          //   1583: pop
          //   1584: aload_0
          //   1585: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1588: invokestatic 315	com/tencent/mm/plugin/backup/c/d:n	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1591: pop2
          //   1592: aload_0
          //   1593: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1596: invokestatic 319	com/tencent/mm/plugin/backup/c/d:o	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/d;
          //   1599: invokevirtual 325	com/tencent/mm/plugin/backup/b/d:crZ	()Lcom/tencent/mm/plugin/backup/b/e;
          //   1602: bipush 26
          //   1604: putfield 330	com/tencent/mm/plugin/backup/b/e:rKS	I
          //   1607: aload_0
          //   1608: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1611: invokestatic 319	com/tencent/mm/plugin/backup/c/d:o	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/d;
          //   1614: invokevirtual 325	com/tencent/mm/plugin/backup/b/d:crZ	()Lcom/tencent/mm/plugin/backup/b/e;
          //   1617: astore 10
          //   1619: aload_0
          //   1620: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1623: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1626: aload_0
          //   1627: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1630: invokestatic 258	com/tencent/mm/plugin/backup/c/d:i	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1633: lcmp
          //   1634: ifle +189 -> 1823
          //   1637: ldc2_w 331
          //   1640: lstore 4
          //   1642: aload 10
          //   1644: lload 4
          //   1646: l2i
          //   1647: putfield 335	com/tencent/mm/plugin/backup/b/e:rKV	I
          //   1650: aload_0
          //   1651: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1654: bipush 26
          //   1656: invokevirtual 338	com/tencent/mm/plugin/backup/c/d:ED	(I)V
          //   1659: aload_0
          //   1660: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1663: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   1666: invokevirtual 268	java/util/HashSet:size	()I
          //   1669: iload_1
          //   1670: if_icmple +47 -> 1717
          //   1673: aload_0
          //   1674: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1677: invokestatic 104	com/tencent/mm/plugin/backup/c/d:b	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/f/b/a/z;
          //   1680: aload_0
          //   1681: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1684: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   1687: invokevirtual 268	java/util/HashSet:size	()I
          //   1690: putfield 341	com/tencent/mm/f/b/a/z:ggo	I
          //   1693: aload_0
          //   1694: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1697: invokestatic 121	com/tencent/mm/plugin/backup/c/d:c	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
          //   1700: ldc_w 343
          //   1703: aload_0
          //   1704: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1707: invokestatic 104	com/tencent/mm/plugin/backup/c/d:b	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/f/b/a/z;
          //   1710: invokevirtual 346	com/tencent/mm/f/b/a/z:agH	()Ljava/lang/String;
          //   1713: invokevirtual 349	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Ljava/lang/String;)Z
          //   1716: pop
          //   1717: aload_0
          //   1718: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1721: invokestatic 175	com/tencent/mm/plugin/backup/c/d:f	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/c/d$a;
          //   1724: invokevirtual 281	com/tencent/mm/plugin/backup/c/d$a:end	()V
          //   1727: invokestatic 284	com/tencent/mm/plugin/backup/c/d:csy	()V
          //   1730: ldc2_w 350
          //   1733: invokestatic 354	java/lang/Thread:sleep	(J)V
          //   1736: ldc 244
          //   1738: ldc_w 356
          //   1741: bipush 6
          //   1743: anewarray 4	java/lang/Object
          //   1746: dup
          //   1747: iconst_0
          //   1748: aload 11
          //   1750: aastore
          //   1751: dup
          //   1752: iconst_1
          //   1753: aload_0
          //   1754: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1757: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1760: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1763: aastore
          //   1764: dup
          //   1765: iconst_2
          //   1766: aload_0
          //   1767: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1770: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   1773: invokevirtual 268	java/util/HashSet:size	()I
          //   1776: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   1779: aastore
          //   1780: dup
          //   1781: iconst_3
          //   1782: lload_2
          //   1783: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1786: aastore
          //   1787: dup
          //   1788: iconst_4
          //   1789: aload_0
          //   1790: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1793: invokestatic 301	com/tencent/mm/plugin/backup/c/d:m	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1796: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1799: aastore
          //   1800: dup
          //   1801: iconst_5
          //   1802: lload 6
          //   1804: invokestatic 359	com/tencent/mm/sdk/platformtools/Util:milliSecondsToNow	(J)J
          //   1807: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   1810: aastore
          //   1811: invokestatic 361	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   1814: goto -1639 -> 175
          //   1817: lconst_0
          //   1818: lstore 4
          //   1820: goto -281 -> 1539
          //   1823: aload_0
          //   1824: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1827: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1830: ldc2_w 331
          //   1833: lmul
          //   1834: aload_0
          //   1835: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1838: invokestatic 258	com/tencent/mm/plugin/backup/c/d:i	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1841: ldiv
          //   1842: lstore 4
          //   1844: goto -202 -> 1642
          //   1847: lconst_0
          //   1848: lstore 4
          //   1850: goto -619 -> 1231
          //   1853: aload_0
          //   1854: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1857: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1860: ldc2_w 331
          //   1863: lmul
          //   1864: aload_0
          //   1865: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1868: invokestatic 258	com/tencent/mm/plugin/backup/c/d:i	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1871: ldiv
          //   1872: lstore 4
          //   1874: goto -540 -> 1334
          //   1877: aload_0
          //   1878: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1881: invokestatic 319	com/tencent/mm/plugin/backup/c/d:o	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/d;
          //   1884: invokevirtual 325	com/tencent/mm/plugin/backup/b/d:crZ	()Lcom/tencent/mm/plugin/backup/b/e;
          //   1887: aload_0
          //   1888: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1891: invokestatic 301	com/tencent/mm/plugin/backup/c/d:m	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1894: putfield 373	com/tencent/mm/plugin/backup/b/e:rLd	J
          //   1897: aload_0
          //   1898: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1901: invokestatic 319	com/tencent/mm/plugin/backup/c/d:o	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/d;
          //   1904: invokevirtual 325	com/tencent/mm/plugin/backup/b/d:crZ	()Lcom/tencent/mm/plugin/backup/b/e;
          //   1907: astore 10
          //   1909: aload_0
          //   1910: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1913: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   1916: invokevirtual 268	java/util/HashSet:size	()I
          //   1919: aload_0
          //   1920: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1923: invokestatic 135	com/tencent/mm/plugin/backup/c/d:d	(Lcom/tencent/mm/plugin/backup/c/d;)I
          //   1926: if_icmple +420 -> 2346
          //   1929: aload_0
          //   1930: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1933: invokestatic 135	com/tencent/mm/plugin/backup/c/d:d	(Lcom/tencent/mm/plugin/backup/c/d;)I
          //   1936: istore_1
          //   1937: aload 10
          //   1939: iload_1
          //   1940: putfield 376	com/tencent/mm/plugin/backup/b/e:rKT	I
          //   1943: aload_0
          //   1944: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1947: invokestatic 319	com/tencent/mm/plugin/backup/c/d:o	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/d;
          //   1950: invokevirtual 325	com/tencent/mm/plugin/backup/b/d:crZ	()Lcom/tencent/mm/plugin/backup/b/e;
          //   1953: aload_0
          //   1954: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1957: invokestatic 135	com/tencent/mm/plugin/backup/c/d:d	(Lcom/tencent/mm/plugin/backup/c/d;)I
          //   1960: putfield 379	com/tencent/mm/plugin/backup/b/e:rKU	I
          //   1963: aload_0
          //   1964: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1967: invokestatic 319	com/tencent/mm/plugin/backup/c/d:o	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/d;
          //   1970: invokevirtual 325	com/tencent/mm/plugin/backup/b/d:crZ	()Lcom/tencent/mm/plugin/backup/b/e;
          //   1973: astore 10
          //   1975: aload_0
          //   1976: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1979: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1982: aload_0
          //   1983: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   1986: invokestatic 258	com/tencent/mm/plugin/backup/c/d:i	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   1989: lcmp
          //   1990: ifle +370 -> 2360
          //   1993: ldc2_w 331
          //   1996: lstore_2
          //   1997: aload 10
          //   1999: lload_2
          //   2000: l2i
          //   2001: putfield 335	com/tencent/mm/plugin/backup/b/e:rKV	I
          //   2004: aload_0
          //   2005: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2008: bipush 30
          //   2010: invokevirtual 338	com/tencent/mm/plugin/backup/c/d:ED	(I)V
          //   2013: aload 12
          //   2015: invokestatic 289	com/tencent/mm/plugin/backup/h/c:i	(Ljava/util/HashMap;)V
          //   2018: ldc 244
          //   2020: ldc_w 381
          //   2023: iconst_4
          //   2024: anewarray 4	java/lang/Object
          //   2027: dup
          //   2028: iconst_0
          //   2029: aload_0
          //   2030: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2033: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   2036: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   2039: aastore
          //   2040: dup
          //   2041: iconst_1
          //   2042: aload_0
          //   2043: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2046: invokestatic 258	com/tencent/mm/plugin/backup/c/d:i	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   2049: invokestatic 256	java/lang/Long:valueOf	(J)Ljava/lang/Long;
          //   2052: aastore
          //   2053: dup
          //   2054: iconst_2
          //   2055: aload_0
          //   2056: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2059: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   2062: invokevirtual 268	java/util/HashSet:size	()I
          //   2065: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2068: aastore
          //   2069: dup
          //   2070: iconst_3
          //   2071: aload_0
          //   2072: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2075: invokestatic 135	com/tencent/mm/plugin/backup/c/d:d	(Lcom/tencent/mm/plugin/backup/c/d;)I
          //   2078: invokestatic 273	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
          //   2081: aastore
          //   2082: invokestatic 361	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
          //   2085: aload_0
          //   2086: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2089: invokestatic 175	com/tencent/mm/plugin/backup/c/d:f	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/c/d$a;
          //   2092: invokevirtual 281	com/tencent/mm/plugin/backup/c/d$a:end	()V
          //   2095: aload_0
          //   2096: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2099: invokestatic 384	com/tencent/mm/plugin/backup/c/d:p	(Lcom/tencent/mm/plugin/backup/c/d;)I
          //   2102: invokestatic 387	com/tencent/mm/plugin/backup/c/d:csz	()I
          //   2105: if_icmpeq +231 -> 2336
          //   2108: aload_0
          //   2109: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2112: invokestatic 387	com/tencent/mm/plugin/backup/c/d:csz	()I
          //   2115: invokestatic 390	com/tencent/mm/plugin/backup/c/d:a	(Lcom/tencent/mm/plugin/backup/c/d;I)I
          //   2118: pop
          //   2119: invokestatic 393	com/tencent/mm/plugin/backup/c/d:csw	()V
          //   2122: aload_0
          //   2123: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2126: invokestatic 108	com/tencent/mm/plugin/backup/c/d:a	(Lcom/tencent/mm/plugin/backup/c/d;)I
          //   2129: iconst_1
          //   2130: if_icmpne +253 -> 2383
          //   2133: invokestatic 399	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
          //   2136: pop
          //   2137: invokestatic 402	com/tencent/mm/model/c:aHp	()Lcom/tencent/mm/storage/ao;
          //   2140: getstatic 408	com/tencent/mm/storage/ar$a:VnE	Lcom/tencent/mm/storage/ar$a;
          //   2143: getstatic 414	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
          //   2146: invokevirtual 418	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
          //   2149: aload_0
          //   2150: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2153: invokestatic 121	com/tencent/mm/plugin/backup/c/d:c	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
          //   2156: ldc 123
          //   2158: iconst_0
          //   2159: invokevirtual 421	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;I)Z
          //   2162: pop
          //   2163: aload_0
          //   2164: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2167: invokestatic 121	com/tencent/mm/plugin/backup/c/d:c	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
          //   2170: ldc_w 423
          //   2173: iconst_0
          //   2174: invokevirtual 426	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Z)Z
          //   2177: pop
          //   2178: aload_0
          //   2179: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2182: invokestatic 121	com/tencent/mm/plugin/backup/c/d:c	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
          //   2185: ldc_w 343
          //   2188: ldc_w 428
          //   2191: invokevirtual 349	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:encode	(Ljava/lang/String;Ljava/lang/String;)Z
          //   2194: pop
          //   2195: aload_0
          //   2196: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2199: invokestatic 432	com/tencent/mm/plugin/backup/c/d:q	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/b$d;
          //   2202: ifnull +15 -> 2217
          //   2205: aload_0
          //   2206: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2209: invokestatic 432	com/tencent/mm/plugin/backup/c/d:q	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/b$d;
          //   2212: invokeinterface 437 1 0
          //   2217: aload_0
          //   2218: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2221: invokestatic 319	com/tencent/mm/plugin/backup/c/d:o	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/d;
          //   2224: invokevirtual 325	com/tencent/mm/plugin/backup/b/d:crZ	()Lcom/tencent/mm/plugin/backup/b/e;
          //   2227: astore 10
          //   2229: aload_0
          //   2230: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2233: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   2236: invokevirtual 268	java/util/HashSet:size	()I
          //   2239: aload_0
          //   2240: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2243: invokestatic 135	com/tencent/mm/plugin/backup/c/d:d	(Lcom/tencent/mm/plugin/backup/c/d;)I
          //   2246: if_icmple +167 -> 2413
          //   2249: aload_0
          //   2250: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2253: invokestatic 135	com/tencent/mm/plugin/backup/c/d:d	(Lcom/tencent/mm/plugin/backup/c/d;)I
          //   2256: istore_1
          //   2257: aload 10
          //   2259: bipush 27
          //   2261: iload_1
          //   2262: aload_0
          //   2263: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2266: invokestatic 135	com/tencent/mm/plugin/backup/c/d:d	(Lcom/tencent/mm/plugin/backup/c/d;)I
          //   2269: invokevirtual 441	com/tencent/mm/plugin/backup/b/e:T	(III)V
          //   2272: aload_0
          //   2273: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2276: bipush 27
          //   2278: invokevirtual 338	com/tencent/mm/plugin/backup/c/d:ED	(I)V
          //   2281: invokestatic 444	com/tencent/mm/plugin/backup/b/g:csl	()V
          //   2284: getstatic 50	com/tencent/mm/plugin/backup/b/g:rLl	Z
          //   2287: ifne +12 -> 2299
          //   2290: invokestatic 66	com/tencent/mm/plugin/backup/b/g:csm	()Ljava/lang/String;
          //   2293: invokestatic 70	com/tencent/mm/plugin/backup/b/g:aoa	(Ljava/lang/String;)V
          //   2296: invokestatic 447	com/tencent/mm/plugin/backup/b/g:csk	()V
          //   2299: aload_0
          //   2300: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2303: invokestatic 450	com/tencent/mm/plugin/backup/c/d:csA	()I
          //   2306: invokestatic 390	com/tencent/mm/plugin/backup/c/d:a	(Lcom/tencent/mm/plugin/backup/c/d;I)I
          //   2309: pop
          //   2310: aload_0
          //   2311: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2314: invokestatic 454	com/tencent/mm/plugin/backup/c/d:r	(Lcom/tencent/mm/plugin/backup/c/d;)V
          //   2317: invokestatic 458	com/tencent/mm/model/bh:getNotification	()Lcom/tencent/mm/model/ay;
          //   2320: iconst_0
          //   2321: invokeinterface 464 2 0
          //   2326: aload_0
          //   2327: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2330: invokestatic 319	com/tencent/mm/plugin/backup/c/d:o	(Lcom/tencent/mm/plugin/backup/c/d;)Lcom/tencent/mm/plugin/backup/b/d;
          //   2333: invokevirtual 467	com/tencent/mm/plugin/backup/b/d:csb	()V
          //   2336: invokestatic 470	com/tencent/mm/sdk/platformtools/Log:appenderFlush	()V
          //   2339: sipush 21256
          //   2342: invokestatic 363	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
          //   2345: return
          //   2346: aload_0
          //   2347: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2350: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   2353: invokevirtual 268	java/util/HashSet:size	()I
          //   2356: istore_1
          //   2357: goto -420 -> 1937
          //   2360: aload_0
          //   2361: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2364: invokestatic 250	com/tencent/mm/plugin/backup/c/d:h	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   2367: ldc2_w 331
          //   2370: lmul
          //   2371: aload_0
          //   2372: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2375: invokestatic 258	com/tencent/mm/plugin/backup/c/d:i	(Lcom/tencent/mm/plugin/backup/c/d;)J
          //   2378: ldiv
          //   2379: lstore_2
          //   2380: goto -383 -> 1997
          //   2383: aload_0
          //   2384: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2387: invokestatic 108	com/tencent/mm/plugin/backup/c/d:a	(Lcom/tencent/mm/plugin/backup/c/d;)I
          //   2390: iconst_2
          //   2391: if_icmpne -242 -> 2149
          //   2394: invokestatic 399	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
          //   2397: pop
          //   2398: invokestatic 402	com/tencent/mm/model/c:aHp	()Lcom/tencent/mm/storage/ao;
          //   2401: getstatic 473	com/tencent/mm/storage/ar$a:VnH	Lcom/tencent/mm/storage/ar$a;
          //   2404: getstatic 414	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
          //   2407: invokevirtual 418	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
          //   2410: goto -261 -> 2149
          //   2413: aload_0
          //   2414: getfield 16	com/tencent/mm/plugin/backup/c/d$1:rMH	Lcom/tencent/mm/plugin/backup/c/d;
          //   2417: invokestatic 262	com/tencent/mm/plugin/backup/c/d:j	(Lcom/tencent/mm/plugin/backup/c/d;)Ljava/util/HashSet;
          //   2420: invokevirtual 268	java/util/HashSet:size	()I
          //   2423: istore_1
          //   2424: goto -167 -> 2257
          //   2427: astore 10
          //   2429: goto -1720 -> 709
          //   2432: astore 10
          //   2434: goto -1389 -> 1045
          //   2437: astore 10
          //   2439: goto -703 -> 1736
          //   2442: astore 12
          //   2444: goto -1016 -> 1428
          //   2447: astore 10
          //   2449: goto -1242 -> 1207
          //   2452: astore 10
          //   2454: goto -1296 -> 1158
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	2457	0	this	1
          //   346	2078	1	i	int
          //   174	2206	2	l1	long
          //   351	1522	4	l2	long
          //   200	1603	6	l3	long
          //   501	1043	8	l4	long
          //   212	740	10	localObject1	Object
          //   1156	44	10	localException1	java.lang.Exception
          //   1202	311	10	localObject2	Object
          //   1519	739	10	localObject3	Object
          //   2427	1	10	localInterruptedException1	java.lang.InterruptedException
          //   2432	1	10	localInterruptedException2	java.lang.InterruptedException
          //   2437	1	10	localInterruptedException3	java.lang.InterruptedException
          //   2447	1	10	localObject4	Object
          //   2452	1	10	localException2	java.lang.Exception
          //   195	1554	11	str1	String
          //   67	1947	12	localObject5	Object
          //   2442	1	12	localInterruptedException4	java.lang.InterruptedException
          //   86	252	13	str2	String
          //   171	15	14	localIterator	Iterator
          //   287	53	15	localPString	com.tencent.mm.pointers.PString
          //   296	46	16	localPBool	com.tencent.mm.pointers.PBool
          //   325	11	17	localPair	Pair
          // Exception table:
          //   from	to	target	type
          //   327	347	1156	java/lang/Exception
          //   353	363	1202	finally
          //   366	437	1202	finally
          //   440	450	1202	finally
          //   453	456	1202	finally
          //   459	464	1202	finally
          //   467	488	1202	finally
          //   1161	1178	1202	finally
          //   1181	1187	1202	finally
          //   1190	1196	1202	finally
          //   1199	1202	1202	finally
          //   703	709	2427	java/lang/InterruptedException
          //   1039	1045	2432	java/lang/InterruptedException
          //   1730	1736	2437	java/lang/InterruptedException
          //   1422	1428	2442	java/lang/InterruptedException
          //   327	347	2447	finally
          //   353	363	2452	java/lang/Exception
          //   366	437	2452	java/lang/Exception
          //   440	450	2452	java/lang/Exception
          //   453	456	2452	java/lang/Exception
          //   459	464	2452	java/lang/Exception
          //   467	488	2452	java/lang/Exception
        }
      });
      AppMethodBeat.o(21260);
      return;
      if (this.rKO == 2)
      {
        bh.beI();
        c.aHp().set(ar.a.VnH, Boolean.TRUE);
      }
    }
  }
  
  final class a
  {
    boolean jVu = false;
    long rMI = -1L;
    
    private a() {}
    
    public final void end()
    {
      AppMethodBeat.i(21257);
      if ((this.jVu) && (com.tencent.mm.plugin.backup.h.d.cua().cub().kcF != null))
      {
        com.tencent.mm.plugin.backup.h.d.cua().cub().kcF.endTransaction(this.rMI);
        this.jVu = false;
      }
      AppMethodBeat.o(21257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.d
 * JD-Core Version:    0.7.0.1
 */