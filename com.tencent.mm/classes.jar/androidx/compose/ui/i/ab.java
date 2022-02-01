package androidx.compose.ui.i;

import androidx.compose.ui.f.c;
import androidx.compose.ui.g.c.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/PointerInputDelegatingWrapper;", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "Landroidx/compose/ui/input/pointer/PointerInputModifier;", "wrapped", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "pointerInputModifier", "(Landroidx/compose/ui/node/LayoutNodeWrapper;Landroidx/compose/ui/input/pointer/PointerInputModifier;)V", "value", "modifier", "getModifier", "()Landroidx/compose/ui/input/pointer/PointerInputModifier;", "setModifier", "(Landroidx/compose/ui/input/pointer/PointerInputModifier;)V", "hitTest", "", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitPointerInputFilters", "", "Landroidx/compose/ui/input/pointer/PointerInputFilter;", "hitTest-3MmeM6k", "(JLjava/util/List;)V", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends b<t>
{
  public ab(j paramj, t paramt)
  {
    super(paramj, (f.c)paramt);
    AppMethodBeat.i(204562);
    paramt.wq().ahy = ((androidx.compose.ui.h.j)this);
    AppMethodBeat.o(204562);
  }
  
  public final void b(long paramLong, List<androidx.compose.ui.g.c.s> paramList)
  {
    AppMethodBeat.i(204571);
    kotlin.g.b.s.u(paramList, "hitPointerInputFilters");
    if ((aE(paramLong)) && (aD(paramLong)))
    {
      paramList.add(((t)super.wb()).wq());
      paramLong = this.aNN.aC(paramLong);
      this.aNN.b(paramLong, paramList);
    }
    AppMethodBeat.o(204571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.ab
 * JD-Core Version:    0.7.0.1
 */