import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.RegisterPhoneNumActivity;

public class exn
  extends Handler
{
  public exn(RegisterPhoneNumActivity paramRegisterPhoneNumActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     exn
 * JD-Core Version:    0.7.0.1
 */