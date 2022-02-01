import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class erd
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public erd(QQBrowserActivity paramQQBrowserActivity, long paramLong) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.f = System.currentTimeMillis();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.M)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.loadUrl(this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.M);
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQBrowser", 2, "layout webivew width," + this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.getWidth() + " cost: " + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     erd
 * JD-Core Version:    0.7.0.1
 */