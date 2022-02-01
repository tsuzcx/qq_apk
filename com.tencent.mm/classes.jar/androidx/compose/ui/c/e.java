package androidx.compose.ui.c;

import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.f.c.a;
import androidx.compose.ui.i.o;
import androidx.compose.ui.platform.ad;
import androidx.compose.ui.platform.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/focus/FocusModifier;", "Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "initialFocus", "Landroidx/compose/ui/focus/FocusStateImpl;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/focus/FocusStateImpl;Lkotlin/jvm/functions/Function1;)V", "focusNode", "Landroidx/compose/ui/node/ModifiedFocusNode;", "getFocusNode", "()Landroidx/compose/ui/node/ModifiedFocusNode;", "setFocusNode", "(Landroidx/compose/ui/node/ModifiedFocusNode;)V", "focusState", "getFocusState", "()Landroidx/compose/ui/focus/FocusStateImpl;", "setFocusState", "(Landroidx/compose/ui/focus/FocusStateImpl;)V", "focusedChild", "getFocusedChild", "setFocusedChild", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends ae
  implements f.c
{
  public l auP;
  public o auQ;
  public o auR;
  
  private e(l paraml, b<? super ad, ah> paramb)
  {
    super(paramb);
    AppMethodBeat.i(204369);
    this.auP = paraml;
    AppMethodBeat.o(204369);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(204404);
    paramf = f.c.a.a((f.c)this, paramf);
    AppMethodBeat.o(204404);
    return paramf;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(204386);
    paramR = f.c.a.a(this, paramR, paramm);
    AppMethodBeat.o(204386);
    return paramR;
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(204375);
    s.u(paraml, "<set-?>");
    this.auP = paraml;
    AppMethodBeat.o(204375);
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(204398);
    boolean bool = f.c.a.a(this, paramb);
    AppMethodBeat.o(204398);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(204392);
    paramR = f.c.a.b(this, paramR, paramm);
    AppMethodBeat.o(204392);
    return paramR;
  }
  
  public final o sq()
  {
    AppMethodBeat.i(204380);
    o localo = this.auR;
    if (localo != null)
    {
      AppMethodBeat.o(204380);
      return localo;
    }
    s.bIx("focusNode");
    AppMethodBeat.o(204380);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.c.e
 * JD-Core Version:    0.7.0.1
 */