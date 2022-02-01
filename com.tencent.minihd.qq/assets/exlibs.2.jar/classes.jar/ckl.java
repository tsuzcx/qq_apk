import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.assistant.PubAccountAssistantSettingAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.statistics.ReportController;

public class ckl
  implements View.OnClickListener
{
  public ckl(PubAccountAssistantSettingAdapter paramPubAccountAssistantSettingAdapter, PublicAccountInfo paramPublicAccountInfo, ckn paramckn, View paramView) {}
  
  public void onClick(View paramView)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.messageSettingFlag != 0)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.messageSettingFlag == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.messageSettingFlag = 1;
        this.jdField_a_of_type_Ckn.b.setBackgroundColor(PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter).getResources().getColor(2131427375));
      }
      for (i = 1;; i = 2)
      {
        PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo, 6, i);
        String str1 = PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter).getString(2131363643);
        String str2 = this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.name;
        if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mShowMsgFlag != 1) {
          break;
        }
        paramView = PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter).getString(2131367642);
        label116:
        paramView = String.format(str1, new Object[] { str2, paramView });
        this.jdField_a_of_type_AndroidViewView.setContentDescription(paramView);
        ReportController.b(PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter), "P_CliOper", "Pb_account_lifeservice", PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter).getAccount(), "mp_msg_zhushou_3", "share_succ", 0, 0, "", "", "", "");
        return;
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.messageSettingFlag = 2;
        this.jdField_a_of_type_Ckn.b.setBackgroundResource(2130838071);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mShowMsgFlag == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mShowMsgFlag = 1;
      this.jdField_a_of_type_Ckn.b.setBackgroundColor(PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter).getResources().getColor(2131427375));
      i = 1;
    }
    for (;;)
    {
      PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter, this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo, 5, i);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mShowMsgFlag == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqDataPublicAccountInfo.mShowMsgFlag = 0;
        this.jdField_a_of_type_Ckn.b.setBackgroundResource(2130838071);
        i = 2;
        continue;
        paramView = PubAccountAssistantSettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountAssistantPubAccountAssistantSettingAdapter).getString(2131367671);
        break label116;
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ckl
 * JD-Core Version:    0.7.0.1
 */