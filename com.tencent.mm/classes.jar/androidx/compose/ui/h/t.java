package androidx.compose.ui.h;

import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.f.c.a;
import androidx.compose.ui.platform.ad;
import androidx.compose.ui.platform.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/OnGloballyPositionedModifierImpl;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "callback", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "", "inspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getCallback", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "", "hashCode", "", "onGloballyPositioned", "coordinates", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class t
  extends ae
  implements s
{
  private final b<j, ah> callback;
  
  public t(b<? super j, ah> paramb, b<? super ad, ah> paramb1)
  {
    super(paramb1);
    AppMethodBeat.i(205657);
    this.callback = paramb;
    AppMethodBeat.o(205657);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(205676);
    s locals = (s)this;
    kotlin.g.b.s.u(locals, "this");
    kotlin.g.b.s.u(paramf, "other");
    paramf = f.c.a.a((f.c)locals, paramf);
    AppMethodBeat.o(205676);
    return paramf;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(205667);
    s locals = (s)this;
    kotlin.g.b.s.u(locals, "this");
    kotlin.g.b.s.u(paramm, "operation");
    paramR = f.c.a.a((f.c)locals, paramR, paramm);
    AppMethodBeat.o(205667);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(205672);
    s locals = (s)this;
    kotlin.g.b.s.u(locals, "this");
    kotlin.g.b.s.u(paramb, "predicate");
    boolean bool = f.c.a.a((f.c)locals, paramb);
    AppMethodBeat.o(205672);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(205670);
    s locals = (s)this;
    kotlin.g.b.s.u(locals, "this");
    kotlin.g.b.s.u(paramm, "operation");
    paramR = f.c.a.b((f.c)locals, paramR, paramm);
    AppMethodBeat.o(205670);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205663);
    if (this == paramObject)
    {
      AppMethodBeat.o(205663);
      return true;
    }
    if (!(paramObject instanceof t))
    {
      AppMethodBeat.o(205663);
      return false;
    }
    boolean bool = kotlin.g.b.s.p(this.callback, ((t)paramObject).callback);
    AppMethodBeat.o(205663);
    return bool;
  }
  
  public final void g(j paramj)
  {
    AppMethodBeat.i(205660);
    kotlin.g.b.s.u(paramj, "coordinates");
    this.callback.invoke(paramj);
    AppMethodBeat.o(205660);
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205664);
    int i = this.callback.hashCode();
    AppMethodBeat.o(205664);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.h.t
 * JD-Core Version:    0.7.0.1
 */