import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.Leba;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class ego
  extends Handler
{
  public ego(Leba paramLeba) {}
  
  public void handleMessage(Message paramMessage)
  {
    if ((this.a.app != null) && ("0".equals(this.a.app.a()))) {
      return;
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1134006: 
      this.a.c();
      return;
    case 11340002: 
      if (QLog.isColorLevel()) {
        QLog.d("Q.lebatab.leba", 2, "handler refresh leba config");
      }
      this.a.e();
      return;
    }
    Leba.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ego
 * JD-Core Version:    0.7.0.1
 */