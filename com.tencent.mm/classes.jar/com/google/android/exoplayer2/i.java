package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.g.g.a;
import com.google.android.exoplayer2.i.o;
import com.google.android.exoplayer2.source.e.a;
import com.google.android.exoplayer2.source.f.a;
import com.google.android.exoplayer2.source.f.b;

final class i
  implements Handler.Callback, g.a, e.a, f.a
{
  private final s[] atB;
  private final m atC;
  private final o atD;
  private final HandlerThread atE;
  private final f atF;
  private final n atG;
  private r atH;
  private com.google.android.exoplayer2.i.f atI;
  private com.google.android.exoplayer2.source.f atJ;
  private r[] atK;
  private boolean atL;
  int atM;
  private int atN;
  private long atO;
  private int atP;
  private i.c atQ;
  private long atR;
  private i.a atS;
  private i.a atT;
  private i.a atU;
  private final r[] atf;
  private final g atg;
  private final w.b atk;
  private final w.a atl;
  private boolean atn;
  private w atr;
  private p atv;
  private i.b atw;
  private final Handler eventHandler;
  final Handler handler;
  private boolean isLoading;
  boolean released;
  private int repeatMode;
  private int state;
  
  public i(r[] paramArrayOfr, g paramg, m paramm, boolean paramBoolean, int paramInt, Handler paramHandler, i.b paramb, f paramf)
  {
    this.atf = paramArrayOfr;
    this.atg = paramg;
    this.atC = paramm;
    this.atn = paramBoolean;
    this.repeatMode = paramInt;
    this.eventHandler = paramHandler;
    this.state = 1;
    this.atw = paramb;
    this.atF = paramf;
    this.atB = new s[paramArrayOfr.length];
    paramInt = 0;
    while (paramInt < paramArrayOfr.length)
    {
      paramArrayOfr[paramInt].setIndex(paramInt);
      this.atB[paramInt] = paramArrayOfr[paramInt].kr();
      paramInt += 1;
    }
    this.atD = new o();
    this.atK = new r[0];
    this.atk = new w.b();
    this.atl = new w.a();
    this.atG = new n();
    paramg.aQH = this;
    this.atv = p.auS;
    this.atE = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
    this.atE.start();
    this.handler = new Handler(this.atE.getLooper(), this);
  }
  
  private int a(int paramInt, w paramw1, w paramw2)
  {
    int m = paramw1.kW();
    int k = 0;
    int i = -1;
    int j = paramInt;
    paramInt = k;
    while ((paramInt < m) && (i == -1))
    {
      j = paramw1.a(j, this.atl, this.atk, this.repeatMode);
      if (j == -1) {
        break;
      }
      i = paramw2.O(paramw1.a(j, this.atl, true).atW);
      paramInt += 1;
    }
    return i;
  }
  
  private long a(f.b paramb, long paramLong)
  {
    kH();
    this.atL = false;
    setState(2);
    Object localObject;
    if (this.atU == null)
    {
      if (this.atS == null) {
        break label366;
      }
      this.atS.release();
      localObject = null;
    }
    for (;;)
    {
      if ((this.atU != localObject) || (this.atU != this.atT))
      {
        paramb = this.atK;
        int j = paramb.length;
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            paramb[i].disable();
            i += 1;
            continue;
            i.a locala1 = this.atU;
            i.a locala2 = null;
            localObject = locala2;
            if (locala1 == null) {
              break;
            }
            if (locala2 == null) {
              if ((paramb.equals(locala1.aua.auN)) && (locala1.prepared))
              {
                this.atr.a(locala1.aua.auN.aIm, this.atl, false);
                i = this.atl.z(paramLong);
                if ((i == -1) || (this.atl.avw[i] == locala1.aua.auO))
                {
                  i = 1;
                  label206:
                  if (i == 0) {
                    break label231;
                  }
                  locala2 = locala1;
                }
              }
            }
            for (;;)
            {
              locala1 = locala1.auc;
              break;
              i = 0;
              break label206;
              label231:
              locala1.release();
            }
          }
        }
        this.atK = new r[0];
        this.atI = null;
        this.atH = null;
        this.atU = null;
      }
      if (localObject != null)
      {
        localObject.auc = null;
        this.atS = localObject;
        this.atT = localObject;
        b(localObject);
        long l = paramLong;
        if (this.atU.aub) {
          l = this.atU.atV.I(paramLong);
        }
        u(l);
        kL();
        paramLong = l;
      }
      for (;;)
      {
        this.handler.sendEmptyMessage(2);
        return paramLong;
        this.atS = null;
        this.atT = null;
        this.atU = null;
        u(paramLong);
      }
      label366:
      localObject = null;
    }
  }
  
  private Pair<Integer, Long> a(i.c paramc)
  {
    Object localObject2 = paramc.atr;
    Object localObject1 = localObject2;
    if (((w)localObject2).isEmpty()) {
      localObject1 = this.atr;
    }
    try
    {
      localObject2 = ((w)localObject1).a(this.atk, this.atl, paramc.auk, paramc.aul);
      if (this.atr == localObject1) {
        return localObject2;
      }
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      throw new l(this.atr, paramc.auk, paramc.aul);
    }
    int i = this.atr.O(localIndexOutOfBoundsException.a(((Integer)((Pair)localObject2).first).intValue(), this.atl, true).atW);
    if (i != -1) {
      return Pair.create(Integer.valueOf(i), ((Pair)localObject2).second);
    }
    i = a(((Integer)((Pair)localObject2).first).intValue(), localIndexOutOfBoundsException, this.atr);
    if (i != -1) {
      return cB(this.atr.a(i, this.atl, false).auk);
    }
    return null;
  }
  
  private i.a a(i.a parama, int paramInt)
  {
    for (;;)
    {
      parama.aua = this.atG.a(parama.aua, paramInt);
      if ((parama.aua.auQ) || (parama.auc == null)) {
        return parama;
      }
      parama = parama.auc;
    }
  }
  
  private static void a(i.a parama)
  {
    while (parama != null)
    {
      parama.release();
      parama = parama.auc;
    }
  }
  
  private static void a(r paramr)
  {
    if (paramr.getState() == 2) {
      paramr.stop();
    }
  }
  
  private void au(boolean paramBoolean)
  {
    Handler localHandler;
    if (this.isLoading != paramBoolean)
    {
      this.isLoading = paramBoolean;
      localHandler = this.eventHandler;
      if (!paramBoolean) {
        break label35;
      }
    }
    label35:
    for (int i = 1;; i = 0)
    {
      localHandler.obtainMessage(2, i, 0).sendToTarget();
      return;
    }
  }
  
  private void av(boolean paramBoolean)
  {
    this.handler.removeMessages(2);
    this.atL = false;
    this.atD.stop();
    this.atI = null;
    this.atH = null;
    this.atR = 60000000L;
    Object localObject = this.atK;
    int j = localObject.length;
    int i = 0;
    for (;;)
    {
      r localr;
      if (i < j) {
        localr = localObject[i];
      }
      try
      {
        a(localr);
        localr.disable();
        label72:
        i += 1;
        continue;
        this.atK = new r[0];
        if (this.atU != null) {}
        for (localObject = this.atU;; localObject = this.atS)
        {
          a((i.a)localObject);
          this.atS = null;
          this.atT = null;
          this.atU = null;
          au(false);
          if (paramBoolean)
          {
            if (this.atJ != null)
            {
              this.atJ.mF();
              this.atJ = null;
            }
            this.atG.atr = null;
            this.atr = null;
          }
          return;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        break label72;
      }
      catch (e locale)
      {
        break label72;
      }
    }
  }
  
  private void b(i.a parama)
  {
    if (this.atU == parama) {
      return;
    }
    boolean[] arrayOfBoolean = new boolean[this.atf.length];
    int i = 0;
    int j = 0;
    if (i < this.atf.length)
    {
      r localr = this.atf[i];
      if (localr.getState() != 0) {}
      for (int m = 1;; m = 0)
      {
        arrayOfBoolean[i] = m;
        com.google.android.exoplayer2.g.e locale = parama.aud.aQJ.aQG[i];
        int k = j;
        if (locale != null) {
          k = j + 1;
        }
        if ((arrayOfBoolean[i] != 0) && ((locale == null) || ((localr.kw()) && (localr.kt() == this.atU.atX[i]))))
        {
          if (localr == this.atH)
          {
            this.atD.a(this.atI);
            this.atI = null;
            this.atH = null;
          }
          a(localr);
          localr.disable();
        }
        i += 1;
        j = k;
        break;
      }
    }
    this.atU = parama;
    this.eventHandler.obtainMessage(3, parama.aud).sendToTarget();
    b(arrayOfBoolean, j);
  }
  
  private void b(Object paramObject, int paramInt)
  {
    this.atw = new i.b(0L);
    c(paramObject, paramInt);
    this.atw = new i.b(-9223372036854775807L);
    setState(4);
    av(false);
  }
  
  private void b(boolean[] paramArrayOfBoolean, int paramInt)
  {
    this.atK = new r[paramInt];
    int i = 0;
    paramInt = 0;
    while (paramInt < this.atf.length)
    {
      r localr = this.atf[paramInt];
      Object localObject = this.atU.aud.aQJ.aQG[paramInt];
      int j = i;
      if (localObject != null)
      {
        this.atK[i] = localr;
        if (localr.getState() == 0)
        {
          t localt = this.atU.aud.aQL[paramInt];
          if ((this.atn) && (this.state == 3))
          {
            j = 1;
            if ((paramArrayOfBoolean[paramInt] != 0) || (j == 0)) {
              break label170;
            }
          }
          Format[] arrayOfFormat;
          label170:
          for (boolean bool = true;; bool = false)
          {
            arrayOfFormat = new Format[((com.google.android.exoplayer2.g.e)localObject).length()];
            int k = 0;
            while (k < arrayOfFormat.length)
            {
              arrayOfFormat[k] = ((com.google.android.exoplayer2.g.e)localObject).dt(k);
              k += 1;
            }
            j = 0;
            break;
          }
          localr.a(localt, arrayOfFormat, this.atU.atX[paramInt], this.atR, bool, this.atU.kM());
          localObject = localr.ks();
          if (localObject != null)
          {
            if (this.atI != null) {
              throw e.b(new IllegalStateException("Multiple renderer media clocks enabled."));
            }
            this.atI = ((com.google.android.exoplayer2.i.f)localObject);
            this.atH = localr;
            this.atI.b(this.atv);
          }
          if (j != 0) {
            localr.start();
          }
        }
        j = i + 1;
      }
      paramInt += 1;
      i = j;
    }
  }
  
  private void c(Object paramObject, int paramInt)
  {
    this.eventHandler.obtainMessage(6, new i.d(this.atr, paramObject, this.atw, paramInt)).sendToTarget();
  }
  
  private Pair<Integer, Long> cB(int paramInt)
  {
    return this.atr.a(this.atk, this.atl, paramInt, -9223372036854775807L);
  }
  
  private void e(long paramLong1, long paramLong2)
  {
    this.handler.removeMessages(2);
    paramLong1 = paramLong1 + paramLong2 - SystemClock.elapsedRealtime();
    if (paramLong1 <= 0L)
    {
      this.handler.sendEmptyMessage(2);
      return;
    }
    this.handler.sendEmptyMessageDelayed(2, paramLong1);
  }
  
  private void kG()
  {
    int i = 0;
    this.atL = false;
    Object localObject = this.atD;
    if (!((o)localObject).started)
    {
      ((o)localObject).aSP = SystemClock.elapsedRealtime();
      ((o)localObject).started = true;
    }
    localObject = this.atK;
    int j = localObject.length;
    while (i < j)
    {
      localObject[i].start();
      i += 1;
    }
  }
  
  private void kH()
  {
    this.atD.stop();
    r[] arrayOfr = this.atK;
    int j = arrayOfr.length;
    int i = 0;
    while (i < j)
    {
      a(arrayOfr[i]);
      i += 1;
    }
  }
  
  private void kI()
  {
    if (this.atU == null) {
      return;
    }
    long l1 = this.atU.atV.mA();
    if (l1 != -9223372036854775807L)
    {
      u(l1);
      this.atw.aui = l1;
      this.atO = (SystemClock.elapsedRealtime() * 1000L);
      if (this.atK.length != 0) {
        break label176;
      }
    }
    label176:
    for (l1 = -9223372036854775808L;; l1 = this.atU.atV.mB())
    {
      Object localObject = this.atw;
      long l2 = l1;
      if (l1 == -9223372036854775808L) {
        l2 = this.atU.aua.auP;
      }
      ((i.b)localObject).auj = l2;
      return;
      if ((this.atH != null) && (!this.atH.kU()))
      {
        this.atR = this.atI.lo();
        this.atD.R(this.atR);
      }
      for (;;)
      {
        localObject = this.atU;
        l1 = this.atR - ((i.a)localObject).kM();
        break;
        this.atR = this.atD.lo();
      }
    }
  }
  
  private void kJ()
  {
    av(true);
    this.atC.onStopped();
    setState(1);
  }
  
  private void kK()
  {
    r[] arrayOfr;
    int j;
    int i;
    if ((this.atS != null) && (!this.atS.prepared) && ((this.atT == null) || (this.atT.auc == this.atS)))
    {
      arrayOfr = this.atK;
      j = arrayOfr.length;
      i = 0;
    }
    while (i < j)
    {
      if (!arrayOfr[i].ku()) {
        return;
      }
      i += 1;
    }
    this.atS.atV.my();
  }
  
  private void kL()
  {
    i.a locala = this.atS;
    long l2 = this.atR;
    long l1;
    if (!locala.prepared)
    {
      l1 = 0L;
      if (l1 != -9223372036854775808L) {
        break label89;
      }
    }
    label89:
    long l3;
    for (boolean bool = false;; bool = locala.atC.s(l1 - (l2 - l3)))
    {
      au(bool);
      if (bool)
      {
        locala = this.atS;
        l1 = this.atR;
        l2 = locala.kM();
        locala.atV.J(l1 - l2);
      }
      return;
      l1 = locala.atV.mC();
      break;
      l3 = locala.kM();
    }
  }
  
  private void setState(int paramInt)
  {
    if (this.state != paramInt)
    {
      this.state = paramInt;
      this.eventHandler.obtainMessage(1, paramInt, 0).sendToTarget();
    }
  }
  
  private void u(long paramLong)
  {
    if (this.atU == null) {}
    for (paramLong = 60000000L + paramLong;; paramLong = this.atU.kM() + paramLong)
    {
      this.atR = paramLong;
      this.atD.R(this.atR);
      r[] arrayOfr = this.atK;
      int j = arrayOfr.length;
      int i = 0;
      while (i < j)
      {
        arrayOfr[i].p(this.atR);
        i += 1;
      }
    }
  }
  
  private boolean v(long paramLong)
  {
    return (paramLong == -9223372036854775807L) || (this.atw.aui < paramLong) || ((this.atU.auc != null) && ((this.atU.auc.prepared) || (this.atU.auc.aua.auN.mG())));
  }
  
  public final void a(com.google.android.exoplayer2.source.e parame)
  {
    this.handler.obtainMessage(8, parame).sendToTarget();
  }
  
  public final void a(w paramw, int paramInt, long paramLong)
  {
    this.handler.obtainMessage(3, new i.c(paramw, paramInt, paramLong)).sendToTarget();
  }
  
  public final void a(w paramw, Object paramObject)
  {
    this.handler.obtainMessage(7, Pair.create(paramw, paramObject)).sendToTarget();
  }
  
  /* Error */
  public final void b(f.c... paramVarArgs)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 571	com/google/android/exoplayer2/i:released	Z
    //   6: istore 5
    //   8: iload 5
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: getfield 573	com/google/android/exoplayer2/i:atM	I
    //   20: istore_3
    //   21: aload_0
    //   22: iload_3
    //   23: iconst_1
    //   24: iadd
    //   25: putfield 573	com/google/android/exoplayer2/i:atM	I
    //   28: aload_0
    //   29: getfield 171	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   32: bipush 11
    //   34: aload_1
    //   35: invokevirtual 423	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   38: invokevirtual 363	android/os/Message:sendToTarget	()V
    //   41: iconst_0
    //   42: istore_2
    //   43: aload_0
    //   44: getfield 575	com/google/android/exoplayer2/i:atN	I
    //   47: istore 4
    //   49: iload 4
    //   51: iload_3
    //   52: if_icmpgt +16 -> 68
    //   55: aload_0
    //   56: invokevirtual 578	java/lang/Object:wait	()V
    //   59: goto -16 -> 43
    //   62: astore_1
    //   63: iconst_1
    //   64: istore_2
    //   65: goto -22 -> 43
    //   68: iload_2
    //   69: ifeq -56 -> 13
    //   72: invokestatic 584	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   75: invokevirtual 587	java/lang/Thread:interrupt	()V
    //   78: goto -65 -> 13
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	i
    //   0	86	1	paramVarArgs	f.c[]
    //   42	27	2	i	int
    //   20	33	3	j	int
    //   47	6	4	k	int
    //   6	3	5	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   55	59	62	java/lang/InterruptedException
    //   2	8	81	finally
    //   16	41	81	finally
    //   43	49	81	finally
    //   55	59	81	finally
    //   72	78	81	finally
  }
  
  /* Error */
  public final boolean handleMessage(Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 594	android/os/Message:what	I
    //   4: tableswitch	default:+4813 -> 4817, 0:+68->72, 1:+217->221, 2:+634->638, 3:+2614->2618, 4:+2995->2999, 5:+3053->3057, 6:+3059->3063, 7:+3248->3252, 8:+3098->3102, 9:+4181->4185, 10:+4217->4221, 11:+4677->4681, 12:+344->348
    //   73: getfield 597	android/os/Message:obj	Ljava/lang/Object;
    //   76: checkcast 386	com/google/android/exoplayer2/source/f
    //   79: astore 15
    //   81: aload_1
    //   82: getfield 600	android/os/Message:arg1	I
    //   85: ifeq +4734 -> 4819
    //   88: iconst_1
    //   89: istore_2
    //   90: aload_0
    //   91: getfield 93	com/google/android/exoplayer2/i:eventHandler	Landroid/os/Handler;
    //   94: iconst_0
    //   95: invokevirtual 284	android/os/Handler:sendEmptyMessage	(I)Z
    //   98: pop
    //   99: aload_0
    //   100: iconst_1
    //   101: invokespecial 436	com/google/android/exoplayer2/i:av	(Z)V
    //   104: aload_0
    //   105: getfield 87	com/google/android/exoplayer2/i:atC	Lcom/google/android/exoplayer2/m;
    //   108: invokeinterface 603 1 0
    //   113: iload_2
    //   114: ifeq +52 -> 166
    //   117: aload_0
    //   118: new 16	com/google/android/exoplayer2/i$b
    //   121: dup
    //   122: ldc2_w 433
    //   125: invokespecial 429	com/google/android/exoplayer2/i$b:<init>	(J)V
    //   128: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   131: aload_0
    //   132: aload 15
    //   134: putfield 384	com/google/android/exoplayer2/i:atJ	Lcom/google/android/exoplayer2/source/f;
    //   137: aload 15
    //   139: ifnull +11 -> 150
    //   142: aload 15
    //   144: aload_0
    //   145: invokeinterface 606 2 0
    //   150: aload_0
    //   151: iconst_2
    //   152: invokespecial 203	com/google/android/exoplayer2/i:setState	(I)V
    //   155: aload_0
    //   156: getfield 171	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   159: iconst_2
    //   160: invokevirtual 284	android/os/Handler:sendEmptyMessage	(I)Z
    //   163: pop
    //   164: iconst_1
    //   165: ireturn
    //   166: aload_0
    //   167: new 16	com/google/android/exoplayer2/i$b
    //   170: dup
    //   171: aload_0
    //   172: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   175: getfield 609	com/google/android/exoplayer2/i$b:auf	Lcom/google/android/exoplayer2/source/f$b;
    //   178: aload_0
    //   179: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   182: getfield 507	com/google/android/exoplayer2/i$b:aui	J
    //   185: aload_0
    //   186: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   189: getfield 612	com/google/android/exoplayer2/i$b:auh	J
    //   192: invokespecial 615	com/google/android/exoplayer2/i$b:<init>	(Lcom/google/android/exoplayer2/source/f$b;JJ)V
    //   195: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   198: goto -67 -> 131
    //   201: astore_1
    //   202: aload_0
    //   203: getfield 93	com/google/android/exoplayer2/i:eventHandler	Landroid/os/Handler;
    //   206: bipush 8
    //   208: aload_1
    //   209: invokevirtual 423	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   212: invokevirtual 363	android/os/Message:sendToTarget	()V
    //   215: aload_0
    //   216: invokespecial 617	com/google/android/exoplayer2/i:kJ	()V
    //   219: iconst_1
    //   220: ireturn
    //   221: aload_1
    //   222: getfield 600	android/os/Message:arg1	I
    //   225: ifeq +4601 -> 4826
    //   228: iconst_1
    //   229: istore 6
    //   231: aload_0
    //   232: iconst_0
    //   233: putfield 200	com/google/android/exoplayer2/i:atL	Z
    //   236: aload_0
    //   237: iload 6
    //   239: putfield 89	com/google/android/exoplayer2/i:atn	Z
    //   242: iload 6
    //   244: ifne +14 -> 258
    //   247: aload_0
    //   248: invokespecial 198	com/google/android/exoplayer2/i:kH	()V
    //   251: aload_0
    //   252: invokespecial 619	com/google/android/exoplayer2/i:kI	()V
    //   255: goto +4569 -> 4824
    //   258: aload_0
    //   259: getfield 95	com/google/android/exoplayer2/i:state	I
    //   262: iconst_3
    //   263: if_icmpne +42 -> 305
    //   266: aload_0
    //   267: invokespecial 621	com/google/android/exoplayer2/i:kG	()V
    //   270: aload_0
    //   271: getfield 171	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   274: iconst_2
    //   275: invokevirtual 284	android/os/Handler:sendEmptyMessage	(I)Z
    //   278: pop
    //   279: goto +4545 -> 4824
    //   282: astore_1
    //   283: aload_0
    //   284: getfield 93	com/google/android/exoplayer2/i:eventHandler	Landroid/os/Handler;
    //   287: bipush 8
    //   289: aload_1
    //   290: invokestatic 624	com/google/android/exoplayer2/e:a	(Ljava/io/IOException;)Lcom/google/android/exoplayer2/e;
    //   293: invokevirtual 423	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   296: invokevirtual 363	android/os/Message:sendToTarget	()V
    //   299: aload_0
    //   300: invokespecial 617	com/google/android/exoplayer2/i:kJ	()V
    //   303: iconst_1
    //   304: ireturn
    //   305: aload_0
    //   306: getfield 95	com/google/android/exoplayer2/i:state	I
    //   309: iconst_2
    //   310: if_icmpne +4514 -> 4824
    //   313: aload_0
    //   314: getfield 171	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   317: iconst_2
    //   318: invokevirtual 284	android/os/Handler:sendEmptyMessage	(I)Z
    //   321: pop
    //   322: goto +4502 -> 4824
    //   325: astore_1
    //   326: aload_0
    //   327: getfield 93	com/google/android/exoplayer2/i:eventHandler	Landroid/os/Handler;
    //   330: bipush 8
    //   332: aload_1
    //   333: invokestatic 472	com/google/android/exoplayer2/e:b	(Ljava/lang/RuntimeException;)Lcom/google/android/exoplayer2/e;
    //   336: invokevirtual 423	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   339: invokevirtual 363	android/os/Message:sendToTarget	()V
    //   342: aload_0
    //   343: invokespecial 617	com/google/android/exoplayer2/i:kJ	()V
    //   346: iconst_1
    //   347: ireturn
    //   348: aload_1
    //   349: getfield 600	android/os/Message:arg1	I
    //   352: istore_2
    //   353: aload_0
    //   354: iload_2
    //   355: putfield 91	com/google/android/exoplayer2/i:repeatMode	I
    //   358: aload_0
    //   359: getfield 135	com/google/android/exoplayer2/i:atG	Lcom/google/android/exoplayer2/n;
    //   362: iload_2
    //   363: putfield 625	com/google/android/exoplayer2/n:repeatMode	I
    //   366: aload_0
    //   367: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   370: ifnull +63 -> 433
    //   373: aload_0
    //   374: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   377: astore_1
    //   378: goto +4454 -> 4832
    //   381: aload_0
    //   382: getfield 236	com/google/android/exoplayer2/i:atr	Lcom/google/android/exoplayer2/w;
    //   385: aload_1
    //   386: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   389: getfield 225	com/google/android/exoplayer2/n$a:auN	Lcom/google/android/exoplayer2/source/f$b;
    //   392: getfield 239	com/google/android/exoplayer2/source/f$b:aIm	I
    //   395: aload_0
    //   396: getfield 130	com/google/android/exoplayer2/i:atl	Lcom/google/android/exoplayer2/w$a;
    //   399: aload_0
    //   400: getfield 125	com/google/android/exoplayer2/i:atk	Lcom/google/android/exoplayer2/w$b;
    //   403: iload_2
    //   404: invokevirtual 183	com/google/android/exoplayer2/w:a	(ILcom/google/android/exoplayer2/w$a;Lcom/google/android/exoplayer2/w$b;I)I
    //   407: istore_3
    //   408: aload_1
    //   409: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   412: ifnull +29 -> 441
    //   415: aload_1
    //   416: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   419: getfield 343	com/google/android/exoplayer2/n$a:auQ	Z
    //   422: ifne +19 -> 441
    //   425: aload_1
    //   426: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   429: astore_1
    //   430: goto -22 -> 408
    //   433: aload_0
    //   434: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   437: astore_1
    //   438: goto +4394 -> 4832
    //   441: iload_3
    //   442: iconst_m1
    //   443: if_icmpeq +35 -> 478
    //   446: aload_1
    //   447: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   450: ifnull +28 -> 478
    //   453: aload_1
    //   454: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   457: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   460: getfield 225	com/google/android/exoplayer2/n$a:auN	Lcom/google/android/exoplayer2/source/f$b;
    //   463: getfield 239	com/google/android/exoplayer2/source/f$b:aIm	I
    //   466: iload_3
    //   467: if_icmpne +11 -> 478
    //   470: aload_1
    //   471: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   474: astore_1
    //   475: goto -94 -> 381
    //   478: aload_0
    //   479: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   482: getfield 628	com/google/android/exoplayer2/i$a:index	I
    //   485: istore_3
    //   486: aload_0
    //   487: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   490: ifnull +4351 -> 4841
    //   493: aload_0
    //   494: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   497: getfield 628	com/google/android/exoplayer2/i$a:index	I
    //   500: istore_2
    //   501: aload_1
    //   502: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   505: ifnull +15 -> 520
    //   508: aload_1
    //   509: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   512: invokestatic 380	com/google/android/exoplayer2/i:a	(Lcom/google/android/exoplayer2/i$a;)V
    //   515: aload_1
    //   516: aconst_null
    //   517: putfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   520: aload_0
    //   521: getfield 135	com/google/android/exoplayer2/i:atG	Lcom/google/android/exoplayer2/n;
    //   524: astore 15
    //   526: aload_1
    //   527: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   530: astore 16
    //   532: aload_1
    //   533: aload 15
    //   535: aload 16
    //   537: aload 16
    //   539: getfield 225	com/google/android/exoplayer2/n$a:auN	Lcom/google/android/exoplayer2/source/f$b;
    //   542: invokevirtual 631	com/google/android/exoplayer2/n:a	(Lcom/google/android/exoplayer2/n$a;Lcom/google/android/exoplayer2/source/f$b;)Lcom/google/android/exoplayer2/n$a;
    //   545: putfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   548: iload_3
    //   549: aload_1
    //   550: getfield 628	com/google/android/exoplayer2/i$a:index	I
    //   553: if_icmpgt +4293 -> 4846
    //   556: iconst_1
    //   557: istore_3
    //   558: iload_3
    //   559: ifne +8 -> 567
    //   562: aload_0
    //   563: aload_1
    //   564: putfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   567: iload_2
    //   568: iconst_m1
    //   569: if_icmpeq +4282 -> 4851
    //   572: iload_2
    //   573: aload_1
    //   574: getfield 628	com/google/android/exoplayer2/i$a:index	I
    //   577: if_icmpgt +4274 -> 4851
    //   580: iconst_1
    //   581: istore_2
    //   582: iload_2
    //   583: ifne +4256 -> 4839
    //   586: aload_0
    //   587: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   590: ifnull +4249 -> 4839
    //   593: aload_0
    //   594: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   597: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   600: getfield 225	com/google/android/exoplayer2/n$a:auN	Lcom/google/android/exoplayer2/source/f$b;
    //   603: astore_1
    //   604: aload_0
    //   605: new 16	com/google/android/exoplayer2/i$b
    //   608: dup
    //   609: aload_1
    //   610: aload_0
    //   611: aload_1
    //   612: aload_0
    //   613: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   616: getfield 507	com/google/android/exoplayer2/i$b:aui	J
    //   619: invokespecial 633	com/google/android/exoplayer2/i:a	(Lcom/google/android/exoplayer2/source/f$b;J)J
    //   622: aload_0
    //   623: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   626: getfield 612	com/google/android/exoplayer2/i$b:auh	J
    //   629: invokespecial 615	com/google/android/exoplayer2/i$b:<init>	(Lcom/google/android/exoplayer2/source/f$b;JJ)V
    //   632: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   635: goto +4204 -> 4839
    //   638: invokestatic 489	android/os/SystemClock:elapsedRealtime	()J
    //   641: lstore 11
    //   643: aload_0
    //   644: getfield 236	com/google/android/exoplayer2/i:atr	Lcom/google/android/exoplayer2/w;
    //   647: ifnonnull +42 -> 689
    //   650: aload_0
    //   651: getfield 384	com/google/android/exoplayer2/i:atJ	Lcom/google/android/exoplayer2/source/f;
    //   654: ifnull +35 -> 689
    //   657: aload_0
    //   658: getfield 384	com/google/android/exoplayer2/i:atJ	Lcom/google/android/exoplayer2/source/f;
    //   661: invokeinterface 636 1 0
    //   666: aload_0
    //   667: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   670: ifnonnull +1363 -> 2033
    //   673: aload_0
    //   674: invokespecial 638	com/google/android/exoplayer2/i:kK	()V
    //   677: aload_0
    //   678: lload 11
    //   680: ldc2_w 639
    //   683: invokespecial 642	com/google/android/exoplayer2/i:e	(JJ)V
    //   686: goto +4170 -> 4856
    //   689: aload_0
    //   690: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   693: ifnonnull +186 -> 879
    //   696: aload_0
    //   697: getfield 135	com/google/android/exoplayer2/i:atG	Lcom/google/android/exoplayer2/n;
    //   700: astore_1
    //   701: aload_0
    //   702: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   705: astore 15
    //   707: aload_1
    //   708: aload 15
    //   710: getfield 609	com/google/android/exoplayer2/i$b:auf	Lcom/google/android/exoplayer2/source/f$b;
    //   713: aload 15
    //   715: getfield 612	com/google/android/exoplayer2/i$b:auh	J
    //   718: aload 15
    //   720: getfield 645	com/google/android/exoplayer2/i$b:aug	J
    //   723: invokevirtual 648	com/google/android/exoplayer2/n:a	(Lcom/google/android/exoplayer2/source/f$b;JJ)Lcom/google/android/exoplayer2/n$a;
    //   726: astore_1
    //   727: aload_1
    //   728: ifnonnull +744 -> 1472
    //   731: aload_0
    //   732: getfield 384	com/google/android/exoplayer2/i:atJ	Lcom/google/android/exoplayer2/source/f;
    //   735: invokeinterface 636 1 0
    //   740: aload_0
    //   741: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   744: ifnull +13 -> 757
    //   747: aload_0
    //   748: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   751: invokevirtual 651	com/google/android/exoplayer2/i$a:kN	()Z
    //   754: ifeq +881 -> 1635
    //   757: aload_0
    //   758: iconst_0
    //   759: invokespecial 382	com/google/android/exoplayer2/i:au	(Z)V
    //   762: aload_0
    //   763: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   766: ifnull -100 -> 666
    //   769: aload_0
    //   770: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   773: aload_0
    //   774: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   777: if_acmpeq +879 -> 1656
    //   780: aload_0
    //   781: getfield 376	com/google/android/exoplayer2/i:atR	J
    //   784: aload_0
    //   785: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   788: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   791: getfield 654	com/google/android/exoplayer2/i$a:atZ	J
    //   794: lcmp
    //   795: iflt +861 -> 1656
    //   798: aload_0
    //   799: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   802: invokevirtual 210	com/google/android/exoplayer2/i$a:release	()V
    //   805: aload_0
    //   806: aload_0
    //   807: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   810: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   813: invokespecial 261	com/google/android/exoplayer2/i:b	(Lcom/google/android/exoplayer2/i$a;)V
    //   816: aload_0
    //   817: new 16	com/google/android/exoplayer2/i$b
    //   820: dup
    //   821: aload_0
    //   822: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   825: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   828: getfield 225	com/google/android/exoplayer2/n$a:auN	Lcom/google/android/exoplayer2/source/f$b;
    //   831: aload_0
    //   832: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   835: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   838: getfield 655	com/google/android/exoplayer2/n$a:aug	J
    //   841: aload_0
    //   842: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   845: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   848: getfield 656	com/google/android/exoplayer2/n$a:auh	J
    //   851: invokespecial 615	com/google/android/exoplayer2/i$b:<init>	(Lcom/google/android/exoplayer2/source/f$b;JJ)V
    //   854: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   857: aload_0
    //   858: invokespecial 619	com/google/android/exoplayer2/i:kI	()V
    //   861: aload_0
    //   862: getfield 93	com/google/android/exoplayer2/i:eventHandler	Landroid/os/Handler;
    //   865: iconst_5
    //   866: aload_0
    //   867: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   870: invokevirtual 423	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   873: invokevirtual 363	android/os/Message:sendToTarget	()V
    //   876: goto -107 -> 769
    //   879: aload_0
    //   880: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   883: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   886: getfield 659	com/google/android/exoplayer2/n$a:auR	Z
    //   889: ifne -149 -> 740
    //   892: aload_0
    //   893: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   896: invokevirtual 651	com/google/android/exoplayer2/i$a:kN	()Z
    //   899: ifeq -159 -> 740
    //   902: aload_0
    //   903: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   906: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   909: getfield 516	com/google/android/exoplayer2/n$a:auP	J
    //   912: ldc2_w 433
    //   915: lcmp
    //   916: ifeq -176 -> 740
    //   919: aload_0
    //   920: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   923: ifnull +23 -> 946
    //   926: aload_0
    //   927: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   930: getfield 628	com/google/android/exoplayer2/i$a:index	I
    //   933: aload_0
    //   934: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   937: getfield 628	com/google/android/exoplayer2/i$a:index	I
    //   940: isub
    //   941: bipush 100
    //   943: if_icmpeq -203 -> 740
    //   946: aload_0
    //   947: getfield 135	com/google/android/exoplayer2/i:atG	Lcom/google/android/exoplayer2/n;
    //   950: astore_1
    //   951: aload_0
    //   952: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   955: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   958: astore 15
    //   960: aload_0
    //   961: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   964: invokevirtual 455	com/google/android/exoplayer2/i$a:kM	()J
    //   967: lstore 7
    //   969: aload_0
    //   970: getfield 376	com/google/android/exoplayer2/i:atR	J
    //   973: lstore 9
    //   975: aload 15
    //   977: getfield 343	com/google/android/exoplayer2/n$a:auQ	Z
    //   980: ifeq +172 -> 1152
    //   983: aload_1
    //   984: getfield 390	com/google/android/exoplayer2/n:atr	Lcom/google/android/exoplayer2/w;
    //   987: aload 15
    //   989: getfield 225	com/google/android/exoplayer2/n$a:auN	Lcom/google/android/exoplayer2/source/f$b;
    //   992: getfield 239	com/google/android/exoplayer2/source/f$b:aIm	I
    //   995: aload_1
    //   996: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   999: aload_1
    //   1000: getfield 661	com/google/android/exoplayer2/n:atk	Lcom/google/android/exoplayer2/w$b;
    //   1003: aload_1
    //   1004: getfield 625	com/google/android/exoplayer2/n:repeatMode	I
    //   1007: invokevirtual 183	com/google/android/exoplayer2/w:a	(ILcom/google/android/exoplayer2/w$a;Lcom/google/android/exoplayer2/w$b;I)I
    //   1010: istore_2
    //   1011: iload_2
    //   1012: iconst_m1
    //   1013: if_icmpne +8 -> 1021
    //   1016: aconst_null
    //   1017: astore_1
    //   1018: goto -291 -> 727
    //   1021: aload_1
    //   1022: getfield 390	com/google/android/exoplayer2/n:atr	Lcom/google/android/exoplayer2/w;
    //   1025: iload_2
    //   1026: aload_1
    //   1027: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   1030: iconst_0
    //   1031: invokevirtual 186	com/google/android/exoplayer2/w:a	(ILcom/google/android/exoplayer2/w$a;Z)Lcom/google/android/exoplayer2/w$a;
    //   1034: getfield 330	com/google/android/exoplayer2/w$a:auk	I
    //   1037: istore_3
    //   1038: aload_1
    //   1039: getfield 390	com/google/android/exoplayer2/n:atr	Lcom/google/android/exoplayer2/w;
    //   1042: iload_3
    //   1043: aload_1
    //   1044: getfield 661	com/google/android/exoplayer2/n:atk	Lcom/google/android/exoplayer2/w$b;
    //   1047: lconst_0
    //   1048: invokevirtual 664	com/google/android/exoplayer2/w:a	(ILcom/google/android/exoplayer2/w$b;J)Lcom/google/android/exoplayer2/w$b;
    //   1051: getfield 667	com/google/android/exoplayer2/w$b:avG	I
    //   1054: iload_2
    //   1055: if_icmpne +3803 -> 4858
    //   1058: aload 15
    //   1060: getfield 516	com/google/android/exoplayer2/n$a:auP	J
    //   1063: lstore 13
    //   1065: aload_1
    //   1066: getfield 390	com/google/android/exoplayer2/n:atr	Lcom/google/android/exoplayer2/w;
    //   1069: aload_1
    //   1070: getfield 661	com/google/android/exoplayer2/n:atk	Lcom/google/android/exoplayer2/w$b;
    //   1073: aload_1
    //   1074: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   1077: iload_3
    //   1078: ldc2_w 433
    //   1081: lconst_0
    //   1082: lload 13
    //   1084: lload 7
    //   1086: ladd
    //   1087: lload 9
    //   1089: lsub
    //   1090: invokestatic 673	java/lang/Math:max	(JJ)J
    //   1093: invokevirtual 676	com/google/android/exoplayer2/w:a	(Lcom/google/android/exoplayer2/w$b;Lcom/google/android/exoplayer2/w$a;IJJ)Landroid/util/Pair;
    //   1096: astore 15
    //   1098: aload 15
    //   1100: ifnonnull +8 -> 1108
    //   1103: aconst_null
    //   1104: astore_1
    //   1105: goto -378 -> 727
    //   1108: aload 15
    //   1110: getfield 311	android/util/Pair:first	Ljava/lang/Object;
    //   1113: checkcast 313	java/lang/Integer
    //   1116: invokevirtual 316	java/lang/Integer:intValue	()I
    //   1119: istore_2
    //   1120: aload 15
    //   1122: getfield 323	android/util/Pair:second	Ljava/lang/Object;
    //   1125: checkcast 678	java/lang/Long
    //   1128: invokevirtual 681	java/lang/Long:longValue	()J
    //   1131: lstore 7
    //   1133: aload_1
    //   1134: aload_1
    //   1135: iload_2
    //   1136: lload 7
    //   1138: invokevirtual 684	com/google/android/exoplayer2/n:e	(IJ)Lcom/google/android/exoplayer2/source/f$b;
    //   1141: lload 7
    //   1143: lload 7
    //   1145: invokevirtual 648	com/google/android/exoplayer2/n:a	(Lcom/google/android/exoplayer2/source/f$b;JJ)Lcom/google/android/exoplayer2/n$a;
    //   1148: astore_1
    //   1149: goto -422 -> 727
    //   1152: aload 15
    //   1154: getfield 225	com/google/android/exoplayer2/n$a:auN	Lcom/google/android/exoplayer2/source/f$b;
    //   1157: astore 16
    //   1159: aload 16
    //   1161: invokevirtual 562	com/google/android/exoplayer2/source/f$b:mG	()Z
    //   1164: ifeq +158 -> 1322
    //   1167: aload 16
    //   1169: getfield 687	com/google/android/exoplayer2/source/f$b:aIn	I
    //   1172: istore_2
    //   1173: aload_1
    //   1174: getfield 390	com/google/android/exoplayer2/n:atr	Lcom/google/android/exoplayer2/w;
    //   1177: aload 16
    //   1179: getfield 239	com/google/android/exoplayer2/source/f$b:aIm	I
    //   1182: aload_1
    //   1183: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   1186: iconst_0
    //   1187: invokevirtual 186	com/google/android/exoplayer2/w:a	(ILcom/google/android/exoplayer2/w$a;Z)Lcom/google/android/exoplayer2/w$a;
    //   1190: pop
    //   1191: aload_1
    //   1192: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   1195: getfield 691	com/google/android/exoplayer2/w$a:avx	[I
    //   1198: iload_2
    //   1199: iaload
    //   1200: istore_3
    //   1201: iload_3
    //   1202: iconst_m1
    //   1203: if_icmpne +8 -> 1211
    //   1206: aconst_null
    //   1207: astore_1
    //   1208: goto -481 -> 727
    //   1211: aload 16
    //   1213: getfield 694	com/google/android/exoplayer2/source/f$b:aIo	I
    //   1216: iconst_1
    //   1217: iadd
    //   1218: istore 4
    //   1220: iload 4
    //   1222: iload_3
    //   1223: if_icmpge +42 -> 1265
    //   1226: aload_1
    //   1227: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   1230: iload_2
    //   1231: iload 4
    //   1233: invokevirtual 698	com/google/android/exoplayer2/w$a:aD	(II)Z
    //   1236: ifne +8 -> 1244
    //   1239: aconst_null
    //   1240: astore_1
    //   1241: goto -514 -> 727
    //   1244: aload_1
    //   1245: aload 16
    //   1247: getfield 239	com/google/android/exoplayer2/source/f$b:aIm	I
    //   1250: iload_2
    //   1251: iload 4
    //   1253: aload 15
    //   1255: getfield 656	com/google/android/exoplayer2/n$a:auh	J
    //   1258: invokevirtual 701	com/google/android/exoplayer2/n:b	(IIIJ)Lcom/google/android/exoplayer2/n$a;
    //   1261: astore_1
    //   1262: goto -535 -> 727
    //   1265: aload_1
    //   1266: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   1269: aload 15
    //   1271: getfield 656	com/google/android/exoplayer2/n$a:auh	J
    //   1274: invokevirtual 243	com/google/android/exoplayer2/w$a:z	(J)I
    //   1277: istore_2
    //   1278: iload_2
    //   1279: iconst_m1
    //   1280: if_icmpne +28 -> 1308
    //   1283: ldc2_w 512
    //   1286: lstore 7
    //   1288: aload_1
    //   1289: aload 16
    //   1291: getfield 239	com/google/android/exoplayer2/source/f$b:aIm	I
    //   1294: aload 15
    //   1296: getfield 656	com/google/android/exoplayer2/n$a:auh	J
    //   1299: lload 7
    //   1301: invokevirtual 704	com/google/android/exoplayer2/n:b	(IJJ)Lcom/google/android/exoplayer2/n$a;
    //   1304: astore_1
    //   1305: goto -578 -> 727
    //   1308: aload_1
    //   1309: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   1312: getfield 247	com/google/android/exoplayer2/w$a:avw	[J
    //   1315: iload_2
    //   1316: laload
    //   1317: lstore 7
    //   1319: goto -31 -> 1288
    //   1322: aload 15
    //   1324: getfield 250	com/google/android/exoplayer2/n$a:auO	J
    //   1327: ldc2_w 512
    //   1330: lcmp
    //   1331: ifeq +53 -> 1384
    //   1334: aload_1
    //   1335: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   1338: aload 15
    //   1340: getfield 250	com/google/android/exoplayer2/n$a:auO	J
    //   1343: invokevirtual 707	com/google/android/exoplayer2/w$a:y	(J)I
    //   1346: istore_2
    //   1347: aload_1
    //   1348: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   1351: iload_2
    //   1352: iconst_0
    //   1353: invokevirtual 698	com/google/android/exoplayer2/w$a:aD	(II)Z
    //   1356: ifne +8 -> 1364
    //   1359: aconst_null
    //   1360: astore_1
    //   1361: goto -634 -> 727
    //   1364: aload_1
    //   1365: aload 16
    //   1367: getfield 239	com/google/android/exoplayer2/source/f$b:aIm	I
    //   1370: iload_2
    //   1371: iconst_0
    //   1372: aload 15
    //   1374: getfield 250	com/google/android/exoplayer2/n$a:auO	J
    //   1377: invokevirtual 701	com/google/android/exoplayer2/n:b	(IIIJ)Lcom/google/android/exoplayer2/n$a;
    //   1380: astore_1
    //   1381: goto -654 -> 727
    //   1384: aload_1
    //   1385: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   1388: invokevirtual 710	com/google/android/exoplayer2/w$a:kX	()I
    //   1391: istore_2
    //   1392: iload_2
    //   1393: ifeq +3471 -> 4864
    //   1396: aload_1
    //   1397: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   1400: getfield 247	com/google/android/exoplayer2/w$a:avw	[J
    //   1403: iload_2
    //   1404: iconst_1
    //   1405: isub
    //   1406: laload
    //   1407: ldc2_w 512
    //   1410: lcmp
    //   1411: ifne +3453 -> 4864
    //   1414: aload_1
    //   1415: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   1418: iload_2
    //   1419: iconst_1
    //   1420: isub
    //   1421: invokevirtual 713	com/google/android/exoplayer2/w$a:cD	(I)Z
    //   1424: ifne +3440 -> 4864
    //   1427: aload_1
    //   1428: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   1431: iload_2
    //   1432: iconst_1
    //   1433: isub
    //   1434: iconst_0
    //   1435: invokevirtual 698	com/google/android/exoplayer2/w$a:aD	(II)Z
    //   1438: ifne +6 -> 1444
    //   1441: goto +3423 -> 4864
    //   1444: aload_1
    //   1445: getfield 660	com/google/android/exoplayer2/n:atl	Lcom/google/android/exoplayer2/w$a;
    //   1448: getfield 714	com/google/android/exoplayer2/w$a:auP	J
    //   1451: lstore 7
    //   1453: aload_1
    //   1454: aload 16
    //   1456: getfield 239	com/google/android/exoplayer2/source/f$b:aIm	I
    //   1459: iload_2
    //   1460: iconst_1
    //   1461: isub
    //   1462: iconst_0
    //   1463: lload 7
    //   1465: invokevirtual 701	com/google/android/exoplayer2/n:b	(IIIJ)Lcom/google/android/exoplayer2/n$a;
    //   1468: astore_1
    //   1469: goto -742 -> 727
    //   1472: aload_0
    //   1473: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   1476: ifnonnull +123 -> 1599
    //   1479: ldc2_w 373
    //   1482: lstore 7
    //   1484: aload_0
    //   1485: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   1488: ifnonnull +134 -> 1622
    //   1491: iconst_0
    //   1492: istore_2
    //   1493: aload_0
    //   1494: getfield 236	com/google/android/exoplayer2/i:atr	Lcom/google/android/exoplayer2/w;
    //   1497: aload_1
    //   1498: getfield 225	com/google/android/exoplayer2/n$a:auN	Lcom/google/android/exoplayer2/source/f$b;
    //   1501: getfield 239	com/google/android/exoplayer2/source/f$b:aIm	I
    //   1504: aload_0
    //   1505: getfield 130	com/google/android/exoplayer2/i:atl	Lcom/google/android/exoplayer2/w$a;
    //   1508: iconst_1
    //   1509: invokevirtual 186	com/google/android/exoplayer2/w:a	(ILcom/google/android/exoplayer2/w$a;Z)Lcom/google/android/exoplayer2/w$a;
    //   1512: getfield 190	com/google/android/exoplayer2/w$a:atW	Ljava/lang/Object;
    //   1515: astore 15
    //   1517: new 14	com/google/android/exoplayer2/i$a
    //   1520: dup
    //   1521: aload_0
    //   1522: getfield 83	com/google/android/exoplayer2/i:atf	[Lcom/google/android/exoplayer2/r;
    //   1525: aload_0
    //   1526: getfield 103	com/google/android/exoplayer2/i:atB	[Lcom/google/android/exoplayer2/s;
    //   1529: lload 7
    //   1531: aload_0
    //   1532: getfield 85	com/google/android/exoplayer2/i:atg	Lcom/google/android/exoplayer2/g/g;
    //   1535: aload_0
    //   1536: getfield 87	com/google/android/exoplayer2/i:atC	Lcom/google/android/exoplayer2/m;
    //   1539: aload_0
    //   1540: getfield 384	com/google/android/exoplayer2/i:atJ	Lcom/google/android/exoplayer2/source/f;
    //   1543: aload 15
    //   1545: iload_2
    //   1546: aload_1
    //   1547: invokespecial 717	com/google/android/exoplayer2/i$a:<init>	([Lcom/google/android/exoplayer2/r;[Lcom/google/android/exoplayer2/s;JLcom/google/android/exoplayer2/g/g;Lcom/google/android/exoplayer2/m;Lcom/google/android/exoplayer2/source/f;Ljava/lang/Object;ILcom/google/android/exoplayer2/n$a;)V
    //   1550: astore 15
    //   1552: aload_0
    //   1553: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   1556: ifnull +12 -> 1568
    //   1559: aload_0
    //   1560: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   1563: aload 15
    //   1565: putfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   1568: aload_0
    //   1569: aload 15
    //   1571: putfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   1574: aload_0
    //   1575: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   1578: getfield 268	com/google/android/exoplayer2/i$a:atV	Lcom/google/android/exoplayer2/source/e;
    //   1581: aload_0
    //   1582: aload_1
    //   1583: getfield 655	com/google/android/exoplayer2/n$a:aug	J
    //   1586: invokeinterface 720 4 0
    //   1591: aload_0
    //   1592: iconst_1
    //   1593: invokespecial 382	com/google/android/exoplayer2/i:au	(Z)V
    //   1596: goto -856 -> 740
    //   1599: aload_0
    //   1600: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   1603: invokevirtual 455	com/google/android/exoplayer2/i$a:kM	()J
    //   1606: aload_0
    //   1607: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   1610: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   1613: getfield 516	com/google/android/exoplayer2/n$a:auP	J
    //   1616: ladd
    //   1617: lstore 7
    //   1619: goto -135 -> 1484
    //   1622: aload_0
    //   1623: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   1626: getfield 628	com/google/android/exoplayer2/i$a:index	I
    //   1629: iconst_1
    //   1630: iadd
    //   1631: istore_2
    //   1632: goto -139 -> 1493
    //   1635: aload_0
    //   1636: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   1639: ifnull -877 -> 762
    //   1642: aload_0
    //   1643: getfield 354	com/google/android/exoplayer2/i:isLoading	Z
    //   1646: ifne -884 -> 762
    //   1649: aload_0
    //   1650: invokespecial 280	com/google/android/exoplayer2/i:kL	()V
    //   1653: goto -891 -> 762
    //   1656: aload_0
    //   1657: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   1660: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   1663: getfield 659	com/google/android/exoplayer2/n$a:auR	Z
    //   1666: ifeq +3210 -> 4876
    //   1669: iconst_0
    //   1670: istore_2
    //   1671: iload_2
    //   1672: aload_0
    //   1673: getfield 83	com/google/android/exoplayer2/i:atf	[Lcom/google/android/exoplayer2/r;
    //   1676: arraylength
    //   1677: if_icmpge -1011 -> 666
    //   1680: aload_0
    //   1681: getfield 83	com/google/android/exoplayer2/i:atf	[Lcom/google/android/exoplayer2/r;
    //   1684: iload_2
    //   1685: aaload
    //   1686: astore_1
    //   1687: aload_0
    //   1688: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   1691: getfield 417	com/google/android/exoplayer2/i$a:atX	[Lcom/google/android/exoplayer2/source/i;
    //   1694: iload_2
    //   1695: aaload
    //   1696: astore 15
    //   1698: aload 15
    //   1700: ifnull +3169 -> 4869
    //   1703: aload_1
    //   1704: invokeinterface 413 1 0
    //   1709: aload 15
    //   1711: if_acmpne +3158 -> 4869
    //   1714: aload_1
    //   1715: invokeinterface 542 1 0
    //   1720: ifeq +3149 -> 4869
    //   1723: aload_1
    //   1724: invokeinterface 723 1 0
    //   1729: goto +3140 -> 4869
    //   1732: iload_2
    //   1733: aload_0
    //   1734: getfield 83	com/google/android/exoplayer2/i:atf	[Lcom/google/android/exoplayer2/r;
    //   1737: arraylength
    //   1738: if_icmpge +49 -> 1787
    //   1741: aload_0
    //   1742: getfield 83	com/google/android/exoplayer2/i:atf	[Lcom/google/android/exoplayer2/r;
    //   1745: iload_2
    //   1746: aaload
    //   1747: astore_1
    //   1748: aload_0
    //   1749: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   1752: getfield 417	com/google/android/exoplayer2/i$a:atX	[Lcom/google/android/exoplayer2/source/i;
    //   1755: iload_2
    //   1756: aaload
    //   1757: astore 15
    //   1759: aload_1
    //   1760: invokeinterface 413 1 0
    //   1765: aload 15
    //   1767: if_acmpne -1101 -> 666
    //   1770: aload 15
    //   1772: ifnull +3109 -> 4881
    //   1775: aload_1
    //   1776: invokeinterface 542 1 0
    //   1781: ifeq -1115 -> 666
    //   1784: goto +3097 -> 4881
    //   1787: aload_0
    //   1788: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   1791: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   1794: ifnull -1128 -> 666
    //   1797: aload_0
    //   1798: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   1801: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   1804: getfield 234	com/google/android/exoplayer2/i$a:prepared	Z
    //   1807: ifeq -1141 -> 666
    //   1810: aload_0
    //   1811: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   1814: getfield 394	com/google/android/exoplayer2/i$a:aud	Lcom/google/android/exoplayer2/g/h;
    //   1817: astore_1
    //   1818: aload_0
    //   1819: aload_0
    //   1820: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   1823: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   1826: putfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   1829: aload_0
    //   1830: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   1833: getfield 394	com/google/android/exoplayer2/i$a:aud	Lcom/google/android/exoplayer2/g/h;
    //   1836: astore 15
    //   1838: aload_0
    //   1839: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   1842: getfield 268	com/google/android/exoplayer2/i$a:atV	Lcom/google/android/exoplayer2/source/e;
    //   1845: invokeinterface 504 1 0
    //   1850: ldc2_w 433
    //   1853: lcmp
    //   1854: ifeq +3039 -> 4893
    //   1857: iconst_1
    //   1858: istore_2
    //   1859: goto +3029 -> 4888
    //   1862: iload_3
    //   1863: aload_0
    //   1864: getfield 83	com/google/android/exoplayer2/i:atf	[Lcom/google/android/exoplayer2/r;
    //   1867: arraylength
    //   1868: if_icmpge -1202 -> 666
    //   1871: aload_0
    //   1872: getfield 83	com/google/android/exoplayer2/i:atf	[Lcom/google/android/exoplayer2/r;
    //   1875: iload_3
    //   1876: aaload
    //   1877: astore 16
    //   1879: aload_1
    //   1880: getfield 400	com/google/android/exoplayer2/g/h:aQJ	Lcom/google/android/exoplayer2/g/f;
    //   1883: getfield 406	com/google/android/exoplayer2/g/f:aQG	[Lcom/google/android/exoplayer2/g/e;
    //   1886: iload_3
    //   1887: aaload
    //   1888: ifnull +3010 -> 4898
    //   1891: iload_2
    //   1892: ifne +131 -> 2023
    //   1895: aload 16
    //   1897: invokeinterface 409 1 0
    //   1902: ifne +2996 -> 4898
    //   1905: aload 15
    //   1907: getfield 400	com/google/android/exoplayer2/g/h:aQJ	Lcom/google/android/exoplayer2/g/f;
    //   1910: getfield 406	com/google/android/exoplayer2/g/f:aQG	[Lcom/google/android/exoplayer2/g/e;
    //   1913: iload_3
    //   1914: aaload
    //   1915: astore 17
    //   1917: aload_1
    //   1918: getfield 440	com/google/android/exoplayer2/g/h:aQL	[Lcom/google/android/exoplayer2/t;
    //   1921: iload_3
    //   1922: aaload
    //   1923: astore 18
    //   1925: aload 15
    //   1927: getfield 440	com/google/android/exoplayer2/g/h:aQL	[Lcom/google/android/exoplayer2/t;
    //   1930: iload_3
    //   1931: aaload
    //   1932: astore 19
    //   1934: aload 17
    //   1936: ifnull +87 -> 2023
    //   1939: aload 19
    //   1941: aload 18
    //   1943: invokevirtual 726	com/google/android/exoplayer2/t:equals	(Ljava/lang/Object;)Z
    //   1946: ifeq +77 -> 2023
    //   1949: aload 17
    //   1951: invokeinterface 445 1 0
    //   1956: anewarray 447	com/google/android/exoplayer2/Format
    //   1959: astore 18
    //   1961: iconst_0
    //   1962: istore 4
    //   1964: iload 4
    //   1966: aload 18
    //   1968: arraylength
    //   1969: if_icmpge +26 -> 1995
    //   1972: aload 18
    //   1974: iload 4
    //   1976: aload 17
    //   1978: iload 4
    //   1980: invokeinterface 451 2 0
    //   1985: aastore
    //   1986: iload 4
    //   1988: iconst_1
    //   1989: iadd
    //   1990: istore 4
    //   1992: goto -28 -> 1964
    //   1995: aload 16
    //   1997: aload 18
    //   1999: aload_0
    //   2000: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   2003: getfield 417	com/google/android/exoplayer2/i$a:atX	[Lcom/google/android/exoplayer2/source/i;
    //   2006: iload_3
    //   2007: aaload
    //   2008: aload_0
    //   2009: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   2012: invokevirtual 455	com/google/android/exoplayer2/i$a:kM	()J
    //   2015: invokeinterface 729 5 0
    //   2020: goto +2878 -> 4898
    //   2023: aload 16
    //   2025: invokeinterface 723 1 0
    //   2030: goto +2868 -> 4898
    //   2033: ldc_w 731
    //   2036: invokestatic 736	com/google/android/exoplayer2/i/r:beginSection	(Ljava/lang/String;)V
    //   2039: aload_0
    //   2040: invokespecial 619	com/google/android/exoplayer2/i:kI	()V
    //   2043: aload_0
    //   2044: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   2047: getfield 268	com/google/android/exoplayer2/i$a:atV	Lcom/google/android/exoplayer2/source/e;
    //   2050: aload_0
    //   2051: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   2054: getfield 507	com/google/android/exoplayer2/i$b:aui	J
    //   2057: invokeinterface 739 3 0
    //   2062: iconst_1
    //   2063: istore_2
    //   2064: iconst_1
    //   2065: istore 6
    //   2067: aload_0
    //   2068: getfield 120	com/google/android/exoplayer2/i:atK	[Lcom/google/android/exoplayer2/r;
    //   2071: astore_1
    //   2072: aload_1
    //   2073: arraylength
    //   2074: istore 5
    //   2076: iconst_0
    //   2077: istore_3
    //   2078: iload_3
    //   2079: iload 5
    //   2081: if_icmpge +77 -> 2158
    //   2084: aload_1
    //   2085: iload_3
    //   2086: aaload
    //   2087: astore 15
    //   2089: aload 15
    //   2091: aload_0
    //   2092: getfield 376	com/google/android/exoplayer2/i:atR	J
    //   2095: aload_0
    //   2096: getfield 511	com/google/android/exoplayer2/i:atO	J
    //   2099: invokeinterface 742 5 0
    //   2104: iload_2
    //   2105: ifeq +2826 -> 4931
    //   2108: aload 15
    //   2110: invokeinterface 522 1 0
    //   2115: ifeq +2816 -> 4931
    //   2118: iconst_1
    //   2119: istore_2
    //   2120: aload 15
    //   2122: invokeinterface 745 1 0
    //   2127: ifne +2778 -> 4905
    //   2130: aload 15
    //   2132: invokeinterface 522 1 0
    //   2137: ifeq +2799 -> 4936
    //   2140: goto +2765 -> 4905
    //   2143: iload 4
    //   2145: ifne +2766 -> 4911
    //   2148: aload 15
    //   2150: invokeinterface 748 1 0
    //   2155: goto +2756 -> 4911
    //   2158: iload 6
    //   2160: ifne +7 -> 2167
    //   2163: aload_0
    //   2164: invokespecial 638	com/google/android/exoplayer2/i:kK	()V
    //   2167: aload_0
    //   2168: getfield 255	com/google/android/exoplayer2/i:atI	Lcom/google/android/exoplayer2/i/f;
    //   2171: ifnull +53 -> 2224
    //   2174: aload_0
    //   2175: getfield 255	com/google/android/exoplayer2/i:atI	Lcom/google/android/exoplayer2/i/f;
    //   2178: invokeinterface 752 1 0
    //   2183: astore_1
    //   2184: aload_1
    //   2185: aload_0
    //   2186: getfield 148	com/google/android/exoplayer2/i:atv	Lcom/google/android/exoplayer2/p;
    //   2189: invokevirtual 753	com/google/android/exoplayer2/p:equals	(Ljava/lang/Object;)Z
    //   2192: ifne +32 -> 2224
    //   2195: aload_0
    //   2196: aload_1
    //   2197: putfield 148	com/google/android/exoplayer2/i:atv	Lcom/google/android/exoplayer2/p;
    //   2200: aload_0
    //   2201: getfield 118	com/google/android/exoplayer2/i:atD	Lcom/google/android/exoplayer2/i/o;
    //   2204: aload_0
    //   2205: getfield 255	com/google/android/exoplayer2/i:atI	Lcom/google/android/exoplayer2/i/f;
    //   2208: invokevirtual 420	com/google/android/exoplayer2/i/o:a	(Lcom/google/android/exoplayer2/i/f;)V
    //   2211: aload_0
    //   2212: getfield 93	com/google/android/exoplayer2/i:eventHandler	Landroid/os/Handler;
    //   2215: bipush 7
    //   2217: aload_1
    //   2218: invokevirtual 423	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   2221: invokevirtual 363	android/os/Message:sendToTarget	()V
    //   2224: aload_0
    //   2225: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   2228: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   2231: getfield 516	com/google/android/exoplayer2/n$a:auP	J
    //   2234: lstore 7
    //   2236: iload_2
    //   2237: ifeq +85 -> 2322
    //   2240: lload 7
    //   2242: ldc2_w 433
    //   2245: lcmp
    //   2246: ifeq +16 -> 2262
    //   2249: lload 7
    //   2251: aload_0
    //   2252: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   2255: getfield 507	com/google/android/exoplayer2/i$b:aui	J
    //   2258: lcmp
    //   2259: ifgt +63 -> 2322
    //   2262: aload_0
    //   2263: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   2266: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   2269: getfield 659	com/google/android/exoplayer2/n$a:auR	Z
    //   2272: ifeq +50 -> 2322
    //   2275: aload_0
    //   2276: iconst_4
    //   2277: invokespecial 203	com/google/android/exoplayer2/i:setState	(I)V
    //   2280: aload_0
    //   2281: invokespecial 198	com/google/android/exoplayer2/i:kH	()V
    //   2284: aload_0
    //   2285: getfield 95	com/google/android/exoplayer2/i:state	I
    //   2288: iconst_2
    //   2289: if_icmpne +252 -> 2541
    //   2292: aload_0
    //   2293: getfield 120	com/google/android/exoplayer2/i:atK	[Lcom/google/android/exoplayer2/r;
    //   2296: astore_1
    //   2297: aload_1
    //   2298: arraylength
    //   2299: istore_3
    //   2300: iconst_0
    //   2301: istore_2
    //   2302: iload_2
    //   2303: iload_3
    //   2304: if_icmpge +237 -> 2541
    //   2307: aload_1
    //   2308: iload_2
    //   2309: aaload
    //   2310: invokeinterface 748 1 0
    //   2315: iload_2
    //   2316: iconst_1
    //   2317: iadd
    //   2318: istore_2
    //   2319: goto -17 -> 2302
    //   2322: aload_0
    //   2323: getfield 95	com/google/android/exoplayer2/i:state	I
    //   2326: iconst_2
    //   2327: if_icmpne +162 -> 2489
    //   2330: aload_0
    //   2331: getfield 120	com/google/android/exoplayer2/i:atK	[Lcom/google/android/exoplayer2/r;
    //   2334: arraylength
    //   2335: ifle +143 -> 2478
    //   2338: iload 6
    //   2340: ifeq +2619 -> 4959
    //   2343: aload_0
    //   2344: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   2347: astore_1
    //   2348: aload_0
    //   2349: getfield 200	com/google/android/exoplayer2/i:atL	Z
    //   2352: istore 6
    //   2354: aload_0
    //   2355: getfield 376	com/google/android/exoplayer2/i:atR	J
    //   2358: lstore 13
    //   2360: aload_1
    //   2361: getfield 234	com/google/android/exoplayer2/i$a:prepared	Z
    //   2364: ifne +65 -> 2429
    //   2367: aload_1
    //   2368: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   2371: getfield 655	com/google/android/exoplayer2/n$a:aug	J
    //   2374: lstore 7
    //   2376: lload 7
    //   2378: lstore 9
    //   2380: lload 7
    //   2382: ldc2_w 512
    //   2385: lcmp
    //   2386: ifne +66 -> 2452
    //   2389: aload_1
    //   2390: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   2393: getfield 659	com/google/android/exoplayer2/n$a:auR	Z
    //   2396: ifeq +47 -> 2443
    //   2399: iconst_1
    //   2400: istore 6
    //   2402: goto +2546 -> 4948
    //   2405: iload 6
    //   2407: ifeq -123 -> 2284
    //   2410: aload_0
    //   2411: iconst_3
    //   2412: invokespecial 203	com/google/android/exoplayer2/i:setState	(I)V
    //   2415: aload_0
    //   2416: getfield 89	com/google/android/exoplayer2/i:atn	Z
    //   2419: ifeq -135 -> 2284
    //   2422: aload_0
    //   2423: invokespecial 621	com/google/android/exoplayer2/i:kG	()V
    //   2426: goto -142 -> 2284
    //   2429: aload_1
    //   2430: getfield 268	com/google/android/exoplayer2/i$a:atV	Lcom/google/android/exoplayer2/source/e;
    //   2433: invokeinterface 532 1 0
    //   2438: lstore 7
    //   2440: goto -64 -> 2376
    //   2443: aload_1
    //   2444: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   2447: getfield 516	com/google/android/exoplayer2/n$a:auP	J
    //   2450: lstore 9
    //   2452: aload_1
    //   2453: getfield 552	com/google/android/exoplayer2/i$a:atC	Lcom/google/android/exoplayer2/m;
    //   2456: lload 9
    //   2458: lload 13
    //   2460: aload_1
    //   2461: invokevirtual 455	com/google/android/exoplayer2/i$a:kM	()J
    //   2464: lsub
    //   2465: lsub
    //   2466: iload 6
    //   2468: invokeinterface 756 4 0
    //   2473: istore 6
    //   2475: goto +2473 -> 4948
    //   2478: aload_0
    //   2479: lload 7
    //   2481: invokespecial 758	com/google/android/exoplayer2/i:v	(J)Z
    //   2484: istore 6
    //   2486: goto -81 -> 2405
    //   2489: aload_0
    //   2490: getfield 95	com/google/android/exoplayer2/i:state	I
    //   2493: iconst_3
    //   2494: if_icmpne -210 -> 2284
    //   2497: aload_0
    //   2498: getfield 120	com/google/android/exoplayer2/i:atK	[Lcom/google/android/exoplayer2/r;
    //   2501: arraylength
    //   2502: ifle +28 -> 2530
    //   2505: iload 6
    //   2507: ifne -223 -> 2284
    //   2510: aload_0
    //   2511: aload_0
    //   2512: getfield 89	com/google/android/exoplayer2/i:atn	Z
    //   2515: putfield 200	com/google/android/exoplayer2/i:atL	Z
    //   2518: aload_0
    //   2519: iconst_2
    //   2520: invokespecial 203	com/google/android/exoplayer2/i:setState	(I)V
    //   2523: aload_0
    //   2524: invokespecial 198	com/google/android/exoplayer2/i:kH	()V
    //   2527: goto -243 -> 2284
    //   2530: aload_0
    //   2531: lload 7
    //   2533: invokespecial 758	com/google/android/exoplayer2/i:v	(J)Z
    //   2536: istore 6
    //   2538: goto -33 -> 2505
    //   2541: aload_0
    //   2542: getfield 89	com/google/android/exoplayer2/i:atn	Z
    //   2545: ifeq +11 -> 2556
    //   2548: aload_0
    //   2549: getfield 95	com/google/android/exoplayer2/i:state	I
    //   2552: iconst_3
    //   2553: if_icmpeq +11 -> 2564
    //   2556: aload_0
    //   2557: getfield 95	com/google/android/exoplayer2/i:state	I
    //   2560: iconst_2
    //   2561: if_icmpne +18 -> 2579
    //   2564: aload_0
    //   2565: lload 11
    //   2567: ldc2_w 639
    //   2570: invokespecial 642	com/google/android/exoplayer2/i:e	(JJ)V
    //   2573: invokestatic 761	com/google/android/exoplayer2/i/r:endSection	()V
    //   2576: goto +2280 -> 4856
    //   2579: aload_0
    //   2580: getfield 120	com/google/android/exoplayer2/i:atK	[Lcom/google/android/exoplayer2/r;
    //   2583: arraylength
    //   2584: ifeq +23 -> 2607
    //   2587: aload_0
    //   2588: getfield 95	com/google/android/exoplayer2/i:state	I
    //   2591: iconst_4
    //   2592: if_icmpeq +15 -> 2607
    //   2595: aload_0
    //   2596: lload 11
    //   2598: ldc2_w 508
    //   2601: invokespecial 642	com/google/android/exoplayer2/i:e	(JJ)V
    //   2604: goto -31 -> 2573
    //   2607: aload_0
    //   2608: getfield 171	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   2611: iconst_2
    //   2612: invokevirtual 371	android/os/Handler:removeMessages	(I)V
    //   2615: goto -42 -> 2573
    //   2618: aload_1
    //   2619: getfield 597	android/os/Message:obj	Ljava/lang/Object;
    //   2622: checkcast 18	com/google/android/exoplayer2/i$c
    //   2625: astore_1
    //   2626: aload_0
    //   2627: getfield 236	com/google/android/exoplayer2/i:atr	Lcom/google/android/exoplayer2/w;
    //   2630: ifnonnull +21 -> 2651
    //   2633: aload_0
    //   2634: aload_0
    //   2635: getfield 763	com/google/android/exoplayer2/i:atP	I
    //   2638: iconst_1
    //   2639: iadd
    //   2640: putfield 763	com/google/android/exoplayer2/i:atP	I
    //   2643: aload_0
    //   2644: aload_1
    //   2645: putfield 765	com/google/android/exoplayer2/i:atQ	Lcom/google/android/exoplayer2/i$c;
    //   2648: goto +2317 -> 4965
    //   2651: aload_0
    //   2652: aload_1
    //   2653: invokespecial 767	com/google/android/exoplayer2/i:a	(Lcom/google/android/exoplayer2/i$c;)Landroid/util/Pair;
    //   2656: astore 15
    //   2658: aload 15
    //   2660: ifnonnull +59 -> 2719
    //   2663: aload_0
    //   2664: new 16	com/google/android/exoplayer2/i$b
    //   2667: dup
    //   2668: lconst_0
    //   2669: invokespecial 429	com/google/android/exoplayer2/i$b:<init>	(J)V
    //   2672: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   2675: aload_0
    //   2676: getfield 93	com/google/android/exoplayer2/i:eventHandler	Landroid/os/Handler;
    //   2679: iconst_4
    //   2680: iconst_1
    //   2681: iconst_0
    //   2682: aload_0
    //   2683: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   2686: invokevirtual 770	android/os/Handler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   2689: invokevirtual 363	android/os/Message:sendToTarget	()V
    //   2692: aload_0
    //   2693: new 16	com/google/android/exoplayer2/i$b
    //   2696: dup
    //   2697: ldc2_w 433
    //   2700: invokespecial 429	com/google/android/exoplayer2/i$b:<init>	(J)V
    //   2703: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   2706: aload_0
    //   2707: iconst_4
    //   2708: invokespecial 203	com/google/android/exoplayer2/i:setState	(I)V
    //   2711: aload_0
    //   2712: iconst_0
    //   2713: invokespecial 436	com/google/android/exoplayer2/i:av	(Z)V
    //   2716: goto +2249 -> 4965
    //   2719: aload_1
    //   2720: getfield 298	com/google/android/exoplayer2/i$c:aul	J
    //   2723: ldc2_w 433
    //   2726: lcmp
    //   2727: ifne +148 -> 2875
    //   2730: iconst_1
    //   2731: istore_2
    //   2732: aload 15
    //   2734: getfield 311	android/util/Pair:first	Ljava/lang/Object;
    //   2737: checkcast 313	java/lang/Integer
    //   2740: invokevirtual 316	java/lang/Integer:intValue	()I
    //   2743: istore_3
    //   2744: aload 15
    //   2746: getfield 323	android/util/Pair:second	Ljava/lang/Object;
    //   2749: checkcast 678	java/lang/Long
    //   2752: invokevirtual 681	java/lang/Long:longValue	()J
    //   2755: lstore 9
    //   2757: aload_0
    //   2758: getfield 135	com/google/android/exoplayer2/i:atG	Lcom/google/android/exoplayer2/n;
    //   2761: iload_3
    //   2762: lload 9
    //   2764: invokevirtual 684	com/google/android/exoplayer2/n:e	(IJ)Lcom/google/android/exoplayer2/source/f$b;
    //   2767: astore 15
    //   2769: aload 15
    //   2771: invokevirtual 562	com/google/android/exoplayer2/source/f$b:mG	()Z
    //   2774: istore 6
    //   2776: iload 6
    //   2778: ifeq +2032 -> 4810
    //   2781: lconst_0
    //   2782: lstore 7
    //   2784: iconst_1
    //   2785: istore_2
    //   2786: aload 15
    //   2788: aload_0
    //   2789: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   2792: getfield 609	com/google/android/exoplayer2/i$b:auf	Lcom/google/android/exoplayer2/source/f$b;
    //   2795: invokevirtual 231	com/google/android/exoplayer2/source/f$b:equals	(Ljava/lang/Object;)Z
    //   2798: ifeq +87 -> 2885
    //   2801: lload 7
    //   2803: ldc2_w 508
    //   2806: ldiv
    //   2807: lstore 11
    //   2809: aload_0
    //   2810: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   2813: getfield 507	com/google/android/exoplayer2/i$b:aui	J
    //   2816: ldc2_w 508
    //   2819: ldiv
    //   2820: lstore 13
    //   2822: lload 11
    //   2824: lload 13
    //   2826: lcmp
    //   2827: ifne +58 -> 2885
    //   2830: aload_0
    //   2831: new 16	com/google/android/exoplayer2/i$b
    //   2834: dup
    //   2835: aload 15
    //   2837: lload 7
    //   2839: lload 9
    //   2841: invokespecial 615	com/google/android/exoplayer2/i$b:<init>	(Lcom/google/android/exoplayer2/source/f$b;JJ)V
    //   2844: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   2847: aload_0
    //   2848: getfield 93	com/google/android/exoplayer2/i:eventHandler	Landroid/os/Handler;
    //   2851: astore_1
    //   2852: iload_2
    //   2853: ifeq +27 -> 2880
    //   2856: iconst_1
    //   2857: istore_2
    //   2858: aload_1
    //   2859: iconst_4
    //   2860: iload_2
    //   2861: iconst_0
    //   2862: aload_0
    //   2863: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   2866: invokevirtual 770	android/os/Handler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   2869: invokevirtual 363	android/os/Message:sendToTarget	()V
    //   2872: goto +2093 -> 4965
    //   2875: iconst_0
    //   2876: istore_2
    //   2877: goto -145 -> 2732
    //   2880: iconst_0
    //   2881: istore_2
    //   2882: goto -24 -> 2858
    //   2885: aload_0
    //   2886: aload 15
    //   2888: lload 7
    //   2890: invokespecial 633	com/google/android/exoplayer2/i:a	(Lcom/google/android/exoplayer2/source/f$b;J)J
    //   2893: lstore 11
    //   2895: lload 7
    //   2897: lload 11
    //   2899: lcmp
    //   2900: ifeq +2067 -> 4967
    //   2903: iconst_1
    //   2904: istore_3
    //   2905: aload_0
    //   2906: new 16	com/google/android/exoplayer2/i$b
    //   2909: dup
    //   2910: aload 15
    //   2912: lload 11
    //   2914: lload 9
    //   2916: invokespecial 615	com/google/android/exoplayer2/i$b:<init>	(Lcom/google/android/exoplayer2/source/f$b;JJ)V
    //   2919: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   2922: aload_0
    //   2923: getfield 93	com/google/android/exoplayer2/i:eventHandler	Landroid/os/Handler;
    //   2926: astore_1
    //   2927: iload_2
    //   2928: iload_3
    //   2929: ior
    //   2930: ifeq +2042 -> 4972
    //   2933: iconst_1
    //   2934: istore_2
    //   2935: aload_1
    //   2936: iconst_4
    //   2937: iload_2
    //   2938: iconst_0
    //   2939: aload_0
    //   2940: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   2943: invokevirtual 770	android/os/Handler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   2946: invokevirtual 363	android/os/Message:sendToTarget	()V
    //   2949: goto +2016 -> 4965
    //   2952: astore_1
    //   2953: aload_0
    //   2954: new 16	com/google/android/exoplayer2/i$b
    //   2957: dup
    //   2958: aload 15
    //   2960: lload 7
    //   2962: lload 9
    //   2964: invokespecial 615	com/google/android/exoplayer2/i$b:<init>	(Lcom/google/android/exoplayer2/source/f$b;JJ)V
    //   2967: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   2970: aload_0
    //   2971: getfield 93	com/google/android/exoplayer2/i:eventHandler	Landroid/os/Handler;
    //   2974: astore 15
    //   2976: iload_2
    //   2977: ifeq +2000 -> 4977
    //   2980: iconst_1
    //   2981: istore_2
    //   2982: aload 15
    //   2984: iconst_4
    //   2985: iload_2
    //   2986: iconst_0
    //   2987: aload_0
    //   2988: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   2991: invokevirtual 770	android/os/Handler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   2994: invokevirtual 363	android/os/Message:sendToTarget	()V
    //   2997: aload_1
    //   2998: athrow
    //   2999: aload_1
    //   3000: getfield 597	android/os/Message:obj	Ljava/lang/Object;
    //   3003: checkcast 143	com/google/android/exoplayer2/p
    //   3006: astore_1
    //   3007: aload_0
    //   3008: getfield 255	com/google/android/exoplayer2/i:atI	Lcom/google/android/exoplayer2/i/f;
    //   3011: ifnull +34 -> 3045
    //   3014: aload_0
    //   3015: getfield 255	com/google/android/exoplayer2/i:atI	Lcom/google/android/exoplayer2/i/f;
    //   3018: aload_1
    //   3019: invokeinterface 477 2 0
    //   3024: astore_1
    //   3025: aload_0
    //   3026: aload_1
    //   3027: putfield 148	com/google/android/exoplayer2/i:atv	Lcom/google/android/exoplayer2/p;
    //   3030: aload_0
    //   3031: getfield 93	com/google/android/exoplayer2/i:eventHandler	Landroid/os/Handler;
    //   3034: bipush 7
    //   3036: aload_1
    //   3037: invokevirtual 423	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   3040: invokevirtual 363	android/os/Message:sendToTarget	()V
    //   3043: iconst_1
    //   3044: ireturn
    //   3045: aload_0
    //   3046: getfield 118	com/google/android/exoplayer2/i:atD	Lcom/google/android/exoplayer2/i/o;
    //   3049: aload_1
    //   3050: invokevirtual 771	com/google/android/exoplayer2/i/o:b	(Lcom/google/android/exoplayer2/p;)Lcom/google/android/exoplayer2/p;
    //   3053: astore_1
    //   3054: goto -29 -> 3025
    //   3057: aload_0
    //   3058: invokespecial 617	com/google/android/exoplayer2/i:kJ	()V
    //   3061: iconst_1
    //   3062: ireturn
    //   3063: aload_0
    //   3064: iconst_1
    //   3065: invokespecial 436	com/google/android/exoplayer2/i:av	(Z)V
    //   3068: aload_0
    //   3069: getfield 87	com/google/android/exoplayer2/i:atC	Lcom/google/android/exoplayer2/m;
    //   3072: invokeinterface 774 1 0
    //   3077: aload_0
    //   3078: iconst_1
    //   3079: invokespecial 203	com/google/android/exoplayer2/i:setState	(I)V
    //   3082: aload_0
    //   3083: monitorenter
    //   3084: aload_0
    //   3085: iconst_1
    //   3086: putfield 571	com/google/android/exoplayer2/i:released	Z
    //   3089: aload_0
    //   3090: invokevirtual 777	java/lang/Object:notifyAll	()V
    //   3093: aload_0
    //   3094: monitorexit
    //   3095: iconst_1
    //   3096: ireturn
    //   3097: astore_1
    //   3098: aload_0
    //   3099: monitorexit
    //   3100: aload_1
    //   3101: athrow
    //   3102: aload_1
    //   3103: getfield 597	android/os/Message:obj	Ljava/lang/Object;
    //   3106: checkcast 270	com/google/android/exoplayer2/source/e
    //   3109: astore_1
    //   3110: aload_0
    //   3111: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   3114: ifnull +1868 -> 4982
    //   3117: aload_0
    //   3118: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   3121: getfield 268	com/google/android/exoplayer2/i$a:atV	Lcom/google/android/exoplayer2/source/e;
    //   3124: aload_1
    //   3125: if_acmpeq +6 -> 3131
    //   3128: goto +1854 -> 4982
    //   3131: aload_0
    //   3132: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   3135: astore_1
    //   3136: aload_1
    //   3137: iconst_1
    //   3138: putfield 234	com/google/android/exoplayer2/i$a:prepared	Z
    //   3141: aload_1
    //   3142: invokevirtual 780	com/google/android/exoplayer2/i$a:kO	()Z
    //   3145: pop
    //   3146: aload_1
    //   3147: aload_1
    //   3148: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   3151: getfield 655	com/google/android/exoplayer2/n$a:aug	J
    //   3154: invokevirtual 783	com/google/android/exoplayer2/i$a:w	(J)J
    //   3157: lstore 7
    //   3159: aload_1
    //   3160: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   3163: astore 15
    //   3165: aload_1
    //   3166: new 221	com/google/android/exoplayer2/n$a
    //   3169: dup
    //   3170: aload 15
    //   3172: getfield 225	com/google/android/exoplayer2/n$a:auN	Lcom/google/android/exoplayer2/source/f$b;
    //   3175: lload 7
    //   3177: aload 15
    //   3179: getfield 250	com/google/android/exoplayer2/n$a:auO	J
    //   3182: aload 15
    //   3184: getfield 656	com/google/android/exoplayer2/n$a:auh	J
    //   3187: aload 15
    //   3189: getfield 516	com/google/android/exoplayer2/n$a:auP	J
    //   3192: aload 15
    //   3194: getfield 343	com/google/android/exoplayer2/n$a:auQ	Z
    //   3197: aload 15
    //   3199: getfield 659	com/google/android/exoplayer2/n$a:auR	Z
    //   3202: invokespecial 786	com/google/android/exoplayer2/n$a:<init>	(Lcom/google/android/exoplayer2/source/f$b;JJJJZZ)V
    //   3205: putfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   3208: aload_0
    //   3209: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   3212: ifnonnull +33 -> 3245
    //   3215: aload_0
    //   3216: aload_0
    //   3217: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   3220: putfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   3223: aload_0
    //   3224: aload_0
    //   3225: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   3228: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   3231: getfield 655	com/google/android/exoplayer2/n$a:aug	J
    //   3234: invokespecial 277	com/google/android/exoplayer2/i:u	(J)V
    //   3237: aload_0
    //   3238: aload_0
    //   3239: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   3242: invokespecial 261	com/google/android/exoplayer2/i:b	(Lcom/google/android/exoplayer2/i$a;)V
    //   3245: aload_0
    //   3246: invokespecial 280	com/google/android/exoplayer2/i:kL	()V
    //   3249: goto +1733 -> 4982
    //   3252: aload_1
    //   3253: getfield 597	android/os/Message:obj	Ljava/lang/Object;
    //   3256: checkcast 308	android/util/Pair
    //   3259: astore_1
    //   3260: aload_0
    //   3261: getfield 236	com/google/android/exoplayer2/i:atr	Lcom/google/android/exoplayer2/w;
    //   3264: astore 17
    //   3266: aload_0
    //   3267: aload_1
    //   3268: getfield 311	android/util/Pair:first	Ljava/lang/Object;
    //   3271: checkcast 176	com/google/android/exoplayer2/w
    //   3274: putfield 236	com/google/android/exoplayer2/i:atr	Lcom/google/android/exoplayer2/w;
    //   3277: aload_0
    //   3278: getfield 135	com/google/android/exoplayer2/i:atG	Lcom/google/android/exoplayer2/n;
    //   3281: aload_0
    //   3282: getfield 236	com/google/android/exoplayer2/i:atr	Lcom/google/android/exoplayer2/w;
    //   3285: putfield 390	com/google/android/exoplayer2/n:atr	Lcom/google/android/exoplayer2/w;
    //   3288: aload_1
    //   3289: getfield 323	android/util/Pair:second	Ljava/lang/Object;
    //   3292: astore 16
    //   3294: aload 17
    //   3296: ifnonnull +228 -> 3524
    //   3299: aload_0
    //   3300: getfield 763	com/google/android/exoplayer2/i:atP	I
    //   3303: ifle +111 -> 3414
    //   3306: aload_0
    //   3307: aload_0
    //   3308: getfield 765	com/google/android/exoplayer2/i:atQ	Lcom/google/android/exoplayer2/i$c;
    //   3311: invokespecial 767	com/google/android/exoplayer2/i:a	(Lcom/google/android/exoplayer2/i$c;)Landroid/util/Pair;
    //   3314: astore_1
    //   3315: aload_0
    //   3316: getfield 763	com/google/android/exoplayer2/i:atP	I
    //   3319: istore_2
    //   3320: aload_0
    //   3321: iconst_0
    //   3322: putfield 763	com/google/android/exoplayer2/i:atP	I
    //   3325: aload_0
    //   3326: aconst_null
    //   3327: putfield 765	com/google/android/exoplayer2/i:atQ	Lcom/google/android/exoplayer2/i$c;
    //   3330: aload_1
    //   3331: ifnonnull +13 -> 3344
    //   3334: aload_0
    //   3335: aload 16
    //   3337: iload_2
    //   3338: invokespecial 788	com/google/android/exoplayer2/i:b	(Ljava/lang/Object;I)V
    //   3341: goto +1643 -> 4984
    //   3344: aload_1
    //   3345: getfield 311	android/util/Pair:first	Ljava/lang/Object;
    //   3348: checkcast 313	java/lang/Integer
    //   3351: invokevirtual 316	java/lang/Integer:intValue	()I
    //   3354: istore_3
    //   3355: aload_1
    //   3356: getfield 323	android/util/Pair:second	Ljava/lang/Object;
    //   3359: checkcast 678	java/lang/Long
    //   3362: invokevirtual 681	java/lang/Long:longValue	()J
    //   3365: lstore 9
    //   3367: aload_0
    //   3368: getfield 135	com/google/android/exoplayer2/i:atG	Lcom/google/android/exoplayer2/n;
    //   3371: iload_3
    //   3372: lload 9
    //   3374: invokevirtual 684	com/google/android/exoplayer2/n:e	(IJ)Lcom/google/android/exoplayer2/source/f$b;
    //   3377: astore_1
    //   3378: aload_1
    //   3379: invokevirtual 562	com/google/android/exoplayer2/source/f$b:mG	()Z
    //   3382: ifeq +1604 -> 4986
    //   3385: lconst_0
    //   3386: lstore 7
    //   3388: aload_0
    //   3389: new 16	com/google/android/exoplayer2/i$b
    //   3392: dup
    //   3393: aload_1
    //   3394: lload 7
    //   3396: lload 9
    //   3398: invokespecial 615	com/google/android/exoplayer2/i$b:<init>	(Lcom/google/android/exoplayer2/source/f$b;JJ)V
    //   3401: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   3404: aload_0
    //   3405: aload 16
    //   3407: iload_2
    //   3408: invokespecial 432	com/google/android/exoplayer2/i:c	(Ljava/lang/Object;I)V
    //   3411: goto +1573 -> 4984
    //   3414: aload_0
    //   3415: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   3418: getfield 645	com/google/android/exoplayer2/i$b:aug	J
    //   3421: ldc2_w 433
    //   3424: lcmp
    //   3425: ifne +89 -> 3514
    //   3428: aload_0
    //   3429: getfield 236	com/google/android/exoplayer2/i:atr	Lcom/google/android/exoplayer2/w;
    //   3432: invokevirtual 292	com/google/android/exoplayer2/w:isEmpty	()Z
    //   3435: ifeq +13 -> 3448
    //   3438: aload_0
    //   3439: aload 16
    //   3441: iconst_0
    //   3442: invokespecial 788	com/google/android/exoplayer2/i:b	(Ljava/lang/Object;I)V
    //   3445: goto +1539 -> 4984
    //   3448: aload_0
    //   3449: iconst_0
    //   3450: invokespecial 334	com/google/android/exoplayer2/i:cB	(I)Landroid/util/Pair;
    //   3453: astore_1
    //   3454: aload_1
    //   3455: getfield 311	android/util/Pair:first	Ljava/lang/Object;
    //   3458: checkcast 313	java/lang/Integer
    //   3461: invokevirtual 316	java/lang/Integer:intValue	()I
    //   3464: istore_2
    //   3465: aload_1
    //   3466: getfield 323	android/util/Pair:second	Ljava/lang/Object;
    //   3469: checkcast 678	java/lang/Long
    //   3472: invokevirtual 681	java/lang/Long:longValue	()J
    //   3475: lstore 9
    //   3477: aload_0
    //   3478: getfield 135	com/google/android/exoplayer2/i:atG	Lcom/google/android/exoplayer2/n;
    //   3481: iload_2
    //   3482: lload 9
    //   3484: invokevirtual 684	com/google/android/exoplayer2/n:e	(IJ)Lcom/google/android/exoplayer2/source/f$b;
    //   3487: astore_1
    //   3488: aload_1
    //   3489: invokevirtual 562	com/google/android/exoplayer2/source/f$b:mG	()Z
    //   3492: ifeq +1501 -> 4993
    //   3495: lconst_0
    //   3496: lstore 7
    //   3498: aload_0
    //   3499: new 16	com/google/android/exoplayer2/i$b
    //   3502: dup
    //   3503: aload_1
    //   3504: lload 7
    //   3506: lload 9
    //   3508: invokespecial 615	com/google/android/exoplayer2/i$b:<init>	(Lcom/google/android/exoplayer2/source/f$b;JJ)V
    //   3511: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   3514: aload_0
    //   3515: aload 16
    //   3517: iconst_0
    //   3518: invokespecial 432	com/google/android/exoplayer2/i:c	(Ljava/lang/Object;I)V
    //   3521: goto +1463 -> 4984
    //   3524: aload_0
    //   3525: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   3528: getfield 609	com/google/android/exoplayer2/i$b:auf	Lcom/google/android/exoplayer2/source/f$b;
    //   3531: getfield 239	com/google/android/exoplayer2/source/f$b:aIm	I
    //   3534: istore_3
    //   3535: aload_0
    //   3536: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   3539: ifnull +83 -> 3622
    //   3542: aload_0
    //   3543: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   3546: astore_1
    //   3547: aload_1
    //   3548: ifnonnull +12 -> 3560
    //   3551: iload_3
    //   3552: aload 17
    //   3554: invokevirtual 180	com/google/android/exoplayer2/w:kW	()I
    //   3557: if_icmpge +252 -> 3809
    //   3560: aload_1
    //   3561: ifnonnull +69 -> 3630
    //   3564: aload 17
    //   3566: iload_3
    //   3567: aload_0
    //   3568: getfield 130	com/google/android/exoplayer2/i:atl	Lcom/google/android/exoplayer2/w$a;
    //   3571: iconst_1
    //   3572: invokevirtual 186	com/google/android/exoplayer2/w:a	(ILcom/google/android/exoplayer2/w$a;Z)Lcom/google/android/exoplayer2/w$a;
    //   3575: getfield 190	com/google/android/exoplayer2/w$a:atW	Ljava/lang/Object;
    //   3578: astore 15
    //   3580: aload_0
    //   3581: getfield 236	com/google/android/exoplayer2/i:atr	Lcom/google/android/exoplayer2/w;
    //   3584: aload 15
    //   3586: invokevirtual 194	com/google/android/exoplayer2/w:O	(Ljava/lang/Object;)I
    //   3589: istore_2
    //   3590: iload_2
    //   3591: iconst_m1
    //   3592: if_icmpne +227 -> 3819
    //   3595: aload_0
    //   3596: iload_3
    //   3597: aload 17
    //   3599: aload_0
    //   3600: getfield 236	com/google/android/exoplayer2/i:atr	Lcom/google/android/exoplayer2/w;
    //   3603: invokespecial 329	com/google/android/exoplayer2/i:a	(ILcom/google/android/exoplayer2/w;Lcom/google/android/exoplayer2/w;)I
    //   3606: istore_2
    //   3607: iload_2
    //   3608: iconst_m1
    //   3609: if_icmpne +30 -> 3639
    //   3612: aload_0
    //   3613: aload 16
    //   3615: iconst_0
    //   3616: invokespecial 788	com/google/android/exoplayer2/i:b	(Ljava/lang/Object;I)V
    //   3619: goto +1365 -> 4984
    //   3622: aload_0
    //   3623: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   3626: astore_1
    //   3627: goto -80 -> 3547
    //   3630: aload_1
    //   3631: getfield 789	com/google/android/exoplayer2/i$a:atW	Ljava/lang/Object;
    //   3634: astore 15
    //   3636: goto -56 -> 3580
    //   3639: aload_0
    //   3640: aload_0
    //   3641: getfield 236	com/google/android/exoplayer2/i:atr	Lcom/google/android/exoplayer2/w;
    //   3644: iload_2
    //   3645: aload_0
    //   3646: getfield 130	com/google/android/exoplayer2/i:atl	Lcom/google/android/exoplayer2/w$a;
    //   3649: iconst_0
    //   3650: invokevirtual 186	com/google/android/exoplayer2/w:a	(ILcom/google/android/exoplayer2/w$a;Z)Lcom/google/android/exoplayer2/w$a;
    //   3653: getfield 330	com/google/android/exoplayer2/w$a:auk	I
    //   3656: invokespecial 334	com/google/android/exoplayer2/i:cB	(I)Landroid/util/Pair;
    //   3659: astore 15
    //   3661: aload 15
    //   3663: getfield 311	android/util/Pair:first	Ljava/lang/Object;
    //   3666: checkcast 313	java/lang/Integer
    //   3669: invokevirtual 316	java/lang/Integer:intValue	()I
    //   3672: istore_2
    //   3673: aload 15
    //   3675: getfield 323	android/util/Pair:second	Ljava/lang/Object;
    //   3678: checkcast 678	java/lang/Long
    //   3681: invokevirtual 681	java/lang/Long:longValue	()J
    //   3684: lstore 7
    //   3686: aload_0
    //   3687: getfield 236	com/google/android/exoplayer2/i:atr	Lcom/google/android/exoplayer2/w;
    //   3690: iload_2
    //   3691: aload_0
    //   3692: getfield 130	com/google/android/exoplayer2/i:atl	Lcom/google/android/exoplayer2/w$a;
    //   3695: iconst_1
    //   3696: invokevirtual 186	com/google/android/exoplayer2/w:a	(ILcom/google/android/exoplayer2/w$a;Z)Lcom/google/android/exoplayer2/w$a;
    //   3699: pop
    //   3700: aload_1
    //   3701: ifnull +80 -> 3781
    //   3704: aload_0
    //   3705: getfield 130	com/google/android/exoplayer2/i:atl	Lcom/google/android/exoplayer2/w$a;
    //   3708: getfield 190	com/google/android/exoplayer2/w$a:atW	Ljava/lang/Object;
    //   3711: astore 15
    //   3713: aload_1
    //   3714: aload_1
    //   3715: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   3718: invokevirtual 793	com/google/android/exoplayer2/n$a:kS	()Lcom/google/android/exoplayer2/n$a;
    //   3721: putfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   3724: aload_1
    //   3725: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   3728: ifnull +53 -> 3781
    //   3731: aload_1
    //   3732: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   3735: astore_1
    //   3736: aload_1
    //   3737: getfield 789	com/google/android/exoplayer2/i$a:atW	Ljava/lang/Object;
    //   3740: aload 15
    //   3742: invokevirtual 794	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   3745: ifeq +22 -> 3767
    //   3748: aload_1
    //   3749: aload_0
    //   3750: getfield 135	com/google/android/exoplayer2/i:atG	Lcom/google/android/exoplayer2/n;
    //   3753: aload_1
    //   3754: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   3757: iload_2
    //   3758: invokevirtual 340	com/google/android/exoplayer2/n:a	(Lcom/google/android/exoplayer2/n$a;I)Lcom/google/android/exoplayer2/n$a;
    //   3761: putfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   3764: goto -40 -> 3724
    //   3767: aload_1
    //   3768: aload_1
    //   3769: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   3772: invokevirtual 793	com/google/android/exoplayer2/n$a:kS	()Lcom/google/android/exoplayer2/n$a;
    //   3775: putfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   3778: goto -54 -> 3724
    //   3781: new 227	com/google/android/exoplayer2/source/f$b
    //   3784: dup
    //   3785: iload_2
    //   3786: invokespecial 796	com/google/android/exoplayer2/source/f$b:<init>	(I)V
    //   3789: astore_1
    //   3790: aload_0
    //   3791: new 16	com/google/android/exoplayer2/i$b
    //   3794: dup
    //   3795: aload_1
    //   3796: aload_0
    //   3797: aload_1
    //   3798: lload 7
    //   3800: invokespecial 633	com/google/android/exoplayer2/i:a	(Lcom/google/android/exoplayer2/source/f$b;J)J
    //   3803: invokespecial 799	com/google/android/exoplayer2/i$b:<init>	(Lcom/google/android/exoplayer2/source/f$b;J)V
    //   3806: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   3809: aload_0
    //   3810: aload 16
    //   3812: iconst_0
    //   3813: invokespecial 432	com/google/android/exoplayer2/i:c	(Ljava/lang/Object;I)V
    //   3816: goto +1168 -> 4984
    //   3819: iload_2
    //   3820: iload_3
    //   3821: if_icmpeq +63 -> 3884
    //   3824: aload_0
    //   3825: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   3828: astore 15
    //   3830: new 16	com/google/android/exoplayer2/i$b
    //   3833: dup
    //   3834: aload 15
    //   3836: getfield 609	com/google/android/exoplayer2/i$b:auf	Lcom/google/android/exoplayer2/source/f$b;
    //   3839: iload_2
    //   3840: invokevirtual 803	com/google/android/exoplayer2/source/f$b:dg	(I)Lcom/google/android/exoplayer2/source/f$b;
    //   3843: aload 15
    //   3845: getfield 645	com/google/android/exoplayer2/i$b:aug	J
    //   3848: aload 15
    //   3850: getfield 612	com/google/android/exoplayer2/i$b:auh	J
    //   3853: invokespecial 615	com/google/android/exoplayer2/i$b:<init>	(Lcom/google/android/exoplayer2/source/f$b;JJ)V
    //   3856: astore 17
    //   3858: aload 17
    //   3860: aload 15
    //   3862: getfield 507	com/google/android/exoplayer2/i$b:aui	J
    //   3865: putfield 507	com/google/android/exoplayer2/i$b:aui	J
    //   3868: aload 17
    //   3870: aload 15
    //   3872: getfield 519	com/google/android/exoplayer2/i$b:auj	J
    //   3875: putfield 519	com/google/android/exoplayer2/i$b:auj	J
    //   3878: aload_0
    //   3879: aload 17
    //   3881: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   3884: aload_0
    //   3885: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   3888: getfield 609	com/google/android/exoplayer2/i$b:auf	Lcom/google/android/exoplayer2/source/f$b;
    //   3891: invokevirtual 562	com/google/android/exoplayer2/source/f$b:mG	()Z
    //   3894: ifeq +98 -> 3992
    //   3897: aload_0
    //   3898: getfield 135	com/google/android/exoplayer2/i:atG	Lcom/google/android/exoplayer2/n;
    //   3901: iload_2
    //   3902: aload_0
    //   3903: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   3906: getfield 612	com/google/android/exoplayer2/i$b:auh	J
    //   3909: invokevirtual 684	com/google/android/exoplayer2/n:e	(IJ)Lcom/google/android/exoplayer2/source/f$b;
    //   3912: astore 15
    //   3914: aload 15
    //   3916: invokevirtual 562	com/google/android/exoplayer2/source/f$b:mG	()Z
    //   3919: ifeq +21 -> 3940
    //   3922: aload 15
    //   3924: getfield 694	com/google/android/exoplayer2/source/f$b:aIo	I
    //   3927: aload_0
    //   3928: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   3931: getfield 609	com/google/android/exoplayer2/i$b:auf	Lcom/google/android/exoplayer2/source/f$b;
    //   3934: getfield 694	com/google/android/exoplayer2/source/f$b:aIo	I
    //   3937: if_icmpeq +55 -> 3992
    //   3940: aload_0
    //   3941: aload 15
    //   3943: aload_0
    //   3944: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   3947: getfield 612	com/google/android/exoplayer2/i$b:auh	J
    //   3950: invokespecial 633	com/google/android/exoplayer2/i:a	(Lcom/google/android/exoplayer2/source/f$b;J)J
    //   3953: lstore 9
    //   3955: aload 15
    //   3957: invokevirtual 562	com/google/android/exoplayer2/source/f$b:mG	()Z
    //   3960: ifeq +1040 -> 5000
    //   3963: aload_0
    //   3964: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   3967: getfield 612	com/google/android/exoplayer2/i$b:auh	J
    //   3970: lstore 7
    //   3972: aload_0
    //   3973: new 16	com/google/android/exoplayer2/i$b
    //   3976: dup
    //   3977: aload 15
    //   3979: lload 9
    //   3981: lload 7
    //   3983: invokespecial 615	com/google/android/exoplayer2/i$b:<init>	(Lcom/google/android/exoplayer2/source/f$b;JJ)V
    //   3986: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   3989: goto -180 -> 3809
    //   3992: aload_1
    //   3993: ifnull -184 -> 3809
    //   3996: aload_0
    //   3997: aload_1
    //   3998: iload_2
    //   3999: invokespecial 805	com/google/android/exoplayer2/i:a	(Lcom/google/android/exoplayer2/i$a;I)Lcom/google/android/exoplayer2/i$a;
    //   4002: astore_1
    //   4003: aload_1
    //   4004: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   4007: ifnull -198 -> 3809
    //   4010: aload_1
    //   4011: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   4014: astore 15
    //   4016: aload_0
    //   4017: getfield 236	com/google/android/exoplayer2/i:atr	Lcom/google/android/exoplayer2/w;
    //   4020: iload_2
    //   4021: aload_0
    //   4022: getfield 130	com/google/android/exoplayer2/i:atl	Lcom/google/android/exoplayer2/w$a;
    //   4025: aload_0
    //   4026: getfield 125	com/google/android/exoplayer2/i:atk	Lcom/google/android/exoplayer2/w$b;
    //   4029: aload_0
    //   4030: getfield 91	com/google/android/exoplayer2/i:repeatMode	I
    //   4033: invokevirtual 183	com/google/android/exoplayer2/w:a	(ILcom/google/android/exoplayer2/w$a;Lcom/google/android/exoplayer2/w$b;I)I
    //   4036: istore_2
    //   4037: iload_2
    //   4038: iconst_m1
    //   4039: if_icmpeq +41 -> 4080
    //   4042: aload 15
    //   4044: getfield 789	com/google/android/exoplayer2/i$a:atW	Ljava/lang/Object;
    //   4047: aload_0
    //   4048: getfield 236	com/google/android/exoplayer2/i:atr	Lcom/google/android/exoplayer2/w;
    //   4051: iload_2
    //   4052: aload_0
    //   4053: getfield 130	com/google/android/exoplayer2/i:atl	Lcom/google/android/exoplayer2/w$a;
    //   4056: iconst_1
    //   4057: invokevirtual 186	com/google/android/exoplayer2/w:a	(ILcom/google/android/exoplayer2/w$a;Z)Lcom/google/android/exoplayer2/w$a;
    //   4060: getfield 190	com/google/android/exoplayer2/w$a:atW	Ljava/lang/Object;
    //   4063: invokevirtual 794	java/lang/Object:equals	(Ljava/lang/Object;)Z
    //   4066: ifeq +14 -> 4080
    //   4069: aload_0
    //   4070: aload 15
    //   4072: iload_2
    //   4073: invokespecial 805	com/google/android/exoplayer2/i:a	(Lcom/google/android/exoplayer2/i$a;I)Lcom/google/android/exoplayer2/i$a;
    //   4076: astore_1
    //   4077: goto -74 -> 4003
    //   4080: aload_0
    //   4081: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   4084: ifnull +924 -> 5008
    //   4087: aload_0
    //   4088: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   4091: getfield 628	com/google/android/exoplayer2/i$a:index	I
    //   4094: aload 15
    //   4096: getfield 628	com/google/android/exoplayer2/i$a:index	I
    //   4099: if_icmpge +909 -> 5008
    //   4102: iconst_1
    //   4103: istore_2
    //   4104: iload_2
    //   4105: ifne +59 -> 4164
    //   4108: aload_0
    //   4109: aload_0
    //   4110: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   4113: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   4116: getfield 225	com/google/android/exoplayer2/n$a:auN	Lcom/google/android/exoplayer2/source/f$b;
    //   4119: aload_0
    //   4120: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   4123: getfield 507	com/google/android/exoplayer2/i$b:aui	J
    //   4126: invokespecial 633	com/google/android/exoplayer2/i:a	(Lcom/google/android/exoplayer2/source/f$b;J)J
    //   4129: lstore 7
    //   4131: aload_0
    //   4132: new 16	com/google/android/exoplayer2/i$b
    //   4135: dup
    //   4136: aload_0
    //   4137: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   4140: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   4143: getfield 225	com/google/android/exoplayer2/n$a:auN	Lcom/google/android/exoplayer2/source/f$b;
    //   4146: lload 7
    //   4148: aload_0
    //   4149: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   4152: getfield 612	com/google/android/exoplayer2/i$b:auh	J
    //   4155: invokespecial 615	com/google/android/exoplayer2/i$b:<init>	(Lcom/google/android/exoplayer2/source/f$b;JJ)V
    //   4158: putfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   4161: goto -352 -> 3809
    //   4164: aload_0
    //   4165: aload_1
    //   4166: putfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   4169: aload_0
    //   4170: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   4173: aconst_null
    //   4174: putfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   4177: aload 15
    //   4179: invokestatic 380	com/google/android/exoplayer2/i:a	(Lcom/google/android/exoplayer2/i$a;)V
    //   4182: goto -373 -> 3809
    //   4185: aload_1
    //   4186: getfield 597	android/os/Message:obj	Ljava/lang/Object;
    //   4189: checkcast 270	com/google/android/exoplayer2/source/e
    //   4192: astore_1
    //   4193: aload_0
    //   4194: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   4197: ifnull +816 -> 5013
    //   4200: aload_0
    //   4201: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   4204: getfield 268	com/google/android/exoplayer2/i$a:atV	Lcom/google/android/exoplayer2/source/e;
    //   4207: aload_1
    //   4208: if_acmpeq +6 -> 4214
    //   4211: goto +802 -> 5013
    //   4214: aload_0
    //   4215: invokespecial 280	com/google/android/exoplayer2/i:kL	()V
    //   4218: goto +795 -> 5013
    //   4221: aload_0
    //   4222: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   4225: ifnull +790 -> 5015
    //   4228: aload_0
    //   4229: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   4232: astore_1
    //   4233: iconst_1
    //   4234: istore_2
    //   4235: aload_1
    //   4236: ifnull +779 -> 5015
    //   4239: aload_1
    //   4240: getfield 234	com/google/android/exoplayer2/i$a:prepared	Z
    //   4243: ifne +6 -> 4249
    //   4246: goto +769 -> 5015
    //   4249: aload_1
    //   4250: invokevirtual 780	com/google/android/exoplayer2/i$a:kO	()Z
    //   4253: ifne +21 -> 4274
    //   4256: aload_1
    //   4257: aload_0
    //   4258: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   4261: if_acmpne +5 -> 4266
    //   4264: iconst_0
    //   4265: istore_2
    //   4266: aload_1
    //   4267: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   4270: astore_1
    //   4271: goto -36 -> 4235
    //   4274: iload_2
    //   4275: ifeq +313 -> 4588
    //   4278: aload_0
    //   4279: getfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   4282: aload_0
    //   4283: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   4286: if_acmpeq +741 -> 5027
    //   4289: iconst_1
    //   4290: istore 6
    //   4292: aload_0
    //   4293: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   4296: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   4299: invokestatic 380	com/google/android/exoplayer2/i:a	(Lcom/google/android/exoplayer2/i$a;)V
    //   4302: aload_0
    //   4303: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   4306: aconst_null
    //   4307: putfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   4310: aload_0
    //   4311: aload_0
    //   4312: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   4315: putfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   4318: aload_0
    //   4319: aload_0
    //   4320: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   4323: putfield 212	com/google/android/exoplayer2/i:atT	Lcom/google/android/exoplayer2/i$a;
    //   4326: aload_0
    //   4327: getfield 83	com/google/android/exoplayer2/i:atf	[Lcom/google/android/exoplayer2/r;
    //   4330: arraylength
    //   4331: newarray boolean
    //   4333: astore 15
    //   4335: aload_0
    //   4336: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   4339: aload_0
    //   4340: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   4343: getfield 507	com/google/android/exoplayer2/i$b:aui	J
    //   4346: iload 6
    //   4348: aload 15
    //   4350: invokevirtual 808	com/google/android/exoplayer2/i$a:a	(JZ[Z)J
    //   4353: lstore 7
    //   4355: lload 7
    //   4357: aload_0
    //   4358: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   4361: getfield 507	com/google/android/exoplayer2/i$b:aui	J
    //   4364: lcmp
    //   4365: ifeq +18 -> 4383
    //   4368: aload_0
    //   4369: getfield 97	com/google/android/exoplayer2/i:atw	Lcom/google/android/exoplayer2/i$b;
    //   4372: lload 7
    //   4374: putfield 507	com/google/android/exoplayer2/i$b:aui	J
    //   4377: aload_0
    //   4378: lload 7
    //   4380: invokespecial 277	com/google/android/exoplayer2/i:u	(J)V
    //   4383: iconst_0
    //   4384: istore_3
    //   4385: aload_0
    //   4386: getfield 83	com/google/android/exoplayer2/i:atf	[Lcom/google/android/exoplayer2/r;
    //   4389: arraylength
    //   4390: newarray boolean
    //   4392: astore 16
    //   4394: iconst_0
    //   4395: istore_2
    //   4396: iload_2
    //   4397: aload_0
    //   4398: getfield 83	com/google/android/exoplayer2/i:atf	[Lcom/google/android/exoplayer2/r;
    //   4401: arraylength
    //   4402: if_icmpge +144 -> 4546
    //   4405: aload_0
    //   4406: getfield 83	com/google/android/exoplayer2/i:atf	[Lcom/google/android/exoplayer2/r;
    //   4409: iload_2
    //   4410: aaload
    //   4411: astore 17
    //   4413: aload 17
    //   4415: invokeinterface 347 1 0
    //   4420: ifeq +613 -> 5033
    //   4423: iconst_1
    //   4424: istore 6
    //   4426: aload 16
    //   4428: iload_2
    //   4429: iload 6
    //   4431: bastore
    //   4432: aload_0
    //   4433: getfield 205	com/google/android/exoplayer2/i:atU	Lcom/google/android/exoplayer2/i$a;
    //   4436: getfield 417	com/google/android/exoplayer2/i$a:atX	[Lcom/google/android/exoplayer2/source/i;
    //   4439: iload_2
    //   4440: aaload
    //   4441: astore 18
    //   4443: iload_3
    //   4444: istore 4
    //   4446: aload 18
    //   4448: ifnull +8 -> 4456
    //   4451: iload_3
    //   4452: iconst_1
    //   4453: iadd
    //   4454: istore 4
    //   4456: aload 16
    //   4458: iload_2
    //   4459: baload
    //   4460: ifeq +557 -> 5017
    //   4463: aload 18
    //   4465: aload 17
    //   4467: invokeinterface 413 1 0
    //   4472: if_acmpeq +53 -> 4525
    //   4475: aload 17
    //   4477: aload_0
    //   4478: getfield 257	com/google/android/exoplayer2/i:atH	Lcom/google/android/exoplayer2/r;
    //   4481: if_acmpne +29 -> 4510
    //   4484: aload 18
    //   4486: ifnonnull +14 -> 4500
    //   4489: aload_0
    //   4490: getfield 118	com/google/android/exoplayer2/i:atD	Lcom/google/android/exoplayer2/i/o;
    //   4493: aload_0
    //   4494: getfield 255	com/google/android/exoplayer2/i:atI	Lcom/google/android/exoplayer2/i/f;
    //   4497: invokevirtual 420	com/google/android/exoplayer2/i/o:a	(Lcom/google/android/exoplayer2/i/f;)V
    //   4500: aload_0
    //   4501: aconst_null
    //   4502: putfield 255	com/google/android/exoplayer2/i:atI	Lcom/google/android/exoplayer2/i/f;
    //   4505: aload_0
    //   4506: aconst_null
    //   4507: putfield 257	com/google/android/exoplayer2/i:atH	Lcom/google/android/exoplayer2/r;
    //   4510: aload 17
    //   4512: invokestatic 378	com/google/android/exoplayer2/i:a	(Lcom/google/android/exoplayer2/r;)V
    //   4515: aload 17
    //   4517: invokeinterface 215 1 0
    //   4522: goto +495 -> 5017
    //   4525: aload 15
    //   4527: iload_2
    //   4528: baload
    //   4529: ifeq +488 -> 5017
    //   4532: aload 17
    //   4534: aload_0
    //   4535: getfield 376	com/google/android/exoplayer2/i:atR	J
    //   4538: invokeinterface 558 3 0
    //   4543: goto +474 -> 5017
    //   4546: aload_0
    //   4547: getfield 93	com/google/android/exoplayer2/i:eventHandler	Landroid/os/Handler;
    //   4550: iconst_3
    //   4551: aload_1
    //   4552: getfield 394	com/google/android/exoplayer2/i$a:aud	Lcom/google/android/exoplayer2/g/h;
    //   4555: invokevirtual 423	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   4558: invokevirtual 363	android/os/Message:sendToTarget	()V
    //   4561: aload_0
    //   4562: aload 16
    //   4564: iload_3
    //   4565: invokespecial 426	com/google/android/exoplayer2/i:b	([ZI)V
    //   4568: aload_0
    //   4569: invokespecial 280	com/google/android/exoplayer2/i:kL	()V
    //   4572: aload_0
    //   4573: invokespecial 619	com/google/android/exoplayer2/i:kI	()V
    //   4576: aload_0
    //   4577: getfield 171	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   4580: iconst_2
    //   4581: invokevirtual 284	android/os/Handler:sendEmptyMessage	(I)Z
    //   4584: pop
    //   4585: goto +430 -> 5015
    //   4588: aload_0
    //   4589: aload_1
    //   4590: putfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   4593: aload_0
    //   4594: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   4597: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   4600: astore_1
    //   4601: aload_1
    //   4602: ifnull +15 -> 4617
    //   4605: aload_1
    //   4606: invokevirtual 210	com/google/android/exoplayer2/i$a:release	()V
    //   4609: aload_1
    //   4610: getfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   4613: astore_1
    //   4614: goto -13 -> 4601
    //   4617: aload_0
    //   4618: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   4621: aconst_null
    //   4622: putfield 253	com/google/android/exoplayer2/i$a:auc	Lcom/google/android/exoplayer2/i$a;
    //   4625: aload_0
    //   4626: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   4629: getfield 234	com/google/android/exoplayer2/i$a:prepared	Z
    //   4632: ifeq -64 -> 4568
    //   4635: aload_0
    //   4636: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   4639: getfield 219	com/google/android/exoplayer2/i$a:aua	Lcom/google/android/exoplayer2/n$a;
    //   4642: getfield 655	com/google/android/exoplayer2/n$a:aug	J
    //   4645: lstore 7
    //   4647: aload_0
    //   4648: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   4651: astore_1
    //   4652: lload 7
    //   4654: aload_0
    //   4655: getfield 376	com/google/android/exoplayer2/i:atR	J
    //   4658: aload_1
    //   4659: invokevirtual 455	com/google/android/exoplayer2/i$a:kM	()J
    //   4662: lsub
    //   4663: invokestatic 673	java/lang/Math:max	(JJ)J
    //   4666: lstore 7
    //   4668: aload_0
    //   4669: getfield 207	com/google/android/exoplayer2/i:atS	Lcom/google/android/exoplayer2/i$a;
    //   4672: lload 7
    //   4674: invokevirtual 783	com/google/android/exoplayer2/i$a:w	(J)J
    //   4677: pop2
    //   4678: goto -110 -> 4568
    //   4681: aload_1
    //   4682: getfield 597	android/os/Message:obj	Ljava/lang/Object;
    //   4685: checkcast 810	[Lcom/google/android/exoplayer2/f$c;
    //   4688: checkcast 810	[Lcom/google/android/exoplayer2/f$c;
    //   4691: astore_1
    //   4692: aload_1
    //   4693: arraylength
    //   4694: istore_3
    //   4695: iconst_0
    //   4696: istore_2
    //   4697: iload_2
    //   4698: iload_3
    //   4699: if_icmpge +35 -> 4734
    //   4702: aload_1
    //   4703: iload_2
    //   4704: aaload
    //   4705: astore 15
    //   4707: aload 15
    //   4709: getfield 816	com/google/android/exoplayer2/f$c:atc	Lcom/google/android/exoplayer2/f$b;
    //   4712: aload 15
    //   4714: getfield 819	com/google/android/exoplayer2/f$c:atd	I
    //   4717: aload 15
    //   4719: getfield 822	com/google/android/exoplayer2/f$c:ate	Ljava/lang/Object;
    //   4722: invokeinterface 828 3 0
    //   4727: iload_2
    //   4728: iconst_1
    //   4729: iadd
    //   4730: istore_2
    //   4731: goto -34 -> 4697
    //   4734: aload_0
    //   4735: getfield 95	com/google/android/exoplayer2/i:state	I
    //   4738: iconst_3
    //   4739: if_icmpeq +11 -> 4750
    //   4742: aload_0
    //   4743: getfield 95	com/google/android/exoplayer2/i:state	I
    //   4746: iconst_2
    //   4747: if_icmpne +12 -> 4759
    //   4750: aload_0
    //   4751: getfield 171	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   4754: iconst_2
    //   4755: invokevirtual 284	android/os/Handler:sendEmptyMessage	(I)Z
    //   4758: pop
    //   4759: aload_0
    //   4760: monitorenter
    //   4761: aload_0
    //   4762: aload_0
    //   4763: getfield 575	com/google/android/exoplayer2/i:atN	I
    //   4766: iconst_1
    //   4767: iadd
    //   4768: putfield 575	com/google/android/exoplayer2/i:atN	I
    //   4771: aload_0
    //   4772: invokevirtual 777	java/lang/Object:notifyAll	()V
    //   4775: aload_0
    //   4776: monitorexit
    //   4777: iconst_1
    //   4778: ireturn
    //   4779: astore_1
    //   4780: aload_0
    //   4781: monitorexit
    //   4782: aload_1
    //   4783: athrow
    //   4784: astore_1
    //   4785: aload_0
    //   4786: monitorenter
    //   4787: aload_0
    //   4788: aload_0
    //   4789: getfield 575	com/google/android/exoplayer2/i:atN	I
    //   4792: iconst_1
    //   4793: iadd
    //   4794: putfield 575	com/google/android/exoplayer2/i:atN	I
    //   4797: aload_0
    //   4798: invokevirtual 777	java/lang/Object:notifyAll	()V
    //   4801: aload_0
    //   4802: monitorexit
    //   4803: aload_1
    //   4804: athrow
    //   4805: astore_1
    //   4806: aload_0
    //   4807: monitorexit
    //   4808: aload_1
    //   4809: athrow
    //   4810: lload 9
    //   4812: lstore 7
    //   4814: goto -2028 -> 2786
    //   4817: iconst_0
    //   4818: ireturn
    //   4819: iconst_0
    //   4820: istore_2
    //   4821: goto -4731 -> 90
    //   4824: iconst_1
    //   4825: ireturn
    //   4826: iconst_0
    //   4827: istore 6
    //   4829: goto -4598 -> 231
    //   4832: aload_1
    //   4833: ifnull +6 -> 4839
    //   4836: goto -4455 -> 381
    //   4839: iconst_1
    //   4840: ireturn
    //   4841: iconst_m1
    //   4842: istore_2
    //   4843: goto -4342 -> 501
    //   4846: iconst_0
    //   4847: istore_3
    //   4848: goto -4290 -> 558
    //   4851: iconst_0
    //   4852: istore_2
    //   4853: goto -4271 -> 582
    //   4856: iconst_1
    //   4857: ireturn
    //   4858: lconst_0
    //   4859: lstore 7
    //   4861: goto -3728 -> 1133
    //   4864: aconst_null
    //   4865: astore_1
    //   4866: goto -4139 -> 727
    //   4869: iload_2
    //   4870: iconst_1
    //   4871: iadd
    //   4872: istore_2
    //   4873: goto -3202 -> 1671
    //   4876: iconst_0
    //   4877: istore_2
    //   4878: goto -3146 -> 1732
    //   4881: iload_2
    //   4882: iconst_1
    //   4883: iadd
    //   4884: istore_2
    //   4885: goto -3153 -> 1732
    //   4888: iconst_0
    //   4889: istore_3
    //   4890: goto -3028 -> 1862
    //   4893: iconst_0
    //   4894: istore_2
    //   4895: goto -7 -> 4888
    //   4898: iload_3
    //   4899: iconst_1
    //   4900: iadd
    //   4901: istore_3
    //   4902: goto -3040 -> 1862
    //   4905: iconst_1
    //   4906: istore 4
    //   4908: goto -2765 -> 2143
    //   4911: iload 6
    //   4913: ifeq +29 -> 4942
    //   4916: iload 4
    //   4918: ifeq +24 -> 4942
    //   4921: iconst_1
    //   4922: istore 6
    //   4924: iload_3
    //   4925: iconst_1
    //   4926: iadd
    //   4927: istore_3
    //   4928: goto -2850 -> 2078
    //   4931: iconst_0
    //   4932: istore_2
    //   4933: goto -2813 -> 2120
    //   4936: iconst_0
    //   4937: istore 4
    //   4939: goto -2796 -> 2143
    //   4942: iconst_0
    //   4943: istore 6
    //   4945: goto -21 -> 4924
    //   4948: iload 6
    //   4950: ifeq +9 -> 4959
    //   4953: iconst_1
    //   4954: istore 6
    //   4956: goto -2551 -> 2405
    //   4959: iconst_0
    //   4960: istore 6
    //   4962: goto -2557 -> 2405
    //   4965: iconst_1
    //   4966: ireturn
    //   4967: iconst_0
    //   4968: istore_3
    //   4969: goto -2064 -> 2905
    //   4972: iconst_0
    //   4973: istore_2
    //   4974: goto -2039 -> 2935
    //   4977: iconst_0
    //   4978: istore_2
    //   4979: goto -1997 -> 2982
    //   4982: iconst_1
    //   4983: ireturn
    //   4984: iconst_1
    //   4985: ireturn
    //   4986: lload 9
    //   4988: lstore 7
    //   4990: goto -1602 -> 3388
    //   4993: lload 9
    //   4995: lstore 7
    //   4997: goto -1499 -> 3498
    //   5000: ldc2_w 433
    //   5003: lstore 7
    //   5005: goto -1033 -> 3972
    //   5008: iconst_0
    //   5009: istore_2
    //   5010: goto -906 -> 4104
    //   5013: iconst_1
    //   5014: ireturn
    //   5015: iconst_1
    //   5016: ireturn
    //   5017: iload_2
    //   5018: iconst_1
    //   5019: iadd
    //   5020: istore_2
    //   5021: iload 4
    //   5023: istore_3
    //   5024: goto -628 -> 4396
    //   5027: iconst_0
    //   5028: istore 6
    //   5030: goto -738 -> 4292
    //   5033: iconst_0
    //   5034: istore 6
    //   5036: goto -610 -> 4426
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	5039	0	this	i
    //   0	5039	1	paramMessage	Message
    //   89	4932	2	i	int
    //   407	4617	3	j	int
    //   1218	3804	4	k	int
    //   2074	8	5	m	int
    //   229	4806	6	bool	boolean
    //   967	4037	7	l1	long
    //   973	4021	9	l2	long
    //   641	2272	11	l3	long
    //   1063	1762	13	l4	long
    //   79	4639	15	localObject1	Object
    //   530	4033	16	localObject2	Object
    //   1915	2618	17	localObject3	Object
    //   1923	2562	18	localObject4	Object
    //   1932	8	19	localt	t
    // Exception table:
    //   from	to	target	type
    //   0	72	201	com/google/android/exoplayer2/e
    //   72	88	201	com/google/android/exoplayer2/e
    //   90	113	201	com/google/android/exoplayer2/e
    //   117	131	201	com/google/android/exoplayer2/e
    //   131	137	201	com/google/android/exoplayer2/e
    //   142	150	201	com/google/android/exoplayer2/e
    //   150	164	201	com/google/android/exoplayer2/e
    //   166	198	201	com/google/android/exoplayer2/e
    //   221	228	201	com/google/android/exoplayer2/e
    //   231	242	201	com/google/android/exoplayer2/e
    //   247	255	201	com/google/android/exoplayer2/e
    //   258	279	201	com/google/android/exoplayer2/e
    //   305	322	201	com/google/android/exoplayer2/e
    //   348	378	201	com/google/android/exoplayer2/e
    //   381	408	201	com/google/android/exoplayer2/e
    //   408	430	201	com/google/android/exoplayer2/e
    //   433	438	201	com/google/android/exoplayer2/e
    //   446	475	201	com/google/android/exoplayer2/e
    //   478	501	201	com/google/android/exoplayer2/e
    //   501	520	201	com/google/android/exoplayer2/e
    //   520	556	201	com/google/android/exoplayer2/e
    //   562	567	201	com/google/android/exoplayer2/e
    //   572	580	201	com/google/android/exoplayer2/e
    //   586	635	201	com/google/android/exoplayer2/e
    //   638	666	201	com/google/android/exoplayer2/e
    //   666	686	201	com/google/android/exoplayer2/e
    //   689	727	201	com/google/android/exoplayer2/e
    //   731	740	201	com/google/android/exoplayer2/e
    //   740	757	201	com/google/android/exoplayer2/e
    //   757	762	201	com/google/android/exoplayer2/e
    //   762	769	201	com/google/android/exoplayer2/e
    //   769	876	201	com/google/android/exoplayer2/e
    //   879	946	201	com/google/android/exoplayer2/e
    //   946	1011	201	com/google/android/exoplayer2/e
    //   1021	1098	201	com/google/android/exoplayer2/e
    //   1108	1133	201	com/google/android/exoplayer2/e
    //   1133	1149	201	com/google/android/exoplayer2/e
    //   1152	1201	201	com/google/android/exoplayer2/e
    //   1211	1220	201	com/google/android/exoplayer2/e
    //   1226	1239	201	com/google/android/exoplayer2/e
    //   1244	1262	201	com/google/android/exoplayer2/e
    //   1265	1278	201	com/google/android/exoplayer2/e
    //   1288	1305	201	com/google/android/exoplayer2/e
    //   1308	1319	201	com/google/android/exoplayer2/e
    //   1322	1359	201	com/google/android/exoplayer2/e
    //   1364	1381	201	com/google/android/exoplayer2/e
    //   1384	1392	201	com/google/android/exoplayer2/e
    //   1396	1441	201	com/google/android/exoplayer2/e
    //   1444	1469	201	com/google/android/exoplayer2/e
    //   1472	1479	201	com/google/android/exoplayer2/e
    //   1484	1491	201	com/google/android/exoplayer2/e
    //   1493	1568	201	com/google/android/exoplayer2/e
    //   1568	1596	201	com/google/android/exoplayer2/e
    //   1599	1619	201	com/google/android/exoplayer2/e
    //   1622	1632	201	com/google/android/exoplayer2/e
    //   1635	1653	201	com/google/android/exoplayer2/e
    //   1656	1669	201	com/google/android/exoplayer2/e
    //   1671	1698	201	com/google/android/exoplayer2/e
    //   1703	1729	201	com/google/android/exoplayer2/e
    //   1732	1770	201	com/google/android/exoplayer2/e
    //   1775	1784	201	com/google/android/exoplayer2/e
    //   1787	1857	201	com/google/android/exoplayer2/e
    //   1862	1891	201	com/google/android/exoplayer2/e
    //   1895	1934	201	com/google/android/exoplayer2/e
    //   1939	1961	201	com/google/android/exoplayer2/e
    //   1964	1986	201	com/google/android/exoplayer2/e
    //   1995	2020	201	com/google/android/exoplayer2/e
    //   2023	2030	201	com/google/android/exoplayer2/e
    //   2033	2062	201	com/google/android/exoplayer2/e
    //   2067	2076	201	com/google/android/exoplayer2/e
    //   2089	2104	201	com/google/android/exoplayer2/e
    //   2108	2118	201	com/google/android/exoplayer2/e
    //   2120	2140	201	com/google/android/exoplayer2/e
    //   2148	2155	201	com/google/android/exoplayer2/e
    //   2163	2167	201	com/google/android/exoplayer2/e
    //   2167	2224	201	com/google/android/exoplayer2/e
    //   2224	2236	201	com/google/android/exoplayer2/e
    //   2249	2262	201	com/google/android/exoplayer2/e
    //   2262	2284	201	com/google/android/exoplayer2/e
    //   2284	2300	201	com/google/android/exoplayer2/e
    //   2307	2315	201	com/google/android/exoplayer2/e
    //   2322	2338	201	com/google/android/exoplayer2/e
    //   2343	2376	201	com/google/android/exoplayer2/e
    //   2389	2399	201	com/google/android/exoplayer2/e
    //   2410	2426	201	com/google/android/exoplayer2/e
    //   2429	2440	201	com/google/android/exoplayer2/e
    //   2443	2452	201	com/google/android/exoplayer2/e
    //   2452	2475	201	com/google/android/exoplayer2/e
    //   2478	2486	201	com/google/android/exoplayer2/e
    //   2489	2505	201	com/google/android/exoplayer2/e
    //   2510	2527	201	com/google/android/exoplayer2/e
    //   2530	2538	201	com/google/android/exoplayer2/e
    //   2541	2556	201	com/google/android/exoplayer2/e
    //   2556	2564	201	com/google/android/exoplayer2/e
    //   2564	2573	201	com/google/android/exoplayer2/e
    //   2573	2576	201	com/google/android/exoplayer2/e
    //   2579	2604	201	com/google/android/exoplayer2/e
    //   2607	2615	201	com/google/android/exoplayer2/e
    //   2618	2648	201	com/google/android/exoplayer2/e
    //   2651	2658	201	com/google/android/exoplayer2/e
    //   2663	2716	201	com/google/android/exoplayer2/e
    //   2719	2730	201	com/google/android/exoplayer2/e
    //   2732	2776	201	com/google/android/exoplayer2/e
    //   2830	2852	201	com/google/android/exoplayer2/e
    //   2858	2872	201	com/google/android/exoplayer2/e
    //   2905	2927	201	com/google/android/exoplayer2/e
    //   2935	2949	201	com/google/android/exoplayer2/e
    //   2953	2976	201	com/google/android/exoplayer2/e
    //   2982	2999	201	com/google/android/exoplayer2/e
    //   2999	3025	201	com/google/android/exoplayer2/e
    //   3025	3043	201	com/google/android/exoplayer2/e
    //   3045	3054	201	com/google/android/exoplayer2/e
    //   3057	3061	201	com/google/android/exoplayer2/e
    //   3063	3084	201	com/google/android/exoplayer2/e
    //   3100	3102	201	com/google/android/exoplayer2/e
    //   3102	3128	201	com/google/android/exoplayer2/e
    //   3131	3245	201	com/google/android/exoplayer2/e
    //   3245	3249	201	com/google/android/exoplayer2/e
    //   3252	3294	201	com/google/android/exoplayer2/e
    //   3299	3330	201	com/google/android/exoplayer2/e
    //   3334	3341	201	com/google/android/exoplayer2/e
    //   3344	3385	201	com/google/android/exoplayer2/e
    //   3388	3411	201	com/google/android/exoplayer2/e
    //   3414	3445	201	com/google/android/exoplayer2/e
    //   3448	3495	201	com/google/android/exoplayer2/e
    //   3498	3514	201	com/google/android/exoplayer2/e
    //   3514	3521	201	com/google/android/exoplayer2/e
    //   3524	3547	201	com/google/android/exoplayer2/e
    //   3551	3560	201	com/google/android/exoplayer2/e
    //   3564	3580	201	com/google/android/exoplayer2/e
    //   3580	3590	201	com/google/android/exoplayer2/e
    //   3595	3607	201	com/google/android/exoplayer2/e
    //   3612	3619	201	com/google/android/exoplayer2/e
    //   3622	3627	201	com/google/android/exoplayer2/e
    //   3630	3636	201	com/google/android/exoplayer2/e
    //   3639	3700	201	com/google/android/exoplayer2/e
    //   3704	3724	201	com/google/android/exoplayer2/e
    //   3724	3764	201	com/google/android/exoplayer2/e
    //   3767	3778	201	com/google/android/exoplayer2/e
    //   3781	3809	201	com/google/android/exoplayer2/e
    //   3809	3816	201	com/google/android/exoplayer2/e
    //   3824	3884	201	com/google/android/exoplayer2/e
    //   3884	3940	201	com/google/android/exoplayer2/e
    //   3940	3972	201	com/google/android/exoplayer2/e
    //   3972	3989	201	com/google/android/exoplayer2/e
    //   3996	4003	201	com/google/android/exoplayer2/e
    //   4003	4037	201	com/google/android/exoplayer2/e
    //   4042	4077	201	com/google/android/exoplayer2/e
    //   4080	4102	201	com/google/android/exoplayer2/e
    //   4108	4161	201	com/google/android/exoplayer2/e
    //   4164	4182	201	com/google/android/exoplayer2/e
    //   4185	4211	201	com/google/android/exoplayer2/e
    //   4214	4218	201	com/google/android/exoplayer2/e
    //   4221	4233	201	com/google/android/exoplayer2/e
    //   4239	4246	201	com/google/android/exoplayer2/e
    //   4249	4256	201	com/google/android/exoplayer2/e
    //   4256	4264	201	com/google/android/exoplayer2/e
    //   4266	4271	201	com/google/android/exoplayer2/e
    //   4278	4289	201	com/google/android/exoplayer2/e
    //   4292	4383	201	com/google/android/exoplayer2/e
    //   4385	4394	201	com/google/android/exoplayer2/e
    //   4396	4423	201	com/google/android/exoplayer2/e
    //   4432	4443	201	com/google/android/exoplayer2/e
    //   4463	4484	201	com/google/android/exoplayer2/e
    //   4489	4500	201	com/google/android/exoplayer2/e
    //   4500	4510	201	com/google/android/exoplayer2/e
    //   4510	4522	201	com/google/android/exoplayer2/e
    //   4532	4543	201	com/google/android/exoplayer2/e
    //   4546	4568	201	com/google/android/exoplayer2/e
    //   4568	4585	201	com/google/android/exoplayer2/e
    //   4588	4601	201	com/google/android/exoplayer2/e
    //   4605	4614	201	com/google/android/exoplayer2/e
    //   4617	4678	201	com/google/android/exoplayer2/e
    //   4681	4692	201	com/google/android/exoplayer2/e
    //   4759	4761	201	com/google/android/exoplayer2/e
    //   4782	4784	201	com/google/android/exoplayer2/e
    //   4785	4787	201	com/google/android/exoplayer2/e
    //   4803	4805	201	com/google/android/exoplayer2/e
    //   4808	4810	201	com/google/android/exoplayer2/e
    //   0	72	282	java/io/IOException
    //   72	88	282	java/io/IOException
    //   90	113	282	java/io/IOException
    //   117	131	282	java/io/IOException
    //   131	137	282	java/io/IOException
    //   142	150	282	java/io/IOException
    //   150	164	282	java/io/IOException
    //   166	198	282	java/io/IOException
    //   221	228	282	java/io/IOException
    //   231	242	282	java/io/IOException
    //   247	255	282	java/io/IOException
    //   258	279	282	java/io/IOException
    //   305	322	282	java/io/IOException
    //   348	378	282	java/io/IOException
    //   381	408	282	java/io/IOException
    //   408	430	282	java/io/IOException
    //   433	438	282	java/io/IOException
    //   446	475	282	java/io/IOException
    //   478	501	282	java/io/IOException
    //   501	520	282	java/io/IOException
    //   520	556	282	java/io/IOException
    //   562	567	282	java/io/IOException
    //   572	580	282	java/io/IOException
    //   586	635	282	java/io/IOException
    //   638	666	282	java/io/IOException
    //   666	686	282	java/io/IOException
    //   689	727	282	java/io/IOException
    //   731	740	282	java/io/IOException
    //   740	757	282	java/io/IOException
    //   757	762	282	java/io/IOException
    //   762	769	282	java/io/IOException
    //   769	876	282	java/io/IOException
    //   879	946	282	java/io/IOException
    //   946	1011	282	java/io/IOException
    //   1021	1098	282	java/io/IOException
    //   1108	1133	282	java/io/IOException
    //   1133	1149	282	java/io/IOException
    //   1152	1201	282	java/io/IOException
    //   1211	1220	282	java/io/IOException
    //   1226	1239	282	java/io/IOException
    //   1244	1262	282	java/io/IOException
    //   1265	1278	282	java/io/IOException
    //   1288	1305	282	java/io/IOException
    //   1308	1319	282	java/io/IOException
    //   1322	1359	282	java/io/IOException
    //   1364	1381	282	java/io/IOException
    //   1384	1392	282	java/io/IOException
    //   1396	1441	282	java/io/IOException
    //   1444	1469	282	java/io/IOException
    //   1472	1479	282	java/io/IOException
    //   1484	1491	282	java/io/IOException
    //   1493	1568	282	java/io/IOException
    //   1568	1596	282	java/io/IOException
    //   1599	1619	282	java/io/IOException
    //   1622	1632	282	java/io/IOException
    //   1635	1653	282	java/io/IOException
    //   1656	1669	282	java/io/IOException
    //   1671	1698	282	java/io/IOException
    //   1703	1729	282	java/io/IOException
    //   1732	1770	282	java/io/IOException
    //   1775	1784	282	java/io/IOException
    //   1787	1857	282	java/io/IOException
    //   1862	1891	282	java/io/IOException
    //   1895	1934	282	java/io/IOException
    //   1939	1961	282	java/io/IOException
    //   1964	1986	282	java/io/IOException
    //   1995	2020	282	java/io/IOException
    //   2023	2030	282	java/io/IOException
    //   2033	2062	282	java/io/IOException
    //   2067	2076	282	java/io/IOException
    //   2089	2104	282	java/io/IOException
    //   2108	2118	282	java/io/IOException
    //   2120	2140	282	java/io/IOException
    //   2148	2155	282	java/io/IOException
    //   2163	2167	282	java/io/IOException
    //   2167	2224	282	java/io/IOException
    //   2224	2236	282	java/io/IOException
    //   2249	2262	282	java/io/IOException
    //   2262	2284	282	java/io/IOException
    //   2284	2300	282	java/io/IOException
    //   2307	2315	282	java/io/IOException
    //   2322	2338	282	java/io/IOException
    //   2343	2376	282	java/io/IOException
    //   2389	2399	282	java/io/IOException
    //   2410	2426	282	java/io/IOException
    //   2429	2440	282	java/io/IOException
    //   2443	2452	282	java/io/IOException
    //   2452	2475	282	java/io/IOException
    //   2478	2486	282	java/io/IOException
    //   2489	2505	282	java/io/IOException
    //   2510	2527	282	java/io/IOException
    //   2530	2538	282	java/io/IOException
    //   2541	2556	282	java/io/IOException
    //   2556	2564	282	java/io/IOException
    //   2564	2573	282	java/io/IOException
    //   2573	2576	282	java/io/IOException
    //   2579	2604	282	java/io/IOException
    //   2607	2615	282	java/io/IOException
    //   2618	2648	282	java/io/IOException
    //   2651	2658	282	java/io/IOException
    //   2663	2716	282	java/io/IOException
    //   2719	2730	282	java/io/IOException
    //   2732	2776	282	java/io/IOException
    //   2830	2852	282	java/io/IOException
    //   2858	2872	282	java/io/IOException
    //   2905	2927	282	java/io/IOException
    //   2935	2949	282	java/io/IOException
    //   2953	2976	282	java/io/IOException
    //   2982	2999	282	java/io/IOException
    //   2999	3025	282	java/io/IOException
    //   3025	3043	282	java/io/IOException
    //   3045	3054	282	java/io/IOException
    //   3057	3061	282	java/io/IOException
    //   3063	3084	282	java/io/IOException
    //   3100	3102	282	java/io/IOException
    //   3102	3128	282	java/io/IOException
    //   3131	3245	282	java/io/IOException
    //   3245	3249	282	java/io/IOException
    //   3252	3294	282	java/io/IOException
    //   3299	3330	282	java/io/IOException
    //   3334	3341	282	java/io/IOException
    //   3344	3385	282	java/io/IOException
    //   3388	3411	282	java/io/IOException
    //   3414	3445	282	java/io/IOException
    //   3448	3495	282	java/io/IOException
    //   3498	3514	282	java/io/IOException
    //   3514	3521	282	java/io/IOException
    //   3524	3547	282	java/io/IOException
    //   3551	3560	282	java/io/IOException
    //   3564	3580	282	java/io/IOException
    //   3580	3590	282	java/io/IOException
    //   3595	3607	282	java/io/IOException
    //   3612	3619	282	java/io/IOException
    //   3622	3627	282	java/io/IOException
    //   3630	3636	282	java/io/IOException
    //   3639	3700	282	java/io/IOException
    //   3704	3724	282	java/io/IOException
    //   3724	3764	282	java/io/IOException
    //   3767	3778	282	java/io/IOException
    //   3781	3809	282	java/io/IOException
    //   3809	3816	282	java/io/IOException
    //   3824	3884	282	java/io/IOException
    //   3884	3940	282	java/io/IOException
    //   3940	3972	282	java/io/IOException
    //   3972	3989	282	java/io/IOException
    //   3996	4003	282	java/io/IOException
    //   4003	4037	282	java/io/IOException
    //   4042	4077	282	java/io/IOException
    //   4080	4102	282	java/io/IOException
    //   4108	4161	282	java/io/IOException
    //   4164	4182	282	java/io/IOException
    //   4185	4211	282	java/io/IOException
    //   4214	4218	282	java/io/IOException
    //   4221	4233	282	java/io/IOException
    //   4239	4246	282	java/io/IOException
    //   4249	4256	282	java/io/IOException
    //   4256	4264	282	java/io/IOException
    //   4266	4271	282	java/io/IOException
    //   4278	4289	282	java/io/IOException
    //   4292	4383	282	java/io/IOException
    //   4385	4394	282	java/io/IOException
    //   4396	4423	282	java/io/IOException
    //   4432	4443	282	java/io/IOException
    //   4463	4484	282	java/io/IOException
    //   4489	4500	282	java/io/IOException
    //   4500	4510	282	java/io/IOException
    //   4510	4522	282	java/io/IOException
    //   4532	4543	282	java/io/IOException
    //   4546	4568	282	java/io/IOException
    //   4568	4585	282	java/io/IOException
    //   4588	4601	282	java/io/IOException
    //   4605	4614	282	java/io/IOException
    //   4617	4678	282	java/io/IOException
    //   4681	4692	282	java/io/IOException
    //   4759	4761	282	java/io/IOException
    //   4782	4784	282	java/io/IOException
    //   4785	4787	282	java/io/IOException
    //   4803	4805	282	java/io/IOException
    //   4808	4810	282	java/io/IOException
    //   0	72	325	java/lang/RuntimeException
    //   72	88	325	java/lang/RuntimeException
    //   90	113	325	java/lang/RuntimeException
    //   117	131	325	java/lang/RuntimeException
    //   131	137	325	java/lang/RuntimeException
    //   142	150	325	java/lang/RuntimeException
    //   150	164	325	java/lang/RuntimeException
    //   166	198	325	java/lang/RuntimeException
    //   221	228	325	java/lang/RuntimeException
    //   231	242	325	java/lang/RuntimeException
    //   247	255	325	java/lang/RuntimeException
    //   258	279	325	java/lang/RuntimeException
    //   305	322	325	java/lang/RuntimeException
    //   348	378	325	java/lang/RuntimeException
    //   381	408	325	java/lang/RuntimeException
    //   408	430	325	java/lang/RuntimeException
    //   433	438	325	java/lang/RuntimeException
    //   446	475	325	java/lang/RuntimeException
    //   478	501	325	java/lang/RuntimeException
    //   501	520	325	java/lang/RuntimeException
    //   520	556	325	java/lang/RuntimeException
    //   562	567	325	java/lang/RuntimeException
    //   572	580	325	java/lang/RuntimeException
    //   586	635	325	java/lang/RuntimeException
    //   638	666	325	java/lang/RuntimeException
    //   666	686	325	java/lang/RuntimeException
    //   689	727	325	java/lang/RuntimeException
    //   731	740	325	java/lang/RuntimeException
    //   740	757	325	java/lang/RuntimeException
    //   757	762	325	java/lang/RuntimeException
    //   762	769	325	java/lang/RuntimeException
    //   769	876	325	java/lang/RuntimeException
    //   879	946	325	java/lang/RuntimeException
    //   946	1011	325	java/lang/RuntimeException
    //   1021	1098	325	java/lang/RuntimeException
    //   1108	1133	325	java/lang/RuntimeException
    //   1133	1149	325	java/lang/RuntimeException
    //   1152	1201	325	java/lang/RuntimeException
    //   1211	1220	325	java/lang/RuntimeException
    //   1226	1239	325	java/lang/RuntimeException
    //   1244	1262	325	java/lang/RuntimeException
    //   1265	1278	325	java/lang/RuntimeException
    //   1288	1305	325	java/lang/RuntimeException
    //   1308	1319	325	java/lang/RuntimeException
    //   1322	1359	325	java/lang/RuntimeException
    //   1364	1381	325	java/lang/RuntimeException
    //   1384	1392	325	java/lang/RuntimeException
    //   1396	1441	325	java/lang/RuntimeException
    //   1444	1469	325	java/lang/RuntimeException
    //   1472	1479	325	java/lang/RuntimeException
    //   1484	1491	325	java/lang/RuntimeException
    //   1493	1568	325	java/lang/RuntimeException
    //   1568	1596	325	java/lang/RuntimeException
    //   1599	1619	325	java/lang/RuntimeException
    //   1622	1632	325	java/lang/RuntimeException
    //   1635	1653	325	java/lang/RuntimeException
    //   1656	1669	325	java/lang/RuntimeException
    //   1671	1698	325	java/lang/RuntimeException
    //   1703	1729	325	java/lang/RuntimeException
    //   1732	1770	325	java/lang/RuntimeException
    //   1775	1784	325	java/lang/RuntimeException
    //   1787	1857	325	java/lang/RuntimeException
    //   1862	1891	325	java/lang/RuntimeException
    //   1895	1934	325	java/lang/RuntimeException
    //   1939	1961	325	java/lang/RuntimeException
    //   1964	1986	325	java/lang/RuntimeException
    //   1995	2020	325	java/lang/RuntimeException
    //   2023	2030	325	java/lang/RuntimeException
    //   2033	2062	325	java/lang/RuntimeException
    //   2067	2076	325	java/lang/RuntimeException
    //   2089	2104	325	java/lang/RuntimeException
    //   2108	2118	325	java/lang/RuntimeException
    //   2120	2140	325	java/lang/RuntimeException
    //   2148	2155	325	java/lang/RuntimeException
    //   2163	2167	325	java/lang/RuntimeException
    //   2167	2224	325	java/lang/RuntimeException
    //   2224	2236	325	java/lang/RuntimeException
    //   2249	2262	325	java/lang/RuntimeException
    //   2262	2284	325	java/lang/RuntimeException
    //   2284	2300	325	java/lang/RuntimeException
    //   2307	2315	325	java/lang/RuntimeException
    //   2322	2338	325	java/lang/RuntimeException
    //   2343	2376	325	java/lang/RuntimeException
    //   2389	2399	325	java/lang/RuntimeException
    //   2410	2426	325	java/lang/RuntimeException
    //   2429	2440	325	java/lang/RuntimeException
    //   2443	2452	325	java/lang/RuntimeException
    //   2452	2475	325	java/lang/RuntimeException
    //   2478	2486	325	java/lang/RuntimeException
    //   2489	2505	325	java/lang/RuntimeException
    //   2510	2527	325	java/lang/RuntimeException
    //   2530	2538	325	java/lang/RuntimeException
    //   2541	2556	325	java/lang/RuntimeException
    //   2556	2564	325	java/lang/RuntimeException
    //   2564	2573	325	java/lang/RuntimeException
    //   2573	2576	325	java/lang/RuntimeException
    //   2579	2604	325	java/lang/RuntimeException
    //   2607	2615	325	java/lang/RuntimeException
    //   2618	2648	325	java/lang/RuntimeException
    //   2651	2658	325	java/lang/RuntimeException
    //   2663	2716	325	java/lang/RuntimeException
    //   2719	2730	325	java/lang/RuntimeException
    //   2732	2776	325	java/lang/RuntimeException
    //   2830	2852	325	java/lang/RuntimeException
    //   2858	2872	325	java/lang/RuntimeException
    //   2905	2927	325	java/lang/RuntimeException
    //   2935	2949	325	java/lang/RuntimeException
    //   2953	2976	325	java/lang/RuntimeException
    //   2982	2999	325	java/lang/RuntimeException
    //   2999	3025	325	java/lang/RuntimeException
    //   3025	3043	325	java/lang/RuntimeException
    //   3045	3054	325	java/lang/RuntimeException
    //   3057	3061	325	java/lang/RuntimeException
    //   3063	3084	325	java/lang/RuntimeException
    //   3100	3102	325	java/lang/RuntimeException
    //   3102	3128	325	java/lang/RuntimeException
    //   3131	3245	325	java/lang/RuntimeException
    //   3245	3249	325	java/lang/RuntimeException
    //   3252	3294	325	java/lang/RuntimeException
    //   3299	3330	325	java/lang/RuntimeException
    //   3334	3341	325	java/lang/RuntimeException
    //   3344	3385	325	java/lang/RuntimeException
    //   3388	3411	325	java/lang/RuntimeException
    //   3414	3445	325	java/lang/RuntimeException
    //   3448	3495	325	java/lang/RuntimeException
    //   3498	3514	325	java/lang/RuntimeException
    //   3514	3521	325	java/lang/RuntimeException
    //   3524	3547	325	java/lang/RuntimeException
    //   3551	3560	325	java/lang/RuntimeException
    //   3564	3580	325	java/lang/RuntimeException
    //   3580	3590	325	java/lang/RuntimeException
    //   3595	3607	325	java/lang/RuntimeException
    //   3612	3619	325	java/lang/RuntimeException
    //   3622	3627	325	java/lang/RuntimeException
    //   3630	3636	325	java/lang/RuntimeException
    //   3639	3700	325	java/lang/RuntimeException
    //   3704	3724	325	java/lang/RuntimeException
    //   3724	3764	325	java/lang/RuntimeException
    //   3767	3778	325	java/lang/RuntimeException
    //   3781	3809	325	java/lang/RuntimeException
    //   3809	3816	325	java/lang/RuntimeException
    //   3824	3884	325	java/lang/RuntimeException
    //   3884	3940	325	java/lang/RuntimeException
    //   3940	3972	325	java/lang/RuntimeException
    //   3972	3989	325	java/lang/RuntimeException
    //   3996	4003	325	java/lang/RuntimeException
    //   4003	4037	325	java/lang/RuntimeException
    //   4042	4077	325	java/lang/RuntimeException
    //   4080	4102	325	java/lang/RuntimeException
    //   4108	4161	325	java/lang/RuntimeException
    //   4164	4182	325	java/lang/RuntimeException
    //   4185	4211	325	java/lang/RuntimeException
    //   4214	4218	325	java/lang/RuntimeException
    //   4221	4233	325	java/lang/RuntimeException
    //   4239	4246	325	java/lang/RuntimeException
    //   4249	4256	325	java/lang/RuntimeException
    //   4256	4264	325	java/lang/RuntimeException
    //   4266	4271	325	java/lang/RuntimeException
    //   4278	4289	325	java/lang/RuntimeException
    //   4292	4383	325	java/lang/RuntimeException
    //   4385	4394	325	java/lang/RuntimeException
    //   4396	4423	325	java/lang/RuntimeException
    //   4432	4443	325	java/lang/RuntimeException
    //   4463	4484	325	java/lang/RuntimeException
    //   4489	4500	325	java/lang/RuntimeException
    //   4500	4510	325	java/lang/RuntimeException
    //   4510	4522	325	java/lang/RuntimeException
    //   4532	4543	325	java/lang/RuntimeException
    //   4546	4568	325	java/lang/RuntimeException
    //   4568	4585	325	java/lang/RuntimeException
    //   4588	4601	325	java/lang/RuntimeException
    //   4605	4614	325	java/lang/RuntimeException
    //   4617	4678	325	java/lang/RuntimeException
    //   4681	4692	325	java/lang/RuntimeException
    //   4759	4761	325	java/lang/RuntimeException
    //   4782	4784	325	java/lang/RuntimeException
    //   4785	4787	325	java/lang/RuntimeException
    //   4803	4805	325	java/lang/RuntimeException
    //   4808	4810	325	java/lang/RuntimeException
    //   2786	2822	2952	finally
    //   2885	2895	2952	finally
    //   3084	3095	3097	finally
    //   3098	3100	3097	finally
    //   4761	4777	4779	finally
    //   4780	4782	4779	finally
    //   4692	4695	4784	finally
    //   4707	4727	4784	finally
    //   4734	4750	4784	finally
    //   4750	4759	4784	finally
    //   4787	4803	4805	finally
    //   4806	4808	4805	finally
  }
  
  /* Error */
  public final void release()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 571	com/google/android/exoplayer2/i:released	Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 171	com/google/android/exoplayer2/i:handler	Landroid/os/Handler;
    //   18: bipush 6
    //   20: invokevirtual 284	android/os/Handler:sendEmptyMessage	(I)Z
    //   23: pop
    //   24: iconst_0
    //   25: istore_1
    //   26: aload_0
    //   27: getfield 571	com/google/android/exoplayer2/i:released	Z
    //   30: istore_2
    //   31: iload_2
    //   32: ifne +16 -> 48
    //   35: aload_0
    //   36: invokevirtual 578	java/lang/Object:wait	()V
    //   39: goto -13 -> 26
    //   42: astore_3
    //   43: iconst_1
    //   44: istore_1
    //   45: goto -19 -> 26
    //   48: iload_1
    //   49: ifeq +9 -> 58
    //   52: invokestatic 584	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   55: invokevirtual 587	java/lang/Thread:interrupt	()V
    //   58: aload_0
    //   59: getfield 157	com/google/android/exoplayer2/i:atE	Landroid/os/HandlerThread;
    //   62: invokevirtual 831	android/os/HandlerThread:quit	()Z
    //   65: pop
    //   66: goto -55 -> 11
    //   69: astore_3
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	i
    //   25	24	1	i	int
    //   6	26	2	bool	boolean
    //   42	1	3	localInterruptedException	java.lang.InterruptedException
    //   69	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   35	39	42	java/lang/InterruptedException
    //   2	7	69	finally
    //   14	24	69	finally
    //   26	31	69	finally
    //   35	39	69	finally
    //   52	58	69	finally
    //   58	66	69	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.i
 * JD-Core Version:    0.7.0.1
 */