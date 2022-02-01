package com.tencent.mm.plugin.ball.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EllipsizeLayout
  extends LinearLayout
{
  public EllipsizeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106381);
    int i;
    int j;
    Object localObject1;
    int n;
    int k;
    label128:
    int m;
    if ((getOrientation() == 0) && (View.MeasureSpec.getMode(paramInt1) == 1073741824))
    {
      i = 0;
      j = 0;
      localObject1 = null;
      int i1 = getChildCount();
      n = View.MeasureSpec.getSize(paramInt1);
      int i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(paramInt1), 0);
      k = 0;
      if ((k < i1) && (j == 0))
      {
        View localView = getChildAt(k);
        if ((localView == null) || (localView.getVisibility() == 8)) {
          break label304;
        }
        if (!(localView instanceof TextView)) {
          break label301;
        }
        Object localObject2 = (TextView)localView;
        if (((TextView)localObject2).getEllipsize() == null) {
          break label301;
        }
        if (localObject1 == null)
        {
          ((TextView)localObject2).setMaxWidth(2147483647);
          localObject1 = localObject2;
          measureChildWithMargins(localView, i2, 0, paramInt2, 0);
          localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
          if (localObject2 == null) {
            break label223;
          }
          if (((LinearLayout.LayoutParams)localObject2).weight <= 0.0F) {
            break label217;
          }
          m = 1;
          label167:
          j |= m;
          m = localView.getMeasuredWidth();
          int i3 = ((LinearLayout.LayoutParams)localObject2).leftMargin;
          i = ((LinearLayout.LayoutParams)localObject2).rightMargin + (m + i3) + i;
        }
      }
    }
    label301:
    label304:
    for (;;)
    {
      k += 1;
      break;
      j = 1;
      break label128;
      label217:
      m = 0;
      break label167;
      label223:
      j = 1;
      continue;
      if ((localObject1 == null) || (i == 0)) {}
      for (k = 1;; k = 0)
      {
        if (((k | j) == 0) && (i > n))
        {
          j = localObject1.getMeasuredWidth() - (i - n);
          i = j;
          if (j < 0) {
            i = 0;
          }
          localObject1.setMaxWidth(i);
        }
        super.onMeasure(paramInt1, paramInt2);
        AppMethodBeat.o(106381);
        return;
      }
      break label128;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.view.EllipsizeLayout
 * JD-Core Version:    0.7.0.1
 */