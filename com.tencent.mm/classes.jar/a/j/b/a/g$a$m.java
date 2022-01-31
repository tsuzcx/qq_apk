package a.j.b.a;

import a.f.a.a;
import a.f.b.k;
import a.j.b.a.c.a.d;
import a.j.b.a.c.b.e;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "T", "", "invoke", "()Ljava/lang/Object;"})
final class g$a$m
  extends k
  implements a<T>
{
  g$a$m(g.a parama)
  {
    super(0);
  }
  
  public final T invoke()
  {
    AppMethodBeat.i(118706);
    Object localObject = this.BOL.ebw();
    if (((e)localObject).ecB() != a.j.b.a.c.b.f.BWk)
    {
      AppMethodBeat.o(118706);
      return null;
    }
    if (((e)localObject).ecF())
    {
      d locald = d.BRE;
      if (d.b((e)localObject)) {}
    }
    for (localObject = this.BOL.BOK.BNl.getEnclosingClass().getDeclaredField(((e)localObject).edF().name);; localObject = this.BOL.BOK.BNl.getDeclaredField("INSTANCE"))
    {
      localObject = ((Field)localObject).get(null);
      if (localObject != null) {
        break;
      }
      localObject = new v("null cannot be cast to non-null type T");
      AppMethodBeat.o(118706);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(118706);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     a.j.b.a.g.a.m
 * JD-Core Version:    0.7.0.1
 */