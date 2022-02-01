import android.app.Application;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

public class emt
  implements DialogInterface.OnClickListener
{
  public emt(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    String str = null;
    paramDialogInterface = this.a.app.getApplication().getAllAccounts();
    Object localObject1;
    Object localObject2;
    if ((paramDialogInterface != null) && (paramDialogInterface.size() > 0))
    {
      localObject1 = this.a.app.getAccount();
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        localObject2 = paramDialogInterface.iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramDialogInterface = (SimpleAccount)((Iterator)localObject2).next();
        } while (!((String)localObject1).equals(paramDialogInterface.getUin()));
      }
    }
    for (;;)
    {
      this.a.finish();
      this.a.app.setKickIntent(null);
      if (paramDialogInterface != null)
      {
        SharedPreUtils.a(this.a.getApplication().getApplicationContext(), paramDialogInterface.getUin(), true);
        this.a.app.login(paramDialogInterface);
        return;
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("password", null);
      if (!PhoneNumLoginImpl.a().a(this.a.app, this.a.app.a()))
      {
        this.a.app.updateSubAccountLogin(this.a.app.a(), false);
        this.a.app.getApplication().refreAccountList();
      }
      localObject2 = (SubAccountManager)this.a.app.getManager(59);
      paramDialogInterface = str;
      if (localObject2 != null) {
        paramDialogInterface = ((SubAccountManager)localObject2).a();
      }
      if ((paramDialogInterface != null) && (paramDialogInterface.size() > 0))
      {
        paramDialogInterface = paramDialogInterface.iterator();
        while (paramDialogInterface.hasNext())
        {
          str = (String)paramDialogInterface.next();
          if (!PhoneNumLoginImpl.a().a(this.a.app, str))
          {
            this.a.app.updateSubAccountLogin(str, false);
            this.a.app.getApplication().refreAccountList();
          }
        }
      }
      this.a.startActivity(new Intent(this.a, LoginActivity.class).putExtras((Bundle)localObject1).addFlags(67108864));
      return;
      paramDialogInterface = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     emt
 * JD-Core Version:    0.7.0.1
 */