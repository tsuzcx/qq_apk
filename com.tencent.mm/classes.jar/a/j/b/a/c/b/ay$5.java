package a.j.b.a.c.b;

import a.j.b.a.c.i.d;
import a.j.b.a.c.i.e.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ay$5
  extends az
{
  ay$5(String paramString)
  {
    super(paramString, false);
  }
  
  public final boolean b(a.j.b.a.c.i.e.a.e parame, p paramp, l paraml)
  {
    AppMethodBeat.i(119305);
    if (ay.BWK.b(parame, paramp, paraml))
    {
      if (parame == ay.BWX)
      {
        AppMethodBeat.o(119305);
        return true;
      }
      if (parame == ay.eeD())
      {
        AppMethodBeat.o(119305);
        return false;
      }
      paramp = d.a(paramp, e.class);
      if ((paramp != null) && ((parame instanceof g)))
      {
        boolean bool = ((g)parame).eeq().edL().equals(paramp.edC());
        AppMethodBeat.o(119305);
        return bool;
      }
    }
    AppMethodBeat.o(119305);
    return false;
  }
  
  public final String getDisplayName()
  {
    return "private/*private to this*/";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     a.j.b.a.c.b.ay.5
 * JD-Core Version:    0.7.0.1
 */