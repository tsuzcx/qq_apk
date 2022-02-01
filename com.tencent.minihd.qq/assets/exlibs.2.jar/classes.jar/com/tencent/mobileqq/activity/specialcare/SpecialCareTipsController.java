package com.tencent.mobileqq.activity.specialcare;

import android.view.View;
import android.view.ViewGroup;

public class SpecialCareTipsController
{
  private ViewGroup a;
  
  public SpecialCareTipsController(ViewGroup paramViewGroup)
  {
    this.a = paramViewGroup;
  }
  
  public void a()
  {
    this.a.setVisibility(8);
  }
  
  public void a(View paramView)
  {
    if (paramView != null)
    {
      if (this.a.indexOfChild(paramView) == -1) {
        this.a.addView(paramView);
      }
      int i = 0;
      while (i < this.a.getChildCount())
      {
        this.a.getChildAt(i).setVisibility(8);
        i += 1;
      }
      paramView.setVisibility(0);
      this.a.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.SpecialCareTipsController
 * JD-Core Version:    0.7.0.1
 */