package com.tencent.widget.pulltorefresh.library.internal;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import lui;
import luj;

public class ViewCompat
{
  public static void a(View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      lui.a(paramView, paramInt);
    }
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      luj.a(paramView, paramDrawable);
      return;
    }
    paramView.setBackgroundDrawable(paramDrawable);
  }
  
  public static void a(View paramView, Runnable paramRunnable)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      luj.a(paramView, paramRunnable);
      return;
    }
    paramView.postDelayed(paramRunnable, 16L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.internal.ViewCompat
 * JD-Core Version:    0.7.0.1
 */