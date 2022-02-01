import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.dating.DatingDetailActivity;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.dating.DetailGuest;

public class icp
  implements View.OnClickListener
{
  public icp(DetailGuest paramDetailGuest) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_AndroidAppDialog != null)
    {
      this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      this.a.jdField_a_of_type_AndroidAppDialog = null;
    }
    DatingUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity.app, this.a.jdField_a_of_type_ComTencentMobileqqDatingDatingDetailActivity, String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailPubUin), this.a.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.publisherNickname, this.a.jdField_a_of_type_ComTencentMobileqqDataDatingInfo.detailSigC2C, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     icp
 * JD-Core Version:    0.7.0.1
 */