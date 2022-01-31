package a.j.b.a.c.d.a.c;

import a.f.b.j;
import a.j.b.a.c.d.a.a.a;
import a.j.b.a.c.d.a.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.EnumMap;

public final class d
{
  final EnumMap<a.a, h> CeZ;
  
  public d(EnumMap<a.a, h> paramEnumMap)
  {
    AppMethodBeat.i(119827);
    this.CeZ = paramEnumMap;
    AppMethodBeat.o(119827);
  }
  
  public final a.j.b.a.c.d.a.f.d b(a.a parama)
  {
    AppMethodBeat.i(119826);
    parama = (h)this.CeZ.get(parama);
    if (parama == null)
    {
      AppMethodBeat.o(119826);
      return null;
    }
    j.p(parama, "nullabilityQualifiers[ap…ilityType] ?: return null");
    parama = new a.j.b.a.c.d.a.f.d(parama.ChD, null, false, parama.ChE);
    AppMethodBeat.o(119826);
    return parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.d.a.c.d
 * JD-Core Version:    0.7.0.1
 */