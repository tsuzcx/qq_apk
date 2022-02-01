package android.support.transition;

import android.animation.LayoutTransition;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ab
{
  private static LayoutTransition Bt;
  private static Field Bu;
  private static boolean Bv;
  private static Method Bw;
  private static boolean Bx;
  
  private static void a(LayoutTransition paramLayoutTransition)
  {
    if (!Bx) {}
    try
    {
      Method localMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
      Bw = localMethod;
      localMethod.setAccessible(true);
      label27:
      Bx = true;
      if (Bw != null) {}
      try
      {
        Bw.invoke(paramLayoutTransition, new Object[0]);
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
    if (Bt == null)
    {
      localObject = new LayoutTransition()
      {
        public final boolean isChangingLayout()
        {
          return true;
        }
      };
      Bt = (LayoutTransition)localObject;
      ((LayoutTransition)localObject).setAnimator(2, null);
      Bt.setAnimator(0, null);
      Bt.setAnimator(1, null);
      Bt.setAnimator(3, null);
      Bt.setAnimator(4, null);
    }
    if (paramBoolean)
    {
      localObject = paramViewGroup.getLayoutTransition();
      if (localObject != null)
      {
        if (((LayoutTransition)localObject).isRunning()) {
          a((LayoutTransition)localObject);
        }
        if (localObject != Bt) {
          paramViewGroup.setTag(2131306067, localObject);
        }
      }
      paramViewGroup.setLayoutTransition(Bt);
    }
    for (;;)
    {
      return;
      paramViewGroup.setLayoutTransition(null);
      if (!Bv) {}
      try
      {
        localObject = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
        Bu = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        label146:
        Bv = true;
        paramBoolean = bool2;
        if (Bu != null) {
          paramBoolean = bool1;
        }
        try
        {
          bool1 = Bu.getBoolean(paramViewGroup);
          paramBoolean = bool1;
          if (bool1)
          {
            paramBoolean = bool1;
            Bu.setBoolean(paramViewGroup, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.transition.ab
 * JD-Core Version:    0.7.0.1
 */