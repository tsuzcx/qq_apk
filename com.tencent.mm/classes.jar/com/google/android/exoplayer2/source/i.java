package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.h.b;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface i
{
  public abstract h a(b paramb, b paramb1);
  
  public abstract void a(f paramf, a parama);
  
  public abstract void b(h paramh);
  
  public abstract void vn();
  
  public abstract void vo();
  
  public static abstract interface a
  {
    public abstract void a(w paramw, Object paramObject);
  }
  
  public static final class b
  {
    public static final b bwv;
    public final int bww;
    public final int bwx;
    public final int bwy;
    
    static
    {
      AppMethodBeat.i(92680);
      bwv = new b(-1, -1, -1);
      AppMethodBeat.o(92680);
    }
    
    public b(int paramInt)
    {
      this(paramInt, -1, -1);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.bww = paramInt1;
      this.bwx = paramInt2;
      this.bwy = paramInt3;
    }
    
    public final b eB(int paramInt)
    {
      AppMethodBeat.i(92678);
      if (this.bww == paramInt)
      {
        AppMethodBeat.o(92678);
        return this;
      }
      b localb = new b(paramInt, this.bwx, this.bwy);
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
      if ((this.bww == paramObject.bww) && (this.bwx == paramObject.bwx) && (this.bwy == paramObject.bwy))
      {
        AppMethodBeat.o(92679);
        return true;
      }
      AppMethodBeat.o(92679);
      return false;
    }
    
    public final int hashCode()
    {
      return ((this.bww + 527) * 31 + this.bwx) * 31 + this.bwy;
    }
    
    public final boolean vx()
    {
      return this.bwx != -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.i
 * JD-Core Version:    0.7.0.1
 */