package com.bumptech.glide.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
{
  private Class<?> aNV;
  private Class<?> aNW;
  private Class<?> aNX;
  
  public i() {}
  
  public i(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3)
  {
    AppMethodBeat.i(77762);
    e(paramClass1, paramClass2, paramClass3);
    AppMethodBeat.o(77762);
  }
  
  public final void e(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3)
  {
    this.aNV = paramClass1;
    this.aNW = paramClass2;
    this.aNX = paramClass3;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77764);
    if (this == paramObject)
    {
      AppMethodBeat.o(77764);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(77764);
      return false;
    }
    paramObject = (i)paramObject;
    if (!this.aNV.equals(paramObject.aNV))
    {
      AppMethodBeat.o(77764);
      return false;
    }
    if (!this.aNW.equals(paramObject.aNW))
    {
      AppMethodBeat.o(77764);
      return false;
    }
    if (!k.h(this.aNX, paramObject.aNX))
    {
      AppMethodBeat.o(77764);
      return false;
    }
    AppMethodBeat.o(77764);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(77765);
    int j = this.aNV.hashCode();
    int k = this.aNW.hashCode();
    if (this.aNX != null) {}
    for (int i = this.aNX.hashCode();; i = 0)
    {
      AppMethodBeat.o(77765);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77763);
    String str = "MultiClassKey{first=" + this.aNV + ", second=" + this.aNW + '}';
    AppMethodBeat.o(77763);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.g.i
 * JD-Core Version:    0.7.0.1
 */