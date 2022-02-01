package com.tencent.mobileqq.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.widget.LimitTextView;
import com.tencent.mobileqq.widget.PinnedDividerListView.DividerAdapter;
import com.tencent.qphone.base.util.QLog;
import evy;
import evz;
import ewa;
import ewc;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RecentSaidActivity$ListAdapter
  extends PinnedDividerListView.DividerAdapter
{
  private static final int jdField_a_of_type_Int = 0;
  private static final int b = 1;
  private static final int c = 2;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  
  protected RecentSaidActivity$ListAdapter(RecentSaidActivity paramRecentSaidActivity) {}
  
  public int a()
  {
    return 2130903703;
  }
  
  public void a(View paramView, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount())) {
      return;
    }
    evy localevy = ((evz)getItem(paramInt)).jdField_a_of_type_Evy;
    TextView localTextView = (TextView)paramView;
    CharSequence localCharSequence = localevy.a();
    paramView = localCharSequence;
    if (localevy.jdField_a_of_type_Int > 1) {
      paramView = localCharSequence.toString() + String.format(" (%d条)", new Object[] { Integer.valueOf(localevy.jdField_a_of_type_Int) });
    }
    localTextView.setText(paramView);
  }
  
  public boolean a(int paramInt)
  {
    return getItemViewType(paramInt) == 1;
  }
  
  public boolean a(List paramList)
  {
    paramList = paramList.iterator();
    if (paramList.hasNext())
    {
      ewc localewc = (ewc)paramList.next();
      Object localObject;
      if (this.jdField_a_of_type_JavaUtilList.size() > 0)
      {
        localObject = (evz)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_JavaUtilList.size() - 1);
        switch (Integer.signum(localewc.a((evz)localObject)))
        {
        }
      }
      for (;;)
      {
        int i = 1;
        for (;;)
        {
          if (i != 0)
          {
            localObject = new evy(this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity, localewc.jdField_a_of_type_Long);
            this.jdField_a_of_type_JavaUtilList.add(localObject);
            localevy = ((evy)localObject).jdField_a_of_type_Evy;
            localevy.jdField_a_of_type_Int += 1;
            localewc.jdField_a_of_type_Evy = ((evy)localObject);
          }
          this.jdField_a_of_type_JavaUtilList.add(localewc);
          break;
          evy localevy = ((evz)localObject).jdField_a_of_type_Evy;
          localevy.jdField_a_of_type_Int += 1;
          localewc.jdField_a_of_type_Evy = ((evz)localObject).jdField_a_of_type_Evy;
          i = 0;
          continue;
          i = 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("IphoneTitleBarActivity", 2, String.format("Illegal Argument: The item to insert must be the older than others! Item time: %d, Last item time: %d, Item count: %d", new Object[] { Long.valueOf(localewc.jdField_a_of_type_Long), Long.valueOf(((evz)localObject).jdField_a_of_type_Long), Integer.valueOf(this.jdField_a_of_type_JavaUtilList.size()) }));
        }
        ReportController.a(null, "P_CliOper", "BizTechReport", "", "recent_said", "item_orders_error", 0, 0, String.valueOf(localewc.jdField_a_of_type_Long), String.valueOf(((evz)localObject).jdField_a_of_type_Long), String.valueOf(this.jdField_a_of_type_JavaUtilList.size()), "");
      }
    }
    return true;
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
    if (((evz)getItem(paramInt) instanceof ewc)) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return paramView;
    case 0: 
      View localView = paramView;
      if (paramView == null)
      {
        localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity).inflate(2130903704, paramViewGroup, false);
        paramView = new ewa();
        paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetLimitTextView = ((LimitTextView)localView.findViewById(2131299365));
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131299366));
        localView.setTag(paramView);
      }
      paramView = (ewa)localView.getTag();
      paramViewGroup = (ewc)getItem(paramInt);
      paramView.jdField_a_of_type_ComTencentMobileqqTroopWidgetLimitTextView.setText(paramViewGroup.b);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(paramViewGroup.a());
      localView.setContentDescription(paramViewGroup.b + " " + paramViewGroup.a());
      return localView;
    }
    paramViewGroup = paramView;
    if (paramView == null) {
      paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity).inflate(a(), this.jdField_a_of_type_ComTencentMobileqqActivityRecentSaidActivity.a, false);
    }
    a(paramViewGroup, paramInt);
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RecentSaidActivity.ListAdapter
 * JD-Core Version:    0.7.0.1
 */