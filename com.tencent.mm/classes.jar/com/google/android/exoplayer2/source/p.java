package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class p
{
  public static final p bmL;
  private int aFZ;
  public final o[] bmM;
  public final int length;
  
  static
  {
    AppMethodBeat.i(92726);
    bmL = new p(new o[0]);
    AppMethodBeat.o(92726);
  }
  
  public p(o... paramVarArgs)
  {
    AppMethodBeat.i(92723);
    this.bmM = paramVarArgs;
    this.length = paramVarArgs.length;
    AppMethodBeat.o(92723);
  }
  
  public final int a(o paramo)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.bmM[i] == paramo) {
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
    paramObject = (p)paramObject;
    if ((this.length == paramObject.length) && (Arrays.equals(this.bmM, paramObject.bmM)))
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
    if (this.aFZ == 0) {
      this.aFZ = Arrays.hashCode(this.bmM);
    }
    int i = this.aFZ;
    AppMethodBeat.o(92724);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.p
 * JD-Core Version:    0.7.0.1
 */