import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DPCConfigInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.ReflectedMethods;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class hit
  implements Runnable
{
  public hit(DeviceProfileManager paramDeviceProfileManager, ConfigurationService.RespGetConfig paramRespGetConfig, String paramString) {}
  
  public void run()
  {
    ConfigurationService.Config localConfig = (ConfigurationService.Config)this.jdField_a_of_type_ComTencentMobileqqConfigStructSplashprotoConfigurationService$RespGetConfig.config_list.get(0);
    Object localObject1 = localConfig.content_list;
    if (QLog.isColorLevel()) {
      QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "onDPCResponse is called, version=" + localConfig.version.get());
    }
    if (localObject1 != null) {}
    boolean bool1;
    int i;
    label107:
    Iterator localIterator;
    SharedPreferences.Editor localEditor2;
    SharedPreferences localSharedPreferences;
    SharedPreferences.Editor localEditor3;
    HashMap localHashMap;
    break label646;
    label264:
    Object localObject8;
    hiv localhiv;
    Object localObject7;
    SharedPreferences.Editor localEditor1;
    Object localObject6;
    label427:
    boolean bool2;
    for (;;)
    {
      try
      {
        if (((PBRepeatField)localObject1).size() != 0)
        {
          bool1 = TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString);
          if (!bool1) {}
        }
        else
        {
          return;
        }
        ??? = new HashMap();
        i = 0;
        if (i < ((PBRepeatField)localObject1).size())
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager.a((String)((PBRepeatField)localObject1).get(i), (HashMap)???))
          {
            if (QLog.isColorLevel()) {
              QLog.e(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "onDPCResponse parseDPCXML error, so return");
            }
            return;
          }
          i += 1;
          break label107;
        }
        localIterator = ((HashMap)???).entrySet().iterator();
        localEditor2 = ReflectedMethods.a(BaseApplicationImpl.getContext(), "dpcConfig").edit();
        localSharedPreferences = ReflectedMethods.a(BaseApplicationImpl.getContext(), "dpcConfig_account");
        localEditor3 = localSharedPreferences.edit();
        localObject1 = null;
        localObject7 = DeviceProfileManager.a().b;
      }
      catch (Exception localException) {}finally
      {
        this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager.a(4);
      }
      bool1 = true;
      ??? = DeviceProfileManager.AccountDpcManager.a(DeviceProfileManager.a(), (String)localObject8);
      localEditor1 = localEditor3;
      localObject6 = localObject3;
      if (QLog.isColorLevel()) {
        QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "onDPCResponse DPCXmlHandler.tempMap: key=" + (String)localObject8 + ", value=" + localhiv.toString() + ", isAccountName=" + bool1);
      }
      if (localObject6 != null)
      {
        DeviceProfileManager.DPCConfigInfo localDPCConfigInfo = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject6).get(???);
        bool1 = false;
        localObject8 = localDPCConfigInfo;
        if (localDPCConfigInfo == null)
        {
          bool1 = true;
          localObject7 = (DeviceProfileManager.DPCConfigInfo)((HashMap)localObject7).get(???);
          if (localObject7 != null) {
            localObject8 = (DeviceProfileManager.DPCConfigInfo)((DeviceProfileManager.DPCConfigInfo)localObject7).clone();
          }
        }
        else if (localObject8 != null)
        {
          if (QLog.isDevelopLevel()) {
            QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 4, "onDPCResponse tempFeatureMap old value: key=" + (String)??? + " " + localObject8 + ", isAddConfig=" + bool1);
          }
          bool2 = DeviceProfileManager.a((DeviceProfileManager.DPCConfigInfo)localObject8, localhiv.b.toString().trim());
          if (!bool1) {
            break label989;
          }
          ((HashMap)localObject6).put(???, localObject8);
          break label989;
        }
      }
    }
    for (;;)
    {
      localEditor1.putString((String)???, localhiv.b);
      label646:
      if (!QLog.isColorLevel()) {
        break label264;
      }
      QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "onDPCResponse tempFeatureMap new value: key=" + (String)??? + " " + localObject8 + ", isAddConfig=" + bool1 + ", hasUpdate=" + bool2);
      break label264;
      localObject7 = DeviceProfileManager.b(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager);
      bool1 = false;
      localObject6 = localHashMap;
      localEditor1 = localEditor2;
      ??? = localObject8;
      break label427;
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager)
      {
        DeviceProfileManager.a(this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager, localHashMap);
        if ((DeviceProfileManager.a() != null) && (DeviceProfileManager.a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.equals(DeviceProfileManager.a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) {
          DeviceProfileManager.a().jdField_a_of_type_JavaUtilHashMap = localObject3;
        }
        if (DeviceProfileManager.a() != null)
        {
          localEditor3.putLong(DeviceProfileManager.AccountDpcManager.a(DeviceProfileManager.a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "last_update_time"), System.currentTimeMillis());
          localEditor3.putInt(DeviceProfileManager.AccountDpcManager.a(DeviceProfileManager.a().jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "server_version"), localConfig.version.get());
        }
        i = localSharedPreferences.getInt("key_versioncode", 0);
        int j = ApkUtils.a(BaseApplicationImpl.getContext());
        if (i < j) {
          localEditor3.putInt("key_versioncode", j);
        }
        localEditor2.commit();
        localEditor3.commit();
        if (QLog.isColorLevel()) {
          QLog.d(DeviceProfileManager.jdField_a_of_type_JavaLangString, 2, "onDPCResponse KEY_LAST_UPDATE_TIME=" + System.currentTimeMillis() + ", versioncode=" + j + ", keyVersionCode =" + i);
        }
        this.jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager.a(4);
        return;
      }
      label989:
      if (!bool1) {
        if (!bool2) {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hit
 * JD-Core Version:    0.7.0.1
 */