package a.j.b.a.c.d.a;

import a.f.b.j;
import a.j.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class r
{
  final f BYN;
  final String signature;
  
  public r(f paramf, String paramString)
  {
    AppMethodBeat.i(119719);
    this.BYN = paramf;
    this.signature = paramString;
    AppMethodBeat.o(119719);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(119722);
    if (this != paramObject)
    {
      if ((paramObject instanceof r))
      {
        paramObject = (r)paramObject;
        if ((!j.e(this.BYN, paramObject.BYN)) || (!j.e(this.signature, paramObject.signature))) {}
      }
    }
    else
    {
      AppMethodBeat.o(119722);
      return true;
    }
    AppMethodBeat.o(119722);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(119721);
    Object localObject = this.BYN;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.signature;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(119721);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(119720);
    String str = "NameAndSignature(name=" + this.BYN + ", signature=" + this.signature + ")";
    AppMethodBeat.o(119720);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.d.a.r
 * JD-Core Version:    0.7.0.1
 */