package androidx.compose.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/AndroidFlingSpline;", "", "()V", "NbSamples", "", "SplinePositions", "", "SplineTimes", "deceleration", "", "velocity", "", "friction", "flingPosition", "Landroidx/compose/animation/AndroidFlingSpline$FlingResult;", "time", "FlingResult", "animation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Sl;
  private static final float[] Sm;
  private static final float[] Sn;
  
  static
  {
    AppMethodBeat.i(203050);
    Sl = new a();
    Sm = new float[101];
    Sn = new float[101];
    float[] arrayOfFloat1 = Sm;
    float[] arrayOfFloat2 = Sn;
    float f1 = 0.0F;
    int i = 0;
    float f2 = 0.0F;
    for (;;)
    {
      int j = i + 1;
      float f5 = i / 100.0F;
      float f3 = 1.0F;
      float f4;
      float f6;
      float f7;
      for (;;)
      {
        f4 = (f3 - f1) / 2.0F + f1;
        f6 = 3.0F * f4 * (1.0F - f4);
        f7 = ((1.0F - f4) * 0.175F + 0.35F * f4) * f6 + f4 * f4 * f4;
        if (Math.abs(f7 - f5) < 1.E-005D) {
          break;
        }
        if (f7 > f5) {
          f3 = f4;
        } else {
          f1 = f4;
        }
      }
      arrayOfFloat1[i] = (((1.0F - f4) * 0.5F + f4) * f6 + f4 * (f4 * f4));
      f3 = 1.0F;
      for (;;)
      {
        f4 = (f3 - f2) / 2.0F + f2;
        f6 = 3.0F * f4 * (1.0F - f4);
        f7 = ((1.0F - f4) * 0.5F + f4) * f6 + f4 * f4 * f4;
        if (Math.abs(f7 - f5) < 1.E-005D) {
          break;
        }
        if (f7 > f5) {
          f3 = f4;
        } else {
          f2 = f4;
        }
      }
      arrayOfFloat2[i] = (((1.0F - f4) * 0.175F + 0.35F * f4) * f6 + f4 * (f4 * f4));
      if (j >= 100)
      {
        arrayOfFloat2[100] = 1.0F;
        arrayOfFloat1[100] = arrayOfFloat2[100];
        AppMethodBeat.o(203050);
        return;
      }
      i = j;
    }
  }
  
  public static a.a l(float paramFloat)
  {
    AppMethodBeat.i(203031);
    int i = (int)(100.0F * paramFloat);
    float f2 = 1.0F;
    float f1 = 0.0F;
    if (i < 100)
    {
      f2 = i / 100.0F;
      f1 = (i + 1) / 100.0F;
      float f3 = Sm[i];
      f1 = (Sm[(i + 1)] - f3) / (f1 - f2);
      f2 = (paramFloat - f2) * f1 + f3;
    }
    a.a locala = new a.a(f2, f1);
    AppMethodBeat.o(203031);
    return locala;
  }
  
  public static double q(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(203037);
    double d = Math.log(0.35F * Math.abs(paramFloat1) / paramFloat2);
    AppMethodBeat.o(203037);
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a
 * JD-Core Version:    0.7.0.1
 */