package com.google.android.exoplayer2.source;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i$b
{
  public static final b aPW;
  public final int aPX;
  public final int aPY;
  public final int aPZ;
  
  static
  {
    AppMethodBeat.i(95514);
    aPW = new b(-1, -1, -1);
    AppMethodBeat.o(95514);
  }
  
  public i$b(int paramInt)
  {
    this(paramInt, -1, -1);
  }
  
  public i$b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.aPX = paramInt1;
    this.aPY = paramInt2;
    this.aPZ = paramInt3;
  }
  
  public final b dM(int paramInt)
  {
    AppMethodBeat.i(95512);
    if (this.aPX == paramInt)
    {
      AppMethodBeat.o(95512);
      return this;
    }
    b localb = new b(paramInt, this.aPY, this.aPZ);
    AppMethodBeat.o(95512);
    return localb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(95513);
    if (this == paramObject)
    {
      AppMethodBeat.o(95513);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(95513);
      return false;
    }
    paramObject = (b)paramObject;
    if ((this.aPX == paramObject.aPX) && (this.aPY == paramObject.aPY) && (this.aPZ == paramObject.aPZ))
    {
      AppMethodBeat.o(95513);
      return true;
    }
    AppMethodBeat.o(95513);
    return false;
  }
  
  public final int hashCode()
  {
    return ((this.aPX + 527) * 31 + this.aPY) * 31 + this.aPZ;
  }
  
  public final boolean pi()
  {
    return this.aPY != -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.i.b
 * JD-Core Version:    0.7.0.1
 */