import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.widget.Switch;

public class chw
  implements DialogInterface.OnClickListener
{
  public chw(AccountDetailActivity paramAccountDetailActivity, mobileqq_mp.ConfigInfo paramConfigInfo, Switch paramSwitch, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0) {
      if ((3 == this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state_id.get()) && (this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo.state.get() == 0))
      {
        paramDialogInterface = this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity;
        localConfigInfo = this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo;
        localSwitch = this.jdField_a_of_type_ComTencentWidgetSwitch;
        if (!this.jdField_a_of_type_Boolean)
        {
          bool = true;
          AccountDetailActivity.a(paramDialogInterface, localConfigInfo, localSwitch, bool);
        }
      }
      else
      {
        AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch);
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a.isConfirmed = true;
        AccountDetailActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a);
        this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.h = false;
      }
    }
    while (paramInt != 1) {
      for (;;)
      {
        mobileqq_mp.ConfigInfo localConfigInfo;
        Switch localSwitch;
        return;
        boolean bool = false;
      }
    }
    AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, this.jdField_a_of_type_ComTencentWidgetSwitch, this.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a.isConfirmed = true;
    AccountDetailActivity.e(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.a);
    this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity.h = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     chw
 * JD-Core Version:    0.7.0.1
 */