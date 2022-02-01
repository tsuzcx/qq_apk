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
  private final r[] bcf;
  final com.google.android.exoplayer2.g.h bcg;
  private final g bch;
  private final i bci;
  final CopyOnWriteArraySet<q.a> bcj;
  private final w.b bck;
  private final w.a bcl;
  boolean bcm;
  boolean bcn;
  int bco;
  int bcp;
  int bcq;
  w bcr;
  Object bcs;
  com.google.android.exoplayer2.source.p bct;
  g bcu;
  p bcv;
  i.b bcw;
  int bcx;
  int bcy;
  long bcz;
  private final Handler eventHandler;
  boolean isLoading;
  private int repeatMode;
  
  @SuppressLint({"HandlerLeak"})
  public h(r[] paramArrayOfr, com.google.android.exoplayer2.g.h paramh, m paramm)
  {
    AppMethodBeat.i(91891);
    new StringBuilder("Init ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.bHq).append("]");
    boolean bool;
    if (paramArrayOfr.length > 0)
    {
      bool = true;
      a.checkState(bool);
      this.bcf = ((r[])a.checkNotNull(paramArrayOfr));
      this.bcg = ((com.google.android.exoplayer2.g.h)a.checkNotNull(paramh));
      this.bcn = false;
      this.repeatMode = 0;
      this.bco = 1;
      this.bcj = new CopyOnWriteArraySet();
      this.bch = new g(new com.google.android.exoplayer2.g.f[paramArrayOfr.length]);
      this.bcr = w.beo;
      this.bck = new w.b();
      this.bcl = new w.a();
      this.bct = com.google.android.exoplayer2.source.p.bxg;
      this.bcu = this.bch;
      this.bcv = p.bdP;
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
            ((h)localObject).bcq -= 1;
            AppMethodBeat.o(91890);
            return;
          case 1: 
            ((h)localObject).bco = paramAnonymousMessage.arg1;
            paramAnonymousMessage = ((h)localObject).bcj.iterator();
            while (paramAnonymousMessage.hasNext()) {
              ((q.a)paramAnonymousMessage.next()).e(((h)localObject).bcn, ((h)localObject).bco);
            }
            AppMethodBeat.o(91890);
            return;
          case 2: 
            if (paramAnonymousMessage.arg1 != 0) {}
            for (boolean bool = true;; bool = false)
            {
              ((h)localObject).isLoading = bool;
              paramAnonymousMessage = ((h)localObject).bcj.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).aS(((h)localObject).isLoading);
              }
            }
            AppMethodBeat.o(91890);
            return;
          case 3: 
            if (((h)localObject).bcq == 0)
            {
              paramAnonymousMessage = (com.google.android.exoplayer2.g.i)paramAnonymousMessage.obj;
              ((h)localObject).bcm = true;
              ((h)localObject).bct = paramAnonymousMessage.bED;
              ((h)localObject).bcu = paramAnonymousMessage.bEE;
              ((h)localObject).bcg.ag(paramAnonymousMessage.info);
              paramAnonymousMessage = ((h)localObject).bcj.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).tu();
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 4: 
            int i = ((h)localObject).bcp - 1;
            ((h)localObject).bcp = i;
            if (i == 0)
            {
              ((h)localObject).bcw = ((i.b)paramAnonymousMessage.obj);
              if (((h)localObject).bcr.isEmpty())
              {
                ((h)localObject).bcy = 0;
                ((h)localObject).bcx = 0;
                ((h)localObject).bcz = 0L;
              }
              if (paramAnonymousMessage.arg1 != 0)
              {
                paramAnonymousMessage = ((h)localObject).bcj.iterator();
                while (paramAnonymousMessage.hasNext()) {
                  ((q.a)paramAnonymousMessage.next()).tv();
                }
                AppMethodBeat.o(91890);
                return;
              }
            }
            break;
          case 5: 
            if (((h)localObject).bcp == 0)
            {
              ((h)localObject).bcw = ((i.b)paramAnonymousMessage.obj);
              paramAnonymousMessage = ((h)localObject).bcj.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).tv();
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 6: 
            paramAnonymousMessage = (i.d)paramAnonymousMessage.obj;
            ((h)localObject).bcp -= paramAnonymousMessage.bdn;
            if (((h)localObject).bcq == 0)
            {
              ((h)localObject).bcr = paramAnonymousMessage.bcr;
              ((h)localObject).bcs = paramAnonymousMessage.bcs;
              ((h)localObject).bcw = paramAnonymousMessage.bcw;
              if ((((h)localObject).bcp == 0) && (((h)localObject).bcr.isEmpty()))
              {
                ((h)localObject).bcy = 0;
                ((h)localObject).bcx = 0;
                ((h)localObject).bcz = 0L;
              }
              paramAnonymousMessage = ((h)localObject).bcj.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).tt();
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 7: 
            paramAnonymousMessage = (p)paramAnonymousMessage.obj;
            if (!((h)localObject).bcv.equals(paramAnonymousMessage))
            {
              ((h)localObject).bcv = paramAnonymousMessage;
              localObject = ((h)localObject).bcj.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((q.a)((Iterator)localObject).next()).b(paramAnonymousMessage);
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 8: 
            paramAnonymousMessage = (e)paramAnonymousMessage.obj;
            localObject = ((h)localObject).bcj.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((q.a)((Iterator)localObject).next()).a(paramAnonymousMessage);
            }
            AppMethodBeat.o(91890);
            return;
          }
          AppMethodBeat.o(91890);
        }
      };
      this.bcw = new i.b(0L);
      this.bci = new i(paramArrayOfr, paramh, paramm, this.bcn, this.repeatMode, this.eventHandler, this.bcw, this);
      AppMethodBeat.o(91891);
      return;
      bool = false;
      break;
    }
  }
  
  private int tf()
  {
    AppMethodBeat.i(91903);
    if ((this.bcr.isEmpty()) || (this.bcp > 0))
    {
      i = this.bcx;
      AppMethodBeat.o(91903);
      return i;
    }
    int i = this.bcr.a(this.bcw.bdg.bww, this.bcl, false).bdl;
    AppMethodBeat.o(91903);
    return i;
  }
  
  private long y(long paramLong)
  {
    AppMethodBeat.i(91908);
    long l = b.v(paramLong);
    paramLong = l;
    if (!this.bcw.bdg.vx())
    {
      this.bcr.a(this.bcw.bdg.bww, this.bcl, false);
      paramLong = l + b.v(this.bcl.beq);
    }
    AppMethodBeat.o(91908);
    return paramLong;
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(91898);
    p localp = paramp;
    if (paramp == null) {
      localp = p.bdP;
    }
    this.bci.handler.obtainMessage(4, localp).sendToTarget();
    AppMethodBeat.o(91898);
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(91892);
    this.bcj.add(parama);
    AppMethodBeat.o(91892);
  }
  
  public final void a(com.google.android.exoplayer2.source.i parami)
  {
    AppMethodBeat.i(91894);
    Iterator localIterator;
    if ((!this.bcr.isEmpty()) || (this.bcs != null))
    {
      this.bcr = w.beo;
      this.bcs = null;
      localIterator = this.bcj.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).tt();
      }
    }
    if (this.bcm)
    {
      this.bcm = false;
      this.bct = com.google.android.exoplayer2.source.p.bxg;
      this.bcu = this.bch;
      this.bcg.ag(null);
      localIterator = this.bcj.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).tu();
      }
    }
    this.bcq += 1;
    this.bci.handler.obtainMessage(0, 1, 0, parami).sendToTarget();
    AppMethodBeat.o(91894);
  }
  
  public final void a(f.c... paramVarArgs)
  {
    AppMethodBeat.i(91901);
    i locali = this.bci;
    if (!locali.released)
    {
      locali.bcM += 1;
      locali.handler.obtainMessage(11, paramVarArgs).sendToTarget();
    }
    AppMethodBeat.o(91901);
  }
  
  public final void aP(boolean paramBoolean)
  {
    AppMethodBeat.i(91895);
    if (this.bcn != paramBoolean)
    {
      this.bcn = paramBoolean;
      Object localObject = this.bci.handler;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((Handler)localObject).obtainMessage(1, i, 0).sendToTarget();
        localObject = this.bcj.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((q.a)((Iterator)localObject).next()).e(paramBoolean, this.bco);
        }
      }
    }
    AppMethodBeat.o(91895);
  }
  
  public final void b(q.a parama)
  {
    AppMethodBeat.i(91893);
    this.bcj.remove(parama);
    AppMethodBeat.o(91893);
  }
  
  public final void b(f.c... paramVarArgs)
  {
    AppMethodBeat.i(91902);
    this.bci.b(paramVarArgs);
    AppMethodBeat.o(91902);
  }
  
  public final int getBufferedPercentage()
  {
    AppMethodBeat.i(91907);
    if (this.bcr.isEmpty())
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
    if ((this.bcr.isEmpty()) || (this.bcp > 0))
    {
      l = this.bcz;
      AppMethodBeat.o(91906);
      return l;
    }
    long l = y(this.bcw.bdk);
    AppMethodBeat.o(91906);
    return l;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(91905);
    if ((this.bcr.isEmpty()) || (this.bcp > 0))
    {
      l = this.bcz;
      AppMethodBeat.o(91905);
      return l;
    }
    long l = y(this.bcw.bdj);
    AppMethodBeat.o(91905);
    return l;
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(91904);
    if (this.bcr.isEmpty())
    {
      AppMethodBeat.o(91904);
      return -9223372036854775807L;
    }
    if ((!this.bcr.isEmpty()) && (this.bcp == 0) && (this.bcw.bdg.vx())) {}
    for (int i = 1; i != 0; i = 0)
    {
      com.google.android.exoplayer2.source.i.b localb = this.bcw.bdg;
      this.bcr.a(localb.bww, this.bcl, false);
      l = b.v(this.bcl.bh(localb.bwx, localb.bwy));
      AppMethodBeat.o(91904);
      return l;
    }
    long l = b.v(this.bcr.a(tf(), this.bck).bdM);
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
    new StringBuilder("Release ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.bHq).append("] [").append(j.tp()).append("]");
    this.bci.release();
    this.eventHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(91900);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(91897);
    int j = tf();
    if ((j < 0) || ((!this.bcr.isEmpty()) && (j >= this.bcr.ty())))
    {
      localObject = new l(this.bcr, j, paramLong);
      AppMethodBeat.o(91897);
      throw ((Throwable)localObject);
    }
    this.bcp += 1;
    this.bcx = j;
    if (this.bcr.isEmpty()) {}
    int i;
    for (this.bcy = 0; paramLong == -9223372036854775807L; this.bcy = i)
    {
      this.bcz = 0L;
      this.bci.a(this.bcr, j, -9223372036854775807L);
      AppMethodBeat.o(91897);
      return;
      this.bcr.a(j, this.bck);
      if (paramLong == -9223372036854775807L) {}
      for (long l1 = this.bck.beD;; l1 = b.w(paramLong))
      {
        i = this.bck.beB;
        long l2 = this.bck.beE + l1;
        for (l1 = this.bcr.a(i, this.bcl, false).bdM; (l1 != -9223372036854775807L) && (l2 >= l1) && (i < this.bck.beC); l1 = ((w)localObject).a(i, this.bcl, false).bdM)
        {
          l2 -= l1;
          localObject = this.bcr;
          i += 1;
        }
      }
    }
    this.bcz = paramLong;
    this.bci.a(this.bcr, j, b.w(paramLong));
    Object localObject = this.bcj.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((q.a)((Iterator)localObject).next()).tv();
    }
    AppMethodBeat.o(91897);
  }
  
  public final void setRepeatMode(int paramInt)
  {
    AppMethodBeat.i(91896);
    if (this.repeatMode != paramInt)
    {
      this.repeatMode = paramInt;
      this.bci.handler.obtainMessage(12, paramInt, 0).sendToTarget();
      Iterator localIterator = this.bcj.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).aA(paramInt);
      }
    }
    AppMethodBeat.o(91896);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(91899);
    this.bci.handler.sendEmptyMessage(5);
    AppMethodBeat.o(91899);
  }
  
  public final int td()
  {
    return this.bco;
  }
  
  public final boolean te()
  {
    return this.bcn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h
 * JD-Core Version:    0.7.0.1
 */