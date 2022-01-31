package android.support.design.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.a.d;
import android.support.design.a.f;
import android.support.design.a.k;
import android.support.design.widget.b.b;
import android.support.v4.view.q;
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
  implements b.b
{
  private TextView ee;
  private Button ef;
  private int eg;
  private int eh;
  
  public SnackbarContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.SnackbarLayout);
    this.eg = paramContext.getDimensionPixelSize(a.k.SnackbarLayout_android_maxWidth, -1);
    this.eh = paramContext.getDimensionPixelSize(a.k.SnackbarLayout_maxActionInlineWidth, -1);
    paramContext.recycle();
  }
  
  private boolean e(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if (paramInt1 != getOrientation())
    {
      setOrientation(paramInt1);
      bool = true;
    }
    TextView localTextView;
    if ((this.ee.getPaddingTop() != paramInt2) || (this.ee.getPaddingBottom() != paramInt3))
    {
      localTextView = this.ee;
      if (!q.ag(localTextView)) {
        break label78;
      }
      q.d(localTextView, q.T(localTextView), paramInt2, q.U(localTextView), paramInt3);
    }
    for (;;)
    {
      bool = true;
      return bool;
      label78:
      localTextView.setPadding(localTextView.getPaddingLeft(), paramInt2, localTextView.getPaddingRight(), paramInt3);
    }
  }
  
  public final void Y()
  {
    this.ee.setAlpha(0.0F);
    this.ee.animate().alpha(1.0F).setDuration(180L).setStartDelay(70L).start();
    if (this.ef.getVisibility() == 0)
    {
      this.ef.setAlpha(0.0F);
      this.ef.animate().alpha(1.0F).setDuration(180L).setStartDelay(70L).start();
    }
  }
  
  public final void Z()
  {
    this.ee.setAlpha(1.0F);
    this.ee.animate().alpha(0.0F).setDuration(180L).setStartDelay(0L).start();
    if (this.ef.getVisibility() == 0)
    {
      this.ef.setAlpha(1.0F);
      this.ef.animate().alpha(0.0F).setDuration(180L).setStartDelay(0L).start();
    }
  }
  
  public Button getActionView()
  {
    return this.ef;
  }
  
  public TextView getMessageView()
  {
    return this.ee;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.ee = ((TextView)findViewById(a.f.snackbar_text));
    this.ef = ((Button)findViewById(a.f.snackbar_action));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = paramInt1;
    if (this.eg > 0)
    {
      i = paramInt1;
      if (getMeasuredWidth() > this.eg)
      {
        i = View.MeasureSpec.makeMeasureSpec(this.eg, 1073741824);
        super.onMeasure(i, paramInt2);
      }
    }
    int j = getResources().getDimensionPixelSize(a.d.design_snackbar_padding_vertical_2lines);
    int k = getResources().getDimensionPixelSize(a.d.design_snackbar_padding_vertical);
    if (this.ee.getLayout().getLineCount() > 1)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || (this.eh <= 0) || (this.ef.getMeasuredWidth() <= this.eh)) {
        break label142;
      }
      if (!e(1, j, j - k)) {
        break label170;
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
      label142:
      if (paramInt1 != 0) {}
      for (paramInt1 = j;; paramInt1 = k)
      {
        if (!e(0, paramInt1, paramInt1)) {
          break label170;
        }
        paramInt1 = 1;
        break;
      }
      label170:
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.internal.SnackbarContentLayout
 * JD-Core Version:    0.7.0.1
 */