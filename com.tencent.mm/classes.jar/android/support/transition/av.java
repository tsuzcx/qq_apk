package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

final class av
{
  private static final bb tr;
  private static Field tt;
  private static boolean tu;
  static final Property<View, Float> tv;
  static final Property<View, Rect> tw;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 22) {
      tr = new ba();
    }
    for (;;)
    {
      tv = new av.1(Float.class, "translationAlpha");
      tw = new av.2(Rect.class, "clipBounds");
      return;
      if (Build.VERSION.SDK_INT >= 21) {
        tr = new az();
      } else if (Build.VERSION.SDK_INT >= 19) {
        tr = new ay();
      } else if (Build.VERSION.SDK_INT >= 18) {
        tr = new ax();
      } else {
        tr = new aw();
      }
    }
  }
  
  static au F(View paramView)
  {
    return tr.F(paramView);
  }
  
  static bf G(View paramView)
  {
    return tr.G(paramView);
  }
  
  static float H(View paramView)
  {
    return tr.H(paramView);
  }
  
  static void I(View paramView)
  {
    tr.I(paramView);
  }
  
  static void J(View paramView)
  {
    tr.J(paramView);
  }
  
  static void a(View paramView, Matrix paramMatrix)
  {
    tr.a(paramView, paramMatrix);
  }
  
  static void b(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    tr.b(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  static void b(View paramView, Matrix paramMatrix)
  {
    tr.b(paramView, paramMatrix);
  }
  
  static void c(View paramView, float paramFloat)
  {
    tr.c(paramView, paramFloat);
  }
  
  static void c(View paramView, Matrix paramMatrix)
  {
    tr.c(paramView, paramMatrix);
  }
  
  static void k(View paramView, int paramInt)
  {
    if (!tu) {}
    try
    {
      Field localField = View.class.getDeclaredField("mViewFlags");
      tt = localField;
      localField.setAccessible(true);
      label23:
      tu = true;
      if (tt != null) {}
      try
      {
        int i = tt.getInt(paramView);
        tt.setInt(paramView, i & 0xFFFFFFF3 | paramInt);
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
 * Qualified Name:     android.support.transition.av
 * JD-Core Version:    0.7.0.1
 */