package com.tencent.mobileqq.dating;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DatingInfo;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.List;

public class DatingFeedAdapter
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView;
  private DatingItemBuilder jdField_a_of_type_ComTencentMobileqqDatingDatingItemBuilder;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public DatingFeedAdapter(Context paramContext, QQAppInterface paramQQAppInterface, FaceDecoder paramFaceDecoder)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemBuilder = new DatingItemBuilder(paramQQAppInterface, paramContext, paramFaceDecoder);
  }
  
  public DatingItemBuilder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemBuilder;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
  }
  
  public void a(String paramString)
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      if (((DatingInfo)this.jdField_a_of_type_JavaUtilList.get(i)).datingId.equals(paramString))
      {
        this.jdField_a_of_type_JavaUtilList.remove(i);
        DatingUtil.a("removeDatingFeedData success. " + paramString, new Object[0]);
        notifyDataSetChanged();
        return;
      }
      i += 1;
    }
    DatingUtil.a("DatingFeedData to remove not found. " + paramString, new Object[0]);
  }
  
  public void a(List paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      long l1 = System.currentTimeMillis();
      this.jdField_a_of_type_JavaUtilList.removeAll(paramList);
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.i("Q.dating", 2, "datingFeedAdapter addDatingFeedsData cost time is: " + (l2 - l1));
      }
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  public void b(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaUtilList.size())
    {
      int j = i;
      if (i == 0)
      {
        j = i;
        if (this.jdField_a_of_type_AndroidViewView != null) {
          j = 1;
        }
      }
      return j;
    }
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (DatingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0))
    {
      float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
      paramInt = (int)(paramViewGroup.getHeight() - (60.0F * f + 0.5F));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams(new AbsListView.LayoutParams(-1, paramInt));
      return this.jdField_a_of_type_AndroidViewView;
    }
    DatingInfo localDatingInfo = (DatingInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    if (!this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemBuilder.a(paramView)) {
      paramView = this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemBuilder.a(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqDatingDatingItemBuilder.a(0, paramInt, paramView, localDatingInfo, null);
      return paramView;
    }
  }
  
  public boolean isEmpty()
  {
    return (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.dating.DatingFeedAdapter
 * JD-Core Version:    0.7.0.1
 */