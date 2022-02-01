import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import com.tencent.biz.widgets.XChooserActivity;

public class cri
  implements Runnable
{
  public cri(XChooserActivity paramXChooserActivity, ActivityInfo paramActivityInfo) {}
  
  public void run()
  {
    try
    {
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.getPreferences(0).edit();
      localEditor.putString(this.jdField_a_of_type_ComTencentBizWidgetsXChooserActivity.m, this.jdField_a_of_type_AndroidContentPmActivityInfo.applicationInfo.packageName + '/' + this.jdField_a_of_type_AndroidContentPmActivityInfo.name);
      localEditor.commit();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cri
 * JD-Core Version:    0.7.0.1
 */