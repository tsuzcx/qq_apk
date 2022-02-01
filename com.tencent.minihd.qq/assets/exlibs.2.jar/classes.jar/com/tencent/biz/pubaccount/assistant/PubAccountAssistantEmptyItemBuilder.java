package com.tencent.biz.pubaccount.assistant;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.widget.AbsListView.LayoutParams;

public class PubAccountAssistantEmptyItemBuilder
  extends RecentItemBaseBuilder
{
  private static final String jdField_b_of_type_JavaLangString = "PubAccountAssistantEmptyItemBuilder";
  private int a = 0;
  private int jdField_b_of_type_Int;
  private int n = 0;
  
  public PubAccountAssistantEmptyItemBuilder()
  {
    this.b = 0;
  }
  
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    int i;
    if (paramView == null)
    {
      paramDrawable = null;
      if (!"PubAccountAssistantEmptyItemBuilder".equals(paramDrawable))
      {
        paramView = View.inflate(paramContext, 2130903610, null);
        paramView.setTag("PubAccountAssistantEmptyItemBuilder");
        this.b = paramContext.getResources().getDimensionPixelSize(2131493045);
        this.a = paramContext.getResources().getDimensionPixelSize(2131493046);
        this.n = paramContext.getResources().getDimensionPixelSize(2131493047);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10;
      if (i <= this.n) {
        break label191;
      }
      label104:
      paramDrawable = new AbsListView.LayoutParams(-1, -1);
      paramDrawable.width = -1;
      paramDrawable.height = i;
      paramView.setLayoutParams(paramDrawable);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramDrawable = (TextView)paramView.findViewById(2131298966);
        if (paramObject.intValue() != 9) {
          break label200;
        }
        paramDrawable.setText(2131363636);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramDrawable = paramView.getTag();
      break;
      label191:
      i = this.n;
      break label104;
      label200:
      paramDrawable.setText(2131368511);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.assistant.PubAccountAssistantEmptyItemBuilder
 * JD-Core Version:    0.7.0.1
 */