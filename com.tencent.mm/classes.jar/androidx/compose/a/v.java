package androidx.compose.a;

import android.view.ViewConfiguration;
import androidx.compose.a.a.ac;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.runtime.p;
import androidx.compose.ui.n.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"platformFlingScrollFriction", "", "getPlatformFlingScrollFriction", "()F", "rememberSplineBasedDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "T", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/DecayAnimationSpec;", "splineBasedDecayDeprecated", "density", "Landroidx/compose/ui/unit/Density;", "splineBasedDecay", "animation_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class v
{
  private static final float TP;
  
  static
  {
    AppMethodBeat.i(203108);
    TP = ViewConfiguration.getScrollFriction();
    AppMethodBeat.o(203108);
  }
  
  public static final <T> androidx.compose.a.a.u<T> b(h paramh)
  {
    AppMethodBeat.i(203103);
    paramh.bx(-903108490);
    d locald = (d)paramh.a((p)androidx.compose.ui.platform.u.yU());
    float f = locald.mn();
    paramh.bx(-3686930);
    boolean bool = paramh.G(Float.valueOf(f));
    Object localObject = paramh.or();
    if (!bool)
    {
      h.a locala = h.alD;
      if (localObject != h.a.ox()) {}
    }
    else
    {
      localObject = (ac)new u(locald);
      s.u(localObject, "<this>");
      localObject = (androidx.compose.a.a.u)new androidx.compose.a.a.v((ac)localObject);
      paramh.F(localObject);
    }
    for (;;)
    {
      paramh.od();
      localObject = (androidx.compose.a.a.u)localObject;
      paramh.od();
      AppMethodBeat.o(203103);
      return localObject;
    }
  }
  
  public static final float lA()
  {
    return TP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.v
 * JD-Core Version:    0.7.0.1
 */