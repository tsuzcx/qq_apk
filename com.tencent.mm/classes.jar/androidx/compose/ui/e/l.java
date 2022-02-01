package androidx.compose.ui.e;

import android.graphics.PathMeasure;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/AndroidPathMeasure;", "Landroidx/compose/ui/graphics/PathMeasure;", "internalPathMeasure", "Landroid/graphics/PathMeasure;", "(Landroid/graphics/PathMeasure;)V", "length", "", "getLength", "()F", "getSegment", "", "startDistance", "stopDistance", "destination", "Landroidx/compose/ui/graphics/Path;", "startWithMoveTo", "setPath", "", "path", "forceClosed", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements ar
{
  private final PathMeasure avR;
  
  public l(PathMeasure paramPathMeasure)
  {
    AppMethodBeat.i(205931);
    this.avR = paramPathMeasure;
    AppMethodBeat.o(205931);
  }
  
  public final void a(ao paramao)
  {
    AppMethodBeat.i(205941);
    PathMeasure localPathMeasure = this.avR;
    if (paramao == null) {}
    for (paramao = null;; paramao = ((j)paramao).avN)
    {
      localPathMeasure.setPath(paramao, false);
      AppMethodBeat.o(205941);
      return;
      if (!(paramao instanceof j)) {
        break;
      }
    }
    paramao = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    AppMethodBeat.o(205941);
    throw paramao;
  }
  
  public final boolean a(float paramFloat1, float paramFloat2, ao paramao)
  {
    AppMethodBeat.i(205938);
    s.u(paramao, "destination");
    PathMeasure localPathMeasure = this.avR;
    if ((paramao instanceof j))
    {
      boolean bool = localPathMeasure.getSegment(paramFloat1, paramFloat2, ((j)paramao).avN, true);
      AppMethodBeat.o(205938);
      return bool;
    }
    paramao = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    AppMethodBeat.o(205938);
    throw paramao;
  }
  
  public final float sP()
  {
    AppMethodBeat.i(205932);
    float f = this.avR.getLength();
    AppMethodBeat.o(205932);
    return f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.l
 * JD-Core Version:    0.7.0.1
 */