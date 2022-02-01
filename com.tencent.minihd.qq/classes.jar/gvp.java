import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.RecentOptionBar;

public class gvp
  implements View.OnClickListener
{
  private long jdField_a_of_type_Long;
  
  public gvp(RecentOptionBar paramRecentOptionBar) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (Math.abs(l - this.jdField_a_of_type_Long) < 500L) {
      return;
    }
    this.jdField_a_of_type_Long = l;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131297335: 
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.b();
      return;
    case 2131297336: 
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.a();
      return;
    case 2131297337: 
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.c();
      return;
    case 2131297338: 
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.e();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentOptionBar.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gvp
 * JD-Core Version:    0.7.0.1
 */