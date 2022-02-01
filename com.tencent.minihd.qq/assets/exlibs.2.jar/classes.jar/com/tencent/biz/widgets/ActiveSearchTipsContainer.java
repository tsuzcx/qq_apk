package com.tencent.biz.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.biz.lebasearch.SearchProtocol.WordItem;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DisplayUtils;
import cqt;
import java.util.Iterator;
import java.util.List;

public class ActiveSearchTipsContainer
  extends ViewGroup
  implements View.OnClickListener
{
  public static final int a = 1000;
  public static final String a = "ActiveSearchTipsContainer";
  private static final int b = 14;
  private static final int c = 10;
  private static final int d = 8;
  private static final int e = 6;
  private static final int f = 2;
  private ActiveSearchTipsContainer.OnTipClickListener jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer$OnTipClickListener;
  private List jdField_a_of_type_JavaUtilList = null;
  private int g = 2;
  
  public ActiveSearchTipsContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected int a(int paramInt)
  {
    int i5 = (int)DisplayUtils.a(getContext(), 8.0F);
    int i = (int)DisplayUtils.a(getContext(), 10.0F);
    int i6 = (int)DisplayUtils.a(getContext(), 6.0F);
    int i1 = 1;
    int i7 = getChildCount();
    int m = 0;
    int n = i;
    int k = 0;
    for (;;)
    {
      int j = i;
      int i8;
      int i9;
      int i3;
      if (m < i7)
      {
        View localView = getChildAt(m);
        i8 = localView.getMeasuredWidth();
        i9 = localView.getMeasuredHeight();
        j = i;
        if (m == 0) {
          j = i + i9;
        }
        i = j;
        i3 = i1;
        i2 = n;
        i4 = k;
        if (k + i8 <= paramInt) {
          break label155;
        }
        i3 = i1 + 1;
        if (i3 <= this.g) {}
      }
      else
      {
        return j;
      }
      int i2 = n + (i9 + i5);
      i = i2 + i9;
      int i4 = 0;
      label155:
      m += 1;
      k = i6 + i8 + i4;
      i1 = i3;
      n = i2;
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString != null) && (TextUtils.isEmpty(paramString.trim()))) {
      return;
    }
    Button localButton = new Button(getContext());
    localButton.setBackgroundResource(2130838988);
    localButton.setText(paramString);
    localButton.setTextSize(14.0F);
    localButton.setTextColor(-16777216);
    localButton.setOnClickListener(this);
    localButton.setTag(paramString);
    super.addView(localButton);
  }
  
  public void a(List paramList)
  {
    removeAllViews();
    this.jdField_a_of_type_JavaUtilList = paramList;
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a(((SearchProtocol.WordItem)paramList.next()).word);
    }
  }
  
  public void onClick(View paramView)
  {
    cqt localcqt = new cqt(this, Looper.getMainLooper());
    if (localcqt != null)
    {
      Message localMessage = localcqt.obtainMessage();
      localMessage.obj = paramView.getTag();
      localcqt.sendMessage(localMessage);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i1 = (int)DisplayUtils.a(getContext(), 8.0F);
    int i = (int)DisplayUtils.a(getContext(), 10.0F);
    int i2 = (int)DisplayUtils.a(getContext(), 6.0F);
    int j = 0;
    int i3 = getChildCount();
    int m = 0;
    for (paramInt4 = 1;; paramInt4 = paramInt2)
    {
      View localView;
      int i4;
      int i5;
      int k;
      int n;
      if (m < i3)
      {
        localView = getChildAt(m);
        i4 = localView.getMeasuredWidth();
        i5 = localView.getMeasuredHeight();
        paramInt2 = paramInt4;
        k = i;
        n = j;
        if (j + i4 > paramInt3 - paramInt1)
        {
          n = 0;
          k = i + (i5 + i1);
          paramInt4 += 1;
          paramInt2 = paramInt4;
          if (paramInt4 <= this.g) {}
        }
      }
      else
      {
        return;
      }
      localView.layout(n, k, n + i4, k + i5);
      ReportController.b(null, "CliOper", "", "", "0X8004AB3", "0X8004AB3", 0, 0, ((SearchProtocol.WordItem)this.jdField_a_of_type_JavaUtilList.get(m)).id, null, null, null);
      m += 1;
      i = k;
      j = n + (i2 + i4);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = 0;
    int n = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    super.measureChildren(paramInt1, paramInt2);
    switch (n)
    {
    default: 
      paramInt2 = k;
      paramInt1 = j;
      switch (m)
      {
      }
      break;
    }
    for (paramInt1 = a(i);; paramInt1 = a(i))
    {
      super.setMeasuredDimension(paramInt2, paramInt1);
      return;
      paramInt2 = i;
      break;
    }
  }
  
  public void setOnTipsClickListener(ActiveSearchTipsContainer.OnTipClickListener paramOnTipClickListener)
  {
    this.jdField_a_of_type_ComTencentBizWidgetsActiveSearchTipsContainer$OnTipClickListener = paramOnTipClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.widgets.ActiveSearchTipsContainer
 * JD-Core Version:    0.7.0.1
 */