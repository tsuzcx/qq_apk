import android.app.Dialog;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.phone.ContactListView;

public class gqd
  implements Animation.AnimationListener
{
  public gqd(ContactListView paramContactListView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    ContactListView.a(this.a).show();
    this.a.b.setAnimation(null);
    this.a.a.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gqd
 * JD-Core Version:    0.7.0.1
 */