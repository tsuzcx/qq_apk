import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionInfoCardActivity;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;

public class dvm
  implements View.OnClickListener
{
  public dvm(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onClick(View paramView)
  {
    ChatBackground.b(this.a, this.a.app.getAccount(), DiscussionInfoCardActivity.a(this.a), "null");
    QQToast.a(this.a, 2131367510, 0).a();
    DiscussionInfoCardActivity.a(this.a).setText(2131370018);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dvm
 * JD-Core Version:    0.7.0.1
 */