package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.troop.data.NearbyTroopsExpandableListViewAdapter;

public class NearbyTroopsExpandableListView
  extends PinnedHeaderIphoneTreeView
{
  public int a;
  public View a;
  public boolean a;
  
  public NearbyTroopsExpandableListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  public NearbyTroopsExpandableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  public NearbyTroopsExpandableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_Int = 0;
    }
    NearbyTroopsExpandableListViewAdapter localNearbyTroopsExpandableListViewAdapter = (NearbyTroopsExpandableListViewAdapter)a();
    if (localNearbyTroopsExpandableListViewAdapter == null) {
      return;
    }
    int j = localNearbyTroopsExpandableListViewAdapter.getGroupCount();
    int i = this.jdField_a_of_type_Int;
    while (i < j)
    {
      c(i);
      i += 1;
    }
    this.jdField_a_of_type_Int = j;
  }
  
  public void a_(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    a(paramView);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView != null)) {
      return this.jdField_a_of_type_AndroidViewView.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setShowBody(boolean paramBoolean)
  {
    NearbyTroopsExpandableListViewAdapter localNearbyTroopsExpandableListViewAdapter = (NearbyTroopsExpandableListViewAdapter)a();
    if (localNearbyTroopsExpandableListViewAdapter == null) {
      return;
    }
    if (paramBoolean)
    {
      localNearbyTroopsExpandableListViewAdapter.a(true);
      return;
    }
    localNearbyTroopsExpandableListViewAdapter.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.NearbyTroopsExpandableListView
 * JD-Core Version:    0.7.0.1
 */