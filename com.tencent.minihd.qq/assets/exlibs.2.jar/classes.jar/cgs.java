import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.biz.lebasearch.SearchActivity;

public class cgs
  implements TextView.OnEditorActionListener
{
  public cgs(SearchActivity paramSearchActivity) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt != 3)
    {
      bool1 = bool2;
      if (paramKeyEvent != null)
      {
        bool1 = bool2;
        if (paramKeyEvent.getKeyCode() != 84) {}
      }
    }
    else
    {
      if (TextUtils.isEmpty(SearchActivity.a(this.a).getText())) {
        break label104;
      }
      SearchActivity.a(this.a, 2);
    }
    for (;;)
    {
      paramTextView = SearchActivity.a(this.a).getText().toString();
      this.a.a(paramTextView);
      SearchActivity.a(this.a).setSelection(paramTextView.length());
      SearchActivity.a(this.a, false);
      bool1 = true;
      return bool1;
      label104:
      if (!TextUtils.isEmpty(SearchActivity.a(this.a).getHint())) {
        SearchActivity.a(this.a, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cgs
 * JD-Core Version:    0.7.0.1
 */