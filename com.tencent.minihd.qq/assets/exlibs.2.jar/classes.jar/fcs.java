import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.SubAccountBindActivity;

public class fcs
  extends Handler
{
  public fcs(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1981: 
      this.a.finish();
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fcs
 * JD-Core Version:    0.7.0.1
 */