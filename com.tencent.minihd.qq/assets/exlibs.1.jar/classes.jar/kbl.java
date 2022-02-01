import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.emoticonview.SystemEmoticonPanel;
import com.tencent.mobileqq.troop.activity.AbsPublishActivity;

public class kbl
  implements Runnable
{
  public kbl(AbsPublishActivity paramAbsPublishActivity) {}
  
  public void run()
  {
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonviewSystemEmoticonPanel.setVisibility(0);
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setImageResource(2130841083);
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setContentDescription(this.a.getString(2131363926));
    if (this.a.b != null) {
      this.a.b.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     kbl
 * JD-Core Version:    0.7.0.1
 */