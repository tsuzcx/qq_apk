package a.j.b.a.c.h;

import a.j.b.a.c.b.ag;
import a.j.b.a.c.b.n;
import a.j.b.a.c.b.t;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$a
  implements n<y, StringBuilder>
{
  private final void a(ag paramag, StringBuilder paramStringBuilder, String paramString)
  {
    AppMethodBeat.i(121737);
    o localo = this.CtR.CtQ.enG();
    switch (f.bLo[localo.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(121737);
      return;
      e.a(this.CtR, paramag, paramStringBuilder);
      paramStringBuilder.append(paramString + " for ");
      paramString = this.CtR;
      paramag = paramag.eeg();
      a.f.b.j.p(paramag, "descriptor.correspondingProperty");
      e.a(paramString, paramag, paramStringBuilder);
      AppMethodBeat.o(121737);
      return;
      b((t)paramag, paramStringBuilder);
    }
  }
  
  private void b(t paramt, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(121738);
    a.f.b.j.q(paramt, "descriptor");
    a.f.b.j.q(paramStringBuilder, "builder");
    e.a(this.CtR, paramt, paramStringBuilder);
    AppMethodBeat.o(121738);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     a.j.b.a.c.h.e.a
 * JD-Core Version:    0.7.0.1
 */