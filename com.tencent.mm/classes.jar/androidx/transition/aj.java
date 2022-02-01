package androidx.transition;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class aj
  extends am
{
  private static Method chO;
  private static boolean chP;
  private static Method chQ;
  private static boolean chR;
  
  public final float ci(View paramView)
  {
    AppMethodBeat.i(201564);
    if (!chR) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
      chQ = localMethod;
      localMethod.setAccessible(true);
      label32:
      chR = true;
      if (chQ != null) {
        try
        {
          f = ((Float)chQ.invoke(paramView, new Object[0])).floatValue();
          AppMethodBeat.o(201564);
          return f;
        }
        catch (InvocationTargetException paramView)
        {
          paramView = new RuntimeException(paramView.getCause());
          AppMethodBeat.o(201564);
          throw paramView;
        }
        catch (IllegalAccessException localIllegalAccessException) {}
      }
      float f = super.ci(paramView);
      AppMethodBeat.o(201564);
      return f;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label32;
    }
  }
  
  public final void cj(View paramView) {}
  
  public final void ck(View paramView) {}
  
  public final void o(View paramView, float paramFloat)
  {
    AppMethodBeat.i(201555);
    if (!chP) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setTransitionAlpha", new Class[] { Float.TYPE });
      chO = localMethod;
      localMethod.setAccessible(true);
      label38:
      chP = true;
      if (chO != null) {
        try
        {
          chO.invoke(paramView, new Object[] { Float.valueOf(paramFloat) });
          AppMethodBeat.o(201555);
          return;
        }
        catch (IllegalAccessException paramView)
        {
          AppMethodBeat.o(201555);
          return;
        }
        catch (InvocationTargetException paramView)
        {
          paramView = new RuntimeException(paramView.getCause());
          AppMethodBeat.o(201555);
          throw paramView;
        }
      }
      paramView.setAlpha(paramFloat);
      AppMethodBeat.o(201555);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.transition.aj
 * JD-Core Version:    0.7.0.1
 */