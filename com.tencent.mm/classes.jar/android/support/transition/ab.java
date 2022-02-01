package android.support.transition;

import android.animation.LayoutTransition;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ab
{
  private static LayoutTransition Dl;
  private static Field Dm;
  private static boolean Dn;
  private static Method Do;
  private static boolean Dp;
  
  private static void a(LayoutTransition paramLayoutTransition)
  {
    if (!Dp) {}
    try
    {
      Method localMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
      Do = localMethod;
      localMethod.setAccessible(true);
      label27:
      Dp = true;
      if (Do != null) {}
      try
      {
        Do.invoke(paramLayoutTransition, new Object[0]);
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
    if (Dl == null)
    {
      localObject = new LayoutTransition()
      {
        public final boolean isChangingLayout()
        {
          return true;
        }
      };
      Dl = (LayoutTransition)localObject;
      ((LayoutTransition)localObject).setAnimator(2, null);
      Dl.setAnimator(0, null);
      Dl.setAnimator(1, null);
      Dl.setAnimator(3, null);
      Dl.setAnimator(4, null);
    }
    if (paramBoolean)
    {
      localObject = paramViewGroup.getLayoutTransition();
      if (localObject != null)
      {
        if (((LayoutTransition)localObject).isRunning()) {
          a((LayoutTransition)localObject);
        }
        if (localObject != Dl) {
          paramViewGroup.setTag(2131306067, localObject);
        }
      }
      paramViewGroup.setLayoutTransition(Dl);
    }
    for (;;)
    {
      return;
      paramViewGroup.setLayoutTransition(null);
      if (!Dn) {}
      try
      {
        localObject = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
        Dm = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        label146:
        Dn = true;
        paramBoolean = bool2;
        if (Dm != null) {
          paramBoolean = bool1;
        }
        try
        {
          bool1 = Dm.getBoolean(paramViewGroup);
          paramBoolean = bool1;
          if (bool1)
          {
            paramBoolean = bool1;
            Dm.setBoolean(paramViewGroup, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.transition.ab
 * JD-Core Version:    0.7.0.1
 */