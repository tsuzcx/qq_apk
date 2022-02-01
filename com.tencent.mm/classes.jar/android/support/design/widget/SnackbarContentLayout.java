package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.a.a;
import android.support.design.g.a;
import android.support.v4.view.t;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SnackbarContentLayout
  extends LinearLayout
  implements a
{
  private int maxWidth;
  private TextView rE;
  private Button rF;
  private int rG;
  
  public SnackbarContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.SnackbarLayout);
    this.maxWidth = paramContext.getDimensionPixelSize(0, -1);
    this.rG = paramContext.getDimensionPixelSize(2, -1);
    paramContext.recycle();
  }
  
  private static void e(View paramView, int paramInt1, int paramInt2)
  {
    if (t.as(paramView))
    {
      t.d(paramView, t.ab(paramView), paramInt1, t.ac(paramView), paramInt2);
      return;
    }
    paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
  }
  
  private boolean f(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if (paramInt1 != getOrientation())
    {
      setOrientation(paramInt1);
      bool = true;
    }
    if ((this.rE.getPaddingTop() != paramInt2) || (this.rE.getPaddingBottom() != paramInt3))
    {
      e(this.rE, paramInt2, paramInt3);
      bool = true;
    }
    return bool;
  }
  
  public final void bu()
  {
    this.rE.setAlpha(0.0F);
    this.rE.animate().alpha(1.0F).setDuration(180L).setStartDelay(70L).start();
    if (this.rF.getVisibility() == 0)
    {
      this.rF.setAlpha(0.0F);
      this.rF.animate().alpha(1.0F).setDuration(180L).setStartDelay(70L).start();
    }
  }
  
  public final void bv()
  {
    this.rE.setAlpha(1.0F);
    this.rE.animate().alpha(0.0F).setDuration(180L).setStartDelay(0L).start();
    if (this.rF.getVisibility() == 0)
    {
      this.rF.setAlpha(1.0F);
      this.rF.animate().alpha(0.0F).setDuration(180L).setStartDelay(0L).start();
    }
  }
  
  public Button getActionView()
  {
    return this.rF;
  }
  
  public TextView getMessageView()
  {
    return this.rE;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.rE = ((TextView)findViewById(2131304885));
    this.rF = ((Button)findViewById(2131304884));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
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
    int j = getResources().getDimensionPixelSize(2131166129);
    int k = getResources().getDimensionPixelSize(2131166128);
    if (this.rE.getLayout().getLineCount() > 1)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || (this.rG <= 0) || (this.rF.getMeasuredWidth() <= this.rG)) {
        break label140;
      }
      if (!f(1, j, j - k)) {
        break label168;
      }
      paramInt1 = 1;
    }
    for (;;)
    {
      if (paramInt1 != 0) {
        super.onMeasure(i, paramInt2);
      }
      return;
      paramInt1 = 0;
      break;
      label140:
      if (paramInt1 != 0) {}
      for (paramInt1 = j;; paramInt1 = k)
      {
        if (!f(0, paramInt1, paramInt1)) {
          break label168;
        }
        paramInt1 = 1;
        break;
      }
      label168:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.SnackbarContentLayout
 * JD-Core Version:    0.7.0.1
 */