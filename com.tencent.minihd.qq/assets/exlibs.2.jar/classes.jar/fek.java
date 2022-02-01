import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.utils.ContactUtils;

public class fek
  extends FriendListObserver
{
  public fek(SubAccountSettingActivity paramSubAccountSettingActivity) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (SubAccountSettingActivity.a(this.a) != null) && (SubAccountSettingActivity.a(this.a).subuin != null) && (paramString != null) && (SubAccountSettingActivity.a(this.a).subuin.equals(paramString)))
    {
      paramString = ContactUtils.c(this.a.app, paramString, false);
      if ((!TextUtils.isEmpty(paramString)) && ((TextUtils.isEmpty(SubAccountSettingActivity.a(this.a).subname)) || (!paramString.equals(SubAccountSettingActivity.a(this.a).subname))))
      {
        SubAccountSettingActivity.a(this.a).subname = paramString;
        SubAccountSettingActivity.a(this.a).setText(SubAccountSettingActivity.a(this.a).subname);
      }
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if ((!paramBoolean) || (TextUtils.isEmpty(paramString)) || (SubAccountSettingActivity.a(this.a) == null) || (!paramString.equals(SubAccountSettingActivity.a(this.a).subuin))) {}
    while (SubAccountSettingActivity.a(this.a) == null) {
      return;
    }
    paramString = this.a.app.b(SubAccountSettingActivity.a(this.a).subuin);
    SubAccountSettingActivity.a(this.a).setImageDrawable(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fek
 * JD-Core Version:    0.7.0.1
 */