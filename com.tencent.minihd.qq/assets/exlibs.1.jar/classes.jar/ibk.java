import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.dating.DatingCacheMng;
import com.tencent.mobileqq.dating.DatingFeedActivity;
import com.tencent.mobileqq.dating.DatingFilters;
import com.tencent.mobileqq.dating.DatingManager;
import java.util.List;

public class ibk
  implements Runnable
{
  public ibk(DatingFeedActivity paramDatingFeedActivity, List paramList, DatingManager paramDatingManager) {}
  
  public void run()
  {
    List localList = null;
    String str;
    if (this.jdField_a_of_type_JavaUtilList == null)
    {
      SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity.getSharedPreferences("dating_pref" + this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity.app.a(), 0);
      str = localSharedPreferences.getString("feed_cookie", null);
      if (str == null)
      {
        DatingFeedActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity, new byte[0]);
        DatingFeedActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity, localSharedPreferences.getBoolean("feed_has_more", false));
        DatingFeedActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity, localSharedPreferences.getBoolean("feed_have_published", false));
        if (this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager != null)
        {
          DatingFeedActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity, this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a());
          localList = this.jdField_a_of_type_ComTencentMobileqqDatingDatingManager.a().a(0);
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_JavaUtilList != null) {
        localList = this.jdField_a_of_type_JavaUtilList;
      }
      DatingFeedActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity, DatingFilters.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity, this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity.app.a()));
      DatingFeedActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity, DatingFeedActivity.b(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity));
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity.runOnUiThread(new ibl(this, localList));
      return;
      DatingFeedActivity.a(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity, Base64.decode(str, 0));
      break;
      DatingFeedActivity.e(this.jdField_a_of_type_ComTencentMobileqqDatingDatingFeedActivity, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ibk
 * JD-Core Version:    0.7.0.1
 */