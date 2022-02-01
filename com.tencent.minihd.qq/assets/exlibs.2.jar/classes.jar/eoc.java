import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class eoc
  implements Runnable
{
  public eoc(QQAppInterface paramQQAppInterface, String paramString) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ReportController", 4, "reportSettingStatusDaily run");
    }
    HashMap localHashMap = new HashMap();
    int i;
    label41:
    label65:
    label71:
    label95:
    label101:
    label125:
    Object localObject;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.e() == 1)
    {
      i = 1;
      if (i == 0) {
        break label472;
      }
      i = 1;
      localHashMap.put("Clk_notice_shake", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() != 1) {
        break label477;
      }
      i = 1;
      if (i == 0) {
        break label482;
      }
      i = 1;
      localHashMap.put("Clk_notice_grpshake", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d() != 1) {
        break label487;
      }
      i = 1;
      if (i == 0) {
        break label492;
      }
      i = 1;
      localHashMap.put("Clk_notice_sound", Integer.valueOf(i));
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b() != 1) {
        break label497;
      }
      i = 1;
      if (i == 0) {
        break label502;
      }
      i = 1;
      label131:
      localHashMap.put("Clk_notice_gupsound", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "no_disturb_mode", "qqsetting_nodisturb_mode_key", false)) {
        break label507;
      }
      i = 1;
      label163:
      localHashMap.put("Clk_night_mode", Integer.valueOf(i));
      if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.f()) {
        break label512;
      }
      i = 1;
      label186:
      localHashMap.put("Clk_hide_text", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366822), "qqsetting_notify_blncontrol_key", true)) {
        break label517;
      }
      i = 1;
      label231:
      localHashMap.put("Led_blinking", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131367905), "qqsetting_receivemsg_whenexit_key", true)) {
        break label522;
      }
      i = 1;
      label276:
      localHashMap.put("Logout_msg", Integer.valueOf(i));
      if (!SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131366826), "qqsetting_notify_myfeedpush_key", true)) {
        break label527;
      }
      i = 1;
      label321:
      localHashMap.put("Clk_about_me", Integer.valueOf(i));
      localObject = localHashMap.keySet();
      try
      {
        localObject = ((Set)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          String str2 = (String)((Iterator)localObject).next();
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliStatus", "", "", "Setting_tab", str2, 0, 0, String.valueOf(localHashMap.get(str2)), "", "", "");
        }
        boolean bool;
        str1 = "1";
      }
      catch (Exception localException)
      {
        bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), null, "qqsetting_pcactive_key", false);
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        if (!bool) {}
      }
    }
    for (;;)
    {
      ReportController.b((QQAppInterface)localObject, "CliStatus", "", "", "0X8004971", "0X8004971", 0, 0, str1, "", "", "");
      return;
      i = 0;
      break;
      label472:
      i = 0;
      break label41;
      label477:
      i = 0;
      break label65;
      label482:
      i = 0;
      break label71;
      label487:
      i = 0;
      break label95;
      label492:
      i = 0;
      break label101;
      label497:
      i = 0;
      break label125;
      label502:
      i = 0;
      break label131;
      label507:
      i = 0;
      break label163;
      label512:
      i = 0;
      break label186;
      label517:
      i = 0;
      break label231;
      label522:
      i = 0;
      break label276;
      label527:
      i = 0;
      break label321;
      String str1 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eoc
 * JD-Core Version:    0.7.0.1
 */