package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.k.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class h
  implements f
{
  private final r[] aLB;
  final com.google.android.exoplayer2.g.h aLC;
  private final g aLD;
  private final i aLE;
  final CopyOnWriteArraySet<q.a> aLF;
  private final w.b aLG;
  private final w.a aLH;
  boolean aLI;
  boolean aLJ;
  private int aLK;
  int aLL;
  int aLM;
  int aLN;
  w aLO;
  Object aLP;
  com.google.android.exoplayer2.source.r aLQ;
  g aLR;
  p aLS;
  i.b aLT;
  int aLU;
  int aLV;
  long aLW;
  private final Handler eventHandler;
  boolean isLoading;
  
  @SuppressLint({"HandlerLeak"})
  public h(r[] paramArrayOfr, com.google.android.exoplayer2.g.h paramh, m paramm)
  {
    AppMethodBeat.i(91891);
    new StringBuilder("Init ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.brr).append("]");
    boolean bool;
    if (paramArrayOfr.length > 0)
    {
      bool = true;
      a.checkState(bool);
      this.aLB = ((r[])a.checkNotNull(paramArrayOfr));
      this.aLC = ((com.google.android.exoplayer2.g.h)a.checkNotNull(paramh));
      this.aLJ = false;
      this.aLK = 0;
      this.aLL = 1;
      this.aLF = new CopyOnWriteArraySet();
      this.aLD = new g(new com.google.android.exoplayer2.g.f[paramArrayOfr.length]);
      this.aLO = w.aNM;
      this.aLG = new w.b();
      this.aLH = new w.a();
      this.aLQ = com.google.android.exoplayer2.source.r.bgJ;
      this.aLR = this.aLD;
      this.aLS = p.aNn;
      if (Looper.myLooper() == null) {
        break label253;
      }
    }
    label253:
    for (Looper localLooper = Looper.myLooper();; localLooper = Looper.getMainLooper())
    {
      this.eventHandler = new Handler(localLooper)
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(91890);
          Object localObject = h.this;
          switch (paramAnonymousMessage.what)
          {
          default: 
            paramAnonymousMessage = new IllegalStateException();
            AppMethodBeat.o(91890);
            throw paramAnonymousMessage;
          case 0: 
            ((h)localObject).aLN -= 1;
            AppMethodBeat.o(91890);
            return;
          case 1: 
            ((h)localObject).aLL = paramAnonymousMessage.arg1;
            paramAnonymousMessage = ((h)localObject).aLF.iterator();
            while (paramAnonymousMessage.hasNext()) {
              ((q.a)paramAnonymousMessage.next()).e(((h)localObject).aLJ, ((h)localObject).aLL);
            }
            AppMethodBeat.o(91890);
            return;
          case 2: 
            if (paramAnonymousMessage.arg1 != 0) {}
            for (boolean bool = true;; bool = false)
            {
              ((h)localObject).isLoading = bool;
              paramAnonymousMessage = ((h)localObject).aLF.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).aP(((h)localObject).isLoading);
              }
            }
            AppMethodBeat.o(91890);
            return;
          case 3: 
            if (((h)localObject).aLN == 0)
            {
              paramAnonymousMessage = (com.google.android.exoplayer2.g.i)paramAnonymousMessage.obj;
              ((h)localObject).aLI = true;
              ((h)localObject).aLQ = paramAnonymousMessage.boh;
              ((h)localObject).aLR = paramAnonymousMessage.boi;
              ((h)localObject).aLC.Z(paramAnonymousMessage.info);
              paramAnonymousMessage = ((h)localObject).aLF.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).a(((h)localObject).aLQ, ((h)localObject).aLR);
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 4: 
            int i = ((h)localObject).aLM - 1;
            ((h)localObject).aLM = i;
            if (i == 0)
            {
              ((h)localObject).aLT = ((i.b)paramAnonymousMessage.obj);
              if (((h)localObject).aLO.isEmpty())
              {
                ((h)localObject).aLV = 0;
                ((h)localObject).aLU = 0;
                ((h)localObject).aLW = 0L;
              }
              if (paramAnonymousMessage.arg1 != 0)
              {
                paramAnonymousMessage = ((h)localObject).aLF.iterator();
                while (paramAnonymousMessage.hasNext()) {
                  ((q.a)paramAnonymousMessage.next()).rs();
                }
                AppMethodBeat.o(91890);
                return;
              }
            }
            break;
          case 5: 
            if (((h)localObject).aLM == 0)
            {
              ((h)localObject).aLT = ((i.b)paramAnonymousMessage.obj);
              paramAnonymousMessage = ((h)localObject).aLF.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).rs();
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 6: 
            paramAnonymousMessage = (i.d)paramAnonymousMessage.obj;
            ((h)localObject).aLM -= paramAnonymousMessage.aMK;
            if (((h)localObject).aLN == 0)
            {
              ((h)localObject).aLO = paramAnonymousMessage.aLO;
              ((h)localObject).aLP = paramAnonymousMessage.aLP;
              ((h)localObject).aLT = paramAnonymousMessage.aLT;
              if ((((h)localObject).aLM == 0) && (((h)localObject).aLO.isEmpty()))
              {
                ((h)localObject).aLV = 0;
                ((h)localObject).aLU = 0;
                ((h)localObject).aLW = 0L;
              }
              paramAnonymousMessage = ((h)localObject).aLF.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).b(((h)localObject).aLO, ((h)localObject).aLP);
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 7: 
            paramAnonymousMessage = (p)paramAnonymousMessage.obj;
            if (!((h)localObject).aLS.equals(paramAnonymousMessage))
            {
              ((h)localObject).aLS = paramAnonymousMessage;
              localObject = ((h)localObject).aLF.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((q.a)((Iterator)localObject).next()).b(paramAnonymousMessage);
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 8: 
            paramAnonymousMessage = (e)paramAnonymousMessage.obj;
            localObject = ((h)localObject).aLF.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((q.a)((Iterator)localObject).next()).a(paramAnonymousMessage);
            }
            AppMethodBeat.o(91890);
            return;
          }
          AppMethodBeat.o(91890);
        }
      };
      this.aLT = new i.b(0L);
      this.aLE = new i(paramArrayOfr, paramh, paramm, this.aLJ, this.aLK, this.eventHandler, this.aLT, this);
      AppMethodBeat.o(91891);
      return;
      bool = false;
      break;
    }
  }
  
  private long B(long paramLong)
  {
    AppMethodBeat.i(91908);
    long l = b.y(paramLong);
    paramLong = l;
    if (!this.aLT.aMD.isAd())
    {
      this.aLO.a(this.aLT.aMD.bfZ, this.aLH, false);
      paramLong = l + b.y(this.aLH.aNO);
    }
    AppMethodBeat.o(91908);
    return paramLong;
  }
  
  private int rc()
  {
    AppMethodBeat.i(91903);
    if ((this.aLO.isEmpty()) || (this.aLM > 0))
    {
      i = this.aLU;
      AppMethodBeat.o(91903);
      return i;
    }
    int i = this.aLO.a(this.aLT.aMD.bfZ, this.aLH, false).aMI;
    AppMethodBeat.o(91903);
    return i;
  }
  
  public final void L(int paramInt)
  {
    AppMethodBeat.i(91896);
    if (this.aLK != paramInt)
    {
      this.aLK = paramInt;
      this.aLE.handler.obtainMessage(12, paramInt, 0).sendToTarget();
      Iterator localIterator = this.aLF.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).I(paramInt);
      }
    }
    AppMethodBeat.o(91896);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(91898);
    p localp = paramp;
    if (paramp == null) {
      localp = p.aNn;
    }
    this.aLE.handler.obtainMessage(4, localp).sendToTarget();
    AppMethodBeat.o(91898);
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(91892);
    this.aLF.add(parama);
    AppMethodBeat.o(91892);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(91894);
    Iterator localIterator;
    if ((!this.aLO.isEmpty()) || (this.aLP != null))
    {
      this.aLO = w.aNM;
      this.aLP = null;
      localIterator = this.aLF.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).b(this.aLO, this.aLP);
      }
    }
    if (this.aLI)
    {
      this.aLI = false;
      this.aLQ = com.google.android.exoplayer2.source.r.bgJ;
      this.aLR = this.aLD;
      this.aLC.Z(null);
      localIterator = this.aLF.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).a(this.aLQ, this.aLR);
      }
    }
    this.aLN += 1;
    this.aLE.handler.obtainMessage(0, 1, 0, paramk).sendToTarget();
    AppMethodBeat.o(91894);
  }
  
  public final void a(f.c... paramVarArgs)
  {
    AppMethodBeat.i(91901);
    i locali = this.aLE;
    if (!locali.released)
    {
      locali.aMj += 1;
      locali.handler.obtainMessage(11, paramVarArgs).sendToTarget();
    }
    AppMethodBeat.o(91901);
  }
  
  public final void aM(boolean paramBoolean)
  {
    AppMethodBeat.i(91895);
    if (this.aLJ != paramBoolean)
    {
      this.aLJ = paramBoolean;
      Object localObject = this.aLE.handler;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((Handler)localObject).obtainMessage(1, i, 0).sendToTarget();
        localObject = this.aLF.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((q.a)((Iterator)localObject).next()).e(paramBoolean, this.aLL);
        }
      }
    }
    AppMethodBeat.o(91895);
  }
  
  public final void b(q.a parama)
  {
    AppMethodBeat.i(91893);
    this.aLF.remove(parama);
    AppMethodBeat.o(91893);
  }
  
  public final void b(f.c... paramVarArgs)
  {
    AppMethodBeat.i(91902);
    this.aLE.b(paramVarArgs);
    AppMethodBeat.o(91902);
  }
  
  public final int getBufferedPercentage()
  {
    AppMethodBeat.i(91907);
    if (this.aLO.isEmpty())
    {
      AppMethodBeat.o(91907);
      return 0;
    }
    long l1 = rd();
    long l2 = getDuration();
    if ((l1 == -9223372036854775807L) || (l2 == -9223372036854775807L))
    {
      AppMethodBeat.o(91907);
      return 0;
    }
    if (l2 == 0L)
    {
      AppMethodBeat.o(91907);
      return 100;
    }
    int i = x.r((int)(l1 * 100L / l2), 0, 100);
    AppMethodBeat.o(91907);
    return i;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(91905);
    if ((this.aLO.isEmpty()) || (this.aLM > 0))
    {
      l = this.aLW;
      AppMethodBeat.o(91905);
      return l;
    }
    long l = B(this.aLT.aMG);
    AppMethodBeat.o(91905);
    return l;
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(91904);
    if (this.aLO.isEmpty())
    {
      AppMethodBeat.o(91904);
      return -9223372036854775807L;
    }
    if ((!this.aLO.isEmpty()) && (this.aLM == 0) && (this.aLT.aMD.isAd())) {}
    for (int i = 1; i != 0; i = 0)
    {
      k.b localb = this.aLT.aMD;
      this.aLO.a(localb.bfZ, this.aLH, false);
      l = b.y(this.aLH.bh(localb.bga, localb.bgb));
      AppMethodBeat.o(91904);
      return l;
    }
    long l = b.y(this.aLO.a(rc(), this.aLG).aNk);
    AppMethodBeat.o(91904);
    return l;
  }
  
  public final boolean isLoading()
  {
    return this.isLoading;
  }
  
  public final int ra()
  {
    return this.aLL;
  }
  
  public final boolean rb()
  {
    return this.aLJ;
  }
  
  public final long rd()
  {
    AppMethodBeat.i(91906);
    if ((this.aLO.isEmpty()) || (this.aLM > 0))
    {
      l = this.aLW;
      AppMethodBeat.o(91906);
      return l;
    }
    long l = B(this.aLT.aMH);
    AppMethodBeat.o(91906);
    return l;
  }
  
  public final void release()
  {
    AppMethodBeat.i(91900);
    new StringBuilder("Release ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.brr).append("] [").append(j.ro()).append("]");
    this.aLE.release();
    this.eventHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(91900);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(91897);
    int j = rc();
    if ((j < 0) || ((!this.aLO.isEmpty()) && (j >= this.aLO.rv())))
    {
      localObject = new l(this.aLO, j, paramLong);
      AppMethodBeat.o(91897);
      throw ((Throwable)localObject);
    }
    this.aLM += 1;
    this.aLU = j;
    if (this.aLO.isEmpty()) {}
    int i;
    for (this.aLV = 0; paramLong == -9223372036854775807L; this.aLV = i)
    {
      this.aLW = 0L;
      this.aLE.a(this.aLO, j, -9223372036854775807L);
      AppMethodBeat.o(91897);
      return;
      this.aLO.a(j, this.aLG);
      if (paramLong == -9223372036854775807L) {}
      for (long l1 = this.aLG.aOb;; l1 = b.z(paramLong))
      {
        i = this.aLG.aNZ;
        long l2 = this.aLG.aOc + l1;
        for (l1 = this.aLO.a(i, this.aLH, false).aNk; (l1 != -9223372036854775807L) && (l2 >= l1) && (i < this.aLG.aOa); l1 = ((w)localObject).a(i, this.aLH, false).aNk)
        {
          l2 -= l1;
          localObject = this.aLO;
          i += 1;
        }
      }
    }
    this.aLW = paramLong;
    this.aLE.a(this.aLO, j, b.z(paramLong));
    Object localObject = this.aLF.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((q.a)((Iterator)localObject).next()).rs();
    }
    AppMethodBeat.o(91897);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(91899);
    this.aLE.handler.sendEmptyMessage(5);
    AppMethodBeat.o(91899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h
 * JD-Core Version:    0.7.0.1
 */