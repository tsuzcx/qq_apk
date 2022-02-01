package androidx.compose.ui.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"DebugChanges", "", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "add", "", "Landroidx/compose/ui/node/LayoutNode;", "child", "assignChained", "T", "Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "originalWrapper", "Landroidx/compose/ui/node/LayoutNodeWrapper;", "(Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;Landroidx/compose/ui/node/LayoutNodeWrapper;)Landroidx/compose/ui/node/DelegatingLayoutNodeWrapper;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class i
{
  private static final h aPh;
  
  static
  {
    AppMethodBeat.i(204522);
    aPh = new h();
    AppMethodBeat.o(204522);
  }
  
  public static final y q(f paramf)
  {
    AppMethodBeat.i(204517);
    s.u(paramf, "<this>");
    paramf = paramf.aOl;
    if (paramf == null)
    {
      paramf = (Throwable)new IllegalStateException("LayoutNode should be attached to an owner".toString());
      AppMethodBeat.o(204517);
      throw paramf;
    }
    AppMethodBeat.o(204517);
    return paramf;
  }
  
  public static final h xR()
  {
    return aPh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.i
 * JD-Core Version:    0.7.0.1
 */