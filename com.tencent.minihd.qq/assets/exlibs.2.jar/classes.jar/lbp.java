import android.view.View;
import android.widget.EditText;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.open.agent.FriendChooser;
import com.tencent.open.agent.OpenFrame;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.open.agent.datamodel.FriendDataManager;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

public class lbp
  implements AdapterView.OnItemClickListener
{
  public lbp(FriendChooser paramFriendChooser) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (Friend)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
    if ((paramAdapterView == null) || (this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramAdapterView.a))) {
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.c() >= this.a.j)
    {
      this.a.e();
      return;
    }
    paramView = (OpenFrame)this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.getCurrentView();
    this.a.c.add(paramAdapterView);
    this.a.jdField_a_of_type_ComTencentOpenAgentDatamodelFriendDataManager.a(paramAdapterView.a);
    this.a.j();
    paramView.g();
    this.a.b(false);
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lbp
 * JD-Core Version:    0.7.0.1
 */