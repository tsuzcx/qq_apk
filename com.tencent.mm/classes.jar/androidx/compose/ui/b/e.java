package androidx.compose.ui.b;

import androidx.compose.ui.e.b.c;
import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.platform.ad;
import androidx.compose.ui.platform.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/draw/DrawBackgroundModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "onDraw", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "inspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnDraw", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "", "hashCode", "", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
final class e
  extends ae
  implements h
{
  private final b<androidx.compose.ui.e.b.e, ah> auo;
  
  public e(b<? super androidx.compose.ui.e.b.e, ah> paramb, b<? super ad, ah> paramb1)
  {
    super(paramb1);
    AppMethodBeat.i(204839);
    this.auo = paramb;
    AppMethodBeat.o(204839);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(204886);
    paramf = h.a.a((h)this, paramf);
    AppMethodBeat.o(204886);
    return paramf;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(204862);
    paramR = h.a.a((h)this, paramR, paramm);
    AppMethodBeat.o(204862);
    return paramR;
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(204843);
    s.u(paramc, "<this>");
    this.auo.invoke(paramc);
    paramc.uK();
    AppMethodBeat.o(204843);
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(204881);
    boolean bool = h.a.a((h)this, paramb);
    AppMethodBeat.o(204881);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(204870);
    paramR = h.a.b((h)this, paramR, paramm);
    AppMethodBeat.o(204870);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(204850);
    if (this == paramObject)
    {
      AppMethodBeat.o(204850);
      return true;
    }
    if (!(paramObject instanceof e))
    {
      AppMethodBeat.o(204850);
      return false;
    }
    boolean bool = s.p(this.auo, ((e)paramObject).auo);
    AppMethodBeat.o(204850);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(204855);
    int i = this.auo.hashCode();
    AppMethodBeat.o(204855);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.b.e
 * JD-Core Version:    0.7.0.1
 */