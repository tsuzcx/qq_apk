import android.widget.TextView;
import com.tencent.mobileqq.activity.LebaListMgrActivity;

public class ehg
  implements Runnable
{
  public ehg(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void run()
  {
    LebaListMgrActivity.a(this.a).setVisibility(4);
    LebaListMgrActivity.b(this.a).setClickable(true);
    LebaListMgrActivity.c(this.a).setText("完成");
    LebaListMgrActivity.d(this.a).setContentDescription("完成 按钮");
    this.a.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ehg
 * JD-Core Version:    0.7.0.1
 */