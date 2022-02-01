package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StructMsgItemLayout4
  extends AbsStructMsgItem
{
  public StructMsgItemLayout4()
  {
    this.l = 4;
  }
  
  public StructMsgItemLayout4(int paramInt)
  {
    super(paramInt);
    this.l = 4;
  }
  
  public StructMsgItemLayout4(Collection paramCollection)
  {
    super(paramCollection);
    this.l = 4;
  }
  
  private LinearLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new LinearLayout(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    a(paramContext);
    b(paramContext);
    int k = localResources.getDimensionPixelSize(2131493096);
    int m = localResources.getDimensionPixelSize(2131493097);
    int i;
    if (a(1))
    {
      i = localResources.getDimensionPixelSize(2131493098);
      if (!a(2)) {
        break label121;
      }
    }
    label121:
    for (int j = localResources.getDimensionPixelSize(2131493099);; j = AIOUtils.a(16.0F, localResources))
    {
      paramContext.setPadding(k, i, m, j);
      paramContext.setLayoutParams(localLayoutParams);
      paramContext.setOrientation(0);
      return paramContext;
      i = AIOUtils.a(16.0F, localResources);
      break;
    }
  }
  
  public View b(Context paramContext, View paramView)
  {
    Resources localResources = paramContext.getResources();
    Iterator localIterator;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      paramView = (LinearLayout)paramView;
      paramView.removeAllViews();
      localIterator = this.a.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return paramView;
      }
      Object localObject2 = (AbsStructMsgElement)localIterator.next();
      Object localObject1 = ((AbsStructMsgElement)localObject2).a;
      if ("title".equals(localObject1))
      {
        localObject1 = ((AbsStructMsgElement)localObject2).a(paramContext, null);
        if ((localObject2 instanceof StructMsgItemTitle)) {
          ((StructMsgItemTitle)localObject2).a(a(), this.j);
        }
        localObject2 = new LinearLayout.LayoutParams(-1, -2);
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((LinearLayout.LayoutParams)localObject2).weight = 1.0F;
        TextView localTextView = (TextView)((View)localObject1).findViewById(2131296341);
        if (localTextView != null) {
          localTextView.setEllipsize(TextUtils.TruncateAt.END);
        }
        paramView.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        continue;
        paramView = a(paramContext);
        break;
      }
      if ("picture".equals(localObject1))
      {
        localObject1 = ((AbsStructMsgElement)localObject2).a(paramContext, null);
        localObject2 = new LinearLayout.LayoutParams(localResources.getDimensionPixelSize(2131493102), localResources.getDimensionPixelSize(2131493102));
        ((LinearLayout.LayoutParams)localObject2).gravity = 16;
        ((LinearLayout.LayoutParams)localObject2).rightMargin = AIOUtils.a(16.0F, localResources);
        paramView.addView((View)localObject1, 0, (ViewGroup.LayoutParams)localObject2);
      }
    }
    return paramView;
  }
  
  public View b(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    return b(paramContext, paramView);
  }
  
  public String b()
  {
    return "Layout4";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout4
 * JD-Core Version:    0.7.0.1
 */