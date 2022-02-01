package androidx.compose.ui.e;

import android.graphics.BlendModeColorFilter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/BlendModeColorFilterHelper;", "", "()V", "BlendModeColorFilter", "Landroid/graphics/BlendModeColorFilter;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "BlendModeColorFilter-xETnrds", "(JI)Landroid/graphics/BlendModeColorFilter;", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
final class q
{
  public static final q awx;
  
  static
  {
    AppMethodBeat.i(205945);
    awx = new q();
    AppMethodBeat.o(205945);
  }
  
  public final BlendModeColorFilter c(long paramLong, int paramInt)
  {
    AppMethodBeat.i(205949);
    BlendModeColorFilter localBlendModeColorFilter = new BlendModeColorFilter(ab.ai(paramLong), a.cy(paramInt));
    AppMethodBeat.o(205949);
    return localBlendModeColorFilter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.q
 * JD-Core Version:    0.7.0.1
 */