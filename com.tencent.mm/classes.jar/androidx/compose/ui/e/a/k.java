package androidx.compose.ui.e.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/colorspace/Rgb;", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "name", "", "toXYZ", "", "oetf", "Lkotlin/Function1;", "", "eotf", "(Ljava/lang/String;[FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "primaries", "whitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "min", "", "max", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FF)V", "function", "Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;)V", "id", "", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;Landroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "gamma", "(Ljava/lang/String;[FD)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;D)V", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;DFFI)V", "colorSpace", "transform", "(Landroidx/compose/ui/graphics/colorspace/Rgb;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;)V", "transferParameters", "(Ljava/lang/String;[FLandroidx/compose/ui/graphics/colorspace/WhitePoint;[FLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;FFLandroidx/compose/ui/graphics/colorspace/TransferParameters;I)V", "getEotf", "()Lkotlin/jvm/functions/Function1;", "eotfOrig", "getEotfOrig$ui_graphics_release", "inverseTransform", "getInverseTransform$ui_graphics_release", "()[F", "isSrgb", "", "()Z", "isWideGamut", "getOetf", "oetfOrig", "getOetfOrig$ui_graphics_release", "getPrimaries$ui_graphics_release", "getTransferParameters", "()Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "getTransform$ui_graphics_release", "getWhitePoint", "()Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "equals", "other", "", "fromLinear", "r", "g", "b", "v", "fromXyz", "getInverseTransform", "getMaxValue", "component", "getMinValue", "getPrimaries", "getTransform", "hashCode", "toLinear", "toXyz", "Companion", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends c
{
  private static final kotlin.g.a.b<Double, Double> aAd;
  public static final a azT;
  public final kotlin.g.a.b<Double, Double> aAa;
  private final boolean aAb;
  private final boolean aAc;
  final m azU;
  private final l azV;
  private final float[] azW;
  final kotlin.g.a.b<Double, Double> azX;
  final kotlin.g.a.b<Double, Double> azY;
  final kotlin.g.a.b<Double, Double> azZ;
  final float[] inverseTransform;
  private final float max;
  private final float min;
  final float[] transform;
  
  static
  {
    AppMethodBeat.i(206245);
    azT = new a((byte)0);
    aAd = (kotlin.g.a.b)k.b.aAg;
    AppMethodBeat.o(206245);
  }
  
  public k(k paramk, float[] paramArrayOfFloat, m paramm)
  {
    this(paramk.name, paramk.azW, paramm, paramArrayOfFloat, paramk.azX, paramk.azZ, paramk.min, paramk.max, paramk.azV, -1);
    AppMethodBeat.i(206230);
    AppMethodBeat.o(206230);
  }
  
  public k(String paramString, float[] paramArrayOfFloat, m paramm, double paramDouble, float paramFloat1, float paramFloat2, int paramInt) {}
  
  public k(String paramString, float[] paramArrayOfFloat, m paramm, l paraml, int paramInt) {}
  
  public k(String paramString, float[] paramArrayOfFloat1, m paramm, float[] paramArrayOfFloat2, kotlin.g.a.b<? super Double, Double> paramb1, kotlin.g.a.b<? super Double, Double> paramb2, float paramFloat1, float paramFloat2, l paraml, int paramInt)
  {
    super(paramString, b.tZ(), paramInt, (byte)0);
    AppMethodBeat.i(206218);
    this.azU = paramm;
    this.min = paramFloat1;
    this.max = paramFloat2;
    this.azV = paraml;
    this.azX = paramb1;
    this.azY = ((kotlin.g.a.b)new d(this));
    this.azZ = paramb2;
    this.aAa = ((kotlin.g.a.b)new c(this));
    if ((paramArrayOfFloat1.length != 6) && (paramArrayOfFloat1.length != 9))
    {
      paramString = new IllegalArgumentException("The color space's primaries must be defined as an array of 6 floats in xyY or 9 floats in XYZ");
      AppMethodBeat.o(206218);
      throw paramString;
    }
    if (this.min >= this.max)
    {
      paramString = new IllegalArgumentException("Invalid range: min=" + this.min + ", max=" + this.max + "; min must be strictly < max");
      AppMethodBeat.o(206218);
      throw paramString;
    }
    paramString = new float[6];
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    label639:
    int i;
    if (paramArrayOfFloat1.length == 9)
    {
      paramFloat1 = paramArrayOfFloat1[0] + paramArrayOfFloat1[1] + paramArrayOfFloat1[2];
      paramArrayOfFloat1[0] /= paramFloat1;
      paramArrayOfFloat1[1] /= paramFloat1;
      paramFloat1 = paramArrayOfFloat1[3] + paramArrayOfFloat1[4] + paramArrayOfFloat1[5];
      paramString[2] = (paramArrayOfFloat1[3] / paramFloat1);
      paramString[3] = (paramArrayOfFloat1[4] / paramFloat1);
      paramFloat1 = paramArrayOfFloat1[6] + paramArrayOfFloat1[7] + paramArrayOfFloat1[8];
      paramString[4] = (paramArrayOfFloat1[6] / paramFloat1);
      paramString[5] = (paramArrayOfFloat1[7] / paramFloat1);
      this.azW = paramString;
      if (paramArrayOfFloat2 != null) {
        break label937;
      }
      paramString = this.azW;
      paramArrayOfFloat1 = this.azU;
      paramFloat1 = paramString[0];
      paramFloat2 = paramString[1];
      f1 = paramString[2];
      f2 = paramString[3];
      f3 = paramString[4];
      f4 = paramString[5];
      float f12 = paramArrayOfFloat1.x;
      float f13 = paramArrayOfFloat1.y;
      float f8 = (1.0F - paramFloat1) / paramFloat2;
      float f9 = (1.0F - f1) / f2;
      float f10 = (1.0F - f3) / f4;
      float f11 = (1.0F - f12) / f13;
      f5 = paramFloat1 / paramFloat2;
      float f6 = f1 / f2;
      float f7 = f3 / f4;
      f12 /= f13;
      f8 = ((f11 - f8) * (f6 - f5) - (f12 - f5) * (f9 - f8)) / ((f10 - f8) * (f6 - f5) - (f9 - f8) * (f7 - f5));
      f5 = (f12 - f5 - (f7 - f5) * f8) / (f6 - f5);
      f6 = 1.0F - f5 - f8;
      f7 = f6 / paramFloat2;
      f9 = f5 / f2;
      f10 = f8 / f4;
      this.transform = new float[] { f7 * paramFloat1, f6, (1.0F - paramFloat1 - paramFloat2) * f7, f9 * f1, f5, (1.0F - f1 - f2) * f9, f10 * f3, f8, (1.0F - f3 - f4) * f10 };
      this.inverseTransform = d.h(this.transform);
      paramString = this.azW;
      paramFloat1 = this.min;
      paramFloat2 = this.max;
      f1 = a.j(paramString);
      paramArrayOfFloat1 = e.ayQ;
      if (f1 / a.j(e.ue()) > 0.9F)
      {
        paramArrayOfFloat1 = e.ayQ;
        paramArrayOfFloat1 = e.ud();
        paramm = new float[6];
        paramString[0] -= paramArrayOfFloat1[0];
        paramString[1] -= paramArrayOfFloat1[1];
        paramString[2] -= paramArrayOfFloat1[2];
        paramString[3] -= paramArrayOfFloat1[3];
        paramString[4] -= paramArrayOfFloat1[4];
        paramString[5] -= paramArrayOfFloat1[5];
        f1 = paramm[0];
        f2 = paramm[1];
        f3 = paramArrayOfFloat1[0];
        f4 = paramArrayOfFloat1[4];
        if (f1 * (paramArrayOfFloat1[1] - paramArrayOfFloat1[5]) - f2 * (f3 - f4) >= 0.0F)
        {
          f1 = paramArrayOfFloat1[0];
          f2 = paramArrayOfFloat1[2];
          f3 = paramArrayOfFloat1[1];
          f4 = paramArrayOfFloat1[3];
          f5 = paramm[0];
          if ((f1 - f2) * paramm[1] - (f3 - f4) * f5 >= 0.0F) {
            break label981;
          }
        }
        i = 0;
        label861:
        if (i != 0) {}
      }
      else
      {
        if ((paramFloat1 >= 0.0F) || (paramFloat2 <= 1.0F)) {
          break label1183;
        }
      }
    }
    label1183:
    for (boolean bool = true;; bool = false)
    {
      this.aAb = bool;
      this.aAc = a.a(this.azW, this.azU, paramb1, paramb2, this.min, this.max, paramInt);
      AppMethodBeat.o(206218);
      return;
      kotlin.a.k.a(paramArrayOfFloat1, paramString, 6, 6);
      break;
      label937:
      if (paramArrayOfFloat2.length != 9)
      {
        paramString = new IllegalArgumentException(s.X("Transform must have 9 entries! Has ", Integer.valueOf(paramArrayOfFloat2.length)));
        AppMethodBeat.o(206218);
        throw paramString;
      }
      this.transform = paramArrayOfFloat2;
      break label639;
      label981:
      f1 = paramm[2];
      f2 = paramm[3];
      f3 = paramArrayOfFloat1[2];
      f4 = paramArrayOfFloat1[0];
      if (f1 * (paramArrayOfFloat1[3] - paramArrayOfFloat1[1]) - f2 * (f3 - f4) >= 0.0F)
      {
        f1 = paramArrayOfFloat1[2];
        f2 = paramArrayOfFloat1[4];
        f3 = paramArrayOfFloat1[3];
        f4 = paramArrayOfFloat1[5];
        f5 = paramm[2];
        if ((f1 - f2) * paramm[3] - (f3 - f4) * f5 >= 0.0F) {}
      }
      else
      {
        i = 0;
        break label861;
      }
      f1 = paramm[4];
      f2 = paramm[5];
      f3 = paramArrayOfFloat1[4];
      f4 = paramArrayOfFloat1[2];
      if (f1 * (paramArrayOfFloat1[5] - paramArrayOfFloat1[3]) - f2 * (f3 - f4) >= 0.0F)
      {
        f1 = paramArrayOfFloat1[4];
        f2 = paramArrayOfFloat1[0];
        f3 = paramArrayOfFloat1[5];
        f4 = paramArrayOfFloat1[1];
        f5 = paramm[4];
        if ((f1 - f2) * paramm[5] - (f3 - f4) * f5 >= 0.0F)
        {
          i = 1;
          break label861;
        }
      }
      i = 0;
      break label861;
    }
  }
  
  public final float cM(int paramInt)
  {
    return this.min;
  }
  
  public final float cN(int paramInt)
  {
    return this.max;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(206268);
    if (this == paramObject)
    {
      AppMethodBeat.o(206268);
      return true;
    }
    if ((paramObject == null) || (!s.p(ai.cz(getClass()), ai.cz(paramObject.getClass()))))
    {
      AppMethodBeat.o(206268);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(206268);
      return false;
    }
    paramObject = (k)paramObject;
    if (Float.compare(paramObject.min, this.min) != 0)
    {
      AppMethodBeat.o(206268);
      return false;
    }
    if (Float.compare(paramObject.max, this.max) != 0)
    {
      AppMethodBeat.o(206268);
      return false;
    }
    if (!s.p(this.azU, paramObject.azU))
    {
      AppMethodBeat.o(206268);
      return false;
    }
    if (!Arrays.equals(this.azW, paramObject.azW))
    {
      AppMethodBeat.o(206268);
      return false;
    }
    if (this.azV != null)
    {
      bool = s.p(this.azV, paramObject.azV);
      AppMethodBeat.o(206268);
      return bool;
    }
    if (paramObject.azV == null)
    {
      AppMethodBeat.o(206268);
      return true;
    }
    if (!s.p(this.azX, paramObject.azX))
    {
      AppMethodBeat.o(206268);
      return false;
    }
    boolean bool = s.p(this.azZ, paramObject.azZ);
    AppMethodBeat.o(206268);
    return bool;
  }
  
  public final float[] f(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206261);
    s.u(paramArrayOfFloat, "v");
    paramArrayOfFloat[0] = ((float)((Number)this.aAa.invoke(Double.valueOf(paramArrayOfFloat[0]))).doubleValue());
    paramArrayOfFloat[1] = ((float)((Number)this.aAa.invoke(Double.valueOf(paramArrayOfFloat[1]))).doubleValue());
    paramArrayOfFloat[2] = ((float)((Number)this.aAa.invoke(Double.valueOf(paramArrayOfFloat[2]))).doubleValue());
    paramArrayOfFloat = d.c(this.transform, paramArrayOfFloat);
    AppMethodBeat.o(206261);
    return paramArrayOfFloat;
  }
  
  public final float[] g(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(206263);
    s.u(paramArrayOfFloat, "v");
    d.c(this.inverseTransform, paramArrayOfFloat);
    paramArrayOfFloat[0] = ((float)((Number)this.azY.invoke(Double.valueOf(paramArrayOfFloat[0]))).doubleValue());
    paramArrayOfFloat[1] = ((float)((Number)this.azY.invoke(Double.valueOf(paramArrayOfFloat[1]))).doubleValue());
    paramArrayOfFloat[2] = ((float)((Number)this.azY.invoke(Double.valueOf(paramArrayOfFloat[2]))).doubleValue());
    AppMethodBeat.o(206263);
    return paramArrayOfFloat;
  }
  
  public final int hashCode()
  {
    int k = 0;
    AppMethodBeat.i(206272);
    int m = super.hashCode();
    int n = this.azU.hashCode();
    int i1 = Arrays.hashCode(this.azW);
    int i;
    if (this.min == 0.0F)
    {
      i = 1;
      if (i != 0) {
        break label169;
      }
      i = Float.floatToIntBits(this.min);
      label55:
      if (this.max != 0.0F) {
        break label174;
      }
      j = 1;
      label66:
      if (j != 0) {
        break label179;
      }
    }
    label169:
    label174:
    label179:
    for (int j = Float.floatToIntBits(this.max);; j = 0)
    {
      if (this.azV != null) {
        k = this.azV.hashCode();
      }
      j = (j + (i + ((m * 31 + n) * 31 + i1) * 31) * 31) * 31 + k;
      i = j;
      if (this.azV == null) {
        i = (j * 31 + this.azX.hashCode()) * 31 + this.azZ.hashCode();
      }
      AppMethodBeat.o(206272);
      return i;
      i = 0;
      break;
      i = 0;
      break label55;
      j = 0;
      break label66;
    }
  }
  
  public final boolean uc()
  {
    return this.aAc;
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/colorspace/Rgb$Companion;", "", "()V", "DoubleIdentity", "Lkotlin/Function1;", "", "area", "", "primaries", "", "compare", "", "point", "a", "b", "computePrimaries", "toXYZ", "computePrimaries$ui_graphics_release", "computeWhitePoint", "Landroidx/compose/ui/graphics/colorspace/WhitePoint;", "computeXYZMatrix", "whitePoint", "contains", "p1", "p2", "cross", "ax", "ay", "bx", "by", "isSrgb", "OETF", "EOTF", "min", "max", "id", "", "isWideGamut", "xyPrimaries", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static boolean a(double paramDouble, kotlin.g.a.b<? super Double, Double> paramb1, kotlin.g.a.b<? super Double, Double> paramb2)
    {
      AppMethodBeat.i(206204);
      if (Math.abs(((Number)paramb1.invoke(Double.valueOf(paramDouble))).doubleValue() - ((Number)paramb2.invoke(Double.valueOf(paramDouble))).doubleValue()) <= 0.001D)
      {
        AppMethodBeat.o(206204);
        return true;
      }
      AppMethodBeat.o(206204);
      return false;
    }
    
    static boolean a(float[] paramArrayOfFloat, m paramm, kotlin.g.a.b<? super Double, Double> paramb1, kotlin.g.a.b<? super Double, Double> paramb2, float paramFloat1, float paramFloat2, int paramInt)
    {
      AppMethodBeat.i(206200);
      if (paramInt == 0)
      {
        AppMethodBeat.o(206200);
        return true;
      }
      Object localObject = e.ayQ;
      localObject = e.ud();
      s.u(paramArrayOfFloat, "a");
      s.u(localObject, "b");
      int j;
      if (paramArrayOfFloat != localObject)
      {
        j = paramArrayOfFloat.length - 1;
        if (j < 0) {}
      }
      int i;
      label281:
      for (paramInt = 0;; paramInt = i)
      {
        i = paramInt + 1;
        if ((Float.compare(paramArrayOfFloat[paramInt], localObject[paramInt]) != 0) && (Math.abs(paramArrayOfFloat[paramInt] - localObject[paramInt]) > 0.001F)) {}
        for (paramInt = 0; paramInt == 0; paramInt = 1)
        {
          AppMethodBeat.o(206200);
          return false;
          if (i <= j) {
            break label281;
          }
        }
        paramArrayOfFloat = g.azA;
        if (!d.a(paramm, g.uA()))
        {
          AppMethodBeat.o(206200);
          return false;
        }
        if (paramFloat1 == 0.0F) {}
        for (paramInt = 1; paramInt == 0; paramInt = 0)
        {
          AppMethodBeat.o(206200);
          return false;
        }
        if (paramFloat2 == 1.0F) {}
        for (paramInt = 1; paramInt == 0; paramInt = 0)
        {
          AppMethodBeat.o(206200);
          return false;
        }
        paramArrayOfFloat = e.ayQ;
        paramArrayOfFloat = e.uf();
        for (double d = 0.0D; d <= 1.0D; d += 0.00392156862745098D)
        {
          if (!a(d, paramb1, paramArrayOfFloat.azX))
          {
            AppMethodBeat.o(206200);
            return false;
          }
          if (!a(d, paramb2, paramArrayOfFloat.azZ))
          {
            AppMethodBeat.o(206200);
            return false;
          }
        }
        AppMethodBeat.o(206200);
        return true;
      }
    }
    
    static float j(float[] paramArrayOfFloat)
    {
      float f1 = paramArrayOfFloat[0];
      float f2 = paramArrayOfFloat[1];
      float f3 = paramArrayOfFloat[2];
      float f4 = paramArrayOfFloat[3];
      float f5 = paramArrayOfFloat[4];
      float f6 = paramArrayOfFloat[5];
      f2 = (f1 * f4 + f2 * f5 + f3 * f6 - f4 * f5 - f2 * f3 - f1 * f6) * 0.5F;
      f1 = f2;
      if (f2 < 0.0F) {
        f1 = -f2;
      }
      return f1;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "x"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<Double, Double>
  {
    c(k paramk)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "x"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<Double, Double>
  {
    d(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.a.k
 * JD-Core Version:    0.7.0.1
 */