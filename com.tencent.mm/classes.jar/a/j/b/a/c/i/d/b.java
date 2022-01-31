package a.j.b.a.c.i.d;

import a.j.b.a.c.f.a;
import a.j.b.a.c.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  private a.j.b.a.c.f.b BXD;
  public final String Cjr;
  
  private b(String paramString)
  {
    this.Cjr = paramString;
  }
  
  public static b azf(String paramString)
  {
    AppMethodBeat.i(122156);
    paramString = new b(paramString);
    AppMethodBeat.o(122156);
    return paramString;
  }
  
  public static b h(a parama)
  {
    AppMethodBeat.i(122157);
    a.j.b.a.c.f.b localb = parama.BUK;
    parama = parama.CqB.CqE.CqJ.replace('.', '$');
    if (localb.isRoot())
    {
      parama = new b(parama);
      AppMethodBeat.o(122157);
      return parama;
    }
    parama = new b(localb.CqE.CqJ.replace('.', '/') + "/" + parama);
    AppMethodBeat.o(122157);
    return parama;
  }
  
  public static b o(a.j.b.a.c.f.b paramb)
  {
    AppMethodBeat.i(122158);
    b localb = new b(paramb.CqE.CqJ.replace('.', '/'));
    localb.BXD = paramb;
    AppMethodBeat.o(122158);
    return localb;
  }
  
  public final a.j.b.a.c.f.b enX()
  {
    AppMethodBeat.i(122159);
    int i = this.Cjr.lastIndexOf("/");
    if (i == -1)
    {
      localb = a.j.b.a.c.f.b.CqD;
      AppMethodBeat.o(122159);
      return localb;
    }
    a.j.b.a.c.f.b localb = new a.j.b.a.c.f.b(this.Cjr.substring(0, i).replace('/', '.'));
    AppMethodBeat.o(122159);
    return localb;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(122160);
    if (this == paramObject)
    {
      AppMethodBeat.o(122160);
      return true;
    }
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
    {
      AppMethodBeat.o(122160);
      return false;
    }
    boolean bool = this.Cjr.equals(((b)paramObject).Cjr);
    AppMethodBeat.o(122160);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(122161);
    int i = this.Cjr.hashCode();
    AppMethodBeat.o(122161);
    return i;
  }
  
  public final String toString()
  {
    return this.Cjr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.i.d.b
 * JD-Core Version:    0.7.0.1
 */