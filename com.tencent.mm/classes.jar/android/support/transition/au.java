package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

final class au
{
  private static final ba uv;
  private static Field uw;
  private static boolean ux;
  static final Property<View, Float> uy;
  static final Property<View, Rect> uz;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22) {
      uv = new az();
    }
    for (;;)
    {
      uy = new au.1(Float.class, "translationAlpha");
      uz = new au.2(Rect.class, "clipBounds");
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        uv = new ay();
      } else if (Build.VERSION.SDK_INT >= 19) {
        uv = new ax();
      } else if (Build.VERSION.SDK_INT >= 18) {
        uv = new aw();
      } else {
        uv = new av();
      }
    }
  }
  
  static at J(View paramView)
  {
    return uv.J(paramView);
  }
  
  static be K(View paramView)
  {
    return uv.K(paramView);
  }
  
  static float L(View paramView)
  {
    return uv.L(paramView);
  }
  
  static void M(View paramView)
  {
    uv.M(paramView);
  }
  
  static void N(View paramView)
  {
    uv.N(paramView);
  }
  
  static void a(View paramView, Matrix paramMatrix)
  {
    uv.a(paramView, paramMatrix);
  }
  
  static void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    uv.b(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static void b(View paramView, Matrix paramMatrix)
  {
    uv.b(paramView, paramMatrix);
  }
  
  static void c(View paramView, Matrix paramMatrix)
  {
    uv.c(paramView, paramMatrix);
  }
  
  static void d(View paramView, float paramFloat)
  {
    uv.d(paramView, paramFloat);
  }
  
  static void l(View paramView, int paramInt)
  {
    if (!ux) {}
    try
    {
      Field localField = View.class.getDeclaredField("mViewFlags");
      uw = localField;
      localField.setAccessible(true);
      label23:
      ux = true;
      if (uw != null) {}
      try
      {
        int i = uw.getInt(paramView);
        uw.setInt(paramView, i & 0xFFFFFFF3 | paramInt);
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
 * Qualified Name:     android.support.transition.au
 * JD-Core Version:    0.7.0.1
 */