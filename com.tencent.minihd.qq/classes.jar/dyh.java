import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.ForwardOperations;
import com.tencent.qphone.base.util.QLog;

public class dyh
  extends Handler
{
  public dyh(ForwardOperations paramForwardOperations, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      this.a.d();
      ForwardOperations.a(this.a, this.a.a());
      return;
    case 2: 
      this.a.d();
      return;
    }
    QLog.i("ForwardOperations", 2, "progress: " + paramMessage.arg1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     dyh
 * JD-Core Version:    0.7.0.1
 */