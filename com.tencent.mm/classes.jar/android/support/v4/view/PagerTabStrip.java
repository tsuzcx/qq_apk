package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class PagerTabStrip
  extends PagerTitleStrip
{
  private int Ge = this.GF;
  private int Gf;
  private int Gg;
  private int Gh;
  private int Gi;
  private int Gj;
  private final Paint Gk = new Paint();
  private int Gl = 255;
  private boolean Gm = false;
  private boolean Gn = false;
  private int Go;
  private boolean Gp;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.Gk.setColor(this.Ge);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.Gf = ((int)(3.0F * f + 0.5F));
    this.Gg = ((int)(6.0F * f + 0.5F));
    this.Gh = ((int)(64.0F * f));
    this.Gj = ((int)(16.0F * f + 0.5F));
    this.Go = ((int)(1.0F * f + 0.5F));
    this.Gi = ((int)(f * 32.0F + 0.5F));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    this.Gs.setFocusable(true);
    this.Gs.setOnClickListener(new PagerTabStrip.1(this));
    this.Gu.setFocusable(true);
    this.Gu.setOnClickListener(new PagerTabStrip.2(this));
    if (getBackground() == null) {
      this.Gm = true;
    }
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.mTempRect;
    int i = getHeight();
    int j = this.Gt.getLeft();
    int k = this.Gj;
    int m = this.Gt.getRight();
    int n = this.Gj;
    int i1 = i - this.Gf;
    localRect.set(j - k, i1, m + n, i);
    super.a(paramInt, paramFloat, paramBoolean);
    this.Gl = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.Gt.getLeft() - this.Gj, i1, this.Gt.getRight() + this.Gj, i);
    invalidate(localRect);
  }
  
  public boolean getDrawFullUnderline()
  {
    return this.Gm;
  }
  
  int getMinHeight()
  {
    return Math.max(super.getMinHeight(), this.Gi);
  }
  
  public int getTabIndicatorColor()
  {
    return this.Ge;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.Gt.getLeft();
    int k = this.Gj;
    int m = this.Gt.getRight();
    int n = this.Gj;
    int i1 = this.Gf;
    this.Gk.setColor(this.Gl << 24 | this.Ge & 0xFFFFFF);
    paramCanvas.drawRect(j - k, i - i1, m + n, i, this.Gk);
    if (this.Gm)
    {
      this.Gk.setColor(0xFF000000 | this.Ge & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - this.Go, getWidth() - getPaddingRight(), i, this.Gk);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.Gp)) {
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
      this.Gp = false;
      continue;
      if ((Math.abs(f1 - this.mInitialMotionX) > this.mTouchSlop) || (Math.abs(f2 - this.mInitialMotionY) > this.mTouchSlop))
      {
        this.Gp = true;
        continue;
        if (f1 < this.Gt.getLeft() - this.Gj) {
          this.Gr.setCurrentItem(this.Gr.getCurrentItem() - 1);
        } else if (f1 > this.Gt.getRight() + this.Gj) {
          this.Gr.setCurrentItem(this.Gr.getCurrentItem() + 1);
        }
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.Gn) {
      if ((0xFF000000 & paramInt) != 0) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      this.Gm = bool;
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.Gn) {
      if (paramDrawable != null) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.Gm = bool;
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.Gn) {
      if (paramInt != 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.Gm = bool;
      return;
    }
  }
  
  public void setDrawFullUnderline(boolean paramBoolean)
  {
    this.Gm = paramBoolean;
    this.Gn = true;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4;
    if (paramInt4 < this.Gg) {
      i = this.Gg;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
  }
  
  public void setTabIndicatorColor(int paramInt)
  {
    this.Ge = paramInt;
    this.Gk.setColor(this.Ge);
    invalidate();
  }
  
  public void setTabIndicatorColorResource(int paramInt)
  {
    setTabIndicatorColor(b.m(getContext(), paramInt));
  }
  
  public void setTextSpacing(int paramInt)
  {
    int i = paramInt;
    if (paramInt < this.Gh) {
      i = this.Gh;
    }
    super.setTextSpacing(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.v4.view.PagerTabStrip
 * JD-Core Version:    0.7.0.1
 */