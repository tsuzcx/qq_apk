import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;

public class dfe
  implements View.OnClickListener
{
  public dfe(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (AddFriendVerifyActivity.a(this.a).getText().toString().length() > 30)
    {
      paramView = new Dialog(this.a, 2131558902);
      paramView.setContentView(2130904387);
      ((TextView)paramView.findViewById(2131296606)).setText(this.a.getString(2131367303));
      ((ProgressBar)paramView.findViewById(2131296605)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131301658)).setImageResource(2130838254);
      paramView.show();
      return;
    }
    this.a.a(AddFriendVerifyActivity.a(this.a).getText().toString(), true);
    if (NetworkUtil.e(this.a))
    {
      AddFriendVerifyActivity.a(this.a, AddFriendVerifyActivity.a(this.a), AddFriendVerifyActivity.a(this.a).getText().toString(), this.a.getIntent().getIntExtra("stat_option", 0));
      this.a.a.b(2131366988);
      this.a.a.show();
      return;
    }
    QQToast.a(this.a, 1, 2131367328, 0).b(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dfe
 * JD-Core Version:    0.7.0.1
 */