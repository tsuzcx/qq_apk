import android.os.Looper;
import android.os.Message;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.util.WeakReferenceHandler;

public class era
  implements Runnable
{
  public era(QQBrowserActivity paramQQBrowserActivity, String paramString) {}
  
  public void run()
  {
    try
    {
      Thread.sleep(5000L);
      String str = HttpUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, MsfSdkUtils.insertMtype("Web", this.jdField_a_of_type_JavaLangString), "POST", null, null);
      if ((str == null) || ("".equals(str.trim())) || (QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity) == null)) {}
      synchronized (this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity)
      {
        if (QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity) == null) {
          QQBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, new WeakReferenceHandler(Looper.getMainLooper(), this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity));
        }
        Message.obtain(QQBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity), 100, str).sendToTarget();
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     era
 * JD-Core Version:    0.7.0.1
 */