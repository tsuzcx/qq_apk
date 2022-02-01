import com.dataline.activities.DLRouterActivity;
import com.dataline.activities.LiteActivity;
import com.dataline.util.RouterSessionAdapter;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.RouterHandler;
import java.util.HashMap;

public class hos
  implements Runnable
{
  public hos(RouterHandler paramRouterHandler, Session paramSession) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(this.jdField_a_of_type_ComTencentLitetransfersdkSession.uSessionID), this.jdField_a_of_type_ComTencentLitetransfersdkSession);
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a(3, this.jdField_a_of_type_ComTencentLitetransfersdkSession, 0.0D, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.b();
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.notifyDataSetChanged();
      LiteActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable, this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.a.jdField_a_of_type_ComTencentWidgetXListView);
      LiteActivity.a(this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.a.jdField_a_of_type_ComTencentWidgetXListView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hos
 * JD-Core Version:    0.7.0.1
 */