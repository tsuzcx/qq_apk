package a.j;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"})
public final class q
{
  private static final q BNJ;
  public static final q.a BNK;
  private final r BNH;
  private final o BNI;
  
  static
  {
    AppMethodBeat.i(56004);
    BNK = new q.a((byte)0);
    BNJ = new q(null, null);
    AppMethodBeat.o(56004);
  }
  
  public q(r paramr, o paramo)
  {
    this.BNH = paramr;
    this.BNI = paramo;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(56007);
    if (this != paramObject)
    {
      if ((paramObject instanceof q))
      {
        paramObject = (q)paramObject;
        if ((!j.e(this.BNH, paramObject.BNH)) || (!j.e(this.BNI, paramObject.BNI))) {}
      }
    }
    else
    {
      AppMethodBeat.o(56007);
      return true;
    }
    AppMethodBeat.o(56007);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(56006);
    Object localObject = this.BNH;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.BNI;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(56006);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(56005);
    String str = "KTypeProjection(variance=" + this.BNH + ", type=" + this.BNI + ")";
    AppMethodBeat.o(56005);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.q
 * JD-Core Version:    0.7.0.1
 */