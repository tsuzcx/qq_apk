package androidx.compose.foundation.c;

import androidx.compose.ui.a.b;
import androidx.compose.ui.a.c;
import androidx.compose.ui.h.x;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/CrossAxisAlignment;", "", "()V", "isRelative", "", "isRelative$foundation_layout_release", "()Z", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "calculateAlignmentLinePosition", "calculateAlignmentLinePosition$foundation_layout_release", "(Landroidx/compose/ui/layout/Placeable;)Ljava/lang/Integer;", "AlignmentLineCrossAxisAlignment", "CenterCrossAxisAlignment", "Companion", "EndCrossAxisAlignment", "HorizontalCrossAxisAlignment", "StartCrossAxisAlignment", "VerticalCrossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment$CenterCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$StartCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$EndCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$AlignmentLineCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$VerticalCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment$HorizontalCrossAxisAlignment;", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class i
{
  public static final b acA = new b((byte)0);
  private static final i acB = (i)a.acE;
  private static final i acC = (i)e.acH;
  private static final i acD = (i)c.acF;
  
  public static Integer a(x paramx)
  {
    s.u(paramx, "placeable");
    return null;
  }
  
  public static boolean mB()
  {
    return false;
  }
  
  public abstract int a(int paramInt, n paramn, x paramx);
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/CrossAxisAlignment$CenterCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "()V", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    extends i
  {
    public static final a acE;
    
    static
    {
      AppMethodBeat.i(203809);
      acE = new a();
      AppMethodBeat.o(203809);
    }
    
    private a()
    {
      super();
    }
    
    public final int a(int paramInt, n paramn, x paramx)
    {
      AppMethodBeat.i(203813);
      s.u(paramn, "layoutDirection");
      s.u(paramx, "placeable");
      paramInt /= 2;
      AppMethodBeat.o(203813);
      return paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/CrossAxisAlignment$Companion;", "", "()V", "Center", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "End", "getEnd$annotations", "getEnd", "Start", "getStart$annotations", "getStart", "AlignmentLine", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "Relative", "alignmentLineProvider", "Landroidx/compose/foundation/layout/AlignmentLineProvider;", "Relative$foundation_layout_release", "horizontal", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontal$foundation_layout_release", "vertical", "Landroidx/compose/ui/Alignment$Vertical;", "vertical$foundation_layout_release", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static i a(a.b paramb)
    {
      AppMethodBeat.i(203822);
      s.u(paramb, "horizontal");
      paramb = (i)new i.d(paramb);
      AppMethodBeat.o(203822);
      return paramb;
    }
    
    public static i a(a.c paramc)
    {
      AppMethodBeat.i(203818);
      s.u(paramc, "vertical");
      paramc = (i)new i.f(paramc);
      AppMethodBeat.o(203818);
      return paramc;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/CrossAxisAlignment$EndCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "()V", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
    extends i
  {
    public static final c acF;
    
    static
    {
      AppMethodBeat.i(203827);
      acF = new c();
      AppMethodBeat.o(203827);
    }
    
    private c()
    {
      super();
    }
    
    public final int a(int paramInt, n paramn, x paramx)
    {
      AppMethodBeat.i(203838);
      s.u(paramn, "layoutDirection");
      s.u(paramx, "placeable");
      if (paramn == n.beP)
      {
        AppMethodBeat.o(203838);
        return paramInt;
      }
      AppMethodBeat.o(203838);
      return 0;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/CrossAxisAlignment$HorizontalCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "horizontal", "Landroidx/compose/ui/Alignment$Horizontal;", "(Landroidx/compose/ui/Alignment$Horizontal;)V", "getHorizontal", "()Landroidx/compose/ui/Alignment$Horizontal;", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class d
    extends i
  {
    private final a.b acG;
    
    public d(a.b paramb)
    {
      super();
      AppMethodBeat.i(203821);
      this.acG = paramb;
      AppMethodBeat.o(203821);
    }
    
    public final int a(int paramInt, n paramn, x paramx)
    {
      AppMethodBeat.i(203832);
      s.u(paramn, "layoutDirection");
      s.u(paramx, "placeable");
      paramInt = this.acG.a(0, paramInt, paramn);
      AppMethodBeat.o(203832);
      return paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/CrossAxisAlignment$StartCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "()V", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class e
    extends i
  {
    public static final e acH;
    
    static
    {
      AppMethodBeat.i(203833);
      acH = new e();
      AppMethodBeat.o(203833);
    }
    
    private e()
    {
      super();
    }
    
    public final int a(int paramInt, n paramn, x paramx)
    {
      AppMethodBeat.i(203842);
      s.u(paramn, "layoutDirection");
      s.u(paramx, "placeable");
      if (paramn == n.beP)
      {
        AppMethodBeat.o(203842);
        return 0;
      }
      AppMethodBeat.o(203842);
      return paramInt;
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/CrossAxisAlignment$VerticalCrossAxisAlignment;", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "vertical", "Landroidx/compose/ui/Alignment$Vertical;", "(Landroidx/compose/ui/Alignment$Vertical;)V", "getVertical", "()Landroidx/compose/ui/Alignment$Vertical;", "align", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "placeable", "Landroidx/compose/ui/layout/Placeable;", "beforeCrossAxisAlignmentLine", "align$foundation_layout_release", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class f
    extends i
  {
    private final a.c acI;
    
    public f(a.c paramc)
    {
      super();
      AppMethodBeat.i(203828);
      this.acI = paramc;
      AppMethodBeat.o(203828);
    }
    
    public final int a(int paramInt, n paramn, x paramx)
    {
      AppMethodBeat.i(203844);
      s.u(paramn, "layoutDirection");
      s.u(paramx, "placeable");
      paramInt = this.acI.Y(0, paramInt);
      AppMethodBeat.o(203844);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.i
 * JD-Core Version:    0.7.0.1
 */