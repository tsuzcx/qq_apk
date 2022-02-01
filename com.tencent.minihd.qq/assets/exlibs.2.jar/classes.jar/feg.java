import android.app.Activity;
import com.tencent.mobileqq.activity.SubAccountSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class feg
  extends SubAccountBindObserver
{
  public feg(SubAccountSettingActivity paramSubAccountSettingActivity) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if ((paramBoolean) && (paramSubAccountBackProtocData != null) && (SubAccountSettingActivity.a(this.a) != null) && (SubAccountSettingActivity.a(this.a).subuin != null) && (SubAccountSettingActivity.a(this.a).subuin.length() >= 5))
    {
      paramSubAccountBackProtocData = paramSubAccountBackProtocData.c();
      if ((paramSubAccountBackProtocData != null) && (!paramSubAccountBackProtocData.contains(SubAccountSettingActivity.a(this.a).subuin))) {}
    }
    else
    {
      return;
    }
    paramSubAccountBackProtocData = (SubAccountControll)this.a.app.getManager(60);
    SubAccountSettingActivity.a(this.a, paramSubAccountBackProtocData, SubAccountSettingActivity.a(this.a).subuin);
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("SubAccountSettingActivity.onUnBindSubAccount() isSucc=").append(paramBoolean).append(" currentActivity subUin=");
      if (SubAccountSettingActivity.a(this.a) != null) {
        break label183;
      }
    }
    label183:
    for (String str = "mSubInfo is null";; str = SubAccountSettingActivity.a(this.a).subuin)
    {
      QLog.d("SUB_ACCOUNT", 2, str);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountSettingActivity.onUnBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.p + " errMsg=" + paramSubAccountBackProtocData.a);
      }
      if ((paramSubAccountBackProtocData != null) && (SubAccountSettingActivity.a(this.a) != null) && ((SubAccountSettingActivity.a(this.a) == null) || ((SubAccountSettingActivity.a(this.a).subuin != null) && (SubAccountSettingActivity.a(this.a).subuin.equals(paramSubAccountBackProtocData.c))))) {
        break;
      }
      return;
    }
    this.a.a();
    if (paramBoolean)
    {
      this.a.getActivity().setTitle("");
      this.a.b(this.a.getString(2131368717));
      this.a.finish();
      return;
    }
    this.a.a(this.a.getString(2131368686));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     feg
 * JD-Core Version:    0.7.0.1
 */