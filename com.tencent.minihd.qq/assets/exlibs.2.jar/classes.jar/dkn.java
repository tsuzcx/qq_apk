import com.tencent.mobileqq.activity.Call;
import com.tencent.mobileqq.activity.recent.RecentCallHelper;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

public class dkn
  extends FriendListObserver
{
  public dkn(Call paramCall) {}
  
  protected void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CallTab", 2, "onUpdateFriendInfo uin = " + paramString + ", isSc = " + paramBoolean);
    }
    if (!paramBoolean) {}
    while (Utils.a(paramString, this.a.app.getAccount())) {
      return;
    }
    this.a.c();
  }
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean == true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CallTab", 2, "refresh CallTab, from_onupdatedelfriend");
      }
      this.a.c();
    }
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CallTab", 2, "ContactsActivity.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
    if (!paramBoolean) {}
    while (Utils.a(paramString, this.a.app.a())) {
      return;
    }
    this.a.runOnUiThread(new dko(this, paramString));
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CallTab", 2, "refresh CallTab, from_onupdatefriendlist");
      }
      this.a.c();
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("CallTab", 4, "onUpdateOnlineFriend| isSuc = " + paramBoolean);
    }
    if ((Call.a(this.a) != null) && (Call.a(this.a).c))
    {
      this.a.runOnUiThread(new dkp(this, paramBoolean));
      return;
    }
    if ((paramBoolean) && (Call.a(this.a) != null)) {
      this.a.runOnUiThread(new dkq(this));
    }
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dkn
 * JD-Core Version:    0.7.0.1
 */