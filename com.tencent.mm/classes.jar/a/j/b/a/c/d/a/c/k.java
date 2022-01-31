package a.j.b.a.c.d.a.c;

import a.f.b.j;
import a.j.b.a.c.d.a.a.a;
import a.j.b.a.c.d.a.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

public final class k
{
  public final h Cfq;
  public final Collection<a.a> Cfr;
  
  public k(h paramh, Collection<? extends a.a> paramCollection)
  {
    AppMethodBeat.i(119846);
    this.Cfq = paramh;
    this.Cfr = paramCollection;
    AppMethodBeat.o(119846);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(119849);
    if (this != paramObject)
    {
      if ((paramObject instanceof k))
      {
        paramObject = (k)paramObject;
        if ((!j.e(this.Cfq, paramObject.Cfq)) || (!j.e(this.Cfr, paramObject.Cfr))) {}
      }
    }
    else
    {
      AppMethodBeat.o(119849);
      return true;
    }
    AppMethodBeat.o(119849);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(119848);
    Object localObject = this.Cfq;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.Cfr;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(119848);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119847);
    String str = "NullabilityQualifierWithApplicability(nullabilityQualifier=" + this.Cfq + ", qualifierApplicabilityTypes=" + this.Cfr + ")";
    AppMethodBeat.o(119847);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.k
 * JD-Core Version:    0.7.0.1
 */