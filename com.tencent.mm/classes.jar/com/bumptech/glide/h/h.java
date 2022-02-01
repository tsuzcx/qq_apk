package com.bumptech.glide.h;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  private Class<?> aLv;
  private Class<?> aLw;
  private Class<?> aLx;
  
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
    this.aLv = paramClass1;
    this.aLw = paramClass2;
    this.aLx = paramClass3;
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
    if (!this.aLv.equals(paramObject.aLv))
    {
      AppMethodBeat.o(77764);
      return false;
    }
    if (!this.aLw.equals(paramObject.aLw))
    {
      AppMethodBeat.o(77764);
      return false;
    }
    if (!j.e(this.aLx, paramObject.aLx))
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
    int j = this.aLv.hashCode();
    int k = this.aLw.hashCode();
    if (this.aLx != null) {}
    for (int i = this.aLx.hashCode();; i = 0)
    {
      AppMethodBeat.o(77765);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(77763);
    String str = "MultiClassKey{first=" + this.aLv + ", second=" + this.aLw + '}';
    AppMethodBeat.o(77763);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.h.h
 * JD-Core Version:    0.7.0.1
 */