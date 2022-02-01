package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class r
{
  public static final r daD;
  private int cHb;
  public final q[] daE;
  public final int length;
  
  static
  {
    AppMethodBeat.i(92726);
    daD = new r(new q[0]);
    AppMethodBeat.o(92726);
  }
  
  public r(q... paramVarArgs)
  {
    AppMethodBeat.i(92723);
    this.daE = paramVarArgs;
    this.length = paramVarArgs.length;
    AppMethodBeat.o(92723);
  }
  
  public final int a(q paramq)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.daE[i] == paramq) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92725);
    if (this == paramObject)
    {
      AppMethodBeat.o(92725);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92725);
      return false;
    }
    paramObject = (r)paramObject;
    if ((this.length == paramObject.length) && (Arrays.equals(this.daE, paramObject.daE)))
    {
      AppMethodBeat.o(92725);
      return true;
    }
    AppMethodBeat.o(92725);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(92724);
    if (this.cHb == 0) {
      this.cHb = Arrays.hashCode(this.daE);
    }
    int i = this.cHb;
    AppMethodBeat.o(92724);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.r
 * JD-Core Version:    0.7.0.1
 */