import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberItem;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import java.util.List;

public class flf
  extends FacePreloadBaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public flf(TroopTransferActivity paramTroopTransferActivity, List paramList)
  {
    super(paramTroopTransferActivity, paramTroopTransferActivity.app, paramTroopTransferActivity.b, 1, true);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected Object a(int paramInt)
  {
    TroopTransferActivity.TroopMemberItem localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)getItem(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if (localTroopMemberItem != null) {
      localFaceInfo.a = localTroopMemberItem.a;
    }
    return localFaceInfo;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopTransferActivity.TroopMemberItem localTroopMemberItem;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.getLayoutInflater().inflate(2130904422, paramViewGroup, false);
      paramViewGroup = new flk(null);
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131297531));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131297297));
      ((TextView)paramView.findViewById(2131302143)).setText("");
      paramView.setTag(paramViewGroup);
      localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localTroopMemberItem.e)) || (localTroopMemberItem.e.equals(localTroopMemberItem.b))) {
        break label203;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopMemberItem.b + "(" + localTroopMemberItem.e + ")");
    }
    for (;;)
    {
      paramViewGroup.b = localTroopMemberItem.a;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem = localTroopMemberItem;
      paramViewGroup.d.setImageBitmap(a(1, localTroopMemberItem.a));
      return paramView;
      paramViewGroup = (flk)paramView.getTag();
      break;
      label203:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopMemberItem.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     flf
 * JD-Core Version:    0.7.0.1
 */