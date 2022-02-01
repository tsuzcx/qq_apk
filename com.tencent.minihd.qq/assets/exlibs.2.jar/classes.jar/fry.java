import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanel;
import com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel;

public class fry
  implements Runnable
{
  public fry(CommonRecordSoundPanel paramCommonRecordSoundPanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    int i = AudioPanel.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.d(i);
    CommonRecordSoundPanel.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel).setText(AudioPanel.a(this.jdField_a_of_type_Double));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudiopanelCommonRecordSoundPanel.jdField_a_of_type_Double = this.jdField_a_of_type_Double;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fry
 * JD-Core Version:    0.7.0.1
 */