import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.HotChatListActivity;
import com.tencent.widget.XListView;

public class eef
  extends Handler
{
  public eef(HotChatListActivity paramHotChatListActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.a.B();
    HotChatListActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eef
 * JD-Core Version:    0.7.0.1
 */