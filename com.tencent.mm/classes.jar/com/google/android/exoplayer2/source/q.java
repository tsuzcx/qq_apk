package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class q
{
  private int aHK;
  public final Format[] bwD;
  public final int length;
  
  public q(Format... paramVarArgs)
  {
    AppMethodBeat.i(92720);
    if (paramVarArgs.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.bwD = paramVarArgs;
      this.length = paramVarArgs.length;
      AppMethodBeat.o(92720);
      return;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92722);
    if (this == paramObject)
    {
      AppMethodBeat.o(92722);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92722);
      return false;
    }
    paramObject = (q)paramObject;
    if ((this.length == paramObject.length) && (Arrays.equals(this.bwD, paramObject.bwD)))
    {
      AppMethodBeat.o(92722);
      return true;
    }
    AppMethodBeat.o(92722);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(92721);
    if (this.aHK == 0) {
      this.aHK = (Arrays.hashCode(this.bwD) + 527);
    }
    int i = this.aHK;
    AppMethodBeat.o(92721);
    return i;
  }
  
  public final int j(Format paramFormat)
  {
    int i = 0;
    while (i < this.bwD.length)
    {
      if (paramFormat == this.bwD[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.q
 * JD-Core Version:    0.7.0.1
 */