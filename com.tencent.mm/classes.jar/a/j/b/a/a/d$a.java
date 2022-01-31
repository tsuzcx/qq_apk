package a.j.b.a.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;

@l(eaO={1, 1, 13})
public final class d$a
{
  public static <M extends Member> void a(d<? extends M> paramd, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(118971);
    j.q(paramArrayOfObject, "args");
    if (f.a(paramd) != paramArrayOfObject.length)
    {
      paramd = (Throwable)new IllegalArgumentException("Callable expects " + f.a(paramd) + " arguments, but " + paramArrayOfObject.length + " were provided.");
      AppMethodBeat.o(118971);
      throw paramd;
    }
    AppMethodBeat.o(118971);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     a.j.b.a.a.d.a
 * JD-Core Version:    0.7.0.1
 */