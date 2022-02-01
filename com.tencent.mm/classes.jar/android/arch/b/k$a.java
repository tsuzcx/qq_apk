package android.arch.b;

import android.support.v7.h.d;

final class k$a
  implements d
{
  private final int fq;
  private final d fr;
  
  private k$a(int paramInt, d paramd)
  {
    this.fq = paramInt;
    this.fr = paramd;
  }
  
  public final void c(int paramInt1, int paramInt2, Object paramObject)
  {
    this.fr.c(this.fq + paramInt1, paramInt2, paramObject);
  }
  
  public final void f(int paramInt1, int paramInt2)
  {
    this.fr.f(this.fq + paramInt1, paramInt2);
  }
  
  public final void k(int paramInt1, int paramInt2)
  {
    this.fr.k(this.fq + paramInt1, paramInt2);
  }
  
  public final void l(int paramInt1, int paramInt2)
  {
    this.fr.l(this.fq + paramInt1, this.fq + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.arch.b.k.a
 * JD-Core Version:    0.7.0.1
 */