import com.tencent.mobileqq.activity.qwallet.QWalletPushManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.qphone.base.util.BaseApplication;

public final class gto
  implements Runnable
{
  public gto(boolean paramBoolean, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    if (((this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a() == null) || (!GesturePWDUtils.getJumpLock(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()))) && (QWalletPushManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface))) {
      QWalletPushManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     gto
 * JD-Core Version:    0.7.0.1
 */