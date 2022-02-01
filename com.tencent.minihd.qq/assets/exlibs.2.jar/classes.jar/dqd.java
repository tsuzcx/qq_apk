import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.ChatSettingForTroop;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopObserver;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import com.tencent.mobileqq.troopinfo.TroopUnreadMsgInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.List;

public class dqd
  extends TroopObserver
{
  public dqd(ChatSettingForTroop paramChatSettingForTroop) {}
  
  protected void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqDataTroopInfo.troopuin.equals(paramString1)) && (paramString2.equals(this.a.app.a()))) {
      this.a.a("", paramString3);
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, List paramList, int paramInt)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData == null) {}
    while ((!paramBoolean1) || (paramList == null) || (paramList.size() <= 0)) {
      return;
    }
    paramInt = 0;
    label31:
    TroopUnreadMsgInfo localTroopUnreadMsgInfo;
    if (paramInt < paramList.size())
    {
      localTroopUnreadMsgInfo = (TroopUnreadMsgInfo)paramList.get(paramInt);
      if ((localTroopUnreadMsgInfo != null) && (Utils.a(localTroopUnreadMsgInfo.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.c)))
      {
        if (localTroopUnreadMsgInfo.jdField_a_of_type_Long != 2L) {
          break label206;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.i = localTroopUnreadMsgInfo.b;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.h = localTroopUnreadMsgInfo.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
        if (paramBoolean2) {
          QZoneHelper.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.h);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.chatopttroop", 2, "onUpdateTroopUnreadMsg| isPush = " + paramBoolean2 + ", " + localTroopUnreadMsgInfo);
      }
      paramInt += 1;
      break label31;
      break;
      label206:
      if (localTroopUnreadMsgInfo.jdField_a_of_type_Long == 1L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.j = localTroopUnreadMsgInfo.jdField_a_of_type_Int;
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.k = localTroopUnreadMsgInfo.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
      }
      else if (localTroopUnreadMsgInfo.jdField_a_of_type_Long == 1101236949L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.l = localTroopUnreadMsgInfo.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(9);
      }
      else if (localTroopUnreadMsgInfo.jdField_a_of_type_Long == 1101484419L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData.m = localTroopUnreadMsgInfo.b;
        this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(16);
      }
      else
      {
        Message localMessage = Message.obtain();
        localMessage.what = 15;
        localMessage.arg1 = localTroopUnreadMsgInfo.b;
        localMessage.obj = Long.valueOf(localTroopUnreadMsgInfo.jdField_a_of_type_Long);
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dqd
 * JD-Core Version:    0.7.0.1
 */