import com.tencent.mobileqq.app.ConditionSearchManager.IConfigListener;
import com.tencent.mobileqq.dating.DatingDestinationActivity;
import com.tencent.qphone.base.util.QLog;

public class iad
  implements ConditionSearchManager.IConfigListener
{
  public iad(DatingDestinationActivity paramDatingDestinationActivity) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DatingDestinationActivity", 2, "onGetConfig:" + paramInt + "   " + paramBoolean);
    }
    if (paramBoolean) {
      DatingDestinationActivity.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iad
 * JD-Core Version:    0.7.0.1
 */