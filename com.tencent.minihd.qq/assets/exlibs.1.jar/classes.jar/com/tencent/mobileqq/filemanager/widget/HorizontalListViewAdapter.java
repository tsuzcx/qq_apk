package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.filemanager.fileviewer.ActionBar.ActionBar;
import com.tencent.widget.ActionSheet;
import java.util.ArrayList;

public class HorizontalListViewAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  ArrayList jdField_a_of_type_JavaUtilArrayList;
  
  public HorizontalListViewAdapter(Context paramContext, ActionSheet paramActionSheet, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramActionSheet;
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)this.jdField_a_of_type_AndroidContentContext.getSystemService("layout_inflater"));
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramViewGroup = new HorizontalListViewAdapter.HlistViewHolder();
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903750, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299494));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299495));
      paramView.setTag(paramViewGroup);
      if (paramInt != this.jdField_a_of_type_Int) {
        break label161;
      }
      paramView.setSelected(true);
      label67:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((ActionBar)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a());
      if (Build.VERSION.SDK_INT < 16) {
        break label169;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackground(((ActionBar)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a());
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_ComTencentWidgetActionSheet = this.jdField_a_of_type_ComTencentWidgetActionSheet;
      paramView.setTag(paramViewGroup);
      paramView.setOnClickListener(((ActionBar)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a());
      return paramView;
      paramViewGroup = (HorizontalListViewAdapter.HlistViewHolder)paramView.getTag();
      break;
      label161:
      paramView.setSelected(false);
      break label67;
      label169:
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(((ActionBar)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter
 * JD-Core Version:    0.7.0.1
 */