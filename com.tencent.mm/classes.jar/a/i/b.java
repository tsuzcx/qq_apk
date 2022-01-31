package a.i;

import a.d.c;
import a.f.b.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/ranges/IntProgression;", "", "", "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", "", "other", "", "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", "", "Companion", "kotlin-stdlib"})
public class b
  implements a, Iterable<Integer>
{
  public static final b.a BNx;
  public final int BNv;
  public final int BNw;
  public final int hAu;
  
  static
  {
    AppMethodBeat.i(56000);
    BNx = new b.a((byte)0);
    AppMethodBeat.o(56000);
  }
  
  public b(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(55999);
    if (paramInt3 == 0)
    {
      localThrowable = (Throwable)new IllegalArgumentException("Step must be non-zero.");
      AppMethodBeat.o(55999);
      throw localThrowable;
    }
    if (paramInt3 == -2147483648)
    {
      localThrowable = (Throwable)new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
      AppMethodBeat.o(55999);
      throw localThrowable;
    }
    this.BNv = paramInt1;
    int i;
    if (paramInt3 > 0) {
      if (paramInt1 >= paramInt2) {
        i = paramInt2;
      }
    }
    for (;;)
    {
      this.BNw = i;
      this.hAu = paramInt3;
      AppMethodBeat.o(55999);
      return;
      i = paramInt2 - c.aN(paramInt2, paramInt1, paramInt3);
      continue;
      if (paramInt3 >= 0) {
        break;
      }
      i = paramInt2;
      if (paramInt1 > paramInt2) {
        i = paramInt2 + c.aN(paramInt1, paramInt2, -paramInt3);
      }
    }
    Throwable localThrowable = (Throwable)new IllegalArgumentException("Step is zero.");
    AppMethodBeat.o(55999);
    throw localThrowable;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(55996);
    if (((paramObject instanceof b)) && (((isEmpty()) && (((b)paramObject).isEmpty())) || ((this.BNv == ((b)paramObject).BNv) && (this.BNw == ((b)paramObject).BNw) && (this.hAu == ((b)paramObject).hAu))))
    {
      AppMethodBeat.o(55996);
      return true;
    }
    AppMethodBeat.o(55996);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(55997);
    if (isEmpty())
    {
      AppMethodBeat.o(55997);
      return -1;
    }
    int i = this.BNv;
    int j = this.BNw;
    int k = this.hAu;
    AppMethodBeat.o(55997);
    return (i * 31 + j) * 31 + k;
  }
  
  public boolean isEmpty()
  {
    if (this.hAu > 0) {
      if (this.BNv <= this.BNw) {}
    }
    while (this.BNv < this.BNw)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    AppMethodBeat.i(55998);
    if (this.hAu > 0)
    {
      str = this.BNv + ".." + this.BNw + " step " + this.hAu;
      AppMethodBeat.o(55998);
      return str;
    }
    String str = this.BNv + " downTo " + this.BNw + " step " + -this.hAu;
    AppMethodBeat.o(55998);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.i.b
 * JD-Core Version:    0.7.0.1
 */