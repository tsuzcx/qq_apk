package coil.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"log", "", "Lcoil/util/Logger;", "tag", "", "priority", "", "lazyMessage", "Lkotlin/Function0;", "throwable", "", "coil-base_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final void a(k paramk, String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(188114);
    s.u(paramk, "<this>");
    s.u(paramString, "tag");
    s.u(paramThrowable, "throwable");
    AppMethodBeat.o(188114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.util.f
 * JD-Core Version:    0.7.0.1
 */