package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.widget.ImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class n
  implements o
{
  private static Method sd;
  private static boolean se;
  
  public final void a(ImageView paramImageView) {}
  
  public final void a(ImageView paramImageView, Animator paramAnimator) {}
  
  public final void a(ImageView paramImageView, Matrix paramMatrix)
  {
    if (!se) {}
    try
    {
      Method localMethod = ImageView.class.getDeclaredMethod("animateTransform", new Class[] { Matrix.class });
      sd = localMethod;
      localMethod.setAccessible(true);
      label32:
      se = true;
      if (sd != null) {}
      try
      {
        sd.invoke(paramImageView, new Object[] { paramMatrix });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.transition.n
 * JD-Core Version:    0.7.0.1
 */