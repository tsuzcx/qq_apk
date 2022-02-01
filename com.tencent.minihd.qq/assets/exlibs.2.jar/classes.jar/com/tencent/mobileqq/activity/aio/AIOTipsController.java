package com.tencent.mobileqq.activity.aio;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class AIOTipsController
{
  private ViewGroup a;
  
  public AIOTipsController(ViewGroup paramViewGroup)
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
        this.a.addView(paramView, new ViewGroup.LayoutParams(-1, -2));
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTipsController
 * JD-Core Version:    0.7.0.1
 */