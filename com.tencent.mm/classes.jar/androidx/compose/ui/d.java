package androidx.compose.ui;

import androidx.compose.runtime.h;
import androidx.compose.ui.platform.ad;
import androidx.compose.ui.platform.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.a.q;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/ComposedModifier;", "Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "factory", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)V", "getFactory", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class d
  extends ae
  implements f.c
{
  final q<f, h, Integer, f> aua;
  
  public d(b<? super ad, ah> paramb, q<? super f, ? super h, ? super Integer, ? extends f> paramq)
  {
    super(paramb);
    AppMethodBeat.i(204779);
    this.aua = paramq;
    AppMethodBeat.o(204779);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(204813);
    paramf = f.c.a.a((f.c)this, paramf);
    AppMethodBeat.o(204813);
    return paramf;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(204788);
    paramR = f.c.a.a(this, paramR, paramm);
    AppMethodBeat.o(204788);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(204806);
    boolean bool = f.c.a.a(this, paramb);
    AppMethodBeat.o(204806);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(204796);
    paramR = f.c.a.b(this, paramR, paramm);
    AppMethodBeat.o(204796);
    return paramR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.d
 * JD-Core Version:    0.7.0.1
 */