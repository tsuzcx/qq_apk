package com.tencent.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.QQBasePluginActivity;

public class HongbaoRelativeLayout
  extends RelativeLayout
{
  public HongbaoRelativeLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public HongbaoRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HongbaoRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setId(int paramInt)
  {
    Object localObject = getContext();
    int i = paramInt;
    if ((localObject instanceof ContextWrapper))
    {
      localObject = ((ContextWrapper)localObject).getBaseContext();
      i = paramInt;
      if ((localObject instanceof QQBasePluginActivity))
      {
        localObject = ((QQBasePluginActivity)localObject).b;
        i = paramInt;
        if (localObject != null)
        {
          i = paramInt;
          if (((String)localObject).endsWith("HbListActivity")) {
            i = paramInt + 1;
          }
        }
      }
    }
    super.setId(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.HongbaoRelativeLayout
 * JD-Core Version:    0.7.0.1
 */