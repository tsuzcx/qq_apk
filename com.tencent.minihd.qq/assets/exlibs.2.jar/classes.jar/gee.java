import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contact.CircleMemberListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;

public class gee
  extends Handler
{
  public gee(CircleMemberListActivity paramCircleMemberListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    int j;
    if (paramMessage.what == 1000)
    {
      i = CircleMemberListActivity.a(this.a).s();
      j = CircleMemberListActivity.a(this.a).t();
      if (i <= 0) {
        break label63;
      }
      i -= 1;
    }
    for (;;)
    {
      this.a.app.a(new gef(this, i, j - 1));
      return;
      label63:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gee
 * JD-Core Version:    0.7.0.1
 */