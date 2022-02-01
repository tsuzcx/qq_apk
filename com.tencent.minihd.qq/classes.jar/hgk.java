import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class hgk
  implements Runnable
{
  public hgk(BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    BaseActivity.mShowGesture = false;
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "startUnlockActivity.mShowGesture set false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hgk
 * JD-Core Version:    0.7.0.1
 */