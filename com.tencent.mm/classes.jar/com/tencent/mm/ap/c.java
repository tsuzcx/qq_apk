package com.tencent.mm.ap;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class c
  implements Runnable
{
  private static long iTF = 0L;
  int iTE;
  private d iTG;
  a iTH;
  private long iTI;
  long iTJ;
  long iTK;
  String iTL;
  private String iTM;
  boolean iTN;
  
  c()
  {
    AppMethodBeat.i(132530);
    this.iTE = 0;
    this.iTG = null;
    this.iTH = new a();
    this.iTI = 0L;
    this.iTJ = 0L;
    this.iTK = 0L;
    this.iTL = null;
    this.iTM = null;
    this.iTN = false;
    if (this.iTL == null)
    {
      this.iTL = (b.aKB() + "ProcessDetector");
      o localo = new o(this.iTL);
      if (!localo.exists()) {
        localo.mkdirs();
      }
    }
    if (MMApplicationContext.isMMProcess())
    {
      this.iTM = (this.iTL + "/mm");
      AppMethodBeat.o(132530);
      return;
    }
    if (MMApplicationContext.isPushProcess()) {
      this.iTM = (this.iTL + "/push");
    }
    AppMethodBeat.o(132530);
  }
  
  private static void a(long paramLong, List<b> paramList)
  {
    AppMethodBeat.i(132533);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      if (localb == null)
      {
        paramList.remove(localb);
      }
      else
      {
        if (paramLong - localb.iUl < 259200000L) {
          break;
        }
        paramList.remove(localb);
      }
    }
    AppMethodBeat.o(132533);
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(132532);
    if (parama == null)
    {
      AppMethodBeat.o(132532);
      return;
    }
    long l = System.currentTimeMillis();
    Object localObject;
    for (;;)
    {
      try
      {
        localIterator = parama.iTO.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (d)localIterator.next();
        if (localObject == null)
        {
          parama.iTO.remove(localObject);
          continue;
        }
        if (l - ((d)localObject).endTime < 259200000L) {
          break;
        }
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace("MicroMsg.ActiveDetector.ProcessDetector", parama, "check data exception.", new Object[0]);
        AppMethodBeat.o(132532);
        return;
      }
      parama.iTO.remove(localObject);
    }
    Iterator localIterator = parama.iTP.iterator();
    while (localIterator.hasNext())
    {
      localObject = (c)localIterator.next();
      if (localObject == null)
      {
        parama.iTP.remove(localObject);
      }
      else
      {
        if (l - ((c)localObject).time < 259200000L) {
          break;
        }
        parama.iTP.remove(localObject);
      }
    }
    localIterator = parama.iTQ.iterator();
    while (localIterator.hasNext())
    {
      localObject = (c)localIterator.next();
      if (localObject == null)
      {
        parama.iTQ.remove(localObject);
      }
      else
      {
        if (l - ((c)localObject).time < 259200000L) {
          break;
        }
        parama.iTQ.remove(localObject);
      }
    }
    a(l, parama.iTR);
    a(l, parama.iTS);
    a(l, parama.iTT);
    a(l, parama.iTU);
    a(l, parama.iTV);
    a(l, parama.iTW);
    a(l, parama.iTX);
    a(l, parama.iTY);
    a(l, parama.iTZ);
    a(l, parama.iUa);
    a(l, parama.iUb);
    a(l, parama.iUc);
    a(l, parama.iUd);
    a(l, parama.iUe);
    a(l, parama.iUf);
    a(l, parama.iUg);
    a(l, parama.iUh);
    a(l, parama.iUi);
    a(l, parama.iUj);
    a(l, parama.iUk);
    AppMethodBeat.o(132532);
  }
  
  private static boolean a(StringBuilder paramStringBuilder, List<b> paramList, String paramString)
  {
    AppMethodBeat.i(132536);
    if (paramList.size() > 0)
    {
      paramStringBuilder.append(paramString).append("[").append(paramList.size()).append("]:\n");
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        paramString = (b)paramList.next();
        paramStringBuilder.append("\t").append(paramString).append("\n");
      }
      AppMethodBeat.o(132536);
      return true;
    }
    AppMethodBeat.o(132536);
    return false;
  }
  
  private static void b(a parama)
  {
    AppMethodBeat.i(132535);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ProcessInfo <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
    Iterator localIterator;
    Object localObject;
    if (parama.iTO.size() > 0)
    {
      localStringBuilder.append("processStatusList:\n");
      localIterator = parama.iTO.iterator();
      while (localIterator.hasNext())
      {
        localObject = (d)localIterator.next();
        localStringBuilder.append("\t").append(localObject).append("\n");
      }
    }
    if (parama.iTP.size() > 0)
    {
      localStringBuilder.append("sendInterProcessList:\n");
      localIterator = parama.iTP.iterator();
      while (localIterator.hasNext())
      {
        localObject = (c)localIterator.next();
        localStringBuilder.append("\t").append(localObject).append("\n");
      }
    }
    if (parama.iTQ.size() > 0)
    {
      localStringBuilder.append("receiveInterProcessList:\n");
      localIterator = parama.iTQ.iterator();
      while (localIterator.hasNext())
      {
        localObject = (c)localIterator.next();
        localStringBuilder.append("\t").append(localObject).append("\n");
      }
    }
    localStringBuilder.append(">>>>>>>>>>>>>>>>>>>>> foreground <<<<<<<<<<<<<<<<<<<<<\n");
    a(localStringBuilder, parama.iTR, "foregroundDelayed2sMsgList");
    a(localStringBuilder, parama.iTS, "foregroundDelayed5sMsgList");
    a(localStringBuilder, parama.iTT, "foregroundDelayed10sMsgList");
    a(localStringBuilder, parama.iTU, "foregroundDelayed30sMsgList");
    a(localStringBuilder, parama.iTV, "foregroundDelayed1minMsgList");
    a(localStringBuilder, parama.iTW, "foregroundDelayed3minMsgList");
    a(localStringBuilder, parama.iTX, "foregroundDelayed5minMsgList");
    a(localStringBuilder, parama.iTY, "foregroundDelayed10minMsgList");
    a(localStringBuilder, parama.iTZ, "foregroundDelayed30minMsgList");
    a(localStringBuilder, parama.iUa, "foregroundDelayed1hMsgList");
    localStringBuilder.append(">>>>>>>>>>>>>>>>>>>>> background <<<<<<<<<<<<<<<<<<<<<\n");
    a(localStringBuilder, parama.iUb, "backgroundDelayed2sMsgList");
    a(localStringBuilder, parama.iUc, "backgroundDelayed5sMsgList");
    a(localStringBuilder, parama.iUd, "backgroundDelayed10sMsgList");
    a(localStringBuilder, parama.iUe, "backgroundDelayed30sMsgList");
    a(localStringBuilder, parama.iUf, "backgroundDelayed1minMsgList");
    a(localStringBuilder, parama.iUg, "backgroundDelayed3minMsgList");
    a(localStringBuilder, parama.iUh, "backgroundDelayed5minMsgList");
    a(localStringBuilder, parama.iUi, "backgroundDelayed10minMsgList");
    a(localStringBuilder, parama.iUj, "backgroundDelayed30minMsgList");
    a(localStringBuilder, parama.iUk, "backgroundDelayed1hMsgList");
    localStringBuilder.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    Log.i("MicroMsg.ActiveDetector.ProcessDetector", "printProcessInfoAndReport()\n".concat(String.valueOf(localStringBuilder)));
    AppMethodBeat.o(132535);
  }
  
  private static long bbs()
  {
    AppMethodBeat.i(132534);
    if (iTF == 0L) {
      iTF = Util.getLong(d.cRY().b("clicfg_android_process_detect_time", "5", false, true), 5L) * 60L * 1000L;
    }
    long l = iTF;
    AppMethodBeat.o(132534);
    return l;
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc_w 363
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   10: putfield 60	com/tencent/mm/ap/c:iTJ	J
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 60	com/tencent/mm/ap/c:iTJ	J
    //   18: putfield 62	com/tencent/mm/ap/c:iTK	J
    //   21: aload_0
    //   22: new 17	com/tencent/mm/ap/c$d
    //   25: dup
    //   26: invokespecial 364	com/tencent/mm/ap/c$d:<init>	()V
    //   29: putfield 53	com/tencent/mm/ap/c:iTG	Lcom/tencent/mm/ap/c$d;
    //   32: aload_0
    //   33: getfield 53	com/tencent/mm/ap/c:iTG	Lcom/tencent/mm/ap/c$d;
    //   36: invokestatic 369	android/os/Process:myPid	()I
    //   39: aload_0
    //   40: getfield 60	com/tencent/mm/ap/c:iTJ	J
    //   43: aload_0
    //   44: getfield 62	com/tencent/mm/ap/c:iTK	J
    //   47: aload_0
    //   48: getfield 51	com/tencent/mm/ap/c:iTE	I
    //   51: invokevirtual 372	com/tencent/mm/ap/c$d:b	(IJJI)V
    //   54: aload_0
    //   55: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   58: getfield 155	com/tencent/mm/ap/c$a:iTO	Ljava/util/List;
    //   61: invokeinterface 375 1 0
    //   66: ifeq +425 -> 491
    //   69: aload_0
    //   70: getfield 66	com/tencent/mm/ap/c:iTM	Ljava/lang/String;
    //   73: invokestatic 381	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   76: invokestatic 387	com/tencent/mm/ap/b:y	(Ljava/io/InputStream;)Ljava/lang/Object;
    //   79: checkcast 8	com/tencent/mm/ap/c$a
    //   82: astore 9
    //   84: aload 9
    //   86: ifnull +405 -> 491
    //   89: aload 9
    //   91: getfield 171	com/tencent/mm/ap/c$a:iTP	Ljava/util/List;
    //   94: aload_0
    //   95: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   98: getfield 171	com/tencent/mm/ap/c$a:iTP	Ljava/util/List;
    //   101: invokeinterface 391 2 0
    //   106: pop
    //   107: aload 9
    //   109: getfield 177	com/tencent/mm/ap/c$a:iTQ	Ljava/util/List;
    //   112: aload_0
    //   113: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   116: getfield 177	com/tencent/mm/ap/c$a:iTQ	Ljava/util/List;
    //   119: invokeinterface 391 2 0
    //   124: pop
    //   125: aload 9
    //   127: getfield 180	com/tencent/mm/ap/c$a:iTR	Ljava/util/List;
    //   130: aload_0
    //   131: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   134: getfield 180	com/tencent/mm/ap/c$a:iTR	Ljava/util/List;
    //   137: invokeinterface 391 2 0
    //   142: pop
    //   143: aload 9
    //   145: getfield 185	com/tencent/mm/ap/c$a:iTS	Ljava/util/List;
    //   148: aload_0
    //   149: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   152: getfield 185	com/tencent/mm/ap/c$a:iTS	Ljava/util/List;
    //   155: invokeinterface 391 2 0
    //   160: pop
    //   161: aload 9
    //   163: getfield 188	com/tencent/mm/ap/c$a:iTT	Ljava/util/List;
    //   166: aload_0
    //   167: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   170: getfield 188	com/tencent/mm/ap/c$a:iTT	Ljava/util/List;
    //   173: invokeinterface 391 2 0
    //   178: pop
    //   179: aload 9
    //   181: getfield 191	com/tencent/mm/ap/c$a:iTU	Ljava/util/List;
    //   184: aload_0
    //   185: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   188: getfield 191	com/tencent/mm/ap/c$a:iTU	Ljava/util/List;
    //   191: invokeinterface 391 2 0
    //   196: pop
    //   197: aload 9
    //   199: getfield 194	com/tencent/mm/ap/c$a:iTV	Ljava/util/List;
    //   202: aload_0
    //   203: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   206: getfield 194	com/tencent/mm/ap/c$a:iTV	Ljava/util/List;
    //   209: invokeinterface 391 2 0
    //   214: pop
    //   215: aload 9
    //   217: getfield 197	com/tencent/mm/ap/c$a:iTW	Ljava/util/List;
    //   220: aload_0
    //   221: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   224: getfield 197	com/tencent/mm/ap/c$a:iTW	Ljava/util/List;
    //   227: invokeinterface 391 2 0
    //   232: pop
    //   233: aload 9
    //   235: getfield 200	com/tencent/mm/ap/c$a:iTX	Ljava/util/List;
    //   238: aload_0
    //   239: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   242: getfield 200	com/tencent/mm/ap/c$a:iTX	Ljava/util/List;
    //   245: invokeinterface 391 2 0
    //   250: pop
    //   251: aload 9
    //   253: getfield 203	com/tencent/mm/ap/c$a:iTY	Ljava/util/List;
    //   256: aload_0
    //   257: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   260: getfield 203	com/tencent/mm/ap/c$a:iTY	Ljava/util/List;
    //   263: invokeinterface 391 2 0
    //   268: pop
    //   269: aload 9
    //   271: getfield 206	com/tencent/mm/ap/c$a:iTZ	Ljava/util/List;
    //   274: aload_0
    //   275: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   278: getfield 206	com/tencent/mm/ap/c$a:iTZ	Ljava/util/List;
    //   281: invokeinterface 391 2 0
    //   286: pop
    //   287: aload 9
    //   289: getfield 209	com/tencent/mm/ap/c$a:iUa	Ljava/util/List;
    //   292: aload_0
    //   293: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   296: getfield 209	com/tencent/mm/ap/c$a:iUa	Ljava/util/List;
    //   299: invokeinterface 391 2 0
    //   304: pop
    //   305: aload 9
    //   307: getfield 212	com/tencent/mm/ap/c$a:iUb	Ljava/util/List;
    //   310: aload_0
    //   311: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   314: getfield 212	com/tencent/mm/ap/c$a:iUb	Ljava/util/List;
    //   317: invokeinterface 391 2 0
    //   322: pop
    //   323: aload 9
    //   325: getfield 215	com/tencent/mm/ap/c$a:iUc	Ljava/util/List;
    //   328: aload_0
    //   329: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   332: getfield 215	com/tencent/mm/ap/c$a:iUc	Ljava/util/List;
    //   335: invokeinterface 391 2 0
    //   340: pop
    //   341: aload 9
    //   343: getfield 218	com/tencent/mm/ap/c$a:iUd	Ljava/util/List;
    //   346: aload_0
    //   347: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   350: getfield 218	com/tencent/mm/ap/c$a:iUd	Ljava/util/List;
    //   353: invokeinterface 391 2 0
    //   358: pop
    //   359: aload 9
    //   361: getfield 221	com/tencent/mm/ap/c$a:iUe	Ljava/util/List;
    //   364: aload_0
    //   365: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   368: getfield 221	com/tencent/mm/ap/c$a:iUe	Ljava/util/List;
    //   371: invokeinterface 391 2 0
    //   376: pop
    //   377: aload 9
    //   379: getfield 224	com/tencent/mm/ap/c$a:iUf	Ljava/util/List;
    //   382: aload_0
    //   383: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   386: getfield 224	com/tencent/mm/ap/c$a:iUf	Ljava/util/List;
    //   389: invokeinterface 391 2 0
    //   394: pop
    //   395: aload 9
    //   397: getfield 227	com/tencent/mm/ap/c$a:iUg	Ljava/util/List;
    //   400: aload_0
    //   401: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   404: getfield 227	com/tencent/mm/ap/c$a:iUg	Ljava/util/List;
    //   407: invokeinterface 391 2 0
    //   412: pop
    //   413: aload 9
    //   415: getfield 230	com/tencent/mm/ap/c$a:iUh	Ljava/util/List;
    //   418: aload_0
    //   419: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   422: getfield 230	com/tencent/mm/ap/c$a:iUh	Ljava/util/List;
    //   425: invokeinterface 391 2 0
    //   430: pop
    //   431: aload 9
    //   433: getfield 233	com/tencent/mm/ap/c$a:iUi	Ljava/util/List;
    //   436: aload_0
    //   437: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   440: getfield 233	com/tencent/mm/ap/c$a:iUi	Ljava/util/List;
    //   443: invokeinterface 391 2 0
    //   448: pop
    //   449: aload 9
    //   451: getfield 236	com/tencent/mm/ap/c$a:iUj	Ljava/util/List;
    //   454: aload_0
    //   455: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   458: getfield 236	com/tencent/mm/ap/c$a:iUj	Ljava/util/List;
    //   461: invokeinterface 391 2 0
    //   466: pop
    //   467: aload 9
    //   469: getfield 239	com/tencent/mm/ap/c$a:iUk	Ljava/util/List;
    //   472: aload_0
    //   473: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   476: getfield 239	com/tencent/mm/ap/c$a:iUk	Ljava/util/List;
    //   479: invokeinterface 391 2 0
    //   484: pop
    //   485: aload_0
    //   486: aload 9
    //   488: putfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   491: aload_0
    //   492: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   495: invokestatic 393	com/tencent/mm/ap/c:a	(Lcom/tencent/mm/ap/c$a;)V
    //   498: aload_0
    //   499: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   502: getfield 155	com/tencent/mm/ap/c$a:iTO	Ljava/util/List;
    //   505: aload_0
    //   506: getfield 53	com/tencent/mm/ap/c:iTG	Lcom/tencent/mm/ap/c$d;
    //   509: invokeinterface 396 2 0
    //   514: pop
    //   515: ldc 157
    //   517: ldc_w 398
    //   520: iconst_3
    //   521: anewarray 4	java/lang/Object
    //   524: dup
    //   525: iconst_0
    //   526: aload_0
    //   527: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   530: getfield 155	com/tencent/mm/ap/c$a:iTO	Ljava/util/List;
    //   533: invokeinterface 245 1 0
    //   538: invokestatic 403	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   541: aastore
    //   542: dup
    //   543: iconst_1
    //   544: aload_0
    //   545: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   548: getfield 171	com/tencent/mm/ap/c$a:iTP	Ljava/util/List;
    //   551: invokeinterface 245 1 0
    //   556: invokestatic 403	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   559: aastore
    //   560: dup
    //   561: iconst_2
    //   562: aload_0
    //   563: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   566: getfield 177	com/tencent/mm/ap/c$a:iTQ	Ljava/util/List;
    //   569: invokeinterface 245 1 0
    //   574: invokestatic 403	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   577: aastore
    //   578: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   581: ldc 157
    //   583: ldc_w 408
    //   586: iconst_1
    //   587: anewarray 4	java/lang/Object
    //   590: dup
    //   591: iconst_0
    //   592: aload_0
    //   593: getfield 68	com/tencent/mm/ap/c:iTN	Z
    //   596: invokestatic 413	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   599: aastore
    //   600: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   603: invokestatic 418	com/tencent/mm/model/cl:aWy	()J
    //   606: lstore_3
    //   607: lload_3
    //   608: ldc_w 420
    //   611: invokestatic 426	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   614: ldc_w 428
    //   617: lconst_0
    //   618: invokevirtual 429	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getLong	(Ljava/lang/String;J)J
    //   621: lsub
    //   622: ldc2_w 430
    //   625: lcmp
    //   626: iflt +34 -> 660
    //   629: ldc_w 420
    //   632: invokestatic 426	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   635: invokevirtual 435	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:edit	()Landroid/content/SharedPreferences$Editor;
    //   638: ldc_w 428
    //   641: lload_3
    //   642: invokeinterface 441 4 0
    //   647: invokeinterface 444 1 0
    //   652: pop
    //   653: aload_0
    //   654: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   657: invokestatic 446	com/tencent/mm/ap/c:b	(Lcom/tencent/mm/ap/c$a;)V
    //   660: invokestatic 340	com/tencent/mm/plugin/expt/h/d:cRY	()Lcom/tencent/mm/plugin/expt/h/d;
    //   663: ldc_w 448
    //   666: ldc_w 450
    //   669: iconst_0
    //   670: iconst_1
    //   671: invokevirtual 347	com/tencent/mm/plugin/expt/h/d:b	(Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;
    //   674: ldc_w 450
    //   677: invokestatic 454	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   680: ifeq +429 -> 1109
    //   683: iconst_1
    //   684: istore_1
    //   685: iload_1
    //   686: ifeq +786 -> 1472
    //   689: aload_0
    //   690: getfield 68	com/tencent/mm/ap/c:iTN	Z
    //   693: ifeq +779 -> 1472
    //   696: invokestatic 460	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   699: invokevirtual 463	java/lang/Thread:isInterrupted	()Z
    //   702: ifne +770 -> 1472
    //   705: ldc 157
    //   707: ldc_w 465
    //   710: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   713: invokestatic 369	android/os/Process:myPid	()I
    //   716: istore_1
    //   717: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   720: lstore_3
    //   721: aload_0
    //   722: getfield 53	com/tencent/mm/ap/c:iTG	Lcom/tencent/mm/ap/c$d;
    //   725: astore 10
    //   727: aload_0
    //   728: getfield 62	com/tencent/mm/ap/c:iTK	J
    //   731: lstore 5
    //   733: aload_0
    //   734: getfield 51	com/tencent/mm/ap/c:iTE	I
    //   737: istore_2
    //   738: lload_3
    //   739: lload 5
    //   741: lsub
    //   742: lstore 7
    //   744: aload 10
    //   746: getfield 468	com/tencent/mm/ap/c$d:networkStatus	I
    //   749: iload_2
    //   750: if_icmpne +16 -> 766
    //   753: lload 7
    //   755: invokestatic 470	com/tencent/mm/ap/c:bbs	()J
    //   758: ldc2_w 471
    //   761: ladd
    //   762: lcmp
    //   763: ifle +351 -> 1114
    //   766: iload_1
    //   767: lload 5
    //   769: lload_3
    //   770: iload_2
    //   771: invokestatic 475	com/tencent/mm/ap/c$d:c	(IJJI)Lcom/tencent/mm/ap/c$d;
    //   774: astore 9
    //   776: aload 10
    //   778: getfield 468	com/tencent/mm/ap/c$d:networkStatus	I
    //   781: iload_2
    //   782: if_icmpeq +9 -> 791
    //   785: aload 9
    //   787: iconst_1
    //   788: putfield 478	com/tencent/mm/ap/c$d:iTz	Z
    //   791: lload 7
    //   793: invokestatic 470	com/tencent/mm/ap/c:bbs	()J
    //   796: ldc2_w 471
    //   799: ladd
    //   800: lcmp
    //   801: ifle +688 -> 1489
    //   804: aload 9
    //   806: iconst_0
    //   807: putfield 481	com/tencent/mm/ap/c$d:iTy	Z
    //   810: goto +679 -> 1489
    //   813: aload 9
    //   815: ifnull +315 -> 1130
    //   818: ldc 157
    //   820: ldc_w 483
    //   823: iconst_1
    //   824: anewarray 4	java/lang/Object
    //   827: dup
    //   828: iconst_0
    //   829: aload 9
    //   831: aastore
    //   832: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   835: aload_0
    //   836: aload 9
    //   838: putfield 53	com/tencent/mm/ap/c:iTG	Lcom/tencent/mm/ap/c$d;
    //   841: aload_0
    //   842: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   845: getfield 155	com/tencent/mm/ap/c$a:iTO	Ljava/util/List;
    //   848: aload_0
    //   849: getfield 53	com/tencent/mm/ap/c:iTG	Lcom/tencent/mm/ap/c$d;
    //   852: invokeinterface 396 2 0
    //   857: pop
    //   858: ldc 157
    //   860: ldc_w 485
    //   863: iconst_2
    //   864: anewarray 4	java/lang/Object
    //   867: dup
    //   868: iconst_0
    //   869: aload_0
    //   870: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   873: getfield 171	com/tencent/mm/ap/c$a:iTP	Ljava/util/List;
    //   876: aastore
    //   877: dup
    //   878: iconst_1
    //   879: aload_0
    //   880: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   883: getfield 177	com/tencent/mm/ap/c$a:iTQ	Ljava/util/List;
    //   886: aastore
    //   887: invokestatic 487	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   890: aload_0
    //   891: lload_3
    //   892: putfield 62	com/tencent/mm/ap/c:iTK	J
    //   895: aload_0
    //   896: getfield 58	com/tencent/mm/ap/c:iTI	J
    //   899: lconst_0
    //   900: lcmp
    //   901: ifle +16 -> 917
    //   904: lload_3
    //   905: aload_0
    //   906: getfield 58	com/tencent/mm/ap/c:iTI	J
    //   909: lsub
    //   910: ldc2_w 488
    //   913: lcmp
    //   914: ifle +107 -> 1021
    //   917: aload_0
    //   918: lload_3
    //   919: putfield 58	com/tencent/mm/ap/c:iTI	J
    //   922: aload_0
    //   923: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   926: ifnull +28 -> 954
    //   929: aload_0
    //   930: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   933: getfield 155	com/tencent/mm/ap/c$a:iTO	Ljava/util/List;
    //   936: ifnull +18 -> 954
    //   939: aload_0
    //   940: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   943: getfield 155	com/tencent/mm/ap/c$a:iTO	Ljava/util/List;
    //   946: invokeinterface 375 1 0
    //   951: ifeq +226 -> 1177
    //   954: ldc 157
    //   956: ldc_w 491
    //   959: iconst_1
    //   960: anewarray 4	java/lang/Object
    //   963: dup
    //   964: iconst_0
    //   965: aload_0
    //   966: getfield 53	com/tencent/mm/ap/c:iTG	Lcom/tencent/mm/ap/c$d;
    //   969: aastore
    //   970: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   973: ldc 157
    //   975: ldc_w 493
    //   978: iconst_2
    //   979: anewarray 4	java/lang/Object
    //   982: dup
    //   983: iconst_0
    //   984: aload_0
    //   985: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   988: getfield 171	com/tencent/mm/ap/c$a:iTP	Ljava/util/List;
    //   991: invokeinterface 245 1 0
    //   996: invokestatic 403	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   999: aastore
    //   1000: dup
    //   1001: iconst_1
    //   1002: aload_0
    //   1003: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   1006: getfield 177	com/tencent/mm/ap/c$a:iTQ	Ljava/util/List;
    //   1009: invokeinterface 245 1 0
    //   1014: invokestatic 403	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1017: aastore
    //   1018: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1021: invokestatic 470	com/tencent/mm/ap/c:bbs	()J
    //   1024: invokestatic 497	java/lang/Thread:sleep	(J)V
    //   1027: goto -367 -> 660
    //   1030: astore 9
    //   1032: ldc 157
    //   1034: ldc_w 499
    //   1037: iconst_1
    //   1038: anewarray 4	java/lang/Object
    //   1041: dup
    //   1042: iconst_0
    //   1043: invokestatic 502	android/os/Process:myTid	()I
    //   1046: invokestatic 403	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1049: aastore
    //   1050: invokestatic 406	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1053: invokestatic 460	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1056: invokevirtual 505	java/lang/Thread:interrupt	()V
    //   1059: aload_0
    //   1060: iconst_0
    //   1061: putfield 68	com/tencent/mm/ap/c:iTN	Z
    //   1064: goto -404 -> 660
    //   1067: astore 9
    //   1069: ldc 157
    //   1071: new 70	java/lang/StringBuilder
    //   1074: dup
    //   1075: ldc_w 507
    //   1078: invokespecial 508	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1081: aload 9
    //   1083: invokevirtual 511	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1086: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1092: iconst_1
    //   1093: anewarray 4	java/lang/Object
    //   1096: dup
    //   1097: iconst_0
    //   1098: aload_0
    //   1099: getfield 66	com/tencent/mm/ap/c:iTM	Ljava/lang/String;
    //   1102: aastore
    //   1103: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1106: goto -615 -> 491
    //   1109: iconst_0
    //   1110: istore_1
    //   1111: goto -426 -> 685
    //   1114: aload 10
    //   1116: iload_1
    //   1117: lload 5
    //   1119: lload_3
    //   1120: iload_2
    //   1121: invokevirtual 372	com/tencent/mm/ap/c$d:b	(IJJI)V
    //   1124: aconst_null
    //   1125: astore 9
    //   1127: goto -314 -> 813
    //   1130: ldc 157
    //   1132: ldc_w 516
    //   1135: iconst_1
    //   1136: anewarray 4	java/lang/Object
    //   1139: dup
    //   1140: iconst_0
    //   1141: aload_0
    //   1142: getfield 53	com/tencent/mm/ap/c:iTG	Lcom/tencent/mm/ap/c$d;
    //   1145: aastore
    //   1146: invokestatic 487	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1149: goto -291 -> 858
    //   1152: astore 9
    //   1154: ldc 157
    //   1156: ldc_w 518
    //   1159: iconst_1
    //   1160: anewarray 4	java/lang/Object
    //   1163: dup
    //   1164: iconst_0
    //   1165: aload 9
    //   1167: invokevirtual 511	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1170: aastore
    //   1171: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1174: goto -514 -> 660
    //   1177: ldc 157
    //   1179: ldc_w 520
    //   1182: iconst_1
    //   1183: anewarray 4	java/lang/Object
    //   1186: dup
    //   1187: iconst_0
    //   1188: aload_0
    //   1189: getfield 66	com/tencent/mm/ap/c:iTM	Ljava/lang/String;
    //   1192: aastore
    //   1193: invokestatic 487	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1196: aload_0
    //   1197: getfield 56	com/tencent/mm/ap/c:iTH	Lcom/tencent/mm/ap/c$a;
    //   1200: astore 11
    //   1202: aload_0
    //   1203: getfield 66	com/tencent/mm/ap/c:iTM	Ljava/lang/String;
    //   1206: iconst_0
    //   1207: invokestatic 524	com/tencent/mm/vfs/s:dw	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   1210: astore 9
    //   1212: aload 11
    //   1214: ifnull -260 -> 954
    //   1217: aload 9
    //   1219: ifnull -265 -> 954
    //   1222: new 526	java/io/ObjectOutputStream
    //   1225: dup
    //   1226: aload 9
    //   1228: invokespecial 529	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1231: astore 10
    //   1233: aload 10
    //   1235: astore 9
    //   1237: aload 10
    //   1239: aload 11
    //   1241: invokevirtual 533	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   1244: aload 10
    //   1246: astore 9
    //   1248: aload 10
    //   1250: invokevirtual 536	java/io/ObjectOutputStream:flush	()V
    //   1253: aload 10
    //   1255: invokevirtual 539	java/io/ObjectOutputStream:close	()V
    //   1258: goto -304 -> 954
    //   1261: astore 9
    //   1263: ldc_w 541
    //   1266: new 70	java/lang/StringBuilder
    //   1269: dup
    //   1270: ldc_w 543
    //   1273: invokespecial 508	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1276: aload 9
    //   1278: invokevirtual 511	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1281: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1284: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1287: invokestatic 546	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1290: goto -336 -> 954
    //   1293: astore 9
    //   1295: ldc 157
    //   1297: new 70	java/lang/StringBuilder
    //   1300: dup
    //   1301: ldc_w 548
    //   1304: invokespecial 508	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1307: aload 9
    //   1309: invokevirtual 511	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1312: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1315: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1318: iconst_1
    //   1319: anewarray 4	java/lang/Object
    //   1322: dup
    //   1323: iconst_0
    //   1324: aload_0
    //   1325: getfield 66	com/tencent/mm/ap/c:iTM	Ljava/lang/String;
    //   1328: aastore
    //   1329: invokestatic 514	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1332: goto -378 -> 954
    //   1335: astore 11
    //   1337: aconst_null
    //   1338: astore 10
    //   1340: aload 10
    //   1342: astore 9
    //   1344: ldc_w 541
    //   1347: new 70	java/lang/StringBuilder
    //   1350: dup
    //   1351: ldc_w 550
    //   1354: invokespecial 508	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1357: aload 11
    //   1359: invokevirtual 511	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1362: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1365: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1368: invokestatic 546	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1371: aload 10
    //   1373: ifnull -419 -> 954
    //   1376: aload 10
    //   1378: invokevirtual 539	java/io/ObjectOutputStream:close	()V
    //   1381: goto -427 -> 954
    //   1384: astore 9
    //   1386: ldc_w 541
    //   1389: new 70	java/lang/StringBuilder
    //   1392: dup
    //   1393: ldc_w 543
    //   1396: invokespecial 508	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1399: aload 9
    //   1401: invokevirtual 511	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1404: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1407: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1410: invokestatic 546	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1413: goto -459 -> 954
    //   1416: astore 10
    //   1418: aconst_null
    //   1419: astore 9
    //   1421: aload 9
    //   1423: ifnull +8 -> 1431
    //   1426: aload 9
    //   1428: invokevirtual 539	java/io/ObjectOutputStream:close	()V
    //   1431: ldc_w 363
    //   1434: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1437: aload 10
    //   1439: athrow
    //   1440: astore 9
    //   1442: ldc_w 541
    //   1445: new 70	java/lang/StringBuilder
    //   1448: dup
    //   1449: ldc_w 543
    //   1452: invokespecial 508	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1455: aload 9
    //   1457: invokevirtual 511	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1460: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1463: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1466: invokestatic 546	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1469: goto -38 -> 1431
    //   1472: ldc_w 363
    //   1475: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1478: return
    //   1479: astore 10
    //   1481: goto -60 -> 1421
    //   1484: astore 11
    //   1486: goto -146 -> 1340
    //   1489: goto -676 -> 813
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1492	0	this	c
    //   684	433	1	i	int
    //   737	384	2	j	int
    //   606	514	3	l1	long
    //   731	387	5	l2	long
    //   742	50	7	l3	long
    //   82	755	9	localObject1	Object
    //   1030	1	9	localInterruptedException	java.lang.InterruptedException
    //   1067	15	9	localException1	Exception
    //   1125	1	9	localObject2	Object
    //   1152	14	9	localException2	Exception
    //   1210	37	9	localObject3	Object
    //   1261	16	9	localException3	Exception
    //   1293	15	9	localException4	Exception
    //   1342	1	9	localObject4	Object
    //   1384	16	9	localException5	Exception
    //   1419	8	9	localObject5	Object
    //   1440	16	9	localException6	Exception
    //   725	652	10	localObject6	Object
    //   1416	22	10	localObject7	Object
    //   1479	1	10	localObject8	Object
    //   1200	40	11	locala	a
    //   1335	23	11	localException7	Exception
    //   1484	1	11	localException8	Exception
    // Exception table:
    //   from	to	target	type
    //   713	738	1030	java/lang/InterruptedException
    //   744	766	1030	java/lang/InterruptedException
    //   766	791	1030	java/lang/InterruptedException
    //   791	810	1030	java/lang/InterruptedException
    //   818	858	1030	java/lang/InterruptedException
    //   858	917	1030	java/lang/InterruptedException
    //   917	954	1030	java/lang/InterruptedException
    //   954	1021	1030	java/lang/InterruptedException
    //   1021	1027	1030	java/lang/InterruptedException
    //   1114	1124	1030	java/lang/InterruptedException
    //   1130	1149	1030	java/lang/InterruptedException
    //   1177	1196	1030	java/lang/InterruptedException
    //   1196	1212	1030	java/lang/InterruptedException
    //   1253	1258	1030	java/lang/InterruptedException
    //   1263	1290	1030	java/lang/InterruptedException
    //   1295	1332	1030	java/lang/InterruptedException
    //   1376	1381	1030	java/lang/InterruptedException
    //   1386	1413	1030	java/lang/InterruptedException
    //   1426	1431	1030	java/lang/InterruptedException
    //   1431	1440	1030	java/lang/InterruptedException
    //   1442	1469	1030	java/lang/InterruptedException
    //   69	84	1067	java/lang/Exception
    //   89	491	1067	java/lang/Exception
    //   713	738	1152	java/lang/Exception
    //   744	766	1152	java/lang/Exception
    //   766	791	1152	java/lang/Exception
    //   791	810	1152	java/lang/Exception
    //   818	858	1152	java/lang/Exception
    //   858	917	1152	java/lang/Exception
    //   917	954	1152	java/lang/Exception
    //   954	1021	1152	java/lang/Exception
    //   1021	1027	1152	java/lang/Exception
    //   1114	1124	1152	java/lang/Exception
    //   1130	1149	1152	java/lang/Exception
    //   1177	1196	1152	java/lang/Exception
    //   1295	1332	1152	java/lang/Exception
    //   1253	1258	1261	java/lang/Exception
    //   1196	1212	1293	java/lang/Exception
    //   1263	1290	1293	java/lang/Exception
    //   1386	1413	1293	java/lang/Exception
    //   1431	1440	1293	java/lang/Exception
    //   1442	1469	1293	java/lang/Exception
    //   1222	1233	1335	java/lang/Exception
    //   1376	1381	1384	java/lang/Exception
    //   1222	1233	1416	finally
    //   1426	1431	1440	java/lang/Exception
    //   1237	1244	1479	finally
    //   1248	1253	1479	finally
    //   1344	1371	1479	finally
    //   1237	1244	1484	java/lang/Exception
    //   1248	1253	1484	java/lang/Exception
  }
  
  static final class a
    implements Serializable
  {
    final List<c.d> iTO;
    final List<c.c> iTP;
    final List<c.c> iTQ;
    final List<c.b> iTR;
    final List<c.b> iTS;
    final List<c.b> iTT;
    final List<c.b> iTU;
    final List<c.b> iTV;
    final List<c.b> iTW;
    final List<c.b> iTX;
    final List<c.b> iTY;
    final List<c.b> iTZ;
    final List<c.b> iUa;
    final List<c.b> iUb;
    final List<c.b> iUc;
    final List<c.b> iUd;
    final List<c.b> iUe;
    final List<c.b> iUf;
    final List<c.b> iUg;
    final List<c.b> iUh;
    final List<c.b> iUi;
    final List<c.b> iUj;
    final List<c.b> iUk;
    
    a()
    {
      AppMethodBeat.i(132524);
      this.iTO = new CopyOnWriteArrayList();
      this.iTP = new CopyOnWriteArrayList();
      this.iTQ = new CopyOnWriteArrayList();
      this.iTR = new CopyOnWriteArrayList();
      this.iTS = new CopyOnWriteArrayList();
      this.iTT = new CopyOnWriteArrayList();
      this.iTU = new CopyOnWriteArrayList();
      this.iTV = new CopyOnWriteArrayList();
      this.iTW = new CopyOnWriteArrayList();
      this.iTX = new CopyOnWriteArrayList();
      this.iTY = new CopyOnWriteArrayList();
      this.iTZ = new CopyOnWriteArrayList();
      this.iUa = new CopyOnWriteArrayList();
      this.iUb = new CopyOnWriteArrayList();
      this.iUc = new CopyOnWriteArrayList();
      this.iUd = new CopyOnWriteArrayList();
      this.iUe = new CopyOnWriteArrayList();
      this.iUf = new CopyOnWriteArrayList();
      this.iUg = new CopyOnWriteArrayList();
      this.iUh = new CopyOnWriteArrayList();
      this.iUi = new CopyOnWriteArrayList();
      this.iUj = new CopyOnWriteArrayList();
      this.iUk = new CopyOnWriteArrayList();
      AppMethodBeat.o(132524);
    }
  }
  
  static final class b
    implements Serializable
  {
    long iTB = 0L;
    long iTC = 0L;
    long iTD = 0L;
    long iTx = 0L;
    long iUl = 0L;
    int msgType = 0;
    int pid = 0;
    String username = "";
    
    b(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2)
    {
      this.pid = paramInt1;
      this.iTx = paramLong1;
      this.iUl = paramLong2;
      this.iTB = paramLong3;
      this.iTC = paramLong4;
      this.iTD = paramLong5;
      this.username = paramString;
      this.msgType = paramInt2;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(132525);
      String str = String.format("pid:%s, server time:%s, client time:%s, msg server time:%s, intervalTime:%s, msg server id:%s username:%s, msgType:%s", new Object[] { Integer.valueOf(this.pid), a.Av(this.iTx), a.Av(this.iUl), a.Av(this.iTB), Long.valueOf(this.iTC), Long.valueOf(this.iTD), this.username, Integer.valueOf(this.msgType) });
      AppMethodBeat.o(132525);
      return str;
    }
  }
  
  static final class c
    implements Serializable
  {
    long iTx = 0L;
    long iUm;
    long time = 0L;
    int type = 0;
    
    c(long paramLong1, long paramLong2, int paramInt, long paramLong3)
    {
      this.iTx = paramLong1;
      this.time = paramLong2;
      this.type = paramInt;
      this.iUm = paramLong3;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(132526);
      String str = String.format("serverTime:%s,time:%s,type:%s,recvTime:%s", new Object[] { a.Av(this.iTx), a.Av(this.time), Integer.valueOf(this.type), Long.valueOf(this.iUm) });
      AppMethodBeat.o(132526);
      return str;
    }
  }
  
  public static final class d
    implements Serializable
  {
    long endTime = 0L;
    boolean iTy = true;
    boolean iTz = false;
    long iUn = 0L;
    int networkStatus = 0;
    int pid = 0;
    long startTime = 0L;
    
    static d c(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
    {
      AppMethodBeat.i(132528);
      d locald = new d();
      locald.pid = paramInt1;
      locald.startTime = paramLong1;
      locald.endTime = paramLong2;
      locald.networkStatus = paramInt2;
      AppMethodBeat.o(132528);
      return locald;
    }
    
    final void b(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
    {
      AppMethodBeat.i(132527);
      this.pid = paramInt1;
      if (this.startTime <= 0L)
      {
        this.startTime = paramLong1;
        this.iUn = cl.aWy();
      }
      this.endTime = paramLong2;
      this.networkStatus = paramInt2;
      AppMethodBeat.o(132527);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(132529);
      String str = String.format("pid:%s,startServerTime:%s,startTime:%s,endTime:%s,normalExecute:%s,changedNetworkStatus:%s,networkStatus:%s", new Object[] { Integer.valueOf(this.pid), a.Av(this.iUn), a.Av(this.startTime), a.Av(this.endTime), Boolean.valueOf(this.iTy), Boolean.valueOf(this.iTz), Integer.valueOf(this.networkStatus) });
      AppMethodBeat.o(132529);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ap.c
 * JD-Core Version:    0.7.0.1
 */