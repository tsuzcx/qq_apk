import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.activity.contact.newfriend.ContactRecommendActivity;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

public class eyd
  extends ContactBindObserver
{
  public eyd(RegisterQQNumberActivity paramRegisterQQNumberActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "onUploadContact  isSuccess = " + paramBoolean);
    }
    RegisterQQNumberActivity.a(this.a);
    if (paramBoolean)
    {
      Intent localIntent = new Intent(this.a, ContactRecommendActivity.class);
      this.a.startActivity(localIntent);
      this.a.overridePendingTransition(2130968641, 0);
      this.a.finish();
      return;
    }
    RegisterQQNumberActivity.c(this.a);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RegisterQQNumberActivity", 2, "RegisterQQNumberActivity onGetBindUinWithPhone isSuccess = " + paramBoolean1 + "; isBindOk = " + paramBoolean2 + ";hadbind = " + paramBoolean3 + ";uin =" + paramString);
    }
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        RegisterQQNumberActivity.a(this.a, true);
        RegisterQQNumberActivity.b(this.a);
        return;
      }
      if ((paramBoolean3) && (!TextUtils.isEmpty(paramString)))
      {
        RegisterQQNumberActivity.a(this.a);
        Intent localIntent = new Intent(this.a, VerifyPhoneNumActivity.class);
        localIntent.putExtra("phonenum", this.a.d);
        localIntent.putExtra("key", this.a.e);
        localIntent.putExtra("uin", RegisterQQNumberActivity.a(this.a));
        localIntent.putExtra("key_register_sign", RegisterQQNumberActivity.a(this.a));
        localIntent.putExtra("key_register_binduin", paramString);
        this.a.startActivity(localIntent);
        this.a.finish();
        return;
      }
      RegisterQQNumberActivity.b(this.a);
      return;
    }
    RegisterQQNumberActivity.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     eyd
 * JD-Core Version:    0.7.0.1
 */