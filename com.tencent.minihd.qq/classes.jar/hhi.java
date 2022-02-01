import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.service.circle.IFriendObserver;
import java.util.Iterator;
import java.util.LinkedList;

public class hhi
  implements Runnable
{
  public hhi(CircleManager paramCircleManager, String paramString) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.c != null)
    {
      Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqAppCircleManager.c.iterator();
      while (localIterator.hasNext()) {
        ((IFriendObserver)localIterator.next()).a(this.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     hhi
 * JD-Core Version:    0.7.0.1
 */