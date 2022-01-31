package a.l;

import a.f.b.j;
import a.i.d;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/text/MatchGroup;", "", "value", "", "range", "Lkotlin/ranges/IntRange;", "(Ljava/lang/String;Lkotlin/ranges/IntRange;)V", "getRange", "()Lkotlin/ranges/IntRange;", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "kotlin-stdlib"})
public final class f
{
  private final d CGM;
  private final String value;
  
  public f(String paramString, d paramd)
  {
    AppMethodBeat.i(56348);
    this.value = paramString;
    this.CGM = paramd;
    AppMethodBeat.o(56348);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56351);
    if (this != paramObject)
    {
      if ((paramObject instanceof f))
      {
        paramObject = (f)paramObject;
        if ((!j.e(this.value, paramObject.value)) || (!j.e(this.CGM, paramObject.CGM))) {}
      }
    }
    else
    {
      AppMethodBeat.o(56351);
      return true;
    }
    AppMethodBeat.o(56351);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(56350);
    Object localObject = this.value;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.CGM;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(56350);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56349);
    String str = "MatchGroup(value=" + this.value + ", range=" + this.CGM + ")";
    AppMethodBeat.o(56349);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.l.f
 * JD-Core Version:    0.7.0.1
 */