package androidx.compose.ui.p;

import android.view.View;
import androidx.compose.ui.d.e;
import androidx.compose.ui.h.j;
import androidx.compose.ui.h.k;
import androidx.compose.ui.i.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.h.a;

@Metadata(d1={""}, d2={"Unmeasured", "", "layoutAccordingTo", "", "Landroid/view/View;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  static final void a(View paramView, f paramf)
  {
    AppMethodBeat.i(204429);
    long l = k.b((j)paramf.aOC);
    int i = a.eH(e.F(l));
    int j = a.eH(e.G(l));
    paramView.layout(i, j, paramView.getMeasuredWidth() + i, paramView.getMeasuredHeight() + j);
    AppMethodBeat.o(204429);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.p.b
 * JD-Core Version:    0.7.0.1
 */