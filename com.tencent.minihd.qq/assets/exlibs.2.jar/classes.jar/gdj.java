import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.FraudTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;

public class gdj
  implements View.OnClickListener
{
  public gdj(FraudTipsBar paramFraudTipsBar, int paramInt) {}
  
  public void onClick(View paramView)
  {
    FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar, 2);
    FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar).a();
    ReportController.b(FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar), "P_CliOper", "Safe_AntiFraud", FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar).a, "banner", "userclick", this.jdField_a_of_type_Int, 0, "", "", "", "");
    paramView = (Bundle)AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerURL", 146, this.jdField_a_of_type_Int);
    if (paramView != null) {}
    for (paramView = paramView.getString("BannerURL");; paramView = null)
    {
      Object localObject = paramView;
      if (TextUtils.isEmpty(paramView)) {
        localObject = "https://jubao.qq.com/cn/jubao?appname=KQQ&subapp=$SUBAPP$&jubaotype=uin&system=$SYSTEM$&eviluin=$EVILUIN$&impeachuin=$USERUIN$";
      }
      if (this.jdField_a_of_type_Int == 1) {}
      for (paramView = ((String)localObject).replace("$SUBAPP$", "notice");; paramView = ((String)localObject).replace("$SUBAPP$", "tips"))
      {
        paramView = paramView.replace("$SYSTEM$", "android").replace("$EVILUIN$", FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar).a).replace("$USERUIN$", FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar).getAccount());
        localObject = new Intent(FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar), QQBrowserDelegationActivity.class);
        ((Intent)localObject).putExtra("injectrecommend", true);
        ((Intent)localObject).putExtra("url", paramView);
        FraudTipsBar.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsFraudTipsBar).startActivity((Intent)localObject);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gdj
 * JD-Core Version:    0.7.0.1
 */