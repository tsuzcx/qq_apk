package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
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

public class StructMsgItemLayout1
  extends AbsStructMsgItem
{
  public StructMsgItemLayout1()
  {
    this.l = 1;
  }
  
  public StructMsgItemLayout1(int paramInt)
  {
    super(paramInt);
    this.l = 1;
  }
  
  public StructMsgItemLayout1(Collection paramCollection)
  {
    super(paramCollection);
    this.l = 1;
  }
  
  public View b(Context paramContext, View paramView)
  {
    Resources localResources = paramContext.getResources();
    int m = localResources.getDimensionPixelSize(2131493096);
    int n = localResources.getDimensionPixelSize(2131493097);
    int i = AIOUtils.a(5.0F, localResources);
    int k;
    Object localObject2;
    Object localObject1;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      if (!TextUtils.isEmpty(this.c)) {
        paramView.setBackgroundResource(2130838151);
      }
      b(paramView);
      if (paramView.getChildCount() != this.a.size()) {
        break label456;
      }
      k = this.a.size();
      j = 0;
      if (j < k)
      {
        localObject2 = (AbsStructMsgElement)this.a.get(j);
        if ((localObject2 instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localObject2).a(a(), this.j);
        }
        localObject1 = ((AbsStructMsgElement)localObject2).a(paramContext, paramView.getChildAt(j));
        if (localObject1 != null) {}
      }
      else
      {
        label159:
        return paramView;
      }
    }
    else
    {
      paramView = new LinearLayout(paramContext);
      paramView.setOrientation(1);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      if (!a(1)) {
        break label747;
      }
    }
    label456:
    label472:
    label747:
    for (int j = a(paramContext) + i;; j = i)
    {
      k = i;
      if (a(2)) {
        k = i + a(paramContext);
      }
      paramView.setPadding(m, j, n, k);
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      i = j;
      break;
      int i1 = AIOUtils.a(10.0F, localResources);
      int i2 = AIOUtils.a(5.0F, localResources);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if (j > 0) {
        localLayoutParams.topMargin = i2;
      }
      localObject2 = ((AbsStructMsgElement)localObject2).a;
      if ("picture".equals(localObject2))
      {
        ((View)localObject1).setId(-1);
        localLayoutParams.height = (BaseChatItemLayout.g - i1 - i1);
      }
      for (;;)
      {
        j += 1;
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
          if (k == 1) {
            paramView.setPadding(0, 0, 0, 0);
          } else if (j == k - 1) {
            paramView.setPadding(m, i, n, 0);
          }
        }
        else if ("image".equals(localObject2))
        {
          localLayoutParams.gravity = 1;
          paramView.setPadding(0, 0, 0, 0);
        }
      }
      paramView.removeAllViews();
      k = this.a.size();
      j = 0;
      if (j < k)
      {
        localObject2 = (AbsStructMsgElement)this.a.get(j);
        if ((localObject2 instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localObject2).a(a(), this.j);
        }
        localObject1 = ((AbsStructMsgElement)localObject2).a(paramContext, null);
        if (localObject1 == null) {
          break label159;
        }
        i1 = AIOUtils.a(10.0F, localResources);
        i2 = AIOUtils.a(5.0F, localResources);
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
        if (j > 0) {
          localLayoutParams.topMargin = i2;
        }
        localObject2 = ((AbsStructMsgElement)localObject2).a;
        if (!"picture".equals(localObject2)) {
          break label627;
        }
        ((View)localObject1).setId(-1);
        localLayoutParams.height = (BaseChatItemLayout.g - i1 - i1);
      }
      for (;;)
      {
        paramView.addView((View)localObject1, localLayoutParams);
        j += 1;
        break label472;
        break;
        label627:
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
          if (k == 1) {
            paramView.setPadding(0, 0, 0, 0);
          } else if (j == k - 1) {
            paramView.setPadding(m, i, n, 0);
          }
        }
        else if ("image".equals(localObject2))
        {
          localLayoutParams.gravity = 1;
          paramView.setPadding(0, 0, 0, 0);
        }
      }
    }
  }
  
  public View b(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    return b(paramContext, paramView);
  }
  
  public String b()
  {
    return "Layout1";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout1
 * JD-Core Version:    0.7.0.1
 */