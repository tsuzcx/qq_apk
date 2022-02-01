package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface j
{
  public abstract i a(b paramb, b paramb1);
  
  public abstract void a(f paramf, a parama);
  
  public abstract void b(i parami);
  
  public abstract void tG();
  
  public abstract void tH();
  
  public static abstract interface a
  {
    public abstract void a(w paramw, Object paramObject);
  }
  
  public static final class b
  {
    public static final b blv;
    public final int blw;
    public final int blx;
    public final int bly;
    
    static
    {
      AppMethodBeat.i(92680);
      blv = new b(-1, -1, -1);
      AppMethodBeat.o(92680);
    }
    
    public b(int paramInt)
    {
      this(paramInt, -1, -1);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.blw = paramInt1;
      this.blx = paramInt2;
      this.bly = paramInt3;
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
      if ((this.blw == paramObject.blw) && (this.blx == paramObject.blx) && (this.bly == paramObject.bly))
      {
        AppMethodBeat.o(92679);
        return true;
      }
      AppMethodBeat.o(92679);
      return false;
    }
    
    public final b ex(int paramInt)
    {
      AppMethodBeat.i(92678);
      if (this.blw == paramInt)
      {
        AppMethodBeat.o(92678);
        return this;
      }
      b localb = new b(paramInt, this.blx, this.bly);
      AppMethodBeat.o(92678);
      return localb;
    }
    
    public final int hashCode()
    {
      return ((this.blw + 527) * 31 + this.blx) * 31 + this.bly;
    }
    
    public final boolean tQ()
    {
      return this.blx != -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.j
 * JD-Core Version:    0.7.0.1
 */