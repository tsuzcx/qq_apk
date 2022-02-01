package androidx.compose.ui.e;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/AndroidImageBitmap;", "Landroidx/compose/ui/graphics/ImageBitmap;", "bitmap", "Landroid/graphics/Bitmap;", "(Landroid/graphics/Bitmap;)V", "getBitmap$ui_graphics_release", "()Landroid/graphics/Bitmap;", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "getColorSpace", "()Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getConfig-_sVssgQ", "()I", "hasAlpha", "", "getHasAlpha", "()Z", "height", "", "getHeight", "width", "getWidth", "prepareToDraw", "", "readPixels", "buffer", "", "startX", "startY", "bufferOffset", "stride", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  implements af
{
  final Bitmap bitmap;
  
  public e(Bitmap paramBitmap)
  {
    AppMethodBeat.i(205982);
    this.bitmap = paramBitmap;
    AppMethodBeat.o(205982);
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(205988);
    int i = this.bitmap.getHeight();
    AppMethodBeat.o(205988);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(205985);
    int i = this.bitmap.getWidth();
    AppMethodBeat.o(205985);
    return i;
  }
  
  public final void sD()
  {
    AppMethodBeat.i(205992);
    this.bitmap.prepareToDraw();
    AppMethodBeat.o(205992);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.e
 * JD-Core Version:    0.7.0.1
 */