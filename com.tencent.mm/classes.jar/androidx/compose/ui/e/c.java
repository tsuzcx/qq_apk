package androidx.compose.ui.e;

import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"EmptyCanvas", "Landroid/graphics/Canvas;", "nativeCanvas", "Landroidx/compose/ui/graphics/NativeCanvas;", "Landroidx/compose/ui/graphics/Canvas;", "getNativeCanvas", "(Landroidx/compose/ui/graphics/Canvas;)Landroid/graphics/Canvas;", "ActualCanvas", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "Canvas", "c", "NativeCanvas", "ui-graphics_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class c
{
  private static final Canvas avG;
  
  static
  {
    AppMethodBeat.i(206002);
    avG = new Canvas();
    AppMethodBeat.o(206002);
  }
  
  public static final Canvas a(u paramu)
  {
    AppMethodBeat.i(205993);
    s.u(paramu, "<this>");
    paramu = ((b)paramu).avB;
    AppMethodBeat.o(205993);
    return paramu;
  }
  
  public static final u a(af paramaf)
  {
    AppMethodBeat.i(205990);
    s.u(paramaf, "image");
    b localb = new b();
    localb.b(new Canvas(f.b(paramaf)));
    paramaf = (u)localb;
    AppMethodBeat.o(205990);
    return paramaf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.c
 * JD-Core Version:    0.7.0.1
 */