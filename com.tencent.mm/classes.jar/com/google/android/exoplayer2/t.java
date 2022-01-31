package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
{
  public static final t axm;
  public final int axn;
  
  static
  {
    AppMethodBeat.i(95392);
    axm = new t(0);
    AppMethodBeat.o(95392);
  }
  
  public t(int paramInt)
  {
    this.axn = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95391);
    if (this == paramObject)
    {
      AppMethodBeat.o(95391);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95391);
      return false;
    }
    paramObject = (t)paramObject;
    if (this.axn == paramObject.axn)
    {
      AppMethodBeat.o(95391);
      return true;
    }
    AppMethodBeat.o(95391);
    return false;
  }
  
  public final int hashCode()
  {
    return this.axn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.t
 * JD-Core Version:    0.7.0.1
 */