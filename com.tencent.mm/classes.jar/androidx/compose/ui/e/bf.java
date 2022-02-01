package androidx.compose.ui.e;

import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/WrapperVerificationHelperMethods;", "", "()V", "setBlendMode", "", "paint", "Landroid/graphics/Paint;", "Landroidx/compose/ui/graphics/NativePaint;", "mode", "Landroidx/compose/ui/graphics/BlendMode;", "setBlendMode-GB0RdKg", "(Landroid/graphics/Paint;I)V", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bf
{
  public static final bf ayE;
  
  static
  {
    AppMethodBeat.i(206012);
    ayE = new bf();
    AppMethodBeat.o(206012);
  }
  
  public final void a(Paint paramPaint, int paramInt)
  {
    AppMethodBeat.i(206015);
    s.u(paramPaint, "paint");
    paramPaint.setBlendMode(a.cy(paramInt));
    AppMethodBeat.o(206015);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.bf
 * JD-Core Version:    0.7.0.1
 */