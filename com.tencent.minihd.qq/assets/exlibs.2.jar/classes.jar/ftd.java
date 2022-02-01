import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel;

public class ftd
  implements Runnable
{
  public ftd(RecordSoundPanel paramRecordSoundPanel, String paramString) {}
  
  public void run()
  {
    RecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel).b(this.jdField_a_of_type_JavaLangString);
    ListenPanel localListenPanel = (ListenPanel)RecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel).findViewById(2131298537);
    localListenPanel.setVisibility(0);
    localListenPanel.setAudioPath(this.jdField_a_of_type_JavaLangString, RecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel));
    localListenPanel.setJumpSource(ListenPanel.d);
    RecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel).setStatus(4);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ftd
 * JD-Core Version:    0.7.0.1
 */