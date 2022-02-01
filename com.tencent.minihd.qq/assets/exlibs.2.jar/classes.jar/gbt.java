import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountManager.InitDoneObserver;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.statistics.ReportController;

public class gbt
  implements PublicAccountManager.InitDoneObserver
{
  public gbt(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void a()
  {
    Object localObject = (PublicAccountDataManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(54);
    if (localObject != null) {}
    for (localObject = ((PublicAccountDataManager)localObject).a(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);; localObject = null)
    {
      boolean bool2;
      if (localObject == null)
      {
        bool2 = PublicAccountChatPie.a(this.a);
        PublicAccountChatPie.b(this.a);
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          if (TextUtils.isEmpty(this.a.K))
          {
            localObject = PublicAccountUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
            bool1 = bool2;
            if (localObject != null)
            {
              bool1 = bool2;
              if (!TextUtils.isEmpty(((AccountDetail)localObject).summary)) {
                this.a.K = ((AccountDetail)localObject).summary;
              }
            }
          }
        }
      }
      for (boolean bool1 = bool2;; bool1 = false)
      {
        if (bool1)
        {
          ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "Pb_account_lifeservice", "", "0X8004EFB", "0X8004EFB", 0, 0, "", "", "", "");
          PublicAccountChatPie.a(this.a, true);
          PublicAccountChatPie.a(this.a).sendEmptyMessage(3);
        }
        while (PublicAccountChatPie.c(this.a)) {
          return;
        }
        PublicAccountChatPie.a(this.a).sendEmptyMessage(1);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gbt
 * JD-Core Version:    0.7.0.1
 */