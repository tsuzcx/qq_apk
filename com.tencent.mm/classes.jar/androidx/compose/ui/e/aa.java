package androidx.compose.ui.e;

import android.graphics.ColorFilter;
import android.graphics.PorterDuffColorFilter;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/ColorFilter;", "", "nativeColorFilter", "Landroid/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/NativeColorFilter;", "(Landroid/graphics/ColorFilter;)V", "getNativeColorFilter$ui_graphics_release", "()Landroid/graphics/ColorFilter;", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
{
  public static final a awX;
  final ColorFilter awY;
  
  static
  {
    AppMethodBeat.i(206270);
    awX = new a((byte)0);
    AppMethodBeat.o(206270);
  }
  
  public aa(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(206265);
    this.awY = paramColorFilter;
    AppMethodBeat.o(206265);
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/ColorFilter$Companion;", "", "()V", "colorMatrix", "Landroidx/compose/ui/graphics/ColorFilter;", "Landroidx/compose/ui/graphics/ColorMatrix;", "colorMatrix-jHG-Opc", "([F)Landroidx/compose/ui/graphics/ColorFilter;", "lighting", "multiply", "Landroidx/compose/ui/graphics/Color;", "add", "lighting--OWjLjI", "(JJ)Landroidx/compose/ui/graphics/ColorFilter;", "tint", "color", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "tint-xETnrds", "(JI)Landroidx/compose/ui/graphics/ColorFilter;", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static aa d(long paramLong, int paramInt)
    {
      AppMethodBeat.i(206032);
      if (Build.VERSION.SDK_INT >= 29) {}
      for (Object localObject = (ColorFilter)q.awx.c(paramLong, paramInt);; localObject = (ColorFilter)new PorterDuffColorFilter(ab.ai(paramLong), a.cx(paramInt)))
      {
        localObject = new aa((ColorFilter)localObject);
        AppMethodBeat.o(206032);
        return localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.aa
 * JD-Core Version:    0.7.0.1
 */