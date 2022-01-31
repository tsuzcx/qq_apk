package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.d;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

public class AlertDialogLayout
  extends LinearLayoutCompat
{
  public AlertDialogLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = getPaddingLeft();
    int k = paramInt3 - paramInt1;
    int m = getPaddingRight();
    int n = getPaddingRight();
    paramInt1 = getMeasuredHeight();
    int i1 = getChildCount();
    int i2 = getGravity();
    Object localObject;
    label91:
    label94:
    int i3;
    int i4;
    LinearLayoutCompat.LayoutParams localLayoutParams;
    int i;
    switch (i2 & 0x70)
    {
    default: 
      paramInt1 = getPaddingTop();
      localObject = getDividerDrawable();
      if (localObject == null)
      {
        paramInt3 = 0;
        paramInt4 = 0;
        if (paramInt4 >= i1) {
          return;
        }
        localObject = getChildAt(paramInt4);
        paramInt2 = paramInt1;
        if (localObject != null)
        {
          paramInt2 = paramInt1;
          if (((View)localObject).getVisibility() != 8)
          {
            i3 = ((View)localObject).getMeasuredWidth();
            i4 = ((View)localObject).getMeasuredHeight();
            localLayoutParams = (LinearLayoutCompat.LayoutParams)((View)localObject).getLayoutParams();
            i = localLayoutParams.gravity;
            paramInt2 = i;
            if (i < 0) {
              paramInt2 = 0x800007 & i2;
            }
            switch (d.getAbsoluteGravity(paramInt2, t.T(this)) & 0x7)
            {
            default: 
              paramInt2 = localLayoutParams.leftMargin + j;
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      i = paramInt1;
      if (bG(paramInt4)) {
        i = paramInt1 + paramInt3;
      }
      paramInt1 = i + localLayoutParams.topMargin;
      ((View)localObject).layout(paramInt2, paramInt1, i3 + paramInt2, paramInt1 + i4);
      paramInt2 = paramInt1 + (localLayoutParams.bottomMargin + i4);
      paramInt4 += 1;
      paramInt1 = paramInt2;
      break label94;
      paramInt1 = getPaddingTop() + paramInt4 - paramInt2 - paramInt1;
      break;
      paramInt3 = getPaddingTop();
      paramInt1 = (paramInt4 - paramInt2 - paramInt1) / 2 + paramInt3;
      break;
      paramInt3 = ((Drawable)localObject).getIntrinsicHeight();
      break label91;
      paramInt2 = (k - j - n - i3) / 2 + j + localLayoutParams.leftMargin - localLayoutParams.rightMargin;
      continue;
      paramInt2 = k - m - i3 - localLayoutParams.rightMargin;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject4 = null;
    Object localObject2 = null;
    Object localObject1 = null;
    int i3 = getChildCount();
    int i = 0;
    Object localObject3;
    int j;
    if (i < i3)
    {
      localObject3 = getChildAt(i);
      if (((View)localObject3).getVisibility() == 8) {
        break label733;
      }
      j = ((View)localObject3).getId();
      if (j == 2131820941) {
        localObject4 = localObject3;
      }
    }
    label218:
    label733:
    for (;;)
    {
      i += 1;
      break;
      if (j == 2131820930)
      {
        localObject2 = localObject3;
      }
      else
      {
        if ((j == 2131820933) || (j == 2131820939)) {
          if (localObject1 == null) {}
        }
        for (i = 0;; i = 0)
        {
          if (i == 0) {
            super.onMeasure(paramInt1, paramInt2);
          }
          return;
          localObject1 = localObject3;
          break;
        }
        int i5 = View.MeasureSpec.getMode(paramInt2);
        int i2 = View.MeasureSpec.getSize(paramInt2);
        int i4 = View.MeasureSpec.getMode(paramInt1);
        j = 0;
        int k = getPaddingTop() + getPaddingBottom();
        if (localObject4 != null)
        {
          localObject4.measure(paramInt1, 0);
          i = localObject4.getMeasuredHeight();
          j = View.combineMeasuredStates(0, localObject4.getMeasuredState());
          k += i;
        }
        for (;;)
        {
          i = 0;
          int m;
          if (localObject2 != null)
          {
            ((View)localObject2).measure(paramInt1, 0);
            localObject3 = localObject2;
            i = t.aa((View)localObject3);
            if (i > 0)
            {
              m = ((View)localObject2).getMeasuredHeight();
              k += i;
              j = View.combineMeasuredStates(j, ((View)localObject2).getMeasuredState());
              m -= i;
            }
          }
          for (;;)
          {
            int n;
            int i1;
            if (localObject1 != null) {
              if (i5 == 0)
              {
                n = 0;
                ((View)localObject1).measure(paramInt1, n);
                i1 = ((View)localObject1).getMeasuredHeight();
                k += i1;
                j = View.combineMeasuredStates(j, ((View)localObject1).getMeasuredState());
              }
            }
            for (;;)
            {
              i2 -= k;
              if (localObject2 != null)
              {
                int i6 = Math.min(i2, m);
                m = i2;
                n = i;
                if (i6 > 0)
                {
                  m = i2 - i6;
                  n = i + i6;
                }
                ((View)localObject2).measure(paramInt1, View.MeasureSpec.makeMeasureSpec(n, 1073741824));
                k = ((View)localObject2).getMeasuredHeight() + (k - i);
                i = View.combineMeasuredStates(j, ((View)localObject2).getMeasuredState());
              }
              for (j = k;; j = k)
              {
                if ((localObject1 != null) && (m > 0))
                {
                  ((View)localObject1).measure(paramInt1, View.MeasureSpec.makeMeasureSpec(m + i1, i5));
                  k = ((View)localObject1).getMeasuredHeight() + (j - i1);
                  j = View.combineMeasuredStates(i, ((View)localObject1).getMeasuredState());
                  i = k;
                }
                for (;;)
                {
                  m = 0;
                  k = 0;
                  for (;;)
                  {
                    if (k < i3)
                    {
                      localObject1 = getChildAt(k);
                      n = m;
                      if (((View)localObject1).getVisibility() != 8) {
                        n = Math.max(m, ((View)localObject1).getMeasuredWidth());
                      }
                      k += 1;
                      m = n;
                      continue;
                      if ((localObject3 instanceof ViewGroup))
                      {
                        localObject3 = (ViewGroup)localObject3;
                        if (((ViewGroup)localObject3).getChildCount() == 1)
                        {
                          localObject3 = ((ViewGroup)localObject3).getChildAt(0);
                          break;
                        }
                      }
                      i = 0;
                      break label218;
                      n = View.MeasureSpec.makeMeasureSpec(Math.max(0, i2 - k), i5);
                      break label262;
                    }
                  }
                  setMeasuredDimension(View.resolveSizeAndState(m + (getPaddingLeft() + getPaddingRight()), paramInt1, j), View.resolveSizeAndState(i, paramInt2, 0));
                  if (i4 != 1073741824)
                  {
                    j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
                    i = 0;
                    while (i < i3)
                    {
                      localObject1 = getChildAt(i);
                      if (((View)localObject1).getVisibility() != 8)
                      {
                        localObject2 = (LinearLayoutCompat.LayoutParams)((View)localObject1).getLayoutParams();
                        if (((LinearLayoutCompat.LayoutParams)localObject2).width == -1)
                        {
                          k = ((LinearLayoutCompat.LayoutParams)localObject2).height;
                          ((LinearLayoutCompat.LayoutParams)localObject2).height = ((View)localObject1).getMeasuredHeight();
                          measureChildWithMargins((View)localObject1, j, 0, paramInt2, 0);
                          ((LinearLayoutCompat.LayoutParams)localObject2).height = k;
                        }
                      }
                      i += 1;
                    }
                  }
                  i = 1;
                  break;
                  k = i;
                  i = j;
                  j = k;
                }
                i = j;
                m = i2;
              }
              i1 = 0;
            }
            m = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v7.widget.AlertDialogLayout
 * JD-Core Version:    0.7.0.1
 */