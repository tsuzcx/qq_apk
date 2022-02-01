package com.tencent.mobileqq.startup.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class UpdatePluginVersion
  extends Step
{
  private static final String jdField_a_of_type_JavaLangString = "update_plugin_version";
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString;
  private static final String c = "cur_version";
  
  static
  {
    a = new String[] { "qlink_plugin.apk", "secmsg_plugin.apk", "qqsmartdevice.apk" };
  }
  
  private void a(Context paramContext)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("UpdatePluginVersion", 2, "clearOldPlugin : " + a.length);
    }
    File localFile1 = PluginUtils.getPluginInstallDir(paramContext);
    paramContext = paramContext.getDir("plugin_info", 0);
    while (i < a.length)
    {
      Object localObject = a[i];
      File localFile2 = new File(localFile1, (String)localObject + ".cfg");
      boolean bool;
      if (localFile2.exists())
      {
        bool = localFile2.delete();
        if (QLog.isColorLevel()) {
          QLog.d("UpdatePluginVersion", 2, "clear cfg file." + bool);
        }
      }
      localFile2 = new File(localFile1, (String)localObject);
      if (localFile2.exists())
      {
        bool = localFile2.delete();
        if (QLog.isColorLevel()) {
          QLog.d("UpdatePluginVersion", 2, "clear plugin file." + bool);
        }
      }
      localObject = new File(paramContext, (String)localObject + ".cfg");
      if (((File)localObject).exists())
      {
        bool = ((File)localObject).delete();
        if (QLog.isColorLevel()) {
          QLog.d("UpdatePluginVersion", 2, "clear update cfg file." + bool);
        }
      }
      i += 1;
    }
  }
  
  protected boolean a()
  {
    Context localContext = BaseApplicationImpl.a.getApplicationContext();
    SharedPreferences localSharedPreferences = localContext.getSharedPreferences("update_plugin_version", 0);
    String str = localSharedPreferences.getString("cur_version", "");
    if (QLog.isColorLevel()) {
      QLog.d("UpdatePluginVersion", 2, "version, currentVersion :" + str + ", " + "2cb8ec");
    }
    if (!"2cb8ec".equals(str))
    {
      a(localContext);
      localSharedPreferences.edit().putString("cur_version", "2cb8ec").commit();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.UpdatePluginVersion
 * JD-Core Version:    0.7.0.1
 */