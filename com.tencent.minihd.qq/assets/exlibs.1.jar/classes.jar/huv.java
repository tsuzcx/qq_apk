import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.utils.StartupTracker;

public class huv
  implements Runnable
{
  public huv(BubbleManager paramBubbleManager, int paramInt) {}
  
  public void run()
  {
    StartupTracker.a(null, "AIO_bubble_craete_bubble_info");
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.jdField_a_of_type_Int, true);
    StartupTracker.a("AIO_bubble_craete_bubble_info", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     huv
 * JD-Core Version:    0.7.0.1
 */