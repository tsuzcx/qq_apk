package androidx.core.g;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private final Object MG;
  
  c(Object paramObject)
  {
    this.MG = paramObject;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(251397);
    if (this == paramObject)
    {
      AppMethodBeat.o(251397);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(251397);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.MG == null)
    {
      if (paramObject.MG == null)
      {
        AppMethodBeat.o(251397);
        return true;
      }
      AppMethodBeat.o(251397);
      return false;
    }
    boolean bool = this.MG.equals(paramObject.MG);
    AppMethodBeat.o(251397);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(251398);
    if (this.MG == null)
    {
      AppMethodBeat.o(251398);
      return 0;
    }
    int i = this.MG.hashCode();
    AppMethodBeat.o(251398);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(251400);
    String str = "DisplayCutoutCompat{" + this.MG + "}";
    AppMethodBeat.o(251400);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.core.g.c
 * JD-Core Version:    0.7.0.1
 */