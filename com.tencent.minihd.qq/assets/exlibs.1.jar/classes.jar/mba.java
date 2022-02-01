import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.IPluginManager;

public final class mba
  implements Runnable
{
  mba(QQAppInterface paramQQAppInterface, IPluginManager paramIPluginManager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QPlugin", 2, Thread.currentThread().getName() + "getFileThreadHandler" + Thread.currentThread().getPriority());
    }
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    int i = ((SharedPreferences)localObject).getInt("total_retried_times_QzoneVideoPlugin.apk", 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("total_retried_times_QzoneVideoPlugin.apk", i + 1);
    ((SharedPreferences.Editor)localObject).commit();
    if (i <= 3) {
      this.jdField_a_of_type_CooperationPluginIPluginManager.installPlugin("QzoneVideoPlugin.apk", new mbb(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     mba
 * JD-Core Version:    0.7.0.1
 */