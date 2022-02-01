import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.CommonWebActivity;
import com.tencent.mobileqq.activity.LoginPhoneNumActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class feu
  implements ActionSheet.OnButtonClickListener
{
  public feu(SubLoginActivity paramSubLoginActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (SubLoginActivity.a(this.a)) {
      return;
    }
    if (paramInt == 0)
    {
      paramView = new Intent(this.a, CommonWebActivity.class);
      paramView.putExtra("uin", SubLoginActivity.a(this.a));
      paramView.putExtra("reqType", 3);
      paramView.putExtra("url", "https://aq.qq.com/cn2/findpsw/mobile_web_find_input_account?source_id=2756");
      this.a.startActivity(paramView);
    }
    for (;;)
    {
      SubLoginActivity.a(this.a, true);
      SubLoginActivity.a(this.a).dismiss();
      return;
      if (paramInt == 1)
      {
        paramView = new Intent(this.a, LoginPhoneNumActivity.class);
        paramView.putExtra("isSubaccount", true);
        paramView.putExtra("fromWhere", this.a.a);
        this.a.startActivity(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     feu
 * JD-Core Version:    0.7.0.1
 */