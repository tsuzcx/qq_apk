package androidx.compose.ui.k;

import androidx.compose.runtime.h;
import androidx.compose.ui.e;
import androidx.compose.ui.f;
import androidx.compose.ui.platform.ab;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"clearAndSetSemantics", "Landroidx/compose/ui/Modifier;", "properties", "Lkotlin/Function1;", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "Lkotlin/ExtensionFunctionType;", "semantics", "mergeDescendants", "", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class n
{
  public static final f a(f paramf, boolean paramBoolean, final b<? super u, ah> paramb)
  {
    AppMethodBeat.i(205466);
    s.u(paramf, "<this>");
    s.u(paramb, "properties");
    if (ab.zi()) {}
    for (b localb = (b)new a(paramBoolean, paramb);; localb = ab.zh())
    {
      paramf = e.a(paramf, localb, (q)new b(paramBoolean, paramb));
      AppMethodBeat.o(205466);
      return paramf;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/platform/InspectorInfo;", "androidx/compose/ui/platform/InspectableValueKt$debugInspectorInfo$1"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    extends kotlin.g.b.u
    implements b<ad, ah>
  {
    public a(boolean paramBoolean, b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements q<f, h, Integer, f>
  {
    b(boolean paramBoolean, b<? super u, ah> paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.k.n
 * JD-Core Version:    0.7.0.1
 */