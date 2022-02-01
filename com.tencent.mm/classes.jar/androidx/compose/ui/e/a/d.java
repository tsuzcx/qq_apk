package androidx.compose.ui.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"absRcpResponse", "", "x", "a", "b", "c", "d", "g", "absResponse", "chromaticAdaptation", "", "matrix", "srcWhitePoint", "dstWhitePoint", "compare", "", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "inverse3x3", "m", "mul3x3", "lhs", "rhs", "mul3x3Diag", "mul3x3Float3", "rcpResponse", "e", "f", "response", "adapt", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "whitePoint", "adaptation", "Landroidx/compose/ui/graphics/colorspace/Adaptation;", "connect", "Landroidx/compose/ui/graphics/colorspace/Connector;", "destination", "intent", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "connect-YBCOT_4", "(Landroidx/compose/ui/graphics/colorspace/ColorSpace;Landroidx/compose/ui/graphics/colorspace/ColorSpace;I)Landroidx/compose/ui/graphics/colorspace/Connector;", "ui-graphics_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class d
{
  private static f a(c paramc1, c paramc2, int paramInt)
  {
    AppMethodBeat.i(206168);
    s.u(paramc1, "$this$connect");
    s.u(paramc2, "destination");
    if (paramc1 == paramc2)
    {
      paramc2 = f.azq;
      s.u(paramc1, "source");
      paramc2 = j.azP;
      paramc1 = (f)new f.a.a(paramc1, j.uD());
      AppMethodBeat.o(206168);
      return paramc1;
    }
    long l = paramc1.ayP;
    b.a locala = b.ayJ;
    if (b.e(l, b.tZ()))
    {
      l = paramc2.ayP;
      locala = b.ayJ;
      if (b.e(l, b.tZ()))
      {
        paramc1 = (f)new f.b((k)paramc1, (k)paramc2, paramInt, (byte)0);
        AppMethodBeat.o(206168);
        return paramc1;
      }
    }
    paramc1 = new f(paramc1, paramc2, paramInt, (byte)0);
    AppMethodBeat.o(206168);
    return paramc1;
  }
  
  public static final boolean a(m paramm1, m paramm2)
  {
    AppMethodBeat.i(206190);
    s.u(paramm1, "a");
    s.u(paramm2, "b");
    if (paramm1 == paramm2)
    {
      AppMethodBeat.o(206190);
      return true;
    }
    if ((Math.abs(paramm1.x - paramm2.x) < 0.001F) && (Math.abs(paramm1.y - paramm2.y) < 0.001F))
    {
      AppMethodBeat.o(206190);
      return true;
    }
    AppMethodBeat.o(206190);
    return false;
  }
  
  public static final float[] a(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2, float[] paramArrayOfFloat3)
  {
    AppMethodBeat.i(206214);
    s.u(paramArrayOfFloat1, "matrix");
    s.u(paramArrayOfFloat2, "srcWhitePoint");
    s.u(paramArrayOfFloat3, "dstWhitePoint");
    paramArrayOfFloat2 = c(paramArrayOfFloat1, paramArrayOfFloat2);
    paramArrayOfFloat3 = c(paramArrayOfFloat1, paramArrayOfFloat3);
    float f1 = paramArrayOfFloat3[0] / paramArrayOfFloat2[0];
    float f2 = paramArrayOfFloat3[1] / paramArrayOfFloat2[1];
    float f3 = paramArrayOfFloat3[2] / paramArrayOfFloat2[2];
    paramArrayOfFloat1 = b(h(paramArrayOfFloat1), d(new float[] { f1, f2, f3 }, paramArrayOfFloat1));
    AppMethodBeat.o(206214);
    return paramArrayOfFloat1;
  }
  
  public static final float[] b(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(206199);
    s.u(paramArrayOfFloat1, "lhs");
    s.u(paramArrayOfFloat2, "rhs");
    float f1 = paramArrayOfFloat1[0];
    float f2 = paramArrayOfFloat2[0];
    float f3 = paramArrayOfFloat1[3];
    float f4 = paramArrayOfFloat2[1];
    float f5 = paramArrayOfFloat1[6];
    float f6 = paramArrayOfFloat2[2];
    float f7 = paramArrayOfFloat1[1];
    float f8 = paramArrayOfFloat2[0];
    float f9 = paramArrayOfFloat1[4];
    float f10 = paramArrayOfFloat2[1];
    float f11 = paramArrayOfFloat1[7];
    float f12 = paramArrayOfFloat2[2];
    float f13 = paramArrayOfFloat1[2];
    float f14 = paramArrayOfFloat2[0];
    float f15 = paramArrayOfFloat1[5];
    float f16 = paramArrayOfFloat2[1];
    float f17 = paramArrayOfFloat1[8];
    float f18 = paramArrayOfFloat2[2];
    float f19 = paramArrayOfFloat1[0];
    float f20 = paramArrayOfFloat2[3];
    float f21 = paramArrayOfFloat1[3];
    float f22 = paramArrayOfFloat2[4];
    float f23 = paramArrayOfFloat1[6];
    float f24 = paramArrayOfFloat2[5];
    float f25 = paramArrayOfFloat1[1];
    float f26 = paramArrayOfFloat2[3];
    float f27 = paramArrayOfFloat1[4];
    float f28 = paramArrayOfFloat2[4];
    float f29 = paramArrayOfFloat1[7];
    float f30 = paramArrayOfFloat2[5];
    float f31 = paramArrayOfFloat1[2];
    float f32 = paramArrayOfFloat2[3];
    float f33 = paramArrayOfFloat1[5];
    float f34 = paramArrayOfFloat2[4];
    float f35 = paramArrayOfFloat1[8];
    float f36 = paramArrayOfFloat2[5];
    float f37 = paramArrayOfFloat1[0];
    float f38 = paramArrayOfFloat2[6];
    float f39 = paramArrayOfFloat1[3];
    float f40 = paramArrayOfFloat2[7];
    float f41 = paramArrayOfFloat1[6];
    float f42 = paramArrayOfFloat2[8];
    float f43 = paramArrayOfFloat1[1];
    float f44 = paramArrayOfFloat2[6];
    float f45 = paramArrayOfFloat1[4];
    float f46 = paramArrayOfFloat2[7];
    float f47 = paramArrayOfFloat1[7];
    float f48 = paramArrayOfFloat2[8];
    float f49 = paramArrayOfFloat1[2];
    float f50 = paramArrayOfFloat2[6];
    float f51 = paramArrayOfFloat1[5];
    float f52 = paramArrayOfFloat2[7];
    float f53 = paramArrayOfFloat1[8];
    float f54 = paramArrayOfFloat2[8];
    AppMethodBeat.o(206199);
    return new float[] { f1 * f2 + f3 * f4 + f5 * f6, f7 * f8 + f9 * f10 + f11 * f12, f13 * f14 + f15 * f16 + f17 * f18, f19 * f20 + f21 * f22 + f23 * f24, f25 * f26 + f27 * f28 + f29 * f30, f31 * f32 + f33 * f34 + f35 * f36, f37 * f38 + f39 * f40 + f41 * f42, f43 * f44 + f45 * f46 + f47 * f48, f49 * f50 + f51 * f52 + f53 * f54 };
  }
  
  public static final double c(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    AppMethodBeat.i(206182);
    if (paramDouble1 >= paramDouble5 * paramDouble4)
    {
      paramDouble1 = (Math.pow(paramDouble1, 1.0D / paramDouble6) - paramDouble3) / paramDouble2;
      AppMethodBeat.o(206182);
      return paramDouble1;
    }
    paramDouble1 /= paramDouble4;
    AppMethodBeat.o(206182);
    return paramDouble1;
  }
  
  public static final float[] c(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(206203);
    s.u(paramArrayOfFloat1, "lhs");
    s.u(paramArrayOfFloat2, "rhs");
    float f1 = paramArrayOfFloat2[0];
    float f2 = paramArrayOfFloat2[1];
    float f3 = paramArrayOfFloat2[2];
    paramArrayOfFloat2[0] = (paramArrayOfFloat1[0] * f1 + paramArrayOfFloat1[3] * f2 + paramArrayOfFloat1[6] * f3);
    paramArrayOfFloat2[1] = (paramArrayOfFloat1[1] * f1 + paramArrayOfFloat1[4] * f2 + paramArrayOfFloat1[7] * f3);
    paramArrayOfFloat2[2] = (f1 * paramArrayOfFloat1[2] + f2 * paramArrayOfFloat1[5] + paramArrayOfFloat1[8] * f3);
    AppMethodBeat.o(206203);
    return paramArrayOfFloat2;
  }
  
  public static final double d(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6)
  {
    AppMethodBeat.i(206186);
    if (paramDouble1 >= paramDouble5)
    {
      paramDouble1 = Math.pow(paramDouble2 * paramDouble1 + paramDouble3, paramDouble6);
      AppMethodBeat.o(206186);
      return paramDouble1;
    }
    AppMethodBeat.o(206186);
    return paramDouble4 * paramDouble1;
  }
  
  public static final float[] d(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    AppMethodBeat.i(206209);
    s.u(paramArrayOfFloat1, "lhs");
    s.u(paramArrayOfFloat2, "rhs");
    float f1 = paramArrayOfFloat1[0];
    float f2 = paramArrayOfFloat2[0];
    float f3 = paramArrayOfFloat1[1];
    float f4 = paramArrayOfFloat2[1];
    float f5 = paramArrayOfFloat1[2];
    float f6 = paramArrayOfFloat2[2];
    float f7 = paramArrayOfFloat1[0];
    float f8 = paramArrayOfFloat2[3];
    float f9 = paramArrayOfFloat1[1];
    float f10 = paramArrayOfFloat2[4];
    float f11 = paramArrayOfFloat1[2];
    float f12 = paramArrayOfFloat2[5];
    float f13 = paramArrayOfFloat1[0];
    float f14 = paramArrayOfFloat2[6];
    float f15 = paramArrayOfFloat1[1];
    float f16 = paramArrayOfFloat2[7];
    float f17 = paramArrayOfFloat1[2];
    float f18 = paramArrayOfFloat2[8];
    AppMethodBeat.o(206209);
    return new float[] { f1 * f2, f3 * f4, f5 * f6, f7 * f8, f9 * f10, f11 * f12, f13 * f14, f15 * f16, f17 * f18 };
  }
  
  public static final float[] h(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206193);
    s.u(paramArrayOfFloat, "m");
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[3];
    float f3 = paramArrayOfFloat[6];
    float f4 = paramArrayOfFloat[1];
    float f5 = paramArrayOfFloat[4];
    float f6 = paramArrayOfFloat[7];
    float f7 = paramArrayOfFloat[2];
    float f8 = paramArrayOfFloat[5];
    float f9 = paramArrayOfFloat[8];
    float f10 = f5 * f9 - f6 * f8;
    float f11 = f6 * f7 - f4 * f9;
    float f12 = f4 * f8 - f5 * f7;
    float f13 = f1 * f10 + f2 * f11 + f3 * f12;
    paramArrayOfFloat = new float[paramArrayOfFloat.length];
    paramArrayOfFloat[0] = (f10 / f13);
    paramArrayOfFloat[1] = (f11 / f13);
    paramArrayOfFloat[2] = (f12 / f13);
    paramArrayOfFloat[3] = ((f3 * f8 - f2 * f9) / f13);
    paramArrayOfFloat[4] = ((f9 * f1 - f3 * f7) / f13);
    paramArrayOfFloat[5] = ((f7 * f2 - f8 * f1) / f13);
    paramArrayOfFloat[6] = ((f2 * f6 - f3 * f5) / f13);
    paramArrayOfFloat[7] = ((f3 * f4 - f6 * f1) / f13);
    paramArrayOfFloat[8] = ((f1 * f5 - f2 * f4) / f13);
    AppMethodBeat.o(206193);
    return paramArrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.a.d
 * JD-Core Version:    0.7.0.1
 */