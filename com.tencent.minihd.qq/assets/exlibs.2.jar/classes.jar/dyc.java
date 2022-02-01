import android.content.Intent;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardHandlerActivity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil.FMDialogInterface;
import java.util.ArrayList;
import java.util.Iterator;

public class dyc
  implements FMDialogUtil.FMDialogInterface
{
  public dyc(ForwardHandlerActivity paramForwardHandlerActivity, ArrayList paramArrayList, Intent paramIntent) {}
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        ForwardFileInfo localForwardFileInfo = (ForwardFileInfo)localIterator.next();
        ChatActivityFacade.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardHandlerActivity.app, ForwardHandlerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityForwardHandlerActivity), this.jdField_a_of_type_ComTencentMobileqqActivityForwardHandlerActivity.a, this.jdField_a_of_type_AndroidContentIntent, localForwardFileInfo.a(), localForwardFileInfo, true);
      }
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dyc
 * JD-Core Version:    0.7.0.1
 */