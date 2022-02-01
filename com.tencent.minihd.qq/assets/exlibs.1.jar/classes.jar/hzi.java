import android.support.v4.util.LruCache;
import com.tencent.mobileqq.dating.AnchorageManager;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class hzi
  extends TimerTask
{
  public hzi(AnchorageManager paramAnchorageManager, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager.jdField_a_of_type_JavaLangString, 2, "autoRemoveAnchorage key:" + this.jdField_a_of_type_JavaLangString);
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager)
    {
      AnchorageManager.a(this.jdField_a_of_type_ComTencentMobileqqDatingAnchorageManager).remove(this.jdField_a_of_type_JavaLangString);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     hzi
 * JD-Core Version:    0.7.0.1
 */