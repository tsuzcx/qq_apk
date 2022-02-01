package com.tencent.mobileqq.activity.recent;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout.OnDragModeChangedListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.List;

public class RecentCallHoldItemBuilder
  extends RecentItemBaseBuilder
{
  public View a(int paramInt, Object paramObject, Drawable paramDrawable, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, View.OnLongClickListener paramOnLongClickListener, DragFrameLayout.OnDragModeChangedListener paramOnDragModeChangedListener)
  {
    int i = 0;
    paramObject = paramView;
    if (paramView == null) {
      paramObject = LayoutInflater.from(paramContext).inflate(2130903866, null);
    }
    paramDrawable = paramObject.findViewById(2131299875);
    paramDrawable.setContentDescription("进入找人聊聊界面");
    paramDrawable.setOnClickListener(paramOnClickListener);
    paramDrawable.setOnLongClickListener(paramOnLongClickListener);
    paramDrawable.setTag(-1, Integer.valueOf(paramInt));
    if (paramObject.getResources().getConfiguration().orientation == 2) {}
    for (paramInt = 8;; paramInt = 0)
    {
      paramDrawable.setVisibility(paramInt);
      if (!(paramViewGroup instanceof ListView)) {
        return paramObject;
      }
      paramDrawable = (ListView)paramViewGroup;
      int k = paramDrawable.getChildCount();
      int j = 0;
      paramInt = i;
      i = j;
      while (paramInt < k)
      {
        i += paramDrawable.getChildAt(paramInt).getHeight();
        paramInt += 1;
      }
    }
    paramObject.setMinimumHeight(paramDrawable.getHeight() - i);
    return paramObject;
  }
  
  View a(View paramView, List paramList, QQAppInterface paramQQAppInterface)
  {
    int i = 4;
    Object localObject1 = new ImageView[4];
    localObject1[0] = ((ImageView)paramView.findViewById(2131299870));
    localObject1[1] = ((ImageView)paramView.findViewById(2131299871));
    localObject1[2] = ((ImageView)paramView.findViewById(2131299872));
    localObject1[3] = ((ImageView)paramView.findViewById(2131299873));
    Object localObject2;
    int j;
    if ((paramList != null) && (paramView != null))
    {
      localObject2 = new Bitmap[4];
      j = paramList.size();
      if (j < 4) {
        break label443;
      }
    }
    for (;;)
    {
      j = 0;
      if (j < i)
      {
        localObject3 = ((Long)paramList.get(j)).toString();
        localObject2[j] = paramQQAppInterface.a((String)localObject3, 3, true);
        if (localObject2[j] == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.recent", 2, "mRecommendFriendList headBitmap[" + j + "]= null !");
          }
          localObject2[j] = paramQQAppInterface.a((String)localObject3, 3, true);
        }
        if (localObject2[j] == null) {
          localObject1[j].setImageResource(2130840154);
        }
        for (;;)
        {
          j += 1;
          break;
          localObject1[j].setImageBitmap(localObject2[j]);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "mRecommendFriendList is null!");
        }
        i = 0;
        while (i < 4)
        {
          localObject1[i].setImageResource(2130840154);
          i += 1;
        }
      }
      i = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
      paramList = (RelativeLayout)paramView.findViewById(2131299867);
      paramQQAppInterface = (RelativeLayout.LayoutParams)paramList.getLayoutParams();
      localObject1 = (TextView)paramView.findViewById(2131299874);
      localObject2 = (RelativeLayout.LayoutParams)((TextView)localObject1).getLayoutParams();
      Object localObject3 = (TextView)paramView.findViewById(2131299875);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((TextView)localObject3).getLayoutParams();
      if (i <= 800)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.recent", 2, "screenHeight = " + i);
        }
        paramQQAppInterface.topMargin = 0;
        paramList.setLayoutParams(paramQQAppInterface);
        ((RelativeLayout.LayoutParams)localObject2).topMargin = BaseApplication.getContext().getResources().getDimensionPixelSize(2131493707);
        localLayoutParams.topMargin = BaseApplication.getContext().getResources().getDimensionPixelSize(2131493707);
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        ((TextView)localObject3).setLayoutParams(localLayoutParams);
      }
      return paramView;
      label443:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentCallHoldItemBuilder
 * JD-Core Version:    0.7.0.1
 */