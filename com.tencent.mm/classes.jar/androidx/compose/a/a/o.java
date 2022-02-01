package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"AnimationVector", "Landroidx/compose/animation/core/AnimationVector1D;", "v1", "", "Landroidx/compose/animation/core/AnimationVector2D;", "v2", "Landroidx/compose/animation/core/AnimationVector3D;", "v3", "Landroidx/compose/animation/core/AnimationVector4D;", "v4", "copy", "T", "Landroidx/compose/animation/core/AnimationVector;", "(Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "copyFrom", "", "source", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "newInstance", "animation-core_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class o
{
  public static final <T extends k> void a(T paramT1, T paramT2)
  {
    AppMethodBeat.i(203274);
    s.u(paramT1, "<this>");
    s.u(paramT2, "source");
    int i = 0;
    int k = paramT1.lK();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      paramT1.e(i, paramT2.bq(i));
      if (j >= k)
      {
        AppMethodBeat.o(203274);
        return;
      }
      i = j;
    }
  }
  
  public static final <T extends k> T b(T paramT)
  {
    AppMethodBeat.i(203261);
    s.u(paramT, "<this>");
    paramT = paramT.lJ();
    AppMethodBeat.o(203261);
    return paramT;
  }
  
  public static final <T extends k> T c(T paramT)
  {
    AppMethodBeat.i(203267);
    s.u(paramT, "<this>");
    k localk = b(paramT);
    int i = 0;
    int k = localk.lK();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      localk.e(i, paramT.bq(i));
      if (j >= k)
      {
        AppMethodBeat.o(203267);
        return localk;
      }
      i = j;
    }
  }
  
  public static final l q(float paramFloat)
  {
    AppMethodBeat.i(203257);
    l locall = new l(paramFloat);
    AppMethodBeat.o(203257);
    return locall;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.o
 * JD-Core Version:    0.7.0.1
 */