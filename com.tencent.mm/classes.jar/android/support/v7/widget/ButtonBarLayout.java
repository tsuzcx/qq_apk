package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v4.view.q;
import android.support.v7.a.a.f;
import android.support.v7.a.a.j;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class ButtonBarLayout
  extends LinearLayout
{
  private boolean aaR;
  private int aaS = -1;
  private int aaT = 0;
  
  public ButtonBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ButtonBarLayout);
    this.aaR = paramContext.getBoolean(a.j.ButtonBarLayout_allowStacking, true);
    paramContext.recycle();
  }
  
  private int br(int paramInt)
  {
    int i = getChildCount();
    while (paramInt < i)
    {
      if (getChildAt(paramInt).getVisibility() == 0) {
        return paramInt;
      }
      paramInt += 1;
    }
    return -1;
  }
  
  private boolean gt()
  {
    return getOrientation() == 1;
  }
  
  private void setStacked(boolean paramBoolean)
  {
    label17:
    View localView;
    if (paramBoolean)
    {
      i = 1;
      setOrientation(i);
      if (!paramBoolean) {
        break label78;
      }
      i = 5;
      setGravity(i);
      localView = findViewById(a.f.spacer);
      if (localView != null) {
        if (!paramBoolean) {
          break label84;
        }
      }
    }
    label78:
    label84:
    for (int i = 8;; i = 4)
    {
      localView.setVisibility(i);
      i = getChildCount() - 2;
      while (i >= 0)
      {
        bringChildToFront(getChildAt(i));
        i -= 1;
      }
      i = 0;
      break;
      i = 80;
      break label17;
    }
  }
  
  public int getMinimumHeight()
  {
    return Math.max(this.aaT, super.getMinimumHeight());
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    if (this.aaR)
    {
      if ((i > this.aaS) && (gt())) {
        setStacked(false);
      }
      this.aaS = i;
    }
    int j;
    if ((!gt()) && (View.MeasureSpec.getMode(paramInt1) == 1073741824))
    {
      j = View.MeasureSpec.makeMeasureSpec(i, -2147483648);
      i = 1;
      super.onMeasure(j, paramInt2);
      int k = i;
      if (this.aaR)
      {
        k = i;
        if (!gt())
        {
          if ((getMeasuredWidthAndState() & 0xFF000000) != 16777216) {
            break label261;
          }
          j = 1;
          label105:
          k = i;
          if (j != 0)
          {
            setStacked(true);
            k = 1;
          }
        }
      }
      if (k != 0) {
        super.onMeasure(paramInt1, paramInt2);
      }
      paramInt1 = br(0);
      if (paramInt1 < 0) {
        break label277;
      }
      View localView = getChildAt(paramInt1);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      paramInt2 = getPaddingTop();
      i = localView.getMeasuredHeight();
      j = localLayoutParams.topMargin;
      paramInt2 = localLayoutParams.bottomMargin + (i + paramInt2 + j) + 0;
      if (!gt()) {
        break label267;
      }
      i = br(paramInt1 + 1);
      paramInt1 = paramInt2;
      if (i >= 0) {
        paramInt1 = paramInt2 + (getChildAt(i).getPaddingTop() + (int)(16.0F * getResources().getDisplayMetrics().density));
      }
    }
    for (;;)
    {
      if (q.X(this) != paramInt1) {
        setMinimumHeight(paramInt1);
      }
      return;
      i = 0;
      j = paramInt1;
      break;
      label261:
      j = 0;
      break label105;
      label267:
      paramInt1 = paramInt2 + getPaddingBottom();
      continue;
      label277:
      paramInt1 = 0;
    }
  }
  
  public void setAllowStacking(boolean paramBoolean)
  {
    if (this.aaR != paramBoolean)
    {
      this.aaR = paramBoolean;
      if ((!this.aaR) && (getOrientation() == 1)) {
        setStacked(false);
      }
      requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v7.widget.ButtonBarLayout
 * JD-Core Version:    0.7.0.1
 */