package androidx.compose.ui.e;

import android.graphics.Canvas;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/CanvasUtils;", "", "()V", "inorderBarrierMethod", "Ljava/lang/reflect/Method;", "orderMethodsFetched", "", "reorderBarrierMethod", "enableZ", "", "canvas", "Landroid/graphics/Canvas;", "enable", "ui-graphics_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
{
  public static final w awD;
  private static Method awE;
  private static Method awF;
  private static boolean awG;
  
  static
  {
    AppMethodBeat.i(205927);
    awD = new w();
    AppMethodBeat.o(205927);
  }
  
  public static void a(Canvas paramCanvas, boolean paramBoolean)
  {
    AppMethodBeat.i(205922);
    s.u(paramCanvas, "canvas");
    if (Build.VERSION.SDK_INT >= 29)
    {
      x.awH.a(paramCanvas, paramBoolean);
      AppMethodBeat.o(205922);
      return;
    }
    if (!awG) {}
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT != 28) {
          continue;
        }
        localMethod = Class.class.getDeclaredMethod("getDeclaredMethod", new Class[] { String.class, new Class[0].getClass() });
        awE = (Method)localMethod.invoke(Canvas.class, new Object[] { "insertReorderBarrier", (Object[])new Class[0] });
        awF = (Method)localMethod.invoke(Canvas.class, new Object[] { "insertInorderBarrier", (Object[])new Class[0] });
        localMethod = awE;
        if (localMethod != null) {
          localMethod.setAccessible(true);
        }
        localMethod = awF;
        if (localMethod != null) {
          localMethod.setAccessible(true);
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Method localMethod;
        continue;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        continue;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        continue;
      }
      awG = true;
      if (paramBoolean) {}
      try
      {
        if (awE != null)
        {
          localMethod = awE;
          s.checkNotNull(localMethod);
          localMethod.invoke(paramCanvas, new Object[0]);
        }
        if ((paramBoolean) || (awF == null)) {
          continue;
        }
        localMethod = awF;
        s.checkNotNull(localMethod);
        localMethod.invoke(paramCanvas, new Object[0]);
        AppMethodBeat.o(205922);
        return;
      }
      catch (IllegalAccessException paramCanvas)
      {
        AppMethodBeat.o(205922);
        return;
      }
      catch (InvocationTargetException paramCanvas)
      {
        AppMethodBeat.o(205922);
        return;
      }
      awE = Canvas.class.getDeclaredMethod("insertReorderBarrier", new Class[0]);
      awF = Canvas.class.getDeclaredMethod("insertInorderBarrier", new Class[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.w
 * JD-Core Version:    0.7.0.1
 */