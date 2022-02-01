package androidx.compose.foundation.a;

import androidx.compose.a.a.u;
import androidx.compose.a.v;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/gestures/ScrollableDefaults;", "", "()V", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/FlingBehavior;", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public static final q abg;
  
  static
  {
    AppMethodBeat.i(204149);
    abg = new q();
    AppMethodBeat.o(204149);
  }
  
  public static i e(h paramh)
  {
    AppMethodBeat.i(204145);
    paramh.bx(400127669);
    u localu = v.b(paramh);
    paramh.bx(-3686930);
    boolean bool = paramh.G(localu);
    Object localObject2 = paramh.or();
    if (!bool)
    {
      localObject1 = h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = new a(localu);
      paramh.F(localObject1);
    }
    paramh.od();
    Object localObject1 = (a)localObject1;
    paramh.od();
    paramh = (i)localObject1;
    AppMethodBeat.o(204145);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.a.q
 * JD-Core Version:    0.7.0.1
 */