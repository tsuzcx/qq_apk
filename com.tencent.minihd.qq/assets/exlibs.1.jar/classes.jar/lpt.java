import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.qqconnect.wtlogin.Login;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;

public class lpt
  implements TextWatcher
{
  public lpt(Login paramLogin) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool;
    if ((paramEditable.length() > 0) && (this.a.jdField_b_of_type_AndroidWidgetEditText.getText().length() > 0))
    {
      bool = true;
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(bool);
      paramEditable = this.a.jdField_a_of_type_AndroidWidgetButton;
      if (!bool) {
        break label66;
      }
    }
    label66:
    for (int i = 2130838078;; i = 2130838528)
    {
      paramEditable.setBackgroundResource(i);
      return;
      bool = false;
      break;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence.length() == 0) {
      this.a.jdField_a_of_type_AndroidViewView.setVisibility(4);
    }
    for (;;)
    {
      long l = this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.a.jdField_a_of_type_MqqManagerWtloginManager, paramCharSequence.toString());
      if (!this.a.a(l)) {
        break;
      }
      this.a.jdField_b_of_type_AndroidWidgetEditText.setText("123457890");
      this.a.jdField_b_of_type_Boolean = true;
      this.a.jdField_b_of_type_AndroidWidgetEditText.setSelection(9);
      return;
      if (paramInt3 < 2) {
        this.a.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
    }
    if (!"".equals(this.a.jdField_b_of_type_AndroidWidgetEditText.getText().toString())) {
      this.a.jdField_b_of_type_AndroidWidgetEditText.setText("");
    }
    this.a.jdField_b_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lpt
 * JD-Core Version:    0.7.0.1
 */