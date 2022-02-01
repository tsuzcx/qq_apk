package androidx.compose.b.a;

import androidx.compose.a.a.av;
import androidx.compose.foundation.k;
import androidx.compose.runtime.bj;
import androidx.compose.runtime.bm;
import androidx.compose.runtime.h;
import androidx.compose.runtime.h.a;
import androidx.compose.ui.n.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"DefaultTweenSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "incomingStateLayerAnimationSpecFor", "Landroidx/compose/animation/core/AnimationSpec;", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "outgoingStateLayerAnimationSpecFor", "rememberRipple", "Landroidx/compose/foundation/Indication;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/Color;", "rememberRipple-9IZ8Weo", "(ZFJLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/Indication;", "material-ripple_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class m
{
  private static final av<Float> akQ;
  
  static
  {
    AppMethodBeat.i(201848);
    akQ = new av(15, androidx.compose.a.a.z.lM(), 2);
    AppMethodBeat.o(201848);
  }
  
  public static final k a(boolean paramBoolean, float paramFloat, long paramLong, h paramh, int paramInt)
  {
    AppMethodBeat.i(201834);
    paramh.bx(-1508283871);
    if ((paramInt & 0x1) != 0) {
      paramBoolean = true;
    }
    if ((paramInt & 0x2) != 0)
    {
      localObject1 = g.beI;
      paramFloat = g.Ch();
    }
    if ((paramInt & 0x4) != 0)
    {
      localObject1 = androidx.compose.ui.e.z.awK;
      paramLong = androidx.compose.ui.e.z.sw();
    }
    bm localbm = bj.b(androidx.compose.ui.e.z.ad(paramLong), paramh);
    Object localObject1 = g.al(paramFloat);
    paramh.bx(-3686552);
    boolean bool1 = paramh.G(Boolean.valueOf(paramBoolean));
    boolean bool2 = paramh.G(localObject1);
    Object localObject2 = paramh.or();
    if (!(bool2 | bool1))
    {
      localObject1 = h.alD;
      localObject1 = localObject2;
      if (localObject2 != h.a.ox()) {}
    }
    else
    {
      localObject1 = new d(paramBoolean, paramFloat, localbm, (byte)0);
      paramh.F(localObject1);
    }
    paramh.od();
    localObject1 = (d)localObject1;
    paramh.od();
    paramh = (k)localObject1;
    AppMethodBeat.o(201834);
    return paramh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.m
 * JD-Core Version:    0.7.0.1
 */