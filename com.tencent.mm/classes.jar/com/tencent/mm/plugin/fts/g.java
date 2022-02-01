package com.tencent.mm.plugin.fts;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.PriorityBlockingQueue;

public class g
  implements m
{
  a Hqi;
  
  public g()
  {
    AppMethodBeat.i(52559);
    this.Hqi = new a();
    AppMethodBeat.o(52559);
  }
  
  public final c a(int paramInt, c paramc)
  {
    AppMethodBeat.i(52562);
    if (this.Hqi == null)
    {
      AppMethodBeat.o(52562);
      return null;
    }
    paramc.mPriority = paramInt;
    a locala = this.Hqi;
    if (!locala.Hql)
    {
      paramInt = paramc.getPriority();
      locala.Hqk.put(paramc);
      if (locala.Hqm != null) {
        break label68;
      }
      locala.Wc(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(52562);
      return paramc;
      label68:
      if (paramInt < locala.Hqj)
      {
        locala.interrupt();
        locala.Wc(paramInt);
      }
    }
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(265409);
    if (this.Hqi == null)
    {
      AppMethodBeat.o(265409);
      return;
    }
    a locala = this.Hqi;
    paramc.mCancelled = true;
    locala.Hqk.remove(paramc);
    if (locala.Hqm == paramc) {
      locala.interrupt();
    }
    AppMethodBeat.o(265409);
  }
  
  public final boolean isStart()
  {
    AppMethodBeat.i(52560);
    if ((this.Hqi != null) && (this.Hqi.isAlive()))
    {
      AppMethodBeat.o(52560);
      return true;
    }
    AppMethodBeat.o(52560);
    return false;
  }
  
  public final void quit()
  {
    AppMethodBeat.i(52561);
    if ((this.Hqi == null) || (!this.Hqi.isAlive()))
    {
      AppMethodBeat.o(52561);
      return;
    }
    this.Hqi.quit();
    try
    {
      this.Hqi.join();
      label42:
      this.Hqi = null;
      Log.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon quited.");
      AppMethodBeat.o(52561);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label42;
    }
  }
  
  final class a
    extends Thread
  {
    int Hqj;
    PriorityBlockingQueue<c> Hqk;
    volatile boolean Hql;
    c Hqm;
    private boolean Hqn;
    Runnable Hqo;
    boolean Hqp;
    private int mTid;
    
    public a()
    {
      super();
      AppMethodBeat.i(52554);
      this.mTid = 0;
      this.Hqj = 2147483647;
      this.Hqk = new PriorityBlockingQueue();
      this.Hql = false;
      this.Hqp = false;
      AppMethodBeat.o(52554);
    }
    
    final void Wc(int paramInt)
    {
      do
      {
        try
        {
          AppMethodBeat.i(52555);
          if ((this.Hqj == paramInt) || (!isAlive()))
          {
            AppMethodBeat.o(52555);
            return;
          }
          if ((paramInt < 0) && (this.Hqj >= 0)) {
            Process.setThreadPriority(this.mTid, -8);
          }
          while (paramInt < 0)
          {
            this.Hqj = paramInt;
            AppMethodBeat.o(52555);
            break;
          }
        }
        finally {}
      } while (this.Hqj >= 0);
      if (this.Hqn) {}
      for (int i = 10;; i = 0)
      {
        Process.setThreadPriority(this.mTid, i);
        break;
      }
    }
    
    public final void quit()
    {
      try
      {
        AppMethodBeat.i(52556);
        this.Hql = true;
        interrupt();
        AppMethodBeat.o(52556);
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: ldc 82
      //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokestatic 86	android/os/Process:myTid	()I
      //   9: putfield 41	com/tencent/mm/plugin/fts/g$a:mTid	I
      //   12: invokestatic 89	java/lang/Thread:interrupted	()Z
      //   15: pop
      //   16: aload_0
      //   17: getfield 53	com/tencent/mm/plugin/fts/g$a:Hql	Z
      //   20: istore_2
      //   21: iload_2
      //   22: ifeq +22 -> 44
      //   25: invokestatic 94	com/tencent/mm/plugin/fts/a:fxc	()V
      //   28: aload_0
      //   29: aconst_null
      //   30: putfield 96	com/tencent/mm/plugin/fts/g$a:Hqm	Lcom/tencent/mm/plugin/fts/a/a/c;
      //   33: aload_0
      //   34: iconst_0
      //   35: putfield 41	com/tencent/mm/plugin/fts/g$a:mTid	I
      //   38: ldc 82
      //   40: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   43: return
      //   44: aload_0
      //   45: aconst_null
      //   46: putfield 96	com/tencent/mm/plugin/fts/g$a:Hqm	Lcom/tencent/mm/plugin/fts/a/a/c;
      //   49: aload_0
      //   50: getfield 51	com/tencent/mm/plugin/fts/g$a:Hqk	Ljava/util/concurrent/PriorityBlockingQueue;
      //   53: invokevirtual 100	java/util/concurrent/PriorityBlockingQueue:take	()Ljava/lang/Object;
      //   56: checkcast 102	com/tencent/mm/plugin/fts/a/a/c
      //   59: astore 5
      //   61: aload 5
      //   63: ifnonnull +14 -> 77
      //   66: invokestatic 94	com/tencent/mm/plugin/fts/a:fxc	()V
      //   69: aload_0
      //   70: aconst_null
      //   71: putfield 96	com/tencent/mm/plugin/fts/g$a:Hqm	Lcom/tencent/mm/plugin/fts/a/a/c;
      //   74: goto -62 -> 12
      //   77: aload_0
      //   78: aload 5
      //   80: putfield 96	com/tencent/mm/plugin/fts/g$a:Hqm	Lcom/tencent/mm/plugin/fts/a/a/c;
      //   83: aload_0
      //   84: aload 5
      //   86: invokevirtual 105	com/tencent/mm/plugin/fts/a/a/c:getPriority	()I
      //   89: invokevirtual 107	com/tencent/mm/plugin/fts/g$a:Wc	(I)V
      //   92: aload 5
      //   94: invokevirtual 111	com/tencent/mm/plugin/fts/a/a/c:getName	()Ljava/lang/String;
      //   97: astore 6
      //   99: aload 6
      //   101: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   104: ifeq +1067 -> 1171
      //   107: aload 5
      //   109: invokevirtual 122	java/lang/Object:toString	()Ljava/lang/String;
      //   112: astore 7
      //   114: aload 7
      //   116: astore 6
      //   118: invokestatic 128	java/lang/System:currentTimeMillis	()J
      //   121: lstore_3
      //   122: aload 5
      //   124: invokevirtual 131	com/tencent/mm/plugin/fts/a/a/c:aXz	()Z
      //   127: pop
      //   128: aload 5
      //   130: invokestatic 128	java/lang/System:currentTimeMillis	()J
      //   133: lload_3
      //   134: lsub
      //   135: aload 5
      //   137: getfield 135	com/tencent/mm/plugin/fts/a/a/c:Hss	J
      //   140: ladd
      //   141: putfield 135	com/tencent/mm/plugin/fts/a/a/c:Hss	J
      //   144: aload 5
      //   146: invokevirtual 138	com/tencent/mm/plugin/fts/a/a/c:getId	()I
      //   149: aload 5
      //   151: getfield 135	com/tencent/mm/plugin/fts/a/a/c:Hss	J
      //   154: invokestatic 144	com/tencent/mm/plugin/fts/a/e:aA	(IJ)V
      //   157: aload 5
      //   159: invokevirtual 138	com/tencent/mm/plugin/fts/a/a/c:getId	()I
      //   162: aload 5
      //   164: getfield 135	com/tencent/mm/plugin/fts/a/a/c:Hss	J
      //   167: invokestatic 147	com/tencent/mm/plugin/fts/a/e:aB	(IJ)V
      //   170: aload 5
      //   172: getfield 150	com/tencent/mm/plugin/fts/a/a/c:Hst	J
      //   175: lconst_1
      //   176: land
      //   177: lconst_0
      //   178: lcmp
      //   179: ifle +348 -> 527
      //   182: iconst_1
      //   183: istore_1
      //   184: iload_1
      //   185: ifeq +47 -> 232
      //   188: aload 5
      //   190: getfield 135	com/tencent/mm/plugin/fts/a/a/c:Hss	J
      //   193: ldc2_w 151
      //   196: lcmp
      //   197: ifle +35 -> 232
      //   200: aload 5
      //   202: getfield 135	com/tencent/mm/plugin/fts/a/a/c:Hss	J
      //   205: ldc2_w 153
      //   208: lcmp
      //   209: ifge +23 -> 232
      //   212: bipush 27
      //   214: aload 5
      //   216: getfield 135	com/tencent/mm/plugin/fts/a/a/c:Hss	J
      //   219: invokestatic 144	com/tencent/mm/plugin/fts/a/e:aA	(IJ)V
      //   222: bipush 27
      //   224: aload 5
      //   226: getfield 135	com/tencent/mm/plugin/fts/a/a/c:Hss	J
      //   229: invokestatic 147	com/tencent/mm/plugin/fts/a/e:aB	(IJ)V
      //   232: aload 5
      //   234: instanceof 156
      //   237: ifeq +295 -> 532
      //   240: aload 5
      //   242: checkcast 156	com/tencent/mm/plugin/fts/a/a/k
      //   245: astore 8
      //   247: ldc 158
      //   249: iconst_4
      //   250: anewarray 119	java/lang/Object
      //   253: dup
      //   254: iconst_0
      //   255: aload 6
      //   257: aastore
      //   258: dup
      //   259: iconst_1
      //   260: aload 8
      //   262: getfield 162	com/tencent/mm/plugin/fts/a/a/k:Htr	Lcom/tencent/mm/plugin/fts/a/a/l;
      //   265: invokevirtual 165	com/tencent/mm/plugin/fts/a/a/l:toString	()Ljava/lang/String;
      //   268: aastore
      //   269: dup
      //   270: iconst_2
      //   271: aload 8
      //   273: getfield 169	com/tencent/mm/plugin/fts/a/a/k:Hts	Lcom/tencent/mm/plugin/fts/a/a/m;
      //   276: invokevirtual 172	com/tencent/mm/plugin/fts/a/a/m:toString	()Ljava/lang/String;
      //   279: aastore
      //   280: dup
      //   281: iconst_3
      //   282: aload 5
      //   284: getfield 135	com/tencent/mm/plugin/fts/a/a/c:Hss	J
      //   287: invokestatic 178	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   290: aastore
      //   291: invokestatic 184	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   294: astore 7
      //   296: aload 8
      //   298: getfield 169	com/tencent/mm/plugin/fts/a/a/k:Hts	Lcom/tencent/mm/plugin/fts/a/a/m;
      //   301: getfield 188	com/tencent/mm/plugin/fts/a/a/m:HtF	Ljava/util/List;
      //   304: invokeinterface 193 1 0
      //   309: istore_1
      //   310: aload 5
      //   312: invokevirtual 138	com/tencent/mm/plugin/fts/a/a/c:getId	()I
      //   315: aload 5
      //   317: getfield 135	com/tencent/mm/plugin/fts/a/a/c:Hss	J
      //   320: iload_1
      //   321: i2l
      //   322: invokestatic 197	com/tencent/mm/plugin/fts/a/e:n	(IJJ)V
      //   325: aload 5
      //   327: getfield 200	com/tencent/mm/plugin/fts/a/a/c:Hsu	Ljava/util/List;
      //   330: ifnull +352 -> 682
      //   333: aload 5
      //   335: getfield 200	com/tencent/mm/plugin/fts/a/a/c:Hsu	Ljava/util/List;
      //   338: invokeinterface 193 1 0
      //   343: iconst_1
      //   344: if_icmple +338 -> 682
      //   347: new 202	java/lang/StringBuffer
      //   350: dup
      //   351: invokespecial 203	java/lang/StringBuffer:<init>	()V
      //   354: astore 8
      //   356: iconst_1
      //   357: istore_1
      //   358: iload_1
      //   359: aload 5
      //   361: getfield 200	com/tencent/mm/plugin/fts/a/a/c:Hsu	Ljava/util/List;
      //   364: invokeinterface 193 1 0
      //   369: if_icmpge +195 -> 564
      //   372: aload 5
      //   374: getfield 200	com/tencent/mm/plugin/fts/a/a/c:Hsu	Ljava/util/List;
      //   377: iload_1
      //   378: iconst_1
      //   379: isub
      //   380: invokeinterface 207 2 0
      //   385: checkcast 209	com/tencent/mm/plugin/fts/a/a/c$a
      //   388: astore 9
      //   390: aload 5
      //   392: getfield 200	com/tencent/mm/plugin/fts/a/a/c:Hsu	Ljava/util/List;
      //   395: iload_1
      //   396: invokeinterface 207 2 0
      //   401: checkcast 209	com/tencent/mm/plugin/fts/a/a/c$a
      //   404: astore 10
      //   406: aload 8
      //   408: ldc 211
      //   410: invokevirtual 215	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   413: pop
      //   414: aload 8
      //   416: aload 10
      //   418: getfield 219	com/tencent/mm/plugin/fts/a/a/c$a:Hsw	Ljava/lang/String;
      //   421: invokevirtual 215	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   424: pop
      //   425: aload 8
      //   427: ldc 221
      //   429: invokevirtual 215	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   432: pop
      //   433: aload 8
      //   435: aload 10
      //   437: getfield 224	com/tencent/mm/plugin/fts/a/a/c$a:timestamp	J
      //   440: aload 9
      //   442: getfield 224	com/tencent/mm/plugin/fts/a/a/c$a:timestamp	J
      //   445: lsub
      //   446: invokevirtual 227	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
      //   449: pop
      //   450: aload 8
      //   452: ldc 229
      //   454: invokevirtual 215	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   457: pop
      //   458: iload_1
      //   459: iconst_1
      //   460: iadd
      //   461: istore_1
      //   462: goto -104 -> 358
      //   465: astore 7
      //   467: ldc 82
      //   469: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   472: aload 7
      //   474: athrow
      //   475: astore 7
      //   477: aload 5
      //   479: invokestatic 128	java/lang/System:currentTimeMillis	()J
      //   482: lload_3
      //   483: lsub
      //   484: aload 5
      //   486: getfield 135	com/tencent/mm/plugin/fts/a/a/c:Hss	J
      //   489: ladd
      //   490: putfield 135	com/tencent/mm/plugin/fts/a/a/c:Hss	J
      //   493: ldc 82
      //   495: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   498: aload 7
      //   500: athrow
      //   501: astore 8
      //   503: aload 5
      //   505: astore 7
      //   507: aload 8
      //   509: astore 5
      //   511: aload 7
      //   513: ifnonnull +176 -> 689
      //   516: invokestatic 94	com/tencent/mm/plugin/fts/a:fxc	()V
      //   519: aload_0
      //   520: aconst_null
      //   521: putfield 96	com/tencent/mm/plugin/fts/g$a:Hqm	Lcom/tencent/mm/plugin/fts/a/a/c;
      //   524: goto -512 -> 12
      //   527: iconst_0
      //   528: istore_1
      //   529: goto -345 -> 184
      //   532: ldc 231
      //   534: iconst_2
      //   535: anewarray 119	java/lang/Object
      //   538: dup
      //   539: iconst_0
      //   540: aload 6
      //   542: aastore
      //   543: dup
      //   544: iconst_1
      //   545: aload 5
      //   547: getfield 135	com/tencent/mm/plugin/fts/a/a/c:Hss	J
      //   550: invokestatic 178	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   553: aastore
      //   554: invokestatic 184	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   557: astore 7
      //   559: iconst_0
      //   560: istore_1
      //   561: goto -251 -> 310
      //   564: ldc 233
      //   566: iconst_1
      //   567: anewarray 119	java/lang/Object
      //   570: dup
      //   571: iconst_0
      //   572: aload 8
      //   574: invokevirtual 234	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   577: aastore
      //   578: invokestatic 184	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   581: astore 8
      //   583: aload 8
      //   585: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   588: ifne +580 -> 1168
      //   591: new 236	java/lang/StringBuilder
      //   594: dup
      //   595: invokespecial 237	java/lang/StringBuilder:<init>	()V
      //   598: aload 7
      //   600: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   603: ldc 242
      //   605: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   608: aload 8
      //   610: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   613: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   616: astore 7
      //   618: aload 5
      //   620: invokevirtual 246	com/tencent/mm/plugin/fts/a/a/c:coz	()Ljava/lang/String;
      //   623: astore 9
      //   625: aload 7
      //   627: astore 8
      //   629: aload 9
      //   631: invokestatic 117	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   634: ifne +30 -> 664
      //   637: new 236	java/lang/StringBuilder
      //   640: dup
      //   641: invokespecial 237	java/lang/StringBuilder:<init>	()V
      //   644: aload 7
      //   646: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   649: ldc 242
      //   651: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   654: aload 9
      //   656: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   659: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   662: astore 8
      //   664: ldc 248
      //   666: aload 8
      //   668: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   671: invokestatic 94	com/tencent/mm/plugin/fts/a:fxc	()V
      //   674: aload_0
      //   675: aconst_null
      //   676: putfield 96	com/tencent/mm/plugin/fts/g$a:Hqm	Lcom/tencent/mm/plugin/fts/a/a/c;
      //   679: goto -667 -> 12
      //   682: ldc 255
      //   684: astore 8
      //   686: goto -103 -> 583
      //   689: aload 5
      //   691: instanceof 257
      //   694: ifeq +70 -> 764
      //   697: aload 7
      //   699: invokevirtual 260	com/tencent/mm/plugin/fts/a/a/c:isCancelled	()Z
      //   702: ifne +12 -> 714
      //   705: aload_0
      //   706: getfield 51	com/tencent/mm/plugin/fts/g$a:Hqk	Ljava/util/concurrent/PriorityBlockingQueue;
      //   709: aload 7
      //   711: invokevirtual 264	java/util/concurrent/PriorityBlockingQueue:put	(Ljava/lang/Object;)V
      //   714: ldc 248
      //   716: ldc_w 266
      //   719: iconst_3
      //   720: anewarray 119	java/lang/Object
      //   723: dup
      //   724: iconst_0
      //   725: aload 6
      //   727: aastore
      //   728: dup
      //   729: iconst_1
      //   730: aload 7
      //   732: invokevirtual 260	com/tencent/mm/plugin/fts/a/a/c:isCancelled	()Z
      //   735: invokestatic 271	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   738: aastore
      //   739: dup
      //   740: iconst_2
      //   741: aload 7
      //   743: getfield 135	com/tencent/mm/plugin/fts/a/a/c:Hss	J
      //   746: invokestatic 178	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   749: aastore
      //   750: invokestatic 274	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   753: invokestatic 94	com/tencent/mm/plugin/fts/a:fxc	()V
      //   756: aload_0
      //   757: aconst_null
      //   758: putfield 96	com/tencent/mm/plugin/fts/g$a:Hqm	Lcom/tencent/mm/plugin/fts/a/a/c;
      //   761: goto -749 -> 12
      //   764: aload 5
      //   766: instanceof 276
      //   769: ifeq +32 -> 801
      //   772: ldc 248
      //   774: ldc_w 278
      //   777: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   780: goto -27 -> 753
      //   783: astore 5
      //   785: invokestatic 94	com/tencent/mm/plugin/fts/a:fxc	()V
      //   788: aload_0
      //   789: aconst_null
      //   790: putfield 96	com/tencent/mm/plugin/fts/g$a:Hqm	Lcom/tencent/mm/plugin/fts/a/a/c;
      //   793: ldc 82
      //   795: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   798: aload 5
      //   800: athrow
      //   801: aload 5
      //   803: instanceof 280
      //   806: ifeq +80 -> 886
      //   809: ldc 248
      //   811: aload 5
      //   813: ldc_w 282
      //   816: iconst_1
      //   817: anewarray 119	java/lang/Object
      //   820: dup
      //   821: iconst_0
      //   822: aload 6
      //   824: aastore
      //   825: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   828: aload_0
      //   829: getfield 55	com/tencent/mm/plugin/fts/g$a:Hqp	Z
      //   832: ifne -79 -> 753
      //   835: new 236	java/lang/StringBuilder
      //   838: dup
      //   839: invokespecial 237	java/lang/StringBuilder:<init>	()V
      //   842: aload 7
      //   844: invokevirtual 289	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   847: ldc_w 291
      //   850: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   853: aload 5
      //   855: invokestatic 297	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   858: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   861: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   864: astore 5
      //   866: getstatic 303	com/tencent/mm/plugin/report/service/h:OAn	Lcom/tencent/mm/plugin/report/service/h;
      //   869: ldc_w 305
      //   872: aload 5
      //   874: aconst_null
      //   875: invokevirtual 309	com/tencent/mm/plugin/report/service/h:e	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
      //   878: aload_0
      //   879: iconst_1
      //   880: putfield 55	com/tencent/mm/plugin/fts/g$a:Hqp	Z
      //   883: goto -130 -> 753
      //   886: aload 5
      //   888: instanceof 311
      //   891: ifeq +30 -> 921
      //   894: ldc 248
      //   896: aload 5
      //   898: ldc_w 313
      //   901: iconst_1
      //   902: anewarray 119	java/lang/Object
      //   905: dup
      //   906: iconst_0
      //   907: aload 6
      //   909: aastore
      //   910: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   913: bipush 6
      //   915: invokestatic 316	com/tencent/mm/plugin/fts/a/e:Wf	(I)V
      //   918: goto -165 -> 753
      //   921: aload 5
      //   923: instanceof 318
      //   926: ifeq +30 -> 956
      //   929: ldc 248
      //   931: aload 5
      //   933: ldc_w 313
      //   936: iconst_1
      //   937: anewarray 119	java/lang/Object
      //   940: dup
      //   941: iconst_0
      //   942: aload 6
      //   944: aastore
      //   945: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   948: bipush 7
      //   950: invokestatic 316	com/tencent/mm/plugin/fts/a/e:Wf	(I)V
      //   953: goto -200 -> 753
      //   956: aload 5
      //   958: instanceof 320
      //   961: ifeq +45 -> 1006
      //   964: ldc 248
      //   966: aload 5
      //   968: ldc_w 313
      //   971: iconst_1
      //   972: anewarray 119	java/lang/Object
      //   975: dup
      //   976: iconst_0
      //   977: aload 6
      //   979: aastore
      //   980: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   983: iconst_3
      //   984: invokestatic 316	com/tencent/mm/plugin/fts/a/e:Wf	(I)V
      //   987: aload_0
      //   988: getfield 322	com/tencent/mm/plugin/fts/g$a:Hqo	Ljava/lang/Runnable;
      //   991: ifnull -238 -> 753
      //   994: aload_0
      //   995: getfield 322	com/tencent/mm/plugin/fts/g$a:Hqo	Ljava/lang/Runnable;
      //   998: invokeinterface 326 1 0
      //   1003: goto -250 -> 753
      //   1006: aload 5
      //   1008: instanceof 328
      //   1011: ifeq +75 -> 1086
      //   1014: ldc 248
      //   1016: aload 5
      //   1018: ldc_w 313
      //   1021: iconst_1
      //   1022: anewarray 119	java/lang/Object
      //   1025: dup
      //   1026: iconst_0
      //   1027: aload 6
      //   1029: aastore
      //   1030: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1033: aload 5
      //   1035: invokevirtual 331	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1038: ifnull +41 -> 1079
      //   1041: aload 5
      //   1043: invokevirtual 331	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1046: ldc_w 333
      //   1049: invokevirtual 337	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   1052: ifeq +27 -> 1079
      //   1055: bipush 17
      //   1057: invokestatic 316	com/tencent/mm/plugin/fts/a/e:Wf	(I)V
      //   1060: aload_0
      //   1061: getfield 322	com/tencent/mm/plugin/fts/g$a:Hqo	Ljava/lang/Runnable;
      //   1064: ifnull -311 -> 753
      //   1067: aload_0
      //   1068: getfield 322	com/tencent/mm/plugin/fts/g$a:Hqo	Ljava/lang/Runnable;
      //   1071: invokeinterface 326 1 0
      //   1076: goto -323 -> 753
      //   1079: iconst_4
      //   1080: invokestatic 316	com/tencent/mm/plugin/fts/a/e:Wf	(I)V
      //   1083: goto -23 -> 1060
      //   1086: ldc 248
      //   1088: aload 5
      //   1090: ldc_w 313
      //   1093: iconst_1
      //   1094: anewarray 119	java/lang/Object
      //   1097: dup
      //   1098: iconst_0
      //   1099: aload 6
      //   1101: aastore
      //   1102: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1105: iconst_5
      //   1106: invokestatic 316	com/tencent/mm/plugin/fts/a/e:Wf	(I)V
      //   1109: aload_0
      //   1110: getfield 322	com/tencent/mm/plugin/fts/g$a:Hqo	Ljava/lang/Runnable;
      //   1113: ifnull -360 -> 753
      //   1116: aload_0
      //   1117: getfield 322	com/tencent/mm/plugin/fts/g$a:Hqo	Ljava/lang/Runnable;
      //   1120: invokeinterface 326 1 0
      //   1125: goto -372 -> 753
      //   1128: astore 5
      //   1130: aconst_null
      //   1131: astore 6
      //   1133: aconst_null
      //   1134: astore 7
      //   1136: goto -625 -> 511
      //   1139: astore 8
      //   1141: aconst_null
      //   1142: astore 6
      //   1144: aload 5
      //   1146: astore 7
      //   1148: aload 8
      //   1150: astore 5
      //   1152: goto -641 -> 511
      //   1155: astore 8
      //   1157: aload 5
      //   1159: astore 7
      //   1161: aload 8
      //   1163: astore 5
      //   1165: goto -654 -> 511
      //   1168: goto -550 -> 618
      //   1171: goto -1053 -> 118
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1174	0	this	a
      //   183	378	1	i	int
      //   20	2	2	bool	boolean
      //   121	362	3	l	long
      //   59	706	5	localObject1	Object
      //   783	71	5	localThrowable	java.lang.Throwable
      //   864	225	5	str1	java.lang.String
      //   1128	17	5	localException1	java.lang.Exception
      //   1150	14	5	localObject2	Object
      //   97	1046	6	localObject3	Object
      //   112	183	7	str2	java.lang.String
      //   465	8	7	localException2	java.lang.Exception
      //   475	24	7	localObject4	Object
      //   505	655	7	localObject5	Object
      //   245	206	8	localObject6	Object
      //   501	72	8	localException3	java.lang.Exception
      //   581	104	8	localObject7	Object
      //   1139	10	8	localException4	java.lang.Exception
      //   1155	7	8	localException5	java.lang.Exception
      //   388	267	9	localObject8	Object
      //   404	32	10	locala	com.tencent.mm.plugin.fts.a.a.c.a
      // Exception table:
      //   from	to	target	type
      //   122	128	465	java/lang/Exception
      //   122	128	475	finally
      //   467	475	475	finally
      //   118	122	501	java/lang/Exception
      //   128	182	501	java/lang/Exception
      //   188	232	501	java/lang/Exception
      //   232	310	501	java/lang/Exception
      //   310	356	501	java/lang/Exception
      //   358	458	501	java/lang/Exception
      //   477	501	501	java/lang/Exception
      //   532	559	501	java/lang/Exception
      //   564	583	501	java/lang/Exception
      //   583	618	501	java/lang/Exception
      //   618	625	501	java/lang/Exception
      //   629	664	501	java/lang/Exception
      //   664	671	501	java/lang/Exception
      //   12	21	783	finally
      //   44	61	783	finally
      //   77	99	783	finally
      //   99	114	783	finally
      //   118	122	783	finally
      //   128	182	783	finally
      //   188	232	783	finally
      //   232	310	783	finally
      //   310	356	783	finally
      //   358	458	783	finally
      //   477	501	783	finally
      //   532	559	783	finally
      //   564	583	783	finally
      //   583	618	783	finally
      //   618	625	783	finally
      //   629	664	783	finally
      //   664	671	783	finally
      //   689	714	783	finally
      //   714	753	783	finally
      //   764	780	783	finally
      //   801	883	783	finally
      //   886	918	783	finally
      //   921	953	783	finally
      //   956	1003	783	finally
      //   1006	1060	783	finally
      //   1060	1076	783	finally
      //   1079	1083	783	finally
      //   1086	1125	783	finally
      //   12	21	1128	java/lang/Exception
      //   44	61	1128	java/lang/Exception
      //   77	99	1139	java/lang/Exception
      //   99	114	1155	java/lang/Exception
    }
    
    /* Error */
    public final void vN(boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc_w 342
      //   7: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   10: aload_0
      //   11: getfield 73	com/tencent/mm/plugin/fts/g$a:Hqn	Z
      //   14: iload_1
      //   15: if_icmpne +12 -> 27
      //   18: ldc_w 342
      //   21: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   24: aload_0
      //   25: monitorexit
      //   26: return
      //   27: aload_0
      //   28: iload_1
      //   29: putfield 73	com/tencent/mm/plugin/fts/g$a:Hqn	Z
      //   32: aload_0
      //   33: getfield 44	com/tencent/mm/plugin/fts/g$a:Hqj	I
      //   36: iflt +126 -> 162
      //   39: aload_0
      //   40: invokevirtual 65	com/tencent/mm/plugin/fts/g$a:isAlive	()Z
      //   43: ifeq +119 -> 162
      //   46: aload_0
      //   47: getfield 41	com/tencent/mm/plugin/fts/g$a:mTid	I
      //   50: ifeq +112 -> 162
      //   53: aload_0
      //   54: getfield 73	com/tencent/mm/plugin/fts/g$a:Hqn	Z
      //   57: istore_1
      //   58: iload_1
      //   59: ifeq +6 -> 65
      //   62: bipush 10
      //   64: istore_2
      //   65: aload_0
      //   66: getfield 41	com/tencent/mm/plugin/fts/g$a:mTid	I
      //   69: iload_2
      //   70: invokestatic 71	android/os/Process:setThreadPriority	(II)V
      //   73: new 236	java/lang/StringBuilder
      //   76: dup
      //   77: ldc_w 344
      //   80: invokespecial 345	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   83: astore 4
      //   85: aload_0
      //   86: getfield 73	com/tencent/mm/plugin/fts/g$a:Hqn	Z
      //   89: ifeq +35 -> 124
      //   92: ldc_w 347
      //   95: astore_3
      //   96: ldc 248
      //   98: aload 4
      //   100: aload_3
      //   101: invokevirtual 240	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   104: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   107: invokestatic 253	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   110: ldc_w 342
      //   113: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   116: goto -92 -> 24
      //   119: astore_3
      //   120: aload_0
      //   121: monitorexit
      //   122: aload_3
      //   123: athrow
      //   124: ldc_w 349
      //   127: astore_3
      //   128: goto -32 -> 96
      //   131: astore_3
      //   132: ldc 248
      //   134: aload_3
      //   135: ldc_w 351
      //   138: iconst_2
      //   139: anewarray 119	java/lang/Object
      //   142: dup
      //   143: iconst_0
      //   144: aload_0
      //   145: getfield 41	com/tencent/mm/plugin/fts/g$a:mTid	I
      //   148: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   151: aastore
      //   152: dup
      //   153: iconst_1
      //   154: iload_2
      //   155: invokestatic 356	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   158: aastore
      //   159: invokestatic 286	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   162: ldc_w 342
      //   165: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   168: goto -144 -> 24
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	171	0	this	a
      //   0	171	1	paramBoolean	boolean
      //   1	154	2	i	int
      //   95	6	3	str1	java.lang.String
      //   119	4	3	localObject	Object
      //   127	1	3	str2	java.lang.String
      //   131	4	3	localSecurityException	java.lang.SecurityException
      //   83	16	4	localStringBuilder	java.lang.StringBuilder
      // Exception table:
      //   from	to	target	type
      //   4	24	119	finally
      //   27	58	119	finally
      //   65	92	119	finally
      //   96	110	119	finally
      //   110	116	119	finally
      //   132	162	119	finally
      //   162	168	119	finally
      //   65	92	131	java/lang/SecurityException
      //   96	110	131	java/lang/SecurityException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.g
 * JD-Core Version:    0.7.0.1
 */