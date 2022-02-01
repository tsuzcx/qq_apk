import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.util.PAMessageUtil;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PATextItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.open.adapter.OpenAppClient;

public class fvr
  implements View.OnClickListener
{
  public fvr(PATextItemBuilder paramPATextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = (fvs)AIOUtils.a(paramView);
    if (PAMessageUtil.a(paramView.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_AndroidContentContext)) {}
    for (;;)
    {
      paramView = paramView.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
      if ((paramView instanceof MessageForPubAccount))
      {
        paramView = (MessageForPubAccount)paramView;
        if ((paramView.mPAMessage != null) && (paramView.mPAMessage.mMsgId > 0L)) {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Pb_account_lifeservice", paramView.frienduin, "mp_msg_sys_14", "msg_click", 0, 1, 0, Long.toString(paramView.mPAMessage.mMsgId), "", "", "");
        }
      }
      return;
      Object localObject;
      if ((paramView.b != null) && (paramView.b.equals("open_local")))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("schemaurl", paramView.c);
        ((Bundle)localObject).putString("uin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        ((Bundle)localObject).putString("vkey", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.d());
        OpenAppClient.b((Activity)this.a.jdField_a_of_type_AndroidContentContext, (Bundle)localObject);
      }
      else
      {
        localObject = new Intent(this.a.jdField_a_of_type_AndroidContentContext, PublicAccountBrowser.class);
        ((Intent)localObject).putExtra("uin", this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
        ((Intent)localObject).putExtra("url", paramView.c);
        ((Intent)localObject).putExtra("assignBackText", this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131366374));
        ((Intent)localObject).putExtra("puin", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        ((Intent)localObject).putExtra("source_name", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.d);
        ((Intent)localObject).putExtra("fromAio", true);
        PublicAccountUtil.a((Intent)localObject, paramView.c);
        this.a.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject);
        ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "aio_msg_url", "aio_url_clickqq", 0, 1, 0, paramView.c, "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fvr
 * JD-Core Version:    0.7.0.1
 */