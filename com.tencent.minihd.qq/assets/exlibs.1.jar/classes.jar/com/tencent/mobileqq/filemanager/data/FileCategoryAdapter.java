package com.tencent.mobileqq.filemanager.data;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileCategoryAdapter
  extends BaseAdapter
{
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private BaseFileAssistantActivity jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity;
  private List jdField_a_of_type_JavaUtilList;
  private List b = new ArrayList();
  
  public FileCategoryAdapter(BaseFileAssistantActivity paramBaseFileAssistantActivity, List paramList, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity = paramBaseFileAssistantActivity;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  private void a()
  {
    this.b.clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      FileCategoryEntity localFileCategoryEntity = (FileCategoryEntity)localIterator.next();
      if ((localFileCategoryEntity.D == 0) && (localFileCategoryEntity.E == 2130903753)) {
        this.b.add(localFileCategoryEntity);
      }
    }
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
  
  public int getItemViewType(int paramInt)
  {
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).D == 0) {
      return 0;
    }
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).D == 3) {
      return 3;
    }
    if (((FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).D == 2) {
      return 2;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    FileCategoryEntity localFileCategoryEntity = (FileCategoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    Object localObject;
    if (localFileCategoryEntity == null)
    {
      localObject = null;
      return localObject;
    }
    a();
    if (paramView == null)
    {
      localObject = new FileCategoryAdapter.ItemHolder(this);
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(localFileCategoryEntity.E, paramViewGroup, false);
      paramView = new RedTouch(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity, paramView).d(30).a();
      paramView.setTag(localObject);
      paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      if ((localFileCategoryEntity.D == 0) || (localFileCategoryEntity.D == 3))
      {
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.findViewById(2131296742));
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidViewView = paramView.findViewById(2131298571);
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131299505));
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299506));
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131299509));
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299507));
        ((FileCategoryAdapter.ItemHolder)localObject).jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131299508));
        ((FileCategoryAdapter.ItemHolder)localObject).c = ((TextView)paramView.findViewById(2131297003));
        paramViewGroup = (ViewGroup)localObject;
      }
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Int = localFileCategoryEntity.H;
      paramViewGroup.jdField_a_of_type_JavaLangString = localFileCategoryEntity.jdField_c_of_type_JavaLangString;
      label252:
      int i;
      if (paramInt == 1)
      {
        paramView.setBackgroundResource(2130837951);
        if (localFileCategoryEntity.D != 0) {
          break label761;
        }
        if (paramViewGroup.jdField_a_of_type_AndroidViewViewGroup != null)
        {
          paramInt = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.getResources().getDimensionPixelSize(2131493499);
          i = this.b.indexOf(localFileCategoryEntity);
          if (i != 0) {
            break label571;
          }
          paramViewGroup.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130837639);
          paramView.setBackgroundResource(2130837958);
          paramView.setPadding(paramView.getPaddingLeft(), paramInt, paramView.getPaddingRight(), 0);
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        }
        label335:
        if (!localFileCategoryEntity.jdField_c_of_type_Boolean) {
          break label671;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        label351:
        if (!localFileCategoryEntity.jdField_b_of_type_Boolean) {
          break label683;
        }
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(localFileCategoryEntity.F);
        label371:
        if (localFileCategoryEntity.jdField_b_of_type_JavaLangString == null) {
          break label695;
        }
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.c.setText(localFileCategoryEntity.jdField_b_of_type_JavaLangString);
      }
      for (;;)
      {
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText(localFileCategoryEntity.jdField_a_of_type_JavaLangString);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(paramViewGroup);
        if (localFileCategoryEntity.jdField_a_of_type_Boolean) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText("(" + localFileCategoryEntity.G + ")");
        }
        if (16 != localFileCategoryEntity.H) {
          break label707;
        }
        paramViewGroup = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(35)).a(String.valueOf("100160.100162"));
        ((RedTouch)paramView).a(paramViewGroup);
        return paramView;
        if (localFileCategoryEntity.D != 1) {
          break label805;
        }
        ((FileCategoryAdapter.ItemHolder)localObject).d = ((TextView)paramView.findViewById(2131299480));
        ((FileCategoryAdapter.ItemHolder)localObject).e = ((TextView)paramView.findViewById(2131299481));
        paramViewGroup = (ViewGroup)localObject;
        break;
        paramViewGroup = (FileCategoryAdapter.ItemHolder)paramView.getTag();
        break;
        paramView.setBackgroundResource(0);
        break label252;
        label571:
        if (i == this.b.size() - 1)
        {
          paramViewGroup.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130837637);
          paramView.setBackgroundResource(2130837955);
          paramView.setPadding(paramView.getPaddingLeft(), 0, paramView.getPaddingRight(), paramInt);
          paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(4);
          break label335;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130837638);
        paramView.setBackgroundResource(2130837952);
        paramView.setPadding(paramView.getPaddingLeft(), 0, paramView.getPaddingRight(), 0);
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
        break label335;
        label671:
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label351;
        label683:
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        break label371;
        label695:
        paramViewGroup.c.setVisibility(8);
      }
      label707:
      if (17 == localFileCategoryEntity.H)
      {
        paramViewGroup = ((RedTouchManager)this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityBaseFileAssistantActivity.app.getManager(35)).a(String.valueOf("100160.100161"));
        ((RedTouch)paramView).a(paramViewGroup);
        return paramView;
      }
      ((RedTouch)paramView).a();
      return paramView;
      label761:
      localObject = paramView;
      if (localFileCategoryEntity.D != 1) {
        break;
      }
      if (localFileCategoryEntity.jdField_a_of_type_Boolean)
      {
        paramViewGroup.e.setText(localFileCategoryEntity.jdField_a_of_type_JavaLangString);
        return paramView;
      }
      paramViewGroup.e.setVisibility(4);
      return paramView;
      label805:
      paramViewGroup = (ViewGroup)localObject;
    }
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.FileCategoryAdapter
 * JD-Core Version:    0.7.0.1
 */