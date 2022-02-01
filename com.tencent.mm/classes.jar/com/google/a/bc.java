package com.google.a;

final class bc<T>
  implements br<T>
{
  private final aw bXE;
  private final cb<?, ?> bYB;
  private final s<?> bYC;
  private final boolean bYs;
  
  private bc(cb<?, ?> paramcb, s<?> params, aw paramaw)
  {
    this.bYB = paramcb;
    this.bYs = params.f(paramaw);
    this.bYC = params;
    this.bXE = paramaw;
  }
  
  static <T> bc<T> a(cb<?, ?> paramcb, s<?> params, aw paramaw)
  {
    return new bc(paramcb, params, paramaw);
  }
  
  public final void ap(T paramT)
  {
    this.bYB.ap(paramT);
    this.bYC.ap(paramT);
  }
  
  public final boolean equals(T paramT1, T paramT2)
  {
    if (!this.bYB.aw(paramT1).equals(this.bYB.aw(paramT2))) {
      return false;
    }
    if (this.bYs) {
      return this.bYC.an(paramT1).equals(this.bYC.an(paramT2));
    }
    return true;
  }
  
  public final int hashCode(T paramT)
  {
    int j = this.bYB.aw(paramT).hashCode();
    int i = j;
    if (this.bYs) {
      i = j * 53 + this.bYC.an(paramT).hashCode();
    }
    return i;
  }
  
  public final void n(T paramT1, T paramT2)
  {
    bt.a(this.bYB, paramT1, paramT2);
    if (this.bYs) {
      bt.a(this.bYC, paramT1, paramT2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.a.bc
 * JD-Core Version:    0.7.0.1
 */