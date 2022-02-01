package androidx.compose.ui.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.h.a;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/unit/Density;", "", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "fontScale", "getFontScale$annotations", "getFontScale", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui-unit_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
{
  public abstract float bs(int paramInt);
  
  public abstract float mn();
  
  public abstract float mo();
  
  public abstract float t(long paramLong);
  
  public abstract int v(float paramFloat);
  
  public abstract float w(float paramFloat);
  
  public abstract long x(float paramFloat);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static float a(d paramd, float paramFloat)
    {
      AppMethodBeat.i(204753);
      s.u(paramd, "this");
      float f = paramd.mn();
      AppMethodBeat.o(204753);
      return f * paramFloat;
    }
    
    public static float a(d paramd, int paramInt)
    {
      AppMethodBeat.i(204775);
      s.u(paramd, "this");
      float f = g.ai(paramInt / paramd.mn());
      AppMethodBeat.o(204775);
      return f;
    }
    
    public static float a(d paramd, long paramLong)
    {
      AppMethodBeat.i(204773);
      s.u(paramd, "this");
      long l = o.bn(paramLong);
      q.a locala = q.beU;
      if (!q.e(l, q.Ci()))
      {
        paramd = (Throwable)new IllegalStateException("Only Sp can convert to Px".toString());
        AppMethodBeat.o(204773);
        throw paramd;
      }
      float f1 = o.bo(paramLong);
      float f2 = paramd.mo();
      float f3 = paramd.mn();
      AppMethodBeat.o(204773);
      return f1 * f2 * f3;
    }
    
    public static int b(d paramd, float paramFloat)
    {
      AppMethodBeat.i(204764);
      s.u(paramd, "this");
      paramFloat = paramd.w(paramFloat);
      if (Float.isInfinite(paramFloat))
      {
        AppMethodBeat.o(204764);
        return 2147483647;
      }
      int i = a.eH(paramFloat);
      AppMethodBeat.o(204764);
      return i;
    }
    
    public static long c(d paramd, float paramFloat)
    {
      AppMethodBeat.i(204767);
      s.u(paramd, "this");
      long l = p.i(4294967296L, paramFloat / paramd.mo());
      AppMethodBeat.o(204767);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.n.d
 * JD-Core Version:    0.7.0.1
 */