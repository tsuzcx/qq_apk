import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SubAccountBindObserver;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.subaccount.logic.SubAccountBackProtocData;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class dsu
  extends SubAccountBindObserver
{
  public dsu(Conversation paramConversation) {}
  
  protected void a(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("Conversation.onGetBindSubAccount() return, isSucc=").append(paramBoolean).append(" mSubUin=");
      if (paramSubAccountBackProtocData != null) {
        break label69;
      }
    }
    label69:
    for (Object localObject1 = null;; localObject1 = paramSubAccountBackProtocData.c)
    {
      QLog.d("SUB_ACCOUNT", 2, (String)localObject1);
      if (paramBoolean) {
        break;
      }
      if (QLog.isDevelopLevel()) {
        QLog.d("SUB_ACCOUNT", 4, "Conversation.onGetBindSubAccount() return.");
      }
      return;
    }
    if (paramSubAccountBackProtocData.p == 1008)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onGetBindSubAccount() delete all subAccountType RU, and add default RU.");
      }
      SubAccountControll.a(this.a.app, 0);
    }
    if (paramSubAccountBackProtocData.a())
    {
      SubAccountControll.a(this.a.app, paramSubAccountBackProtocData.a(), 2);
      this.a.app.e = true;
    }
    if (paramSubAccountBackProtocData.b())
    {
      localObject1 = paramSubAccountBackProtocData.b();
      if (localObject1 != null)
      {
        localObject1 = ((ArrayList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          SubAccountControll.c(this.a.app, (String)localObject2);
        }
      }
    }
    paramSubAccountBackProtocData.a();
    this.a.a(0L);
    Conversation.c(this.a);
  }
  
  protected void b(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() isSucc=" + paramBoolean);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.p + " errMsg=" + paramSubAccountBackProtocData.a);
      }
    }
    if ((paramBoolean) && (paramSubAccountBackProtocData != null) && (paramSubAccountBackProtocData.c())) {
      SubAccountControll.a(this.a.app, paramSubAccountBackProtocData.c(), 1);
    }
    this.a.a(0L);
  }
  
  protected void c(boolean paramBoolean, SubAccountBackProtocData paramSubAccountBackProtocData)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() isSucc=" + paramBoolean);
      if (paramSubAccountBackProtocData != null) {
        QLog.d("SUB_ACCOUNT", 2, "Conversation.onUnBindSubAccount() mainAccount=" + paramSubAccountBackProtocData.b + " subAccount=" + paramSubAccountBackProtocData.c + " errType=" + paramSubAccountBackProtocData.p + " errMsg=" + paramSubAccountBackProtocData.a);
      }
    }
    if (paramSubAccountBackProtocData == null) {}
    while ((!paramBoolean) || (paramSubAccountBackProtocData.c == null) || (paramSubAccountBackProtocData.c.length() <= 4)) {
      return;
    }
    this.a.app.a().c(paramSubAccountBackProtocData.c, 7000);
    SubAccountControll.c(this.a.app, paramSubAccountBackProtocData.c);
    this.a.a(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dsu
 * JD-Core Version:    0.7.0.1
 */