package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

final class ah
{
  private static final al DI;
  private static Field DJ;
  private static boolean DK;
  static final Property<View, Float> DL;
  static final Property<View, Rect> DM;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22) {
      DI = new ak();
    }
    for (;;)
    {
      DL = new Property(Float.class, "translationAlpha") {};
      DM = new Property(Rect.class, "clipBounds") {};
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        DI = new aj();
      } else if (Build.VERSION.SDK_INT >= 19) {
        DI = new ai();
      } else {
        DI = new al();
      }
    }
  }
  
  static ag N(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new af(paramView);
    }
    return ae.M(paramView);
  }
  
  static ap O(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return new ao(paramView);
    }
    return new an(paramView.getWindowToken());
  }
  
  static float P(View paramView)
  {
    return DI.P(paramView);
  }
  
  static void Q(View paramView)
  {
    DI.Q(paramView);
  }
  
  static void R(View paramView)
  {
    DI.R(paramView);
  }
  
  static void a(View paramView, Matrix paramMatrix)
  {
    DI.a(paramView, paramMatrix);
  }
  
  static void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    DI.b(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static void b(View paramView, Matrix paramMatrix)
  {
    DI.b(paramView, paramMatrix);
  }
  
  static void c(View paramView, Matrix paramMatrix)
  {
    DI.c(paramView, paramMatrix);
  }
  
  static void d(View paramView, float paramFloat)
  {
    DI.d(paramView, paramFloat);
  }
  
  static void m(View paramView, int paramInt)
  {
    if (!DK) {}
    try
    {
      Field localField = View.class.getDeclaredField("mViewFlags");
      DJ = localField;
      localField.setAccessible(true);
      label23:
      DK = true;
      if (DJ != null) {}
      try
      {
        int i = DJ.getInt(paramView);
        DJ.setInt(paramView, i & 0xFFFFFFF3 | paramInt);
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
 * Qualified Name:     android.support.transition.ah
 * JD-Core Version:    0.7.0.1
 */