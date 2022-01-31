package a.j.b.a.c.i.e.a;

import a.f.b.j;
import a.j.b.a.c.b.e;
import a.j.b.a.c.l.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
  implements d, g
{
  private final c Cyk;
  private final e Cyl;
  private final e Cym;
  
  public c(e parame)
  {
    AppMethodBeat.i(122236);
    this.Cym = parame;
    this.Cyk = this;
    this.Cyl = this.Cym;
    AppMethodBeat.o(122236);
  }
  
  private ad efP()
  {
    AppMethodBeat.i(122231);
    ad localad = this.Cym.edE();
    j.p(localad, "classDescriptor.defaultType");
    AppMethodBeat.o(122231);
    return localad;
  }
  
  public final e eeq()
  {
    return this.Cym;
  }
  
  public final boolean equals(Object paramObject)
  {
    Object localObject = null;
    AppMethodBeat.i(122233);
    e locale = this.Cym;
    if (!(paramObject instanceof c)) {
      paramObject = null;
    }
    for (;;)
    {
      c localc = (c)paramObject;
      paramObject = localObject;
      if (localc != null) {
        paramObject = localc.Cym;
      }
      boolean bool = j.e(locale, paramObject);
      AppMethodBeat.o(122233);
      return bool;
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(122234);
    int i = this.Cym.hashCode();
    AppMethodBeat.o(122234);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(122235);
    String str = "Class{" + efP() + '}';
    AppMethodBeat.o(122235);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.i.e.a.c
 * JD-Core Version:    0.7.0.1
 */