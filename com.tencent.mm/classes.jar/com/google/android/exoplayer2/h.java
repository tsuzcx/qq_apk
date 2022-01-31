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

public final class h
  implements f
{
  private final i avA;
  final CopyOnWriteArraySet<q.a> avB;
  private final w.b avC;
  private final w.a avD;
  boolean avE;
  boolean avF;
  int avG;
  int avH;
  int avI;
  w avJ;
  Object avK;
  com.google.android.exoplayer2.source.p avL;
  g avM;
  p avN;
  i.b avO;
  int avP;
  int avQ;
  long avR;
  private final r[] avx;
  final com.google.android.exoplayer2.g.h avy;
  private final g avz;
  private final Handler eventHandler;
  boolean isLoading;
  private int repeatMode;
  
  @SuppressLint({"HandlerLeak"})
  public h(r[] paramArrayOfr, com.google.android.exoplayer2.g.h paramh, m paramm)
  {
    AppMethodBeat.i(94778);
    new StringBuilder("Init ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.bbt).append("]");
    boolean bool;
    if (paramArrayOfr.length > 0)
    {
      bool = true;
      a.checkState(bool);
      this.avx = ((r[])a.checkNotNull(paramArrayOfr));
      this.avy = ((com.google.android.exoplayer2.g.h)a.checkNotNull(paramh));
      this.avF = false;
      this.repeatMode = 0;
      this.avG = 1;
      this.avB = new CopyOnWriteArraySet();
      this.avz = new g(new com.google.android.exoplayer2.g.f[paramArrayOfr.length]);
      this.avJ = w.axJ;
      this.avC = new w.b();
      this.avD = new w.a();
      this.avL = com.google.android.exoplayer2.source.p.aQG;
      this.avM = this.avz;
      this.avN = p.axk;
      if (Looper.myLooper() == null) {
        break label253;
      }
    }
    label253:
    for (Looper localLooper = Looper.myLooper();; localLooper = Looper.getMainLooper())
    {
      this.eventHandler = new h.1(this, localLooper);
      this.avO = new i.b(0L);
      this.avA = new i(paramArrayOfr, paramh, paramm, this.avF, this.repeatMode, this.eventHandler, this.avO, this);
      AppMethodBeat.o(94778);
      return;
      bool = false;
      break;
    }
  }
  
  private int mL()
  {
    AppMethodBeat.i(94789);
    if ((this.avJ.isEmpty()) || (this.avH > 0))
    {
      i = this.avP;
      AppMethodBeat.o(94789);
      return i;
    }
    int i = this.avJ.a(this.avO.awx.aPX, this.avD, false).awC;
    AppMethodBeat.o(94789);
    return i;
  }
  
  private long r(long paramLong)
  {
    AppMethodBeat.i(94794);
    long l = b.o(paramLong);
    paramLong = l;
    if (!this.avO.awx.pi())
    {
      this.avJ.a(this.avO.awx.aPX, this.avD, false);
      paramLong = l + b.o(this.avD.axL);
    }
    AppMethodBeat.o(94794);
    return paramLong;
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(151935);
    p localp = paramp;
    if (paramp == null) {
      localp = p.axk;
    }
    this.avA.handler.obtainMessage(4, localp).sendToTarget();
    AppMethodBeat.o(151935);
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(94779);
    this.avB.add(parama);
    AppMethodBeat.o(94779);
  }
  
  public final void a(com.google.android.exoplayer2.source.i parami)
  {
    AppMethodBeat.i(94781);
    Iterator localIterator;
    if ((!this.avJ.isEmpty()) || (this.avK != null))
    {
      this.avJ = w.axJ;
      this.avK = null;
      localIterator = this.avB.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).na();
      }
    }
    if (this.avE)
    {
      this.avE = false;
      this.avL = com.google.android.exoplayer2.source.p.aQG;
      this.avM = this.avz;
      this.avy.Q(null);
      localIterator = this.avB.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).nb();
      }
    }
    this.avI += 1;
    this.avA.handler.obtainMessage(0, 1, 0, parami).sendToTarget();
    AppMethodBeat.o(94781);
  }
  
  public final void a(f.c... paramVarArgs)
  {
    AppMethodBeat.i(94787);
    i locali = this.avA;
    if (!locali.released)
    {
      locali.awe += 1;
      locali.handler.obtainMessage(11, paramVarArgs).sendToTarget();
    }
    AppMethodBeat.o(94787);
  }
  
  public final void aC(boolean paramBoolean)
  {
    AppMethodBeat.i(94782);
    if (this.avF != paramBoolean)
    {
      this.avF = paramBoolean;
      Object localObject = this.avA.handler;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((Handler)localObject).obtainMessage(1, i, 0).sendToTarget();
        localObject = this.avB.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((q.a)((Iterator)localObject).next()).b(paramBoolean, this.avG);
        }
      }
    }
    AppMethodBeat.o(94782);
  }
  
  public final void b(q.a parama)
  {
    AppMethodBeat.i(94780);
    this.avB.remove(parama);
    AppMethodBeat.o(94780);
  }
  
  public final void b(f.c... paramVarArgs)
  {
    AppMethodBeat.i(94788);
    this.avA.b(paramVarArgs);
    AppMethodBeat.o(94788);
  }
  
  public final int getBufferedPercentage()
  {
    AppMethodBeat.i(94793);
    if (this.avJ.isEmpty())
    {
      AppMethodBeat.o(94793);
      return 0;
    }
    long l1 = getBufferedPosition();
    long l2 = getDuration();
    if ((l1 == -9223372036854775807L) || (l2 == -9223372036854775807L))
    {
      AppMethodBeat.o(94793);
      return 0;
    }
    if (l2 == 0L)
    {
      AppMethodBeat.o(94793);
      return 100;
    }
    int i = x.t((int)(l1 * 100L / l2), 0, 100);
    AppMethodBeat.o(94793);
    return i;
  }
  
  public final long getBufferedPosition()
  {
    AppMethodBeat.i(94792);
    if ((this.avJ.isEmpty()) || (this.avH > 0))
    {
      l = this.avR;
      AppMethodBeat.o(94792);
      return l;
    }
    long l = r(this.avO.awB);
    AppMethodBeat.o(94792);
    return l;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(94791);
    if ((this.avJ.isEmpty()) || (this.avH > 0))
    {
      l = this.avR;
      AppMethodBeat.o(94791);
      return l;
    }
    long l = r(this.avO.awA);
    AppMethodBeat.o(94791);
    return l;
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(94790);
    if (this.avJ.isEmpty())
    {
      AppMethodBeat.o(94790);
      return -9223372036854775807L;
    }
    if ((!this.avJ.isEmpty()) && (this.avH == 0) && (this.avO.awx.pi())) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.google.android.exoplayer2.source.i.b localb = this.avO.awx;
      this.avJ.a(localb.aPX, this.avD, false);
      l = b.o(this.avD.aU(localb.aPY, localb.aPZ));
      AppMethodBeat.o(94790);
      return l;
    }
    long l = b.o(this.avJ.a(mL(), this.avC).axh);
    AppMethodBeat.o(94790);
    return l;
  }
  
  public final boolean isLoading()
  {
    return this.isLoading;
  }
  
  public final int mJ()
  {
    return this.avG;
  }
  
  public final boolean mK()
  {
    return this.avF;
  }
  
  public final void release()
  {
    AppMethodBeat.i(94786);
    new StringBuilder("Release ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.bbt).append("] [").append(j.mW()).append("]");
    this.avA.release();
    this.eventHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(94786);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(94784);
    int j = mL();
    if ((j < 0) || ((!this.avJ.isEmpty()) && (j >= this.avJ.ne())))
    {
      localObject = new l(this.avJ, j, paramLong);
      AppMethodBeat.o(94784);
      throw ((Throwable)localObject);
    }
    this.avH += 1;
    this.avP = j;
    if (this.avJ.isEmpty()) {}
    int i;
    for (this.avQ = 0; paramLong == -9223372036854775807L; this.avQ = i)
    {
      this.avR = 0L;
      this.avA.a(this.avJ, j, -9223372036854775807L);
      AppMethodBeat.o(94784);
      return;
      this.avJ.a(j, this.avC);
      if (paramLong == -9223372036854775807L) {}
      for (long l1 = this.avC.axY;; l1 = b.p(paramLong))
      {
        i = this.avC.axW;
        long l2 = this.avC.axZ + l1;
        for (l1 = this.avJ.a(i, this.avD, false).axh; (l1 != -9223372036854775807L) && (l2 >= l1) && (i < this.avC.axX); l1 = ((w)localObject).a(i, this.avD, false).axh)
        {
          l2 -= l1;
          localObject = this.avJ;
          i += 1;
        }
      }
    }
    this.avR = paramLong;
    this.avA.a(this.avJ, j, b.p(paramLong));
    Object localObject = this.avB.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((q.a)((Iterator)localObject).next()).nc();
    }
    AppMethodBeat.o(94784);
  }
  
  public final void setRepeatMode(int paramInt)
  {
    AppMethodBeat.i(94783);
    if (this.repeatMode != paramInt)
    {
      this.repeatMode = paramInt;
      this.avA.handler.obtainMessage(12, paramInt, 0).sendToTarget();
      Iterator localIterator = this.avB.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).ai(paramInt);
      }
    }
    AppMethodBeat.o(94783);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(94785);
    this.avA.handler.sendEmptyMessage(5);
    AppMethodBeat.o(94785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.h
 * JD-Core Version:    0.7.0.1
 */