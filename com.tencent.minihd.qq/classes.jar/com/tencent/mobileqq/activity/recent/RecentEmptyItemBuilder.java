package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.widget.AbsListView.LayoutParams;

public class RecentEmptyItemBuilder
  extends RecentItemBaseBuilder
{
  private int a = 0;
  private int b = 0;
  private int n = 0;
  
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramDrawable = paramView;
    if (paramView == null)
    {
      paramDrawable = View.inflate(paramContext, 2130903201, null);
      this.b = paramContext.getResources().getDimensionPixelSize(2131493045);
      this.a = paramContext.getResources().getDimensionPixelSize(2131493041);
      this.n = paramContext.getResources().getDimensionPixelSize(2131493047);
    }
    int i = paramViewGroup.getHeight() - this.a * 2 - this.b;
    if (i > this.n)
    {
      paramView = new AbsListView.LayoutParams(-1, -1);
      paramView.width = -1;
      paramView.height = i;
      paramDrawable.setLayoutParams(paramView);
      paramDrawable.setTag(Boolean.valueOf(true));
      paramView = (TextView)paramDrawable.findViewById(2131297330);
      paramViewGroup = (Button)paramDrawable.findViewById(2131297331);
      if (!(paramObject instanceof Integer)) {
        break label454;
      }
      i = ((Integer)paramObject).intValue();
      if (i != 1) {
        break label240;
      }
      paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838564, 0, 0);
      paramView.setVisibility(0);
      paramView.setText(2131368511);
      paramView.setTextColor(paramContext.getResources().getColorStateList(2131427975));
      paramViewGroup.setVisibility(8);
      paramViewGroup.setOnClickListener(null);
    }
    label454:
    for (;;)
    {
      paramDrawable.setTag(-1, Integer.valueOf(paramInt));
      return paramDrawable;
      i = this.n;
      break;
      label240:
      if (i == 0)
      {
        paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838564, 0, 0);
        paramView.setVisibility(0);
        paramView.setText(2131367204);
        paramView.setTextColor(paramContext.getResources().getColorStateList(2131427975));
        paramViewGroup.setVisibility(8);
        paramViewGroup.setOnClickListener(null);
      }
      else if (i == 7)
      {
        paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840143, 0, 0);
        paramView.setVisibility(0);
        paramView.setText(2131368511);
        paramView.setTextColor(paramContext.getResources().getColorStateList(2131427975));
        paramViewGroup.setVisibility(8);
        paramViewGroup.setOnClickListener(null);
      }
      else if (i == 6)
      {
        paramView.setCompoundDrawablesWithIntrinsicBounds(0, 2130840143, 0, 0);
        paramView.setVisibility(0);
        paramView.setText(2131367206);
        paramView.setTextColor(paramContext.getResources().getColorStateList(2131427934));
        paramViewGroup.setVisibility(0);
        paramViewGroup.setTag(-1, Integer.valueOf(paramInt));
        paramViewGroup.setOnClickListener(paramOnClickListener);
        paramViewGroup.setContentDescription("点击进行选人，可以直接发起QQ电话");
      }
      else
      {
        paramView.setVisibility(4);
        paramView.setText("");
        continue;
        paramView.setVisibility(8);
        paramView.setText("");
        paramViewGroup.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentEmptyItemBuilder
 * JD-Core Version:    0.7.0.1
 */