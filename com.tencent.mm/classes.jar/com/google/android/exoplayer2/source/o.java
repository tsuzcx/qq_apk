package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class o
{
  public final Format[] aQc;
  private int axc;
  public final int length;
  
  public o(Format... paramVarArgs)
  {
    AppMethodBeat.i(95552);
    if (paramVarArgs.length > 0) {}
    for (boolean bool = true;; bool = false)
    {
      a.checkState(bool);
      this.aQc = paramVarArgs;
      this.length = paramVarArgs.length;
      AppMethodBeat.o(95552);
      return;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95554);
    if (this == paramObject)
    {
      AppMethodBeat.o(95554);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95554);
      return false;
    }
    paramObject = (o)paramObject;
    if ((this.length == paramObject.length) && (Arrays.equals(this.aQc, paramObject.aQc)))
    {
      AppMethodBeat.o(95554);
      return true;
    }
    AppMethodBeat.o(95554);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(95553);
    if (this.axc == 0) {
      this.axc = (Arrays.hashCode(this.aQc) + 527);
    }
    int i = this.axc;
    AppMethodBeat.o(95553);
    return i;
  }
  
  public final int j(Format paramFormat)
  {
    int i = 0;
    while (i < this.aQc.length)
    {
      if (paramFormat == this.aQc[i]) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.o
 * JD-Core Version:    0.7.0.1
 */