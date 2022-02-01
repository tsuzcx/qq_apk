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
  private final r[] bcc;
  final com.google.android.exoplayer2.g.h bcd;
  private final g bce;
  private final i bcf;
  final CopyOnWriteArraySet<q.a> bcg;
  private final w.b bch;
  private final w.a bci;
  boolean bcj;
  boolean bck;
  int bcl;
  int bcm;
  int bcn;
  w bco;
  Object bcp;
  com.google.android.exoplayer2.source.r bcq;
  g bcr;
  p bcs;
  i.b bct;
  int bcu;
  int bcv;
  long bcw;
  private final Handler eventHandler;
  boolean isLoading;
  private int repeatMode;
  
  @SuppressLint({"HandlerLeak"})
  public h(r[] paramArrayOfr, com.google.android.exoplayer2.g.h paramh, m paramm)
  {
    AppMethodBeat.i(91891);
    new StringBuilder("Init ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.bHH).append("]");
    boolean bool;
    if (paramArrayOfr.length > 0)
    {
      bool = true;
      a.checkState(bool);
      this.bcc = ((r[])a.checkNotNull(paramArrayOfr));
      this.bcd = ((com.google.android.exoplayer2.g.h)a.checkNotNull(paramh));
      this.bck = false;
      this.repeatMode = 0;
      this.bcl = 1;
      this.bcg = new CopyOnWriteArraySet();
      this.bce = new g(new com.google.android.exoplayer2.g.f[paramArrayOfr.length]);
      this.bco = w.bel;
      this.bch = new w.b();
      this.bci = new w.a();
      this.bcq = com.google.android.exoplayer2.source.r.bxh;
      this.bcr = this.bce;
      this.bcs = p.bdM;
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
            ((h)localObject).bcn -= 1;
            AppMethodBeat.o(91890);
            return;
          case 1: 
            ((h)localObject).bcl = paramAnonymousMessage.arg1;
            paramAnonymousMessage = ((h)localObject).bcg.iterator();
            while (paramAnonymousMessage.hasNext()) {
              ((q.a)paramAnonymousMessage.next()).c(((h)localObject).bck, ((h)localObject).bcl);
            }
            AppMethodBeat.o(91890);
            return;
          case 2: 
            if (paramAnonymousMessage.arg1 != 0) {}
            for (boolean bool = true;; bool = false)
            {
              ((h)localObject).isLoading = bool;
              paramAnonymousMessage = ((h)localObject).bcg.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).aR(((h)localObject).isLoading);
              }
            }
            AppMethodBeat.o(91890);
            return;
          case 3: 
            if (((h)localObject).bcn == 0)
            {
              paramAnonymousMessage = (com.google.android.exoplayer2.g.i)paramAnonymousMessage.obj;
              ((h)localObject).bcj = true;
              ((h)localObject).bcq = paramAnonymousMessage.bEF;
              ((h)localObject).bcr = paramAnonymousMessage.bEG;
              ((h)localObject).bcd.ah(paramAnonymousMessage.info);
              paramAnonymousMessage = ((h)localObject).bcg.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).tz();
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 4: 
            int i = ((h)localObject).bcm - 1;
            ((h)localObject).bcm = i;
            if (i == 0)
            {
              ((h)localObject).bct = ((i.b)paramAnonymousMessage.obj);
              if (((h)localObject).bco.isEmpty())
              {
                ((h)localObject).bcv = 0;
                ((h)localObject).bcu = 0;
                ((h)localObject).bcw = 0L;
              }
              if (paramAnonymousMessage.arg1 != 0)
              {
                paramAnonymousMessage = ((h)localObject).bcg.iterator();
                while (paramAnonymousMessage.hasNext()) {
                  ((q.a)paramAnonymousMessage.next()).tA();
                }
                AppMethodBeat.o(91890);
                return;
              }
            }
            break;
          case 5: 
            if (((h)localObject).bcm == 0)
            {
              ((h)localObject).bct = ((i.b)paramAnonymousMessage.obj);
              paramAnonymousMessage = ((h)localObject).bcg.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).tA();
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 6: 
            paramAnonymousMessage = (i.d)paramAnonymousMessage.obj;
            ((h)localObject).bcm -= paramAnonymousMessage.bdk;
            if (((h)localObject).bcn == 0)
            {
              ((h)localObject).bco = paramAnonymousMessage.bco;
              ((h)localObject).bcp = paramAnonymousMessage.bcp;
              ((h)localObject).bct = paramAnonymousMessage.bct;
              if ((((h)localObject).bcm == 0) && (((h)localObject).bco.isEmpty()))
              {
                ((h)localObject).bcv = 0;
                ((h)localObject).bcu = 0;
                ((h)localObject).bcw = 0L;
              }
              paramAnonymousMessage = ((h)localObject).bcg.iterator();
              while (paramAnonymousMessage.hasNext()) {
                ((q.a)paramAnonymousMessage.next()).ty();
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 7: 
            paramAnonymousMessage = (p)paramAnonymousMessage.obj;
            if (!((h)localObject).bcs.equals(paramAnonymousMessage))
            {
              ((h)localObject).bcs = paramAnonymousMessage;
              localObject = ((h)localObject).bcg.iterator();
              while (((Iterator)localObject).hasNext()) {
                ((q.a)((Iterator)localObject).next()).b(paramAnonymousMessage);
              }
              AppMethodBeat.o(91890);
              return;
            }
            break;
          case 8: 
            paramAnonymousMessage = (e)paramAnonymousMessage.obj;
            localObject = ((h)localObject).bcg.iterator();
            while (((Iterator)localObject).hasNext()) {
              ((q.a)((Iterator)localObject).next()).a(paramAnonymousMessage);
            }
            AppMethodBeat.o(91890);
            return;
          }
          AppMethodBeat.o(91890);
        }
      };
      this.bct = new i.b(0L);
      this.bcf = new i(paramArrayOfr, paramh, paramm, this.bck, this.repeatMode, this.eventHandler, this.bct, this);
      AppMethodBeat.o(91891);
      return;
      bool = false;
      break;
    }
  }
  
  private int tk()
  {
    AppMethodBeat.i(91903);
    if ((this.bco.isEmpty()) || (this.bcm > 0))
    {
      i = this.bcu;
      AppMethodBeat.o(91903);
      return i;
    }
    int i = this.bco.a(this.bct.bdd.bwx, this.bci, false).bdi;
    AppMethodBeat.o(91903);
    return i;
  }
  
  private long y(long paramLong)
  {
    AppMethodBeat.i(91908);
    long l = b.v(paramLong);
    paramLong = l;
    if (!this.bct.bdd.isAd())
    {
      this.bco.a(this.bct.bdd.bwx, this.bci, false);
      paramLong = l + b.v(this.bci.ben);
    }
    AppMethodBeat.o(91908);
    return paramLong;
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(91898);
    p localp = paramp;
    if (paramp == null) {
      localp = p.bdM;
    }
    this.bcf.handler.obtainMessage(4, localp).sendToTarget();
    AppMethodBeat.o(91898);
  }
  
  public final void a(q.a parama)
  {
    AppMethodBeat.i(91892);
    this.bcg.add(parama);
    AppMethodBeat.o(91892);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(91894);
    Iterator localIterator;
    if ((!this.bco.isEmpty()) || (this.bcp != null))
    {
      this.bco = w.bel;
      this.bcp = null;
      localIterator = this.bcg.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).ty();
      }
    }
    if (this.bcj)
    {
      this.bcj = false;
      this.bcq = com.google.android.exoplayer2.source.r.bxh;
      this.bcr = this.bce;
      this.bcd.ah(null);
      localIterator = this.bcg.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).tz();
      }
    }
    this.bcn += 1;
    this.bcf.handler.obtainMessage(0, 1, 0, paramk).sendToTarget();
    AppMethodBeat.o(91894);
  }
  
  public final void a(f.c... paramVarArgs)
  {
    AppMethodBeat.i(91901);
    i locali = this.bcf;
    if (!locali.released)
    {
      locali.bcJ += 1;
      locali.handler.obtainMessage(11, paramVarArgs).sendToTarget();
    }
    AppMethodBeat.o(91901);
  }
  
  public final void aO(boolean paramBoolean)
  {
    AppMethodBeat.i(91895);
    if (this.bck != paramBoolean)
    {
      this.bck = paramBoolean;
      Object localObject = this.bcf.handler;
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        ((Handler)localObject).obtainMessage(1, i, 0).sendToTarget();
        localObject = this.bcg.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((q.a)((Iterator)localObject).next()).c(paramBoolean, this.bcl);
        }
      }
    }
    AppMethodBeat.o(91895);
  }
  
  public final void b(q.a parama)
  {
    AppMethodBeat.i(91893);
    this.bcg.remove(parama);
    AppMethodBeat.o(91893);
  }
  
  public final void b(f.c... paramVarArgs)
  {
    AppMethodBeat.i(91902);
    this.bcf.b(paramVarArgs);
    AppMethodBeat.o(91902);
  }
  
  public final int getBufferedPercentage()
  {
    AppMethodBeat.i(91907);
    if (this.bco.isEmpty())
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
    int i = x.s((int)(l1 * 100L / l2), 0, 100);
    AppMethodBeat.o(91907);
    return i;
  }
  
  public final long getBufferedPosition()
  {
    AppMethodBeat.i(91906);
    if ((this.bco.isEmpty()) || (this.bcm > 0))
    {
      l = this.bcw;
      AppMethodBeat.o(91906);
      return l;
    }
    long l = y(this.bct.bdh);
    AppMethodBeat.o(91906);
    return l;
  }
  
  public final long getCurrentPosition()
  {
    AppMethodBeat.i(91905);
    if ((this.bco.isEmpty()) || (this.bcm > 0))
    {
      l = this.bcw;
      AppMethodBeat.o(91905);
      return l;
    }
    long l = y(this.bct.bdg);
    AppMethodBeat.o(91905);
    return l;
  }
  
  public final long getDuration()
  {
    AppMethodBeat.i(91904);
    if (this.bco.isEmpty())
    {
      AppMethodBeat.o(91904);
      return -9223372036854775807L;
    }
    if ((!this.bco.isEmpty()) && (this.bcm == 0) && (this.bct.bdd.isAd())) {}
    for (int i = 1; i != 0; i = 0)
    {
      k.b localb = this.bct.bdd;
      this.bco.a(localb.bwx, this.bci, false);
      l = b.v(this.bci.bb(localb.bwy, localb.bwz));
      AppMethodBeat.o(91904);
      return l;
    }
    long l = b.v(this.bco.a(tk(), this.bch).bdJ);
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
    new StringBuilder("Release ").append(Integer.toHexString(System.identityHashCode(this))).append(" [ExoPlayerLib/2.5.4] [").append(x.bHH).append("] [").append(j.tu()).append("]");
    this.bcf.release();
    this.eventHandler.removeCallbacksAndMessages(null);
    AppMethodBeat.o(91900);
  }
  
  public final void seekTo(long paramLong)
  {
    AppMethodBeat.i(91897);
    int j = tk();
    if ((j < 0) || ((!this.bco.isEmpty()) && (j >= this.bco.tD())))
    {
      localObject = new l(this.bco, j, paramLong);
      AppMethodBeat.o(91897);
      throw ((Throwable)localObject);
    }
    this.bcm += 1;
    this.bcu = j;
    if (this.bco.isEmpty()) {}
    int i;
    for (this.bcv = 0; paramLong == -9223372036854775807L; this.bcv = i)
    {
      this.bcw = 0L;
      this.bcf.a(this.bco, j, -9223372036854775807L);
      AppMethodBeat.o(91897);
      return;
      this.bco.a(j, this.bch);
      if (paramLong == -9223372036854775807L) {}
      for (long l1 = this.bch.beA;; l1 = b.w(paramLong))
      {
        i = this.bch.bey;
        long l2 = this.bch.beB + l1;
        for (l1 = this.bco.a(i, this.bci, false).bdJ; (l1 != -9223372036854775807L) && (l2 >= l1) && (i < this.bch.bez); l1 = ((w)localObject).a(i, this.bci, false).bdJ)
        {
          l2 -= l1;
          localObject = this.bco;
          i += 1;
        }
      }
    }
    this.bcw = paramLong;
    this.bcf.a(this.bco, j, b.w(paramLong));
    Object localObject = this.bcg.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((q.a)((Iterator)localObject).next()).tA();
    }
    AppMethodBeat.o(91897);
  }
  
  public final void setRepeatMode(int paramInt)
  {
    AppMethodBeat.i(91896);
    if (this.repeatMode != paramInt)
    {
      this.repeatMode = paramInt;
      this.bcf.handler.obtainMessage(12, paramInt, 0).sendToTarget();
      Iterator localIterator = this.bcg.iterator();
      while (localIterator.hasNext()) {
        ((q.a)localIterator.next()).aA(paramInt);
      }
    }
    AppMethodBeat.o(91896);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(91899);
    this.bcf.handler.sendEmptyMessage(5);
    AppMethodBeat.o(91899);
  }
  
  public final int ti()
  {
    return this.bcl;
  }
  
  public final boolean tj()
  {
    return this.bck;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.h
 * JD-Core Version:    0.7.0.1
 */