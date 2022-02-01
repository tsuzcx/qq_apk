package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public abstract class h
{
  final long bdm;
  final f boq;
  final long bor;
  
  public h(f paramf, long paramLong1, long paramLong2)
  {
    this.boq = paramf;
    this.bdm = paramLong1;
    this.bor = paramLong2;
  }
  
  public f a(g paramg)
  {
    return this.boq;
  }
  
  public static abstract class a
    extends h
  {
    final int bos;
    final List<h.d> bot;
    final long duration;
    
    public a(f paramf, long paramLong1, long paramLong2, int paramInt, long paramLong3, List<h.d> paramList)
    {
      super(paramLong1, paramLong2);
      this.bos = paramInt;
      this.duration = paramLong3;
      this.bot = paramList;
    }
    
    public abstract f a(g paramg, int paramInt);
    
    public abstract int ah(long paramLong);
    
    public final long eO(int paramInt)
    {
      if (this.bot != null) {}
      for (long l = ((h.d)this.bot.get(paramInt - this.bos)).startTime - this.bor;; l = (paramInt - this.bos) * this.duration) {
        return x.b(l, 1000000L, this.bdm);
      }
    }
    
    public boolean uj()
    {
      return this.bot != null;
    }
  }
  
  public static final class b
    extends h.a
  {
    final List<f> bou;
    
    public b(f paramf, long paramLong1, long paramLong2, int paramInt, long paramLong3, List<h.d> paramList, List<f> paramList1)
    {
      super(paramLong1, paramLong2, paramInt, paramLong3, paramList);
      this.bou = paramList1;
    }
    
    public final f a(g paramg, int paramInt)
    {
      AppMethodBeat.i(10571);
      paramg = (f)this.bou.get(paramInt - this.bos);
      AppMethodBeat.o(10571);
      return paramg;
    }
    
    public final int ah(long paramLong)
    {
      AppMethodBeat.i(10572);
      int i = this.bou.size();
      AppMethodBeat.o(10572);
      return i;
    }
    
    public final boolean uj()
    {
      return true;
    }
  }
  
  public static final class c
    extends h.a
  {
    final j bov;
    final j bow;
    
    public c(f paramf, long paramLong1, long paramLong2, int paramInt, long paramLong3, List<h.d> paramList, j paramj1, j paramj2)
    {
      super(paramLong1, paramLong2, paramInt, paramLong3, paramList);
      this.bov = paramj1;
      this.bow = paramj2;
    }
    
    public final f a(g paramg)
    {
      AppMethodBeat.i(10573);
      if (this.bov != null)
      {
        paramg = new f(this.bov.a(paramg.aSv.id, 0, paramg.aSv.bitrate, 0L), 0L, -1L);
        AppMethodBeat.o(10573);
        return paramg;
      }
      paramg = super.a(paramg);
      AppMethodBeat.o(10573);
      return paramg;
    }
    
    public final f a(g paramg, int paramInt)
    {
      AppMethodBeat.i(10574);
      if (this.bot != null) {}
      for (long l = ((h.d)this.bot.get(paramInt - this.bos)).startTime;; l = (paramInt - this.bos) * this.duration)
      {
        paramg = new f(this.bow.a(paramg.aSv.id, paramInt, paramg.aSv.bitrate, l), 0L, -1L);
        AppMethodBeat.o(10574);
        return paramg;
      }
    }
    
    public final int ah(long paramLong)
    {
      AppMethodBeat.i(10575);
      int i;
      if (this.bot != null)
      {
        i = this.bot.size();
        AppMethodBeat.o(10575);
        return i;
      }
      if (paramLong != -9223372036854775807L)
      {
        i = (int)x.n(paramLong, this.duration * 1000000L / this.bdm);
        AppMethodBeat.o(10575);
        return i;
      }
      AppMethodBeat.o(10575);
      return -1;
    }
  }
  
  public static final class d
  {
    final long duration;
    final long startTime;
    
    public d(long paramLong1, long paramLong2)
    {
      this.startTime = paramLong1;
      this.duration = paramLong2;
    }
  }
  
  public static final class e
    extends h
  {
    final long box;
    final long boy;
    
    public e()
    {
      this(null, 1L, 0L, 0L, 0L);
    }
    
    public e(f paramf, long paramLong1, long paramLong2, long paramLong3, long paramLong4)
    {
      super(paramLong1, paramLong2);
      this.box = paramLong3;
      this.boy = paramLong4;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.manifest.h
 * JD-Core Version:    0.7.0.1
 */