import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.activity.ChatSettingForTroop.GetClassChoiceCallBack;
import com.tencent.mobileqq.troopinfo.GroupCatalogTool;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.qphone.base.util.QLog;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public class drg
  implements Runnable
{
  public drg(ChatSettingForTroop.GetClassChoiceCallBack paramGetClassChoiceCallBack, JSONObject paramJSONObject) {}
  
  public void run()
  {
    try
    {
      InputStream localInputStream = (InputStream)this.jdField_a_of_type_OrgJsonJSONObject.get("content");
      if ((localInputStream != null) && (GroupCatalogTool.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.a).a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.a, localInputStream)) && (this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.a.a != null))
      {
        GroupCatalogTool.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.a).b(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.a, Long.toString(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.a.a.a));
        GroupCatalogTool.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.a).a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.a, System.currentTimeMillis());
        boolean bool = GroupCatalogTool.a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.a).a(this.jdField_a_of_type_ComTencentMobileqqActivityChatSettingForTroop$GetClassChoiceCallBack.a);
        if ((!bool) && (QLog.isColorLevel())) {
          QLog.d("Q.chatopttroop", 2, "isMoveSuccess " + bool);
        }
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     drg
 * JD-Core Version:    0.7.0.1
 */