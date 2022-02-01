import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.biz.troop.EditUniqueTitleActivity;

public class cnr
  implements TextWatcher
{
  public cnr(EditUniqueTitleActivity paramEditUniqueTitleActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    String str = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    if (str.equals(""))
    {
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(8);
      if (str.length() <= 6) {
        break label182;
      }
      EditUniqueTitleActivity.a(this.a, false);
    }
    for (paramEditable = this.a.getResources().getColorStateList(2131427999);; paramEditable = this.a.getResources().getColorStateList(2131427975))
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(paramEditable);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(str.length() + "/" + 6);
      int j = 6 - str.length();
      int i = j;
      if (j < 0) {
        i = 0;
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(String.format(this.a.getString(2131364009), new Object[] { Integer.valueOf(i) }));
      return;
      this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
      break;
      label182:
      EditUniqueTitleActivity.b(this.a, true);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cnr
 * JD-Core Version:    0.7.0.1
 */