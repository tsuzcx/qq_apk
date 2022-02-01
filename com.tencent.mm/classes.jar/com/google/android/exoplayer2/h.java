package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class h
  implements f
{
  private final r[] aRK;
  final com.google.android.exoplayer2.g.h aRL;
  private final g aRM;
  private final i aRN;
  final CopyOnWriteArraySet<q.a> aRO;
  private final w.b aRP;
  private final w.a aRQ;
  boolean aRR;
  boolean aRS;
  int aRT;
  int aRU;
  int aRV;
  w aRW;
  Object aRX;
  com.google.android.exoplayer2.source.p aRY;
  g aRZ;
  p aSa;
  i.b aSb;
  int aSc;
  int aSd;
  long aSe;
  private final Handler eventHandler;
  boolean isLoading;
  private int repeatMode;
  
  @SuppressLint({"HandlerLeak"})
  public h(r[] paramArrayOfr, com.google.android.exoplayer2.g.h paramh, m paramm)
  {
    AppMethodBeat.i(91891);
    new StringBuilder("Init ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.bxc).append("]");
    boolean bool;
    if (paramArrayOfr.length > 0)
    {
      bool = true;
      a.checkState(bool);
      this.aRK = ((r[])a.checkNotNull(paramArrayOfr));
      this.aRL = ((com.google.android.exoplayer2.g.h)a.checkNotNull(paramh));
      this.aRS = false;
      this.repeatMode = 0;
      this.aRT = 1;
      this.aRO = new CopyOnWriteArraySet();
      this.aRM = new g(new com.google.android.exoplayer2.g.f[paramArrayOfr.length]);
      this.aRW = w.aTU;
      this.aRP = new w.b();
      this.aRQ = new w.a();
      this.aRY = com.google.android.exoplayer2.source.p.bmL;
      this.aRZ = this.aRM;
      this.aSa = p.aTv;
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
            ((h)localObject).aRV -= 1;
            AppMethodBeat.o(91890);
            return;
          case 1: 
            ((h)localObject).aRT = paramAnonymousMessage.arg1;
            paramAnonymousMessage = ((h)localObject).aRO.iterator();
            while (paramAnonymousMessage.hasNext()) {
              ((q.a)paramAnonymousMessage.next()).e(((h)localObject).aRS, ((h)localObject).aRT);
            }
            AppMethodBeat.o(91890);
            return;
          case 2: 
            if (paramAnonymousMessage.arg1 != 0) {}
            for (boolean bool = true;; bool = false)
            {
              ((h)localObject).isLoading = bool;
              paramAnonymousMessage = ((h)localObject).aRO.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).aR(((h)localObject).isLoading);
              }
            }
            AppMethodBeat.o(91890);
            return;
          case 3: 
            if (((h)localObject).aRV == 0)
            {
              paramAnonymousMessage = (com.google.android.exoplayer2.g.i)paramAnonymousMessage.obj;
              ((h)localObject).aRR = true;
              ((h)localObject).aRY = paramAnonymousMessage.buo;
              ((h)localObject).aRZ = paramAnonymousMessage.bup;
              ((h)localObject).aRL.ae(paramAnonymousMessage.info);
              paramAnonymousMessage = ((h)localObject).aRO.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).rV();
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 4: 
            int i = ((h)localObject).aRU - 1;
            ((h)localObject).aRU = i;
            if (i == 0)
            {
              ((h)localObject).aSb = ((i.b)paramAnonymousMessage.obj);
              if (((h)localObject).aRW.isEmpty())
              {
                ((h)localObject).aSd = 0;
                ((h)localObject).aSc = 0;
                ((h)localObject).aSe = 0L;
              }
              if (paramAnonymousMessage.arg1 != 0)
              {
                paramAnonymousMessage = ((h)localObject).aRO.iterator();
                while (paramAnonymousMessage.hasNext()) {
                  ((q.a)paramAnonymousMessage.next()).rW();
                }
                AppMethodBeat.o(91890);
                return;
              }
            }
            break;
          case 5: 
            if (((h)localObject).aRU == 0)
            {
              ((h)localObject).aSb = ((i.b)paramAnonymousMessage.obj);
              paramAnonymousMessage = ((h)localObject).aRO.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).rW();
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 6: 
            paramAnonymousMessage = (i.d)paramAnonymousMessage.obj;
            ((h)localObject).aRU -= paramAnonymousMessage.aSS;
            if (((h)localObject).aRV == 0)
            {
              ((h)localObject).aRW = paramAnonymousMessage.aRW;
              ((h)localObject).aRX = paramAnonymousMessage.aRX;
              ((h)localObject).aSb = paramAnonymousMessage.aSb;
              if ((((h)localObject).aRU == 0) && (((h)localObject).aRW.isEmpty()))
              {
                ((h)localObject).aSd = 0;
                ((h)localObject).aSc = 0;
                ((h)localObject).aSe = 0L;
              }
              paramAnonymousMessage = ((h)localObject).aRO.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).rU();
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 7: 
            paramAnonymousMessage = (p)paramAnonymousMessage.obj;
            if (!((h)localObject).aSa.equals(paramAnonymousMessage))
            {
              ((h)localObject).aSa = paramAnonymousMessage;
              localObject = ((h)localObject).aRO.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((q.a)((Iterator)localObject).next()).b(paramAnonymousMessage);
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 8: 
            paramAnonymousMessage = (e)paramAnonymousMessage.obj;
            localObject = ((h)localObject).aRO.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((q.a)((Iterator)localObject).next()).a(paramAnonymousMessage);
            }
            AppMethodBeat.o(91890);
            return;
          }
          AppMethodBeat.o(91890);
        }
      };
      this.aSb = new i.b(0L);
      this.aRN = new i(paramArrayOfr, paramh, paramm, this.aRS, this.repeatMode, this.eventHandler, this.aSb, this);
      AppMethodBeat.o(91891);
      return;
      bool = false;
      break;
    }
  }
  
  private int rG()
  {
    AppMethodBeat.i(91903);
    if ((this.aRW.isEmpty()) || (this.aRU > 0))
    {
      i = this.aSc;
      AppMethodBeat.o(91903);
      return i;
    }
    int i = this.aRW.a(this.aSb.aSL.bmb, this.aRQ, false).aSQ;
    AppMethodBeat.o(91903);
    return i;
  }
  
  private long y(long paramLong)
  {
    AppMethodBeat.i(91908);
    long l = b.v(paramLong);
    paramLong = l;
    if (!this.aSb.aSL.tY())
    {
      this.aRW.a(this.aSb.aSL.bmb, this.aRQ, false);
      paramLong = l + b.v(this.aRQ.aTW);
    }
    AppMethodBeat.o(91908);
    return paramLong;
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(91898);
    p localp = paramp;
    if (paramp == null) {
      localp = p.aTv;
    }
    this.aRN.handler.obtainMessage(4, localp).sendToTarget();
    AppMethodBeat.o(91898);
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(91892);
    this.aRO.add(parama);
    AppMethodBeat.o(91892);
  }
  
  public final void a(com.google.android.exoplayer2.source.i parami)
  {
    AppMethodBeat.i(91894);
    Iterator localIterator;
    if ((!this.aRW.isEmpty()) || (this.aRX != null))
    {
      this.aRW = w.aTU;
      this.aRX = null;
      localIterator = this.aRO.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).rU();
      }
    }
    if (this.aRR)
    {
      this.aRR = false;
      this.aRY = com.google.android.exoplayer2.source.p.bmL;
      this.aRZ = this.aRM;
      this.aRL.ae(null);
      localIterator = this.aRO.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).rV();
      }
    }
    this.aRV += 1;
    this.aRN.handler.obtainMessage(0, 1, 0, parami).sendToTarget();
    AppMethodBeat.o(91894);
  }
  
  public final void a(f.c... paramVarArgs)
  {
    AppMethodBeat.i(91901);
    i locali = this.aRN;
    if (!locali.released)
    {
      locali.aSr += 1;
      locali.handler.obtainMessage(11, paramVarArgs).sendToTarget();
    }
    AppMethodBeat.o(91901);
  }
  
  public final void aO(boolean paramBoolean)
  {
    AppMethodBeat.i(91895);
    if (this.aRS != paramBoolean)
    {
      this.aRS = paramBoolean;
      Object localObject = this.aRN.handler;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((Handler)localObject).obtainMessage(1, i, 0).sendToTarget();
        localObject = this.aRO.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((q.a)((Iterator)localObject).next()).e(paramBoolean, this.aRT);
        }
      }
    }
    AppMethodBeat.o(91895);
  }
  
  public final void b(q.a parama)
  {
    AppMethodBeat.i(91893);
    this.aRO.remove(parama);
    AppMethodBeat.o(91893);
  }
  
  public final void b(f.c... paramVarArgs)
  {
    AppMethodBeat.i(91902);
    this.aRN.b(paramVarArgs);
    AppMethodBeat.o(91902);
  }
  
  public final int getBufferedPercentage()
  {
    AppMethodBeat.i(91907);
    if (this.aRW.isEmpty())
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
    if ((this.aRW.isEmpty()) || (this.aRU > 0))
    {
      l = this.aSe;
      AppMethodBeat.o(91906);
      return l;
    }
    long l = y(this.aSb.aSP);
    AppMethodBeat.o(91906);
    return l;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(91905);
    if ((this.aRW.isEmpty()) || (this.aRU > 0))
    {
      l = this.aSe;
      AppMethodBeat.o(91905);
      return l;
    }
    long l = y(this.aSb.aSO);
    AppMethodBeat.o(91905);
    return l;
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(91904);
    if (this.aRW.isEmpty())
    {
      AppMethodBeat.o(91904);
      return -9223372036854775807L;
    }
    if ((!this.aRW.isEmpty()) && (this.aRU == 0) && (this.aSb.aSL.tY())) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.google.android.exoplayer2.source.i.b localb = this.aSb.aSL;
      this.aRW.a(localb.bmb, this.aRQ, false);
      l = b.v(this.aRQ.bf(localb.bmc, localb.bmd));
      AppMethodBeat.o(91904);
      return l;
    }
    long l = b.v(this.aRW.a(rG(), this.aRP).aTs);
    AppMethodBeat.o(91904);
    return l;
  }
  
  public final boolean isLoading()
  {
    return this.isLoading;
  }
  
  public final int rE()
  {
    return this.aRT;
  }
  
  public final boolean rF()
  {
    return this.aRS;
  }
  
  public final void release()
  {
    AppMethodBeat.i(91900);
    new StringBuilder("Release ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.bxc).append("] [").append(j.rQ()).append("]");
    this.aRN.release();
    this.eventHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(91900);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(91897);
    int j = rG();
    if ((j < 0) || ((!this.aRW.isEmpty()) && (j >= this.aRW.rZ())))
    {
      localObject = new l(this.aRW, j, paramLong);
      AppMethodBeat.o(91897);
      throw ((Throwable)localObject);
    }
    this.aRU += 1;
    this.aSc = j;
    if (this.aRW.isEmpty()) {}
    int i;
    for (this.aSd = 0; paramLong == -9223372036854775807L; this.aSd = i)
    {
      this.aSe = 0L;
      this.aRN.a(this.aRW, j, -9223372036854775807L);
      AppMethodBeat.o(91897);
      return;
      this.aRW.a(j, this.aRP);
      if (paramLong == -9223372036854775807L) {}
      for (long l1 = this.aRP.aUj;; l1 = b.w(paramLong))
      {
        i = this.aRP.aUh;
        long l2 = this.aRP.aUk + l1;
        for (l1 = this.aRW.a(i, this.aRQ, false).aTs; (l1 != -9223372036854775807L) && (l2 >= l1) && (i < this.aRP.aUi); l1 = ((w)localObject).a(i, this.aRQ, false).aTs)
        {
          l2 -= l1;
          localObject = this.aRW;
          i += 1;
        }
      }
    }
    this.aSe = paramLong;
    this.aRN.a(this.aRW, j, b.w(paramLong));
    Object localObject = this.aRO.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((q.a)((Iterator)localObject).next()).rW();
    }
    AppMethodBeat.o(91897);
  }
  
  public final void setRepeatMode(int paramInt)
  {
    AppMethodBeat.i(91896);
    if (this.repeatMode != paramInt)
    {
      this.repeatMode = paramInt;
      this.aRN.handler.obtainMessage(12, paramInt, 0).sendToTarget();
      Iterator localIterator = this.aRO.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).aA(paramInt);
      }
    }
    AppMethodBeat.o(91896);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(91899);
    this.aRN.handler.sendEmptyMessage(5);
    AppMethodBeat.o(91899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.h
 * JD-Core Version:    0.7.0.1
 */