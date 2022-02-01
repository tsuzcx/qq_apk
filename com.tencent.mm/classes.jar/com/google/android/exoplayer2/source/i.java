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
  
  public abstract void tO();
  
  public abstract void tP();
  
  public static abstract interface a
  {
    public abstract void a(w paramw, Object paramObject);
  }
  
  public static final class b
  {
    public static final b bma;
    public final int bmb;
    public final int bmc;
    public final int bmd;
    
    static
    {
      AppMethodBeat.i(92680);
      bma = new b(-1, -1, -1);
      AppMethodBeat.o(92680);
    }
    
    public b(int paramInt)
    {
      this(paramInt, -1, -1);
    }
    
    public b(int paramInt1, int paramInt2, int paramInt3)
    {
      this.bmb = paramInt1;
      this.bmc = paramInt2;
      this.bmd = paramInt3;
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
      if ((this.bmb == paramObject.bmb) && (this.bmc == paramObject.bmc) && (this.bmd == paramObject.bmd))
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
      if (this.bmb == paramInt)
      {
        AppMethodBeat.o(92678);
        return this;
      }
      b localb = new b(paramInt, this.bmc, this.bmd);
      AppMethodBeat.o(92678);
      return localb;
    }
    
    public final int hashCode()
    {
      return ((this.bmb + 527) * 31 + this.bmc) * 31 + this.bmd;
    }
    
    public final boolean tY()
    {
      return this.bmc != -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.i
 * JD-Core Version:    0.7.0.1
 */