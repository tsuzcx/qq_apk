package a.i;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"})
public final class d
  extends b
  implements a<Integer>
{
  private static final d BNB;
  public static final d.a BNC;
  
  static
  {
    AppMethodBeat.i(55992);
    BNC = new d.a((byte)0);
    BNB = new d(1, 0);
    AppMethodBeat.o(55992);
  }
  
  public d(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2, 1);
  }
  
  public final boolean contains(int paramInt)
  {
    return (this.BNv <= paramInt) && (paramInt <= this.BNw);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(55989);
    if (((paramObject instanceof d)) && (((isEmpty()) && (((d)paramObject).isEmpty())) || ((this.BNv == ((d)paramObject).BNv) && (this.BNw == ((d)paramObject).BNw))))
    {
      AppMethodBeat.o(55989);
      return true;
    }
    AppMethodBeat.o(55989);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(55990);
    if (isEmpty())
    {
      AppMethodBeat.o(55990);
      return -1;
    }
    int i = this.BNv;
    int j = this.BNw;
    AppMethodBeat.o(55990);
    return i * 31 + j;
  }
  
  public final boolean isEmpty()
  {
    return this.BNv > this.BNw;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(55991);
    String str = this.BNv + ".." + this.BNw;
    AppMethodBeat.o(55991);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.i.d
 * JD-Core Version:    0.7.0.1
 */