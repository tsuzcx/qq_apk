package com.tencent.mm.aq;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class c
  implements Runnable
{
  private static long oCA = 0L;
  private d oCB;
  a oCC;
  private long oCD;
  long oCE;
  long oCF;
  String oCG;
  private String oCH;
  boolean oCI;
  int oCz;
  
  c()
  {
    AppMethodBeat.i(132530);
    this.oCz = 0;
    this.oCB = null;
    this.oCC = new a();
    this.oCD = 0L;
    this.oCE = 0L;
    this.oCF = 0L;
    this.oCG = null;
    this.oCH = null;
    this.oCI = false;
    if (this.oCG == null)
    {
      this.oCG = (b.bmr() + "ProcessDetector");
      u localu = new u(this.oCG);
      if (!localu.jKS()) {
        localu.jKY();
      }
    }
    if (MMApplicationContext.isMMProcess())
    {
      this.oCH = (this.oCG + "/mm");
      AppMethodBeat.o(132530);
      return;
    }
    if (MMApplicationContext.isPushProcess()) {
      this.oCH = (this.oCG + "/push");
    }
    AppMethodBeat.o(132530);
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
        localIterator = parama.oCJ.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (d)localIterator.next();
        if (localObject == null)
        {
          parama.oCJ.remove(localObject);
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
      parama.oCJ.remove(localObject);
    }
    Iterator localIterator = parama.oCK.iterator();
    while (localIterator.hasNext())
    {
      localObject = (c)localIterator.next();
      if (localObject == null)
      {
        parama.oCK.remove(localObject);
      }
      else
      {
        if (l - ((c)localObject).time < 259200000L) {
          break;
        }
        parama.oCK.remove(localObject);
      }
    }
    localIterator = parama.oCL.iterator();
    while (localIterator.hasNext())
    {
      localObject = (c)localIterator.next();
      if (localObject == null)
      {
        parama.oCL.remove(localObject);
      }
      else
      {
        if (l - ((c)localObject).time < 259200000L) {
          break;
        }
        parama.oCL.remove(localObject);
      }
    }
    f(l, parama.oCM);
    f(l, parama.oCN);
    f(l, parama.oCO);
    f(l, parama.oCP);
    f(l, parama.oCQ);
    f(l, parama.oCR);
    f(l, parama.oCS);
    f(l, parama.oCT);
    f(l, parama.oCU);
    f(l, parama.oCV);
    f(l, parama.oCW);
    f(l, parama.oCX);
    f(l, parama.oCY);
    f(l, parama.oCZ);
    f(l, parama.oDa);
    f(l, parama.oDb);
    f(l, parama.oDc);
    f(l, parama.oDd);
    f(l, parama.oDe);
    f(l, parama.oDf);
    AppMethodBeat.o(132532);
  }
  
  private static boolean a(StringBuilder paramStringBuilder, List<b> paramList, String paramString)
  {
    AppMethodBeat.i(132536);
    int i;
    if (paramList.size() > 0)
    {
      paramStringBuilder.append(paramString).append("[").append(paramList.size()).append("]:\n");
      paramList = paramList.iterator();
      i = 0;
    }
    for (;;)
    {
      if (paramList.hasNext())
      {
        paramString = (b)paramList.next();
        paramStringBuilder.append("\t").append(paramString).append("\n");
        i += 1;
        if (i <= 1000) {}
      }
      else
      {
        AppMethodBeat.o(132536);
        return true;
        AppMethodBeat.o(132536);
        return false;
      }
    }
  }
  
  private static void b(a parama)
  {
    int j = 0;
    AppMethodBeat.i(132535);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ProcessInfo <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
    Iterator localIterator;
    int i;
    if (parama.oCJ.size() > 0)
    {
      localStringBuilder.append("processStatusList:\n");
      localIterator = parama.oCJ.iterator();
      i = 0;
    }
    for (;;)
    {
      Object localObject;
      if (localIterator.hasNext())
      {
        localObject = (d)localIterator.next();
        localStringBuilder.append("\t").append(localObject).append("\n");
        i += 1;
        if (i <= 1000) {}
      }
      else
      {
        if (parama.oCK.size() > 0)
        {
          localStringBuilder.append("sendInterProcessList:\n");
          localIterator = parama.oCK.iterator();
          i = 0;
        }
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject = (c)localIterator.next();
            localStringBuilder.append("\t").append(localObject).append("\n");
            i += 1;
            if (i <= 1000) {}
          }
          else
          {
            if (parama.oCL.size() > 0)
            {
              localStringBuilder.append("receiveInterProcessList:\n");
              localIterator = parama.oCL.iterator();
              i = j;
              do
              {
                if (!localIterator.hasNext()) {
                  break;
                }
                localObject = (c)localIterator.next();
                localStringBuilder.append("\t").append(localObject).append("\n");
                j = i + 1;
                i = j;
              } while (j <= 1000);
            }
            localStringBuilder.append(">>>>>>>>>>>>>>>>>>>>> foreground <<<<<<<<<<<<<<<<<<<<<\n");
            a(localStringBuilder, parama.oCM, "foregroundDelayed2sMsgList");
            a(localStringBuilder, parama.oCN, "foregroundDelayed5sMsgList");
            a(localStringBuilder, parama.oCO, "foregroundDelayed10sMsgList");
            a(localStringBuilder, parama.oCP, "foregroundDelayed30sMsgList");
            a(localStringBuilder, parama.oCQ, "foregroundDelayed1minMsgList");
            a(localStringBuilder, parama.oCR, "foregroundDelayed3minMsgList");
            a(localStringBuilder, parama.oCS, "foregroundDelayed5minMsgList");
            a(localStringBuilder, parama.oCT, "foregroundDelayed10minMsgList");
            a(localStringBuilder, parama.oCU, "foregroundDelayed30minMsgList");
            a(localStringBuilder, parama.oCV, "foregroundDelayed1hMsgList");
            localStringBuilder.append(">>>>>>>>>>>>>>>>>>>>> background <<<<<<<<<<<<<<<<<<<<<\n");
            a(localStringBuilder, parama.oCW, "backgroundDelayed2sMsgList");
            a(localStringBuilder, parama.oCX, "backgroundDelayed5sMsgList");
            a(localStringBuilder, parama.oCY, "backgroundDelayed10sMsgList");
            a(localStringBuilder, parama.oCZ, "backgroundDelayed30sMsgList");
            a(localStringBuilder, parama.oDa, "backgroundDelayed1minMsgList");
            a(localStringBuilder, parama.oDb, "backgroundDelayed3minMsgList");
            a(localStringBuilder, parama.oDc, "backgroundDelayed5minMsgList");
            a(localStringBuilder, parama.oDd, "backgroundDelayed10minMsgList");
            a(localStringBuilder, parama.oDe, "backgroundDelayed30minMsgList");
            a(localStringBuilder, parama.oDf, "backgroundDelayed1hMsgList");
            localStringBuilder.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            Log.i("MicroMsg.ActiveDetector.ProcessDetector", "printProcessInfoAndReport()\n".concat(String.valueOf(localStringBuilder)));
            AppMethodBeat.o(132535);
            return;
          }
        }
      }
    }
  }
  
  private static long bIC()
  {
    AppMethodBeat.i(132534);
    if (oCA == 0L) {
      oCA = Util.getLong(d.dNI().a("clicfg_android_process_detect_time", "5", false, true), 5L) * 60L * 1000L;
    }
    long l = oCA;
    AppMethodBeat.o(132534);
    return l;
  }
  
  private static void f(long paramLong, List<b> paramList)
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
        if (paramLong - localb.oDg < 259200000L) {
          break;
        }
        paramList.remove(localb);
      }
    }
    AppMethodBeat.o(132533);
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc_w 366
    //   3: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   10: putfield 60	com/tencent/mm/aq/c:oCE	J
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 60	com/tencent/mm/aq/c:oCE	J
    //   18: putfield 62	com/tencent/mm/aq/c:oCF	J
    //   21: aload_0
    //   22: new 17	com/tencent/mm/aq/c$d
    //   25: dup
    //   26: invokespecial 367	com/tencent/mm/aq/c$d:<init>	()V
    //   29: putfield 53	com/tencent/mm/aq/c:oCB	Lcom/tencent/mm/aq/c$d;
    //   32: aload_0
    //   33: getfield 53	com/tencent/mm/aq/c:oCB	Lcom/tencent/mm/aq/c$d;
    //   36: invokestatic 372	android/os/Process:myPid	()I
    //   39: aload_0
    //   40: getfield 60	com/tencent/mm/aq/c:oCE	J
    //   43: aload_0
    //   44: getfield 62	com/tencent/mm/aq/c:oCF	J
    //   47: aload_0
    //   48: getfield 51	com/tencent/mm/aq/c:oCz	I
    //   51: invokevirtual 375	com/tencent/mm/aq/c$d:b	(IJJI)V
    //   54: aload_0
    //   55: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   58: getfield 127	com/tencent/mm/aq/c$a:oCJ	Ljava/util/List;
    //   61: invokeinterface 378 1 0
    //   66: ifeq +62 -> 128
    //   69: aload_0
    //   70: getfield 66	com/tencent/mm/aq/c:oCH	Ljava/lang/String;
    //   73: invokestatic 384	com/tencent/mm/vfs/y:bEl	(Ljava/lang/String;)J
    //   76: lstore_3
    //   77: lload_3
    //   78: ldc2_w 385
    //   81: lcmp
    //   82: ifle +610 -> 692
    //   85: ldc 148
    //   87: ldc_w 388
    //   90: iconst_3
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_0
    //   97: getfield 66	com/tencent/mm/aq/c:oCH	Ljava/lang/String;
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: lload_3
    //   104: invokestatic 393	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: ldc2_w 385
    //   113: invokestatic 393	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   116: aastore
    //   117: invokestatic 397	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aload_0
    //   121: getfield 66	com/tencent/mm/aq/c:oCH	Ljava/lang/String;
    //   124: invokestatic 401	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   127: pop
    //   128: aload_0
    //   129: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   132: invokestatic 403	com/tencent/mm/aq/c:a	(Lcom/tencent/mm/aq/c$a;)V
    //   135: aload_0
    //   136: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   139: aload_0
    //   140: getfield 53	com/tencent/mm/aq/c:oCB	Lcom/tencent/mm/aq/c$d;
    //   143: invokevirtual 406	com/tencent/mm/aq/c$a:a	(Lcom/tencent/mm/aq/c$d;)V
    //   146: ldc 148
    //   148: ldc_w 408
    //   151: iconst_3
    //   152: anewarray 4	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload_0
    //   158: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   161: getfield 127	com/tencent/mm/aq/c$a:oCJ	Ljava/util/List;
    //   164: invokeinterface 240 1 0
    //   169: invokestatic 413	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: aload_0
    //   176: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   179: getfield 164	com/tencent/mm/aq/c$a:oCK	Ljava/util/List;
    //   182: invokeinterface 240 1 0
    //   187: invokestatic 413	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: dup
    //   192: iconst_2
    //   193: aload_0
    //   194: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   197: getfield 170	com/tencent/mm/aq/c$a:oCL	Ljava/util/List;
    //   200: invokeinterface 240 1 0
    //   205: invokestatic 413	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   208: aastore
    //   209: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: ldc 148
    //   214: ldc_w 417
    //   217: iconst_1
    //   218: anewarray 4	java/lang/Object
    //   221: dup
    //   222: iconst_0
    //   223: aload_0
    //   224: getfield 68	com/tencent/mm/aq/c:oCI	Z
    //   227: invokestatic 422	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   230: aastore
    //   231: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: invokestatic 427	com/tencent/mm/model/cn:bDu	()J
    //   237: lstore_3
    //   238: lload_3
    //   239: ldc_w 429
    //   242: invokestatic 435	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   245: ldc_w 437
    //   248: lconst_0
    //   249: invokevirtual 438	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getLong	(Ljava/lang/String;J)J
    //   252: lsub
    //   253: ldc2_w 439
    //   256: lcmp
    //   257: iflt +34 -> 291
    //   260: ldc_w 429
    //   263: invokestatic 435	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   266: invokevirtual 444	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:edit	()Landroid/content/SharedPreferences$Editor;
    //   269: ldc_w 437
    //   272: lload_3
    //   273: invokeinterface 450 4 0
    //   278: invokeinterface 453 1 0
    //   283: pop
    //   284: aload_0
    //   285: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   288: invokestatic 455	com/tencent/mm/aq/c:b	(Lcom/tencent/mm/aq/c$a;)V
    //   291: invokestatic 336	com/tencent/mm/plugin/expt/e/d:dNI	()Lcom/tencent/mm/plugin/expt/e/d;
    //   294: ldc_w 457
    //   297: ldc_w 459
    //   300: iconst_0
    //   301: iconst_1
    //   302: invokevirtual 343	com/tencent/mm/plugin/expt/e/d:a	(Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;
    //   305: ldc_w 459
    //   308: invokestatic 463	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   311: ifeq +998 -> 1309
    //   314: iconst_1
    //   315: istore_1
    //   316: iload_1
    //   317: ifeq +1355 -> 1672
    //   320: aload_0
    //   321: getfield 68	com/tencent/mm/aq/c:oCI	Z
    //   324: ifeq +1348 -> 1672
    //   327: invokestatic 469	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   330: invokevirtual 472	java/lang/Thread:isInterrupted	()Z
    //   333: ifne +1339 -> 1672
    //   336: ldc 148
    //   338: ldc_w 474
    //   341: invokestatic 328	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: invokestatic 372	android/os/Process:myPid	()I
    //   347: istore_1
    //   348: invokestatic 123	java/lang/System:currentTimeMillis	()J
    //   351: lstore_3
    //   352: aload_0
    //   353: getfield 53	com/tencent/mm/aq/c:oCB	Lcom/tencent/mm/aq/c$d;
    //   356: astore 10
    //   358: aload_0
    //   359: getfield 62	com/tencent/mm/aq/c:oCF	J
    //   362: lstore 5
    //   364: aload_0
    //   365: getfield 51	com/tencent/mm/aq/c:oCz	I
    //   368: istore_2
    //   369: lload_3
    //   370: lload 5
    //   372: lsub
    //   373: lstore 7
    //   375: aload 10
    //   377: getfield 477	com/tencent/mm/aq/c$d:networkStatus	I
    //   380: iload_2
    //   381: if_icmpne +16 -> 397
    //   384: lload 7
    //   386: invokestatic 479	com/tencent/mm/aq/c:bIC	()J
    //   389: ldc2_w 480
    //   392: ladd
    //   393: lcmp
    //   394: ifle +920 -> 1314
    //   397: iload_1
    //   398: lload 5
    //   400: lload_3
    //   401: iload_2
    //   402: invokestatic 484	com/tencent/mm/aq/c$d:c	(IJJI)Lcom/tencent/mm/aq/c$d;
    //   405: astore 9
    //   407: aload 10
    //   409: getfield 477	com/tencent/mm/aq/c$d:networkStatus	I
    //   412: iload_2
    //   413: if_icmpeq +9 -> 422
    //   416: aload 9
    //   418: iconst_1
    //   419: putfield 487	com/tencent/mm/aq/c$d:oCu	Z
    //   422: lload 7
    //   424: invokestatic 479	com/tencent/mm/aq/c:bIC	()J
    //   427: ldc2_w 480
    //   430: ladd
    //   431: lcmp
    //   432: ifle +1257 -> 1689
    //   435: aload 9
    //   437: iconst_0
    //   438: putfield 490	com/tencent/mm/aq/c$d:oCt	Z
    //   441: goto +1248 -> 1689
    //   444: aload 9
    //   446: ifnull +884 -> 1330
    //   449: ldc 148
    //   451: ldc_w 492
    //   454: iconst_1
    //   455: anewarray 4	java/lang/Object
    //   458: dup
    //   459: iconst_0
    //   460: aload 9
    //   462: aastore
    //   463: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: aload_0
    //   467: aload 9
    //   469: putfield 53	com/tencent/mm/aq/c:oCB	Lcom/tencent/mm/aq/c$d;
    //   472: aload_0
    //   473: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   476: aload_0
    //   477: getfield 53	com/tencent/mm/aq/c:oCB	Lcom/tencent/mm/aq/c$d;
    //   480: invokevirtual 406	com/tencent/mm/aq/c$a:a	(Lcom/tencent/mm/aq/c$d;)V
    //   483: ldc 148
    //   485: ldc_w 494
    //   488: iconst_2
    //   489: anewarray 4	java/lang/Object
    //   492: dup
    //   493: iconst_0
    //   494: aload_0
    //   495: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   498: getfield 164	com/tencent/mm/aq/c$a:oCK	Ljava/util/List;
    //   501: aastore
    //   502: dup
    //   503: iconst_1
    //   504: aload_0
    //   505: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   508: getfield 170	com/tencent/mm/aq/c$a:oCL	Ljava/util/List;
    //   511: aastore
    //   512: invokestatic 496	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   515: aload_0
    //   516: lload_3
    //   517: putfield 62	com/tencent/mm/aq/c:oCF	J
    //   520: aload_0
    //   521: getfield 58	com/tencent/mm/aq/c:oCD	J
    //   524: lconst_0
    //   525: lcmp
    //   526: ifle +16 -> 542
    //   529: lload_3
    //   530: aload_0
    //   531: getfield 58	com/tencent/mm/aq/c:oCD	J
    //   534: lsub
    //   535: ldc2_w 497
    //   538: lcmp
    //   539: ifle +107 -> 646
    //   542: aload_0
    //   543: lload_3
    //   544: putfield 58	com/tencent/mm/aq/c:oCD	J
    //   547: aload_0
    //   548: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   551: ifnull +28 -> 579
    //   554: aload_0
    //   555: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   558: getfield 127	com/tencent/mm/aq/c$a:oCJ	Ljava/util/List;
    //   561: ifnull +18 -> 579
    //   564: aload_0
    //   565: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   568: getfield 127	com/tencent/mm/aq/c$a:oCJ	Ljava/util/List;
    //   571: invokeinterface 378 1 0
    //   576: ifeq +801 -> 1377
    //   579: ldc 148
    //   581: ldc_w 500
    //   584: iconst_1
    //   585: anewarray 4	java/lang/Object
    //   588: dup
    //   589: iconst_0
    //   590: aload_0
    //   591: getfield 53	com/tencent/mm/aq/c:oCB	Lcom/tencent/mm/aq/c$d;
    //   594: aastore
    //   595: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   598: ldc 148
    //   600: ldc_w 502
    //   603: iconst_2
    //   604: anewarray 4	java/lang/Object
    //   607: dup
    //   608: iconst_0
    //   609: aload_0
    //   610: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   613: getfield 164	com/tencent/mm/aq/c$a:oCK	Ljava/util/List;
    //   616: invokeinterface 240 1 0
    //   621: invokestatic 413	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   624: aastore
    //   625: dup
    //   626: iconst_1
    //   627: aload_0
    //   628: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   631: getfield 170	com/tencent/mm/aq/c$a:oCL	Ljava/util/List;
    //   634: invokeinterface 240 1 0
    //   639: invokestatic 413	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   642: aastore
    //   643: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   646: invokestatic 479	com/tencent/mm/aq/c:bIC	()J
    //   649: invokestatic 506	java/lang/Thread:sleep	(J)V
    //   652: goto -361 -> 291
    //   655: astore 9
    //   657: ldc 148
    //   659: ldc_w 508
    //   662: iconst_1
    //   663: anewarray 4	java/lang/Object
    //   666: dup
    //   667: iconst_0
    //   668: invokestatic 511	android/os/Process:myTid	()I
    //   671: invokestatic 413	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   674: aastore
    //   675: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   678: invokestatic 469	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   681: invokevirtual 514	java/lang/Thread:interrupt	()V
    //   684: aload_0
    //   685: iconst_0
    //   686: putfield 68	com/tencent/mm/aq/c:oCI	Z
    //   689: goto -398 -> 291
    //   692: aload_0
    //   693: getfield 66	com/tencent/mm/aq/c:oCH	Ljava/lang/String;
    //   696: invokestatic 518	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   699: invokestatic 523	com/tencent/mm/aq/b:I	(Ljava/io/InputStream;)Ljava/lang/Object;
    //   702: checkcast 8	com/tencent/mm/aq/c$a
    //   705: astore 9
    //   707: aload 9
    //   709: ifnull -581 -> 128
    //   712: aload_0
    //   713: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   716: getfield 164	com/tencent/mm/aq/c$a:oCK	Ljava/util/List;
    //   719: astore 10
    //   721: aload 9
    //   723: getfield 164	com/tencent/mm/aq/c$a:oCK	Ljava/util/List;
    //   726: invokeinterface 240 1 0
    //   731: istore_1
    //   732: iload_1
    //   733: sipush 30000
    //   736: if_icmple +60 -> 796
    //   739: iconst_0
    //   740: istore_1
    //   741: iload_1
    //   742: aload 10
    //   744: invokeinterface 240 1 0
    //   749: bipush 100
    //   751: iadd
    //   752: if_icmpge +44 -> 796
    //   755: aload 9
    //   757: getfield 164	com/tencent/mm/aq/c$a:oCK	Ljava/util/List;
    //   760: iconst_0
    //   761: invokeinterface 526 2 0
    //   766: pop
    //   767: iload_1
    //   768: iconst_1
    //   769: iadd
    //   770: istore_1
    //   771: goto -30 -> 741
    //   774: astore 11
    //   776: ldc 148
    //   778: ldc_w 528
    //   781: iconst_1
    //   782: anewarray 4	java/lang/Object
    //   785: dup
    //   786: iconst_0
    //   787: aload 11
    //   789: invokevirtual 531	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   792: aastore
    //   793: invokestatic 397	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   796: aload 9
    //   798: getfield 164	com/tencent/mm/aq/c$a:oCK	Ljava/util/List;
    //   801: aload 10
    //   803: invokeinterface 535 2 0
    //   808: pop
    //   809: aload_0
    //   810: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   813: getfield 170	com/tencent/mm/aq/c$a:oCL	Ljava/util/List;
    //   816: astore 10
    //   818: aload 9
    //   820: getfield 170	com/tencent/mm/aq/c$a:oCL	Ljava/util/List;
    //   823: invokeinterface 240 1 0
    //   828: istore_1
    //   829: iload_1
    //   830: sipush 30000
    //   833: if_icmple +60 -> 893
    //   836: iconst_0
    //   837: istore_1
    //   838: iload_1
    //   839: aload 10
    //   841: invokeinterface 240 1 0
    //   846: bipush 100
    //   848: iadd
    //   849: if_icmpge +44 -> 893
    //   852: aload 9
    //   854: getfield 170	com/tencent/mm/aq/c$a:oCL	Ljava/util/List;
    //   857: iconst_0
    //   858: invokeinterface 526 2 0
    //   863: pop
    //   864: iload_1
    //   865: iconst_1
    //   866: iadd
    //   867: istore_1
    //   868: goto -30 -> 838
    //   871: astore 11
    //   873: ldc 148
    //   875: ldc_w 537
    //   878: iconst_1
    //   879: anewarray 4	java/lang/Object
    //   882: dup
    //   883: iconst_0
    //   884: aload 11
    //   886: invokevirtual 531	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   889: aastore
    //   890: invokestatic 397	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   893: aload 9
    //   895: getfield 170	com/tencent/mm/aq/c$a:oCL	Ljava/util/List;
    //   898: aload 10
    //   900: invokeinterface 535 2 0
    //   905: pop
    //   906: aload 9
    //   908: getfield 173	com/tencent/mm/aq/c$a:oCM	Ljava/util/List;
    //   911: aload_0
    //   912: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   915: getfield 173	com/tencent/mm/aq/c$a:oCM	Ljava/util/List;
    //   918: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   921: aload 9
    //   923: getfield 180	com/tencent/mm/aq/c$a:oCN	Ljava/util/List;
    //   926: aload_0
    //   927: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   930: getfield 180	com/tencent/mm/aq/c$a:oCN	Ljava/util/List;
    //   933: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   936: aload 9
    //   938: getfield 183	com/tencent/mm/aq/c$a:oCO	Ljava/util/List;
    //   941: aload_0
    //   942: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   945: getfield 183	com/tencent/mm/aq/c$a:oCO	Ljava/util/List;
    //   948: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   951: aload 9
    //   953: getfield 186	com/tencent/mm/aq/c$a:oCP	Ljava/util/List;
    //   956: aload_0
    //   957: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   960: getfield 186	com/tencent/mm/aq/c$a:oCP	Ljava/util/List;
    //   963: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   966: aload 9
    //   968: getfield 189	com/tencent/mm/aq/c$a:oCQ	Ljava/util/List;
    //   971: aload_0
    //   972: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   975: getfield 189	com/tencent/mm/aq/c$a:oCQ	Ljava/util/List;
    //   978: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   981: aload 9
    //   983: getfield 192	com/tencent/mm/aq/c$a:oCR	Ljava/util/List;
    //   986: aload_0
    //   987: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   990: getfield 192	com/tencent/mm/aq/c$a:oCR	Ljava/util/List;
    //   993: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   996: aload 9
    //   998: getfield 195	com/tencent/mm/aq/c$a:oCS	Ljava/util/List;
    //   1001: aload_0
    //   1002: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1005: getfield 195	com/tencent/mm/aq/c$a:oCS	Ljava/util/List;
    //   1008: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   1011: aload 9
    //   1013: getfield 198	com/tencent/mm/aq/c$a:oCT	Ljava/util/List;
    //   1016: aload_0
    //   1017: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1020: getfield 198	com/tencent/mm/aq/c$a:oCT	Ljava/util/List;
    //   1023: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   1026: aload 9
    //   1028: getfield 201	com/tencent/mm/aq/c$a:oCU	Ljava/util/List;
    //   1031: aload_0
    //   1032: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1035: getfield 201	com/tencent/mm/aq/c$a:oCU	Ljava/util/List;
    //   1038: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   1041: aload 9
    //   1043: getfield 204	com/tencent/mm/aq/c$a:oCV	Ljava/util/List;
    //   1046: aload_0
    //   1047: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1050: getfield 204	com/tencent/mm/aq/c$a:oCV	Ljava/util/List;
    //   1053: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   1056: aload 9
    //   1058: getfield 207	com/tencent/mm/aq/c$a:oCW	Ljava/util/List;
    //   1061: aload_0
    //   1062: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1065: getfield 207	com/tencent/mm/aq/c$a:oCW	Ljava/util/List;
    //   1068: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   1071: aload 9
    //   1073: getfield 210	com/tencent/mm/aq/c$a:oCX	Ljava/util/List;
    //   1076: aload_0
    //   1077: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1080: getfield 210	com/tencent/mm/aq/c$a:oCX	Ljava/util/List;
    //   1083: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   1086: aload 9
    //   1088: getfield 213	com/tencent/mm/aq/c$a:oCY	Ljava/util/List;
    //   1091: aload_0
    //   1092: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1095: getfield 213	com/tencent/mm/aq/c$a:oCY	Ljava/util/List;
    //   1098: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   1101: aload 9
    //   1103: getfield 216	com/tencent/mm/aq/c$a:oCZ	Ljava/util/List;
    //   1106: aload_0
    //   1107: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1110: getfield 216	com/tencent/mm/aq/c$a:oCZ	Ljava/util/List;
    //   1113: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   1116: aload 9
    //   1118: getfield 219	com/tencent/mm/aq/c$a:oDa	Ljava/util/List;
    //   1121: aload_0
    //   1122: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1125: getfield 219	com/tencent/mm/aq/c$a:oDa	Ljava/util/List;
    //   1128: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   1131: aload 9
    //   1133: getfield 222	com/tencent/mm/aq/c$a:oDb	Ljava/util/List;
    //   1136: aload_0
    //   1137: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1140: getfield 222	com/tencent/mm/aq/c$a:oDb	Ljava/util/List;
    //   1143: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   1146: aload 9
    //   1148: getfield 225	com/tencent/mm/aq/c$a:oDc	Ljava/util/List;
    //   1151: aload_0
    //   1152: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1155: getfield 225	com/tencent/mm/aq/c$a:oDc	Ljava/util/List;
    //   1158: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   1161: aload 9
    //   1163: getfield 228	com/tencent/mm/aq/c$a:oDd	Ljava/util/List;
    //   1166: aload_0
    //   1167: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1170: getfield 228	com/tencent/mm/aq/c$a:oDd	Ljava/util/List;
    //   1173: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   1176: aload 9
    //   1178: getfield 231	com/tencent/mm/aq/c$a:oDe	Ljava/util/List;
    //   1181: aload_0
    //   1182: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1185: getfield 231	com/tencent/mm/aq/c$a:oDe	Ljava/util/List;
    //   1188: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   1191: aload 9
    //   1193: getfield 234	com/tencent/mm/aq/c$a:oDf	Ljava/util/List;
    //   1196: aload_0
    //   1197: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1200: getfield 234	com/tencent/mm/aq/c$a:oDf	Ljava/util/List;
    //   1203: invokestatic 541	com/tencent/mm/aq/c$a:j	(Ljava/util/List;Ljava/util/List;)V
    //   1206: aload_0
    //   1207: aload 9
    //   1209: putfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1212: goto -1084 -> 128
    //   1215: astore 9
    //   1217: ldc 148
    //   1219: new 70	java/lang/StringBuilder
    //   1222: dup
    //   1223: ldc_w 543
    //   1226: invokespecial 544	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1229: aload 9
    //   1231: invokevirtual 531	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1234: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1240: iconst_1
    //   1241: anewarray 4	java/lang/Object
    //   1244: dup
    //   1245: iconst_0
    //   1246: aload_0
    //   1247: getfield 66	com/tencent/mm/aq/c:oCH	Ljava/lang/String;
    //   1250: aastore
    //   1251: invokestatic 397	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1254: aload_0
    //   1255: getfield 66	com/tencent/mm/aq/c:oCH	Ljava/lang/String;
    //   1258: invokestatic 401	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   1261: pop
    //   1262: goto -1134 -> 128
    //   1265: astore 9
    //   1267: ldc 148
    //   1269: ldc_w 546
    //   1272: iconst_2
    //   1273: anewarray 4	java/lang/Object
    //   1276: dup
    //   1277: iconst_0
    //   1278: aload 9
    //   1280: invokevirtual 547	java/lang/Error:getMessage	()Ljava/lang/String;
    //   1283: aastore
    //   1284: dup
    //   1285: iconst_1
    //   1286: aload 9
    //   1288: invokevirtual 551	java/lang/Object:getClass	()Ljava/lang/Class;
    //   1291: invokevirtual 556	java/lang/Class:getName	()Ljava/lang/String;
    //   1294: aastore
    //   1295: invokestatic 496	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1298: aload_0
    //   1299: getfield 66	com/tencent/mm/aq/c:oCH	Ljava/lang/String;
    //   1302: invokestatic 401	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   1305: pop
    //   1306: goto -1178 -> 128
    //   1309: iconst_0
    //   1310: istore_1
    //   1311: goto -995 -> 316
    //   1314: aload 10
    //   1316: iload_1
    //   1317: lload 5
    //   1319: lload_3
    //   1320: iload_2
    //   1321: invokevirtual 375	com/tencent/mm/aq/c$d:b	(IJJI)V
    //   1324: aconst_null
    //   1325: astore 9
    //   1327: goto -883 -> 444
    //   1330: ldc 148
    //   1332: ldc_w 558
    //   1335: iconst_1
    //   1336: anewarray 4	java/lang/Object
    //   1339: dup
    //   1340: iconst_0
    //   1341: aload_0
    //   1342: getfield 53	com/tencent/mm/aq/c:oCB	Lcom/tencent/mm/aq/c$d;
    //   1345: aastore
    //   1346: invokestatic 496	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1349: goto -866 -> 483
    //   1352: astore 9
    //   1354: ldc 148
    //   1356: ldc_w 560
    //   1359: iconst_1
    //   1360: anewarray 4	java/lang/Object
    //   1363: dup
    //   1364: iconst_0
    //   1365: aload 9
    //   1367: invokevirtual 531	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1370: aastore
    //   1371: invokestatic 397	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1374: goto -1083 -> 291
    //   1377: ldc 148
    //   1379: ldc_w 562
    //   1382: iconst_1
    //   1383: anewarray 4	java/lang/Object
    //   1386: dup
    //   1387: iconst_0
    //   1388: aload_0
    //   1389: getfield 66	com/tencent/mm/aq/c:oCH	Ljava/lang/String;
    //   1392: aastore
    //   1393: invokestatic 496	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1396: aload_0
    //   1397: getfield 56	com/tencent/mm/aq/c:oCC	Lcom/tencent/mm/aq/c$a;
    //   1400: astore 11
    //   1402: aload_0
    //   1403: getfield 66	com/tencent/mm/aq/c:oCH	Ljava/lang/String;
    //   1406: iconst_0
    //   1407: invokestatic 566	com/tencent/mm/vfs/y:ev	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   1410: astore 9
    //   1412: aload 11
    //   1414: ifnull -835 -> 579
    //   1417: aload 9
    //   1419: ifnull -840 -> 579
    //   1422: new 568	java/io/ObjectOutputStream
    //   1425: dup
    //   1426: aload 9
    //   1428: invokespecial 571	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1431: astore 10
    //   1433: aload 10
    //   1435: astore 9
    //   1437: aload 10
    //   1439: aload 11
    //   1441: invokevirtual 575	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   1444: aload 10
    //   1446: astore 9
    //   1448: aload 10
    //   1450: invokevirtual 578	java/io/ObjectOutputStream:flush	()V
    //   1453: aload 10
    //   1455: invokevirtual 581	java/io/ObjectOutputStream:close	()V
    //   1458: goto -879 -> 579
    //   1461: astore 9
    //   1463: ldc_w 583
    //   1466: new 70	java/lang/StringBuilder
    //   1469: dup
    //   1470: ldc_w 585
    //   1473: invokespecial 544	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1476: aload 9
    //   1478: invokevirtual 531	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1481: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1484: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1487: invokestatic 588	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1490: goto -911 -> 579
    //   1493: astore 9
    //   1495: ldc 148
    //   1497: new 70	java/lang/StringBuilder
    //   1500: dup
    //   1501: ldc_w 590
    //   1504: invokespecial 544	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1507: aload 9
    //   1509: invokevirtual 531	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1512: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1515: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1518: iconst_1
    //   1519: anewarray 4	java/lang/Object
    //   1522: dup
    //   1523: iconst_0
    //   1524: aload_0
    //   1525: getfield 66	com/tencent/mm/aq/c:oCH	Ljava/lang/String;
    //   1528: aastore
    //   1529: invokestatic 397	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1532: goto -953 -> 579
    //   1535: astore 11
    //   1537: aconst_null
    //   1538: astore 10
    //   1540: aload 10
    //   1542: astore 9
    //   1544: ldc_w 583
    //   1547: new 70	java/lang/StringBuilder
    //   1550: dup
    //   1551: ldc_w 592
    //   1554: invokespecial 544	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1557: aload 11
    //   1559: invokevirtual 531	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1562: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1565: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1568: invokestatic 588	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1571: aload 10
    //   1573: ifnull -994 -> 579
    //   1576: aload 10
    //   1578: invokevirtual 581	java/io/ObjectOutputStream:close	()V
    //   1581: goto -1002 -> 579
    //   1584: astore 9
    //   1586: ldc_w 583
    //   1589: new 70	java/lang/StringBuilder
    //   1592: dup
    //   1593: ldc_w 585
    //   1596: invokespecial 544	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1599: aload 9
    //   1601: invokevirtual 531	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1604: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1607: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1610: invokestatic 588	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1613: goto -1034 -> 579
    //   1616: astore 10
    //   1618: aconst_null
    //   1619: astore 9
    //   1621: aload 9
    //   1623: ifnull +8 -> 1631
    //   1626: aload 9
    //   1628: invokevirtual 581	java/io/ObjectOutputStream:close	()V
    //   1631: ldc_w 366
    //   1634: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1637: aload 10
    //   1639: athrow
    //   1640: astore 9
    //   1642: ldc_w 583
    //   1645: new 70	java/lang/StringBuilder
    //   1648: dup
    //   1649: ldc_w 585
    //   1652: invokespecial 544	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1655: aload 9
    //   1657: invokevirtual 531	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1660: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1663: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1666: invokestatic 588	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1669: goto -38 -> 1631
    //   1672: ldc_w 366
    //   1675: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1678: return
    //   1679: astore 10
    //   1681: goto -60 -> 1621
    //   1684: astore 11
    //   1686: goto -146 -> 1540
    //   1689: goto -1245 -> 444
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1692	0	this	c
    //   315	1002	1	i	int
    //   368	953	2	j	int
    //   76	1244	3	l1	long
    //   362	956	5	l2	long
    //   373	50	7	l3	long
    //   405	63	9	locald	d
    //   655	1	9	localInterruptedException	java.lang.InterruptedException
    //   705	503	9	locala1	a
    //   1215	15	9	localException1	Exception
    //   1265	22	9	localError	java.lang.Error
    //   1325	1	9	localObject1	Object
    //   1352	14	9	localException2	Exception
    //   1410	37	9	localObject2	Object
    //   1461	16	9	localException3	Exception
    //   1493	15	9	localException4	Exception
    //   1542	1	9	localObject3	Object
    //   1584	16	9	localException5	Exception
    //   1619	8	9	localObject4	Object
    //   1640	16	9	localException6	Exception
    //   356	1221	10	localObject5	Object
    //   1616	22	10	localObject6	Object
    //   1679	1	10	localObject7	Object
    //   774	14	11	localException7	Exception
    //   871	14	11	localException8	Exception
    //   1400	40	11	locala2	a
    //   1535	23	11	localException9	Exception
    //   1684	1	11	localException10	Exception
    // Exception table:
    //   from	to	target	type
    //   344	369	655	java/lang/InterruptedException
    //   375	397	655	java/lang/InterruptedException
    //   397	422	655	java/lang/InterruptedException
    //   422	441	655	java/lang/InterruptedException
    //   449	483	655	java/lang/InterruptedException
    //   483	542	655	java/lang/InterruptedException
    //   542	579	655	java/lang/InterruptedException
    //   579	646	655	java/lang/InterruptedException
    //   646	652	655	java/lang/InterruptedException
    //   1314	1324	655	java/lang/InterruptedException
    //   1330	1349	655	java/lang/InterruptedException
    //   1377	1396	655	java/lang/InterruptedException
    //   1396	1412	655	java/lang/InterruptedException
    //   1453	1458	655	java/lang/InterruptedException
    //   1463	1490	655	java/lang/InterruptedException
    //   1495	1532	655	java/lang/InterruptedException
    //   1576	1581	655	java/lang/InterruptedException
    //   1586	1613	655	java/lang/InterruptedException
    //   1626	1631	655	java/lang/InterruptedException
    //   1631	1640	655	java/lang/InterruptedException
    //   1642	1669	655	java/lang/InterruptedException
    //   741	767	774	java/lang/Exception
    //   838	864	871	java/lang/Exception
    //   69	77	1215	java/lang/Exception
    //   85	128	1215	java/lang/Exception
    //   692	707	1215	java/lang/Exception
    //   712	732	1215	java/lang/Exception
    //   776	796	1215	java/lang/Exception
    //   796	829	1215	java/lang/Exception
    //   873	893	1215	java/lang/Exception
    //   893	1212	1215	java/lang/Exception
    //   69	77	1265	java/lang/Error
    //   85	128	1265	java/lang/Error
    //   692	707	1265	java/lang/Error
    //   712	732	1265	java/lang/Error
    //   741	767	1265	java/lang/Error
    //   776	796	1265	java/lang/Error
    //   796	829	1265	java/lang/Error
    //   838	864	1265	java/lang/Error
    //   873	893	1265	java/lang/Error
    //   893	1212	1265	java/lang/Error
    //   344	369	1352	java/lang/Exception
    //   375	397	1352	java/lang/Exception
    //   397	422	1352	java/lang/Exception
    //   422	441	1352	java/lang/Exception
    //   449	483	1352	java/lang/Exception
    //   483	542	1352	java/lang/Exception
    //   542	579	1352	java/lang/Exception
    //   579	646	1352	java/lang/Exception
    //   646	652	1352	java/lang/Exception
    //   1314	1324	1352	java/lang/Exception
    //   1330	1349	1352	java/lang/Exception
    //   1377	1396	1352	java/lang/Exception
    //   1495	1532	1352	java/lang/Exception
    //   1453	1458	1461	java/lang/Exception
    //   1396	1412	1493	java/lang/Exception
    //   1463	1490	1493	java/lang/Exception
    //   1586	1613	1493	java/lang/Exception
    //   1631	1640	1493	java/lang/Exception
    //   1642	1669	1493	java/lang/Exception
    //   1422	1433	1535	java/lang/Exception
    //   1576	1581	1584	java/lang/Exception
    //   1422	1433	1616	finally
    //   1626	1631	1640	java/lang/Exception
    //   1437	1444	1679	finally
    //   1448	1453	1679	finally
    //   1544	1571	1679	finally
    //   1437	1444	1684	java/lang/Exception
    //   1448	1453	1684	java/lang/Exception
  }
  
  static final class a
    implements Serializable
  {
    final List<c.d> oCJ;
    final List<c.c> oCK;
    final List<c.c> oCL;
    final List<c.b> oCM;
    final List<c.b> oCN;
    final List<c.b> oCO;
    final List<c.b> oCP;
    final List<c.b> oCQ;
    final List<c.b> oCR;
    final List<c.b> oCS;
    final List<c.b> oCT;
    final List<c.b> oCU;
    final List<c.b> oCV;
    final List<c.b> oCW;
    final List<c.b> oCX;
    final List<c.b> oCY;
    final List<c.b> oCZ;
    final List<c.b> oDa;
    final List<c.b> oDb;
    final List<c.b> oDc;
    final List<c.b> oDd;
    final List<c.b> oDe;
    final List<c.b> oDf;
    
    a()
    {
      AppMethodBeat.i(132524);
      this.oCJ = new CopyOnWriteArrayList();
      this.oCK = new CopyOnWriteArrayList();
      this.oCL = new CopyOnWriteArrayList();
      this.oCM = new CopyOnWriteArrayList();
      this.oCN = new CopyOnWriteArrayList();
      this.oCO = new CopyOnWriteArrayList();
      this.oCP = new CopyOnWriteArrayList();
      this.oCQ = new CopyOnWriteArrayList();
      this.oCR = new CopyOnWriteArrayList();
      this.oCS = new CopyOnWriteArrayList();
      this.oCT = new CopyOnWriteArrayList();
      this.oCU = new CopyOnWriteArrayList();
      this.oCV = new CopyOnWriteArrayList();
      this.oCW = new CopyOnWriteArrayList();
      this.oCX = new CopyOnWriteArrayList();
      this.oCY = new CopyOnWriteArrayList();
      this.oCZ = new CopyOnWriteArrayList();
      this.oDa = new CopyOnWriteArrayList();
      this.oDb = new CopyOnWriteArrayList();
      this.oDc = new CopyOnWriteArrayList();
      this.oDd = new CopyOnWriteArrayList();
      this.oDe = new CopyOnWriteArrayList();
      this.oDf = new CopyOnWriteArrayList();
      AppMethodBeat.o(132524);
    }
    
    public static void a(List<c.b> paramList, c.b paramb)
    {
      AppMethodBeat.i(230988);
      if (paramList.size() > 10000)
      {
        int i = 0;
        for (;;)
        {
          if (i < 100) {
            try
            {
              paramList.remove(0);
              i += 1;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.ActiveDetector.ProcessDetector", "addDelayedMsgList %s", new Object[] { localException.getMessage() });
            }
          }
        }
      }
      paramList.add(paramb);
      AppMethodBeat.o(230988);
    }
    
    public static void j(List<c.b> paramList1, List<c.b> paramList2)
    {
      AppMethodBeat.i(230989);
      if (paramList1.size() > 10000)
      {
        int i = 0;
        try
        {
          while (i < paramList2.size() + 100)
          {
            paramList1.remove(0);
            i += 1;
          }
          paramList1.addAll(paramList2);
        }
        catch (Exception localException)
        {
          Log.e("MicroMsg.ActiveDetector.ProcessDetector", "addDelayedMsgList %s", new Object[] { localException.getMessage() });
        }
      }
      AppMethodBeat.o(230989);
    }
    
    public final void a(c.d paramd)
    {
      AppMethodBeat.i(230990);
      if (this.oCJ.size() > 30000)
      {
        int i = 0;
        for (;;)
        {
          if (i < 100) {
            try
            {
              this.oCJ.remove(0);
              i += 1;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.ActiveDetector.ProcessDetector", "addProcessStatusList %s", new Object[] { localException.getMessage() });
            }
          }
        }
      }
      this.oCJ.add(paramd);
      AppMethodBeat.o(230990);
    }
  }
  
  static final class b
    implements Serializable
  {
    int msgType = 0;
    long oCs = 0L;
    long oCw = 0L;
    long oCx = 0L;
    long oCy = 0L;
    long oDg = 0L;
    int pid = 0;
    String username = "";
    
    b(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2)
    {
      this.pid = paramInt1;
      this.oCs = paramLong1;
      this.oDg = paramLong2;
      this.oCw = paramLong3;
      this.oCx = paramLong4;
      this.oCy = paramLong5;
      this.username = paramString;
      this.msgType = paramInt2;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(132525);
      String str = String.format("pid:%s, server time:%s, client time:%s, msg server time:%s, intervalTime:%s, msg server id:%s username:%s, msgType:%s", new Object[] { Integer.valueOf(this.pid), a.iO(this.oCs), a.iO(this.oDg), a.iO(this.oCw), Long.valueOf(this.oCx), Long.valueOf(this.oCy), this.username, Integer.valueOf(this.msgType) });
      AppMethodBeat.o(132525);
      return str;
    }
  }
  
  static final class c
    implements Serializable
  {
    long oCs = 0L;
    long oDh;
    long time = 0L;
    int type = 0;
    
    c(long paramLong1, long paramLong2, int paramInt, long paramLong3)
    {
      this.oCs = paramLong1;
      this.time = paramLong2;
      this.type = paramInt;
      this.oDh = paramLong3;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(132526);
      String str = String.format("serverTime:%s,time:%s,type:%s,recvTime:%s", new Object[] { a.iO(this.oCs), a.iO(this.time), Integer.valueOf(this.type), Long.valueOf(this.oDh) });
      AppMethodBeat.o(132526);
      return str;
    }
  }
  
  public static final class d
    implements Serializable
  {
    long endTime = 0L;
    int networkStatus = 0;
    boolean oCt = true;
    boolean oCu = false;
    long oDi = 0L;
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
        this.oDi = cn.bDu();
      }
      this.endTime = paramLong2;
      this.networkStatus = paramInt2;
      AppMethodBeat.o(132527);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(132529);
      String str = String.format("pid:%s,startServerTime:%s,startTime:%s,endTime:%s,normalExecute:%s,changedNetworkStatus:%s,networkStatus:%s", new Object[] { Integer.valueOf(this.pid), a.iO(this.oDi), a.iO(this.startTime), a.iO(this.endTime), Boolean.valueOf(this.oCt), Boolean.valueOf(this.oCu), Integer.valueOf(this.networkStatus) });
      AppMethodBeat.o(132529);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.aq.c
 * JD-Core Version:    0.7.0.1
 */