package android.support.transition;

import android.animation.LayoutTransition;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ap
  implements ar
{
  private static LayoutTransition tc;
  private static Field td;
  private static boolean te;
  private static Method tf;
  private static boolean tg;
  
  public void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject;
    if (tc == null)
    {
      localObject = new ap.1(this);
      tc = (LayoutTransition)localObject;
      ((LayoutTransition)localObject).setAnimator(2, null);
      tc.setAnimator(0, null);
      tc.setAnimator(1, null);
      tc.setAnimator(3, null);
      tc.setAnimator(4, null);
    }
    if (paramBoolean)
    {
      localObject = paramViewGroup.getLayoutTransition();
      if ((localObject != null) && ((((LayoutTransition)localObject).isRunning()) && (tg))) {}
    }
    try
    {
      Method localMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
      tf = localMethod;
      localMethod.setAccessible(true);
      label118:
      tg = true;
      if (tf != null) {}
      try
      {
        tf.invoke(localObject, new Object[0]);
        label141:
        if (localObject != tc) {
          paramViewGroup.setTag(z.a.transition_layout_save, localObject);
        }
        paramViewGroup.setLayoutTransition(tc);
        for (;;)
        {
          return;
          paramViewGroup.setLayoutTransition(null);
          if (!te) {}
          try
          {
            localObject = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
            td = (Field)localObject;
            ((Field)localObject).setAccessible(true);
            label197:
            te = true;
            paramBoolean = bool2;
            if (td != null) {
              paramBoolean = bool1;
            }
            try
            {
              bool1 = td.getBoolean(paramViewGroup);
              paramBoolean = bool1;
              if (bool1)
              {
                paramBoolean = bool1;
                td.setBoolean(paramViewGroup, false);
                paramBoolean = bool1;
              }
            }
            catch (IllegalAccessException localIllegalAccessException1)
            {
              label238:
              break label238;
            }
            if (paramBoolean) {
              paramViewGroup.requestLayout();
            }
            localObject = (LayoutTransition)paramViewGroup.getTag(z.a.transition_layout_save);
            if (localObject == null) {
              continue;
            }
            paramViewGroup.setTag(z.a.transition_layout_save, null);
            paramViewGroup.setLayoutTransition((LayoutTransition)localObject);
            return;
          }
          catch (NoSuchFieldException localNoSuchFieldException)
          {
            break label197;
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
  
  public an d(ViewGroup paramViewGroup)
  {
    return (al)as.E(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.ap
 * JD-Core Version:    0.7.0.1
 */