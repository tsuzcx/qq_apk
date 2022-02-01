package androidx.compose.b.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.ui.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/RippleContainer;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "MaxRippleHosts", "", "nextHostIndex", "rippleHostMap", "Landroidx/compose/material/ripple/RippleHostMap;", "rippleHosts", "", "Landroidx/compose/material/ripple/RippleHostView;", "unusedRippleHosts", "onLayout", "", "changed", "", "l", "t", "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "disposeRippleIfNeeded", "Landroidx/compose/material/ripple/AndroidRippleIndicationInstance;", "getRippleHostView", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends ViewGroup
{
  final int akA;
  final List<k> akB;
  final List<k> akC;
  final j akD;
  int akE;
  
  public i(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(201821);
    this.akA = 5;
    this.akB = ((List)new ArrayList());
    this.akC = ((List)new ArrayList());
    this.akD = new j();
    setClipChildren(false);
    paramContext = new k(paramContext);
    addView((View)paramContext);
    this.akB.add(paramContext);
    this.akC.add(paramContext);
    this.akE = 1;
    setTag(g.a.hide_in_inspector_tag, Boolean.TRUE);
    AppMethodBeat.o(201821);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(201831);
    s.u(parama, "<this>");
    parama.a(null);
    k localk = this.akD.b(parama);
    if (localk != null)
    {
      localk.nG();
      this.akD.c(parama);
      this.akC.add(localk);
    }
    AppMethodBeat.o(201831);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201828);
    setMeasuredDimension(0, 0);
    AppMethodBeat.o(201828);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.i
 * JD-Core Version:    0.7.0.1
 */