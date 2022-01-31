package a.j.b.a.c.l;

import a.f.b.j;
import a.j.b.a.c.b.ar;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class ai$a
  extends ao
{
  ai$a(List paramList) {}
  
  public final ap c(an paraman)
  {
    AppMethodBeat.i(122635);
    j.q(paraman, "key");
    if (this.CBC.contains(paraman))
    {
      paraman = paraman.ecR();
      if (paraman == null)
      {
        paraman = new v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        AppMethodBeat.o(122635);
        throw paraman;
      }
      paraman = av.e((ar)paraman);
      AppMethodBeat.o(122635);
      return paraman;
    }
    AppMethodBeat.o(122635);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     a.j.b.a.c.l.ai.a
 * JD-Core Version:    0.7.0.1
 */