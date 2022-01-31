package a.j.b.a.c.b;

import a.j.b.a.c.f.b;
import a.j.b.a.c.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ay$1
  extends az
{
  ay$1(String paramString)
  {
    super(paramString, false);
  }
  
  public final boolean b(a.j.b.a.c.i.e.a.e parame, p paramp, l paraml)
  {
    AppMethodBeat.i(119301);
    if (d.r(paramp))
    {
      if (d.C(paraml) != an.BWG) {}
      for (int i = 1; i != 0; i = 0)
      {
        boolean bool = ay.a(paramp, paraml);
        AppMethodBeat.o(119301);
        return bool;
      }
    }
    if ((paramp instanceof k))
    {
      parame = ((k)paramp).edN();
      if ((d.v(parame)) && (d.r(parame)) && ((paraml instanceof k)) && (d.r(paraml.ecv())) && (ay.a(paramp, paraml)))
      {
        AppMethodBeat.o(119301);
        return true;
      }
    }
    parame = paramp;
    l locall;
    do
    {
      paramp = parame;
      if (parame == null) {
        break;
      }
      locall = parame.ecv();
      if ((locall instanceof e))
      {
        paramp = locall;
        if (!d.u(locall)) {
          break;
        }
      }
      parame = locall;
    } while (!(locall instanceof ab));
    paramp = locall;
    if (paramp == null)
    {
      AppMethodBeat.o(119301);
      return false;
    }
    while (paraml != null)
    {
      if (paramp == paraml)
      {
        AppMethodBeat.o(119301);
        return true;
      }
      if ((paraml instanceof ab))
      {
        if (((paramp instanceof ab)) && (((ab)paramp).eee().equals(((ab)paraml).eee())) && (d.e(paraml, paramp)))
        {
          AppMethodBeat.o(119301);
          return true;
        }
        AppMethodBeat.o(119301);
        return false;
      }
      paraml = paraml.ecv();
    }
    AppMethodBeat.o(119301);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     a.j.b.a.c.b.ay.1
 * JD-Core Version:    0.7.0.1
 */