package androidx.transition;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ae
{
  private static Method chA;
  private static boolean chB;
  
  private static void Mc()
  {
    AppMethodBeat.i(201637);
    if (!chB) {}
    try
    {
      Method localMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[] { Boolean.TYPE });
      chA = localMethod;
      localMethod.setAccessible(true);
      label38:
      chB = true;
      AppMethodBeat.o(201637);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label38;
    }
  }
  
  static void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(201625);
    Mc();
    if (chA != null) {
      try
      {
        chA.invoke(paramViewGroup, new Object[] { Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(201625);
        return;
      }
      catch (IllegalAccessException paramViewGroup)
      {
        AppMethodBeat.o(201625);
        return;
      }
      catch (InvocationTargetException paramViewGroup) {}
    }
    AppMethodBeat.o(201625);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.transition.ae
 * JD-Core Version:    0.7.0.1
 */