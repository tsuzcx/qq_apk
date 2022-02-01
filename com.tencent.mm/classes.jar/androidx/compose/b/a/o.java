package androidx.compose.b.a;

import androidx.compose.runtime.as;
import androidx.compose.runtime.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"DarkThemeRippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "LightThemeHighContrastRippleAlpha", "LightThemeLowContrastRippleAlpha", "LocalRippleTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/ripple/RippleTheme;", "getLocalRippleTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material-ripple_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class o
{
  private static final as<n> akT;
  private static final f akU;
  private static final f akV;
  private static final f akW;
  
  static
  {
    AppMethodBeat.i(201846);
    akT = q.e((a)a.akX);
    akU = new f(0.16F, 0.24F, 0.08F, 0.24F);
    akV = new f(0.08F, 0.12F, 0.04F, 0.12F);
    akW = new f(0.08F, 0.12F, 0.04F, 0.1F);
    AppMethodBeat.o(201846);
  }
  
  public static final as<n> nI()
  {
    return akT;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroidx/compose/material/ripple/RippleTheme;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<n>
  {
    public static final a akX;
    
    static
    {
      AppMethodBeat.i(201840);
      akX = new a();
      AppMethodBeat.o(201840);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.b.a.o
 * JD-Core Version:    0.7.0.1
 */