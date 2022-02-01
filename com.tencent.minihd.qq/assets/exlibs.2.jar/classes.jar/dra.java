import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class dra
  implements HttpWebCgiAsyncTask.Callback
{
  public dra(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    boolean bool = true;
    if (this.a.c) {}
    do
    {
      do
      {
        return;
        switch (paramInt)
        {
        default: 
          return;
        case 1: 
          if (QLog.isColorLevel()) {
            QLog.d("Q.chatopttroop", 2, "群活动清漫游小红点CGI回调,result:" + paramJSONObject);
          }
          break;
        }
      } while ((paramJSONObject == null) || (paramJSONObject.optInt("ec", 13) != 0));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.chatopttroop", 2, "GroupActivityCallback result: " + paramJSONObject);
      }
      if ((paramJSONObject == null) || (paramJSONObject.optInt("ec", 13) != 0)) {
        break;
      }
    } while (this.a.c);
    Object localObject2;
    String str;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.a) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.e())
      {
        paramBundle = "0";
        localObject1 = "Grp_Visdata";
        localObject2 = "";
        if (this.a.av == 1)
        {
          str = "Grp_Admin_data";
          if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m != 0) {
            break label301;
          }
        }
      }
    }
    label301:
    for (Object localObject1 = "0";; localObject1 = "1")
    {
      localObject2 = localObject1;
      localObject1 = str;
      ReportController.b(this.a.app, "P_CliOper", "Grp_set", "", (String)localObject1, "exp_ac", 0, 0, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, paramBundle, (String)localObject2, "");
      paramBundle = this.a.jdField_a_of_type_AndroidOsHandler.obtainMessage(17);
      paramBundle.obj = paramJSONObject;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramBundle);
      return;
      paramBundle = "1";
      break;
      paramBundle = "2";
      break;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m = 0;
    paramBundle = this.a.jdField_a_of_type_ArrayOfAndroidViewView[19];
    localObject1 = this.a;
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m != 0) {}
    for (;;)
    {
      ((ChatSettingForTroop)localObject1).a(paramBundle, 0, bool);
      DBUtils.a(this.a.app.a(), "group_activity_new_message", this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.chatopttroop", 2, "NullExcption: 群活动CGI回调的数据错误, result:" + paramJSONObject);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dra
 * JD-Core Version:    0.7.0.1
 */