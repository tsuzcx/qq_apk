package android.support.transition;

import android.animation.LayoutTransition;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ab
{
  private static LayoutTransition Av;
  private static Field Aw;
  private static boolean Ax;
  private static Method Ay;
  private static boolean Az;
  
  private static void a(LayoutTransition paramLayoutTransition)
  {
    if (!Az) {}
    try
    {
      Method localMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
      Ay = localMethod;
      localMethod.setAccessible(true);
      label27:
      Az = true;
      if (Ay != null) {}
      try
      {
        Ay.invoke(paramLayoutTransition, new Object[0]);
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
    if (Av == null)
    {
      localObject = new LayoutTransition()
      {
        public final boolean isChangingLayout()
        {
          return true;
        }
      };
      Av = (LayoutTransition)localObject;
      ((LayoutTransition)localObject).setAnimator(2, null);
      Av.setAnimator(0, null);
      Av.setAnimator(1, null);
      Av.setAnimator(3, null);
      Av.setAnimator(4, null);
    }
    if (paramBoolean)
    {
      localObject = paramViewGroup.getLayoutTransition();
      if (localObject != null)
      {
        if (((LayoutTransition)localObject).isRunning()) {
          a((LayoutTransition)localObject);
        }
        if (localObject != Av) {
          paramViewGroup.setTag(2131306067, localObject);
        }
      }
      paramViewGroup.setLayoutTransition(Av);
    }
    for (;;)
    {
      return;
      paramViewGroup.setLayoutTransition(null);
      if (!Ax) {}
      try
      {
        localObject = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
        Aw = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        label146:
        Ax = true;
        paramBoolean = bool2;
        if (Aw != null) {
          paramBoolean = bool1;
        }
        try
        {
          bool1 = Aw.getBoolean(paramViewGroup);
          paramBoolean = bool1;
          if (bool1)
          {
            paramBoolean = bool1;
            Aw.setBoolean(paramViewGroup, false);
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
        localObject = (LayoutTransition)paramViewGroup.getTag(2131306067);
        if (localObject == null) {
          continue;
        }
        paramViewGroup.setTag(2131306067, null);
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
 * Qualified Name:     android.support.transition.ab
 * JD-Core Version:    0.7.0.1
 */