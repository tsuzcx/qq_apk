package a.j.b.a.c.d.b;

import a.f.b.j;
import a.j.b.a.c.b.an;
import a.j.b.a.c.e.a.s;
import a.j.b.a.c.e.a.c;
import a.j.b.a.c.e.b.a.g;
import a.j.b.a.c.f.a;
import a.j.b.a.c.g.i.c;
import a.j.b.a.c.j.a.a.e;
import a.j.b.a.c.j.a.o;
import a.l.m;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i
  implements e
{
  public final a.j.b.a.c.i.d.b Cjl;
  public final a.j.b.a.c.i.d.b Cjm;
  private final o<g> Cjn;
  private final boolean Cjo;
  final n Cjp;
  private final String gVh;
  
  public i(n paramn, a.s params, c paramc, o<g> paramo, boolean paramBoolean) {}
  
  private i(a.j.b.a.c.i.d.b paramb1, a.j.b.a.c.i.d.b paramb2, a.s params, c paramc, o<g> paramo, boolean paramBoolean, n paramn)
  {
    AppMethodBeat.i(120271);
    this.Cjl = paramb1;
    this.Cjm = paramb2;
    this.Cjn = paramo;
    this.Cjo = paramBoolean;
    this.Cjp = paramn;
    paramb1 = (i.c)params;
    paramb2 = a.j.b.a.c.e.b.b.Cpy;
    j.p(paramb2, "JvmProtoBuf.packageModuleName");
    paramb1 = (Integer)a.j.b.a.c.e.a.f.a(paramb1, paramb2);
    if (paramb1 != null)
    {
      paramb2 = paramc.getString(((Number)paramb1).intValue());
      paramb1 = paramb2;
      if (paramb2 != null) {}
    }
    else
    {
      paramb1 = "main";
    }
    this.gVh = paramb1;
    AppMethodBeat.o(120271);
  }
  
  public final an ebY()
  {
    AppMethodBeat.i(120270);
    an localan = an.BWG;
    j.p(localan, "SourceFile.NO_SOURCE_FILE");
    AppMethodBeat.o(120270);
    return localan;
  }
  
  public final a ebx()
  {
    AppMethodBeat.i(120268);
    a locala = new a(this.Cjl.enX(), egS());
    AppMethodBeat.o(120268);
    return locala;
  }
  
  public final a.j.b.a.c.f.f egS()
  {
    AppMethodBeat.i(120267);
    Object localObject = this.Cjl.Cjr;
    j.p(localObject, "className.internalName");
    localObject = a.j.b.a.c.f.f.ayT(m.a((String)localObject, '/'));
    j.p(localObject, "Name.identifier(classNam….substringAfterLast('/'))");
    AppMethodBeat.o(120267);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(120269);
    String str = getClass().getSimpleName() + ": " + this.Cjl;
    AppMethodBeat.o(120269);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     a.j.b.a.c.d.b.i
 * JD-Core Version:    0.7.0.1
 */