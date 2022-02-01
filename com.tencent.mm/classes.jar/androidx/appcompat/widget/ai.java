package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ai
{
  private static Method xU;
  
  static
  {
    AppMethodBeat.i(242514);
    if (Build.VERSION.SDK_INT >= 18) {
      try
      {
        Method localMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[] { Rect.class, Rect.class });
        xU = localMethod;
        if (!localMethod.isAccessible()) {
          xU.setAccessible(true);
        }
        AppMethodBeat.o(242514);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException) {}
    }
    AppMethodBeat.o(242514);
  }
  
  public static void a(View paramView, Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(242512);
    if (xU != null) {
      try
      {
        xU.invoke(paramView, new Object[] { paramRect1, paramRect2 });
        AppMethodBeat.o(242512);
        return;
      }
      catch (Exception paramView) {}
    }
    AppMethodBeat.o(242512);
  }
  
  public static boolean s(View paramView)
  {
    AppMethodBeat.i(242511);
    if (w.I(paramView) == 1)
    {
      AppMethodBeat.o(242511);
      return true;
    }
    AppMethodBeat.o(242511);
    return false;
  }
  
  public static void t(View paramView)
  {
    AppMethodBeat.i(242513);
    if (Build.VERSION.SDK_INT >= 16) {
      try
      {
        Method localMethod = paramView.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        localMethod.invoke(paramView, new Object[0]);
        AppMethodBeat.o(242513);
        return;
      }
      catch (NoSuchMethodException paramView)
      {
        AppMethodBeat.o(242513);
        return;
      }
      catch (InvocationTargetException paramView)
      {
        AppMethodBeat.o(242513);
        return;
      }
      catch (IllegalAccessException paramView) {}
    }
    AppMethodBeat.o(242513);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.ai
 * JD-Core Version:    0.7.0.1
 */