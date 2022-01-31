package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.widget.ImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class n
  implements o
{
  private static Method rf;
  private static boolean rg;
  
  public final void a(ImageView paramImageView) {}
  
  public final void a(ImageView paramImageView, Animator paramAnimator) {}
  
  public final void a(ImageView paramImageView, Matrix paramMatrix)
  {
    if (!rg) {}
    try
    {
      Method localMethod = ImageView.class.getDeclaredMethod("animateTransform", new Class[] { Matrix.class });
      rf = localMethod;
      localMethod.setAccessible(true);
      label32:
      rg = true;
      if (rf != null) {}
      try
      {
        rf.invoke(paramImageView, new Object[] { paramMatrix });
        return;
      }
      catch (InvocationTargetException paramImageView)
      {
        throw new RuntimeException(paramImageView.getCause());
      }
      catch (IllegalAccessException paramImageView) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label32;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.transition.n
 * JD-Core Version:    0.7.0.1
 */