package androidx.transition;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ae
{
  private static Method asR;
  private static boolean asS;
  
  static void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    AppMethodBeat.i(193148);
    nz();
    if (asR != null) {
      try
      {
        asR.invoke(paramViewGroup, new Object[] { Boolean.valueOf(paramBoolean) });
        AppMethodBeat.o(193148);
        return;
      }
      catch (IllegalAccessException paramViewGroup)
      {
        AppMethodBeat.o(193148);
        return;
      }
      catch (InvocationTargetException paramViewGroup) {}
    }
    AppMethodBeat.o(193148);
  }
  
  private static void nz()
  {
    AppMethodBeat.i(193153);
    if (!asS) {}
    try
    {
      Method localMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[] { Boolean.TYPE });
      asR = localMethod;
      localMethod.setAccessible(true);
      label38:
      asS = true;
      AppMethodBeat.o(193153);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.transition.ae
 * JD-Core Version:    0.7.0.1
 */