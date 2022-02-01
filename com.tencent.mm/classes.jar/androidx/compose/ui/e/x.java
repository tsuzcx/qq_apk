package androidx.compose.ui.e;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/CanvasZHelper;", "", "()V", "enableZ", "", "canvas", "Landroid/graphics/Canvas;", "enable", "", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
final class x
{
  public static final x awH;
  
  static
  {
    AppMethodBeat.i(205915);
    awH = new x();
    AppMethodBeat.o(205915);
  }
  
  public final void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(205918);
    s.u(paramCanvas, "canvas");
    if (paramBoolean)
    {
      paramCanvas.enableZ();
      AppMethodBeat.o(205918);
      return;
    }
    paramCanvas.disableZ();
    AppMethodBeat.o(205918);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.x
 * JD-Core Version:    0.7.0.1
 */