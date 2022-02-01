package com.tencent.mobileqq.statistics;

import android.content.Context;
import com.tencent.mobileqq.pluginsdk.IStatisticsUploader;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class PluginStatisticsCollector
  implements IStatisticsUploader
{
  private static final String a = "PluginStatisticsCollector";
  private static final String b = "actPluginInstallationFailure";
  private static final String c = "actPluginStartupFailure";
  private static final String d = "actPluginStartupResult";
  private static final String e = "plugin_name";
  private static final String f = "plugin_loc";
  private static final String g = "plugin_activity";
  private static final String h = "plugin_extra_info";
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("plugin_name", paramString2);
    localHashMap.put("plugin_extra_info", paramString3);
    if (QLog.isColorLevel()) {
      QLog.d("PluginStatisticsCollector", 2, "uploadInstallationFailure pluginName = " + paramString2 + ", errorInfo = " + paramString3);
    }
    StatisticCollector.a(paramContext).a(paramString1, "actPluginInstallationFailure", false, 0L, 0L, localHashMap, null);
  }
  
  public void uploadStartupFailure(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    boolean bool = false;
    if ("success".equals(paramString5)) {
      bool = true;
    }
    String str = paramString5;
    if (paramString5 != null)
    {
      str = paramString5;
      if (paramString5.contains(ClassNotFoundException.class.getName()))
      {
        float f1 = FileUtils.a();
        str = "GetAvailableInnernalMemorySize:" + f1 + "__" + paramString5;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PluginStatisticsCollector", 2, "uploadStartupFailure result = " + bool + ", pluginName = " + paramString2 + ", extraInfo = " + str);
    }
    if (!bool)
    {
      paramString5 = new HashMap();
      paramString5.put(BaseConstants.RDM_NoChangeFailCode, "");
      paramString5.put("plugin_name", paramString2);
      paramString5.put("plugin_loc", paramString3);
      paramString5.put("plugin_activity", paramString4);
      paramString5.put("plugin_extra_info", str);
      StatisticCollector.a(paramContext).a(paramString1, "actPluginStartupFailure", bool, 0L, 0L, paramString5, null);
    }
    paramString3 = new HashMap();
    paramString3.put(BaseConstants.RDM_NoChangeFailCode, "");
    paramString3.put("plugin_name", paramString2);
    StatisticCollector.a(paramContext).a(paramString1, "actPluginStartupResult", bool, 0L, 0L, paramString3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.PluginStatisticsCollector
 * JD-Core Version:    0.7.0.1
 */