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
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.TextView;

public class PagerTabStrip
  extends PagerTitleStrip
{
  private int Ne = this.mTextColor;
  private int Nf;
  private int Ng;
  private int Nh;
  private int Ni;
  private int Nj;
  private final Paint Nk = new Paint();
  private int Nl = 255;
  private boolean Nm = false;
  private boolean Nn = false;
  private int No;
  private boolean Np;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.Nk.setColor(this.Ne);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.Nf = ((int)(3.0F * f + 0.5F));
    this.Ng = ((int)(6.0F * f + 0.5F));
    this.Nh = ((int)(64.0F * f));
    this.Nj = ((int)(16.0F * f + 0.5F));
    this.No = ((int)(1.0F * f + 0.5F));
    this.Ni = ((int)(f * 32.0F + 0.5F));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    this.Ns.setFocusable(true);
    this.Ns.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.Nr.setCurrentItem(PagerTabStrip.this.Nr.getCurrentItem() - 1);
      }
    });
    this.Nu.setFocusable(true);
    this.Nu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.Nr.setCurrentItem(PagerTabStrip.this.Nr.getCurrentItem() + 1);
      }
    });
    if (getBackground() == null) {
      this.Nm = true;
    }
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.mTempRect;
    int i = getHeight();
    int j = this.Nt.getLeft();
    int k = this.Nj;
    int m = this.Nt.getRight();
    int n = this.Nj;
    int i1 = i - this.Nf;
    localRect.set(j - k, i1, m + n, i);
    super.a(paramInt, paramFloat, paramBoolean);
    this.Nl = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.Nt.getLeft() - this.Nj, i1, this.Nt.getRight() + this.Nj, i);
    invalidate(localRect);
  }
  
  public boolean getDrawFullUnderline()
  {
    return this.Nm;
  }
  
  int getMinHeight()
  {
    return Math.max(super.getMinHeight(), this.Ni);
  }
  
  public int getTabIndicatorColor()
  {
    return this.Ne;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.Nt.getLeft();
    int k = this.Nj;
    int m = this.Nt.getRight();
    int n = this.Nj;
    int i1 = this.Nf;
    this.Nk.setColor(this.Nl << 24 | this.Ne & 0xFFFFFF);
    paramCanvas.drawRect(j - k, i - i1, m + n, i, this.Nk);
    if (this.Nm)
    {
      this.Nk.setColor(0xFF000000 | this.Ne & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - this.No, getWidth() - getPaddingRight(), i, this.Nk);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.Np)) {
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
      this.Np = false;
      continue;
      if ((Math.abs(f1 - this.mInitialMotionX) > this.mTouchSlop) || (Math.abs(f2 - this.mInitialMotionY) > this.mTouchSlop))
      {
        this.Np = true;
        continue;
        if (f1 < this.Nt.getLeft() - this.Nj) {
          this.Nr.setCurrentItem(this.Nr.getCurrentItem() - 1);
        } else if (f1 > this.Nt.getRight() + this.Nj) {
          this.Nr.setCurrentItem(this.Nr.getCurrentItem() + 1);
        }
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.Nn) {
      if ((0xFF000000 & paramInt) != 0) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      this.Nm = bool;
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.Nn) {
      if (paramDrawable != null) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.Nm = bool;
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.Nn) {
      if (paramInt != 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.Nm = bool;
      return;
    }
  }
  
  public void setDrawFullUnderline(boolean paramBoolean)
  {
    this.Nm = paramBoolean;
    this.Nn = true;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4;
    if (paramInt4 < this.Ng) {
      i = this.Ng;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
  }
  
  public void setTabIndicatorColor(int paramInt)
  {
    this.Ne = paramInt;
    this.Nk.setColor(this.Ne);
    invalidate();
  }
  
  public void setTabIndicatorColorResource(int paramInt)
  {
    setTabIndicatorColor(b.n(getContext(), paramInt));
  }
  
  public void setTextSpacing(int paramInt)
  {
    int i = paramInt;
    if (paramInt < this.Nh) {
      i = this.Nh;
    }
    super.setTextSpacing(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v4.view.PagerTabStrip
 * JD-Core Version:    0.7.0.1
 */