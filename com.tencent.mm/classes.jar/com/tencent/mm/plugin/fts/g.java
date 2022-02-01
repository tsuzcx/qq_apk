package com.tencent.mm.plugin.fts;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.concurrent.PriorityBlockingQueue;

public final class g
  implements m
{
  a rmx;
  
  public g()
  {
    AppMethodBeat.i(52559);
    this.rmx = new a();
    AppMethodBeat.o(52559);
  }
  
  public final a a(int paramInt, a parama)
  {
    AppMethodBeat.i(52562);
    if (this.rmx == null)
    {
      AppMethodBeat.o(52562);
      return null;
    }
    parama.mPriority = paramInt;
    a locala = this.rmx;
    if (!locala.rmA)
    {
      paramInt = parama.getPriority();
      locala.rmz.put(parama);
      if (locala.rmB != null) {
        break label68;
      }
      locala.DA(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(52562);
      return parama;
      label68:
      if (paramInt < locala.rmy)
      {
        locala.interrupt();
        locala.DA(paramInt);
      }
    }
  }
  
  public final boolean isStart()
  {
    AppMethodBeat.i(52560);
    if ((this.rmx != null) && (this.rmx.isAlive()))
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
    if ((this.rmx == null) || (!this.rmx.isAlive()))
    {
      AppMethodBeat.o(52561);
      return;
    }
    this.rmx.quit();
    try
    {
      this.rmx.join();
      label42:
      this.rmx = null;
      ad.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon quited.");
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
    private int mTid;
    volatile boolean rmA;
    a rmB;
    private boolean rmC;
    Runnable rmD;
    boolean rmE;
    int rmy;
    PriorityBlockingQueue<a> rmz;
    
    public a()
    {
      super();
      AppMethodBeat.i(52554);
      this.mTid = 0;
      this.rmy = 2147483647;
      this.rmz = new PriorityBlockingQueue();
      this.rmA = false;
      this.rmE = false;
      AppMethodBeat.o(52554);
    }
    
    final void DA(int paramInt)
    {
      do
      {
        try
        {
          AppMethodBeat.i(52555);
          if ((this.rmy == paramInt) || (!isAlive()))
          {
            AppMethodBeat.o(52555);
            return;
          }
          if ((paramInt < 0) && (this.rmy >= 0)) {
            Process.setThreadPriority(this.mTid, -8);
          }
          while (paramInt < 0)
          {
            this.rmy = paramInt;
            AppMethodBeat.o(52555);
            break;
          }
        }
        finally {}
      } while (this.rmy >= 0);
      if (this.rmC) {}
      for (int i = 10;; i = 0)
      {
        Process.setThreadPriority(this.mTid, i);
        break;
      }
    }
    
    /* Error */
    public final void lz(boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 78
      //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 73	com/tencent/mm/plugin/fts/g$a:rmC	Z
      //   13: iload_1
      //   14: if_icmpne +11 -> 25
      //   17: ldc 78
      //   19: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   22: aload_0
      //   23: monitorexit
      //   24: return
      //   25: aload_0
      //   26: iload_1
      //   27: putfield 73	com/tencent/mm/plugin/fts/g$a:rmC	Z
      //   30: aload_0
      //   31: getfield 44	com/tencent/mm/plugin/fts/g$a:rmy	I
      //   34: iflt +121 -> 155
      //   37: aload_0
      //   38: invokevirtual 65	com/tencent/mm/plugin/fts/g$a:isAlive	()Z
      //   41: ifeq +114 -> 155
      //   44: aload_0
      //   45: getfield 41	com/tencent/mm/plugin/fts/g$a:mTid	I
      //   48: ifeq +107 -> 155
      //   51: aload_0
      //   52: getfield 73	com/tencent/mm/plugin/fts/g$a:rmC	Z
      //   55: istore_1
      //   56: iload_1
      //   57: ifeq +6 -> 63
      //   60: bipush 10
      //   62: istore_2
      //   63: aload_0
      //   64: getfield 41	com/tencent/mm/plugin/fts/g$a:mTid	I
      //   67: iload_2
      //   68: invokestatic 71	android/os/Process:setThreadPriority	(II)V
      //   71: new 80	java/lang/StringBuilder
      //   74: dup
      //   75: ldc 82
      //   77: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   80: astore 4
      //   82: aload_0
      //   83: getfield 73	com/tencent/mm/plugin/fts/g$a:rmC	Z
      //   86: ifeq +33 -> 119
      //   89: ldc 85
      //   91: astore_3
      //   92: ldc 87
      //   94: aload 4
      //   96: aload_3
      //   97: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   100: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   103: invokestatic 100	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   106: ldc 78
      //   108: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   111: goto -89 -> 22
      //   114: astore_3
      //   115: aload_0
      //   116: monitorexit
      //   117: aload_3
      //   118: athrow
      //   119: ldc 102
      //   121: astore_3
      //   122: goto -30 -> 92
      //   125: astore_3
      //   126: ldc 87
      //   128: aload_3
      //   129: ldc 104
      //   131: iconst_2
      //   132: anewarray 106	java/lang/Object
      //   135: dup
      //   136: iconst_0
      //   137: aload_0
      //   138: getfield 41	com/tencent/mm/plugin/fts/g$a:mTid	I
      //   141: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   144: aastore
      //   145: dup
      //   146: iconst_1
      //   147: iload_2
      //   148: invokestatic 112	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   151: aastore
      //   152: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   155: ldc 78
      //   157: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   160: goto -138 -> 22
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	163	0	this	a
      //   0	163	1	paramBoolean	boolean
      //   1	147	2	i	int
      //   91	6	3	str1	java.lang.String
      //   114	4	3	localObject	Object
      //   121	1	3	str2	java.lang.String
      //   125	4	3	localSecurityException	java.lang.SecurityException
      //   80	15	4	localStringBuilder	java.lang.StringBuilder
      // Exception table:
      //   from	to	target	type
      //   4	22	114	finally
      //   25	56	114	finally
      //   63	89	114	finally
      //   92	106	114	finally
      //   106	111	114	finally
      //   126	155	114	finally
      //   155	160	114	finally
      //   63	89	125	java/lang/SecurityException
      //   92	106	125	java/lang/SecurityException
    }
    
    public final void quit()
    {
      try
      {
        AppMethodBeat.i(52556);
        this.rmA = true;
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
      //   0: ldc 125
      //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokestatic 129	android/os/Process:myTid	()I
      //   9: putfield 41	com/tencent/mm/plugin/fts/g$a:mTid	I
      //   12: invokestatic 132	java/lang/Thread:interrupted	()Z
      //   15: pop
      //   16: aload_0
      //   17: getfield 53	com/tencent/mm/plugin/fts/g$a:rmA	Z
      //   20: istore_2
      //   21: iload_2
      //   22: ifeq +22 -> 44
      //   25: invokestatic 137	com/tencent/mm/plugin/fts/a:cwU	()V
      //   28: aload_0
      //   29: aconst_null
      //   30: putfield 139	com/tencent/mm/plugin/fts/g$a:rmB	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   33: aload_0
      //   34: iconst_0
      //   35: putfield 41	com/tencent/mm/plugin/fts/g$a:mTid	I
      //   38: ldc 125
      //   40: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   43: return
      //   44: aload_0
      //   45: aconst_null
      //   46: putfield 139	com/tencent/mm/plugin/fts/g$a:rmB	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   49: aload_0
      //   50: getfield 51	com/tencent/mm/plugin/fts/g$a:rmz	Ljava/util/concurrent/PriorityBlockingQueue;
      //   53: invokevirtual 143	java/util/concurrent/PriorityBlockingQueue:take	()Ljava/lang/Object;
      //   56: checkcast 145	com/tencent/mm/plugin/fts/a/a/a
      //   59: astore 5
      //   61: aload 5
      //   63: ifnonnull +14 -> 77
      //   66: invokestatic 137	com/tencent/mm/plugin/fts/a:cwU	()V
      //   69: aload_0
      //   70: aconst_null
      //   71: putfield 139	com/tencent/mm/plugin/fts/g$a:rmB	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   74: goto -62 -> 12
      //   77: aload_0
      //   78: aload 5
      //   80: putfield 139	com/tencent/mm/plugin/fts/g$a:rmB	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   83: aload_0
      //   84: aload 5
      //   86: invokevirtual 148	com/tencent/mm/plugin/fts/a/a/a:getPriority	()I
      //   89: invokevirtual 150	com/tencent/mm/plugin/fts/g$a:DA	(I)V
      //   92: aload 5
      //   94: invokevirtual 153	com/tencent/mm/plugin/fts/a/a/a:getName	()Ljava/lang/String;
      //   97: astore 6
      //   99: aload 6
      //   101: invokestatic 159	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   104: ifeq +1074 -> 1178
      //   107: aload 5
      //   109: invokevirtual 160	java/lang/Object:toString	()Ljava/lang/String;
      //   112: astore 7
      //   114: aload 7
      //   116: astore 6
      //   118: invokestatic 166	java/lang/System:currentTimeMillis	()J
      //   121: lstore_3
      //   122: aload 5
      //   124: invokevirtual 169	com/tencent/mm/plugin/fts/a/a/a:execute	()Z
      //   127: pop
      //   128: aload 5
      //   130: invokestatic 166	java/lang/System:currentTimeMillis	()J
      //   133: lload_3
      //   134: lsub
      //   135: aload 5
      //   137: getfield 173	com/tencent/mm/plugin/fts/a/a/a:roF	J
      //   140: ladd
      //   141: putfield 173	com/tencent/mm/plugin/fts/a/a/a:roF	J
      //   144: aload 5
      //   146: invokevirtual 176	com/tencent/mm/plugin/fts/a/a/a:getId	()I
      //   149: aload 5
      //   151: getfield 173	com/tencent/mm/plugin/fts/a/a/a:roF	J
      //   154: invokestatic 182	com/tencent/mm/plugin/fts/a/e:ad	(IJ)V
      //   157: aload 5
      //   159: invokevirtual 176	com/tencent/mm/plugin/fts/a/a/a:getId	()I
      //   162: aload 5
      //   164: getfield 173	com/tencent/mm/plugin/fts/a/a/a:roF	J
      //   167: invokestatic 185	com/tencent/mm/plugin/fts/a/e:ae	(IJ)V
      //   170: aload 5
      //   172: getfield 188	com/tencent/mm/plugin/fts/a/a/a:roG	J
      //   175: lconst_1
      //   176: land
      //   177: lconst_0
      //   178: lcmp
      //   179: ifle +350 -> 529
      //   182: iconst_1
      //   183: istore_1
      //   184: iload_1
      //   185: ifeq +47 -> 232
      //   188: aload 5
      //   190: getfield 173	com/tencent/mm/plugin/fts/a/a/a:roF	J
      //   193: ldc2_w 189
      //   196: lcmp
      //   197: ifle +35 -> 232
      //   200: aload 5
      //   202: getfield 173	com/tencent/mm/plugin/fts/a/a/a:roF	J
      //   205: ldc2_w 191
      //   208: lcmp
      //   209: ifge +23 -> 232
      //   212: bipush 27
      //   214: aload 5
      //   216: getfield 173	com/tencent/mm/plugin/fts/a/a/a:roF	J
      //   219: invokestatic 182	com/tencent/mm/plugin/fts/a/e:ad	(IJ)V
      //   222: bipush 27
      //   224: aload 5
      //   226: getfield 173	com/tencent/mm/plugin/fts/a/a/a:roF	J
      //   229: invokestatic 185	com/tencent/mm/plugin/fts/a/e:ae	(IJ)V
      //   232: aload 5
      //   234: instanceof 194
      //   237: ifeq +297 -> 534
      //   240: aload 5
      //   242: checkcast 194	com/tencent/mm/plugin/fts/a/a/i
      //   245: astore 8
      //   247: ldc 196
      //   249: iconst_4
      //   250: anewarray 106	java/lang/Object
      //   253: dup
      //   254: iconst_0
      //   255: aload 6
      //   257: aastore
      //   258: dup
      //   259: iconst_1
      //   260: aload 8
      //   262: getfield 200	com/tencent/mm/plugin/fts/a/a/i:rpD	Lcom/tencent/mm/plugin/fts/a/a/j;
      //   265: invokevirtual 203	com/tencent/mm/plugin/fts/a/a/j:toString	()Ljava/lang/String;
      //   268: aastore
      //   269: dup
      //   270: iconst_2
      //   271: aload 8
      //   273: getfield 207	com/tencent/mm/plugin/fts/a/a/i:rpE	Lcom/tencent/mm/plugin/fts/a/a/k;
      //   276: invokevirtual 210	com/tencent/mm/plugin/fts/a/a/k:toString	()Ljava/lang/String;
      //   279: aastore
      //   280: dup
      //   281: iconst_3
      //   282: aload 5
      //   284: getfield 173	com/tencent/mm/plugin/fts/a/a/a:roF	J
      //   287: invokestatic 215	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   290: aastore
      //   291: invokestatic 221	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   294: astore 7
      //   296: aload 8
      //   298: getfield 207	com/tencent/mm/plugin/fts/a/a/i:rpE	Lcom/tencent/mm/plugin/fts/a/a/k;
      //   301: getfield 225	com/tencent/mm/plugin/fts/a/a/k:rpQ	Ljava/util/List;
      //   304: invokeinterface 230 1 0
      //   309: istore_1
      //   310: aload 5
      //   312: invokevirtual 176	com/tencent/mm/plugin/fts/a/a/a:getId	()I
      //   315: aload 5
      //   317: getfield 173	com/tencent/mm/plugin/fts/a/a/a:roF	J
      //   320: iload_1
      //   321: i2l
      //   322: invokestatic 233	com/tencent/mm/plugin/fts/a/e:i	(IJJ)V
      //   325: aload 5
      //   327: getfield 236	com/tencent/mm/plugin/fts/a/a/a:roH	Ljava/util/List;
      //   330: ifnull +358 -> 688
      //   333: aload 5
      //   335: getfield 236	com/tencent/mm/plugin/fts/a/a/a:roH	Ljava/util/List;
      //   338: invokeinterface 230 1 0
      //   343: iconst_1
      //   344: if_icmple +344 -> 688
      //   347: new 238	java/lang/StringBuffer
      //   350: dup
      //   351: invokespecial 239	java/lang/StringBuffer:<init>	()V
      //   354: astore 8
      //   356: iconst_1
      //   357: istore_1
      //   358: iload_1
      //   359: aload 5
      //   361: getfield 236	com/tencent/mm/plugin/fts/a/a/a:roH	Ljava/util/List;
      //   364: invokeinterface 230 1 0
      //   369: if_icmpge +198 -> 567
      //   372: aload 5
      //   374: getfield 236	com/tencent/mm/plugin/fts/a/a/a:roH	Ljava/util/List;
      //   377: iload_1
      //   378: iconst_1
      //   379: isub
      //   380: invokeinterface 243 2 0
      //   385: checkcast 245	com/tencent/mm/plugin/fts/a/a/a$a
      //   388: astore 9
      //   390: aload 5
      //   392: getfield 236	com/tencent/mm/plugin/fts/a/a/a:roH	Ljava/util/List;
      //   395: iload_1
      //   396: invokeinterface 243 2 0
      //   401: checkcast 245	com/tencent/mm/plugin/fts/a/a/a$a
      //   404: astore 10
      //   406: aload 8
      //   408: ldc 247
      //   410: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   413: pop
      //   414: aload 8
      //   416: aload 10
      //   418: getfield 254	com/tencent/mm/plugin/fts/a/a/a$a:roJ	Ljava/lang/String;
      //   421: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   424: pop
      //   425: aload 8
      //   427: ldc_w 256
      //   430: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   433: pop
      //   434: aload 8
      //   436: aload 10
      //   438: getfield 259	com/tencent/mm/plugin/fts/a/a/a$a:timestamp	J
      //   441: aload 9
      //   443: getfield 259	com/tencent/mm/plugin/fts/a/a/a$a:timestamp	J
      //   446: lsub
      //   447: invokevirtual 262	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
      //   450: pop
      //   451: aload 8
      //   453: ldc_w 264
      //   456: invokevirtual 250	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   459: pop
      //   460: iload_1
      //   461: iconst_1
      //   462: iadd
      //   463: istore_1
      //   464: goto -106 -> 358
      //   467: astore 7
      //   469: ldc 125
      //   471: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   474: aload 7
      //   476: athrow
      //   477: astore 7
      //   479: aload 5
      //   481: invokestatic 166	java/lang/System:currentTimeMillis	()J
      //   484: lload_3
      //   485: lsub
      //   486: aload 5
      //   488: getfield 173	com/tencent/mm/plugin/fts/a/a/a:roF	J
      //   491: ladd
      //   492: putfield 173	com/tencent/mm/plugin/fts/a/a/a:roF	J
      //   495: ldc 125
      //   497: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   500: aload 7
      //   502: athrow
      //   503: astore 8
      //   505: aload 5
      //   507: astore 7
      //   509: aload 8
      //   511: astore 5
      //   513: aload 7
      //   515: ifnonnull +181 -> 696
      //   518: invokestatic 137	com/tencent/mm/plugin/fts/a:cwU	()V
      //   521: aload_0
      //   522: aconst_null
      //   523: putfield 139	com/tencent/mm/plugin/fts/g$a:rmB	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   526: goto -514 -> 12
      //   529: iconst_0
      //   530: istore_1
      //   531: goto -347 -> 184
      //   534: ldc_w 266
      //   537: iconst_2
      //   538: anewarray 106	java/lang/Object
      //   541: dup
      //   542: iconst_0
      //   543: aload 6
      //   545: aastore
      //   546: dup
      //   547: iconst_1
      //   548: aload 5
      //   550: getfield 173	com/tencent/mm/plugin/fts/a/a/a:roF	J
      //   553: invokestatic 215	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   556: aastore
      //   557: invokestatic 221	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   560: astore 7
      //   562: iconst_0
      //   563: istore_1
      //   564: goto -254 -> 310
      //   567: ldc_w 268
      //   570: iconst_1
      //   571: anewarray 106	java/lang/Object
      //   574: dup
      //   575: iconst_0
      //   576: aload 8
      //   578: invokevirtual 269	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   581: aastore
      //   582: invokestatic 221	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   585: astore 8
      //   587: aload 8
      //   589: invokestatic 159	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   592: ifne +583 -> 1175
      //   595: new 80	java/lang/StringBuilder
      //   598: dup
      //   599: invokespecial 270	java/lang/StringBuilder:<init>	()V
      //   602: aload 7
      //   604: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   607: ldc_w 272
      //   610: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   613: aload 8
      //   615: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   618: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   621: astore 7
      //   623: aload 5
      //   625: invokevirtual 275	com/tencent/mm/plugin/fts/a/a/a:aWs	()Ljava/lang/String;
      //   628: astore 9
      //   630: aload 7
      //   632: astore 8
      //   634: aload 9
      //   636: invokestatic 159	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   639: ifne +31 -> 670
      //   642: new 80	java/lang/StringBuilder
      //   645: dup
      //   646: invokespecial 270	java/lang/StringBuilder:<init>	()V
      //   649: aload 7
      //   651: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   654: ldc_w 272
      //   657: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   660: aload 9
      //   662: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   665: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   668: astore 8
      //   670: ldc 87
      //   672: aload 8
      //   674: invokestatic 100	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   677: invokestatic 137	com/tencent/mm/plugin/fts/a:cwU	()V
      //   680: aload_0
      //   681: aconst_null
      //   682: putfield 139	com/tencent/mm/plugin/fts/g$a:rmB	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   685: goto -673 -> 12
      //   688: ldc_w 277
      //   691: astore 8
      //   693: goto -106 -> 587
      //   696: aload 5
      //   698: instanceof 279
      //   701: ifeq +70 -> 771
      //   704: aload 7
      //   706: invokevirtual 282	com/tencent/mm/plugin/fts/a/a/a:isCancelled	()Z
      //   709: ifne +12 -> 721
      //   712: aload_0
      //   713: getfield 51	com/tencent/mm/plugin/fts/g$a:rmz	Ljava/util/concurrent/PriorityBlockingQueue;
      //   716: aload 7
      //   718: invokevirtual 286	java/util/concurrent/PriorityBlockingQueue:put	(Ljava/lang/Object;)V
      //   721: ldc 87
      //   723: ldc_w 288
      //   726: iconst_3
      //   727: anewarray 106	java/lang/Object
      //   730: dup
      //   731: iconst_0
      //   732: aload 6
      //   734: aastore
      //   735: dup
      //   736: iconst_1
      //   737: aload 7
      //   739: invokevirtual 282	com/tencent/mm/plugin/fts/a/a/a:isCancelled	()Z
      //   742: invokestatic 293	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   745: aastore
      //   746: dup
      //   747: iconst_2
      //   748: aload 7
      //   750: getfield 173	com/tencent/mm/plugin/fts/a/a/a:roF	J
      //   753: invokestatic 215	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   756: aastore
      //   757: invokestatic 296	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   760: invokestatic 137	com/tencent/mm/plugin/fts/a:cwU	()V
      //   763: aload_0
      //   764: aconst_null
      //   765: putfield 139	com/tencent/mm/plugin/fts/g$a:rmB	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   768: goto -756 -> 12
      //   771: aload 5
      //   773: instanceof 298
      //   776: ifeq +32 -> 808
      //   779: ldc 87
      //   781: ldc_w 300
      //   784: invokestatic 100	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   787: goto -27 -> 760
      //   790: astore 5
      //   792: invokestatic 137	com/tencent/mm/plugin/fts/a:cwU	()V
      //   795: aload_0
      //   796: aconst_null
      //   797: putfield 139	com/tencent/mm/plugin/fts/g$a:rmB	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   800: ldc 125
      //   802: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   805: aload 5
      //   807: athrow
      //   808: aload 5
      //   810: instanceof 302
      //   813: ifeq +80 -> 893
      //   816: ldc 87
      //   818: aload 5
      //   820: ldc_w 304
      //   823: iconst_1
      //   824: anewarray 106	java/lang/Object
      //   827: dup
      //   828: iconst_0
      //   829: aload 6
      //   831: aastore
      //   832: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   835: aload_0
      //   836: getfield 55	com/tencent/mm/plugin/fts/g$a:rmE	Z
      //   839: ifne -79 -> 760
      //   842: new 80	java/lang/StringBuilder
      //   845: dup
      //   846: invokespecial 270	java/lang/StringBuilder:<init>	()V
      //   849: aload 7
      //   851: invokevirtual 307	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   854: ldc_w 309
      //   857: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   860: aload 5
      //   862: invokestatic 315	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   865: invokevirtual 91	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   868: invokevirtual 95	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   871: astore 5
      //   873: getstatic 321	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
      //   876: ldc_w 323
      //   879: aload 5
      //   881: aconst_null
      //   882: invokevirtual 327	com/tencent/mm/plugin/report/service/h:e	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
      //   885: aload_0
      //   886: iconst_1
      //   887: putfield 55	com/tencent/mm/plugin/fts/g$a:rmE	Z
      //   890: goto -130 -> 760
      //   893: aload 5
      //   895: instanceof 329
      //   898: ifeq +30 -> 928
      //   901: ldc 87
      //   903: aload 5
      //   905: ldc_w 331
      //   908: iconst_1
      //   909: anewarray 106	java/lang/Object
      //   912: dup
      //   913: iconst_0
      //   914: aload 6
      //   916: aastore
      //   917: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   920: bipush 6
      //   922: invokestatic 334	com/tencent/mm/plugin/fts/a/e:DC	(I)V
      //   925: goto -165 -> 760
      //   928: aload 5
      //   930: instanceof 336
      //   933: ifeq +30 -> 963
      //   936: ldc 87
      //   938: aload 5
      //   940: ldc_w 331
      //   943: iconst_1
      //   944: anewarray 106	java/lang/Object
      //   947: dup
      //   948: iconst_0
      //   949: aload 6
      //   951: aastore
      //   952: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   955: bipush 7
      //   957: invokestatic 334	com/tencent/mm/plugin/fts/a/e:DC	(I)V
      //   960: goto -200 -> 760
      //   963: aload 5
      //   965: instanceof 338
      //   968: ifeq +45 -> 1013
      //   971: ldc 87
      //   973: aload 5
      //   975: ldc_w 331
      //   978: iconst_1
      //   979: anewarray 106	java/lang/Object
      //   982: dup
      //   983: iconst_0
      //   984: aload 6
      //   986: aastore
      //   987: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   990: iconst_3
      //   991: invokestatic 334	com/tencent/mm/plugin/fts/a/e:DC	(I)V
      //   994: aload_0
      //   995: getfield 340	com/tencent/mm/plugin/fts/g$a:rmD	Ljava/lang/Runnable;
      //   998: ifnull -238 -> 760
      //   1001: aload_0
      //   1002: getfield 340	com/tencent/mm/plugin/fts/g$a:rmD	Ljava/lang/Runnable;
      //   1005: invokeinterface 344 1 0
      //   1010: goto -250 -> 760
      //   1013: aload 5
      //   1015: instanceof 346
      //   1018: ifeq +75 -> 1093
      //   1021: ldc 87
      //   1023: aload 5
      //   1025: ldc_w 331
      //   1028: iconst_1
      //   1029: anewarray 106	java/lang/Object
      //   1032: dup
      //   1033: iconst_0
      //   1034: aload 6
      //   1036: aastore
      //   1037: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1040: aload 5
      //   1042: invokevirtual 349	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1045: ifnull +41 -> 1086
      //   1048: aload 5
      //   1050: invokevirtual 349	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1053: ldc_w 351
      //   1056: invokevirtual 355	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   1059: ifeq +27 -> 1086
      //   1062: bipush 17
      //   1064: invokestatic 334	com/tencent/mm/plugin/fts/a/e:DC	(I)V
      //   1067: aload_0
      //   1068: getfield 340	com/tencent/mm/plugin/fts/g$a:rmD	Ljava/lang/Runnable;
      //   1071: ifnull -311 -> 760
      //   1074: aload_0
      //   1075: getfield 340	com/tencent/mm/plugin/fts/g$a:rmD	Ljava/lang/Runnable;
      //   1078: invokeinterface 344 1 0
      //   1083: goto -323 -> 760
      //   1086: iconst_4
      //   1087: invokestatic 334	com/tencent/mm/plugin/fts/a/e:DC	(I)V
      //   1090: goto -23 -> 1067
      //   1093: ldc 87
      //   1095: aload 5
      //   1097: ldc_w 331
      //   1100: iconst_1
      //   1101: anewarray 106	java/lang/Object
      //   1104: dup
      //   1105: iconst_0
      //   1106: aload 6
      //   1108: aastore
      //   1109: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1112: iconst_5
      //   1113: invokestatic 334	com/tencent/mm/plugin/fts/a/e:DC	(I)V
      //   1116: aload_0
      //   1117: getfield 340	com/tencent/mm/plugin/fts/g$a:rmD	Ljava/lang/Runnable;
      //   1120: ifnull -360 -> 760
      //   1123: aload_0
      //   1124: getfield 340	com/tencent/mm/plugin/fts/g$a:rmD	Ljava/lang/Runnable;
      //   1127: invokeinterface 344 1 0
      //   1132: goto -372 -> 760
      //   1135: astore 5
      //   1137: aconst_null
      //   1138: astore 6
      //   1140: aconst_null
      //   1141: astore 7
      //   1143: goto -630 -> 513
      //   1146: astore 8
      //   1148: aconst_null
      //   1149: astore 6
      //   1151: aload 5
      //   1153: astore 7
      //   1155: aload 8
      //   1157: astore 5
      //   1159: goto -646 -> 513
      //   1162: astore 8
      //   1164: aload 5
      //   1166: astore 7
      //   1168: aload 8
      //   1170: astore 5
      //   1172: goto -659 -> 513
      //   1175: goto -552 -> 623
      //   1178: goto -1060 -> 118
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1181	0	this	a
      //   183	381	1	i	int
      //   20	2	2	bool	boolean
      //   121	364	3	l	long
      //   59	713	5	localObject1	Object
      //   790	71	5	localThrowable	java.lang.Throwable
      //   871	225	5	str1	java.lang.String
      //   1135	17	5	localException1	java.lang.Exception
      //   1157	14	5	localObject2	Object
      //   97	1053	6	localObject3	Object
      //   112	183	7	str2	java.lang.String
      //   467	8	7	localException2	java.lang.Exception
      //   477	24	7	localObject4	Object
      //   507	660	7	localObject5	Object
      //   245	207	8	localObject6	Object
      //   503	74	8	localException3	java.lang.Exception
      //   585	107	8	localObject7	Object
      //   1146	10	8	localException4	java.lang.Exception
      //   1162	7	8	localException5	java.lang.Exception
      //   388	273	9	localObject8	Object
      //   404	33	10	locala	com.tencent.mm.plugin.fts.a.a.a.a
      // Exception table:
      //   from	to	target	type
      //   122	128	467	java/lang/Exception
      //   122	128	477	finally
      //   469	477	477	finally
      //   118	122	503	java/lang/Exception
      //   128	182	503	java/lang/Exception
      //   188	232	503	java/lang/Exception
      //   232	310	503	java/lang/Exception
      //   310	356	503	java/lang/Exception
      //   358	460	503	java/lang/Exception
      //   479	503	503	java/lang/Exception
      //   534	562	503	java/lang/Exception
      //   567	587	503	java/lang/Exception
      //   587	623	503	java/lang/Exception
      //   623	630	503	java/lang/Exception
      //   634	670	503	java/lang/Exception
      //   670	677	503	java/lang/Exception
      //   12	21	790	finally
      //   44	61	790	finally
      //   77	99	790	finally
      //   99	114	790	finally
      //   118	122	790	finally
      //   128	182	790	finally
      //   188	232	790	finally
      //   232	310	790	finally
      //   310	356	790	finally
      //   358	460	790	finally
      //   479	503	790	finally
      //   534	562	790	finally
      //   567	587	790	finally
      //   587	623	790	finally
      //   623	630	790	finally
      //   634	670	790	finally
      //   670	677	790	finally
      //   696	721	790	finally
      //   721	760	790	finally
      //   771	787	790	finally
      //   808	890	790	finally
      //   893	925	790	finally
      //   928	960	790	finally
      //   963	1010	790	finally
      //   1013	1067	790	finally
      //   1067	1083	790	finally
      //   1086	1090	790	finally
      //   1093	1132	790	finally
      //   12	21	1135	java/lang/Exception
      //   44	61	1135	java/lang/Exception
      //   77	99	1146	java/lang/Exception
      //   99	114	1162	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.g
 * JD-Core Version:    0.7.0.1
 */