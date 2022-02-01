package androidx.core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class d<F, S>
{
  public final F bsC;
  public final S bsD;
  
  public d(F paramF, S paramS)
  {
    this.bsC = paramF;
    this.bsD = paramS;
  }
  
  public static <A, B> d<A, B> l(A paramA, B paramB)
  {
    AppMethodBeat.i(196022);
    paramA = new d(paramA, paramB);
    AppMethodBeat.o(196022);
    return paramA;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196030);
    if (!(paramObject instanceof d))
    {
      AppMethodBeat.o(196030);
      return false;
    }
    paramObject = (d)paramObject;
    if ((c.equals(paramObject.bsC, this.bsC)) && (c.equals(paramObject.bsD, this.bsD)))
    {
      AppMethodBeat.o(196030);
      return true;
    }
    AppMethodBeat.o(196030);
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(196037);
    int i;
    if (this.bsC == null)
    {
      i = 0;
      if (this.bsD != null) {
        break label43;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(196037);
      return i ^ j;
      i = this.bsC.hashCode();
      break;
      label43:
      j = this.bsD.hashCode();
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(196046);
    String str = "Pair{" + this.bsC + " " + this.bsD + "}";
    AppMethodBeat.o(196046);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     androidx.core.f.d
 * JD-Core Version:    0.7.0.1
 */