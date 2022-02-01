import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ModifyFriendInfoActivity;

public class ekr
  extends Handler
{
  public ekr(ModifyFriendInfoActivity paramModifyFriendInfoActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return;
      } while ((this.a.c == null) || (this.a.c.length() <= 0));
      this.a.b.setText(this.a.c);
      return;
    }
    this.a.a.setText(this.a.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ekr
 * JD-Core Version:    0.7.0.1
 */