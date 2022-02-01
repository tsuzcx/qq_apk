package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FinderTagFlowLayout
  extends ViewGroup
{
  public List<List<View>> GCA;
  protected List<Integer> GCB;
  protected List<Integer> GCC;
  private List<View> GCD;
  private int tJ;
  
  public FinderTagFlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FinderTagFlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168643);
    this.GCA = new ArrayList();
    this.GCB = new ArrayList();
    this.GCC = new ArrayList();
    this.GCD = new ArrayList();
    this.tJ = -1;
    AppMethodBeat.o(168643);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    AppMethodBeat.i(168647);
    ViewGroup.MarginLayoutParams localMarginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
    AppMethodBeat.o(168647);
    return localMarginLayoutParams;
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(168646);
    paramAttributeSet = new ViewGroup.MarginLayoutParams(getContext(), paramAttributeSet);
    AppMethodBeat.o(168646);
    return paramAttributeSet;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(168648);
    paramLayoutParams = new ViewGroup.MarginLayoutParams(paramLayoutParams);
    AppMethodBeat.o(168648);
    return paramLayoutParams;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(168645);
    this.GCA.clear();
    this.GCB.clear();
    this.GCC.clear();
    this.GCD.clear();
    int j = getWidth();
    paramInt1 = 0;
    paramInt2 = 0;
    int k = getChildCount();
    paramInt3 = 0;
    View localView;
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    int n;
    int m;
    while (paramInt3 < k)
    {
      localView = getChildAt(paramInt3);
      i = paramInt2;
      paramInt4 = paramInt1;
      if (localView.getVisibility() != 8)
      {
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
        n = localView.getMeasuredWidth();
        m = localView.getMeasuredHeight();
        paramInt4 = paramInt2;
        i = paramInt1;
        if (n + paramInt1 + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin > j - getPaddingLeft() - getPaddingRight())
        {
          this.GCB.add(Integer.valueOf(paramInt2));
          this.GCA.add(this.GCD);
          this.GCC.add(Integer.valueOf(paramInt1));
          i = 0;
          paramInt4 = localMarginLayoutParams.topMargin + m + localMarginLayoutParams.bottomMargin;
          this.GCD = new ArrayList();
        }
        paramInt1 = i + (n + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin);
        paramInt2 = localMarginLayoutParams.topMargin;
        i = Math.max(paramInt4, localMarginLayoutParams.bottomMargin + (paramInt2 + m));
        this.GCD.add(localView);
        paramInt4 = paramInt1;
      }
      paramInt3 += 1;
      paramInt2 = i;
      paramInt1 = paramInt4;
    }
    this.GCB.add(Integer.valueOf(paramInt2));
    this.GCC.add(Integer.valueOf(paramInt1));
    this.GCA.add(this.GCD);
    paramInt1 = getPaddingLeft();
    paramInt2 = getPaddingTop();
    int i = this.GCA.size();
    paramInt3 = 0;
    if (paramInt3 < i)
    {
      this.GCD = ((List)this.GCA.get(paramInt3));
      k = ((Integer)this.GCB.get(paramInt3)).intValue();
      paramInt4 = ((Integer)this.GCC.get(paramInt3)).intValue();
      switch (this.tJ)
      {
      default: 
        label456:
        paramInt4 = 0;
        label459:
        if (paramInt4 < this.GCD.size())
        {
          localView = (View)this.GCD.get(paramInt4);
          if (localView.getVisibility() == 8) {
            break label651;
          }
          localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
          m = localMarginLayoutParams.leftMargin + paramInt1;
          n = localMarginLayoutParams.topMargin + paramInt2;
          localView.layout(m, n, localView.getMeasuredWidth() + m, localView.getMeasuredHeight() + n);
          paramInt1 = localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin + paramInt1;
        }
        break;
      }
    }
    label651:
    for (;;)
    {
      paramInt4 += 1;
      break label459;
      paramInt1 = getPaddingLeft();
      break label456;
      paramInt1 = (j - paramInt4) / 2 + getPaddingLeft();
      break label456;
      paramInt1 = j - (paramInt4 + getPaddingLeft()) - getPaddingRight();
      Collections.reverse(this.GCD);
      break label456;
      paramInt3 += 1;
      paramInt2 += k;
      break;
      AppMethodBeat.o(168645);
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(168644);
    int i3 = View.MeasureSpec.getSize(paramInt1);
    int i6 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt2);
    int i5 = View.MeasureSpec.getMode(paramInt2);
    int k = 0;
    int j = 0;
    int m = 0;
    int i = 0;
    int i7 = getChildCount();
    int n = 0;
    View localView;
    if (n < i7)
    {
      localView = getChildAt(n);
      if (localView.getVisibility() == 8)
      {
        if (n != i7 - 1) {
          break label354;
        }
        k = Math.max(m, k);
        j += i;
      }
    }
    label325:
    label354:
    for (;;)
    {
      n += 1;
      break;
      measureChild(localView, paramInt1, paramInt2);
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localView.getLayoutParams();
      int i4 = localView.getMeasuredWidth() + localMarginLayoutParams.leftMargin + localMarginLayoutParams.rightMargin;
      int i1 = localView.getMeasuredHeight();
      int i8 = localMarginLayoutParams.topMargin;
      i1 = localMarginLayoutParams.bottomMargin + (i1 + i8);
      if (m + i4 > i3 - getPaddingLeft() - getPaddingRight())
      {
        k = Math.max(k, m);
        j += i;
        i = i4;
        m = i1;
      }
      for (;;)
      {
        if (n == i7 - 1)
        {
          k = Math.max(i, k);
          i1 = j + m;
          j = i;
          i = m;
          m = j;
          j = i1;
          break;
          i = Math.max(i, i1);
          i1 = m + i4;
          m = i;
          i = i1;
          continue;
          if (i6 == 1073741824)
          {
            paramInt1 = i3;
            if (i5 != 1073741824) {
              break label325;
            }
          }
          for (paramInt2 = i2;; paramInt2 = getPaddingTop() + j + getPaddingBottom())
          {
            setMeasuredDimension(paramInt1, paramInt2);
            AppMethodBeat.o(168644);
            return;
            paramInt1 = getPaddingLeft() + k + getPaddingRight();
            break;
          }
        }
      }
      i1 = i;
      i = m;
      m = i1;
    }
  }
  
  public void setGravity(int paramInt)
  {
    this.tJ = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderTagFlowLayout
 * JD-Core Version:    0.7.0.1
 */