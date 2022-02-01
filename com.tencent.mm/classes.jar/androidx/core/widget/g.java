package androidx.core.widget;

import android.os.Build.VERSION;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class g
{
  private static Method QC;
  private static boolean QD;
  private static Field QE;
  private static boolean QF;
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    AppMethodBeat.i(253061);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramPopupWindow.setWindowLayoutType(paramInt);
      AppMethodBeat.o(253061);
      return;
    }
    if (!QD) {}
    try
    {
      Method localMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
      QC = localMethod;
      localMethod.setAccessible(true);
      label57:
      QD = true;
      if (QC != null) {
        try
        {
          QC.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(253061);
          return;
        }
        catch (Exception paramPopupWindow) {}
      }
      AppMethodBeat.o(253061);
      return;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    AppMethodBeat.i(253059);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
      AppMethodBeat.o(253059);
      return;
    }
    if ((Build.VERSION.SDK_INT < 21) || (!QF)) {}
    try
    {
      Field localField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
      QE = localField;
      localField.setAccessible(true);
      label55:
      QF = true;
      if (QE != null) {
        try
        {
          QE.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
          AppMethodBeat.o(253059);
          return;
        }
        catch (IllegalAccessException paramPopupWindow) {}
      }
      AppMethodBeat.o(253059);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label55;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.widget.g
 * JD-Core Version:    0.7.0.1
 */