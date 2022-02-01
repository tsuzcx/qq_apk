import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.BigEmoticonViewBinder;
import com.tencent.mobileqq.model.EmoticonManager;

public class ifo
  implements Runnable
{
  public ifo(BigEmoticonViewBinder paramBigEmoticonViewBinder) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    ((EmoticonManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(this.a.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage.epId, Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ifo
 * JD-Core Version:    0.7.0.1
 */