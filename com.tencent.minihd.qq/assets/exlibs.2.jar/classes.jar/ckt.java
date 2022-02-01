import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantActivity;
import com.tencent.mobileqq.activity.recent.RecentAdapter;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import java.util.List;

public class ckt
  implements Runnable
{
  public ckt(TroopBarAssistantActivity paramTroopBarAssistantActivity, List paramList) {}
  
  public void run()
  {
    if ((TroopBarAssistantActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountTroopbarassitTroopBarAssistantActivity).a() == -1) && (TroopBarAssistantActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountTroopbarassitTroopBarAssistantActivity) != null))
    {
      TroopBarAssistantActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountTroopbarassitTroopBarAssistantActivity).a(9);
      TroopBarAssistantActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountTroopbarassitTroopBarAssistantActivity).b(this.jdField_a_of_type_JavaUtilList);
      TroopBarAssistantActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountTroopbarassitTroopBarAssistantActivity).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ckt
 * JD-Core Version:    0.7.0.1
 */