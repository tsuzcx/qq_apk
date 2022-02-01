package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b beJ;
  public final int beK;
  public final int beL;
  AudioAttributes beM;
  public final int flags;
  
  static
  {
    AppMethodBeat.i(91755);
    a locala = new a();
    beJ = new b(locala.beK, locala.flags, locala.beL, (byte)0);
    AppMethodBeat.o(91755);
  }
  
  private b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.beK = paramInt1;
    this.flags = paramInt2;
    this.beL = paramInt3;
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
    if ((this.beK == paramObject.beK) && (this.flags == paramObject.flags) && (this.beL == paramObject.beL))
    {
      AppMethodBeat.o(91754);
      return true;
    }
    AppMethodBeat.o(91754);
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.beK + 527) * 31 + this.flags) * 31 + this.beL;
  }
  
  public static final class a
  {
    int beK = 0;
    int beL = 1;
    int flags = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.a.b
 * JD-Core Version:    0.7.0.1
 */