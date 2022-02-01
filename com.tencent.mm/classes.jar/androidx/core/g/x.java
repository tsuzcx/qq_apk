package androidx.core.g;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;

public final class x
{
  private static Method NP;
  
  static
  {
    AppMethodBeat.i(251800);
    if (Build.VERSION.SDK_INT == 25) {
      try
      {
        NP = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
        AppMethodBeat.o(251800);
        return;
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(251800);
  }
  
  public static float a(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    AppMethodBeat.i(251792);
    if (Build.VERSION.SDK_INT >= 26)
    {
      f = paramViewConfiguration.getScaledHorizontalScrollFactor();
      AppMethodBeat.o(251792);
      return f;
    }
    float f = c(paramViewConfiguration, paramContext);
    AppMethodBeat.o(251792);
    return f;
  }
  
  @Deprecated
  public static int a(ViewConfiguration paramViewConfiguration)
  {
    AppMethodBeat.i(251791);
    int i = paramViewConfiguration.getScaledPagingTouchSlop();
    AppMethodBeat.o(251791);
    return i;
  }
  
  public static float b(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    AppMethodBeat.i(251793);
    if (Build.VERSION.SDK_INT >= 26)
    {
      f = paramViewConfiguration.getScaledVerticalScrollFactor();
      AppMethodBeat.o(251793);
      return f;
    }
    float f = c(paramViewConfiguration, paramContext);
    AppMethodBeat.o(251793);
    return f;
  }
  
  public static int b(ViewConfiguration paramViewConfiguration)
  {
    AppMethodBeat.i(251796);
    if (Build.VERSION.SDK_INT >= 28)
    {
      i = paramViewConfiguration.getScaledHoverSlop();
      AppMethodBeat.o(251796);
      return i;
    }
    int i = paramViewConfiguration.getScaledTouchSlop() / 2;
    AppMethodBeat.o(251796);
    return i;
  }
  
  private static float c(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    AppMethodBeat.i(251795);
    float f;
    if ((Build.VERSION.SDK_INT >= 25) && (NP != null)) {
      try
      {
        int i = ((Integer)NP.invoke(paramViewConfiguration, new Object[0])).intValue();
        f = i;
        AppMethodBeat.o(251795);
        return f;
      }
      catch (Exception paramViewConfiguration) {}
    }
    paramViewConfiguration = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(16842829, paramViewConfiguration, true))
    {
      f = paramViewConfiguration.getDimension(paramContext.getResources().getDisplayMetrics());
      AppMethodBeat.o(251795);
      return f;
    }
    AppMethodBeat.o(251795);
    return 0.0F;
  }
  
  public static boolean d(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    AppMethodBeat.i(251799);
    if (Build.VERSION.SDK_INT >= 28)
    {
      boolean bool = paramViewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
      AppMethodBeat.o(251799);
      return bool;
    }
    paramViewConfiguration = paramContext.getResources();
    int i = paramViewConfiguration.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
    if ((i != 0) && (paramViewConfiguration.getBoolean(i)))
    {
      AppMethodBeat.o(251799);
      return true;
    }
    AppMethodBeat.o(251799);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.g.x
 * JD-Core Version:    0.7.0.1
 */