package com.tencent.widget.widget;

import android.view.View;
import android.widget.LinearLayout;
import com.tencent.widget.widget.adapters.WheelViewAdapter;
import java.util.LinkedList;
import java.util.List;

public class WheelRecycle
{
  private WheelView jdField_a_of_type_ComTencentWidgetWidgetWheelView;
  private List jdField_a_of_type_JavaUtilList;
  private List b;
  
  public WheelRecycle(WheelView paramWheelView)
  {
    this.jdField_a_of_type_ComTencentWidgetWidgetWheelView = paramWheelView;
  }
  
  private View a(List paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      View localView = (View)paramList.get(0);
      paramList.remove(0);
      return localView;
    }
    return null;
  }
  
  private List a(View paramView, List paramList)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new LinkedList();
    }
    ((List)localObject).add(paramView);
    return localObject;
  }
  
  private void a(View paramView, int paramInt)
  {
    int j = this.jdField_a_of_type_ComTencentWidgetWidgetWheelView.a().a();
    int i;
    if (paramInt >= 0)
    {
      i = paramInt;
      if (paramInt < j) {}
    }
    else
    {
      i = paramInt;
      if (!this.jdField_a_of_type_ComTencentWidgetWidgetWheelView.a())
      {
        this.b = a(paramView, this.b);
        return;
      }
    }
    while (i < 0) {
      i += j;
    }
    this.jdField_a_of_type_JavaUtilList = a(paramView, this.jdField_a_of_type_JavaUtilList);
  }
  
  public int a(LinearLayout paramLinearLayout, int paramInt, ItemsRange paramItemsRange)
  {
    int j = 0;
    int i = paramInt;
    if (j < paramLinearLayout.getChildCount())
    {
      int k;
      int m;
      if (!paramItemsRange.a(paramInt))
      {
        a(paramLinearLayout.getChildAt(j), paramInt);
        paramLinearLayout.removeViewAt(j);
        k = j;
        m = i;
        if (j == 0)
        {
          m = i + 1;
          k = j;
        }
      }
      for (;;)
      {
        paramInt += 1;
        j = k;
        i = m;
        break;
        k = j + 1;
        m = i;
      }
    }
    return i;
  }
  
  public View a()
  {
    return a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.jdField_a_of_type_JavaUtilList.clear();
    }
    if (this.b != null) {
      this.b.clear();
    }
  }
  
  public View b()
  {
    return a(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.widget.WheelRecycle
 * JD-Core Version:    0.7.0.1
 */