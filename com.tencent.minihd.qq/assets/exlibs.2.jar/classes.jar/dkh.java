import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.tencent.mobileqq.activity.BookShareAdviceEditActivity;
import com.tencent.mobileqq.activity.book.BookEditText;

public class dkh
  implements TextWatcher
{
  public dkh(BookShareAdviceEditActivity paramBookShareAdviceEditActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.getText().toString();
    if ((paramEditable != null) && ("".equals(paramEditable))) {
      BookShareAdviceEditActivity.a(this.a).setEnabled(false);
    }
    for (;;)
    {
      int i = this.a.jdField_a_of_type_ComTencentMobileqqActivityBookBookEditText.a(paramEditable);
      this.a.c = (40 - (i + 2) / 3);
      if (this.a.c < 0) {
        break;
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#9A9A9A"));
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.a.c));
      return;
      BookShareAdviceEditActivity.b(this.a).setEnabled(true);
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-65536);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(String.valueOf(this.a.c));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dkh
 * JD-Core Version:    0.7.0.1
 */