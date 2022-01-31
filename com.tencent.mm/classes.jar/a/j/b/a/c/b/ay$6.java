package a.j.b.a.c.b;

import a.j.b.a.c.i.d;
import a.j.b.a.c.i.e.a.f;
import a.j.b.a.c.l.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ay$6
  extends az
{
  ay$6(String paramString)
  {
    super(paramString, true);
  }
  
  public final boolean b(a.j.b.a.c.i.e.a.e parame, p paramp, l paraml)
  {
    AppMethodBeat.i(119306);
    for (;;)
    {
      e locale2 = (e)d.a(paramp, e.class);
      e locale1 = (e)d.a(paraml, e.class, false);
      if (locale1 == null)
      {
        AppMethodBeat.o(119306);
        return false;
      }
      if ((locale2 != null) && (d.u(locale2)))
      {
        paraml = (e)d.a(locale2, e.class);
        if ((paraml != null) && (d.c(locale1, paraml)))
        {
          AppMethodBeat.o(119306);
          return true;
        }
      }
      paraml = d.a(paramp);
      locale2 = (e)d.a(paraml, e.class);
      if (locale2 == null)
      {
        AppMethodBeat.o(119306);
        return false;
      }
      if (d.c(locale1, locale2))
      {
        int i;
        if (parame != ay.BWY) {
          if (!(paraml instanceof b)) {
            i = 1;
          }
        }
        while (i != 0)
        {
          AppMethodBeat.o(119306);
          return true;
          if ((paraml instanceof k))
          {
            i = 1;
          }
          else if (parame == ay.BWX)
          {
            i = 1;
          }
          else if ((parame == ay.eeD()) || (parame == null))
          {
            i = 0;
          }
          else
          {
            if ((parame instanceof f)) {}
            for (paraml = ((f)parame).eon();; paraml = parame.eer())
            {
              if ((!d.b(paraml, locale1)) && (!n.ag(paraml))) {
                break label243;
              }
              i = 1;
              break;
            }
            label243:
            i = 0;
          }
        }
      }
      paraml = locale1.ecv();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.c.b.ay.6
 * JD-Core Version:    0.7.0.1
 */