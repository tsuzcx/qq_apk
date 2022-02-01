package com.google.b;

final class cc<T>
  implements cp<T>
{
  private final bw bZW;
  private final boolean bZX;
  private final cz<?, ?> cag;
  private final aq<?> cah;
  
  private cc(cz<?, ?> paramcz, aq<?> paramaq, bw parambw)
  {
    this.cag = paramcz;
    this.bZX = paramaq.e(parambw);
    this.cah = paramaq;
    this.bZW = parambw;
  }
  
  static <T> cc<T> a(cz<?, ?> paramcz, aq<?> paramaq, bw parambw)
  {
    return new cc(paramcz, paramaq, parambw);
  }
  
  public final boolean equals(T paramT1, T paramT2)
  {
    if (!this.cag.as(paramT1).equals(this.cag.as(paramT2))) {
      return false;
    }
    if (this.bZX) {
      return this.cah.am(paramT1).equals(this.cah.am(paramT2));
    }
    return true;
  }
  
  public final int hashCode(T paramT)
  {
    int j = this.cag.as(paramT).hashCode();
    int i = j;
    if (this.bZX) {
      i = j * 53 + this.cah.am(paramT).hashCode();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.cc
 * JD-Core Version:    0.7.0.1
 */