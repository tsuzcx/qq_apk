package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.storage.ad;
import java.util.HashMap;
import java.util.HashSet;

final class a$b
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private int kyA = 0;
  private int kyB = 0;
  private int kyC = 0;
  private int kyD;
  private int kyE;
  private int kyF;
  private HashSet<String> kyv;
  private HashMap<String, ad> kyw = new HashMap();
  private long kyx = -1L;
  private long kyy = -1L;
  private int kyz = 0;
  
  private a$b(a parama) {}
  
  public final String afJ()
  {
    return String.format("{build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, fail: %d}", new Object[] { Integer.valueOf(this.kyF), Integer.valueOf(this.kyA), Integer.valueOf(this.kyz), Integer.valueOf(this.kyB), Integer.valueOf(this.kyD), Integer.valueOf(this.kyE), Integer.valueOf(this.kyC) });
  }
  
  /* Error */
  public final boolean execute()
  {
    // Byte code:
    //   0: ldc 86
    //   2: ldc 88
    //   4: invokestatic 94	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: aload_0
    //   8: ldc 96
    //   10: invokevirtual 100	com/tencent/mm/plugin/fts/b/a$b:DW	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 102	com/tencent/mm/plugin/fts/b/a$b:kyv	Ljava/util/HashSet;
    //   17: ifnonnull +239 -> 256
    //   20: aload_0
    //   21: new 104	java/util/HashSet
    //   24: dup
    //   25: invokespecial 105	java/util/HashSet:<init>	()V
    //   28: putfield 102	com/tencent/mm/plugin/fts/b/a$b:kyv	Ljava/util/HashSet;
    //   31: aload_0
    //   32: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   35: invokestatic 109	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
    //   38: getstatic 115	com/tencent/mm/plugin/fts/a/c:kuV	[I
    //   41: iconst_1
    //   42: iconst_0
    //   43: iconst_1
    //   44: iconst_0
    //   45: iconst_1
    //   46: invokevirtual 120	com/tencent/mm/plugin/fts/c/a:a	([IZZZZZ)Landroid/database/Cursor;
    //   49: astore 7
    //   51: aload 7
    //   53: invokeinterface 125 1 0
    //   58: ifeq +134 -> 192
    //   61: aload 7
    //   63: iconst_1
    //   64: invokeinterface 129 2 0
    //   69: astore 8
    //   71: aload 7
    //   73: iconst_2
    //   74: invokeinterface 133 2 0
    //   79: istore_1
    //   80: aload 7
    //   82: iconst_0
    //   83: invokeinterface 137 2 0
    //   88: lstore_3
    //   89: iload_1
    //   90: iconst_1
    //   91: if_icmpne +70 -> 161
    //   94: aload_0
    //   95: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   98: invokestatic 140	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashMap;
    //   101: aload 8
    //   103: invokevirtual 144	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   106: checkcast 146	java/util/List
    //   109: astore 6
    //   111: aload 6
    //   113: astore 5
    //   115: aload 6
    //   117: ifnonnull +29 -> 146
    //   120: new 148	java/util/ArrayList
    //   123: dup
    //   124: bipush 16
    //   126: invokespecial 151	java/util/ArrayList:<init>	(I)V
    //   129: astore 5
    //   131: aload_0
    //   132: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   135: invokestatic 140	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashMap;
    //   138: aload 8
    //   140: aload 5
    //   142: invokevirtual 155	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   145: pop
    //   146: aload 5
    //   148: lload_3
    //   149: invokestatic 160	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   152: invokeinterface 164 2 0
    //   157: pop
    //   158: goto -107 -> 51
    //   161: aload_0
    //   162: getfield 102	com/tencent/mm/plugin/fts/b/a$b:kyv	Ljava/util/HashSet;
    //   165: aload 8
    //   167: invokevirtual 165	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   170: pop
    //   171: iload_1
    //   172: iconst_2
    //   173: if_icmpne -122 -> 51
    //   176: aload_0
    //   177: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   180: invokestatic 169	com/tencent/mm/plugin/fts/b/a:c	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashSet;
    //   183: aload 8
    //   185: invokevirtual 165	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   188: pop
    //   189: goto -138 -> 51
    //   192: aload 7
    //   194: invokeinterface 172 1 0
    //   199: aload_0
    //   200: aload_0
    //   201: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   204: invokestatic 140	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashMap;
    //   207: invokevirtual 176	java/util/HashMap:size	()I
    //   210: putfield 72	com/tencent/mm/plugin/fts/b/a$b:kyD	I
    //   213: aload_0
    //   214: aload_0
    //   215: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   218: invokestatic 169	com/tencent/mm/plugin/fts/b/a:c	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashSet;
    //   221: invokevirtual 177	java/util/HashSet:size	()I
    //   224: putfield 74	com/tencent/mm/plugin/fts/b/a$b:kyE	I
    //   227: aload_0
    //   228: aload_0
    //   229: getfield 102	com/tencent/mm/plugin/fts/b/a$b:kyv	Ljava/util/HashSet;
    //   232: invokevirtual 177	java/util/HashSet:size	()I
    //   235: putfield 64	com/tencent/mm/plugin/fts/b/a$b:kyF	I
    //   238: aload_0
    //   239: getfield 64	com/tencent/mm/plugin/fts/b/a$b:kyF	I
    //   242: iconst_5
    //   243: if_icmpge +13 -> 256
    //   246: aload_0
    //   247: aload_0
    //   248: getfield 180	com/tencent/mm/plugin/fts/a/a/a:kvZ	J
    //   251: lconst_1
    //   252: lor
    //   253: putfield 180	com/tencent/mm/plugin/fts/a/a/a:kvZ	J
    //   256: aload_0
    //   257: ldc 182
    //   259: invokevirtual 100	com/tencent/mm/plugin/fts/b/a$b:DW	(Ljava/lang/String;)V
    //   262: invokestatic 187	java/lang/Thread:interrupted	()Z
    //   265: ifeq +11 -> 276
    //   268: new 189	java/lang/InterruptedException
    //   271: dup
    //   272: invokespecial 190	java/lang/InterruptedException:<init>	()V
    //   275: athrow
    //   276: aload_0
    //   277: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   280: invokestatic 140	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashMap;
    //   283: invokevirtual 176	java/util/HashMap:size	()I
    //   286: ifle +82 -> 368
    //   289: new 148	java/util/ArrayList
    //   292: dup
    //   293: invokespecial 191	java/util/ArrayList:<init>	()V
    //   296: astore 5
    //   298: aload_0
    //   299: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   302: invokestatic 140	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashMap;
    //   305: invokevirtual 195	java/util/HashMap:values	()Ljava/util/Collection;
    //   308: invokeinterface 201 1 0
    //   313: astore 6
    //   315: aload 6
    //   317: invokeinterface 206 1 0
    //   322: ifeq +24 -> 346
    //   325: aload 5
    //   327: aload 6
    //   329: invokeinterface 210 1 0
    //   334: checkcast 146	java/util/List
    //   337: invokeinterface 214 2 0
    //   342: pop
    //   343: goto -28 -> 315
    //   346: aload_0
    //   347: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   350: invokestatic 140	com/tencent/mm/plugin/fts/b/a:b	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashMap;
    //   353: invokevirtual 217	java/util/HashMap:clear	()V
    //   356: aload_0
    //   357: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   360: invokestatic 109	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
    //   363: aload 5
    //   365: invokevirtual 221	com/tencent/mm/plugin/fts/c/a:by	(Ljava/util/List;)V
    //   368: aload_0
    //   369: ldc 223
    //   371: invokevirtual 100	com/tencent/mm/plugin/fts/b/a$b:DW	(Ljava/lang/String;)V
    //   374: invokestatic 187	java/lang/Thread:interrupted	()Z
    //   377: ifeq +11 -> 388
    //   380: new 189	java/lang/InterruptedException
    //   383: dup
    //   384: invokespecial 190	java/lang/InterruptedException:<init>	()V
    //   387: athrow
    //   388: aload_0
    //   389: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   392: invokestatic 169	com/tencent/mm/plugin/fts/b/a:c	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashSet;
    //   395: invokevirtual 177	java/util/HashSet:size	()I
    //   398: ifle +78 -> 476
    //   401: aload_0
    //   402: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   405: invokestatic 169	com/tencent/mm/plugin/fts/b/a:c	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashSet;
    //   408: invokevirtual 224	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   411: astore 5
    //   413: aload 5
    //   415: invokeinterface 206 1 0
    //   420: ifeq +46 -> 466
    //   423: aload 5
    //   425: invokeinterface 210 1 0
    //   430: checkcast 76	java/lang/String
    //   433: astore 6
    //   435: aload_0
    //   436: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   439: invokestatic 228	com/tencent/mm/plugin/fts/b/a:d	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/a/j;
    //   442: aload 6
    //   444: invokeinterface 234 2 0
    //   449: lstore_3
    //   450: aload_0
    //   451: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   454: invokestatic 109	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
    //   457: aload 6
    //   459: lload_3
    //   460: invokevirtual 238	com/tencent/mm/plugin/fts/c/a:E	(Ljava/lang/String;J)V
    //   463: goto -50 -> 413
    //   466: aload_0
    //   467: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   470: invokestatic 169	com/tencent/mm/plugin/fts/b/a:c	(Lcom/tencent/mm/plugin/fts/b/a;)Ljava/util/HashSet;
    //   473: invokevirtual 239	java/util/HashSet:clear	()V
    //   476: aload_0
    //   477: ldc 241
    //   479: invokevirtual 100	com/tencent/mm/plugin/fts/b/a$b:DW	(Ljava/lang/String;)V
    //   482: invokestatic 187	java/lang/Thread:interrupted	()Z
    //   485: ifeq +11 -> 496
    //   488: new 189	java/lang/InterruptedException
    //   491: dup
    //   492: invokespecial 190	java/lang/InterruptedException:<init>	()V
    //   495: athrow
    //   496: aload_0
    //   497: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   500: invokestatic 228	com/tencent/mm/plugin/fts/b/a:d	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/a/j;
    //   503: ldc 243
    //   505: iconst_1
    //   506: anewarray 76	java/lang/String
    //   509: dup
    //   510: iconst_0
    //   511: aload_0
    //   512: getfield 42	com/tencent/mm/plugin/fts/b/a$b:kyx	J
    //   515: invokestatic 247	java/lang/Long:toString	(J)Ljava/lang/String;
    //   518: aastore
    //   519: invokeinterface 251 3 0
    //   524: astore 5
    //   526: bipush 50
    //   528: istore_1
    //   529: aload 5
    //   531: invokeinterface 125 1 0
    //   536: ifeq +367 -> 903
    //   539: invokestatic 187	java/lang/Thread:interrupted	()Z
    //   542: ifeq +28 -> 570
    //   545: aload 5
    //   547: invokeinterface 172 1 0
    //   552: aload_0
    //   553: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   556: invokestatic 109	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
    //   559: invokevirtual 254	com/tencent/mm/plugin/fts/c/a:commit	()V
    //   562: new 189	java/lang/InterruptedException
    //   565: dup
    //   566: invokespecial 190	java/lang/InterruptedException:<init>	()V
    //   569: athrow
    //   570: aload 5
    //   572: iconst_0
    //   573: invokeinterface 137 2 0
    //   578: lstore_3
    //   579: aload_0
    //   580: lload_3
    //   581: putfield 42	com/tencent/mm/plugin/fts/b/a$b:kyx	J
    //   584: new 256	com/tencent/mm/storage/ad
    //   587: dup
    //   588: invokespecial 257	com/tencent/mm/storage/ad:<init>	()V
    //   591: astore 6
    //   593: aload 6
    //   595: lload_3
    //   596: putfield 260	com/tencent/mm/storage/ad:dBe	J
    //   599: aload 6
    //   601: aload 5
    //   603: iconst_1
    //   604: invokeinterface 129 2 0
    //   609: invokevirtual 263	com/tencent/mm/storage/ad:setUsername	(Ljava/lang/String;)V
    //   612: aload 6
    //   614: aload 5
    //   616: iconst_2
    //   617: invokeinterface 129 2 0
    //   622: invokevirtual 266	com/tencent/mm/storage/ad:cZ	(Ljava/lang/String;)V
    //   625: aload 6
    //   627: aload 5
    //   629: iconst_3
    //   630: invokeinterface 129 2 0
    //   635: invokevirtual 269	com/tencent/mm/storage/ad:df	(Ljava/lang/String;)V
    //   638: aload 6
    //   640: aload 5
    //   642: iconst_4
    //   643: invokeinterface 129 2 0
    //   648: invokevirtual 272	com/tencent/mm/storage/ad:dk	(Ljava/lang/String;)V
    //   651: aload 6
    //   653: aload 5
    //   655: iconst_5
    //   656: invokeinterface 133 2 0
    //   661: invokevirtual 275	com/tencent/mm/storage/ad:fi	(I)V
    //   664: aload 6
    //   666: aload 5
    //   668: bipush 6
    //   670: invokeinterface 133 2 0
    //   675: invokevirtual 278	com/tencent/mm/storage/ad:setType	(I)V
    //   678: aload 6
    //   680: aload 5
    //   682: bipush 7
    //   684: invokeinterface 282 2 0
    //   689: invokevirtual 286	com/tencent/mm/storage/ad:v	([B)V
    //   692: aload 6
    //   694: aload 5
    //   696: bipush 8
    //   698: invokeinterface 129 2 0
    //   703: invokevirtual 289	com/tencent/mm/storage/ad:dr	(Ljava/lang/String;)V
    //   706: aload 6
    //   708: iconst_0
    //   709: invokevirtual 292	com/tencent/mm/storage/ad:fk	(I)V
    //   712: aload_0
    //   713: getfield 38	com/tencent/mm/plugin/fts/b/a$b:kyw	Ljava/util/HashMap;
    //   716: aload 6
    //   718: getfield 298	com/tencent/mm/h/c/ao:field_username	Ljava/lang/String;
    //   721: aload 6
    //   723: invokevirtual 155	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   726: pop
    //   727: aload 6
    //   729: getfield 298	com/tencent/mm/h/c/ao:field_username	Ljava/lang/String;
    //   732: invokestatic 304	com/tencent/mm/model/s:fn	(Ljava/lang/String;)Z
    //   735: ifne -206 -> 529
    //   738: aload_0
    //   739: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   742: aload 6
    //   744: invokevirtual 308	com/tencent/mm/plugin/fts/b/a:G	(Lcom/tencent/mm/storage/ad;)Z
    //   747: ifeq -218 -> 529
    //   750: aload_0
    //   751: getfield 102	com/tencent/mm/plugin/fts/b/a$b:kyv	Ljava/util/HashSet;
    //   754: aload 6
    //   756: getfield 298	com/tencent/mm/h/c/ao:field_username	Ljava/lang/String;
    //   759: invokevirtual 311	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   762: ifne -233 -> 529
    //   765: iload_1
    //   766: istore_2
    //   767: iload_1
    //   768: bipush 50
    //   770: if_icmplt +25 -> 795
    //   773: aload_0
    //   774: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   777: invokestatic 109	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
    //   780: invokevirtual 254	com/tencent/mm/plugin/fts/c/a:commit	()V
    //   783: aload_0
    //   784: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   787: invokestatic 109	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
    //   790: invokevirtual 314	com/tencent/mm/plugin/fts/c/a:beginTransaction	()V
    //   793: iconst_0
    //   794: istore_2
    //   795: iload_2
    //   796: istore_1
    //   797: aload 6
    //   799: getfield 298	com/tencent/mm/h/c/ao:field_username	Ljava/lang/String;
    //   802: ldc_w 316
    //   805: invokevirtual 319	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   808: ifne +35 -> 843
    //   811: iload_2
    //   812: istore_1
    //   813: aload 6
    //   815: getfield 322	com/tencent/mm/h/c/ao:field_verifyFlag	I
    //   818: invokestatic 325	com/tencent/mm/storage/ad:cuc	()I
    //   821: iand
    //   822: ifne +21 -> 843
    //   825: iload_2
    //   826: istore_1
    //   827: aload_0
    //   828: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   831: aload 6
    //   833: invokevirtual 328	com/tencent/mm/plugin/fts/b/a:E	(Lcom/tencent/mm/storage/ad;)V
    //   836: iload_2
    //   837: istore_1
    //   838: aload 6
    //   840: invokevirtual 331	com/tencent/mm/storage/ad:cuf	()V
    //   843: iload_2
    //   844: istore_1
    //   845: iload_2
    //   846: aload_0
    //   847: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   850: aload 6
    //   852: invokevirtual 334	com/tencent/mm/plugin/fts/b/a:I	(Lcom/tencent/mm/storage/ad;)I
    //   855: iadd
    //   856: istore_2
    //   857: iload_2
    //   858: istore_1
    //   859: aload_0
    //   860: aload_0
    //   861: getfield 48	com/tencent/mm/plugin/fts/b/a$b:kyA	I
    //   864: iconst_1
    //   865: iadd
    //   866: putfield 48	com/tencent/mm/plugin/fts/b/a$b:kyA	I
    //   869: iload_2
    //   870: istore_1
    //   871: goto -342 -> 529
    //   874: astore 6
    //   876: ldc 86
    //   878: aload 6
    //   880: ldc_w 336
    //   883: iconst_0
    //   884: anewarray 62	java/lang/Object
    //   887: invokestatic 340	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   890: aload_0
    //   891: aload_0
    //   892: getfield 52	com/tencent/mm/plugin/fts/b/a$b:kyC	I
    //   895: iconst_1
    //   896: iadd
    //   897: putfield 52	com/tencent/mm/plugin/fts/b/a$b:kyC	I
    //   900: goto -371 -> 529
    //   903: aload 5
    //   905: invokeinterface 172 1 0
    //   910: aload_0
    //   911: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   914: invokestatic 109	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
    //   917: invokevirtual 254	com/tencent/mm/plugin/fts/c/a:commit	()V
    //   920: aload_0
    //   921: ldc_w 342
    //   924: invokevirtual 100	com/tencent/mm/plugin/fts/b/a$b:DW	(Ljava/lang/String;)V
    //   927: invokestatic 187	java/lang/Thread:interrupted	()Z
    //   930: ifeq +11 -> 941
    //   933: new 189	java/lang/InterruptedException
    //   936: dup
    //   937: invokespecial 190	java/lang/InterruptedException:<init>	()V
    //   940: athrow
    //   941: aload_0
    //   942: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   945: invokestatic 228	com/tencent/mm/plugin/fts/b/a:d	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/a/j;
    //   948: ldc_w 344
    //   951: iconst_1
    //   952: anewarray 76	java/lang/String
    //   955: dup
    //   956: iconst_0
    //   957: aload_0
    //   958: getfield 44	com/tencent/mm/plugin/fts/b/a$b:kyy	J
    //   961: invokestatic 247	java/lang/Long:toString	(J)Ljava/lang/String;
    //   964: aastore
    //   965: invokeinterface 251 3 0
    //   970: astore 6
    //   972: bipush 50
    //   974: istore_1
    //   975: aload 6
    //   977: invokeinterface 125 1 0
    //   982: ifeq +237 -> 1219
    //   985: invokestatic 187	java/lang/Thread:interrupted	()Z
    //   988: ifeq +28 -> 1016
    //   991: aload 6
    //   993: invokeinterface 172 1 0
    //   998: aload_0
    //   999: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   1002: invokestatic 109	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
    //   1005: invokevirtual 254	com/tencent/mm/plugin/fts/c/a:commit	()V
    //   1008: new 189	java/lang/InterruptedException
    //   1011: dup
    //   1012: invokespecial 190	java/lang/InterruptedException:<init>	()V
    //   1015: athrow
    //   1016: aload_0
    //   1017: aload 6
    //   1019: iconst_0
    //   1020: invokeinterface 137 2 0
    //   1025: putfield 44	com/tencent/mm/plugin/fts/b/a$b:kyy	J
    //   1028: aload 6
    //   1030: iconst_1
    //   1031: invokeinterface 129 2 0
    //   1036: astore 5
    //   1038: aload_0
    //   1039: getfield 102	com/tencent/mm/plugin/fts/b/a$b:kyv	Ljava/util/HashSet;
    //   1042: aload 5
    //   1044: invokevirtual 311	java/util/HashSet:remove	(Ljava/lang/Object;)Z
    //   1047: ifne -72 -> 975
    //   1050: aload 6
    //   1052: iconst_2
    //   1053: invokeinterface 129 2 0
    //   1058: astore 8
    //   1060: aload 6
    //   1062: iconst_3
    //   1063: invokeinterface 282 2 0
    //   1068: astore 7
    //   1070: getstatic 350	com/tencent/mm/plugin/fts/a/c$a:kvj	Ljava/util/regex/Pattern;
    //   1073: aload 8
    //   1075: invokevirtual 356	java/util/regex/Pattern:split	(Ljava/lang/CharSequence;)[Ljava/lang/String;
    //   1078: astore 8
    //   1080: aload 8
    //   1082: new 358	com/tencent/mm/plugin/fts/b/a$b$1
    //   1085: dup
    //   1086: aload_0
    //   1087: invokespecial 361	com/tencent/mm/plugin/fts/b/a$b$1:<init>	(Lcom/tencent/mm/plugin/fts/b/a$b;)V
    //   1090: invokestatic 367	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
    //   1093: aload_0
    //   1094: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   1097: aload 5
    //   1099: aload 8
    //   1101: invokevirtual 371	com/tencent/mm/plugin/fts/b/a:h	(Ljava/lang/String;[Ljava/lang/String;)I
    //   1104: istore_2
    //   1105: iload_1
    //   1106: iload_2
    //   1107: iadd
    //   1108: istore_1
    //   1109: aload_0
    //   1110: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   1113: aload 5
    //   1115: aload_0
    //   1116: getfield 38	com/tencent/mm/plugin/fts/b/a$b:kyw	Ljava/util/HashMap;
    //   1119: aload 5
    //   1121: invokevirtual 144	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1124: checkcast 256	com/tencent/mm/storage/ad
    //   1127: aload 8
    //   1129: aload 7
    //   1131: aload_0
    //   1132: getfield 38	com/tencent/mm/plugin/fts/b/a$b:kyw	Ljava/util/HashMap;
    //   1135: invokevirtual 374	com/tencent/mm/plugin/fts/b/a:a	(Ljava/lang/String;Lcom/tencent/mm/storage/ad;[Ljava/lang/String;[BLjava/util/HashMap;)I
    //   1138: istore_2
    //   1139: iload_1
    //   1140: iload_2
    //   1141: iadd
    //   1142: istore_1
    //   1143: aload_0
    //   1144: aload_0
    //   1145: getfield 46	com/tencent/mm/plugin/fts/b/a$b:kyz	I
    //   1148: iconst_1
    //   1149: iadd
    //   1150: putfield 46	com/tencent/mm/plugin/fts/b/a$b:kyz	I
    //   1153: iload_1
    //   1154: istore_2
    //   1155: iload_2
    //   1156: istore_1
    //   1157: iload_2
    //   1158: bipush 50
    //   1160: if_icmplt -185 -> 975
    //   1163: aload_0
    //   1164: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   1167: invokestatic 109	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
    //   1170: invokevirtual 254	com/tencent/mm/plugin/fts/c/a:commit	()V
    //   1173: aload_0
    //   1174: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   1177: invokestatic 109	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
    //   1180: invokevirtual 314	com/tencent/mm/plugin/fts/c/a:beginTransaction	()V
    //   1183: iconst_0
    //   1184: istore_1
    //   1185: goto -210 -> 975
    //   1188: astore 5
    //   1190: ldc 86
    //   1192: aload 5
    //   1194: ldc_w 336
    //   1197: iconst_0
    //   1198: anewarray 62	java/lang/Object
    //   1201: invokestatic 340	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1204: aload_0
    //   1205: aload_0
    //   1206: getfield 52	com/tencent/mm/plugin/fts/b/a$b:kyC	I
    //   1209: iconst_1
    //   1210: iadd
    //   1211: putfield 52	com/tencent/mm/plugin/fts/b/a$b:kyC	I
    //   1214: iload_1
    //   1215: istore_2
    //   1216: goto -61 -> 1155
    //   1219: aload 6
    //   1221: invokeinterface 172 1 0
    //   1226: aload_0
    //   1227: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   1230: invokestatic 109	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
    //   1233: invokevirtual 254	com/tencent/mm/plugin/fts/c/a:commit	()V
    //   1236: aload_0
    //   1237: ldc_w 376
    //   1240: invokevirtual 100	com/tencent/mm/plugin/fts/b/a$b:DW	(Ljava/lang/String;)V
    //   1243: invokestatic 187	java/lang/Thread:interrupted	()Z
    //   1246: ifeq +11 -> 1257
    //   1249: new 189	java/lang/InterruptedException
    //   1252: dup
    //   1253: invokespecial 190	java/lang/InterruptedException:<init>	()V
    //   1256: athrow
    //   1257: aload_0
    //   1258: aload_0
    //   1259: getfield 102	com/tencent/mm/plugin/fts/b/a$b:kyv	Ljava/util/HashSet;
    //   1262: invokevirtual 177	java/util/HashSet:size	()I
    //   1265: putfield 50	com/tencent/mm/plugin/fts/b/a$b:kyB	I
    //   1268: aload_0
    //   1269: getfield 102	com/tencent/mm/plugin/fts/b/a$b:kyv	Ljava/util/HashSet;
    //   1272: invokevirtual 224	java/util/HashSet:iterator	()Ljava/util/Iterator;
    //   1275: astore 5
    //   1277: aload 5
    //   1279: invokeinterface 206 1 0
    //   1284: ifeq +53 -> 1337
    //   1287: aload 5
    //   1289: invokeinterface 210 1 0
    //   1294: checkcast 76	java/lang/String
    //   1297: astore 6
    //   1299: aload_0
    //   1300: getfield 30	com/tencent/mm/plugin/fts/b/a$b:kyt	Lcom/tencent/mm/plugin/fts/b/a;
    //   1303: invokestatic 109	com/tencent/mm/plugin/fts/b/a:a	(Lcom/tencent/mm/plugin/fts/b/a;)Lcom/tencent/mm/plugin/fts/c/a;
    //   1306: getstatic 115	com/tencent/mm/plugin/fts/a/c:kuV	[I
    //   1309: aload 6
    //   1311: invokevirtual 379	com/tencent/mm/plugin/fts/c/a:b	([ILjava/lang/String;)V
    //   1314: ldc_w 381
    //   1317: invokestatic 387	com/tencent/mm/kernel/g:t	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   1320: checkcast 381	com/tencent/mm/plugin/fts/PluginFTS
    //   1323: invokevirtual 391	com/tencent/mm/plugin/fts/PluginFTS:getTopHitsLogic	()Lcom/tencent/mm/plugin/fts/b/e;
    //   1326: getstatic 115	com/tencent/mm/plugin/fts/a/c:kuV	[I
    //   1329: aload 6
    //   1331: invokevirtual 395	com/tencent/mm/plugin/fts/b/e:d	([ILjava/lang/String;)V
    //   1334: goto -57 -> 1277
    //   1337: aload_0
    //   1338: getfield 102	com/tencent/mm/plugin/fts/b/a$b:kyv	Ljava/util/HashSet;
    //   1341: invokevirtual 239	java/util/HashSet:clear	()V
    //   1344: aload_0
    //   1345: getfield 38	com/tencent/mm/plugin/fts/b/a$b:kyw	Ljava/util/HashMap;
    //   1348: invokevirtual 217	java/util/HashMap:clear	()V
    //   1351: aload_0
    //   1352: ldc_w 397
    //   1355: invokevirtual 100	com/tencent/mm/plugin/fts/b/a$b:DW	(Ljava/lang/String;)V
    //   1358: ldc_w 381
    //   1361: invokestatic 387	com/tencent/mm/kernel/g:t	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   1364: checkcast 381	com/tencent/mm/plugin/fts/PluginFTS
    //   1367: iconst_1
    //   1368: invokevirtual 401	com/tencent/mm/plugin/fts/PluginFTS:setFTSIndexReady	(Z)V
    //   1371: iconst_1
    //   1372: ireturn
    //   1373: astore 5
    //   1375: goto -185 -> 1190
    //   1378: astore 5
    //   1380: goto -190 -> 1190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1383	0	this	b
    //   79	1136	1	i	int
    //   766	450	2	j	int
    //   88	508	3	l	long
    //   113	1007	5	localObject1	Object
    //   1188	5	5	localException1	java.lang.Exception
    //   1275	13	5	localIterator	java.util.Iterator
    //   1373	1	5	localException2	java.lang.Exception
    //   1378	1	5	localException3	java.lang.Exception
    //   109	742	6	localObject2	Object
    //   874	5	6	localException4	java.lang.Exception
    //   970	360	6	localObject3	Object
    //   49	1081	7	localObject4	Object
    //   69	1059	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   797	811	874	java/lang/Exception
    //   813	825	874	java/lang/Exception
    //   827	836	874	java/lang/Exception
    //   838	843	874	java/lang/Exception
    //   845	857	874	java/lang/Exception
    //   859	869	874	java/lang/Exception
    //   1070	1105	1188	java/lang/Exception
    //   1109	1139	1373	java/lang/Exception
    //   1143	1153	1378	java/lang/Exception
  }
  
  public final int getId()
  {
    return 1;
  }
  
  public final String getName()
  {
    return "BuildContactIndexTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.b
 * JD-Core Version:    0.7.0.1
 */