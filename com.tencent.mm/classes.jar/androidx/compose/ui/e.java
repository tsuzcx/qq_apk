package androidx.compose.ui;

import androidx.compose.runtime.h;
import androidx.compose.ui.platform.ad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"composed", "Landroidx/compose/ui/Modifier;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "factory", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "materialize", "Landroidx/compose/runtime/Composer;", "modifier", "ui_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final f a(h paramh, f paramf)
  {
    AppMethodBeat.i(204802);
    s.u(paramh, "<this>");
    s.u(paramf, "modifier");
    if (paramf.a((b)a.aub))
    {
      AppMethodBeat.o(204802);
      return paramf;
    }
    paramh.bx(1219399079);
    paramf = (f)paramf.a(f.aud, (m)new b(paramh));
    paramh.od();
    AppMethodBeat.o(204802);
    return paramf;
  }
  
  public static final f a(f paramf, b<? super ad, ah> paramb, q<? super f, ? super h, ? super Integer, ? extends f> paramq)
  {
    AppMethodBeat.i(204782);
    s.u(paramf, "<this>");
    s.u(paramb, "inspectorInfo");
    s.u(paramq, "factory");
    paramf = paramf.a((f)new d(paramb, paramq));
    AppMethodBeat.o(204782);
    return paramf;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Landroidx/compose/ui/Modifier$Element;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements b<f.c, Boolean>
  {
    public static final a aub;
    
    static
    {
      AppMethodBeat.i(204351);
      aub = new a();
      AppMethodBeat.o(204351);
    }
    
    a()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/ui/Modifier;", "acc", "element", "Landroidx/compose/ui/Modifier$Element;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements m<f, f.c, f>
  {
    b(h paramh)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e
 * JD-Core Version:    0.7.0.1
 */