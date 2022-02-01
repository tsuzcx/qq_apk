import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import com.tencent.biz.lebasearch.SearchActivity;

public class cgy
  implements TextWatcher
{
  private cgy(SearchActivity paramSearchActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (SearchActivity.a(this.a) == true)
    {
      SearchActivity.a(this.a, false);
      if (SearchActivity.a(this.a) <= paramEditable.length()) {
        break label71;
      }
      SearchActivity.a(this.a).setText("");
    }
    for (;;)
    {
      paramEditable = SearchActivity.a(this.a).getText().toString();
      this.a.b(paramEditable);
      return;
      label71:
      paramEditable = paramEditable.toString().substring(SearchActivity.a(this.a));
      SearchActivity.a(this.a).setText(paramEditable);
      SearchActivity.a(this.a).setSelection(paramEditable.length());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    SearchActivity.b(this.a, paramCharSequence.length());
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cgy
 * JD-Core Version:    0.7.0.1
 */