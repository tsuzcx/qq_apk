import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatHistoryForC2C;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class dod
  extends Handler
{
  public dod(ChatHistoryForC2C paramChatHistoryForC2C) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      if ((this.a.a != null) && (this.a.a.isShowing())) {
        this.a.a.dismiss();
      }
      this.a.a = new QQProgressDialog(this.a, this.a.getTitleBarHeight());
      this.a.a.setCancelable(false);
      this.a.a.b(2131366714);
      this.a.a.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dod
 * JD-Core Version:    0.7.0.1
 */