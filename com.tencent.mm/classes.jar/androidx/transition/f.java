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
  static Class<?> cfp;
  private static boolean cfq;
  private static Method cfr;
  private static boolean cfs;
  static Method cft;
  static boolean cfu;
  private final View cfv;
  
  private f(View paramView)
  {
    this.cfv = paramView;
  }
  
  static void LP()
  {
    AppMethodBeat.i(201582);
    if (!cfq) {}
    try
    {
      cfp = Class.forName("android.view.GhostView");
      label19:
      cfq = true;
      AppMethodBeat.o(201582);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      break label19;
    }
  }
  
  static g a(View paramView, ViewGroup paramViewGroup, Matrix paramMatrix)
  {
    AppMethodBeat.i(201561);
    if (!cfs) {}
    try
    {
      LP();
      Method localMethod = cfp.getDeclaredMethod("addGhost", new Class[] { View.class, ViewGroup.class, Matrix.class });
      cfr = localMethod;
      localMethod.setAccessible(true);
      label51:
      cfs = true;
      if (cfr != null) {
        try
        {
          paramView = new f((View)cfr.invoke(null, new Object[] { paramView, paramViewGroup, paramMatrix }));
          AppMethodBeat.o(201561);
          return paramView;
        }
        catch (InvocationTargetException paramView)
        {
          paramView = new RuntimeException(paramView.getCause());
          AppMethodBeat.o(201561);
          throw paramView;
        }
        catch (IllegalAccessException paramView) {}
      }
      AppMethodBeat.o(201561);
      return null;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label51;
    }
  }
  
  public final void a(ViewGroup paramViewGroup, View paramView) {}
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(201591);
    this.cfv.setVisibility(paramInt);
    AppMethodBeat.o(201591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.transition.f
 * JD-Core Version:    0.7.0.1
 */