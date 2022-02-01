package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.source.j.b;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class h
  implements f
{
  private final r[] aQP;
  final com.google.android.exoplayer2.g.h aQQ;
  private final g aQR;
  private final i aQS;
  final CopyOnWriteArraySet<q.a> aQT;
  private final w.b aQU;
  private final w.a aQV;
  boolean aQW;
  boolean aQX;
  int aQY;
  int aQZ;
  int aRa;
  w aRb;
  Object aRc;
  q aRd;
  g aRe;
  p aRf;
  i.b aRg;
  int aRh;
  int aRi;
  long aRj;
  private final Handler eventHandler;
  boolean isLoading;
  private int repeatMode;
  
  @SuppressLint({"HandlerLeak"})
  public h(r[] paramArrayOfr, com.google.android.exoplayer2.g.h paramh, m paramm)
  {
    AppMethodBeat.i(91891);
    new StringBuilder("Init ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.bzu).append("]");
    boolean bool;
    if (paramArrayOfr.length > 0)
    {
      bool = true;
      a.checkState(bool);
      this.aQP = ((r[])a.checkNotNull(paramArrayOfr));
      this.aQQ = ((com.google.android.exoplayer2.g.h)a.checkNotNull(paramh));
      this.aQX = false;
      this.repeatMode = 0;
      this.aQY = 1;
      this.aQT = new CopyOnWriteArraySet();
      this.aQR = new g(new com.google.android.exoplayer2.g.f[paramArrayOfr.length]);
      this.aRb = w.aTc;
      this.aQU = new w.b();
      this.aQV = new w.a();
      this.aRd = q.bmg;
      this.aRe = this.aQR;
      this.aRf = p.aSC;
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
            ((h)localObject).aRa -= 1;
            AppMethodBeat.o(91890);
            return;
          case 1: 
            ((h)localObject).aQY = paramAnonymousMessage.arg1;
            paramAnonymousMessage = ((h)localObject).aQT.iterator();
            while (paramAnonymousMessage.hasNext()) {
              ((q.a)paramAnonymousMessage.next()).e(((h)localObject).aQX, ((h)localObject).aQY);
            }
            AppMethodBeat.o(91890);
            return;
          case 2: 
            if (paramAnonymousMessage.arg1 != 0) {}
            for (boolean bool = true;; bool = false)
            {
              ((h)localObject).isLoading = bool;
              paramAnonymousMessage = ((h)localObject).aQT.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).aR(((h)localObject).isLoading);
              }
            }
            AppMethodBeat.o(91890);
            return;
          case 3: 
            if (((h)localObject).aRa == 0)
            {
              paramAnonymousMessage = (com.google.android.exoplayer2.g.i)paramAnonymousMessage.obj;
              ((h)localObject).aQW = true;
              ((h)localObject).aRd = paramAnonymousMessage.bwp;
              ((h)localObject).aRe = paramAnonymousMessage.bwq;
              ((h)localObject).aQQ.ad(paramAnonymousMessage.info);
              paramAnonymousMessage = ((h)localObject).aQT.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).rK();
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 4: 
            int i = ((h)localObject).aQZ - 1;
            ((h)localObject).aQZ = i;
            if (i == 0)
            {
              ((h)localObject).aRg = ((i.b)paramAnonymousMessage.obj);
              if (((h)localObject).aRb.isEmpty())
              {
                ((h)localObject).aRi = 0;
                ((h)localObject).aRh = 0;
                ((h)localObject).aRj = 0L;
              }
              if (paramAnonymousMessage.arg1 != 0)
              {
                paramAnonymousMessage = ((h)localObject).aQT.iterator();
                while (paramAnonymousMessage.hasNext()) {
                  ((q.a)paramAnonymousMessage.next()).rL();
                }
                AppMethodBeat.o(91890);
                return;
              }
            }
            break;
          case 5: 
            if (((h)localObject).aQZ == 0)
            {
              ((h)localObject).aRg = ((i.b)paramAnonymousMessage.obj);
              paramAnonymousMessage = ((h)localObject).aQT.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).rL();
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 6: 
            paramAnonymousMessage = (i.d)paramAnonymousMessage.obj;
            ((h)localObject).aQZ -= paramAnonymousMessage.aRX;
            if (((h)localObject).aRa == 0)
            {
              ((h)localObject).aRb = paramAnonymousMessage.aRb;
              ((h)localObject).aRc = paramAnonymousMessage.aRc;
              ((h)localObject).aRg = paramAnonymousMessage.aRg;
              if ((((h)localObject).aQZ == 0) && (((h)localObject).aRb.isEmpty()))
              {
                ((h)localObject).aRi = 0;
                ((h)localObject).aRh = 0;
                ((h)localObject).aRj = 0L;
              }
              paramAnonymousMessage = ((h)localObject).aQT.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).rJ();
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 7: 
            paramAnonymousMessage = (p)paramAnonymousMessage.obj;
            if (!((h)localObject).aRf.equals(paramAnonymousMessage))
            {
              ((h)localObject).aRf = paramAnonymousMessage;
              localObject = ((h)localObject).aQT.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((q.a)((Iterator)localObject).next()).b(paramAnonymousMessage);
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 8: 
            paramAnonymousMessage = (e)paramAnonymousMessage.obj;
            localObject = ((h)localObject).aQT.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((q.a)((Iterator)localObject).next()).a(paramAnonymousMessage);
            }
            AppMethodBeat.o(91890);
            return;
          }
          AppMethodBeat.o(91890);
        }
      };
      this.aRg = new i.b(0L);
      this.aQS = new i(paramArrayOfr, paramh, paramm, this.aQX, this.repeatMode, this.eventHandler, this.aRg, this);
      AppMethodBeat.o(91891);
      return;
      bool = false;
      break;
    }
  }
  
  private int rv()
  {
    AppMethodBeat.i(91903);
    if ((this.aRb.isEmpty()) || (this.aQZ > 0))
    {
      i = this.aRh;
      AppMethodBeat.o(91903);
      return i;
    }
    int i = this.aRb.a(this.aRg.aRQ.blw, this.aQV, false).aRV;
    AppMethodBeat.o(91903);
    return i;
  }
  
  private long w(long paramLong)
  {
    AppMethodBeat.i(91908);
    long l = b.t(paramLong);
    paramLong = l;
    if (!this.aRg.aRQ.tQ())
    {
      this.aRb.a(this.aRg.aRQ.blw, this.aQV, false);
      paramLong = l + b.t(this.aQV.aTe);
    }
    AppMethodBeat.o(91908);
    return paramLong;
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(91898);
    p localp = paramp;
    if (paramp == null) {
      localp = p.aSC;
    }
    this.aQS.handler.obtainMessage(4, localp).sendToTarget();
    AppMethodBeat.o(91898);
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(91892);
    this.aQT.add(parama);
    AppMethodBeat.o(91892);
  }
  
  public final void a(com.google.android.exoplayer2.source.j paramj)
  {
    AppMethodBeat.i(91894);
    Iterator localIterator;
    if ((!this.aRb.isEmpty()) || (this.aRc != null))
    {
      this.aRb = w.aTc;
      this.aRc = null;
      localIterator = this.aQT.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).rJ();
      }
    }
    if (this.aQW)
    {
      this.aQW = false;
      this.aRd = q.bmg;
      this.aRe = this.aQR;
      this.aQQ.ad(null);
      localIterator = this.aQT.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).rK();
      }
    }
    this.aRa += 1;
    this.aQS.handler.obtainMessage(0, 1, 0, paramj).sendToTarget();
    AppMethodBeat.o(91894);
  }
  
  public final void a(f.c... paramVarArgs)
  {
    AppMethodBeat.i(91901);
    i locali = this.aQS;
    if (!locali.released)
    {
      locali.aRw += 1;
      locali.handler.obtainMessage(11, paramVarArgs).sendToTarget();
    }
    AppMethodBeat.o(91901);
  }
  
  public final void aO(boolean paramBoolean)
  {
    AppMethodBeat.i(91895);
    if (this.aQX != paramBoolean)
    {
      this.aQX = paramBoolean;
      Object localObject = this.aQS.handler;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((Handler)localObject).obtainMessage(1, i, 0).sendToTarget();
        localObject = this.aQT.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((q.a)((Iterator)localObject).next()).e(paramBoolean, this.aQY);
        }
      }
    }
    AppMethodBeat.o(91895);
  }
  
  public final void b(q.a parama)
  {
    AppMethodBeat.i(91893);
    this.aQT.remove(parama);
    AppMethodBeat.o(91893);
  }
  
  public final void b(f.c... paramVarArgs)
  {
    AppMethodBeat.i(91902);
    this.aQS.b(paramVarArgs);
    AppMethodBeat.o(91902);
  }
  
  public final int getBufferedPercentage()
  {
    AppMethodBeat.i(91907);
    if (this.aRb.isEmpty())
    {
      AppMethodBeat.o(91907);
      return 0;
    }
    long l1 = getBufferedPosition();
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
    int i = x.v((int)(l1 * 100L / l2), 0, 100);
    AppMethodBeat.o(91907);
    return i;
  }
  
  public final long getBufferedPosition()
  {
    AppMethodBeat.i(91906);
    if ((this.aRb.isEmpty()) || (this.aQZ > 0))
    {
      l = this.aRj;
      AppMethodBeat.o(91906);
      return l;
    }
    long l = w(this.aRg.aRU);
    AppMethodBeat.o(91906);
    return l;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(91905);
    if ((this.aRb.isEmpty()) || (this.aQZ > 0))
    {
      l = this.aRj;
      AppMethodBeat.o(91905);
      return l;
    }
    long l = w(this.aRg.aRT);
    AppMethodBeat.o(91905);
    return l;
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(91904);
    if (this.aRb.isEmpty())
    {
      AppMethodBeat.o(91904);
      return -9223372036854775807L;
    }
    if ((!this.aRb.isEmpty()) && (this.aQZ == 0) && (this.aRg.aRQ.tQ())) {}
    for (int i = 1; i != 0; i = 0)
    {
      j.b localb = this.aRg.aRQ;
      this.aRb.a(localb.blw, this.aQV, false);
      l = b.t(this.aQV.bf(localb.blx, localb.bly));
      AppMethodBeat.o(91904);
      return l;
    }
    long l = b.t(this.aRb.a(rv(), this.aQU).aSz);
    AppMethodBeat.o(91904);
    return l;
  }
  
  public final boolean isLoading()
  {
    return this.isLoading;
  }
  
  public final void release()
  {
    AppMethodBeat.i(91900);
    new StringBuilder("Release ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.bzu).append("] [").append(j.rF()).append("]");
    this.aQS.release();
    this.eventHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(91900);
  }
  
  public final int rt()
  {
    return this.aQY;
  }
  
  public final boolean ru()
  {
    return this.aQX;
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(91897);
    int j = rv();
    if ((j < 0) || ((!this.aRb.isEmpty()) && (j >= this.aRb.rP())))
    {
      localObject = new l(this.aRb, j, paramLong);
      AppMethodBeat.o(91897);
      throw ((Throwable)localObject);
    }
    this.aQZ += 1;
    this.aRh = j;
    if (this.aRb.isEmpty()) {}
    int i;
    for (this.aRi = 0; paramLong == -9223372036854775807L; this.aRi = i)
    {
      this.aRj = 0L;
      this.aQS.a(this.aRb, j, -9223372036854775807L);
      AppMethodBeat.o(91897);
      return;
      this.aRb.a(j, this.aQU);
      if (paramLong == -9223372036854775807L) {}
      for (long l1 = this.aQU.aTr;; l1 = b.u(paramLong))
      {
        i = this.aQU.aTp;
        long l2 = this.aQU.aTs + l1;
        for (l1 = this.aRb.a(i, this.aQV, false).aSz; (l1 != -9223372036854775807L) && (l2 >= l1) && (i < this.aQU.aTq); l1 = ((w)localObject).a(i, this.aQV, false).aSz)
        {
          l2 -= l1;
          localObject = this.aRb;
          i += 1;
        }
      }
    }
    this.aRj = paramLong;
    this.aQS.a(this.aRb, j, b.u(paramLong));
    Object localObject = this.aQT.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((q.a)((Iterator)localObject).next()).rL();
    }
    AppMethodBeat.o(91897);
  }
  
  public final void setRepeatMode(int paramInt)
  {
    AppMethodBeat.i(91896);
    if (this.repeatMode != paramInt)
    {
      this.repeatMode = paramInt;
      this.aQS.handler.obtainMessage(12, paramInt, 0).sendToTarget();
      Iterator localIterator = this.aQT.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).aA(paramInt);
      }
    }
    AppMethodBeat.o(91896);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(91899);
    this.aQS.handler.sendEmptyMessage(5);
    AppMethodBeat.o(91899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h
 * JD-Core Version:    0.7.0.1
 */