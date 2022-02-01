package android.support.design.internal;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.support.design.a.a;
import android.support.v4.view.g;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;

public class FlowLayout
  extends ViewGroup
{
  private int kG;
  private int kH;
  private boolean kI = false;
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlowLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, a.a.FlowLayout, 0, 0);
    this.kG = paramContext.getDimensionPixelSize(2, 0);
    this.kH = paramContext.getDimensionPixelSize(1, 0);
    paramContext.recycle();
  }
  
  private static int d(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt1;
    switch (paramInt2)
    {
    default: 
      i = paramInt3;
    case 1073741824: 
      return i;
    }
    return Math.min(paramInt3, paramInt1);
  }
  
  protected int getItemSpacing()
  {
    return this.kH;
  }
  
  protected int getLineSpacing()
  {
    return this.kG;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() == 0) {
      return;
    }
    int j;
    label19:
    label29:
    label40:
    int i;
    int k;
    label68:
    View localView;
    int n;
    int m;
    label134:
    int i1;
    if (t.Y(this) == 1)
    {
      j = 1;
      if (j == 0) {
        break label274;
      }
      paramInt2 = getPaddingRight();
      if (j == 0) {
        break label282;
      }
      paramInt4 = getPaddingLeft();
      i = getPaddingTop();
      int i2 = paramInt3 - paramInt1 - paramInt4;
      paramInt4 = i;
      paramInt1 = i;
      paramInt3 = paramInt2;
      k = 0;
      if (k < getChildCount())
      {
        localView = getChildAt(k);
        if (localView.getVisibility() == 8) {
          break label315;
        }
        Object localObject = localView.getLayoutParams();
        n = 0;
        if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
          break label309;
        }
        localObject = (ViewGroup.MarginLayoutParams)localObject;
        n = g.a((ViewGroup.MarginLayoutParams)localObject);
        m = g.b((ViewGroup.MarginLayoutParams)localObject);
        int i3 = localView.getMeasuredWidth();
        i = paramInt1;
        i1 = paramInt3;
        if (!this.kI)
        {
          i = paramInt1;
          i1 = paramInt3;
          if (paramInt3 + n + i3 > i2)
          {
            i = paramInt4 + this.kG;
            i1 = paramInt2;
          }
        }
        paramInt1 = localView.getMeasuredWidth() + (i1 + n);
        paramInt4 = localView.getMeasuredHeight() + i;
        if (j == 0) {
          break label291;
        }
        localView.layout(i2 - paramInt1, i, i2 - i1 - n, paramInt4);
        label235:
        paramInt3 = i1 + (m + n + localView.getMeasuredWidth() + this.kH);
        paramInt1 = i;
      }
    }
    label274:
    label282:
    label291:
    label309:
    label315:
    for (;;)
    {
      k += 1;
      break label68;
      break;
      j = 0;
      break label19;
      paramInt2 = getPaddingLeft();
      break label29;
      paramInt4 = getPaddingRight();
      break label40;
      localView.layout(i1 + n, i, paramInt1, paramInt4);
      break label235;
      m = 0;
      break label134;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i6 = View.MeasureSpec.getSize(paramInt1);
    int i7 = View.MeasureSpec.getMode(paramInt1);
    int i8 = View.MeasureSpec.getSize(paramInt2);
    int i9 = View.MeasureSpec.getMode(paramInt2);
    int n;
    int i;
    int i1;
    int i2;
    label68:
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
        break label296;
      }
      View localView = getChildAt(i1);
      if (localView.getVisibility() == 8) {
        break label325;
      }
      measureChild(localView, paramInt1, paramInt2);
      Object localObject = localView.getLayoutParams();
      int i4 = 0;
      if (!(localObject instanceof ViewGroup.MarginLayoutParams)) {
        break label319;
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      m = ((ViewGroup.MarginLayoutParams)localObject).leftMargin;
      i3 = ((ViewGroup.MarginLayoutParams)localObject).rightMargin + 0;
      i4 = m + 0;
      label150:
      m = i;
      int i5 = k;
      if (k + i4 + localView.getMeasuredWidth() > n - i10)
      {
        m = i;
        i5 = k;
        if (!this.kI)
        {
          i5 = getPaddingLeft();
          m = i2 + this.kG;
        }
      }
      k = i5 + i4 + localView.getMeasuredWidth();
      i2 = localView.getMeasuredHeight();
      i = j;
      if (k > j) {
        i = k;
      }
      k = i5 + (i3 + i4 + localView.getMeasuredWidth() + this.kH);
      i2 = m + i2;
    }
    for (int j = m;; j = m)
    {
      i1 += 1;
      m = j;
      j = i;
      i = m;
      break label68;
      n = 2147483647;
      break;
      label296:
      setMeasuredDimension(d(i6, i7, j), d(i8, i9, i2));
      return;
      label319:
      i3 = 0;
      break label150;
      label325:
      m = i;
      i = j;
    }
  }
  
  protected void setItemSpacing(int paramInt)
  {
    this.kH = paramInt;
  }
  
  protected void setLineSpacing(int paramInt)
  {
    this.kG = paramInt;
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    this.kI = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.FlowLayout
 * JD-Core Version:    0.7.0.1
 */