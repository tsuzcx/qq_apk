import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.troop.activity.AudioRecordActivity;

public class kcq
  implements Animation.AnimationListener
{
  public kcq(AudioRecordActivity paramAudioRecordActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AudioRecordActivity.a(this.a).setBackgroundColor(1291845632);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kcq
 * JD-Core Version:    0.7.0.1
 */