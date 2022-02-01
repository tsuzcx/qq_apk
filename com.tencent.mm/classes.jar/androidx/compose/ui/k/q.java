package androidx.compose.ui.k;

import androidx.compose.ui.i.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/semantics/SemanticsOwner;", "", "rootNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "rootSemanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "getRootSemanticsNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "unmergedRootSemanticsNode", "getUnmergedRootSemanticsNode", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public static final int Ue = 8;
  private final f aXt;
  
  public q(f paramf)
  {
    AppMethodBeat.i(205430);
    this.aXt = paramf;
    AppMethodBeat.o(205430);
  }
  
  public final o Ae()
  {
    AppMethodBeat.i(205448);
    Object localObject = p.G(this.aXt);
    s.checkNotNull(localObject);
    localObject = new o((w)localObject, false);
    AppMethodBeat.o(205448);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.k.q
 * JD-Core Version:    0.7.0.1
 */