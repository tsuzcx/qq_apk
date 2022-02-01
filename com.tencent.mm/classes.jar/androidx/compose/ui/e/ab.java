package androidx.compose.ui.e;

import androidx.compose.ui.e.a.b.a;
import androidx.compose.ui.e.a.c;
import androidx.compose.ui.e.a.d;
import androidx.compose.ui.e.a.f;
import androidx.compose.ui.e.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"isSpecified", "", "Landroidx/compose/ui/graphics/Color;", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "Color", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "color", "", "(I)J", "(IIII)J", "", "(J)J", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "saturate", "v", "compositeOver", "background", "compositeOver--OWjLjI", "(JJ)J", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "toArgb", "toArgb-8_81llA", "(J)I", "ui-graphics_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ab
{
  private static final float K(float paramFloat)
  {
    float f;
    if (paramFloat <= 0.0F) {
      f = 0.0F;
    }
    do
    {
      return f;
      f = paramFloat;
    } while (paramFloat < 1.0F);
    return 1.0F;
  }
  
  public static final long a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, c paramc)
  {
    int j = 1;
    AppMethodBeat.i(206279);
    s.u(paramc, "colorSpace");
    float f = paramc.cM(0);
    if (paramFloat1 <= paramc.cN(0)) {
      if (f <= paramFloat1)
      {
        i = 1;
        if (i == 0) {
          break label269;
        }
        f = paramc.cM(1);
        if (paramFloat2 > paramc.cN(1)) {
          break label239;
        }
        if (f > paramFloat2) {
          break label233;
        }
        i = 1;
        label78:
        if (i == 0) {
          break label269;
        }
        f = paramc.cM(2);
        if (paramFloat3 > paramc.cN(2)) {
          break label251;
        }
        if (f > paramFloat3) {
          break label245;
        }
        i = 1;
        label112:
        if (i == 0) {
          break label269;
        }
        if (0.0F > paramFloat4) {
          break label263;
        }
        if (paramFloat4 > 1.0F) {
          break label257;
        }
        i = 1;
        label132:
        if (i == 0) {
          break label269;
        }
      }
    }
    label257:
    label263:
    label269:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label275;
      }
      paramc = (Throwable)new IllegalArgumentException(("red = " + paramFloat1 + ", green = " + paramFloat2 + ", blue = " + paramFloat3 + ", alpha = " + paramFloat4 + " outside the range for " + paramc).toString());
      AppMethodBeat.o(206279);
      throw paramc;
      i = 0;
      break;
      i = 0;
      break;
      label233:
      i = 0;
      break label78;
      label239:
      i = 0;
      break label78;
      label245:
      i = 0;
      break label112;
      label251:
      i = 0;
      break label112;
      i = 0;
      break label132;
      i = 0;
      break label132;
    }
    label275:
    if (paramc.uc())
    {
      l = z.J(kotlin.ab.J(kotlin.ab.J(kotlin.ab.J((int)(paramFloat4 * 255.0F + 0.5F) << 24 | (int)(paramFloat1 * 255.0F + 0.5F) << 16 | (int)(paramFloat2 * 255.0F + 0.5F) << 8 | (int)(paramFloat3 * 255.0F + 0.5F)) & 0xFFFFFFFF) << 32));
      AppMethodBeat.o(206279);
      return l;
    }
    if (androidx.compose.ui.e.a.b.an(paramc.ayP) == 3) {}
    for (i = 1; i == 0; i = 0)
    {
      paramc = (Throwable)new IllegalArgumentException("Color only works with ColorSpaces with 3 components".toString());
      AppMethodBeat.o(206279);
      throw paramc;
    }
    int k = paramc.id;
    if (k != -1) {}
    for (i = j; i == 0; i = 0)
    {
      paramc = (Throwable)new IllegalArgumentException("Unknown color space, please use a color space in ColorSpaces".toString());
      AppMethodBeat.o(206279);
      throw paramc;
    }
    i = ac.L(paramFloat1);
    j = ac.L(paramFloat2);
    int m = ac.L(paramFloat3);
    int n = (int)(Math.max(0.0F, Math.min(paramFloat4, 1.0F)) * 1023.0F + 0.5F);
    long l = kotlin.ab.J(kotlin.ab.J(kotlin.ab.J(i) & 0xFFFF) << 48);
    l = z.J(kotlin.ab.J(kotlin.ab.J(kotlin.ab.J(kotlin.ab.J(kotlin.ab.J(kotlin.ab.J(kotlin.ab.J(j) & 0xFFFF) << 32) | l) | kotlin.ab.J(kotlin.ab.J(kotlin.ab.J(m) & 0xFFFF) << 16)) | kotlin.ab.J(kotlin.ab.J(kotlin.ab.J(n) & 0x3FF) << 6)) | kotlin.ab.J(kotlin.ab.J(k) & 0x3F)));
    AppMethodBeat.o(206279);
    return l;
  }
  
  public static final long af(long paramLong)
  {
    AppMethodBeat.i(206282);
    paramLong = z.J(kotlin.ab.J(kotlin.ab.J(kotlin.ab.J(paramLong) & 0xFFFFFFFF) << 32));
    AppMethodBeat.o(206282);
    return paramLong;
  }
  
  static final float[] ag(long paramLong)
  {
    AppMethodBeat.i(206292);
    float f1 = z.Z(paramLong);
    float f2 = z.aa(paramLong);
    float f3 = z.ab(paramLong);
    float f4 = z.ac(paramLong);
    AppMethodBeat.o(206292);
    return new float[] { f1, f2, f3, f4 };
  }
  
  public static final float ah(long paramLong)
  {
    AppMethodBeat.i(206303);
    Object localObject = z.Y(paramLong);
    long l = ((c)localObject).ayP;
    b.a locala = androidx.compose.ui.e.a.b.ayJ;
    if (!androidx.compose.ui.e.a.b.e(l, androidx.compose.ui.e.a.b.tZ()))
    {
      localObject = (Throwable)new IllegalArgumentException(s.X("The specified color must be encoded in an RGB color space. The supplied color space is ", androidx.compose.ui.e.a.b.H(((c)localObject).ayP)).toString());
      AppMethodBeat.o(206303);
      throw ((Throwable)localObject);
    }
    localObject = ((k)localObject).aAa;
    double d1 = ((Number)((kotlin.g.a.b)localObject).invoke(Double.valueOf(z.Z(paramLong)))).doubleValue();
    double d2 = ((Number)((kotlin.g.a.b)localObject).invoke(Double.valueOf(z.aa(paramLong)))).doubleValue();
    float f = K((float)(((Number)((kotlin.g.a.b)localObject).invoke(Double.valueOf(z.ab(paramLong)))).doubleValue() * 0.0722D + (d1 * 0.2126D + d2 * 0.7152D)));
    AppMethodBeat.o(206303);
    return f;
  }
  
  public static final int ai(long paramLong)
  {
    AppMethodBeat.i(206316);
    c localc = z.Y(paramLong);
    if (localc.uc())
    {
      i = (int)kotlin.ab.J(paramLong >>> 32);
      AppMethodBeat.o(206316);
      return i;
    }
    float[] arrayOfFloat = ag(paramLong);
    d.a(localc, null, 0, 3).i(arrayOfFloat);
    int i = (int)(arrayOfFloat[3] * 255.0F + 0.5F);
    int j = (int)(arrayOfFloat[0] * 255.0F + 0.5F);
    int k = (int)(arrayOfFloat[1] * 255.0F + 0.5F);
    int m = (int)(arrayOfFloat[2] * 255.0F + 0.5F);
    AppMethodBeat.o(206316);
    return i << 24 | j << 16 | k << 8 | m;
  }
  
  public static final long cH(int paramInt)
  {
    AppMethodBeat.i(206281);
    long l = z.J(kotlin.ab.J(kotlin.ab.J(paramInt) << 32));
    AppMethodBeat.o(206281);
    return l;
  }
  
  public static final long i(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(206285);
    paramLong1 = z.a(paramLong1, z.Y(paramLong2));
    float f3 = z.ac(paramLong2);
    float f5 = z.ac(paramLong1);
    float f4 = f5 + (1.0F - f5) * f3;
    float f1 = z.Z(paramLong1);
    float f2 = z.Z(paramLong2);
    int i;
    label69:
    float f6;
    label91:
    label99:
    float f7;
    if (f4 == 0.0F)
    {
      i = 1;
      if (i == 0) {
        break label159;
      }
      f1 = 0.0F;
      f2 = z.aa(paramLong1);
      f6 = z.aa(paramLong2);
      if (f4 != 0.0F) {
        break label183;
      }
      i = 1;
      if (i == 0) {
        break label189;
      }
      f2 = 0.0F;
      f6 = z.ab(paramLong1);
      f7 = z.ab(paramLong2);
      if (f4 != 0.0F) {
        break label213;
      }
      i = 1;
      label121:
      if (i == 0) {
        break label219;
      }
    }
    label159:
    label183:
    label189:
    label213:
    label219:
    for (f3 = 0.0F;; f3 = (f6 * f5 + f7 * f3 * (1.0F - f5)) / f4)
    {
      paramLong1 = a(f1, f2, f3, f4, z.Y(paramLong2));
      AppMethodBeat.o(206285);
      return paramLong1;
      i = 0;
      break;
      f1 = (f1 * f5 + f2 * f3 * (1.0F - f5)) / f4;
      break label69;
      i = 0;
      break label91;
      f2 = (f2 * f5 + f6 * f3 * (1.0F - f5)) / f4;
      break label99;
      i = 0;
      break label121;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.ab
 * JD-Core Version:    0.7.0.1
 */