package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class r
{
  public static final r bxh;
  private int aHK;
  public final q[] bxi;
  public final int length;
  
  static
  {
    AppMethodBeat.i(92726);
    bxh = new r(new q[0]);
    AppMethodBeat.o(92726);
  }
  
  public r(q... paramVarArgs)
  {
    AppMethodBeat.i(92723);
    this.bxi = paramVarArgs;
    this.length = paramVarArgs.length;
    AppMethodBeat.o(92723);
  }
  
  public final int a(q paramq)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.bxi[i] == paramq) {
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
    if ((this.length == paramObject.length) && (Arrays.equals(this.bxi, paramObject.bxi)))
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
    if (this.aHK == 0) {
      this.aHK = Arrays.hashCode(this.bxi);
    }
    int i = this.aHK;
    AppMethodBeat.o(92724);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.r
 * JD-Core Version:    0.7.0.1
 */