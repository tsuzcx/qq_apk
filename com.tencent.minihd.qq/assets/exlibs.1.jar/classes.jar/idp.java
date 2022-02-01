import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.qphone.base.util.QLog;

public class idp
  implements Runnable
{
  public idp(MsgBoxListActivity paramMsgBoxListActivity, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if ((MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop) == 1010) && (MsgBoxListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingMsgBoxListActivity) == 1010))
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("DatingMsgListActivity", 4, "UIN_TYPE_DATE -- msg update");
      }
      if (MsgBoxListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingMsgBoxListActivity).a() == -1) {
        MsgBoxListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingMsgBoxListActivity);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingMsgBoxListActivity.a();
      return;
      if ((MsgProxyUtils.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop) == 1001) && (MsgBoxListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingMsgBoxListActivity) == 1001))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("DatingMsgListActivity", 4, "UIN_TYPE_HELLO -- msg update");
        }
        if (MsgBoxListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingMsgBoxListActivity).a() == -1) {
          MsgBoxListActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingMsgBoxListActivity);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     idp
 * JD-Core Version:    0.7.0.1
 */