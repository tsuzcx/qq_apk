import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;

public class exx
  implements View.OnClickListener
{
  public exx(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, LoginActivity.class);
    paramView.putExtra("uin", RegisterQQNumberActivity.a(this.a));
    paramView.putExtra("tab_index", 1);
    paramView.addFlags(131072);
    this.a.startActivity(paramView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     exx
 * JD-Core Version:    0.7.0.1
 */