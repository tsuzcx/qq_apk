package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface k
{
  public abstract void SU();
  
  public abstract void SV();
  
  public abstract j a(b paramb, b paramb1);
  
  public abstract void a(f paramf, a parama);
  
  public abstract void b(j paramj);
  
  public static abstract interface a
  {
    public abstract void a(w paramw, Object paramObject);
  }
  
  public static final class b
  {
    public static final b cZR;
    public final int cZS;
    public final int cZT;
    public final int cZU;
    
    static
    {
      AppMethodBeat.i(92680);
      cZR = new b(-1, -1, -1);
      AppMethodBeat.o(92680);
    }
    
    public b(int paramInt)
    {
      this(paramInt, -1, -1);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.cZS = paramInt1;
      this.cZT = paramInt2;
      this.cZU = paramInt3;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(92679);
      if (this == paramObject)
      {
        AppMethodBeat.o(92679);
        return true;
      }
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
      {
        AppMethodBeat.o(92679);
        return false;
      }
      paramObject = (b)paramObject;
      if ((this.cZS == paramObject.cZS) && (this.cZT == paramObject.cZT) && (this.cZU == paramObject.cZU))
      {
        AppMethodBeat.o(92679);
        return true;
      }
      AppMethodBeat.o(92679);
      return false;
    }
    
    public final int hashCode()
    {
      return ((this.cZS + 527) * 31 + this.cZT) * 31 + this.cZU;
    }
    
    public final b ig(int paramInt)
    {
      AppMethodBeat.i(92678);
      if (this.cZS == paramInt)
      {
        AppMethodBeat.o(92678);
        return this;
      }
      b localb = new b(paramInt, this.cZT, this.cZU);
      AppMethodBeat.o(92678);
      return localb;
    }
    
    public final boolean isAd()
    {
      return this.cZT != -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.k
 * JD-Core Version:    0.7.0.1
 */