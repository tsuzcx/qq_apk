import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaListMgrActivity;

public class egw
  implements Runnable
{
  public egw(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void run()
  {
    LebaListMgrActivity.e(this.a).setVisibility(0);
    LebaListMgrActivity.f(this.a).setClickable(true);
    LebaListMgrActivity.g(this.a).setText("编辑");
    LebaListMgrActivity.h(this.a).setContentDescription("编辑 按钮");
    this.a.a = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     egw
 * JD-Core Version:    0.7.0.1
 */