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
  private int PQ = this.mTextColor;
  private int PR;
  private int PS;
  private int PT;
  private int PU;
  private int PV;
  private final Paint PW = new Paint();
  private int PX = 255;
  private boolean PY = false;
  private boolean PZ = false;
  private int Qa;
  private boolean Qb;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.PW.setColor(this.PQ);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.PR = ((int)(3.0F * f + 0.5F));
    this.PS = ((int)(6.0F * f + 0.5F));
    this.PT = ((int)(64.0F * f));
    this.PV = ((int)(16.0F * f + 0.5F));
    this.Qa = ((int)(1.0F * f + 0.5F));
    this.PU = ((int)(f * 32.0F + 0.5F));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    this.Qe.setFocusable(true);
    this.Qe.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.Qd.setCurrentItem(PagerTabStrip.this.Qd.getCurrentItem() - 1);
      }
    });
    this.Qg.setFocusable(true);
    this.Qg.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.Qd.setCurrentItem(PagerTabStrip.this.Qd.getCurrentItem() + 1);
      }
    });
    if (getBackground() == null) {
      this.PY = true;
    }
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.mTempRect;
    int i = getHeight();
    int j = this.Qf.getLeft();
    int k = this.PV;
    int m = this.Qf.getRight();
    int n = this.PV;
    int i1 = i - this.PR;
    localRect.set(j - k, i1, m + n, i);
    super.a(paramInt, paramFloat, paramBoolean);
    this.PX = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.Qf.getLeft() - this.PV, i1, this.Qf.getRight() + this.PV, i);
    invalidate(localRect);
  }
  
  public boolean getDrawFullUnderline()
  {
    return this.PY;
  }
  
  int getMinHeight()
  {
    return Math.max(super.getMinHeight(), this.PU);
  }
  
  public int getTabIndicatorColor()
  {
    return this.PQ;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.Qf.getLeft();
    int k = this.PV;
    int m = this.Qf.getRight();
    int n = this.PV;
    int i1 = this.PR;
    this.PW.setColor(this.PX << 24 | this.PQ & 0xFFFFFF);
    paramCanvas.drawRect(j - k, i - i1, m + n, i, this.PW);
    if (this.PY)
    {
      this.PW.setColor(0xFF000000 | this.PQ & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - this.Qa, getWidth() - getPaddingRight(), i, this.PW);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.Qb)) {
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
      this.Qb = false;
      continue;
      if ((Math.abs(f1 - this.mInitialMotionX) > this.mTouchSlop) || (Math.abs(f2 - this.mInitialMotionY) > this.mTouchSlop))
      {
        this.Qb = true;
        continue;
        if (f1 < this.Qf.getLeft() - this.PV) {
          this.Qd.setCurrentItem(this.Qd.getCurrentItem() - 1);
        } else if (f1 > this.Qf.getRight() + this.PV) {
          this.Qd.setCurrentItem(this.Qd.getCurrentItem() + 1);
        }
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.PZ) {
      if ((0xFF000000 & paramInt) != 0) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      this.PY = bool;
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.PZ) {
      if (paramDrawable != null) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.PY = bool;
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.PZ) {
      if (paramInt != 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.PY = bool;
      return;
    }
  }
  
  public void setDrawFullUnderline(boolean paramBoolean)
  {
    this.PY = paramBoolean;
    this.PZ = true;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4;
    if (paramInt4 < this.PS) {
      i = this.PS;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
  }
  
  public void setTabIndicatorColor(int paramInt)
  {
    this.PQ = paramInt;
    this.PW.setColor(this.PQ);
    invalidate();
  }
  
  public void setTabIndicatorColorResource(int paramInt)
  {
    setTabIndicatorColor(b.n(getContext(), paramInt));
  }
  
  public void setTextSpacing(int paramInt)
  {
    int i = paramInt;
    if (paramInt < this.PT) {
      i = this.PT;
    }
    super.setTextSpacing(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.view.PagerTabStrip
 * JD-Core Version:    0.7.0.1
 */