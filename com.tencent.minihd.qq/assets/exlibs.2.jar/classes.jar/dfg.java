import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;

public class dfg
  implements View.OnClickListener
{
  public dfg(AddFriendVerifyActivity paramAddFriendVerifyActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.getText().toString().length() > 30)
    {
      paramView = new Dialog(this.a, 2131558902);
      paramView.setContentView(2130904387);
      ((TextView)paramView.findViewById(2131296606)).setText(this.a.getString(2131367303));
      ((ProgressBar)paramView.findViewById(2131296605)).setVisibility(8);
      ((ImageView)paramView.findViewById(2131301658)).setImageResource(2130838254);
      paramView.show();
      return;
    }
    this.a.a(this.a.a.getText().toString().trim(), false);
    this.a.a(this.a.a.getText().toString().trim(), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dfg
 * JD-Core Version:    0.7.0.1
 */