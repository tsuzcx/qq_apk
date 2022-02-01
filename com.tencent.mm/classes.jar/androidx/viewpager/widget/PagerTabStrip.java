package androidx.viewpager.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PagerTabStrip
  extends PagerTitleStrip
{
  private int avj;
  private int avk;
  private int avl;
  private int avm;
  private int avn;
  private int avo;
  private final Paint avp;
  private int avq;
  private boolean avr;
  private boolean avs;
  private int avt;
  private boolean avu;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private final Rect mTempRect;
  private int mTouchSlop;
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235106);
    this.avp = new Paint();
    this.mTempRect = new Rect();
    this.avq = 255;
    this.avr = false;
    this.avs = false;
    this.avj = this.avJ;
    this.avp.setColor(this.avj);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.avk = ((int)(3.0F * f + 0.5F));
    this.avl = ((int)(6.0F * f + 0.5F));
    this.avm = ((int)(64.0F * f));
    this.avo = ((int)(16.0F * f + 0.5F));
    this.avt = ((int)(1.0F * f + 0.5F));
    this.avn = ((int)(f * 32.0F + 0.5F));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    this.avx.setFocusable(true);
    this.avx.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(235087);
        PagerTabStrip.this.avw.setCurrentItem(PagerTabStrip.this.avw.getCurrentItem() - 1);
        AppMethodBeat.o(235087);
      }
    });
    this.avz.setFocusable(true);
    this.avz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(235097);
        PagerTabStrip.this.avw.setCurrentItem(PagerTabStrip.this.avw.getCurrentItem() + 1);
        AppMethodBeat.o(235097);
      }
    });
    if (getBackground() == null) {
      this.avr = true;
    }
    AppMethodBeat.o(235106);
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(235132);
    Rect localRect = this.mTempRect;
    int i = getHeight();
    int j = this.avy.getLeft();
    int k = this.avo;
    int m = this.avy.getRight();
    int n = this.avo;
    int i1 = i - this.avk;
    localRect.set(j - k, i1, m + n, i);
    super.a(paramInt, paramFloat, paramBoolean);
    this.avq = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.avy.getLeft() - this.avo, i1, this.avy.getRight() + this.avo, i);
    invalidate(localRect);
    AppMethodBeat.o(235132);
  }
  
  public boolean getDrawFullUnderline()
  {
    return this.avr;
  }
  
  int getMinHeight()
  {
    AppMethodBeat.i(235122);
    int i = Math.max(super.getMinHeight(), this.avn);
    AppMethodBeat.o(235122);
    return i;
  }
  
  public int getTabIndicatorColor()
  {
    return this.avj;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(235128);
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.avy.getLeft();
    int k = this.avo;
    int m = this.avy.getRight();
    int n = this.avo;
    int i1 = this.avk;
    this.avp.setColor(this.avq << 24 | this.avj & 0xFFFFFF);
    paramCanvas.drawRect(j - k, i - i1, m + n, i, this.avp);
    if (this.avr)
    {
      this.avp.setColor(0xFF000000 | this.avj & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - this.avt, getWidth() - getPaddingRight(), i, this.avp);
    }
    AppMethodBeat.o(235128);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235124);
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.avu))
    {
      AppMethodBeat.o(235124);
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(235124);
      return true;
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      this.avu = false;
      continue;
      if ((Math.abs(f1 - this.mInitialMotionX) > this.mTouchSlop) || (Math.abs(f2 - this.mInitialMotionY) > this.mTouchSlop))
      {
        this.avu = true;
        continue;
        if (f1 < this.avy.getLeft() - this.avo) {
          this.avw.setCurrentItem(this.avw.getCurrentItem() - 1);
        } else if (f1 > this.avy.getRight() + this.avo) {
          this.avw.setCurrentItem(this.avw.getCurrentItem() + 1);
        }
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(235116);
    super.setBackgroundColor(paramInt);
    if (!this.avs) {
      if ((0xFF000000 & paramInt) != 0) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      this.avr = bool;
      AppMethodBeat.o(235116);
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(235115);
    super.setBackgroundDrawable(paramDrawable);
    if (!this.avs) {
      if (paramDrawable != null) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.avr = bool;
      AppMethodBeat.o(235115);
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(235117);
    super.setBackgroundResource(paramInt);
    if (!this.avs) {
      if (paramInt != 0) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.avr = bool;
      AppMethodBeat.o(235117);
      return;
    }
  }
  
  public void setDrawFullUnderline(boolean paramBoolean)
  {
    AppMethodBeat.i(235119);
    this.avr = paramBoolean;
    this.avs = true;
    invalidate();
    AppMethodBeat.o(235119);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235113);
    int i = paramInt4;
    if (paramInt4 < this.avl) {
      i = this.avl;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
    AppMethodBeat.o(235113);
  }
  
  public void setTabIndicatorColor(int paramInt)
  {
    AppMethodBeat.i(235108);
    this.avj = paramInt;
    this.avp.setColor(this.avj);
    invalidate();
    AppMethodBeat.o(235108);
  }
  
  public void setTabIndicatorColorResource(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(235109);
    setTabIndicatorColor(androidx.core.content.a.w(getContext(), paramInt));
    AppMethodBeat.o(235109);
  }
  
  public void setTextSpacing(int paramInt)
  {
    AppMethodBeat.i(235114);
    int i = paramInt;
    if (paramInt < this.avm) {
      i = this.avm;
    }
    super.setTextSpacing(i);
    AppMethodBeat.o(235114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.viewpager.widget.PagerTabStrip
 * JD-Core Version:    0.7.0.1
 */