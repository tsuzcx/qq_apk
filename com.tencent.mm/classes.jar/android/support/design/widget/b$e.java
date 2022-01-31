package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.k;
import android.support.v4.view.q;
import android.util.AttributeSet;
import android.widget.FrameLayout;

class b$e
  extends FrameLayout
{
  private b.d fb;
  private b.c fc;
  
  b$e(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.SnackbarLayout);
    if (paramContext.hasValue(a.k.SnackbarLayout_elevation)) {
      q.h(this, paramContext.getDimensionPixelSize(a.k.SnackbarLayout_elevation, 0));
    }
    paramContext.recycle();
    setClickable(true);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    q.ad(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.fc != null) {
      this.fc.aq();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.fb != null) {
      this.fb.ar();
    }
  }
  
  void setOnAttachStateChangeListener(b.c paramc)
  {
    this.fc = paramc;
  }
  
  void setOnLayoutChangeListener(b.d paramd)
  {
    this.fb = paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     android.support.design.widget.b.e
 * JD-Core Version:    0.7.0.1
 */