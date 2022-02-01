package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.a;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class PagerTabStrip
  extends PagerTitleStrip
{
  private int Qc = this.QD;
  private int Qd;
  private int Qe;
  private int Qf;
  private int Qg;
  private int Qh;
  private final Paint Qi = new Paint();
  private int Qj = 255;
  private boolean Qk = false;
  private boolean Ql = false;
  private int Qm;
  private boolean Qn;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.Qi.setColor(this.Qc);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.Qd = ((int)(3.0F * f + 0.5F));
    this.Qe = ((int)(6.0F * f + 0.5F));
    this.Qf = ((int)(64.0F * f));
    this.Qh = ((int)(16.0F * f + 0.5F));
    this.Qm = ((int)(1.0F * f + 0.5F));
    this.Qg = ((int)(f * 32.0F + 0.5F));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    this.Qq.setFocusable(true);
    this.Qq.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.Qp.setCurrentItem(PagerTabStrip.this.Qp.getCurrentItem() - 1);
      }
    });
    this.Qs.setFocusable(true);
    this.Qs.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.Qp.setCurrentItem(PagerTabStrip.this.Qp.getCurrentItem() + 1);
      }
    });
    if (getBackground() == null) {
      this.Qk = true;
    }
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.mTempRect;
    int i = getHeight();
    int j = this.Qr.getLeft();
    int k = this.Qh;
    int m = this.Qr.getRight();
    int n = this.Qh;
    int i1 = i - this.Qd;
    localRect.set(j - k, i1, m + n, i);
    super.a(paramInt, paramFloat, paramBoolean);
    this.Qj = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.Qr.getLeft() - this.Qh, i1, this.Qr.getRight() + this.Qh, i);
    invalidate(localRect);
  }
  
  public boolean getDrawFullUnderline()
  {
    return this.Qk;
  }
  
  int getMinHeight()
  {
    return Math.max(super.getMinHeight(), this.Qg);
  }
  
  public int getTabIndicatorColor()
  {
    return this.Qc;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.Qr.getLeft();
    int k = this.Qh;
    int m = this.Qr.getRight();
    int n = this.Qh;
    int i1 = this.Qd;
    this.Qi.setColor(this.Qj << 24 | this.Qc & 0xFFFFFF);
    paramCanvas.drawRect(j - k, i - i1, m + n, i, this.Qi);
    if (this.Qk)
    {
      this.Qi.setColor(0xFF000000 | this.Qc & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - this.Qm, getWidth() - getPaddingRight(), i, this.Qi);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.Qn)) {
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    for (;;)
    {
      return true;
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      this.Qn = false;
      continue;
      if ((Math.abs(f1 - this.mInitialMotionX) > this.mTouchSlop) || (Math.abs(f2 - this.mInitialMotionY) > this.mTouchSlop))
      {
        this.Qn = true;
        continue;
        if (f1 < this.Qr.getLeft() - this.Qh) {
          this.Qp.setCurrentItem(this.Qp.getCurrentItem() - 1);
        } else if (f1 > this.Qr.getRight() + this.Qh) {
          this.Qp.setCurrentItem(this.Qp.getCurrentItem() + 1);
        }
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.Ql) {
      if ((0xFF000000 & paramInt) != 0) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      this.Qk = bool;
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.Ql) {
      if (paramDrawable != null) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.Qk = bool;
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.Ql) {
      if (paramInt != 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.Qk = bool;
      return;
    }
  }
  
  public void setDrawFullUnderline(boolean paramBoolean)
  {
    this.Qk = paramBoolean;
    this.Ql = true;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4;
    if (paramInt4 < this.Qe) {
      i = this.Qe;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
  }
  
  public void setTabIndicatorColor(int paramInt)
  {
    this.Qc = paramInt;
    this.Qi.setColor(this.Qc);
    invalidate();
  }
  
  public void setTabIndicatorColorResource(@a int paramInt)
  {
    setTabIndicatorColor(b.n(getContext(), paramInt));
  }
  
  public void setTextSpacing(int paramInt)
  {
    int i = paramInt;
    if (paramInt < this.Qf) {
      i = this.Qf;
    }
    super.setTextSpacing(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.PagerTabStrip
 * JD-Core Version:    0.7.0.1
 */