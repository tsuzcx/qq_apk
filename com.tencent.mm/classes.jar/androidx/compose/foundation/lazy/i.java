package androidx.compose.foundation.lazy;

import androidx.compose.foundation.c.ab;
import androidx.compose.ui.f;
import androidx.compose.ui.n.b;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "Landroidx/compose/foundation/lazy/LazyItemScope;", "density", "Landroidx/compose/ui/unit/Density;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "(Landroidx/compose/ui/unit/Density;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getConstraints-msEJaDk", "()J", "J", "getDensity", "()Landroidx/compose/ui/unit/Density;", "maxHeight", "Landroidx/compose/ui/unit/Dp;", "F", "maxWidth", "component1", "component2", "component2-msEJaDk", "copy", "copy-0kLqBqw", "(Landroidx/compose/ui/unit/Density;J)Landroidx/compose/foundation/lazy/LazyItemScopeImpl;", "equals", "", "other", "", "hashCode", "", "toString", "", "fillParentMaxHeight", "Landroidx/compose/ui/Modifier;", "fraction", "", "fillParentMaxSize", "fillParentMaxWidth", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
final class i
  implements h
{
  final d TD;
  final long aeB;
  private final float maxHeight;
  private final float maxWidth;
  
  private i(d paramd, long paramLong)
  {
    AppMethodBeat.i(204234);
    this.TD = paramd;
    this.aeB = paramLong;
    this.maxWidth = this.TD.bs(b.aU(this.aeB));
    this.maxHeight = this.TD.bs(b.aW(this.aeB));
    AppMethodBeat.o(204234);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204265);
    if (this == paramObject)
    {
      AppMethodBeat.o(204265);
      return true;
    }
    if (!(paramObject instanceof i))
    {
      AppMethodBeat.o(204265);
      return false;
    }
    paramObject = (i)paramObject;
    if (!s.p(this.TD, paramObject.TD))
    {
      AppMethodBeat.o(204265);
      return false;
    }
    if (!b.e(this.aeB, paramObject.aeB))
    {
      AppMethodBeat.o(204265);
      return false;
    }
    AppMethodBeat.o(204265);
    return true;
  }
  
  public final f f(f paramf)
  {
    AppMethodBeat.i(204244);
    s.u(paramf, "<this>");
    paramf = ab.d(paramf, g.ai(this.maxWidth * 1.0F));
    AppMethodBeat.o(204244);
    return paramf;
  }
  
  public final f g(f paramf)
  {
    AppMethodBeat.i(204249);
    s.u(paramf, "<this>");
    paramf = ab.e(paramf, g.ai(this.maxHeight * 1.0F));
    AppMethodBeat.o(204249);
    return paramf;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204261);
    int i = this.TD.hashCode();
    int j = b.I(this.aeB);
    AppMethodBeat.o(204261);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(204254);
    String str = "LazyItemScopeImpl(density=" + this.TD + ", constraints=" + b.H(this.aeB) + ')';
    AppMethodBeat.o(204254);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.i
 * JD-Core Version:    0.7.0.1
 */