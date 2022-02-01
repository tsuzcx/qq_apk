import android.view.View;
import com.tencent.mobileqq.activity.SoundAndVibrateActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.HashMap;

public class fbe
  implements ActionSheet.OnButtonClickListener
{
  public fbe(SoundAndVibrateActivity paramSoundAndVibrateActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((paramInt < 0) && (paramInt >= SoundAndVibrateActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity).size())) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.f(paramInt);
      SoundAndVibrateActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivitySoundAndVibrateActivity, paramInt);
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fbe
 * JD-Core Version:    0.7.0.1
 */