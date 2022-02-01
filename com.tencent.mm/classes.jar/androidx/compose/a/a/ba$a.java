package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ah;

@Metadata(d1={""}, d2={"androidx/compose/animation/core/VectorizedAnimationSpecKt$createSpringAnimations$1", "Landroidx/compose/animation/core/Animations;", "anims", "", "Landroidx/compose/animation/core/FloatSpringSpec;", "get", "index", "", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ba$a
  implements p
{
  private final List<ad> Xr;
  
  ba$a(V paramV, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(203238);
    Object localObject = (Iterable)kotlin.k.k.qt(0, this.Xs.lK());
    paramFloat1 = this.Xt;
    paramFloat2 = this.Xu;
    paramV = this.Xs;
    Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(new ad(paramFloat1, paramFloat2, paramV.bq(((ah)localObject).Zo())));
    }
    this.Xr = ((List)localCollection);
    AppMethodBeat.o(203238);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.ba.a
 * JD-Core Version:    0.7.0.1
 */