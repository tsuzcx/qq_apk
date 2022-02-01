package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b aTA;
  public final int aTB;
  public final int aTC;
  AudioAttributes aTD;
  public final int flags;
  
  static
  {
    AppMethodBeat.i(91755);
    aTA = new a().rT();
    AppMethodBeat.o(91755);
  }
  
  private b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.aTB = paramInt1;
    this.flags = paramInt2;
    this.aTC = paramInt3;
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
    if ((this.aTB == paramObject.aTB) && (this.flags == paramObject.flags) && (this.aTC == paramObject.aTC))
    {
      AppMethodBeat.o(91754);
      return true;
    }
    AppMethodBeat.o(91754);
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.aTB + 527) * 31 + this.flags) * 31 + this.aTC;
  }
  
  public static final class a
  {
    public int aTB = 0;
    public int aTC = 1;
    private int flags = 0;
    
    public final b rT()
    {
      AppMethodBeat.i(91753);
      b localb = new b(this.aTB, this.flags, this.aTC, (byte)0);
      AppMethodBeat.o(91753);
      return localb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.b
 * JD-Core Version:    0.7.0.1
 */