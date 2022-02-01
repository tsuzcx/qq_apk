import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.SubLoginActivity;

public class fev
  extends Handler
{
  public fev(SubLoginActivity paramSubLoginActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1982: 
      this.a.finish();
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fev
 * JD-Core Version:    0.7.0.1
 */