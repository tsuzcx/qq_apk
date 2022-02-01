import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.qphone.base.util.QLog;

public class hmk
  implements Runnable
{
  public hmk(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PhoneContact", 2, "syncBindState mCurrentBindState = " + this.a.a);
    }
    if (this.a.a >= 6) {
      return;
    }
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hmk
 * JD-Core Version:    0.7.0.1
 */