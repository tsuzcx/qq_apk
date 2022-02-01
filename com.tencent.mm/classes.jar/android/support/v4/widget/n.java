package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class n
{
  private static Method UM;
  private static boolean UN;
  private static Field UO;
  private static boolean UQ;
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramPopupWindow.setWindowLayoutType(paramInt);
    }
    for (;;)
    {
      return;
      if (!UN) {}
      try
      {
        Method localMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
        UM = localMethod;
        localMethod.setAccessible(true);
        label47:
        UN = true;
        if (UM == null) {
          continue;
        }
        try
        {
          UM.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
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
      if (!UQ) {}
      try
      {
        Field localField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
        UO = localField;
        localField.setAccessible(true);
        label45:
        UQ = true;
        if (UO == null) {
          continue;
        }
        try
        {
          UO.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
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