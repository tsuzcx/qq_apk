import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.SubAccountBindActivity;
import com.tencent.mobileqq.activity.SubLoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class fct
  extends SubAccountBindObserver
{
  public fct(SubAccountBindActivity paramSubAccountBindActivity) {}
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "SubAccountBindActivity.onBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.p + " errMsg=" + paramSubAccountBackProtocData.a);
      }
    }
    this.a.a();
    Object localObject2;
    if (paramBoolean)
    {
      this.a.b(this.a.getString(2131368716));
      SubAccountAssistantForward.a(this.a.app);
      this.a.getActivity().setTitle("");
      localObject1 = new Intent(this.a, SplashActivity.class);
      ((Intent)localObject1).putExtra("tab_index", 1);
      ((Intent)localObject1).setFlags(67108864);
      this.a.startActivity((Intent)localObject1);
      this.a.finish();
      if ((QLog.isColorLevel()) && (paramSubAccountBackProtocData != null))
      {
        localObject2 = new StringBuilder().append("onBindSubAccount:");
        if (!paramBoolean) {
          break label905;
        }
      }
    }
    label905:
    for (Object localObject1 = "..success";; localObject1 = "...failed..")
    {
      QLog.d("SUB_ACCOUNT", 2, (String)localObject1 + " ...errorMsg = " + paramSubAccountBackProtocData.a + "...errorType = " + paramSubAccountBackProtocData.p);
      return;
      switch (paramSubAccountBackProtocData.p)
      {
      default: 
        localObject2 = this.a.getString(2131368697);
        localObject1 = localObject2;
        if (paramSubAccountBackProtocData != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            localObject1 = paramSubAccountBackProtocData.a;
          }
        }
        this.a.a((String)localObject1);
        break;
      case 1002: 
        SubAccountControll.a(this.a.app, this.a);
        break;
      case 1003: 
        this.a.a(this.a.getString(2131368694));
        break;
      case 1004: 
        switch (paramSubAccountBackProtocData.q)
        {
        default: 
          localObject2 = paramSubAccountBackProtocData.a;
          localObject1 = localObject2;
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.subaccount.SubAccountBindActivity", 2, "onBindSubAccount:bind error happen but msg is null shit, ");
            }
            localObject1 = this.a.getString(2131368697);
          }
          this.a.a((String)localObject1);
          break;
        case 1200: 
        case 1214: 
        case 1215: 
          localObject1 = this.a.getString(2131368681);
          localObject2 = this.a.getString(2131368695);
          this.a.a((String)localObject1, (String)localObject2, new fcu(this, paramSubAccountBackProtocData));
          break;
        case 1218: 
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            break;
          }
          localObject1 = this.a.app.a().getResources().getString(2131366753);
          this.a.a((String)localObject1);
          break;
        case 1232: 
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            break;
          }
          localObject1 = this.a.app.a().getResources().getString(2131368655);
          this.a.a((String)localObject1);
          break;
        case 1233: 
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            break;
          }
          localObject1 = this.a.app.a().getResources().getString(2131368656);
          this.a.a((String)localObject1);
          break;
        case 1240: 
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            break;
          }
          localObject1 = this.a.app.a().getResources().getString(2131368657);
          this.a.a((String)localObject1);
          break;
        case 1241: 
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            break;
          }
          localObject1 = this.a.app.a().getResources().getString(2131368658);
          this.a.a((String)localObject1);
          break;
        case 1242: 
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            break;
          }
          localObject1 = this.a.app.a().getResources().getString(2131368659);
          this.a.a((String)localObject1);
        }
        break;
      case 1011: 
        localObject2 = this.a.getString(2131368697);
        localObject1 = localObject2;
        if (paramSubAccountBackProtocData != null)
        {
          localObject1 = localObject2;
          if (!TextUtils.isEmpty(paramSubAccountBackProtocData.a)) {
            localObject1 = paramSubAccountBackProtocData.a;
          }
        }
        this.a.a((String)localObject1);
        localObject1 = new Intent(this.a, SubLoginActivity.class);
        ((Intent)localObject1).putExtra("subuin", paramSubAccountBackProtocData.c);
        ((Intent)localObject1).putExtra("fromWhere", this.a.a);
        this.a.startActivity((Intent)localObject1);
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fct
 * JD-Core Version:    0.7.0.1
 */