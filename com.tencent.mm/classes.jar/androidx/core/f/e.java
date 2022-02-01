package androidx.core.f;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class e<F, S>
{
  public final F Mx;
  public final S My;
  
  public e(F paramF, S paramS)
  {
    this.Mx = paramF;
    this.My = paramS;
  }
  
  public static <A, B> e<A, B> d(A paramA, B paramB)
  {
    AppMethodBeat.i(251326);
    paramA = new e(paramA, paramB);
    AppMethodBeat.o(251326);
    return paramA;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(251321);
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(251321);
      return false;
    }
    paramObject = (e)paramObject;
    if ((d.equals(paramObject.Mx, this.Mx)) && (d.equals(paramObject.My, this.My)))
    {
      AppMethodBeat.o(251321);
      return true;
    }
    AppMethodBeat.o(251321);
    return false;
  }
  
  public int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(251322);
    int i;
    if (this.Mx == null)
    {
      i = 0;
      if (this.My != null) {
        break label43;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(251322);
      return i ^ j;
      i = this.Mx.hashCode();
      break;
      label43:
      j = this.My.hashCode();
    }
  }
  
  public String toString()
  {
    AppMethodBeat.i(251324);
    String str = "Pair{" + String.valueOf(this.Mx) + " " + String.valueOf(this.My) + "}";
    AppMethodBeat.o(251324);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.core.f.e
 * JD-Core Version:    0.7.0.1
 */