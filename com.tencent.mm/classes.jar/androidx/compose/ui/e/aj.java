package androidx.compose.ui.e;

import androidx.compose.ui.d.d;
import androidx.compose.ui.d.e;
import androidx.compose.ui.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/Matrix;", "", "values", "", "constructor-impl", "([F)[F", "getValues", "()[F", "equals", "", "other", "equals-impl", "([FLjava/lang/Object;)Z", "get", "", "row", "", "column", "get-impl", "([FII)F", "hashCode", "hashCode-impl", "([F)I", "invert", "", "invert-impl", "([F)V", "map", "rect", "Landroidx/compose/ui/geometry/MutableRect;", "map-impl", "([FLandroidx/compose/ui/geometry/MutableRect;)V", "Landroidx/compose/ui/geometry/Offset;", "point", "map-MK-Hz9U", "([FJ)J", "Landroidx/compose/ui/geometry/Rect;", "([FLandroidx/compose/ui/geometry/Rect;)Landroidx/compose/ui/geometry/Rect;", "reset", "reset-impl", "rotateX", "degrees", "rotateX-impl", "([FF)V", "rotateY", "rotateY-impl", "rotateZ", "rotateZ-impl", "scale", "x", "y", "z", "scale-impl", "([FFFF)V", "set", "v", "set-impl", "([FIIF)V", "setFrom", "matrix", "setFrom-58bKbWc", "([F[F)V", "timesAssign", "m", "timesAssign-58bKbWc", "toString", "", "toString-impl", "([F)Ljava/lang/String;", "translate", "translate-impl", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aj
{
  public static final aj.a axK;
  
  static
  {
    AppMethodBeat.i(206360);
    axK = new aj.a((byte)0);
    AppMethodBeat.o(206360);
  }
  
  public static final long a(float[] paramArrayOfFloat, long paramLong)
  {
    float f1 = 0.0F;
    AppMethodBeat.i(206302);
    s.u(paramArrayOfFloat, "arg0");
    float f2 = e.F(paramLong);
    float f3 = e.G(paramLong);
    float f4 = paramArrayOfFloat[3];
    float f5 = paramArrayOfFloat[7];
    f4 = paramArrayOfFloat[15] + (f4 * f2 + f5 * f3);
    int i;
    if (f4 == 0.0F)
    {
      i = 1;
      if (i == 0) {
        break label126;
      }
    }
    for (;;)
    {
      paramLong = f.x((paramArrayOfFloat[0] * f2 + paramArrayOfFloat[4] * f3 + paramArrayOfFloat[12]) * f1, f1 * (paramArrayOfFloat[1] * f2 + paramArrayOfFloat[5] * f3 + paramArrayOfFloat[13]));
      AppMethodBeat.o(206302);
      return paramLong;
      i = 0;
      break;
      label126:
      f1 = 1.0F / f4;
    }
  }
  
  public static final void a(float[] paramArrayOfFloat, float paramFloat)
  {
    AppMethodBeat.i(206331);
    s.u(paramArrayOfFloat, "arg0");
    float f1 = (float)Math.cos(paramFloat * 3.141592653589793D / 180.0D);
    paramFloat = (float)Math.sin(paramFloat * 3.141592653589793D / 180.0D);
    float f2 = paramArrayOfFloat[0];
    float f3 = paramArrayOfFloat[4];
    float f4 = -paramFloat;
    float f5 = paramArrayOfFloat[1];
    float f6 = paramArrayOfFloat[5];
    float f7 = -paramFloat;
    float f8 = paramArrayOfFloat[2];
    float f9 = paramArrayOfFloat[6];
    float f10 = -paramFloat;
    float f11 = paramArrayOfFloat[3];
    float f12 = paramArrayOfFloat[7];
    float f13 = -paramFloat;
    paramArrayOfFloat[0] = (f1 * f2 + paramFloat * f3);
    paramArrayOfFloat[1] = (f1 * f5 + paramFloat * f6);
    paramArrayOfFloat[2] = (f1 * f8 + paramFloat * f9);
    paramArrayOfFloat[3] = (f1 * f11 + paramFloat * f12);
    paramArrayOfFloat[4] = (f2 * f4 + f3 * f1);
    paramArrayOfFloat[5] = (f5 * f7 + f6 * f1);
    paramArrayOfFloat[6] = (f8 * f10 + f9 * f1);
    paramArrayOfFloat[7] = (f1 * f12 + f13 * f11);
    AppMethodBeat.o(206331);
  }
  
  public static final void a(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206341);
    s.u(paramArrayOfFloat, "arg0");
    paramArrayOfFloat[0] *= paramFloat1;
    paramArrayOfFloat[1] *= paramFloat1;
    paramArrayOfFloat[2] *= paramFloat1;
    paramArrayOfFloat[3] *= paramFloat1;
    paramArrayOfFloat[4] *= paramFloat2;
    paramArrayOfFloat[5] *= paramFloat2;
    paramArrayOfFloat[6] *= paramFloat2;
    paramArrayOfFloat[7] *= paramFloat2;
    paramArrayOfFloat[8] *= 1.0F;
    paramArrayOfFloat[9] *= 1.0F;
    paramArrayOfFloat[10] *= 1.0F;
    paramArrayOfFloat[11] *= 1.0F;
    AppMethodBeat.o(206341);
  }
  
  public static final void a(float[] paramArrayOfFloat, d paramd)
  {
    AppMethodBeat.i(206309);
    s.u(paramArrayOfFloat, "arg0");
    s.u(paramd, "rect");
    long l1 = a(paramArrayOfFloat, f.x(paramd.left, paramd.top));
    long l2 = a(paramArrayOfFloat, f.x(paramd.left, paramd.bottom));
    long l3 = a(paramArrayOfFloat, f.x(paramd.right, paramd.top));
    long l4 = a(paramArrayOfFloat, f.x(paramd.right, paramd.bottom));
    paramd.left = Math.min(Math.min(e.F(l1), e.F(l2)), Math.min(e.F(l3), e.F(l4)));
    paramd.top = Math.min(Math.min(e.G(l1), e.G(l2)), Math.min(e.G(l3), e.G(l4)));
    paramd.right = Math.max(Math.max(e.F(l1), e.F(l2)), Math.max(e.F(l3), e.F(l4)));
    paramd.bottom = Math.max(Math.max(e.G(l1), e.G(l2)), Math.max(e.G(l3), e.G(l4)));
    AppMethodBeat.o(206309);
  }
  
  public static final void d(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206321);
    s.u(paramArrayOfFloat, "arg0");
    float f1 = paramArrayOfFloat[0];
    float f2 = paramArrayOfFloat[1];
    float f3 = paramArrayOfFloat[2];
    float f4 = paramArrayOfFloat[3];
    float f5 = paramArrayOfFloat[4];
    float f6 = paramArrayOfFloat[5];
    float f7 = paramArrayOfFloat[6];
    float f8 = paramArrayOfFloat[7];
    float f9 = paramArrayOfFloat[8];
    float f10 = paramArrayOfFloat[9];
    float f11 = paramArrayOfFloat[10];
    float f12 = paramArrayOfFloat[11];
    float f13 = paramArrayOfFloat[12];
    float f14 = paramArrayOfFloat[13];
    float f15 = paramArrayOfFloat[14];
    float f16 = paramArrayOfFloat[15];
    float f17 = f1 * f6 - f2 * f5;
    float f18 = f1 * f7 - f3 * f5;
    float f19 = f1 * f8 - f4 * f5;
    float f20 = f2 * f7 - f3 * f6;
    float f21 = f2 * f8 - f4 * f6;
    float f22 = f3 * f8 - f4 * f7;
    float f23 = f9 * f14 - f10 * f13;
    float f24 = f9 * f15 - f11 * f13;
    float f25 = f9 * f16 - f12 * f13;
    float f26 = f10 * f15 - f11 * f14;
    float f27 = f10 * f16 - f12 * f14;
    float f28 = f11 * f16 - f12 * f15;
    float f29 = f22 * f23 + (f17 * f28 - f18 * f27 + f19 * f26 + f20 * f25 - f21 * f24);
    if (f29 == 0.0F) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(206321);
      return;
    }
    f29 = 1.0F / f29;
    paramArrayOfFloat[0] = ((f6 * f28 - f7 * f27 + f8 * f26) * f29);
    paramArrayOfFloat[1] = ((-f2 * f28 + f3 * f27 - f4 * f26) * f29);
    paramArrayOfFloat[2] = ((f14 * f22 - f15 * f21 + f16 * f20) * f29);
    paramArrayOfFloat[3] = ((-f10 * f22 + f11 * f21 - f12 * f20) * f29);
    paramArrayOfFloat[4] = ((-f5 * f28 + f7 * f25 - f8 * f24) * f29);
    paramArrayOfFloat[5] = ((f28 * f1 - f3 * f25 + f4 * f24) * f29);
    paramArrayOfFloat[6] = ((-f13 * f22 + f15 * f19 - f16 * f18) * f29);
    paramArrayOfFloat[7] = ((f22 * f9 - f11 * f19 + f12 * f18) * f29);
    paramArrayOfFloat[8] = ((f8 * f23 + (f5 * f27 - f6 * f25)) * f29);
    paramArrayOfFloat[9] = ((-f1 * f27 + f2 * f25 - f4 * f23) * f29);
    paramArrayOfFloat[10] = ((f13 * f21 - f14 * f19 + f16 * f17) * f29);
    paramArrayOfFloat[11] = ((-f9 * f21 + f10 * f19 - f12 * f17) * f29);
    paramArrayOfFloat[12] = ((-f5 * f26 + f6 * f24 - f7 * f23) * f29);
    paramArrayOfFloat[13] = ((f1 * f26 - f2 * f24 + f3 * f23) * f29);
    paramArrayOfFloat[14] = ((-f13 * f20 + f14 * f18 - f15 * f17) * f29);
    paramArrayOfFloat[15] = (f29 * (f9 * f20 - f10 * f18 + f11 * f17));
    AppMethodBeat.o(206321);
  }
  
  public static final void e(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206328);
    s.u(paramArrayOfFloat, "arg0");
    int i = 0;
    int k = i + 1;
    int m;
    label69:
    for (int j = 0;; j = m)
    {
      m = j + 1;
      if (i == j) {}
      for (float f = 1.0F;; f = 0.0F)
      {
        paramArrayOfFloat[(j * 4 + i)] = f;
        if (m <= 3) {
          break label69;
        }
        if (k <= 3) {
          break;
        }
        AppMethodBeat.o(206328);
        return;
      }
      i = k;
      break;
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    throw null;
  }
  
  public final int hashCode()
  {
    throw null;
  }
  
  public final String toString()
  {
    throw null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.aj
 * JD-Core Version:    0.7.0.1
 */