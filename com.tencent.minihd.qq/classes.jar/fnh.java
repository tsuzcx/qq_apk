import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.VerifyCodeActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class fnh
  implements View.OnClickListener
{
  public fnh(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString();
    if ((paramView == null) || (paramView.length() == 0)) {
      Toast.makeText(this.a.getApplicationContext(), this.a.getString(2131367156), 0).show();
    }
    while (paramView == null) {
      return;
    }
    this.a.a(paramView);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
    VerifyCodeActivity.b(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     fnh
 * JD-Core Version:    0.7.0.1
 */