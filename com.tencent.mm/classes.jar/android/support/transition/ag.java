package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

final class ag
{
  private static Field DA;
  private static boolean DB;
  static final Property<View, Float> DC;
  static final Property<View, Rect> DD;
  private static final ak Dz;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22) {
      Dz = new aj();
    }
    for (;;)
    {
      DC = new Property(Float.class, "translationAlpha") {};
      DD = new Property(Rect.class, "clipBounds") {};
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        Dz = new ai();
      } else if (Build.VERSION.SDK_INT >= 19) {
        Dz = new ah();
      } else {
        Dz = new ak();
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
    return Dz.O(paramView);
  }
  
  static void P(View paramView)
  {
    Dz.P(paramView);
  }
  
  static void Q(View paramView)
  {
    Dz.Q(paramView);
  }
  
  static void a(View paramView, Matrix paramMatrix)
  {
    Dz.a(paramView, paramMatrix);
  }
  
  static void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Dz.b(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static void b(View paramView, Matrix paramMatrix)
  {
    Dz.b(paramView, paramMatrix);
  }
  
  static void c(View paramView, Matrix paramMatrix)
  {
    Dz.c(paramView, paramMatrix);
  }
  
  static void d(View paramView, float paramFloat)
  {
    Dz.d(paramView, paramFloat);
  }
  
  static void m(View paramView, int paramInt)
  {
    if (!DB) {}
    try
    {
      Field localField = View.class.getDeclaredField("mViewFlags");
      DA = localField;
      localField.setAccessible(true);
      label23:
      DB = true;
      if (DA != null) {}
      try
      {
        int i = DA.getInt(paramView);
        DA.setInt(paramView, i & 0xFFFFFFF3 | paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.ag
 * JD-Core Version:    0.7.0.1
 */