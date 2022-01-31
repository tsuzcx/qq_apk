package a.j.b.a.c.d.a.f;

import a.f.b.j;
import a.j.b.a.c.l.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class p
{
  final w BPZ;
  final d Ciu;
  
  public p(w paramw, d paramd)
  {
    AppMethodBeat.i(120191);
    this.BPZ = paramw;
    this.Ciu = paramd;
    AppMethodBeat.o(120191);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(120194);
    if (this != paramObject)
    {
      if ((paramObject instanceof p))
      {
        paramObject = (p)paramObject;
        if ((!j.e(this.BPZ, paramObject.BPZ)) || (!j.e(this.Ciu, paramObject.Ciu))) {}
      }
    }
    else
    {
      AppMethodBeat.o(120194);
      return true;
    }
    AppMethodBeat.o(120194);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(120193);
    Object localObject = this.BPZ;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.Ciu;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(120193);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(120192);
    String str = "TypeAndDefaultQualifiers(type=" + this.BPZ + ", defaultQualifiers=" + this.Ciu + ")";
    AppMethodBeat.o(120192);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.d.a.f.p
 * JD-Core Version:    0.7.0.1
 */