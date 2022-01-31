package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.view.d;
import android.support.v4.view.q;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class l
{
  static final d Lo = new d();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      Lo = new c();
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Lo = new b();
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      Lo = new a();
      return;
    }
  }
  
  public static void a(PopupWindow paramPopupWindow, int paramInt)
  {
    Lo.a(paramPopupWindow, paramInt);
  }
  
  public static void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    Lo.a(paramPopupWindow, paramView, paramInt1, paramInt2, paramInt3);
  }
  
  public static void a(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    Lo.a(paramPopupWindow, paramBoolean);
  }
  
  static class a
    extends l.d
  {
    public final void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
    }
  }
  
  static class b
    extends l.a
  {
    private static Field Lp;
    
    static
    {
      try
      {
        Field localField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
        Lp = localField;
        localField.setAccessible(true);
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException) {}
    }
    
    public void a(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      if (Lp != null) {}
      try
      {
        Lp.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
        return;
      }
      catch (IllegalAccessException paramPopupWindow) {}
    }
  }
  
  static final class c
    extends l.b
  {
    public final void a(PopupWindow paramPopupWindow, int paramInt)
    {
      paramPopupWindow.setWindowLayoutType(paramInt);
    }
    
    public final void a(PopupWindow paramPopupWindow, boolean paramBoolean)
    {
      paramPopupWindow.setOverlapAnchor(paramBoolean);
    }
  }
  
  static class d
  {
    private static Method Lq;
    private static boolean Lr;
    
    public void a(PopupWindow paramPopupWindow, int paramInt)
    {
      if (!Lr) {}
      try
      {
        Method localMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[] { Integer.TYPE });
        Lq = localMethod;
        localMethod.setAccessible(true);
        label33:
        Lr = true;
        if (Lq != null) {}
        try
        {
          Lq.invoke(paramPopupWindow, new Object[] { Integer.valueOf(paramInt) });
          return;
        }
        catch (Exception paramPopupWindow) {}
      }
      catch (Exception localException)
      {
        break label33;
      }
    }
    
    public void a(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
    {
      int i = paramInt1;
      if ((d.getAbsoluteGravity(paramInt3, q.Q(paramView)) & 0x7) == 5) {
        i = paramInt1 - (paramPopupWindow.getWidth() - paramView.getWidth());
      }
      paramPopupWindow.showAsDropDown(paramView, i, paramInt2);
    }
    
    public void a(PopupWindow paramPopupWindow, boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.widget.l
 * JD-Core Version:    0.7.0.1
 */