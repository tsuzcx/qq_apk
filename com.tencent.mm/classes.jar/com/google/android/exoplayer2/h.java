package com.google.android.exoplayer2;

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
  private final g cFA;
  private final i cFB;
  final CopyOnWriteArraySet<q.a> cFC;
  private final w.b cFD;
  private final w.a cFE;
  boolean cFF;
  boolean cFG;
  private int cFH;
  int cFI;
  int cFJ;
  int cFK;
  w cFL;
  Object cFM;
  com.google.android.exoplayer2.source.r cFN;
  g cFO;
  p cFP;
  i.b cFQ;
  int cFR;
  int cFS;
  long cFT;
  private final r[] cFy;
  final com.google.android.exoplayer2.g.h cFz;
  private final Handler eventHandler;
  boolean isLoading;
  
  public h(r[] paramArrayOfr, com.google.android.exoplayer2.g.h paramh, m paramm)
  {
    AppMethodBeat.i(91891);
    new StringBuilder("Init ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.dkT).append("]");
    boolean bool;
    if (paramArrayOfr.length > 0)
    {
      bool = true;
      a.checkState(bool);
      this.cFy = ((r[])a.checkNotNull(paramArrayOfr));
      this.cFz = ((com.google.android.exoplayer2.g.h)a.checkNotNull(paramh));
      this.cFG = false;
      this.cFH = 0;
      this.cFI = 1;
      this.cFC = new CopyOnWriteArraySet();
      this.cFA = new g(new com.google.android.exoplayer2.g.f[paramArrayOfr.length]);
      this.cFL = w.cHI;
      this.cFD = new w.b();
      this.cFE = new w.a();
      this.cFN = com.google.android.exoplayer2.source.r.daD;
      this.cFO = this.cFA;
      this.cFP = p.cHj;
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
            ((h)localObject).cFK -= 1;
            AppMethodBeat.o(91890);
            return;
          case 1: 
            ((h)localObject).cFI = paramAnonymousMessage.arg1;
            paramAnonymousMessage = ((h)localObject).cFC.iterator();
            while (paramAnonymousMessage.hasNext()) {
              ((q.a)paramAnonymousMessage.next()).onPlayerStateChanged(((h)localObject).cFG, ((h)localObject).cFI);
            }
            AppMethodBeat.o(91890);
            return;
          case 2: 
            if (paramAnonymousMessage.arg1 != 0) {}
            for (boolean bool = true;; bool = false)
            {
              ((h)localObject).isLoading = bool;
              paramAnonymousMessage = ((h)localObject).cFC.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).onLoadingChanged(((h)localObject).isLoading);
              }
            }
            AppMethodBeat.o(91890);
            return;
          case 3: 
            if (((h)localObject).cFK == 0)
            {
              paramAnonymousMessage = (com.google.android.exoplayer2.g.i)paramAnonymousMessage.obj;
              ((h)localObject).cFF = true;
              ((h)localObject).cFN = paramAnonymousMessage.dia;
              ((h)localObject).cFO = paramAnonymousMessage.dib;
              ((h)localObject).cFz.bi(paramAnonymousMessage.info);
              paramAnonymousMessage = ((h)localObject).cFC.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).onTracksChanged(((h)localObject).cFN, ((h)localObject).cFO);
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 4: 
            int i = ((h)localObject).cFJ - 1;
            ((h)localObject).cFJ = i;
            if (i == 0)
            {
              ((h)localObject).cFQ = ((i.b)paramAnonymousMessage.obj);
              if (((h)localObject).cFL.isEmpty())
              {
                ((h)localObject).cFS = 0;
                ((h)localObject).cFR = 0;
                ((h)localObject).cFT = 0L;
              }
              if (paramAnonymousMessage.arg1 != 0)
              {
                paramAnonymousMessage = ((h)localObject).cFC.iterator();
                while (paramAnonymousMessage.hasNext()) {
                  ((q.a)paramAnonymousMessage.next()).onPositionDiscontinuity();
                }
                AppMethodBeat.o(91890);
                return;
              }
            }
            break;
          case 5: 
            if (((h)localObject).cFJ == 0)
            {
              ((h)localObject).cFQ = ((i.b)paramAnonymousMessage.obj);
              paramAnonymousMessage = ((h)localObject).cFC.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).onPositionDiscontinuity();
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 6: 
            paramAnonymousMessage = (i.d)paramAnonymousMessage.obj;
            ((h)localObject).cFJ -= paramAnonymousMessage.cGH;
            if (((h)localObject).cFK == 0)
            {
              ((h)localObject).cFL = paramAnonymousMessage.cFL;
              ((h)localObject).cFM = paramAnonymousMessage.cFM;
              ((h)localObject).cFQ = paramAnonymousMessage.cFQ;
              if ((((h)localObject).cFJ == 0) && (((h)localObject).cFL.isEmpty()))
              {
                ((h)localObject).cFS = 0;
                ((h)localObject).cFR = 0;
                ((h)localObject).cFT = 0L;
              }
              paramAnonymousMessage = ((h)localObject).cFC.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).onTimelineChanged(((h)localObject).cFL, ((h)localObject).cFM);
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 7: 
            paramAnonymousMessage = (p)paramAnonymousMessage.obj;
            if (!((h)localObject).cFP.equals(paramAnonymousMessage))
            {
              ((h)localObject).cFP = paramAnonymousMessage;
              localObject = ((h)localObject).cFC.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((q.a)((Iterator)localObject).next()).onPlaybackParametersChanged(paramAnonymousMessage);
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 8: 
            paramAnonymousMessage = (e)paramAnonymousMessage.obj;
            localObject = ((h)localObject).cFC.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((q.a)((Iterator)localObject).next()).onPlayerError(paramAnonymousMessage);
            }
            AppMethodBeat.o(91890);
            return;
          }
          AppMethodBeat.o(91890);
        }
      };
      this.cFQ = new i.b(0L);
      this.cFB = new i(paramArrayOfr, paramh, paramm, this.cFG, this.cFH, this.eventHandler, this.cFQ, this);
      AppMethodBeat.o(91891);
      return;
      bool = false;
      break;
    }
  }
  
  private int QE()
  {
    AppMethodBeat.i(91903);
    if ((this.cFL.isEmpty()) || (this.cFJ > 0))
    {
      i = this.cFR;
      AppMethodBeat.o(91903);
      return i;
    }
    int i = this.cFL.a(this.cFQ.cGA.cZS, this.cFE, false).cGF;
    AppMethodBeat.o(91903);
    return i;
  }
  
  private long bP(long paramLong)
  {
    AppMethodBeat.i(91908);
    long l = b.bM(paramLong);
    paramLong = l;
    if (!this.cFQ.cGA.isAd())
    {
      this.cFL.a(this.cFQ.cGA.cZS, this.cFE, false);
      paramLong = l + b.bM(this.cFE.cHK);
    }
    AppMethodBeat.o(91908);
    return paramLong;
  }
  
  public final void J(int paramInt)
  {
    AppMethodBeat.i(91896);
    if (this.cFH != paramInt)
    {
      this.cFH = paramInt;
      this.cFB.handler.obtainMessage(12, paramInt, 0).sendToTarget();
      Iterator localIterator = this.cFC.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).onRepeatModeChanged(paramInt);
      }
    }
    AppMethodBeat.o(91896);
  }
  
  public final int QC()
  {
    return this.cFI;
  }
  
  public final boolean QD()
  {
    return this.cFG;
  }
  
  public final long QF()
  {
    AppMethodBeat.i(91906);
    if ((this.cFL.isEmpty()) || (this.cFJ > 0))
    {
      l = this.cFT;
      AppMethodBeat.o(91906);
      return l;
    }
    long l = bP(this.cFQ.cGE);
    AppMethodBeat.o(91906);
    return l;
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(91898);
    p localp = paramp;
    if (paramp == null) {
      localp = p.cHj;
    }
    this.cFB.handler.obtainMessage(4, localp).sendToTarget();
    AppMethodBeat.o(91898);
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(91892);
    this.cFC.add(parama);
    AppMethodBeat.o(91892);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(91894);
    Iterator localIterator;
    if ((!this.cFL.isEmpty()) || (this.cFM != null))
    {
      this.cFL = w.cHI;
      this.cFM = null;
      localIterator = this.cFC.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).onTimelineChanged(this.cFL, this.cFM);
      }
    }
    if (this.cFF)
    {
      this.cFF = false;
      this.cFN = com.google.android.exoplayer2.source.r.daD;
      this.cFO = this.cFA;
      this.cFz.bi(null);
      localIterator = this.cFC.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).onTracksChanged(this.cFN, this.cFO);
      }
    }
    this.cFK += 1;
    this.cFB.handler.obtainMessage(0, 1, 0, paramk).sendToTarget();
    AppMethodBeat.o(91894);
  }
  
  public final void a(f.c... paramVarArgs)
  {
    AppMethodBeat.i(91901);
    i locali = this.cFB;
    if (!locali.released)
    {
      locali.cGg += 1;
      locali.handler.obtainMessage(11, paramVarArgs).sendToTarget();
    }
    AppMethodBeat.o(91901);
  }
  
  public final void b(q.a parama)
  {
    AppMethodBeat.i(91893);
    this.cFC.remove(parama);
    AppMethodBeat.o(91893);
  }
  
  public final void b(f.c... paramVarArgs)
  {
    AppMethodBeat.i(91902);
    this.cFB.b(paramVarArgs);
    AppMethodBeat.o(91902);
  }
  
  public final void bv(boolean paramBoolean)
  {
    AppMethodBeat.i(91895);
    if (this.cFG != paramBoolean)
    {
      this.cFG = paramBoolean;
      Object localObject = this.cFB.handler;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((Handler)localObject).obtainMessage(1, i, 0).sendToTarget();
        localObject = this.cFC.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((q.a)((Iterator)localObject).next()).onPlayerStateChanged(paramBoolean, this.cFI);
        }
      }
    }
    AppMethodBeat.o(91895);
  }
  
  public final int getBufferedPercentage()
  {
    AppMethodBeat.i(91907);
    if (this.cFL.isEmpty())
    {
      AppMethodBeat.o(91907);
      return 0;
    }
    long l1 = QF();
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
    int i = x.H((int)(l1 * 100L / l2), 0, 100);
    AppMethodBeat.o(91907);
    return i;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(91905);
    if ((this.cFL.isEmpty()) || (this.cFJ > 0))
    {
      l = this.cFT;
      AppMethodBeat.o(91905);
      return l;
    }
    long l = bP(this.cFQ.cGD);
    AppMethodBeat.o(91905);
    return l;
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(91904);
    if (this.cFL.isEmpty())
    {
      AppMethodBeat.o(91904);
      return -9223372036854775807L;
    }
    if ((!this.cFL.isEmpty()) && (this.cFJ == 0) && (this.cFQ.cGA.isAd())) {}
    for (int i = 1; i != 0; i = 0)
    {
      k.b localb = this.cFQ.cGA;
      this.cFL.a(localb.cZS, this.cFE, false);
      l = b.bM(this.cFE.cc(localb.cZT, localb.cZU));
      AppMethodBeat.o(91904);
      return l;
    }
    long l = b.bM(this.cFL.a(QE(), this.cFD).cHg);
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
    new StringBuilder("Release ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.dkT).append("] [").append(j.QQ()).append("]");
    this.cFB.release();
    this.eventHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(91900);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(91897);
    int j = QE();
    if ((j < 0) || ((!this.cFL.isEmpty()) && (j >= this.cFL.QW())))
    {
      localObject = new l(this.cFL, j, paramLong);
      AppMethodBeat.o(91897);
      throw ((Throwable)localObject);
    }
    this.cFJ += 1;
    this.cFR = j;
    if (this.cFL.isEmpty()) {}
    int i;
    for (this.cFS = 0; paramLong == -9223372036854775807L; this.cFS = i)
    {
      this.cFT = 0L;
      this.cFB.a(this.cFL, j, -9223372036854775807L);
      AppMethodBeat.o(91897);
      return;
      this.cFL.a(j, this.cFD);
      if (paramLong == -9223372036854775807L) {}
      for (long l1 = this.cFD.cHX;; l1 = b.bN(paramLong))
      {
        i = this.cFD.cHV;
        long l2 = this.cFD.cHY + l1;
        for (l1 = this.cFL.a(i, this.cFE, false).cHg; (l1 != -9223372036854775807L) && (l2 >= l1) && (i < this.cFD.cHW); l1 = ((w)localObject).a(i, this.cFE, false).cHg)
        {
          l2 -= l1;
          localObject = this.cFL;
          i += 1;
        }
      }
    }
    this.cFT = paramLong;
    this.cFB.a(this.cFL, j, b.bN(paramLong));
    Object localObject = this.cFC.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((q.a)((Iterator)localObject).next()).onPositionDiscontinuity();
    }
    AppMethodBeat.o(91897);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(91899);
    this.cFB.handler.sendEmptyMessage(5);
    AppMethodBeat.o(91899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.h
 * JD-Core Version:    0.7.0.1
 */