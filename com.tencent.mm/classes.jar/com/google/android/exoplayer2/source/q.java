package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class q
{
  public static final q bmg;
  private int aFj;
  public final p[] bmh;
  public final int length;
  
  static
  {
    AppMethodBeat.i(92726);
    bmg = new q(new p[0]);
    AppMethodBeat.o(92726);
  }
  
  public q(p... paramVarArgs)
  {
    AppMethodBeat.i(92723);
    this.bmh = paramVarArgs;
    this.length = paramVarArgs.length;
    AppMethodBeat.o(92723);
  }
  
  public final int a(p paramp)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.bmh[i] == paramp) {
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
    paramObject = (q)paramObject;
    if ((this.length == paramObject.length) && (Arrays.equals(this.bmh, paramObject.bmh)))
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
    if (this.aFj == 0) {
      this.aFj = Arrays.hashCode(this.bmh);
    }
    int i = this.aFj;
    AppMethodBeat.o(92724);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.q
 * JD-Core Version:    0.7.0.1
 */