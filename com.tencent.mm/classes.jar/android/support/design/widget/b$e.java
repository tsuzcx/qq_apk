package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.a.a;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.widget.FrameLayout;

class b$e
  extends FrameLayout
{
  private b.d ga;
  private b.c gb;
  
  b$e(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.SnackbarLayout);
    if (paramContext.hasValue(1)) {
      t.i(this, paramContext.getDimensionPixelSize(1, 0));
    }
    paramContext.recycle();
    setClickable(true);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    t.ak(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.gb != null) {
      this.gb.aU();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.ga != null) {
      this.ga.aV();
    }
  }
  
  void setOnAttachStateChangeListener(b.c paramc)
  {
    this.gb = paramc;
  }
  
  void setOnLayoutChangeListener(b.d paramd)
  {
    this.ga = paramd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.design.widget.b.e
 * JD-Core Version:    0.7.0.1
 */