package androidx.compose.ui.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"ActualImageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "width", "", "height", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "hasAlpha", "", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "ActualImageBitmap-x__-hDU", "(IIIZLandroidx/compose/ui/graphics/colorspace/ColorSpace;)Landroidx/compose/ui/graphics/ImageBitmap;", "asAndroidBitmap", "Landroid/graphics/Bitmap;", "asImageBitmap", "toBitmapConfig", "Landroid/graphics/Bitmap$Config;", "toBitmapConfig-1JJdX4A", "(I)Landroid/graphics/Bitmap$Config;", "toImageConfig", "(Landroid/graphics/Bitmap$Config;)I", "ui-graphics_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final Bitmap b(af paramaf)
  {
    AppMethodBeat.i(205979);
    s.u(paramaf, "<this>");
    if ((paramaf instanceof e))
    {
      paramaf = ((e)paramaf).bitmap;
      AppMethodBeat.o(205979);
      return paramaf;
    }
    paramaf = new UnsupportedOperationException("Unable to obtain android.graphics.Bitmap");
    AppMethodBeat.o(205979);
    throw paramaf;
  }
  
  public static final Bitmap.Config cA(int paramInt)
  {
    AppMethodBeat.i(205980);
    Object localObject = ag.axA;
    if (!ag.C(paramInt, ag.tA()))
    {
      localObject = ag.axA;
      if (ag.C(paramInt, ag.tB()))
      {
        localObject = Bitmap.Config.ALPHA_8;
        AppMethodBeat.o(205980);
        return localObject;
      }
      localObject = ag.axA;
      if (ag.C(paramInt, ag.tC()))
      {
        localObject = Bitmap.Config.RGB_565;
        AppMethodBeat.o(205980);
        return localObject;
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = ag.axA;
        if (ag.C(paramInt, ag.tD()))
        {
          localObject = Bitmap.Config.RGBA_F16;
          AppMethodBeat.o(205980);
          return localObject;
        }
      }
      if (Build.VERSION.SDK_INT >= 26)
      {
        localObject = ag.axA;
        if (ag.C(paramInt, ag.tE()))
        {
          localObject = Bitmap.Config.HARDWARE;
          AppMethodBeat.o(205980);
          return localObject;
        }
      }
    }
    localObject = Bitmap.Config.ARGB_8888;
    AppMethodBeat.o(205980);
    return localObject;
  }
  
  public static final af h(Bitmap paramBitmap)
  {
    AppMethodBeat.i(205974);
    s.u(paramBitmap, "<this>");
    paramBitmap = (af)new e(paramBitmap);
    AppMethodBeat.o(205974);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.f
 * JD-Core Version:    0.7.0.1
 */