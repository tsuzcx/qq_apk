package androidx.compose.b;

import androidx.compose.ui.e.ab;
import androidx.compose.ui.e.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"DefaultSelectionBackgroundAlpha", "", "DesiredContrastRatio", "MinimumSelectionBackgroundAlpha", "binarySearchForAccessibleSelectionColorAlpha", "selectionColor", "Landroidx/compose/ui/graphics/Color;", "textColor", "backgroundColor", "binarySearchForAccessibleSelectionColorAlpha-ysEtTa8", "(JJJ)F", "calculateContrastRatio", "foreground", "background", "calculateContrastRatio--OWjLjI", "(JJ)F", "selectionColorAlpha", "calculateContrastRatio-nb2GgbA", "(JFJJ)F", "calculateSelectionBackgroundColor", "calculateSelectionBackgroundColor-ysEtTa8", "(JJJ)J", "rememberTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "colors", "Landroidx/compose/material/Colors;", "(Landroidx/compose/material/Colors;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "material_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class l
{
  static final float a(long paramLong1, float paramFloat, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(201725);
    paramLong1 = ab.i(z.g(paramLong1, paramFloat), paramLong3);
    paramFloat = d(ab.i(paramLong2, paramLong1), paramLong1);
    AppMethodBeat.o(201725);
    return paramFloat;
  }
  
  static final float b(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(201720);
    float f2 = 0.2F;
    float f1 = 0.4F;
    float f3 = 0.4F;
    int j = 0;
    if (j < 7)
    {
      float f4 = a(paramLong1, f1, paramLong2, paramLong3) / 4.5F - 1.0F;
      int i;
      if (0.0F <= f4) {
        if (f4 <= 0.01F)
        {
          i = 1;
          label61:
          if (i != 0) {
            break label122;
          }
          if (f4 >= 0.0F) {
            break label119;
          }
          f3 = f1;
          f1 = f2;
        }
      }
      label119:
      for (;;)
      {
        f4 = (f3 + f1) / 2.0F;
        f2 = f1;
        j += 1;
        f1 = f4;
        break;
        i = 0;
        break label61;
        i = 0;
        break label61;
      }
    }
    label122:
    AppMethodBeat.o(201720);
    return f1;
  }
  
  private static float d(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(201729);
    float f1 = ab.ah(paramLong1) + 0.05F;
    float f2 = ab.ah(paramLong2) + 0.05F;
    f1 = Math.max(f1, f2) / Math.min(f1, f2);
    AppMethodBeat.o(201729);
    return f1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.l
 * JD-Core Version:    0.7.0.1
 */