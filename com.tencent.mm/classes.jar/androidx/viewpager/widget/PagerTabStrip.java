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
import androidx.core.content.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class PagerTabStrip
  extends PagerTitleStrip
{
  private int cjF;
  private int cjG;
  private int cjH;
  private int cjI;
  private int cjJ;
  private int cjK;
  private final Paint cjL;
  private int cjM;
  private boolean cjN;
  private boolean cjO;
  private int cjP;
  private boolean cjQ;
  private float mInitialMotionX;
  private float mInitialMotionY;
  private final Rect mTempRect;
  private int mTouchSlop;
  
  public PagerTabStrip(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(193315);
    this.cjL = new Paint();
    this.mTempRect = new Rect();
    this.cjM = 255;
    this.cjN = false;
    this.cjO = false;
    this.cjF = this.ckf;
    this.cjL.setColor(this.cjF);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.cjG = ((int)(3.0F * f + 0.5F));
    this.cjH = ((int)(6.0F * f + 0.5F));
    this.cjI = ((int)(64.0F * f));
    this.cjK = ((int)(16.0F * f + 0.5F));
    this.cjP = ((int)(1.0F * f + 0.5F));
    this.cjJ = ((int)(f * 32.0F + 0.5F));
    this.mTouchSlop = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
    setTextSpacing(getTextSpacing());
    setWillNotDraw(false);
    this.cjT.setFocusable(true);
    this.cjT.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193251);
        PagerTabStrip.this.cjS.setCurrentItem(PagerTabStrip.this.cjS.getCurrentItem() - 1);
        AppMethodBeat.o(193251);
      }
    });
    this.cjV.setFocusable(true);
    this.cjV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193267);
        PagerTabStrip.this.cjS.setCurrentItem(PagerTabStrip.this.cjS.getCurrentItem() + 1);
        AppMethodBeat.o(193267);
      }
    });
    if (getBackground() == null) {
      this.cjN = true;
    }
    AppMethodBeat.o(193315);
  }
  
  final void a(int paramInt, float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(193466);
    Rect localRect = this.mTempRect;
    int i = getHeight();
    int j = this.cjU.getLeft();
    int k = this.cjK;
    int m = this.cjU.getRight();
    int n = this.cjK;
    int i1 = i - this.cjG;
    localRect.set(j - k, i1, m + n, i);
    super.a(paramInt, paramFloat, paramBoolean);
    this.cjM = ((int)(Math.abs(paramFloat - 0.5F) * 2.0F * 255.0F));
    localRect.union(this.cjU.getLeft() - this.cjK, i1, this.cjU.getRight() + this.cjK, i);
    invalidate(localRect);
    AppMethodBeat.o(193466);
  }
  
  public boolean getDrawFullUnderline()
  {
    return this.cjN;
  }
  
  int getMinHeight()
  {
    AppMethodBeat.i(193424);
    int i = Math.max(super.getMinHeight(), this.cjJ);
    AppMethodBeat.o(193424);
    return i;
  }
  
  public int getTabIndicatorColor()
  {
    return this.cjF;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(193453);
    super.onDraw(paramCanvas);
    int i = getHeight();
    int j = this.cjU.getLeft();
    int k = this.cjK;
    int m = this.cjU.getRight();
    int n = this.cjK;
    int i1 = this.cjG;
    this.cjL.setColor(this.cjM << 24 | this.cjF & 0xFFFFFF);
    paramCanvas.drawRect(j - k, i - i1, m + n, i, this.cjL);
    if (this.cjN)
    {
      this.cjL.setColor(0xFF000000 | this.cjF & 0xFFFFFF);
      paramCanvas.drawRect(getPaddingLeft(), i - this.cjP, getWidth() - getPaddingRight(), i, this.cjL);
    }
    AppMethodBeat.o(193453);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(193440);
    int i = paramMotionEvent.getAction();
    if ((i != 0) && (this.cjQ))
    {
      AppMethodBeat.o(193440);
      return false;
    }
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(193440);
      return true;
      this.mInitialMotionX = f1;
      this.mInitialMotionY = f2;
      this.cjQ = false;
      continue;
      if ((Math.abs(f1 - this.mInitialMotionX) > this.mTouchSlop) || (Math.abs(f2 - this.mInitialMotionY) > this.mTouchSlop))
      {
        this.cjQ = true;
        continue;
        if (f1 < this.cjU.getLeft() - this.cjK) {
          this.cjS.setCurrentItem(this.cjS.getCurrentItem() - 1);
        } else if (f1 > this.cjU.getRight() + this.cjK) {
          this.cjS.setCurrentItem(this.cjS.getCurrentItem() + 1);
        }
      }
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(193384);
    super.setBackgroundColor(paramInt);
    if (!this.cjO) {
      if ((0xFF000000 & paramInt) != 0) {
        break label39;
      }
    }
    label39:
    for (boolean bool = true;; bool = false)
    {
      this.cjN = bool;
      AppMethodBeat.o(193384);
      return;
    }
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(193371);
    super.setBackgroundDrawable(paramDrawable);
    if (!this.cjO) {
      if (paramDrawable != null) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.cjN = bool;
      AppMethodBeat.o(193371);
      return;
    }
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(193395);
    super.setBackgroundResource(paramInt);
    if (!this.cjO) {
      if (paramInt != 0) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.cjN = bool;
      AppMethodBeat.o(193395);
      return;
    }
  }
  
  public void setDrawFullUnderline(boolean paramBoolean)
  {
    AppMethodBeat.i(193406);
    this.cjN = paramBoolean;
    this.cjO = true;
    invalidate();
    AppMethodBeat.o(193406);
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(193352);
    int i = paramInt4;
    if (paramInt4 < this.cjH) {
      i = this.cjH;
    }
    super.setPadding(paramInt1, paramInt2, paramInt3, i);
    AppMethodBeat.o(193352);
  }
  
  public void setTabIndicatorColor(int paramInt)
  {
    AppMethodBeat.i(193324);
    this.cjF = paramInt;
    this.cjL.setColor(this.cjF);
    invalidate();
    AppMethodBeat.o(193324);
  }
  
  public void setTabIndicatorColorResource(int paramInt)
  {
    AppMethodBeat.i(193334);
    setTabIndicatorColor(a.w(getContext(), paramInt));
    AppMethodBeat.o(193334);
  }
  
  public void setTextSpacing(int paramInt)
  {
    AppMethodBeat.i(193363);
    int i = paramInt;
    if (paramInt < this.cjI) {
      i = this.cjI;
    }
    super.setTextSpacing(i);
    AppMethodBeat.o(193363);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.viewpager.widget.PagerTabStrip
 * JD-Core Version:    0.7.0.1
 */