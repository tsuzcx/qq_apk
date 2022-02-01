package androidx.compose.ui.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/colorspace/Illuminant;", "", "()V", "A", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "getA", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "B", "getB", "C", "getC", "D50", "getD50", "D50Xyz", "", "getD50Xyz$ui_graphics_release", "()[F", "D55", "getD55", "D60", "getD60", "D65", "getD65", "D75", "getD75", "E", "getE", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g azA;
  private static final m azB;
  private static final m azC;
  private static final m azD;
  private static final m azE;
  private static final m azF;
  private static final m azG;
  private static final m azH;
  private static final m azI;
  private static final m azJ;
  private static final float[] azK;
  
  static
  {
    AppMethodBeat.i(206233);
    azA = new g();
    azB = new m(0.44757F, 0.40745F);
    azC = new m(0.34842F, 0.35161F);
    azD = new m(0.31006F, 0.31616F);
    azE = new m(0.34567F, 0.3585F);
    azF = new m(0.33242F, 0.34743F);
    azG = new m(0.32168F, 0.33767F);
    azH = new m(0.31271F, 0.32902F);
    azI = new m(0.29902F, 0.31485F);
    azJ = new m(0.33333F, 0.33333F);
    azK = new float[] { 0.964212F, 1.0F, 0.825188F };
    AppMethodBeat.o(206233);
  }
  
  public static m uA()
  {
    return azH;
  }
  
  public static float[] uB()
  {
    return azK;
  }
  
  public static m ux()
  {
    return azD;
  }
  
  public static m uy()
  {
    return azE;
  }
  
  public static m uz()
  {
    return azG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.a.g
 * JD-Core Version:    0.7.0.1
 */