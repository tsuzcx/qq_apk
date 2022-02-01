package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b aUs;
  public final int aUt;
  public final int aUu;
  AudioAttributes aUv;
  public final int flags;
  
  static
  {
    AppMethodBeat.i(91755);
    a locala = new a();
    aUs = new b(locala.aUt, locala.flags, locala.aUu, (byte)0);
    AppMethodBeat.o(91755);
  }
  
  private b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.aUt = paramInt1;
    this.flags = paramInt2;
    this.aUu = paramInt3;
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
    if ((this.aUt == paramObject.aUt) && (this.flags == paramObject.flags) && (this.aUu == paramObject.aUu))
    {
      AppMethodBeat.o(91754);
      return true;
    }
    AppMethodBeat.o(91754);
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.aUt + 527) * 31 + this.flags) * 31 + this.aUu;
  }
  
  public static final class a
  {
    int aUt = 0;
    int aUu = 1;
    int flags = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.a.b
 * JD-Core Version:    0.7.0.1
 */