import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.widget.XPanelContainer;

public class gcq
  implements Animation.AnimationListener
{
  public gcq(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    TroopChatPie.b(this.a).setBackgroundDrawable(this.a.a.a.a);
    this.a.f.setVisibility(8);
    this.a.d.setVisibility(8);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.f.setVisibility(0);
    TroopChatPie.d(this.a).setBackgroundResource(2130841806);
    TroopChatPie.a(this.a).setBackgroundResource(2130841714);
    int i = TroopChatPie.e(this.a).getResources().getDimensionPixelSize(2131492925);
    TroopChatPie.f(this.a).setPadding(i, 0, i, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gcq
 * JD-Core Version:    0.7.0.1
 */