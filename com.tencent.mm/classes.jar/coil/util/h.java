package coil.util;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import okhttp3.c;

@Metadata(d1={""}, d2={"Lcoil/util/CoilUtils;", "", "()V", "clear", "", "view", "Landroid/view/View;", "createDefaultCache", "Lokhttp3/Cache;", "context", "Landroid/content/Context;", "metadata", "Lcoil/request/ImageResult$Metadata;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h cqr;
  
  static
  {
    AppMethodBeat.i(188140);
    cqr = new h();
    AppMethodBeat.o(188140);
  }
  
  public static final c aB(Context paramContext)
  {
    AppMethodBeat.i(188132);
    s.u(paramContext, "context");
    m localm = m.cqA;
    paramContext = m.aC(paramContext);
    localm = m.cqA;
    paramContext = new c(paramContext, m.q(paramContext));
    AppMethodBeat.o(188132);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     coil.util.h
 * JD-Core Version:    0.7.0.1
 */