package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.m;
import kotlin.v;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/FloatSpringSpec;", "Landroidx/compose/animation/core/FloatAnimationSpec;", "dampingRatio", "", "stiffness", "visibilityThreshold", "(FFF)V", "getDampingRatio", "()F", "spring", "Landroidx/compose/animation/core/SpringSimulation;", "getStiffness", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "getEndVelocity", "getValueFromNanos", "playTimeNanos", "getVelocityFromNanos", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
  implements ab
{
  public static final int Ue = 8;
  private final float UV;
  private final float UW;
  private final float UX;
  private final ao UY;
  
  public ad()
  {
    this(0.0F, 0.0F, 0.0F, 7);
  }
  
  public ad(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(203416);
    this.UV = paramFloat1;
    this.UW = paramFloat2;
    this.UX = paramFloat3;
    Object localObject = new ao();
    paramFloat1 = this.UV;
    if (paramFloat1 < 0.0F)
    {
      localObject = new IllegalArgumentException("Damping ratio must be non-negative");
      AppMethodBeat.o(203416);
      throw ((Throwable)localObject);
    }
    ((ao)localObject).UV = paramFloat1;
    ((ao)localObject).initialized = false;
    paramFloat1 = this.UW;
    if (((ao)localObject).lP() <= 0.0F)
    {
      localObject = new IllegalArgumentException("Spring stiffness constant must be positive.");
      AppMethodBeat.o(203416);
      throw ((Throwable)localObject);
    }
    ((ao)localObject).VQ = Math.sqrt(paramFloat1);
    ((ao)localObject).initialized = false;
    ah localah = ah.aiuX;
    this.UY = ((ao)localObject);
    AppMethodBeat.o(203416);
  }
  
  public final float a(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(203454);
    paramLong /= 1000000L;
    this.UY.VP = paramFloat2;
    paramLong = this.UY.a(paramFloat1, paramFloat3, paramLong);
    m localm = m.aiwV;
    paramFloat1 = Float.intBitsToFloat((int)(paramLong >> 32));
    AppMethodBeat.o(203454);
    return paramFloat1;
  }
  
  public final float b(long paramLong, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(203461);
    paramLong /= 1000000L;
    this.UY.VP = paramFloat2;
    paramLong = this.UY.a(paramFloat1, paramFloat3, paramLong);
    m localm = m.aiwV;
    paramFloat1 = Float.intBitsToFloat((int)(paramLong & 0xFFFFFFFF));
    AppMethodBeat.o(203461);
    return paramFloat1;
  }
  
  public final float d(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return 0.0F;
  }
  
  public final long e(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(203484);
    float f1 = this.UY.lP();
    float f2 = this.UY.UV;
    paramFloat1 = (paramFloat1 - paramFloat2) / this.UX;
    paramFloat2 = paramFloat3 / this.UX;
    double d4 = f1;
    double d2 = f2;
    double d1 = paramFloat2;
    double d3 = paramFloat1;
    double d5 = 2.0D * d2 * Math.sqrt(d4);
    double d6 = -d5;
    Object localObject1 = r.n(d5 * d5 - 4.0D * d4);
    ((q)localObject1).UE = (d6 + ((q)localObject1).UE);
    ((q)localObject1).UE /= 2.0D;
    ((q)localObject1).UF /= 2.0D;
    d6 = -d5;
    Object localObject2 = r.n(d5 * d5 - d4 * 4.0D);
    ((q)localObject2).UE *= -1.0D;
    ((q)localObject2).UF *= -1.0D;
    ((q)localObject2).UE += d6;
    ((q)localObject2).UE /= 2.0D;
    ((q)localObject2).UF /= 2.0D;
    localObject1 = v.Y(localObject1, localObject2);
    if (d3 == 0.0D)
    {
      i = 1;
      if (i == 0) {
        break label291;
      }
      if (d1 != 0.0D) {
        break label285;
      }
      i = 1;
      label259:
      if (i == 0) {
        break label291;
      }
    }
    label902:
    for (long l = 0L;; l = (1000.0D * d2))
    {
      AppMethodBeat.o(203484);
      return l * 1000000L;
      i = 0;
      break;
      label285:
      i = 0;
      break label259;
      label291:
      if (d3 < 0.0D)
      {
        d1 = -d1;
        d5 = Math.abs(d3);
        if (d2 <= 1.0D) {
          break label836;
        }
        d4 = ((q)((kotlin.r)localObject1).bsC).UE;
        d6 = ((q)((kotlin.r)localObject1).bsD).UE;
        d7 = (d4 * d5 - d1) / (d4 - d6);
        d5 -= d7;
        d1 = Math.log(Math.abs(1.0D / d5)) / d4;
        d2 = Math.log(Math.abs(1.0D / d7)) / d6;
        if ((Double.isInfinite(d1)) || (Double.isNaN(d1))) {
          break label649;
        }
        i = 1;
        if (i != 0) {
          break label655;
        }
        i = 1;
        label423:
        if (i == 0) {
          break label661;
        }
        d1 = d2;
        label432:
        d2 = Math.log(d5 * d4 / (-d7 * d6)) / (d6 - d4);
        if ((!Double.isNaN(d2)) && (d2 > 0.0D)) {
          break label720;
        }
        d2 = -1.0D;
      }
      for (;;)
      {
        label415:
        localObject1 = (b)new an.c(d5, d4, d7, d6, d2);
        localObject2 = (b)new an.d(d5, d4, d7, d6);
        d2 = d1;
        if (Math.abs(((Number)((b)localObject1).invoke(Double.valueOf(d1))).doubleValue()) < 0.0001D) {
          break label902;
        }
        d3 = 1.7976931348623157E+308D;
        i = 0;
        for (;;)
        {
          d2 = d1;
          if (d3 <= 0.001D) {
            break;
          }
          d2 = d1;
          if (i >= 100) {
            break;
          }
          d2 = d1 - ((Number)((b)localObject1).invoke(Double.valueOf(d1))).doubleValue() / ((Number)((b)localObject2).invoke(Double.valueOf(d1))).doubleValue();
          d3 = Math.abs(d1 - d2);
          i += 1;
          d1 = d2;
        }
        break;
        label649:
        i = 0;
        break label415;
        label655:
        i = 0;
        break label423;
        label661:
        if ((!Double.isInfinite(d2)) && (!Double.isNaN(d2)))
        {
          i = 1;
          label680:
          if (i != 0) {
            break label702;
          }
        }
        label702:
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label708;
          }
          break;
          i = 0;
          break label680;
        }
        label708:
        d1 = Math.max(d1, d2);
        break label432;
        label720:
        if (d2 > 0.0D)
        {
          d3 = Math.exp(d4 * d2);
          if (-(Math.exp(d2 * d6) * d7 + d3 * d5) < 1.0D)
          {
            d2 = d1;
            if (d7 > 0.0D)
            {
              d2 = d1;
              if (d5 < 0.0D) {
                d2 = 0.0D;
              }
            }
            d3 = -1.0D;
            d1 = d2;
            d2 = d3;
            continue;
          }
        }
        d1 = Math.log(-(d7 * d6 * d6) / (d5 * d4 * d4)) / (d4 - d6);
        d2 = 1.0D;
      }
      label836:
      if (d2 >= 1.0D) {
        break label914;
      }
      d2 = ((q)((kotlin.r)localObject1).bsC).UE;
      d1 = (d1 - d2 * d5) / ((q)((kotlin.r)localObject1).bsC).UF;
      d2 = Math.log(1.0D / Math.sqrt(d1 * d1 + d5 * d5)) / d2;
    }
    label914:
    d6 = ((q)((kotlin.r)localObject1).bsC).UE;
    double d7 = d1 - d6 * d5;
    d2 = Math.log(Math.abs(1.0D / d5)) / d6;
    d3 = Math.log(Math.abs(1.0D / d7));
    int i = 0;
    d1 = d3;
    int j;
    do
    {
      j = i + 1;
      d4 = d3 - Math.log(Math.abs(d1 / d6));
      i = j;
      d1 = d4;
    } while (j <= 5);
    d1 = d4 / d6;
    if ((!Double.isInfinite(d2)) && (!Double.isNaN(d2)))
    {
      i = 1;
      label1033:
      if (i != 0) {
        break label1224;
      }
      i = 1;
      label1041:
      if (i == 0) {
        break label1230;
      }
      label1046:
      d2 = -(d6 * d5 + d7) / (d6 * d7);
      if ((!Double.isNaN(d2)) && (d2 > 0.0D)) {
        break label1293;
      }
      d2 = -1.0D;
    }
    for (;;)
    {
      localObject1 = (b)new an.a(d5, d7, d6, d2);
      localObject2 = (b)new an.b(d7, d6, d5);
      i = 0;
      d3 = 1.7976931348623157E+308D;
      for (;;)
      {
        d2 = d1;
        if (d3 <= 0.001D) {
          break;
        }
        d2 = d1;
        if (i >= 100) {
          break;
        }
        d2 = d1 - ((Number)((b)localObject1).invoke(Double.valueOf(d1))).doubleValue() / ((Number)((b)localObject2).invoke(Double.valueOf(d1))).doubleValue();
        d3 = Math.abs(d1 - d2);
        i += 1;
        d1 = d2;
      }
      i = 0;
      break label1033;
      label1224:
      i = 0;
      break label1041;
      label1230:
      if ((!Double.isInfinite(d1)) && (!Double.isNaN(d1)))
      {
        i = 1;
        label1249:
        if (i != 0) {
          break label1275;
        }
      }
      label1275:
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label1281;
        }
        d1 = d2;
        break;
        i = 0;
        break label1249;
      }
      label1281:
      d1 = Math.max(d2, d1);
      break label1046;
      label1293:
      if (d2 > 0.0D)
      {
        d3 = Math.exp(d6 * d2);
        if (-(Math.exp(d2 * d6) * (d7 * d2) + d3 * d5) < 1.0D)
        {
          d2 = d1;
          if (d7 < 0.0D)
          {
            d2 = d1;
            if (d5 > 0.0D) {
              d2 = 0.0D;
            }
          }
          d3 = -1.0D;
          d1 = d2;
          d2 = d3;
          continue;
        }
      }
      d1 = -(2.0D / d6);
      d3 = d5 / d7;
      d2 = 1.0D;
      d1 -= d3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.ad
 * JD-Core Version:    0.7.0.1
 */