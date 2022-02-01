package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.AlphaAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.Animation;
import com.tencent.tencentmap.mapsdk.maps.model.AnimationSet;
import com.tencent.tencentmap.mapsdk.maps.model.EmergeAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.RotateAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.ScaleAnimation;
import com.tencent.tencentmap.mapsdk.maps.model.TranslateAnimation;
import java.util.Iterator;
import java.util.List;

public final class ic
{
  public static <A extends Animation> hd a(bm parambm, A paramA)
  {
    Object localObject1 = null;
    AppMethodBeat.i(226148);
    if ((parambm == null) || (paramA == null))
    {
      AppMethodBeat.o(226148);
      return null;
    }
    if ((paramA instanceof hd))
    {
      parambm = (hd)paramA;
      AppMethodBeat.o(226148);
      return parambm;
    }
    Object localObject2 = paramA.getClass();
    if (localObject2 == AlphaAnimation.class)
    {
      localObject1 = (AlphaAnimation)paramA;
      localObject1 = parambm.createAlphaAnimation(((AlphaAnimation)localObject1).mFromAlpha, ((AlphaAnimation)localObject1).mToAlpha);
    }
    for (;;)
    {
      if (localObject1 != null)
      {
        ((Animation)localObject1).setDuration(paramA.getDuration());
        ((Animation)localObject1).setInterpolator(paramA.getInterpolator());
        ((Animation)localObject1).setAnimationListener(paramA.getAnimationListener());
      }
      parambm = (hd)localObject1;
      AppMethodBeat.o(226148);
      return parambm;
      if (localObject2 == ScaleAnimation.class)
      {
        localObject1 = (ScaleAnimation)paramA;
        localObject1 = parambm.createScaleAnimation(((ScaleAnimation)localObject1).mFromX, ((ScaleAnimation)localObject1).mToX, ((ScaleAnimation)localObject1).mFromY, ((ScaleAnimation)localObject1).mToY);
      }
      else if (localObject2 == EmergeAnimation.class)
      {
        localObject1 = parambm.createEmergeAnimation(((EmergeAnimation)paramA).mStartPoint);
      }
      else if (localObject2 == AnimationSet.class)
      {
        localObject2 = (AnimationSet)paramA;
        localObject1 = parambm.createAnimationSet(((AnimationSet)localObject2).mShareInterpolator);
        localObject2 = ((AnimationSet)localObject2).mAnimations.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          hd localhd = a(parambm, (Animation)((Iterator)localObject2).next());
          ((he)localObject1).addAnimation(localhd);
        }
      }
      else if (localObject2 == RotateAnimation.class)
      {
        localObject1 = (RotateAnimation)paramA;
        localObject1 = parambm.createRotateAnimation(((RotateAnimation)localObject1).mFromDegree, ((RotateAnimation)localObject1).mToDegree, ((RotateAnimation)localObject1).mPivoteX, ((RotateAnimation)localObject1).mPivoteY, ((RotateAnimation)localObject1).mPivoteZ);
      }
      else if (localObject2 == TranslateAnimation.class)
      {
        localObject1 = parambm.createTranslateAnimation(((TranslateAnimation)paramA).mTargetLatLng);
      }
    }
  }
  
  public static double[] a(double paramDouble1, double paramDouble2)
  {
    double d1 = paramDouble1 + paramDouble2;
    double[] arrayOfDouble = new double[20];
    arrayOfDouble[9] = (paramDouble2 / 2.0D + paramDouble1);
    arrayOfDouble[19] = d1;
    paramDouble2 = paramDouble2 / 10.0D / 10.0D;
    double d2 = paramDouble2 / 2.0D;
    arrayOfDouble[0] = (paramDouble1 + d2);
    arrayOfDouble[18] = (d1 - d2);
    int i = 1;
    while (i < 9)
    {
      paramDouble1 = i * paramDouble2 + d2;
      arrayOfDouble[i] = (arrayOfDouble[(i - 1)] + paramDouble1);
      arrayOfDouble[(18 - i)] = (arrayOfDouble[(19 - i)] - paramDouble1);
      i += 1;
    }
    return arrayOfDouble;
  }
  
  private static double[] a(double paramDouble1, double paramDouble2, int paramInt)
  {
    AppMethodBeat.i(226117);
    double d3 = paramDouble1 + paramDouble2;
    double d4 = Math.abs(paramDouble2) / 2.0D;
    double d5 = Math.sqrt(4.0D * d4 / 3.141592653589793D);
    int i = paramInt >> 1;
    int j = i << 1;
    double[] arrayOfDouble = new double[j];
    arrayOfDouble[(i - 1)] = (paramDouble2 / 2.0D + paramDouble1);
    arrayOfDouble[(j - 1)] = d3;
    double d6 = d5 / i;
    paramInt = 0;
    while (paramInt < i - 1)
    {
      double d1 = d5 - (paramInt + 1) * d6;
      double d2 = Math.acos(d1 / d5);
      double d7 = Math.sin(d2);
      d2 = d2 * d4 * 2.0D / 3.141592653589793D - d1 * (d7 * d5) / 2.0D;
      d1 = d2;
      if (paramDouble2 < 0.0D) {
        d1 = -d2;
      }
      arrayOfDouble[paramInt] = (paramDouble1 + d1);
      arrayOfDouble[(j - 2 - paramInt)] = (d3 - d1);
      paramInt += 1;
    }
    AppMethodBeat.o(226117);
    return arrayOfDouble;
  }
  
  private static double[] b(double paramDouble1, double paramDouble2, int paramInt)
  {
    double[] arrayOfDouble = new double[paramInt];
    double d1 = 2.0D * paramDouble2 / paramInt / paramInt;
    double d2 = d1 / 2.0D;
    arrayOfDouble[(paramInt - 1)] = (paramDouble1 + paramDouble2);
    arrayOfDouble[0] = (paramDouble1 + d2);
    int i = 1;
    while (i < paramInt - 1)
    {
      arrayOfDouble[i] = (i * d1 + d2 + arrayOfDouble[(i - 1)]);
      i += 1;
    }
    return arrayOfDouble;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.ic
 * JD-Core Version:    0.7.0.1
 */