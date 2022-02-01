import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import java.util.List;

public class ffy
  implements Runnable
{
  public ffy(TroopAssistantActivity paramTroopAssistantActivity, List paramList) {}
  
  public void run()
  {
    RecentAdapter localRecentAdapter;
    if ((TroopAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity) != null) && (TroopAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity).a() == -1) && (TroopAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity) != null))
    {
      localRecentAdapter = TroopAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity);
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.b) {
        break label81;
      }
    }
    label81:
    for (int i = 3;; i = 4)
    {
      localRecentAdapter.a(i);
      TroopAssistantActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity).b(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqActivityTroopAssistantActivity.f();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ffy
 * JD-Core Version:    0.7.0.1
 */