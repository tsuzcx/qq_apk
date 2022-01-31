package com.tencent.mm.plugin.fts;

import android.os.Process;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.PriorityBlockingQueue;

public final class g
  implements m
{
  a ktR = new a();
  
  public final a a(int paramInt, a parama)
  {
    a locala;
    if (this.ktR == null) {
      locala = null;
    }
    a locala1;
    do
    {
      do
      {
        return locala;
        parama.mPriority = paramInt;
        locala1 = this.ktR;
        locala = parama;
      } while (locala1.ktU);
      paramInt = parama.getPriority();
      locala1.ktT.put(parama);
      if (locala1.ktV == null)
      {
        locala1.ru(paramInt);
        return parama;
      }
      locala = parama;
    } while (paramInt >= locala1.ktS);
    locala1.interrupt();
    locala1.ru(paramInt);
    return parama;
  }
  
  public final boolean aiS()
  {
    return (this.ktR != null) && (this.ktR.isAlive());
  }
  
  public final void quit()
  {
    if ((this.ktR == null) || (!this.ktR.isAlive())) {
      return;
    }
    this.ktR.quit();
    try
    {
      this.ktR.join();
      label32:
      this.ktR = null;
      y.i("MicroMsg.FTS.FTSTaskDaemon", "***** Search daemon quited.");
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label32;
    }
  }
  
  private final class a
    extends Thread
  {
    int ktS = 2147483647;
    PriorityBlockingQueue<a> ktT = new PriorityBlockingQueue();
    volatile boolean ktU = false;
    a ktV;
    private boolean ktW;
    Runnable ktX;
    e ktY;
    boolean ktZ = false;
    private int mTid = 0;
    
    public a()
    {
      super();
    }
    
    public final void gm(boolean paramBoolean)
    {
      int i = 0;
      label145:
      for (;;)
      {
        try
        {
          boolean bool = this.ktW;
          if (bool == paramBoolean) {
            return;
          }
          this.ktW = paramBoolean;
          if ((this.ktS >= 0) && (isAlive()) && (this.mTid != 0))
          {
            paramBoolean = this.ktW;
            if (paramBoolean) {
              i = 10;
            }
            try
            {
              Process.setThreadPriority(this.mTid, i);
              StringBuilder localStringBuilder = new StringBuilder("*** Switch priority: ");
              if (!this.ktW) {
                break label145;
              }
              String str1 = "foreground";
              y.i("MicroMsg.FTS.FTSTaskDaemon", str1);
            }
            catch (SecurityException localSecurityException)
            {
              y.printErrStackTrace("MicroMsg.FTS.FTSTaskDaemon", localSecurityException, "setLowPriorityMode failed, tid=%d, p=%d", new Object[] { Integer.valueOf(this.mTid), Integer.valueOf(i) });
            }
            continue;
            String str2 = "background";
          }
        }
        finally {}
      }
    }
    
    public final void quit()
    {
      try
      {
        this.ktU = true;
        interrupt();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    final void ru(int paramInt)
    {
      do
      {
        try
        {
          if (this.ktS != paramInt)
          {
            boolean bool = isAlive();
            if (bool) {}
          }
          else
          {
            return;
          }
          if ((paramInt < 0) && (this.ktS >= 0)) {
            Process.setThreadPriority(this.mTid, -8);
          }
          while (paramInt < 0)
          {
            this.ktS = paramInt;
            break;
          }
        }
        finally {}
      } while (this.ktS >= 0);
      if (this.ktW) {}
      for (int i = 10;; i = 0)
      {
        Process.setThreadPriority(this.mTid, i);
        break;
      }
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokestatic 119	android/os/Process:myTid	()I
      //   4: putfield 36	com/tencent/mm/plugin/fts/g$a:mTid	I
      //   7: invokestatic 122	java/lang/Thread:interrupted	()Z
      //   10: pop
      //   11: aload_0
      //   12: getfield 48	com/tencent/mm/plugin/fts/g$a:ktU	Z
      //   15: istore_2
      //   16: iload_2
      //   17: ifeq +17 -> 34
      //   20: invokestatic 127	com/tencent/mm/plugin/fts/a:aVi	()V
      //   23: aload_0
      //   24: aconst_null
      //   25: putfield 129	com/tencent/mm/plugin/fts/g$a:ktV	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   28: aload_0
      //   29: iconst_0
      //   30: putfield 36	com/tencent/mm/plugin/fts/g$a:mTid	I
      //   33: return
      //   34: aload_0
      //   35: aconst_null
      //   36: putfield 129	com/tencent/mm/plugin/fts/g$a:ktV	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   39: aload_0
      //   40: getfield 46	com/tencent/mm/plugin/fts/g$a:ktT	Ljava/util/concurrent/PriorityBlockingQueue;
      //   43: invokevirtual 133	java/util/concurrent/PriorityBlockingQueue:take	()Ljava/lang/Object;
      //   46: checkcast 135	com/tencent/mm/plugin/fts/a/a/a
      //   49: astore 5
      //   51: aload 5
      //   53: ifnonnull +14 -> 67
      //   56: invokestatic 127	com/tencent/mm/plugin/fts/a:aVi	()V
      //   59: aload_0
      //   60: aconst_null
      //   61: putfield 129	com/tencent/mm/plugin/fts/g$a:ktV	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   64: goto -57 -> 7
      //   67: aload_0
      //   68: aload 5
      //   70: putfield 129	com/tencent/mm/plugin/fts/g$a:ktV	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   73: aload_0
      //   74: aload 5
      //   76: invokevirtual 138	com/tencent/mm/plugin/fts/a/a/a:getPriority	()I
      //   79: invokevirtual 140	com/tencent/mm/plugin/fts/g$a:ru	(I)V
      //   82: aload 5
      //   84: invokevirtual 143	com/tencent/mm/plugin/fts/a/a/a:getName	()Ljava/lang/String;
      //   87: astore 6
      //   89: aload 6
      //   91: invokestatic 149	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
      //   94: ifeq +1059 -> 1153
      //   97: aload 5
      //   99: invokevirtual 150	java/lang/Object:toString	()Ljava/lang/String;
      //   102: astore 7
      //   104: aload 7
      //   106: astore 6
      //   108: invokestatic 156	java/lang/System:currentTimeMillis	()J
      //   111: lstore_3
      //   112: aload 5
      //   114: invokevirtual 159	com/tencent/mm/plugin/fts/a/a/a:execute	()Z
      //   117: pop
      //   118: aload 5
      //   120: invokestatic 156	java/lang/System:currentTimeMillis	()J
      //   123: lload_3
      //   124: lsub
      //   125: aload 5
      //   127: getfield 163	com/tencent/mm/plugin/fts/a/a/a:kvY	J
      //   130: ladd
      //   131: putfield 163	com/tencent/mm/plugin/fts/a/a/a:kvY	J
      //   134: aload 5
      //   136: invokevirtual 166	com/tencent/mm/plugin/fts/a/a/a:getId	()I
      //   139: aload 5
      //   141: getfield 163	com/tencent/mm/plugin/fts/a/a/a:kvY	J
      //   144: invokestatic 172	com/tencent/mm/plugin/fts/a/e:y	(IJ)V
      //   147: aload 5
      //   149: invokevirtual 166	com/tencent/mm/plugin/fts/a/a/a:getId	()I
      //   152: aload 5
      //   154: getfield 163	com/tencent/mm/plugin/fts/a/a/a:kvY	J
      //   157: invokestatic 175	com/tencent/mm/plugin/fts/a/e:z	(IJ)V
      //   160: aload 5
      //   162: getfield 178	com/tencent/mm/plugin/fts/a/a/a:kvZ	J
      //   165: lconst_1
      //   166: land
      //   167: lconst_0
      //   168: lcmp
      //   169: ifle +338 -> 507
      //   172: iconst_1
      //   173: istore_1
      //   174: iload_1
      //   175: ifeq +47 -> 222
      //   178: aload 5
      //   180: getfield 163	com/tencent/mm/plugin/fts/a/a/a:kvY	J
      //   183: ldc2_w 179
      //   186: lcmp
      //   187: ifle +35 -> 222
      //   190: aload 5
      //   192: getfield 163	com/tencent/mm/plugin/fts/a/a/a:kvY	J
      //   195: ldc2_w 181
      //   198: lcmp
      //   199: ifge +23 -> 222
      //   202: bipush 27
      //   204: aload 5
      //   206: getfield 163	com/tencent/mm/plugin/fts/a/a/a:kvY	J
      //   209: invokestatic 172	com/tencent/mm/plugin/fts/a/e:y	(IJ)V
      //   212: bipush 27
      //   214: aload 5
      //   216: getfield 163	com/tencent/mm/plugin/fts/a/a/a:kvY	J
      //   219: invokestatic 175	com/tencent/mm/plugin/fts/a/e:z	(IJ)V
      //   222: aload 5
      //   224: instanceof 184
      //   227: ifeq +285 -> 512
      //   230: aload 5
      //   232: checkcast 184	com/tencent/mm/plugin/fts/a/a/h
      //   235: astore 8
      //   237: ldc 186
      //   239: iconst_4
      //   240: anewarray 94	java/lang/Object
      //   243: dup
      //   244: iconst_0
      //   245: aload 6
      //   247: aastore
      //   248: dup
      //   249: iconst_1
      //   250: aload 8
      //   252: getfield 190	com/tencent/mm/plugin/fts/a/a/h:kwT	Lcom/tencent/mm/plugin/fts/a/a/i;
      //   255: invokevirtual 193	com/tencent/mm/plugin/fts/a/a/i:toString	()Ljava/lang/String;
      //   258: aastore
      //   259: dup
      //   260: iconst_2
      //   261: aload 8
      //   263: getfield 197	com/tencent/mm/plugin/fts/a/a/h:kwU	Lcom/tencent/mm/plugin/fts/a/a/j;
      //   266: invokevirtual 200	com/tencent/mm/plugin/fts/a/a/j:toString	()Ljava/lang/String;
      //   269: aastore
      //   270: dup
      //   271: iconst_3
      //   272: aload 5
      //   274: getfield 163	com/tencent/mm/plugin/fts/a/a/a:kvY	J
      //   277: invokestatic 205	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   280: aastore
      //   281: invokestatic 211	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   284: astore 7
      //   286: aload 8
      //   288: getfield 197	com/tencent/mm/plugin/fts/a/a/h:kwU	Lcom/tencent/mm/plugin/fts/a/a/j;
      //   291: getfield 215	com/tencent/mm/plugin/fts/a/a/j:kxh	Ljava/util/List;
      //   294: invokeinterface 220 1 0
      //   299: istore_1
      //   300: aload 5
      //   302: invokevirtual 166	com/tencent/mm/plugin/fts/a/a/a:getId	()I
      //   305: aload 5
      //   307: getfield 163	com/tencent/mm/plugin/fts/a/a/a:kvY	J
      //   310: iload_1
      //   311: i2l
      //   312: invokestatic 224	com/tencent/mm/plugin/fts/a/e:g	(IJJ)V
      //   315: aload 5
      //   317: getfield 227	com/tencent/mm/plugin/fts/a/a/a:kwa	Ljava/util/List;
      //   320: ifnull +346 -> 666
      //   323: aload 5
      //   325: getfield 227	com/tencent/mm/plugin/fts/a/a/a:kwa	Ljava/util/List;
      //   328: invokeinterface 220 1 0
      //   333: iconst_1
      //   334: if_icmple +332 -> 666
      //   337: new 229	java/lang/StringBuffer
      //   340: dup
      //   341: invokespecial 230	java/lang/StringBuffer:<init>	()V
      //   344: astore 8
      //   346: iconst_1
      //   347: istore_1
      //   348: iload_1
      //   349: aload 5
      //   351: getfield 227	com/tencent/mm/plugin/fts/a/a/a:kwa	Ljava/util/List;
      //   354: invokeinterface 220 1 0
      //   359: if_icmpge +186 -> 545
      //   362: aload 5
      //   364: getfield 227	com/tencent/mm/plugin/fts/a/a/a:kwa	Ljava/util/List;
      //   367: iload_1
      //   368: iconst_1
      //   369: isub
      //   370: invokeinterface 234 2 0
      //   375: checkcast 236	com/tencent/mm/plugin/fts/a/a/a$a
      //   378: astore 9
      //   380: aload 5
      //   382: getfield 227	com/tencent/mm/plugin/fts/a/a/a:kwa	Ljava/util/List;
      //   385: iload_1
      //   386: invokeinterface 234 2 0
      //   391: checkcast 236	com/tencent/mm/plugin/fts/a/a/a$a
      //   394: astore 10
      //   396: aload 8
      //   398: ldc 238
      //   400: invokevirtual 241	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   403: pop
      //   404: aload 8
      //   406: aload 10
      //   408: getfield 245	com/tencent/mm/plugin/fts/a/a/a$a:kwc	Ljava/lang/String;
      //   411: invokevirtual 241	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   414: pop
      //   415: aload 8
      //   417: ldc 247
      //   419: invokevirtual 241	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   422: pop
      //   423: aload 8
      //   425: aload 10
      //   427: getfield 250	com/tencent/mm/plugin/fts/a/a/a$a:timestamp	J
      //   430: aload 9
      //   432: getfield 250	com/tencent/mm/plugin/fts/a/a/a$a:timestamp	J
      //   435: lsub
      //   436: invokevirtual 253	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
      //   439: pop
      //   440: aload 8
      //   442: ldc 255
      //   444: invokevirtual 241	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
      //   447: pop
      //   448: iload_1
      //   449: iconst_1
      //   450: iadd
      //   451: istore_1
      //   452: goto -104 -> 348
      //   455: astore 7
      //   457: aload 7
      //   459: athrow
      //   460: astore 7
      //   462: aload 5
      //   464: invokestatic 156	java/lang/System:currentTimeMillis	()J
      //   467: lload_3
      //   468: lsub
      //   469: aload 5
      //   471: getfield 163	com/tencent/mm/plugin/fts/a/a/a:kvY	J
      //   474: ladd
      //   475: putfield 163	com/tencent/mm/plugin/fts/a/a/a:kvY	J
      //   478: aload 7
      //   480: athrow
      //   481: astore 8
      //   483: aload 5
      //   485: astore 7
      //   487: aload 8
      //   489: astore 5
      //   491: aload 7
      //   493: ifnonnull +181 -> 674
      //   496: invokestatic 127	com/tencent/mm/plugin/fts/a:aVi	()V
      //   499: aload_0
      //   500: aconst_null
      //   501: putfield 129	com/tencent/mm/plugin/fts/g$a:ktV	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   504: goto -497 -> 7
      //   507: iconst_0
      //   508: istore_1
      //   509: goto -335 -> 174
      //   512: ldc_w 257
      //   515: iconst_2
      //   516: anewarray 94	java/lang/Object
      //   519: dup
      //   520: iconst_0
      //   521: aload 6
      //   523: aastore
      //   524: dup
      //   525: iconst_1
      //   526: aload 5
      //   528: getfield 163	com/tencent/mm/plugin/fts/a/a/a:kvY	J
      //   531: invokestatic 205	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   534: aastore
      //   535: invokestatic 211	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   538: astore 7
      //   540: iconst_0
      //   541: istore_1
      //   542: goto -242 -> 300
      //   545: ldc_w 259
      //   548: iconst_1
      //   549: anewarray 94	java/lang/Object
      //   552: dup
      //   553: iconst_0
      //   554: aload 8
      //   556: invokevirtual 260	java/lang/StringBuffer:toString	()Ljava/lang/String;
      //   559: aastore
      //   560: invokestatic 211	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   563: astore 8
      //   565: aload 8
      //   567: invokestatic 149	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
      //   570: ifne +580 -> 1150
      //   573: new 69	java/lang/StringBuilder
      //   576: dup
      //   577: invokespecial 261	java/lang/StringBuilder:<init>	()V
      //   580: aload 7
      //   582: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   585: ldc_w 263
      //   588: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   591: aload 8
      //   593: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   596: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   599: astore 7
      //   601: aload 5
      //   603: invokevirtual 266	com/tencent/mm/plugin/fts/a/a/a:afJ	()Ljava/lang/String;
      //   606: astore 9
      //   608: aload 7
      //   610: astore 8
      //   612: aload 9
      //   614: invokestatic 149	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
      //   617: ifne +31 -> 648
      //   620: new 69	java/lang/StringBuilder
      //   623: dup
      //   624: invokespecial 261	java/lang/StringBuilder:<init>	()V
      //   627: aload 7
      //   629: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   632: ldc_w 263
      //   635: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   638: aload 9
      //   640: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   643: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   646: astore 8
      //   648: ldc 76
      //   650: aload 8
      //   652: invokestatic 90	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   655: invokestatic 127	com/tencent/mm/plugin/fts/a:aVi	()V
      //   658: aload_0
      //   659: aconst_null
      //   660: putfield 129	com/tencent/mm/plugin/fts/g$a:ktV	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   663: goto -656 -> 7
      //   666: ldc_w 268
      //   669: astore 8
      //   671: goto -106 -> 565
      //   674: aload 5
      //   676: instanceof 270
      //   679: ifeq +70 -> 749
      //   682: aload 7
      //   684: invokevirtual 273	com/tencent/mm/plugin/fts/a/a/a:isCancelled	()Z
      //   687: ifne +12 -> 699
      //   690: aload_0
      //   691: getfield 46	com/tencent/mm/plugin/fts/g$a:ktT	Ljava/util/concurrent/PriorityBlockingQueue;
      //   694: aload 7
      //   696: invokevirtual 277	java/util/concurrent/PriorityBlockingQueue:put	(Ljava/lang/Object;)V
      //   699: ldc 76
      //   701: ldc_w 279
      //   704: iconst_3
      //   705: anewarray 94	java/lang/Object
      //   708: dup
      //   709: iconst_0
      //   710: aload 6
      //   712: aastore
      //   713: dup
      //   714: iconst_1
      //   715: aload 7
      //   717: invokevirtual 273	com/tencent/mm/plugin/fts/a/a/a:isCancelled	()Z
      //   720: invokestatic 284	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   723: aastore
      //   724: dup
      //   725: iconst_2
      //   726: aload 7
      //   728: getfield 163	com/tencent/mm/plugin/fts/a/a/a:kvY	J
      //   731: invokestatic 205	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   734: aastore
      //   735: invokestatic 287	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   738: invokestatic 127	com/tencent/mm/plugin/fts/a:aVi	()V
      //   741: aload_0
      //   742: aconst_null
      //   743: putfield 129	com/tencent/mm/plugin/fts/g$a:ktV	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   746: goto -739 -> 7
      //   749: aload 5
      //   751: instanceof 289
      //   754: ifeq +114 -> 868
      //   757: ldc 76
      //   759: aload 5
      //   761: ldc_w 291
      //   764: iconst_1
      //   765: anewarray 94	java/lang/Object
      //   768: dup
      //   769: iconst_0
      //   770: aload 6
      //   772: aastore
      //   773: invokestatic 104	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   776: aload_0
      //   777: getfield 293	com/tencent/mm/plugin/fts/g$a:ktY	Lcom/tencent/mm/plugin/fts/e;
      //   780: ifnull +12 -> 792
      //   783: aload_0
      //   784: getfield 293	com/tencent/mm/plugin/fts/g$a:ktY	Lcom/tencent/mm/plugin/fts/e;
      //   787: invokeinterface 298 1 0
      //   792: bipush 18
      //   794: invokestatic 301	com/tencent/mm/plugin/fts/a/e:rv	(I)V
      //   797: aload_0
      //   798: getfield 50	com/tencent/mm/plugin/fts/g$a:ktZ	Z
      //   801: ifne -63 -> 738
      //   804: new 69	java/lang/StringBuilder
      //   807: dup
      //   808: invokespecial 261	java/lang/StringBuilder:<init>	()V
      //   811: aload 7
      //   813: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   816: ldc_w 306
      //   819: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   822: aload 5
      //   824: invokestatic 312	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   827: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   830: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   833: astore 5
      //   835: getstatic 318	com/tencent/mm/plugin/report/service/h:nFQ	Lcom/tencent/mm/plugin/report/service/h;
      //   838: ldc_w 320
      //   841: aload 5
      //   843: aconst_null
      //   844: invokevirtual 324	com/tencent/mm/plugin/report/service/h:d	(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V
      //   847: aload_0
      //   848: iconst_1
      //   849: putfield 50	com/tencent/mm/plugin/fts/g$a:ktZ	Z
      //   852: goto -114 -> 738
      //   855: astore 5
      //   857: invokestatic 127	com/tencent/mm/plugin/fts/a:aVi	()V
      //   860: aload_0
      //   861: aconst_null
      //   862: putfield 129	com/tencent/mm/plugin/fts/g$a:ktV	Lcom/tencent/mm/plugin/fts/a/a/a;
      //   865: aload 5
      //   867: athrow
      //   868: aload 5
      //   870: instanceof 326
      //   873: ifeq +30 -> 903
      //   876: ldc 76
      //   878: aload 5
      //   880: ldc_w 328
      //   883: iconst_1
      //   884: anewarray 94	java/lang/Object
      //   887: dup
      //   888: iconst_0
      //   889: aload 6
      //   891: aastore
      //   892: invokestatic 104	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   895: bipush 6
      //   897: invokestatic 301	com/tencent/mm/plugin/fts/a/e:rv	(I)V
      //   900: goto -162 -> 738
      //   903: aload 5
      //   905: instanceof 330
      //   908: ifeq +30 -> 938
      //   911: ldc 76
      //   913: aload 5
      //   915: ldc_w 328
      //   918: iconst_1
      //   919: anewarray 94	java/lang/Object
      //   922: dup
      //   923: iconst_0
      //   924: aload 6
      //   926: aastore
      //   927: invokestatic 104	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   930: bipush 7
      //   932: invokestatic 301	com/tencent/mm/plugin/fts/a/e:rv	(I)V
      //   935: goto -197 -> 738
      //   938: aload 5
      //   940: instanceof 332
      //   943: ifeq +45 -> 988
      //   946: ldc 76
      //   948: aload 5
      //   950: ldc_w 328
      //   953: iconst_1
      //   954: anewarray 94	java/lang/Object
      //   957: dup
      //   958: iconst_0
      //   959: aload 6
      //   961: aastore
      //   962: invokestatic 104	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   965: iconst_3
      //   966: invokestatic 301	com/tencent/mm/plugin/fts/a/e:rv	(I)V
      //   969: aload_0
      //   970: getfield 334	com/tencent/mm/plugin/fts/g$a:ktX	Ljava/lang/Runnable;
      //   973: ifnull -235 -> 738
      //   976: aload_0
      //   977: getfield 334	com/tencent/mm/plugin/fts/g$a:ktX	Ljava/lang/Runnable;
      //   980: invokeinterface 338 1 0
      //   985: goto -247 -> 738
      //   988: aload 5
      //   990: instanceof 340
      //   993: ifeq +75 -> 1068
      //   996: ldc 76
      //   998: aload 5
      //   1000: ldc_w 328
      //   1003: iconst_1
      //   1004: anewarray 94	java/lang/Object
      //   1007: dup
      //   1008: iconst_0
      //   1009: aload 6
      //   1011: aastore
      //   1012: invokestatic 104	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1015: aload 5
      //   1017: invokevirtual 343	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1020: ifnull +41 -> 1061
      //   1023: aload 5
      //   1025: invokevirtual 343	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   1028: ldc_w 345
      //   1031: invokevirtual 349	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
      //   1034: ifeq +27 -> 1061
      //   1037: bipush 17
      //   1039: invokestatic 301	com/tencent/mm/plugin/fts/a/e:rv	(I)V
      //   1042: aload_0
      //   1043: getfield 334	com/tencent/mm/plugin/fts/g$a:ktX	Ljava/lang/Runnable;
      //   1046: ifnull -308 -> 738
      //   1049: aload_0
      //   1050: getfield 334	com/tencent/mm/plugin/fts/g$a:ktX	Ljava/lang/Runnable;
      //   1053: invokeinterface 338 1 0
      //   1058: goto -320 -> 738
      //   1061: iconst_4
      //   1062: invokestatic 301	com/tencent/mm/plugin/fts/a/e:rv	(I)V
      //   1065: goto -23 -> 1042
      //   1068: ldc 76
      //   1070: aload 5
      //   1072: ldc_w 328
      //   1075: iconst_1
      //   1076: anewarray 94	java/lang/Object
      //   1079: dup
      //   1080: iconst_0
      //   1081: aload 6
      //   1083: aastore
      //   1084: invokestatic 104	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1087: iconst_5
      //   1088: invokestatic 301	com/tencent/mm/plugin/fts/a/e:rv	(I)V
      //   1091: aload_0
      //   1092: getfield 334	com/tencent/mm/plugin/fts/g$a:ktX	Ljava/lang/Runnable;
      //   1095: ifnull -357 -> 738
      //   1098: aload_0
      //   1099: getfield 334	com/tencent/mm/plugin/fts/g$a:ktX	Ljava/lang/Runnable;
      //   1102: invokeinterface 338 1 0
      //   1107: goto -369 -> 738
      //   1110: astore 5
      //   1112: aconst_null
      //   1113: astore 6
      //   1115: aconst_null
      //   1116: astore 7
      //   1118: goto -627 -> 491
      //   1121: astore 8
      //   1123: aconst_null
      //   1124: astore 6
      //   1126: aload 5
      //   1128: astore 7
      //   1130: aload 8
      //   1132: astore 5
      //   1134: goto -643 -> 491
      //   1137: astore 8
      //   1139: aload 5
      //   1141: astore 7
      //   1143: aload 8
      //   1145: astore 5
      //   1147: goto -656 -> 491
      //   1150: goto -549 -> 601
      //   1153: goto -1045 -> 108
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1156	0	this	a
      //   173	369	1	i	int
      //   15	2	2	bool	boolean
      //   111	357	3	l	long
      //   49	793	5	localObject1	Object
      //   855	216	5	localThrowable	java.lang.Throwable
      //   1110	17	5	localException1	java.lang.Exception
      //   1132	14	5	localObject2	Object
      //   87	1038	6	localObject3	Object
      //   102	183	7	str	String
      //   455	3	7	localException2	java.lang.Exception
      //   460	19	7	localObject4	Object
      //   485	657	7	localObject5	Object
      //   235	206	8	localObject6	Object
      //   481	74	8	localException3	java.lang.Exception
      //   563	107	8	localObject7	Object
      //   1121	10	8	localException4	java.lang.Exception
      //   1137	7	8	localException5	java.lang.Exception
      //   378	261	9	localObject8	Object
      //   394	32	10	locala	com.tencent.mm.plugin.fts.a.a.a.a
      // Exception table:
      //   from	to	target	type
      //   112	118	455	java/lang/Exception
      //   112	118	460	finally
      //   457	460	460	finally
      //   108	112	481	java/lang/Exception
      //   118	172	481	java/lang/Exception
      //   178	222	481	java/lang/Exception
      //   222	300	481	java/lang/Exception
      //   300	346	481	java/lang/Exception
      //   348	448	481	java/lang/Exception
      //   462	481	481	java/lang/Exception
      //   512	540	481	java/lang/Exception
      //   545	565	481	java/lang/Exception
      //   565	601	481	java/lang/Exception
      //   601	608	481	java/lang/Exception
      //   612	648	481	java/lang/Exception
      //   648	655	481	java/lang/Exception
      //   7	16	855	finally
      //   34	51	855	finally
      //   67	89	855	finally
      //   89	104	855	finally
      //   108	112	855	finally
      //   118	172	855	finally
      //   178	222	855	finally
      //   222	300	855	finally
      //   300	346	855	finally
      //   348	448	855	finally
      //   462	481	855	finally
      //   512	540	855	finally
      //   545	565	855	finally
      //   565	601	855	finally
      //   601	608	855	finally
      //   612	648	855	finally
      //   648	655	855	finally
      //   674	699	855	finally
      //   699	738	855	finally
      //   749	792	855	finally
      //   792	852	855	finally
      //   868	900	855	finally
      //   903	935	855	finally
      //   938	985	855	finally
      //   988	1042	855	finally
      //   1042	1058	855	finally
      //   1061	1065	855	finally
      //   1068	1107	855	finally
      //   7	16	1110	java/lang/Exception
      //   34	51	1110	java/lang/Exception
      //   67	89	1121	java/lang/Exception
      //   89	104	1137	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.g
 * JD-Core Version:    0.7.0.1
 */