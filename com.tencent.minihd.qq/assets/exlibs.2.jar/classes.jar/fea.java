import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class fea
  extends SubAccountBindObserver
{
  public fea(SubAccountMessageActivity paramSubAccountMessageActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if ((paramBoolean) && (paramSubAccountBackProtocData != null) && (SubAccountMessageActivity.a(this.a) != null) && (SubAccountMessageActivity.a(this.a).subuin != null) && (SubAccountMessageActivity.a(this.a).subuin.length() >= 5))
    {
      paramSubAccountBackProtocData = paramSubAccountBackProtocData.c();
      if ((paramSubAccountBackProtocData != null) && (!paramSubAccountBackProtocData.contains(SubAccountMessageActivity.a(this.a).subuin))) {}
    }
    else
    {
      return;
    }
    paramSubAccountBackProtocData = (SubAccountControll)this.a.app.getManager(60);
    SubAccountMessageActivity.a(this.a, paramSubAccountBackProtocData, SubAccountMessageActivity.a(this.a).subuin);
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("SubAccountMessageActivity.onUnBindSubAccount() isSucc=").append(paramBoolean).append(" currentActivity subUin=");
      if (SubAccountMessageActivity.a(this.a) != null) {
        break label183;
      }
    }
    label183:
    for (String str = "mSubInfo is null";; str = SubAccountMessageActivity.a(this.a).subuin)
    {
      QLog.d("SUB_ACCOUNT", 2, str);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountMessageActivity.onUnBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.p + " errMsg=" + paramSubAccountBackProtocData.a);
      }
      if ((paramSubAccountBackProtocData != null) && (SubAccountMessageActivity.a(this.a) != null) && ((SubAccountMessageActivity.a(this.a) == null) || ((SubAccountMessageActivity.a(this.a).subuin != null) && (SubAccountMessageActivity.a(this.a).subuin.equals(paramSubAccountBackProtocData.c))))) {
        break;
      }
      return;
    }
    this.a.a();
    if (paramBoolean)
    {
      SubAccountAssistantForward.b(this.a.app);
      SubAccountAssistantForward.a(this.a.app);
      SubAccountAssistantForward.e(this.a.app);
      SubAccountAssistantForward.c(this.a.app);
      this.a.setTitle("");
      this.a.b(this.a.getString(2131368717));
      if (!SubAccountControll.a(this.a.app)) {
        SubAccountAssistantForward.a(this.a.app, this.a, null);
      }
      this.a.finish();
      return;
    }
    this.a.a(this.a.getString(2131368686));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fea
 * JD-Core Version:    0.7.0.1
 */