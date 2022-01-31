package com.tencent.mm.plugin.dbbackup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.c;

final class d$3
  implements Runnable
{
  final String[] kUq;
  
  d$3(d paramd, c paramc, String paramString, b paramb)
  {
    AppMethodBeat.i(18971);
    this.kUq = new String[] { "message", "ImgInfo2", "videoinfo2", "EmojiInfo", "conversation", "rconversation" };
    AppMethodBeat.o(18971);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: sipush 18972
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   10: aconst_null
    //   11: invokestatic 67	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RepairKit;)Lcom/tencent/wcdb/repair/RepairKit;
    //   14: pop
    //   15: invokestatic 73	com/tencent/mm/model/c:YC	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/h;
    //   18: pop
    //   19: invokestatic 77	com/tencent/mm/model/c:YF	()Lcom/tencent/mm/storage/be;
    //   22: pop
    //   23: invokestatic 83	com/tencent/mm/at/o:ahC	()Lcom/tencent/mm/at/g;
    //   26: pop
    //   27: invokestatic 89	com/tencent/mm/modelvideo/o:alE	()Lcom/tencent/mm/modelvideo/t;
    //   30: pop
    //   31: new 91	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   38: iconst_1
    //   39: invokestatic 98	com/tencent/mm/compatible/e/q:bP	(Z)Ljava/lang/String;
    //   42: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokestatic 106	com/tencent/mm/model/c:getUin	()I
    //   48: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokevirtual 117	java/lang/String:getBytes	()[B
    //   57: astore 7
    //   59: aload 7
    //   61: invokestatic 123	com/tencent/mm/a/g:x	([B)[B
    //   64: astore 13
    //   66: aload 7
    //   68: invokestatic 127	com/tencent/mm/a/g:w	([B)Ljava/lang/String;
    //   71: iconst_0
    //   72: bipush 7
    //   74: invokevirtual 131	java/lang/String:substring	(II)Ljava/lang/String;
    //   77: invokevirtual 117	java/lang/String:getBytes	()[B
    //   80: astore 12
    //   82: ldc 132
    //   84: istore_1
    //   85: invokestatic 138	com/tencent/mm/cg/f:dzP	()Z
    //   88: ifeq +6 -> 94
    //   91: ldc 139
    //   93: istore_1
    //   94: invokestatic 143	com/tencent/mm/model/c:Rq	()Lcom/tencent/mm/cg/h;
    //   97: invokevirtual 149	com/tencent/mm/cg/h:dzV	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   100: invokevirtual 154	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   103: aload 12
    //   105: invokestatic 158	com/tencent/mm/plugin/dbbackup/d:biT	()Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   108: aconst_null
    //   109: iload_1
    //   110: aconst_null
    //   111: iconst_0
    //   112: invokestatic 162	com/tencent/wcdb/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;ILcom/tencent/wcdb/DatabaseErrorHandler;I)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   115: astore 11
    //   117: invokestatic 168	java/lang/System:nanoTime	()J
    //   120: lstore_3
    //   121: new 91	java/lang/StringBuilder
    //   124: dup
    //   125: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   128: aload_0
    //   129: getfield 29	com/tencent/mm/plugin/dbbackup/d$3:kUr	Ljava/lang/String;
    //   132: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc 170
    //   137: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: astore 14
    //   145: new 91	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   152: astore 7
    //   154: invokestatic 176	com/tencent/mm/kernel/g:RM	()Lcom/tencent/mm/kernel/g;
    //   157: pop
    //   158: aload 7
    //   160: invokestatic 180	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   163: getfield 185	com/tencent/mm/kernel/e:eHR	Ljava/lang/String;
    //   166: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc 187
    //   171: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore 15
    //   179: iconst_0
    //   180: istore_1
    //   181: aconst_null
    //   182: astore 7
    //   184: aload 7
    //   186: astore 10
    //   188: iload_1
    //   189: iconst_2
    //   190: if_icmpge +61 -> 251
    //   193: iconst_2
    //   194: anewarray 42	java/lang/String
    //   197: dup
    //   198: iconst_0
    //   199: aload 14
    //   201: aastore
    //   202: dup
    //   203: iconst_1
    //   204: aload 15
    //   206: aastore
    //   207: iload_1
    //   208: aaload
    //   209: astore 9
    //   211: aload 7
    //   213: astore 8
    //   215: aload 9
    //   217: aload 13
    //   219: aload_0
    //   220: getfield 56	com/tencent/mm/plugin/dbbackup/d$3:kUq	[Ljava/lang/String;
    //   223: invokestatic 193	com/tencent/wcdb/repair/RepairKit$MasterInfo:load	(Ljava/lang/String;[B[Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
    //   226: astore 10
    //   228: aload 10
    //   230: astore 8
    //   232: aload 10
    //   234: astore 7
    //   236: ldc 195
    //   238: ldc 197
    //   240: aload 9
    //   242: invokestatic 201	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   245: invokevirtual 205	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   248: invokestatic 210	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: aload 10
    //   253: ifnonnull +399 -> 652
    //   256: aload 10
    //   258: astore 9
    //   260: aload 10
    //   262: astore 7
    //   264: aload_0
    //   265: getfield 56	com/tencent/mm/plugin/dbbackup/d$3:kUq	[Ljava/lang/String;
    //   268: invokestatic 214	com/tencent/wcdb/repair/RepairKit$MasterInfo:make	([Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
    //   271: astore 8
    //   273: aload 8
    //   275: astore 9
    //   277: aload 8
    //   279: astore 7
    //   281: ldc 195
    //   283: ldc 216
    //   285: invokestatic 218	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload 8
    //   290: astore 9
    //   292: aload 8
    //   294: astore 7
    //   296: getstatic 224	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   299: ldc2_w 225
    //   302: ldc2_w 227
    //   305: lconst_1
    //   306: iconst_1
    //   307: invokevirtual 232	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   310: aload 8
    //   312: astore 9
    //   314: aload 8
    //   316: astore 7
    //   318: aload_0
    //   319: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   322: new 234	com/tencent/wcdb/repair/RepairKit
    //   325: dup
    //   326: aload_0
    //   327: getfield 29	com/tencent/mm/plugin/dbbackup/d$3:kUr	Ljava/lang/String;
    //   330: aload 12
    //   332: invokestatic 158	com/tencent/mm/plugin/dbbackup/d:biT	()Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   335: aload 8
    //   337: invokespecial 237	com/tencent/wcdb/repair/RepairKit:<init>	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;)V
    //   340: invokestatic 67	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RepairKit;)Lcom/tencent/wcdb/repair/RepairKit;
    //   343: pop
    //   344: aload 8
    //   346: astore 9
    //   348: aload 8
    //   350: astore 7
    //   352: aload_0
    //   353: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   356: invokestatic 241	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   359: aload 11
    //   361: iconst_1
    //   362: invokevirtual 245	com/tencent/wcdb/repair/RepairKit:output	(Lcom/tencent/wcdb/database/SQLiteDatabase;I)I
    //   365: ifne +501 -> 866
    //   368: iconst_1
    //   369: istore_1
    //   370: aload 8
    //   372: astore 9
    //   374: aload 8
    //   376: astore 7
    //   378: aload_0
    //   379: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   382: invokestatic 241	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   385: invokevirtual 248	com/tencent/wcdb/repair/RepairKit:isHeaderCorrupted	()Z
    //   388: ifeq +715 -> 1103
    //   391: aload 8
    //   393: astore 9
    //   395: aload 8
    //   397: astore 7
    //   399: aload_0
    //   400: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   403: invokestatic 241	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   406: invokevirtual 251	com/tencent/wcdb/repair/RepairKit:isDataCorrupted	()Z
    //   409: ifne +462 -> 871
    //   412: goto +691 -> 1103
    //   415: iload_1
    //   416: iload_2
    //   417: iand
    //   418: istore_1
    //   419: aload 8
    //   421: astore 9
    //   423: aload 8
    //   425: astore 7
    //   427: aload 11
    //   429: invokevirtual 254	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   432: aconst_null
    //   433: astore 9
    //   435: aload 8
    //   437: invokevirtual 257	com/tencent/wcdb/repair/RepairKit$MasterInfo:release	()V
    //   440: aconst_null
    //   441: astore 10
    //   443: aconst_null
    //   444: astore 8
    //   446: aload_0
    //   447: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   450: invokestatic 241	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   453: invokevirtual 258	com/tencent/wcdb/repair/RepairKit:release	()V
    //   456: aload_0
    //   457: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   460: aconst_null
    //   461: invokestatic 67	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RepairKit;)Lcom/tencent/wcdb/repair/RepairKit;
    //   464: pop
    //   465: invokestatic 261	com/tencent/mm/plugin/dbbackup/d:biR	()V
    //   468: invokestatic 168	java/lang/System:nanoTime	()J
    //   471: lstore 5
    //   473: iload_1
    //   474: ifeq +402 -> 876
    //   477: ldc_w 263
    //   480: astore 7
    //   482: ldc 195
    //   484: ldc_w 265
    //   487: iconst_2
    //   488: anewarray 4	java/lang/Object
    //   491: dup
    //   492: iconst_0
    //   493: aload 7
    //   495: aastore
    //   496: dup
    //   497: iconst_1
    //   498: lload 5
    //   500: lload_3
    //   501: lsub
    //   502: l2f
    //   503: ldc_w 266
    //   506: fdiv
    //   507: invokestatic 271	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   510: aastore
    //   511: invokestatic 274	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   514: iload_1
    //   515: ifeq +369 -> 884
    //   518: bipush 26
    //   520: istore_2
    //   521: iload_2
    //   522: istore_1
    //   523: aload_0
    //   524: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:kUb	Lcom/tencent/mm/plugin/dbbackup/b;
    //   527: ifnull +15 -> 542
    //   530: aload_0
    //   531: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:kUb	Lcom/tencent/mm/plugin/dbbackup/b;
    //   534: iconst_0
    //   535: invokeinterface 279 2 0
    //   540: iload_2
    //   541: istore_1
    //   542: getstatic 224	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   545: ldc2_w 225
    //   548: iload_1
    //   549: i2l
    //   550: lconst_1
    //   551: iconst_1
    //   552: invokevirtual 232	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   555: aload_0
    //   556: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   559: invokestatic 241	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   562: ifnull +22 -> 584
    //   565: aload_0
    //   566: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   569: invokestatic 241	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   572: invokevirtual 258	com/tencent/wcdb/repair/RepairKit:release	()V
    //   575: aload_0
    //   576: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   579: aconst_null
    //   580: invokestatic 67	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RepairKit;)Lcom/tencent/wcdb/repair/RepairKit;
    //   583: pop
    //   584: aload_0
    //   585: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   588: invokestatic 283	com/tencent/mm/plugin/dbbackup/d:c	(Lcom/tencent/mm/plugin/dbbackup/d;)Z
    //   591: pop
    //   592: invokestatic 289	com/tencent/mm/model/aw:RO	()Lcom/tencent/mm/sdk/platformtools/al;
    //   595: invokevirtual 294	com/tencent/mm/sdk/platformtools/al:dtd	()V
    //   598: sipush 18972
    //   601: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   604: return
    //   605: astore 10
    //   607: aload 8
    //   609: astore 9
    //   611: aload 8
    //   613: astore 7
    //   615: ldc 195
    //   617: new 91	java/lang/StringBuilder
    //   620: dup
    //   621: ldc_w 296
    //   624: invokespecial 299	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   627: aload 10
    //   629: invokevirtual 302	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   632: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   638: invokestatic 304	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   641: iload_1
    //   642: iconst_1
    //   643: iadd
    //   644: istore_1
    //   645: aload 8
    //   647: astore 7
    //   649: goto -465 -> 184
    //   652: aload 10
    //   654: astore 8
    //   656: iload_1
    //   657: ifle -347 -> 310
    //   660: aload 10
    //   662: astore 9
    //   664: aload 10
    //   666: astore 7
    //   668: ldc 195
    //   670: ldc_w 306
    //   673: invokestatic 210	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   676: aload 10
    //   678: astore 9
    //   680: aload 10
    //   682: astore 7
    //   684: getstatic 224	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   687: ldc2_w 225
    //   690: ldc2_w 307
    //   693: lconst_1
    //   694: iconst_1
    //   695: invokevirtual 232	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   698: aload 10
    //   700: astore 8
    //   702: goto -392 -> 310
    //   705: astore 7
    //   707: aload 9
    //   709: astore 8
    //   711: aload 11
    //   713: astore 9
    //   715: ldc 195
    //   717: aload 7
    //   719: ldc_w 310
    //   722: iconst_1
    //   723: anewarray 4	java/lang/Object
    //   726: dup
    //   727: iconst_0
    //   728: aload_0
    //   729: getfield 29	com/tencent/mm/plugin/dbbackup/d$3:kUr	Ljava/lang/String;
    //   732: aastore
    //   733: invokestatic 314	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   736: aload_0
    //   737: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:kUb	Lcom/tencent/mm/plugin/dbbackup/b;
    //   740: ifnull +13 -> 753
    //   743: aload_0
    //   744: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:kUb	Lcom/tencent/mm/plugin/dbbackup/b;
    //   747: iconst_m1
    //   748: invokeinterface 279 2 0
    //   753: getstatic 224	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   756: ldc_w 316
    //   759: new 91	java/lang/StringBuilder
    //   762: dup
    //   763: ldc_w 318
    //   766: invokespecial 299	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   769: invokestatic 321	com/tencent/wcdb/repair/RepairKit:lastError	()Ljava/lang/String;
    //   772: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   778: aconst_null
    //   779: invokevirtual 325	com/tencent/mm/plugin/report/service/h:g	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   782: getstatic 224	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   785: ldc2_w 225
    //   788: ldc2_w 326
    //   791: lconst_1
    //   792: iconst_1
    //   793: invokevirtual 232	com/tencent/mm/plugin/report/service/h:idkeyStat	(JJJZ)V
    //   796: aload_0
    //   797: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   800: invokestatic 241	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   803: ifnull +22 -> 825
    //   806: aload_0
    //   807: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   810: invokestatic 241	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   813: invokevirtual 258	com/tencent/wcdb/repair/RepairKit:release	()V
    //   816: aload_0
    //   817: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   820: aconst_null
    //   821: invokestatic 67	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RepairKit;)Lcom/tencent/wcdb/repair/RepairKit;
    //   824: pop
    //   825: aload 9
    //   827: ifnull +8 -> 835
    //   830: aload 9
    //   832: invokevirtual 254	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   835: aload 8
    //   837: ifnull +8 -> 845
    //   840: aload 8
    //   842: invokevirtual 257	com/tencent/wcdb/repair/RepairKit$MasterInfo:release	()V
    //   845: aload_0
    //   846: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   849: invokestatic 283	com/tencent/mm/plugin/dbbackup/d:c	(Lcom/tencent/mm/plugin/dbbackup/d;)Z
    //   852: pop
    //   853: invokestatic 289	com/tencent/mm/model/aw:RO	()Lcom/tencent/mm/sdk/platformtools/al;
    //   856: invokevirtual 294	com/tencent/mm/sdk/platformtools/al:dtd	()V
    //   859: sipush 18972
    //   862: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   865: return
    //   866: iconst_0
    //   867: istore_1
    //   868: goto -498 -> 370
    //   871: iconst_0
    //   872: istore_2
    //   873: goto -458 -> 415
    //   876: ldc_w 329
    //   879: astore 7
    //   881: goto -399 -> 482
    //   884: bipush 27
    //   886: istore_1
    //   887: aload_0
    //   888: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:kUb	Lcom/tencent/mm/plugin/dbbackup/b;
    //   891: ifnull +13 -> 904
    //   894: aload_0
    //   895: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:kUb	Lcom/tencent/mm/plugin/dbbackup/b;
    //   898: iconst_m1
    //   899: invokeinterface 279 2 0
    //   904: getstatic 224	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
    //   907: ldc_w 316
    //   910: new 91	java/lang/StringBuilder
    //   913: dup
    //   914: ldc_w 318
    //   917: invokespecial 299	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   920: invokestatic 321	com/tencent/wcdb/repair/RepairKit:lastError	()Ljava/lang/String;
    //   923: invokevirtual 102	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   929: aconst_null
    //   930: invokevirtual 325	com/tencent/mm/plugin/report/service/h:g	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   933: goto -391 -> 542
    //   936: astore 7
    //   938: goto -223 -> 715
    //   941: astore 7
    //   943: aconst_null
    //   944: astore 9
    //   946: aconst_null
    //   947: astore 8
    //   949: aload_0
    //   950: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   953: invokestatic 241	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   956: ifnull +22 -> 978
    //   959: aload_0
    //   960: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   963: invokestatic 241	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   966: invokevirtual 258	com/tencent/wcdb/repair/RepairKit:release	()V
    //   969: aload_0
    //   970: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   973: aconst_null
    //   974: invokestatic 67	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RepairKit;)Lcom/tencent/wcdb/repair/RepairKit;
    //   977: pop
    //   978: aload 9
    //   980: ifnull +8 -> 988
    //   983: aload 9
    //   985: invokevirtual 254	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   988: aload 8
    //   990: ifnull +8 -> 998
    //   993: aload 8
    //   995: invokevirtual 257	com/tencent/wcdb/repair/RepairKit$MasterInfo:release	()V
    //   998: aload_0
    //   999: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:kUn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   1002: invokestatic 283	com/tencent/mm/plugin/dbbackup/d:c	(Lcom/tencent/mm/plugin/dbbackup/d;)Z
    //   1005: pop
    //   1006: invokestatic 289	com/tencent/mm/model/aw:RO	()Lcom/tencent/mm/sdk/platformtools/al;
    //   1009: invokevirtual 294	com/tencent/mm/sdk/platformtools/al:dtd	()V
    //   1012: sipush 18972
    //   1015: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1018: aload 7
    //   1020: athrow
    //   1021: astore 7
    //   1023: aconst_null
    //   1024: astore 8
    //   1026: aload 11
    //   1028: astore 9
    //   1030: goto -81 -> 949
    //   1033: astore 9
    //   1035: aload 7
    //   1037: astore 8
    //   1039: aload 9
    //   1041: astore 7
    //   1043: aload 11
    //   1045: astore 9
    //   1047: goto -98 -> 949
    //   1050: astore 7
    //   1052: aconst_null
    //   1053: astore 9
    //   1055: goto -106 -> 949
    //   1058: astore 7
    //   1060: aconst_null
    //   1061: astore 9
    //   1063: aload 10
    //   1065: astore 8
    //   1067: goto -118 -> 949
    //   1070: astore 7
    //   1072: goto -123 -> 949
    //   1075: astore 7
    //   1077: aconst_null
    //   1078: astore 9
    //   1080: aconst_null
    //   1081: astore 8
    //   1083: goto -368 -> 715
    //   1086: astore 7
    //   1088: aload 11
    //   1090: astore 9
    //   1092: aconst_null
    //   1093: astore 8
    //   1095: goto -380 -> 715
    //   1098: astore 7
    //   1100: goto -385 -> 715
    //   1103: iconst_1
    //   1104: istore_2
    //   1105: goto -690 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1108	0	this	3
    //   84	803	1	i	int
    //   416	689	2	j	int
    //   120	381	3	l1	long
    //   471	28	5	l2	long
    //   57	626	7	localObject1	Object
    //   705	13	7	localException1	java.lang.Exception
    //   879	1	7	str1	String
    //   936	1	7	localException2	java.lang.Exception
    //   941	78	7	localObject2	Object
    //   1021	15	7	localObject3	Object
    //   1041	1	7	localObject4	Object
    //   1050	1	7	localObject5	Object
    //   1058	1	7	localObject6	Object
    //   1070	1	7	localObject7	Object
    //   1075	1	7	localException3	java.lang.Exception
    //   1086	1	7	localException4	java.lang.Exception
    //   1098	1	7	localException5	java.lang.Exception
    //   213	881	8	localObject8	Object
    //   209	820	9	localObject9	Object
    //   1033	7	9	localObject10	Object
    //   1045	46	9	localSQLiteDatabase1	com.tencent.wcdb.database.SQLiteDatabase
    //   186	256	10	localObject11	Object
    //   605	459	10	localException6	java.lang.Exception
    //   115	974	11	localSQLiteDatabase2	com.tencent.wcdb.database.SQLiteDatabase
    //   80	251	12	arrayOfByte1	byte[]
    //   64	154	13	arrayOfByte2	byte[]
    //   143	57	14	str2	String
    //   177	28	15	str3	String
    // Exception table:
    //   from	to	target	type
    //   215	228	605	java/lang/Exception
    //   236	251	605	java/lang/Exception
    //   264	273	705	java/lang/Exception
    //   281	288	705	java/lang/Exception
    //   296	310	705	java/lang/Exception
    //   318	344	705	java/lang/Exception
    //   352	368	705	java/lang/Exception
    //   378	391	705	java/lang/Exception
    //   399	412	705	java/lang/Exception
    //   427	432	705	java/lang/Exception
    //   615	641	705	java/lang/Exception
    //   668	676	705	java/lang/Exception
    //   684	698	705	java/lang/Exception
    //   446	473	936	java/lang/Exception
    //   482	514	936	java/lang/Exception
    //   523	540	936	java/lang/Exception
    //   542	555	936	java/lang/Exception
    //   887	904	936	java/lang/Exception
    //   904	933	936	java/lang/Exception
    //   15	82	941	finally
    //   85	91	941	finally
    //   94	117	941	finally
    //   117	179	1021	finally
    //   215	228	1033	finally
    //   236	251	1033	finally
    //   264	273	1033	finally
    //   281	288	1033	finally
    //   296	310	1033	finally
    //   318	344	1033	finally
    //   352	368	1033	finally
    //   378	391	1033	finally
    //   399	412	1033	finally
    //   427	432	1033	finally
    //   615	641	1033	finally
    //   668	676	1033	finally
    //   684	698	1033	finally
    //   435	440	1050	finally
    //   446	473	1058	finally
    //   482	514	1058	finally
    //   523	540	1058	finally
    //   542	555	1058	finally
    //   887	904	1058	finally
    //   904	933	1058	finally
    //   715	753	1070	finally
    //   753	796	1070	finally
    //   15	82	1075	java/lang/Exception
    //   85	91	1075	java/lang/Exception
    //   94	117	1075	java/lang/Exception
    //   117	179	1086	java/lang/Exception
    //   435	440	1098	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.3
 * JD-Core Version:    0.7.0.1
 */