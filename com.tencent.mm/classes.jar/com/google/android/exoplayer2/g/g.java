package com.google.android.exoplayer2.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class g
{
  public final f[] aYk;
  private int axc;
  public final int length;
  
  public g(f... paramVarArgs)
  {
    AppMethodBeat.i(95781);
    this.aYk = paramVarArgs;
    this.length = paramVarArgs.length;
    AppMethodBeat.o(95781);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95784);
    if (this == paramObject)
    {
      AppMethodBeat.o(95784);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95784);
      return false;
    }
    paramObject = (g)paramObject;
    boolean bool = Arrays.equals(this.aYk, paramObject.aYk);
    AppMethodBeat.o(95784);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(95783);
    if (this.axc == 0) {
      this.axc = (Arrays.hashCode(this.aYk) + 527);
    }
    int i = this.axc;
    AppMethodBeat.o(95783);
    return i;
  }
  
  public final f[] qj()
  {
    AppMethodBeat.i(95782);
    f[] arrayOff = (f[])this.aYk.clone();
    AppMethodBeat.o(95782);
    return arrayOff;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.g.g
 * JD-Core Version:    0.7.0.1
 */