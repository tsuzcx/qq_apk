import android.text.TextUtils;
import com.tencent.mobileqq.activity.SubAccountMessageActivity;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.mobileqq.subaccount.datamanager.SubAccountManager;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;

public class fdy
  extends MessageObserver
{
  public fdy(SubAccountMessageActivity paramSubAccountMessageActivity) {}
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.i(SubAccountMessageActivity.a(this.a), 2, "onPushSubAccountMsg() isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.i(SubAccountMessageActivity.a(this.a), 2, "onPushSubAccountMsg() data.errorType=" + paramSubAccountBackProtocData.p + "  errorMsg=" + paramSubAccountBackProtocData.a + " mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + "  subAccount=" + paramSubAccountBackProtocData.c + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
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
      } while ((SubAccountMessageActivity.a(this.a) == null) || (!paramString.equals(SubAccountMessageActivity.a(this.a).subuin)));
      SubAccountMessageActivity.a(this.a, localSubAccountControll, paramString);
      return;
    } while ((SubAccountMessageActivity.a(this.a) == null) || (!paramString.equals(SubAccountMessageActivity.a(this.a).subuin)));
    localSubAccountControll.a(SubAccountMessageActivity.a(this.a).subuin, 1, true);
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    boolean bool2 = false;
    boolean bool1;
    if (QLog.isColorLevel())
    {
      String str = SubAccountMessageActivity.a(this.a);
      StringBuilder localStringBuilder = new StringBuilder().append("onSubAccountMsgNumConfirm isSucc=").append(paramBoolean).append(" subUin=").append(paramString1).append(" set need2ConfirmMsgNum=");
      if (!paramBoolean)
      {
        bool1 = true;
        QLog.d(str, 2, bool1 + " nextAction=" + paramString2);
      }
    }
    else
    {
      if ((paramString1 != null) && (SubAccountMessageActivity.a(this.a) != null) && (paramString1.equals(SubAccountMessageActivity.a(this.a).subuin))) {
        break label189;
      }
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder().append("onSubAccountMsgNumConfirm() return, subAccount=").append(paramString1).append(" mSubInfo.subuin=");
        if (SubAccountMessageActivity.a(this.a) != null) {
          break label175;
        }
        paramString1 = "null";
        label154:
        QLog.d("SUB_ACCOUNT", 2, paramString1);
      }
    }
    label175:
    label189:
    do
    {
      do
      {
        return;
        bool1 = false;
        break;
        paramString1 = SubAccountMessageActivity.a(this.a).subuin;
        break label154;
        paramString1 = this.a;
        bool1 = bool2;
        if (!paramBoolean) {
          bool1 = true;
        }
        SubAccountMessageActivity.b(paramString1, bool1);
        if (!"sub.account.unbind".equals(paramString2)) {
          break label256;
        }
        paramString1 = (SubAccountProtocManager)this.a.app.getManager(27);
      } while (paramString1 == null);
      paramString1.a(SubAccountMessageActivity.a(this.a).subuin);
      return;
      if ("sub.account.switchAccount".equals(paramString2))
      {
        paramString1 = (SubAccountManager)this.a.app.getManager(59);
        if (paramString1 != null) {
          paramString1.b(SubAccountMessageActivity.a(this.a).subuin);
        }
        this.a.app.a().c(SubAccountMessageActivity.a(this.a).subuin, 7000);
        SubAccountMessageActivity.a(this.a);
        return;
      }
    } while (!"sub.acocunt.toQZone".equals(paramString2));
    label256:
    paramString1 = (SubAccountManager)this.a.app.getManager(59);
    if (paramString1 != null) {
      paramString1.b(SubAccountMessageActivity.a(this.a).subuin);
    }
    this.a.app.a().c(SubAccountMessageActivity.a(this.a).subuin, 7000);
    SubAccountMessageActivity.a(this.a, true);
    SubAccountMessageActivity.a(this.a);
  }
  
  public void b(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.i(SubAccountMessageActivity.a(this.a), 2, "onGetSubAccountMsgNotify.isSuccess=" + paramBoolean + " subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.i(SubAccountMessageActivity.a(this.a), 2, "onGetSubAccountMsgNotify.data.errorType=" + paramSubAccountBackProtocData.p + "  errorMsg=" + paramSubAccountBackProtocData.a + " mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + "  subAccount=" + paramSubAccountBackProtocData.c + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    if ((paramString == null) || (SubAccountMessageActivity.a(this.a) == null) || (!paramString.equals(SubAccountMessageActivity.a(this.a).subuin)))
    {
      if (QLog.isColorLevel())
      {
        paramSubAccountBackProtocData = new StringBuilder().append("onGetSubAccountMsg() return, subAccount=").append(paramString).append(" mSubInfo.subuin=");
        if (SubAccountMessageActivity.a(this.a) != null) {
          break label217;
        }
      }
      label217:
      for (paramString = "null";; paramString = SubAccountMessageActivity.a(this.a).subuin)
      {
        QLog.d("SUB_ACCOUNT", 2, paramString);
        return;
      }
    }
    SubAccountMessageActivity.c(this.a, false);
    Object localObject = SubAccountMessageActivity.a(this.a);
    int i;
    if (paramBoolean)
    {
      i = 0;
      ((PullRefreshHeader)localObject).a(i);
      SubAccountMessageActivity.a(this.a, 800L);
      if (!paramBoolean) {
        break label307;
      }
      SubAccountMessageActivity.b(this.a);
      SubAccountMessageActivity.c(this.a);
    }
    for (;;)
    {
      SubAccountMessageActivity.d(this.a, false);
      return;
      i = 2;
      break;
      label307:
      if ((!paramBoolean) && (paramSubAccountBackProtocData != null))
      {
        localObject = this.a.getString(2131367300);
        switch (paramSubAccountBackProtocData.p)
        {
        case 1001: 
        case 1006: 
        case 1007: 
        case 1003: 
        case 1005: 
        case 1009: 
        default: 
          break;
        case 1002: 
          paramString = this.a.getString(2131368706);
          SubAccountMessageActivity.a(this.a, (String)localObject, paramString);
          break;
        case 1004: 
          String str = paramSubAccountBackProtocData.a;
          localObject = str;
          if (TextUtils.isEmpty(str)) {
            switch (paramSubAccountBackProtocData.q)
            {
            default: 
              localObject = this.a.getString(2131368695);
            }
          }
          for (;;)
          {
            SubAccountMessageActivity.a(this.a, 0, (String)localObject, paramString);
            break;
            localObject = this.a.getString(2131368695);
            continue;
            localObject = this.a.getString(2131368712);
            continue;
            localObject = this.a.getString(2131368711);
          }
        case 1008: 
          paramString = this.a.getString(2131368709);
          SubAccountMessageActivity.a(this.a, (String)localObject, paramString);
          break;
        case 1010: 
          if (SubAccountMessageActivity.b(this.a))
          {
            localObject = this.a.getString(2131368695);
            paramString = null;
            if (paramSubAccountBackProtocData != null) {
              paramString = paramSubAccountBackProtocData.c;
            }
            SubAccountMessageActivity.a(this.a, 1, (String)localObject, paramString);
          }
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fdy
 * JD-Core Version:    0.7.0.1
 */