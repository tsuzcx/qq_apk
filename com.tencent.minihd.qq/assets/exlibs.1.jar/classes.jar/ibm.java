import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DateEventMsgActivity;
import com.tencent.mobileqq.dating.DatingFeedActivity;
import com.tencent.mobileqq.redtouch.RedTouchManager;

public class ibm
  implements View.OnClickListener
{
  public ibm(DatingFeedActivity paramDatingFeedActivity) {}
  
  public void onClick(View paramView)
  {
    DateEventMsgActivity.a(this.a, 2);
    paramView = (RedTouchManager)this.a.app.getManager(35);
    paramView.b(String.valueOf("100510.100511"));
    paramView.b(String.valueOf(100510));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibm
 * JD-Core Version:    0.7.0.1
 */