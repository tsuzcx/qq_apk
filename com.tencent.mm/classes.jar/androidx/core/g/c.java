package androidx.core.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  final Object bsJ;
  
  c(Object paramObject)
  {
    this.bsJ = paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(195710);
    if (this == paramObject)
    {
      AppMethodBeat.o(195710);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(195710);
      return false;
    }
    paramObject = (c)paramObject;
    boolean bool = androidx.core.f.c.equals(this.bsJ, paramObject.bsJ);
    AppMethodBeat.o(195710);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(195719);
    if (this.bsJ == null)
    {
      AppMethodBeat.o(195719);
      return 0;
    }
    int i = this.bsJ.hashCode();
    AppMethodBeat.o(195719);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(195726);
    String str = "DisplayCutoutCompat{" + this.bsJ + "}";
    AppMethodBeat.o(195726);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.g.c
 * JD-Core Version:    0.7.0.1
 */