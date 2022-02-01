package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t
{
  public static final t cHm;
  public final int cHn;
  
  static
  {
    AppMethodBeat.i(92514);
    cHm = new t(0);
    AppMethodBeat.o(92514);
  }
  
  public t(int paramInt)
  {
    this.cHn = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92513);
    if (this == paramObject)
    {
      AppMethodBeat.o(92513);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92513);
      return false;
    }
    paramObject = (t)paramObject;
    if (this.cHn == paramObject.cHn)
    {
      AppMethodBeat.o(92513);
      return true;
    }
    AppMethodBeat.o(92513);
    return false;
  }
  
  public final int hashCode()
  {
    return this.cHn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.t
 * JD-Core Version:    0.7.0.1
 */