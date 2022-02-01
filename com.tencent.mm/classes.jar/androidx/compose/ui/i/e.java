package androidx.compose.ui.i;

import androidx.compose.runtime.an;
import androidx.compose.ui.h.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/IntrinsicsPolicy;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "measurePolicyState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/layout/MeasurePolicy;", "pendingMeasurePolicy", "maxIntrinsicHeight", "", "width", "maxIntrinsicWidth", "height", "measurePolicyFromState", "minIntrinsicHeight", "minIntrinsicWidth", "updateFrom", "", "measurePolicy", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  private static final e.a aOa;
  private final f aOb;
  private an<p> aOc;
  private p aOd;
  
  static
  {
    AppMethodBeat.i(204496);
    aOa = new e.a((byte)0);
    AppMethodBeat.o(204496);
  }
  
  public e(f paramf)
  {
    AppMethodBeat.i(204491);
    this.aOb = paramf;
    AppMethodBeat.o(204491);
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(204504);
    s.u(paramp, "measurePolicy");
    if (this.aOc != null)
    {
      an localan = this.aOc;
      s.checkNotNull(localan);
      localan.setValue(paramp);
      AppMethodBeat.o(204504);
      return;
    }
    this.aOd = paramp;
    AppMethodBeat.o(204504);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.e
 * JD-Core Version:    0.7.0.1
 */