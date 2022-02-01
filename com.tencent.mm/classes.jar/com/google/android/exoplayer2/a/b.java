package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b cIg;
  public final int cIh;
  public final int cIi;
  AudioAttributes cIj;
  public final int flags;
  
  static
  {
    AppMethodBeat.i(91755);
    cIg = new a().Ra();
    AppMethodBeat.o(91755);
  }
  
  private b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.cIh = paramInt1;
    this.flags = paramInt2;
    this.cIi = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(91754);
    if (this == paramObject)
    {
      AppMethodBeat.o(91754);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(91754);
      return false;
    }
    paramObject = (b)paramObject;
    if ((this.cIh == paramObject.cIh) && (this.flags == paramObject.flags) && (this.cIi == paramObject.cIi))
    {
      AppMethodBeat.o(91754);
      return true;
    }
    AppMethodBeat.o(91754);
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.cIh + 527) * 31 + this.flags) * 31 + this.cIi;
  }
  
  public static final class a
  {
    public int cIh = 0;
    public int cIi = 1;
    private int flags = 0;
    
    public final b Ra()
    {
      AppMethodBeat.i(91753);
      b localb = new b(this.cIh, this.flags, this.cIi, (byte)0);
      AppMethodBeat.o(91753);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.b
 * JD-Core Version:    0.7.0.1
 */