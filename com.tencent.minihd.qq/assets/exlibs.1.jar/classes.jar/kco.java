import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonListenPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;
import com.tencent.mobileqq.troop.activity.AbsReplyActivity;
import com.tencent.mobileqq.troop.data.AudioInfo;
import java.io.File;

public class kco
  extends Handler
{
  public kco(AbsReplyActivity paramAbsReplyActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2: 
      paramMessage = paramMessage.obj.toString();
      File localFile = new File(paramMessage);
      if (localFile.exists()) {}
      for (long l = localFile.length();; l = 0L)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.setAudioPath(paramMessage, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a());
        AbsReplyActivity.a(this.a, new AudioInfo(paramMessage, (int)this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.a(), l));
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonListenPanel.setVisibility(0);
        this.a.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.setVisibility(8);
        return;
      }
    }
    AbsReplyActivity.a(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kco
 * JD-Core Version:    0.7.0.1
 */