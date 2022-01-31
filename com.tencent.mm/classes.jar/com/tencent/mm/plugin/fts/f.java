package com.tencent.mm.plugin.fts;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.PriorityBlockingQueue;

public final class f
  implements m
{
  a mPG;
  
  public f()
  {
    AppMethodBeat.i(136575);
    this.mPG = new a();
    AppMethodBeat.o(136575);
  }
  
  public final a a(int paramInt, a parama)
  {
    AppMethodBeat.i(136578);
    if (this.mPG == null)
    {
      AppMethodBeat.o(136578);
      return null;
    }
    parama.mPriority = paramInt;
    a locala = this.mPG;
    if (!locala.mPJ)
    {
      paramInt = parama.getPriority();
      locala.mPI.put(parama);
      if (locala.mPK != null) {
        break label68;
      }
      locala.wo(paramInt);
    }
    for (;;)
    {
      AppMethodBeat.o(136578);
      return parama;
      label68:
      if (paramInt < locala.mPH)
      {
        locala.interrupt();
        locala.wo(paramInt);
      }
    }
  }
  
  public final boolean isStart()
  {
    AppMethodBeat.i(136576);
    if ((this.mPG != null) && (this.mPG.isAlive()))
    {
      AppMethodBeat.o(136576);
      return true;
    }
    AppMethodBeat.o(136576);
    return false;
  }
  
  public final void quit()
  {
    AppMethodBeat.i(136577);
    if ((this.mPG == null) || (!this.mPG.isAlive()))
    {
      AppMethodBeat.o(136577);
      return;
    }
    this.mPG.quit();
    try
    {
      this.mPG.join();
      label42:
      this.mPG = null;
      ab.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon quited.");
      AppMethodBeat.o(136577);
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
    int mPH;
    PriorityBlockingQueue<a> mPI;
    volatile boolean mPJ;
    a mPK;
    private boolean mPL;
    Runnable mPM;
    boolean mPN;
    private int mTid;
    
    public a()
    {
      super();
      AppMethodBeat.i(136570);
      this.mTid = 0;
      this.mPH = 2147483647;
      this.mPI = new PriorityBlockingQueue();
      this.mPJ = false;
      this.mPN = false;
      AppMethodBeat.o(136570);
    }
    
    /* Error */
    public final void hP(boolean paramBoolean)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_2
      //   2: aload_0
      //   3: monitorenter
      //   4: ldc 64
      //   6: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   9: aload_0
      //   10: getfield 66	com/tencent/mm/plugin/fts/f$a:mPL	Z
      //   13: iload_1
      //   14: if_icmpne +11 -> 25
      //   17: ldc 64
      //   19: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   22: aload_0
      //   23: monitorexit
      //   24: return
      //   25: aload_0
      //   26: iload_1
      //   27: putfield 66	com/tencent/mm/plugin/fts/f$a:mPL	Z
      //   30: aload_0
      //   31: getfield 44	com/tencent/mm/plugin/fts/f$a:mPH	I
      //   34: iflt +121 -> 155
      //   37: aload_0
      //   38: invokevirtual 70	com/tencent/mm/plugin/fts/f$a:isAlive	()Z
      //   41: ifeq +114 -> 155
      //   44: aload_0
      //   45: getfield 41	com/tencent/mm/plugin/fts/f$a:mTid	I
      //   48: ifeq +107 -> 155
      //   51: aload_0
      //   52: getfield 66	com/tencent/mm/plugin/fts/f$a:mPL	Z
      //   55: istore_1
      //   56: iload_1
      //   57: ifeq +6 -> 63
      //   60: bipush 10
      //   62: istore_2
      //   63: aload_0
      //   64: getfield 41	com/tencent/mm/plugin/fts/f$a:mTid	I
      //   67: iload_2
      //   68: invokestatic 76	android/os/Process:setThreadPriority	(II)V
      //   71: new 78	java/lang/StringBuilder
      //   74: dup
      //   75: ldc 80
      //   77: invokespecial 81	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   80: astore 4
      //   82: aload_0
      //   83: getfield 66	com/tencent/mm/plugin/fts/f$a:mPL	Z
      //   86: ifeq +33 -> 119
      //   89: ldc 83
      //   91: astore_3
      //   92: ldc 85
      //   94: aload 4
      //   96: aload_3
      //   97: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   100: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   103: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   106: ldc 64
      //   108: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   111: goto -89 -> 22
      //   114: astore_3
      //   115: aload_0
      //   116: monitorexit
      //   117: aload_3
      //   118: athrow
      //   119: ldc 100
      //   121: astore_3
      //   122: goto -30 -> 92
      //   125: astore_3
      //   126: ldc 85
      //   128: aload_3
      //   129: ldc 102
      //   131: iconst_2
      //   132: anewarray 104	java/lang/Object
      //   135: dup
      //   136: iconst_0
      //   137: aload_0
      //   138: getfield 41	com/tencent/mm/plugin/fts/f$a:mTid	I
      //   141: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   144: aastore
      //   145: dup
      //   146: iconst_1
      //   147: iload_2
      //   148: invokestatic 110	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   151: aastore
      //   152: invokestatic 114	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   155: ldc 64
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
        AppMethodBeat.i(136572);
        this.mPJ = true;
        interrupt();
        AppMethodBeat.o(136572);
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
      //   0: ldc 123
      //   2: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: invokestatic 127	android/os/Process:myTid	()I
      //   9: putfield 41	com/tencent/mm/plugin/fts/f$a:mTid	I
      //   12: invokestatic 130	java/lang/Thread:interrupted	()Z
      //   15: pop
      //   16: aload_0
      //   17: getfield 53	com/tencent/mm/plugin/fts/f$a:mPJ	Z
      //   20: istore_2
      //   21: iload_2
      //   22: ifeq +22 -> 44
      //   25: invokestatic 135	com/tencent/mm/plugin/fts/a:bBH	()V
      //   28: aload_0
      //   29: aconst_null
      //   30: putfield 137	com/tencent/mm/plugin/fts/f$a:mPK	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   33: aload_0
      //   34: iconst_0
      //   35: putfield 41	com/tencent/mm/plugin/fts/f$a:mTid	I
      //   38: ldc 123
      //   40: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   43: return
      //   44: aload_0
      //   45: aconst_null
      //   46: putfield 137	com/tencent/mm/plugin/fts/f$a:mPK	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   49: aload_0
      //   50: getfield 51	com/tencent/mm/plugin/fts/f$a:mPI	Ljava/util/concurrent/PriorityBlockingQueue;
      //   53: invokevirtual 141	java/util/concurrent/PriorityBlockingQueue:take	()Ljava/lang/Object;
      //   56: checkcast 143	com/tencent/mm/plugin/fts/a/a/a
      //   59: astore 5
      //   61: aload 5
      //   63: ifnonnull +14 -> 77
      //   66: invokestatic 135	com/tencent/mm/plugin/fts/a:bBH	()V
      //   69: aload_0
      //   70: aconst_null
      //   71: putfield 137	com/tencent/mm/plugin/fts/f$a:mPK	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   74: goto -62 -> 12
      //   77: aload_0
      //   78: aload 5
      //   80: putfield 137	com/tencent/mm/plugin/fts/f$a:mPK	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   83: aload_0
      //   84: aload 5
      //   86: invokevirtual 146	com/tencent/mm/plugin/fts/a/a/a:getPriority	()I
      //   89: invokevirtual 149	com/tencent/mm/plugin/fts/f$a:wo	(I)V
      //   92: aload 5
      //   94: invokevirtual 152	com/tencent/mm/plugin/fts/a/a/a:getName	()Ljava/lang/String;
      //   97: astore 6
      //   99: aload 6
      //   101: invokestatic 158	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
      //   104: ifeq +1054 -> 1158
      //   107: aload 5
      //   109: invokevirtual 159	java/lang/Object:toString	()Ljava/lang/String;
      //   112: astore 7
      //   114: aload 7
      //   116: astore 6
      //   118: invokestatic 165	java/lang/System:currentTimeMillis	()J
      //   121: lstore_3
      //   122: aload 5
      //   124: invokevirtual 168	com/tencent/mm/plugin/fts/a/a/a:execute	()Z
      //   127: pop
      //   128: aload 5
      //   130: invokestatic 165	java/lang/System:currentTimeMillis	()J
      //   133: lload_3
      //   134: lsub
      //   135: aload 5
      //   137: getfield 172	com/tencent/mm/plugin/fts/a/a/a:mRN	J
      //   140: ladd
      //   141: putfield 172	com/tencent/mm/plugin/fts/a/a/a:mRN	J
      //   144: aload 5
      //   146: invokevirtual 175	com/tencent/mm/plugin/fts/a/a/a:getId	()I
      //   149: aload 5
      //   151: getfield 172	com/tencent/mm/plugin/fts/a/a/a:mRN	J
      //   154: invokestatic 181	com/tencent/mm/plugin/fts/a/e:P	(IJ)V
      //   157: aload 5
      //   159: invokevirtual 175	com/tencent/mm/plugin/fts/a/a/a:getId	()I
      //   162: aload 5
      //   164: getfield 172	com/tencent/mm/plugin/fts/a/a/a:mRN	J
      //   167: invokestatic 184	com/tencent/mm/plugin/fts/a/e:Q	(IJ)V
      //   170: aload 5
      //   172: getfield 187	com/tencent/mm/plugin/fts/a/a/a:mRO	J
      //   175: lconst_1
      //   176: land
      //   177: lconst_0
      //   178: lcmp
      //   179: ifle +349 -> 528
      //   182: iconst_1
      //   183: istore_1
      //   184: iload_1
      //   185: ifeq +47 -> 232
      //   188: aload 5
      //   190: getfield 172	com/tencent/mm/plugin/fts/a/a/a:mRN	J
      //   193: ldc2_w 188
      //   196: lcmp
      //   197: ifle +35 -> 232
      //   200: aload 5
      //   202: getfield 172	com/tencent/mm/plugin/fts/a/a/a:mRN	J
      //   205: ldc2_w 190
      //   208: lcmp
      //   209: ifge +23 -> 232
      //   212: bipush 27
      //   214: aload 5
      //   216: getfield 172	com/tencent/mm/plugin/fts/a/a/a:mRN	J
      //   219: invokestatic 181	com/tencent/mm/plugin/fts/a/e:P	(IJ)V
      //   222: bipush 27
      //   224: aload 5
      //   226: getfield 172	com/tencent/mm/plugin/fts/a/a/a:mRN	J
      //   229: invokestatic 184	com/tencent/mm/plugin/fts/a/e:Q	(IJ)V
      //   232: aload 5
      //   234: instanceof 193
      //   237: ifeq +296 -> 533
      //   240: aload 5
      //   242: checkcast 193	com/tencent/mm/plugin/fts/a/a/h
      //   245: astore 8
      //   247: ldc 195
      //   249: iconst_4
      //   250: anewarray 104	java/lang/Object
      //   253: dup
      //   254: iconst_0
      //   255: aload 6
      //   257: aastore
      //   258: dup
      //   259: iconst_1
      //   260: aload 8
      //   262: getfield 199	com/tencent/mm/plugin/fts/a/a/h:mSJ	Lcom/tencent/mm/plugin/fts/a/a/i;
      //   265: invokevirtual 202	com/tencent/mm/plugin/fts/a/a/i:toString	()Ljava/lang/String;
      //   268: aastore
      //   269: dup
      //   270: iconst_2
      //   271: aload 8
      //   273: getfield 206	com/tencent/mm/plugin/fts/a/a/h:mSK	Lcom/tencent/mm/plugin/fts/a/a/j;
      //   276: invokevirtual 209	com/tencent/mm/plugin/fts/a/a/j:toString	()Ljava/lang/String;
      //   279: aastore
      //   280: dup
      //   281: iconst_3
      //   282: aload 5
      //   284: getfield 172	com/tencent/mm/plugin/fts/a/a/a:mRN	J
      //   287: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   290: aastore
      //   291: invokestatic 220	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   294: astore 7
      //   296: aload 8
      //   298: getfield 206	com/tencent/mm/plugin/fts/a/a/h:mSK	Lcom/tencent/mm/plugin/fts/a/a/j;
      //   301: getfield 224	com/tencent/mm/plugin/fts/a/a/j:mSW	Ljava/util/List;
      //   304: invokeinterface 229 1 0
      //   309: istore_1
      //   310: aload 5
      //   312: invokevirtual 175	com/tencent/mm/plugin/fts/a/a/a:getId	()I
      //   315: aload 5
      //   317: getfield 172	com/tencent/mm/plugin/fts/a/a/a:mRN	J
      //   320: iload_1
      //   321: i2l
      //   322: invokestatic 232	com/tencent/mm/plugin/fts/a/e:i	(IJJ)V
      //   325: aload 5
      //   327: getfield 235	com/tencent/mm/plugin/fts/a/a/a:mRP	Ljava/util/List;
      //   330: ifnull +357 -> 687
      //   333: aload 5
      //   335: getfield 235	com/tencent/mm/plugin/fts/a/a/a:mRP	Ljava/util/List;
      //   338: invokeinterface 229 1 0
      //   343: iconst_1
      //   344: if_icmple +343 -> 687
      //   347: new 237	java/lang/StringBuffer
      //   350: dup
      //   351: invokespecial 238	java/lang/StringBuffer:<init>	()V
      //   354: astore 8
      //   356: iconst_1
      //   357: istore_1
      //   358: iload_1
      //   359: aload 5
      //   361: getfield 235	com/tencent/mm/plugin/fts/a/a/a:mRP	Ljava/util/List;
      //   364: invokeinterface 229 1 0
      //   369: if_icmpge +197 -> 566
      //   372: aload 5
      //   374: getfield 235	com/tencent/mm/plugin/fts/a/a/a:mRP	Ljava/util/List;
      //   377: iload_1
      //   378: iconst_1
      //   379: isub
      //   380: invokeinterface 242 2 0
      //   385: checkcast 244	com/tencent/mm/plugin/fts/a/a/a$a
      //   388: astore 9
      //   390: aload 5
      //   392: getfield 235	com/tencent/mm/plugin/fts/a/a/a:mRP	Ljava/util/List;
      //   395: iload_1
      //   396: invokeinterface 242 2 0
      //   401: checkcast 244	com/tencent/mm/plugin/fts/a/a/a$a
      //   404: astore 10
      //   406: aload 8
      //   408: ldc 246
      //   410: invokevirtual 249	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   413: pop
      //   414: aload 8
      //   416: aload 10
      //   418: getfield 253	com/tencent/mm/plugin/fts/a/a/a$a:mRR	Ljava/lang/String;
      //   421: invokevirtual 249	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   424: pop
      //   425: aload 8
      //   427: ldc 255
      //   429: invokevirtual 249	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   432: pop
      //   433: aload 8
      //   435: aload 10
      //   437: getfield 258	com/tencent/mm/plugin/fts/a/a/a$a:timestamp	J
      //   440: aload 9
      //   442: getfield 258	com/tencent/mm/plugin/fts/a/a/a$a:timestamp	J
      //   445: lsub
      //   446: invokevirtual 261	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
      //   449: pop
      //   450: aload 8
      //   452: ldc_w 263
      //   455: invokevirtual 249	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   458: pop
      //   459: iload_1
      //   460: iconst_1
      //   461: iadd
      //   462: istore_1
      //   463: goto -105 -> 358
      //   466: astore 7
      //   468: ldc 123
      //   470: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   473: aload 7
      //   475: athrow
      //   476: astore 7
      //   478: aload 5
      //   480: invokestatic 165	java/lang/System:currentTimeMillis	()J
      //   483: lload_3
      //   484: lsub
      //   485: aload 5
      //   487: getfield 172	com/tencent/mm/plugin/fts/a/a/a:mRN	J
      //   490: ladd
      //   491: putfield 172	com/tencent/mm/plugin/fts/a/a/a:mRN	J
      //   494: ldc 123
      //   496: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   499: aload 7
      //   501: athrow
      //   502: astore 8
      //   504: aload 5
      //   506: astore 7
      //   508: aload 8
      //   510: astore 5
      //   512: aload 7
      //   514: ifnonnull +181 -> 695
      //   517: invokestatic 135	com/tencent/mm/plugin/fts/a:bBH	()V
      //   520: aload_0
      //   521: aconst_null
      //   522: putfield 137	com/tencent/mm/plugin/fts/f$a:mPK	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   525: goto -513 -> 12
      //   528: iconst_0
      //   529: istore_1
      //   530: goto -346 -> 184
      //   533: ldc_w 265
      //   536: iconst_2
      //   537: anewarray 104	java/lang/Object
      //   540: dup
      //   541: iconst_0
      //   542: aload 6
      //   544: aastore
      //   545: dup
      //   546: iconst_1
      //   547: aload 5
      //   549: getfield 172	com/tencent/mm/plugin/fts/a/a/a:mRN	J
      //   552: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   555: aastore
      //   556: invokestatic 220	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   559: astore 7
      //   561: iconst_0
      //   562: istore_1
      //   563: goto -253 -> 310
      //   566: ldc_w 267
      //   569: iconst_1
      //   570: anewarray 104	java/lang/Object
      //   573: dup
      //   574: iconst_0
      //   575: aload 8
      //   577: invokevirtual 268	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   580: aastore
      //   581: invokestatic 220	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   584: astore 8
      //   586: aload 8
      //   588: invokestatic 158	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
      //   591: ifne +564 -> 1155
      //   594: new 78	java/lang/StringBuilder
      //   597: dup
      //   598: invokespecial 269	java/lang/StringBuilder:<init>	()V
      //   601: aload 7
      //   603: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   606: ldc_w 271
      //   609: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   612: aload 8
      //   614: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   617: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   620: astore 7
      //   622: aload 5
      //   624: invokevirtual 274	com/tencent/mm/plugin/fts/a/a/a:aAn	()Ljava/lang/String;
      //   627: astore 9
      //   629: aload 7
      //   631: astore 8
      //   633: aload 9
      //   635: invokestatic 158	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
      //   638: ifne +31 -> 669
      //   641: new 78	java/lang/StringBuilder
      //   644: dup
      //   645: invokespecial 269	java/lang/StringBuilder:<init>	()V
      //   648: aload 7
      //   650: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   653: ldc_w 271
      //   656: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   659: aload 9
      //   661: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   664: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   667: astore 8
      //   669: ldc 85
      //   671: aload 8
      //   673: invokestatic 98	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   676: invokestatic 135	com/tencent/mm/plugin/fts/a:bBH	()V
      //   679: aload_0
      //   680: aconst_null
      //   681: putfield 137	com/tencent/mm/plugin/fts/f$a:mPK	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   684: goto -672 -> 12
      //   687: ldc_w 276
      //   690: astore 8
      //   692: goto -106 -> 586
      //   695: aload 5
      //   697: instanceof 278
      //   700: ifeq +70 -> 770
      //   703: aload 7
      //   705: invokevirtual 281	com/tencent/mm/plugin/fts/a/a/a:isCancelled	()Z
      //   708: ifne +12 -> 720
      //   711: aload_0
      //   712: getfield 51	com/tencent/mm/plugin/fts/f$a:mPI	Ljava/util/concurrent/PriorityBlockingQueue;
      //   715: aload 7
      //   717: invokevirtual 285	java/util/concurrent/PriorityBlockingQueue:put	(Ljava/lang/Object;)V
      //   720: ldc 85
      //   722: ldc_w 287
      //   725: iconst_3
      //   726: anewarray 104	java/lang/Object
      //   729: dup
      //   730: iconst_0
      //   731: aload 6
      //   733: aastore
      //   734: dup
      //   735: iconst_1
      //   736: aload 7
      //   738: invokevirtual 281	com/tencent/mm/plugin/fts/a/a/a:isCancelled	()Z
      //   741: invokestatic 292	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   744: aastore
      //   745: dup
      //   746: iconst_2
      //   747: aload 7
      //   749: getfield 172	com/tencent/mm/plugin/fts/a/a/a:mRN	J
      //   752: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   755: aastore
      //   756: invokestatic 295	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   759: invokestatic 135	com/tencent/mm/plugin/fts/a:bBH	()V
      //   762: aload_0
      //   763: aconst_null
      //   764: putfield 137	com/tencent/mm/plugin/fts/f$a:mPK	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   767: goto -755 -> 12
      //   770: aload 5
      //   772: instanceof 297
      //   775: ifeq +98 -> 873
      //   778: ldc 85
      //   780: aload 5
      //   782: ldc_w 299
      //   785: iconst_1
      //   786: anewarray 104	java/lang/Object
      //   789: dup
      //   790: iconst_0
      //   791: aload 6
      //   793: aastore
      //   794: invokestatic 114	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   797: aload_0
      //   798: getfield 55	com/tencent/mm/plugin/fts/f$a:mPN	Z
      //   801: ifne -42 -> 759
      //   804: new 78	java/lang/StringBuilder
      //   807: dup
      //   808: invokespecial 269	java/lang/StringBuilder:<init>	()V
      //   811: aload 7
      //   813: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   816: ldc_w 304
      //   819: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   822: aload 5
      //   824: invokestatic 310	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   827: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   830: invokevirtual 93	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   833: astore 5
      //   835: getstatic 316	com/tencent/mm/plugin/report/service/h:qsU	Lcom/tencent/mm/plugin/report/service/h;
      //   838: ldc_w 318
      //   841: aload 5
      //   843: aconst_null
      //   844: invokevirtual 322	com/tencent/mm/plugin/report/service/h:g	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
      //   847: aload_0
      //   848: iconst_1
      //   849: putfield 55	com/tencent/mm/plugin/fts/f$a:mPN	Z
      //   852: goto -93 -> 759
      //   855: astore 5
      //   857: invokestatic 135	com/tencent/mm/plugin/fts/a:bBH	()V
      //   860: aload_0
      //   861: aconst_null
      //   862: putfield 137	com/tencent/mm/plugin/fts/f$a:mPK	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   865: ldc 123
      //   867: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   870: aload 5
      //   872: athrow
      //   873: aload 5
      //   875: instanceof 324
      //   878: ifeq +30 -> 908
      //   881: ldc 85
      //   883: aload 5
      //   885: ldc_w 326
      //   888: iconst_1
      //   889: anewarray 104	java/lang/Object
      //   892: dup
      //   893: iconst_0
      //   894: aload 6
      //   896: aastore
      //   897: invokestatic 114	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   900: bipush 6
      //   902: invokestatic 329	com/tencent/mm/plugin/fts/a/e:wq	(I)V
      //   905: goto -146 -> 759
      //   908: aload 5
      //   910: instanceof 331
      //   913: ifeq +30 -> 943
      //   916: ldc 85
      //   918: aload 5
      //   920: ldc_w 326
      //   923: iconst_1
      //   924: anewarray 104	java/lang/Object
      //   927: dup
      //   928: iconst_0
      //   929: aload 6
      //   931: aastore
      //   932: invokestatic 114	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   935: bipush 7
      //   937: invokestatic 329	com/tencent/mm/plugin/fts/a/e:wq	(I)V
      //   940: goto -181 -> 759
      //   943: aload 5
      //   945: instanceof 333
      //   948: ifeq +45 -> 993
      //   951: ldc 85
      //   953: aload 5
      //   955: ldc_w 326
      //   958: iconst_1
      //   959: anewarray 104	java/lang/Object
      //   962: dup
      //   963: iconst_0
      //   964: aload 6
      //   966: aastore
      //   967: invokestatic 114	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   970: iconst_3
      //   971: invokestatic 329	com/tencent/mm/plugin/fts/a/e:wq	(I)V
      //   974: aload_0
      //   975: getfield 335	com/tencent/mm/plugin/fts/f$a:mPM	Ljava/lang/Runnable;
      //   978: ifnull -219 -> 759
      //   981: aload_0
      //   982: getfield 335	com/tencent/mm/plugin/fts/f$a:mPM	Ljava/lang/Runnable;
      //   985: invokeinterface 339 1 0
      //   990: goto -231 -> 759
      //   993: aload 5
      //   995: instanceof 341
      //   998: ifeq +75 -> 1073
      //   1001: ldc 85
      //   1003: aload 5
      //   1005: ldc_w 326
      //   1008: iconst_1
      //   1009: anewarray 104	java/lang/Object
      //   1012: dup
      //   1013: iconst_0
      //   1014: aload 6
      //   1016: aastore
      //   1017: invokestatic 114	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1020: aload 5
      //   1022: invokevirtual 344	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1025: ifnull +41 -> 1066
      //   1028: aload 5
      //   1030: invokevirtual 344	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1033: ldc_w 346
      //   1036: invokevirtual 350	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   1039: ifeq +27 -> 1066
      //   1042: bipush 17
      //   1044: invokestatic 329	com/tencent/mm/plugin/fts/a/e:wq	(I)V
      //   1047: aload_0
      //   1048: getfield 335	com/tencent/mm/plugin/fts/f$a:mPM	Ljava/lang/Runnable;
      //   1051: ifnull -292 -> 759
      //   1054: aload_0
      //   1055: getfield 335	com/tencent/mm/plugin/fts/f$a:mPM	Ljava/lang/Runnable;
      //   1058: invokeinterface 339 1 0
      //   1063: goto -304 -> 759
      //   1066: iconst_4
      //   1067: invokestatic 329	com/tencent/mm/plugin/fts/a/e:wq	(I)V
      //   1070: goto -23 -> 1047
      //   1073: ldc 85
      //   1075: aload 5
      //   1077: ldc_w 326
      //   1080: iconst_1
      //   1081: anewarray 104	java/lang/Object
      //   1084: dup
      //   1085: iconst_0
      //   1086: aload 6
      //   1088: aastore
      //   1089: invokestatic 114	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1092: iconst_5
      //   1093: invokestatic 329	com/tencent/mm/plugin/fts/a/e:wq	(I)V
      //   1096: aload_0
      //   1097: getfield 335	com/tencent/mm/plugin/fts/f$a:mPM	Ljava/lang/Runnable;
      //   1100: ifnull -341 -> 759
      //   1103: aload_0
      //   1104: getfield 335	com/tencent/mm/plugin/fts/f$a:mPM	Ljava/lang/Runnable;
      //   1107: invokeinterface 339 1 0
      //   1112: goto -353 -> 759
      //   1115: astore 5
      //   1117: aconst_null
      //   1118: astore 6
      //   1120: aconst_null
      //   1121: astore 7
      //   1123: goto -611 -> 512
      //   1126: astore 8
      //   1128: aconst_null
      //   1129: astore 6
      //   1131: aload 5
      //   1133: astore 7
      //   1135: aload 8
      //   1137: astore 5
      //   1139: goto -627 -> 512
      //   1142: astore 8
      //   1144: aload 5
      //   1146: astore 7
      //   1148: aload 8
      //   1150: astore 5
      //   1152: goto -640 -> 512
      //   1155: goto -533 -> 622
      //   1158: goto -1040 -> 118
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1161	0	this	a
      //   183	380	1	i	int
      //   20	2	2	bool	boolean
      //   121	363	3	l	long
      //   59	783	5	localObject1	Object
      //   855	221	5	localThrowable	java.lang.Throwable
      //   1115	17	5	localException1	java.lang.Exception
      //   1137	14	5	localObject2	Object
      //   97	1033	6	localObject3	Object
      //   112	183	7	str	java.lang.String
      //   466	8	7	localException2	java.lang.Exception
      //   476	24	7	localObject4	Object
      //   506	641	7	localObject5	Object
      //   245	206	8	localObject6	Object
      //   502	74	8	localException3	java.lang.Exception
      //   584	107	8	localObject7	Object
      //   1126	10	8	localException4	java.lang.Exception
      //   1142	7	8	localException5	java.lang.Exception
      //   388	272	9	localObject8	Object
      //   404	32	10	locala	com.tencent.mm.plugin.fts.a.a.a.a
      // Exception table:
      //   from	to	target	type
      //   122	128	466	java/lang/Exception
      //   122	128	476	finally
      //   468	476	476	finally
      //   118	122	502	java/lang/Exception
      //   128	182	502	java/lang/Exception
      //   188	232	502	java/lang/Exception
      //   232	310	502	java/lang/Exception
      //   310	356	502	java/lang/Exception
      //   358	459	502	java/lang/Exception
      //   478	502	502	java/lang/Exception
      //   533	561	502	java/lang/Exception
      //   566	586	502	java/lang/Exception
      //   586	622	502	java/lang/Exception
      //   622	629	502	java/lang/Exception
      //   633	669	502	java/lang/Exception
      //   669	676	502	java/lang/Exception
      //   12	21	855	finally
      //   44	61	855	finally
      //   77	99	855	finally
      //   99	114	855	finally
      //   118	122	855	finally
      //   128	182	855	finally
      //   188	232	855	finally
      //   232	310	855	finally
      //   310	356	855	finally
      //   358	459	855	finally
      //   478	502	855	finally
      //   533	561	855	finally
      //   566	586	855	finally
      //   586	622	855	finally
      //   622	629	855	finally
      //   633	669	855	finally
      //   669	676	855	finally
      //   695	720	855	finally
      //   720	759	855	finally
      //   770	852	855	finally
      //   873	905	855	finally
      //   908	940	855	finally
      //   943	990	855	finally
      //   993	1047	855	finally
      //   1047	1063	855	finally
      //   1066	1070	855	finally
      //   1073	1112	855	finally
      //   12	21	1115	java/lang/Exception
      //   44	61	1115	java/lang/Exception
      //   77	99	1126	java/lang/Exception
      //   99	114	1142	java/lang/Exception
    }
    
    final void wo(int paramInt)
    {
      do
      {
        try
        {
          AppMethodBeat.i(136571);
          if ((this.mPH == paramInt) || (!isAlive()))
          {
            AppMethodBeat.o(136571);
            return;
          }
          if ((paramInt < 0) && (this.mPH >= 0)) {
            Process.setThreadPriority(this.mTid, -8);
          }
          while (paramInt < 0)
          {
            this.mPH = paramInt;
            AppMethodBeat.o(136571);
            break;
          }
        }
        finally {}
      } while (this.mPH >= 0);
      if (this.mPL) {}
      for (int i = 10;; i = 0)
      {
        Process.setThreadPriority(this.mTid, i);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.f
 * JD-Core Version:    0.7.0.1
 */