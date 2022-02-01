package cooperation.plugin;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PluginPreInstaller
{
  private static final int jdField_a_of_type_Int = 10;
  private static final String jdField_a_of_type_JavaLangString = PluginPreInstaller.class.getSimpleName();
  private static final SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "qlink_plugin.apk" };
  private static final int jdField_b_of_type_Int = 2;
  private static final String jdField_b_of_type_JavaLangString = "plugin_pre_install_qq_version";
  private static final String c = "total_retried_times_";
  private static final String d = "today_retried_times_";
  private static final String e = "last_retry_day_";
  private Context jdField_a_of_type_AndroidContentContext;
  private IPluginManager jdField_a_of_type_CooperationPluginIPluginManager;
  
  public PluginPreInstaller(Context paramContext, IPluginManager paramIPluginManager)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_CooperationPluginIPluginManager = paramIPluginManager;
    b();
  }
  
  private int a(String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).getInt("total_retried_times_" + paramString, 0);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit();
    Object localObject = new Date();
    localObject = jdField_a_of_type_JavaTextSimpleDateFormat.format((Date)localObject);
    localEditor.putInt("total_retried_times_" + paramString, paramInt1 + 1);
    localEditor.putInt("today_retried_times_" + paramString, paramInt2 + 1);
    localEditor.putString("last_retry_day_" + paramString, (String)localObject);
    localEditor.commit();
    this.jdField_a_of_type_CooperationPluginIPluginManager.a(paramString);
  }
  
  private int b(String paramString)
  {
    int i = 0;
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
    Date localDate = new Date();
    if (jdField_a_of_type_JavaTextSimpleDateFormat.format(localDate).equals(localSharedPreferences.getString("last_retry_day_" + paramString, ""))) {
      i = localSharedPreferences.getInt("today_retried_times_" + paramString, 0);
    }
    return i;
  }
  
  private void b()
  {
    if (!PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).getString("plugin_pre_install_qq_version", "").equals(DeviceInfoUtil.c()))
    {
      SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit();
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        localEditor.remove("total_retried_times_" + str);
        i += 1;
      }
      localEditor.commit();
    }
  }
  
  public void a()
  {
    String str;
    try
    {
      String[] arrayOfString = jdField_a_of_type_ArrayOfJavaLangString;
      int j = arrayOfString.length;
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label131;
        }
        str = arrayOfString[i];
        try
        {
          if (!this.jdField_a_of_type_CooperationPluginIPluginManager.isPlugininstalled(str))
          {
            int k = a(str);
            if (k < 10)
            {
              int m = b(str);
              if (m < 2) {
                a(str, k, m);
              }
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(jdField_a_of_type_JavaLangString, 2, "preinstall plugin : " + str + " failed.", localException);
            }
          }
        }
        i += 1;
      }
    }
    finally {}
    label131:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.plugin.PluginPreInstaller
 * JD-Core Version:    0.7.0.1
 */