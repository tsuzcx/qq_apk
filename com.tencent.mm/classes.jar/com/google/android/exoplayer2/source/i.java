package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.a;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  implements k
{
  private final k cZL;
  int cZM;
  final int loopCount;
  
  public i(k paramk)
  {
    AppMethodBeat.i(210352);
    a.checkArgument(true);
    this.cZL = paramk;
    this.loopCount = 50;
    AppMethodBeat.o(210352);
  }
  
  public final void SU()
  {
    AppMethodBeat.i(210356);
    this.cZL.SU();
    AppMethodBeat.o(210356);
  }
  
  public final void SV()
  {
    AppMethodBeat.i(210359);
    this.cZL.SV();
    AppMethodBeat.o(210359);
  }
  
  public final j a(k.b paramb, b paramb1)
  {
    AppMethodBeat.i(210357);
    if (this.loopCount != 2147483647)
    {
      paramb = this.cZL.a(new k.b(paramb.cZS % this.cZM), paramb1);
      AppMethodBeat.o(210357);
      return paramb;
    }
    paramb = this.cZL.a(paramb, paramb1);
    AppMethodBeat.o(210357);
    return paramb;
  }
  
  public final void a(f paramf, final k.a parama)
  {
    AppMethodBeat.i(210354);
    this.cZL.a(paramf, new k.a()
    {
      public final void a(w paramAnonymousw, Object paramAnonymousObject)
      {
        AppMethodBeat.i(210348);
        i.this.cZM = paramAnonymousw.QX();
        if (i.this.loopCount != 2147483647) {}
        for (paramAnonymousw = new i.b(paramAnonymousw, i.this.loopCount);; paramAnonymousw = new i.a(paramAnonymousw))
        {
          parama.a(paramAnonymousw, paramAnonymousObject);
          AppMethodBeat.o(210348);
          return;
        }
      }
    });
    AppMethodBeat.o(210354);
  }
  
  public final void b(j paramj)
  {
    AppMethodBeat.i(210358);
    this.cZL.b(paramj);
    AppMethodBeat.o(210358);
  }
  
  static final class a
    extends w
  {
    private final w cZP;
    
    public a(w paramw)
    {
      this.cZP = paramw;
    }
    
    public final int QW()
    {
      AppMethodBeat.i(210342);
      int i = this.cZP.QW();
      AppMethodBeat.o(210342);
      return i;
    }
    
    public final int QX()
    {
      AppMethodBeat.i(210349);
      int i = this.cZP.QX();
      AppMethodBeat.o(210349);
      return i;
    }
    
    public final w.a a(int paramInt, w.a parama, boolean paramBoolean)
    {
      AppMethodBeat.i(210351);
      parama = this.cZP.a(paramInt, parama, paramBoolean);
      AppMethodBeat.o(210351);
      return parama;
    }
    
    public final w.b a(int paramInt, w.b paramb, boolean paramBoolean, long paramLong)
    {
      AppMethodBeat.i(210347);
      paramb = this.cZP.a(paramInt, paramb, paramBoolean, paramLong);
      AppMethodBeat.o(210347);
      return paramb;
    }
    
    public final int bf(Object paramObject)
    {
      AppMethodBeat.i(210355);
      int i = this.cZP.bf(paramObject);
      AppMethodBeat.o(210355);
      return i;
    }
    
    public final int ca(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(210343);
      paramInt1 = this.cZP.ca(paramInt1, paramInt2);
      if (paramInt1 == -1)
      {
        AppMethodBeat.o(210343);
        return 0;
      }
      AppMethodBeat.o(210343);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.i
 * JD-Core Version:    0.7.0.1
 */