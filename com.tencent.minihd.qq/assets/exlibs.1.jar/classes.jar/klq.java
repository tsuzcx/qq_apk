import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.troop.logic.VideoPlayLogic;

public class klq
  implements View.OnClickListener
{
  public klq(VideoPlayLogic paramVideoPlayLogic) {}
  
  public void onClick(View paramView)
  {
    if ((VideoPlayLogic.a(this.a) instanceof ChatActivity)) {
      ((ChatActivity)VideoPlayLogic.a(this.a)).a().V();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     klq
 * JD-Core Version:    0.7.0.1
 */