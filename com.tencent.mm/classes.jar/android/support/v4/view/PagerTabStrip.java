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
  private int FA;
  private final Paint FB = new Paint();
  private int FC = 255;
  private boolean FD = false;
  private boolean FE = false;
  private int FF;
  private boolean FG;
  private float FH;
  private float FI;
  private int Fv = this.FY;
  private int Fw;
  private int Fx;
  private int Fy;
  private int Fz;
  private final Rect ec = new Rect();
  private int jb;
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.FB.setColor(this.Fv);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.Fw = ((int)(3.0F * f + 0.5F));
    this.Fx = ((int)(6.0F * f + 0.5F));
    this.Fy = ((int)(64.0F * f));
    this.FA = ((int)(16.0F * f + 0.5F));
    this.FF = ((int)(1.0F * f + 0.5F));
    this.Fz = ((int)(f * 32.0F + 0.5F));
    this.jb = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    this.FL.setFocusable(true);
    this.FL.setOnClickListener(new PagerTabStrip.1(this));
    this.FN.setFocusable(true);
    this.FN.setOnClickListener(new PagerTabStrip.2(this));
    if (getBackground() == null) {
      this.FD = true;
    }
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.ec;
    int i = getHeight();
    int j = this.FM.getLeft();
    int k = this.FA;
    int m = this.FM.getRight();
    int n = this.FA;
    int i1 = i - this.Fw;
    localRect.set(j - k, i1, m + n, i);
    super.a(paramInt, paramFloat, paramBoolean);
    this.FC = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.FM.getLeft() - this.FA, i1, this.FM.getRight() + this.FA, i);
    invalidate(localRect);
  }
  
  public boolean getDrawFullUnderline()
  {
    return this.FD;
  }
  
  int getMinHeight()
  {
    return Math.max(super.getMinHeight(), this.Fz);
  }
  
  public int getTabIndicatorColor()
  {
    return this.Fv;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.FM.getLeft();
    int k = this.FA;
    int m = this.FM.getRight();
    int n = this.FA;
    int i1 = this.Fw;
    this.FB.setColor(this.FC << 24 | this.Fv & 0xFFFFFF);
    paramCanvas.drawRect(j - k, i - i1, m + n, i, this.FB);
    if (this.FD)
    {
      this.FB.setColor(0xFF000000 | this.Fv & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - this.FF, getWidth() - getPaddingRight(), i, this.FB);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.FG)) {
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
      this.FH = f1;
      this.FI = f2;
      this.FG = false;
      continue;
      if ((Math.abs(f1 - this.FH) > this.jb) || (Math.abs(f2 - this.FI) > this.jb))
      {
        this.FG = true;
        continue;
        if (f1 < this.FM.getLeft() - this.FA) {
          this.FK.setCurrentItem(this.FK.getCurrentItem() - 1);
        } else if (f1 > this.FM.getRight() + this.FA) {
          this.FK.setCurrentItem(this.FK.getCurrentItem() + 1);
        }
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.FE) {
      if ((0xFF000000 & paramInt) != 0) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      this.FD = bool;
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.FE) {
      if (paramDrawable != null) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.FD = bool;
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.FE) {
      if (paramInt != 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.FD = bool;
      return;
    }
  }
  
  public void setDrawFullUnderline(boolean paramBoolean)
  {
    this.FD = paramBoolean;
    this.FE = true;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4;
    if (paramInt4 < this.Fx) {
      i = this.Fx;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
  }
  
  public void setTabIndicatorColor(int paramInt)
  {
    this.Fv = paramInt;
    this.FB.setColor(this.Fv);
    invalidate();
  }
  
  public void setTabIndicatorColorResource(int paramInt)
  {
    setTabIndicatorColor(b.i(getContext(), paramInt));
  }
  
  public void setTextSpacing(int paramInt)
  {
    int i = paramInt;
    if (paramInt < this.Fy) {
      i = this.Fy;
    }
    super.setTextSpacing(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.PagerTabStrip
 * JD-Core Version:    0.7.0.1
 */