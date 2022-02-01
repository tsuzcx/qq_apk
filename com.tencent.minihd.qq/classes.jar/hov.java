import com.dataline.util.RouterSessionAdapter;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.RouterHandler;
import java.util.HashMap;

public class hov
  implements Runnable
{
  public hov(RouterHandler paramRouterHandler, long paramLong, int paramInt) {}
  
  public void run()
  {
    Session localSession = (Session)this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(this.jdField_a_of_type_Long));
    if ((this.jdField_a_of_type_Int == 2) && (localSession != null)) {
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(this.jdField_a_of_type_Long));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a(2, localSession, 0.0D, this.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hov
 * JD-Core Version:    0.7.0.1
 */