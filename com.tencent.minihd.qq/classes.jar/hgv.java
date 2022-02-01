import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.qphone.base.util.QLog;

class hgv
  implements Runnable
{
  hgv(hgu paramhgu) {}
  
  public void run()
  {
    if ((this.a.a.isBackground_Stop) && (BaseActivity.sTopActivity == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(BrowserAppInterface.b, 2, "no activity running, reboot for tbs now");
      }
      BrowserAppInterface.a(this.a.a, null);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d(BrowserAppInterface.b, 2, "activity still running, cannot reboot");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hgv
 * JD-Core Version:    0.7.0.1
 */