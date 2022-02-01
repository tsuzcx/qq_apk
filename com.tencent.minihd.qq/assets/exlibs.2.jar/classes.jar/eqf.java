import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ProfileLabelEditorActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class eqf
  implements View.OnClickListener
{
  public eqf(ProfileLabelEditorActivity paramProfileLabelEditorActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = this.a.getIntent().getStringExtra("uin");
    if ((paramView != null) && (paramView.equals(this.a.app.a()))) {
      ProfileLabelEditorActivity.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eqf
 * JD-Core Version:    0.7.0.1
 */