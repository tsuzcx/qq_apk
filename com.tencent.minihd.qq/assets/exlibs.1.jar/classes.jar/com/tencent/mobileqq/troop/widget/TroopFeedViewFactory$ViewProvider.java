package com.tencent.mobileqq.troop.widget;

import android.view.View;
import com.tencent.mobileqq.data.TroopFeedItem;
import java.util.ArrayList;
import java.util.List;

public abstract class TroopFeedViewFactory$ViewProvider
{
  protected int a;
  List a;
  
  public TroopFeedViewFactory$ViewProvider(TroopFeedViewFactory paramTroopFeedViewFactory)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = 1;
  }
  
  private View a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return (View)this.jdField_a_of_type_JavaUtilList.remove(0);
    }
    return null;
  }
  
  public abstract View a(View paramView, TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean);
  
  public View a(TroopFeedItem paramTroopFeedItem, int paramInt, boolean paramBoolean)
  {
    return a(a(), paramTroopFeedItem, paramInt, paramBoolean);
  }
  
  public void a(View paramView)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if (this.jdField_a_of_type_JavaUtilList.size() < this.jdField_a_of_type_Int) {
      this.jdField_a_of_type_JavaUtilList.add(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.TroopFeedViewFactory.ViewProvider
 * JD-Core Version:    0.7.0.1
 */