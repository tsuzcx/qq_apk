package androidx.compose.ui.b;

import androidx.compose.ui.n.d;
import androidx.compose.ui.n.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/draw/CacheDrawScope;", "Landroidx/compose/ui/unit/Density;", "()V", "cacheParams", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "getCacheParams$ui_release", "()Landroidx/compose/ui/draw/BuildDrawCacheParams;", "setCacheParams$ui_release", "(Landroidx/compose/ui/draw/BuildDrawCacheParams;)V", "density", "", "getDensity", "()F", "drawResult", "Landroidx/compose/ui/draw/DrawResult;", "getDrawResult$ui_release", "()Landroidx/compose/ui/draw/DrawResult;", "setDrawResult$ui_release", "(Landroidx/compose/ui/draw/DrawResult;)V", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "onDrawBehind", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "onDrawWithContent", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  implements d
{
  public b aum;
  j aun;
  
  public c()
  {
    AppMethodBeat.i(204844);
    this.aum = ((b)k.auv);
    AppMethodBeat.o(204844);
  }
  
  public final float bs(int paramInt)
  {
    AppMethodBeat.i(204899);
    float f = d.a.a(this, paramInt);
    AppMethodBeat.o(204899);
    return f;
  }
  
  public final j m(kotlin.g.a.b<? super androidx.compose.ui.e.b.c, ah> paramb)
  {
    AppMethodBeat.i(204856);
    s.u(paramb, "block");
    paramb = new j(paramb);
    this.aun = paramb;
    AppMethodBeat.o(204856);
    return paramb;
  }
  
  public final float mn()
  {
    AppMethodBeat.i(204863);
    float f = this.aum.getDensity().mn();
    AppMethodBeat.o(204863);
    return f;
  }
  
  public final float mo()
  {
    AppMethodBeat.i(204871);
    float f = this.aum.getDensity().mo();
    AppMethodBeat.o(204871);
    return f;
  }
  
  public final long sf()
  {
    AppMethodBeat.i(204851);
    long l = this.aum.sf();
    AppMethodBeat.o(204851);
    return l;
  }
  
  public final float t(long paramLong)
  {
    AppMethodBeat.i(204894);
    float f = d.a.a(this, paramLong);
    AppMethodBeat.o(204894);
    return f;
  }
  
  public final int v(float paramFloat)
  {
    AppMethodBeat.i(204879);
    int i = d.a.b(this, paramFloat);
    AppMethodBeat.o(204879);
    return i;
  }
  
  public final float w(float paramFloat)
  {
    AppMethodBeat.i(369516);
    paramFloat = d.a.a(this, paramFloat);
    AppMethodBeat.o(369516);
    return paramFloat;
  }
  
  public final long x(float paramFloat)
  {
    AppMethodBeat.i(204891);
    long l = d.a.c(this, paramFloat);
    AppMethodBeat.o(204891);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.b.c
 * JD-Core Version:    0.7.0.1
 */