import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.AccountDetailActivity;
import com.tencent.mobileqq.mp.mobileqq_mp.ConfigInfo;
import com.tencent.mobileqq.widget.IconPopupWindow;

public class cia
  implements View.OnClickListener
{
  public cia(AccountDetailActivity paramAccountDetailActivity, mobileqq_mp.ConfigInfo paramConfigInfo, IconPopupWindow paramIconPopupWindow) {}
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    AccountDetailActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountAccountDetailActivity, this.jdField_a_of_type_ComTencentMobileqqMpMobileqq_mp$ConfigInfo, i + 1);
    this.jdField_a_of_type_ComTencentMobileqqWidgetIconPopupWindow.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cia
 * JD-Core Version:    0.7.0.1
 */