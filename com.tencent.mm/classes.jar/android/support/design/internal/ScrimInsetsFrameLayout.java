package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.a.a;
import android.support.v4.view.ac;
import android.support.v4.view.p;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;

public class ScrimInsetsFrameLayout
  extends FrameLayout
{
  Drawable lm;
  Rect ln;
  private Rect lo = new Rect();
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrimInsetsFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = f.a(paramContext, paramAttributeSet, a.a.ScrimInsetsFrameLayout, paramInt, 2131821687, new int[0]);
    this.lm = paramContext.getDrawable(0);
    paramContext.recycle();
    setWillNotDraw(true);
    u.a(this, new p()
    {
      public final ac a(View paramAnonymousView, ac paramAnonymousac)
      {
        if (ScrimInsetsFrameLayout.this.ln == null) {
          ScrimInsetsFrameLayout.this.ln = new Rect();
        }
        ScrimInsetsFrameLayout.this.ln.set(paramAnonymousac.getSystemWindowInsetLeft(), paramAnonymousac.getSystemWindowInsetTop(), paramAnonymousac.getSystemWindowInsetRight(), paramAnonymousac.getSystemWindowInsetBottom());
        ScrimInsetsFrameLayout.this.a(paramAnonymousac);
        paramAnonymousView = ScrimInsetsFrameLayout.this;
        if (Build.VERSION.SDK_INT >= 20)
        {
          bool = ((WindowInsets)paramAnonymousac.Rm).hasSystemWindowInsets();
          if ((bool) && (ScrimInsetsFrameLayout.this.lm != null)) {
            break label120;
          }
        }
        label120:
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setWillNotDraw(bool);
          u.X(ScrimInsetsFrameLayout.this);
          return paramAnonymousac.fI();
          bool = false;
          break;
        }
      }
    });
  }
  
  protected void a(ac paramac) {}
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    if ((this.ln != null) && (this.lm != null))
    {
      int k = paramCanvas.save();
      paramCanvas.translate(getScrollX(), getScrollY());
      this.lo.set(0, 0, i, this.ln.top);
      this.lm.setBounds(this.lo);
      this.lm.draw(paramCanvas);
      this.lo.set(0, j - this.ln.bottom, i, j);
      this.lm.setBounds(this.lo);
      this.lm.draw(paramCanvas);
      this.lo.set(0, this.ln.top, this.ln.left, j - this.ln.bottom);
      this.lm.setBounds(this.lo);
      this.lm.draw(paramCanvas);
      this.lo.set(i - this.ln.right, this.ln.top, i, j - this.ln.bottom);
      this.lm.setBounds(this.lo);
      this.lm.draw(paramCanvas);
      paramCanvas.restoreToCount(k);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.lm != null) {
      this.lm.setCallback(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.lm != null) {
      this.lm.setCallback(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.ScrimInsetsFrameLayout
 * JD-Core Version:    0.7.0.1
 */