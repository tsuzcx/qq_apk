package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.appcompat.a.f;
import androidx.appcompat.a.j;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ButtonBarLayout
  extends LinearLayout
{
  private boolean rS;
  private int rT;
  private int rU;
  
  public ButtonBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(241175);
    this.rT = -1;
    this.rU = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ButtonBarLayout);
    this.rS = paramContext.getBoolean(a.j.ButtonBarLayout_allowStacking, true);
    paramContext.recycle();
    AppMethodBeat.o(241175);
  }
  
  private int av(int paramInt)
  {
    AppMethodBeat.i(241180);
    int i = getChildCount();
    while (paramInt < i)
    {
      if (getChildAt(paramInt).getVisibility() == 0)
      {
        AppMethodBeat.o(241180);
        return paramInt;
      }
      paramInt += 1;
    }
    AppMethodBeat.o(241180);
    return -1;
  }
  
  private boolean dD()
  {
    AppMethodBeat.i(241184);
    if (getOrientation() == 1)
    {
      AppMethodBeat.o(241184);
      return true;
    }
    AppMethodBeat.o(241184);
    return false;
  }
  
  private void setStacked(boolean paramBoolean)
  {
    AppMethodBeat.i(241183);
    label22:
    View localView;
    if (paramBoolean)
    {
      i = 1;
      setOrientation(i);
      if (!paramBoolean) {
        break label83;
      }
      i = 5;
      setGravity(i);
      localView = findViewById(a.f.spacer);
      if (localView != null) {
        if (!paramBoolean) {
          break label89;
        }
      }
    }
    label83:
    label89:
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
      break label22;
    }
    AppMethodBeat.o(241183);
  }
  
  public int getMinimumHeight()
  {
    AppMethodBeat.i(241182);
    int i = Math.max(this.rU, super.getMinimumHeight());
    AppMethodBeat.o(241182);
    return i;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(241178);
    int i = View.MeasureSpec.getSize(paramInt1);
    if (this.rS)
    {
      if ((i > this.rT) && (dD())) {
        setStacked(false);
      }
      this.rT = i;
    }
    int j;
    if ((!dD()) && (View.MeasureSpec.getMode(paramInt1) == 1073741824))
    {
      j = View.MeasureSpec.makeMeasureSpec(i, -2147483648);
      i = 1;
      super.onMeasure(j, paramInt2);
      int k = i;
      if (this.rS)
      {
        k = i;
        if (!dD())
        {
          if ((getMeasuredWidthAndState() & 0xFF000000) != 16777216) {
            break label271;
          }
          j = 1;
          label110:
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
      paramInt1 = av(0);
      if (paramInt1 < 0) {
        break label287;
      }
      View localView = getChildAt(paramInt1);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      paramInt2 = getPaddingTop();
      i = localView.getMeasuredHeight();
      j = localLayoutParams.topMargin;
      paramInt2 = localLayoutParams.bottomMargin + (i + paramInt2 + j) + 0;
      if (!dD()) {
        break label277;
      }
      i = av(paramInt1 + 1);
      paramInt1 = paramInt2;
      if (i >= 0) {
        paramInt1 = paramInt2 + (getChildAt(i).getPaddingTop() + (int)(16.0F * getResources().getDisplayMetrics().density));
      }
    }
    for (;;)
    {
      if (w.P(this) != paramInt1) {
        setMinimumHeight(paramInt1);
      }
      AppMethodBeat.o(241178);
      return;
      i = 0;
      j = paramInt1;
      break;
      label271:
      j = 0;
      break label110;
      label277:
      paramInt1 = paramInt2 + getPaddingBottom();
      continue;
      label287:
      paramInt1 = 0;
    }
  }
  
  public void setAllowStacking(boolean paramBoolean)
  {
    AppMethodBeat.i(241177);
    if (this.rS != paramBoolean)
    {
      this.rS = paramBoolean;
      if ((!this.rS) && (getOrientation() == 1)) {
        setStacked(false);
      }
      requestLayout();
    }
    AppMethodBeat.o(241177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.widget.ButtonBarLayout
 * JD-Core Version:    0.7.0.1
 */