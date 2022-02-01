package androidx.transition;

import android.animation.LayoutTransition;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ad
{
  private static LayoutTransition asM;
  private static Field asN;
  private static boolean asO;
  private static Method asP;
  private static boolean asQ;
  
  private static void a(LayoutTransition paramLayoutTransition)
  {
    AppMethodBeat.i(193142);
    if (!asQ) {}
    try
    {
      Method localMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
      asP = localMethod;
      localMethod.setAccessible(true);
      label32:
      asQ = true;
      if (asP != null) {
        try
        {
          asP.invoke(paramLayoutTransition, new Object[0]);
          AppMethodBeat.o(193142);
          return;
        }
        catch (IllegalAccessException paramLayoutTransition)
        {
          AppMethodBeat.o(193142);
          return;
        }
        catch (InvocationTargetException paramLayoutTransition) {}
      }
      AppMethodBeat.o(193142);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label32;
    }
  }
  
  static void c(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    AppMethodBeat.i(193135);
    Object localObject;
    if (asM == null)
    {
      localObject = new LayoutTransition()
      {
        public final boolean isChangingLayout()
        {
          return true;
        }
      };
      asM = (LayoutTransition)localObject;
      ((LayoutTransition)localObject).setAnimator(2, null);
      asM.setAnimator(0, null);
      asM.setAnimator(1, null);
      asM.setAnimator(3, null);
      asM.setAnimator(4, null);
    }
    if (paramBoolean)
    {
      localObject = paramViewGroup.getLayoutTransition();
      if (localObject != null)
      {
        if (((LayoutTransition)localObject).isRunning()) {
          a((LayoutTransition)localObject);
        }
        if (localObject != asM) {
          paramViewGroup.setTag(m.a.transition_layout_save, localObject);
        }
      }
      paramViewGroup.setLayoutTransition(asM);
      AppMethodBeat.o(193135);
      return;
    }
    paramViewGroup.setLayoutTransition(null);
    if (!asO) {}
    try
    {
      localObject = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
      asN = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      label157:
      asO = true;
      paramBoolean = bool2;
      if (asN != null) {
        paramBoolean = bool1;
      }
      try
      {
        bool1 = asN.getBoolean(paramViewGroup);
        paramBoolean = bool1;
        if (bool1)
        {
          paramBoolean = bool1;
          asN.setBoolean(paramViewGroup, false);
          paramBoolean = bool1;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        label197:
        break label197;
      }
      if (paramBoolean) {
        paramViewGroup.requestLayout();
      }
      localObject = (LayoutTransition)paramViewGroup.getTag(m.a.transition_layout_save);
      if (localObject != null)
      {
        paramViewGroup.setTag(m.a.transition_layout_save, null);
        paramViewGroup.setLayoutTransition((LayoutTransition)localObject);
      }
      AppMethodBeat.o(193135);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label157;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.transition.ad
 * JD-Core Version:    0.7.0.1
 */