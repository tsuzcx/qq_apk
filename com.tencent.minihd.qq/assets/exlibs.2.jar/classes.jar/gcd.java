import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.utils.TroopGagMgr.GagStatus;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import tencent.im.lbs.member_lbs.NeighbourNumber;
import tencent.im.lbs.member_lbs.RspBody;

public class gcd
  extends BizTroopObserver
{
  public gcd(TroopChatPie paramTroopChatPie) {}
  
  protected void a(TroopGagMgr.GagStatus paramGagStatus)
  {
    if ((paramGagStatus.jdField_a_of_type_Int == 2) && (paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$SelfGagInfo != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(paramGagStatus.jdField_a_of_type_JavaLangString))) {
      TroopChatPie.a(this.a, paramGagStatus.jdField_a_of_type_ComTencentMobileqqTroopUtilsTroopGagMgr$SelfGagInfo, true);
    }
  }
  
  protected void a(Object paramObject)
  {
    if (TroopChatPie.a(this.a) != null) {
      TroopChatPie.b(this.a).notifyDataSetChanged();
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isResume()) {
      return;
    }
    if (paramBoolean1)
    {
      if (paramBoolean2) {}
      for (String str = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364020);; str = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131364021))
      {
        QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), 2, str, 1).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
        return;
      }
    }
    QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getApplicationContext(), 1, 2131364022, 1).b(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getTitleBarHeight());
  }
  
  protected void d(boolean paramBoolean, Object paramObject)
  {
    long l = ((Long)paramObject).longValue();
    if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int == 1) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString.equals(String.valueOf(l)))) {
      TroopChatPie.b(this.a);
    }
  }
  
  protected void e(boolean paramBoolean, Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return;
      paramObject = (member_lbs.RspBody)paramObject;
      Object localObject = (member_lbs.NeighbourNumber)paramObject.msg_neighbour_number.get();
      long l2 = ((member_lbs.NeighbourNumber)localObject).uint64_group_code.get();
      try
      {
        long l1 = Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        l2 = Long.valueOf(l2).longValue();
        if (l1 == l2)
        {
          if (((member_lbs.NeighbourNumber)localObject).uint64_neighbour_number.get() > 0L) {
            this.a.a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, ((member_lbs.NeighbourNumber)localObject).uint64_neighbour_number.get());
          }
          if (paramObject.bool_show_tips.get())
          {
            try
            {
              localObject = new String(paramObject.str_tips_wording.get().toByteArray(), "UTF-8");
              paramObject = new String(paramObject.str_tips_web_url.get().toByteArray(), "UTF-8");
              if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips == null) {
                continue;
              }
              this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopAioTips.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAIOTipsController, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, (String)localObject, paramObject);
              return;
            }
            catch (UnsupportedEncodingException paramObject)
            {
              return;
            }
            if (!QLog.isColorLevel()) {}
          }
        }
      }
      catch (NumberFormatException paramObject) {}
    }
    QLog.d("TroopChatPie", 2, "onGetNearbyTroopMemberCount NumberFormatException", paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gcd
 * JD-Core Version:    0.7.0.1
 */