package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class d
  implements com.tencent.mm.ah.g
{
  private boolean bNW = false;
  private Random dFL = new Random();
  private boolean edT = false;
  List<String> hNO = new LinkedList();
  HashSet<String> hNP = new HashSet();
  e.d hNQ;
  f hNR;
  boolean hNS = false;
  private long hNT;
  private long hNU;
  int hNV;
  int hNW = 0;
  Object lock = new Object();
  
  private static String a(Random paramRandom)
  {
    return com.tencent.mm.a.g.o((bk.UZ() + paramRandom.nextDouble()).getBytes());
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    this.hNU += paramInt1;
    if (this.hNT == 0L) {}
    for (paramInt1 = 0;; paramInt1 = (int)(this.hNU * 100L / this.hNT))
    {
      if (paramInt1 > this.hNV)
      {
        this.hNV = paramInt1;
        com.tencent.mm.plugin.backup.bakoldlogic.c.c.setProgress(this.hNV);
        if ((!this.bNW) && (!this.edT) && (this.hNQ != null) && (this.hNV >= 0) && (this.hNV <= 100)) {
          this.hNQ.nS(this.hNV);
        }
      }
      return;
    }
  }
  
  final void avy()
  {
    if ((!this.hNS) || (this.edT)) {
      return;
    }
    for (;;)
    {
      synchronized (this.lock)
      {
        if (this.hNP.isEmpty())
        {
          a.avr().avs().hOi = 4;
          a.avr().avs().hOj = 3;
          com.tencent.mm.plugin.backup.g.b.b(5, this.hNR);
          new com.tencent.mm.plugin.backup.bakoldlogic.c.b(5).auT();
          c localc = a.avr().avt();
          localc.hNK += 1;
          if (this.hNQ != null)
          {
            this.hNQ.avF();
            cancel();
            y.i("MicroMsg.BakPCServer", "send backup finish cmd");
          }
        }
        else
        {
          return;
        }
      }
      y.i("MicroMsg.BakPCServer", "operatorCallback is null");
    }
  }
  
  public final void cancel()
  {
    y.i("MicroMsg.BakPCServer", "cancel");
    this.edT = true;
    com.tencent.mm.plugin.backup.g.b.b(5, this.hNR);
    this.hNQ = null;
    this.hNS = false;
    this.hNV = 0;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      return;
    }
  }
  
  public final void pause()
  {
    y.i("MicroMsg.BakPCServer", "pause");
    this.bNW = true;
  }
  
  /* Error */
  public final boolean q(String arg1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: new 201	com/tencent/mm/pointers/PLong
    //   3: dup
    //   4: invokespecial 202	com/tencent/mm/pointers/PLong:<init>	()V
    //   7: astore 8
    //   9: invokestatic 208	com/tencent/mm/plugin/backup/bakoldlogic/d/b:avO	()Lcom/tencent/mm/plugin/backup/bakoldlogic/d/b;
    //   12: invokevirtual 212	com/tencent/mm/plugin/backup/bakoldlogic/d/b:avP	()Lcom/tencent/mm/plugin/backup/bakoldlogic/d/c;
    //   15: invokevirtual 218	com/tencent/mm/plugin/backup/bakoldlogic/d/c:Fy	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/g;
    //   18: aload_1
    //   19: invokeinterface 224 2 0
    //   24: astore 7
    //   26: new 49	java/util/LinkedList
    //   29: dup
    //   30: invokespecial 50	java/util/LinkedList:<init>	()V
    //   33: astore 6
    //   35: new 49	java/util/LinkedList
    //   38: dup
    //   39: invokespecial 50	java/util/LinkedList:<init>	()V
    //   42: astore 9
    //   44: aload 6
    //   46: astore_1
    //   47: aload 7
    //   49: invokeinterface 229 1 0
    //   54: ifeq +867 -> 921
    //   57: aload 7
    //   59: invokeinterface 232 1 0
    //   64: ifne +984 -> 1048
    //   67: aload_0
    //   68: getfield 38	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   71: astore_1
    //   72: aload_1
    //   73: monitorenter
    //   74: aload_0
    //   75: getfield 57	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:hNP	Ljava/util/HashSet;
    //   78: invokevirtual 236	java/util/HashSet:size	()I
    //   81: istore 4
    //   83: iload 4
    //   85: bipush 10
    //   87: if_icmple +10 -> 97
    //   90: aload_0
    //   91: getfield 38	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   94: invokevirtual 239	java/lang/Object:wait	()V
    //   97: aload_0
    //   98: getfield 45	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:bNW	Z
    //   101: ifeq +21 -> 122
    //   104: aload_0
    //   105: getfield 47	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:edT	Z
    //   108: istore 5
    //   110: iload 5
    //   112: ifne +10 -> 122
    //   115: aload_0
    //   116: getfield 38	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   119: invokevirtual 239	java/lang/Object:wait	()V
    //   122: aload_0
    //   123: getfield 47	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:edT	Z
    //   126: ifeq +54 -> 180
    //   129: ldc 177
    //   131: ldc 241
    //   133: invokestatic 185	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_1
    //   137: monitorexit
    //   138: aload 7
    //   140: invokeinterface 244 1 0
    //   145: iconst_0
    //   146: ireturn
    //   147: astore 10
    //   149: ldc 177
    //   151: aload 10
    //   153: ldc 246
    //   155: iconst_0
    //   156: anewarray 4	java/lang/Object
    //   159: invokestatic 250	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   162: goto -40 -> 122
    //   165: astore_2
    //   166: aload_1
    //   167: monitorexit
    //   168: aload_2
    //   169: athrow
    //   170: astore_1
    //   171: aload 7
    //   173: invokeinterface 244 1 0
    //   178: aload_1
    //   179: athrow
    //   180: aload_1
    //   181: monitorexit
    //   182: new 252	com/tencent/mm/storage/bi
    //   185: dup
    //   186: invokespecial 253	com/tencent/mm/storage/bi:<init>	()V
    //   189: astore 10
    //   191: aload 10
    //   193: aload 7
    //   195: invokevirtual 257	com/tencent/mm/storage/bi:d	(Landroid/database/Cursor;)V
    //   198: iload_3
    //   199: ifle +183 -> 382
    //   202: iconst_1
    //   203: istore 4
    //   205: aload 10
    //   207: getfield 262	com/tencent/mm/h/c/cs:field_msgSvrId	J
    //   210: lconst_0
    //   211: lcmp
    //   212: ifne +176 -> 388
    //   215: ldc_w 264
    //   218: ldc_w 266
    //   221: iconst_2
    //   222: anewarray 4	java/lang/Object
    //   225: dup
    //   226: iconst_0
    //   227: aload 10
    //   229: getfield 270	com/tencent/mm/h/c/cs:field_talker	Ljava/lang/String;
    //   232: aastore
    //   233: dup
    //   234: iconst_1
    //   235: aload 10
    //   237: invokevirtual 273	com/tencent/mm/storage/bi:getType	()I
    //   240: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   243: aastore
    //   244: invokestatic 283	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: aconst_null
    //   248: astore_1
    //   249: iload_3
    //   250: iconst_1
    //   251: isub
    //   252: istore_3
    //   253: aload_1
    //   254: ifnull +10 -> 264
    //   257: aload 6
    //   259: aload_1
    //   260: invokevirtual 287	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   263: pop
    //   264: aload 9
    //   266: invokevirtual 291	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   269: astore 10
    //   271: aload 10
    //   273: invokeinterface 296 1 0
    //   278: ifeq +481 -> 759
    //   281: aload 10
    //   283: invokeinterface 300 1 0
    //   288: checkcast 302	com/tencent/mm/plugin/backup/i/u
    //   291: astore 11
    //   293: new 109	com/tencent/mm/plugin/backup/bakoldlogic/c/c
    //   296: dup
    //   297: aload 11
    //   299: getfield 305	com/tencent/mm/plugin/backup/i/u:bUi	Ljava/lang/String;
    //   302: iconst_2
    //   303: aconst_null
    //   304: aload 11
    //   306: getfield 308	com/tencent/mm/plugin/backup/i/u:path	Ljava/lang/String;
    //   309: aload_0
    //   310: invokestatic 133	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:avr	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   313: getfield 314	com/tencent/mm/plugin/backup/b/d:hFs	[B
    //   316: invokespecial 317	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/ah/g;[B)V
    //   319: astore 12
    //   321: aload_0
    //   322: getfield 38	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   325: astore_1
    //   326: aload_1
    //   327: monitorenter
    //   328: aload 12
    //   330: invokevirtual 318	com/tencent/mm/plugin/backup/bakoldlogic/c/c:auT	()Z
    //   333: pop
    //   334: aload_0
    //   335: getfield 57	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:hNP	Ljava/util/HashSet;
    //   338: aload 11
    //   340: getfield 305	com/tencent/mm/plugin/backup/i/u:bUi	Ljava/lang/String;
    //   343: invokevirtual 319	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   346: pop
    //   347: ldc 177
    //   349: ldc_w 321
    //   352: iconst_1
    //   353: anewarray 4	java/lang/Object
    //   356: dup
    //   357: iconst_0
    //   358: aload_0
    //   359: getfield 57	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:hNP	Ljava/util/HashSet;
    //   362: invokevirtual 236	java/util/HashSet:size	()I
    //   365: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   368: aastore
    //   369: invokestatic 323	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   372: aload_1
    //   373: monitorexit
    //   374: goto -103 -> 271
    //   377: astore_2
    //   378: aload_1
    //   379: monitorexit
    //   380: aload_2
    //   381: athrow
    //   382: iconst_0
    //   383: istore 4
    //   385: goto -180 -> 205
    //   388: new 325	com/tencent/mm/protocal/c/fo
    //   391: dup
    //   392: invokespecial 326	com/tencent/mm/protocal/c/fo:<init>	()V
    //   395: astore_1
    //   396: aload_1
    //   397: aload 10
    //   399: getfield 262	com/tencent/mm/h/c/cs:field_msgSvrId	J
    //   402: putfield 329	com/tencent/mm/protocal/c/fo:ndp	J
    //   405: aload 10
    //   407: getfield 332	com/tencent/mm/h/c/cs:field_isSend	I
    //   410: iconst_1
    //   411: if_icmpne +208 -> 619
    //   414: aload_1
    //   415: new 334	com/tencent/mm/protocal/c/bml
    //   418: dup
    //   419: invokespecial 335	com/tencent/mm/protocal/c/bml:<init>	()V
    //   422: aload_2
    //   423: invokevirtual 339	com/tencent/mm/protocal/c/bml:YI	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/bml;
    //   426: putfield 343	com/tencent/mm/protocal/c/fo:svF	Lcom/tencent/mm/protocal/c/bml;
    //   429: aload_1
    //   430: new 334	com/tencent/mm/protocal/c/bml
    //   433: dup
    //   434: invokespecial 335	com/tencent/mm/protocal/c/bml:<init>	()V
    //   437: aload 10
    //   439: getfield 270	com/tencent/mm/h/c/cs:field_talker	Ljava/lang/String;
    //   442: invokevirtual 339	com/tencent/mm/protocal/c/bml:YI	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/bml;
    //   445: putfield 346	com/tencent/mm/protocal/c/fo:svG	Lcom/tencent/mm/protocal/c/bml;
    //   448: iconst_2
    //   449: istore 4
    //   451: aload_1
    //   452: iload 4
    //   454: putfield 349	com/tencent/mm/protocal/c/fo:szk	I
    //   457: aload_1
    //   458: new 351	com/tencent/mm/protocal/c/bmk
    //   461: dup
    //   462: invokespecial 352	com/tencent/mm/protocal/c/bmk:<init>	()V
    //   465: putfield 356	com/tencent/mm/protocal/c/fo:szp	Lcom/tencent/mm/protocal/c/bmk;
    //   468: aload_1
    //   469: iconst_0
    //   470: putfield 359	com/tencent/mm/protocal/c/fo:szq	I
    //   473: aload_1
    //   474: iconst_0
    //   475: putfield 362	com/tencent/mm/protocal/c/fo:szr	I
    //   478: aload_1
    //   479: ldc 246
    //   481: putfield 365	com/tencent/mm/protocal/c/fo:svK	Ljava/lang/String;
    //   484: aload_1
    //   485: aload 10
    //   487: invokevirtual 273	com/tencent/mm/storage/bi:getType	()I
    //   490: invokestatic 371	com/tencent/mm/pluginsdk/model/app/l:DK	(I)I
    //   493: putfield 374	com/tencent/mm/protocal/c/fo:hQR	I
    //   496: aload_1
    //   497: aload 10
    //   499: getfield 377	com/tencent/mm/h/c/cs:field_createTime	J
    //   502: ldc2_w 378
    //   505: ldiv
    //   506: l2i
    //   507: putfield 382	com/tencent/mm/protocal/c/fo:szl	I
    //   510: aload_1
    //   511: aload 10
    //   513: getfield 377	com/tencent/mm/h/c/cs:field_createTime	J
    //   516: putfield 385	com/tencent/mm/protocal/c/fo:szt	J
    //   519: aload_1
    //   520: aload 10
    //   522: getfield 388	com/tencent/mm/h/c/cs:field_msgSeq	J
    //   525: l2i
    //   526: putfield 391	com/tencent/mm/protocal/c/fo:szs	I
    //   529: aload_1
    //   530: aload 10
    //   532: getfield 394	com/tencent/mm/h/c/cs:field_flag	I
    //   535: putfield 397	com/tencent/mm/protocal/c/fo:szu	I
    //   538: new 334	com/tencent/mm/protocal/c/bml
    //   541: dup
    //   542: invokespecial 335	com/tencent/mm/protocal/c/bml:<init>	()V
    //   545: astore 11
    //   547: aload 11
    //   549: aload 10
    //   551: getfield 400	com/tencent/mm/h/c/cs:field_content	Ljava/lang/String;
    //   554: ldc 246
    //   556: invokestatic 404	com/tencent/mm/sdk/platformtools/bk:aM	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   559: invokevirtual 339	com/tencent/mm/protocal/c/bml:YI	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/bml;
    //   562: pop
    //   563: aload_1
    //   564: aload 11
    //   566: putfield 407	com/tencent/mm/protocal/c/fo:svH	Lcom/tencent/mm/protocal/c/bml;
    //   569: invokestatic 413	com/tencent/mm/plugin/backup/bakoldlogic/b/d:avq	()Lcom/tencent/mm/plugin/backup/bakoldlogic/b/d;
    //   572: aload 10
    //   574: invokevirtual 273	com/tencent/mm/storage/bi:getType	()I
    //   577: invokestatic 371	com/tencent/mm/pluginsdk/model/app/l:DK	(I)I
    //   580: invokevirtual 417	com/tencent/mm/plugin/backup/bakoldlogic/b/d:nM	(I)Lcom/tencent/mm/plugin/backup/bakoldlogic/b/j;
    //   583: astore 11
    //   585: aload 11
    //   587: ifnonnull +77 -> 664
    //   590: ldc_w 264
    //   593: ldc_w 419
    //   596: iconst_1
    //   597: anewarray 4	java/lang/Object
    //   600: dup
    //   601: iconst_0
    //   602: aload 10
    //   604: invokevirtual 273	com/tencent/mm/storage/bi:getType	()I
    //   607: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   610: aastore
    //   611: invokestatic 421	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   614: aconst_null
    //   615: astore_1
    //   616: goto -367 -> 249
    //   619: aload_1
    //   620: new 334	com/tencent/mm/protocal/c/bml
    //   623: dup
    //   624: invokespecial 335	com/tencent/mm/protocal/c/bml:<init>	()V
    //   627: aload 10
    //   629: getfield 270	com/tencent/mm/h/c/cs:field_talker	Ljava/lang/String;
    //   632: invokevirtual 339	com/tencent/mm/protocal/c/bml:YI	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/bml;
    //   635: putfield 343	com/tencent/mm/protocal/c/fo:svF	Lcom/tencent/mm/protocal/c/bml;
    //   638: aload_1
    //   639: new 334	com/tencent/mm/protocal/c/bml
    //   642: dup
    //   643: invokespecial 335	com/tencent/mm/protocal/c/bml:<init>	()V
    //   646: aload_2
    //   647: invokevirtual 339	com/tencent/mm/protocal/c/bml:YI	(Ljava/lang/String;)Lcom/tencent/mm/protocal/c/bml;
    //   650: putfield 346	com/tencent/mm/protocal/c/fo:svG	Lcom/tencent/mm/protocal/c/bml;
    //   653: iload 4
    //   655: ifeq +387 -> 1042
    //   658: iconst_3
    //   659: istore 4
    //   661: goto -210 -> 451
    //   664: aload 11
    //   666: aload_1
    //   667: aload 10
    //   669: aload 9
    //   671: invokeinterface 426 4 0
    //   676: istore 4
    //   678: iload 4
    //   680: ifge +8 -> 688
    //   683: aconst_null
    //   684: astore_1
    //   685: goto -436 -> 249
    //   688: aload 8
    //   690: aload 8
    //   692: getfield 429	com/tencent/mm/pointers/PLong:value	J
    //   695: iload 4
    //   697: i2l
    //   698: ladd
    //   699: putfield 429	com/tencent/mm/pointers/PLong:value	J
    //   702: aload 8
    //   704: aload 8
    //   706: getfield 429	com/tencent/mm/pointers/PLong:value	J
    //   709: ldc2_w 430
    //   712: ladd
    //   713: putfield 429	com/tencent/mm/pointers/PLong:value	J
    //   716: goto -467 -> 249
    //   719: astore_1
    //   720: ldc 177
    //   722: aload_1
    //   723: ldc 246
    //   725: iconst_0
    //   726: anewarray 4	java/lang/Object
    //   729: invokestatic 250	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   732: ldc 177
    //   734: new 66	java/lang/StringBuilder
    //   737: dup
    //   738: ldc_w 433
    //   741: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   744: aload_1
    //   745: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   748: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: invokestatic 442	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   754: aconst_null
    //   755: astore_1
    //   756: goto -503 -> 253
    //   759: aload 9
    //   761: invokevirtual 445	java/util/LinkedList:clear	()V
    //   764: aload 6
    //   766: astore_1
    //   767: aload 8
    //   769: getfield 429	com/tencent/mm/pointers/PLong:value	J
    //   772: ldc2_w 446
    //   775: lcmp
    //   776: ifle +125 -> 901
    //   779: ldc 177
    //   781: new 66	java/lang/StringBuilder
    //   784: dup
    //   785: ldc_w 449
    //   788: invokespecial 436	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   791: aload 8
    //   793: getfield 429	com/tencent/mm/pointers/PLong:value	J
    //   796: invokevirtual 77	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   799: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokestatic 451	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: aload_0
    //   806: getfield 43	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:dFL	Ljava/util/Random;
    //   809: invokestatic 453	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:a	(Ljava/util/Random;)Ljava/lang/String;
    //   812: astore_1
    //   813: new 109	com/tencent/mm/plugin/backup/bakoldlogic/c/c
    //   816: dup
    //   817: aload_1
    //   818: iconst_1
    //   819: aload 6
    //   821: ldc 246
    //   823: aload_0
    //   824: invokestatic 133	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:avr	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   827: getfield 314	com/tencent/mm/plugin/backup/b/d:hFs	[B
    //   830: invokespecial 317	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/ah/g;[B)V
    //   833: astore 10
    //   835: aload_0
    //   836: getfield 38	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   839: astore 6
    //   841: aload 6
    //   843: monitorenter
    //   844: aload 10
    //   846: invokevirtual 318	com/tencent/mm/plugin/backup/bakoldlogic/c/c:auT	()Z
    //   849: pop
    //   850: aload_0
    //   851: getfield 57	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:hNP	Ljava/util/HashSet;
    //   854: aload_1
    //   855: invokevirtual 319	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   858: pop
    //   859: ldc 177
    //   861: ldc_w 321
    //   864: iconst_1
    //   865: anewarray 4	java/lang/Object
    //   868: dup
    //   869: iconst_0
    //   870: aload_0
    //   871: getfield 57	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:hNP	Ljava/util/HashSet;
    //   874: invokevirtual 236	java/util/HashSet:size	()I
    //   877: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   880: aastore
    //   881: invokestatic 323	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   884: aload 6
    //   886: monitorexit
    //   887: new 49	java/util/LinkedList
    //   890: dup
    //   891: invokespecial 50	java/util/LinkedList:<init>	()V
    //   894: astore_1
    //   895: aload 8
    //   897: lconst_0
    //   898: putfield 429	com/tencent/mm/pointers/PLong:value	J
    //   901: aload 7
    //   903: invokeinterface 456 1 0
    //   908: pop
    //   909: aload_1
    //   910: astore 6
    //   912: goto -855 -> 57
    //   915: astore_1
    //   916: aload 6
    //   918: monitorexit
    //   919: aload_1
    //   920: athrow
    //   921: aload 8
    //   923: getfield 429	com/tencent/mm/pointers/PLong:value	J
    //   926: lconst_0
    //   927: lcmp
    //   928: ifle +95 -> 1023
    //   931: aload_0
    //   932: getfield 43	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:dFL	Ljava/util/Random;
    //   935: invokestatic 453	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:a	(Ljava/util/Random;)Ljava/lang/String;
    //   938: astore_2
    //   939: new 109	com/tencent/mm/plugin/backup/bakoldlogic/c/c
    //   942: dup
    //   943: aload_2
    //   944: iconst_1
    //   945: aload_1
    //   946: ldc 246
    //   948: aload_0
    //   949: invokestatic 133	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:avr	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   952: getfield 314	com/tencent/mm/plugin/backup/b/d:hFs	[B
    //   955: invokespecial 317	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/ah/g;[B)V
    //   958: astore 6
    //   960: aload_0
    //   961: getfield 38	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   964: astore_1
    //   965: aload_1
    //   966: monitorenter
    //   967: aload 6
    //   969: invokevirtual 318	com/tencent/mm/plugin/backup/bakoldlogic/c/c:auT	()Z
    //   972: pop
    //   973: aload_0
    //   974: getfield 57	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:hNP	Ljava/util/HashSet;
    //   977: aload_2
    //   978: invokevirtual 319	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   981: pop
    //   982: ldc 177
    //   984: ldc_w 321
    //   987: iconst_1
    //   988: anewarray 4	java/lang/Object
    //   991: dup
    //   992: iconst_0
    //   993: aload_0
    //   994: getfield 57	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:hNP	Ljava/util/HashSet;
    //   997: invokevirtual 236	java/util/HashSet:size	()I
    //   1000: invokestatic 279	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1003: aastore
    //   1004: invokestatic 323	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1007: aload_1
    //   1008: monitorexit
    //   1009: aload 8
    //   1011: lconst_0
    //   1012: putfield 429	com/tencent/mm/pointers/PLong:value	J
    //   1015: new 49	java/util/LinkedList
    //   1018: dup
    //   1019: invokespecial 50	java/util/LinkedList:<init>	()V
    //   1022: pop
    //   1023: aload 7
    //   1025: invokeinterface 244 1 0
    //   1030: iconst_1
    //   1031: ireturn
    //   1032: astore_2
    //   1033: aload_1
    //   1034: monitorexit
    //   1035: aload_2
    //   1036: athrow
    //   1037: astore 10
    //   1039: goto -942 -> 97
    //   1042: iconst_4
    //   1043: istore 4
    //   1045: goto -594 -> 451
    //   1048: aload 6
    //   1050: astore_1
    //   1051: goto -130 -> 921
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1054	0	this	d
    //   0	1054	2	paramString2	String
    //   0	1054	3	paramInt	int
    //   81	963	4	i	int
    //   108	3	5	bool	boolean
    //   24	1000	7	localCursor	android.database.Cursor
    //   7	1003	8	localPLong	com.tencent.mm.pointers.PLong
    //   42	718	9	localLinkedList	LinkedList
    //   147	5	10	localInterruptedException1	java.lang.InterruptedException
    //   189	656	10	localObject2	Object
    //   1037	1	10	localInterruptedException2	java.lang.InterruptedException
    //   291	374	11	localObject3	Object
    //   319	10	12	localc	com.tencent.mm.plugin.backup.bakoldlogic.c.c
    // Exception table:
    //   from	to	target	type
    //   115	122	147	java/lang/InterruptedException
    //   74	83	165	finally
    //   90	97	165	finally
    //   97	110	165	finally
    //   115	122	165	finally
    //   122	138	165	finally
    //   149	162	165	finally
    //   166	168	165	finally
    //   180	182	165	finally
    //   47	57	170	finally
    //   57	74	170	finally
    //   168	170	170	finally
    //   182	198	170	finally
    //   205	247	170	finally
    //   257	264	170	finally
    //   264	271	170	finally
    //   271	328	170	finally
    //   380	382	170	finally
    //   388	448	170	finally
    //   451	585	170	finally
    //   590	614	170	finally
    //   619	653	170	finally
    //   664	678	170	finally
    //   688	716	170	finally
    //   720	754	170	finally
    //   759	764	170	finally
    //   767	844	170	finally
    //   887	901	170	finally
    //   901	909	170	finally
    //   919	921	170	finally
    //   921	967	170	finally
    //   1009	1023	170	finally
    //   1035	1037	170	finally
    //   328	374	377	finally
    //   378	380	377	finally
    //   205	247	719	java/lang/Exception
    //   388	448	719	java/lang/Exception
    //   451	585	719	java/lang/Exception
    //   590	614	719	java/lang/Exception
    //   619	653	719	java/lang/Exception
    //   664	678	719	java/lang/Exception
    //   688	716	719	java/lang/Exception
    //   844	887	915	finally
    //   916	919	915	finally
    //   967	1009	1032	finally
    //   1033	1035	1032	finally
    //   90	97	1037	java/lang/InterruptedException
  }
  
  public final void resume()
  {
    y.i("MicroMsg.BakPCServer", "resume");
    this.bNW = false;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d
 * JD-Core Version:    0.7.0.1
 */