import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessInfoCheckUpdateItem;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.redtouch.VipBannerInfo;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;

public class guu
  implements View.OnClickListener
{
  public guu(BannerManager paramBannerManager, VipBannerInfo paramVipBannerInfo, RedTouchManager paramRedTouchManager, BusinessInfoCheckUpdate.AppInfo paramAppInfo) {}
  
  public void onClick(View paramView)
  {
    BusinessInfoCheckUpdateItem.a(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).app, "200001", false);
    if ((this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.d == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.d)))
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.c;
      if (paramView == null)
      {
        paramView = "";
        switch (this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.e)
        {
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouchManager.a(this.jdField_a_of_type_ComTencentPbGetbusiinfoBusinessInfoCheckUpdate$AppInfo, this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.a, 3);
      BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).removeMessages(9);
      BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).sendEmptyMessage(9);
      return;
      paramView = paramView.replace(" ", "_");
      break;
      VipUtils.a(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeivip%s", new Object[] { paramView }));
      continue;
      VipUtils.b(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), 3, String.format("mvip.gongneng.mobileqq.androiddaoqiqian.xufeisvip%s", new Object[] { paramView }));
      continue;
      VipUtils.a(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeivip%s", new Object[] { paramView }));
      continue;
      VipUtils.b(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), 3, String.format("mvip.gongneng.mobileqq.androidyidaoqi.xufeisvip%s", new Object[] { paramView }));
      continue;
      paramView = new Intent(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager), QQBrowserActivity.class);
      paramView.putExtra("url", this.jdField_a_of_type_ComTencentMobileqqRedtouchVipBannerInfo.d);
      BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     guu
 * JD-Core Version:    0.7.0.1
 */