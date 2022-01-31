package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public final class r
{
  private static Method Gp;
  
  static
  {
    if (Build.VERSION.SDK_INT == 25) {}
    try
    {
      Gp = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static float a(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramViewConfiguration.getScaledHorizontalScrollFactor();
    }
    return c(paramViewConfiguration, paramContext);
  }
  
  @Deprecated
  public static int a(ViewConfiguration paramViewConfiguration)
  {
    return paramViewConfiguration.getScaledPagingTouchSlop();
  }
  
  public static float b(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return paramViewConfiguration.getScaledVerticalScrollFactor();
    }
    return c(paramViewConfiguration, paramContext);
  }
  
  private static float c(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    if ((Build.VERSION.SDK_INT >= 25) && (Gp != null)) {
      try
      {
        int i = ((Integer)Gp.invoke(paramViewConfiguration, new Object[0])).intValue();
        return i;
      }
      catch (Exception paramViewConfiguration) {}
    }
    paramViewConfiguration = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(16842829, paramViewConfiguration, true)) {
      return paramViewConfiguration.getDimension(paramContext.getResources().getDisplayMetrics());
    }
    return 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.view.r
 * JD-Core Version:    0.7.0.1
 */