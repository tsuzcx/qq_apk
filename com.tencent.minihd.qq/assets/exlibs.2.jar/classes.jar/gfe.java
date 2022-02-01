import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.activity.contact.addcontact.SearchContactsFragment;

public class gfe
  implements TextView.OnEditorActionListener
{
  public gfe(SearchResultDialog paramSearchResultDialog) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (SearchResultDialog.a(this.a))
    {
      bool1 = bool2;
      if (SearchResultDialog.a(this.a) != null) {
        if (paramInt != 3)
        {
          bool1 = bool2;
          if (paramKeyEvent != null)
          {
            bool1 = bool2;
            if (paramKeyEvent.getKeyCode() != 66) {}
          }
        }
        else
        {
          paramTextView = SearchResultDialog.a(this.a).getText().toString();
          if (!TextUtils.isEmpty(paramTextView)) {
            SearchResultDialog.a(this.a).a(paramTextView, false);
          }
          bool1 = true;
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gfe
 * JD-Core Version:    0.7.0.1
 */