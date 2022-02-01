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
  private TextView qE;
  private Button qF;
  private int qG;
  
  public SnackbarContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.SnackbarLayout);
    this.maxWidth = paramContext.getDimensionPixelSize(0, -1);
    this.qG = paramContext.getDimensionPixelSize(2, -1);
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
    if ((this.qE.getPaddingTop() != paramInt2) || (this.qE.getPaddingBottom() != paramInt3))
    {
      e(this.qE, paramInt2, paramInt3);
      bool = true;
    }
    return bool;
  }
  
  public final void bn()
  {
    this.qE.setAlpha(0.0F);
    this.qE.animate().alpha(1.0F).setDuration(180L).setStartDelay(70L).start();
    if (this.qF.getVisibility() == 0)
    {
      this.qF.setAlpha(0.0F);
      this.qF.animate().alpha(1.0F).setDuration(180L).setStartDelay(70L).start();
    }
  }
  
  public final void bo()
  {
    this.qE.setAlpha(1.0F);
    this.qE.animate().alpha(0.0F).setDuration(180L).setStartDelay(0L).start();
    if (this.qF.getVisibility() == 0)
    {
      this.qF.setAlpha(1.0F);
      this.qF.animate().alpha(0.0F).setDuration(180L).setStartDelay(0L).start();
    }
  }
  
  public Button getActionView()
  {
    return this.qF;
  }
  
  public TextView getMessageView()
  {
    return this.qE;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.qE = ((TextView)findViewById(2131304885));
    this.qF = ((Button)findViewById(2131304884));
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
    if (this.qE.getLayout().getLineCount() > 1)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || (this.qG <= 0) || (this.qF.getMeasuredWidth() <= this.qG)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.SnackbarContentLayout
 * JD-Core Version:    0.7.0.1
 */