package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;

public class RecentCallContactItemBuilder
  extends RecentItemBaseBuilder
{
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = LayoutInflater.from(paramContext).inflate(2130903865, null);
    }
    paramDrawable = paramObject.findViewById(2131299865);
    paramDrawable.setContentDescription("进入通讯录界面");
    paramDrawable.setOnClickListener(paramOnClickListener);
    paramDrawable.setOnLongClickListener(paramOnLongClickListener);
    paramDrawable.setTag(-1, Integer.valueOf(paramInt));
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentCallContactItemBuilder
 * JD-Core Version:    0.7.0.1
 */