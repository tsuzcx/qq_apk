import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.IndividuationSetActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class eev
  implements View.OnClickListener
{
  public eev(IndividuationSetActivity paramIndividuationSetActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (JSONObject)paramView.getTag();
    if (paramView != null) {}
    for (;;)
    {
      try
      {
        ReportController.b(this.a.app, "Trends_tab", "", "", "Clk_native_banner", paramView.getString("bannerId"), 0, 0, "", "", "", "");
        switch (paramView.getInt("bizType"))
        {
        case 0: 
          if (i == -1) {
            break label455;
          }
          IndividuationSetActivity.a(this.a, null, i);
          return;
        }
      }
      catch (Exception paramView)
      {
        Intent localIntent;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("IndividualShowBannerMaskClick", 2, "IndividualShowBannerMaskClick error:" + paramView.getMessage());
        paramView.printStackTrace();
        return;
      }
      paramView = paramView.getString("href");
      localIntent = new Intent();
      localIntent.putExtra("url", paramView.replace("{uin}", this.a.app.a()).replace("{client}", "androidQQ").replace("{version}", "5.9.3.3468").replace("{platformId}", "2").replace("{device}", Build.DEVICE).replace("{system}", Build.VERSION.RELEASE).replace("{systemInt}", Integer.toString(Build.VERSION.SDK_INT)).replace("{adTag}", "mvip.gongneng.anroid.individuation.native").replace("{updateFlag}", "false").replace("{density}", ThemeUtil.getThemeDensity(this.a.app.getApplication().getApplicationContext())));
      localIntent.putExtra("individuation_url_type", 100);
      localIntent.setClass(this.a, QQBrowserActivity.class);
      this.a.startActivity(localIntent);
      int i = -1;
      continue;
      EmojiHomeUiPlugin.openEmojiDetailPage(this.a, this.a.app.getAccount(), 8, paramView.getString("href"), this.a.app.getSid(), false);
      i = -1;
      continue;
      i = 2131297823;
      continue;
      i = 2131297831;
      continue;
      i = 2131297844;
      continue;
      i = 2131297815;
      continue;
      i = 2131297868;
      continue;
      i = 2131297876;
      continue;
      i = 2131297884;
      continue;
      i = 2131297852;
      continue;
      i = -1;
      continue;
      label455:
      return;
      i = 2131297808;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eev
 * JD-Core Version:    0.7.0.1
 */