package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class StructMsgItemLayout5
  extends AbsStructMsgItem
{
  public StructMsgItemLayout5()
  {
    this.l = 5;
  }
  
  public StructMsgItemLayout5(int paramInt)
  {
    super(paramInt);
    this.l = 5;
  }
  
  public StructMsgItemLayout5(Collection paramCollection)
  {
    super(paramCollection);
    this.l = 5;
  }
  
  private RelativeLayout a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    paramContext = new RelativeLayout(paramContext);
    a(paramContext);
    b(paramContext);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    int k = localResources.getDimensionPixelSize(2131493096);
    int m = localResources.getDimensionPixelSize(2131493097);
    int i;
    if (a(1))
    {
      i = localResources.getDimensionPixelSize(2131493098);
      if (!a(2)) {
        break label116;
      }
    }
    label116:
    for (int j = localResources.getDimensionPixelSize(2131493099);; j = localResources.getDimensionPixelSize(2131493099))
    {
      paramContext.setPadding(k, i, m, j);
      paramContext.setLayoutParams(localLayoutParams);
      return paramContext;
      i = AIOUtils.a(6.0F, localResources);
      break;
    }
  }
  
  public View b(Context paramContext, View paramView)
  {
    Resources localResources = paramContext.getResources();
    RelativeLayout localRelativeLayout;
    Object localObject1;
    label42:
    Object localObject2;
    Object localObject3;
    if ((paramView != null) && ((paramView instanceof RelativeLayout)))
    {
      localRelativeLayout = (RelativeLayout)paramView;
      localRelativeLayout.removeAllViews();
      Iterator localIterator = this.a.iterator();
      paramView = null;
      localObject1 = null;
      if (!localIterator.hasNext()) {
        break label265;
      }
      localObject2 = (AbsStructMsgElement)localIterator.next();
      localObject3 = ((AbsStructMsgElement)localObject2).a;
      if (!"title".equals(localObject3)) {
        break label198;
      }
      localObject2 = (StructMsgItemTitle)localObject2;
      if (TextUtils.isEmpty(((StructMsgItemTitle)localObject2).b())) {
        break label370;
      }
      paramView = new TextView(paramContext);
      paramView.setText(((StructMsgItemTitle)localObject2).b());
      paramView.setId(2131296341);
      paramView.setTag(localObject2);
      paramView.setMaxLines(1);
      paramView.setEllipsize(TextUtils.TruncateAt.END);
      paramView.setTextColor(-1);
      paramView.setTextSize(2, 18.0F);
      paramView.setGravity(1);
      int i = AIOUtils.a(42.0F, localResources);
      int j = AIOUtils.a(52.0F, localResources);
      paramView.setPadding(i, j, i, j);
    }
    label198:
    label370:
    for (;;)
    {
      break label42;
      localRelativeLayout = a(paramContext);
      break;
      if ("picture".equals(localObject3))
      {
        localObject2 = ((AbsStructMsgElement)localObject2).a(paramContext, null);
        localObject3 = ((View)localObject2).findViewById(2131296340);
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if ((localObject3 instanceof AnyScaleTypeImageView))
          {
            ((AnyScaleTypeImageView)localObject3).setScaleType(ImageView.ScaleType.CENTER_CROP);
            localObject1 = localObject2;
          }
        }
      }
      continue;
      if (localObject1 != null)
      {
        localObject2 = new RelativeLayout.LayoutParams(-1, localResources.getDimensionPixelSize(2131493108));
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 0;
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = (localResources.getDimensionPixelSize(2131493096) / 2);
        localRelativeLayout.addView(localObject1, (ViewGroup.LayoutParams)localObject2);
        paramContext = new ImageView(paramContext);
        paramContext.setBackgroundResource(2130837642);
        localRelativeLayout.addView(paramContext, (ViewGroup.LayoutParams)localObject2);
      }
      if (paramView != null)
      {
        paramContext = new RelativeLayout.LayoutParams(-1, -2);
        paramContext.addRule(12);
        localRelativeLayout.addView(paramView, paramContext);
      }
      return localRelativeLayout;
    }
  }
  
  public View b(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    return b(paramContext, paramView);
  }
  
  public String b()
  {
    return "Layout5";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout5
 * JD-Core Version:    0.7.0.1
 */