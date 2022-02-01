package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;

public class RecentCallMoreItemBuilder
  extends RecentItemBaseBuilder
{
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = LayoutInflater.from(paramContext).inflate(2130903868, null);
    }
    if (paramObject.getResources().getConfiguration().orientation == 2) {}
    for (int i = 8;; i = 0)
    {
      paramObject.setVisibility(i);
      paramObject.setContentDescription("展示更多QQ电话好友 按钮");
      paramObject.setOnClickListener(paramOnClickListener);
      paramObject.setOnLongClickListener(paramOnLongClickListener);
      paramObject.setTag(-1, Integer.valueOf(paramInt));
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentCallMoreItemBuilder
 * JD-Core Version:    0.7.0.1
 */