package android.support.transition;

import android.animation.LayoutTransition;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ac
{
  private static LayoutTransition Du;
  private static Field Dv;
  private static boolean Dw;
  private static Method Dx;
  private static boolean Dy;
  
  private static void a(LayoutTransition paramLayoutTransition)
  {
    if (!Dy) {}
    try
    {
      Method localMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
      Dx = localMethod;
      localMethod.setAccessible(true);
      label27:
      Dy = true;
      if (Dx != null) {}
      try
      {
        Dx.invoke(paramLayoutTransition, new Object[0]);
        return;
      }
      catch (InvocationTargetException paramLayoutTransition) {}catch (IllegalAccessException paramLayoutTransition) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label27;
    }
  }
  
  static void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject;
    if (Du == null)
    {
      localObject = new LayoutTransition()
      {
        public final boolean isChangingLayout()
        {
          return true;
        }
      };
      Du = (LayoutTransition)localObject;
      ((LayoutTransition)localObject).setAnimator(2, null);
      Du.setAnimator(0, null);
      Du.setAnimator(1, null);
      Du.setAnimator(3, null);
      Du.setAnimator(4, null);
    }
    if (paramBoolean)
    {
      localObject = paramViewGroup.getLayoutTransition();
      if (localObject != null)
      {
        if (((LayoutTransition)localObject).isRunning()) {
          a((LayoutTransition)localObject);
        }
        if (localObject != Du) {
          paramViewGroup.setTag(2131309396, localObject);
        }
      }
      paramViewGroup.setLayoutTransition(Du);
    }
    for (;;)
    {
      return;
      paramViewGroup.setLayoutTransition(null);
      if (!Dw) {}
      try
      {
        localObject = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
        Dv = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        label146:
        Dw = true;
        paramBoolean = bool2;
        if (Dv != null) {
          paramBoolean = bool1;
        }
        try
        {
          bool1 = Dv.getBoolean(paramViewGroup);
          paramBoolean = bool1;
          if (bool1)
          {
            paramBoolean = bool1;
            Dv.setBoolean(paramViewGroup, false);
            paramBoolean = bool1;
          }
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          label186:
          break label186;
        }
        if (paramBoolean) {
          paramViewGroup.requestLayout();
        }
        localObject = (LayoutTransition)paramViewGroup.getTag(2131309396);
        if (localObject == null) {
          continue;
        }
        paramViewGroup.setTag(2131309396, null);
        paramViewGroup.setLayoutTransition((LayoutTransition)localObject);
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        break label146;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.ac
 * JD-Core Version:    0.7.0.1
 */