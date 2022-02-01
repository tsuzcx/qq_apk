import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.UserguideActivity;
import com.tencent.mobileqq.activity.phone.PhoneLaunchActivity;
import com.tencent.mobileqq.activity.phone.PhoneMatchActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.mybusiness.MyBusinessManager;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.mobileqq.phonelogin.PhoneNumLoginImpl;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public class hmc
  extends ContactBindObserver
{
  boolean jdField_a_of_type_Boolean = false;
  
  public hmc(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  private boolean a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d();
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
    long l2 = System.currentTimeMillis();
    long l1 = -1L;
    RespondQueryQQBindingStat localRespondQueryQQBindingStat = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a();
    if (localRespondQueryQQBindingStat != null) {
      l1 = localRespondQueryQQBindingStat.lastUsedFlag;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "isShouldQueryContacts state:" + i + ", isFirst:" + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Boolean + ", isAccessable:" + bool + ", currentTime:" + l2 + ", uploadTime:" + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_d_of_type_Long + ", downloadTime:" + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b + ", lastUsedFlag:" + l1 + ", mCurrentBindState:" + this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int);
    }
    return (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.g()) && (bool) && (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int != 6) && (l1 != 2L) && (l2 - this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_d_of_type_Long > 120000L);
  }
  
  void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "phoneContactOb.onQueryBindState() is called,isOpeningShare is:" + PhoneContactManagerImp.jdField_c_of_type_Boolean);
    }
    if (PhoneContactManagerImp.jdField_c_of_type_Boolean) {}
    label186:
    do
    {
      do
      {
        do
        {
          return;
          if (!UserguideActivity.a(PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).a(), PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).a())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("ThemeDownloadTrace", 2, "UserguideActivity.showUserGuideThisTime = ture");
        return;
        if (!this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.d()) {
          break;
        }
      } while (PhoneNumLoginImpl.a().a());
      localObject = null;
      BaseActivity localBaseActivity = null;
      if (PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).isLogin())
      {
        this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b();
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloadTrace", 2, "bindState = " + -1);
        }
      }
      StringBuilder localStringBuilder;
      switch (-1)
      {
      default: 
        localObject = localBaseActivity;
        ContactUtils.a(PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp), 1);
        localBaseActivity = BaseActivity.sTopActivity;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("topActivity is:").append(localBaseActivity).append(",isFinishing is:");
          if (localBaseActivity == null) {
            break label414;
          }
        }
        break;
      }
      for (boolean bool = localBaseActivity.isFinishing();; bool = false)
      {
        QLog.d("ThemeDownloadTrace", 2, bool + ",i is:" + localObject);
        if ((localBaseActivity == null) || (localBaseActivity.isFinishing()) || (localBaseActivity.getAppRuntime() != PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp))) {
          break label427;
        }
        if ((localBaseActivity instanceof UserguideActivity)) {
          break;
        }
        if (localObject == null) {
          break label419;
        }
        localBaseActivity.startActivity((Intent)localObject);
        localBaseActivity.overridePendingTransition(2130968746, 2130968592);
        return;
        localObject = new Intent(PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).a().getApplicationContext(), PhoneLaunchActivity.class);
        ((Intent)localObject).putExtra("needAlert", true);
        ContactUtils.a(PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp));
        break label186;
        localObject = localBaseActivity;
        if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a() == null) {
          break label186;
        }
        localObject = localBaseActivity;
        if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.a().lastUsedFlag != 3L) {
          break label186;
        }
        localObject = new Intent(PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).a().getApplicationContext(), PhoneMatchActivity.class);
        break label186;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.k();
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.k();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, "mgr.isPhoneContactFirstRun() result is false");
      }
    } while ((!PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).isLogin()) || (!ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp, PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp))) || (BaseActivity.sTopActivity == null));
    label414:
    label419:
    label427:
    Object localObject = new Intent(PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).a().getApplicationContext(), PhoneLaunchActivity.class);
    ((Intent)localObject).putExtra("needAlert", true);
    BaseActivity.sTopActivity.startActivity((Intent)localObject);
    BaseActivity.sTopActivity.overridePendingTransition(2130968746, 2130968592);
  }
  
  protected void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("contact_bind_info_upload", paramBoolean).commit();
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_d_of_type_Long = 0L;
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int = 8;
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e();
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
      PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp, 2);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_d_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int = 5;
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if ((paramBoolean) && (paramInt == 0))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
    }
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_c_of_type_Long = 0L;
    if (this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Boolean) {
      c(paramBoolean1);
    }
    if (paramBoolean3) {
      a();
    }
    if (a()) {
      PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp);
    }
    if ((this.jdField_a_of_type_Boolean) && (paramBoolean2))
    {
      RespondQueryQQBindingStat localRespondQueryQQBindingStat = ((PhoneContactManager)PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).getManager(10)).a();
      if ((localRespondQueryQQBindingStat == null) || (TextUtils.isEmpty(localRespondQueryQQBindingStat.mobileNo))) {
        break label131;
      }
      ((MyBusinessManager)PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).getManager(48)).a(localRespondQueryQQBindingStat.mobileNo, localRespondQueryQQBindingStat.type, "");
      this.jdField_a_of_type_Boolean = false;
    }
    label131:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("PhoneContact", 2, "mybusiness bindInfo null ");
  }
  
  protected void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ((MyBusinessManager)PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).getManager(48)).a("", 0, "");
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.c();
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int = 1;
    }
  }
  
  protected void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.b = 0L;
    if ((paramBoolean1) && (paramBoolean2)) {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e();
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int = 11;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.jdField_a_of_type_Int = 10;
  }
  
  void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      hmd localhmd = new hmd(this);
      PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp).a(localhmd);
    }
  }
  
  protected void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp, true);
  }
  
  protected void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp.e();
      PhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hmc
 * JD-Core Version:    0.7.0.1
 */