package a.e;

import a.b.d;
import a.d.b.a.a;

public class b
  implements a, Iterable<Integer>
{
  public static final b.a xoA = new b.a((byte)0);
  public final int first;
  public final int ghE;
  public final int xoz;
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      throw ((Throwable)new IllegalArgumentException("Step must be non-zero"));
    }
    this.first = paramInt1;
    if (paramInt3 > 0) {}
    for (paramInt1 = paramInt2 - d.aB(paramInt2, paramInt1, paramInt3);; paramInt1 = d.aB(paramInt1, paramInt2, -paramInt3) + paramInt2)
    {
      this.xoz = paramInt1;
      this.ghE = paramInt3;
      return;
      if (paramInt3 >= 0) {
        break;
      }
    }
    throw ((Throwable)new IllegalArgumentException("Step is zero."));
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof b)) && (((isEmpty()) && (((b)paramObject).isEmpty())) || ((this.first == ((b)paramObject).first) && (this.xoz == ((b)paramObject).xoz) && (this.ghE == ((b)paramObject).ghE)));
  }
  
  public int hashCode()
  {
    if (isEmpty()) {
      return -1;
    }
    return (this.first * 31 + this.xoz) * 31 + this.ghE;
  }
  
  public boolean isEmpty()
  {
    if (this.ghE > 0) {
      if (this.first <= this.xoz) {}
    }
    while (this.first < this.xoz)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    if (this.ghE > 0) {
      return this.first + ".." + this.xoz + " step " + this.ghE;
    }
    return this.first + " downTo " + this.xoz + " step " + -this.ghE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.e.b
 * JD-Core Version:    0.7.0.1
 */