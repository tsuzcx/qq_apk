import com.tencent.biz.pubaccount.PublicAccountManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import java.lang.ref.WeakReference;
import mqq.observer.BusinessObserver;

public class cjv
  implements Runnable
{
  public cjv(PublicAccountManager paramPublicAccountManager) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((this.a.jdField_a_of_type_AndroidContentContext != null) && (localQQAppInterface != null)) {
      SosoInterface.a(new cjw(this, 0, true, 0L, true, false, "PublicAccountManager.getLocationThread()", localQQAppInterface));
    }
    while (localQQAppInterface == null) {
      return;
    }
    this.a.a(this.a.jdField_a_of_type_AndroidContentContext, localQQAppInterface, this.a.u, this.a.v, false, 0.0D, 0.0D, (BusinessObserver)PublicAccountManager.a(this.a).get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cjv
 * JD-Core Version:    0.7.0.1
 */