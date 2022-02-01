package androidx.compose.ui.k;

import androidx.compose.ui.d.g;
import androidx.compose.ui.i.f;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/semantics/NodeLocationHolder;", "", "subtreeRoot", "Landroidx/compose/ui/node/LayoutNode;", "node", "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutNode;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "location", "Landroidx/compose/ui/geometry/Rect;", "getNode$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "getSubtreeRoot$ui_release", "compareTo", "", "other", "Companion", "ComparisonStrategy", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements Comparable<e>
{
  public static final a aWo;
  private static b aWs;
  private final f aWp;
  final f aWq;
  private final g aWr;
  private final n agm;
  
  static
  {
    AppMethodBeat.i(205435);
    aWo = new a((byte)0);
    aWs = b.aWt;
    AppMethodBeat.o(205435);
  }
  
  public e(f paramf1, f paramf2)
  {
    AppMethodBeat.i(205427);
    this.aWp = paramf1;
    this.aWq = paramf2;
    this.agm = this.aWp.agm;
    paramf1 = this.aWp.aOC;
    paramf2 = v.I(this.aWq);
    if ((paramf1.isAttached()) && (paramf2.isAttached())) {}
    for (paramf1 = ((androidx.compose.ui.h.j)paramf1).a((androidx.compose.ui.h.j)paramf2);; paramf1 = null)
    {
      this.aWr = paramf1;
      AppMethodBeat.o(205427);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/semantics/NodeLocationHolder$Companion;", "", "()V", "comparisonStrategy", "Landroidx/compose/ui/semantics/NodeLocationHolder$ComparisonStrategy;", "getComparisonStrategy$ui_release", "()Landroidx/compose/ui/semantics/NodeLocationHolder$ComparisonStrategy;", "setComparisonStrategy$ui_release", "(Landroidx/compose/ui/semantics/NodeLocationHolder$ComparisonStrategy;)V", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void b(e.b paramb)
    {
      AppMethodBeat.i(205499);
      s.u(paramb, "<set-?>");
      e.a(paramb);
      AppMethodBeat.o(205499);
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/semantics/NodeLocationHolder$ComparisonStrategy;", "", "(Ljava/lang/String;I)V", "Stripe", "Location", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum b
  {
    static
    {
      AppMethodBeat.i(205509);
      aWt = new b("Stripe", 0);
      aWu = new b("Location", 1);
      aWv = new b[] { aWt, aWu };
      AppMethodBeat.o(205509);
    }
    
    private b() {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/node/LayoutNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements b<f, Boolean>
  {
    c(g paramg)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/node/LayoutNode;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<f, Boolean>
  {
    d(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.k.e
 * JD-Core Version:    0.7.0.1
 */