import com.tencent.mobileqq.activity.SubAccountInfoListActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class fde
  extends MessageObserver
{
  public fde(SubAccountInfoListActivity paramSubAccountInfoListActivity) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsgNotify.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.i("IphoneTitleBarActivity", 2, "onGetSubAccountMsgNotify.data.errorType=" + paramSubAccountBackProtocData.p + "  errorMsg=" + paramSubAccountBackProtocData.a + " mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + "  subAccount=" + paramSubAccountBackProtocData.c + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    if (this.a.isFinishing()) {}
    SubAccountControll localSubAccountControll;
    label268:
    do
    {
      for (;;)
      {
        return;
        if ((paramSubAccountBackProtocData != null) && (paramString != null) && (paramString.length() >= 5))
        {
          localSubAccountControll = (SubAccountControll)this.a.app.getManager(60);
          if (paramSubAccountBackProtocData.p != 1) {
            break label268;
          }
          if ((!this.a.isResume()) || (!SubAccountControll.a(this.a.app, "sub.uin.all"))) {
            break;
          }
          paramString = localSubAccountControll.a("sub.uin.all");
          int j = paramString.size();
          int i = 0;
          while (i < j)
          {
            paramSubAccountBackProtocData = (Pair)paramString.get(i);
            localSubAccountControll.a(this.a.app, this.a, paramSubAccountBackProtocData, new fdf(this, localSubAccountControll, paramSubAccountBackProtocData));
            i += 1;
          }
        }
      }
    } while (!this.a.isResume());
    localSubAccountControll.a(paramString, 1, true);
    SubAccountInfoListActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fde
 * JD-Core Version:    0.7.0.1
 */