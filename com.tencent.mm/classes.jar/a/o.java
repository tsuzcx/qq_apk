package a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/Pair;", "A", "B", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "component1", "component2", "copy", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
public final class o<A, B>
  implements Serializable
{
  public final A first;
  public final B second;
  
  public o(A paramA, B paramB)
  {
    this.first = paramA;
    this.second = paramB;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56423);
    if (this != paramObject)
    {
      if ((paramObject instanceof o))
      {
        paramObject = (o)paramObject;
        if ((!j.e(this.first, paramObject.first)) || (!j.e(this.second, paramObject.second))) {}
      }
    }
    else
    {
      AppMethodBeat.o(56423);
      return true;
    }
    AppMethodBeat.o(56423);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(56422);
    Object localObject = this.first;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.second;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(56422);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56421);
    String str = "(" + this.first + ", " + this.second + ')';
    AppMethodBeat.o(56421);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.o
 * JD-Core Version:    0.7.0.1
 */