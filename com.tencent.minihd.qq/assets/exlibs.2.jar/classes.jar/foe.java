import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendGrid;
import com.tencent.mobileqq.activity.activateFriend.BirthdayActivatePage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import mqq.util.WeakReference;

public class foe
  implements View.OnClickListener
{
  public foe(BirthdayActivatePage paramBirthdayActivatePage) {}
  
  public void onClick(View paramView)
  {
    if ((BirthdayActivatePage.a(this.a) != null) && (BirthdayActivatePage.a(this.a).get() != null))
    {
      String str = QzoneConfig.a().a("H5Url", "SendBirthdayGift", "https://qzs.qzone.qq.com/qzone/hybrid/module/sendGift/index.html?friends={uin_uin}&clicktime={clicktime}");
      long[] arrayOfLong = this.a.a.a();
      String[] arrayOfString = this.a.a.a();
      if (arrayOfLong.length > 0)
      {
        paramView = "";
        int i = 0;
        while (i < arrayOfLong.length)
        {
          paramView = paramView + arrayOfLong[i];
          paramView = paramView + "_";
          localObject = paramView + arrayOfString[i];
          int j = i + 1;
          i = j;
          paramView = (View)localObject;
          if (j < arrayOfLong.length)
          {
            paramView = (String)localObject + "|";
            i = j;
          }
        }
        paramView = str.replace("{uin_uin}", Uri.encode(paramView)).replace("{clicktime}", String.valueOf(System.currentTimeMillis()));
        paramView = paramView + "&_wv=7";
        Object localObject = new Intent(BaseApplication.getContext(), QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", paramView);
        ((Intent)localObject).putExtra("injectrecommend", true);
        ((Intent)localObject).setData(Uri.parse(paramView));
        ((ActivateFriendActivity)BirthdayActivatePage.a(this.a).get()).startActivityForResult((Intent)localObject, 1000);
        ReportController.b(((ActivateFriendActivity)BirthdayActivatePage.a(this.a).get()).app, "CliOper", "", "", "0X8004E08", "0X8004E08", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     foe
 * JD-Core Version:    0.7.0.1
 */