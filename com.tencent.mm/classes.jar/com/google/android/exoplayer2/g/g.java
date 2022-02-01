package com.google.android.exoplayer2.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class g
{
  private int aFZ;
  public final f[] bum;
  public final int length;
  
  public g(f... paramVarArgs)
  {
    AppMethodBeat.i(92949);
    this.bum = paramVarArgs;
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
    boolean bool = Arrays.equals(this.bum, paramObject.bum);
    AppMethodBeat.o(92952);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(92951);
    if (this.aFZ == 0) {
      this.aFZ = (Arrays.hashCode(this.bum) + 527);
    }
    int i = this.aFZ;
    AppMethodBeat.o(92951);
    return i;
  }
  
  public final f[] uX()
  {
    AppMethodBeat.i(92950);
    f[] arrayOff = (f[])this.bum.clone();
    AppMethodBeat.o(92950);
    return arrayOff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.g.g
 * JD-Core Version:    0.7.0.1
 */