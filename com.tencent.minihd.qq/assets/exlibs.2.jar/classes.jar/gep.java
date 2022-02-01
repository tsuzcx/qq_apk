import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.activity.Contacts;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.SoftInputActivity;
import com.tencent.mobileqq.activity.contact.SearchResultDialog;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.util.SizeMeasure;

public class gep
  implements View.OnClickListener
{
  public gep(SearchResultDialog paramSearchResultDialog) {}
  
  public void onClick(View paramView)
  {
    if (((SearchResultDialog.a(this.a) instanceof BaseActivity)) && (!((BaseActivity)SearchResultDialog.a(this.a)).isResume()) && (SizeMeasure.a(SearchResultDialog.a(this.a))) && (((SearchResultDialog.a(this.a) instanceof Conversation)) || ((SearchResultDialog.a(this.a) instanceof Contacts)) || ((SearchResultDialog.a(this.a) instanceof Call))))
    {
      SearchResultDialog.b(this.a);
      SearchResultDialog.a(this.a).setCursorVisible(false);
      SearchResultDialog.a(this.a).postDelayed(new geq(this), 500L);
      paramView = new Intent(SearchResultDialog.a(this.a), SoftInputActivity.class);
      paramView.setFlags(268435456);
      if (!TextUtils.isEmpty(SearchResultDialog.a(this.a).getText())) {
        paramView.putExtra("text", SearchResultDialog.a(this.a).getText().toString());
      }
      SearchResultDialog.a(this.a).startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gep
 * JD-Core Version:    0.7.0.1
 */