import QQService.TagInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ToggleButton;
import com.tencent.mobileqq.activity.EditTagActivity;
import java.util.ArrayList;

public class dxe
  extends BaseAdapter
{
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public dxe(EditTagActivity paramEditTagActivity, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new ToggleButton(paramViewGroup.getContext());
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, (int)(28.0F * this.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_Float)));
      paramView.setBackgroundResource(2130842034);
      ((ToggleButton)paramView).setGravity(17);
      ((ToggleButton)paramView).setTextSize(this.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.getResources().getInteger(2131623940));
      ((ToggleButton)paramView).setTextColor(Color.parseColor("#777777"));
    }
    for (;;)
    {
      ((ToggleButton)paramView).setOnCheckedChangeListener(null);
      ((ToggleButton)paramView).setChecked(this.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.a((TagInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt), this.jdField_a_of_type_ComTencentMobileqqActivityEditTagActivity.jdField_a_of_type_JavaUtilArrayList));
      ((ToggleButton)paramView).setOnCheckedChangeListener(new dxf(this, paramInt));
      ((ToggleButton)paramView).setText(((TagInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).strContent);
      ((ToggleButton)paramView).setTextOn(((TagInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).strContent);
      ((ToggleButton)paramView).setTextOff(((TagInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).strContent);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     dxe
 * JD-Core Version:    0.7.0.1
 */