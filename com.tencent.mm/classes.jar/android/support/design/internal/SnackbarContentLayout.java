package android.support.design.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.design.a.a;
import android.support.design.widget.b.b;
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
  implements b.b
{
  private TextView fc;
  private Button fe;
  private int ff;
  private int mMaxWidth;
  
  public SnackbarContentLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.SnackbarLayout);
    this.mMaxWidth = paramContext.getDimensionPixelSize(0, -1);
    this.ff = paramContext.getDimensionPixelSize(2, -1);
    paramContext.recycle();
  }
  
  private static void a(View paramView, int paramInt1, int paramInt2)
  {
    if (t.an(paramView))
    {
      t.d(paramView, t.W(paramView), paramInt1, t.X(paramView), paramInt2);
      return;
    }
    paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
  }
  
  private boolean e(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if (paramInt1 != getOrientation())
    {
      setOrientation(paramInt1);
      bool = true;
    }
    if ((this.fc.getPaddingTop() != paramInt2) || (this.fc.getPaddingBottom() != paramInt3))
    {
      a(this.fc, paramInt2, paramInt3);
      bool = true;
    }
    return bool;
  }
  
  public final void aJ()
  {
    this.fc.setAlpha(0.0F);
    this.fc.animate().alpha(1.0F).setDuration(180L).setStartDelay(70L).start();
    if (this.fe.getVisibility() == 0)
    {
      this.fe.setAlpha(0.0F);
      this.fe.animate().alpha(1.0F).setDuration(180L).setStartDelay(70L).start();
    }
  }
  
  public final void aK()
  {
    this.fc.setAlpha(1.0F);
    this.fc.animate().alpha(0.0F).setDuration(180L).setStartDelay(0L).start();
    if (this.fe.getVisibility() == 0)
    {
      this.fe.setAlpha(1.0F);
      this.fe.animate().alpha(0.0F).setDuration(180L).setStartDelay(0L).start();
    }
  }
  
  public Button getActionView()
  {
    return this.fe;
  }
  
  public TextView getMessageView()
  {
    return this.fc;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.fc = ((TextView)findViewById(2131823376));
    this.fe = ((Button)findViewById(2131823377));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = paramInt1;
    if (this.mMaxWidth > 0)
    {
      i = paramInt1;
      if (getMeasuredWidth() > this.mMaxWidth)
      {
        i = View.MeasureSpec.makeMeasureSpec(this.mMaxWidth, 1073741824);
        super.onMeasure(i, paramInt2);
      }
    }
    int j = getResources().getDimensionPixelSize(2131427392);
    int k = getResources().getDimensionPixelSize(2131428302);
    if (this.fc.getLayout().getLineCount() > 1)
    {
      paramInt1 = 1;
      if ((paramInt1 == 0) || (this.ff <= 0) || (this.fe.getMeasuredWidth() <= this.ff)) {
        break label140;
      }
      if (!e(1, j, j - k)) {
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
        if (!e(0, paramInt1, paramInt1)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.internal.SnackbarContentLayout
 * JD-Core Version:    0.7.0.1
 */