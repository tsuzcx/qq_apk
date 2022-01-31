package com.google.android.exoplayer2.g;

import java.util.Arrays;

public final class f
{
  public final e[] aQG;
  private int auK;
  public final int length;
  
  public f(e... paramVarArgs)
  {
    this.aQG = paramVarArgs;
    this.length = paramVarArgs.length;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass())) {
      return false;
    }
    paramObject = (f)paramObject;
    return Arrays.equals(this.aQG, paramObject.aQG);
  }
  
  public final int hashCode()
  {
    if (this.auK == 0) {
      this.auK = (Arrays.hashCode(this.aQG) + 527);
    }
    return this.auK;
  }
  
  public final e[] nL()
  {
    return (e[])this.aQG.clone();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.g.f
 * JD-Core Version:    0.7.0.1
 */