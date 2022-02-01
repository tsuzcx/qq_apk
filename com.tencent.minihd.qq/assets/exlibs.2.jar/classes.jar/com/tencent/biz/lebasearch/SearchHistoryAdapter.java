package com.tencent.biz.lebasearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cgz;
import com.tencent.mobileqq.data.SearchHistoryEntity;
import java.lang.ref.WeakReference;
import java.util.List;

public class SearchHistoryAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  public SearchHistoryAdapter.OnItemClickObserver a;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private List jdField_a_of_type_JavaUtilList;
  
  public SearchHistoryAdapter(Context paramContext, List paramList, SearchHistoryAdapter.OnItemClickObserver paramOnItemClickObserver)
  {
    this.jdField_a_of_type_ComTencentBizLebasearchSearchHistoryAdapter$OnItemClickObserver = null;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentBizLebasearchSearchHistoryAdapter$OnItemClickObserver = paramOnItemClickObserver;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size() + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return (SearchHistoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (Context)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    View localView;
    if (paramViewGroup == null) {
      localView = null;
    }
    do
    {
      return localView;
      if (paramView == null)
      {
        paramView = LayoutInflater.from(paramViewGroup).inflate(2130903485, null);
        paramViewGroup = new cgz(this);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298483));
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131298481));
        paramViewGroup.b = ((RelativeLayout)paramView.findViewById(2131298484));
        paramView.setTag(paramViewGroup);
        paramView.setOnClickListener(this);
      }
      for (;;)
      {
        paramViewGroup.jdField_a_of_type_Int = paramInt;
        if (paramInt >= this.jdField_a_of_type_JavaUtilList.size()) {
          break;
        }
        paramViewGroup.b.setVisibility(8);
        paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((SearchHistoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramInt)).keyWord);
        return paramView;
        paramViewGroup = (cgz)paramView.getTag();
      }
      localView = paramView;
    } while (paramInt != this.jdField_a_of_type_JavaUtilList.size());
    paramViewGroup.b.setVisibility(0);
    paramViewGroup.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    return paramView;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() instanceof cgz))
    {
      paramView = (cgz)paramView.getTag();
      if (paramView.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
        break label69;
      }
      if (this.jdField_a_of_type_ComTencentBizLebasearchSearchHistoryAdapter$OnItemClickObserver != null)
      {
        paramView = (SearchHistoryEntity)this.jdField_a_of_type_JavaUtilList.get(paramView.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentBizLebasearchSearchHistoryAdapter$OnItemClickObserver.a(paramView);
      }
    }
    label69:
    while ((paramView.jdField_a_of_type_Int != this.jdField_a_of_type_JavaUtilList.size()) || (this.jdField_a_of_type_ComTencentBizLebasearchSearchHistoryAdapter$OnItemClickObserver == null)) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizLebasearchSearchHistoryAdapter$OnItemClickObserver.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.lebasearch.SearchHistoryAdapter
 * JD-Core Version:    0.7.0.1
 */