import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import java.lang.ref.WeakReference;

public class dkd
  implements Runnable
{
  private ExtensionInfo jdField_a_of_type_ComTencentMobileqqDataExtensionInfo;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public dkd(ExtensionInfo paramExtensionInfo, QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo = paramExtensionInfo;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    }
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    } while (localQQAppInterface == null);
    ((FriendsManager)localQQAppInterface.getManager(49)).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dkd
 * JD-Core Version:    0.7.0.1
 */