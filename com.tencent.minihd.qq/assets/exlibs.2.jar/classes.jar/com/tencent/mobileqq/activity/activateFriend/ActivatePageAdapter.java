package com.tencent.mobileqq.activity.activateFriend;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.util.WeakReference;

public class ActivatePageAdapter
  extends PagerAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "ActivatePageAdapter";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private WeakReference jdField_a_of_type_MqqUtilWeakReference = null;
  
  public ActivatePageAdapter(ViewPager paramViewPager)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramViewPager);
  }
  
  public long a(int paramInt)
  {
    return paramInt;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
      return;
    }
    ((ViewPager)this.jdField_a_of_type_MqqUtilWeakReference.get()).setAdapter(null);
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ((ViewPager)this.jdField_a_of_type_MqqUtilWeakReference.get()).setAdapter(this);
  }
  
  public void a(ActivateBasePage paramActivateBasePage)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramActivateBasePage);
    notifyDataSetChanged();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ActivatePageAdapter", 4, "destroy item");
    }
    paramObject = (ActivateBasePage)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramObject.b();
    paramViewGroup.removeView(paramObject);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivatePageAdapter
 * JD-Core Version:    0.7.0.1
 */