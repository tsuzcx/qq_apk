import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantActivity;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import java.util.List;

public class cko
  implements Runnable
{
  public cko(EcShopAssistantActivity paramEcShopAssistantActivity, List paramList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragFrameLayout.a() == -1) && (this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter != null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.a(9);
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.b(this.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentBizPubaccountEcshopassitEcShopAssistantActivity.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentAdapter.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cko
 * JD-Core Version:    0.7.0.1
 */