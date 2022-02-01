package com.google.android.material.internal;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.core.g.h;
import androidx.core.g.w;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FlowLayout
  extends ViewGroup
{
  private boolean bCn;
  private int itemSpacing;
  private int lineSpacing;
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(237671);
    this.bCn = false;
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, a.k.FlowLayout, 0, 0);
    this.lineSpacing = paramContext.getDimensionPixelSize(a.k.FlowLayout_lineSpacing, 0);
    this.itemSpacing = paramContext.getDimensionPixelSize(a.k.FlowLayout_itemSpacing, 0);
    paramContext.recycle();
    AppMethodBeat.o(237671);
  }
  
  private static int x(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(237682);
    switch (paramInt2)
    {
    default: 
      AppMethodBeat.o(237682);
      return paramInt3;
    case 1073741824: 
      AppMethodBeat.o(237682);
      return paramInt1;
    }
    paramInt1 = Math.min(paramInt3, paramInt1);
    AppMethodBeat.o(237682);
    return paramInt1;
  }
  
  protected int getItemSpacing()
  {
    return this.itemSpacing;
  }
  
  protected int getLineSpacing()
  {
    return this.lineSpacing;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(237683);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(237683);
      return;
    }
    int j;
    label39:
    label50:
    int i;
    int k;
    label78:
    View localView;
    int n;
    int m;
    label144:
    int i1;
    if (w.I(this) == 1)
    {
      j = 1;
      if (j == 0) {
        break label284;
      }
      paramInt2 = getPaddingRight();
      if (j == 0) {
        break label292;
      }
      paramInt4 = getPaddingLeft();
      i = getPaddingTop();
      int i2 = paramInt3 - paramInt1 - paramInt4;
      paramInt4 = i;
      paramInt1 = i;
      paramInt3 = paramInt2;
      k = 0;
      if (k >= getChildCount()) {
        break label319;
      }
      localView = getChildAt(k);
      if (localView.getVisibility() == 8) {
        break label331;
      }
      Object localObject = localView.getLayoutParams();
      n = 0;
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        break label325;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      n = h.a((ViewGroup.MarginLayoutParams)localObject);
      m = h.b((ViewGroup.MarginLayoutParams)localObject);
      int i3 = localView.getMeasuredWidth();
      i = paramInt1;
      i1 = paramInt3;
      if (!this.bCn)
      {
        i = paramInt1;
        i1 = paramInt3;
        if (paramInt3 + n + i3 > i2)
        {
          i = paramInt4 + this.lineSpacing;
          i1 = paramInt2;
        }
      }
      paramInt1 = localView.getMeasuredWidth() + (i1 + n);
      paramInt4 = localView.getMeasuredHeight() + i;
      if (j == 0) {
        break label301;
      }
      localView.layout(i2 - paramInt1, i, i2 - i1 - n, paramInt4);
      label245:
      paramInt3 = i1 + (m + n + localView.getMeasuredWidth() + this.itemSpacing);
      paramInt1 = i;
    }
    label284:
    label292:
    label301:
    label319:
    label325:
    label331:
    for (;;)
    {
      k += 1;
      break label78;
      j = 0;
      break;
      paramInt2 = getPaddingLeft();
      break label39;
      paramInt4 = getPaddingRight();
      break label50;
      localView.layout(i1 + n, i, paramInt1, paramInt4);
      break label245;
      AppMethodBeat.o(237683);
      return;
      m = 0;
      break label144;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237680);
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int i7 = View.MeasureSpec.getMode(paramInt1);
    int i8 = View.MeasureSpec.getSize(paramInt2);
    int i9 = View.MeasureSpec.getMode(paramInt2);
    int n;
    int i;
    int i1;
    int i2;
    label73:
    int m;
    int i3;
    if ((i7 == -2147483648) || (i7 == 1073741824))
    {
      n = i6;
      int k = getPaddingLeft();
      i = getPaddingTop();
      j = 0;
      int i10 = getPaddingRight();
      i1 = 0;
      i2 = i;
      if (i1 >= getChildCount()) {
        break label301;
      }
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 8) {
        break label335;
      }
      measureChild(localView, paramInt1, paramInt2);
      Object localObject = localView.getLayoutParams();
      int i4 = 0;
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        break label329;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      m = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
      i3 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin + 0;
      i4 = m + 0;
      label155:
      m = i;
      int i5 = k;
      if (k + i4 + localView.getMeasuredWidth() > n - i10)
      {
        m = i;
        i5 = k;
        if (!this.bCn)
        {
          i5 = getPaddingLeft();
          m = i2 + this.lineSpacing;
        }
      }
      k = i5 + i4 + localView.getMeasuredWidth();
      i2 = localView.getMeasuredHeight();
      i = j;
      if (k > j) {
        i = k;
      }
      k = i5 + (i3 + i4 + localView.getMeasuredWidth() + this.itemSpacing);
      i2 = m + i2;
    }
    for (int j = m;; j = m)
    {
      i1 += 1;
      m = j;
      j = i;
      i = m;
      break label73;
      n = 2147483647;
      break;
      label301:
      setMeasuredDimension(x(i6, i7, j), x(i8, i9, i2));
      AppMethodBeat.o(237680);
      return;
      label329:
      i3 = 0;
      break label155;
      label335:
      m = i;
      i = j;
    }
  }
  
  protected void setItemSpacing(int paramInt)
  {
    this.itemSpacing = paramInt;
  }
  
  protected void setLineSpacing(int paramInt)
  {
    this.lineSpacing = paramInt;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    this.bCn = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.internal.FlowLayout
 * JD-Core Version:    0.7.0.1
 */