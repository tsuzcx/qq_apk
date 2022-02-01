package androidx.core.g;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class aa
{
  private static Method btV;
  
  static
  {
    AppMethodBeat.i(195818);
    if (Build.VERSION.SDK_INT == 25) {
      try
      {
        btV = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
        AppMethodBeat.o(195818);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(195818);
  }
  
  public static float a(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    AppMethodBeat.i(195760);
    if (Build.VERSION.SDK_INT >= 26)
    {
      f = paramViewConfiguration.getScaledHorizontalScrollFactor();
      AppMethodBeat.o(195760);
      return f;
    }
    float f = c(paramViewConfiguration, paramContext);
    AppMethodBeat.o(195760);
    return f;
  }
  
  @Deprecated
  public static int a(ViewConfiguration paramViewConfiguration)
  {
    AppMethodBeat.i(195752);
    int i = paramViewConfiguration.getScaledPagingTouchSlop();
    AppMethodBeat.o(195752);
    return i;
  }
  
  public static float b(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    AppMethodBeat.i(195771);
    if (Build.VERSION.SDK_INT >= 26)
    {
      f = paramViewConfiguration.getScaledVerticalScrollFactor();
      AppMethodBeat.o(195771);
      return f;
    }
    float f = c(paramViewConfiguration, paramContext);
    AppMethodBeat.o(195771);
    return f;
  }
  
  public static int b(ViewConfiguration paramViewConfiguration)
  {
    AppMethodBeat.i(195793);
    if (Build.VERSION.SDK_INT >= 28)
    {
      i = paramViewConfiguration.getScaledHoverSlop();
      AppMethodBeat.o(195793);
      return i;
    }
    int i = paramViewConfiguration.getScaledTouchSlop() / 2;
    AppMethodBeat.o(195793);
    return i;
  }
  
  private static float c(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    AppMethodBeat.i(195785);
    float f;
    if ((Build.VERSION.SDK_INT >= 25) && (btV != null)) {
      try
      {
        int i = ((Integer)btV.invoke(paramViewConfiguration, new Object[0])).intValue();
        f = i;
        AppMethodBeat.o(195785);
        return f;
      }
      catch (Exception paramViewConfiguration) {}
    }
    paramViewConfiguration = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(16842829, paramViewConfiguration, true))
    {
      f = paramViewConfiguration.getDimension(paramContext.getResources().getDisplayMetrics());
      AppMethodBeat.o(195785);
      return f;
    }
    AppMethodBeat.o(195785);
    return 0.0F;
  }
  
  public static boolean d(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    AppMethodBeat.i(195806);
    if (Build.VERSION.SDK_INT >= 28)
    {
      boolean bool = paramViewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
      AppMethodBeat.o(195806);
      return bool;
    }
    paramViewConfiguration = paramContext.getResources();
    int i = paramViewConfiguration.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
    if ((i != 0) && (paramViewConfiguration.getBoolean(i)))
    {
      AppMethodBeat.o(195806);
      return true;
    }
    AppMethodBeat.o(195806);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.aa
 * JD-Core Version:    0.7.0.1
 */