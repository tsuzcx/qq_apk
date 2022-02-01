import com.tencent.mobileqq.activity.VerifyPhoneNumActivity;
import com.tencent.mobileqq.phonecontact.ContactBindObserver;
import com.tencent.qphone.base.util.QLog;

public class fnp
  extends ContactBindObserver
{
  public fnp(VerifyPhoneNumActivity paramVerifyPhoneNumActivity) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerifyPhoneNumActivity", 2, "onUploadContact  isSuccess = " + paramBoolean);
    }
    VerifyPhoneNumActivity.b(this.a);
    if (paramBoolean)
    {
      VerifyPhoneNumActivity.e(this.a);
      VerifyPhoneNumActivity.b(this.a);
      return;
    }
    VerifyPhoneNumActivity.f(this.a);
    VerifyPhoneNumActivity.b(this.a);
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VerifyPhoneNumActivity", 2, "VerifyPhoneNumActivity onReBindMblWTLogin isSuccess = " + paramBoolean1 + "; resultOk = " + paramBoolean2);
    }
    this.a.a();
    if (paramBoolean1)
    {
      if (paramBoolean2)
      {
        VerifyPhoneNumActivity.a(this.a, true);
        VerifyPhoneNumActivity.d(this.a);
        return;
      }
      VerifyPhoneNumActivity.d(this.a);
      return;
    }
    VerifyPhoneNumActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     fnp
 * JD-Core Version:    0.7.0.1
 */