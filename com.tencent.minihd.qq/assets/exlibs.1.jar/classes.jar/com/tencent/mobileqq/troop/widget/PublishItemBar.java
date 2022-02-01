package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.utils.DisplayUtils;

public class PublishItemBar
  extends LinearLayout
  implements View.OnClickListener
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  private boolean c = false;
  private boolean d = false;
  
  public PublishItemBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(int paramInt)
  {
    boolean bool2 = false;
    if ((paramInt & 0x1) == 1)
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      if ((paramInt & 0x2) != 2) {
        break label327;
      }
      bool1 = true;
      label25:
      this.b = bool1;
      if ((paramInt & 0x8) != 8) {
        break label332;
      }
    }
    label327:
    label332:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.c = bool1;
      bool1 = bool2;
      if ((paramInt & 0x4) == 4) {
        bool1 = true;
      }
      this.d = bool1;
      if (getChildCount() > 0) {
        removeAllViews();
      }
      ImageButton localImageButton;
      if (this.jdField_a_of_type_Boolean)
      {
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(1));
        localImageButton.setImageResource(2130839190);
        localImageButton.setContentDescription(getResources().getString(2131364061));
        a(localImageButton);
      }
      if (this.b)
      {
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(2));
        localImageButton.setImageResource(2130839184);
        localImageButton.setContentDescription(getResources().getString(2131364063));
        a(localImageButton);
      }
      if (this.c)
      {
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(3));
        localImageButton.setImageResource(2130839191);
        localImageButton.setContentDescription(getResources().getString(2131364065));
        a(localImageButton);
      }
      if (this.d)
      {
        localImageButton = new ImageButton(getContext());
        localImageButton.setOnClickListener(this);
        localImageButton.setTag(Integer.valueOf(4));
        localImageButton.setImageResource(2130839189);
        localImageButton.setContentDescription(getResources().getString(2131364064));
        a(localImageButton);
      }
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label25;
    }
  }
  
  public void a(ImageButton paramImageButton)
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    paramImageButton.setPadding(0, 0, (int)DisplayUtils.a(getContext(), 24.0F), 0);
    paramImageButton.setBackgroundResource(2130842210);
    paramImageButton.setLayoutParams(localLayoutParams);
    addView(paramImageButton);
  }
  
  public void onClick(View paramView)
  {
    paramView = paramView.getTag();
    if ((paramView != null) && (this.jdField_a_of_type_AndroidOsHandler != null)) {}
    switch (((Integer)paramView).intValue())
    {
    default: 
      return;
    case 2: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      return;
    case 4: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(4);
      return;
    case 1: 
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
  }
  
  public void setCallback(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.PublishItemBar
 * JD-Core Version:    0.7.0.1
 */