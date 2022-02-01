import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class erp
  implements Runnable
{
  public erp(QQBrowserActivity paramQQBrowserActivity, int paramInt) {}
  
  public void run()
  {
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.a.edit();
    localEditor.putInt("webview_add_fav_guide_show_count", this.jdField_a_of_type_Int + 1);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     erp
 * JD-Core Version:    0.7.0.1
 */