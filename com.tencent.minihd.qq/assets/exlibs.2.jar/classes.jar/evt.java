import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.RecentSaidActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.XListView;

public class evt
  implements View.OnClickListener
{
  public evt(RecentSaidActivity paramRecentSaidActivity, View paramView) {}
  
  public void onClick(View paramView)
  {
    paramView = RecentSaidActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity, 0).edit();
    paramView.putBoolean(this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity.app.a(), true);
    paramView.commit();
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity.a.a(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity.a("Close_warning");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     evt
 * JD-Core Version:    0.7.0.1
 */