import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AutoReplySettingActivity;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class dhw
  implements View.OnClickListener
{
  public dhw(AutoReplySettingActivity paramAutoReplySettingActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = BaseApplication.getContext().getSharedPreferences("share", 0);
    Intent localIntent = new Intent(this.a, EditActivity.class);
    localIntent.putExtra("title", 2131367636).putExtra("limit", 210).putExtra("current", paramView.getString("auto_reply_msg" + this.a.app.a(), this.a.getString(2131367637))).putExtra("canPostNull", false).putExtra("hint", this.a.getResources().getString(2131367644)).putExtra("multiLine", true);
    this.a.startActivityForResult(localIntent, 2010);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dhw
 * JD-Core Version:    0.7.0.1
 */