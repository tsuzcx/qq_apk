package com.bumptech.glide.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  private Class<?> aMl;
  private Class<?> aMm;
  private Class<?> aMn;
  
  public h() {}
  
  public h(Class<?> paramClass1, Class<?> paramClass2)
  {
    AppMethodBeat.i(77761);
    d(paramClass1, paramClass2, null);
    AppMethodBeat.o(77761);
  }
  
  public h(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3)
  {
    AppMethodBeat.i(77762);
    d(paramClass1, paramClass2, paramClass3);
    AppMethodBeat.o(77762);
  }
  
  public final void d(Class<?> paramClass1, Class<?> paramClass2, Class<?> paramClass3)
  {
    this.aMl = paramClass1;
    this.aMm = paramClass2;
    this.aMn = paramClass3;
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
    paramObject = (h)paramObject;
    if (!this.aMl.equals(paramObject.aMl))
    {
      AppMethodBeat.o(77764);
      return false;
    }
    if (!this.aMm.equals(paramObject.aMm))
    {
      AppMethodBeat.o(77764);
      return false;
    }
    if (!j.e(this.aMn, paramObject.aMn))
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
    int j = this.aMl.hashCode();
    int k = this.aMm.hashCode();
    if (this.aMn != null) {}
    for (int i = this.aMn.hashCode();; i = 0)
    {
      AppMethodBeat.o(77765);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77763);
    String str = "MultiClassKey{first=" + this.aMl + ", second=" + this.aMm + '}';
    AppMethodBeat.o(77763);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.h.h
 * JD-Core Version:    0.7.0.1
 */