import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.Banner;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.struct.PushBanner;
import com.tencent.mobileqq.widget.ADView;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;

public class guh
  implements View.OnClickListener
{
  public guh(BannerManager paramBannerManager, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = (ADView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297804);
    Object localObject = paramView.a(false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "0X80060C6: md5 = " + paramView.a(false));
    }
    ReportController.b(BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).app, "CliOper", "", "", "0X80060C6", "0X80060C6", 0, 0, "", "", (String)localObject, "");
    BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).getSharedPreferences("mobileQQ", 0).edit().putBoolean("push_banner_display" + BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager).app.getAccount(), false).commit();
    paramView = BannerManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager)[13];
    if ((paramView != null) && (paramView.jdField_a_of_type_AndroidViewView != null))
    {
      localObject = (ADView)paramView.jdField_a_of_type_AndroidViewView.findViewById(2131297804);
      if (localObject == null) {
        break label312;
      }
    }
    label312:
    for (paramView = ((ADView)localObject).a(0);; paramView = null)
    {
      if (paramView != null)
      {
        int j = paramView.getChildCount();
        LinkedList localLinkedList = new LinkedList();
        int i = 0;
        while (i < j)
        {
          View localView = paramView.getChildAt(i);
          if (localView != null) {
            localLinkedList.add((PushBanner)localView.getTag());
          }
          i += 1;
        }
        ThreadManager.a().post(new gui(this, j, localLinkedList));
        if (localObject != null) {
          ((ADView)localObject).a();
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(13, 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(null);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.b = false;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     guh
 * JD-Core Version:    0.7.0.1
 */