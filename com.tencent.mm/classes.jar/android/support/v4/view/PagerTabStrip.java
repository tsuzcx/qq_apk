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
  private int NZ = this.mTextColor;
  private int Oa;
  private int Ob;
  private int Oc;
  private int Od;
  private int Oe;
  private final Paint Of = new Paint();
  private int Og = 255;
  private boolean Oh = false;
  private boolean Oi = false;
  private int Oj;
  private boolean Ok;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private final Rect mTempRect = new Rect();
  private int mTouchSlop;
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.Of.setColor(this.NZ);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.Oa = ((int)(3.0F * f + 0.5F));
    this.Ob = ((int)(6.0F * f + 0.5F));
    this.Oc = ((int)(64.0F * f));
    this.Oe = ((int)(16.0F * f + 0.5F));
    this.Oj = ((int)(1.0F * f + 0.5F));
    this.Od = ((int)(f * 32.0F + 0.5F));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    this.On.setFocusable(true);
    this.On.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.Om.setCurrentItem(PagerTabStrip.this.Om.getCurrentItem() - 1);
      }
    });
    this.Op.setFocusable(true);
    this.Op.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        PagerTabStrip.this.Om.setCurrentItem(PagerTabStrip.this.Om.getCurrentItem() + 1);
      }
    });
    if (getBackground() == null) {
      this.Oh = true;
    }
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    Rect localRect = this.mTempRect;
    int i = getHeight();
    int j = this.Oo.getLeft();
    int k = this.Oe;
    int m = this.Oo.getRight();
    int n = this.Oe;
    int i1 = i - this.Oa;
    localRect.set(j - k, i1, m + n, i);
    super.a(paramInt, paramFloat, paramBoolean);
    this.Og = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.Oo.getLeft() - this.Oe, i1, this.Oo.getRight() + this.Oe, i);
    invalidate(localRect);
  }
  
  public boolean getDrawFullUnderline()
  {
    return this.Oh;
  }
  
  int getMinHeight()
  {
    return Math.max(super.getMinHeight(), this.Od);
  }
  
  public int getTabIndicatorColor()
  {
    return this.NZ;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.Oo.getLeft();
    int k = this.Oe;
    int m = this.Oo.getRight();
    int n = this.Oe;
    int i1 = this.Oa;
    this.Of.setColor(this.Og << 24 | this.NZ & 0xFFFFFF);
    paramCanvas.drawRect(j - k, i - i1, m + n, i, this.Of);
    if (this.Oh)
    {
      this.Of.setColor(0xFF000000 | this.NZ & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - this.Oj, getWidth() - getPaddingRight(), i, this.Of);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.Ok)) {
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
      this.Ok = false;
      continue;
      if ((Math.abs(f1 - this.mInitialMotionX) > this.mTouchSlop) || (Math.abs(f2 - this.mInitialMotionY) > this.mTouchSlop))
      {
        this.Ok = true;
        continue;
        if (f1 < this.Oo.getLeft() - this.Oe) {
          this.Om.setCurrentItem(this.Om.getCurrentItem() - 1);
        } else if (f1 > this.Oo.getRight() + this.Oe) {
          this.Om.setCurrentItem(this.Om.getCurrentItem() + 1);
        }
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    super.setBackgroundColor(paramInt);
    if (!this.Oi) {
      if ((0xFF000000 & paramInt) != 0) {
        break label27;
      }
    }
    label27:
    for (boolean bool = true;; bool = false)
    {
      this.Oh = bool;
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
    if (!this.Oi) {
      if (paramDrawable != null) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.Oh = bool;
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    super.setBackgroundResource(paramInt);
    if (!this.Oi) {
      if (paramInt != 0) {
        break label24;
      }
    }
    label24:
    for (boolean bool = true;; bool = false)
    {
      this.Oh = bool;
      return;
    }
  }
  
  public void setDrawFullUnderline(boolean paramBoolean)
  {
    this.Oh = paramBoolean;
    this.Oi = true;
    invalidate();
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt4;
    if (paramInt4 < this.Ob) {
      i = this.Ob;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
  }
  
  public void setTabIndicatorColor(int paramInt)
  {
    this.NZ = paramInt;
    this.Of.setColor(this.NZ);
    invalidate();
  }
  
  public void setTabIndicatorColorResource(int paramInt)
  {
    setTabIndicatorColor(b.n(getContext(), paramInt));
  }
  
  public void setTextSpacing(int paramInt)
  {
    int i = paramInt;
    if (paramInt < this.Oc) {
      i = this.Oc;
    }
    super.setTextSpacing(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.v4.view.PagerTabStrip
 * JD-Core Version:    0.7.0.1
 */