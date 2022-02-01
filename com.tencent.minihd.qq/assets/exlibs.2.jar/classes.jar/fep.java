import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

public class fep
  extends MessageObserver
{
  public fep(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.i("IphoneTitleBarActivity", 2, "onPushSubAccountMsg() data.errorType=" + paramSubAccountBackProtocData.p + "  errorMsg=" + paramSubAccountBackProtocData.a + " mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + "  subAccount=" + paramSubAccountBackProtocData.c + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    if ((paramSubAccountBackProtocData == null) || (paramString == null) || (paramString.length() < 5)) {}
    SubAccountControll localSubAccountControll;
    do
    {
      do
      {
        do
        {
          return;
        } while (this.a.isFinishing());
        localSubAccountControll = (SubAccountControll)this.a.app.getManager(60);
        if (paramSubAccountBackProtocData.p != 1) {
          break;
        }
      } while ((SubAccountUgActivity.a(this.a) == null) || (!SubAccountUgActivity.a(this.a).equals(paramString)));
      SubAccountUgActivity.a(this.a, localSubAccountControll, paramString);
      return;
    } while ((SubAccountUgActivity.a(this.a) == null) || (!SubAccountUgActivity.a(this.a).equals(paramString)));
    localSubAccountControll.a(SubAccountUgActivity.a(this.a), 1, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fep
 * JD-Core Version:    0.7.0.1
 */