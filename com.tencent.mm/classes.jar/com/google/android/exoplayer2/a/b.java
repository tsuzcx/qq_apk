package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b beM;
  public final int beN;
  public final int beO;
  AudioAttributes beP;
  public final int flags;
  
  static
  {
    AppMethodBeat.i(91755);
    a locala = new a();
    beM = new b(locala.beN, locala.flags, locala.beO, (byte)0);
    AppMethodBeat.o(91755);
  }
  
  private b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.beN = paramInt1;
    this.flags = paramInt2;
    this.beO = paramInt3;
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
    if ((this.beN == paramObject.beN) && (this.flags == paramObject.flags) && (this.beO == paramObject.beO))
    {
      AppMethodBeat.o(91754);
      return true;
    }
    AppMethodBeat.o(91754);
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.beN + 527) * 31 + this.flags) * 31 + this.beO;
  }
  
  public static final class a
  {
    int beN = 0;
    int beO = 1;
    int flags = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.a.b
 * JD-Core Version:    0.7.0.1
 */