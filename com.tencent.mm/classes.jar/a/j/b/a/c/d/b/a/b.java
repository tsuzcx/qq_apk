package a.j.b.a.c.d.b.a;

import a.j.b.a.c.b.am;
import a.j.b.a.c.d.a.p;
import a.j.b.a.c.d.b.n.a;
import a.j.b.a.c.d.b.n.c;
import a.j.b.a.c.e.b.a.d;
import a.j.b.a.c.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;

public final class b
  implements n.c
{
  private static final boolean Ckg;
  private static final Map<a, a.a> Ckh;
  public d CjS = null;
  public String[] CjT = null;
  public String[] CjU = null;
  public String CjV = null;
  public int CjW = 0;
  public int[] Cki = null;
  public a.a Ckj = null;
  public String packageName = null;
  public String[] strings = null;
  
  static
  {
    AppMethodBeat.i(120352);
    Ckg = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
    HashMap localHashMap = new HashMap();
    Ckh = localHashMap;
    localHashMap.put(a.n(new a.j.b.a.c.f.b("kotlin.jvm.internal.KotlinClass")), a.a.CjY);
    Ckh.put(a.n(new a.j.b.a.c.f.b("kotlin.jvm.internal.KotlinFileFacade")), a.a.CjZ);
    Ckh.put(a.n(new a.j.b.a.c.f.b("kotlin.jvm.internal.KotlinMultifileClass")), a.a.Ckb);
    Ckh.put(a.n(new a.j.b.a.c.f.b("kotlin.jvm.internal.KotlinMultifileClassPart")), a.a.Ckc);
    Ckh.put(a.n(new a.j.b.a.c.f.b("kotlin.jvm.internal.KotlinSyntheticClass")), a.a.Cka);
    AppMethodBeat.o(120352);
  }
  
  public final n.a a(a parama, am paramam)
  {
    AppMethodBeat.i(120351);
    if (parama.emc().equals(p.CcZ))
    {
      parama = new b.b(this, (byte)0);
      AppMethodBeat.o(120351);
      return parama;
    }
    if (Ckg)
    {
      AppMethodBeat.o(120351);
      return null;
    }
    if (this.Ckj != null)
    {
      AppMethodBeat.o(120351);
      return null;
    }
    parama = (a.a)Ckh.get(parama);
    if (parama != null)
    {
      this.Ckj = parama;
      parama = new b.c(this, (byte)0);
      AppMethodBeat.o(120351);
      return parama;
    }
    AppMethodBeat.o(120351);
    return null;
  }
  
  public final void zi() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.d.b.a.b
 * JD-Core Version:    0.7.0.1
 */