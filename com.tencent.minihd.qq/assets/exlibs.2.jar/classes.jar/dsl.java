import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;

public class dsl
  extends MessageObserver
{
  public dsl(Conversation paramConversation) {}
  
  protected void a()
  {
    TroopAssistantManager.a().c(this.a.app);
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0) {
      this.a.runOnUiThread(new dso(this));
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    paramString = RecentDataListManager.a(paramString, -2147483648);
    this.a.a(2, 9, paramString);
  }
  
  public void a(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() isSuccess=" + paramBoolean + " subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onPushSubAccountMsgNotify() mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + " subAccount=" + paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString + " data.errorType=" + paramSubAccountBackProtocData.p + " errorMsg=" + paramSubAccountBackProtocData.a + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    if ((!paramBoolean) || (paramSubAccountBackProtocData == null)) {
      return;
    }
    if (paramSubAccountBackProtocData.p == 0)
    {
      SubAccountControll.a(this.a.app, paramString, 1);
      paramSubAccountBackProtocData = (SubAccountControll)this.a.app.getManager(60);
      if (paramSubAccountBackProtocData != null) {
        paramSubAccountBackProtocData.a(paramString, 1, true);
      }
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      if (paramSubAccountBackProtocData.p == 1)
      {
        SubAccountControll.c(this.a.app, paramString);
        Conversation.c(this.a);
      }
    }
  }
  
  public void b(boolean paramBoolean, String paramString, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.isSuccess=" + paramBoolean + "  subAccount=" + paramString);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "onGetSubAccountMsgNotify.data.errorType=" + paramSubAccountBackProtocData.p + " errorMsg=" + paramSubAccountBackProtocData.a + " mainAccount=" + paramSubAccountBackProtocData.jdField_b_of_type_JavaLangString + "  subAccount=" + paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString + " isNeedStartGetMsg=" + paramSubAccountBackProtocData.jdField_b_of_type_Boolean);
      }
    }
    if (paramSubAccountBackProtocData != null) {
      switch (paramSubAccountBackProtocData.p)
      {
      default: 
        if ((paramSubAccountBackProtocData.jdField_c_of_type_Boolean) && (!paramSubAccountBackProtocData.d) && (paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString != null) && (paramSubAccountBackProtocData.jdField_c_of_type_JavaLangString.length() > 4))
        {
          SubAccountControll.a(this.a.app, paramString, 6);
          paramSubAccountBackProtocData.d = true;
        }
        break;
      }
    }
    for (;;)
    {
      this.a.a(0L);
      return;
      SubAccountControll.c(this.a.app, paramString);
      continue;
      SubAccountControll.a(this.a.app, 0);
    }
  }
  
  protected void c()
  {
    this.a.a(0L);
  }
  
  protected void c(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "onGetOfflineMsgFinished|isSuc = " + paramBoolean);
    }
    if (this.a.b != 1000L) {
      this.a.b = 1000L;
    }
    this.a.runOnUiThread(new dsm(this, paramBoolean));
  }
  
  protected void d(boolean paramBoolean)
  {
    this.a.runOnUiThread(new dsn(this, paramBoolean));
  }
  
  public void d(boolean paramBoolean, String paramString)
  {
    this.a.a(8, paramString, -2147483648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dsl
 * JD-Core Version:    0.7.0.1
 */