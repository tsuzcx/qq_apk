package com.tencent.mobileqq.bubble;

import android.animation.TypeEvaluator;
import android.annotation.TargetApi;

@TargetApi(11)
public class PathPoint$PathEvaluator
  implements TypeEvaluator
{
  public PathPoint a(float paramFloat, PathPoint paramPathPoint1, PathPoint paramPathPoint2)
  {
    float f1;
    float f2;
    if (paramPathPoint2.jdField_d_of_type_Int == 2)
    {
      f1 = 1.0F - paramFloat;
      f2 = f1 * f1 * f1 * paramPathPoint1.a + 3.0F * f1 * f1 * paramFloat * paramPathPoint2.e + 3.0F * f1 * paramFloat * paramFloat * paramPathPoint2.g + paramFloat * paramFloat * paramFloat * paramPathPoint2.a;
      float f3 = paramPathPoint1.b;
      float f4 = paramPathPoint2.f;
      f1 = f1 * 3.0F * paramFloat * paramFloat * paramPathPoint2.h + (f1 * f1 * f1 * f3 + 3.0F * f1 * f1 * paramFloat * f4) + paramFloat * paramFloat * paramFloat * paramPathPoint2.b;
    }
    for (;;)
    {
      PathPoint localPathPoint = PathPoint.b(f2, f1);
      paramPathPoint1.jdField_d_of_type_Float += (paramPathPoint2.jdField_d_of_type_Float - paramPathPoint1.jdField_d_of_type_Float) * paramFloat;
      paramPathPoint1.c += (paramPathPoint2.c - paramPathPoint1.c) * paramFloat;
      return localPathPoint;
      if (paramPathPoint2.jdField_d_of_type_Int == 1)
      {
        f1 = paramPathPoint1.a;
        f2 = (paramPathPoint2.a - paramPathPoint1.a) * paramFloat + f1;
        f1 = paramPathPoint1.b + (paramPathPoint2.b - paramPathPoint1.b) * paramFloat;
      }
      else
      {
        f2 = paramPathPoint2.a;
        f1 = paramPathPoint2.b;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.PathPoint.PathEvaluator
 * JD-Core Version:    0.7.0.1
 */