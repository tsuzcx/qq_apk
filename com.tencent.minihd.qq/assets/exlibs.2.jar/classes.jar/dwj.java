import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.DiscussionMemberActivity;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter.FaceInfo;
import java.util.List;

public class dwj
  extends FacePreloadBaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public dwj(DiscussionMemberActivity paramDiscussionMemberActivity, List paramList)
  {
    super(paramDiscussionMemberActivity, paramDiscussionMemberActivity.app, paramDiscussionMemberActivity.a, 1, true);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  protected Object a(int paramInt)
  {
    dwg localdwg = (dwg)getItem(paramInt);
    FacePreloadBaseAdapter.FaceInfo localFaceInfo = new FacePreloadBaseAdapter.FaceInfo(this);
    if (localdwg != null)
    {
      localFaceInfo.jdField_a_of_type_JavaLangString = localdwg.jdField_a_of_type_JavaLangString;
      localFaceInfo.jdField_a_of_type_Int = 1;
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
    dwg localdwg;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.getLayoutInflater().inflate(2130903280, paramViewGroup, false);
      paramViewGroup = new dwl(null);
      paramViewGroup.d = ((ImageView)paramView.findViewById(2131297531));
      paramViewGroup.a = ((TextView)paramView.findViewById(2131297297));
      paramView.setTag(paramViewGroup);
      localdwg = (dwg)getItem(paramInt);
      if ((localdwg.b != null) && (!"".equals(localdwg.b.trim()))) {
        break label144;
      }
      paramViewGroup.a.setText(localdwg.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      paramViewGroup.b = localdwg.jdField_a_of_type_JavaLangString;
      paramViewGroup.d.setImageBitmap(a(1, localdwg.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (dwl)paramView.getTag();
      break;
      label144:
      paramViewGroup.a.setText(localdwg.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dwj
 * JD-Core Version:    0.7.0.1
 */