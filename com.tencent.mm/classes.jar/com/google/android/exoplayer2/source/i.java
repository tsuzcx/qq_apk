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
  private final k bwq;
  int bwr;
  final int loopCount;
  
  public i(k paramk)
  {
    AppMethodBeat.i(196054);
    com.google.android.exoplayer2.i.a.checkArgument(true);
    this.bwq = paramk;
    this.loopCount = 50;
    AppMethodBeat.o(196054);
  }
  
  public final j a(k.b paramb, b paramb1)
  {
    AppMethodBeat.i(196057);
    if (this.loopCount != 2147483647)
    {
      paramb = this.bwq.a(new k.b(paramb.bwx % this.bwr), paramb1);
      AppMethodBeat.o(196057);
      return paramb;
    }
    paramb = this.bwq.a(paramb, paramb1);
    AppMethodBeat.o(196057);
    return paramb;
  }
  
  public final void a(f paramf, final k.a parama)
  {
    AppMethodBeat.i(196055);
    this.bwq.a(paramf, new k.a()
    {
      public final void a(w paramAnonymousw, Object paramAnonymousObject)
      {
        AppMethodBeat.i(196044);
        i.this.bwr = paramAnonymousw.tE();
        if (i.this.loopCount != 2147483647) {}
        for (paramAnonymousw = new i.b(paramAnonymousw, i.this.loopCount);; paramAnonymousw = new i.a(paramAnonymousw))
        {
          parama.a(paramAnonymousw, paramAnonymousObject);
          AppMethodBeat.o(196044);
          return;
        }
      }
    });
    AppMethodBeat.o(196055);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(196058);
    this.bwq.b(paramj);
    AppMethodBeat.o(196058);
  }
  
  public final void vt()
  {
    AppMethodBeat.i(196056);
    this.bwq.vt();
    AppMethodBeat.o(196056);
  }
  
  public final void vu()
  {
    AppMethodBeat.i(196059);
    this.bwq.vu();
    AppMethodBeat.o(196059);
  }
  
  static final class a
    extends w
  {
    private final w bwu;
    
    public a(w paramw)
    {
      this.bwu = paramw;
    }
    
    public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(196049);
      parama = this.bwu.a(paramInt, parama, paramBoolean);
      AppMethodBeat.o(196049);
      return parama;
    }
    
    public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
    {
      AppMethodBeat.i(196047);
      paramb = this.bwu.a(paramInt, paramb, paramBoolean, paramLong);
      AppMethodBeat.o(196047);
      return paramb;
    }
    
    public final int aZ(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(196046);
      paramInt1 = this.bwu.aZ(paramInt1, paramInt2);
      if (paramInt1 == -1)
      {
        AppMethodBeat.o(196046);
        return 0;
      }
      AppMethodBeat.o(196046);
      return paramInt1;
    }
    
    public final int ae(Object paramObject)
    {
      AppMethodBeat.i(196050);
      int i = this.bwu.ae(paramObject);
      AppMethodBeat.o(196050);
      return i;
    }
    
    public final int tD()
    {
      AppMethodBeat.i(196045);
      int i = this.bwu.tD();
      AppMethodBeat.o(196045);
      return i;
    }
    
    public final int tE()
    {
      AppMethodBeat.i(196048);
      int i = this.bwu.tE();
      AppMethodBeat.o(196048);
      return i;
    }
  }
  
  static final class b
    extends a
  {
    private final int bwr;
    private final w bwu;
    private final int bwv;
    private final int loopCount;
    
    public b(w paramw, int paramInt)
    {
      super();
      AppMethodBeat.i(196051);
      this.bwu = paramw;
      this.bwr = paramw.tE();
      this.bwv = paramw.tD();
      this.loopCount = paramInt;
      if (paramInt <= 2147483647 / this.bwr) {}
      for (boolean bool = true;; bool = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool, "LoopingMediaSource contains too many periods");
        AppMethodBeat.o(196051);
        return;
      }
    }
    
    protected final int ag(Object paramObject)
    {
      AppMethodBeat.i(196052);
      if (!(paramObject instanceof Integer))
      {
        AppMethodBeat.o(196052);
        return -1;
      }
      int i = ((Integer)paramObject).intValue();
      AppMethodBeat.o(196052);
      return i;
    }
    
    protected final int ev(int paramInt)
    {
      return paramInt / this.bwr;
    }
    
    protected final int ew(int paramInt)
    {
      return paramInt / this.bwv;
    }
    
    protected final int ex(int paramInt)
    {
      return this.bwr * paramInt;
    }
    
    protected final int ey(int paramInt)
    {
      return this.bwv * paramInt;
    }
    
    protected final Object ez(int paramInt)
    {
      AppMethodBeat.i(196053);
      AppMethodBeat.o(196053);
      return Integer.valueOf(paramInt);
    }
    
    public final int tD()
    {
      return this.bwv * this.loopCount;
    }
    
    public final int tE()
    {
      return this.bwr * this.loopCount;
    }
    
    protected final w vk()
    {
      return this.bwu;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.i
 * JD-Core Version:    0.7.0.1
 */