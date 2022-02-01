package androidx.transition;

import android.graphics.Matrix;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ak
  extends aj
{
  private static Method atj;
  private static boolean atk;
  private static Method atl;
  private static boolean atm;
  private static Method atn;
  private static boolean ato;
  
  public final void a(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(193269);
    if (!atk) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[] { Matrix.class });
      atj = localMethod;
      localMethod.setAccessible(true);
      label37:
      atk = true;
      if (atj != null) {
        try
        {
          atj.invoke(paramView, new Object[] { paramMatrix });
          AppMethodBeat.o(193269);
          return;
        }
        catch (IllegalAccessException paramView)
        {
          AppMethodBeat.o(193269);
          return;
        }
        catch (InvocationTargetException paramView)
        {
          paramView = new RuntimeException(paramView.getCause());
          AppMethodBeat.o(193269);
          throw paramView;
        }
      }
      AppMethodBeat.o(193269);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label37;
    }
  }
  
  public final void b(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(193271);
    if (!atm) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[] { Matrix.class });
      atl = localMethod;
      localMethod.setAccessible(true);
      label37:
      atm = true;
      if (atl != null) {
        try
        {
          atl.invoke(paramView, new Object[] { paramMatrix });
          AppMethodBeat.o(193271);
          return;
        }
        catch (IllegalAccessException paramView)
        {
          AppMethodBeat.o(193271);
          return;
        }
        catch (InvocationTargetException paramView)
        {
          paramView = new RuntimeException(paramView.getCause());
          AppMethodBeat.o(193271);
          throw paramView;
        }
      }
      AppMethodBeat.o(193271);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label37;
    }
  }
  
  public final void c(View paramView, Matrix paramMatrix)
  {
    AppMethodBeat.i(193278);
    if (!ato) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setAnimationMatrix", new Class[] { Matrix.class });
      atn = localMethod;
      localMethod.setAccessible(true);
      label37:
      ato = true;
      if (atn != null) {
        try
        {
          atn.invoke(paramView, new Object[] { paramMatrix });
          AppMethodBeat.o(193278);
          return;
        }
        catch (InvocationTargetException paramView)
        {
          AppMethodBeat.o(193278);
          return;
        }
        catch (IllegalAccessException paramView)
        {
          paramView = new RuntimeException(paramView.getCause());
          AppMethodBeat.o(193278);
          throw paramView;
        }
      }
      AppMethodBeat.o(193278);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label37;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.transition.ak
 * JD-Core Version:    0.7.0.1
 */