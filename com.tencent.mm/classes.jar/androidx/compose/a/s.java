package androidx.compose.a;

import androidx.compose.a.a.aa;
import androidx.compose.ui.n.j;
import androidx.compose.ui.n.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/Slide;", "", "slideOffset", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "fullSize", "Landroidx/compose/ui/unit/IntOffset;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/animation/core/FiniteAnimationSpec;)V", "getAnimationSpec", "()Landroidx/compose/animation/core/FiniteAnimationSpec;", "getSlideOffset", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "animation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class s
{
  final aa<j> SH;
  final b<l, j> TI;
  
  public s(b<? super l, j> paramb, aa<j> paramaa)
  {
    AppMethodBeat.i(203078);
    this.TI = paramb;
    this.SH = paramaa;
    AppMethodBeat.o(203078);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203101);
    if (this == paramObject)
    {
      AppMethodBeat.o(203101);
      return true;
    }
    if (!(paramObject instanceof s))
    {
      AppMethodBeat.o(203101);
      return false;
    }
    paramObject = (s)paramObject;
    if (!kotlin.g.b.s.p(this.TI, paramObject.TI))
    {
      AppMethodBeat.o(203101);
      return false;
    }
    if (!kotlin.g.b.s.p(this.SH, paramObject.SH))
    {
      AppMethodBeat.o(203101);
      return false;
    }
    AppMethodBeat.o(203101);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203093);
    int i = this.TI.hashCode();
    int j = this.SH.hashCode();
    AppMethodBeat.o(203093);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203087);
    String str = "Slide(slideOffset=" + this.TI + ", animationSpec=" + this.SH + ')';
    AppMethodBeat.o(203087);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.s
 * JD-Core Version:    0.7.0.1
 */