package com.tencent.biz.pubaccount.assistant;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentItemBaseBuilder;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;

public class PubAccountAssistantGuideBuilder
  extends RecentItemBaseBuilder
{
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    paramObject = paramView;
    if (paramView == null) {
      paramObject = View.inflate(paramContext, 2130903612, null);
    }
    paramDrawable = paramObject.findViewById(2131298967);
    paramDrawable.setTag(-1, Integer.valueOf(paramInt));
    paramDrawable.setOnClickListener(paramOnClickListener);
    paramDrawable = paramObject.findViewById(2131298968);
    paramDrawable.setTag(-1, Integer.valueOf(paramInt));
    paramDrawable.setOnClickListener(paramOnClickListener);
    paramObject.setTag(-1, Integer.valueOf(paramInt));
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.pubaccount.assistant.PubAccountAssistantGuideBuilder
 * JD-Core Version:    0.7.0.1
 */