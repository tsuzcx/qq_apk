package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  implements k
{
  private final k bfS;
  int bfT;
  final int loopCount;
  
  public i(k paramk)
  {
    AppMethodBeat.i(196347);
    com.google.android.exoplayer2.i.a.checkArgument(true);
    this.bfS = paramk;
    this.loopCount = 50;
    AppMethodBeat.o(196347);
  }
  
  public final j a(k.b paramb, b paramb1)
  {
    AppMethodBeat.i(196354);
    if (this.loopCount != 2147483647)
    {
      paramb = this.bfS.a(new k.b(paramb.bfZ % this.bfT), paramb1);
      AppMethodBeat.o(196354);
      return paramb;
    }
    paramb = this.bfS.a(paramb, paramb1);
    AppMethodBeat.o(196354);
    return paramb;
  }
  
  public final void a(f paramf, final k.a parama)
  {
    AppMethodBeat.i(196350);
    this.bfS.a(paramf, new k.a()
    {
      public final void a(w paramAnonymousw, Object paramAnonymousObject)
      {
        AppMethodBeat.i(196295);
        i.this.bfT = paramAnonymousw.rw();
        if (i.this.loopCount != 2147483647) {}
        for (paramAnonymousw = new i.b(paramAnonymousw, i.this.loopCount);; paramAnonymousw = new i.a(paramAnonymousw))
        {
          parama.a(paramAnonymousw, paramAnonymousObject);
          AppMethodBeat.o(196295);
          return;
        }
      }
    });
    AppMethodBeat.o(196350);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(196356);
    this.bfS.b(paramj);
    AppMethodBeat.o(196356);
  }
  
  public final void tr()
  {
    AppMethodBeat.i(196351);
    this.bfS.tr();
    AppMethodBeat.o(196351);
  }
  
  public final void ts()
  {
    AppMethodBeat.i(196357);
    this.bfS.ts();
    AppMethodBeat.o(196357);
  }
  
  static final class a
    extends w
  {
    private final w bfW;
    
    public a(w paramw)
    {
      this.bfW = paramw;
    }
    
    public final int W(Object paramObject)
    {
      AppMethodBeat.i(196315);
      int i = this.bfW.W(paramObject);
      AppMethodBeat.o(196315);
      return i;
    }
    
    public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(196312);
      parama = this.bfW.a(paramInt, parama, paramBoolean);
      AppMethodBeat.o(196312);
      return parama;
    }
    
    public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
    {
      AppMethodBeat.i(196306);
      paramb = this.bfW.a(paramInt, paramb, paramBoolean, paramLong);
      AppMethodBeat.o(196306);
      return paramb;
    }
    
    public final int bf(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196303);
      paramInt1 = this.bfW.bf(paramInt1, paramInt2);
      if (paramInt1 == -1)
      {
        AppMethodBeat.o(196303);
        return 0;
      }
      AppMethodBeat.o(196303);
      return paramInt1;
    }
    
    public final int rv()
    {
      AppMethodBeat.i(196301);
      int i = this.bfW.rv();
      AppMethodBeat.o(196301);
      return i;
    }
    
    public final int rw()
    {
      AppMethodBeat.i(196309);
      int i = this.bfW.rw();
      AppMethodBeat.o(196309);
      return i;
    }
  }
  
  static final class b
    extends a
  {
    private final int bfT;
    private final w bfW;
    private final int bfX;
    private final int loopCount;
    
    public b(w paramw, int paramInt)
    {
      super();
      AppMethodBeat.i(196321);
      this.bfW = paramw;
      this.bfT = paramw.rw();
      this.bfX = paramw.rv();
      this.loopCount = paramInt;
      if (paramInt <= 2147483647 / this.bfT) {}
      for (boolean bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool, "LoopingMediaSource contains too many periods");
        AppMethodBeat.o(196321);
        return;
      }
    }
    
    protected final int Y(Object paramObject)
    {
      AppMethodBeat.i(196326);
      if (!(paramObject instanceof Integer))
      {
        AppMethodBeat.o(196326);
        return -1;
      }
      int i = ((Integer)paramObject).intValue();
      AppMethodBeat.o(196326);
      return i;
    }
    
    protected final int eL(int paramInt)
    {
      return paramInt / this.bfT;
    }
    
    protected final int eM(int paramInt)
    {
      return paramInt / this.bfX;
    }
    
    protected final int eN(int paramInt)
    {
      return this.bfT * paramInt;
    }
    
    protected final int eO(int paramInt)
    {
      return this.bfX * paramInt;
    }
    
    protected final Object eP(int paramInt)
    {
      AppMethodBeat.i(196329);
      AppMethodBeat.o(196329);
      return Integer.valueOf(paramInt);
    }
    
    public final int rv()
    {
      return this.bfX * this.loopCount;
    }
    
    public final int rw()
    {
      return this.bfT * this.loopCount;
    }
    
    protected final w ti()
    {
      return this.bfW;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.i
 * JD-Core Version:    0.7.0.1
 */