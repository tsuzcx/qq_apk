import android.widget.TextView;
import com.tencent.mobileqq.testassister.activity.ShareAppLogActivity;
import com.tencent.widget.TCWDatePicker;
import com.tencent.widget.TCWDatePickerDialog.OnDateSetListener;

public class jzb
  implements TCWDatePickerDialog.OnDateSetListener
{
  public jzb(ShareAppLogActivity paramShareAppLogActivity, TextView paramTextView) {}
  
  public void a(TCWDatePicker paramTCWDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt1 + "-" + (paramInt2 + 1) + "-" + paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     jzb
 * JD-Core Version:    0.7.0.1
 */