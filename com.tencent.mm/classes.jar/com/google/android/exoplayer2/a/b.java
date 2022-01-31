package com.google.android.exoplayer2.a;

import android.media.AudioAttributes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final b ayh;
  public final int ayi;
  public final int ayj;
  AudioAttributes ayk;
  public final int flags;
  
  static
  {
    AppMethodBeat.i(94644);
    b.a locala = new b.a();
    ayh = new b(locala.ayi, locala.flags, locala.ayj, (byte)0);
    AppMethodBeat.o(94644);
  }
  
  private b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.ayi = paramInt1;
    this.flags = paramInt2;
    this.ayj = paramInt3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(94643);
    if (this == paramObject)
    {
      AppMethodBeat.o(94643);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(94643);
      return false;
    }
    paramObject = (b)paramObject;
    if ((this.ayi == paramObject.ayi) && (this.flags == paramObject.flags) && (this.ayj == paramObject.ayj))
    {
      AppMethodBeat.o(94643);
      return true;
    }
    AppMethodBeat.o(94643);
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.ayi + 527) * 31 + this.flags) * 31 + this.ayj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.a.b
 * JD-Core Version:    0.7.0.1
 */