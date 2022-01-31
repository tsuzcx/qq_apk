package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class p
{
  public static final p aQG;
  public final o[] aQH;
  private int axc;
  public final int length;
  
  static
  {
    AppMethodBeat.i(95558);
    aQG = new p(new o[0]);
    AppMethodBeat.o(95558);
  }
  
  public p(o... paramVarArgs)
  {
    AppMethodBeat.i(95555);
    this.aQH = paramVarArgs;
    this.length = paramVarArgs.length;
    AppMethodBeat.o(95555);
  }
  
  public final int a(o paramo)
  {
    int i = 0;
    while (i < this.length)
    {
      if (this.aQH[i] == paramo) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95557);
    if (this == paramObject)
    {
      AppMethodBeat.o(95557);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95557);
      return false;
    }
    paramObject = (p)paramObject;
    if ((this.length == paramObject.length) && (Arrays.equals(this.aQH, paramObject.aQH)))
    {
      AppMethodBeat.o(95557);
      return true;
    }
    AppMethodBeat.o(95557);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(95556);
    if (this.axc == 0) {
      this.axc = Arrays.hashCode(this.aQH);
    }
    int i = this.axc;
    AppMethodBeat.o(95556);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.p
 * JD-Core Version:    0.7.0.1
 */