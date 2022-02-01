package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

final class ag
{
  private static final ak BH;
  private static Field BI;
  private static boolean BJ;
  static final Property<View, Float> BK;
  static final Property<View, Rect> BL;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22) {
      BH = new aj();
    }
    for (;;)
    {
      BK = new Property(Float.class, "translationAlpha") {};
      BL = new Property(Rect.class, "clipBounds") {};
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        BH = new ai();
      } else if (Build.VERSION.SDK_INT >= 19) {
        BH = new ah();
      } else {
        BH = new ak();
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
    return BH.O(paramView);
  }
  
  static void P(View paramView)
  {
    BH.P(paramView);
  }
  
  static void Q(View paramView)
  {
    BH.Q(paramView);
  }
  
  static void a(View paramView, Matrix paramMatrix)
  {
    BH.a(paramView, paramMatrix);
  }
  
  static void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    BH.b(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static void b(View paramView, Matrix paramMatrix)
  {
    BH.b(paramView, paramMatrix);
  }
  
  static void c(View paramView, Matrix paramMatrix)
  {
    BH.c(paramView, paramMatrix);
  }
  
  static void d(View paramView, float paramFloat)
  {
    BH.d(paramView, paramFloat);
  }
  
  static void m(View paramView, int paramInt)
  {
    if (!BJ) {}
    try
    {
      Field localField = View.class.getDeclaredField("mViewFlags");
      BI = localField;
      localField.setAccessible(true);
      label23:
      BJ = true;
      if (BI != null) {}
      try
      {
        int i = BI.getInt(paramView);
        BI.setInt(paramView, i & 0xFFFFFFF3 | paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.transition.ag
 * JD-Core Version:    0.7.0.1
 */