import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.widget.QQToast;

public class gyt
  extends Handler
{
  public gyt(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      QQToast.a(this.a, 2131369545, 0).a();
      return;
    case 2: 
      String str = this.a.getString(2131369546);
      paramMessage = (String)paramMessage.obj;
      QQToast.a(this.a, str + paramMessage, 0).a();
      return;
    }
    QQToast.a(this.a, 2131369547, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gyt
 * JD-Core Version:    0.7.0.1
 */