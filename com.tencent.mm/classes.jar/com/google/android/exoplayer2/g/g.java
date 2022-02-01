package com.google.android.exoplayer2.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class g
{
  private int aHQ;
  public final f[] bEB;
  public final int length;
  
  public g(f... paramVarArgs)
  {
    AppMethodBeat.i(92949);
    this.bEB = paramVarArgs;
    this.length = paramVarArgs.length;
    AppMethodBeat.o(92949);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(92952);
    if (this == paramObject)
    {
      AppMethodBeat.o(92952);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(92952);
      return false;
    }
    paramObject = (g)paramObject;
    boolean bool = Arrays.equals(this.bEB, paramObject.bEB);
    AppMethodBeat.o(92952);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(92951);
    if (this.aHQ == 0) {
      this.aHQ = (Arrays.hashCode(this.bEB) + 527);
    }
    int i = this.aHQ;
    AppMethodBeat.o(92951);
    return i;
  }
  
  public final f[] ww()
  {
    AppMethodBeat.i(92950);
    f[] arrayOff = (f[])this.bEB.clone();
    AppMethodBeat.o(92950);
    return arrayOff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.g.g
 * JD-Core Version:    0.7.0.1
 */