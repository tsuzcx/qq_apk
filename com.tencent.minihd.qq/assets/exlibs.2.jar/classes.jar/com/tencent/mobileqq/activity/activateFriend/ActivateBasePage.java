package com.tencent.mobileqq.activity.activateFriend;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public abstract class ActivateBasePage
  extends RelativeLayout
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  View jdField_a_of_type_AndroidViewView = null;
  public Button a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  public ActivateFriendGrid a;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  
  public ActivateBasePage(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    a();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.setTextScrolling(false);
    }
  }
  
  public ActivateBasePage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  public abstract void a();
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityActivateFriendActivateFriendGrid.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.ActivateBasePage
 * JD-Core Version:    0.7.0.1
 */