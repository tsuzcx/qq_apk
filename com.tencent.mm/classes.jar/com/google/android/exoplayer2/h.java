package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.g.e;
import com.google.android.exoplayer2.g.g;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.source.f.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class h
  implements f
{
  private final r[] atf;
  final g atg;
  private final com.google.android.exoplayer2.g.f ath;
  private final i ati;
  final CopyOnWriteArraySet<q.a> atj;
  private final w.b atk;
  private final w.a atl;
  boolean atm;
  boolean atn;
  int ato;
  int atp;
  int atq;
  w atr;
  Object ats;
  com.google.android.exoplayer2.source.m att;
  com.google.android.exoplayer2.g.f atu;
  p atv;
  i.b atw;
  int atx;
  int aty;
  long atz;
  private final Handler eventHandler;
  boolean isLoading;
  private int repeatMode;
  
  @SuppressLint({"HandlerLeak"})
  public h(r[] paramArrayOfr, g paramg, m paramm)
  {
    new StringBuilder("Init ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(t.aSS).append("]");
    boolean bool;
    if (paramArrayOfr.length > 0)
    {
      bool = true;
      a.aC(bool);
      this.atf = ((r[])a.E(paramArrayOfr));
      this.atg = ((g)a.E(paramg));
      this.atn = false;
      this.repeatMode = 0;
      this.ato = 1;
      this.atj = new CopyOnWriteArraySet();
      this.ath = new com.google.android.exoplayer2.g.f(new e[paramArrayOfr.length]);
      this.atr = w.avt;
      this.atk = new w.b();
      this.atl = new w.a();
      this.att = com.google.android.exoplayer2.source.m.aIY;
      this.atu = this.ath;
      this.atv = p.auS;
      if (Looper.myLooper() == null) {
        break label243;
      }
    }
    label243:
    for (Looper localLooper = Looper.myLooper();; localLooper = Looper.getMainLooper())
    {
      this.eventHandler = new h.1(this, localLooper);
      this.atw = new i.b(0L);
      this.ati = new i(paramArrayOfr, paramg, paramm, this.atn, this.repeatMode, this.eventHandler, this.atw, this);
      return;
      bool = false;
      break;
    }
  }
  
  private int kF()
  {
    if ((this.atr.isEmpty()) || (this.atp > 0)) {
      return this.atx;
    }
    return this.atr.a(this.atw.auf.aIm, this.atl, false).auk;
  }
  
  private long t(long paramLong)
  {
    long l = b.q(paramLong);
    paramLong = l;
    if (!this.atw.auf.mG())
    {
      this.atr.a(this.atw.auf.aIm, this.atl, false);
      paramLong = l + b.q(this.atl.avv);
    }
    return paramLong;
  }
  
  public final void a(q.a parama)
  {
    this.atj.add(parama);
  }
  
  public final void a(com.google.android.exoplayer2.source.f paramf)
  {
    Iterator localIterator;
    if ((!this.atr.isEmpty()) || (this.ats != null))
    {
      this.atr = w.avt;
      this.ats = null;
      localIterator = this.atj.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    if (this.atm)
    {
      this.atm = false;
      this.att = com.google.android.exoplayer2.source.m.aIY;
      this.atu = this.ath;
      this.atg.Q(null);
      localIterator = this.atj.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    this.atq += 1;
    this.ati.handler.obtainMessage(0, 1, 0, paramf).sendToTarget();
  }
  
  public final void a(f.c... paramVarArgs)
  {
    i locali = this.ati;
    if (!locali.released)
    {
      locali.atM += 1;
      locali.handler.obtainMessage(11, paramVarArgs).sendToTarget();
    }
  }
  
  public final void at(boolean paramBoolean)
  {
    if (this.atn != paramBoolean)
    {
      this.atn = paramBoolean;
      Object localObject = this.ati.handler;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((Handler)localObject).obtainMessage(1, i, 0).sendToTarget();
        localObject = this.atj.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((q.a)((Iterator)localObject).next()).b(paramBoolean, this.ato);
        }
      }
    }
  }
  
  public final void b(q.a parama)
  {
    this.atj.remove(parama);
  }
  
  public final void b(f.c... paramVarArgs)
  {
    this.ati.b(paramVarArgs);
  }
  
  public final int getBufferedPercentage()
  {
    if (this.atr.isEmpty()) {}
    long l1;
    long l2;
    do
    {
      return 0;
      l1 = getBufferedPosition();
      l2 = getDuration();
    } while ((l1 == -9223372036854775807L) || (l2 == -9223372036854775807L));
    if (l2 == 0L) {
      return 100;
    }
    return t.t((int)(l1 * 100L / l2), 0, 100);
  }
  
  public final long getBufferedPosition()
  {
    if ((this.atr.isEmpty()) || (this.atp > 0)) {
      return this.atz;
    }
    return t(this.atw.auj);
  }
  
  public final long getCurrentPosition()
  {
    if ((this.atr.isEmpty()) || (this.atp > 0)) {
      return this.atz;
    }
    return t(this.atw.aui);
  }
  
  public final long getDuration()
  {
    if (this.atr.isEmpty()) {
      return -9223372036854775807L;
    }
    if ((!this.atr.isEmpty()) && (this.atp == 0) && (this.atw.auf.mG())) {}
    for (int i = 1; i != 0; i = 0)
    {
      f.b localb = this.atw.auf;
      this.atr.a(localb.aIm, this.atl, false);
      return b.q(this.atl.aE(localb.aIn, localb.aIo));
    }
    return b.q(this.atr.a(kF(), this.atk, 0L).auP);
  }
  
  public final boolean isLoading()
  {
    return this.isLoading;
  }
  
  public final int kD()
  {
    return this.ato;
  }
  
  public final boolean kE()
  {
    return this.atn;
  }
  
  public final void release()
  {
    new StringBuilder("Release ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(t.aSS).append("] [").append(j.kP()).append("]");
    this.ati.release();
    this.eventHandler.removeCallbacksAndMessages(null);
  }
  
  public final void seekTo(long paramLong)
  {
    int j = kF();
    if ((j < 0) || ((!this.atr.isEmpty()) && (j >= this.atr.kV()))) {
      throw new l(this.atr, j, paramLong);
    }
    this.atp += 1;
    this.atx = j;
    if (this.atr.isEmpty())
    {
      this.aty = 0;
      if (paramLong != -9223372036854775807L) {
        break label260;
      }
      this.atz = 0L;
      this.ati.a(this.atr, j, -9223372036854775807L);
    }
    for (;;)
    {
      return;
      this.atr.a(j, this.atk, 0L);
      if (paramLong == -9223372036854775807L) {}
      int i;
      for (long l1 = this.atk.avI;; l1 = b.r(paramLong))
      {
        i = this.atk.avG;
        long l2 = this.atk.avJ + l1;
        for (l1 = this.atr.a(i, this.atl, false).auP; (l1 != -9223372036854775807L) && (l2 >= l1) && (i < this.atk.avH); l1 = ((w)localObject).a(i, this.atl, false).auP)
        {
          l2 -= l1;
          localObject = this.atr;
          i += 1;
        }
      }
      this.aty = i;
      break;
      label260:
      this.atz = paramLong;
      this.ati.a(this.atr, j, b.r(paramLong));
      Object localObject = this.atj.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((q.a)((Iterator)localObject).next()).kT();
      }
    }
  }
  
  public final void stop()
  {
    this.ati.handler.sendEmptyMessage(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h
 * JD-Core Version:    0.7.0.1
 */