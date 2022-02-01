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
import androidx.core.g.z;
import com.google.android.material.a.d;
import com.google.android.material.a.f;
import com.google.android.material.a.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SnackbarContentLayout
  extends LinearLayout
{
  private TextView dxG;
  private Button dxH;
  private int dxI;
  private int maxWidth;
  
  public SnackbarContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(209768);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.SnackbarLayout);
    this.maxWidth = paramContext.getDimensionPixelSize(a.k.SnackbarLayout_android_maxWidth, -1);
    this.dxI = paramContext.getDimensionPixelSize(a.k.SnackbarLayout_maxActionInlineWidth, -1);
    paramContext.recycle();
    AppMethodBeat.o(209768);
  }
  
  private boolean P(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(209775);
    boolean bool = false;
    if (paramInt1 != getOrientation())
    {
      setOrientation(paramInt1);
      bool = true;
    }
    if ((this.dxG.getPaddingTop() != paramInt2) || (this.dxG.getPaddingBottom() != paramInt3))
    {
      o(this.dxG, paramInt2, paramInt3);
      bool = true;
    }
    AppMethodBeat.o(209775);
    return bool;
  }
  
  private static void o(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209786);
    if (z.ao(paramView))
    {
      z.g(paramView, z.X(paramView), paramInt1, z.Y(paramView), paramInt2);
      AppMethodBeat.o(209786);
      return;
    }
    paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
    AppMethodBeat.o(209786);
  }
  
  public Button getActionView()
  {
    return this.dxH;
  }
  
  public TextView getMessageView()
  {
    return this.dxG;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(209794);
    super.onFinishInflate();
    this.dxG = ((TextView)findViewById(a.f.snackbar_text));
    this.dxH = ((Button)findViewById(a.f.snackbar_action));
    AppMethodBeat.o(209794);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209823);
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
    if (this.dxG.getLayout().getLineCount() > 1)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || (this.dxI <= 0) || (this.dxH.getMeasuredWidth() <= this.dxI)) {
        break label152;
      }
      if (!P(1, j, j - k)) {
        break label180;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        super.onMeasure(i, paramInt2);
      }
      AppMethodBeat.o(209823);
      return;
      paramInt1 = 0;
      break;
      label152:
      if (paramInt1 != 0) {}
      for (paramInt1 = j;; paramInt1 = k)
      {
        if (!P(0, paramInt1, paramInt1)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.snackbar.SnackbarContentLayout
 * JD-Core Version:    0.7.0.1
 */