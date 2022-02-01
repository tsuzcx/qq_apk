import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;

public class geo
  implements TextWatcher
{
  public geo(SearchResultDialog paramSearchResultDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = SearchResultDialog.a(this.a).getText().toString();
    String str = paramEditable.trim();
    if (TextUtils.isEmpty(str)) {
      this.a.a(paramEditable, paramEditable);
    }
    while (paramEditable.equals(""))
    {
      this.a.findViewById(2131299465).setVisibility(8);
      return;
      this.a.a(str, paramEditable);
    }
    this.a.findViewById(2131299465).setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     geo
 * JD-Core Version:    0.7.0.1
 */