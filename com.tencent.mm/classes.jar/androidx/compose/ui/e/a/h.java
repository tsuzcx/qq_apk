package androidx.compose.ui.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/colorspace/Lab;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "id", "", "(Ljava/lang/String;I)V", "isWideGamut", "", "()Z", "fromXyz", "", "v", "getMaxValue", "", "component", "getMinValue", "toXyz", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends c
{
  public static final h.a azL;
  
  static
  {
    AppMethodBeat.i(206194);
    azL = new h.a((byte)0);
    AppMethodBeat.o(206194);
  }
  
  public h(String paramString)
  {
    super(paramString, b.ub(), 15, (byte)0);
    AppMethodBeat.i(206189);
    AppMethodBeat.o(206189);
  }
  
  public final float cM(int paramInt)
  {
    if (paramInt == 0) {
      return 0.0F;
    }
    return -128.0F;
  }
  
  public final float cN(int paramInt)
  {
    if (paramInt == 0) {
      return 100.0F;
    }
    return 128.0F;
  }
  
  public final float[] f(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206213);
    s.u(paramArrayOfFloat, "v");
    paramArrayOfFloat[0] = k.C(paramArrayOfFloat[0], 0.0F, 100.0F);
    paramArrayOfFloat[1] = k.C(paramArrayOfFloat[1], -128.0F, 128.0F);
    paramArrayOfFloat[2] = k.C(paramArrayOfFloat[2], -128.0F, 128.0F);
    float f2 = (paramArrayOfFloat[0] + 16.0F) / 116.0F;
    float f1 = paramArrayOfFloat[1] * 0.002F + f2;
    float f3 = f2 - paramArrayOfFloat[2] * 0.005F;
    if (f1 > 0.2068966F)
    {
      f1 *= f1 * f1;
      if (f2 <= 0.2068966F) {
        break label186;
      }
      f2 = f2 * f2 * f2;
      label104:
      if (f3 <= 0.2068966F) {
        break label197;
      }
    }
    label186:
    label197:
    for (f3 = f3 * f3 * f3;; f3 = (f3 - 0.137931F) * 0.1284186F)
    {
      g localg = g.azA;
      paramArrayOfFloat[0] = (f1 * g.uB()[0]);
      localg = g.azA;
      paramArrayOfFloat[1] = (f2 * g.uB()[1]);
      localg = g.azA;
      paramArrayOfFloat[2] = (f3 * g.uB()[2]);
      AppMethodBeat.o(206213);
      return paramArrayOfFloat;
      f1 = (f1 - 0.137931F) * 0.1284186F;
      break;
      f2 = (f2 - 0.137931F) * 0.1284186F;
      break label104;
    }
  }
  
  public final float[] g(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206219);
    s.u(paramArrayOfFloat, "v");
    float f1 = paramArrayOfFloat[0];
    g localg = g.azA;
    f1 /= g.uB()[0];
    float f2 = paramArrayOfFloat[1];
    localg = g.azA;
    f2 /= g.uB()[1];
    float f3 = paramArrayOfFloat[2];
    localg = g.azA;
    f3 /= g.uB()[2];
    if (f1 > 0.008856452F)
    {
      f1 = (float)Math.pow(f1, 0.333333343267441D);
      if (f2 <= 0.008856452F) {
        break label186;
      }
      f2 = (float)Math.pow(f2, 0.333333343267441D);
      label99:
      if (f3 <= 0.008856452F) {
        break label197;
      }
    }
    label186:
    label197:
    for (f3 = (float)Math.pow(f3, 0.333333343267441D);; f3 = 7.787037F * f3 + 0.137931F)
    {
      paramArrayOfFloat[0] = k.C(116.0F * f2 - 16.0F, 0.0F, 100.0F);
      paramArrayOfFloat[1] = k.C((f1 - f2) * 500.0F, -128.0F, 128.0F);
      paramArrayOfFloat[2] = k.C((f2 - f3) * 200.0F, -128.0F, 128.0F);
      AppMethodBeat.o(206219);
      return paramArrayOfFloat;
      f1 = f1 * 7.787037F + 0.137931F;
      break;
      f2 = 7.787037F * f2 + 0.137931F;
      break label99;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.a.h
 * JD-Core Version:    0.7.0.1
 */