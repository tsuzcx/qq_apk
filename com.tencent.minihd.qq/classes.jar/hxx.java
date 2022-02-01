import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

public class hxx
  extends ContactBindObserver
{
  public hxx(ContactSyncManager paramContactSyncManager) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    PhoneContactManager localPhoneContactManager = (PhoneContactManager)this.a.a.getManager(10);
    int i = localPhoneContactManager.b();
    String str1 = this.a.a.a();
    String str2 = this.a.a();
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryBindState | state = " + i + " | syncUin = " + ContactSyncManager.b(str2) + " | currentUin = " + ContactSyncManager.b(str1));
    }
    if (localPhoneContactManager.g()) {
      if (!TextUtils.isEmpty(str2)) {}
    }
    do
    {
      do
      {
        ContactSyncManager.a(this.a);
        do
        {
          return;
        } while (str1.equals(str2));
        ContactSyncManager.a(this.a);
        ContactSyncManager.a(this.a);
        return;
      } while ((i != 2) && (i != 1));
      ContactSyncManager.b(this.a);
    } while ((TextUtils.isEmpty(str2)) || (!str2.equals(this.a.a.a())));
    ContactSyncManager.a(this.a);
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Manager", 2, "onQueryContactList | isSuccess = " + paramBoolean1 + " | hasUpdate = " + paramBoolean2);
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hxx
 * JD-Core Version:    0.7.0.1
 */