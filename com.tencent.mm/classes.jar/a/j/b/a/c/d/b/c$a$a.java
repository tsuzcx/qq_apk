package a.j.b.a.c.d.b;

import a.j.b.a.c.b.a.c;
import a.j.b.a.c.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class c$a$a
  implements n.a
{
  c$a$a(n.a parama, f paramf, ArrayList paramArrayList)
  {
    this.CiV = paramf;
  }
  
  public final n.a a(f paramf, a.j.b.a.c.f.a parama)
  {
    AppMethodBeat.i(120227);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(parama, "classId");
    paramf = this.CiV.a(paramf, parama);
    AppMethodBeat.o(120227);
    return paramf;
  }
  
  public final void a(f paramf, n.d paramd)
  {
    AppMethodBeat.i(120229);
    a.f.b.j.q(paramf, "name");
    a.f.b.j.q(paramd, "classLiteralId");
    this.CiV.a(paramf, paramd);
    AppMethodBeat.o(120229);
  }
  
  public final void a(f paramf1, a.j.b.a.c.f.a parama, f paramf2)
  {
    AppMethodBeat.i(120230);
    a.f.b.j.q(paramf1, "name");
    a.f.b.j.q(parama, "enumClassId");
    a.f.b.j.q(paramf2, "enumEntryName");
    this.CiV.a(paramf1, parama, paramf2);
    AppMethodBeat.o(120230);
  }
  
  public final void a(f paramf, Object paramObject)
  {
    AppMethodBeat.i(120226);
    this.CiV.a(paramf, paramObject);
    AppMethodBeat.o(120226);
  }
  
  public final n.b o(f paramf)
  {
    AppMethodBeat.i(120228);
    a.f.b.j.q(paramf, "name");
    paramf = this.CiV.o(paramf);
    AppMethodBeat.o(120228);
    return paramf;
  }
  
  public final void zi()
  {
    AppMethodBeat.i(120225);
    this.CiX.zi();
    ((Map)this.CiW.CiR).put(this.BVU, new a.j.b.a.c.i.b.a((c)a.a.j.fU((List)this.Cil)));
    AppMethodBeat.o(120225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     a.j.b.a.c.d.b.c.a.a
 * JD-Core Version:    0.7.0.1
 */