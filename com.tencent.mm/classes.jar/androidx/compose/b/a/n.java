package androidx.compose.b.a;

import androidx.compose.runtime.h;
import androidx.compose.ui.e.ab;
import androidx.compose.ui.e.z;
import androidx.compose.ui.e.z.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/RippleTheme;", "", "defaultColor", "Landroidx/compose/ui/graphics/Color;", "defaultColor-WaAFU9c", "(Landroidx/compose/runtime/Composer;I)J", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleAlpha;", "Companion", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface n
{
  public static final a akR = a.akS;
  
  public abstract long h(h paramh);
  
  public abstract f i(h paramh);
  
  @Metadata(d1={""}, d2={"Landroidx/compose/material/ripple/RippleTheme$Companion;", "", "()V", "defaultRippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "contentColor", "Landroidx/compose/ui/graphics/Color;", "lightTheme", "", "defaultRippleAlpha-DxMtmZc", "(JZ)Landroidx/compose/material/ripple/RippleAlpha;", "defaultRippleColor", "defaultRippleColor-5vOe2sY", "(JZ)J", "material-ripple_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static
    {
      AppMethodBeat.i(201795);
      akS = new a();
      AppMethodBeat.o(201795);
    }
    
    public static long c(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(201778);
      float f = ab.ah(paramLong);
      if ((!paramBoolean) && (f < 0.5D))
      {
        z.a locala = z.awK;
        paramLong = z.tw();
        AppMethodBeat.o(201778);
        return paramLong;
      }
      AppMethodBeat.o(201778);
      return paramLong;
    }
    
    public static f d(long paramLong, boolean paramBoolean)
    {
      AppMethodBeat.i(201784);
      if (paramBoolean)
      {
        if (ab.ah(paramLong) > 0.5D)
        {
          localf = o.nJ();
          AppMethodBeat.o(201784);
          return localf;
        }
        localf = o.nK();
        AppMethodBeat.o(201784);
        return localf;
      }
      f localf = o.nL();
      AppMethodBeat.o(201784);
      return localf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.n
 * JD-Core Version:    0.7.0.1
 */