package a.j.b.a.c.a.b;

import a.f.b.j;
import a.j.b.a.c.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$a
{
  public final a BVf;
  final a BVg;
  final a BVh;
  
  public c$a(a parama1, a parama2, a parama3)
  {
    AppMethodBeat.i(119172);
    this.BVf = parama1;
    this.BVg = parama2;
    this.BVh = parama3;
    AppMethodBeat.o(119172);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(119175);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((!j.e(this.BVf, paramObject.BVf)) || (!j.e(this.BVg, paramObject.BVg)) || (!j.e(this.BVh, paramObject.BVh))) {}
      }
    }
    else
    {
      AppMethodBeat.o(119175);
      return true;
    }
    AppMethodBeat.o(119175);
    return false;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(119174);
    a locala = this.BVf;
    int i;
    if (locala != null)
    {
      i = locala.hashCode();
      locala = this.BVg;
      if (locala == null) {
        break label80;
      }
    }
    label80:
    for (int j = locala.hashCode();; j = 0)
    {
      locala = this.BVh;
      if (locala != null) {
        k = locala.hashCode();
      }
      AppMethodBeat.o(119174);
      return (j + i * 31) * 31 + k;
      i = 0;
      break;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119173);
    String str = "PlatformMutabilityMapping(javaClass=" + this.BVf + ", kotlinReadOnly=" + this.BVg + ", kotlinMutable=" + this.BVh + ")";
    AppMethodBeat.o(119173);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */