package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

final class ag
{
  private static final ak AJ;
  private static Field AK;
  private static boolean AL;
  static final Property<View, Float> AM;
  static final Property<View, Rect> AN;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22) {
      AJ = new aj();
    }
    for (;;)
    {
      AM = new Property(Float.class, "translationAlpha") {};
      AN = new Property(Rect.class, "clipBounds") {};
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        AJ = new ai();
      } else if (Build.VERSION.SDK_INT >= 19) {
        AJ = new ah();
      } else {
        AJ = new ak();
      }
    }
  }
  
  static af M(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new ae(paramView);
    }
    return ad.L(paramView);
  }
  
  static ao N(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new an(paramView);
    }
    return new am(paramView.getWindowToken());
  }
  
  static float O(View paramView)
  {
    return AJ.O(paramView);
  }
  
  static void P(View paramView)
  {
    AJ.P(paramView);
  }
  
  static void Q(View paramView)
  {
    AJ.Q(paramView);
  }
  
  static void a(View paramView, Matrix paramMatrix)
  {
    AJ.a(paramView, paramMatrix);
  }
  
  static void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AJ.b(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static void b(View paramView, Matrix paramMatrix)
  {
    AJ.b(paramView, paramMatrix);
  }
  
  static void c(View paramView, Matrix paramMatrix)
  {
    AJ.c(paramView, paramMatrix);
  }
  
  static void d(View paramView, float paramFloat)
  {
    AJ.d(paramView, paramFloat);
  }
  
  static void m(View paramView, int paramInt)
  {
    if (!AL) {}
    try
    {
      Field localField = View.class.getDeclaredField("mViewFlags");
      AK = localField;
      localField.setAccessible(true);
      label23:
      AL = true;
      if (AK != null) {}
      try
      {
        int i = AK.getInt(paramView);
        AK.setInt(paramView, i & 0xFFFFFFF3 | paramInt);
        return;
      }
      catch (IllegalAccessException paramView) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label23;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.ag
 * JD-Core Version:    0.7.0.1
 */