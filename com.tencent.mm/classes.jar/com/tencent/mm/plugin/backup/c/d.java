package com.tencent.mm.plugin.backup.c;

import android.content.Context;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.ac;
import com.tencent.mm.g.a.by;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.backup.b.b.d;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.h.a.1;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.m;
import com.tencent.wcdb.DatabaseUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<Lcom.tencent.mm.protocal.protobuf.if;>;
import java.util.Set;

public final class d
{
  private static int nuo = 0;
  private static int nup = 1;
  private static int nuq = 2;
  private static boolean nur = false;
  private boolean hjP;
  private Object lock;
  private final int nsF;
  private long nsU;
  private final com.tencent.mm.plugin.backup.b.d ntw;
  public boolean nug;
  private final HashMap<String, String> nuh;
  private HashSet<String> nui;
  private final int nuj;
  private final long nuk;
  private long nul;
  private b.d num;
  private int nun;
  private HashMap<String, Pair<Long, Long>> nus;
  private a nut;
  private boolean nuu;
  private int nuv;
  
  public d(com.tencent.mm.plugin.backup.b.d paramd, int paramInt1, b.d paramd1, int paramInt2, boolean paramBoolean, LinkedList<String> paramLinkedList, LinkedList<Long> paramLinkedList1)
  {
    AppMethodBeat.i(21258);
    this.nug = false;
    this.nui = new HashSet();
    this.lock = new Object();
    this.nsU = 0L;
    this.nun = nuo;
    this.nuh = ba.aBQ().azV().foI();
    this.ntw = paramd;
    this.nsF = paramInt1;
    this.num = paramd1;
    this.nuj = paramInt2;
    nur = paramBoolean;
    this.nuk = DatabaseUtils.longForQuery(ba.aBQ().azV().hHS.ftT(), "SELECT COUNT(*) FROM BackupRecoverMsgListDataId", null);
    this.nus = c(paramLinkedList, paramLinkedList1);
    this.nui.clear();
    this.nul = 0L;
    ad.i("MicroMsg.BackupRecoverMerger", "BackupRecoverMerger, msgListDataIdHashMap[%d], backupMode[%d], totalMsgList[%d], totalSession[%d], isQuickBackup[%b]", new Object[] { Integer.valueOf(this.nuh.size()), Integer.valueOf(paramInt1), Long.valueOf(this.nuk), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) });
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
    //   9: invokestatic 184	com/tencent/mm/vfs/i:aY	(Ljava/lang/String;II)[B
    //   12: astore 12
    //   14: new 186	com/tencent/mm/protocal/protobuf/ig
    //   17: dup
    //   18: invokespecial 187	com/tencent/mm/protocal/protobuf/ig:<init>	()V
    //   21: aload 12
    //   23: invokevirtual 191	com/tencent/mm/protocal/protobuf/ig:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   26: checkcast 186	com/tencent/mm/protocal/protobuf/ig
    //   29: astore 16
    //   31: aload 4
    //   33: aload 16
    //   35: getfield 195	com/tencent/mm/protocal/protobuf/ig:nDj	Ljava/util/LinkedList;
    //   38: invokestatic 199	com/tencent/mm/plugin/backup/c/d:j	(Ljava/lang/String;Ljava/util/List;)Ljava/util/List;
    //   41: astore_1
    //   42: iconst_1
    //   43: istore 7
    //   45: ldc 201
    //   47: astore 12
    //   49: aload_1
    //   50: invokeinterface 207 1 0
    //   55: astore 17
    //   57: aload 17
    //   59: invokeinterface 213 1 0
    //   64: ifeq +1037 -> 1101
    //   67: aload 17
    //   69: invokeinterface 217 1 0
    //   74: checkcast 219	com/tencent/mm/protocal/protobuf/if
    //   77: astore 18
    //   79: aload_0
    //   80: getfield 72	com/tencent/mm/plugin/backup/c/d:lock	Ljava/lang/Object;
    //   83: astore_1
    //   84: aload_1
    //   85: monitorenter
    //   86: aload_0
    //   87: getfield 221	com/tencent/mm/plugin/backup/c/d:hjP	Z
    //   90: ifeq +184 -> 274
    //   93: aload_1
    //   94: monitorexit
    //   95: sipush 21261
    //   98: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iconst_m1
    //   102: ireturn
    //   103: astore 4
    //   105: ldc 201
    //   107: astore_3
    //   108: aload_3
    //   109: astore_2
    //   110: new 223	com/tencent/mm/vfs/e
    //   113: dup
    //   114: aload_1
    //   115: invokespecial 226	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   118: astore 5
    //   120: aload_3
    //   121: astore_2
    //   122: new 228	java/lang/StringBuilder
    //   125: dup
    //   126: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   129: ldc 201
    //   131: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload 5
    //   136: invokevirtual 236	com/tencent/mm/vfs/e:exists	()Z
    //   139: invokevirtual 239	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   142: ldc 241
    //   144: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: astore_3
    //   151: aload_3
    //   152: astore_2
    //   153: new 228	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   160: aload_3
    //   161: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: aload 5
    //   166: invokevirtual 248	com/tencent/mm/vfs/e:canRead	()Z
    //   169: invokevirtual 239	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   172: ldc 241
    //   174: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: astore_3
    //   181: aload_3
    //   182: astore_2
    //   183: new 228	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 229	java/lang/StringBuilder:<init>	()V
    //   190: aload_3
    //   191: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload 5
    //   196: invokevirtual 252	com/tencent/mm/vfs/e:length	()J
    //   199: invokevirtual 255	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   202: ldc_w 257
    //   205: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: astore_3
    //   212: aload_3
    //   213: astore_2
    //   214: aload 12
    //   216: ifnonnull +50 -> 266
    //   219: iconst_m1
    //   220: istore 7
    //   222: ldc 137
    //   224: aload 4
    //   226: ldc_w 259
    //   229: iconst_4
    //   230: anewarray 4	java/lang/Object
    //   233: dup
    //   234: iconst_0
    //   235: aload_1
    //   236: aastore
    //   237: dup
    //   238: iconst_1
    //   239: aload_2
    //   240: aastore
    //   241: dup
    //   242: iconst_2
    //   243: iload 7
    //   245: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   248: aastore
    //   249: dup
    //   250: iconst_3
    //   251: aload 4
    //   253: aastore
    //   254: invokestatic 263	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   257: sipush 21261
    //   260: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: bipush 254
    //   265: ireturn
    //   266: aload 12
    //   268: arraylength
    //   269: istore 7
    //   271: goto -49 -> 222
    //   274: aload_1
    //   275: monitorexit
    //   276: getstatic 52	com/tencent/mm/plugin/backup/c/d:nur	Z
    //   279: ifeq +12 -> 291
    //   282: aload 18
    //   284: getfield 266	com/tencent/mm/protocal/protobuf/if:nEf	I
    //   287: iconst_1
    //   288: if_icmpne -231 -> 57
    //   291: aload 6
    //   293: getfield 271	com/tencent/mm/pointers/PBool:value	Z
    //   296: ifeq +47 -> 343
    //   299: aconst_null
    //   300: astore_1
    //   301: iload 7
    //   303: ifeq +172 -> 475
    //   306: aload_1
    //   307: ifnull +168 -> 475
    //   310: aload_1
    //   311: getfield 277	com/tencent/mm/g/c/ei:field_talker	Ljava/lang/String;
    //   314: astore_1
    //   315: iconst_0
    //   316: istore 7
    //   318: aload 18
    //   320: getfield 266	com/tencent/mm/protocal/protobuf/if:nEf	I
    //   323: invokestatic 282	com/tencent/mm/plugin/backup/c/e:xs	(I)V
    //   326: aload_1
    //   327: astore 12
    //   329: goto -272 -> 57
    //   332: astore_2
    //   333: aload_1
    //   334: monitorexit
    //   335: sipush 21261
    //   338: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   341: aload_2
    //   342: athrow
    //   343: aload 18
    //   345: getfield 286	com/tencent/mm/protocal/protobuf/if:Fvi	Lcom/tencent/mm/protocal/protobuf/cwt;
    //   348: getfield 291	com/tencent/mm/protocal/protobuf/cwt:HoB	Ljava/lang/String;
    //   351: astore 14
    //   353: aload 18
    //   355: getfield 294	com/tencent/mm/protocal/protobuf/if:Fvj	Lcom/tencent/mm/protocal/protobuf/cwt;
    //   358: getfield 291	com/tencent/mm/protocal/protobuf/cwt:HoB	Ljava/lang/String;
    //   361: astore 13
    //   363: aload 14
    //   365: invokestatic 300	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   368: ifne +11 -> 379
    //   371: aload 13
    //   373: invokestatic 300	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   376: ifeq +45 -> 421
    //   379: aload 14
    //   381: astore_1
    //   382: aload 14
    //   384: ifnonnull +769 -> 1153
    //   387: ldc_w 302
    //   390: astore_1
    //   391: goto +762 -> 1153
    //   394: ldc_w 304
    //   397: ldc_w 306
    //   400: iconst_2
    //   401: anewarray 4	java/lang/Object
    //   404: dup
    //   405: iconst_0
    //   406: aload_1
    //   407: aastore
    //   408: dup
    //   409: iconst_1
    //   410: aload 14
    //   412: aastore
    //   413: invokestatic 309	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   416: aconst_null
    //   417: astore_1
    //   418: goto -117 -> 301
    //   421: aload 4
    //   423: aload 14
    //   425: invokevirtual 315	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   428: ifne +742 -> 1170
    //   431: invokestatic 321	com/tencent/mm/plugin/backup/h/d:bIY	()Lcom/tencent/mm/plugin/backup/h/d;
    //   434: invokevirtual 325	com/tencent/mm/plugin/backup/h/d:bIZ	()Lcom/tencent/mm/plugin/backup/h/b;
    //   437: astore_1
    //   438: aload_1
    //   439: getfield 330	com/tencent/mm/plugin/backup/h/b:uin	I
    //   442: ifne +39 -> 481
    //   445: new 332	com/tencent/mm/model/b
    //   448: dup
    //   449: invokespecial 333	com/tencent/mm/model/b:<init>	()V
    //   452: astore_1
    //   453: sipush 21261
    //   456: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   459: aload_1
    //   460: athrow
    //   461: astore_1
    //   462: ldc 137
    //   464: aload_1
    //   465: ldc_w 335
    //   468: iconst_0
    //   469: anewarray 4	java/lang/Object
    //   472: invokestatic 263	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   475: aload 12
    //   477: astore_1
    //   478: goto -160 -> 318
    //   481: aload_1
    //   482: getfield 339	com/tencent/mm/plugin/backup/h/b:nAj	Lcom/tencent/mm/plugin/messenger/foundation/a/a/l;
    //   485: aload 14
    //   487: invokeinterface 344 2 0
    //   492: ifeq +696 -> 1188
    //   495: goto +675 -> 1170
    //   498: aload 5
    //   500: ifnull +14 -> 514
    //   503: aload 5
    //   505: getfield 348	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   508: invokestatic 300	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   511: ifeq +636 -> 1147
    //   514: aload 5
    //   516: ifnonnull +625 -> 1141
    //   519: new 346	com/tencent/mm/pointers/PString
    //   522: dup
    //   523: invokespecial 349	com/tencent/mm/pointers/PString:<init>	()V
    //   526: astore_1
    //   527: goto +649 -> 1176
    //   530: aload_1
    //   531: aload 15
    //   533: putfield 348	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   536: invokestatic 321	com/tencent/mm/plugin/backup/h/d:bIY	()Lcom/tencent/mm/plugin/backup/h/d;
    //   539: invokevirtual 325	com/tencent/mm/plugin/backup/h/d:bIZ	()Lcom/tencent/mm/plugin/backup/h/b;
    //   542: invokevirtual 353	com/tencent/mm/plugin/backup/h/b:azp	()Lcom/tencent/mm/storage/bp;
    //   545: aload_1
    //   546: getfield 348	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   549: invokeinterface 359 2 0
    //   554: astore 15
    //   556: invokestatic 365	com/tencent/mm/plugin/backup/b/g:bHo	()Ljava/util/List;
    //   559: aload_1
    //   560: getfield 348	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   563: invokeinterface 368 2 0
    //   568: ifne +27 -> 595
    //   571: aload 15
    //   573: ifnull +628 -> 1201
    //   576: aload 15
    //   578: getfield 373	com/tencent/mm/g/c/aw:field_username	Ljava/lang/String;
    //   581: invokestatic 300	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   584: ifne +617 -> 1201
    //   587: aload 15
    //   589: invokevirtual 378	com/tencent/mm/storage/am:fqg	()Z
    //   592: ifeq +609 -> 1201
    //   595: ldc_w 304
    //   598: new 228	java/lang/StringBuilder
    //   601: dup
    //   602: ldc_w 380
    //   605: invokespecial 381	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   608: aload_1
    //   609: getfield 348	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   612: invokevirtual 233	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   615: invokevirtual 245	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   618: invokestatic 384	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   621: aload 6
    //   623: iconst_1
    //   624: putfield 271	com/tencent/mm/pointers/PBool:value	Z
    //   627: aconst_null
    //   628: astore_1
    //   629: goto -328 -> 301
    //   632: aload 18
    //   634: getfield 387	com/tencent/mm/protocal/protobuf/if:xbt	J
    //   637: lconst_0
    //   638: lcmp
    //   639: ifne +22 -> 661
    //   642: aload 18
    //   644: getfield 390	com/tencent/mm/protocal/protobuf/if:xbr	I
    //   647: ifeq +14 -> 661
    //   650: aload 18
    //   652: aload 18
    //   654: getfield 390	com/tencent/mm/protocal/protobuf/if:xbr	I
    //   657: i2l
    //   658: putfield 387	com/tencent/mm/protocal/protobuf/if:xbt	J
    //   661: aload 18
    //   663: getfield 387	com/tencent/mm/protocal/protobuf/if:xbt	J
    //   666: lconst_0
    //   667: lcmp
    //   668: ifeq +77 -> 745
    //   671: invokestatic 321	com/tencent/mm/plugin/backup/h/d:bIY	()Lcom/tencent/mm/plugin/backup/h/d;
    //   674: invokevirtual 325	com/tencent/mm/plugin/backup/h/d:bIZ	()Lcom/tencent/mm/plugin/backup/h/b;
    //   677: invokevirtual 394	com/tencent/mm/plugin/backup/h/b:azs	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/i;
    //   680: aload_1
    //   681: getfield 348	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   684: aload 18
    //   686: getfield 387	com/tencent/mm/protocal/protobuf/if:xbt	J
    //   689: invokeinterface 400 4 0
    //   694: astore 15
    //   696: aload 15
    //   698: getfield 403	com/tencent/mm/g/c/ei:field_msgId	J
    //   701: lconst_0
    //   702: lcmp
    //   703: ifeq +56 -> 759
    //   706: ldc_w 304
    //   709: ldc_w 405
    //   712: iconst_3
    //   713: anewarray 4	java/lang/Object
    //   716: dup
    //   717: iconst_0
    //   718: aload 18
    //   720: getfield 266	com/tencent/mm/protocal/protobuf/if:nEf	I
    //   723: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   726: aastore
    //   727: dup
    //   728: iconst_1
    //   729: aload 14
    //   731: aastore
    //   732: dup
    //   733: iconst_2
    //   734: aload 13
    //   736: aastore
    //   737: invokestatic 166	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   740: aconst_null
    //   741: astore_1
    //   742: goto -441 -> 301
    //   745: ldc_w 304
    //   748: ldc_w 407
    //   751: invokestatic 384	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   754: aconst_null
    //   755: astore_1
    //   756: goto -455 -> 301
    //   759: ldc_w 304
    //   762: ldc_w 409
    //   765: iconst_3
    //   766: anewarray 4	java/lang/Object
    //   769: dup
    //   770: iconst_0
    //   771: aload 18
    //   773: getfield 266	com/tencent/mm/protocal/protobuf/if:nEf	I
    //   776: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   779: aastore
    //   780: dup
    //   781: iconst_1
    //   782: aload 14
    //   784: aastore
    //   785: dup
    //   786: iconst_2
    //   787: aload 13
    //   789: aastore
    //   790: invokestatic 166	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   793: aload 15
    //   795: aload 18
    //   797: getfield 387	com/tencent/mm/protocal/protobuf/if:xbt	J
    //   800: invokevirtual 415	com/tencent/mm/storage/bu:qz	(J)V
    //   803: aload 15
    //   805: aload 18
    //   807: getfield 418	com/tencent/mm/protocal/protobuf/if:FAQ	I
    //   810: i2l
    //   811: invokevirtual 421	com/tencent/mm/storage/bu:qC	(J)V
    //   814: aload 18
    //   816: getfield 424	com/tencent/mm/protocal/protobuf/if:FAS	J
    //   819: lconst_0
    //   820: lcmp
    //   821: ifeq +217 -> 1038
    //   824: aload 18
    //   826: getfield 424	com/tencent/mm/protocal/protobuf/if:FAS	J
    //   829: lstore 10
    //   831: lload 10
    //   833: aload_3
    //   834: getfield 429	android/util/Pair:first	Ljava/lang/Object;
    //   837: checkcast 431	com/tencent/mm/pointers/PLong
    //   840: getfield 433	com/tencent/mm/pointers/PLong:value	J
    //   843: lcmp
    //   844: ifeq +209 -> 1053
    //   847: aload_3
    //   848: getfield 429	android/util/Pair:first	Ljava/lang/Object;
    //   851: checkcast 431	com/tencent/mm/pointers/PLong
    //   854: lload 10
    //   856: putfield 433	com/tencent/mm/pointers/PLong:value	J
    //   859: aload_3
    //   860: getfield 436	android/util/Pair:second	Ljava/lang/Object;
    //   863: checkcast 431	com/tencent/mm/pointers/PLong
    //   866: lload 10
    //   868: putfield 433	com/tencent/mm/pointers/PLong:value	J
    //   871: aload 15
    //   873: lload 10
    //   875: invokevirtual 439	com/tencent/mm/storage/bu:qA	(J)V
    //   878: aload 15
    //   880: aload 18
    //   882: getfield 442	com/tencent/mm/protocal/protobuf/if:FAT	I
    //   885: invokevirtual 445	com/tencent/mm/storage/bu:setFlag	(I)V
    //   888: aload 15
    //   890: aload 18
    //   892: getfield 266	com/tencent/mm/protocal/protobuf/if:nEf	I
    //   895: invokevirtual 448	com/tencent/mm/storage/bu:setType	(I)V
    //   898: iload 8
    //   900: ifeq +304 -> 1204
    //   903: iconst_1
    //   904: istore 9
    //   906: aload 15
    //   908: iload 9
    //   910: invokevirtual 451	com/tencent/mm/storage/bu:kr	(I)V
    //   913: aload 15
    //   915: aload_1
    //   916: getfield 348	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   919: invokevirtual 454	com/tencent/mm/storage/bu:tN	(Ljava/lang/String;)V
    //   922: iload 8
    //   924: ifeq +286 -> 1210
    //   927: aload 18
    //   929: getfield 457	com/tencent/mm/protocal/protobuf/if:FAI	I
    //   932: istore 9
    //   934: aload 15
    //   936: iload 9
    //   938: invokevirtual 460	com/tencent/mm/storage/bu:setStatus	(I)V
    //   941: aload_2
    //   942: aload_1
    //   943: getfield 348	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   946: invokevirtual 464	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   949: ifnonnull +16 -> 965
    //   952: aload_2
    //   953: aload_1
    //   954: getfield 348	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   957: iconst_0
    //   958: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   961: invokevirtual 468	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   964: pop
    //   965: iload 8
    //   967: ifne +41 -> 1008
    //   970: aload 18
    //   972: getfield 457	com/tencent/mm/protocal/protobuf/if:FAI	I
    //   975: iconst_3
    //   976: if_icmpne +32 -> 1008
    //   979: aload_2
    //   980: aload_1
    //   981: getfield 348	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   984: aload_2
    //   985: aload_1
    //   986: getfield 348	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   989: invokevirtual 464	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   992: checkcast 147	java/lang/Integer
    //   995: iconst_0
    //   996: invokestatic 471	com/tencent/mm/sdk/platformtools/bt:a	(Ljava/lang/Integer;I)I
    //   999: iconst_1
    //   1000: iadd
    //   1001: invokestatic 151	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1004: invokevirtual 468	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1007: pop
    //   1008: invokestatic 477	com/tencent/mm/plugin/backup/f/c:bIf	()Lcom/tencent/mm/plugin/backup/f/c;
    //   1011: aload 18
    //   1013: getfield 266	com/tencent/mm/protocal/protobuf/if:nEf	I
    //   1016: invokevirtual 481	com/tencent/mm/plugin/backup/f/c:xx	(I)Lcom/tencent/mm/plugin/backup/f/l;
    //   1019: astore_1
    //   1020: aload_1
    //   1021: ifnonnull +61 -> 1082
    //   1024: ldc_w 304
    //   1027: ldc_w 483
    //   1030: invokestatic 485	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1033: aconst_null
    //   1034: astore_1
    //   1035: goto -734 -> 301
    //   1038: aload 18
    //   1040: getfield 488	com/tencent/mm/protocal/protobuf/if:FAJ	I
    //   1043: i2l
    //   1044: ldc2_w 489
    //   1047: lmul
    //   1048: lstore 10
    //   1050: goto -219 -> 831
    //   1053: aload_3
    //   1054: getfield 436	android/util/Pair:second	Ljava/lang/Object;
    //   1057: checkcast 431	com/tencent/mm/pointers/PLong
    //   1060: getfield 433	com/tencent/mm/pointers/PLong:value	J
    //   1063: lconst_1
    //   1064: ladd
    //   1065: lstore 10
    //   1067: aload_3
    //   1068: getfield 436	android/util/Pair:second	Ljava/lang/Object;
    //   1071: checkcast 431	com/tencent/mm/pointers/PLong
    //   1074: lload 10
    //   1076: putfield 433	com/tencent/mm/pointers/PLong:value	J
    //   1079: goto -208 -> 871
    //   1082: aload_1
    //   1083: aload 4
    //   1085: aload 18
    //   1087: aload 15
    //   1089: invokeinterface 495 4 0
    //   1094: pop
    //   1095: aload 15
    //   1097: astore_1
    //   1098: goto -797 -> 301
    //   1101: invokestatic 498	com/tencent/mm/plugin/backup/c/e:bHz	()V
    //   1104: ldc_w 500
    //   1107: invokestatic 506	com/tencent/mm/kernel/g:ad	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   1110: checkcast 500	com/tencent/mm/chatroom/plugin/PluginChatroomUI
    //   1113: aload 12
    //   1115: invokevirtual 509	com/tencent/mm/chatroom/plugin/PluginChatroomUI:handleChatroomBackup	(Ljava/lang/String;)V
    //   1118: aload 16
    //   1120: getfield 195	com/tencent/mm/protocal/protobuf/ig:nDj	Ljava/util/LinkedList;
    //   1123: invokevirtual 512	java/util/LinkedList:size	()I
    //   1126: istore 7
    //   1128: sipush 21261
    //   1131: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1134: iload 7
    //   1136: ireturn
    //   1137: astore_3
    //   1138: goto -924 -> 214
    //   1141: aload 5
    //   1143: astore_1
    //   1144: goto +32 -> 1176
    //   1147: aload 5
    //   1149: astore_1
    //   1150: goto -518 -> 632
    //   1153: aload 13
    //   1155: astore 14
    //   1157: aload 13
    //   1159: ifnonnull -765 -> 394
    //   1162: ldc_w 302
    //   1165: astore 14
    //   1167: goto -773 -> 394
    //   1170: iconst_1
    //   1171: istore 8
    //   1173: goto -675 -> 498
    //   1176: iload 8
    //   1178: ifeq +16 -> 1194
    //   1181: aload 13
    //   1183: astore 15
    //   1185: goto -655 -> 530
    //   1188: iconst_0
    //   1189: istore 8
    //   1191: goto -693 -> 498
    //   1194: aload 14
    //   1196: astore 15
    //   1198: goto -668 -> 530
    //   1201: goto -569 -> 632
    //   1204: iconst_0
    //   1205: istore 9
    //   1207: goto -301 -> 906
    //   1210: iconst_4
    //   1211: istore 9
    //   1213: goto -279 -> 934
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1216	0	this	d
    //   0	1216	2	paramHashMap	HashMap<String, Integer>
    //   0	1216	3	paramPair	Pair<PLong, PLong>
    //   0	1216	4	paramString2	String
    //   0	1216	5	paramPString	PString
    //   0	1216	6	paramPBool	PBool
    //   43	1092	7	i	int
    //   898	292	8	j	int
    //   904	308	9	k	int
    //   829	246	10	l	long
    //   12	1102	12	localObject1	Object
    //   361	821	13	str	String
    //   351	844	14	localObject2	Object
    //   531	666	15	localObject3	Object
    //   29	1090	16	localig	com.tencent.mm.protocal.protobuf.ig
    //   55	13	17	localIterator	Iterator
    //   77	1009	18	localif	if
    // Exception table:
    //   from	to	target	type
    //   14	31	103	java/lang/Exception
    //   86	95	332	finally
    //   274	276	332	finally
    //   333	335	332	finally
    //   291	299	461	java/lang/Exception
    //   310	315	461	java/lang/Exception
    //   343	379	461	java/lang/Exception
    //   394	416	461	java/lang/Exception
    //   421	461	461	java/lang/Exception
    //   481	495	461	java/lang/Exception
    //   503	514	461	java/lang/Exception
    //   519	527	461	java/lang/Exception
    //   530	571	461	java/lang/Exception
    //   576	595	461	java/lang/Exception
    //   595	627	461	java/lang/Exception
    //   632	661	461	java/lang/Exception
    //   661	740	461	java/lang/Exception
    //   745	754	461	java/lang/Exception
    //   759	831	461	java/lang/Exception
    //   831	871	461	java/lang/Exception
    //   871	898	461	java/lang/Exception
    //   906	922	461	java/lang/Exception
    //   927	934	461	java/lang/Exception
    //   934	965	461	java/lang/Exception
    //   970	1008	461	java/lang/Exception
    //   1008	1020	461	java/lang/Exception
    //   1024	1033	461	java/lang/Exception
    //   1038	1050	461	java/lang/Exception
    //   1053	1079	461	java/lang/Exception
    //   1082	1095	461	java/lang/Exception
    //   110	120	1137	java/lang/Exception
    //   122	151	1137	java/lang/Exception
    //   153	181	1137	java/lang/Exception
    //   183	212	1137	java/lang/Exception
  }
  
  /* Error */
  private boolean bHs()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 65	com/tencent/mm/plugin/backup/c/d:nug	Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +7 -> 17
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 65	com/tencent/mm/plugin/backup/c/d:nug	Z
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
  
  private void bHt()
  {
    try
    {
      this.nug = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void bHu()
  {
    AppMethodBeat.i(21264);
    ad.i("MicroMsg.BackupRecoverMerger", "backupFinishMerge");
    com.tencent.mm.sdk.b.a.IbL.l(new by());
    com.tencent.mm.sdk.b.a.IbL.l(new ac());
    com.tencent.mm.plugin.backup.h.a locala = com.tencent.mm.plugin.backup.h.d.bIY().bJa();
    locala.handler.post(new a.1(locala));
    ba.aBQ();
    com.tencent.mm.model.c.azs().dlU();
    com.tencent.mm.sdk.b.a.IbL.l(new ts());
    com.tencent.mm.sdk.a.b.wA(false);
    AppMethodBeat.o(21264);
  }
  
  public static void bHv()
  {
    AppMethodBeat.i(21265);
    com.tencent.mm.plugin.backup.h.d.bIY().bIZ().azs().apS("BACKUP_MERGE_LOCK");
    AppMethodBeat.o(21265);
  }
  
  public static void bHw()
  {
    AppMethodBeat.i(21266);
    com.tencent.mm.plugin.backup.h.d.bIY().bIZ().azs().apT("BACKUP_MERGE_LOCK");
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
  
  private static List<if> j(String paramString, List<if> paramList)
  {
    AppMethodBeat.i(193140);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = paramList.iterator();
    paramList = null;
    while (localIterator.hasNext())
    {
      if localif = (if)localIterator.next();
      Object localObject;
      if ((localif.nEf == 49) && (k.b.yr(localif.Fvk.HoB).type == 62))
      {
        localObject = paramList;
        if (paramList == null) {
          localObject = new LinkedList();
        }
        ((List)localObject).add(localif);
        paramList = (List<if>)localObject;
      }
      else
      {
        localObject = paramList;
        if (paramList != null)
        {
          localObject = paramList;
          if (!paramList.isEmpty())
          {
            paramList = k(paramString, paramList);
            if (paramList != null) {
              localLinkedList.add(paramList);
            }
            localObject = null;
          }
        }
        localLinkedList.add(localif);
        paramList = (List<if>)localObject;
      }
    }
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramString = k(paramString, paramList);
      if (paramString != null) {
        localLinkedList.add(paramString);
      }
    }
    AppMethodBeat.o(193140);
    return localLinkedList;
  }
  
  private static if k(String paramString, List<if> paramList)
  {
    AppMethodBeat.i(193141);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if localif = (if)paramList.get(0);
      cif localcif1 = new cif();
      localcif1.fFR = paramString;
      paramString = paramList.iterator();
      while (paramString.hasNext())
      {
        paramList = (if)paramString.next();
        cif localcif2 = com.tencent.mm.util.e.aXV(paramList.Fvk.HoB);
        ad.d("MicroMsg.BackupRecoverMerger", "find %s pat record in msg", new Object[] { paramList.Fwt });
        localcif1.vox.addAll(localcif2.vox);
      }
      paramString = new k.b();
      paramList = new com.tencent.mm.plugin.patmsg.a.a();
      paramList.wFH = localcif1;
      paramString.a(paramList);
      paramString.type = 62;
      paramString.title = aj.getContext().getString(2131760809);
      paramString.url = aj.getContext().getString(2131760810);
      paramList = new cwt();
      paramList.aPy(bt.bI(k.b.a(paramString, "", null), ""));
      localif.Fvk = paramList;
      AppMethodBeat.o(193141);
      return localif;
    }
    AppMethodBeat.o(193141);
    return null;
  }
  
  public final void iA(final boolean paramBoolean)
  {
    AppMethodBeat.i(21260);
    if (bHs())
    {
      ad.e("MicroMsg.BackupRecoverMerger", "Already start merge, return.");
      AppMethodBeat.o(21260);
      return;
    }
    ad.i("MicroMsg.BackupRecoverMerger", "startMerge");
    this.nsU = 0L;
    com.tencent.mm.sdk.a.b.wA(true);
    this.ntw.bGY();
    ba.getNotification().cz(true);
    this.nun = nup;
    if (this.nsF == 1)
    {
      ba.aBQ();
      com.tencent.mm.model.c.ajl().set(al.a.Ixe, Boolean.TRUE);
    }
    for (;;)
    {
      ad.i("MicroMsg.BackupRecoverMerger", "startMergeImpl start, mergeState[%d], totalMsgList[%d], msgListDataIdHashMap[%d]", new Object[] { Integer.valueOf(this.nun), Long.valueOf(this.nuk), Integer.valueOf(this.nuh.size()) });
      com.tencent.e.h.LTJ.aU(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "BackupRecoverMerger";
        }
        
        public final void run()
        {
          AppMethodBeat.i(21256);
          e.reset();
          e.bHA();
          if ((g.ntc) && (paramBoolean) && (com.tencent.mm.vfs.i.fv(g.bHl())) && (com.tencent.mm.vfs.i.de(g.bHl(), false) != null))
          {
            g.VO(g.bHk());
            com.tencent.mm.vfs.i.mB(g.bHl(), g.bHk());
          }
          Object localObject1 = new HashMap();
          Object localObject2 = (String)com.tencent.mm.plugin.backup.h.d.bIY().bIZ().ajl().get(2, null);
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
              l2 = bt.flT();
              d.bHv();
              Object localObject3 = d.b(d.this);
              if (com.tencent.mm.plugin.backup.h.d.bIY().bIZ().gBq != null)
              {
                ((d.a)localObject3).nuy = com.tencent.mm.plugin.backup.h.d.bIY().bIZ().gBq.xO(Thread.currentThread().getId());
                ((d.a)localObject3).guj = true;
              }
              localObject3 = g.VP(str) + str;
              PString localPString = new PString();
              PBool localPBool = new PBool();
              Pair localPair = new Pair(new PLong(-1L), new PLong(-1L));
              try
              {
                l3 = d.a(d.this, (String)localObject3, (HashMap)localObject1, localPair, (String)localObject2, localPString, localPBool);
                if (l3 < 0L) {
                  ad.e("MicroMsg.BackupRecoverMerger", "msgListMsgCount error, msgListMsgCount:%d, itemPath:%s", new Object[] { Long.valueOf(l3), localObject3 });
                }
                if (!d.c(d.this)) {
                  break label468;
                }
                ad.e("MicroMsg.BackupRecoverMerger", "startMergeImpl cancel, msgDataId[%s], transferMsgList[%d], totalMsgList[%d], transferSessions[%d], totalSession[%d]", new Object[] { str, Long.valueOf(d.d(d.this)), Long.valueOf(d.e(d.this)), Integer.valueOf(d.f(d.this).size()), Integer.valueOf(d.g(d.this)) });
                d.b(d.this).end();
                d.bHw();
                com.tencent.mm.plugin.backup.h.c.g((HashMap)localObject1);
                d.a(d.this, d.h(d.this), d.i(d.this));
                AppMethodBeat.o(21256);
                return;
              }
              catch (Exception localException)
              {
                ad.printErrStackTrace("MicroMsg.BackupRecoverMerger", localException, "startMergeImpl MMThread.run():", new Object[0]);
              }
              if (!com.tencent.mm.sdk.a.b.fjN()) {
                continue;
              }
              AppMethodBeat.o(21256);
              throw localException;
              d.a(d.this, d.j(d.this) + l3);
              d.f(d.this).add(d.a(d.this).get(localException));
              d.k(d.this);
              d.l(d.this).bGX().nsJ = 26;
              localObject3 = d.l(d.this).bGX();
              if (d.d(d.this) > d.e(d.this))
              {
                l1 = 100L;
                label566:
                ((com.tencent.mm.plugin.backup.b.e)localObject3).nsM = ((int)l1);
                d.this.xr(26);
                d.b(d.this).end();
                d.bHw();
              }
            }
            try
            {
              Thread.sleep(10L);
              label601:
              ad.i("MicroMsg.BackupRecoverMerger", "startMergeImpl msgDataId[%s] merge finish, transferMsgList[%d], transferSessions[%d], msgListMsgCount:%d, receiveMsgCount:%d, costTime:%d", new Object[] { localException, Long.valueOf(d.d(d.this)), Integer.valueOf(d.f(d.this).size()), Long.valueOf(l3), Long.valueOf(d.j(d.this)), Long.valueOf(bt.Df(l2)) });
              continue;
              l1 = d.d(d.this) * 100L / d.e(d.this);
              break label566;
              d.l(d.this).bGX().nsU = d.j(d.this);
              localObject2 = d.l(d.this).bGX();
              if (d.f(d.this).size() > d.g(d.this))
              {
                i = d.g(d.this);
                ((com.tencent.mm.plugin.backup.b.e)localObject2).nsK = i;
                d.l(d.this).bGX().nsL = d.g(d.this);
                localObject2 = d.l(d.this).bGX();
                if (d.d(d.this) <= d.e(d.this)) {
                  break label1143;
                }
                l1 = 100L;
                label826:
                ((com.tencent.mm.plugin.backup.b.e)localObject2).nsM = ((int)l1);
                d.this.xr(30);
                com.tencent.mm.plugin.backup.h.c.g((HashMap)localObject1);
                ad.i("MicroMsg.BackupRecoverMerger", "startMergeImpl buildConversation finish! transferMsgList[%d], totalMsgList[%d], transferSession[%d], totalSession[%d]", new Object[] { Long.valueOf(d.d(d.this)), Long.valueOf(d.e(d.this)), Integer.valueOf(d.f(d.this).size()), Integer.valueOf(d.g(d.this)) });
                d.b(d.this).end();
                if (d.m(d.this) != d.bHx())
                {
                  d.a(d.this, d.bHx());
                  d.bHu();
                  if (d.n(d.this) != 1) {
                    break label1166;
                  }
                  ba.aBQ();
                  com.tencent.mm.model.c.ajl().set(al.a.Ixe, Boolean.FALSE);
                  label978:
                  if (d.o(d.this) != null) {
                    d.o(d.this).bGW();
                  }
                  localObject1 = d.l(d.this).bGX();
                  if (d.f(d.this).size() <= d.g(d.this)) {
                    break label1196;
                  }
                }
              }
              label1166:
              label1196:
              for (int i = d.g(d.this);; i = d.f(d.this).size())
              {
                ((com.tencent.mm.plugin.backup.b.e)localObject1).R(27, i, d.g(d.this));
                d.this.xr(27);
                g.bHj();
                if (!g.ntc)
                {
                  g.VO(g.bHk());
                  g.bHi();
                }
                d.a(d.this, d.bHy());
                d.p(d.this);
                ba.getNotification().cz(false);
                d.l(d.this).bGZ();
                ad.fku();
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
                ba.aBQ();
                com.tencent.mm.model.c.ajl().set(al.a.Ixh, Boolean.FALSE);
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
      if (this.nsF == 2)
      {
        ba.aBQ();
        com.tencent.mm.model.c.ajl().set(al.a.Ixh, Boolean.TRUE);
      }
    }
  }
  
  public final void w(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(21262);
    synchronized (this.lock)
    {
      ad.i("MicroMsg.BackupRecoverMerger", "cancel, needClearContinueRecoverData[%b], mergeState[%d], updateState[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(this.nun), Integer.valueOf(paramInt) });
      this.hjP = true;
      this.nuu = paramBoolean;
      this.nuv = paramInt;
      ba.getNotification().cz(false);
      this.ntw.bGZ();
      AppMethodBeat.o(21262);
      return;
    }
  }
  
  public final void xr(int paramInt)
  {
    AppMethodBeat.i(21263);
    if (this.num != null) {
      this.num.xp(paramInt);
    }
    AppMethodBeat.o(21263);
  }
  
  final class a
  {
    boolean guj = false;
    long nuy = -1L;
    
    private a() {}
    
    public final void end()
    {
      AppMethodBeat.i(21257);
      if ((this.guj) && (com.tencent.mm.plugin.backup.h.d.bIY().bIZ().gBq != null))
      {
        com.tencent.mm.plugin.backup.h.d.bIY().bIZ().gBq.sJ(this.nuy);
        this.guj = false;
      }
      AppMethodBeat.o(21257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.c.d
 * JD-Core Version:    0.7.0.1
 */