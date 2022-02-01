import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.NearbyActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;

public class emf
  implements View.OnClickListener
{
  public emf(NearbyActivity paramNearbyActivity, Runnable paramRunnable) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.b("0X8004444");
    if (NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_JavaLangRunnable.run();
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.app.e(false);
      if ((NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity) != null) && (NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).isShowing())) {
        NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).dismiss();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.finish();
    }
    do
    {
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.a(1, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity.getString(2131365941));
    } while ((NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity) == null) || (!NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).isShowing()));
    NearbyActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyActivity).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     emf
 * JD-Core Version:    0.7.0.1
 */