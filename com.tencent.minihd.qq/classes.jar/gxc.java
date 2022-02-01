import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.RenMaiQuanMemberListInnerFrame;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import com.tencent.mobileqq.app.CircleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.CircleBuddy;
import com.tencent.widget.XListView;
import java.util.ArrayList;

public class gxc
  extends FacePreloadBaseAdapter
{
  public gxc(RenMaiQuanMemberListInnerFrame paramRenMaiQuanMemberListInnerFrame, Context paramContext, QQAppInterface paramQQAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramQQAppInterface, paramXListView, paramInt, paramBoolean);
  }
  
  protected Object a(int paramInt)
  {
    CircleBuddy localCircleBuddy = (CircleBuddy)getItem(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    localFaceInfo.jdField_a_of_type_JavaLangString = localCircleBuddy.uin;
    localFaceInfo.jdField_a_of_type_Int = 1;
    return localFaceInfo;
  }
  
  public int getCount()
  {
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.jdField_a_of_type_JavaUtilArrayList.size())) {
      return (CircleBuddy)this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    CircleBuddy localCircleBuddy = (CircleBuddy)getItem(paramInt);
    View localView;
    if (paramView == null)
    {
      localView = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130904416, paramViewGroup, false);
      paramView = new gxd(null);
      paramView.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)localView.findViewById(2131297505));
      paramView.d = ((ImageView)localView.findViewById(2131296551));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131296582));
      localView.setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.b = localCircleBuddy.uin;
      paramViewGroup.d.setImageBitmap(a(localCircleBuddy.uin, 1, (byte)1));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localCircleBuddy));
      if (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.a(localCircleBuddy.uin)) {
        break label290;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      label161:
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_JavaUtilArrayList == null) || (!this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity.jdField_a_of_type_JavaUtilArrayList.contains(localCircleBuddy.uin))) {
        break label301;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(false);
      label203:
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqDataCircleBuddy = localCircleBuddy;
      if ((!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isChecked()) || (!paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.isEnabled())) {
        break label312;
      }
      localView.setContentDescription(this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localCircleBuddy) + "已选中,双击取消");
    }
    for (;;)
    {
      localView.setOnClickListener(this.a);
      return localView;
      paramViewGroup = (gxd)paramView.getTag();
      localView = paramView;
      break;
      label290:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      break label161;
      label301:
      paramViewGroup.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      break label203;
      label312:
      localView.setContentDescription(this.a.jdField_a_of_type_ComTencentMobileqqAppCircleManager.a(localCircleBuddy) + "未选中,双击选中");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     gxc
 * JD-Core Version:    0.7.0.1
 */