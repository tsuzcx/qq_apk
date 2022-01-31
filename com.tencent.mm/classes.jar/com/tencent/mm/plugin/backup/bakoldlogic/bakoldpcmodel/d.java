package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class d
  implements com.tencent.mm.ai.g
{
  private boolean cvo;
  private Random eDn;
  private boolean eUJ;
  List<String> jHq;
  HashSet<String> jHr;
  e.d jHs;
  f jHt;
  boolean jHu;
  private long jHv;
  private long jHw;
  int jHx;
  int jHy;
  Object lock;
  
  public d()
  {
    AppMethodBeat.i(17830);
    this.lock = new Object();
    this.eDn = new Random();
    this.cvo = false;
    this.eUJ = false;
    this.jHq = new LinkedList();
    this.jHr = new HashSet();
    this.jHu = false;
    this.jHy = 0;
    AppMethodBeat.o(17830);
  }
  
  private static String b(Random paramRandom)
  {
    AppMethodBeat.i(17836);
    paramRandom = com.tencent.mm.a.g.w((bo.yB() + paramRandom.nextDouble()).getBytes());
    AppMethodBeat.o(17836);
    return paramRandom;
  }
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(17837);
    this.jHw += paramInt1;
    if (this.jHv == 0L) {}
    for (paramInt1 = 0;; paramInt1 = (int)(this.jHw * 100L / this.jHv))
    {
      if (paramInt1 > this.jHx)
      {
        this.jHx = paramInt1;
        com.tencent.mm.plugin.backup.bakoldlogic.c.c.setProgress(this.jHx);
        if ((!this.cvo) && (!this.eUJ) && (this.jHs != null) && (this.jHx >= 0) && (this.jHx <= 100)) {
          this.jHs.rF(this.jHx);
        }
      }
      AppMethodBeat.o(17837);
      return;
    }
  }
  
  final void aVb()
  {
    AppMethodBeat.i(17835);
    if ((!this.jHu) || (this.eUJ))
    {
      AppMethodBeat.o(17835);
      return;
    }
    synchronized (this.lock)
    {
      if (this.jHr.isEmpty())
      {
        a.aUU().aUV().jHK = 4;
        a.aUU().aUV().jHL = 3;
        com.tencent.mm.plugin.backup.g.b.b(5, this.jHt);
        new com.tencent.mm.plugin.backup.bakoldlogic.c.b(5).aUv();
        c localc = a.aUU().aUW();
        localc.jHm += 1;
        if (this.jHs != null)
        {
          this.jHs.aVi();
          cancel();
          ab.i("MicroMsg.BakPCServer", "send backup finish cmd");
        }
      }
      else
      {
        AppMethodBeat.o(17835);
        return;
      }
      ab.i("MicroMsg.BakPCServer", "operatorCallback is null");
    }
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(17833);
    ab.i("MicroMsg.BakPCServer", "cancel");
    this.eUJ = true;
    com.tencent.mm.plugin.backup.g.b.b(5, this.jHt);
    this.jHs = null;
    this.jHu = false;
    this.jHx = 0;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      AppMethodBeat.o(17833);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(17831);
    ab.i("MicroMsg.BakPCServer", "pause");
    this.cvo = true;
    AppMethodBeat.o(17831);
  }
  
  public final void resume()
  {
    AppMethodBeat.i(17832);
    ab.i("MicroMsg.BakPCServer", "resume");
    this.cvo = false;
    synchronized (this.lock)
    {
      this.lock.notifyAll();
      AppMethodBeat.o(17832);
      return;
    }
  }
  
  /* Error */
  public final boolean v(String arg1, String paramString2, int paramInt)
  {
    // Byte code:
    //   0: sipush 17834
    //   3: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 210	com/tencent/mm/pointers/PLong
    //   9: dup
    //   10: invokespecial 211	com/tencent/mm/pointers/PLong:<init>	()V
    //   13: astore 8
    //   15: invokestatic 217	com/tencent/mm/plugin/backup/bakoldlogic/d/b:aVr	()Lcom/tencent/mm/plugin/backup/bakoldlogic/d/b;
    //   18: invokevirtual 221	com/tencent/mm/plugin/backup/bakoldlogic/d/b:aVs	()Lcom/tencent/mm/plugin/backup/bakoldlogic/d/c;
    //   21: invokevirtual 227	com/tencent/mm/plugin/backup/bakoldlogic/d/c:YC	()Lcom/tencent/mm/plugin/messenger/foundation/a/a/h;
    //   24: aload_1
    //   25: invokeinterface 233 2 0
    //   30: astore 7
    //   32: new 55	java/util/LinkedList
    //   35: dup
    //   36: invokespecial 56	java/util/LinkedList:<init>	()V
    //   39: astore 6
    //   41: new 55	java/util/LinkedList
    //   44: dup
    //   45: invokespecial 56	java/util/LinkedList:<init>	()V
    //   48: astore 9
    //   50: aload 6
    //   52: astore_1
    //   53: aload 7
    //   55: invokeinterface 238 1 0
    //   60: ifeq +890 -> 950
    //   63: aload 7
    //   65: invokeinterface 241 1 0
    //   70: ifne +1019 -> 1089
    //   73: aload_0
    //   74: getfield 44	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   77: astore_1
    //   78: aload_1
    //   79: monitorenter
    //   80: aload_0
    //   81: getfield 63	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:jHr	Ljava/util/HashSet;
    //   84: invokevirtual 245	java/util/HashSet:size	()I
    //   87: istore 4
    //   89: iload 4
    //   91: bipush 10
    //   93: if_icmple +10 -> 103
    //   96: aload_0
    //   97: getfield 44	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   100: invokevirtual 248	java/lang/Object:wait	()V
    //   103: aload_0
    //   104: getfield 51	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:cvo	Z
    //   107: ifeq +21 -> 128
    //   110: aload_0
    //   111: getfield 53	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:eUJ	Z
    //   114: istore 5
    //   116: iload 5
    //   118: ifne +10 -> 128
    //   121: aload_0
    //   122: getfield 44	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   125: invokevirtual 248	java/lang/Object:wait	()V
    //   128: aload_0
    //   129: getfield 53	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:eUJ	Z
    //   132: ifeq +72 -> 204
    //   135: ldc 185
    //   137: ldc 250
    //   139: invokestatic 192	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: aload_1
    //   143: monitorexit
    //   144: aload 7
    //   146: invokeinterface 253 1 0
    //   151: sipush 17834
    //   154: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: iconst_0
    //   158: ireturn
    //   159: astore 10
    //   161: ldc 185
    //   163: aload 10
    //   165: ldc 255
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 259	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: goto -46 -> 128
    //   177: astore_2
    //   178: aload_1
    //   179: monitorexit
    //   180: sipush 17834
    //   183: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aload_2
    //   187: athrow
    //   188: astore_1
    //   189: aload 7
    //   191: invokeinterface 253 1 0
    //   196: sipush 17834
    //   199: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   202: aload_1
    //   203: athrow
    //   204: aload_1
    //   205: monitorexit
    //   206: new 261	com/tencent/mm/storage/bi
    //   209: dup
    //   210: invokespecial 262	com/tencent/mm/storage/bi:<init>	()V
    //   213: astore 10
    //   215: aload 10
    //   217: aload 7
    //   219: invokevirtual 266	com/tencent/mm/storage/bi:convertFrom	(Landroid/database/Cursor;)V
    //   222: iload_3
    //   223: ifle +189 -> 412
    //   226: iconst_1
    //   227: istore 4
    //   229: aload 10
    //   231: getfield 271	com/tencent/mm/g/c/dd:field_msgSvrId	J
    //   234: lconst_0
    //   235: lcmp
    //   236: ifne +182 -> 418
    //   239: ldc_w 273
    //   242: ldc_w 275
    //   245: iconst_2
    //   246: anewarray 4	java/lang/Object
    //   249: dup
    //   250: iconst_0
    //   251: aload 10
    //   253: getfield 279	com/tencent/mm/g/c/dd:field_talker	Ljava/lang/String;
    //   256: aastore
    //   257: dup
    //   258: iconst_1
    //   259: aload 10
    //   261: invokevirtual 282	com/tencent/mm/storage/bi:getType	()I
    //   264: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: aastore
    //   268: invokestatic 292	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aconst_null
    //   272: astore_1
    //   273: iload_3
    //   274: iconst_1
    //   275: isub
    //   276: istore_3
    //   277: aload_1
    //   278: ifnull +10 -> 288
    //   281: aload 6
    //   283: aload_1
    //   284: invokevirtual 296	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   287: pop
    //   288: aload 9
    //   290: invokevirtual 300	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   293: astore 10
    //   295: aload 10
    //   297: invokeinterface 305 1 0
    //   302: ifeq +480 -> 782
    //   305: aload 10
    //   307: invokeinterface 309 1 0
    //   312: checkcast 311	com/tencent/mm/plugin/backup/i/u
    //   315: astore 11
    //   317: new 119	com/tencent/mm/plugin/backup/bakoldlogic/c/c
    //   320: dup
    //   321: aload 11
    //   323: getfield 314	com/tencent/mm/plugin/backup/i/u:cBO	Ljava/lang/String;
    //   326: iconst_2
    //   327: aconst_null
    //   328: aload 11
    //   330: getfield 317	com/tencent/mm/plugin/backup/i/u:path	Ljava/lang/String;
    //   333: aload_0
    //   334: invokestatic 142	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:aUU	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   337: getfield 323	com/tencent/mm/plugin/backup/b/d:jyL	[B
    //   340: invokespecial 326	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/ai/g;[B)V
    //   343: astore 12
    //   345: aload_0
    //   346: getfield 44	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   349: astore_1
    //   350: aload_1
    //   351: monitorenter
    //   352: aload 12
    //   354: invokevirtual 327	com/tencent/mm/plugin/backup/bakoldlogic/c/c:aUv	()Z
    //   357: pop
    //   358: aload_0
    //   359: getfield 63	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:jHr	Ljava/util/HashSet;
    //   362: aload 11
    //   364: getfield 314	com/tencent/mm/plugin/backup/i/u:cBO	Ljava/lang/String;
    //   367: invokevirtual 328	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   370: pop
    //   371: ldc 185
    //   373: ldc_w 330
    //   376: iconst_1
    //   377: anewarray 4	java/lang/Object
    //   380: dup
    //   381: iconst_0
    //   382: aload_0
    //   383: getfield 63	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:jHr	Ljava/util/HashSet;
    //   386: invokevirtual 245	java/util/HashSet:size	()I
    //   389: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   392: aastore
    //   393: invokestatic 332	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   396: aload_1
    //   397: monitorexit
    //   398: goto -103 -> 295
    //   401: astore_2
    //   402: aload_1
    //   403: monitorexit
    //   404: sipush 17834
    //   407: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: aload_2
    //   411: athrow
    //   412: iconst_0
    //   413: istore 4
    //   415: goto -186 -> 229
    //   418: new 334	com/tencent/mm/protocal/protobuf/gx
    //   421: dup
    //   422: invokespecial 335	com/tencent/mm/protocal/protobuf/gx:<init>	()V
    //   425: astore_1
    //   426: aload_1
    //   427: aload 10
    //   429: getfield 271	com/tencent/mm/g/c/dd:field_msgSvrId	J
    //   432: putfield 338	com/tencent/mm/protocal/protobuf/gx:pIG	J
    //   435: aload 10
    //   437: getfield 341	com/tencent/mm/g/c/dd:field_isSend	I
    //   440: iconst_1
    //   441: if_icmpne +208 -> 649
    //   444: aload_1
    //   445: new 343	com/tencent/mm/protocal/protobuf/bwc
    //   448: dup
    //   449: invokespecial 344	com/tencent/mm/protocal/protobuf/bwc:<init>	()V
    //   452: aload_2
    //   453: invokevirtual 348	com/tencent/mm/protocal/protobuf/bwc:aoF	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/bwc;
    //   456: putfield 352	com/tencent/mm/protocal/protobuf/gx:woP	Lcom/tencent/mm/protocal/protobuf/bwc;
    //   459: aload_1
    //   460: new 343	com/tencent/mm/protocal/protobuf/bwc
    //   463: dup
    //   464: invokespecial 344	com/tencent/mm/protocal/protobuf/bwc:<init>	()V
    //   467: aload 10
    //   469: getfield 279	com/tencent/mm/g/c/dd:field_talker	Ljava/lang/String;
    //   472: invokevirtual 348	com/tencent/mm/protocal/protobuf/bwc:aoF	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/bwc;
    //   475: putfield 355	com/tencent/mm/protocal/protobuf/gx:woQ	Lcom/tencent/mm/protocal/protobuf/bwc;
    //   478: iconst_2
    //   479: istore 4
    //   481: aload_1
    //   482: iload 4
    //   484: putfield 358	com/tencent/mm/protocal/protobuf/gx:wtl	I
    //   487: aload_1
    //   488: new 360	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t
    //   491: dup
    //   492: invokespecial 361	com/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t:<init>	()V
    //   495: putfield 365	com/tencent/mm/protocal/protobuf/gx:wtq	Lcom/tencent/mm/protocal/protobuf/SKBuiltinBuffer_t;
    //   498: aload_1
    //   499: iconst_0
    //   500: putfield 368	com/tencent/mm/protocal/protobuf/gx:wtr	I
    //   503: aload_1
    //   504: iconst_0
    //   505: putfield 371	com/tencent/mm/protocal/protobuf/gx:wts	I
    //   508: aload_1
    //   509: ldc 255
    //   511: putfield 374	com/tencent/mm/protocal/protobuf/gx:woU	Ljava/lang/String;
    //   514: aload_1
    //   515: aload 10
    //   517: invokevirtual 282	com/tencent/mm/storage/bi:getType	()I
    //   520: invokestatic 380	com/tencent/mm/pluginsdk/model/app/l:LD	(I)I
    //   523: putfield 383	com/tencent/mm/protocal/protobuf/gx:jKs	I
    //   526: aload_1
    //   527: aload 10
    //   529: getfield 386	com/tencent/mm/g/c/dd:field_createTime	J
    //   532: ldc2_w 387
    //   535: ldiv
    //   536: l2i
    //   537: putfield 391	com/tencent/mm/protocal/protobuf/gx:wtm	I
    //   540: aload_1
    //   541: aload 10
    //   543: getfield 386	com/tencent/mm/g/c/dd:field_createTime	J
    //   546: putfield 394	com/tencent/mm/protocal/protobuf/gx:wtu	J
    //   549: aload_1
    //   550: aload 10
    //   552: getfield 397	com/tencent/mm/g/c/dd:field_msgSeq	J
    //   555: l2i
    //   556: putfield 400	com/tencent/mm/protocal/protobuf/gx:wtt	I
    //   559: aload_1
    //   560: aload 10
    //   562: getfield 403	com/tencent/mm/g/c/dd:field_flag	I
    //   565: putfield 406	com/tencent/mm/protocal/protobuf/gx:wtv	I
    //   568: new 343	com/tencent/mm/protocal/protobuf/bwc
    //   571: dup
    //   572: invokespecial 344	com/tencent/mm/protocal/protobuf/bwc:<init>	()V
    //   575: astore 11
    //   577: aload 11
    //   579: aload 10
    //   581: getfield 409	com/tencent/mm/g/c/dd:field_content	Ljava/lang/String;
    //   584: ldc 255
    //   586: invokestatic 413	com/tencent/mm/sdk/platformtools/bo:bf	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   589: invokevirtual 348	com/tencent/mm/protocal/protobuf/bwc:aoF	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/bwc;
    //   592: pop
    //   593: aload_1
    //   594: aload 11
    //   596: putfield 416	com/tencent/mm/protocal/protobuf/gx:woR	Lcom/tencent/mm/protocal/protobuf/bwc;
    //   599: invokestatic 422	com/tencent/mm/plugin/backup/bakoldlogic/b/d:aUT	()Lcom/tencent/mm/plugin/backup/bakoldlogic/b/d;
    //   602: aload 10
    //   604: invokevirtual 282	com/tencent/mm/storage/bi:getType	()I
    //   607: invokestatic 380	com/tencent/mm/pluginsdk/model/app/l:LD	(I)I
    //   610: invokevirtual 426	com/tencent/mm/plugin/backup/bakoldlogic/b/d:rA	(I)Lcom/tencent/mm/plugin/backup/bakoldlogic/b/j;
    //   613: astore 11
    //   615: aload 11
    //   617: ifnonnull +77 -> 694
    //   620: ldc_w 273
    //   623: ldc_w 428
    //   626: iconst_1
    //   627: anewarray 4	java/lang/Object
    //   630: dup
    //   631: iconst_0
    //   632: aload 10
    //   634: invokevirtual 282	com/tencent/mm/storage/bi:getType	()I
    //   637: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   640: aastore
    //   641: invokestatic 431	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   644: aconst_null
    //   645: astore_1
    //   646: goto -373 -> 273
    //   649: aload_1
    //   650: new 343	com/tencent/mm/protocal/protobuf/bwc
    //   653: dup
    //   654: invokespecial 344	com/tencent/mm/protocal/protobuf/bwc:<init>	()V
    //   657: aload 10
    //   659: getfield 279	com/tencent/mm/g/c/dd:field_talker	Ljava/lang/String;
    //   662: invokevirtual 348	com/tencent/mm/protocal/protobuf/bwc:aoF	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/bwc;
    //   665: putfield 352	com/tencent/mm/protocal/protobuf/gx:woP	Lcom/tencent/mm/protocal/protobuf/bwc;
    //   668: aload_1
    //   669: new 343	com/tencent/mm/protocal/protobuf/bwc
    //   672: dup
    //   673: invokespecial 344	com/tencent/mm/protocal/protobuf/bwc:<init>	()V
    //   676: aload_2
    //   677: invokevirtual 348	com/tencent/mm/protocal/protobuf/bwc:aoF	(Ljava/lang/String;)Lcom/tencent/mm/protocal/protobuf/bwc;
    //   680: putfield 355	com/tencent/mm/protocal/protobuf/gx:woQ	Lcom/tencent/mm/protocal/protobuf/bwc;
    //   683: iload 4
    //   685: ifeq +398 -> 1083
    //   688: iconst_3
    //   689: istore 4
    //   691: goto -210 -> 481
    //   694: aload 11
    //   696: aload_1
    //   697: aload 10
    //   699: aload 9
    //   701: invokeinterface 436 4 0
    //   706: istore 4
    //   708: iload 4
    //   710: ifge +8 -> 718
    //   713: aconst_null
    //   714: astore_1
    //   715: goto -442 -> 273
    //   718: aload 8
    //   720: aload 8
    //   722: getfield 439	com/tencent/mm/pointers/PLong:value	J
    //   725: iload 4
    //   727: i2l
    //   728: ladd
    //   729: putfield 439	com/tencent/mm/pointers/PLong:value	J
    //   732: aload 8
    //   734: aload 8
    //   736: getfield 439	com/tencent/mm/pointers/PLong:value	J
    //   739: ldc2_w 440
    //   742: ladd
    //   743: putfield 439	com/tencent/mm/pointers/PLong:value	J
    //   746: goto -473 -> 273
    //   749: astore_1
    //   750: ldc 185
    //   752: aload_1
    //   753: ldc 255
    //   755: iconst_0
    //   756: anewarray 4	java/lang/Object
    //   759: invokestatic 259	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   762: ldc 185
    //   764: ldc_w 443
    //   767: aload_1
    //   768: invokestatic 446	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   771: invokevirtual 450	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   774: invokestatic 453	com/tencent/mm/sdk/platformtools/ab:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   777: aconst_null
    //   778: astore_1
    //   779: goto -502 -> 277
    //   782: aload 9
    //   784: invokevirtual 456	java/util/LinkedList:clear	()V
    //   787: aload 6
    //   789: astore_1
    //   790: aload 8
    //   792: getfield 439	com/tencent/mm/pointers/PLong:value	J
    //   795: ldc2_w 457
    //   798: lcmp
    //   799: ifle +125 -> 924
    //   802: ldc 185
    //   804: new 75	java/lang/StringBuilder
    //   807: dup
    //   808: ldc_w 460
    //   811: invokespecial 463	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   814: aload 8
    //   816: getfield 439	com/tencent/mm/pointers/PLong:value	J
    //   819: invokevirtual 86	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   822: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: invokestatic 465	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   828: aload_0
    //   829: getfield 49	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:eDn	Ljava/util/Random;
    //   832: invokestatic 467	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:b	(Ljava/util/Random;)Ljava/lang/String;
    //   835: astore_1
    //   836: new 119	com/tencent/mm/plugin/backup/bakoldlogic/c/c
    //   839: dup
    //   840: aload_1
    //   841: iconst_1
    //   842: aload 6
    //   844: ldc 255
    //   846: aload_0
    //   847: invokestatic 142	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:aUU	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   850: getfield 323	com/tencent/mm/plugin/backup/b/d:jyL	[B
    //   853: invokespecial 326	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/ai/g;[B)V
    //   856: astore 10
    //   858: aload_0
    //   859: getfield 44	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   862: astore 6
    //   864: aload 6
    //   866: monitorenter
    //   867: aload 10
    //   869: invokevirtual 327	com/tencent/mm/plugin/backup/bakoldlogic/c/c:aUv	()Z
    //   872: pop
    //   873: aload_0
    //   874: getfield 63	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:jHr	Ljava/util/HashSet;
    //   877: aload_1
    //   878: invokevirtual 328	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   881: pop
    //   882: ldc 185
    //   884: ldc_w 330
    //   887: iconst_1
    //   888: anewarray 4	java/lang/Object
    //   891: dup
    //   892: iconst_0
    //   893: aload_0
    //   894: getfield 63	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:jHr	Ljava/util/HashSet;
    //   897: invokevirtual 245	java/util/HashSet:size	()I
    //   900: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   903: aastore
    //   904: invokestatic 332	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   907: aload 6
    //   909: monitorexit
    //   910: new 55	java/util/LinkedList
    //   913: dup
    //   914: invokespecial 56	java/util/LinkedList:<init>	()V
    //   917: astore_1
    //   918: aload 8
    //   920: lconst_0
    //   921: putfield 439	com/tencent/mm/pointers/PLong:value	J
    //   924: aload 7
    //   926: invokeinterface 470 1 0
    //   931: pop
    //   932: aload_1
    //   933: astore 6
    //   935: goto -872 -> 63
    //   938: astore_1
    //   939: aload 6
    //   941: monitorexit
    //   942: sipush 17834
    //   945: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   948: aload_1
    //   949: athrow
    //   950: aload 8
    //   952: getfield 439	com/tencent/mm/pointers/PLong:value	J
    //   955: lconst_0
    //   956: lcmp
    //   957: ifle +95 -> 1052
    //   960: aload_0
    //   961: getfield 49	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:eDn	Ljava/util/Random;
    //   964: invokestatic 467	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:b	(Ljava/util/Random;)Ljava/lang/String;
    //   967: astore_2
    //   968: new 119	com/tencent/mm/plugin/backup/bakoldlogic/c/c
    //   971: dup
    //   972: aload_2
    //   973: iconst_1
    //   974: aload_1
    //   975: ldc 255
    //   977: aload_0
    //   978: invokestatic 142	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a:aUU	()Lcom/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/a;
    //   981: getfield 323	com/tencent/mm/plugin/backup/b/d:jyL	[B
    //   984: invokespecial 326	com/tencent/mm/plugin/backup/bakoldlogic/c/c:<init>	(Ljava/lang/String;ILjava/util/LinkedList;Ljava/lang/String;Lcom/tencent/mm/ai/g;[B)V
    //   987: astore 6
    //   989: aload_0
    //   990: getfield 44	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:lock	Ljava/lang/Object;
    //   993: astore_1
    //   994: aload_1
    //   995: monitorenter
    //   996: aload 6
    //   998: invokevirtual 327	com/tencent/mm/plugin/backup/bakoldlogic/c/c:aUv	()Z
    //   1001: pop
    //   1002: aload_0
    //   1003: getfield 63	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:jHr	Ljava/util/HashSet;
    //   1006: aload_2
    //   1007: invokevirtual 328	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   1010: pop
    //   1011: ldc 185
    //   1013: ldc_w 330
    //   1016: iconst_1
    //   1017: anewarray 4	java/lang/Object
    //   1020: dup
    //   1021: iconst_0
    //   1022: aload_0
    //   1023: getfield 63	com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcmodel/d:jHr	Ljava/util/HashSet;
    //   1026: invokevirtual 245	java/util/HashSet:size	()I
    //   1029: invokestatic 288	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1032: aastore
    //   1033: invokestatic 332	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1036: aload_1
    //   1037: monitorexit
    //   1038: aload 8
    //   1040: lconst_0
    //   1041: putfield 439	com/tencent/mm/pointers/PLong:value	J
    //   1044: new 55	java/util/LinkedList
    //   1047: dup
    //   1048: invokespecial 56	java/util/LinkedList:<init>	()V
    //   1051: pop
    //   1052: aload 7
    //   1054: invokeinterface 253 1 0
    //   1059: sipush 17834
    //   1062: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1065: iconst_1
    //   1066: ireturn
    //   1067: astore_2
    //   1068: aload_1
    //   1069: monitorexit
    //   1070: sipush 17834
    //   1073: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1076: aload_2
    //   1077: athrow
    //   1078: astore 10
    //   1080: goto -977 -> 103
    //   1083: iconst_4
    //   1084: istore 4
    //   1086: goto -605 -> 481
    //   1089: aload 6
    //   1091: astore_1
    //   1092: goto -142 -> 950
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1095	0	this	d
    //   0	1095	2	paramString2	String
    //   0	1095	3	paramInt	int
    //   87	998	4	i	int
    //   114	3	5	bool	boolean
    //   30	1023	7	localCursor	android.database.Cursor
    //   13	1026	8	localPLong	com.tencent.mm.pointers.PLong
    //   48	735	9	localLinkedList	LinkedList
    //   159	5	10	localInterruptedException1	java.lang.InterruptedException
    //   213	655	10	localObject2	Object
    //   1078	1	10	localInterruptedException2	java.lang.InterruptedException
    //   315	380	11	localObject3	Object
    //   343	10	12	localc	com.tencent.mm.plugin.backup.bakoldlogic.c.c
    // Exception table:
    //   from	to	target	type
    //   121	128	159	java/lang/InterruptedException
    //   80	89	177	finally
    //   96	103	177	finally
    //   103	116	177	finally
    //   121	128	177	finally
    //   128	144	177	finally
    //   161	174	177	finally
    //   178	180	177	finally
    //   204	206	177	finally
    //   53	63	188	finally
    //   63	80	188	finally
    //   180	188	188	finally
    //   206	222	188	finally
    //   229	271	188	finally
    //   281	288	188	finally
    //   288	295	188	finally
    //   295	352	188	finally
    //   404	412	188	finally
    //   418	478	188	finally
    //   481	615	188	finally
    //   620	644	188	finally
    //   649	683	188	finally
    //   694	708	188	finally
    //   718	746	188	finally
    //   750	777	188	finally
    //   782	787	188	finally
    //   790	867	188	finally
    //   910	924	188	finally
    //   924	932	188	finally
    //   942	950	188	finally
    //   950	996	188	finally
    //   1038	1052	188	finally
    //   1070	1078	188	finally
    //   352	398	401	finally
    //   402	404	401	finally
    //   229	271	749	java/lang/Exception
    //   418	478	749	java/lang/Exception
    //   481	615	749	java/lang/Exception
    //   620	644	749	java/lang/Exception
    //   649	683	749	java/lang/Exception
    //   694	708	749	java/lang/Exception
    //   718	746	749	java/lang/Exception
    //   867	910	938	finally
    //   939	942	938	finally
    //   996	1038	1067	finally
    //   1068	1070	1067	finally
    //   96	103	1078	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.d
 * JD-Core Version:    0.7.0.1
 */