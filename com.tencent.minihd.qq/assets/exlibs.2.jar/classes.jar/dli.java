import android.app.Dialog;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

public final class dli
  implements Runnable
{
  public dli(Dialog paramDialog) {}
  
  public void run()
  {
    if (this.a.isShowing())
    {
      TextView localTextView = (TextView)this.a.findViewById(2131296765);
      AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.9F, 0.0F);
      localAlphaAnimation.setDuration(500L);
      localAlphaAnimation.setAnimationListener(new dlj(this));
      localTextView.startAnimation(localAlphaAnimation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dli
 * JD-Core Version:    0.7.0.1
 */