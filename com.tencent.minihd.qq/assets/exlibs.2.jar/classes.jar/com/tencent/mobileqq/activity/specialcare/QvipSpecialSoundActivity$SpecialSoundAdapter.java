package com.tencent.mobileqq.activity.specialcare;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import hai;
import haj;
import java.util.List;

public class QvipSpecialSoundActivity$SpecialSoundAdapter
  extends BaseAdapter
{
  private List jdField_a_of_type_JavaUtilList = null;
  
  public QvipSpecialSoundActivity$SpecialSoundAdapter(QvipSpecialSoundActivity paramQvipSpecialSoundActivity) {}
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    haj localhaj;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity.getLayoutInflater().inflate(2130904145, null);
      paramViewGroup = new hai(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity, null);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131301002));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131301003));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131301004));
      paramView.setOnClickListener(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity);
      paramView.setTag(paramViewGroup);
      localhaj = (haj)getItem(paramInt);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localhaj.jdField_a_of_type_JavaLangString);
      paramViewGroup.b.setText(localhaj.jdField_a_of_type_JavaLangString);
      paramView.setContentDescription(localhaj.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_Int = localhaj.jdField_a_of_type_Int;
      paramViewGroup.jdField_a_of_type_JavaLangString = localhaj.c;
      if (paramInt != 0) {
        break label255;
      }
      paramView.setBackgroundResource(2130838156);
      label154:
      if (localhaj.b != 1) {
        break label264;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity.getResources().getDrawable(2130840717));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    for (;;)
    {
      if (QvipSpecialCareManager.a(QvipSpecialSoundActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity), this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity.app) != localhaj.jdField_a_of_type_Int) {
        break label315;
      }
      paramView.findViewById(2131301005).setVisibility(0);
      paramViewGroup.b.setVisibility(0);
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      return paramView;
      paramViewGroup = (hai)paramView.getTag();
      break;
      label255:
      paramView.setBackgroundResource(2130838155);
      break label154;
      label264:
      if (localhaj.b == 2)
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqActivitySpecialcareQvipSpecialSoundActivity.getResources().getDrawable(2130840716));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      }
      else
      {
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    label315:
    paramView.findViewById(2131301005).setVisibility(8);
    paramViewGroup.b.setVisibility(8);
    paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundActivity.SpecialSoundAdapter
 * JD-Core Version:    0.7.0.1
 */