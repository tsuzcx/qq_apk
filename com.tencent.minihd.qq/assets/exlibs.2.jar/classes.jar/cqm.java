import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.utils.ShareMsgHelper;
import com.tencent.mobileqq.widget.QQProgressDialog;

class cqm
  implements Runnable
{
  cqm(cql paramcql, String paramString) {}
  
  public void run()
  {
    String str2;
    String str3;
    if ((this.jdField_a_of_type_Cql.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isResume()) && (!this.jdField_a_of_type_Cql.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isFinishing()))
    {
      if ((this.jdField_a_of_type_Cql.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_Cql.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_Cql.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      str2 = String.format("mqqapi://app/action?pkg=com.tencent.minihd.qq&cmp=com.tencent.biz.pubaccount.AccountDetailActivity&uin=%s", new Object[] { this.jdField_a_of_type_Cql.b });
      str3 = String.format("mqqapi://card/show_pslcard?src_type=internal&card_type=public_account&uin=%s&version=1", new Object[] { this.jdField_a_of_type_Cql.b });
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label241;
      }
    }
    label241:
    for (String str1 = this.jdField_a_of_type_Cql.jdField_a_of_type_JavaLangString;; str1 = this.jdField_a_of_type_JavaLangString)
    {
      String str4 = String.format(this.jdField_a_of_type_Cql.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.getResources().getString(2131363662), new Object[] { this.jdField_a_of_type_Cql.c });
      ShareMsgHelper.a(this.jdField_a_of_type_Cql.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity, 1001, 1, "struct_msg_from_h5", this.jdField_a_of_type_Cql.b, str1, this.jdField_a_of_type_Cql.c, this.jdField_a_of_type_Cql.d, str4, this.jdField_a_of_type_Cql.e, "web", null, null, null, "plugin", null, str2, str3, "https://url.cn/JS8oE7", this.jdField_a_of_type_Cql.f, null);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cqm
 * JD-Core Version:    0.7.0.1
 */