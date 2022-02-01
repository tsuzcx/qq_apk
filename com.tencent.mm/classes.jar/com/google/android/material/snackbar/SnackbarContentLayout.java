package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.g.w;
import com.google.android.material.a.d;
import com.google.android.material.a.f;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnackbarContentLayout
  extends LinearLayout
{
  private TextView bEG;
  private Button bEH;
  private int bEI;
  private int maxWidth;
  
  public SnackbarContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(239387);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.SnackbarLayout);
    this.maxWidth = paramContext.getDimensionPixelSize(a.k.SnackbarLayout_android_maxWidth, -1);
    this.bEI = paramContext.getDimensionPixelSize(a.k.SnackbarLayout_maxActionInlineWidth, -1);
    paramContext.recycle();
    AppMethodBeat.o(239387);
  }
  
  private static void o(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239400);
    if (w.ab(paramView))
    {
      w.g(paramView, w.L(paramView), paramInt1, w.M(paramView), paramInt2);
      AppMethodBeat.o(239400);
      return;
    }
    paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
    AppMethodBeat.o(239400);
  }
  
  private boolean z(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(239398);
    boolean bool = false;
    if (paramInt1 != getOrientation())
    {
      setOrientation(paramInt1);
      bool = true;
    }
    if ((this.bEG.getPaddingTop() != paramInt2) || (this.bEG.getPaddingBottom() != paramInt3))
    {
      o(this.bEG, paramInt2, paramInt3);
      bool = true;
    }
    AppMethodBeat.o(239398);
    return bool;
  }
  
  public Button getActionView()
  {
    return this.bEH;
  }
  
  public TextView getMessageView()
  {
    return this.bEG;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(239389);
    super.onFinishInflate();
    this.bEG = ((TextView)findViewById(a.f.snackbar_text));
    this.bEH = ((Button)findViewById(a.f.snackbar_action));
    AppMethodBeat.o(239389);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239396);
    super.onMeasure(paramInt1, paramInt2);
    int i = paramInt1;
    if (this.maxWidth > 0)
    {
      i = paramInt1;
      if (getMeasuredWidth() > this.maxWidth)
      {
        i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, 1073741824);
        super.onMeasure(i, paramInt2);
      }
    }
    int j = getResources().getDimensionPixelSize(a.d.design_snackbar_padding_vertical_2lines);
    int k = getResources().getDimensionPixelSize(a.d.design_snackbar_padding_vertical);
    if (this.bEG.getLayout().getLineCount() > 1)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || (this.bEI <= 0) || (this.bEH.getMeasuredWidth() <= this.bEI)) {
        break label152;
      }
      if (!z(1, j, j - k)) {
        break label180;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        super.onMeasure(i, paramInt2);
      }
      AppMethodBeat.o(239396);
      return;
      paramInt1 = 0;
      break;
      label152:
      if (paramInt1 != 0) {}
      for (paramInt1 = j;; paramInt1 = k)
      {
        if (!z(0, paramInt1, paramInt1)) {
          break label180;
        }
        paramInt1 = 1;
        break;
      }
      label180:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.snackbar.SnackbarContentLayout
 * JD-Core Version:    0.7.0.1
 */