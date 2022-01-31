package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class n
{
  private static Method KZ;
  private static boolean La;
  private static Field Lb;
  private static boolean Lc;
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramPopupWindow.setWindowLayoutType(paramInt);
    }
    for (;;)
    {
      return;
      if (!La) {}
      try
      {
        Method localMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
        KZ = localMethod;
        localMethod.setAccessible(true);
        label47:
        La = true;
        if (KZ == null) {
          continue;
        }
        try
        {
          KZ.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow) {}
      }
      catch (Exception localException)
      {
        break label47;
      }
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT < 21) {
        continue;
      }
      if (!Lc) {}
      try
      {
        Field localField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
        Lb = localField;
        localField.setAccessible(true);
        label45:
        Lc = true;
        if (Lb == null) {
          continue;
        }
        try
        {
          Lb.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
          return;
        }
        catch (IllegalAccessException paramPopupWindow) {}
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label45;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.n
 * JD-Core Version:    0.7.0.1
 */