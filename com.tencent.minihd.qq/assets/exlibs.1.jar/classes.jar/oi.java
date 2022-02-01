import com.qqreader.QRBridgeActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class oi
  extends MessageObserver
{
  public oi(QRBridgeActivity paramQRBridgeActivity) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if ((paramInt == 5002) && (paramBoolean))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("QPlugin", 4, "app getSessionKey has get");
      }
      this.a.app.c(this);
    }
    try
    {
      this.a.a();
      return;
    }
    catch (Exception paramObject)
    {
      paramObject.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     oi
 * JD-Core Version:    0.7.0.1
 */