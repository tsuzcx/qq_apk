package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;

public class StructMsgItemLayout3
  extends AbsStructMsgItem
{
  public StructMsgItemLayout3()
  {
    this.l = 3;
  }
  
  public StructMsgItemLayout3(int paramInt)
  {
    super(paramInt);
    this.l = 3;
  }
  
  public StructMsgItemLayout3(Collection paramCollection)
  {
    super(paramCollection);
    this.l = 3;
  }
  
  public View b(Context paramContext, View paramView)
  {
    return b(paramContext, paramView, null);
  }
  
  public View b(Context paramContext, View paramView, OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    LinearLayout localLinearLayout;
    int n;
    int i;
    int j;
    int k;
    label63:
    int m;
    label66:
    Object localObject;
    label118:
    Resources localResources;
    label151:
    label162:
    String str;
    if ((paramView != null) && ((paramView instanceof LinearLayout)))
    {
      localLinearLayout = (LinearLayout)paramView;
      n = this.a.size();
      paramView = paramContext.getResources();
      i = AIOUtils.a(10.0F, paramView);
      if (a(1))
      {
        j = i;
        if (!a(2)) {
          break label151;
        }
        k = i;
        m = 0;
        paramView = localLinearLayout;
        if (m >= n) {
          break label758;
        }
        paramView = (AbsStructMsgElement)this.a.get(m);
        localObject = paramView.a;
        if (!"picture".equals(localObject)) {
          break label162;
        }
        paramView.a(paramContext, localLinearLayout.getChildAt(m));
        localLinearLayout.setPadding(i, j, i, k);
      }
      for (;;)
      {
        m += 1;
        break label66;
        j = AIOUtils.a(5.0F, paramView);
        break;
        k = AIOUtils.a(5.0F, paramView);
        break label63;
        if (!"button".equals(localObject)) {
          break label118;
        }
        paramView.a(paramContext, localLinearLayout.getChildAt(m * 2), paramOnLongClickAndTouchListener);
      }
    }
    else
    {
      localLinearLayout = new LinearLayout(paramContext);
      localObject = new ArrayList();
      m = this.a.size();
      j = 0;
      localResources = paramContext.getResources();
      k = 0;
      if (k < m)
      {
        paramView = (AbsStructMsgElement)this.a.get(k);
        str = paramView.a;
        if (!"picture".equals(str)) {
          break label394;
        }
        if (j < 3) {}
      }
      else
      {
        if (((ArrayList)localObject).size() != 0) {
          break label472;
        }
        if (QLog.isColorLevel()) {
          QLog.e("StructMsg", 2, "generate 3 item failed,item is:" + this.a);
        }
        return null;
      }
      paramView = paramView.a(paramContext, null);
      i = 0;
      if (k == 0)
      {
        i = 2131296347;
        label336:
        paramView.setId(i);
        ((ArrayList)localObject).add(paramView);
        i = j + 1;
      }
    }
    for (;;)
    {
      k += 1;
      j = i;
      break;
      if (k == 1)
      {
        i = 2131296348;
        break label336;
      }
      if (k != 2) {
        break label336;
      }
      i = 2131296349;
      break label336;
      label394:
      if ("button".equals(str))
      {
        paramView = paramView.a(paramContext, null, paramOnLongClickAndTouchListener);
        i = 0;
        if (k == 0) {
          i = 2131296347;
        }
        for (;;)
        {
          paramView.setId(i);
          ((ArrayList)localObject).add(paramView);
          i = j + 1;
          break;
          if (k == 1) {
            i = 2131296348;
          } else if (k == 2) {
            i = 2131296349;
          }
        }
        label472:
        j = AIOUtils.a(10.0F, localResources);
        label505:
        int i1;
        label533:
        int i2;
        if (a(1))
        {
          k = j;
          if (!a(2)) {
            break label695;
          }
          m = j;
          i1 = ((ArrayList)localObject).size();
          i = (int)((BaseChatItemLayout.g - j - j - 2) / 3.0F);
          n = 0;
          paramView = localLinearLayout;
          if (n >= i1) {
            break label758;
          }
          paramView = (View)((ArrayList)localObject).get(n);
          paramOnLongClickAndTouchListener = new LinearLayout.LayoutParams(-1, -2);
          paramOnLongClickAndTouchListener.weight = 1.0F;
          paramOnLongClickAndTouchListener.width = 0;
          paramOnLongClickAndTouchListener.height = i;
          if (!(paramView instanceof TextView)) {
            break label725;
          }
          i = (int)(BaseChatItemLayout.g / 6.0F);
          paramOnLongClickAndTouchListener.height = i;
          i2 = AIOUtils.a(1.0F, localResources);
          if (n != 0) {
            break label707;
          }
          paramOnLongClickAndTouchListener.leftMargin = i2;
          label623:
          localLinearLayout.addView(paramView, paramOnLongClickAndTouchListener);
          if (n != i1 - 1)
          {
            paramView = new ImageView(paramContext);
            paramView.setLayoutParams(new ViewGroup.LayoutParams(1, i));
            paramView.setBackgroundColor(-3618613);
            localLinearLayout.addView(paramView);
          }
        }
        for (;;)
        {
          n += 1;
          break label533;
          k = AIOUtils.a(5.0F, localResources);
          break;
          label695:
          m = AIOUtils.a(5.0F, localResources);
          break label505;
          label707:
          if (n != i1 - 1) {
            break label623;
          }
          paramOnLongClickAndTouchListener.rightMargin = i2;
          break label623;
          label725:
          if (n > 0) {
            paramOnLongClickAndTouchListener.leftMargin = 1;
          }
          localLinearLayout.setPadding(j, k, j, m);
          localLinearLayout.addView(paramView, paramOnLongClickAndTouchListener);
        }
        label758:
        a(paramView);
        b(paramView);
        return paramView;
      }
      i = j;
    }
  }
  
  public String b()
  {
    return "Layout3";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.structmsg.view.StructMsgItemLayout3
 * JD-Core Version:    0.7.0.1
 */