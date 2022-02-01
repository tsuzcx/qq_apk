package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface k
{
  public abstract j a(b paramb, b paramb1);
  
  public abstract void a(f paramf, a parama);
  
  public abstract void b(j paramj);
  
  public abstract void vt();
  
  public abstract void vu();
  
  public static abstract interface a
  {
    public abstract void a(w paramw, Object paramObject);
  }
  
  public static final class b
  {
    public static final b bww;
    public final int bwx;
    public final int bwy;
    public final int bwz;
    
    static
    {
      AppMethodBeat.i(92680);
      bww = new b(-1, -1, -1);
      AppMethodBeat.o(92680);
    }
    
    public b(int paramInt)
    {
      this(paramInt, -1, -1);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.bwx = paramInt1;
      this.bwy = paramInt2;
      this.bwz = paramInt3;
    }
    
    public final b eA(int paramInt)
    {
      AppMethodBeat.i(92678);
      if (this.bwx == paramInt)
      {
        AppMethodBeat.o(92678);
        return this;
      }
      b localb = new b(paramInt, this.bwy, this.bwz);
      AppMethodBeat.o(92678);
      return localb;
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
      if ((this.bwx == paramObject.bwx) && (this.bwy == paramObject.bwy) && (this.bwz == paramObject.bwz))
      {
        AppMethodBeat.o(92679);
        return true;
      }
      AppMethodBeat.o(92679);
      return false;
    }
    
    public final int hashCode()
    {
      return ((this.bwx + 527) * 31 + this.bwy) * 31 + this.bwz;
    }
    
    public final boolean isAd()
    {
      return this.bwy != -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.k
 * JD-Core Version:    0.7.0.1
 */