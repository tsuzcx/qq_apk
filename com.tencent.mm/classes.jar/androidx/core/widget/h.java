package androidx.core.widget;

import android.os.Build.VERSION;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.g.e;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class h
{
  private static Method bwT;
  private static boolean bwU;
  private static Field bwV;
  private static boolean bwW;
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    AppMethodBeat.i(195388);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramPopupWindow.setWindowLayoutType(paramInt);
      AppMethodBeat.o(195388);
      return;
    }
    if (!bwU) {}
    try
    {
      Method localMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
      bwT = localMethod;
      localMethod.setAccessible(true);
      label57:
      bwU = true;
      if (bwT != null) {
        try
        {
          bwT.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          AppMethodBeat.o(195388);
          return;
        }
        catch (Exception paramPopupWindow) {}
      }
      AppMethodBeat.o(195388);
      return;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(195364);
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
      AppMethodBeat.o(195364);
      return;
    }
    int i = paramInt1;
    if ((e.ay(paramInt3, z.U(paramView)) & 0x7) == 5) {
      i = paramInt1 - (paramPopupWindow.getWidth() - paramView.getWidth());
    }
    paramPopupWindow.showAsDropDown(paramView, i, paramInt2);
    AppMethodBeat.o(195364);
  }
  
  public static void a(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    AppMethodBeat.i(195377);
    if (Build.VERSION.SDK_INT >= 23)
    {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
      AppMethodBeat.o(195377);
      return;
    }
    if ((Build.VERSION.SDK_INT < 21) || (!bwW)) {}
    try
    {
      Field localField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
      bwV = localField;
      localField.setAccessible(true);
      label55:
      bwW = true;
      if (bwV != null) {
        try
        {
          bwV.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
          AppMethodBeat.o(195377);
          return;
        }
        catch (IllegalAccessException paramPopupWindow) {}
      }
      AppMethodBeat.o(195377);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label55;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.widget.h
 * JD-Core Version:    0.7.0.1
 */