package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"CubicErrorBound", "", "FastOutLinearInEasing", "Landroidx/compose/animation/core/Easing;", "getFastOutLinearInEasing", "()Landroidx/compose/animation/core/Easing;", "FastOutSlowInEasing", "getFastOutSlowInEasing", "LinearEasing", "getLinearEasing", "LinearOutSlowInEasing", "getLinearOutSlowInEasing", "animation-core_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class z
{
  private static final y UQ;
  private static final y UR;
  private static final y US;
  private static final y UT;
  
  static
  {
    AppMethodBeat.i(203292);
    UQ = (y)new s(0.4F, 0.2F);
    UR = (y)new s(0.0F, 0.2F);
    US = (y)new s(0.4F, 1.0F);
    UT = (y)a.UU;
    AppMethodBeat.o(203292);
  }
  
  public static final y lL()
  {
    return UQ;
  }
  
  public static final y lM()
  {
    return UT;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "fraction"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    implements y
  {
    public static final a UU;
    
    static
    {
      AppMethodBeat.i(203324);
      UU = new a();
      AppMethodBeat.o(203324);
    }
    
    public final float r(float paramFloat)
    {
      return paramFloat;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.z
 * JD-Core Version:    0.7.0.1
 */