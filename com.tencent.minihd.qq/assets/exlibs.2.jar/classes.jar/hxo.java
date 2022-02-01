import com.tencent.mobileqq.config.NearbyBannerManager;
import com.tencent.mobileqq.config.NearbyBannerManager.INearbyBannerListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class hxo
  implements Runnable
{
  public hxo(NearbyBannerManager paramNearbyBannerManager, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqConfigNearbyBannerManager.a.iterator();
    while (localIterator.hasNext()) {
      ((NearbyBannerManager.INearbyBannerListener)localIterator.next()).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     hxo
 * JD-Core Version:    0.7.0.1
 */