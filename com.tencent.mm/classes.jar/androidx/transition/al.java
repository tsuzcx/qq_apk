package androidx.transition;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class al
  extends ak
{
  private static Method atp;
  private static boolean atq;
  
  public final void j(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(193292);
    if (!atq) {}
    try
    {
      Method localMethod = View.class.getDeclaredMethod("setLeftTopRightBottom", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE });
      atp = localMethod;
      localMethod.setAccessible(true);
      label59:
      atq = true;
      if (atp != null) {
        try
        {
          atp.invoke(paramView, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
          AppMethodBeat.o(193292);
          return;
        }
        catch (IllegalAccessException paramView)
        {
          AppMethodBeat.o(193292);
          return;
        }
        catch (InvocationTargetException paramView)
        {
          paramView = new RuntimeException(paramView.getCause());
          AppMethodBeat.o(193292);
          throw paramView;
        }
      }
      AppMethodBeat.o(193292);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label59;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.transition.al
 * JD-Core Version:    0.7.0.1
 */