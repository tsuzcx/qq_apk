package androidx.transition;

import android.animation.LayoutTransition;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ad
{
  private static LayoutTransition chv;
  private static Field chw;
  private static boolean chx;
  private static Method chy;
  private static boolean chz;
  
  private static void a(LayoutTransition paramLayoutTransition)
  {
    AppMethodBeat.i(201649);
    if (!chz) {}
    try
    {
      Method localMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
      chy = localMethod;
      localMethod.setAccessible(true);
      label32:
      chz = true;
      if (chy != null) {
        try
        {
          chy.invoke(paramLayoutTransition, new Object[0]);
          AppMethodBeat.o(201649);
          return;
        }
        catch (IllegalAccessException paramLayoutTransition)
        {
          AppMethodBeat.o(201649);
          return;
        }
        catch (InvocationTargetException paramLayoutTransition) {}
      }
      AppMethodBeat.o(201649);
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
    AppMethodBeat.i(201638);
    Object localObject;
    if (chv == null)
    {
      localObject = new LayoutTransition()
      {
        public final boolean isChangingLayout()
        {
          return true;
        }
      };
      chv = (LayoutTransition)localObject;
      ((LayoutTransition)localObject).setAnimator(2, null);
      chv.setAnimator(0, null);
      chv.setAnimator(1, null);
      chv.setAnimator(3, null);
      chv.setAnimator(4, null);
    }
    if (paramBoolean)
    {
      localObject = paramViewGroup.getLayoutTransition();
      if (localObject != null)
      {
        if (((LayoutTransition)localObject).isRunning()) {
          a((LayoutTransition)localObject);
        }
        if (localObject != chv) {
          paramViewGroup.setTag(m.a.transition_layout_save, localObject);
        }
      }
      paramViewGroup.setLayoutTransition(chv);
      AppMethodBeat.o(201638);
      return;
    }
    paramViewGroup.setLayoutTransition(null);
    if (!chx) {}
    try
    {
      localObject = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
      chw = (Field)localObject;
      ((Field)localObject).setAccessible(true);
      label157:
      chx = true;
      paramBoolean = bool2;
      if (chw != null) {
        paramBoolean = bool1;
      }
      try
      {
        bool1 = chw.getBoolean(paramViewGroup);
        paramBoolean = bool1;
        if (bool1)
        {
          paramBoolean = bool1;
          chw.setBoolean(paramViewGroup, false);
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
      AppMethodBeat.o(201638);
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label157;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.transition.ad
 * JD-Core Version:    0.7.0.1
 */