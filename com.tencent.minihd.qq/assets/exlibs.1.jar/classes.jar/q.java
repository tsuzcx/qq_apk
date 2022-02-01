import com.dataline.activities.DLRouterSessionInfoActivity;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.widget.XListView;

public class q
  implements Runnable
{
  public q(DLRouterSessionInfoActivity paramDLRouterSessionInfoActivity) {}
  
  public void run()
  {
    if (this.a.jdField_a_of_type_ComTencentWidgetXListView.b() > 2) {
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
    }
    try
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetScrollerRunnable.a(0, -1, null);
      this.a.jdField_a_of_type_ComTencentWidgetXListView.setTranscriptMode(1);
      return;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        this.a.jdField_a_of_type_ComTencentWidgetXListView.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     q
 * JD-Core Version:    0.7.0.1
 */