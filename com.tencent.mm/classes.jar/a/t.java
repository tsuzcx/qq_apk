package a;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/Triple;", "A", "B", "C", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "third", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "getThird", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;", "equals", "", "other", "", "hashCode", "", "toString", "", "kotlin-stdlib"})
public final class t<A, B, C>
  implements Serializable
{
  public final C BMe;
  public final A first;
  public final B second;
  
  public t(A paramA, B paramB, C paramC)
  {
    this.first = paramA;
    this.second = paramB;
    this.BMe = paramC;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56024);
    if (this != paramObject)
    {
      if ((paramObject instanceof t))
      {
        paramObject = (t)paramObject;
        if ((!j.e(this.first, paramObject.first)) || (!j.e(this.second, paramObject.second)) || (!j.e(this.BMe, paramObject.BMe))) {}
      }
    }
    else
    {
      AppMethodBeat.o(56024);
      return true;
    }
    AppMethodBeat.o(56024);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(56023);
    Object localObject = this.first;
    int i;
    if (localObject != null)
    {
      i = localObject.hashCode();
      localObject = this.second;
      if (localObject == null) {
        break label80;
      }
    }
    label80:
    for (int j = localObject.hashCode();; j = 0)
    {
      localObject = this.BMe;
      if (localObject != null) {
        k = localObject.hashCode();
      }
      AppMethodBeat.o(56023);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56022);
    String str = "(" + this.first + ", " + this.second + ", " + this.BMe + ')';
    AppMethodBeat.o(56022);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.t
 * JD-Core Version:    0.7.0.1
 */