package android.support.transition;

import android.animation.LayoutTransition;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ao
  implements aq
{
  private static LayoutTransition ue;
  private static Field uf;
  private static boolean ug;
  private static Method uh;
  private static boolean uj;
  
  public am c(ViewGroup paramViewGroup)
  {
    return (ak)ar.I(paramViewGroup);
  }
  
  public void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject;
    if (ue == null)
    {
      localObject = new ao.1(this);
      ue = (LayoutTransition)localObject;
      ((LayoutTransition)localObject).setAnimator(2, null);
      ue.setAnimator(0, null);
      ue.setAnimator(1, null);
      ue.setAnimator(3, null);
      ue.setAnimator(4, null);
    }
    if (paramBoolean)
    {
      localObject = paramViewGroup.getLayoutTransition();
      if ((localObject != null) && ((((LayoutTransition)localObject).isRunning()) && (uj))) {}
    }
    try
    {
      Method localMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
      uh = localMethod;
      localMethod.setAccessible(true);
      label118:
      uj = true;
      if (uh != null) {}
      try
      {
        uh.invoke(localObject, new Object[0]);
        label141:
        if (localObject != ue) {
          paramViewGroup.setTag(2131820683, localObject);
        }
        paramViewGroup.setLayoutTransition(ue);
        for (;;)
        {
          return;
          paramViewGroup.setLayoutTransition(null);
          if (!ug) {}
          try
          {
            localObject = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
            uf = (Field)localObject;
            ((Field)localObject).setAccessible(true);
            label196:
            ug = true;
            paramBoolean = bool2;
            if (uf != null) {
              paramBoolean = bool1;
            }
            try
            {
              bool1 = uf.getBoolean(paramViewGroup);
              paramBoolean = bool1;
              if (bool1)
              {
                paramBoolean = bool1;
                uf.setBoolean(paramViewGroup, false);
                paramBoolean = bool1;
              }
            }
            catch (IllegalAccessException localIllegalAccessException1)
            {
              label237:
              break label237;
            }
            if (paramBoolean) {
              paramViewGroup.requestLayout();
            }
            localObject = (LayoutTransition)paramViewGroup.getTag(2131820683);
            if (localObject == null) {
              continue;
            }
            paramViewGroup.setTag(2131820683, null);
            paramViewGroup.setLayoutTransition((LayoutTransition)localObject);
            return;
          }
          catch (NoSuchFieldException localNoSuchFieldException)
          {
            break label196;
          }
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        break label141;
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        break label141;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label118;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.transition.ao
 * JD-Core Version:    0.7.0.1
 */