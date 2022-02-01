package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;
import java.util.Collection;

public class StructMsgItemLayoutDefault
  extends AbsStructMsgItem
{
  public StructMsgItemLayoutDefault()
  {
    this.l = 0;
  }
  
  public StructMsgItemLayoutDefault(int paramInt)
  {
    super(paramInt);
    this.l = 0;
  }
  
  public StructMsgItemLayoutDefault(Collection paramCollection)
  {
    super(paramCollection);
    this.l = 0;
  }
  
  public View b(Context paramContext, View paramView)
  {
    Resources localResources = paramContext.getResources();
    int i = localResources.getDimensionPixelSize(2131493096);
    int j = localResources.getDimensionPixelSize(2131493097);
    Object localObject1;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      if (!TextUtils.isEmpty(this.c))
      {
        paramView.setBackgroundResource(2130837637);
        k = AIOUtils.a(1.0F, localResources);
        localObject1 = (LinearLayout.LayoutParams)paramView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).leftMargin = k;
        ((LinearLayout.LayoutParams)localObject1).rightMargin = k;
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      paramView.setPadding(i, 0, j, 0);
      if (paramView.getChildCount() != this.a.size()) {
        break label518;
      }
      j = this.a.size();
      i = 0;
      if (i < j)
      {
        localObject2 = (AbsStructMsgElement)this.a.get(i);
        if ((localObject2 instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localObject2).a(a(), this.j);
        }
        localObject1 = ((AbsStructMsgElement)localObject2).a(paramContext, paramView.getChildAt(i));
        if (localObject1 != null) {
          break label220;
        }
      }
    }
    label220:
    do
    {
      return paramView;
      paramView = new LinearLayout(paramContext);
      paramView.setOrientation(1);
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
      break;
      k = AIOUtils.a(10.0F, localResources);
      m = AIOUtils.a(5.0F, localResources);
      localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if (i > 0) {
        localLayoutParams.topMargin = m;
      }
      localObject2 = ((AbsStructMsgElement)localObject2).a;
      if ("picture".equals(localObject2))
      {
        ((View)localObject1).setId(-1);
        localLayoutParams.height = (BaseChatItemLayout.g - k - k);
      }
      for (;;)
      {
        i += 1;
        break;
        if ("title".equals(localObject2))
        {
          ((View)localObject1).setId(-1);
        }
        else if ("summary".equals(localObject2))
        {
          ((View)localObject1).setId(-1);
        }
        else if ("hr".equals(localObject2))
        {
          localLayoutParams.height = 1;
        }
        else if ("image".equals(localObject2))
        {
          localLayoutParams.gravity = 1;
          paramView.setPadding(0, 0, 0, 0);
        }
        else if ("progress".equals(localObject2))
        {
          localLayoutParams.height = AIOUtils.a(4.0F, localResources);
          if ((j == 1) && (((View)localObject1).getVisibility() == 8))
          {
            paramView.setPadding(0, 0, 0, 0);
            if (a(1)) {
              paramView.setPadding(0, a(paramContext), 0, 0);
            }
            if (a(2)) {
              paramView.setPadding(0, 0, 0, a(paramContext));
            }
          }
        }
        else if ("more".equals(localObject2))
        {
          k = localResources.getDimensionPixelSize(2131493106);
          paramView.setPadding(paramView.getPaddingLeft(), k, paramView.getPaddingRight(), paramView.getPaddingBottom());
        }
      }
      paramView.removeAllViews();
      j = this.a.size();
      i = 0;
      if (i >= j) {
        break label681;
      }
      localObject2 = (AbsStructMsgElement)this.a.get(i);
      if ((localObject2 instanceof StructMsgItemTitle)) {
        ((StructMsgItemTitle)localObject2).a(a(), this.j);
      }
      localObject1 = ((AbsStructMsgElement)localObject2).a(paramContext, null);
    } while (localObject1 == null);
    label518:
    label533:
    int k = AIOUtils.a(10.0F, localResources);
    int m = AIOUtils.a(5.0F, localResources);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    if (i > 0) {
      localLayoutParams.topMargin = m;
    }
    Object localObject2 = ((AbsStructMsgElement)localObject2).a;
    if ("picture".equals(localObject2))
    {
      ((View)localObject1).setId(-1);
      localLayoutParams.height = (BaseChatItemLayout.g - k - k);
    }
    for (;;)
    {
      paramView.addView((View)localObject1, localLayoutParams);
      i += 1;
      break label533;
      label681:
      break;
      if ("title".equals(localObject2))
      {
        ((View)localObject1).setId(-1);
        localLayoutParams.height = localResources.getDimensionPixelSize(2131493103);
        localLayoutParams.gravity = 16;
      }
      else if ("summary".equals(localObject2))
      {
        localLayoutParams.topMargin = localResources.getDimensionPixelSize(2131493105);
        ((View)localObject1).setId(-1);
      }
      else if ("hr".equals(localObject2))
      {
        localLayoutParams.height = ((int)(1.0F * localResources.getDisplayMetrics().density));
      }
      else if ("image".equals(localObject2))
      {
        localLayoutParams.gravity = 1;
        paramView.setPadding(0, 0, 0, 0);
      }
      else if ("progress".equals(localObject2))
      {
        localLayoutParams.height = AIOUtils.a(4.0F, localResources);
        if ((j == 1) && (((View)localObject1).getVisibility() == 8))
        {
          paramView.setPadding(0, 0, 0, 0);
          if (a(1)) {
            paramView.setPadding(0, a(paramContext), 0, 0);
          }
          if (a(2)) {
            paramView.setPadding(0, 0, 0, a(paramContext));
          }
        }
      }
      else if ("more".equals(localObject2))
      {
        k = localResources.getDimensionPixelSize(2131493106);
        paramView.setPadding(paramView.getPaddingLeft(), k, paramView.getPaddingRight(), paramView.getPaddingBottom());
      }
    }
  }
  
  public View b(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    return b(paramContext, paramView);
  }
  
  public String b()
  {
    return "Layout0";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayoutDefault
 * JD-Core Version:    0.7.0.1
 */