package com.tencent.mm.plugin.dbbackup;

import com.tencent.mm.model.c;

final class d$3
  implements Runnable
{
  final String[] iNq = { "message", "ImgInfo2", "videoinfo2", "EmojiInfo", "conversation", "rconversation" };
  
  d$3(d paramd, c paramc, String paramString, b paramb) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   4: aconst_null
    //   5: invokestatic 58	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RepairKit;)Lcom/tencent/wcdb/repair/RepairKit;
    //   8: pop
    //   9: invokestatic 64	com/tencent/mm/model/c:Fy	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/g;
    //   12: pop
    //   13: invokestatic 68	com/tencent/mm/model/c:FB	()Lcom/tencent/mm/storage/be;
    //   16: pop
    //   17: invokestatic 74	com/tencent/mm/as/o:OJ	()Lcom/tencent/mm/as/g;
    //   20: pop
    //   21: invokestatic 80	com/tencent/mm/modelvideo/o:Sr	()Lcom/tencent/mm/modelvideo/t;
    //   24: pop
    //   25: new 82	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   32: invokestatic 89	com/tencent/mm/compatible/e/q:zf	()Ljava/lang/String;
    //   35: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: invokestatic 97	com/tencent/mm/model/c:CK	()I
    //   41: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   44: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokevirtual 107	java/lang/String:getBytes	()[B
    //   50: astore 7
    //   52: aload 7
    //   54: invokestatic 113	com/tencent/mm/a/g:p	([B)[B
    //   57: astore 13
    //   59: aload 7
    //   61: invokestatic 117	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
    //   64: iconst_0
    //   65: bipush 7
    //   67: invokevirtual 121	java/lang/String:substring	(II)Ljava/lang/String;
    //   70: invokevirtual 107	java/lang/String:getBytes	()[B
    //   73: astore 12
    //   75: ldc 122
    //   77: istore_1
    //   78: invokestatic 128	com/tencent/mm/cf/f:cxc	()Z
    //   81: ifeq +6 -> 87
    //   84: ldc 129
    //   86: istore_1
    //   87: invokestatic 133	com/tencent/mm/model/c:Dv	()Lcom/tencent/mm/cf/h;
    //   90: invokevirtual 139	com/tencent/mm/cf/h:cxg	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   93: invokevirtual 144	com/tencent/wcdb/database/SQLiteDatabase:getPath	()Ljava/lang/String;
    //   96: aload 12
    //   98: invokestatic 148	com/tencent/mm/plugin/dbbackup/d:aFA	()Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   101: aconst_null
    //   102: iload_1
    //   103: aconst_null
    //   104: iconst_0
    //   105: invokestatic 152	com/tencent/wcdb/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;ILcom/tencent/wcdb/DatabaseErrorHandler;I)Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   108: astore 11
    //   110: invokestatic 158	java/lang/System:nanoTime	()J
    //   113: lstore_3
    //   114: new 82	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   121: aload_0
    //   122: getfield 29	com/tencent/mm/plugin/dbbackup/d$3:iNr	Ljava/lang/String;
    //   125: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: ldc 160
    //   130: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore 14
    //   138: new 82	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 83	java/lang/StringBuilder:<init>	()V
    //   145: astore 7
    //   147: invokestatic 166	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   150: pop
    //   151: aload 7
    //   153: invokestatic 170	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   156: getfield 175	com/tencent/mm/kernel/e:dKt	Ljava/lang/String;
    //   159: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: ldc 177
    //   164: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: astore 15
    //   172: iconst_0
    //   173: istore_1
    //   174: aconst_null
    //   175: astore 7
    //   177: aload 7
    //   179: astore 10
    //   181: iload_1
    //   182: iconst_2
    //   183: if_icmpge +68 -> 251
    //   186: iconst_2
    //   187: anewarray 36	java/lang/String
    //   190: dup
    //   191: iconst_0
    //   192: aload 14
    //   194: aastore
    //   195: dup
    //   196: iconst_1
    //   197: aload 15
    //   199: aastore
    //   200: iload_1
    //   201: aaload
    //   202: astore 9
    //   204: aload 7
    //   206: astore 8
    //   208: aload 9
    //   210: aload 13
    //   212: aload_0
    //   213: getfield 50	com/tencent/mm/plugin/dbbackup/d$3:iNq	[Ljava/lang/String;
    //   216: invokestatic 183	com/tencent/wcdb/repair/RepairKit$MasterInfo:load	(Ljava/lang/String;[B[Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
    //   219: astore 10
    //   221: aload 10
    //   223: astore 8
    //   225: aload 10
    //   227: astore 7
    //   229: ldc 185
    //   231: new 82	java/lang/StringBuilder
    //   234: dup
    //   235: ldc 187
    //   237: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: aload 9
    //   242: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 196	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: aload 10
    //   253: ifnonnull +390 -> 643
    //   256: aload 10
    //   258: astore 9
    //   260: aload 10
    //   262: astore 7
    //   264: aload_0
    //   265: getfield 50	com/tencent/mm/plugin/dbbackup/d$3:iNq	[Ljava/lang/String;
    //   268: invokestatic 200	com/tencent/wcdb/repair/RepairKit$MasterInfo:make	([Ljava/lang/String;)Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;
    //   271: astore 8
    //   273: aload 8
    //   275: astore 9
    //   277: aload 8
    //   279: astore 7
    //   281: ldc 185
    //   283: ldc 202
    //   285: invokestatic 205	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: aload 8
    //   290: astore 9
    //   292: aload 8
    //   294: astore 7
    //   296: getstatic 211	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   299: ldc2_w 212
    //   302: ldc2_w 214
    //   305: lconst_1
    //   306: iconst_1
    //   307: invokevirtual 218	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   310: aload 8
    //   312: astore 9
    //   314: aload 8
    //   316: astore 7
    //   318: aload_0
    //   319: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   322: new 220	com/tencent/wcdb/repair/RepairKit
    //   325: dup
    //   326: aload_0
    //   327: getfield 29	com/tencent/mm/plugin/dbbackup/d$3:iNr	Ljava/lang/String;
    //   330: aload 12
    //   332: invokestatic 148	com/tencent/mm/plugin/dbbackup/d:aFA	()Lcom/tencent/wcdb/database/SQLiteCipherSpec;
    //   335: aload 8
    //   337: invokespecial 223	com/tencent/wcdb/repair/RepairKit:<init>	(Ljava/lang/String;[BLcom/tencent/wcdb/database/SQLiteCipherSpec;Lcom/tencent/wcdb/repair/RepairKit$MasterInfo;)V
    //   340: invokestatic 58	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RepairKit;)Lcom/tencent/wcdb/repair/RepairKit;
    //   343: pop
    //   344: aload 8
    //   346: astore 9
    //   348: aload 8
    //   350: astore 7
    //   352: aload_0
    //   353: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   356: invokestatic 227	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   359: aload 11
    //   361: iconst_1
    //   362: invokevirtual 231	com/tencent/wcdb/repair/RepairKit:output	(Lcom/tencent/wcdb/database/SQLiteDatabase;I)I
    //   365: ifne +486 -> 851
    //   368: iconst_1
    //   369: istore_1
    //   370: aload 8
    //   372: astore 9
    //   374: aload 8
    //   376: astore 7
    //   378: aload_0
    //   379: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   382: invokestatic 227	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   385: invokevirtual 234	com/tencent/wcdb/repair/RepairKit:isHeaderCorrupted	()Z
    //   388: ifeq +694 -> 1082
    //   391: aload 8
    //   393: astore 9
    //   395: aload 8
    //   397: astore 7
    //   399: aload_0
    //   400: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   403: invokestatic 227	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   406: invokevirtual 237	com/tencent/wcdb/repair/RepairKit:isDataCorrupted	()Z
    //   409: ifne +447 -> 856
    //   412: goto +670 -> 1082
    //   415: iload_1
    //   416: iload_2
    //   417: iand
    //   418: istore_1
    //   419: aload 8
    //   421: astore 9
    //   423: aload 8
    //   425: astore 7
    //   427: aload 11
    //   429: invokevirtual 240	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   432: aconst_null
    //   433: astore 9
    //   435: aload 8
    //   437: invokevirtual 243	com/tencent/wcdb/repair/RepairKit$MasterInfo:release	()V
    //   440: aconst_null
    //   441: astore 10
    //   443: aconst_null
    //   444: astore 8
    //   446: aload_0
    //   447: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   450: invokestatic 227	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   453: invokevirtual 244	com/tencent/wcdb/repair/RepairKit:release	()V
    //   456: aload_0
    //   457: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   460: aconst_null
    //   461: invokestatic 58	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RepairKit;)Lcom/tencent/wcdb/repair/RepairKit;
    //   464: pop
    //   465: invokestatic 247	com/tencent/mm/plugin/dbbackup/d:aFy	()V
    //   468: invokestatic 158	java/lang/System:nanoTime	()J
    //   471: lstore 5
    //   473: iload_1
    //   474: ifeq +387 -> 861
    //   477: ldc 249
    //   479: astore 7
    //   481: ldc 185
    //   483: ldc 251
    //   485: iconst_2
    //   486: anewarray 4	java/lang/Object
    //   489: dup
    //   490: iconst_0
    //   491: aload 7
    //   493: aastore
    //   494: dup
    //   495: iconst_1
    //   496: lload 5
    //   498: lload_3
    //   499: lsub
    //   500: l2f
    //   501: ldc 252
    //   503: fdiv
    //   504: invokestatic 258	java/lang/Float:valueOf	(F)Ljava/lang/Float;
    //   507: aastore
    //   508: invokestatic 261	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   511: iload_1
    //   512: ifeq +357 -> 869
    //   515: bipush 26
    //   517: istore_2
    //   518: iload_2
    //   519: istore_1
    //   520: aload_0
    //   521: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:iNb	Lcom/tencent/mm/plugin/dbbackup/b;
    //   524: ifnull +15 -> 539
    //   527: aload_0
    //   528: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:iNb	Lcom/tencent/mm/plugin/dbbackup/b;
    //   531: iconst_0
    //   532: invokeinterface 267 2 0
    //   537: iload_2
    //   538: istore_1
    //   539: getstatic 211	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   542: ldc2_w 212
    //   545: iload_1
    //   546: i2l
    //   547: lconst_1
    //   548: iconst_1
    //   549: invokevirtual 218	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   552: aload_0
    //   553: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   556: invokestatic 227	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   559: ifnull +22 -> 581
    //   562: aload_0
    //   563: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   566: invokestatic 227	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   569: invokevirtual 244	com/tencent/wcdb/repair/RepairKit:release	()V
    //   572: aload_0
    //   573: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   576: aconst_null
    //   577: invokestatic 58	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RepairKit;)Lcom/tencent/wcdb/repair/RepairKit;
    //   580: pop
    //   581: aload_0
    //   582: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   585: invokestatic 271	com/tencent/mm/plugin/dbbackup/d:c	(Lcom/tencent/mm/plugin/dbbackup/d;)Z
    //   588: pop
    //   589: invokestatic 277	com/tencent/mm/model/au:DS	()Lcom/tencent/mm/sdk/platformtools/ai;
    //   592: invokevirtual 282	com/tencent/mm/sdk/platformtools/ai:cre	()V
    //   595: return
    //   596: astore 10
    //   598: aload 8
    //   600: astore 9
    //   602: aload 8
    //   604: astore 7
    //   606: ldc 185
    //   608: new 82	java/lang/StringBuilder
    //   611: dup
    //   612: ldc_w 284
    //   615: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   618: aload 10
    //   620: invokevirtual 287	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   623: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 289	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   632: iload_1
    //   633: iconst_1
    //   634: iadd
    //   635: istore_1
    //   636: aload 8
    //   638: astore 7
    //   640: goto -463 -> 177
    //   643: aload 10
    //   645: astore 8
    //   647: iload_1
    //   648: ifle -338 -> 310
    //   651: aload 10
    //   653: astore 9
    //   655: aload 10
    //   657: astore 7
    //   659: ldc 185
    //   661: ldc_w 291
    //   664: invokestatic 196	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   667: aload 10
    //   669: astore 9
    //   671: aload 10
    //   673: astore 7
    //   675: getstatic 211	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   678: ldc2_w 212
    //   681: ldc2_w 292
    //   684: lconst_1
    //   685: iconst_1
    //   686: invokevirtual 218	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   689: aload 10
    //   691: astore 8
    //   693: goto -383 -> 310
    //   696: astore 7
    //   698: aload 9
    //   700: astore 8
    //   702: aload 11
    //   704: astore 9
    //   706: ldc 185
    //   708: aload 7
    //   710: ldc_w 295
    //   713: iconst_1
    //   714: anewarray 4	java/lang/Object
    //   717: dup
    //   718: iconst_0
    //   719: aload_0
    //   720: getfield 29	com/tencent/mm/plugin/dbbackup/d$3:iNr	Ljava/lang/String;
    //   723: aastore
    //   724: invokestatic 299	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   727: aload_0
    //   728: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:iNb	Lcom/tencent/mm/plugin/dbbackup/b;
    //   731: ifnull +13 -> 744
    //   734: aload_0
    //   735: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:iNb	Lcom/tencent/mm/plugin/dbbackup/b;
    //   738: iconst_m1
    //   739: invokeinterface 267 2 0
    //   744: getstatic 211	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   747: ldc_w 301
    //   750: new 82	java/lang/StringBuilder
    //   753: dup
    //   754: ldc_w 303
    //   757: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   760: invokestatic 306	com/tencent/wcdb/repair/RepairKit:lastError	()Ljava/lang/String;
    //   763: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   766: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: aconst_null
    //   770: invokevirtual 310	com/tencent/mm/plugin/report/service/h:d	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   773: getstatic 211	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   776: ldc2_w 212
    //   779: ldc2_w 311
    //   782: lconst_1
    //   783: iconst_1
    //   784: invokevirtual 218	com/tencent/mm/plugin/report/service/h:a	(JJJZ)V
    //   787: aload_0
    //   788: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   791: invokestatic 227	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   794: ifnull +22 -> 816
    //   797: aload_0
    //   798: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   801: invokestatic 227	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   804: invokevirtual 244	com/tencent/wcdb/repair/RepairKit:release	()V
    //   807: aload_0
    //   808: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   811: aconst_null
    //   812: invokestatic 58	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RepairKit;)Lcom/tencent/wcdb/repair/RepairKit;
    //   815: pop
    //   816: aload 9
    //   818: ifnull +8 -> 826
    //   821: aload 9
    //   823: invokevirtual 240	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   826: aload 8
    //   828: ifnull +8 -> 836
    //   831: aload 8
    //   833: invokevirtual 243	com/tencent/wcdb/repair/RepairKit$MasterInfo:release	()V
    //   836: aload_0
    //   837: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   840: invokestatic 271	com/tencent/mm/plugin/dbbackup/d:c	(Lcom/tencent/mm/plugin/dbbackup/d;)Z
    //   843: pop
    //   844: invokestatic 277	com/tencent/mm/model/au:DS	()Lcom/tencent/mm/sdk/platformtools/ai;
    //   847: invokevirtual 282	com/tencent/mm/sdk/platformtools/ai:cre	()V
    //   850: return
    //   851: iconst_0
    //   852: istore_1
    //   853: goto -483 -> 370
    //   856: iconst_0
    //   857: istore_2
    //   858: goto -443 -> 415
    //   861: ldc_w 314
    //   864: astore 7
    //   866: goto -385 -> 481
    //   869: bipush 27
    //   871: istore_1
    //   872: aload_0
    //   873: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:iNb	Lcom/tencent/mm/plugin/dbbackup/b;
    //   876: ifnull +13 -> 889
    //   879: aload_0
    //   880: getfield 31	com/tencent/mm/plugin/dbbackup/d$3:iNb	Lcom/tencent/mm/plugin/dbbackup/b;
    //   883: iconst_m1
    //   884: invokeinterface 267 2 0
    //   889: getstatic 211	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
    //   892: ldc_w 301
    //   895: new 82	java/lang/StringBuilder
    //   898: dup
    //   899: ldc_w 303
    //   902: invokespecial 190	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   905: invokestatic 306	com/tencent/wcdb/repair/RepairKit:lastError	()Ljava/lang/String;
    //   908: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: aconst_null
    //   915: invokevirtual 310	com/tencent/mm/plugin/report/service/h:d	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
    //   918: goto -379 -> 539
    //   921: astore 7
    //   923: goto -217 -> 706
    //   926: astore 7
    //   928: aconst_null
    //   929: astore 9
    //   931: aconst_null
    //   932: astore 8
    //   934: aload_0
    //   935: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   938: invokestatic 227	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   941: ifnull +22 -> 963
    //   944: aload_0
    //   945: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   948: invokestatic 227	com/tencent/mm/plugin/dbbackup/d:e	(Lcom/tencent/mm/plugin/dbbackup/d;)Lcom/tencent/wcdb/repair/RepairKit;
    //   951: invokevirtual 244	com/tencent/wcdb/repair/RepairKit:release	()V
    //   954: aload_0
    //   955: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   958: aconst_null
    //   959: invokestatic 58	com/tencent/mm/plugin/dbbackup/d:a	(Lcom/tencent/mm/plugin/dbbackup/d;Lcom/tencent/wcdb/repair/RepairKit;)Lcom/tencent/wcdb/repair/RepairKit;
    //   962: pop
    //   963: aload 9
    //   965: ifnull +8 -> 973
    //   968: aload 9
    //   970: invokevirtual 240	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   973: aload 8
    //   975: ifnull +8 -> 983
    //   978: aload 8
    //   980: invokevirtual 243	com/tencent/wcdb/repair/RepairKit$MasterInfo:release	()V
    //   983: aload_0
    //   984: getfield 25	com/tencent/mm/plugin/dbbackup/d$3:iNn	Lcom/tencent/mm/plugin/dbbackup/d;
    //   987: invokestatic 271	com/tencent/mm/plugin/dbbackup/d:c	(Lcom/tencent/mm/plugin/dbbackup/d;)Z
    //   990: pop
    //   991: invokestatic 277	com/tencent/mm/model/au:DS	()Lcom/tencent/mm/sdk/platformtools/ai;
    //   994: invokevirtual 282	com/tencent/mm/sdk/platformtools/ai:cre	()V
    //   997: aload 7
    //   999: athrow
    //   1000: astore 7
    //   1002: aconst_null
    //   1003: astore 8
    //   1005: aload 11
    //   1007: astore 9
    //   1009: goto -75 -> 934
    //   1012: astore 9
    //   1014: aload 7
    //   1016: astore 8
    //   1018: aload 9
    //   1020: astore 7
    //   1022: aload 11
    //   1024: astore 9
    //   1026: goto -92 -> 934
    //   1029: astore 7
    //   1031: aconst_null
    //   1032: astore 9
    //   1034: goto -100 -> 934
    //   1037: astore 7
    //   1039: aconst_null
    //   1040: astore 9
    //   1042: aload 10
    //   1044: astore 8
    //   1046: goto -112 -> 934
    //   1049: astore 7
    //   1051: goto -117 -> 934
    //   1054: astore 7
    //   1056: aconst_null
    //   1057: astore 9
    //   1059: aconst_null
    //   1060: astore 8
    //   1062: goto -356 -> 706
    //   1065: astore 7
    //   1067: aload 11
    //   1069: astore 9
    //   1071: aconst_null
    //   1072: astore 8
    //   1074: goto -368 -> 706
    //   1077: astore 7
    //   1079: goto -373 -> 706
    //   1082: iconst_1
    //   1083: istore_2
    //   1084: goto -669 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1087	0	this	3
    //   77	795	1	i	int
    //   416	668	2	j	int
    //   113	386	3	l1	long
    //   471	26	5	l2	long
    //   50	624	7	localObject1	Object
    //   696	13	7	localException1	java.lang.Exception
    //   864	1	7	str1	String
    //   921	1	7	localException2	java.lang.Exception
    //   926	72	7	localObject2	Object
    //   1000	15	7	localObject3	Object
    //   1020	1	7	localObject4	Object
    //   1029	1	7	localObject5	Object
    //   1037	1	7	localObject6	Object
    //   1049	1	7	localObject7	Object
    //   1054	1	7	localException3	java.lang.Exception
    //   1065	1	7	localException4	java.lang.Exception
    //   1077	1	7	localException5	java.lang.Exception
    //   206	867	8	localObject8	Object
    //   202	806	9	localObject9	Object
    //   1012	7	9	localObject10	Object
    //   1024	46	9	localSQLiteDatabase1	com.tencent.wcdb.database.SQLiteDatabase
    //   179	263	10	localObject11	Object
    //   596	447	10	localException6	java.lang.Exception
    //   108	960	11	localSQLiteDatabase2	com.tencent.wcdb.database.SQLiteDatabase
    //   73	258	12	arrayOfByte1	byte[]
    //   57	154	13	arrayOfByte2	byte[]
    //   136	57	14	str2	String
    //   170	28	15	str3	String
    // Exception table:
    //   from	to	target	type
    //   208	221	596	java/lang/Exception
    //   229	251	596	java/lang/Exception
    //   264	273	696	java/lang/Exception
    //   281	288	696	java/lang/Exception
    //   296	310	696	java/lang/Exception
    //   318	344	696	java/lang/Exception
    //   352	368	696	java/lang/Exception
    //   378	391	696	java/lang/Exception
    //   399	412	696	java/lang/Exception
    //   427	432	696	java/lang/Exception
    //   606	632	696	java/lang/Exception
    //   659	667	696	java/lang/Exception
    //   675	689	696	java/lang/Exception
    //   446	473	921	java/lang/Exception
    //   481	511	921	java/lang/Exception
    //   520	537	921	java/lang/Exception
    //   539	552	921	java/lang/Exception
    //   872	889	921	java/lang/Exception
    //   889	918	921	java/lang/Exception
    //   9	75	926	finally
    //   78	84	926	finally
    //   87	110	926	finally
    //   110	172	1000	finally
    //   208	221	1012	finally
    //   229	251	1012	finally
    //   264	273	1012	finally
    //   281	288	1012	finally
    //   296	310	1012	finally
    //   318	344	1012	finally
    //   352	368	1012	finally
    //   378	391	1012	finally
    //   399	412	1012	finally
    //   427	432	1012	finally
    //   606	632	1012	finally
    //   659	667	1012	finally
    //   675	689	1012	finally
    //   435	440	1029	finally
    //   446	473	1037	finally
    //   481	511	1037	finally
    //   520	537	1037	finally
    //   539	552	1037	finally
    //   872	889	1037	finally
    //   889	918	1037	finally
    //   706	744	1049	finally
    //   744	787	1049	finally
    //   9	75	1054	java/lang/Exception
    //   78	84	1054	java/lang/Exception
    //   87	110	1054	java/lang/Exception
    //   110	172	1065	java/lang/Exception
    //   435	440	1077	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.dbbackup.d.3
 * JD-Core Version:    0.7.0.1
 */