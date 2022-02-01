import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.tencent.qqconnect.wtlogin.Login;

public class lpu
  implements TextWatcher
{
  public lpu(Login paramLogin) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    boolean bool;
    if ((paramEditable.length() > 0) && (this.a.jdField_a_of_type_AndroidWidgetEditText.getText().length() > 0))
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
    if (paramInt3 < 2)
    {
      this.a.jdField_b_of_type_Boolean = false;
      if (paramCharSequence.length() == 0) {
        this.a.jdField_b_of_type_AndroidViewView.setVisibility(4);
      }
    }
    else
    {
      return;
    }
    this.a.jdField_b_of_type_AndroidViewView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     lpu
 * JD-Core Version:    0.7.0.1
 */