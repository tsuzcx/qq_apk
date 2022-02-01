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
  
  public abstract void tr();
  
  public abstract void ts();
  
  public static abstract interface a
  {
    public abstract void a(w paramw, Object paramObject);
  }
  
  public static final class b
  {
    public static final b bfY;
    public final int bfZ;
    public final int bga;
    public final int bgb;
    
    static
    {
      AppMethodBeat.i(92680);
      bfY = new b(-1, -1, -1);
      AppMethodBeat.o(92680);
    }
    
    public b(int paramInt)
    {
      this(paramInt, -1, -1);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.bfZ = paramInt1;
      this.bga = paramInt2;
      this.bgb = paramInt3;
    }
    
    public final b eQ(int paramInt)
    {
      AppMethodBeat.i(92678);
      if (this.bfZ == paramInt)
      {
        AppMethodBeat.o(92678);
        return this;
      }
      b localb = new b(paramInt, this.bga, this.bgb);
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
      if ((this.bfZ == paramObject.bfZ) && (this.bga == paramObject.bga) && (this.bgb == paramObject.bgb))
      {
        AppMethodBeat.o(92679);
        return true;
      }
      AppMethodBeat.o(92679);
      return false;
    }
    
    public final int hashCode()
    {
      return ((this.bfZ + 527) * 31 + this.bga) * 31 + this.bgb;
    }
    
    public final boolean isAd()
    {
      return this.bga != -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.k
 * JD-Core Version:    0.7.0.1
 */