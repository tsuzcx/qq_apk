import com.tencent.mobileqq.activity.SubAccountUgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;

public class fel
  extends SubAccountBindObserver
{
  public fel(SubAccountUgActivity paramSubAccountUgActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if ((paramBoolean) && (paramSubAccountBackProtocData != null) && (SubAccountUgActivity.a(this.a) != null) && (SubAccountUgActivity.a(this.a).length() >= 5))
    {
      paramSubAccountBackProtocData = paramSubAccountBackProtocData.c();
      if ((paramSubAccountBackProtocData != null) && (!paramSubAccountBackProtocData.contains(SubAccountUgActivity.a(this.a)))) {}
    }
    else
    {
      return;
    }
    paramSubAccountBackProtocData = (SubAccountControll)this.a.app.getManager(60);
    SubAccountUgActivity.a(this.a, paramSubAccountBackProtocData, SubAccountUgActivity.a(this.a));
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() isSucc=" + paramBoolean + " currentActivity subUin=" + SubAccountUgActivity.a(this.a));
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountUgActivity.onUnBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.p + " errMsg=" + paramSubAccountBackProtocData.a);
      }
    }
    if ((paramSubAccountBackProtocData == null) || (SubAccountUgActivity.a(this.a) == null) || ((SubAccountUgActivity.a(this.a) != null) && (!SubAccountUgActivity.a(this.a).equals(paramSubAccountBackProtocData.c)))) {}
    do
    {
      return;
      this.a.a();
      if (SubAccountUgActivity.a(this.a))
      {
        SubAccountUgActivity.a(this.a, false);
        if (paramBoolean)
        {
          this.a.d();
          this.a.b(this.a.getString(2131368717));
          return;
        }
        this.a.a(this.a.getString(2131368686));
        return;
      }
    } while (!paramBoolean);
    paramSubAccountBackProtocData = (SubAccountControll)this.a.app.getManager(60);
    Pair localPair = paramSubAccountBackProtocData.a(SubAccountUgActivity.a(this.a), 1);
    paramSubAccountBackProtocData.a(this.a.app, this.a, localPair, new fem(this, paramSubAccountBackProtocData, localPair));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fel
 * JD-Core Version:    0.7.0.1
 */