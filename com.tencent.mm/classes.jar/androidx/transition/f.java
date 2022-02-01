package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class f
  implements g
{
  static Class<?> aqG;
  private static boolean aqH;
  private static Method aqI;
  private static boolean aqJ;
  static Method aqK;
  static boolean aqL;
  private final View aqM;
  
  private f(View paramView)
  {
    this.aqM = paramView;
  }
  
  static g a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    AppMethodBeat.i(192331);
    if (!aqJ) {}
    try
    {
      nm();
      Method localMethod = aqG.getDeclaredMethod("addGhost", new Class[] { View.class, ViewGroup.class, Matrix.class });
      aqI = localMethod;
      localMethod.setAccessible(true);
      label51:
      aqJ = true;
      if (aqI != null) {
        try
        {
          paramView = new f((View)aqI.invoke(null, new Object[] { paramView, paramViewGroup, paramMatrix }));
          AppMethodBeat.o(192331);
          return paramView;
        }
        catch (InvocationTargetException paramView)
        {
          paramView = new RuntimeException(paramView.getCause());
          AppMethodBeat.o(192331);
          throw paramView;
        }
        catch (IllegalAccessException paramView) {}
      }
      AppMethodBeat.o(192331);
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label51;
    }
  }
  
  static void nm()
  {
    AppMethodBeat.i(192334);
    if (!aqH) {}
    try
    {
      aqG = Class.forName("android.view.GhostView");
      label19:
      aqH = true;
      AppMethodBeat.o(192334);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label19;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, View paramView) {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(192333);
    this.aqM.setVisibility(paramInt);
    AppMethodBeat.o(192333);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.f
 * JD-Core Version:    0.7.0.1
 */