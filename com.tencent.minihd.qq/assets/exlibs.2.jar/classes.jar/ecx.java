import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.GesturePWDCreateActivity;

public class ecx
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  
  public ecx(GesturePWDCreateActivity paramGesturePWDCreateActivity, Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a.length;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a != null) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a.length) && (paramInt >= 0)) {
      return Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a[paramInt]);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903333, null);
    }
    paramView = paramViewGroup.findViewById(2131297756);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a != null) && (paramInt >= 0) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a.length) && (this.jdField_a_of_type_ComTencentMobileqqActivityGesturePWDCreateActivity.a[paramInt] > 0))
    {
      paramView.setBackgroundResource(2130840326);
      return paramViewGroup;
    }
    paramView.setBackgroundResource(2130842210);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     ecx
 * JD-Core Version:    0.7.0.1
 */