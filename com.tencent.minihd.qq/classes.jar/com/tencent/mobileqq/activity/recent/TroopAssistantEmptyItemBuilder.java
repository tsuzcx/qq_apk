package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.widget.AbsListView.LayoutParams;

public class TroopAssistantEmptyItemBuilder
  extends RecentItemBaseBuilder
{
  private static final String jdField_b_of_type_JavaLangString = "TroopAssistantEmptyItemBuilder";
  private int a = 0;
  private int jdField_b_of_type_Int;
  private int n = 0;
  private int o = 0;
  
  public TroopAssistantEmptyItemBuilder()
  {
    this.b = 0;
  }
  
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    int i;
    if (paramView == null)
    {
      paramDrawable = null;
      if (!"TroopAssistantEmptyItemBuilder".equals(paramDrawable))
      {
        paramView = View.inflate(paramContext, 2130904483, null);
        paramView.setTag("TroopAssistantEmptyItemBuilder");
        paramDrawable = paramContext.getResources();
        this.b = paramDrawable.getDimensionPixelSize(2131493045);
        this.a = paramDrawable.getDimensionPixelSize(2131493046);
        this.n = paramDrawable.getDimensionPixelSize(2131493047);
        i = paramDrawable.getDimensionPixelSize(2131493172);
        this.o = (paramDrawable.getDimensionPixelSize(2131493173) + i);
      }
      i = paramViewGroup.getMeasuredHeight() - this.a - this.b - 10 - this.o;
      if (i <= this.n) {
        break label210;
      }
      label124:
      paramDrawable = new AbsListView.LayoutParams(-1, -1);
      paramDrawable.width = -1;
      paramDrawable.height = i;
      paramView.setLayoutParams(paramDrawable);
      if ((paramObject instanceof Integer))
      {
        paramObject = (Integer)paramObject;
        paramDrawable = (TextView)paramView.findViewById(2131302315);
        if (paramObject.intValue() != 4) {
          break label219;
        }
        paramDrawable.setText(2131368176);
      }
    }
    for (;;)
    {
      paramView.setTag(-1, Integer.valueOf(paramInt));
      return paramView;
      paramDrawable = paramView.getTag();
      break;
      label210:
      i = this.n;
      break label124;
      label219:
      paramDrawable.setText(2131368511);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.TroopAssistantEmptyItemBuilder
 * JD-Core Version:    0.7.0.1
 */