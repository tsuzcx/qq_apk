import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;

public class ggp
  implements TextWatcher
{
  public ggp(SearchContactsActivity paramSearchContactsActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    paramEditable = this.a.jdField_a_of_type_AndroidWidgetImageButton;
    int i;
    Button localButton;
    if (str.equals(""))
    {
      i = 8;
      paramEditable.setVisibility(i);
      localButton = this.a.jdField_a_of_type_AndroidWidgetButton;
      if (str.equals("")) {
        break label116;
      }
    }
    label116:
    for (paramEditable = this.a.getResources().getString(2131366590);; paramEditable = this.a.getResources().getString(2131365736))
    {
      localButton.setText(paramEditable);
      this.a.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.a.jdField_a_of_type_AndroidWidgetButton.getText());
      ((SearchContactsFragment)this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment).c(str);
      return;
      i = 0;
      break;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ggp
 * JD-Core Version:    0.7.0.1
 */