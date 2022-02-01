package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class ai
{
  private static Method yP;
  
  static
  {
    AppMethodBeat.i(199571);
    if (Build.VERSION.SDK_INT >= 18) {
      try
      {
        Method localMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[] { Rect.class, Rect.class });
        yP = localMethod;
        if (!localMethod.isAccessible()) {
          yP.setAccessible(true);
        }
        AppMethodBeat.o(199571);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException) {}
    }
    AppMethodBeat.o(199571);
  }
  
  public static void a(View paramView, Rect paramRect1, Rect paramRect2)
  {
    AppMethodBeat.i(199538);
    if (yP != null) {
      try
      {
        yP.invoke(paramView, new Object[] { paramRect1, paramRect2 });
        AppMethodBeat.o(199538);
        return;
      }
      catch (Exception paramView) {}
    }
    AppMethodBeat.o(199538);
  }
  
  public static boolean s(View paramView)
  {
    AppMethodBeat.i(199523);
    if (z.U(paramView) == 1)
    {
      AppMethodBeat.o(199523);
      return true;
    }
    AppMethodBeat.o(199523);
    return false;
  }
  
  public static void t(View paramView)
  {
    AppMethodBeat.i(199555);
    if (Build.VERSION.SDK_INT >= 16) {
      try
      {
        Method localMethod = paramView.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
        if (!localMethod.isAccessible()) {
          localMethod.setAccessible(true);
        }
        localMethod.invoke(paramView, new Object[0]);
        AppMethodBeat.o(199555);
        return;
      }
      catch (NoSuchMethodException paramView)
      {
        AppMethodBeat.o(199555);
        return;
      }
      catch (InvocationTargetException paramView)
      {
        AppMethodBeat.o(199555);
        return;
      }
      catch (IllegalAccessException paramView) {}
    }
    AppMethodBeat.o(199555);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.ai
 * JD-Core Version:    0.7.0.1
 */