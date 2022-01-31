package a.j.b.a.c.i.a.a;

import a.f.b.j;
import a.j.b.a.c.l.ap;
import a.j.b.a.c.l.ba;
import a.j.b.a.c.l.w;
import a.j.b.a.c.l.z;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  static final ap a(ap paramap, a.j.b.a.c.b.ar paramar)
  {
    AppMethodBeat.i(122065);
    if ((paramar == null) || (paramap.eoO() == ba.CBX))
    {
      AppMethodBeat.o(122065);
      return paramap;
    }
    if (paramar.edG() == paramap.eoO())
    {
      if (paramap.eoN())
      {
        paramar = a.j.b.a.c.k.b.CAv;
        j.p(paramar, "LockBasedStorageManager.NO_LOCKS");
        paramap = (ap)new a.j.b.a.c.l.ar((w)new z(paramar, (a.f.a.a)new c.a(paramap)));
        AppMethodBeat.o(122065);
        return paramap;
      }
      paramap = (ap)new a.j.b.a.c.l.ar(paramap.eer());
      AppMethodBeat.o(122065);
      return paramap;
    }
    paramap = (ap)new a.j.b.a.c.l.ar(b(paramap));
    AppMethodBeat.o(122065);
    return paramap;
  }
  
  public static final boolean ae(w paramw)
  {
    AppMethodBeat.i(122063);
    j.q(paramw, "receiver$0");
    boolean bool = paramw.enU() instanceof b;
    AppMethodBeat.o(122063);
    return bool;
  }
  
  private static w b(ap paramap)
  {
    AppMethodBeat.i(122062);
    j.q(paramap, "typeProjection");
    paramap = (w)new a(paramap);
    AppMethodBeat.o(122062);
    return paramap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     a.j.b.a.c.i.a.a.c
 * JD-Core Version:    0.7.0.1
 */