import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonListenPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.troop.activity.AbsReplyActivity;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;

public class kcp
  extends Handler
{
  public kcp(AbsReplyActivity paramAbsReplyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 101: 
      AbsReplyActivity.a(this.a, true);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.setVisibility(8);
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.g();
      this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setVisibility(0);
      TroopBarUtils.a(this.a.ad, this.a.ae, "un_record", this.a.af, this.a.ac, "", "");
      return;
    }
    AbsReplyActivity.a(this.a, true);
    this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo = AbsReplyActivity.a(this.a);
    this.a.a(2, this.a.jdField_a_of_type_ComTencentMobileqqTroopDataAudioInfo);
    AbsReplyActivity.a(this.a, 0);
    TroopBarUtils.a(this.a.ad, this.a.ae, "sure_record", this.a.af, this.a.ac, "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kcp
 * JD-Core Version:    0.7.0.1
 */