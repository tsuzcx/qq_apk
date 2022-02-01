import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel;

public class fsz
  implements Runnable
{
  public fsz(RecordSoundPanel paramRecordSoundPanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    int i = AudioPanel.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel.c(i);
    RecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel).setText(AudioPanel.a(this.jdField_a_of_type_Double));
    RecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelRecordSoundPanel, this.jdField_a_of_type_Double);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fsz
 * JD-Core Version:    0.7.0.1
 */