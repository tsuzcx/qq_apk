package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b aOk;
  public final int aOl;
  public final int aOm;
  AudioAttributes aOn;
  public final int flags;
  
  static
  {
    AppMethodBeat.i(91755);
    a locala = new a();
    aOk = new b(locala.aOl, locala.flags, locala.aOm, (byte)0);
    AppMethodBeat.o(91755);
  }
  
  private b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.aOl = paramInt1;
    this.flags = paramInt2;
    this.aOm = paramInt3;
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
    if ((this.aOl == paramObject.aOl) && (this.flags == paramObject.flags) && (this.aOm == paramObject.aOm))
    {
      AppMethodBeat.o(91754);
      return true;
    }
    AppMethodBeat.o(91754);
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.aOl + 527) * 31 + this.flags) * 31 + this.aOm;
  }
  
  public static final class a
  {
    int aOl = 0;
    int aOm = 1;
    int flags = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.a.b
 * JD-Core Version:    0.7.0.1
 */