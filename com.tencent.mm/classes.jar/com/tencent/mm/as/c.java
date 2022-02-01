package com.tencent.mm.as;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

final class c
  implements Runnable
{
  private static long lJY = 0L;
  int lJX;
  private d lJZ;
  a lKa;
  private long lKb;
  long lKc;
  long lKd;
  String lKe;
  private String lKf;
  boolean lKg;
  
  c()
  {
    AppMethodBeat.i(132530);
    this.lJX = 0;
    this.lJZ = null;
    this.lKa = new a();
    this.lKb = 0L;
    this.lKc = 0L;
    this.lKd = 0L;
    this.lKe = null;
    this.lKf = null;
    this.lKg = false;
    if (this.lKe == null)
    {
      this.lKe = (b.aSD() + "ProcessDetector");
      q localq = new q(this.lKe);
      if (!localq.ifE()) {
        localq.ifK();
      }
    }
    if (MMApplicationContext.isMMProcess())
    {
      this.lKf = (this.lKe + "/mm");
      AppMethodBeat.o(132530);
      return;
    }
    if (MMApplicationContext.isPushProcess()) {
      this.lKf = (this.lKe + "/push");
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
        if (paramLong - localb.lKE < 259200000L) {
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
        localIterator = parama.lKh.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (d)localIterator.next();
        if (localObject == null)
        {
          parama.lKh.remove(localObject);
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
      parama.lKh.remove(localObject);
    }
    Iterator localIterator = parama.lKi.iterator();
    while (localIterator.hasNext())
    {
      localObject = (c)localIterator.next();
      if (localObject == null)
      {
        parama.lKi.remove(localObject);
      }
      else
      {
        if (l - ((c)localObject).time < 259200000L) {
          break;
        }
        parama.lKi.remove(localObject);
      }
    }
    localIterator = parama.lKj.iterator();
    while (localIterator.hasNext())
    {
      localObject = (c)localIterator.next();
      if (localObject == null)
      {
        parama.lKj.remove(localObject);
      }
      else
      {
        if (l - ((c)localObject).time < 259200000L) {
          break;
        }
        parama.lKj.remove(localObject);
      }
    }
    a(l, parama.lKk);
    a(l, parama.lKl);
    a(l, parama.lKm);
    a(l, parama.lKn);
    a(l, parama.lKo);
    a(l, parama.lKp);
    a(l, parama.lKq);
    a(l, parama.lKr);
    a(l, parama.lKs);
    a(l, parama.lKt);
    a(l, parama.lKu);
    a(l, parama.lKv);
    a(l, parama.lKw);
    a(l, parama.lKx);
    a(l, parama.lKy);
    a(l, parama.lKz);
    a(l, parama.lKA);
    a(l, parama.lKB);
    a(l, parama.lKC);
    a(l, parama.lKD);
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
    if (parama.lKh.size() > 0)
    {
      localStringBuilder.append("processStatusList:\n");
      localIterator = parama.lKh.iterator();
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
        if (parama.lKi.size() > 0)
        {
          localStringBuilder.append("sendInterProcessList:\n");
          localIterator = parama.lKi.iterator();
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
            if (parama.lKj.size() > 0)
            {
              localStringBuilder.append("receiveInterProcessList:\n");
              localIterator = parama.lKj.iterator();
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
            a(localStringBuilder, parama.lKk, "foregroundDelayed2sMsgList");
            a(localStringBuilder, parama.lKl, "foregroundDelayed5sMsgList");
            a(localStringBuilder, parama.lKm, "foregroundDelayed10sMsgList");
            a(localStringBuilder, parama.lKn, "foregroundDelayed30sMsgList");
            a(localStringBuilder, parama.lKo, "foregroundDelayed1minMsgList");
            a(localStringBuilder, parama.lKp, "foregroundDelayed3minMsgList");
            a(localStringBuilder, parama.lKq, "foregroundDelayed5minMsgList");
            a(localStringBuilder, parama.lKr, "foregroundDelayed10minMsgList");
            a(localStringBuilder, parama.lKs, "foregroundDelayed30minMsgList");
            a(localStringBuilder, parama.lKt, "foregroundDelayed1hMsgList");
            localStringBuilder.append(">>>>>>>>>>>>>>>>>>>>> background <<<<<<<<<<<<<<<<<<<<<\n");
            a(localStringBuilder, parama.lKu, "backgroundDelayed2sMsgList");
            a(localStringBuilder, parama.lKv, "backgroundDelayed5sMsgList");
            a(localStringBuilder, parama.lKw, "backgroundDelayed10sMsgList");
            a(localStringBuilder, parama.lKx, "backgroundDelayed30sMsgList");
            a(localStringBuilder, parama.lKy, "backgroundDelayed1minMsgList");
            a(localStringBuilder, parama.lKz, "backgroundDelayed3minMsgList");
            a(localStringBuilder, parama.lKA, "backgroundDelayed5minMsgList");
            a(localStringBuilder, parama.lKB, "backgroundDelayed10minMsgList");
            a(localStringBuilder, parama.lKC, "backgroundDelayed30minMsgList");
            a(localStringBuilder, parama.lKD, "backgroundDelayed1hMsgList");
            localStringBuilder.append(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> END <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            Log.i("MicroMsg.ActiveDetector.ProcessDetector", "printProcessInfoAndReport()\n".concat(String.valueOf(localStringBuilder)));
            AppMethodBeat.o(132535);
            return;
          }
        }
      }
    }
  }
  
  private static long bkI()
  {
    AppMethodBeat.i(132534);
    if (lJY == 0L) {
      lJY = Util.getLong(d.dgX().a("clicfg_android_process_detect_time", "5", false, true), 5L) * 60L * 1000L;
    }
    long l = lJY;
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
    //   10: putfield 60	com/tencent/mm/as/c:lKc	J
    //   13: aload_0
    //   14: aload_0
    //   15: getfield 60	com/tencent/mm/as/c:lKc	J
    //   18: putfield 62	com/tencent/mm/as/c:lKd	J
    //   21: aload_0
    //   22: new 17	com/tencent/mm/as/c$d
    //   25: dup
    //   26: invokespecial 364	com/tencent/mm/as/c$d:<init>	()V
    //   29: putfield 53	com/tencent/mm/as/c:lJZ	Lcom/tencent/mm/as/c$d;
    //   32: aload_0
    //   33: getfield 53	com/tencent/mm/as/c:lJZ	Lcom/tencent/mm/as/c$d;
    //   36: invokestatic 369	android/os/Process:myPid	()I
    //   39: aload_0
    //   40: getfield 60	com/tencent/mm/as/c:lKc	J
    //   43: aload_0
    //   44: getfield 62	com/tencent/mm/as/c:lKd	J
    //   47: aload_0
    //   48: getfield 51	com/tencent/mm/as/c:lJX	I
    //   51: invokevirtual 372	com/tencent/mm/as/c$d:b	(IJJI)V
    //   54: aload_0
    //   55: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   58: getfield 155	com/tencent/mm/as/c$a:lKh	Ljava/util/List;
    //   61: invokeinterface 375 1 0
    //   66: ifeq +62 -> 128
    //   69: aload_0
    //   70: getfield 66	com/tencent/mm/as/c:lKf	Ljava/lang/String;
    //   73: invokestatic 381	com/tencent/mm/vfs/u:bBQ	(Ljava/lang/String;)J
    //   76: lstore_3
    //   77: lload_3
    //   78: ldc2_w 382
    //   81: lcmp
    //   82: ifle +610 -> 692
    //   85: ldc 157
    //   87: ldc_w 385
    //   90: iconst_3
    //   91: anewarray 4	java/lang/Object
    //   94: dup
    //   95: iconst_0
    //   96: aload_0
    //   97: getfield 66	com/tencent/mm/as/c:lKf	Ljava/lang/String;
    //   100: aastore
    //   101: dup
    //   102: iconst_1
    //   103: lload_3
    //   104: invokestatic 390	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   107: aastore
    //   108: dup
    //   109: iconst_2
    //   110: ldc2_w 382
    //   113: invokestatic 390	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   116: aastore
    //   117: invokestatic 394	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: aload_0
    //   121: getfield 66	com/tencent/mm/as/c:lKf	Ljava/lang/String;
    //   124: invokestatic 398	com/tencent/mm/vfs/u:deleteFile	(Ljava/lang/String;)Z
    //   127: pop
    //   128: aload_0
    //   129: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   132: invokestatic 400	com/tencent/mm/as/c:a	(Lcom/tencent/mm/as/c$a;)V
    //   135: aload_0
    //   136: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   139: aload_0
    //   140: getfield 53	com/tencent/mm/as/c:lJZ	Lcom/tencent/mm/as/c$d;
    //   143: invokevirtual 403	com/tencent/mm/as/c$a:a	(Lcom/tencent/mm/as/c$d;)V
    //   146: ldc 157
    //   148: ldc_w 405
    //   151: iconst_3
    //   152: anewarray 4	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload_0
    //   158: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   161: getfield 155	com/tencent/mm/as/c$a:lKh	Ljava/util/List;
    //   164: invokeinterface 245 1 0
    //   169: invokestatic 410	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: aload_0
    //   176: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   179: getfield 171	com/tencent/mm/as/c$a:lKi	Ljava/util/List;
    //   182: invokeinterface 245 1 0
    //   187: invokestatic 410	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: dup
    //   192: iconst_2
    //   193: aload_0
    //   194: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   197: getfield 177	com/tencent/mm/as/c$a:lKj	Ljava/util/List;
    //   200: invokeinterface 245 1 0
    //   205: invokestatic 410	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   208: aastore
    //   209: invokestatic 412	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: ldc 157
    //   214: ldc_w 414
    //   217: iconst_1
    //   218: anewarray 4	java/lang/Object
    //   221: dup
    //   222: iconst_0
    //   223: aload_0
    //   224: getfield 68	com/tencent/mm/as/c:lKg	Z
    //   227: invokestatic 419	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   230: aastore
    //   231: invokestatic 412	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: invokestatic 424	com/tencent/mm/model/cm:bfC	()J
    //   237: lstore_3
    //   238: lload_3
    //   239: ldc_w 426
    //   242: invokestatic 432	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   245: ldc_w 434
    //   248: lconst_0
    //   249: invokevirtual 435	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getLong	(Ljava/lang/String;J)J
    //   252: lsub
    //   253: ldc2_w 436
    //   256: lcmp
    //   257: iflt +34 -> 291
    //   260: ldc_w 426
    //   263: invokestatic 432	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:getMMKV	(Ljava/lang/String;)Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   266: invokevirtual 441	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:edit	()Landroid/content/SharedPreferences$Editor;
    //   269: ldc_w 434
    //   272: lload_3
    //   273: invokeinterface 447 4 0
    //   278: invokeinterface 450 1 0
    //   283: pop
    //   284: aload_0
    //   285: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   288: invokestatic 452	com/tencent/mm/as/c:b	(Lcom/tencent/mm/as/c$a;)V
    //   291: invokestatic 340	com/tencent/mm/plugin/expt/h/d:dgX	()Lcom/tencent/mm/plugin/expt/h/d;
    //   294: ldc_w 454
    //   297: ldc_w 456
    //   300: iconst_0
    //   301: iconst_1
    //   302: invokevirtual 347	com/tencent/mm/plugin/expt/h/d:a	(Ljava/lang/String;Ljava/lang/String;ZZ)Ljava/lang/String;
    //   305: ldc_w 456
    //   308: invokestatic 460	com/tencent/mm/sdk/platformtools/Util:isEqual	(Ljava/lang/String;Ljava/lang/String;)Z
    //   311: ifeq +946 -> 1257
    //   314: iconst_1
    //   315: istore_1
    //   316: iload_1
    //   317: ifeq +1302 -> 1619
    //   320: aload_0
    //   321: getfield 68	com/tencent/mm/as/c:lKg	Z
    //   324: ifeq +1295 -> 1619
    //   327: invokestatic 466	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   330: invokevirtual 469	java/lang/Thread:isInterrupted	()Z
    //   333: ifne +1286 -> 1619
    //   336: ldc 157
    //   338: ldc_w 471
    //   341: invokestatic 332	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: invokestatic 369	android/os/Process:myPid	()I
    //   347: istore_1
    //   348: invokestatic 151	java/lang/System:currentTimeMillis	()J
    //   351: lstore_3
    //   352: aload_0
    //   353: getfield 53	com/tencent/mm/as/c:lJZ	Lcom/tencent/mm/as/c$d;
    //   356: astore 10
    //   358: aload_0
    //   359: getfield 62	com/tencent/mm/as/c:lKd	J
    //   362: lstore 5
    //   364: aload_0
    //   365: getfield 51	com/tencent/mm/as/c:lJX	I
    //   368: istore_2
    //   369: lload_3
    //   370: lload 5
    //   372: lsub
    //   373: lstore 7
    //   375: aload 10
    //   377: getfield 474	com/tencent/mm/as/c$d:networkStatus	I
    //   380: iload_2
    //   381: if_icmpne +16 -> 397
    //   384: lload 7
    //   386: invokestatic 476	com/tencent/mm/as/c:bkI	()J
    //   389: ldc2_w 477
    //   392: ladd
    //   393: lcmp
    //   394: ifle +868 -> 1262
    //   397: iload_1
    //   398: lload 5
    //   400: lload_3
    //   401: iload_2
    //   402: invokestatic 481	com/tencent/mm/as/c$d:c	(IJJI)Lcom/tencent/mm/as/c$d;
    //   405: astore 9
    //   407: aload 10
    //   409: getfield 474	com/tencent/mm/as/c$d:networkStatus	I
    //   412: iload_2
    //   413: if_icmpeq +9 -> 422
    //   416: aload 9
    //   418: iconst_1
    //   419: putfield 484	com/tencent/mm/as/c$d:lJS	Z
    //   422: lload 7
    //   424: invokestatic 476	com/tencent/mm/as/c:bkI	()J
    //   427: ldc2_w 477
    //   430: ladd
    //   431: lcmp
    //   432: ifle +1204 -> 1636
    //   435: aload 9
    //   437: iconst_0
    //   438: putfield 487	com/tencent/mm/as/c$d:lJR	Z
    //   441: goto +1195 -> 1636
    //   444: aload 9
    //   446: ifnull +832 -> 1278
    //   449: ldc 157
    //   451: ldc_w 489
    //   454: iconst_1
    //   455: anewarray 4	java/lang/Object
    //   458: dup
    //   459: iconst_0
    //   460: aload 9
    //   462: aastore
    //   463: invokestatic 412	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   466: aload_0
    //   467: aload 9
    //   469: putfield 53	com/tencent/mm/as/c:lJZ	Lcom/tencent/mm/as/c$d;
    //   472: aload_0
    //   473: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   476: aload_0
    //   477: getfield 53	com/tencent/mm/as/c:lJZ	Lcom/tencent/mm/as/c$d;
    //   480: invokevirtual 403	com/tencent/mm/as/c$a:a	(Lcom/tencent/mm/as/c$d;)V
    //   483: ldc 157
    //   485: ldc_w 491
    //   488: iconst_2
    //   489: anewarray 4	java/lang/Object
    //   492: dup
    //   493: iconst_0
    //   494: aload_0
    //   495: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   498: getfield 171	com/tencent/mm/as/c$a:lKi	Ljava/util/List;
    //   501: aastore
    //   502: dup
    //   503: iconst_1
    //   504: aload_0
    //   505: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   508: getfield 177	com/tencent/mm/as/c$a:lKj	Ljava/util/List;
    //   511: aastore
    //   512: invokestatic 493	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   515: aload_0
    //   516: lload_3
    //   517: putfield 62	com/tencent/mm/as/c:lKd	J
    //   520: aload_0
    //   521: getfield 58	com/tencent/mm/as/c:lKb	J
    //   524: lconst_0
    //   525: lcmp
    //   526: ifle +16 -> 542
    //   529: lload_3
    //   530: aload_0
    //   531: getfield 58	com/tencent/mm/as/c:lKb	J
    //   534: lsub
    //   535: ldc2_w 494
    //   538: lcmp
    //   539: ifle +107 -> 646
    //   542: aload_0
    //   543: lload_3
    //   544: putfield 58	com/tencent/mm/as/c:lKb	J
    //   547: aload_0
    //   548: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   551: ifnull +28 -> 579
    //   554: aload_0
    //   555: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   558: getfield 155	com/tencent/mm/as/c$a:lKh	Ljava/util/List;
    //   561: ifnull +18 -> 579
    //   564: aload_0
    //   565: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   568: getfield 155	com/tencent/mm/as/c$a:lKh	Ljava/util/List;
    //   571: invokeinterface 375 1 0
    //   576: ifeq +749 -> 1325
    //   579: ldc 157
    //   581: ldc_w 497
    //   584: iconst_1
    //   585: anewarray 4	java/lang/Object
    //   588: dup
    //   589: iconst_0
    //   590: aload_0
    //   591: getfield 53	com/tencent/mm/as/c:lJZ	Lcom/tencent/mm/as/c$d;
    //   594: aastore
    //   595: invokestatic 412	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   598: ldc 157
    //   600: ldc_w 499
    //   603: iconst_2
    //   604: anewarray 4	java/lang/Object
    //   607: dup
    //   608: iconst_0
    //   609: aload_0
    //   610: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   613: getfield 171	com/tencent/mm/as/c$a:lKi	Ljava/util/List;
    //   616: invokeinterface 245 1 0
    //   621: invokestatic 410	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   624: aastore
    //   625: dup
    //   626: iconst_1
    //   627: aload_0
    //   628: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   631: getfield 177	com/tencent/mm/as/c$a:lKj	Ljava/util/List;
    //   634: invokeinterface 245 1 0
    //   639: invokestatic 410	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   642: aastore
    //   643: invokestatic 412	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   646: invokestatic 476	com/tencent/mm/as/c:bkI	()J
    //   649: invokestatic 503	java/lang/Thread:sleep	(J)V
    //   652: goto -361 -> 291
    //   655: astore 9
    //   657: ldc 157
    //   659: ldc_w 505
    //   662: iconst_1
    //   663: anewarray 4	java/lang/Object
    //   666: dup
    //   667: iconst_0
    //   668: invokestatic 508	android/os/Process:myTid	()I
    //   671: invokestatic 410	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   674: aastore
    //   675: invokestatic 412	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   678: invokestatic 466	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   681: invokevirtual 511	java/lang/Thread:interrupt	()V
    //   684: aload_0
    //   685: iconst_0
    //   686: putfield 68	com/tencent/mm/as/c:lKg	Z
    //   689: goto -398 -> 291
    //   692: aload_0
    //   693: getfield 66	com/tencent/mm/as/c:lKf	Ljava/lang/String;
    //   696: invokestatic 515	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   699: invokestatic 521	com/tencent/mm/as/b:w	(Ljava/io/InputStream;)Ljava/lang/Object;
    //   702: checkcast 8	com/tencent/mm/as/c$a
    //   705: astore 9
    //   707: aload 9
    //   709: ifnull -581 -> 128
    //   712: aload_0
    //   713: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   716: getfield 171	com/tencent/mm/as/c$a:lKi	Ljava/util/List;
    //   719: astore 10
    //   721: aload 9
    //   723: getfield 171	com/tencent/mm/as/c$a:lKi	Ljava/util/List;
    //   726: invokeinterface 245 1 0
    //   731: istore_1
    //   732: iload_1
    //   733: sipush 30000
    //   736: if_icmple +60 -> 796
    //   739: iconst_0
    //   740: istore_1
    //   741: iload_1
    //   742: aload 10
    //   744: invokeinterface 245 1 0
    //   749: bipush 100
    //   751: iadd
    //   752: if_icmpge +44 -> 796
    //   755: aload 9
    //   757: getfield 171	com/tencent/mm/as/c$a:lKi	Ljava/util/List;
    //   760: iconst_0
    //   761: invokeinterface 524 2 0
    //   766: pop
    //   767: iload_1
    //   768: iconst_1
    //   769: iadd
    //   770: istore_1
    //   771: goto -30 -> 741
    //   774: astore 11
    //   776: ldc 157
    //   778: ldc_w 526
    //   781: iconst_1
    //   782: anewarray 4	java/lang/Object
    //   785: dup
    //   786: iconst_0
    //   787: aload 11
    //   789: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   792: aastore
    //   793: invokestatic 394	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   796: aload 9
    //   798: getfield 171	com/tencent/mm/as/c$a:lKi	Ljava/util/List;
    //   801: aload 10
    //   803: invokeinterface 533 2 0
    //   808: pop
    //   809: aload_0
    //   810: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   813: getfield 177	com/tencent/mm/as/c$a:lKj	Ljava/util/List;
    //   816: astore 10
    //   818: aload 9
    //   820: getfield 177	com/tencent/mm/as/c$a:lKj	Ljava/util/List;
    //   823: invokeinterface 245 1 0
    //   828: istore_1
    //   829: iload_1
    //   830: sipush 30000
    //   833: if_icmple +60 -> 893
    //   836: iconst_0
    //   837: istore_1
    //   838: iload_1
    //   839: aload 10
    //   841: invokeinterface 245 1 0
    //   846: bipush 100
    //   848: iadd
    //   849: if_icmpge +44 -> 893
    //   852: aload 9
    //   854: getfield 177	com/tencent/mm/as/c$a:lKj	Ljava/util/List;
    //   857: iconst_0
    //   858: invokeinterface 524 2 0
    //   863: pop
    //   864: iload_1
    //   865: iconst_1
    //   866: iadd
    //   867: istore_1
    //   868: goto -30 -> 838
    //   871: astore 11
    //   873: ldc 157
    //   875: ldc_w 535
    //   878: iconst_1
    //   879: anewarray 4	java/lang/Object
    //   882: dup
    //   883: iconst_0
    //   884: aload 11
    //   886: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   889: aastore
    //   890: invokestatic 394	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   893: aload 9
    //   895: getfield 177	com/tencent/mm/as/c$a:lKj	Ljava/util/List;
    //   898: aload 10
    //   900: invokeinterface 533 2 0
    //   905: pop
    //   906: aload 9
    //   908: getfield 180	com/tencent/mm/as/c$a:lKk	Ljava/util/List;
    //   911: aload_0
    //   912: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   915: getfield 180	com/tencent/mm/as/c$a:lKk	Ljava/util/List;
    //   918: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   921: aload 9
    //   923: getfield 185	com/tencent/mm/as/c$a:lKl	Ljava/util/List;
    //   926: aload_0
    //   927: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   930: getfield 185	com/tencent/mm/as/c$a:lKl	Ljava/util/List;
    //   933: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   936: aload 9
    //   938: getfield 188	com/tencent/mm/as/c$a:lKm	Ljava/util/List;
    //   941: aload_0
    //   942: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   945: getfield 188	com/tencent/mm/as/c$a:lKm	Ljava/util/List;
    //   948: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   951: aload 9
    //   953: getfield 191	com/tencent/mm/as/c$a:lKn	Ljava/util/List;
    //   956: aload_0
    //   957: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   960: getfield 191	com/tencent/mm/as/c$a:lKn	Ljava/util/List;
    //   963: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   966: aload 9
    //   968: getfield 194	com/tencent/mm/as/c$a:lKo	Ljava/util/List;
    //   971: aload_0
    //   972: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   975: getfield 194	com/tencent/mm/as/c$a:lKo	Ljava/util/List;
    //   978: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   981: aload 9
    //   983: getfield 197	com/tencent/mm/as/c$a:lKp	Ljava/util/List;
    //   986: aload_0
    //   987: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   990: getfield 197	com/tencent/mm/as/c$a:lKp	Ljava/util/List;
    //   993: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   996: aload 9
    //   998: getfield 200	com/tencent/mm/as/c$a:lKq	Ljava/util/List;
    //   1001: aload_0
    //   1002: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1005: getfield 200	com/tencent/mm/as/c$a:lKq	Ljava/util/List;
    //   1008: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   1011: aload 9
    //   1013: getfield 203	com/tencent/mm/as/c$a:lKr	Ljava/util/List;
    //   1016: aload_0
    //   1017: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1020: getfield 203	com/tencent/mm/as/c$a:lKr	Ljava/util/List;
    //   1023: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   1026: aload 9
    //   1028: getfield 206	com/tencent/mm/as/c$a:lKs	Ljava/util/List;
    //   1031: aload_0
    //   1032: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1035: getfield 206	com/tencent/mm/as/c$a:lKs	Ljava/util/List;
    //   1038: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   1041: aload 9
    //   1043: getfield 209	com/tencent/mm/as/c$a:lKt	Ljava/util/List;
    //   1046: aload_0
    //   1047: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1050: getfield 209	com/tencent/mm/as/c$a:lKt	Ljava/util/List;
    //   1053: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   1056: aload 9
    //   1058: getfield 212	com/tencent/mm/as/c$a:lKu	Ljava/util/List;
    //   1061: aload_0
    //   1062: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1065: getfield 212	com/tencent/mm/as/c$a:lKu	Ljava/util/List;
    //   1068: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   1071: aload 9
    //   1073: getfield 215	com/tencent/mm/as/c$a:lKv	Ljava/util/List;
    //   1076: aload_0
    //   1077: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1080: getfield 215	com/tencent/mm/as/c$a:lKv	Ljava/util/List;
    //   1083: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   1086: aload 9
    //   1088: getfield 218	com/tencent/mm/as/c$a:lKw	Ljava/util/List;
    //   1091: aload_0
    //   1092: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1095: getfield 218	com/tencent/mm/as/c$a:lKw	Ljava/util/List;
    //   1098: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   1101: aload 9
    //   1103: getfield 221	com/tencent/mm/as/c$a:lKx	Ljava/util/List;
    //   1106: aload_0
    //   1107: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1110: getfield 221	com/tencent/mm/as/c$a:lKx	Ljava/util/List;
    //   1113: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   1116: aload 9
    //   1118: getfield 224	com/tencent/mm/as/c$a:lKy	Ljava/util/List;
    //   1121: aload_0
    //   1122: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1125: getfield 224	com/tencent/mm/as/c$a:lKy	Ljava/util/List;
    //   1128: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   1131: aload 9
    //   1133: getfield 227	com/tencent/mm/as/c$a:lKz	Ljava/util/List;
    //   1136: aload_0
    //   1137: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1140: getfield 227	com/tencent/mm/as/c$a:lKz	Ljava/util/List;
    //   1143: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   1146: aload 9
    //   1148: getfield 230	com/tencent/mm/as/c$a:lKA	Ljava/util/List;
    //   1151: aload_0
    //   1152: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1155: getfield 230	com/tencent/mm/as/c$a:lKA	Ljava/util/List;
    //   1158: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   1161: aload 9
    //   1163: getfield 233	com/tencent/mm/as/c$a:lKB	Ljava/util/List;
    //   1166: aload_0
    //   1167: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1170: getfield 233	com/tencent/mm/as/c$a:lKB	Ljava/util/List;
    //   1173: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   1176: aload 9
    //   1178: getfield 236	com/tencent/mm/as/c$a:lKC	Ljava/util/List;
    //   1181: aload_0
    //   1182: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1185: getfield 236	com/tencent/mm/as/c$a:lKC	Ljava/util/List;
    //   1188: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   1191: aload 9
    //   1193: getfield 239	com/tencent/mm/as/c$a:lKD	Ljava/util/List;
    //   1196: aload_0
    //   1197: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1200: getfield 239	com/tencent/mm/as/c$a:lKD	Ljava/util/List;
    //   1203: invokestatic 538	com/tencent/mm/as/c$a:e	(Ljava/util/List;Ljava/util/List;)V
    //   1206: aload_0
    //   1207: aload 9
    //   1209: putfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1212: goto -1084 -> 128
    //   1215: astore 9
    //   1217: ldc 157
    //   1219: new 70	java/lang/StringBuilder
    //   1222: dup
    //   1223: ldc_w 540
    //   1226: invokespecial 541	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1229: aload 9
    //   1231: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1234: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1237: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1240: iconst_1
    //   1241: anewarray 4	java/lang/Object
    //   1244: dup
    //   1245: iconst_0
    //   1246: aload_0
    //   1247: getfield 66	com/tencent/mm/as/c:lKf	Ljava/lang/String;
    //   1250: aastore
    //   1251: invokestatic 394	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1254: goto -1126 -> 128
    //   1257: iconst_0
    //   1258: istore_1
    //   1259: goto -943 -> 316
    //   1262: aload 10
    //   1264: iload_1
    //   1265: lload 5
    //   1267: lload_3
    //   1268: iload_2
    //   1269: invokevirtual 372	com/tencent/mm/as/c$d:b	(IJJI)V
    //   1272: aconst_null
    //   1273: astore 9
    //   1275: goto -831 -> 444
    //   1278: ldc 157
    //   1280: ldc_w 543
    //   1283: iconst_1
    //   1284: anewarray 4	java/lang/Object
    //   1287: dup
    //   1288: iconst_0
    //   1289: aload_0
    //   1290: getfield 53	com/tencent/mm/as/c:lJZ	Lcom/tencent/mm/as/c$d;
    //   1293: aastore
    //   1294: invokestatic 493	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1297: goto -814 -> 483
    //   1300: astore 9
    //   1302: ldc 157
    //   1304: ldc_w 545
    //   1307: iconst_1
    //   1308: anewarray 4	java/lang/Object
    //   1311: dup
    //   1312: iconst_0
    //   1313: aload 9
    //   1315: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1318: aastore
    //   1319: invokestatic 394	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1322: goto -1031 -> 291
    //   1325: ldc 157
    //   1327: ldc_w 547
    //   1330: iconst_1
    //   1331: anewarray 4	java/lang/Object
    //   1334: dup
    //   1335: iconst_0
    //   1336: aload_0
    //   1337: getfield 66	com/tencent/mm/as/c:lKf	Ljava/lang/String;
    //   1340: aastore
    //   1341: invokestatic 493	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1344: aload_0
    //   1345: getfield 56	com/tencent/mm/as/c:lKa	Lcom/tencent/mm/as/c$a;
    //   1348: astore 11
    //   1350: aload_0
    //   1351: getfield 66	com/tencent/mm/as/c:lKf	Ljava/lang/String;
    //   1354: invokestatic 551	com/tencent/mm/vfs/u:Te	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   1357: astore 9
    //   1359: aload 11
    //   1361: ifnull -782 -> 579
    //   1364: aload 9
    //   1366: ifnull -787 -> 579
    //   1369: new 553	java/io/ObjectOutputStream
    //   1372: dup
    //   1373: aload 9
    //   1375: invokespecial 556	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   1378: astore 10
    //   1380: aload 10
    //   1382: astore 9
    //   1384: aload 10
    //   1386: aload 11
    //   1388: invokevirtual 560	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   1391: aload 10
    //   1393: astore 9
    //   1395: aload 10
    //   1397: invokevirtual 563	java/io/ObjectOutputStream:flush	()V
    //   1400: aload 10
    //   1402: invokevirtual 566	java/io/ObjectOutputStream:close	()V
    //   1405: goto -826 -> 579
    //   1408: astore 9
    //   1410: ldc_w 568
    //   1413: new 70	java/lang/StringBuilder
    //   1416: dup
    //   1417: ldc_w 570
    //   1420: invokespecial 541	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1423: aload 9
    //   1425: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1428: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1431: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1434: invokestatic 572	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1437: goto -858 -> 579
    //   1440: astore 9
    //   1442: ldc 157
    //   1444: new 70	java/lang/StringBuilder
    //   1447: dup
    //   1448: ldc_w 574
    //   1451: invokespecial 541	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1454: aload 9
    //   1456: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1459: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1462: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1465: iconst_1
    //   1466: anewarray 4	java/lang/Object
    //   1469: dup
    //   1470: iconst_0
    //   1471: aload_0
    //   1472: getfield 66	com/tencent/mm/as/c:lKf	Ljava/lang/String;
    //   1475: aastore
    //   1476: invokestatic 394	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1479: goto -900 -> 579
    //   1482: astore 11
    //   1484: aconst_null
    //   1485: astore 10
    //   1487: aload 10
    //   1489: astore 9
    //   1491: ldc_w 568
    //   1494: new 70	java/lang/StringBuilder
    //   1497: dup
    //   1498: ldc_w 576
    //   1501: invokespecial 541	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1504: aload 11
    //   1506: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1509: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1512: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1515: invokestatic 572	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1518: aload 10
    //   1520: ifnull -941 -> 579
    //   1523: aload 10
    //   1525: invokevirtual 566	java/io/ObjectOutputStream:close	()V
    //   1528: goto -949 -> 579
    //   1531: astore 9
    //   1533: ldc_w 568
    //   1536: new 70	java/lang/StringBuilder
    //   1539: dup
    //   1540: ldc_w 570
    //   1543: invokespecial 541	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1546: aload 9
    //   1548: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1551: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1554: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1557: invokestatic 572	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1560: goto -981 -> 579
    //   1563: astore 10
    //   1565: aconst_null
    //   1566: astore 9
    //   1568: aload 9
    //   1570: ifnull +8 -> 1578
    //   1573: aload 9
    //   1575: invokevirtual 566	java/io/ObjectOutputStream:close	()V
    //   1578: ldc_w 363
    //   1581: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1584: aload 10
    //   1586: athrow
    //   1587: astore 9
    //   1589: ldc_w 568
    //   1592: new 70	java/lang/StringBuilder
    //   1595: dup
    //   1596: ldc_w 570
    //   1599: invokespecial 541	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1602: aload 9
    //   1604: invokevirtual 529	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1607: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1610: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1613: invokestatic 572	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1616: goto -38 -> 1578
    //   1619: ldc_w 363
    //   1622: invokestatic 108	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1625: return
    //   1626: astore 10
    //   1628: goto -60 -> 1568
    //   1631: astore 11
    //   1633: goto -146 -> 1487
    //   1636: goto -1192 -> 444
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1639	0	this	c
    //   315	950	1	i	int
    //   368	901	2	j	int
    //   76	1192	3	l1	long
    //   362	904	5	l2	long
    //   373	50	7	l3	long
    //   405	63	9	locald	d
    //   655	1	9	localInterruptedException	java.lang.InterruptedException
    //   705	503	9	locala1	a
    //   1215	15	9	localException1	Exception
    //   1273	1	9	localObject1	Object
    //   1300	14	9	localException2	Exception
    //   1357	37	9	localObject2	Object
    //   1408	16	9	localException3	Exception
    //   1440	15	9	localException4	Exception
    //   1489	1	9	localObject3	Object
    //   1531	16	9	localException5	Exception
    //   1566	8	9	localObject4	Object
    //   1587	16	9	localException6	Exception
    //   356	1168	10	localObject5	Object
    //   1563	22	10	localObject6	Object
    //   1626	1	10	localObject7	Object
    //   774	14	11	localException7	Exception
    //   871	14	11	localException8	Exception
    //   1348	39	11	locala2	a
    //   1482	23	11	localException9	Exception
    //   1631	1	11	localException10	Exception
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
    //   1262	1272	655	java/lang/InterruptedException
    //   1278	1297	655	java/lang/InterruptedException
    //   1325	1344	655	java/lang/InterruptedException
    //   1344	1359	655	java/lang/InterruptedException
    //   1400	1405	655	java/lang/InterruptedException
    //   1410	1437	655	java/lang/InterruptedException
    //   1442	1479	655	java/lang/InterruptedException
    //   1523	1528	655	java/lang/InterruptedException
    //   1533	1560	655	java/lang/InterruptedException
    //   1573	1578	655	java/lang/InterruptedException
    //   1578	1587	655	java/lang/InterruptedException
    //   1589	1616	655	java/lang/InterruptedException
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
    //   344	369	1300	java/lang/Exception
    //   375	397	1300	java/lang/Exception
    //   397	422	1300	java/lang/Exception
    //   422	441	1300	java/lang/Exception
    //   449	483	1300	java/lang/Exception
    //   483	542	1300	java/lang/Exception
    //   542	579	1300	java/lang/Exception
    //   579	646	1300	java/lang/Exception
    //   646	652	1300	java/lang/Exception
    //   1262	1272	1300	java/lang/Exception
    //   1278	1297	1300	java/lang/Exception
    //   1325	1344	1300	java/lang/Exception
    //   1442	1479	1300	java/lang/Exception
    //   1400	1405	1408	java/lang/Exception
    //   1344	1359	1440	java/lang/Exception
    //   1410	1437	1440	java/lang/Exception
    //   1533	1560	1440	java/lang/Exception
    //   1578	1587	1440	java/lang/Exception
    //   1589	1616	1440	java/lang/Exception
    //   1369	1380	1482	java/lang/Exception
    //   1523	1528	1531	java/lang/Exception
    //   1369	1380	1563	finally
    //   1573	1578	1587	java/lang/Exception
    //   1384	1391	1626	finally
    //   1395	1400	1626	finally
    //   1491	1518	1626	finally
    //   1384	1391	1631	java/lang/Exception
    //   1395	1400	1631	java/lang/Exception
  }
  
  static final class a
    implements Serializable
  {
    final List<c.b> lKA;
    final List<c.b> lKB;
    final List<c.b> lKC;
    final List<c.b> lKD;
    final List<c.d> lKh;
    final List<c.c> lKi;
    final List<c.c> lKj;
    final List<c.b> lKk;
    final List<c.b> lKl;
    final List<c.b> lKm;
    final List<c.b> lKn;
    final List<c.b> lKo;
    final List<c.b> lKp;
    final List<c.b> lKq;
    final List<c.b> lKr;
    final List<c.b> lKs;
    final List<c.b> lKt;
    final List<c.b> lKu;
    final List<c.b> lKv;
    final List<c.b> lKw;
    final List<c.b> lKx;
    final List<c.b> lKy;
    final List<c.b> lKz;
    
    a()
    {
      AppMethodBeat.i(132524);
      this.lKh = new CopyOnWriteArrayList();
      this.lKi = new CopyOnWriteArrayList();
      this.lKj = new CopyOnWriteArrayList();
      this.lKk = new CopyOnWriteArrayList();
      this.lKl = new CopyOnWriteArrayList();
      this.lKm = new CopyOnWriteArrayList();
      this.lKn = new CopyOnWriteArrayList();
      this.lKo = new CopyOnWriteArrayList();
      this.lKp = new CopyOnWriteArrayList();
      this.lKq = new CopyOnWriteArrayList();
      this.lKr = new CopyOnWriteArrayList();
      this.lKs = new CopyOnWriteArrayList();
      this.lKt = new CopyOnWriteArrayList();
      this.lKu = new CopyOnWriteArrayList();
      this.lKv = new CopyOnWriteArrayList();
      this.lKw = new CopyOnWriteArrayList();
      this.lKx = new CopyOnWriteArrayList();
      this.lKy = new CopyOnWriteArrayList();
      this.lKz = new CopyOnWriteArrayList();
      this.lKA = new CopyOnWriteArrayList();
      this.lKB = new CopyOnWriteArrayList();
      this.lKC = new CopyOnWriteArrayList();
      this.lKD = new CopyOnWriteArrayList();
      AppMethodBeat.o(132524);
    }
    
    public static void a(List<c.b> paramList, c.b paramb)
    {
      AppMethodBeat.i(206159);
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
      AppMethodBeat.o(206159);
    }
    
    public static void e(List<c.b> paramList1, List<c.b> paramList2)
    {
      AppMethodBeat.i(206161);
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
      AppMethodBeat.o(206161);
    }
    
    public final void a(c.d paramd)
    {
      AppMethodBeat.i(206156);
      if (this.lKh.size() > 30000)
      {
        int i = 0;
        for (;;)
        {
          if (i < 100) {
            try
            {
              this.lKh.remove(0);
              i += 1;
            }
            catch (Exception localException)
            {
              Log.e("MicroMsg.ActiveDetector.ProcessDetector", "addProcessStatusList %s", new Object[] { localException.getMessage() });
            }
          }
        }
      }
      this.lKh.add(paramd);
      AppMethodBeat.o(206156);
    }
  }
  
  static final class b
    implements Serializable
  {
    long lJQ = 0L;
    long lJU = 0L;
    long lJV = 0L;
    long lJW = 0L;
    long lKE = 0L;
    int msgType = 0;
    int pid = 0;
    String username = "";
    
    b(int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, String paramString, int paramInt2)
    {
      this.pid = paramInt1;
      this.lJQ = paramLong1;
      this.lKE = paramLong2;
      this.lJU = paramLong3;
      this.lJV = paramLong4;
      this.lJW = paramLong5;
      this.username = paramString;
      this.msgType = paramInt2;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(132525);
      String str = String.format("pid:%s, server time:%s, client time:%s, msg server time:%s, intervalTime:%s, msg server id:%s username:%s, msgType:%s", new Object[] { Integer.valueOf(this.pid), a.GD(this.lJQ), a.GD(this.lKE), a.GD(this.lJU), Long.valueOf(this.lJV), Long.valueOf(this.lJW), this.username, Integer.valueOf(this.msgType) });
      AppMethodBeat.o(132525);
      return str;
    }
  }
  
  static final class c
    implements Serializable
  {
    long lJQ = 0L;
    long lKF;
    long time = 0L;
    int type = 0;
    
    c(long paramLong1, long paramLong2, int paramInt, long paramLong3)
    {
      this.lJQ = paramLong1;
      this.time = paramLong2;
      this.type = paramInt;
      this.lKF = paramLong3;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(132526);
      String str = String.format("serverTime:%s,time:%s,type:%s,recvTime:%s", new Object[] { a.GD(this.lJQ), a.GD(this.time), Integer.valueOf(this.type), Long.valueOf(this.lKF) });
      AppMethodBeat.o(132526);
      return str;
    }
  }
  
  public static final class d
    implements Serializable
  {
    long endTime = 0L;
    boolean lJR = true;
    boolean lJS = false;
    long lKG = 0L;
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
        this.lKG = cm.bfC();
      }
      this.endTime = paramLong2;
      this.networkStatus = paramInt2;
      AppMethodBeat.o(132527);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(132529);
      String str = String.format("pid:%s,startServerTime:%s,startTime:%s,endTime:%s,normalExecute:%s,changedNetworkStatus:%s,networkStatus:%s", new Object[] { Integer.valueOf(this.pid), a.GD(this.lKG), a.GD(this.startTime), a.GD(this.endTime), Boolean.valueOf(this.lJR), Boolean.valueOf(this.lJS), Integer.valueOf(this.networkStatus) });
      AppMethodBeat.o(132529);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.as.c
 * JD-Core Version:    0.7.0.1
 */