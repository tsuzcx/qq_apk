package androidx.transition;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class aj
  extends am
{
  private static Method atf;
  private static boolean atg;
  private static Method ath;
  private static boolean ati;
  
  public final float bO(View paramView)
  {
    AppMethodBeat.i(193263);
    if (!ati) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
      ath = localMethod;
      localMethod.setAccessible(true);
      label32:
      ati = true;
      if (ath != null) {
        try
        {
          f = ((Float)ath.invoke(paramView, new Object[0])).floatValue();
          AppMethodBeat.o(193263);
          return f;
        }
        catch (InvocationTargetException paramView)
        {
          paramView = new RuntimeException(paramView.getCause());
          AppMethodBeat.o(193263);
          throw paramView;
        }
        catch (IllegalAccessException localIllegalAccessException) {}
      }
      float f = super.bO(paramView);
      AppMethodBeat.o(193263);
      return f;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label32;
    }
  }
  
  public final void bP(View paramView) {}
  
  public final void bQ(View paramView) {}
  
  public final void n(View paramView, float paramFloat)
  {
    AppMethodBeat.i(193260);
    if (!atg) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setTransitionAlpha", new Class[] { Float.TYPE });
      atf = localMethod;
      localMethod.setAccessible(true);
      label38:
      atg = true;
      if (atf != null) {
        try
        {
          atf.invoke(paramView, new Object[] { Float.valueOf(paramFloat) });
          AppMethodBeat.o(193260);
          return;
        }
        catch (IllegalAccessException paramView)
        {
          AppMethodBeat.o(193260);
          return;
        }
        catch (InvocationTargetException paramView)
        {
          paramView = new RuntimeException(paramView.getCause());
          AppMethodBeat.o(193260);
          throw paramView;
        }
      }
      paramView.setAlpha(paramFloat);
      AppMethodBeat.o(193260);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.transition.aj
 * JD-Core Version:    0.7.0.1
 */