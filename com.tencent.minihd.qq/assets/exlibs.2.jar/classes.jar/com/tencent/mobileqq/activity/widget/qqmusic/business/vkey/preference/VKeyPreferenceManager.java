package com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.preference;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.ApnManager;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import java.util.Vector;

public class VKeyPreferenceManager
{
  private static VKeyPreferenceManager jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyPreferenceVKeyPreferenceManager;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final String jdField_a_of_type_JavaLangString = "VKPFWIFI";
  private static final boolean jdField_a_of_type_Boolean = true;
  private static final String b = "VKPF2G3G";
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
  public Vector a;
  
  private VKeyPreferenceManager()
  {
    this.jdField_a_of_type_JavaUtilVector = new Vector();
  }
  
  public static VKeyPreferenceManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyPreferenceVKeyPreferenceManager == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyPreferenceVKeyPreferenceManager == null) {
        jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyPreferenceVKeyPreferenceManager = new VKeyPreferenceManager();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessVkeyPreferenceVKeyPreferenceManager;
    }
  }
  
  public VKeyPreference a()
  {
    for (;;)
    {
      int i;
      try
      {
        if ((ApnManager.a()) && (this.jdField_a_of_type_AndroidContentContext != null))
        {
          if (!ApnManager.b()) {
            break label187;
          }
          Object localObject1 = (WifiManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("wifi");
          if (localObject1 == null) {
            break label182;
          }
          try
          {
            localObject1 = ((WifiManager)localObject1).getConnectionInfo();
            if (localObject1 == null) {
              break label182;
            }
            localObject1 = ((WifiInfo)localObject1).getMacAddress();
            if (localObject1 == null) {
              break label182;
            }
            localObject1 = "VKPFWIFI" + ((String)localObject1).hashCode();
            if (localObject1 == null) {
              break label177;
            }
            i = 0;
            if (i < this.jdField_a_of_type_JavaUtilVector.size())
            {
              if (!((VKeyPreference)this.jdField_a_of_type_JavaUtilVector.get(i)).a.equals(localObject1)) {
                break label193;
              }
              localObject1 = (VKeyPreference)this.jdField_a_of_type_JavaUtilVector.get(i);
              return localObject1;
            }
          }
          catch (Exception localException)
          {
            MLog.d("liwei", "get wifi info fail.");
          }
          VKeyPreference localVKeyPreference = new VKeyPreference(localException, this.jdField_a_of_type_AndroidContentContext);
          this.jdField_a_of_type_JavaUtilVector.add(localVKeyPreference);
          continue;
        }
        str = null;
      }
      finally {}
      label177:
      continue;
      label182:
      String str = null;
      continue;
      label187:
      str = "VKPF2G3G";
      continue;
      label193:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.business.vkey.preference.VKeyPreferenceManager
 * JD-Core Version:    0.7.0.1
 */