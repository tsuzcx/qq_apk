import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.FriendChooser.GridViewAdapter;
import com.tencent.open.agent.OpenFrame;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import java.util.ArrayList;

public class lbn
  implements AdapterView.OnItemClickListener
{
  public lbn(FriendChooser paramFriendChooser) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Friend)this.a.jdField_a_of_type_ComTencentOpenAgentFriendChooser$GridViewAdapter.getItem(paramInt);
    if (this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramAdapterView.a))
    {
      this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.c(paramAdapterView.a);
      this.a.c.remove(paramAdapterView);
      this.a.j();
      ((OpenFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView()).g();
      this.a.b(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lbn
 * JD-Core Version:    0.7.0.1
 */