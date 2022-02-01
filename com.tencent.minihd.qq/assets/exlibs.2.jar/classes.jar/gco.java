import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.widget.XPanelContainer;

public class gco
  implements Animation.AnimationListener
{
  public gco(TroopChatPie paramTroopChatPie) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    TroopChatPie.a(this.a).setBackgroundResource(2130839444);
    this.a.f.setVisibility(8);
    this.a.d.setVisibility(0);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    this.a.f.setVisibility(0);
    TroopChatPie.a(this.a).setBackgroundResource(2130839444);
    int i = TroopChatPie.b(this.a).getResources().getDimensionPixelSize(2131492925);
    TroopChatPie.c(this.a).setPadding(i, 0, i, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gco
 * JD-Core Version:    0.7.0.1
 */