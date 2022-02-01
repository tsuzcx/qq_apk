package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ak
  extends aj
{
  private static Method chS;
  private static boolean chT;
  private static Method chU;
  private static boolean chV;
  private static Method chW;
  private static boolean chX;
  
  public final void a(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(201577);
    if (!chT) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[] { Matrix.class });
      chS = localMethod;
      localMethod.setAccessible(true);
      label37:
      chT = true;
      if (chS != null) {
        try
        {
          chS.invoke(paramView, new Object[] { paramMatrix });
          AppMethodBeat.o(201577);
          return;
        }
        catch (IllegalAccessException paramView)
        {
          AppMethodBeat.o(201577);
          return;
        }
        catch (InvocationTargetException paramView)
        {
          paramView = new RuntimeException(paramView.getCause());
          AppMethodBeat.o(201577);
          throw paramView;
        }
      }
      AppMethodBeat.o(201577);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label37;
    }
  }
  
  public final void b(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(201583);
    if (!chV) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[] { Matrix.class });
      chU = localMethod;
      localMethod.setAccessible(true);
      label37:
      chV = true;
      if (chU != null) {
        try
        {
          chU.invoke(paramView, new Object[] { paramMatrix });
          AppMethodBeat.o(201583);
          return;
        }
        catch (IllegalAccessException paramView)
        {
          AppMethodBeat.o(201583);
          return;
        }
        catch (InvocationTargetException paramView)
        {
          paramView = new RuntimeException(paramView.getCause());
          AppMethodBeat.o(201583);
          throw paramView;
        }
      }
      AppMethodBeat.o(201583);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label37;
    }
  }
  
  public final void c(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(201587);
    if (!chX) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setAnimationMatrix", new Class[] { Matrix.class });
      chW = localMethod;
      localMethod.setAccessible(true);
      label37:
      chX = true;
      if (chW != null) {
        try
        {
          chW.invoke(paramView, new Object[] { paramMatrix });
          AppMethodBeat.o(201587);
          return;
        }
        catch (InvocationTargetException paramView)
        {
          AppMethodBeat.o(201587);
          return;
        }
        catch (IllegalAccessException paramView)
        {
          paramView = new RuntimeException(paramView.getCause());
          AppMethodBeat.o(201587);
          throw paramView;
        }
      }
      AppMethodBeat.o(201587);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.transition.ak
 * JD-Core Version:    0.7.0.1
 */