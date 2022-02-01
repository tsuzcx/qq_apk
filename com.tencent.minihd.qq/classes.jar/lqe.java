import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.core.push.BadgeUtilImpl;
import com.tencent.qphone.base.util.QLog;

public final class lqe
  implements Runnable
{
  public void run()
  {
    try
    {
      if (!BadgeUtilImpl.isEnabled(BaseApplicationImpl.a)) {
        BadgeUtilImpl.disableBadge(BaseApplicationImpl.a);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BadgeUtilImpl", 2, "disableBadge mobileqq", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     lqe
 * JD-Core Version:    0.7.0.1
 */