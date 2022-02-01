import android.os.Handler;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.activity.FilePreviewActivity;

class ike
  implements Runnable
{
  ike(ikb paramikb) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    String str = (String)this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.getText();
    if ((str == null) || (str.length() == 0)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.clearAnimation();
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFilePreviewActivity.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ike
 * JD-Core Version:    0.7.0.1
 */