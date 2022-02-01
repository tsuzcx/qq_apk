import com.dataline.util.RouterSessionAdapter;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.RouterHandler;
import java.util.HashMap;

public class hou
  implements Runnable
{
  public hou(RouterHandler paramRouterHandler, long paramLong1, long paramLong2, long paramLong3) {}
  
  public void run()
  {
    Session localSession = (Session)this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(this.jdField_a_of_type_Long));
    this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.a(1, localSession, (float)((float)this.b * 1.0D / (float)this.c), 0);
    if (this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppRouterHandler.jdField_a_of_type_ComDatalineUtilRouterSessionAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hou
 * JD-Core Version:    0.7.0.1
 */