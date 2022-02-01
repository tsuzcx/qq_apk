package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a.a;
import android.support.v4.view.ab;
import android.support.v4.view.p;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout
  extends FrameLayout
{
  Drawable lk;
  Rect ll;
  private Rect lm = new Rect();
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = f.a(paramContext, paramAttributeSet, a.a.ScrimInsetsFrameLayout, paramInt, 2131821639, new int[0]);
    this.lk = paramContext.getDrawable(0);
    paramContext.recycle();
    setWillNotDraw(true);
    t.a(this, new p()
    {
      public final ab a(View paramAnonymousView, ab paramAnonymousab)
      {
        if (ScrimInsetsFrameLayout.this.ll == null) {
          ScrimInsetsFrameLayout.this.ll = new Rect();
        }
        ScrimInsetsFrameLayout.this.ll.set(paramAnonymousab.getSystemWindowInsetLeft(), paramAnonymousab.getSystemWindowInsetTop(), paramAnonymousab.getSystemWindowInsetRight(), paramAnonymousab.getSystemWindowInsetBottom());
        ScrimInsetsFrameLayout.this.a(paramAnonymousab);
        paramAnonymousView = ScrimInsetsFrameLayout.this;
        if (Build.VERSION.SDK_INT >= 20)
        {
          bool = ((WindowInsets)paramAnonymousab.QZ).hasSystemWindowInsets();
          if ((bool) && (ScrimInsetsFrameLayout.this.lk != null)) {
            break label120;
          }
        }
        label120:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setWillNotDraw(bool);
          t.W(ScrimInsetsFrameLayout.this);
          return paramAnonymousab.fB();
          bool = false;
          break;
        }
      }
    });
  }
  
  protected void a(ab paramab) {}
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((this.ll != null) && (this.lk != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.lm.set(0, 0, i, this.ll.top);
      this.lk.setBounds(this.lm);
      this.lk.draw(paramCanvas);
      this.lm.set(0, j - this.ll.bottom, i, j);
      this.lk.setBounds(this.lm);
      this.lk.draw(paramCanvas);
      this.lm.set(0, this.ll.top, this.ll.left, j - this.ll.bottom);
      this.lk.setBounds(this.lm);
      this.lk.draw(paramCanvas);
      this.lm.set(i - this.ll.right, this.ll.top, i, j - this.ll.bottom);
      this.lk.setBounds(this.lm);
      this.lk.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.lk != null) {
      this.lk.setCallback(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.lk != null) {
      this.lk.setCallback(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.internal.ScrimInsetsFrameLayout
 * JD-Core Version:    0.7.0.1
 */